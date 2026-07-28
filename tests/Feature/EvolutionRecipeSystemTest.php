<?php

use App\Models\GameSource;
use App\Models\Item;
use App\Models\PetEvolution;
use App\Models\PetEvolutionIngredient;
use Database\Seeders\DatabaseSeeder;
use Inertia\Testing\AssertableInertia as Assert;

use function Pest\Laravel\seed;

test('assigns reviewed cross game recipes to all evolution edges', function () {
    seed(DatabaseSeeder::class);

    expect(PetEvolution::query()->count())->toBe(88)
        ->and(PetEvolutionIngredient::query()->count())->toBeGreaterThan(176)
        ->and(PetEvolution::query()->whereDoesntHave('ingredients')->exists())->toBeFalse()
        ->and(PetEvolution::query()->whereNotBetween('cost_rank', [1, 5])->exists())->toBeFalse();

    $lietHoaRecipe = evolutionRecipe('liet-hoa', 6, 7);
    expect($lietHoaRecipe->cost_rank)->toBe(2)
        ->and(recipeIngredients($lietHoaRecipe))->toBe([
            'liet-hoa:3:12' => ['quantity' => 1, 'role' => 'core'],
            'cau-vong:0:16' => ['quantity' => 2, 'role' => 'species'],
        ]);

    $rainbowSignatureRecipe = evolutionRecipe('cau-vong', 2, 3);
    expect($rainbowSignatureRecipe->cost_rank)->toBe(5)
        ->and(recipeIngredients($rainbowSignatureRecipe))->toBe([
            'liet-hoa:3:14' => ['quantity' => 1, 'role' => 'core'],
            'cau-vong:0:18' => ['quantity' => 3, 'role' => 'species'],
            'cau-vong:0:19' => ['quantity' => 3, 'role' => 'species'],
            'cau-vong:0:27' => ['quantity' => 1, 'role' => 'signature'],
        ]);
});

test('prices reviewed mutations cheaply and uses the target species catalyst', function () {
    seed(DatabaseSeeder::class);

    $weakerMutation = evolutionRecipe('liet-hoa', 41, 42);
    expect($weakerMutation->cost_rank)->toBe(1)
        ->and($weakerMutation->balance_notes)->toContain('Hạng Tiết kiệm')
        ->and(recipeIngredients($weakerMutation))->toBe([
            'liet-hoa:3:15' => ['quantity' => 1, 'role' => 'core'],
            'cau-vong:0:24' => ['quantity' => 1, 'role' => 'species'],
        ]);

    $speciesChangingMutation = evolutionRecipe('liet-hoa', 93, 94);
    expect(recipeIngredients($speciesChangingMutation))->toHaveKey('cau-vong:0:16')
        ->and(recipeIngredients($speciesChangingMutation))->not->toHaveKey('cau-vong:0:22');
});

test('exposes every recipe ingredient and price rank on pet dossiers', function () {
    seed(DatabaseSeeder::class);

    $evolution = evolutionRecipe('cau-vong', 2, 3);

    $this->get(route('wiki.pets.show', $evolution->sourcePet))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/pets/show')
            ->where('pet.evolution_family.transitions.2.cost_rank', 5)
            ->where('pet.evolution_family.transitions.2.cost_rank_label', 'Đặc trưng')
            ->has('pet.evolution_family.transitions.2.ingredients', 4)
            ->where('pet.evolution_family.transitions.2.ingredients.0.item.name', 'Thiên Địa Thần Thạch')
            ->where('pet.evolution_family.transitions.2.ingredients.3.item.name', 'Cổ thụ chi hạch'));
});

test('renames shared metal catalyst and omits removed rainbow items', function () {
    seed(DatabaseSeeder::class);

    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();

    expect(Item::query()->whereBelongsTo($rainbow)->where('game_id', 24)->value('name'))->toBe('Kim Tinh Thạch')
        ->and(Item::query()->whereBelongsTo($rainbow)->whereIn('game_id', [12, 13, 35, 38, 49, 52, 53, 54, 55, 56])->exists())->toBeFalse();
});

function evolutionRecipe(string $sourceSlug, int $fromGameId, int $toGameId): PetEvolution
{
    return PetEvolution::query()
        ->whereHas('sourcePet', fn ($query) => $query
            ->where('game_id', $fromGameId)
            ->whereHas('gameSource', fn ($sourceQuery) => $sourceQuery->where('slug', $sourceSlug)))
        ->whereHas('targetPet', fn ($query) => $query->where('game_id', $toGameId))
        ->with(['sourcePet', 'ingredients.item.gameSource'])
        ->firstOrFail();
}

/** @return array<string, array{quantity: int, role: string}> */
function recipeIngredients(PetEvolution $evolution): array
{
    return $evolution->ingredients
        ->mapWithKeys(fn (PetEvolutionIngredient $ingredient): array => [
            "{$ingredient->item->gameSource->slug}:{$ingredient->item->source_table}:{$ingredient->item->game_id}" => [
                'quantity' => $ingredient->quantity,
                'role' => $ingredient->role,
            ],
        ])
        ->all();
}
