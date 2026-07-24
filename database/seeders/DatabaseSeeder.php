<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;

class DatabaseSeeder extends Seeder
{
    use WithoutModelEvents;

    /**
     * Seed the application's database.
     */
    public function run(): void
    {
        $this->call(VqsvGameDataSeeder::class);
        $this->call(RainbowGameDataSeeder::class);
        $this->call(PetTraitSeeder::class);
        $this->call(PetLearnsetSeeder::class);
        $this->call(EvolutionRecipeSeeder::class);
    }
}
