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
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;
use JsonException;
use RuntimeException;

class RainbowGameDataSeeder extends Seeder
{
    private const DATA_SOURCE = 'resources/decoded/rainbow/06_analysis/game-data.json';

    private const SOURCE_SLUG = 'cau-vong';

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
            $petIds = $this->seedPets($data['pets'], $elementIds, $gameSource);

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
        foreach ($rows as $row) {
            $effect = Effect::query()->updateOrCreate(
                ['game_source_id' => $gameSource->id, 'source_table' => $row['source_table'], 'game_id' => $row['game_id']],
                [
                    'kind' => $row['kind'],
                    'name_original' => $row['name'],
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
        foreach ($rows as $row) {
            $item = Item::query()->updateOrCreate(
                ['game_source_id' => $gameSource->id, 'source_table' => 0, 'game_id' => $row['game_id']],
                [
                    'name_original' => $row['name'],
                    'name' => $row['name'],
                    'slug' => $this->slug($row['game_id'], $row['name']),
                    'description_original' => $row['description'],
                    'description' => $row['description'],
                    'category' => $row['category'],
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

    /**
     * @param  list<array<string, mixed>>  $rows
     * @param  array<int, int>  $elementIds
     * @return array<int, int>
     */
    private function seedPets(array $rows, array $elementIds, GameSource $gameSource): array
    {
        $ids = [];
        foreach ($rows as $row) {
            $taxonomy = PetTaxonomyData::for(self::SOURCE_SLUG, $row['game_id']);
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
                    'quality_tier' => max(1, min(5, $row['evolution_stage'])),
                    'rarity_or_growth_code' => $row['evolution_capacity'],
                    'hp_base' => $row['hp_base'],
                    'hp_per_level' => $row['hp_per_10_levels'],
                    'hp_offset' => 0,
                    'energy_base' => $row['energy_base'],
                    'energy_per_10_levels' => $row['energy_per_10_levels'],
                    'stat_2_base' => $row['strength_base'],
                    'stat_2_per_level' => $row['strength_per_10_levels'],
                    'stat_2_offset' => 0,
                    'stat_3_base' => $row['defense_base'],
                    'stat_3_per_10_levels' => $row['defense_per_10_levels'],
                    'stat_3_offset' => 0,
                    'stat_4_base' => $row['agility_base'],
                    'stat_4_per_10_levels' => $row['agility_per_10_levels'],
                    'stat_4_offset' => 0,
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
     * @param  list<array<string, mixed>>  $rows
     * @param  array<int, int>  $elementIds
     * @param  array<string, int>  $effectIds
     */
    private function seedSkills(array $rows, array $elementIds, array $effectIds, GameSource $gameSource): void
    {
        foreach ($rows as $row) {
            $statusEffectId = $row['status_effect_game_id'];
            $effectId = $statusEffectId === null ? null : $effectIds[$this->identity(11, $statusEffectId)];
            Skill::query()->updateOrCreate(
                ['game_source_id' => $gameSource->id, 'game_id' => $row['game_id']],
                [
                    'element_id' => $row['element_game_id'] === null ? null : $elementIds[$row['element_game_id']],
                    'effect_id' => $effectId,
                    'name_original' => $row['name'],
                    'name' => $row['name'],
                    'slug' => $this->slug($row['game_id'], $row['name']),
                    'description_original' => $row['description'],
                    'description' => $row['description'],
                    'power_percent' => $row['power'],
                    'energy_cost' => $row['energy_cost'],
                    'status_chance' => $row['status_chance'],
                    'tier' => $row['tier'],
                    'max_uses' => 0,
                    'effect_mode' => $statusEffectId === null ? 0 : 2,
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
