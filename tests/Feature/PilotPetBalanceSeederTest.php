<?php

use App\Models\GameSource;
use App\Models\Pet;
use App\Support\PetStatCalculator;
use Database\Seeders\DatabaseSeeder;
use Database\Seeders\PilotPetBalanceData;
use Inertia\Testing\AssertableInertia as Assert;

use function Pest\Laravel\seed;

test('seeds all thirty five approved pilot forms at their exact three star targets', function () {
    seed(DatabaseSeeder::class);

    $expectedTargets = pilotLevelFiftyTargets();
    $calculator = app(PetStatCalculator::class);

    expect($expectedTargets)->toHaveCount(35)
        ->and(PilotPetBalanceData::profiles()['liet-hoa'])->toHaveCount(14)
        ->and(PilotPetBalanceData::profiles()['cau-vong'])->toHaveCount(21);

    foreach ($expectedTargets as $identity => $expectedStats) {
        [$sourceSlug, $gameId] = explode(':', $identity);
        $profile = PilotPetBalanceData::for($sourceSlug, (int) $gameId);
        $gameSource = GameSource::query()->where('slug', $sourceSlug)->firstOrFail();
        $pet = Pet::query()
            ->with('speciesTrait')
            ->whereBelongsTo($gameSource)
            ->where('game_id', (int) $gameId)
            ->firstOrFail();

        expect($pet->combat_element)->toBe($profile['combat_element'], $identity)
            ->and($pet->species)->toBe($profile['species'], $identity)
            ->and($pet->primary_role)->toBe($profile['primary_role'], $identity)
            ->and($pet->secondary_role)->toBe($profile['secondary_role'], $identity)
            ->and($pet->speciesTrait?->code)->toBe($profile['species_trait_code'], $identity)
            ->and($pet->hp_offset)->toBe(0, $identity)
            ->and($pet->stat_2_offset)->toBe(0, $identity)
            ->and($pet->stat_3_offset)->toBe(0, $identity)
            ->and($pet->stat_4_offset)->toBe(0, $identity)
            ->and($pet->raw_values)->not->toBeNull($identity)
            ->and($calculator->calculate($pet, 50))->toBe($expectedStats, $identity);
    }
});

test('wiki exposes neutral three star previews independently from source quality tiers', function () {
    seed(DatabaseSeeder::class);

    $source = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $pet = Pet::query()->whereBelongsTo($source)->where('game_id', 68)->firstOrFail();

    $this->get(route('wiki.pets.show', $pet))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/pets/show')
            ->where('pet.default_star', 3)
            ->where('pet.star_multipliers', ['1' => 90, '2' => 95, '3' => 100, '4' => 110, '5' => 125])
            ->where('pet.stats.hp.base', 20)
            ->where('pet.stats.hp.per_level', 18));
});

/** @return array<string, array{hp: int, strength: int, defense: int, agility: int}> */
function pilotLevelFiftyTargets(): array
{
    return [
        'liet-hoa:6' => ['hp' => 820, 'strength' => 229, 'defense' => 100, 'agility' => 20],
        'liet-hoa:7' => ['hp' => 930, 'strength' => 250, 'defense' => 110, 'agility' => 24],
        'liet-hoa:8' => ['hp' => 1100, 'strength' => 340, 'defense' => 125, 'agility' => 25],
        'liet-hoa:16' => ['hp' => 792, 'strength' => 327, 'defense' => 100, 'agility' => 22],
        'liet-hoa:17' => ['hp' => 947, 'strength' => 273, 'defense' => 120, 'agility' => 25],
        'liet-hoa:18' => ['hp' => 1050, 'strength' => 285, 'defense' => 132, 'agility' => 22],
        'liet-hoa:41' => ['hp' => 705, 'strength' => 230, 'defense' => 79, 'agility' => 18],
        'liet-hoa:42' => ['hp' => 1120, 'strength' => 382, 'defense' => 140, 'agility' => 16],
        'liet-hoa:51' => ['hp' => 1050, 'strength' => 250, 'defense' => 109, 'agility' => 23],
        'liet-hoa:52' => ['hp' => 1298, 'strength' => 258, 'defense' => 125, 'agility' => 25],
        'liet-hoa:53' => ['hp' => 1320, 'strength' => 310, 'defense' => 145, 'agility' => 22],
        'liet-hoa:68' => ['hp' => 920, 'strength' => 246, 'defense' => 110, 'agility' => 25],
        'liet-hoa:69' => ['hp' => 1188, 'strength' => 325, 'defense' => 135, 'agility' => 34],
        'liet-hoa:99' => ['hp' => 1650, 'strength' => 390, 'defense' => 135, 'agility' => 48],
        'cau-vong:4' => ['hp' => 662, 'strength' => 234, 'defense' => 97, 'agility' => 23],
        'cau-vong:5' => ['hp' => 1050, 'strength' => 250, 'defense' => 140, 'agility' => 28],
        'cau-vong:6' => ['hp' => 900, 'strength' => 385, 'defense' => 110, 'agility' => 31],
        'cau-vong:17' => ['hp' => 760, 'strength' => 220, 'defense' => 89, 'agility' => 20],
        'cau-vong:18' => ['hp' => 880, 'strength' => 353, 'defense' => 120, 'agility' => 23],
        'cau-vong:19' => ['hp' => 1030, 'strength' => 355, 'defense' => 140, 'agility' => 24],
        'cau-vong:20' => ['hp' => 1200, 'strength' => 346, 'defense' => 150, 'agility' => 26],
        'cau-vong:25' => ['hp' => 676, 'strength' => 205, 'defense' => 82, 'agility' => 20],
        'cau-vong:26' => ['hp' => 929, 'strength' => 254, 'defense' => 108, 'agility' => 22],
        'cau-vong:27' => ['hp' => 1159, 'strength' => 321, 'defense' => 127, 'agility' => 25],
        'cau-vong:36' => ['hp' => 680, 'strength' => 298, 'defense' => 90, 'agility' => 25],
        'cau-vong:37' => ['hp' => 820, 'strength' => 347, 'defense' => 100, 'agility' => 30],
        'cau-vong:38' => ['hp' => 980, 'strength' => 350, 'defense' => 110, 'agility' => 34],
        'cau-vong:39' => ['hp' => 1150, 'strength' => 304, 'defense' => 125, 'agility' => 39],
        'cau-vong:49' => ['hp' => 720, 'strength' => 253, 'defense' => 85, 'agility' => 25],
        'cau-vong:50' => ['hp' => 980, 'strength' => 442, 'defense' => 95, 'agility' => 35],
        'cau-vong:51' => ['hp' => 1080, 'strength' => 316, 'defense' => 140, 'agility' => 31],
        'cau-vong:68' => ['hp' => 765, 'strength' => 227, 'defense' => 106, 'agility' => 18],
        'cau-vong:69' => ['hp' => 993, 'strength' => 302, 'defense' => 129, 'agility' => 19],
        'cau-vong:70' => ['hp' => 1234, 'strength' => 322, 'defense' => 131, 'agility' => 18],
        'cau-vong:71' => ['hp' => 1504, 'strength' => 310, 'defense' => 148, 'agility' => 16],
    ];
}
