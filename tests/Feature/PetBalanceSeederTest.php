<?php

use App\Models\Pet;
use App\Models\PetEvolution;
use App\Support\PetCombatBudget;
use App\Support\PetPowerClassResolver;
use App\Support\PetStatCalculator;
use Database\Seeders\DatabaseSeeder;
use Database\Seeders\PetBalanceData;
use Database\Seeders\PilotPetBalanceData;
use Database\Seeders\RemainingPetBalanceData;

use function Pest\Laravel\seed;

test('defines a unique approved balance profile for all 202 pets', function () {
    $pilotProfiles = PilotPetBalanceData::profiles();
    $remainingProfiles = RemainingPetBalanceData::profiles();
    $allProfiles = PetBalanceData::profiles();

    expect($pilotProfiles['liet-hoa'])->toHaveCount(14)
        ->and($pilotProfiles['cau-vong'])->toHaveCount(21)
        ->and($remainingProfiles['liet-hoa'])->toHaveCount(86)
        ->and($remainingProfiles['cau-vong'])->toHaveCount(81)
        ->and($allProfiles['liet-hoa'])->toHaveCount(100)
        ->and($allProfiles['cau-vong'])->toHaveCount(102)
        ->and(array_keys($allProfiles['liet-hoa']))->toBe(range(0, 99))
        ->and(array_keys($allProfiles['cau-vong']))->toBe(range(0, 101))
        ->and(array_intersect_key($pilotProfiles['liet-hoa'], $remainingProfiles['liet-hoa']))->toBe([])
        ->and(array_intersect_key($pilotProfiles['cau-vong'], $remainingProfiles['cau-vong']))->toBe([]);
});

test('seeds the complete balance design while preserving decoded source values', function () {
    seed(DatabaseSeeder::class);

    $calculator = app(PetStatCalculator::class);
    $pets = Pet::query()
        ->with(['gameSource:id,slug', 'speciesTrait:id,code,species'])
        ->get()
        ->keyBy(fn (Pet $pet): string => "{$pet->gameSource->slug}:{$pet->game_id}");

    expect($pets)->toHaveCount(202);

    foreach (PetBalanceData::profiles() as $source => $profiles) {
        foreach ($profiles as $gameId => $profile) {
            $identity = "{$source}:{$gameId}";
            $pet = $pets->get($identity);

            expect($pet)->not->toBeNull($identity)
                ->and($pet->combat_element)->toBe($profile['combat_element'], $identity)
                ->and($pet->species)->toBe($profile['species'], $identity)
                ->and($pet->primary_role)->toBe($profile['primary_role'], $identity)
                ->and($pet->secondary_role)->toBe($profile['secondary_role'], $identity)
                ->and($pet->speciesTrait?->code)->toBe($profile['species_trait_code'], $identity)
                ->and($pet->speciesTrait?->species)->toBe($profile['species'], $identity)
                ->and($pet->energy_base)->toBeNull($identity)
                ->and($pet->energy_per_10_levels)->toBeNull($identity)
                ->and($pet->raw_values)->not->toBeNull($identity)
                ->and($calculator->calculate($pet, 50))->toBe([
                    'hp' => $profile['hp_base'] + $profile['hp_growth'] * 50,
                    'strength' => $profile['strength_base'] + $profile['strength_growth'] * 50,
                    'defense' => $profile['defense_base'] + $profile['defense_growth'] * 5,
                    'agility' => $profile['agility_base'] + $profile['agility_growth'] * 5,
                ], $identity);
        }
    }

    foreach ([
        'liet-hoa:15' => ['hp' => 1550, 'strength' => 410, 'defense' => 145, 'agility' => 42],
        'liet-hoa:31' => ['hp' => 1500, 'strength' => 350, 'defense' => 150, 'agility' => 40],
        'liet-hoa:47' => ['hp' => 1700, 'strength' => 370, 'defense' => 195, 'agility' => 23],
        'liet-hoa:63' => ['hp' => 1650, 'strength' => 380, 'defense' => 190, 'agility' => 24],
        'liet-hoa:75' => ['hp' => 1500, 'strength' => 430, 'defense' => 145, 'agility' => 43],
        'liet-hoa:87' => ['hp' => 1650, 'strength' => 410, 'defense' => 175, 'agility' => 32],
        'liet-hoa:99' => ['hp' => 1650, 'strength' => 390, 'defense' => 135, 'agility' => 48],
        'cau-vong:85' => ['hp' => 1750, 'strength' => 380, 'defense' => 175, 'agility' => 40],
        'cau-vong:86' => ['hp' => 1600, 'strength' => 430, 'defense' => 150, 'agility' => 44],
        'cau-vong:89' => ['hp' => 1550, 'strength' => 360, 'defense' => 180, 'agility' => 38],
        'cau-vong:92' => ['hp' => 1600, 'strength' => 430, 'defense' => 185, 'agility' => 31],
        'cau-vong:95' => ['hp' => 1675, 'strength' => 390, 'defense' => 165, 'agility' => 43],
        'cau-vong:98' => ['hp' => 1705, 'strength' => 420, 'defense' => 155, 'agility' => 44],
        'cau-vong:101' => ['hp' => 1600, 'strength' => 375, 'defense' => 175, 'agility' => 40],
    ] as $identity => $expectedStats) {
        expect($calculator->calculate($pets->get($identity), 50))->toBe($expectedStats, $identity);
    }

    $powerClassResolver = app(PetPowerClassResolver::class);
    $combatBudget = app(PetCombatBudget::class);
    $combatScoresByPowerClass = $pets
        ->groupBy(fn (Pet $pet): string => $powerClassResolver->resolve($pet))
        ->map(fn ($powerClassPets) => $powerClassPets->map(
            fn (Pet $pet): float => $combatBudget->score($calculator->calculate($pet, 50)),
        ));

    expect($combatScoresByPowerClass->get(PetPowerClassResolver::DIVINE))->toHaveCount(14)
        ->and($combatScoresByPowerClass->get(PetPowerClassResolver::DIVINE)->min())
        ->toBeGreaterThan($combatScoresByPowerClass->get(PetPowerClassResolver::STANDARD)->max());
});

