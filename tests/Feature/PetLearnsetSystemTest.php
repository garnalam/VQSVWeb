<?php

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetSkillLearnset;
use App\Models\Skill;
use Database\Seeders\DatabaseSeeder;
use Illuminate\Support\Collection;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('assigns a combat identity and a curated learnset to all 202 pets', function () {
    $pets = Pet::query()->with('learnsetEntries')->get();

    expect($pets)->toHaveCount(202)
        ->and($pets->whereNull('primary_role'))->toBeEmpty()
        ->and($pets->whereNull('secondary_role'))->toBeEmpty()
        ->and($pets->whereNull('playstyle_summary'))->toBeEmpty()
        ->and($pets->pluck('primary_role')->unique()->diff(array_keys(Pet::COMBAT_ROLES)))->toBeEmpty()
        ->and($pets->where('preferred_battle_format', 'double')->count())->toBeGreaterThan(0)
        ->and(PetSkillLearnset::query()->count())->toBeGreaterThan(500);

    foreach ($pets as $pet) {
        expect($pet->learnsetEntries)->not->toBeEmpty();
    }
});

test('normalizes the shared active skill catalog without retaining rainbow energy costs', function () {
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $rainbowSpeciesSkills = Skill::query()
        ->whereBelongsTo($rainbow)
        ->whereBetween('game_id', [0, 24])
        ->get();

    expect(Skill::query()->count())->toBe(119)
        ->and(Skill::query()->whereBelongsTo($rainbow)->whereBetween('game_id', [31, 48])->where('is_active', false)->count())->toBe(18)
        ->and($rainbowSpeciesSkills)->toHaveCount(25)
        ->and($rainbowSpeciesSkills->whereNotNull('energy_cost'))->toBeEmpty()
        ->and($rainbowSpeciesSkills->pluck('max_uses')->unique()->sort()->values()->all())->toBe([15, 25, 30, 40, 45])
        ->and($rainbowSpeciesSkills->pluck('power_percent')->min())->toBeGreaterThanOrEqual(60)
        ->and($rainbowSpeciesSkills->pluck('power_percent')->max())->toBeLessThanOrEqual(190);
});

test('publishes only covered combat skills and reserves signature labels for one evolution family', function () {
    $activeSkills = Skill::query()
        ->with('learnsetEntries')
        ->where('is_active', true)
        ->get();
    $pets = Pet::query()->select(['id'])->get();
    $incoming = PetEvolution::query()
        ->get()
        ->groupBy('to_pet_id')
        ->map->pluck('from_pet_id');

    expect($activeSkills)->toHaveCount(99)
        ->and($activeSkills->whereIn('combat_category', ['fallback', 'capture', 'passive']))->toBeEmpty();

    foreach ($activeSkills as $skill) {
        expect($skill->learnsetEntries)->not->toBeEmpty();
    }

    $signatureSkills = $activeSkills->filter(
        fn (Skill $skill): bool => $skill->learnsetEntries->contains('is_signature', true),
    );

    expect($signatureSkills)->not->toBeEmpty();

    foreach ($signatureSkills as $skill) {
        $familyRootIds = $skill->learnsetEntries
            ->map(fn (PetSkillLearnset $entry): int => learnsetFamilyRootId($entry->pet_id, $incoming))
            ->unique();

        expect($skill->learnsetEntries->every('is_signature', true))->toBeTrue()
            ->and($familyRootIds)->toHaveCount(1);
    }

    expect($pets)->toHaveCount(202);
});

test('inherits ancestor skills and grants exactly ten cumulative skills at every final form', function () {
    $pets = Pet::query()->with('learnsetEntries')->get()->keyBy('id');
    $evolutions = PetEvolution::query()->get();
    $incoming = $evolutions->groupBy('to_pet_id')->map->pluck('from_pet_id');
    $outgoing = $evolutions->groupBy('from_pet_id')->map->pluck('to_pet_id');

    foreach ($pets as $pet) {
        $accessibleSkillIds = learnsetAccessibleSkillIds($pet->id, $pets, $incoming);
        $isFinalOrStandalone = ! $outgoing->has($pet->id);

        expect($accessibleSkillIds)->toHaveCount($isFinalOrStandalone ? 10 : count($accessibleSkillIds))
            ->and($accessibleSkillIds)->each->toBeInt();

        if ($incoming->has($pet->id)) {
            expect($pet->learnsetEntries)->not->toBeEmpty();
        }
    }

    expect(PetSkillLearnset::query()->whereNotIn('unlock_level', [5, 10, 20, 30, 40])->exists())->toBeFalse()
        ->and(PetSkillLearnset::query()->where('is_signature', true)->count())->toBeGreaterThan(0);
});

