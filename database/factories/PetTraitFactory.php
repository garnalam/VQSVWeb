<?php

namespace Database\Factories;

use App\Models\Pet;
use App\Models\PetTrait;
use Illuminate\Database\Eloquent\Factories\Factory;

/**
 * @extends Factory<PetTrait>
 */
class PetTraitFactory extends Factory
{
    /**
     * Define the model's default state.
     *
     * @return array<string, mixed>
     */
    public function definition(): array
    {
        $slotType = fake()->randomElement([PetTrait::SLOT_PHYSICAL, PetTrait::SLOT_SPECIES]);

        return [
            'code' => fake()->unique()->bothify('TR-##??'),
            'name' => fake()->unique()->words(2, true),
            'slot_type' => $slotType,
            'species' => $slotType === PetTrait::SLOT_SPECIES
                ? fake()->randomElement(array_keys(Pet::SPECIES))
                : null,
            'polarity' => fake()->randomElement([
                PetTrait::POLARITY_NEUTRAL,
                PetTrait::POLARITY_BENEFICIAL,
                PetTrait::POLARITY_HARMFUL,
                PetTrait::POLARITY_MIXED,
            ]),
            'description' => fake()->sentence(),
            'parameters' => [],
            'roll_weight' => $slotType === PetTrait::SLOT_PHYSICAL ? 1 : 0,
            'is_cleanse_eligible' => $slotType === PetTrait::SLOT_PHYSICAL,
            'is_active' => true,
        ];
    }
}
