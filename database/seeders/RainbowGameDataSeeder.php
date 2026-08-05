<?php

namespace Database\Seeders;

use App\Models\Effect;
use App\Models\Element;
use App\Models\GameSource;
use App\Models\Item;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\Skill;
use App\Models\SkillUnlockRule;
use App\Support\Vqsv4SkillData;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;
use JsonException;
use RuntimeException;

class RainbowGameDataSeeder extends Seeder
{
    private const DATA_SOURCE = 'resources/decoded/rainbow/06_analysis/game-data.json';

    private const SOURCE_SLUG = 'cau-vong';

    /** @var list<int> */
    private const REMOVED_ITEM_GAME_IDS = [12, 13, 35, 38, 49, 52, 53, 54, 55, 56];

    /** @var array<int, int> */
    private const QUALITY_MULTIPLIERS = [1 => 90, 2 => 95, 3 => 100, 4 => 110, 5 => 125];

    /** @var list<string> */
    private const STAT_NAMES = ['hp', 'strength', 'defense', 'agility'];

    /**
     * Run the database seeds.
     *
     * @throws JsonException
     */
    public function run(): void
    {
        $data = $this->gameData();
        $gameSource = GameSource::query()->where('slug', self::SOURCE_SLUG)->firstOrFail();

        DB::transaction(function () use ($data, $gameSource): void {
            $elementIds = $this->seedElements($data['elements'], $gameSource);
            $effectIds = $this->seedEffects($data['effects'], $gameSource);
            $itemIds = $this->seedItems($data['items'], $gameSource);
            $balanceTiers = $this->balanceTiers($data['pets'], $data['pet_evolutions']);
            $referenceProfiles = $this->referenceStatProfiles();
            $rainbowTierMedians = $this->rainbowTierMedians($data['pets'], $balanceTiers);
            $petIds = $this->seedPets(
                $data['pets'],
                $elementIds,
                $gameSource,
                $balanceTiers,
                $referenceProfiles,
                $rainbowTierMedians,
            );

            $this->seedSkills($data['skills'], $elementIds, $effectIds, $gameSource);
            $this->seedUnlockRules($gameSource);
            $this->seedEvolutions($data['pet_evolutions'], $petIds, $itemIds);
        });
    }

    /**
     * @param  list<array<string, mixed>>  $rows
     * @return array<int, int>
     */
    private function seedElements(array $rows, GameSource $gameSource): array
    {
        $ids = [];
        foreach ($rows as $row) {
            $element = Element::query()->updateOrCreate(
                ['game_source_id' => $gameSource->id, 'game_id' => $row['game_id']],
                ['name' => $row['name'], 'slug' => $row['slug'], 'color' => $row['color'], 'icon_path' => null],
            );
            $ids[$row['game_id']] = (int) $element->getKey();
        }

        return $ids;
    }

    /**
     * @param  list<array<string, mixed>>  $rows
     * @return array<string, int>
     */
    private function seedEffects(array $rows, GameSource $gameSource): array
    {
        $ids = [];
        foreach ([...$rows, ...Vqsv4SkillData::effectDefinitions()] as $row) {
            $effect = Effect::query()->updateOrCreate(
                ['game_source_id' => $gameSource->id, 'source_table' => $row['source_table'], 'game_id' => $row['game_id']],
                [
                    'kind' => $row['kind'],
                    'name_original' => $row['name_original'] ?? $row['name'],
                    'name' => $row['name'],
                    'description' => $row['description'],
                    'duration' => null,
                    'parameters' => $row['parameters'],
                    'raw_values' => $row,
                ],
            );
            $ids[$this->identity($row['source_table'], $row['game_id'])] = (int) $effect->getKey();
        }

        return $ids;
    }

