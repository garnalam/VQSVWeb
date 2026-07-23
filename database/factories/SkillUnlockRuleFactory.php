<?php

namespace Database\Factories;

use App\Models\GameSource;
use App\Models\SkillUnlockRule;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<SkillUnlockRule>
 */
class SkillUnlockRuleFactory extends Factory
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
            'learning_group' => fake()->numberBetween(0, 3),
            'level' => fake()->randomElement([5, 10, 20, 30, 40]),
            'maximum_skill_tier' => fake()->numberBetween(0, 3),
        ];
    }
}
