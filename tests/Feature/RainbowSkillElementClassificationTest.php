<?php

use App\Models\GameSource;
use App\Models\PetSkillLearnset;
use App\Models\Skill;
use Database\Seeders\DatabaseSeeder;

use function Pest\Laravel\seed;

test('classifies rainbow species skills across all seven combat elements', function () {
    seed(DatabaseSeeder::class);

    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $expectedElements = [
        0 => 'moc',
        1 => 'moc',
        2 => 'moc',
        3 => 'moc',
        4 => 'moc',
        5 => 'tho',
        6 => 'tho',
        7 => 'dien',
        8 => 'dien',
        9 => 'tho',
        10 => 'phong',
        11 => 'phong',
        12 => 'phong',
        13 => 'phong',
        14 => 'dien',
        15 => 'tho',
        16 => 'dien',
        17 => 'hoa',
        18 => 'hoa',
        19 => 'hoa',
        20 => 'quy',
        21 => 'quy',
        22 => 'hoa',
        23 => 'quy',
        24 => 'quy',
    ];

    $skills = Skill::query()
        ->whereBelongsTo($rainbow)
        ->whereBetween('game_id', [0, 24])
        ->orderBy('game_id')
        ->get()
        ->keyBy('game_id');

    expect($skills)->toHaveCount(25);

    foreach ($expectedElements as $gameId => $element) {
        expect($skills[$gameId]->combat_element)->toBe($element)
            ->and($skills[$gameId]->species_affinity)->not->toBeNull()
            ->and($skills[$gameId]->balance_version)->toBe('unified-v7')
            ->and($skills[$gameId]->is_active)->toBeTrue();
    }
});

test('keeps the complete active rainbow pool balanced after special skills are included', function () {
    seed(DatabaseSeeder::class);

    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $distribution = Skill::query()
        ->whereBelongsTo($rainbow)
        ->where('is_active', true)
        ->selectRaw('combat_element, count(*) as aggregate')
        ->groupBy('combat_element')
        ->pluck('aggregate', 'combat_element')
        ->map(fn (mixed $count): int => (int) $count)
        ->all();
    ksort($distribution);

    expect($distribution)->toBe([
        'dien' => 5,
        'hoa' => 5,
        'moc' => 5,
        'phong' => 4,
        'quy' => 5,
        'tho' => 5,
        'thuy' => 4,
    ]);
});

test('gives every pet the three approved v3 source classifications', function () {
    seed(DatabaseSeeder::class);

    $grantsByPet = PetSkillLearnset::query()
        ->with(['pet', 'skill.gameSource:id,slug'])
        ->get()
        ->groupBy('pet_id');

    expect($grantsByPet)->toHaveCount(274);

    foreach ($grantsByPet as $grants) {
        expect($grants->pluck('source_type')->unique()->sort()->values()->all())->toBe([
            'element',
            'species',
            'style',
        ]);
    }

    expect($grantsByPet->flatten(1)->countBy('source_type')->sortKeys()->all())->toBe([
        'element' => 779,
        'species' => 779,
        'style' => 779,
    ]);
});