test('keeps evolution lines progressive without flattening combat roles', function () {
    seed(DatabaseSeeder::class);

    $calculator = app(PetStatCalculator::class);
    $evolutions = PetEvolution::query()->with(['sourcePet', 'targetPet'])->get();

    expect($evolutions)->not->toBeEmpty();

    foreach ($evolutions as $evolution) {
        $fromStats = $calculator->calculate($evolution->sourcePet, 50);
        $toStats = $calculator->calculate($evolution->targetPet, 50);
        $identity = "{$evolution->sourcePet->name} -> {$evolution->targetPet->name}";

        expect(petCombatScore($toStats))->toBeGreaterThan(petCombatScore($fromStats), $identity);
    }

    $uniqueStatProfiles = Pet::query()
        ->get()
        ->map(fn (Pet $pet): string => implode(':', $calculator->calculate($pet, 50)))
        ->unique();
    $primaryRoleCounts = Pet::query()->selectRaw('primary_role, COUNT(*) AS aggregate')->groupBy('primary_role')->pluck('aggregate', 'primary_role');
    $speciesElementCoverage = Pet::query()->get()->groupBy('species')->map(
        fn ($pets): int => $pets->pluck('combat_element')->unique()->count(),
    );

    expect($uniqueStatProfiles)->toHaveCount(202)
        ->and($primaryRoleCounts->keys()->sort()->values()->all())->toBe([
            'bruiser',
            'controller',
            'guardian',
            'striker',
            'support',
            'versatile',
        ]);

    foreach ($primaryRoleCounts as $role => $count) {
        $minimumCount = $role === 'versatile' ? 5 : 10;

        expect((int) $count)->toBeGreaterThanOrEqual($minimumCount, $role);
    }

    foreach ($speciesElementCoverage as $species => $elementCount) {
        expect($elementCount)->toBeGreaterThanOrEqual(5, $species);
    }
});

/** @param array{hp: int, strength: int, defense: int, agility: int} $stats */
function petCombatScore(array $stats): int
{
    return (int) round(app(PetCombatBudget::class)->score($stats));
}
