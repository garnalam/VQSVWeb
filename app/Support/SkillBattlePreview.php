<?php

namespace App\Support;

use App\Models\Pet;
use App\Models\Skill;
use Illuminate\Database\Eloquent\Collection as EloquentCollection;
use Illuminate\Support\Collection;
use Illuminate\Support\Facades\File;

class SkillBattlePreview
{
    private const PREVIEW_LEVEL = 50;

    /** @var array<string, mixed>|null */
    private ?array $gameAssetManifest = null;

    public function __construct(private PetStatCalculator $petStatCalculator) {}

    /**
     * Build the deterministic Liệt Hỏa battle preview payload for a skill dossier.
     *
     * @param  Collection<int, array<string, mixed>>  $compatiblePets
     * @param  EloquentCollection<int, Pet>  $allPets
     * @return array<string, mixed>
     */
    public function build(
        Skill $skill,
        Collection $compatiblePets,
        EloquentCollection $allPets,
        ?int $statusChance,
    ): array {
        $casterOptions = $compatiblePets
            ->map(function (array $compatiblePet) use ($allPets): ?array {
                $pet = $allPets->get($compatiblePet['id']);

                if (! $pet instanceof Pet) {
                    return null;
                }

                return [
                    ...$this->combatantData($pet),
                    'unlock_level' => $compatiblePet['unlock_level'],
                    'is_inherited' => $compatiblePet['is_inherited'],
                ];
            })
            ->filter()
            ->values();
        $defaultCaster = $casterOptions->firstWhere('is_inherited', false) ?? $casterOptions->first();
        $casterPet = $defaultCaster === null ? null : $allPets->get($defaultCaster['id']);
        $opponent = $casterPet instanceof Pet
            ? $this->balancedOpponent($casterPet, $skill->combat_element, $allPets)
            : $allPets->first();
        $effectRule = $this->effectRule($skill, $statusChance);

        return [
            'ruleset' => 'liet-hoa-unified-v1',
            'ruleset_label' => 'Luật chiến đấu Liệt Hỏa',
            'level' => self::PREVIEW_LEVEL,
            'default_caster_id' => $defaultCaster['id'] ?? null,
            'caster_options' => $casterOptions,
            'opponent' => $opponent instanceof Pet ? $this->combatantData($opponent) : null,
            'effect_rule' => $effectRule,
            'source_animation' => $this->sourceAnimation($skill, $effectRule['target']),
            'damage' => [
                'formula' => 'max(1, (strength - defense) × power × element)',
                'element_multiplier' => 1.0,
                'variance' => 1.0,
            ],
        ];
    }

    /**
     * Resolve only animation events that can be traced to decoded game resources.
     *
     * @return array<string, mixed>
     */
    private function sourceAnimation(Skill $skill, string $effectTarget): array
    {
        if ($skill->gameSource->slug === 'cau-vong') {
            $manifest = $this->readManifest(
                public_path('assets/game/cau-vong/skill-animations/manifest.json'),
            );
            $animation = $manifest['animations'][(string) $skill->game_id] ?? null;

            if (! is_array($animation)) {
                return [
                    'provenance' => 'source_no_visual',
                    'label' => 'Source gốc không có VFX độc lập',
                    'events' => [],
                ];
            }

            return [
                'provenance' => 'decoded_original',
                'label' => 'Chuỗi Pet + VFX Skill gốc Cầu Vồng',
                'events' => [[
                    'index' => 0,
                    'kind' => 'sprite_animation',
                    'anchor' => $effectTarget,
                    'render_status' => 'decoded_original',
                    ...$animation,
                ]],
            ];
        }

        $manifest = $this->readManifest(
            public_path('assets/game/skill-animations/manifest.json'),
        );
        $animation = $manifest['skills'][(string) $skill->game_id] ?? null;

        if (! is_array($animation)) {
            return [
                'provenance' => 'unavailable',
                'label' => 'Chưa tìm thấy timeline animation gốc',
                'events' => [],
            ];
        }

        $events = collect($animation['events'] ?? [])->values()->all();
        $hasRenderedEvent = collect($events)->contains(
            fn (array $event): bool => ($event['render_status'] ?? null) === 'decoded_original',
        );

        return [
            'provenance' => $hasRenderedEvent ? 'decoded_original' : 'source_metadata_only',
            'label' => $hasRenderedEvent
                ? 'Timeline & VFX Skill gốc Liệt Hỏa'
                : 'Timeline gốc; VFX biến đổi Pet đang chờ renderer',
            'source_timeline' => $animation['source_timeline'] ?? [],
            'events' => $events,
        ];
    }

