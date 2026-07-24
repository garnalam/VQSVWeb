<?php

use App\Models\Effect;
use App\Models\Element;
use App\Models\GameSource;
use App\Models\Item;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetEvolutionIngredient;
use App\Models\Skill;
use App\Models\SkillUnlockRule;
use Database\Seeders\DatabaseSeeder;
use Inertia\Testing\AssertableInertia as Assert;

use function Pest\Laravel\seed;

test('imports both games with isolated source identities', function () {
    seed(DatabaseSeeder::class);

    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();

    expect(GameSource::query()->count())->toBe(2)
        ->and(Element::query()->count())->toBe(13)
        ->and(Pet::query()->count())->toBe(202)
        ->and(Skill::query()->count())->toBe(119)
        ->and(Item::query()->count())->toBe(112)
        ->and(Effect::query()->count())->toBe(46)
        ->and(PetEvolution::query()->count())->toBe(88)
        ->and(SkillUnlockRule::query()->count())->toBe(45)
        ->and(Pet::query()->whereBelongsTo($rainbow)->count())->toBe(102)
        ->and(Skill::query()->whereBelongsTo($rainbow)->count())->toBe(49)
        ->and(Item::query()->whereBelongsTo($rainbow)->count())->toBe(60)
        ->and(Pet::query()->whereBelongsTo($lietHoa)->where('game_id', 0)->exists())->toBeTrue()
        ->and(Pet::query()->whereBelongsTo($rainbow)->where('game_id', 0)->exists())->toBeTrue();
});

test('preserves decoded rainbow stats effects evolutions and artwork', function () {
    seed(DatabaseSeeder::class);

    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $pet = Pet::query()->whereBelongsTo($rainbow)->where('game_id', 0)->firstOrFail();
    $skill = Skill::query()->with('effect')->whereBelongsTo($rainbow)->where('game_id', 0)->firstOrFail();
    $item = Item::query()->whereBelongsTo($rainbow)->where('game_id', 0)->firstOrFail();

    expect($pet->name)->toBe('Thụ quái')
        ->and($pet->combat_element)->toBe('moc')
        ->and($pet->species)->toBe('thuc-vat')
        ->and($pet->raw_values['hp_base'])->toBe(32)
        ->and($pet->raw_values['hp_per_10_levels'])->toBe(38)
        ->and($pet->hp_base)->not->toBe(32)
        ->and($pet->raw_values['energy_base'])->toBe(80)
        ->and($pet->raw_values['energy_per_10_levels'])->toBe(15)
        ->and($pet->energy_base)->toBeNull()
        ->and($pet->energy_per_10_levels)->toBeNull()
        ->and($pet->discovery_locations)->toBe([
            'Bên ngoài thành phía nam',
            'Cao nguyên phía đông 2',
        ])
        ->and($pet->acquisition_code)->toBeNull()
        ->and($pet->evolutions)->toHaveCount(1)
        ->and($skill->name)->toBe('Triền Nhiễu')
        ->and($skill->energy_cost)->toBeNull()
        ->and($skill->status_chance)->toBe(4)
        ->and($skill->effect?->name)->toBe('Hủ Thực')
        ->and($item->name)->toBe('Đồ uống')
        ->and(public_path('assets/game/cau-vong/pets/0.png'))->toBeFile()
        ->and(public_path('assets/game/cau-vong/skills/0.png'))->toBeFile()
        ->and(public_path('assets/game/cau-vong/items/0.png'))->toBeFile()
        ->and(public_path('assets/game/cau-vong/effects/status-5.png'))->toBeFile();
});

test('preserves rainbow acquisition codes and exposes a complete pet dossier', function () {
    seed(DatabaseSeeder::class);

    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $capturedPet = Pet::query()->whereBelongsTo($rainbow)->where('game_id', 0)->firstOrFail();

    expect(Pet::query()->whereBelongsTo($rainbow)->where('game_id', 1)->value('acquisition_code'))->toBe(-2)
        ->and(Pet::query()->whereBelongsTo($rainbow)->where('game_id', 6)->value('acquisition_code'))->toBe(-3)
        ->and(Pet::query()->whereBelongsTo($rainbow)->where('game_id', 13)->value('acquisition_code'))->toBe(-1)
        ->and(Pet::query()->whereBelongsTo($rainbow)->where('game_id', 14)->value('acquisition_code'))->toBe(-5);

    $this->get(route('wiki.pets.show', $capturedPet))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/pets/show')
            ->where('pet.description', 'Tiểu Thụ Quái đáng yêu. [khắc chế Phi Hành hệ]')
            ->where('pet.lore', 'Tiểu Thụ Quái đáng yêu.')
            ->where('pet.combat_note', 'Khắc chế Phi Hành hệ')
            ->where('pet.acquisition.code', null)
            ->where('pet.acquisition.method', 'Tóm được')
            ->where('pet.acquisition.locations', [
                'Bên ngoài thành phía nam',
                'Cao nguyên phía đông 2',
            ])
            ->where('pet.quality_multiplier', 90)
            ->where('pet.stats.hp.base', $capturedPet->hp_base)
            ->where('pet.stats.hp.per_level', $capturedPet->hp_per_level)
            ->where('pet.stats.hp.per_ten_levels', false)
            ->where('pet.stats.strength.per_ten_levels', false)
            ->where('pet.stats.defense.per_ten_levels', true)
            ->where('pet.stats.agility.per_ten_levels', true)
            ->where('pet.stats.energy', null));

    $eggPet = Pet::query()->whereBelongsTo($rainbow)->where('game_id', 14)->firstOrFail();

    $this->get(route('wiki.pets.show', $eggPet))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('pet.acquisition.method', 'Ấp trứng')
            ->where('pet.acquisition.locations', []));
});

