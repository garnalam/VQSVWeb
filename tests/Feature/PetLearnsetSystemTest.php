<?php

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetSkillLearnset;
use App\Models\Skill;
use App\Support\SkillBalance;
use Database\Seeders\DatabaseSeeder;
use Illuminate\Support\Collection;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('assigns a combat identity and a curated learnset to all 274 pets', function () {
    $pets = Pet::query()->with('learnsetEntries')->get();

    expect($pets)->toHaveCount(274)
        ->and($pets->whereNull('primary_role'))->toBeEmpty()
        ->and($pets->whereNull('secondary_role'))->toBeEmpty()
        ->and($pets->whereNull('playstyle_summary'))->toBeEmpty()
        ->and($pets->pluck('primary_role')->unique()->diff(array_keys(Pet::COMBAT_ROLES)))->toBeEmpty()
        ->and($pets->where('preferred_battle_format', 'double')->count())->toBeGreaterThan(0)
        ->and(PetSkillLearnset::query()->count())->toBe(1880);

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

    expect(Skill::query()->count())->toBe(166)
        ->and(Skill::query()->whereBelongsTo($rainbow)->whereBetween('game_id', [33, 48])->where('is_active', false)->count())->toBe(16)
        ->and($rainbowSpeciesSkills)->toHaveCount(25)
        ->and($rainbowSpeciesSkills->whereNotNull('energy_cost'))->toBeEmpty()
        ->and(Skill::query()->where('is_active', true)->distinct()->pluck('balance_version')->all())->toBe([SkillBalance::VERSION])
        ->and($rainbowSpeciesSkills->pluck('max_uses')->unique()->sort()->values()->all())->toBe([5, 8, 12, 14, 15, 18, 20, 22, 25])
        ->and($rainbowSpeciesSkills->pluck('power_percent')->min())->toBeGreaterThanOrEqual(60)
        ->and($rainbowSpeciesSkills->pluck('power_percent')->max())->toBeLessThanOrEqual(185);
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

    expect($activeSkills)->toHaveCount(136)
        ->and($activeSkills->whereIn('combat_category', ['fallback', 'capture', 'passive']))->toBeEmpty();

    foreach ($activeSkills as $skill) {
        expect($skill->learnsetEntries)->not->toBeEmpty();
    }

    $signatureSkills = $activeSkills->filter(
        fn (Skill $skill): bool => $skill->learnsetEntries->contains('is_signature', true),
    );

    expect($signatureSkills)->not->toBeEmpty();

    foreach ($signatureSkills as $skill) {
        $signatureGrants = $skill->learnsetEntries->where('is_signature', true);
        $familyRootIds = $signatureGrants
            ->map(fn (PetSkillLearnset $entry): int => learnsetFamilyRootId($entry->pet_id, $incoming))
            ->unique();

        expect($signatureGrants)->not->toBeEmpty()
            ->and($familyRootIds)->toHaveCount(1);
    }

    $signatureEntry = PetSkillLearnset::query()
        ->with(['skill.gameSource:id,slug', 'pet.gameSource:id,slug'])
        ->where('is_signature', true)
        ->sole();

    expect($signatureEntry->skill->gameSource->slug)->toBe('cau-vong')
        ->and($signatureEntry->skill->game_id)->toBe(19)
        ->and($signatureEntry->pet->gameSource->slug)->toBe('liet-hoa')
        ->and($signatureEntry->pet->game_id)->toBe(8);

    expect($pets)->toHaveCount(274);
});

