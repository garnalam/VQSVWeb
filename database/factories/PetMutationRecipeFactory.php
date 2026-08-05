<?php

namespace Database\Factories;

use App\Models\Pet;
use App\Models\PetMutationRecipe;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<PetMutationRecipe>
 */
class PetMutationRecipeFactory extends Factory
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
            'status' => 'active',
            'notes' => fake()->sentence(),
        ];
    }
}
