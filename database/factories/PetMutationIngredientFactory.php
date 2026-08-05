<?php

namespace Database\Factories;

use App\Models\Item;
use App\Models\PetMutationIngredient;
use App\Models\PetMutationRecipe;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<PetMutationIngredient>
 */
class PetMutationIngredientFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'pet_mutation_recipe_id' => PetMutationRecipe::factory(),
            'item_id' => Item::factory(),
            'quantity' => fake()->numberBetween(1, 10),
            'role' => PetMutationIngredient::ROLE_CORE,
            'position' => 0,
        ];
    }
}