test('normalizes rainbow evolution families to shared Liệt Hỏa level fifty budgets', function () {
    seed(DatabaseSeeder::class);

    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $pets = Pet::query()
        ->whereBelongsTo($rainbow)
        ->with(['evolutions', 'previousEvolutions'])
        ->get()
        ->keyBy('game_id');

    expect($pets[0]->quality_tier)->toBe(1)
        ->and($pets[3]->quality_tier)->toBe(4)
        ->and($pets[9]->quality_tier)->toBe(4)
        ->and($pets[13]->quality_tier)->toBe(1)
        ->and($pets[15]->quality_tier)->toBe(4)
        ->and($pets[85]->quality_tier)->toBe(5);

    $finalForms = $pets->filter(
        fn (Pet $pet): bool => $pet->previousEvolutions->isNotEmpty() && $pet->evolutions->isEmpty(),
    );

    expect($finalForms)->not->toBeEmpty();

    foreach ($finalForms as $pet) {
        expect(rainbowLevelFiftyTotal($pet))->toBeBetween(1476, 1484);
    }

    expect(rainbowLevelFiftyTotal($pets[3]))->toBeBetween(1476, 1484)
        ->and(rainbowLevelFiftyTotal($pets[9]))->toBeBetween(1476, 1484)
        ->and(abs(rainbowLevelFiftyTotal($pets[3]) - rainbowLevelFiftyTotal($pets[9])))->toBeLessThanOrEqual(4)
        ->and(rainbowLevelFiftyTotal($pets[85]))->toBeBetween(2781, 2789);
});

test('item dossier includes cross game usages from canonical evolution recipes', function () {
    seed(DatabaseSeeder::class);

    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $item = Item::query()
        ->whereBelongsTo($rainbow)
        ->where('game_id', 19)
        ->firstOrFail();

    $this->get(route('wiki.items.show', $item))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/items/show')
            ->where('item.name', 'Chu quả')
            ->has('item.evolution_usages', 11)
            ->where('item.evolution_usages.0.from_pet.name', 'Tiên Nhân Chưởng Thú')
            ->where('item.evolution_usages.0.to_pet.name', 'Thiết Tý Phách Vương Thụ')
            ->where('item.evolution_usages.0.from_pet.game_source.slug', 'liet-hoa')
            ->where('item.evolution_usages.0.quantity', 3)
            ->where('item.evolution_usages.0.role', 'species'));
});

test('can import both sources repeatedly without duplicate records', function () {
    seed(DatabaseSeeder::class);
    seed(DatabaseSeeder::class);

    expect(Pet::query()->count())->toBe(202)
        ->and(Skill::query()->count())->toBe(119)
        ->and(Item::query()->count())->toBe(112)
        ->and(PetEvolution::query()->count())->toBe(88)
        ->and(PetEvolutionIngredient::query()->count())->toBeGreaterThan(176);
});

function rainbowLevelFiftyTotal(Pet $pet): int
{
    $multiplier = [1 => 90, 2 => 95, 3 => 100, 4 => 110, 5 => 125][$pet->quality_tier];
    $preQualityStats = [
        $pet->hp_base + $pet->hp_per_level * 50 + $pet->hp_offset,
        $pet->stat_2_base + $pet->stat_2_per_level * 50 + $pet->stat_2_offset,
        $pet->stat_3_base + $pet->stat_3_per_10_levels * 5 + $pet->stat_3_offset,
        $pet->stat_4_base + $pet->stat_4_per_10_levels * 5 + $pet->stat_4_offset,
    ];

    return array_sum(array_map(
        fn (int $stat): int => (int) ($stat * $multiplier / 100),
        $preQualityStats,
    ));
}
