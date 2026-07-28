<?php

use App\Models\DivineAbility;
use App\Models\Pet;
use App\Models\Skill;
use App\Support\PetBattleSimulator;
use App\Support\PetPowerClassResolver;
use Database\Seeders\DatabaseSeeder;

use function Pest\Laravel\seed;

test('seeds one approved divine ability for every source-classified divine pet', function () {
    seed(DatabaseSeeder::class);

    $abilities = DivineAbility::query()
        ->with('pet.gameSource:id,slug')
        ->orderBy('code')
        ->get();
    $resolver = app(PetPowerClassResolver::class);

    expect($abilities)->toHaveCount(14)
        ->and($abilities->pluck('code')->all())->toEqualCanonicalizing([
            'astral-flow',
            'demon-king-descent',
            'heavenly-fate-seal',
            'heavenly-thunder-pursuit',
            'holy-tide-song',
            'immovable-war-god',
            'moonshadow-hunt',
            'myriad-blossom-domain',
            'nether-king-wrath',
            'phoenix-rebirth',
            'realm-breaking-strike',
            'sacred-light-cycle',
            'tidal-counter-armor',
            'underworld-judgment',
        ])
        ->and($abilities->every(fn (DivineAbility $ability): bool => $ability->is_active))->toBeTrue()
        ->and($abilities->every(fn (DivineAbility $ability): bool => $ability->parameters !== []))->toBeTrue()
        ->and($abilities->every(
            fn (DivineAbility $ability): bool => $resolver->resolve($ability->pet) === PetPowerClassResolver::DIVINE,
        ))->toBeTrue();
});

test('keeps divine abilities outside both trait and combat skill slots', function () {
    seed(DatabaseSeeder::class);

    $pets = Pet::query()
        ->with(['divineAbility', 'speciesTrait', 'learnsetEntries'])
        ->whereHas('divineAbility')
        ->get();

    expect($pets)->toHaveCount(14);

    foreach ($pets as $pet) {
        expect($pet->divineAbility)->not->toBeNull($pet->name)
            ->and($pet->speciesTrait)->not->toBeNull($pet->name)
            ->and($pet->learnsetEntries)->toHaveCount(10, $pet->name);
    }
});

test('executes the approved divine ability triggers without granting events to standard pets', function () {
    seed(DatabaseSeeder::class);

    $simulator = app(PetBattleSimulator::class);
    $divinePets = Pet::query()
        ->with(['divineAbility', 'speciesTrait', 'learnsetEntries.skill.effect'])
        ->whereHas('divineAbility')
        ->orderBy('id')
        ->get();
    $observedCodes = collect();

    foreach ($divinePets as $left) {
        foreach ($divinePets->where('id', '!=', $left->id) as $right) {
            for ($seed = 1; $seed <= 4; $seed++) {
                $result = $simulator->simulate(
                    $left,
                    array_values($left->learnsetEntries->pluck('skill')->filter(
                        fn (mixed $skill): bool => $skill instanceof Skill,
                    )->all()),
                    $right,
                    array_values($right->learnsetEntries->pluck('skill')->filter(
                        fn (mixed $skill): bool => $skill instanceof Skill,
                    )->all()),
                    ($left->id * 10000) + ($right->id * 10) + $seed,
                );

                $observedCodes = $observedCodes->concat(
                    collect($result['divine_ability_events'])->flatten(1)->pluck('code'),
                );
            }
        }
    }

    expect($observedCodes->unique()->values()->all())->toEqualCanonicalizing(
        $divinePets->pluck('divineAbility.code')->all(),
    );

    $standardPets = Pet::query()
        ->with(['divineAbility', 'speciesTrait', 'learnsetEntries.skill.effect'])
        ->whereDoesntHave('divineAbility')
        ->orderBy('id')
        ->take(2)
        ->get();
    $standardResult = $simulator->simulate(
        $standardPets[0],
        array_values($standardPets[0]->learnsetEntries->pluck('skill')->filter(
            fn (mixed $skill): bool => $skill instanceof Skill,
        )->all()),
        $standardPets[1],
        array_values($standardPets[1]->learnsetEntries->pluck('skill')->filter(
            fn (mixed $skill): bool => $skill instanceof Skill,
        )->all()),
        20260728,
    );

    expect(collect($standardResult['divine_ability_events'])->flatten(1))->toBeEmpty();
});
