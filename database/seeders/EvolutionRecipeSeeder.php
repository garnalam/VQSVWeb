<?php

namespace Database\Seeders;

use App\Models\Item;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Support\EvolutionRecipeData;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use RuntimeException;

class EvolutionRecipeSeeder extends Seeder
{
    /** @var array<int, int> */
    private const QUALITY_MULTIPLIERS = [1 => 90, 2 => 95, 3 => 100, 4 => 110, 5 => 125];

    /**
     * Normalize all Liệt Hỏa and Cầu Vồng evolution recipes.
     */
    public function run(): void
    {
        DB::transaction(function (): void {
            $items = Item::query()
                ->with('gameSource:id,slug')
                ->get()
                ->keyBy(fn (Item $item): string => $this->itemIdentity(
                    $item->gameSource->slug,
                    $item->source_table,
                    $item->game_id,
                ));
            $evolutions = PetEvolution::query()
                ->with([
                    'sourcePet.gameSource:id,slug',
                    'targetPet:id,game_id,species,quality_tier,hp_base,hp_per_level,hp_offset,stat_2_base,stat_2_per_level,stat_2_offset,stat_3_base,stat_3_per_10_levels,stat_3_offset,stat_4_base,stat_4_per_10_levels,stat_4_offset',
                    'item:id,game_source_id,source_table,game_id',
                ])
                ->orderBy('id')
                ->get();

            if ($evolutions->count() !== 88) {
                throw new RuntimeException('Evolution recipe normalization requires exactly 88 evolution edges.');
            }

            foreach ($evolutions as $evolution) {
                $sourceSlug = $evolution->sourcePet->gameSource->slug;
                $rank = EvolutionRecipeData::costRank(
                    $sourceSlug,
                    $evolution->sourcePet->game_id,
                    $evolution->targetPet->game_id,
                );
                $recipe = EvolutionRecipeData::ingredients(
                    $sourceSlug,
                    $evolution->sourcePet->game_id,
                    $evolution->targetPet->game_id,
                    $evolution->targetPet->species,
                    $evolution->targetPet->quality_tier,
                    $evolution->evolution_type,
                    $evolution->item->game_id,
                    $evolution->quantity,
                    $evolution->materials ?? [],
                );
                $resolvedIngredients = collect($recipe)->map(function (array $ingredient, int $position) use ($items): array {
                    $identity = $this->itemIdentity(
                        $ingredient['source'],
                        $ingredient['source_table'],
                        $ingredient['game_id'],
                    );
                    $item = $items->get($identity) ?? throw new RuntimeException("Missing recipe item {$identity}.");

                    return [
                        'item_id' => $item->id,
                        'quantity' => $ingredient['quantity'],
                        'role' => $ingredient['role'],
                        'position' => $position,
                    ];
                })->values();
                $primaryIngredient = $resolvedIngredients->first();

                $evolution->update([
                    'item_id' => $primaryIngredient['item_id'],
                    'quantity' => $primaryIngredient['quantity'],
                    'cost_rank' => $rank,
                    'balance_notes' => $this->balanceNotes($evolution, $rank),
                ]);
                $evolution->ingredients()->delete();
                $evolution->ingredients()->createMany($resolvedIngredients->all());
            }
        });
    }

    private function balanceNotes(PetEvolution $evolution, int $rank): string
    {
        $sourceTotal = $this->levelFiftyTotal($evolution->sourcePet);
        $targetTotal = $this->levelFiftyTotal($evolution->targetPet);
        $statChange = (int) round(($targetTotal - $sourceTotal) * 100 / max(1, $sourceTotal));
        $learnset = $evolution->targetPet->learnsetEntries()
            ->with('skill:id,tier')
            ->get();
        $maximumTier = $learnset->max(fn ($entry): int => $entry->skill->tier) ?? 0;
        $rankLabel = EvolutionRecipeData::RANK_LABELS[$rank];
        $changeLabel = $statChange >= 0 ? "+{$statChange}%" : "{$statChange}%";

        return "Hạng {$rankLabel}: {$changeLabel} tổng chỉ số cấp 50; form đích mở {$learnset->count()} Skill trực tiếp, tier cao nhất {$maximumTier}.";
    }

    private function levelFiftyTotal(Pet $pet): int
    {
        $multiplier = self::QUALITY_MULTIPLIERS[$pet->quality_tier];

        return (int) (array_sum([
            $pet->hp_base + $pet->hp_per_level * 50 + $pet->hp_offset,
            $pet->stat_2_base + $pet->stat_2_per_level * 50 + $pet->stat_2_offset,
            $pet->stat_3_base + $pet->stat_3_per_10_levels * 5 + $pet->stat_3_offset,
            $pet->stat_4_base + $pet->stat_4_per_10_levels * 5 + $pet->stat_4_offset,
        ]) * $multiplier / 100);
    }

    private function itemIdentity(string $sourceSlug, int $sourceTable, int $gameId): string
    {
        return "{$sourceSlug}:{$sourceTable}:{$gameId}";
    }
}
