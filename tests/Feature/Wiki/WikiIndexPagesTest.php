<?php

use App\Models\Pet;
use App\Models\Skill;
use Database\Seeders\VqsvGameDataSeeder;
use Inertia\Testing\AssertableInertia as Assert;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(VqsvGameDataSeeder::class);
});

test('pet catalog is public paginated and filterable', function () {
    $this->get(route('wiki.pets.index'))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/pets/index')
            ->has('pets.data', 24)
            ->where('pets.total', 100)
            ->has('elements', 7)
            ->has('species', 5));

    $this->get(route('wiki.pets.index', [
        'q' => 'Long bảo bối',
        'element' => 'hoa',
        'species' => 'manh-thu',
        'learning_group' => 2,
        'evolution' => 'has',
    ]))->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->has('pets.data', 1)
            ->where('pets.data.0.game_id', 6)
            ->where('pets.data.0.belongs_to_evolution_family', true)
            ->where('pets.data.0.evolution_stage', 1)
            ->where('pets.data.0.evolution_family_size', 3)
            ->where('pets.data.0.combat_element.slug', 'hoa')
            ->where('pets.data.0.species.slug', 'manh-thu'));
});

test('pet catalog keeps every evolution family together in stage order', function () {
    $this->get(route('wiki.pets.index'))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('pets.data.6.game_id', 6)
            ->where('pets.data.7.game_id', 7)
            ->where('pets.data.8.game_id', 8)
            ->where('pets.data.6.evolution_stage', 1)
            ->where('pets.data.7.evolution_stage', 2)
            ->where('pets.data.8.evolution_stage', 3)
            ->where('pets.data.8.is_final_stage', true));
});

test('final evolution stages belong to a family and are never classified as standalone', function () {
    $this->get(route('wiki.pets.index', [
        'q' => 8,
        'evolution' => 'has',
    ]))->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->has('pets.data', 1)
            ->where('pets.data.0.game_id', 8)
            ->where('pets.data.0.belongs_to_evolution_family', true)
            ->where('pets.data.0.can_evolve', false)
            ->where('pets.data.0.is_final_stage', true));

    $this->get(route('wiki.pets.index', [
        'q' => 8,
        'evolution' => 'none',
    ]))->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->has('pets.data', 0));
});

test('pet profile exposes stats skills and complete evolution material path', function () {
    $pet = Pet::query()->where('game_id', 7)->firstOrFail();

    $this->get(route('wiki.pets.show', $pet))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/pets/show')
            ->where('pet.game_id', 7)
            ->where('pet.evolution_stage', 2)
            ->where('pet.evolution_stage_count', 3)
            ->where('pet.belongs_to_evolution_family', true)
            ->where('pet.can_evolve', true)
            ->where('pet.combat_element.slug', 'hoa')
            ->where('pet.species.slug', 'manh-thu')
            ->has('pet.stats.hp', 4)
            ->has('pet.stats.strength', 4)
            ->has('pet.stats.defense', 4)
            ->has('pet.stats.agility', 4)
            ->has('pet.skills', 10)
            ->has('pet.evolution_family.pets', 3)
            ->where('pet.evolution_family.pets.0.game_id', 6)
            ->where('pet.evolution_family.pets.1.game_id', 7)
            ->where('pet.evolution_family.pets.2.game_id', 8)
            ->has('pet.evolution_family.transitions', 2)
            ->where('pet.evolution_family.transitions.0.quantity', 1)
            ->has('pet.evolution_family.transitions.0.item'));
});

test('skill catalog filters by effect and target', function () {
    $this->get(route('wiki.skills.index', [
        'q' => 'Dương viêm',
        'element' => 0,
        'effect' => 'harmful',
        'target' => 'opponent',
    ]))->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/skills/index')
            ->has('skills.data', 1)
            ->where('skills.data.0.game_id', 1)
            ->where('skills.data.0.effect.source_table', 7)
            ->where('skills.data.0.effect.game_id', 0)
            ->where('skills.data.0.effect.kind', 'harmful')
            ->has('elements', 7));
});

test('skill dossier exposes unlock levels and compatible pets', function () {
    $skill = Skill::query()->where('game_id', 8)->firstOrFail();
    $compatiblePetCount = Pet::query()
        ->where('element_id', $skill->element_id)
        ->whereIn('learning_group', [2, 3])
        ->count();

    $this->get(route('wiki.skills.show', $skill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/skills/show')
            ->where('skill.game_id', 8)
            ->where('skill.tier', 3)
            ->where('skill.effect.source_table', 7)
            ->where('skill.effect.game_id', 1)
            ->has('skill.unlock_rules', 2)
            ->where('skill.unlock_rules.0.learning_group', 2)
            ->where('skill.unlock_rules.0.unlock_level', 40)
            ->where('skill.unlock_rules.1.learning_group', 3)
            ->where('skill.unlock_rules.1.unlock_level', 30)
            ->has('skill.compatible_pets', $compatiblePetCount));
});

test('item catalog keeps source identity while filtering', function () {
    $this->get(route('wiki.items.index', [
        'q' => 'Năng lượng Thạch',
        'source_table' => 4,
        'category' => 'recovery',
    ]))->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/items/index')
            ->has('items.data', 1)
            ->where('items.data.0.source_table', 4)
            ->where('items.data.0.game_id', 6)
            ->where('items.data.0.effect_type', 2)
            ->has('categories'));
});

test('badge item catalog has original artwork for every game badge', function () {
    $this->get(route('wiki.items.index', ['source_table' => 2]))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/items/index')
            ->has('items.data', 8)
            ->where('items.data.0.game_id', 0)
            ->where('items.data.7.game_id', 7));

    foreach (range(0, 7) as $gameId) {
        expect(public_path("assets/game/badges/{$gameId}.png"))->toBeFile();
    }
});