    /** @return array<string, mixed> */
    private function readManifest(string $path): array
    {
        if (! File::exists($path)) {
            return [];
        }

        return File::json($path);
    }

    /**
     * Select a similarly strong opponent so the preview remains readable and repeatable.
     *
     * @param  EloquentCollection<int, Pet>  $allPets
     */
    private function balancedOpponent(
        Pet $caster,
        ?string $skillElement,
        EloquentCollection $allPets,
    ): ?Pet {
        $casterStats = $this->calculatedStats($caster);
        $casterTotal = array_sum($casterStats);
        $neutralElement = $skillElement ?? $caster->combat_element;

        return $allPets
            ->filter(fn (Pet $pet): bool => $pet->id !== $caster->id)
            ->sortBy(function (Pet $pet) use ($caster, $casterTotal, $neutralElement): int {
                $sourcePenalty = $pet->game_source_id === $caster->game_source_id ? 0 : 2000;
                $qualityPenalty = $pet->quality_tier === $caster->quality_tier ? 0 : 500;
                $elementPenalty = $pet->combat_element === $neutralElement ? 0 : 1000;

                return abs(array_sum($this->calculatedStats($pet)) - $casterTotal)
                    + $sourcePenalty
                    + $qualityPenalty
                    + $elementPenalty;
            })
            ->first();
    }

    /** @return array<string, mixed> */
    private function combatantData(Pet $pet): array
    {
        return [
            'id' => $pet->id,
            'name' => $pet->name,
            'sprite_id' => $pet->sprite_id,
            'quality_tier' => $pet->quality_tier,
            'primary_role_label' => Pet::COMBAT_ROLES[$pet->primary_role],
            'game_source' => [
                'name' => $pet->gameSource->name,
                'slug' => $pet->gameSource->slug,
                'asset_key' => $pet->gameSource->asset_key,
                'color' => $pet->gameSource->color,
            ],
            'combat_element' => [
                'game_id' => Pet::COMBAT_ELEMENTS[$pet->combat_element]['game_id'],
                'name' => Pet::COMBAT_ELEMENTS[$pet->combat_element]['name'],
                'slug' => $pet->combat_element,
                'color' => Pet::COMBAT_ELEMENTS[$pet->combat_element]['color'],
            ],
            'stats' => $this->calculatedStats($pet),
            'effect_snapshots' => $this->effectSnapshots($pet),
        ];
    }

    /** @return array<string, array<string, int|string>> */
    private function effectSnapshots(Pet $pet): array
    {
        if ($pet->gameSource->slug !== 'liet-hoa') {
            return [];
        }

        $this->gameAssetManifest ??= $this->readManifest(
            public_path('assets/game/manifest.json'),
        );

        $snapshots = $this->gameAssetManifest['pet_effect_snapshots'][(string) $pet->sprite_id] ?? [];

        return is_array($snapshots) ? $snapshots : [];
    }

    /** @return array{hp: int, strength: int, defense: int, agility: int} */
    private function calculatedStats(Pet $pet): array
    {
        return $this->petStatCalculator->calculate($pet, self::PREVIEW_LEVEL);
    }

    /** @return array<string, mixed> */
    private function effectRule(Skill $skill, ?int $statusChance): array
    {
        if ($skill->balance_version === SkillBalance::VERSION) {
            return $this->balancedEffectRule($skill, $statusChance);
        }

        if ($skill->effect === null) {
            return $this->categoryRule($skill);
        }

        $rule = match ($skill->effect->source_table) {
            6 => $this->beneficialRule($skill),
            7 => $this->harmfulRule($skill),
            11 => $this->convertedRainbowRule($skill),
            default => $this->genericEffectRule($skill),
        };

        return [
            ...$rule,
            'effect_name' => $skill->effect->name,
            'tone' => $skill->effect->kind,
            'duration_turns' => $skill->effect->duration ?? $this->normalizedDuration($skill),
            'status_chance' => $statusChance,
            'target' => $skill->effect->kind === 'harmful' ? 'opponent' : 'caster',
        ];
    }