    /**
     * @param  list<array<string, mixed>>  $rows
     * @return array<int, int>
     */
    private function seedItems(array $rows, GameSource $gameSource): array
    {
        $ids = [];
        Item::query()
            ->whereBelongsTo($gameSource)
            ->whereIn('game_id', self::REMOVED_ITEM_GAME_IDS)
            ->delete();

        foreach ($rows as $row) {
            if (in_array($row['game_id'], self::REMOVED_ITEM_GAME_IDS, true)) {
                continue;
            }

            $name = $row['game_id'] === 24 ? 'Kim Tinh Thạch' : $row['name'];
            $item = Item::query()->updateOrCreate(
                ['game_source_id' => $gameSource->id, 'source_table' => 0, 'game_id' => $row['game_id']],
                [
                    'name_original' => $row['name'],
                    'name' => $name,
                    'slug' => $this->slug($row['game_id'], $name),
                    'description_original' => $row['description'],
                    'description' => $this->canonicalItemDescription($row),
                    'category' => $this->canonicalItemCategory($row),
                    'frame_id' => $row['game_id'],
                    'cost' => null,
                    'currency_code' => null,
                    'effect_type' => null,
                    'effect_parameters' => ['atlas_frame' => $row['frame_id'], 'sound_id' => $row['sound_id']],
                    'raw_values' => $row,
                ],
            );
            $ids[$row['game_id']] = (int) $item->getKey();
        }

        return $ids;
    }

    /** @param array<string, mixed> $row */
    private function canonicalItemCategory(array $row): string
    {
        return match (true) {
            $row['game_id'] >= 16 && $row['game_id'] <= 25 => 'evolution_material',
            $row['game_id'] >= 26 && $row['game_id'] <= 30 => 'signature_evolution_material',
            in_array($row['game_id'], [37, 39, 40, 41, 42, 43, 44, 47, 48, 50, 51, 57], true) => 'passive_equipment',
            default => $row['category'],
        };
    }

    /** @param array<string, mixed> $row */
    private function canonicalItemDescription(array $row): string
    {
        if ($row['game_id'] >= 16 && $row['game_id'] <= 25) {
            $grade = $row['game_id'] % 2 === 0 ? 'cơ bản' : 'cao cấp';

            return "Nguyên liệu Chủng bậc {$grade}, dùng cùng lõi tiến hóa Liệt Hỏa trong công thức Pet hợp nhất.";
        }

        if ($row['game_id'] >= 26 && $row['game_id'] <= 30) {
            return 'Chất xúc tác đặc trưng dành cho một dòng tiến hóa hiếm hoặc form cuối đặc biệt.';
        }

        return $row['description'];
    }

    /**
     * @param  list<array<string, mixed>>  $rows
     * @param  array<int, int>  $elementIds
     * @param  array<int, int>  $balanceTiers
     * @param  array<int, array{hp: int, strength: int, defense: int, agility: int, budget: int}>  $referenceProfiles
     * @param  array<int, array{hp: float, strength: float, defense: float, agility: float}>  $rainbowTierMedians
     * @return array<int, int>
     */
    private function seedPets(
        array $rows,
        array $elementIds,
        GameSource $gameSource,
        array $balanceTiers,
        array $referenceProfiles,
        array $rainbowTierMedians,
    ): array {
        $ids = [];
        foreach ($rows as $row) {
            $taxonomy = PetTaxonomyData::for(self::SOURCE_SLUG, $row['game_id']);
            $balanceTier = $balanceTiers[$row['game_id']];
            $stats = $this->normalizedStats(
                $row,
                $balanceTier,
                $referenceProfiles[$balanceTier],
                $rainbowTierMedians[$balanceTier],
            );
            $pet = Pet::query()->updateOrCreate(
                ['game_source_id' => $gameSource->id, 'game_id' => $row['game_id']],
                [
                    'element_id' => $elementIds[$row['element_game_id']],
                    'combat_element' => $taxonomy['combat_element'],
                    'species' => $taxonomy['species'],
                    'name_original' => $row['name'],
                    'name' => $row['name'],
                    'slug' => $this->slug($row['game_id'], $row['name']),
                    'description_original' => $row['description'],
                    'description' => $row['description'],
                    'discovery_locations' => $row['locations'],
                    'acquisition_code' => $row['acquisition_code'],
                    'variant_code' => $row['sprite_variant'],
                    'quality_tier' => $balanceTier,
                    'rarity_or_growth_code' => $row['evolution_capacity'],
                    'hp_base' => $stats['hp']['base'],
                    'hp_per_level' => $stats['hp']['growth'],
                    'hp_offset' => $stats['hp']['offset'],
                    'energy_base' => null,
                    'energy_per_10_levels' => null,
                    'stat_2_base' => $stats['strength']['base'],
                    'stat_2_per_level' => $stats['strength']['growth'],
                    'stat_2_offset' => $stats['strength']['offset'],
                    'stat_3_base' => $stats['defense']['base'],
                    'stat_3_per_10_levels' => $stats['defense']['growth'],
                    'stat_3_offset' => $stats['defense']['offset'],
                    'stat_4_base' => $stats['agility']['base'],
                    'stat_4_per_10_levels' => $stats['agility']['growth'],
                    'stat_4_offset' => $stats['agility']['offset'],
                    'sprite_id' => $row['game_id'],
                    'learning_group' => $row['element_game_id'],
                    'effectiveness_class' => $row['flags'][0] ?? 0,
                    'raw_values' => $row,
                ],
            );
            $ids[$row['game_id']] = (int) $pet->getKey();
        }

        return $ids;
    }

