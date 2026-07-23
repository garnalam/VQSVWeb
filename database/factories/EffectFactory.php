<?php

namespace Database\Factories;

use App\Models\Effect;
use App\Models\GameSource;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<Effect>
 */
class EffectFactory extends Factory
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
            'source_table' => fake()->randomElement([6, 7]),
            'game_id' => fake()->unique()->numberBetween(0, 255),
            'kind' => fake()->randomElement(['beneficial', 'harmful']),
            'name_original' => $name,
            'name' => $name,
            'description' => fake()->sentence(),
            'duration' => fake()->numberBetween(1, 5),
            'parameters' => [fake()->numberBetween(-1, 200)],
            'raw_values' => [fake()->numberBetween(-1, 200)],
        ];
    }
}
