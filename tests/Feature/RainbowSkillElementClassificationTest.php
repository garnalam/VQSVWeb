<?php

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetEvolution;
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
        2 => 'hoa',
        3 => 'phong',
        4 => 'moc',
        5 => 'tho',
        6 => 'tho',
        7 => 'hoa',
        8 => 'dien',
        9 => 'dien',
        10 => 'phong',
        11 => 'phong',
        12 => 'phong',
        13 => 'quy',
        14 => 'dien',
        15 => 'tho',
        16 => 'dien',
        17 => 'hoa',
        18 => 'tho',
        19 => 'hoa',
        20 => 'thuy',
        21 => 'thuy',
        22 => 'thuy',
        23 => 'thuy',
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
            ->and($skills[$gameId]->balance_version)->toBe('unified-v4')
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
        'dien' => 4,
        'hoa' => 4,
        'moc' => 5,
        'phong' => 4,
        'quy' => 4,
        'tho' => 4,
        'thuy' => 4,
    ]);
});

test('gives every terminal pet balanced access to the unified element and species pools', function () {
    seed(DatabaseSeeder::class);

    $parentByChild = PetEvolution::query()->pluck('from_pet_id', 'to_pet_id');
    $grantsByPet = PetSkillLearnset::query()
        ->with(['pet', 'skill.gameSource:id,slug'])
        ->get()
        ->groupBy('pet_id');
    $terminalPets = Pet::query()->doesntHave('evolutions')->get();

    expect($terminalPets)->not->toBeEmpty();

    foreach ($terminalPets as $pet) {
        $lineageIds = [$pet->id];
        $currentPetId = $pet->id;

        while ($parentByChild->has($currentPetId)) {
            $currentPetId = (int) $parentByChild->get($currentPetId);
            $lineageIds[] = $currentPetId;
        }

        $skills = collect($lineageIds)
            ->flatMap(fn (int $petId) => $grantsByPet->get($petId, collect()))
            ->pluck('skill')
            ->unique('id')
            ->values();
        $sourceCounts = $skills->countBy(function (Skill $skill) use ($pet): string {
            if ($skill->gameSource->slug === 'cau-vong' && $skill->game_id >= 25) {
                return 'universal';
            }

            if ($skill->species_affinity === $pet->species) {
                return 'species';
            }

            return $skill->combat_element === $pet->combat_element ? 'element' : 'universal';
        });

        expect($skills)->toHaveCount(10)
            ->and($sourceCounts->get('element', 0))->toBeGreaterThanOrEqual(3, $pet->name)
            ->and($sourceCounts->get('species', 0))->toBeGreaterThanOrEqual(3, $pet->name);
    }

    $crossSpeciesElementGrants = $grantsByPet
        ->flatten(1)
        ->filter(fn (PetSkillLearnset $grant): bool => $grant->skill->gameSource->slug === 'cau-vong'
            && $grant->skill->species_affinity !== null
            && $grant->skill->species_affinity !== $grant->pet->species
            && $grant->skill->combat_element === $grant->pet->combat_element);

    expect($crossSpeciesElementGrants)->not->toBeEmpty()
        ->and($crossSpeciesElementGrants->every(
            fn (PetSkillLearnset $grant): bool => $grant->source_type === 'element',
        ))->toBeTrue();
});
