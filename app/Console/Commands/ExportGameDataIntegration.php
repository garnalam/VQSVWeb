<?php

namespace App\Console\Commands;

use App\Support\GameDataIntegrationSnapshotExporter;
use Illuminate\Console\Attributes\Description;
use Illuminate\Console\Attributes\Signature;
use Illuminate\Console\Command;
use Illuminate\Support\Str;

#[Signature('game:export-integration-data {--database= : SQLite output path} {--manifest= : JSON manifest output path}')]
#[Description('Export the unified Pet, Skill, Effect, Item, trait, learnset, and evolution contract')]
class ExportGameDataIntegration extends Command
{
    /**
     * Execute the console command.
     */
    public function handle(GameDataIntegrationSnapshotExporter $exporter): int
    {
        $databasePath = $this->absolutePath(
            (string) ($this->option('database') ?: storage_path('app/private/integration/vqsv-game-data.sqlite')),
        );
        $manifestOption = $this->option('manifest');
        $manifestPath = $manifestOption === null || $manifestOption === ''
            ? null
            : $this->absolutePath((string) $manifestOption);
        $result = $exporter->export($databasePath, $manifestPath);

        $this->components->info('VQSV integration snapshot exported.');
        $this->components->twoColumnDetail('SQLite', $result['database_path']);
        $this->components->twoColumnDetail('Manifest', $result['manifest_path']);
        $this->components->twoColumnDetail('SHA-256', $result['checksum_sha256']);
        $this->table(
            ['Table', 'Rows'],
            collect($result['counts'])->map(fn (int $count, string $table): array => [$table, $count])->values()->all(),
        );

        return self::SUCCESS;
    }

    private function absolutePath(string $path): string
    {
        return Str::startsWith($path, ['/', '\\']) || preg_match('/^[A-Za-z]:[\\\\\/]/', $path) === 1
            ? $path
            : base_path($path);
    }
}
