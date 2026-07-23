<?php

namespace Database\Factories;

use App\Models\GameSource;
use App\Models\Item;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<Item>
 */
class ItemFactory extends Factory
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
            'source_table' => fake()->numberBetween(2, 5),
            'game_id' => fake()->unique()->numberBetween(0, 255),
            'name_original' => $name,
            'name' => $name,
            'slug' => fake()->unique()->slug(2),
            'description_original' => fake()->sentence(),
            'description' => fake()->sentence(),
            'category' => fake()->randomElement(['badge', 'accessory', 'material', 'consumable']),
            'frame_id' => fake()->numberBetween(1, 100),
            'cost' => fake()->numberBetween(1, 1000),
            'currency_code' => fake()->numberBetween(0, 2),
            'effect_type' => fake()->numberBetween(0, 10),
            'effect_parameters' => [fake()->numberBetween(0, 9999)],
            'raw_values' => [fake()->numberBetween(0, 9999)],
        ];
    }
}