    /** @return array<string, mixed> */
    private function balancedEffectRule(Skill $skill, ?int $statusChance): array
    {
        $mechanics = SkillBalance::mechanics($skill->gameSource->slug, $skill->game_id);
        $status = $mechanics['status'] ?? null;
        $type = (string) $mechanics['type'];
        $key = match ($type) {
            'damage_reduction_chance' => 'patience',
            'heal_regeneration', 'cleanse_regeneration' => 'regeneration',
            'direct_heal' => 'direct_heal',
            default => $status ?? $type,
        };
        $followUp = match ($key) {
            'seeded_damage' => 'damage_tick',
            'corrosion' => 'escalating_damage',
            'entangled', 'defense_down' => 'defense_break',
            'accuracy_down' => 'accuracy_check',
            'agility_down', 'dazed', 'paralysis', 'bound' => 'action_delayed',
            'damage_down', 'charmed' => 'counter_weakened',
            'petrified', 'confusion' => 'action_blocked',
            'tier_lock' => 'tier_lock',
            'regeneration' => 'heal_tick',
            'direct_heal' => 'direct_heal',
            'patience' => 'counter_reduced',
            default => $type,
        };
        $value = (int) ($mechanics['value'] ?? $mechanics['heal'] ?? 0);
        $changes = match ($key) {
            'entangled' => [$this->change('defense', 'down', $value)],
            'accuracy_down' => [$this->change('accuracy', 'down', $value)],
            'agility_down', 'dazed', 'paralysis', 'bound' => [$this->change('agility', 'down', $value)],
            'damage_down', 'charmed' => [$this->change('damage', 'down', $value)],
            'defense_down' => [$this->change('defense', 'down', $value)],
            default => [],
        };
        $target = $skill->target_side === 1 || in_array($skill->target_pattern, ['self', 'self_or_ally', 'all_allies'], true)
            ? 'caster'
            : 'opponent';

        return [
            ...$this->rule(
                $key,
                $skill->effect?->name ?? Skill::COMBAT_CATEGORIES[$skill->combat_category],
                $mechanics['description'],
                $followUp,
                $value > 0 ? $value : null,
                isset($mechanics['secondary_value']) ? (int) $mechanics['secondary_value'] : null,
                in_array($type, ['direct_heal', 'heal_regeneration', 'cleanse_regeneration', 'corrosion_storm'], true) ? 'max_hp' : 'percent',
                $changes,
                $target,
                $skill->gameSource->slug === 'cau-vong' ? 'unified' : 'decoded',
            ),
            'effect_name' => $skill->effect?->name,
            'tone' => $skill->effect?->kind ?? 'neutral',
            'duration_turns' => $mechanics['duration'] ?? null,
            'status_chance' => $statusChance,
            'target' => $target,
        ];
    }

    /** @return array<string, mixed> */
    private function categoryRule(Skill $skill): array
    {
        $healPercent = match ($skill->game_id) {
            27 => 25,
            28 => 50,
            default => 0,
        };

        if ($skill->combat_category === 'heal') {
            return $this->rule(
                'direct_heal',
                'Hồi phục trực tiếp',
                "Hồi {$healPercent}% Sinh mệnh tối đa cho mục tiêu phe mình.",
                'direct_heal',
                $healPercent,
                basis: 'max_hp',
                target: 'caster',
            );
        }

        return $this->rule(
            'direct_action',
            'Tác động trực tiếp',
            $skill->power_percent > 0
                ? 'Skill chỉ xử lý sát thương trực tiếp theo công thức Liệt Hỏa.'
                : 'Skill không tạo Buff hoặc Debuff kéo dài.',
            'none',
            target: $skill->target_side === 1 ? 'caster' : 'opponent',
        );
    }

