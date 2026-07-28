<?php

namespace Database\Seeders;

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetTrait;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use UnexpectedValueException;

class PetBalanceSeeder extends Seeder
{
    use WithoutModelEvents;

    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::transaction(function (): void {
            $traits = PetTrait::query()->get()->keyBy('code');

            foreach ($this->profiles() as $sourceSlug => $profiles) {
                $gameSource = GameSource::query()->where('slug', $sourceSlug)->firstOrFail();

                foreach ($profiles as $gameId => $profile) {
                    $pet = Pet::query()
                        ->whereBelongsTo($gameSource)
                        ->where('game_id', $gameId)
                        ->firstOrFail();
                    $trait = $traits->get($profile['species_trait_code']) ?? throw new UnexpectedValueException(
                        "Missing species trait {$profile['species_trait_code']}.",
                    );

                    if ($trait->species !== $profile['species']) {
                        throw new UnexpectedValueException(
                            "Trait {$trait->code} does not match Pet {$sourceSlug}:{$gameId} species {$profile['species']}.",
                        );
                    }

                    $pet->fill([
                        'combat_element' => $profile['combat_element'],
                        'species' => $profile['species'],
                        'primary_role' => $profile['primary_role'],
                        'secondary_role' => $profile['secondary_role'],
                        'preferred_battle_format' => $profile['primary_role'] === 'support' ? 'double' : 'any',
                        'playstyle_summary' => $this->playstyleSummary($profile['primary_role'], $profile['secondary_role']),
                        'hp_base' => $profile['hp_base'],
                        'hp_per_level' => $profile['hp_growth'],
                        'hp_offset' => 0,
                        'energy_base' => null,
                        'energy_per_10_levels' => null,
                        'stat_2_base' => $profile['strength_base'],
                        'stat_2_per_level' => $profile['strength_growth'],
                        'stat_2_offset' => 0,
                        'stat_3_base' => $profile['defense_base'],
                        'stat_3_per_10_levels' => $profile['defense_growth'],
                        'stat_3_offset' => 0,
                        'stat_4_base' => $profile['agility_base'],
                        'stat_4_per_10_levels' => $profile['agility_growth'],
                        'stat_4_offset' => 0,
                    ]);
                    $pet->speciesTrait()->associate($trait);
                    $pet->save();
                }
            }
        });
    }

    /**
     * @return array<string, array<int, array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}>>
     */
    protected function profiles(): array
    {
        return PetBalanceData::profiles();
    }

    private function playstyleSummary(string $primaryRole, string $secondaryRole): string
    {
        return sprintf(
            'Thiên về %s, dùng hướng %s để bù điểm yếu và mở rộng lựa chọn chiến thuật.',
            mb_strtolower(Pet::COMBAT_ROLES[$primaryRole]),
            mb_strtolower(Pet::COMBAT_ROLES[$secondaryRole]),
        );
    }
}
