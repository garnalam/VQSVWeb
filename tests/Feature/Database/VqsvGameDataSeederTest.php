<?php

use App\Models\Effect;
use App\Models\Element;
use App\Models\Item;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\Skill;
use App\Models\SkillUnlockRule;
use Database\Seeders\VqsvGameDataSeeder;

use function Pest\Laravel\seed;

test('imports the complete decoded wiki dataset and its relationships', function () {
    seed(VqsvGameDataSeeder::class);

    expect(Element::query()->count())->toBe(7)
        ->and(Pet::query()->count())->toBe(100)
        ->and(Skill::query()->count())->toBe(70)
        ->and(Effect::query()->count())->toBe(26)
        ->and(Item::query()->count())->toBe(52)
        ->and(PetEvolution::query()->count())->toBe(38)
        ->and(SkillUnlockRule::query()->count())->toBe(20);

    $pet = Pet::query()
        ->with(['element', 'evolutions.targetPet', 'evolutions.item'])
        ->where('game_id', 6)
        ->firstOrFail();
    $evolution = $pet->evolutions->sole();

    expect($pet->name_original)->toBe('Long bảo bối')
        ->and($pet->element->game_id)->toBe(0)
        ->and($pet->combat_element)->toBe('hoa')
        ->and($pet->species)->toBe('manh-thu')
        ->and($pet->raw_values)->toHaveCount(23)
        ->and($evolution->targetPet->game_id)->toBe(7)
        ->and($evolution->item->source_table)->toBe(3)
        ->and($evolution->item->game_id)->toBe(12)
        ->and($evolution->quantity)->toBe(1);

    $skill = Skill::query()->with('effect')->where('game_id', 1)->firstOrFail();

    expect($skill->name_original)->toBe('Dương viêm')
        ->and($skill->effect_mode)->toBe(2)
        ->and($skill->effect?->source_table)->toBe(7)
        ->and($skill->effect?->game_id)->toBe(0);

    $item = Item::query()->where('source_table', 4)->where('game_id', 6)->firstOrFail();

    expect($item->name_original)->toBe('Năng lượng Thạch')
        ->and($item->cost)->toBe(100)
        ->and($item->effect_type)->toBe(2)
        ->and($item->effect_parameters)->toBe(['values' => [25]]);
});

test('can be run repeatedly without creating duplicate game records', function () {
    seed(VqsvGameDataSeeder::class);
    seed(VqsvGameDataSeeder::class);

    expect(Pet::query()->count())->toBe(100)
        ->and(Skill::query()->count())->toBe(70)
        ->and(Effect::query()->count())->toBe(26)
        ->and(Item::query()->count())->toBe(52)
        ->and(PetEvolution::query()->count())->toBe(38)
        ->and(SkillUnlockRule::query()->count())->toBe(20);
});
