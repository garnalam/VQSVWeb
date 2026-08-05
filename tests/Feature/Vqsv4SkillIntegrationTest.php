<?php

use App\Models\Effect;
use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetTrait;
use App\Models\Skill;
use App\Support\PetBattleSimulator;
use App\Support\SkillBalance;
use App\Support\Vqsv4SkillData;
use Database\Seeders\DatabaseSeeder;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('publishes all thirty three approved VQSV4 skills without duplicate source identities', function () {
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $skills = Skill::query()
        ->whereBelongsTo($rainbow)
        ->whereBetween('game_id', [0, 32])
        ->with(['effect', 'gameSource'])
        ->orderBy('game_id')
        ->get()
        ->keyBy('game_id');

    expect(Skill::query()->count())->toBe(119)
        ->and(Skill::query()->where('is_active', true)->count())->toBe(103)
        ->and($skills)->toHaveCount(33)
        ->and($skills[4]->power_percent)->toBe(170)
        ->and(Skill::query()->whereBelongsTo($rainbow)->whereBetween('game_id', [33, 48])->where('is_active', true)->exists())->toBeFalse();

    foreach (Vqsv4SkillData::definitions() as $gameId => $definition) {
        $skill = $skills->get($gameId);
        $profile = SkillBalance::profile('cau-vong', $gameId);

        expect($skill)->not->toBeNull()
            ->and($skill->name)->toBe($definition['name'])
            ->and($skill->combat_element)->toBe($definition['combat_element'])
            ->and($skill->combat_category)->toBe($definition['combat_category'])
            ->and($skill->power_percent)->toBe($profile['power'])
            ->and($skill->max_uses)->toBe($profile['pp'])
            ->and($skill->tier)->toBe($profile['tier'])
            ->and($skill->status_chance)->toBe($profile['status_chance'])
            ->and($skill->description)->toBe($profile['description'])
            ->and($skill->balance_version)->toBe(SkillBalance::VERSION)
            ->and($skill->is_active)->toBeTrue();
    }
});

test('seeds unified effects and six equally weighted VQSV4 aptitudes', function () {
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $effects = Effect::query()
        ->whereBelongsTo($rainbow)
        ->where('source_table', Vqsv4SkillData::UNIFIED_EFFECT_SOURCE_TABLE)
        ->orderBy('game_id')
        ->get();
    $traits = PetTrait::query()
        ->physical()
        ->whereBetween('code', ['V4-TRAIT-00', 'V4-TRAIT-05'])
        ->orderBy('code')
        ->get();
    $traitsByCode = $traits->keyBy('code');

    expect(Effect::query()->count())->toBe(52)
        ->and($effects)->toHaveCount(6)
        ->and($effects->pluck('parameters')->pluck('status_key')->all())->toBe([
            'bleeding',
            'sleep',
            'defense_up',
            'damage_down',
            'agility_down',
            'defense_down',
        ])
        ->and(PetTrait::query()->count())->toBe(39)
        ->and($traits)->toHaveCount(6)
        ->and($traits->pluck('code')->all())->toBe([
            'V4-TRAIT-00',
            'V4-TRAIT-01',
            'V4-TRAIT-02',
            'V4-TRAIT-03',
            'V4-TRAIT-04',
            'V4-TRAIT-05',
        ])
        ->and($traits->pluck('roll_weight')->unique()->all())->toBe([1])
        ->and($traits->countBy('polarity')->all())->toBe([
            PetTrait::POLARITY_BENEFICIAL => 3,
            PetTrait::POLARITY_HARMFUL => 3,
        ])
        ->and($traitsByCode['V4-TRAIT-03']->name)->toBe('Mộc Ngẫu Rạn Vỡ')
        ->and($traitsByCode['V4-TRAIT-03']->parameters['damage_received_percent'])->toBe(50)
        ->and($traitsByCode['V4-TRAIT-04']->parameters['minimum_hp'])->toBe(1)
        ->and($traitsByCode['V4-TRAIT-05']->parameters['experience_multiplier'])->toBe(0.5)
        ->and(Pet::query()->whereIn('species_trait_id', $traits->pluck('id'))->exists())->toBeFalse();
});

test('keeps the VQSV4 import idempotent', function () {
    seed(DatabaseSeeder::class);

    expect(Skill::query()->count())->toBe(119)
        ->and(Effect::query()->count())->toBe(52)
        ->and(PetTrait::query()->count())->toBe(39);
});

