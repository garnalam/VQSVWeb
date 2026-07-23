<?php

use App\Models\Effect;
use App\Models\Element;
use App\Models\GameSource;
use App\Models\Item;
use App\Models\Pet;
use App\Models\PetEvolution;
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
        ->and(Item::query()->count())->toBe(122)
        ->and(Effect::query()->count())->toBe(46)
        ->and(PetEvolution::query()->count())->toBe(88)
        ->and(SkillUnlockRule::query()->count())->toBe(45)
        ->and(Pet::query()->whereBelongsTo($rainbow)->count())->toBe(102)
        ->and(Skill::query()->whereBelongsTo($rainbow)->count())->toBe(49)
        ->and(Item::query()->whereBelongsTo($rainbow)->count())->toBe(70)
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
        ->and($pet->hp_base)->toBe(32)
        ->and($pet->energy_base)->toBe(80)
        ->and($pet->discovery_locations)->toBe([
            'Bên ngoài thành phía nam',
            'Cao nguyên phía đông 2',
        ])
        ->and($pet->acquisition_code)->toBeNull()
        ->and($pet->evolutions)->toHaveCount(1)
        ->and($skill->name)->toBe('Triền Nhiễu')
        ->and($skill->energy_cost)->toBe(10)
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
            ->where('pet.stats.hp.base', 32)
            ->where('pet.stats.hp.per_level', 38)
            ->where('pet.stats.energy.base', 80)
            ->where('pet.stats.energy.per_level', 15));

    $eggPet = Pet::query()->whereBelongsTo($rainbow)->where('game_id', 14)->firstOrFail();

    $this->get(route('wiki.pets.show', $eggPet))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('pet.acquisition.method', 'Ấp trứng')
            ->where('pet.acquisition.locations', []));
});

test('can import both sources repeatedly without duplicate records', function () {
    seed(DatabaseSeeder::class);
    seed(DatabaseSeeder::class);

    expect(Pet::query()->count())->toBe(202)
        ->and(Skill::query()->count())->toBe(119)
        ->and(Item::query()->count())->toBe(122)
        ->and(PetEvolution::query()->count())->toBe(88);
});