    /**
     * Assign a shared strength tier from normalized evolution progress.
     *
     * @param  list<array<string, mixed>>  $petRows
     * @param  list<array<string, mixed>>  $evolutionRows
     * @return array<int, int>
     */
    private function balanceTiers(array $petRows, array $evolutionRows): array
    {
        $incoming = [];
        $outgoing = [];

        foreach ($evolutionRows as $evolution) {
            $from = (int) $evolution['from_pet_game_id'];
            $to = (int) $evolution['to_pet_game_id'];
            $incoming[$to][] = $from;
            $outgoing[$from][] = $to;
        }

        $rootAndDepth = [];
        foreach ($petRows as $row) {
            $gameId = (int) $row['game_id'];
            $current = $gameId;
            $depth = 0;
            $visited = [];

            while (isset($incoming[$current]) && ! isset($visited[$current])) {
                $visited[$current] = true;
                $current = (int) $incoming[$current][0];
                $depth++;
            }

            $rootAndDepth[$gameId] = ['root' => $current, 'depth' => $depth];
        }

        $maximumDepths = [];
        foreach ($rootAndDepth as $metadata) {
            $root = $metadata['root'];
            $maximumDepths[$root] = max($maximumDepths[$root] ?? 0, $metadata['depth']);
        }

        $tiers = [];
        foreach ($petRows as $row) {
            $gameId = (int) $row['game_id'];
            $hasEvolutionFamily = isset($incoming[$gameId]) || isset($outgoing[$gameId]);

            if (! $hasEvolutionFamily) {
                $tiers[$gameId] = max(1, min(5, (int) $row['evolution_stage']));

                continue;
            }

            $metadata = $rootAndDepth[$gameId];
            $maximumDepth = $maximumDepths[$metadata['root']];

            if ($metadata['depth'] === 0) {
                $tiers[$gameId] = 1;
            } elseif (! isset($outgoing[$gameId])) {
                $tiers[$gameId] = 4;
            } else {
                $tiers[$gameId] = 1 + (int) round(3 * $metadata['depth'] / $maximumDepth);
            }
        }

        return $tiers;
    }

