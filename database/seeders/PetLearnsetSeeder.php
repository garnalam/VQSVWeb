<?php

namespace Database\Seeders;

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetSkillLearnset;
use App\Models\Skill;
use Illuminate\Database\Seeder;
use Illuminate\Support\Collection;
use Illuminate\Support\Facades\DB;
use RuntimeException;

class PetLearnsetSeeder extends Seeder
{
    private const BALANCE_VERSION = 'unified-v1';

    /** @var array<int, int> */
    private const QUALITY_MULTIPLIERS = [1 => 90, 2 => 95, 3 => 100, 4 => 110, 5 => 125];

    /** @var array<int, string> */
    private const ELEMENT_BY_GAME_ID = [
        0 => 'hoa',
        1 => 'moc',
        2 => 'tho',
        3 => 'thuy',
        4 => 'dien',
        5 => 'quy',
        6 => 'phong',
    ];

    /** @var array<string, list<string>> */
    private const ROLE_CATEGORY_PRIORITY = [
        'striker' => ['damage', 'hybrid', 'buff', 'disrupt', 'control', 'defense', 'heal', 'capture'],
        'bruiser' => ['hybrid', 'damage', 'defense', 'buff', 'control', 'heal', 'disrupt', 'capture'],
        'guardian' => ['defense', 'heal', 'control', 'hybrid', 'buff', 'disrupt', 'damage', 'capture'],
        'controller' => ['control', 'disrupt', 'hybrid', 'buff', 'defense', 'damage', 'heal', 'capture'],
        'support' => ['heal', 'defense', 'buff', 'disrupt', 'control', 'hybrid', 'damage', 'capture'],
        'versatile' => ['hybrid', 'damage', 'control', 'buff', 'defense', 'disrupt', 'heal', 'capture'],
    ];

