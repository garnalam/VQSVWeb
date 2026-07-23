<?php

namespace Database\Factories;

use App\Models\Element;
use App\Models\GameSource;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<Element>
 */
class ElementFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'game_source_id' => GameSource::factory(),
            'game_id' => fake()->unique()->numberBetween(0, 255),
            'name' => fake()->unique()->word(),
            'slug' => fake()->unique()->slug(2),
            'color' => fake()->hexColor(),
            'icon_path' => null,
        ];
    }
}