    /**
     * Build shared level-50 stat targets from the Liệt Hỏa population.
     *
     * @return array<int, array{hp: int, strength: int, defense: int, agility: int, budget: int}>
     */
    private function referenceStatProfiles(): array
    {
        $pets = Pet::query()
            ->whereHas('gameSource', fn (Builder $query): Builder => $query->where('slug', 'liet-hoa'))
            ->get();

        if ($pets->isEmpty()) {
            throw new RuntimeException('Liệt Hỏa pet data must be seeded before Rainbow stat normalization.');
        }

        $levelFiftyStats = $pets->map(function (Pet $pet): array {
            $multiplier = self::QUALITY_MULTIPLIERS[$pet->quality_tier];

            return [
                'quality_tier' => $pet->quality_tier,
                'hp' => $this->effectiveStat($pet->hp_base + $pet->hp_per_level * 50 + $pet->hp_offset, $multiplier),
                'strength' => $this->effectiveStat($pet->stat_2_base + $pet->stat_2_per_level * 50 + $pet->stat_2_offset, $multiplier),
                'defense' => $this->effectiveStat($pet->stat_3_base + $pet->stat_3_per_10_levels * 5 + $pet->stat_3_offset, $multiplier),
                'agility' => $this->effectiveStat($pet->stat_4_base + $pet->stat_4_per_10_levels * 5 + $pet->stat_4_offset, $multiplier),
            ];
        });
        $standardPets = $levelFiftyStats->where('quality_tier', '<', 5);
        $legendaryPets = $levelFiftyStats->where('quality_tier', 5);

        if ($standardPets->isEmpty() || $legendaryPets->isEmpty()) {
            throw new RuntimeException('Liệt Hỏa reference data must contain standard and tier-five pets.');
        }

        $profiles = [];
        foreach ([1 => 0.2, 2 => 0.4, 3 => 0.6, 4 => 0.8] as $tier => $quantile) {
            $profiles[$tier] = $this->statProfile(
                fn (string $stat): int => $this->quantile($standardPets->pluck($stat)->all(), $quantile),
            );
        }
        $profiles[5] = $this->statProfile(
            fn (string $stat): int => $this->quantile($legendaryPets->pluck($stat)->all(), 0.5),
        );

        return $profiles;
    }

    /**
     * Calculate original Rainbow medians for role preservation within each balance tier.
     *
     * @param  list<array<string, mixed>>  $rows
     * @param  array<int, int>  $balanceTiers
     * @return array<int, array{hp: float, strength: float, defense: float, agility: float}>
     */
    private function rainbowTierMedians(array $rows, array $balanceTiers): array
    {
        $groups = [];
        foreach ($rows as $row) {
            $tier = $balanceTiers[$row['game_id']];
            foreach (self::STAT_NAMES as $stat) {
                $groups[$tier][$stat][] = $this->originalRainbowStat($row, $stat);
            }
        }

        $medians = [];
        foreach ($groups as $tier => $stats) {
            foreach (self::STAT_NAMES as $stat) {
                $medians[$tier][$stat] = $this->median($stats[$stat]);
            }
        }

        return $medians;
    }

    /**
     * Normalize one Pet to the exact shared tier budget while retaining its role profile.
     *
     * @param  array<string, mixed>  $row
     * @param  array{hp: int, strength: int, defense: int, agility: int, budget: int}  $referenceProfile
     * @param  array{hp: float, strength: float, defense: float, agility: float}  $tierMedians
     * @return array<string, array{base: int, growth: int, offset: int, target: int}>
     */
    private function normalizedStats(
        array $row,
        int $balanceTier,
        array $referenceProfile,
        array $tierMedians,
    ): array {
        $provisional = [];
        foreach (self::STAT_NAMES as $stat) {
            $roleFactor = $this->clamp(
                $this->originalRainbowStat($row, $stat) / $tierMedians[$stat],
                0.78,
                1.22,
            );
            $provisional[$stat] = $referenceProfile[$stat] * $roleFactor;
        }

        $targets = $this->allocateBudget($provisional, $referenceProfile['budget']);
        $multiplier = self::QUALITY_MULTIPLIERS[$balanceTier];
        $normalized = [];

        foreach (self::STAT_NAMES as $stat) {
            $baseKey = $stat.'_base';
            $growthKey = match ($stat) {
                'hp' => 'hp_per_10_levels',
                'strength' => 'strength_per_10_levels',
                'defense' => 'defense_per_10_levels',
                'agility' => 'agility_per_10_levels',
            };
            $normalized[$stat] = $this->normalizedFormula(
                (int) $row[$baseKey],
                (int) $row[$growthKey],
                in_array($stat, ['defense', 'agility'], true),
                $targets[$stat],
                $multiplier,
            );
        }

        return $normalized;
    }