    /** @var array<string, array{hp: float, strength: float, defense: float, agility: float}> */
    private const ROLE_PROFILES = [
        'striker' => ['hp' => 0.90, 'strength' => 1.20, 'defense' => 0.84, 'agility' => 1.18],
        'bruiser' => ['hp' => 1.05, 'strength' => 1.12, 'defense' => 1.05, 'agility' => 0.90],
        'guardian' => ['hp' => 1.18, 'strength' => 0.82, 'defense' => 1.22, 'agility' => 0.78],
        'controller' => ['hp' => 0.90, 'strength' => 0.86, 'defense' => 0.90, 'agility' => 1.26],
        'support' => ['hp' => 1.08, 'strength' => 0.78, 'defense' => 1.08, 'agility' => 1.08],
        'versatile' => ['hp' => 1.00, 'strength' => 1.00, 'defense' => 1.00, 'agility' => 1.00],
    ];

    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::transaction(function (): void {
            $this->normalizeSkills();

            $pets = Pet::query()
                ->select([
                    'id',
                    'game_source_id',
                    'game_id',
                    'name',
                    'combat_element',
                    'species',
                    'quality_tier',
                    'hp_base',
                    'hp_per_level',
                    'hp_offset',
                    'stat_2_base',
                    'stat_2_per_level',
                    'stat_2_offset',
                    'stat_3_base',
                    'stat_3_per_10_levels',
                    'stat_3_offset',
                    'stat_4_base',
                    'stat_4_per_10_levels',
                    'stat_4_offset',
                ])
                ->with('gameSource:id,slug')
                ->orderBy('game_source_id')
                ->orderBy('game_id')
                ->get();

            if ($pets->count() !== 202) {
                throw new RuntimeException('The unified learnset requires all 202 pets to be seeded first.');
            }

            $this->assignCombatRoles($pets);
            $this->seedLearnsets($pets);
        });
    }

    private function normalizeSkills(): void
    {
        $sources = GameSource::query()->whereIn('slug', ['liet-hoa', 'cau-vong'])->get()->keyBy('slug');
        $lietHoa = $sources->get('liet-hoa');
        $rainbow = $sources->get('cau-vong');

        if ($lietHoa === null || $rainbow === null) {
            throw new RuntimeException('Both game sources must exist before normalizing skills.');
        }

        $this->normalizeLietHoaSkills($lietHoa);
        $this->normalizeRainbowSkills($rainbow);
    }

    private function normalizeLietHoaSkills(GameSource $gameSource): void
    {
        $selfOrAlly = [4, 14, 15, 25, 34, 35];
        $allAllies = [24];
        $selfOnly = [5, 44, 45, 65];
        $offensiveTeamBuffs = [21, 27, 42, 48, 62, 68];
        $healSkills = [15, 24];
        $defenseSkills = [14, 25, 34, 35];
        $controlSkills = [2, 8, 12, 18, 22, 28, 41, 47, 54, 55];

        Skill::query()
            ->whereBelongsTo($gameSource)
            ->with('element:id,game_id')
            ->orderBy('game_id')
            ->get()
            ->each(function (Skill $skill) use (
                $selfOrAlly,
                $allAllies,
                $selfOnly,
                $offensiveTeamBuffs,
                $healSkills,
                $defenseSkills,
                $controlSkills,
            ): void {
                $category = match (true) {
                    in_array($skill->game_id, $healSkills, true) => 'heal',
                    in_array($skill->game_id, $defenseSkills, true) => 'defense',
                    in_array($skill->game_id, $controlSkills, true) => 'control',
                    $skill->power_percent === 0 && $skill->effect_mode === 2 => 'disrupt',
                    $skill->power_percent === 0 && $skill->effect_mode === 1 => 'buff',
                    $skill->effect_mode !== 0 => 'hybrid',
                    default => 'damage',
                };
                $targetPattern = match (true) {
                    in_array($skill->game_id, $selfOrAlly, true) => 'self_or_ally',
                    in_array($skill->game_id, $allAllies, true) => 'all_allies',
                    in_array($skill->game_id, $selfOnly, true) => 'self',
                    default => 'single_enemy',
                };
                $effectTargetPattern = in_array($skill->game_id, $offensiveTeamBuffs, true)
                    ? 'all_allies'
                    : $targetPattern;

                $skill->update([
                    'combat_element' => self::ELEMENT_BY_GAME_ID[$skill->element->game_id],
                    'species_affinity' => null,
                    'combat_category' => $category,
                    'target_pattern' => $targetPattern,
                    'effect_target_pattern' => $effectTargetPattern,
                    'battle_format' => $skill->game_id === 24 ? 'double' : 'any',
                    'role_tags' => $this->roleTags($category),
                    'balance_version' => self::BALANCE_VERSION,
                    'is_active' => true,
                ]);
            });
    }

    private function normalizeRainbowSkills(GameSource $gameSource): void
    {
        $speciesGroups = [
            0 => ['species' => 'thuc-vat', 'element' => 'moc', 'powers' => [70, 80, 105, 130, 160]],
            1 => ['species' => 'kim-loai', 'element' => 'tho', 'powers' => [60, 70, 90, 110, 140]],
            2 => ['species' => 'phi-hanh', 'element' => 'phong', 'powers' => [85, 95, 120, 145, 175]],
            3 => ['species' => 'manh-thu', 'element' => 'hoa', 'powers' => [70, 80, 105, 130, 160]],
            4 => ['species' => 'hai-duong', 'element' => 'thuy', 'powers' => [90, 100, 130, 155, 190]],
        ];
        $ppByRank = [45, 40, 30, 25, 15];
        $tierByRank = [0, 0, 1, 2, 3];

        Skill::query()
            ->whereBelongsTo($gameSource)
            ->with('effect:id,name')
            ->orderBy('game_id')
            ->get()
            ->each(function (Skill $skill) use ($speciesGroups, $ppByRank, $tierByRank): void {
                if ($skill->game_id <= 24) {
                    $group = $speciesGroups[intdiv($skill->game_id, 5)];
                    $rank = $skill->game_id % 5;
                    $speciesName = Pet::SPECIES[$group['species']]['name'];
                    $elementName = Pet::COMBAT_ELEMENTS[$group['element']]['name'];
                    $effectDescription = $skill->effect === null || $skill->status_chance <= 0
                        ? ''
                        : " Có {$skill->status_chance}% xác suất gây {$skill->effect->name}.";
                    $skill->update([
                        'combat_element' => $group['element'],
                        'species_affinity' => $group['species'],
                        'combat_category' => 'hybrid',
                        'target_pattern' => 'single_enemy',
                        'effect_target_pattern' => 'single_enemy',
                        'battle_format' => 'any',
                        'role_tags' => $this->roleTags('hybrid'),
                        'balance_version' => self::BALANCE_VERSION,
                        'is_active' => true,
                        'power_percent' => $group['powers'][$rank],
                        'description' => "Kỹ thuật chủng {$speciesName} được chuẩn hóa về hệ {$elementName}, gây {$group['powers'][$rank]}% uy lực.{$effectDescription}",
                        'energy_cost' => null,
                        'tier' => $tierByRank[$rank],
                        'max_uses' => $ppByRank[$rank],
                        'target_side' => 0,
                    ]);

                    return;
                }

                $skill->update([
                    ...$this->rainbowSpecialSkill($skill->game_id),
                    'energy_cost' => null,
                    'balance_version' => self::BALANCE_VERSION,
                ]);
            });
    }

    /** @return array<string, mixed> */
    private function rainbowSpecialSkill(int $gameId): array
    {
        if ($gameId >= 31) {
            return [
                'combat_element' => null,
                'species_affinity' => null,
                'combat_category' => 'passive',
                'target_pattern' => 'self',
                'effect_target_pattern' => 'self',
                'battle_format' => 'any',
                'role_tags' => [],
                'is_active' => false,
                'power_percent' => 0,
                'tier' => 0,
                'max_uses' => 0,
                'target_side' => 1,
            ];
        }

        return match ($gameId) {
            25 => [
                ...$this->rainbowSpecialAttributes(null, 'fallback', 'single_enemy', 'any', ['striker', 'bruiser'], 60, 0, 0, 0),
                'is_active' => false,
            ],
            26 => [
                ...$this->rainbowSpecialAttributes('quy', 'capture', 'single_enemy', 'single', ['controller'], 80, 1, 10, 0),
                'is_active' => false,
                'description' => 'Gây sát thương và giảm 25% kháng bắt của Pet hoang trong 3 hiệp; không có hiệu lực PvP.',
            ],
            27 => [
                ...$this->rainbowSpecialAttributes('moc', 'heal', 'self_or_ally', 'double', ['support', 'guardian'], 0, 0, 20, 1),
                'description' => 'Hồi 25% Sinh mệnh tối đa cho bản thân hoặc một đồng đội.',
            ],
            28 => [
                ...$this->rainbowSpecialAttributes('moc', 'heal', 'self_or_ally', 'double', ['support'], 0, 2, 10, 1),
                'description' => 'Hồi 50% Sinh mệnh tối đa cho bản thân hoặc một đồng đội.',
            ],
            29 => [
                ...$this->rainbowSpecialAttributes('quy', 'damage', 'single_enemy', 'any', ['striker'], 250, 3, 1, 0),
                'description' => 'Tuyệt kỹ dùng một lần mỗi trận; sau khi thi triển, PP hiện tại của năm Skill đang mang trở về 0.',
            ],
            30 => [
                ...$this->rainbowSpecialAttributes('quy', 'control', 'single_enemy', 'any', ['controller', 'support'], 0, 2, 5, 0),
                'status_chance' => 70,
                'description' => 'Có 70% xác suất Phong Bế Skill tier 2–3 của một đối thủ trong 2 hiệp.',
            ],
            default => throw new RuntimeException("Missing Rainbow skill conversion for {$gameId}."),
        };
    }

    /**
     * @param  list<string>  $roleTags
     * @return array<string, mixed>
     */
    private function rainbowSpecialAttributes(
        ?string $combatElement,
        string $category,
        string $targetPattern,
        string $battleFormat,
        array $roleTags,
        int $power,
        int $tier,
        int $pp,
        int $targetSide,
    ): array {
        return [
            'combat_element' => $combatElement,
            'species_affinity' => null,
            'combat_category' => $category,
            'target_pattern' => $targetPattern,
            'effect_target_pattern' => $targetPattern,
            'battle_format' => $battleFormat,
            'role_tags' => $roleTags,
            'is_active' => true,
            'power_percent' => $power,
            'tier' => $tier,
            'max_uses' => $pp,
            'target_side' => $targetSide,
        ];
    }

    /** @return list<string> */
    private function roleTags(string $category): array
    {
        return match ($category) {
            'damage' => ['striker', 'bruiser'],
            'hybrid' => ['bruiser', 'controller'],
            'buff' => ['striker', 'support'],
            'heal' => ['support', 'guardian'],
            'defense' => ['guardian', 'support'],
            'control', 'disrupt' => ['controller', 'support'],
            'capture' => ['controller'],
            default => ['versatile'],
        };
    }

    /** @param  Collection<int, Pet>  $pets */
    private function assignCombatRoles(Collection $pets): void
    {
        $statsByPet = $pets->mapWithKeys(fn (Pet $pet): array => [$pet->id => $this->levelFiftyStats($pet)]);
        $tierMedians = $pets
            ->groupBy('quality_tier')
            ->map(function (Collection $tierPets) use ($statsByPet): array {
                $medians = [];
                foreach (['hp', 'strength', 'defense', 'agility'] as $stat) {
                    $medians[$stat] = $this->median(
                        $tierPets->map(fn (Pet $pet): int => $statsByPet[$pet->id][$stat])->all(),
                    );
                }

                return $medians;
            });

        foreach ($pets as $pet) {
            $medians = $tierMedians[$pet->quality_tier];
            $ratios = [];
            foreach (['hp', 'strength', 'defense', 'agility'] as $stat) {
                $ratios[$stat] = $statsByPet[$pet->id][$stat] / max(1, $medians[$stat]);
            }

            $rankedRoles = collect(self::ROLE_PROFILES)
                ->map(function (array $profile, string $role) use ($ratios, $pet): float {
                    $distance = 0.0;
                    foreach ($profile as $stat => $target) {
                        $distance += ($ratios[$stat] - $target) ** 2;
                    }

                    return $distance + $this->speciesRoleBias($pet->species, $role);
                })
                ->sort()
                ->keys()
                ->values();
            $primaryRole = (string) $rankedRoles[0];
            $secondaryRole = (string) $rankedRoles[1];

            $pet->update([
                'primary_role' => $primaryRole,
                'secondary_role' => $secondaryRole,
                'preferred_battle_format' => $primaryRole === 'support' ? 'double' : 'any',
                'playstyle_summary' => $this->playstyleSummary($pet, $primaryRole, $secondaryRole),
            ]);
        }
    }

    /** @return array{hp: int, strength: int, defense: int, agility: int} */
    private function levelFiftyStats(Pet $pet): array
    {
        $multiplier = self::QUALITY_MULTIPLIERS[$pet->quality_tier];

        return [
            'hp' => (int) (($pet->hp_base + $pet->hp_per_level * 50 + $pet->hp_offset) * $multiplier / 100),
            'strength' => (int) (($pet->stat_2_base + $pet->stat_2_per_level * 50 + $pet->stat_2_offset) * $multiplier / 100),
            'defense' => (int) (($pet->stat_3_base + $pet->stat_3_per_10_levels * 5 + $pet->stat_3_offset) * $multiplier / 100),
            'agility' => (int) (($pet->stat_4_base + $pet->stat_4_per_10_levels * 5 + $pet->stat_4_offset) * $multiplier / 100),
        ];
    }

    private function speciesRoleBias(string $species, string $role): float
    {
        return match ($species) {
            'thuc-vat' => match ($role) {
                'support' => -0.10,
                'guardian' => -0.04,
                default => 0.0,
            },
            'kim-loai' => match ($role) {
                'guardian' => -0.12,
                'bruiser' => -0.04,
                default => 0.0,
            },
            'phi-hanh' => match ($role) {
                'controller' => -0.10,
                'striker' => -0.04,
                default => 0.0,
            },
            'manh-thu' => in_array($role, ['striker', 'bruiser'], true) ? -0.08 : 0.0,
            'hai-duong' => match ($role) {
                'support' => -0.08,
                'controller' => -0.05,
                default => 0.0,
            },
            default => 0.0,
        };
    }

    private function playstyleSummary(Pet $pet, string $primaryRole, string $secondaryRole): string
    {
        $primary = Pet::COMBAT_ROLES[$primaryRole];
        $secondary = Pet::COMBAT_ROLES[$secondaryRole];
        $element = Pet::COMBAT_ELEMENTS[$pet->combat_element]['name'];
        $species = Pet::SPECIES[$pet->species]['name'];

        return "{$primary} thiên {$secondary}; kết hợp Skill hệ {$element} với kỹ thuật chủng {$species}.";
    }

    /** @param  Collection<int, Pet>  $pets */
    private function seedLearnsets(Collection $pets): void
    {
        $evolutions = PetEvolution::query()->select(['from_pet_id', 'to_pet_id'])->orderBy('id')->get();
        $incoming = $evolutions->groupBy('to_pet_id')->map->pluck('from_pet_id')->all();
        $outgoing = $evolutions->groupBy('from_pet_id')->map->pluck('to_pet_id')->all();
        $familyMetadata = $this->familyMetadata($pets, $incoming);
        $skills = Skill::query()
            ->select([
                'id',
                'game_source_id',
                'game_id',
                'name',
                'combat_element',
                'species_affinity',
                'combat_category',
                'tier',
                'role_tags',
                'is_active',
            ])
            ->with('gameSource:id,slug')
            ->where('is_active', true)
            ->whereNotIn('combat_category', ['fallback', 'passive'])
            ->get();

        PetSkillLearnset::query()->delete();

        $accessibleSkillIds = [];
        $siblingGrantSkillIds = [];
        $directGrantCounts = array_fill_keys($skills->pluck('id')->all(), 0);
        $exclusiveSkillFamilies = [];
        $rows = [];
        $orderedPets = $pets->sortBy(fn (Pet $pet): array => [
            $familyMetadata[$pet->id]['stage'],
            $pet->game_source_id,
            $pet->game_id,
        ]);

        foreach ($orderedPets as $pet) {
            $metadata = $familyMetadata[$pet->id];
            $parentIds = $incoming[$pet->id] ?? collect();
            $inheritedSkillIds = collect($parentIds)
                ->flatMap(fn (int $parentId): array => $accessibleSkillIds[$parentId] ?? [])
                ->unique()
                ->values();
            $targetCount = $this->targetLearnsetCount(
                $metadata['stage'],
                $metadata['maximum_depth'],
                ! isset($outgoing[$pet->id]),
            );
            $selectedSkillIds = $inheritedSkillIds->all();
            $grantRows = [];
            $reservedSiblingSkillIds = collect($parentIds)
                ->flatMap(fn (int $parentId): array => $siblingGrantSkillIds[$parentId] ?? [])
                ->unique()
                ->values()
                ->all();
            $candidates = $this->candidateSkills($pet, $skills)
                ->reject(fn (Skill $skill): bool => in_array($skill->id, $selectedSkillIds, true)
                    || in_array($skill->id, $reservedSiblingSkillIds, true)
                    || (isset($exclusiveSkillFamilies[$skill->id])
                        && $exclusiveSkillFamilies[$skill->id] !== $metadata['root_id']));

            while (count($selectedSkillIds) < $targetCount && $candidates->isNotEmpty()) {
                $desiredTier = $this->desiredTierForSlot(count($selectedSkillIds));
                $selected = $candidates
                    ->sortBy(fn (Skill $skill): array => $this->candidateScore(
                        $skill,
                        $pet,
                        $desiredTier,
                        $grantRows,
                        $directGrantCounts,
                    ))
                    ->first();

                if ($selected === null) {
                    break;
                }

                $selectedSkillIds[] = $selected->id;
                $directGrantCounts[$selected->id]++;
                $grantRows[] = [
                    'pet_id' => $pet->id,
                    'skill_id' => $selected->id,
                    'unlock_level' => $this->unlockLevel($selected),
                    'source_type' => $this->sourceType($selected),
                    'combat_role' => $selected->combat_category,
                    'is_signature' => false,
                    'sort_order' => count($selectedSkillIds),
                    'created_at' => now(),
                    'updated_at' => now(),
                ];
                $candidates = $candidates->reject(fn (Skill $skill): bool => $skill->is($selected));
            }

            if (
                $exclusiveSkillFamilies === []
                && (! isset($outgoing[$pet->id]) || $metadata['maximum_depth'] === 0)
                && $grantRows !== []
            ) {
                $signatureRowIndex = collect(array_keys($grantRows))
                    ->reverse()
                    ->first(fn (int $index): bool => $directGrantCounts[$grantRows[$index]['skill_id']] === 1);

                if ($signatureRowIndex !== null) {
                    $grantRows[$signatureRowIndex]['is_signature'] = true;
                    $exclusiveSkillFamilies[$grantRows[$signatureRowIndex]['skill_id']] = $metadata['root_id'];
                }
            }

            $rows = [...$rows, ...$grantRows];
            $accessibleSkillIds[$pet->id] = array_values(array_unique($selectedSkillIds));

            foreach ($parentIds as $parentId) {
                $siblingGrantSkillIds[$parentId] = array_values(array_unique([
                    ...($siblingGrantSkillIds[$parentId] ?? []),
                    ...array_column($grantRows, 'skill_id'),
                ]));
            }
        }

        PetSkillLearnset::query()->insert($rows);
        $this->normalizeSignatureAssignments($familyMetadata);
        $this->validateLearnsetCoverage($skills);
    }

    /**
     * Keep the exclusive signature flag only when every direct grant belongs to one evolution family.
     *
     * @param  array<int, array{root_id: int, stage: int, maximum_depth: int}>  $familyMetadata
     */
    private function normalizeSignatureAssignments(array $familyMetadata): void
    {
        $entriesBySkill = PetSkillLearnset::query()
            ->select(['id', 'pet_id', 'skill_id', 'is_signature'])
            ->orderBy('skill_id')
            ->get()
            ->groupBy('skill_id');

        foreach ($entriesBySkill as $entries) {
            $isExclusiveSignature = $entries->every('is_signature', true)
                && $entries
                    ->map(fn (PetSkillLearnset $entry): int => $familyMetadata[$entry->pet_id]['root_id'])
                    ->unique()
                    ->count() === 1;

            if (! $isExclusiveSignature) {
                PetSkillLearnset::query()
                    ->whereIn('id', $entries->pluck('id'))
                    ->update(['is_signature' => false]);
            }
        }

        if (! PetSkillLearnset::query()->where('is_signature', true)->exists()) {
            throw new RuntimeException('The unified learnset must preserve at least one exclusive signature skill.');
        }
    }

    /** @param  Collection<int, Skill>  $skills */
    private function validateLearnsetCoverage(Collection $skills): void
    {
        $coveredSkillIds = PetSkillLearnset::query()->distinct()->pluck('skill_id');
        $uncoveredSkills = $skills->whereNotIn('id', $coveredSkillIds);

        if ($uncoveredSkills->isNotEmpty()) {
            $skillNames = $uncoveredSkills->pluck('name')->implode(', ');

            throw new RuntimeException("Active combat skills without a learnset: {$skillNames}.");
        }
    }

    /**
     * @param  Collection<int, Pet>  $pets
     * @param  array<int, Collection<int, int>>  $incoming
     * @return array<int, array{root_id: int, stage: int, maximum_depth: int}>
     */
    private function familyMetadata(Collection $pets, array $incoming): array
    {
        $metadata = [];
        foreach ($pets as $pet) {
            $currentId = (int) $pet->id;
            $stage = 0;
            $visited = [];

            while (isset($incoming[$currentId]) && ! isset($visited[$currentId])) {
                $visited[$currentId] = true;
                $currentId = (int) $incoming[$currentId]->first();
                $stage++;
            }

            $metadata[$pet->id] = ['root_id' => $currentId, 'stage' => $stage];
        }

        $maximumDepths = collect($metadata)
            ->groupBy('root_id')
            ->map(fn (Collection $family): int => (int) $family->max('stage'));

        return collect($metadata)
            ->map(fn (array $item): array => [
                ...$item,
                'maximum_depth' => $maximumDepths[$item['root_id']],
            ])
            ->all();
    }

    private function targetLearnsetCount(int $stage, int $maximumDepth, bool $isLeaf): int
    {
        if ($maximumDepth === 0 || $isLeaf) {
            return 10;
        }

        if ($stage === 0) {
            return $maximumDepth === 1 ? 6 : 4;
        }

        return min(9, 4 + (int) round(6 * $stage / $maximumDepth));
    }

    /**
     * @param  Collection<int, Skill>  $skills
     * @return Collection<int, Skill>
     */
    private function candidateSkills(Pet $pet, Collection $skills): Collection
    {
        $roleSpecialGameIds = $this->roleSpecialGameIds($pet);

        return $skills->filter(function (Skill $skill) use ($pet, $roleSpecialGameIds): bool {
            $matchesElement = $skill->species_affinity === null
                && $skill->combat_element === $pet->combat_element
                && ! $this->isRestrictedRainbowSpecial($skill, $pet);
            $matchesSpecies = $skill->species_affinity === $pet->species;
            $isRoleSpecial = $this->isRainbowSpecial($skill, $roleSpecialGameIds);

            return $matchesElement || $matchesSpecies || $isRoleSpecial;
        });
    }

    private function isRestrictedRainbowSpecial(Skill $skill, Pet $pet): bool
    {
        if (! $this->isRainbowSpecial($skill, [26, 27, 28, 29, 30])) {
            return false;
        }

        return $skill->game_id === 26
            || ! in_array($skill->game_id, $this->roleSpecialGameIds($pet), true);
    }

    /** @return list<int> */
    private function roleSpecialGameIds(Pet $pet): array
    {
        $variation = abs(crc32("{$pet->game_source_id}:{$pet->game_id}:role-special"));

        return match ($pet->primary_role) {
            'support' => match ($variation % 4) {
                0 => [27, 28],
                1 => [27, 30],
                2 => [30],
                default => [27],
            },
            'guardian' => $variation % 3 === 0 ? [27] : [],
            'controller' => $variation % 2 === 0 ? [30] : [],
            'striker' => $pet->quality_tier >= 4 ? [29] : [],
            default => [],
        };
    }

    /** @param  list<int>  $gameIds */
    private function isRainbowSpecial(Skill $skill, array $gameIds): bool
    {
        return $skill->gameSource->slug === 'cau-vong' && in_array($skill->game_id, $gameIds, true);
    }

    /**
     * @param  list<array<string, mixed>>  $grantRows
     * @param  array<int, int>  $directGrantCounts
     * @return array<int, int|string>
     */
    private function candidateScore(
        Skill $skill,
        Pet $pet,
        int $desiredTier,
        array $grantRows,
        array $directGrantCounts,
    ): array {
        $priorities = self::ROLE_CATEGORY_PRIORITY[$pet->primary_role];
        $categoryRank = array_search($skill->combat_category, $priorities, true);
        $categoryRank = $categoryRank === false ? count($priorities) : $categoryRank;
        $sourceType = $this->sourceType($skill);
        $sameCategoryCount = collect($grantRows)->where('combat_role', $skill->combat_category)->count();
        $sameSourceCount = collect($grantRows)->where('source_type', $sourceType)->count();
        $roleTagBonus = in_array($pet->primary_role, $skill->role_tags ?? [], true) ? -25 : 0;
        $variation = abs(crc32("{$pet->game_source_id}:{$pet->game_id}:{$skill->game_source_id}:{$skill->game_id}")) % 17;

        return [
            $directGrantCounts[$skill->id] === 0 ? 0 : 1,
            $categoryRank * 100 + $roleTagBonus,
            abs($skill->tier - $desiredTier) * 35,
            $sameCategoryCount * 16,
            $sameSourceCount * 12,
            $variation,
            $skill->game_source_id,
            $skill->game_id,
        ];
    }

    private function desiredTierForSlot(int $currentSkillCount): int
    {
        return match (true) {
            $currentSkillCount < 3 => 0,
            $currentSkillCount < 6 => 1,
            $currentSkillCount < 8 => 2,
            default => 3,
        };
    }

    private function unlockLevel(Skill $skill): int
    {
        if ($skill->tier === 0) {
            $groupSize = $skill->gameSource->slug === 'cau-vong' && $skill->game_id <= 24 ? 5 : 10;

            return $skill->game_id % $groupSize === 0 ? 5 : 10;
        }

        return match ($skill->tier) {
            1 => 20,
            2 => 30,
            3 => 40,
            default => 40,
        };
    }

    private function sourceType(Skill $skill): string
    {
        if ($skill->species_affinity !== null) {
            return 'species';
        }

        if ($skill->gameSource->slug === 'cau-vong' && $skill->game_id >= 25) {
            return 'universal';
        }

        return 'element';
    }

    /** @param  list<int|float>  $values */
    private function median(array $values): float
    {
        sort($values, SORT_NUMERIC);
        $count = count($values);
        $middle = intdiv($count, 2);

        return $count % 2 === 0
            ? ($values[$middle - 1] + $values[$middle]) / 2
            : (float) $values[$middle];
    }
}
