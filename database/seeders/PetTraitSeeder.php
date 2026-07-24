<?php

namespace Database\Seeders;

use App\Models\GameSource;
use App\Models\PetTrait;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use UnexpectedValueException;

class PetTraitSeeder extends Seeder
{
    use WithoutModelEvents;

    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::transaction(function (): void {
            foreach (PetTraitData::definitions() as $definition) {
                PetTrait::query()->updateOrCreate(
                    ['code' => $definition['code']],
                    $definition,
                );
            }

            $traitsByCode = PetTrait::query()
                ->select(['id', 'code', 'species'])
                ->get()
                ->keyBy('code');

            $gameSources = GameSource::query()
                ->select(['id', 'slug'])
                ->whereIn('slug', ['liet-hoa', 'cau-vong'])
                ->with(['pets:id,game_source_id,game_id,species,species_trait_id'])
                ->get();

            foreach ($gameSources as $gameSource) {
                foreach ($gameSource->pets as $pet) {
                    $traitCode = PetTraitData::speciesTraitCode($gameSource->slug, $pet->game_id);
                    $trait = $traitsByCode->get($traitCode) ?? throw new UnexpectedValueException(
                        "Missing seeded trait {$traitCode}.",
                    );

                    if ($trait->species !== $pet->species) {
                        throw new UnexpectedValueException(
                            "Trait {$traitCode} does not belong to Pet {$gameSource->slug}:{$pet->game_id} species {$pet->species}.",
                        );
                    }

                    $pet->speciesTrait()->associate($trait);
                    $pet->save();
                }
            }
        });
    }
}
