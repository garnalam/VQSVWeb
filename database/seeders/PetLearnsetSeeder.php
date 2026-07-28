<?php

namespace Database\Seeders;

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetSkillLearnset;
use App\Models\Skill;
use App\Support\SkillBalance;
use Illuminate\Database\Seeder;
use Illuminate\Support\Arr;
use Illuminate\Support\Collection;
use Illuminate\Support\Facades\DB;
use RuntimeException;

class PetLearnsetSeeder extends Seeder
{
    private const BALANCE_VERSION = SkillBalance::VERSION;

    /** @var list<int> */
    private const UNLOCK_MILESTONES = [5, 10, 15, 20, 25, 30, 35, 40, 45, 50];

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

    /** @var array<int, string> */
    private const RAINBOW_SKILL_ELEMENT_BY_GAME_ID = [
        0 => 'moc',
        1 => 'moc',
        2 => 'hoa',
        3 => 'phong',
        4 => 'moc',
        5 => 'tho',
        6 => 'tho',
        7 => 'hoa',
        8 => 'dien',
        9 => 'dien',
        10 => 'phong',
        11 => 'phong',
        12 => 'phong',
        13 => 'quy',
        14 => 'dien',
        15 => 'tho',
        16 => 'dien',
        17 => 'hoa',
        18 => 'tho',
        19 => 'hoa',
        20 => 'thuy',
        21 => 'thuy',
        22 => 'thuy',
        23 => 'thuy',
        24 => 'quy',
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

    /** @var array<string, list<string>> */
    private const CATEGORY_GROUPS = [
        'offense' => ['damage', 'hybrid'],
        'sustain' => ['heal', 'defense', 'buff'],
        'control' => ['control', 'disrupt'],
        'utility' => ['heal', 'defense', 'buff', 'control', 'disrupt'],
    ];

    /** @var array<string, array<string, int>> */
    private const ROLE_GROUP_REQUIREMENTS = [
        'striker' => ['offense' => 6, 'utility' => 1],
        'bruiser' => ['offense' => 5, 'utility' => 2],
        'guardian' => ['sustain' => 1, 'offense' => 3],
        'controller' => ['control' => 1, 'offense' => 4],
        'support' => ['sustain' => 2, 'control' => 1, 'offense' => 2],
        'versatile' => ['offense' => 4, 'utility' => 2, 'control' => 1],
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
                    'primary_role',
                    'secondary_role',
                    'quality_tier',
                ])
                ->with('gameSource:id,slug')
                ->orderBy('game_source_id')
                ->orderBy('game_id')
                ->get();

            if ($pets->count() !== 202) {
                throw new RuntimeException('The unified learnset requires all 202 pets to be seeded first.');
            }