    /**
     * Convert a target effective value to an integer formula matching Liệt Hỏa growth semantics.
     *
     * @return array{base: int, growth: int, offset: int, target: int}
     */
    private function normalizedFormula(
        int $originalBase,
        int $originalGrowthPerTenLevels,
        bool $growsPerTenLevels,
        int $target,
        int $qualityMultiplier,
    ): array {
        $preQualityTarget = $this->closestPreQualityValue($target, $qualityMultiplier);
        $originalLevelFifty = $originalBase + $originalGrowthPerTenLevels * 5;
        $baseRatio = $originalLevelFifty > 0 ? $originalBase / $originalLevelFifty : 0.2;
        $base = (int) round($preQualityTarget * $baseRatio);
        $growthDivisor = $growsPerTenLevels ? 5 : 50;
        $growth = (int) round(($preQualityTarget - $base) / $growthDivisor);

        return [
            'base' => $base,
            'growth' => $growth,
            'offset' => $preQualityTarget - $base - $growth * $growthDivisor,
            'target' => $this->effectiveStat($preQualityTarget, $qualityMultiplier),
        ];
    }

    /**
     * Allocate rounded stat values without changing the shared tier budget.
     *
     * @param  array<string, float>  $values
     * @return array<string, int>
     */
    private function allocateBudget(array $values, int $budget): array
    {
        $scale = $budget / array_sum($values);
        $scaled = array_map(fn (float $value): float => $value * $scale, $values);
        $allocated = array_map(fn (float $value): int => (int) floor($value), $scaled);
        $remainder = $budget - array_sum($allocated);
        $fractions = [];

        foreach ($scaled as $stat => $value) {
            $fractions[$stat] = $value - floor($value);
        }
        arsort($fractions);

        foreach (array_keys($fractions) as $stat) {
            if ($remainder === 0) {
                break;
            }

            $allocated[$stat]++;
            $remainder--;
        }

        return $allocated;
    }

    /** @param  array<string, mixed>  $row */
    private function originalRainbowStat(array $row, string $stat): int
    {
        return (int) $row[$stat.'_base'] + (int) $row[$stat.'_per_10_levels'] * 5;
    }

    /**
     * @param  callable(string): int  $value
     * @return array{hp: int, strength: int, defense: int, agility: int, budget: int}
     */
    private function statProfile(callable $value): array
    {
        $profile = [];
        foreach (self::STAT_NAMES as $stat) {
            $profile[$stat] = $value($stat);
        }
        $profile['budget'] = array_sum($profile);

        return $profile;
    }

