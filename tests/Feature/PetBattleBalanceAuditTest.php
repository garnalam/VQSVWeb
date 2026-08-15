<?php

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Support\PetBalanceAudit;
use App\Support\PetBattleSimulator;
use App\Support\PetEvolutionStageResolver;
use App\Support\PetPowerClassResolver;
use App\Support\PetStatCalculator;
use Database\Seeders\DatabaseSeeder;

use function Pest\Laravel\seed;

test('uses the unified Liệt Hỏa element cycle in single battles', function () {
    $simulator = app(PetBattleSimulator::class);

    expect($simulator->elementMultiplier('hoa', 'moc'))->toBe(1.5)
        ->and($simulator->elementMultiplier('moc', 'hoa'))->toBe(0.75)
        ->and($simulator->elementMultiplier('quy', 'phong'))->toBe(1.5)
        ->and($simulator->elementMultiplier('phong', 'quy'))->toBe(0.75)
        ->and($simulator->elementMultiplier('hoa', 'dien'))->toBe(1.0)
        ->and($simulator->elementMultiplier('thuy', 'thuy'))->toBe(1.0);
});

test('audits deterministic level 50 single battles for the complete 274 pet roster', function () {
    seed(DatabaseSeeder::class);

    $audit = app(PetBalanceAudit::class);
    $deterministicFirst = $audit->run(2, 2);
    $deterministicSecond = $audit->run(2, 2);
    $report = $audit->run(12, 3);
    $pets = collect($report['pets']);
    $outgoingPetIds = PetEvolution::query()->pluck('from_pet_id')->unique();

    expect($deterministicSecond)->toBe($deterministicFirst)
        ->and($report['ruleset']['name'])->toBe('liet-hoa-unified-1v1-v4')
        ->and($report['ruleset']['matchmaking'])->toBe('same_power_class_and_evolution_tier_then_combat_score_and_element_relation')
        ->and($report['ruleset']['level'])->toBe(50)
        ->and($report['ruleset']['star'])->toBe(3)
        ->and($report['ruleset']['maximum_rounds'])->toBe(30)
        ->and($report['ruleset']['combat_score_weights'])->toBe([
            'hp' => 0.25,
            'strength' => 1.0,
            'defense' => 3.0,
            'agility' => 2.0,
        ])
        ->and($report['summary']['pets'])->toBe(274)
        ->and($report['summary']['battles'])->toBeGreaterThan(0)
        ->and($report['summary']['stage_mismatch_matchups'])->toBe(0)
        ->and($report['summary']['power_class_mismatch_matchups'])->toBe(0)
        ->and($report['summary']['low_outliers'])->toBeLessThanOrEqual(60)
        ->and($report['summary']['high_outliers'])->toBeLessThanOrEqual(55)
        ->and($report['summary']['stall_outliers'])->toBe(0)
        ->and($report['summary']['undersampled_pets'])->toBe(
            $pets->where('opponents', '<', 12)->count(),
        )
        ->and($report['by_role']['guardian']['win_rate'])->toBeLessThan(60)
        ->and($report['by_role']['controller']['win_rate'])->toBeGreaterThanOrEqual(45)
        ->and($report['by_element']['moc']['win_rate'])->toBeGreaterThan(45)
        ->and($report['by_element']['thuy']['win_rate'])->toBeGreaterThan(50)
        ->and($report['by_element']['quy']['win_rate'])->toBeLessThan(40)
        ->and($report['by_element']['hoa']['win_rate'])->toBeLessThan(58)
        ->and($pets)->toHaveCount(274)
        ->and($pets->pluck('id')->unique())->toHaveCount(274)
        ->and($pets->max('average_rounds'))->toBeLessThanOrEqual(30)
        ->and($pets->min('deck_size'))->toBeGreaterThanOrEqual(2)
        ->and($pets->max('deck_size'))->toBeLessThanOrEqual(5)
        ->and($pets->min('damage_skills'))->toBeGreaterThanOrEqual(2)
        ->and($report['invalid_decks'])->toBeEmpty()
        ->and($report['outliers']['stall'])->toBeEmpty()
        ->and(array_keys($report['by_evolution_tier']))->toEqualCanonicalizing(
            $pets->pluck('evolution_tier')->unique()->values()->all(),
        )
        ->and(array_keys($report['by_power_class']))->toEqualCanonicalizing([
            PetPowerClassResolver::STANDARD,
            PetPowerClassResolver::DIVINE,
        ])
        ->and(array_keys($report['by_element']))->toHaveCount(7)
        ->and(array_keys($report['by_species']))->toHaveCount(5)
        ->and(array_keys($report['by_role']))->toHaveCount(count(Pet::COMBAT_ROLES))
        ->and(array_keys($report['by_source']))->toHaveCount(3);

    foreach ($pets as $pet) {
        $sameClassTierCount = $pets
            ->where('power_class', $pet['power_class'])
            ->where('evolution_tier', $pet['evolution_tier'])
            ->count();
        $expectedMinimumOpponents = min(12, $sameClassTierCount - 1);

        expect($pet['wins'] + $pet['losses'] + $pet['draws'])->toBe($pet['games'], $pet['name'])
            ->and($pet['opponents'])->toBeGreaterThanOrEqual($expectedMinimumOpponents, $pet['name'])
            ->and($pet['evolution_tier'])->toBeIn(array_keys(PetEvolutionStageResolver::TIER_LABELS))
            ->and($pet['form_number'])->toBeGreaterThanOrEqual(1)
            ->and($pet['family_max_forms'])->toBeGreaterThanOrEqual($pet['form_number'])
            ->and($pet['win_rate'])->toBeGreaterThanOrEqual(0)
            ->and($pet['win_rate'])->toBeLessThanOrEqual(100);

        if ($pet['evolution_tier'] === 'standalone') {
            expect($pet['form_number'])->toBe(1)
                ->and($pet['family_max_forms'])->toBe(1);
        }

        if ($pet['evolution_tier'] === 'initial') {
            expect($pet['form_number'])->toBe(1);
        }

        if ($pet['evolution_tier'] === 'middle_early') {
            expect($pet['progress_ratio'])->toBeLessThanOrEqual(0.5);
        }

        if ($pet['evolution_tier'] === 'middle_late') {
            expect($pet['progress_ratio'])->toBeGreaterThan(0.5)
                ->and($pet['progress_ratio'])->toBeLessThan(1);
        }

        if ($pet['evolution_tier'] === 'final') {
            expect($outgoingPetIds)->not->toContain($pet['id']);
        }
    }

    $divinePets = $pets->where('power_class', PetPowerClassResolver::DIVINE);
    $balanceOutliers = collect($report['outliers']['low'])
        ->concat($report['outliers']['high']);

    expect($divinePets)->toHaveCount(19)
        ->and($report['divine_observations'])->toHaveCount(19)
        ->and($balanceOutliers->every(
            fn (array $pet): bool => $pet['power_class'] === PetPowerClassResolver::STANDARD,
        ))->toBeTrue()
        ->and($divinePets->where('game_source', 'liet-hoa')->pluck('game_id')->all())
        ->toEqualCanonicalizing([15, 31, 47, 63, 75, 87, 99])
        ->and($divinePets->where('game_source', 'cau-vong')->pluck('game_id')->all())
        ->toEqualCanonicalizing([85, 86, 89, 92, 95, 98, 101])
        ->and($divinePets->where('game_source', 'vqsv4')->pluck('game_id')->all())
        ->toEqualCanonicalizing([79, 80, 81, 82, 83]);

    $petResultsByIdentity = $pets->keyBy(
        fn (array $pet): string => "{$pet['game_source']}:{$pet['game_id']}",
    );
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $dauUng = Pet::query()
        ->whereBelongsTo($lietHoa)
        ->where('game_id', 95)
        ->firstOrFail();

    expect($petResultsByIdentity['cau-vong:18']['win_rate'])->toBeBetween(15, 55)
        ->and($petResultsByIdentity['liet-hoa:17']['win_rate'])->toBeBetween(10, 55)
        ->and($petResultsByIdentity['liet-hoa:17']['average_rounds'])->toBeLessThanOrEqual(18)
        ->and($petResultsByIdentity['cau-vong:48']['win_rate'])->toBeBetween(50, 80)
        ->and($petResultsByIdentity['cau-vong:48']['average_rounds'])->toBeLessThanOrEqual(6)
        ->and($petResultsByIdentity['liet-hoa:95']['win_rate'])->toBeBetween(45, 80)
        ->and(app(PetStatCalculator::class)->calculate($dauUng, 50))->toBe([
            'hp' => 869,
            'strength' => 276,
            'defense' => 100,
            'agility' => 32,
        ]);
});
