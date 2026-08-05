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

test('unifies the skill catalog around combat data instead of source and energy filters', function () {
    $this->get(route('wiki.skills.index', [
        'q' => 'Mạn Độc Triền Sinh',
        'source' => 'species',
        'role' => 'attack',
        'unlock' => 5,
        'target' => 'single_enemy',
    ]))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/skills/index')
            ->has('skills.data', 1)
            ->where('skills.data.0.max_uses', 15)
            ->where('skills.data.0.status_chance', 100)
            ->where('skills.data.0.effect.name', 'Hủ Thực')
            ->where('skills.data.0.combat_category', 'hybrid')
            ->where('skills.data.0.target_pattern', 'single_enemy')
            ->where('skills.data.0.source_types', fn ($sourceTypes): bool => collect($sourceTypes)->contains('species'))
            ->where('skills.data.0.unlock_levels', fn ($levels): bool => collect($levels)->contains(5))
            ->where('skills.data.0.learned_by_count', fn (int $count): bool => $count > 0)
            ->has('skills.data.0.compatible_pet_preview')
            ->missing('gameSources')
            ->missing('skills.data.0.energy_cost')
            ->where('catalogStats.element_total', 7)
            ->where('catalogStats.tier_total', 4));
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