            if ($pets->contains(fn (Pet $pet): bool => $pet->primary_role === null || $pet->secondary_role === null)) {
                throw new RuntimeException('Every Pet must have an approved balance role before seeding learnsets.');
            }

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
                $profile = SkillBalance::profile('liet-hoa', $skill->game_id);

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
                    'description' => $profile['description'],
                    'power_percent' => $profile['power'],
                    'status_chance' => $profile['status_chance'],
                    'tier' => $profile['tier'],
                    'max_uses' => $profile['pp'],
                ]);
            });
    }

    private function normalizeRainbowSkills(GameSource $gameSource): void
    {
        $speciesGroups = [
            0 => 'thuc-vat',
            1 => 'kim-loai',
            2 => 'phi-hanh',
            3 => 'manh-thu',
            4 => 'hai-duong',
        ];

        Skill::query()
            ->whereBelongsTo($gameSource)
            ->with('effect:id,name')
            ->orderBy('game_id')
            ->get()
            ->each(function (Skill $skill) use ($speciesGroups): void {
                if ($skill->game_id <= 24) {
                    $species = $speciesGroups[intdiv($skill->game_id, 5)];
                    $combatElement = self::RAINBOW_SKILL_ELEMENT_BY_GAME_ID[$skill->game_id];
                    $profile = SkillBalance::profile('cau-vong', $skill->game_id);
                    $skill->update([
                        'combat_element' => $combatElement,
                        'species_affinity' => $species,
                        'combat_category' => 'hybrid',
                        'target_pattern' => 'single_enemy',
                        'effect_target_pattern' => 'single_enemy',
                        'battle_format' => 'any',
                        'role_tags' => $this->roleTags('hybrid'),
                        'balance_version' => self::BALANCE_VERSION,
                        'is_active' => true,
                        'power_percent' => $profile['power'],
                        'description' => $profile['description'],
                        'energy_cost' => null,
                        'status_chance' => $profile['status_chance'],
                        'tier' => $profile['tier'],
                        'max_uses' => $profile['pp'],
                        'target_side' => 0,
                    ]);

                    return;
                }

                $skill->update([
                    ...$this->rainbowSpecialSkill($skill->game_id),
                    'energy_cost' => null,
                    'balance_version' => in_array($skill->game_id, [27, 28, 29, 30], true)
                        ? self::BALANCE_VERSION
                        : null,
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

        $profile = in_array($gameId, [27, 28, 29, 30], true)
            ? SkillBalance::profile('cau-vong', $gameId)
            : null;

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
                ...$this->rainbowSpecialAttributes('moc', 'heal', 'self_or_ally', 'double', ['support', 'guardian'], $profile['power'], $profile['tier'], $profile['pp'], 1),
                'status_chance' => $profile['status_chance'],
                'description' => $profile['description'],
            ],
            28 => [
                ...$this->rainbowSpecialAttributes('moc', 'heal', 'self_or_ally', 'double', ['support'], $profile['power'], $profile['tier'], $profile['pp'], 1),
                'status_chance' => $profile['status_chance'],
                'description' => $profile['description'],
            ],
            29 => [
                ...$this->rainbowSpecialAttributes('quy', 'damage', 'single_enemy', 'any', ['striker'], $profile['power'], $profile['tier'], $profile['pp'], 0),
                'status_chance' => $profile['status_chance'],
                'description' => $profile['description'],
            ],
            30 => [
                ...$this->rainbowSpecialAttributes('quy', 'control', 'single_enemy', 'any', ['controller', 'support'], $profile['power'], $profile['tier'], $profile['pp'], 0),
                'status_chance' => $profile['status_chance'],
                'description' => $profile['description'],
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
                    || in_array($skill->id, $reservedSiblingSkillIds, true));

            while (count($selectedSkillIds) < $targetCount && $candidates->isNotEmpty()) {
                $desiredTier = $this->desiredTierForSlot(count($selectedSkillIds));
                $selectedSkills = $skills->whereIn('id', $selectedSkillIds);
                $selected = $candidates
                    ->sortBy(fn (Skill $skill): array => $this->candidateScore(
                        $skill,
                        $pet,
                        $desiredTier,
                        $directGrantCounts,
                        $selectedSkills,
                        $targetCount,
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
                    'unlock_level' => self::UNLOCK_MILESTONES[count($selectedSkillIds) - 1],
                    'source_type' => $this->sourceType($selected, $pet),
                    'combat_role' => $selected->combat_category,
                    'is_signature' => $this->isDesignatedSignatureGrant($selected, $pet),
                    'sort_order' => count($selectedSkillIds),
                    'created_at' => now(),
                    'updated_at' => now(),
                ];
                $candidates = $candidates->reject(fn (Skill $skill): bool => $skill->is($selected));
            }

            if (count($selectedSkillIds) !== $targetCount) {
                throw new RuntimeException(
                    "Unable to build {$targetCount} cumulative skills for {$pet->name}.",
                );
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
        $this->applyApprovedMetaTuning($pets, $skills);
        $this->normalizeSignatureAssignments($familyMetadata);
        $this->validateLearnsetCoverage($skills);
    }

    /**
     * Apply the approved per-Pet deck changes without altering shared Skill power.
     *
     * @param  Collection<int, Pet>  $pets
     * @param  Collection<int, Skill>  $skills
     */
    private function applyApprovedMetaTuning(Collection $pets, Collection $skills): void
    {
        $petsByIdentity = $pets->keyBy(
            fn (Pet $pet): string => "{$pet->gameSource->slug}:{$pet->game_id}",
        );
        $skillsByIdentity = $skills->keyBy(
            fn (Skill $skill): string => "{$skill->gameSource->slug}:{$skill->game_id}",
        );
        $replacements = [
            [
                'pet' => 'cau-vong:18',
                'remove' => 'cau-vong:7',
                'add' => 'cau-vong:8',
            ],
            [
                'pet' => 'cau-vong:19',
                'remove' => 'cau-vong:8',
                'add' => 'cau-vong:7',
            ],
            [
                'pet' => 'liet-hoa:17',
                'remove' => 'cau-vong:28',
                'add' => 'liet-hoa:13',
            ],
            [
                'pet' => 'liet-hoa:17',
                'remove' => 'liet-hoa:15',
                'add' => 'liet-hoa:11',
            ],
            [
                'pet' => 'liet-hoa:18',
                'remove' => 'liet-hoa:18',
                'add' => 'liet-hoa:14',
            ],
            [
                'pet' => 'cau-vong:48',
                'remove' => 'liet-hoa:29',
                'add' => 'liet-hoa:25',
            ],
        ];

        foreach ($replacements as $replacement) {
            $pet = $petsByIdentity->get($replacement['pet']);
            $removedSkill = $skillsByIdentity->get($replacement['remove']);
            $addedSkill = $skillsByIdentity->get($replacement['add']);

            if (! $pet instanceof Pet || ! $removedSkill instanceof Skill || ! $addedSkill instanceof Skill) {
                throw new RuntimeException("Invalid approved meta tuning for {$replacement['pet']}.");
            }

            $this->replaceDirectLearnsetSkill($pet, $removedSkill, $addedSkill);
        }
    }

    /**
     * Replace one direct learnset grant while preserving its unlock milestone and order.
     */
    private function replaceDirectLearnsetSkill(Pet $pet, Skill $removedSkill, Skill $addedSkill): void
    {
        $entry = PetSkillLearnset::query()
            ->whereBelongsTo($pet)
            ->whereBelongsTo($removedSkill, 'skill')
            ->first();

        if (! $entry instanceof PetSkillLearnset) {
            throw new RuntimeException(
                "Missing direct Skill {$removedSkill->name} for approved Pet tuning {$pet->name}.",
            );
        }

        if (PetSkillLearnset::query()->whereBelongsTo($pet)->whereBelongsTo($addedSkill, 'skill')->exists()) {
            throw new RuntimeException(
                "Replacement Skill {$addedSkill->name} is already granted directly to {$pet->name}.",
            );
        }

        $entry->update([
            'skill_id' => $addedSkill->id,
            'source_type' => $this->sourceType($addedSkill, $pet),
            'combat_role' => $addedSkill->combat_category,
            'is_signature' => $this->isDesignatedSignatureGrant($addedSkill, $pet),
        ]);
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
            return $maximumDepth === 1 ? 5 : 3;
        }

        return min(9, 3 + (int) round(7 * $stage / $maximumDepth));
    }

    /**
     * @param  Collection<int, Skill>  $skills
     * @return Collection<int, Skill>
     */
    private function candidateSkills(Pet $pet, Collection $skills): Collection
    {
        $roleSpecialGameIds = $this->roleSpecialGameIds($pet);

        return $skills->filter(function (Skill $skill) use ($pet, $roleSpecialGameIds): bool {
            if ($this->isDesignatedSignatureSkill($skill) && ! $this->isDesignatedSignaturePet($pet)) {
                return false;
            }

            $matchesElement = $skill->combat_element === $pet->combat_element
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

        if ($skill->game_id === 26) {
            return true;
        }

        if ($skill->game_id === 28 && $pet->primary_role !== 'support') {
            return true;
        }

        if ($skill->combat_element === $pet->combat_element) {
            return false;
        }

        return ! in_array($skill->game_id, $this->roleSpecialGameIds($pet), true);
    }

    /** @return list<int> */
    private function roleSpecialGameIds(Pet $pet): array
    {
        $primaryRole = $pet->primary_role ?? throw new RuntimeException("Missing combat role for {$pet->name}.");

        return match ($primaryRole) {
            'support' => [27, 28, 30],
            'guardian' => $pet->combat_element === 'tho' ? [] : [27],
            'controller' => [30],
            'striker' => $pet->quality_tier >= 4 ? [29] : [],
            'versatile' => [27, 30],
            default => [],
        };
    }

    /** @param  list<int>  $gameIds */
    private function isRainbowSpecial(Skill $skill, array $gameIds): bool
    {
        return $skill->gameSource->slug === 'cau-vong' && in_array($skill->game_id, $gameIds, true);
    }

    private function isDesignatedSignatureSkill(Skill $skill): bool
    {
        return $skill->gameSource->slug === 'cau-vong' && $skill->game_id === 19;
    }

    private function isDesignatedSignaturePet(Pet $pet): bool
    {
        return $pet->gameSource->slug === 'liet-hoa' && $pet->game_id === 8;
    }

    private function isDesignatedSignatureGrant(Skill $skill, Pet $pet): bool
    {
        return $this->isDesignatedSignatureSkill($skill) && $this->isDesignatedSignaturePet($pet);
    }

    /**
     * @param  array<int, int>  $directGrantCounts
     * @param  Collection<int, Skill>  $selectedSkills
     * @return array<int, int|string>
     */
    private function candidateScore(
        Skill $skill,
        Pet $pet,
        int $desiredTier,
        array $directGrantCounts,
        Collection $selectedSkills,
        int $targetCount,
    ): array {
        $primaryRole = $pet->primary_role ?? throw new RuntimeException("Missing combat role for {$pet->name}.");
        $priorities = self::ROLE_CATEGORY_PRIORITY[$primaryRole];
        $categoryRank = array_search($skill->combat_category, $priorities, true);
        $categoryRank = $categoryRank === false ? count($priorities) : $categoryRank;
        $sourceType = $this->sourceType($skill, $pet);
        $sourceCoveragePenalty = $this->sourceCoveragePenalty(
            $sourceType,
            $pet,
            $selectedSkills,
            $targetCount,
        );
        $roleCoveragePenalty = $this->roleCoveragePenalty(
            $skill->combat_category,
            $primaryRole,
            $selectedSkills,
            $targetCount,
        );
        $minimumOffenseCoveragePenalty = $this->minimumOffenseCoveragePenalty(
            $skill->combat_category,
            $selectedSkills,
            $targetCount,
        );
        $sameCategoryCount = $selectedSkills->where('combat_category', $skill->combat_category)->count();
        $sameSourceCount = $selectedSkills
            ->filter(fn (Skill $selectedSkill): bool => $this->sourceType($selectedSkill, $pet) === $sourceType)
            ->count();
        $secondaryRole = $pet->secondary_role ?? throw new RuntimeException("Missing secondary combat role for {$pet->name}.");
        $roleTags = Arr::wrap($skill->getAttribute('role_tags'));
        $roleTagBonus = match (true) {
            in_array($primaryRole, $roleTags, true) => -25,
            in_array($secondaryRole, $roleTags, true) => -10,
            default => 0,
        };
        $variation = abs(crc32("{$pet->game_source_id}:{$pet->game_id}:{$skill->game_source_id}:{$skill->game_id}")) % 17;

        return [
            $this->isDesignatedSignatureGrant($skill, $pet) ? -1 : 0,
            $minimumOffenseCoveragePenalty,
            $sourceCoveragePenalty + $roleCoveragePenalty,
            $sourceCoveragePenalty,
            $roleCoveragePenalty,
            $directGrantCounts[$skill->id] === 0 ? 0 : 1,
            abs($skill->tier - $desiredTier) * 35,
            $variation,
            $categoryRank * 100 + $roleTagBonus,
            $sameCategoryCount * 16,
            $sameSourceCount * 12,
            $skill->game_source_id,
            $skill->game_id,
        ];
    }

    /** @param Collection<int, Skill> $selectedSkills */
    private function sourceCoveragePenalty(
        string $candidateSource,
        Pet $pet,
        Collection $selectedSkills,
        int $targetCount,
    ): int {
        $requirements = [
            'element' => (int) ceil(3 * $targetCount / 10),
            'species' => (int) ceil(3 * $targetCount / 10),
        ];
        $sourceCounts = $selectedSkills
            ->countBy(fn (Skill $selectedSkill): string => $this->sourceType($selectedSkill, $pet));
        $missingSources = collect($requirements)
            ->filter(fn (int $required, string $source): bool => $sourceCounts->get($source, 0) < $required)
            ->keys();

        return $missingSources->isEmpty() || $missingSources->contains($candidateSource) ? 0 : 2;
    }

    /** @param Collection<int, Skill> $selectedSkills */
    private function roleCoveragePenalty(
        string $candidateCategory,
        string $primaryRole,
        Collection $selectedSkills,
        int $targetCount,
    ): int {
        $coverageDeficits = collect(self::ROLE_GROUP_REQUIREMENTS[$primaryRole])
            ->mapWithKeys(function (int $finalRequirement, string $group) use ($selectedSkills, $targetCount): array {
                $required = (int) ceil($finalRequirement * $targetCount / 10);

                if ($group === 'offense' && $targetCount >= 3) {
                    $required = max(2, $required);
                }

                $current = $selectedSkills
                    ->whereIn('combat_category', self::CATEGORY_GROUPS[$group])
                    ->count();

                return [$group => max(0, $required - $current)];
            })
            ->filter(fn (int $deficit): bool => $deficit > 0);

        if ($coverageDeficits->isEmpty()) {
            return 0;
        }

        return $coverageDeficits
            ->reject(fn (int $deficit, string $group): bool => in_array($candidateCategory, self::CATEGORY_GROUPS[$group], true))
            ->sum() * 2;
    }

    /** @param Collection<int, Skill> $selectedSkills */
    private function minimumOffenseCoveragePenalty(
        string $candidateCategory,
        Collection $selectedSkills,
        int $targetCount,
    ): int {
        if ($targetCount < 3) {
            return 0;
        }

        $offenseCount = $selectedSkills
            ->whereIn('combat_category', self::CATEGORY_GROUPS['offense'])
            ->count();

        if ($offenseCount >= 2) {
            return 0;
        }

        return in_array($candidateCategory, self::CATEGORY_GROUPS['offense'], true) ? 0 : 1;
    }

    private function desiredTierForSlot(int $currentSkillCount): int
    {
        return match (true) {
            $currentSkillCount < 3 => 0,
            $currentSkillCount < 5 => 1,
            $currentSkillCount < 8 => 2,
            default => 3,
        };
    }

    private function sourceType(Skill $skill, Pet $pet): string
    {
        if ($skill->gameSource->slug === 'cau-vong' && $skill->game_id >= 25) {
            return 'universal';
        }

        if ($skill->species_affinity === $pet->species) {
            return 'species';
        }

        if ($skill->combat_element === $pet->combat_element) {
            return 'element';
        }

        return 'universal';
    }
}
