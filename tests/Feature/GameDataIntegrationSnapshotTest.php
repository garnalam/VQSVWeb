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
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM pets')->fetchColumn())->toBe(202)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM skills WHERE is_active = 1')->fetchColumn())->toBe(99)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM pet_skill_learnsets')->fetchColumn())->toBe(1160)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM item_decisions WHERE decision = "remove"')->fetchColumn())->toBe(10)
        ->and((int) $snapshot->query('SELECT COUNT(*) FROM pet_evolution_ingredients')->fetchColumn())->toBe(239);

    $pet = $snapshot->query("SELECT pet_key, provenance_json FROM pets WHERE pet_key = 'CV-000'")->fetch();
    $skill = $snapshot->query("SELECT skill_key, mechanics_json, balance_version FROM skills WHERE skill_key = 'LH-SKILL-00'")->fetch();
    $manifest = json_decode(File::get($manifestPath), true, flags: JSON_THROW_ON_ERROR);

    expect($pet['pet_key'])->toBe('CV-000')
        ->and(json_decode($pet['provenance_json'], true, flags: JSON_THROW_ON_ERROR)['stats'])->toBe('unified_balance')
        ->and($skill['skill_key'])->toBe('LH-SKILL-00')
        ->and($skill['balance_version'])->toBe('unified-v5')
        ->and(json_decode($skill['mechanics_json'], true, flags: JSON_THROW_ON_ERROR))->toHaveKey('type')
        ->and($manifest['checksum_sha256'])->toBe(hash_file('sha256', $databasePath))
        ->and($manifest['counts']['pets'])->toBe(202);

    $snapshot = null;
    File::delete([$databasePath, $manifestPath]);
});