test('keeps mutation branch grants separate while preserving their shared ancestor pool', function () {
    $pets = Pet::query()->with('learnsetEntries')->get()->keyBy('id');
    $evolutions = PetEvolution::query()->get();
    $incoming = $evolutions->groupBy('to_pet_id')->map->pluck('from_pet_id');
    $branchingFamilies = $evolutions->groupBy('from_pet_id')->filter(fn ($targets): bool => $targets->count() > 1);

    expect($branchingFamilies)->not->toBeEmpty();

    foreach ($branchingFamilies as $fromPetId => $branches) {
        $ancestorSkills = learnsetAccessibleSkillIds((int) $fromPetId, $pets, $incoming);
        $branchGrantSets = $branches
            ->map(fn (PetEvolution $evolution): array => $pets[$evolution->to_pet_id]->learnsetEntries->pluck('skill_id')->all())
            ->values();

        foreach ($branchGrantSets as $branchGrants) {
            expect(array_intersect($ancestorSkills, $branchGrants))->toBeEmpty();
        }

        for ($left = 0; $left < $branchGrantSets->count(); $left++) {
            for ($right = $left + 1; $right < $branchGrantSets->count(); $right++) {
                expect(array_intersect($branchGrantSets[$left], $branchGrantSets[$right]))->toBeEmpty();
            }
        }
    }
});

test('gives double battle support pets ally interaction and disruptive options', function () {
    $supportPets = Pet::query()->where('primary_role', 'support')->get();
    $supportPetIds = $supportPets->pluck('id');
    $supportSkillIds = PetSkillLearnset::query()
        ->whereIn('pet_id', $supportPetIds)
        ->pluck('skill_id')
        ->unique();
    $supportSkills = Skill::query()->whereIn('id', $supportSkillIds)->get();

    expect($supportPets)->not->toBeEmpty()
        ->and($supportPets->where('preferred_battle_format', 'double'))->toHaveCount($supportPets->count())
        ->and($supportSkills->whereIn('target_pattern', ['self_or_ally', 'all_allies']))->not->toBeEmpty()
        ->and($supportSkills->whereIn('combat_category', ['control', 'disrupt']))->not->toBeEmpty();
});

test('can rebuild all learnsets repeatedly without creating duplicates', function () {
    $initialRows = PetSkillLearnset::query()->count();

    seed(DatabaseSeeder::class);

    expect(PetSkillLearnset::query()->count())->toBe($initialRows)
        ->and(PetSkillLearnset::query()
            ->selectRaw('pet_id, skill_id, COUNT(*) as aggregate')
            ->groupBy('pet_id', 'skill_id')
            ->having('aggregate', '>', 1)
            ->exists())->toBeFalse();
});

/**
 * @param  Collection<int, Pet>  $pets
 * @param  Collection<int, Collection<int, int>>  $incoming
 * @return list<int>
 */
function learnsetAccessibleSkillIds(
    int $petId,
    Collection $pets,
    Collection $incoming,
): array {
    $skillIds = [];
    $currentId = $petId;
    $visited = [];

    while (! isset($visited[$currentId])) {
        $visited[$currentId] = true;
        $skillIds = [
            ...$skillIds,
            ...$pets[$currentId]->learnsetEntries->pluck('skill_id')->all(),
        ];

        if (! $incoming->has($currentId)) {
            break;
        }

        $currentId = (int) $incoming[$currentId]->first();
    }

    return array_values(array_unique($skillIds));
}

/** @param Collection<int, Collection<int, int>> $incoming */
function learnsetFamilyRootId(int $petId, Collection $incoming): int
{
    $currentId = $petId;
    $visited = [];

    while ($incoming->has($currentId) && ! isset($visited[$currentId])) {
        $visited[$currentId] = true;
        $currentId = (int) $incoming[$currentId]->first();
    }

    return $currentId;
}
