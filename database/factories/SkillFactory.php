<?php

namespace Database\Factories;

use App\Models\Element;
use App\Models\GameSource;
use App\Models\Skill;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<Skill>
 */
class SkillFactory extends Factory
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
            'effect_id' => null,
            'name_original' => $name,
            'name' => $name,
            'slug' => fake()->unique()->slug(2),
            'description_original' => fake()->sentence(),
            'description' => fake()->sentence(),
            'power_percent' => fake()->numberBetween(0, 300),
            'tier' => fake()->numberBetween(0, 3),
            'max_uses' => fake()->numberBetween(1, 50),
            'effect_mode' => 0,
            'effect_parameter' => null,
            'target_side' => fake()->numberBetween(0, 1),
            'raw_values' => [fake()->numberBetween(0, 100)],
        ];
    }
}
