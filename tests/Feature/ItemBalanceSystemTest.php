<?php

use App\Models\GameSource;
use App\Models\Item;
use App\Models\PetEvolution;
use App\Models\PetEvolutionIngredient;
use App\Support\ItemBalance;
use Database\Seeders\DatabaseSeeder;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('publishes one unified catalog while retaining decoded source variants', function () {
    $items = Item::query()->with('canonicalItem')->get();
    $activeItems = $items->where('is_active', true);
    $inactiveItems = $items->where('is_active', false);

    expect($items)->toHaveCount(112)
        ->and($activeItems)->toHaveCount(87)
        ->and($inactiveItems)->toHaveCount(25)
        ->and($items->pluck('balance_version')->unique()->values()->all())->toBe([ItemBalance::VERSION])
        ->and($activeItems->whereNull('mechanic_key'))->toBeEmpty()
        ->and($activeItems->whereNull('usage_scope'))->toBeEmpty()
        ->and($inactiveItems->whereNull('canonical_item_id'))->toBeEmpty()
        ->and($inactiveItems->every(fn (Item $item): bool => $item->canonicalItem?->is_active === true))->toBeTrue();
});

test('converts duplicate rainbow consumables to canonical hp pp capture and exploration items', function () {
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $rainbowVariants = Item::query()
        ->with(['canonicalItem.gameSource:id,slug'])
        ->whereBelongsTo($rainbow)
        ->whereIn('game_id', [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 14, 15])
        ->get()
        ->keyBy('game_id');

    expect($rainbowVariants)->toHaveCount(14)
        ->and($rainbowVariants->every(fn (Item $item): bool => ! $item->is_active))->toBeTrue()
        ->and($rainbowVariants[3]->canonicalItem->mechanic_key)->toBe('restore_pp')
        ->and($rainbowVariants[3]->canonicalItem->effect_parameters['pp_percent'])->toBe(50)
        ->and($rainbowVariants[4]->canonicalItem->effect_parameters['pp_percent'])->toBe(100)
        ->and($rainbowVariants[11]->canonicalItem->gameSource->slug)->toBe('liet-hoa')
        ->and($rainbowVariants[11]->canonicalItem->source_table)->toBe(4)
        ->and($rainbowVariants[11]->canonicalItem->game_id)->toBe(0)
        ->and(Item::query()->whereBelongsTo($lietHoa)->where('source_table', 4)->where('game_id', 6)->value('description'))
        ->toContain('PP');
});

test('publishes all twelve liet hoa accessories with explicit held mechanics', function () {
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $accessories = Item::query()
        ->whereBelongsTo($lietHoa)
        ->where('source_table', 3)
        ->whereBetween('game_id', [0, 11])
        ->orderBy('game_id')
        ->get();

    expect($accessories)->toHaveCount(12)
        ->and($accessories->every(fn (Item $item): bool => $item->is_active
            && $item->category === 'accessory'
            && $item->equipment_slot === 'accessory'
            && $item->usage_scope === 'held_passive'))->toBeTrue()
        ->and($accessories[0]->mechanic_key)->toBe('low_hp_strength')
        ->and($accessories[0]->effect_parameters['strength_percent'])->toBe(100)
        ->and($accessories[7]->mechanic_key)->toBe('opening_priority')
        ->and($accessories[8]->effect_parameters)->toMatchArray(['chance' => 10, 'damage_to_heal_percent' => 20])
        ->and($accessories[10]->effect_parameters['minimum_target_hp'])->toBe(10)
        ->and($accessories[11]->effect_parameters['capture_rate_percent'])->toBe(20);
});

test('publishes twelve rainbow passive equipment items with pp based mechanics', function () {
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $passives = Item::query()
        ->whereBelongsTo($rainbow)
        ->where('is_active', true)
        ->where('category', 'passive_equipment')
        ->orderBy('game_id')
        ->get()
        ->keyBy('game_id');

    expect($passives)->toHaveCount(12)
        ->and($passives->every(fn (Item $item): bool => $item->equipment_slot === 'passive'))->toBeTrue()
        ->and($passives[43]->mechanic_key)->toBe('enemy_pp_drain')
        ->and($passives[43]->effect_parameters)->toMatchArray(['chance' => 25, 'pp_amount' => 1])
        ->and($passives[44]->mechanic_key)->toBe('self_pp_refund')
        ->and($passives[47]->effect_parameters)->toMatchArray(['chance' => 70, 'hp_percent' => 30, 'maximum_activations' => 1])
        ->and($passives[57]->effect_parameters['chance'])->toBe(30);
});

test('reclassifies rainbow rings as five canonical species eggs', function () {
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $sourceEggs = Item::query()
        ->with('canonicalItem')
        ->whereBelongsTo($rainbow)
        ->whereBetween('game_id', [58, 69])
        ->orderBy('game_id')
        ->get();
    $activeEggs = $sourceEggs->where('is_active', true);

    expect($sourceEggs)->toHaveCount(12)
        ->and($activeEggs)->toHaveCount(5)
        ->and($activeEggs->pluck('game_id')->values()->all())->toBe([58, 60, 62, 63, 64])
        ->and($activeEggs->every(fn (Item $item): bool => $item->category === 'pet_egg'
            && $item->mechanic_key === 'hatch_species_pet'))->toBeTrue()
        ->and($activeEggs->pluck('effect_parameters')->pluck('species')->sort()->values()->all())->toBe([
            'hai-duong',
            'kim-loai',
            'manh-thu',
            'phi-hanh',
            'thuc-vat',
        ])
        ->and($sourceEggs->where('is_active', false)->every(
            fn (Item $item): bool => $item->canonicalItem?->mechanic_key === 'hatch_species_pet',
        ))->toBeTrue();
});

test('keeps the approved evolution recipe graph unchanged', function () {
    $inactiveItemIds = Item::query()->where('is_active', false)->pluck('id');

    expect(PetEvolution::query()->count())->toBe(88)
        ->and(PetEvolutionIngredient::query()->count())->toBe(239)
        ->and(PetEvolutionIngredient::query()->whereIn('item_id', $inactiveItemIds)->exists())->toBeFalse()
        ->and(PetEvolutionIngredient::query()->distinct()->pluck('item_id')->count())->toBe(20);
});

test('makes stat stones redistribute rather than create stat budget', function () {
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $stones = Item::query()
        ->whereBelongsTo($lietHoa)
        ->where('source_table', 5)
        ->whereIn('game_id', [7, 8, 9])
        ->orderBy('game_id')
        ->get();

    expect($stones)->toHaveCount(3)
        ->and($stones->every(fn (Item $item): bool => $item->mechanic_key === 'redistribute_stats'
            && $item->effect_parameters['preserve_total_budget'] === true
            && $item->effect_parameters['transfer_percent_each'] === 5))->toBeTrue()
        ->and($stones->pluck('effect_parameters')->pluck('target_stat')->all())->toBe([
            'agility',
            'strength',
            'hp',
        ]);
});
