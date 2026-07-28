<?php

use App\Models\GameSource;
use App\Models\Pet;
use Database\Seeders\DatabaseSeeder;
use Inertia\Testing\AssertableInertia as Assert;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('assigns the complete unified taxonomy to all 202 pets', function () {
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $lietHoaBat = Pet::query()->whereBelongsTo($lietHoa)->where('game_id', 0)->firstOrFail();
    $rainbowCarnivorousFlower = Pet::query()->whereBelongsTo($rainbow)->where('game_id', 6)->firstOrFail();
    $taxonomyCombinations = Pet::query()
        ->select(['combat_element', 'species'])
        ->distinct()
        ->get();

    expect(Pet::query()->count())->toBe(202)
        ->and(Pet::query()->whereNull('combat_element')->count())->toBe(0)
        ->and(Pet::query()->whereNull('species')->count())->toBe(0)
        ->and(Pet::query()->distinct()->count('combat_element'))->toBe(7)
        ->and(Pet::query()->distinct()->count('species'))->toBe(5)
        ->and($taxonomyCombinations)->toHaveCount(34)
        ->and($lietHoaBat->combat_element)->toBe('hoa')
        ->and($lietHoaBat->species)->toBe('phi-hanh')
        ->and($rainbowCarnivorousFlower->name)->toBe('Hoa ăn thịt người')
        ->and($rainbowCarnivorousFlower->combat_element)->toBe('quy')
        ->and($rainbowCarnivorousFlower->species)->toBe('thuc-vat');
});

test('pet wiki filters and presents combat element separately from species', function () {
    $this->get(route('wiki.pets.index', [
        'q' => 'Hoa ăn thịt người',
        'element' => 'quy',
        'species' => 'thuc-vat',
    ]))->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/pets/index')
            ->has('elements', 7)
            ->has('species', 5)
            ->where('filters.element', 'quy')
            ->where('filters.species', 'thuc-vat')
            ->has('pets.data', 1)
            ->where('pets.data.0.combat_element.name', 'Quỷ')
            ->where('pets.data.0.species.name', 'Thực Vật'));
});