test('executes bleeding sleep random power and the approved wood follow ups', function () {
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $skills = Skill::query()
        ->whereBelongsTo($rainbow)
        ->whereIn('game_id', [1, 2, 4, 15, 29, 30])
        ->with(['effect', 'gameSource'])
        ->get()
        ->keyBy('game_id');
    $pets = Pet::query()->with(['speciesTrait', 'divineAbility'])->limit(2)->get();
    $actorPet = $pets->firstOrFail();
    $targetPet = $pets->last();
    $simulator = app(PetBattleSimulator::class);
    $actor = vqsv4InitialState($simulator, $actorPet, $skills->values()->all());
    $target = vqsv4InitialState($simulator, $targetPet, $skills->values()->all());

    vqsv4InvokePrivate($simulator, 'applyBalancedStatus', $target, 'bleeding', 2, 4);
    $bleedingTick = max(1, (int) round($target['max_hp'] * 0.04));
    $beforeBleeding = $target['hp'];
    vqsv4InvokePrivate($simulator, 'applyRoundEnd', $target, 1);
    vqsv4InvokePrivate($simulator, 'applyRoundEnd', $target, 2);

    expect($target['hp'])->toBe($beforeBleeding - $bleedingTick * 2)
        ->and($target['statuses'])->not->toHaveKey('bleeding');

    vqsv4InvokePrivate($simulator, 'applyBalancedStatus', $target, 'sleep', 1, 1);
    expect($target['statuses'])->toHaveKeys(['sleep', 'action_block']);
    vqsv4DealDamage($simulator, $actorPet, $actor, $targetPet, $target, $skills[15]);
    expect($target['statuses'])->not->toHaveKeys(['sleep', 'action_block']);

    $randomPowers = collect(range(1, 30))->map(
        fn (int $seedValue): int => vqsv4ResolvedActionPower(
            $simulator,
            $skills[29],
            $actor,
            $target,
            $seedValue,
        ),
    );
    expect($randomPowers->min())->toBeGreaterThanOrEqual(75)
        ->and($randomPowers->max())->toBeLessThanOrEqual(155)
        ->and($randomPowers->unique()->count())->toBeGreaterThan(1);

    vqsv4InvokePrivate($simulator, 'applyBalancedStatus', $target, 'corrosion', 3, 3);
    $actor['hp'] = max(1, $actor['max_hp'] - 200);
    vqsv4ApplyBalancedEffect($simulator, $skills[1], $actor, $target);
    expect($actor['statuses']['defense_up']['value'])->toBe(10)
        ->and($actor['statuses']['defense_up']['turns'])->toBe(2);

    $targetHpBeforeDetonation = $target['hp'];
    vqsv4ResolveDamageMechanics($simulator, $actorPet, $actor, $targetPet, $target, $skills[2]);
    expect($target['hp'])->toBeLessThan($targetHpBeforeDetonation)
        ->and($target['statuses'])->not->toHaveKey('corrosion')
        ->and($target['statuses']['damage_down']['value'])->toBe(15);

    $target['statuses'] = [];
    $targetHpBeforeStorm = $target['hp'];
    vqsv4ApplyBalancedEffect($simulator, $skills[4], $actor, $target);
    expect($target['hp'])->toBeLessThan($targetHpBeforeStorm)
        ->and($target['statuses']['corrosion']['elapsed'])->toBe(1)
        ->and($target['statuses']['damage_down']['value'])->toBe(20)
        ->and($target['statuses']['agility_down']['value'])->toBe(15);
});

/** @return array<string, mixed> */
function vqsv4InitialState(PetBattleSimulator $simulator, Pet $pet, array $deck): array
{
    $method = new ReflectionMethod($simulator, 'initialState');

    return $method->invoke($simulator, $pet, $deck);
}

function vqsv4InvokePrivate(
    PetBattleSimulator $simulator,
    string $methodName,
    array &$state,
    mixed ...$arguments,
): mixed {
    $method = new ReflectionMethod($simulator, $methodName);
    $invokeArguments = [&$state, ...$arguments];

    return $method->invokeArgs($simulator, $invokeArguments);
}

function vqsv4DealDamage(
    PetBattleSimulator $simulator,
    Pet $actorPet,
    array &$actor,
    Pet $targetPet,
    array &$target,
    Skill $skill,
): void {
    $method = new ReflectionMethod($simulator, 'dealDamage');
    $arguments = [$actorPet, &$actor, $targetPet, &$target, 10, $skill, 1];
    $method->invokeArgs($simulator, $arguments);
}

function vqsv4ResolvedActionPower(
    PetBattleSimulator $simulator,
    Skill $skill,
    array $actor,
    array $target,
    int $seedValue,
): int {
    $method = new ReflectionMethod($simulator, 'resolvedActionPower');

    return $method->invoke($simulator, $skill, $actor, $target, $seedValue, 1, 1);
}

function vqsv4ApplyBalancedEffect(
    PetBattleSimulator $simulator,
    Skill $skill,
    array &$actor,
    array &$target,
): void {
    $method = new ReflectionMethod($simulator, 'applyBalancedEffect');
    $arguments = [$skill, &$actor, &$target];
    $method->invokeArgs($simulator, $arguments);
}

function vqsv4ResolveDamageMechanics(
    PetBattleSimulator $simulator,
    Pet $actorPet,
    array &$actor,
    Pet $targetPet,
    array &$target,
    Skill $skill,
): void {
    $method = new ReflectionMethod($simulator, 'resolveApprovedDamageMechanics');
    $arguments = [$actorPet, &$actor, $targetPet, &$target, $skill, 10, 1, 1, 1];
    $method->invokeArgs($simulator, $arguments);
}
