<?php

namespace App\Http\Controllers\Wiki;

use App\Http\Controllers\Controller;
use App\Http\Requests\Wiki\ItemIndexRequest;
use App\Models\GameSource;
use App\Models\Item;
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
}