test('inherits ancestor skills and grants exactly ten cumulative skills at every final form', function () {
    $pets = Pet::query()
        ->with('learnsetEntries')
        ->whereHas('gameSource', fn ($query) => $query->where('slug', '!=', 'vqsv4'))
        ->get()
        ->keyBy('id');
    $evolutions = PetEvolution::query()->whereIn('from_pet_id', $pets->keys())->get();
    $incoming = $evolutions->groupBy('to_pet_id')->map->pluck('from_pet_id');
    $outgoing = $evolutions->groupBy('from_pet_id')->map->pluck('to_pet_id');
    $familyMetadata = learnsetFamilyMetadata($pets, $incoming);

    foreach ($pets as $pet) {
        $accessibleSkillIds = learnsetAccessibleSkillIds($pet->id, $pets, $incoming);
        $isFinalOrStandalone = ! $outgoing->has($pet->id);
        $expectedPoolSize = learnsetExpectedPoolSize($familyMetadata[$pet->id], $isFinalOrStandalone);

        expect($accessibleSkillIds)->toHaveCount($expectedPoolSize, $pet->name)
            ->and($accessibleSkillIds)->each->toBeInt();

        if ($incoming->has($pet->id)) {
            expect($pet->learnsetEntries)->not->toBeEmpty();
        }
    }

    $legacyLearnsets = PetSkillLearnset::query()
        ->whereHas('pet.gameSource', fn ($query) => $query->where('slug', '!=', 'vqsv4'));

    expect((clone $legacyLearnsets)->whereNotIn('unlock_level', learnsetMilestones())->exists())->toBeFalse()
        ->and((clone $legacyLearnsets)->distinct()->pluck('unlock_level')->sort()->values()->all())->toBe(learnsetMilestones())
        ->and(PetSkillLearnset::query()->where('is_signature', true)->count())->toBeGreaterThan(0);
});

test('builds every pet pool from element species and role appropriate tactical skills', function () {
    $pets = Pet::query()
        ->with('learnsetEntries')
        ->whereHas('gameSource', fn ($query) => $query->where('slug', '!=', 'vqsv4'))
        ->get()
        ->keyBy('id');
    $skills = Skill::query()->with('gameSource:id,slug')->get()->keyBy('id');
    $evolutions = PetEvolution::query()->whereIn('from_pet_id', $pets->keys())->get();
    $incoming = $evolutions->groupBy('to_pet_id')->map->pluck('from_pet_id');
    $outgoingPetIds = $evolutions->pluck('from_pet_id')->unique();
    $poolSignatures = [];

    expect($pets->whereNotIn('id', $outgoingPetIds))->toHaveCount(118);

    foreach ($pets as $pet) {
        $entries = learnsetAccessibleEntries($pet->id, $pets, $incoming);
        $pool = $skills->whereIn('id', $entries->pluck('skill_id'));
        $identity = "{$pet->gameSource->slug}:{$pet->game_id} {$pet->name}";
        $sourceCounts = $pool->countBy(fn (Skill $skill): string => learnsetSkillSourceType($skill, $pet));
        $categoryCounts = [
            'offense' => $pool->whereIn('combat_category', ['damage', 'hybrid'])->count(),
            'sustain' => $pool->whereIn('combat_category', ['heal', 'defense', 'buff'])->count(),
            'control' => $pool->whereIn('combat_category', ['control', 'disrupt'])->count(),
            'utility' => $pool->whereIn('combat_category', ['heal', 'defense', 'buff', 'control', 'disrupt'])->count(),
        ];
        $isFinalOrStandalone = ! $outgoingPetIds->contains($pet->id);
        $minimumElementSkills = $isFinalOrStandalone ? 3 : 1;
        $minimumSpeciesSkills = $isFinalOrStandalone ? 2 : 1;

        expect($sourceCounts->get('element', 0))->toBeGreaterThanOrEqual($minimumElementSkills, $identity)
            ->and($sourceCounts->get('species', 0))->toBeGreaterThanOrEqual($minimumSpeciesSkills, $identity)
            ->and($categoryCounts['offense'])->toBeGreaterThanOrEqual(min(2, $pool->count()), "{$identity}:offense-floor");

        if ($isFinalOrStandalone) {
            foreach (learnsetRoleRequirements($pet->primary_role) as $group => $minimum) {
                expect($categoryCounts[$group])->toBeGreaterThanOrEqual($minimum, "{$identity}:{$group}");
            }

            $poolSignatures[] = $pool->pluck('id')->sort()->implode(':');
        }
    }

    expect(collect($poolSignatures)->unique())->toHaveCount(118);
});

