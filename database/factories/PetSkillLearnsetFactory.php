<?php

namespace Database\Factories;

use App\Models\Pet;
use App\Models\PetSkillLearnset;
use App\Models\Skill;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<PetSkillLearnset>
 */
class PetSkillLearnsetFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'pet_id' => Pet::factory(),
            'skill_id' => Skill::factory(),
            'unlock_level' => fake()->randomElement([5, 10, 20, 30, 40]),
            'source_type' => fake()->randomElement(['element', 'species', 'signature', 'universal']),
            'combat_role' => fake()->randomElement(array_keys(Pet::COMBAT_ROLES)),
            'is_signature' => false,
            'sort_order' => fake()->numberBetween(1, 20),
        ];
    }
}
