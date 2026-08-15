<?php

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetMutationIngredient;
use App\Models\PetMutationRecipe;
use App\Models\PetSkillLearnset;
use App\Support\PetCombatBudget;
use App\Support\PetStatCalculator;
use App\Support\Vqsv4PetDesignRevision;
use Database\Seeders\DatabaseSeeder;
use Illuminate\Support\Collection;
use Illuminate\Support\Facades\File;
use Inertia\Testing\AssertableInertia as Assert;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('seeds the approved 72 pet VQSV4 catalog with balanced taxonomy and recipes', function () {
    $source = GameSource::query()->where('slug', 'vqsv4')->firstOrFail();
    $pets = Pet::query()
        ->whereBelongsTo($source)
        ->with('learnsetEntries.skill')
        ->orderBy('game_id')
        ->get();
    $excludedIds = [0, 1, 2, 3, 16, 17, 18, 19, 26, 27, 28, 29];
    $expectedIds = collect(range(0, 83))->diff($excludedIds)->values()->all();

    expect(GameSource::query()->count())->toBe(3)
        ->and(Pet::query()->count())->toBe(274)
        ->and($pets)->toHaveCount(72)
        ->and($pets->pluck('game_id')->all())->toBe($expectedIds)
        ->and($pets->pluck('game_id')->intersect($excludedIds))->toBeEmpty()
        ->and($pets->countBy('combat_element')->sortKeys()->all())->toBe([
            'dien' => 16,
            'hoa' => 6,
            'moc' => 14,
            'phong' => 7,
            'quy' => 5,
            'tho' => 10,
            'thuy' => 14,
        ])
        ->and($pets->countBy('species')->sortKeys()->all())->toBe([
            'hai-duong' => 9,
            'kim-loai' => 13,
            'manh-thu' => 19,
            'phi-hanh' => 25,
            'thuc-vat' => 6,
        ])
        ->and($pets->where('combat_element', 'moc')->countBy('species')->sortKeys()->all())->toBe([
            'manh-thu' => 5,
            'phi-hanh' => 3,
            'thuc-vat' => 6,
        ])
        ->and($pets->whereIn('game_id', [7, 8, 9])->every(fn (Pet $pet): bool => $pet->species === 'manh-thu'))->toBeTrue()
        ->and($pets->whereIn('game_id', [70, 71, 72])->every(fn (Pet $pet): bool => $pet->species === 'phi-hanh'))->toBeTrue()
        ->and($pets->where('classification', 'divine')->pluck('game_id')->all())->toBe([79, 80, 81, 82, 83])
        ->and($pets->where('combat_element', 'dien')->pluck('game_id')->all())->toBe([
            20, 21, 22, 32, 33, 34, 35, 39, 40, 41, 46, 47, 52, 53, 54, 79,
        ])
        ->and($pets->whereNotNull('primary_role'))->toHaveCount(72)
        ->and($pets->whereNotNull('species_trait_id'))->toHaveCount(72)
        ->and($pets->every(fn (Pet $pet): bool => $pet->learnsetEntries->isNotEmpty()))->toBeTrue()
        ->and($pets->flatMap->learnsetEntries->countBy('source_type')->sortKeys()->all())->toBe([
            'element' => 137,
            'species' => 137,
            'style' => 137,
        ])
        ->and(PetSkillLearnset::query()->whereIn('pet_id', $pets->pluck('id'))->count())->toBe(411)
        ->and(PetEvolution::query()->whereIn('from_pet_id', $pets->pluck('id'))->count())->toBe(45)
        ->and(PetEvolution::query()->whereIn('from_pet_id', $pets->pluck('id'))->whereNull('required_level')->exists())->toBeFalse()
        ->and(PetMutationRecipe::query()->whereIn('pet_id', $pets->pluck('id'))->count())->toBe(23)
        ->and(PetMutationIngredient::query()->count())->toBe(69);
});

test('gives every VQSV4 lineage a distinct level 50 archetype and progressive combat budget', function () {
    $source = GameSource::query()->where('slug', 'vqsv4')->firstOrFail();
    $pets = Pet::query()
        ->whereBelongsTo($source)
        ->orderBy('game_id')
        ->get()
        ->keyBy('game_id');
    $calculator = app(PetStatCalculator::class);
    $combatBudget = app(PetCombatBudget::class);
    $stats = $pets->map(fn (Pet $pet): array => $calculator->calculate($pet, 50));

    expect(Vqsv4PetDesignRevision::gameIds())->toHaveCount(72)
        ->and($pets->pluck('raw_values')->every(
            fn (array $rawValues): bool => data_get($rawValues, 'design.design_revision.version') === Vqsv4PetDesignRevision::VERSION,
        ))->toBeTrue()
        ->and($stats->unique(fn (array $profile): string => implode(':', $profile)))->toHaveCount(72)
        ->and($stats[47])->toBe(['hp' => 760, 'strength' => 390, 'defense' => 95, 'agility' => 41])
        ->and($stats[54])->toBe(['hp' => 1280, 'strength' => 283, 'defense' => 185, 'agility' => 18])
        ->and($stats[39])->toBe(['hp' => 740, 'strength' => 322, 'defense' => 90, 'agility' => 34])
        ->and($stats[40])->toBe(['hp' => 980, 'strength' => 237, 'defense' => 140, 'agility' => 27])
        ->and($stats[80])->toBe(['hp' => 1750, 'strength' => 376, 'defense' => 195, 'agility' => 23]);

    $evolutions = PetEvolution::query()
        ->whereIn('from_pet_id', $pets->pluck('id'))
        ->with(['sourcePet', 'targetPet'])
        ->get();

    foreach ($evolutions as $evolution) {
        $fromScore = $combatBudget->score($calculator->calculate($evolution->sourcePet, 50));
        $toScore = $combatBudget->score($calculator->calculate($evolution->targetPet, 50));

        expect($toScore)->toBeGreaterThan($fromScore, "{$evolution->sourcePet->name} -> {$evolution->targetPet->name}");
    }
});