test('keeps mutation branch grants separate while preserving their shared ancestor pool', function () {
    $pets = Pet::query()
        ->with('learnsetEntries')
        ->whereHas('gameSource', fn ($query) => $query->where('slug', '!=', 'vqsv4'))
        ->get()
        ->keyBy('id');
    $evolutions = PetEvolution::query()->whereIn('from_pet_id', $pets->keys())->get();
    $incoming = $evolutions->groupBy('to_pet_id')->map->pluck('from_pet_id');
    $branchingFamilies = $evolutions->groupBy('from_pet_id')->filter(fn ($targets): bool => $targets->count() > 1);

    expect($branchingFamilies)->not->toBeEmpty();

    foreach ($branchingFamilies as $fromPetId => $branches) {
        $ancestorSkills = learnsetAccessibleSkillIds((int) $fromPetId, $pets, $incoming);
        $branchGrantSets = $branches
            ->map(fn (PetEvolution $evolution): array => learnsetDirectSkillIds($pets[$evolution->to_pet_id]))
            ->values()
            ->all();

        foreach ($branchGrantSets as $branchGrants) {
            expect(array_intersect($ancestorSkills, $branchGrants))->toBeEmpty();
        }

        for ($left = 0; $left < count($branchGrantSets); $left++) {
            for ($right = $left + 1; $right < count($branchGrantSets); $right++) {
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

test('reserves premium healing for water guardians and support while protecting earth balance', function () {
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $basicHealing = Skill::query()->whereBelongsTo($rainbow)->where('game_id', 26)->firstOrFail();
    $professionalHealing = Skill::query()->whereBelongsTo($rainbow)->where('game_id', 28)->firstOrFail();

    expect($basicHealing->learnsetEntries()->whereHas('pet', fn ($query) => $query
        ->where('primary_role', 'guardian')
        ->where('combat_element', 'tho'))->exists())->toBeFalse()
        ->and($basicHealing->learnsetEntries()->whereHas('pet', fn ($query) => $query
            ->where('primary_role', 'guardian')
            ->where('combat_element', '!=', 'tho'))->exists())->toBeTrue()
        ->and($professionalHealing->learnsetEntries()->whereHas('pet', fn ($query) => $query
            ->where('primary_role', 'guardian')
            ->where('combat_element', 'tho'))->exists())->toBeFalse()
        ->and($professionalHealing->learnsetEntries()->whereHas('pet', fn ($query) => $query
            ->where('primary_role', 'guardian')
            ->where('combat_element', 'thuy'))->exists())->toBeTrue()
        ->and($professionalHealing->learnsetEntries()->whereHas('pet', fn ($query) => $query->where('primary_role', 'support'))->exists())->toBeTrue();
});

test('rebuilds representative decks from the approved v6 taxonomy', function () {
    $gameSources = GameSource::query()
        ->whereIn('slug', ['liet-hoa', 'cau-vong'])
        ->get()
        ->keyBy('slug');
    $pets = Pet::query()
        ->with(['gameSource:id,slug', 'learnsetEntries.skill.gameSource:id,slug'])
        ->where(function ($query) use ($gameSources): void {
            $query
                ->where(fn ($sourceQuery) => $sourceQuery
                    ->whereBelongsTo($gameSources['liet-hoa'])
                    ->whereIn('game_id', [17, 90, 95]))
                ->orWhere(fn ($sourceQuery) => $sourceQuery
                    ->whereBelongsTo($gameSources['cau-vong'])
                    ->whereIn('game_id', [11, 18, 48]));
        })
        ->get()
        ->keyBy(fn (Pet $pet): string => "{$pet->gameSource->slug}:{$pet->game_id}");

    expect($pets)->toHaveCount(6);

    foreach ($pets as $pet) {
        $directSkills = $pet->learnsetEntries->pluck('skill');

        expect($directSkills)->not->toBeEmpty()
            ->and($directSkills->pluck('id')->unique())->toHaveCount($directSkills->count())
            ->and($directSkills->every('is_active', true))->toBeTrue();
    }

    $directSkillIdentities = fn (string $petIdentity): Collection => $pets[$petIdentity]
        ->learnsetEntries
        ->map(fn (PetSkillLearnset $entry): string => "{$entry->skill->gameSource->slug}:{$entry->skill->game_id}");

    expect($directSkillIdentities('cau-vong:18'))
        ->toContain('cau-vong:5')
        ->not->toContain('cau-vong:7')
        ->and($directSkillIdentities('liet-hoa:17'))
        ->toContain('liet-hoa:13')
        ->toContain('cau-vong:2')
        ->not->toContain('cau-vong:28')
        ->not->toContain('cau-vong:23')
        ->and($directSkillIdentities('cau-vong:11'))
        ->toContain('cau-vong:9')
        ->not->toContain('liet-hoa:23')
        ->and($directSkillIdentities('cau-vong:48'))
        ->toContain('liet-hoa:25')
        ->not->toContain('cau-vong:14')
        ->and($directSkillIdentities('liet-hoa:90'))
        ->toContain('liet-hoa:60')
        ->not->toContain('cau-vong:14')
        ->and($directSkillIdentities('liet-hoa:95'))
        ->toContain('liet-hoa:68')
        ->not->toContain('liet-hoa:62');
});

test('applies selected vqsv4 skills while reducing premium ghost burst', function () {
    $gameSources = GameSource::query()
        ->whereIn('slug', ['liet-hoa', 'cau-vong'])
        ->get()
        ->keyBy('slug');
    $pets = Pet::query()
        ->with(['gameSource:id,slug', 'learnsetEntries.skill.gameSource:id,slug'])
        ->where(function ($query) use ($gameSources): void {
            $query
                ->where(fn ($sourceQuery) => $sourceQuery
                    ->whereBelongsTo($gameSources['liet-hoa'])
                    ->whereIn('game_id', [31, 53, 61, 70]))
                ->orWhere(fn ($sourceQuery) => $sourceQuery
                    ->whereBelongsTo($gameSources['cau-vong'])
                    ->whereIn('game_id', [70, 86, 95]));
        })
        ->get()
        ->keyBy(fn (Pet $pet): string => "{$pet->gameSource->slug}:{$pet->game_id}");

    expect($pets)->toHaveCount(7);

    $directSkillIdentities = fn (string $petIdentity): Collection => $pets[$petIdentity]
        ->learnsetEntries
        ->map(fn (PetSkillLearnset $entry): string => "{$entry->skill->gameSource->slug}:{$entry->skill->game_id}");

    expect($directSkillIdentities('liet-hoa:31'))
        ->toContain('cau-vong:28')
        ->not->toContain('cau-vong:15')
        ->and($directSkillIdentities('cau-vong:70'))
        ->toContain('cau-vong:28')
        ->not->toContain('liet-hoa:37')
        ->and($directSkillIdentities('liet-hoa:53'))
        ->toContain('cau-vong:27')
        ->not->toContain('liet-hoa:37')
        ->and($directSkillIdentities('liet-hoa:61'))
        ->toContain('cau-vong:29')
        ->not->toContain('liet-hoa:37')
        ->and($directSkillIdentities('liet-hoa:70'))
        ->toContain('cau-vong:29')
        ->not->toContain('liet-hoa:44')
        ->and($directSkillIdentities('cau-vong:86'))
        ->toContain('cau-vong:30')
        ->not->toContain('cau-vong:32')
        ->and($directSkillIdentities('cau-vong:95'))
        ->toContain('liet-hoa:55')
        ->not->toContain('cau-vong:32');
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
 * @param  Collection<array-key, Collection<array-key, mixed>>  $incoming
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

/**
 * @param  Collection<int, Pet>  $pets
 * @param  Collection<array-key, Collection<array-key, mixed>>  $incoming
 * @return Collection<int, PetSkillLearnset>
 */
function learnsetAccessibleEntries(int $petId, Collection $pets, Collection $incoming): Collection
{
    $entries = collect();
    $currentId = $petId;
    $visited = [];

    while (! isset($visited[$currentId])) {
        $visited[$currentId] = true;
        $entries = $entries->concat($pets[$currentId]->learnsetEntries);

        if (! $incoming->has($currentId)) {
            break;
        }

        $currentId = (int) $incoming[$currentId]->first();
    }

    return $entries->unique('skill_id')->values();
}

/** @return list<int> */
function learnsetMilestones(): array
{
    return [5, 10, 15, 20, 25, 30, 35, 40, 45, 50];
}

/**
 * @param  Collection<int, Pet>  $pets
 * @param  Collection<array-key, Collection<array-key, mixed>>  $incoming
 * @return array<int, array{root_id: int, stage: int, maximum_depth: int}>
 */
function learnsetFamilyMetadata(Collection $pets, Collection $incoming): array
{
    $metadata = [];

    foreach ($pets as $pet) {
        $currentId = $pet->id;
        $stage = 0;
        $visited = [];

        while ($incoming->has($currentId) && ! isset($visited[$currentId])) {
            $visited[$currentId] = true;
            $currentId = (int) $incoming[$currentId]->first();
            $stage++;
        }

        $metadata[$pet->id] = [
            'root_id' => $currentId,
            'stage' => $stage,
            'maximum_depth' => 0,
        ];
    }

    $maximumDepthByRoot = collect($metadata)
        ->groupBy('root_id')
        ->map(fn (Collection $family): int => (int) $family->max('stage'));

    foreach ($metadata as $petId => $petMetadata) {
        $metadata[$petId]['maximum_depth'] = $maximumDepthByRoot[$petMetadata['root_id']];
    }

    return $metadata;
}

/** @param array{root_id: int, stage: int, maximum_depth: int} $metadata */
function learnsetExpectedPoolSize(array $metadata, bool $isFinalOrStandalone): int
{
    if ($metadata['maximum_depth'] === 0 || $isFinalOrStandalone) {
        return 10;
    }

    return match ([$metadata['maximum_depth'], $metadata['stage']]) {
        [1, 0] => 5,
        [2, 0], [3, 0] => 3,
        [2, 1] => 7,
        [3, 1] => 5,
        [3, 2] => 8,
        default => throw new InvalidArgumentException('Unsupported evolution depth and stage.'),
    };
}

function learnsetSkillSourceType(Skill $skill, Pet $pet): string
{
    if ($skill->species_affinity === $pet->species) {
        return 'species';
    }

    return $skill->combat_element === $pet->combat_element ? 'element' : 'universal';
}

/** @return list<int> */
function learnsetDirectSkillIds(Pet $pet): array
{
    return array_values($pet->learnsetEntries
        ->pluck('skill_id')
        ->map(fn (mixed $skillId): int => (int) $skillId)
        ->values()
        ->all());
}

/** @return array<string, int> */
function learnsetRoleRequirements(string $role): array
{
    return match ($role) {
        'striker' => ['offense' => 6],
        'bruiser' => ['offense' => 5, 'utility' => 2],
        'guardian' => ['sustain' => 1, 'offense' => 3],
        'controller' => ['control' => 1, 'offense' => 4],
        'support' => ['sustain' => 2, 'control' => 1, 'offense' => 2],
        'versatile' => ['offense' => 4, 'utility' => 2, 'control' => 1],
        default => throw new InvalidArgumentException("Unknown combat role [{$role}]."),
    };
}

/** @param Collection<array-key, Collection<array-key, mixed>> $incoming */
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
