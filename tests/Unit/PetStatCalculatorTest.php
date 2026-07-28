<?php

use App\Models\Pet;
use App\Support\PetStatCalculator;

test('calculates the approved formula at neutral three stars', function () {
    $pet = new Pet([
        'hp_base' => 20,
        'hp_per_level' => 18,
        'hp_offset' => 0,
        'stat_2_base' => 10,
        'stat_2_per_level' => 4,
        'stat_2_offset' => 0,
        'stat_3_base' => 5,
        'stat_3_per_10_levels' => 21,
        'stat_3_offset' => 0,
        'stat_4_base' => 5,
        'stat_4_per_10_levels' => 4,
        'stat_4_offset' => 0,
    ]);

    expect((new PetStatCalculator)->calculate($pet, 50))->toBe([
        'hp' => 920,
        'strength' => 210,
        'defense' => 110,
        'agility' => 25,
    ]);
});

test('applies every star multiplier to the same species formula', function (int $star, array $expected) {
    $pet = new Pet([
        'hp_base' => 20,
        'hp_per_level' => 18,
        'hp_offset' => 0,
        'stat_2_base' => 10,
        'stat_2_per_level' => 4,
        'stat_2_offset' => 0,
        'stat_3_base' => 5,
        'stat_3_per_10_levels' => 21,
        'stat_3_offset' => 0,
        'stat_4_base' => 5,
        'stat_4_per_10_levels' => 4,
        'stat_4_offset' => 0,
    ]);

    expect((new PetStatCalculator)->calculate($pet, 50, $star))->toBe($expected);
})->with([
    'one star' => [1, ['hp' => 828, 'strength' => 189, 'defense' => 99, 'agility' => 22]],
    'two stars' => [2, ['hp' => 874, 'strength' => 199, 'defense' => 104, 'agility' => 23]],
    'three stars' => [3, ['hp' => 920, 'strength' => 210, 'defense' => 110, 'agility' => 25]],
    'four stars' => [4, ['hp' => 1012, 'strength' => 231, 'defense' => 121, 'agility' => 27]],
    'five stars' => [5, ['hp' => 1150, 'strength' => 262, 'defense' => 137, 'agility' => 31]],
]);

test('rejects levels and star qualities outside the combat contract', function (int $level, int $star) {
    $pet = new Pet([
        'hp_base' => 1,
        'hp_per_level' => 1,
        'hp_offset' => 0,
        'stat_2_base' => 1,
        'stat_2_per_level' => 1,
        'stat_2_offset' => 0,
        'stat_3_base' => 1,
        'stat_3_per_10_levels' => 1,
        'stat_3_offset' => 0,
        'stat_4_base' => 1,
        'stat_4_per_10_levels' => 1,
        'stat_4_offset' => 0,
    ]);

    expect(fn () => (new PetStatCalculator)->calculate($pet, $level, $star))
        ->toThrow(InvalidArgumentException::class);
})->with([
    'level below minimum' => [0, 3],
    'level above maximum' => [51, 3],
    'star below minimum' => [50, 0],
    'star above maximum' => [50, 6],
]);