test('matches every VQSV4 v2 stat checkpoint from the refactor contract', function () {
    $source = GameSource::query()->where('slug', 'vqsv4')->firstOrFail();
    $pets = Pet::query()
        ->whereBelongsTo($source)
        ->get()
        ->keyBy(fn (Pet $pet): string => sprintf('V4-%03d', $pet->game_id));
    $calculator = app(PetStatCalculator::class);
    $manifestPath = resource_path('decoded/vqsv4/06_analysis/pet-growth-v2/manifest.properties');
    $manifest = parse_ini_file($manifestPath, false, INI_SCANNER_RAW);
    $lines = preg_split(
        '/\R/',
        trim(File::get(resource_path('decoded/vqsv4/06_analysis/pet-growth-v2/checkpoints.tsv'))),
    );
    $header = str_getcsv((string) array_shift($lines), "\t");

    expect($manifest['profile_version'])->toBe('unified-v4-pet-growth-v2')
        ->and($manifest['pet_count'])->toBe('72')
        ->and($manifest['checkpoint_count'])->toBe('720')
        ->and($manifest['profiles_sha256'])->toBe(hash_file('sha256', resource_path('decoded/vqsv4/06_analysis/pet-growth-v2/profiles.tsv')))
        ->and($manifest['checkpoints_sha256'])->toBe(hash_file('sha256', resource_path('decoded/vqsv4/06_analysis/pet-growth-v2/checkpoints.tsv')))
        ->and($lines)->toHaveCount(720);

    foreach ($lines as $line) {
        $row = array_combine($header, str_getcsv($line, "\t"));
        $pet = $pets->get($row['pet_key']);

        expect($pet)->toBeInstanceOf(Pet::class)
            ->and($calculator->calculate($pet, (int) $row['level'], (int) $row['stars']))->toBe([
                'hp' => (int) $row['hp'],
                'strength' => (int) $row['strength'],
                'defense' => (int) $row['defense'],
                'agility' => (int) $row['agility'],
            ]);
    }
});

test('publishes VQSV4 profiles with exact skill pool animation classification and mutation data', function () {
    $source = GameSource::query()->where('slug', 'vqsv4')->firstOrFail();
    $mutationPet = Pet::query()
        ->whereBelongsTo($source)
        ->whereHas('mutationRecipe')
        ->orderBy('game_id')
        ->firstOrFail();
    $divinePet = Pet::query()
        ->whereBelongsTo($source)
        ->where('game_id', 79)
        ->firstOrFail();

    $this->get(route('wiki.pets.show', $mutationPet))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/pets/show')
            ->where('pet.game_source.slug', 'vqsv4')
            ->where('pet.game_source.asset_key', 'vqsv4')
            ->where('pet.classification', 'normal')
            ->where('pet.population_count', 274)
            ->has('pet.skills')
            ->where('pet.skills', fn (Collection $skills): bool => $skills->where('is_available_on_current_form', true)->isNotEmpty())
            ->where('pet.mutation_recipe.status', 'approved_same_id_variant')
            ->has('pet.mutation_recipe.ingredients', 3)
            ->has('pet.mutation_recipe.ingredients.0.item'));

    $this->get(route('wiki.pets.show', $divinePet))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('pet.classification', 'divine')
            ->where('pet.power_class', 'divine')
            ->where('pet.stats.hp.anchor_formula', 'anchor-l1-l50-over-49')
            ->where('pet.stats.hp.anchor_level_fifty', 1500)
            ->where('pet.divine_ability', null));
});

test('ships decoded artwork and source-timed animation for every approved VQSV4 pet', function () {
    $manifest = json_decode(
        File::get(public_path('assets/game/vqsv4/pet-animations/manifest.json')),
        true,
        flags: JSON_THROW_ON_ERROR,
    );

    expect($manifest['animations'])->toHaveCount(72)
        ->and($manifest['source'])->toContain('vqsv4.jar');

    foreach (array_keys($manifest['animations']) as $gameId) {
        $animation = $manifest['animations'][$gameId];

        expect(public_path("assets/game/vqsv4/pets/{$gameId}.png"))->toBeFile()
            ->and(public_path("assets/game/vqsv4/pet-animations/{$gameId}-skill.webp"))->toBeFile()
            ->and($animation['frame_count'])->toBeGreaterThan(1)
            ->and($animation['duration_ms'])->toBeGreaterThan(0)
            ->and($animation['tick_ms'])->toBe(60);
    }
});
