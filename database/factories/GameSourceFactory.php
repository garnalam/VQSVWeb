<?php

namespace Database\Factories;

use App\Models\GameSource;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<GameSource>
 */
class GameSourceFactory extends Factory
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
            'name' => $name,
            'slug' => fake()->unique()->slug(2),
            'asset_key' => fake()->unique()->slug(2),
            'color' => fake()->hexColor(),
        ];
    }
}
