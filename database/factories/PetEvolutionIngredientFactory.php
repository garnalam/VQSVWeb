<?php

namespace Database\Factories;

use App\Models\Item;
use App\Models\PetEvolution;
use App\Models\PetEvolutionIngredient;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<PetEvolutionIngredient>
 */
class PetEvolutionIngredientFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'pet_evolution_id' => PetEvolution::factory(),
            'item_id' => Item::factory(),
            'quantity' => fake()->numberBetween(1, 3),
            'role' => PetEvolutionIngredient::ROLE_SPECIES,
            'position' => 0,
        ];
    }
}
