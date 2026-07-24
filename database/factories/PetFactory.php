<?php

namespace Database\Factories;

use App\Models\Element;
use App\Models\GameSource;
use App\Models\Pet;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<Pet>
 */
class PetFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        $name = fake()->unique()->words(2, true);

        return [
            'game_source_id' => GameSource::factory(),
            'game_id' => fake()->unique()->numberBetween(0, 255),
            'element_id' => Element::factory(),
            'combat_element' => fake()->randomElement(array_keys(Pet::COMBAT_ELEMENTS)),
            'species' => fake()->randomElement(array_keys(Pet::SPECIES)),
            'primary_role' => fake()->randomElement(array_keys(Pet::COMBAT_ROLES)),
            'secondary_role' => fake()->randomElement(array_keys(Pet::COMBAT_ROLES)),
            'preferred_battle_format' => 'any',
            'name_original' => $name,
            'name' => $name,
            'slug' => fake()->unique()->slug(2),
            'variant_code' => fake()->numberBetween(0, 20),
            'quality_tier' => fake()->numberBetween(1, 5),
            'rarity_or_growth_code' => fake()->numberBetween(0, 10),
            'hp_base' => fake()->numberBetween(1, 100),
            'hp_per_level' => fake()->numberBetween(1, 20),
            'hp_offset' => fake()->numberBetween(-10, 10),
            'stat_2_base' => fake()->numberBetween(1, 100),
            'stat_2_per_level' => fake()->numberBetween(1, 20),
            'stat_2_offset' => fake()->numberBetween(-10, 10),
            'stat_3_base' => fake()->numberBetween(1, 100),
            'stat_3_per_10_levels' => fake()->numberBetween(1, 20),
            'stat_3_offset' => fake()->numberBetween(-10, 10),
            'stat_4_base' => fake()->numberBetween(1, 100),
            'stat_4_per_10_levels' => fake()->numberBetween(1, 20),
            'stat_4_offset' => fake()->numberBetween(-10, 10),
            'sprite_id' => fake()->numberBetween(86, 185),
            'learning_group' => fake()->numberBetween(0, 3),
            'effectiveness_class' => fake()->numberBetween(0, 10),
            'raw_values' => [fake()->numberBetween(0, 100)],
        ];
    }
}