    /** @return array<string, mixed> */
    private function beneficialRule(Skill $skill): array
    {
        $parameter = max(0, (int) $skill->effect_parameter);

        return match ($skill->effect->game_id) {
            0 => $this->rule('charge', 'Súc lực công thủ', 'Phòng ngự tăng 30%; đòn kế tiếp đạt 190% uy lực cơ sở.', 'attack_boost', 90, changes: [$this->change('defense', 'up', 30)]),
            1 => $this->rule('last_stand', 'Đổi thủ lấy công', 'Sức mạnh tăng 50% nhưng Phòng ngự giảm 50% trong thời gian hiệu lực.', 'counter_amplified', 50, changes: [$this->change('strength', 'up', 50), $this->change('defense', 'down', 50)]),
            2 => $this->rule('thorns', 'Giáp gai phản kích', 'Phòng ngự tăng 30% và phản lại 10% sát thương khi trúng đòn.', 'counter_reflect', 10, changes: [$this->change('defense', 'up', 30)]),
            3 => $this->rule('regeneration', 'Khôi phục theo lượt', 'Cuối mỗi hiệp hồi 5% Sinh mệnh tối đa.', 'heal_tick', 5, basis: 'max_hp'),
            4 => $this->rule('defense_up', 'Gia cố phòng ngự', "Phòng ngự tăng {$parameter}% trong thời gian hiệu lực.", 'counter_reduced', $parameter, changes: [$this->change('defense', 'up', $parameter)]),
            5 => $this->rule('mirror_guard', 'Phản xạ công kích', 'Mỗi đòn nhận vào có 30% xác suất dội ngược toàn bộ sát thương.', 'reflection_chance', 30),
            6 => $this->rule('patience', 'Giảm nửa sát thương', 'Sát thương của đòn công kích trúng mục tiêu giảm 50%.', 'counter_reduced', 50),
            7 => $this->rule('agility_up', 'Gia tăng Linh xảo', "Linh xảo tăng {$parameter}% trong thời gian hiệu lực.", 'turn_priority', $parameter, changes: [$this->change('agility', 'up', $parameter)]),
            8 => $this->rule('voltage', 'Quá tải kỹ năng', 'Đòn đánh tăng 30% sát thương nhưng tiêu hao PP gấp đôi.', 'attack_boost', 30, changes: [$this->change('pp_cost', 'up', 100)]),
            9 => $this->rule('fire_stone', 'Đánh đổi tốc độ', 'Linh xảo tăng 50% nhưng Phòng ngự giảm 50%.', 'counter_amplified', 50, changes: [$this->change('agility', 'up', 50), $this->change('defense', 'down', 50)]),
            10 => $this->rule('strength_up', 'Gia tăng Sức mạnh', "Sức mạnh tăng {$parameter}% trong thời gian hiệu lực.", 'attack_boost', $parameter, changes: [$this->change('strength', 'up', $parameter)]),
            11 => $this->rule('buff_steal', 'Thâu thủ trạng thái', 'Chuyển trạng thái có lợi của đối thủ sang Pet thi triển.', 'buff_transfer'),
            12 => $this->rule('double_action', 'Hành động hai lần', 'Lặp lại Skill vừa dùng thêm một lần mà không tốn PP.', 'double_action'),
            13 => $this->rule('cleanse_regeneration', 'Thanh tẩy và tái sinh', 'Xóa trạng thái bất lợi rồi hồi 5% Sinh mệnh tối đa mỗi hiệp.', 'heal_tick', 5, basis: 'max_hp'),
            14 => $this->rule('status_immunity', 'Miễn dịch trạng thái', 'Xóa trạng thái bất lợi và chặn trạng thái mới trong 3 hiệp.', 'status_immunity'),
            default => $this->genericEffectRule($skill),
        };
    }

    /** @return array<string, mixed> */
    private function harmfulRule(Skill $skill): array
    {
        $parameter = max(0, (int) $skill->effect_parameter);

        return match ($skill->effect->game_id) {
            0 => $this->rule('seeded_damage', 'Gieo hạt sát thương', "Mỗi hiệp mất {$parameter} Sinh mệnh trong 3 hiệp.", 'damage_tick', $parameter, basis: 'points', target: 'opponent'),
            1 => $this->rule('dazed', 'Mê muội', 'Làm chậm nhịp hành động và đẩy lượt phản công về sau.', 'action_delayed', target: 'opponent'),
            2 => $this->rule('entangled', 'Quấn quanh', 'Không thể đổi Pet, chạy trốn hoặc sử dụng đạo cụ; Phòng ngự giảm 10% trong đấu đơn.', 'defense_break', 10, changes: [$this->change('defense', 'down', 10)], target: 'opponent'),
            3 => $this->rule('delayed_burst', 'Thực loại', "Sau 3 hiệp nhận thêm {$parameter} sát thương; hiệu ứng mất nếu mục tiêu bị hạ trước đó.", 'delayed_damage', $parameter, basis: 'points', target: 'opponent'),
            4 => $this->rule('accuracy_down', 'Suy giảm chính xác', "Tỷ lệ đánh trúng giảm {$parameter}%.", 'accuracy_check', $parameter, changes: [$this->change('accuracy', 'down', $parameter)], target: 'opponent'),
            5 => $this->rule('agility_down', 'Chậm chạp', "Linh xảo giảm {$parameter}%.", 'action_delayed', $parameter, changes: [$this->change('agility', 'down', $parameter)], target: 'opponent'),
            6 => $this->rule('damage_down', 'Nhụt chí', "Sát thương gây ra giảm {$parameter}%.", 'counter_weakened', $parameter, changes: [$this->change('damage', 'down', $parameter)], target: 'opponent'),
            7 => $this->rule('defense_down', 'Phá phòng ngự', "Phòng ngự giảm {$parameter}%.", 'defense_break', $parameter, changes: [$this->change('defense', 'down', $parameter)], target: 'opponent'),
            8 => $this->rule('ghost_mirror', 'Quỷ mị phản phệ', "Đòn phản công có {$parameter}% xác suất dội ngược vào chính người đánh.", 'self_hit_chance', $parameter, target: 'opponent'),
            9 => $this->rule('confusion', 'Hỗn loạn', 'Mục tiêu mất quyền điều khiển trong lượt kế tiếp.', 'action_blocked', target: 'opponent'),
            10 => $this->rule('paralysis', 'Tê liệt', 'Nhịp hành động bị kéo dài, mục tiêu phản công muộn hơn.', 'action_delayed', target: 'opponent'),
            default => $this->genericEffectRule($skill),
        };
    }

