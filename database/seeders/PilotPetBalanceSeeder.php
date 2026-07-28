<?php

namespace Database\Seeders;

class PilotPetBalanceSeeder extends PetBalanceSeeder
{
    /**
     * @return array<string, array<int, array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}>>
     */
    protected function profiles(): array
    {
        return PilotPetBalanceData::profiles();
    }
}
