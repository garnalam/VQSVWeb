<?php

namespace App\Support;

use RuntimeException;
use SplFileObject;

final class UnifiedPetLearnsetCatalog
{
    public const VERSION = 'pet_skill_learnsets-v3';

    public const LEARNSET_COUNT = 2337;

    public const LEARNSET_SHA256 = '8de1eb3feb46028fa404f16af558968cec36e0caf617f8ce81b111dff50257fa';

    public const EVOLUTION_COUNT = 133;

    public const EVOLUTION_SHA256 = 'bde8fab9bfe1d7f4b482aac37be0a7ee754491d037b1f8b02b3d0f18d96f2bb7';

    /** @var list<int> */
    public const UNLOCK_MILESTONES = [1, 5, 8, 10, 15, 18, 20, 25, 28, 30, 35, 38, 40, 45, 50];

    /** @return list<array<string, string>> */
    public static function learnsets(): array
    {
        return self::read(
            resource_path('decoded/06_analysis/pet-skill-learnsets-v3.tsv'),
            [
                'pet_key',
                'skill_key',
                'runtime_skill_id',
                'grant_set',
                'progression_grade',
                'required_form_pet_key',
                'unlock_level',
                'source_type',
                'combat_role',
                'is_signature',
                'sort_order',
                'provenance',
            ],
            self::LEARNSET_COUNT,
            self::LEARNSET_SHA256,
        );
    }

    /** @return list<array<string, string>> */
    public static function evolutions(): array
    {
        return self::read(
            resource_path('decoded/06_analysis/pet-skill-learnset-evolutions-v3.tsv'),
            [
                'evolution_key',
                'from_pet_key',
                'to_pet_key',
                'evolution_type',
                'inherits_skills',
                'topology_provenance',
            ],
            self::EVOLUTION_COUNT,
            self::EVOLUTION_SHA256,
        );
    }

    /**
     * @param  list<string>  $expectedHeader
     * @return list<array<string, string>>
     */
    private static function read(string $path, array $expectedHeader, int $expectedCount, string $expectedSha256): array
    {
        if (! is_file($path)) {
            throw new RuntimeException("Unified learnset contract not found: {$path}");
        }

        if (hash_file('sha256', $path) !== $expectedSha256) {
            throw new RuntimeException("Unified learnset contract checksum mismatch: {$path}");
        }

        $file = new SplFileObject($path);
        $file->setFlags(SplFileObject::DROP_NEW_LINE | SplFileObject::SKIP_EMPTY);
        $header = null;
        $rows = [];

        foreach ($file as $line) {
            if (! is_string($line) || trim($line) === '') {
                continue;
            }

            $columns = str_getcsv($line, "\t", '"', '');

            if ($header === null) {
                $columns[0] = ltrim($columns[0], "\xEF\xBB\xBF");
                $header = $columns;

                if ($header !== $expectedHeader) {
                    throw new RuntimeException("Unexpected unified learnset header in {$path}.");
                }

                continue;
            }

            if (count($columns) !== count($header)) {
                throw new RuntimeException("Malformed unified learnset row in {$path}.");
            }

            /** @var array<string, string> $row */
            $row = array_combine($header, $columns);
            $rows[] = $row;
        }

        if (count($rows) !== $expectedCount) {
            throw new RuntimeException("Expected {$expectedCount} unified learnset rows in {$path}; found ".count($rows).'.');
        }

        return $rows;
    }
}
