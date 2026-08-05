<?php

namespace Database\Seeders;

use App\Models\Element;
use App\Models\GameSource;
use App\Models\Item;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetMutationRecipe;
use App\Models\PetTrait;
use App\Support\Vqsv4PetDesignRevision;
use Illuminate\Database\Seeder;
use Illuminate\Support\Collection;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;
use JsonException;
use RuntimeException;

class Vqsv4PetSeeder extends Seeder
{
    private const DATA_PATH = 'decoded/vqsv4/06_analysis/pet-design-72.json';

    private const SOURCE_SLUG = 'vqsv4';

    /** @var array<string, int> */
    private const LEARNING_GROUPS = [
        'hoa' => 0,
        'moc' => 1,
        'tho' => 2,
        'thuy' => 3,
        'dien' => 4,
        'quy' => 5,
        'phong' => 6,
    ];

    /**
     * Seed the approved 72-Pet VQSV4 vertical slice.
     *
     * @throws JsonException
     */
    public function run(): void
    {
        $data = $this->data();

        DB::transaction(function () use ($data): void {
            $source = GameSource::query()->updateOrCreate(
                ['slug' => self::SOURCE_SLUG],
                ['name' => 'VQSV4', 'asset_key' => self::SOURCE_SLUG, 'color' => '#a855f7'],
            );
            $elementIds = $this->seedElements($source, $data);
            $traits = PetTrait::query()->get()->keyBy('code');
            $pets = $this->seedPets($source, $data, $elementIds, $traits);

            $this->seedEvolutions($source, $data, $pets);
            $this->seedMutations($source, $data, $pets);
            $this->validateCatalog($source, $data);
        });
    }

    /**
     * @param  array<string, mixed>  $data
     * @return array<int, int>
     */
    private function seedElements(GameSource $source, array $data): array
    {
        $elementIds = [];

        foreach ($data['source_elements'] as $row) {
            $element = Element::query()->updateOrCreate(
                ['game_source_id' => $source->id, 'game_id' => $row['game_id']],
                [
                    'name' => $row['name'],
                    'slug' => $row['slug'],
                    'color' => $row['color'],
                    'icon_path' => null,
                ],
            );
            $elementIds[(int) $row['game_id']] = (int) $element->id;
        }

        return $elementIds;
    }

    /**
     * @param  array<string, mixed>  $data
     * @param  array<int, int>  $elementIds
     * @param  Collection<string, PetTrait>  $traits
     * @return Collection<int, Pet>
     */
    private function seedPets(
        GameSource $source,
        array $data,
        array $elementIds,
        Collection $traits,
    ): Collection {
        $pets = collect();

        foreach ($data['pets'] as $row) {
            $raw = $row['raw_source'];
            $speciesTrait = $traits->get($row['species_trait_code']);
            if (! $speciesTrait instanceof PetTrait || $speciesTrait->species !== $row['species']) {
                throw new RuntimeException("Invalid species trait for VQSV4 Pet {$row['game_id']}.");
            }

            $pet = Pet::query()->updateOrCreate(
                ['game_source_id' => $source->id, 'game_id' => $row['game_id']],
                [
                    'element_id' => $elementIds[(int) $raw['element_game_id']],
                    'combat_element' => $row['combat_element'],
                    'species' => $row['species'],
                    'species_trait_id' => $speciesTrait->id,
                    'primary_role' => $row['primary_role'],
                    'secondary_role' => $row['secondary_role'],
                    'preferred_battle_format' => $row['primary_role'] === 'support' ? 'double' : 'any',
                    'playstyle_summary' => $row['balance_notes'],
                    'name_original' => $row['name_original'],
                    'name' => $row['name'],
                    'slug' => Str::slug(sprintf('%03d-%s', $row['game_id'], $row['name'])),
                    'description_original' => $raw['description'],
                    'description' => $raw['description'],
                    'discovery_locations' => $raw['locations'],
                    'acquisition_code' => $raw['acquisition_code'],
                    'variant_code' => $raw['sprite_variant'],
                    'quality_tier' => $row['stars'],
                    'classification' => $row['classification'],
                    'rarity_or_growth_code' => $raw['evolution_capacity'],
                    'hp_base' => $row['stats']['hp_base'],
                    'hp_per_level' => $row['stats']['hp_growth'],
                    'hp_offset' => 0,
                    'energy_base' => null,
                    'energy_per_10_levels' => null,
                    'stat_2_base' => $row['stats']['strength_base'],
                    'stat_2_per_level' => $row['stats']['strength_growth'],
                    'stat_2_offset' => 0,
                    'stat_3_base' => $row['stats']['defense_base'],
                    'stat_3_per_10_levels' => $row['stats']['defense_growth'],
                    'stat_3_offset' => 0,
                    'stat_4_base' => $row['stats']['agility_base'],
                    'stat_4_per_10_levels' => $row['stats']['agility_growth'],
                    'stat_4_offset' => 0,
                    'sprite_id' => $row['game_id'],
                    'learning_group' => self::LEARNING_GROUPS[$row['combat_element']],
                    'effectiveness_class' => $row['classification'] === 'divine' ? 5 : ($raw['flags'][0] ?? 0),
                    'raw_values' => [
                        'source' => $raw,
                        'design' => [
                            'data_version' => $data['meta']['data_version'],
                            'design_revision' => $row['design_revision'],
                            'lineage_code' => $row['lineage_code'],
                            'stage' => $row['stage'],
                            'recommended_aptitude_code' => $row['recommended_aptitude_code'],
                            'mutation_note' => $row['mutation_note'],
                            'draft_original_label' => $row['draft_original_label'],
                        ],
                    ],
                ],
            );

            $pets->put((int) $row['game_id'], $pet);
        }

        return $pets;
    }

