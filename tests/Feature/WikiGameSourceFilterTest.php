<?php

use Database\Seeders\DatabaseSeeder;
use Inertia\Testing\AssertableInertia as Assert;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('filters pet catalog by rainbow source', function () {
    $this->get(route('wiki.pets.index', ['game' => 'cau-vong']))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/pets/index')
            ->where('pets.total', 102)
            ->has('elements', 7)
            ->has('species', 5)
            ->where('pets.data.0.game_source.slug', 'cau-vong')
            ->where('pets.data.0.combat_element.slug', 'moc')
            ->where('pets.data.0.species.slug', 'thuc-vat'));
});

test('filters skill catalog by rainbow source and exposes real combat data', function () {
    $this->get(route('wiki.skills.index', ['game' => 'cau-vong', 'q' => 'Triền Nhiễu']))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/skills/index')
            ->has('skills.data', 1)
            ->where('skills.data.0.game_source.slug', 'cau-vong')
            ->where('skills.data.0.energy_cost', 10)
            ->where('skills.data.0.status_chance', 4)
            ->where('skills.data.0.effect.name', 'Hủ Thực'));
});

test('filters item catalog by rainbow source', function () {
    $this->get(route('wiki.items.index', ['game' => 'cau-vong']))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/items/index')
            ->where('items.total', 70)
            ->has('gameSources', 2)
            ->where('items.data.0.game_source.name', 'Cầu Vồng')
            ->where('items.data.0.frame_id', 0));
});
