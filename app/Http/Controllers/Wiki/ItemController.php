<?php

namespace App\Http\Controllers\Wiki;

use App\Http\Controllers\Controller;
use App\Http\Requests\Wiki\ItemIndexRequest;
use App\Models\GameSource;
use App\Models\Item;
use App\Models\PetEvolutionIngredient;
use Illuminate\Database\Eloquent\Builder;
use Inertia\Inertia;
use Inertia\Response;

class ItemController extends Controller
{
    /**
     * Display the searchable item catalog.
     */
    public function index(ItemIndexRequest $request): Response
    {
        $filters = $request->validated();
        $search = trim((string) ($filters['q'] ?? ''));
        $sort = (string) ($filters['sort'] ?? 'game_id');
        $gameSlug = $filters['game'] ?? null;

        $items = Item::query()
            ->select([
                'id',
                'game_source_id',
                'source_table',
                'game_id',
                'name',
                'slug',
                'description',
                'category',
                'frame_id',
                'cost',
                'currency_code',
                'effect_type',
                'effect_parameters',
            ])
            ->with('gameSource:id,name,slug,asset_key,color')
            ->when($gameSlug, fn (Builder $query): Builder => $query->whereHas(
                'gameSource',
                fn (Builder $sourceQuery): Builder => $sourceQuery->where('slug', $gameSlug),
            ))
            ->when($search !== '', function (Builder $query) use ($search): void {
                $query->where(function (Builder $searchQuery) use ($search): void {
                    $searchQuery->where('name', 'like', "%{$search}%")
                        ->orWhere('description', 'like', "%{$search}%");

                    if (ctype_digit($search)) {
                        $searchQuery->orWhere('game_id', (int) $search);
                    }
                });
            })
            ->when(isset($filters['source_table']), fn (Builder $query): Builder => $query->where(
                'source_table',
                (int) $filters['source_table'],
            ))
            ->when(isset($filters['category']), fn (Builder $query): Builder => $query->where(
                'category',
                (string) $filters['category'],
            ))
            ->orderBy(match ($sort) {
                'name' => 'name',
                'cost' => 'cost',
                default => 'game_id',
            }, $sort === 'cost' ? 'desc' : 'asc')
            ->orderBy('source_table')
            ->orderBy('game_id')
            ->paginate(24)
            ->withQueryString()
            ->through(fn (Item $item): array => [
                'id' => $item->id,
                'game_source' => [
                    'name' => $item->gameSource->name,
                    'slug' => $item->gameSource->slug,
                    'asset_key' => $item->gameSource->asset_key,
                    'color' => $item->gameSource->color,
                ],
                'source_table' => $item->source_table,
                'game_id' => $item->game_id,
                'name' => $item->name,
                'slug' => $item->slug,
                'description' => $item->description,
                'category' => $item->category,
                'frame_id' => $item->frame_id,
                'cost' => $item->cost,
                'currency_code' => $item->currency_code,
                'effect_type' => $item->effect_type,
                'effect_parameters' => $item->effect_parameters,
            ]);

        return Inertia::render('wiki/items/index', [
            'items' => $items,
            'categories' => Item::query()
                ->when($gameSlug, fn (Builder $query): Builder => $query->whereHas(
                    'gameSource',
                    fn (Builder $sourceQuery): Builder => $sourceQuery->where('slug', $gameSlug),
                ))
                ->distinct()
                ->orderBy('category')
                ->pluck('category'),
            'gameSources' => GameSource::query()->select('name', 'slug', 'asset_key', 'color')->orderBy('id')->get(),
            'filters' => [
                'q' => $search,
                'game' => $gameSlug,
                'source_table' => isset($filters['source_table']) ? (int) $filters['source_table'] : null,
                'category' => $filters['category'] ?? null,
                'sort' => $sort,
            ],
        ]);
    }

    /**
     * Display an item dossier and every evolution path that consumes it.
     */
    public function show(Item $item): Response
    {
        $item->load('gameSource:id,name,slug,asset_key,color');

        $evolutionUsages = $item->evolutionIngredients()
            ->select(['id', 'pet_evolution_id', 'item_id', 'quantity', 'role', 'position'])
            ->with([
                'petEvolution:id,from_pet_id,to_pet_id,evolution_type,cost_rank',
                'petEvolution.sourcePet:id,game_source_id,game_id,name,slug,sprite_id,combat_element,species',
                'petEvolution.sourcePet.gameSource:id,name,slug,asset_key,color',
                'petEvolution.targetPet:id,game_source_id,game_id,name,slug,sprite_id,combat_element,species',
                'petEvolution.targetPet.gameSource:id,name,slug,asset_key,color',
            ])
            ->orderBy('pet_evolution_id')
            ->get()
            ->map(function (PetEvolutionIngredient $ingredient): array {
                $evolution = $ingredient->petEvolution;

                return [
                    'id' => $evolution->id,
                    'type' => $evolution->evolution_type,
                    'quantity' => $ingredient->quantity,
                    'role' => $ingredient->role,
                    'cost_rank' => $evolution->cost_rank,
                    'from_pet' => [
                        'id' => $evolution->sourcePet->id,
                        'game_source' => [
                            'name' => $evolution->sourcePet->gameSource->name,
                            'slug' => $evolution->sourcePet->gameSource->slug,
                            'asset_key' => $evolution->sourcePet->gameSource->asset_key,
                            'color' => $evolution->sourcePet->gameSource->color,
                        ],
                        'game_id' => $evolution->sourcePet->game_id,
                        'name' => $evolution->sourcePet->name,
                        'slug' => $evolution->sourcePet->slug,
                        'sprite_id' => $evolution->sourcePet->sprite_id,
                    ],
                    'to_pet' => [
                        'id' => $evolution->targetPet->id,
                        'game_source' => [
                            'name' => $evolution->targetPet->gameSource->name,
                            'slug' => $evolution->targetPet->gameSource->slug,
                            'asset_key' => $evolution->targetPet->gameSource->asset_key,
                            'color' => $evolution->targetPet->gameSource->color,
                        ],
                        'game_id' => $evolution->targetPet->game_id,
                        'name' => $evolution->targetPet->name,
                        'slug' => $evolution->targetPet->slug,
                        'sprite_id' => $evolution->targetPet->sprite_id,
                    ],
                ];
            })
            ->values();

        return Inertia::render('wiki/items/show', [
            'item' => [
                'id' => $item->id,
                'game_source' => [
                    'name' => $item->gameSource->name,
                    'slug' => $item->gameSource->slug,
                    'asset_key' => $item->gameSource->asset_key,
                    'color' => $item->gameSource->color,
                ],
                'source_table' => $item->source_table,
                'game_id' => $item->game_id,
                'name_original' => $item->name_original,
                'name' => $item->name,
                'slug' => $item->slug,
                'description_original' => $item->description_original,
                'description' => $item->description,
                'category' => $item->category,
                'frame_id' => $item->frame_id,
                'cost' => $item->cost,
                'currency_code' => $item->currency_code,
                'effect_type' => $item->effect_type,
                'effect_parameters' => $item->effect_parameters,
                'raw_values' => $item->raw_values,
                'evolution_usages' => $evolutionUsages,
            ],
        ]);
    }
}
