<?php

use App\Models\Item;
use App\Models\Pet;
use App\Models\Skill;
use Database\Seeders\PetLearnsetSeeder;
use Database\Seeders\PetTraitSeeder;
use Database\Seeders\RainbowGameDataSeeder;
use Database\Seeders\VqsvGameDataSeeder;
use Illuminate\Support\Collection;
use Inertia\Testing\AssertableInertia as Assert;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed([VqsvGameDataSeeder::class, PetTraitSeeder::class]);
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
            ->where('pets.data.0.combat_element.color', fn (string $color): bool => str_starts_with($color, '#'))
            ->where('pets.data.0.species.slug', 'manh-thu')
            ->where('pets.data.0.preview_level', 50)
            ->where('pets.data.0.preview_stats.hp', fn (int $value): bool => $value > 0)
            ->where('pets.data.0.preview_stats.strength', fn (int $value): bool => $value > 0)
            ->where('pets.data.0.preview_stats.defense', fn (int $value): bool => $value > 0)
            ->where('pets.data.0.preview_stats.agility', fn (int $value): bool => $value > 0)
            ->where('pets.data.0.provenance.identity', 'decoded')
            ->where('pets.data.0.provenance.taxonomy', 'unified'));
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
    seed([RainbowGameDataSeeder::class, PetLearnsetSeeder::class]);

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
            ->where('pet.stat_benchmarks.level_one.hp', fn (int $value): bool => $value > 0)
            ->where('pet.stat_benchmarks.level_fifty.hp', fn (int $value): bool => $value > 0)
            ->has('pet.skills', 10)
            ->where('pet.primary_role', fn (string $role): bool => in_array($role, array_keys(Pet::COMBAT_ROLES), true))
            ->where('pet.provenance.combat_profile', 'calculated')
            ->where('pet.provenance.learnset', 'unified')
            ->where('pet.skills', fn (Collection $skills): bool => $skills->where('is_available_on_current_form', true)->count() === 7)
            ->where('pet.skills.0.grant_pet.game_id', 6)
            ->has('pet.evolution_family.pets', 3)
            ->where('pet.evolution_family.pets.0.game_id', 6)
            ->where('pet.evolution_family.pets.1.game_id', 7)
            ->where('pet.evolution_family.pets.1.primary_role', fn (string $role): bool => in_array($role, array_keys(Pet::COMBAT_ROLES), true))
            ->has('pet.evolution_family.pets.1.stats.hp', 4)
            ->has('pet.evolution_family.pets.1.combat_element')
            ->where('pet.evolution_family.pets.2.game_id', 8)
            ->has('pet.evolution_family.transitions', 2)
            ->where('pet.evolution_family.transitions.0.quantity', 1)
            ->has('pet.evolution_family.transitions.0.item'));
});

test('skill catalog filters by effect and target', function () {
    seed([RainbowGameDataSeeder::class, PetLearnsetSeeder::class]);

    $this->get(route('wiki.skills.index', [
        'q' => 'Dương viêm',
        'element' => 'hoa',
        'effect' => 'harmful',
        'target' => 'single_enemy',
    ]))->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/skills/index')
            ->has('skills.data', 1)
            ->where('skills.data.0.game_id', 1)
            ->where('skills.data.0.effect.source_table', 7)
            ->where('skills.data.0.effect.game_id', 0)
            ->where('skills.data.0.effect.kind', 'harmful')
            ->where('skills.data.0.target_pattern', 'single_enemy')
            ->where('skills.data.0.element.slug', 'hoa')
            ->where('skills.data.0.provenance.combat_rules', 'unified')
            ->where('catalogStats.active_total', 99)
            ->has('elements', 7));
});

test('skill element filter uses the shared seven-element combat matrix', function () {
    seed([RainbowGameDataSeeder::class, PetLearnsetSeeder::class]);

    $this->get(route('wiki.skills.index', [
        'element' => 'moc',
    ]))->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/skills/index')
            ->where('skills.total', 17)
            ->where('skills.data', fn (Collection $skills): bool => $skills->isNotEmpty()
                && $skills->every(fn (array $skill): bool => $skill['element']['slug'] === 'moc')));
});

test('skill dossier exposes unlock levels and compatible pets', function () {
    seed([RainbowGameDataSeeder::class, PetLearnsetSeeder::class]);

    $skill = Skill::query()->where('game_id', 8)->firstOrFail();

    $this->get(route('wiki.skills.show', $skill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/skills/show')
            ->where('skill.game_id', 8)
            ->where('skill.tier', 3)
            ->where('skill.status_chance', 20)
            ->where('skill.effect.source_table', 7)
            ->where('skill.effect.game_id', 1)
            ->where('skill.combat_category', fn (string $category): bool => $category !== '')
            ->where('skill.target_pattern', fn (string $target): bool => $target !== '')
            ->where('skill.provenance.identity', 'decoded')
            ->where('skill.provenance.learnset', 'unified')
            ->where('skill.pool_origin.type', fn (string $type): bool => in_array($type, ['element', 'species', 'universal', 'signature'], true))
            ->where('skill.is_signature', fn (bool $isSignature): bool => is_bool($isSignature))
            ->has('skill.navigation.previous')
            ->has('skill.navigation.next')
            ->has('skill.related_skills.0.game_id')
            ->where('skill.learnset_families', fn (Collection $families): bool => $families->isNotEmpty()
                && collect($families[0]['pets'])->every(fn (array $pet): bool => in_array($pet['learning_state'], ['direct', 'inherited', 'unavailable'], true)))
            ->where('skill.species_distribution', fn (Collection $distribution): bool => $distribution->isNotEmpty()
                && round($distribution->sum('percentage'), 1) === 100.0)
            ->has('skill.synergies.setup_skills', 0)
            ->has('skill.synergies.finisher_skills', 0)
            ->has('skill.synergies.teammate_pets')
            ->where('skill.synergies.provenance', 'calculated')
            ->where('skill.simulator.element_multipliers.advantage', 1.5)
            ->where('skill.simulator.element_multipliers.neutral', 1)
            ->where('skill.simulator.element_multipliers.disadvantage', 0.75)
            ->where('skill.compatible_pets', fn (Collection $pets): bool => $pets->isNotEmpty()
                && isset($pets[0]['grant_pet'], $pets[0]['unlock_level'], $pets[0]['is_inherited'])));
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

test('item dossier exposes human readable item data and related evolution paths', function () {
    $item = Item::query()->where('name', 'Tinh Nguyên Thạch')->firstOrFail();

    $this->get(route('wiki.items.show', $item))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/items/show')
            ->where('item.name', 'Tinh Nguyên Thạch')
            ->where('item.category', 'evolution_material')
            ->has('item.evolution_usages', 18)
            ->where('item.evolution_usages.0.from_pet.name', 'Long bảo bối')
            ->where('item.evolution_usages.0.to_pet.name', 'Phệ Hỏa Thú')
            ->where('item.evolution_usages.0.quantity', 1));
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
