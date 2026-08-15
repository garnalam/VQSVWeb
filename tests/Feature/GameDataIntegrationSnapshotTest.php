<?php

use Database\Seeders\DatabaseSeeder;
use Illuminate\Support\Facades\File;

use function Pest\Laravel\artisan;
use function Pest\Laravel\seed;

test('exports a portable gameplay integration database with provenance and stable keys', function () {
    seed(DatabaseSeeder::class);

    $databasePath = storage_path('framework/testing/vqsv-game-data-test.sqlite');
    $manifestPath = storage_path('framework/testing/vqsv-game-data-test.manifest.json');
    File::delete([$databasePath, $manifestPath]);

    artisan('game:export-integration-data', [
        '--database' => $databasePath,
        '--manifest' => $manifestPath,
    ])->assertSuccessful();

    $snapshot = new PDO('sqlite:'.$databasePath);
    $snapshot->setAttribute(PDO::ATTR_DEFAULT_FETCH_MODE, PDO::FETCH_ASSOC);

    expect(File::exists($databasePath))->toBeTrue()
        ->and(File::exists($manifestPath))->toBeTrue()
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM pets')->fetchColumn())->toBe(274)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM skills WHERE is_active = 1')->fetchColumn())->toBe(136)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM pet_skill_learnsets')->fetchColumn())->toBe(2337)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM pet_evolutions WHERE inherits_skills = 0')->fetchColumn())->toBe(14)
        ->and((int) $snapshot->query("SELECT COUNT(*) FROM traits WHERE slot_type = 'physical'")->fetchColumn())->toBe(19)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM item_decisions WHERE decision = "remove"')->fetchColumn())->toBe(10)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM pet_evolution_ingredients')->fetchColumn())->toBe(374)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM pet_mutation_recipes')->fetchColumn())->toBe(23)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM pet_mutation_ingredients')->fetchColumn())->toBe(69);

    $pet = $snapshot->query("SELECT pet_key, provenance_json FROM pets WHERE pet_key = 'CV-003'")->fetch();
    $skill = $snapshot->query("SELECT skill_key, mechanics_json, balance_version FROM skills WHERE skill_key = 'LH-SKILL-00'")->fetch();
    $petColumns = collect($snapshot->query("PRAGMA table_info('pets')")->fetchAll())->pluck('name');
    $manifest = json_decode(File::get($manifestPath), true, flags: JSON_THROW_ON_ERROR);

    expect($pet['pet_key'])->toBe('CV-003')
        ->and($manifest['schema_version'])->toBe('2.1.0')
        ->and($manifest['data_version'])->toBe('unified-2026-08-16.1')
        ->and($manifest['pet_stat_profile_version'])->toBe('unified-v4-pet-growth-v2')
        ->and($manifest['learnset_version'])->toBe('pet_skill_learnsets-v3')
        ->and($petColumns)->not->toContain('talent_key')
        ->and($manifest['skill_balance_version'])->toBe('unified-v7')
        ->and(json_decode($pet['provenance_json'], true, flags: JSON_THROW_ON_ERROR)['stats'])->toBe('unified_balance')
        ->and($skill['skill_key'])->toBe('LH-SKILL-00')
        ->and($skill['balance_version'])->toBe('unified-v7')
        ->and(json_decode($skill['mechanics_json'], true, flags: JSON_THROW_ON_ERROR))->toHaveKey('type')
        ->and($manifest['checksum_sha256'])->toBe(hash_file('sha256', $databasePath))
        ->and($manifest['counts']['pets'])->toBe(274)
        ->and($manifest['counts']['pet_mutation_recipes'])->toBe(23);

    $snapshot = null;
    File::delete([$databasePath, $manifestPath]);
});