    /** @return array<string, mixed> */
    private function convertedRainbowRule(Skill $skill): array
    {
        return match ($skill->effect->game_id) {
            0 => $this->rule('petrified', 'Thạch hóa', 'Không thể hành động; sát thương nhận vào giảm 30%.', 'action_blocked', 30, changes: [$this->change('damage_received', 'down', 30)], target: 'opponent', provenance: 'unified'),
            1 => $this->rule('burning', 'Thiêu đốt', 'Mỗi hiệp mất 8% Sinh mệnh tối đa.', 'damage_tick', 8, basis: 'max_hp', target: 'opponent', provenance: 'unified'),
            2 => $this->rule('rainbow_paralysis', 'Tê liệt quy đổi', 'Mỗi hiệp mất 10% Sinh mệnh hiện tại theo luật trạng thái đã quy đổi.', 'damage_tick', 10, basis: 'current_hp', target: 'opponent', provenance: 'unified'),
            3 => $this->rule('charmed', 'Mị hoặc', 'Không thể chạy trốn, khả năng bị thu phục tăng và sát thương gây ra giảm 10%.', 'counter_weakened', 10, changes: [$this->change('damage', 'down', 10)], target: 'opponent', provenance: 'unified'),
            4 => $this->rule('bound', 'Giam cầm', 'Không thể đổi Pet, chạy trốn hoặc sử dụng đạo cụ; Linh xảo giảm 15%.', 'action_delayed', 15, changes: [$this->change('agility', 'down', 15)], target: 'opponent', provenance: 'unified'),
            5 => $this->rule('corrosion', 'Hủ thực', 'Sát thương theo lượt tăng dần: 4%, 8%, rồi 12% Sinh mệnh tối đa.', 'escalating_damage', 4, secondaryValue: 4, basis: 'max_hp', target: 'opponent', provenance: 'unified'),
            6 => $this->rule('tier_lock', 'Phong bế kỹ năng', 'Mục tiêu không thể dùng Skill tier 2–3 trong 2 hiệp.', 'tier_lock', 1, target: 'opponent', provenance: 'unified'),
            default => $this->genericEffectRule($skill),
        };
    }

    /** @return array<string, mixed> */
    private function genericEffectRule(Skill $skill): array
    {
        return $this->rule(
            'generic_status',
            $skill->effect?->name ?? 'Trạng thái',
            $skill->effect?->description ?: 'Áp dụng trạng thái theo mô tả Skill.',
            'status_only',
            target: $skill->effect?->kind === 'harmful' ? 'opponent' : 'caster',
        );
    }

    /**
     * Assign Liệt Hỏa turn durations to converted Rainbow statuses that had no source duration.
     */
    private function normalizedDuration(Skill $skill): ?int
    {
        if ($skill->effect?->source_table !== 11) {
            return null;
        }

        return match ($skill->effect->game_id) {
            0, 6 => 2,
            1, 2, 3, 4, 5 => 3,
            default => null,
        };
    }

    /**
     * @param  list<array<string, int|string>>  $changes
     * @return array<string, mixed>
     */
    private function rule(
        string $key,
        string $title,
        string $summary,
        string $followUp,
        ?int $value = null,
        ?int $secondaryValue = null,
        string $basis = 'percent',
        array $changes = [],
        string $target = 'caster',
        string $provenance = 'decoded',
    ): array {
        return [
            'key' => $key,
            'title' => $title,
            'summary' => $summary,
            'target' => $target,
            'tone' => 'neutral',
            'duration_turns' => null,
            'status_chance' => null,
            'stat_changes' => $changes,
            'follow_up' => [
                'kind' => $followUp,
                'value' => $value,
                'secondary_value' => $secondaryValue,
                'basis' => $basis,
            ],
            'provenance' => $provenance,
        ];
    }

    /** @return array{stat: string, direction: string, value: int, unit: string} */
    private function change(string $stat, string $direction, int $value): array
    {
        return [
            'stat' => $stat,
            'direction' => $direction,
            'value' => $value,
            'unit' => 'percent',
        ];
    }
}
