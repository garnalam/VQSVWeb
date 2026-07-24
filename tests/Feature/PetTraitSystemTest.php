<?php

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetTrait;
use Database\Seeders\DatabaseSeeder;
use Inertia\Testing\AssertableInertia as Assert;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('seeds the unified trait catalog and assigns every pet species trait', function () {
    $physicalTraits = PetTrait::query()->physical()->orderBy('code')->get();
    $speciesTraits = PetTrait::query()->species()->get();
    $pets = Pet::query()->with('speciesTrait')->get();

    expect(PetTrait::query()->count())->toBe(33)
        ->and($physicalTraits)->toHaveCount(13)
        ->and($physicalTraits->pluck('roll_weight')->unique()->all())->toBe([1])
        ->and($physicalTraits->where('is_cleanse_eligible', true))->toHaveCount(8)
        ->and($physicalTraits->countBy('polarity')->all())->toMatchArray([
            PetTrait::POLARITY_NEUTRAL => 1,
            PetTrait::POLARITY_BENEFICIAL => 5,
            PetTrait::POLARITY_HARMFUL => 5,
            PetTrait::POLARITY_MIXED => 2,
        ])
        ->and($speciesTraits)->toHaveCount(20)
        ->and($pets)->toHaveCount(202)
        ->and($pets->whereNull('species_trait_id'))->toBeEmpty();

    foreach ($pets as $pet) {
        expect($pet->speciesTrait)->not->toBeNull()
            ->and($pet->speciesTrait->slot_type)->toBe(PetTrait::SLOT_SPECIES)
            ->and($pet->speciesTrait->species)->toBe($pet->species);
    }
});

test('keeps the reviewed species trait mapping for representative pets', function () {
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();

    expect(Pet::query()->whereBelongsTo($lietHoa)->where('game_id', 19)->firstOrFail()->speciesTrait->code)
        ->toBe('TV-03')
        ->and(Pet::query()->whereBelongsTo($rainbow)->where('game_id', 10)->firstOrFail()->speciesTrait->code)
        ->toBe('TV-03')
        ->and(Pet::query()->whereBelongsTo($rainbow)->where('game_id', 101)->firstOrFail()->speciesTrait->code)
        ->toBe('HD-02');
});

test('pet wiki exposes the fixed species trait and the equal thirteen trait pool', function () {
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $pet = Pet::query()->whereBelongsTo($lietHoa)->where('game_id', 19)->firstOrFail();

    $this->get(route('wiki.pets.index', ['game' => 'liet-hoa', 'q' => $pet->name]))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->has('pets.data', 1)
            ->where('pets.data.0.species_trait.code', 'TV-03')
            ->where('pets.data.0.species_trait.name', 'Gai phản kích'));

    $this->get(route('wiki.pets.show', $pet))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/pets/show')
            ->where('pet.species_trait.code', 'TV-03')
            ->has('trait_system.physical_traits', 13)
            ->missing('trait_system.total_roll_weight')
            ->missing('trait_system.probability_per_trait')
            ->missing('trait_system.cleanse_pool_count')
            ->missing('trait_system.polarity_counts'));
});
