<?php

namespace Database\Factories;

use App\Models\Item;
use App\Models\Pet;
use App\Models\PetEvolution;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<PetEvolution>
 */
class PetEvolutionFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        return [
            'from_pet_id' => Pet::factory(),
            'to_pet_id' => Pet::factory(),
            'item_id' => Item::factory(),
            'quantity' => fake()->numberBetween(1, 10),
            'materials' => null,
            'evolution_type' => 'evolution',
        ];
    }
}
