<?php

namespace Database\Seeders;

use App\Models\Item;
use App\Models\PetEvolutionIngredient;
use App\Support\ItemBalance;
use Illuminate\Database\Seeder;
use Illuminate\Support\Arr;
use Illuminate\Support\Collection;
use Illuminate\Support\Facades\DB;
use RuntimeException;

class ItemBalanceSeeder extends Seeder
{
    /**
     * Apply the official unified Item catalog without deleting decoded source variants.
     */
    public function run(): void
    {
        DB::transaction(function (): void {
            $items = Item::query()
                ->with('gameSource:id,slug')
                ->orderBy('id')
                ->get();

            if ($items->count() !== 112) {
                throw new RuntimeException(
                    "Unified Item catalog requires exactly 112 retained records; found {$items->count()}.",
                );
            }

            $itemsByIdentity = $items->keyBy(
                fn (Item $item): string => $this->identity(
                    $item->gameSource->slug,
                    $item->source_table,
                    $item->game_id,
                ),
            );

            foreach ($items as $item) {
                $profile = ItemBalance::profile(
                    $item->gameSource->slug,
                    $item->source_table,
                    $item->game_id,
                );
                $sourceMetadata = Arr::only($item->effect_parameters ?? [], [
                    'atlas_frame',
                    'sound_id',
                    'values',
                    'upgrade_description',
                    'condition',
                ]);

                $item->update([
                    'canonical_item_id' => null,
                    'name' => $profile['name'] ?? $item->name,
                    'description' => $profile['description'],
                    'category' => $profile['category'],
                    'mechanic_key' => $profile['mechanic_key'],
                    'usage_scope' => $profile['usage_scope'],
                    'equipment_slot' => $profile['equipment_slot'],
                    'balance_version' => ItemBalance::VERSION,
                    'is_active' => $profile['is_active'],
                    'effect_parameters' => [...$sourceMetadata, ...$profile['parameters']],
                ]);
            }

            $this->connectCanonicalVariants($items, $itemsByIdentity);
            $this->validateCatalog($items);
        });
    }

    /**
     * Connect each hidden decoded variant to the active Item that owns its mechanics.
     *
     * @param  Collection<int, Item>  $items
     * @param  Collection<string, Item>  $itemsByIdentity
     */
    private function connectCanonicalVariants(Collection $items, Collection $itemsByIdentity): void
    {
        foreach ($items as $item) {
            $profile = ItemBalance::profile(
                $item->gameSource->slug,
                $item->source_table,
                $item->game_id,
            );
            $canonical = $profile['canonical'] ?? null;

            if ($canonical === null) {
                continue;
            }

            $canonicalIdentity = $this->identity(
                $canonical['source'],
                $canonical['source_table'],
                $canonical['game_id'],
            );
            $canonicalItem = $itemsByIdentity->get($canonicalIdentity);

            if (! $canonicalItem instanceof Item || ! $canonicalItem->is_active) {
                throw new RuntimeException(
                    "Missing active canonical Item [{$canonicalIdentity}] for {$item->name_original}.",
                );
            }

            $item->update(['canonical_item_id' => $canonicalItem->id]);
        }
    }

    /** @param Collection<int, Item> $items */
    private function validateCatalog(Collection $items): void
    {
        $items->each->refresh();

        if ($items->where('is_active', true)->count() !== 87) {
            throw new RuntimeException('Unified Item catalog must publish exactly 87 active Items.');
        }

        if ($items->where('is_active', false)->count() !== 25) {
            throw new RuntimeException('Unified Item catalog must retain exactly 25 hidden source variants.');
        }

        $inactiveItemIds = $items->where('is_active', false)->pluck('id');

        if (PetEvolutionIngredient::query()->whereIn('item_id', $inactiveItemIds)->exists()) {
            throw new RuntimeException('An inactive Item variant is still referenced by an evolution recipe.');
        }
    }

    private function identity(string $source, int $sourceTable, int $gameId): string
    {
        return "{$source}:{$sourceTable}:{$gameId}";
    }
}