    /** @param  list<int|float>  $values */
    private function quantile(array $values, float $quantile): int
    {
        sort($values, SORT_NUMERIC);
        $position = (count($values) - 1) * $quantile;
        $lowerIndex = (int) floor($position);
        $upperIndex = (int) ceil($position);

        if ($lowerIndex === $upperIndex) {
            return (int) $values[$lowerIndex];
        }

        $fraction = $position - $lowerIndex;

        return (int) round($values[$lowerIndex] + ($values[$upperIndex] - $values[$lowerIndex]) * $fraction);
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

    private function closestPreQualityValue(int $target, int $qualityMultiplier): int
    {
        $estimate = (int) round($target * 100 / $qualityMultiplier);
        $candidates = range(max(0, $estimate - 3), $estimate + 3);

        usort($candidates, fn (int $left, int $right): int => [
            abs($this->effectiveStat($left, $qualityMultiplier) - $target),
            abs($left - $estimate),
        ] <=> [
            abs($this->effectiveStat($right, $qualityMultiplier) - $target),
            abs($right - $estimate),
        ]);

        return $candidates[0];
    }

    private function effectiveStat(int $preQualityValue, int $qualityMultiplier): int
    {
        return (int) ($preQualityValue * $qualityMultiplier / 100);
    }

    private function clamp(float $value, float $minimum, float $maximum): float
    {
        return max($minimum, min($maximum, $value));
    }

    /**
     * @param  list<array<string, mixed>>  $rows
     * @param  array<int, int>  $elementIds
     * @param  array<string, int>  $effectIds
     */
    private function seedSkills(array $rows, array $elementIds, array $effectIds, GameSource $gameSource): void
    {
        foreach ($rows as $row) {
            $approvedDefinition = $row['game_id'] <= Vqsv4SkillData::LAST_ACTIVE_ID
                ? Vqsv4SkillData::definition($row['game_id'])
                : null;
            $primaryEffect = $approvedDefinition['primary_effect'] ?? null;
            $effectId = $primaryEffect === null
                ? null
                : $effectIds[$this->identity($primaryEffect[0], $primaryEffect[1])];
            $name = $approvedDefinition['name'] ?? $row['name'];
            Skill::query()->updateOrCreate(
                ['game_source_id' => $gameSource->id, 'game_id' => $row['game_id']],
                [
                    'element_id' => $row['element_game_id'] === null ? null : $elementIds[$row['element_game_id']],
                    'effect_id' => $effectId,
                    'name_original' => $row['name'],
                    'name' => $name,
                    'slug' => $this->slug($row['game_id'], $name),
                    'description_original' => $row['description'],
                    'description' => $row['description'],
                    'power_percent' => $row['power'],
                    'energy_cost' => $row['energy_cost'],
                    'status_chance' => $row['status_chance'],
                    'tier' => $row['tier'],
                    'max_uses' => 0,
                    'effect_mode' => $effectId === null ? 0 : 2,
                    'effect_parameter' => $row['status_chance'],
                    'target_side' => 0,
                    'raw_values' => $row,
                ],
            );
        }
    }

    private function seedUnlockRules(GameSource $gameSource): void
    {
        foreach (range(0, 4) as $learningGroup) {
            foreach ([7, 14, 21, 28, 35] as $tier => $level) {
                SkillUnlockRule::query()->updateOrCreate(
                    ['game_source_id' => $gameSource->id, 'learning_group' => $learningGroup, 'level' => $level],
                    ['maximum_skill_tier' => $tier + 1],
                );
            }
        }
    }

    /**
     * @param  list<array<string, mixed>>  $rows
     * @param  array<int, int>  $petIds
     * @param  array<int, int>  $itemIds
     */
    private function seedEvolutions(array $rows, array $petIds, array $itemIds): void
    {
        foreach ($rows as $row) {
            $firstMaterial = $row['materials'][0] ?? null;
            if ($firstMaterial === null) {
                continue;
            }
            PetEvolution::query()->updateOrCreate(
                ['from_pet_id' => $petIds[$row['from_pet_game_id']], 'to_pet_id' => $petIds[$row['to_pet_game_id']]],
                [
                    'item_id' => $itemIds[$firstMaterial['item_game_id']],
                    'quantity' => $firstMaterial['quantity'],
                    'materials' => $row['materials'],
                    'evolution_type' => $row['evolution_type'],
                ],
            );
        }
    }

    /** @return array<string, mixed> */
    private function gameData(): array
    {
        $contents = file_get_contents(base_path(self::DATA_SOURCE));
        if ($contents === false) {
            throw new RuntimeException('Unable to read decoded Rainbow game data.');
        }

        return json_decode($contents, true, 512, JSON_THROW_ON_ERROR);
    }

    private function identity(int $sourceTable, int $gameId): string
    {
        return $sourceTable.':'.$gameId;
    }

    private function slug(int $gameId, string $name): string
    {
        return $gameId.'-'.(Str::slug($name) ?: 'record');
    }
}