    /**
     * @param  array<string, mixed>  $data
     * @param  Collection<int, Pet>  $pets
     */
    private function seedEvolutions(GameSource $source, array $data, Collection $pets): void
    {
        PetEvolution::query()
            ->whereHas('sourcePet', fn ($query) => $query->whereBelongsTo($source))
            ->delete();

        $items = $this->recipeItems($data);

        foreach ($data['evolutions'] as $row) {
            $sourcePet = $pets->get((int) $row['from_game_id']);
            $targetPet = $pets->get((int) $row['to_game_id']);

            if (! $sourcePet instanceof Pet || ! $targetPet instanceof Pet) {
                throw new RuntimeException("Invalid VQSV4 evolution {$row['code']}.");
            }

            $resolvedIngredients = collect($row['ingredients'])
                ->map(function (array $ingredient, int $position) use ($items): array {
                    $item = $items->get($ingredient['name']);

                    if (! $item instanceof Item) {
                        throw new RuntimeException("Missing VQSV4 evolution item {$ingredient['name']}.");
                    }

                    return [
                        'item_id' => $item->id,
                        'quantity' => $ingredient['quantity'],
                        'role' => $ingredient['role'],
                        'position' => $position,
                    ];
                });
            $primary = $resolvedIngredients->first();
            $evolution = PetEvolution::query()->create([
                'from_pet_id' => $sourcePet->id,
                'to_pet_id' => $targetPet->id,
                'item_id' => $primary['item_id'],
                'quantity' => $primary['quantity'],
                'required_level' => $row['required_level'],
                'materials' => ['source_code' => $row['code'], 'source' => 'vqsv4-pet-draft-72.xlsx'],
                'evolution_type' => Str::contains($row['type'], 'Dị hóa') ? 'mutation' : 'evolution',
                'cost_rank' => $targetPet->quality_tier,
                'balance_notes' => $row['notes'],
            ]);
            $evolution->ingredients()->createMany($resolvedIngredients->all());
        }
    }

    /**
     * @param  array<string, mixed>  $data
     * @param  Collection<int, Pet>  $pets
     */
    private function seedMutations(GameSource $source, array $data, Collection $pets): void
    {
        PetMutationRecipe::query()
            ->whereHas('pet', fn ($query) => $query->whereBelongsTo($source))
            ->delete();

        $items = $this->recipeItems($data);

        foreach ($data['mutations'] as $row) {
            $pet = $pets->get((int) $row['pet_game_id']);

            if (! $pet instanceof Pet) {
                throw new RuntimeException("Invalid VQSV4 mutation Pet {$row['pet_game_id']}.");
            }

            $recipe = PetMutationRecipe::query()->create([
                'pet_id' => $pet->id,
                'status' => $row['status'],
                'notes' => $row['notes'],
            ]);
            $ingredients = collect($row['ingredients'])->map(function (array $ingredient, int $position) use ($items): array {
                $item = $items->get($ingredient['name']);

                if (! $item instanceof Item) {
                    throw new RuntimeException("Missing VQSV4 mutation item {$ingredient['name']}.");
                }

                return [
                    'item_id' => $item->id,
                    'quantity' => $ingredient['quantity'],
                    'role' => $ingredient['role'],
                    'position' => $position,
                ];
            });
            $recipe->ingredients()->createMany($ingredients->all());
        }
    }

    /**
     * @param  array<string, mixed>  $data
     * @return Collection<string, Item>
     */
    private function recipeItems(array $data): Collection
    {
        $names = collect($data['evolutions'])
            ->flatMap(fn (array $row): array => $row['ingredients'])
            ->merge(collect($data['mutations'])->flatMap(fn (array $row): array => $row['ingredients']))
            ->pluck('name')
            ->unique()
            ->values();
        $items = Item::query()
            ->where('is_active', true)
            ->whereIn('name', $names)
            ->get()
            ->keyBy('name');

        if ($items->count() !== $names->count()) {
            $missing = $names->diff($items->keys())->implode(', ');

            throw new RuntimeException("Missing approved VQSV4 recipe items: {$missing}.");
        }

        return $items;
    }

    /** @param array<string, mixed> $data */
    private function validateCatalog(GameSource $source, array $data): void
    {
        $includedIds = collect($data['pets'])->pluck('game_id');
        $excludedIds = collect($data['meta']['excluded_game_ids']);

        if (Pet::query()->whereBelongsTo($source)->whereIn('game_id', $excludedIds)->exists()) {
            throw new RuntimeException('An excluded VQSV4 Pet entered the approved catalog.');
        }

        if (Pet::query()->whereBelongsTo($source)->whereIn('game_id', $includedIds)->count() !== 72) {
            throw new RuntimeException('The approved VQSV4 catalog must contain exactly 72 Pet.');
        }
    }

    /**
     * @return array<string, mixed>
     *
     * @throws JsonException
     */
    private function data(): array
    {
        $design = json_decode(
            file_get_contents(resource_path(self::DATA_PATH)),
            true,
            flags: JSON_THROW_ON_ERROR,
        );
        $source = json_decode(
            file_get_contents(resource_path('decoded/vqsv4/06_analysis/game-data.json')),
            true,
            flags: JSON_THROW_ON_ERROR,
        );
        $design['source_elements'] = $source['elements'];
        $design['pets'] = collect($design['pets'])
            ->map(fn (array $pet): array => Vqsv4PetDesignRevision::apply($pet))
            ->all();

        if (collect($design['pets'])->pluck('game_id')->sort()->values()->all() !== Vqsv4PetDesignRevision::gameIds()) {
            throw new RuntimeException('The VQSV4 design revision must cover the complete approved 72-Pet catalog.');
        }

        return $design;
    }
}
