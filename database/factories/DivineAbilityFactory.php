<?php

namespace Database\Factories;

use App\Models\DivineAbility;
use App\Models\Pet;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<DivineAbility>
 */
class DivineAbilityFactory extends Factory
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
            'code' => fake()->unique()->bothify('divine-ability-##??'),
            'name' => fake()->unique()->words(3, true),
            'activation_type' => fake()->randomElement(['passive', 'threshold', 'cycle', 'revival']),
            'description' => fake()->sentence(),
            'parameters' => [],
            'is_active' => true,
        ];
    }
}
