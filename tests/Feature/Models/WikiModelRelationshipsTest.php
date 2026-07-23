<?php

use App\Models\Effect;
use App\Models\Element;
use App\Models\Item;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\Skill;
use App\Models\SkillUnlockRule;

test('elements own pets and skills', function () {
    $element = Element::factory()->create();
    $pet = Pet::factory()->for($element)->create();
    $skill = Skill::factory()->for($element)->create();

    expect($pet->element->is($element))->toBeTrue()
        ->and($skill->element->is($element))->toBeTrue()
        ->and($element->pets->contains($pet))->toBeTrue()
        ->and($element->skills->contains($skill))->toBeTrue();
});

test('effects own the skills that apply them', function () {
    $effect = Effect::factory()->create();
    $skill = Skill::factory()->for($effect)->create([
        'effect_mode' => 1,
        'effect_parameter' => 30,
    ]);

    expect($skill->effect->is($effect))->toBeTrue()
        ->and($effect->skills->contains($skill))->toBeTrue();
});

test('pet evolution connects source pet target pet and required item', function () {
    $element = Element::factory()->create();
    $sourcePet = Pet::factory()->recycle($element)->create();
    $targetPet = Pet::factory()->recycle($element)->create();
    $item = Item::factory()->create();

    $evolution = PetEvolution::factory()
        ->for($sourcePet, 'sourcePet')
        ->for($targetPet, 'targetPet')
        ->for($item)
        ->create();

    expect($evolution->sourcePet->is($sourcePet))->toBeTrue()
        ->and($evolution->targetPet->is($targetPet))->toBeTrue()
        ->and($evolution->item->is($item))->toBeTrue()
        ->and($sourcePet->evolutions->contains($evolution))->toBeTrue()
        ->and($targetPet->previousEvolutions->contains($evolution))->toBeTrue()
        ->and($item->petEvolutions->contains($evolution))->toBeTrue();
});

test('skill unlock rules are connected by learning group', function () {
    $rule = SkillUnlockRule::factory()->create([
        'learning_group' => 2,
        'level' => 20,
    ]);
    $pet = Pet::factory()->create(['learning_group' => 2]);

    expect($rule->pets->contains($pet))->toBeTrue()
        ->and($pet->unlockRules->contains($rule))->toBeTrue();
});

test('decoded json values are cast to arrays', function () {
    $pet = Pet::factory()->create(['raw_values' => [1, 2, 3]]);
    $effect = Effect::factory()->create([
        'parameters' => [30, 190],
        'raw_values' => [2, 30, 190],
    ]);
    $item = Item::factory()->create([
        'effect_parameters' => [50, 50],
        'raw_values' => [29, 100, 0, 1, 50, 50],
    ]);

    expect($pet->raw_values)->toBe([1, 2, 3])
        ->and($effect->parameters)->toBe([30, 190])
        ->and($effect->raw_values)->toBe([2, 30, 190])
        ->and($item->effect_parameters)->toBe([50, 50])
        ->and($item->raw_values)->toBe([29, 100, 0, 1, 50, 50]);
});
