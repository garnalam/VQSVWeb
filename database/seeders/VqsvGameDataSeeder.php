<?php

namespace Database\Seeders;

use App\Models\Effect;
use App\Models\Element;
use App\Models\Item;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\Skill;
use App\Models\SkillUnlockRule;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;
use RuntimeException;
use UnexpectedValueException;

class VqsvGameDataSeeder extends Seeder
{
    private const GAME_SOURCE_ID = 1;

    private const DATABASE_SOURCE = 'resources/decoded/04_resources/raw/data/script/db.mid';

    private const STRING_SOURCE = 'resources/decoded/04_resources/raw/data/script/chs.mid';

    /** @var array<int, int> */
    private const EXPECTED_TABLE_COUNTS = [100, 70, 8, 18, 15, 11, 15, 11, 4];

    /** @var array<int, array{name: string, slug: string, color: string}> */
    private const ELEMENTS = [
        ['name' => 'Hỏa', 'slug' => 'hoa', 'color' => '#ef4444'],
        ['name' => 'Mộc', 'slug' => 'moc', 'color' => '#22c55e'],
        ['name' => 'Thổ', 'slug' => 'tho', 'color' => '#a16207'],
        ['name' => 'Thủy', 'slug' => 'thuy', 'color' => '#3b82f6'],
        ['name' => 'Điện', 'slug' => 'dien', 'color' => '#eab308'],
        ['name' => 'Quỷ', 'slug' => 'quy', 'color' => '#7e22ce'],
        ['name' => 'Phong', 'slug' => 'phong', 'color' => '#06b6d4'],
    ];

    /** @var list<int> */
    private const SKILL_UNLOCK_LEVELS = [5, 10, 20, 30, 40];

    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $tables = $this->decodeDatabase(base_path(self::DATABASE_SOURCE));
        $strings = $this->decodeStrings(base_path(self::STRING_SOURCE));

        DB::transaction(function () use ($tables, $strings): void {
            $elementIds = $this->seedElements();
            $effectIds = $this->seedEffects($tables[6], $tables[7], $strings);
            $itemIds = $this->seedItems($tables, $strings);
            $petIds = $this->seedPets($tables[0], $strings, $elementIds);

            $this->seedSkills($tables[1], $strings, $elementIds, $effectIds);
            $this->seedSkillUnlockRules($tables[8]);
            $this->seedPetEvolutions($tables[0], $petIds, $itemIds);
        });
    }

    /**
     * @return array<int, int>
     */
    private function seedElements(): array
    {
        $elementIds = [];

        foreach (self::ELEMENTS as $gameId => $attributes) {
            $element = Element::query()->updateOrCreate(
                ['game_source_id' => self::GAME_SOURCE_ID, 'game_id' => $gameId],
                $attributes,
            );

            $elementIds[$gameId] = (int) $element->getKey();
        }

        return $elementIds;
    }

    /**
     * @param  list<list<int>>  $beneficialRows
     * @param  list<list<int>>  $harmfulRows
     * @param  list<string>  $strings
     * @return array<string, int>
     */
    private function seedEffects(array $beneficialRows, array $harmfulRows, array $strings): array
    {
        $effectIds = [];

        foreach ([6 => $beneficialRows, 7 => $harmfulRows] as $sourceTable => $rows) {
            foreach ($rows as $gameId => $row) {
                $name = $this->gameString($strings, $row[0]);
                $effect = Effect::query()->updateOrCreate(
                    ['game_source_id' => self::GAME_SOURCE_ID, 'source_table' => $sourceTable, 'game_id' => $gameId],
                    [
                        'kind' => $sourceTable === 6 ? 'beneficial' : 'harmful',
                        'name_original' => $name,
                        'name' => $name,
                        'description' => $this->gameString($strings, $row[1]),
                        'duration' => $row[2],
                        'parameters' => $sourceTable === 6 ? array_slice($row, 3) : null,
                        'raw_values' => $row,
                    ],
                );

                $effectIds[$this->sourceIdentity($sourceTable, $gameId)] = (int) $effect->getKey();
            }
        }

        return $effectIds;
    }

    /**
     * @param  list<list<list<int>>>  $tables
     * @param  list<string>  $strings
     * @return array<string, int>
     */
    private function seedItems(array $tables, array $strings): array
    {
        $itemIds = [];

        foreach ([2, 3, 4, 5] as $sourceTable) {
            foreach ($tables[$sourceTable] as $gameId => $row) {
                $name = $this->gameString($strings, $row[0]);
                $description = $this->gameString($strings, $row[2]);
                $item = Item::query()->updateOrCreate(
                    ['game_source_id' => self::GAME_SOURCE_ID, 'source_table' => $sourceTable, 'game_id' => $gameId],
                    [
                        'name_original' => $name,
                        'name' => $name,
                        'slug' => $this->stableSlug($sourceTable.'-'.$gameId, $name),
                        'description_original' => $description,
                        'description' => $description,
                        'category' => $this->itemCategory($sourceTable, $gameId),
                        'frame_id' => $sourceTable === 2 ? null : $row[1],
                        'cost' => $sourceTable === 4 ? $row[3] : null,
                        'currency_code' => $sourceTable === 4 ? $row[4] : null,
                        'effect_type' => $sourceTable === 4 ? $row[5] : null,
                        'effect_parameters' => $this->itemEffectParameters($sourceTable, $row, $strings),
                        'raw_values' => $row,
                    ],
                );

                $itemIds[$this->sourceIdentity($sourceTable, $gameId)] = (int) $item->getKey();
            }
        }

        return $itemIds;
    }

    /**
     * @param  list<list<int>>  $rows
     * @param  list<string>  $strings
     * @param  array<int, int>  $elementIds
     * @return array<int, int>
     */
    private function seedPets(array $rows, array $strings, array $elementIds): array
    {
        $petIds = [];

        foreach ($rows as $gameId => $row) {
            $elementId = $elementIds[$row[1]] ?? throw new UnexpectedValueException(
                "Pet {$gameId} references missing element {$row[1]}.",
            );
            $name = $this->gameString($strings, $row[0]);
            $taxonomy = PetTaxonomyData::for('liet-hoa', $gameId);
            $pet = Pet::query()->updateOrCreate(
                ['game_source_id' => self::GAME_SOURCE_ID, 'game_id' => $gameId],
                [
                    'element_id' => $elementId,
                    'combat_element' => $taxonomy['combat_element'],
                    'species' => $taxonomy['species'],
                    'name_original' => $name,
                    'name' => $name,
                    'slug' => $this->stableSlug((string) $gameId, $name),
                    'variant_code' => $row[2],
                    'quality_tier' => $row[3],
                    'rarity_or_growth_code' => $row[4],
                    'hp_base' => $row[5],
                    'hp_per_level' => $row[6],
                    'hp_offset' => $row[7],
                    'stat_2_base' => $row[8],
                    'stat_2_per_level' => $row[9],
                    'stat_2_offset' => $row[10],
                    'stat_3_base' => $row[11],
                    'stat_3_per_10_levels' => $row[12],
                    'stat_3_offset' => $row[13],
                    'stat_4_base' => $row[14],
                    'stat_4_per_10_levels' => $row[15],
                    'stat_4_offset' => $row[16],
                    'sprite_id' => $row[17],
                    'learning_group' => $row[18],
                    'effectiveness_class' => $row[22],
                    'raw_values' => $row,
                ],
            );

            $petIds[$gameId] = (int) $pet->getKey();
        }

        return $petIds;
    }

    /**
     * @param  list<list<int>>  $rows
     * @param  list<string>  $strings
     * @param  array<int, int>  $elementIds
     * @param  array<string, int>  $effectIds
     */
    private function seedSkills(array $rows, array $strings, array $elementIds, array $effectIds): void
    {
        foreach ($rows as $gameId => $row) {
            $elementId = $elementIds[$row[0]] ?? throw new UnexpectedValueException(
                "Skill {$gameId} references missing element {$row[0]}.",
            );
            $effectId = null;

            if ($row[6] > 0 && $row[7] >= 0) {
                $effectSourceTable = $row[6] === 1 ? 6 : 7;
                $identity = $this->sourceIdentity($effectSourceTable, $row[7]);
                $effectId = $effectIds[$identity] ?? throw new UnexpectedValueException(
                    "Skill {$gameId} references missing effect {$identity}.",
                );
            }

            $name = $this->gameString($strings, $row[1]);
            $description = $this->gameString($strings, $row[2]);

            Skill::query()->updateOrCreate(
                ['game_source_id' => self::GAME_SOURCE_ID, 'game_id' => $gameId],
                [
                    'element_id' => $elementId,
                    'effect_id' => $effectId,
                    'name_original' => $name,
                    'name' => $name,
                    'slug' => $this->stableSlug((string) $gameId, $name),
                    'description_original' => $description,
                    'description' => $description,
                    'power_percent' => $row[3],
                    'tier' => $row[4],
                    'max_uses' => $row[5],
                    'effect_mode' => $row[6],
                    'effect_parameter' => $row[8],
                    'target_side' => $row[9],
                    'raw_values' => $row,
                ],
            );
        }
    }

    /**
     * @param  list<list<int>>  $rows
     */
    private function seedSkillUnlockRules(array $rows): void
    {
        foreach ($rows as $learningGroup => $tiers) {
            foreach (self::SKILL_UNLOCK_LEVELS as $index => $level) {
                SkillUnlockRule::query()->updateOrCreate(
                    ['game_source_id' => self::GAME_SOURCE_ID, 'learning_group' => $learningGroup, 'level' => $level],
                    ['maximum_skill_tier' => $tiers[$index]],
                );
            }
        }
    }

    /**
     * @param  list<list<int>>  $petRows
     * @param  array<int, int>  $petIds
     * @param  array<string, int>  $itemIds
     */
    private function seedPetEvolutions(array $petRows, array $petIds, array $itemIds): void
    {
        foreach ($petRows as $gameId => $row) {
            if ($row[19] < 0) {
                continue;
            }

            $targetGameId = $row[19];
            $materialGameId = $row[20] + 12;
            $materialIdentity = $this->sourceIdentity(3, $materialGameId);
            $sourcePetId = $petIds[$gameId] ?? throw new UnexpectedValueException("Missing source pet {$gameId}.");
            $targetPetId = $petIds[$targetGameId] ?? throw new UnexpectedValueException("Missing target pet {$targetGameId}.");
            $itemId = $itemIds[$materialIdentity] ?? throw new UnexpectedValueException("Missing item {$materialIdentity}.");

            PetEvolution::query()->updateOrCreate(
                ['from_pet_id' => $sourcePetId, 'to_pet_id' => $targetPetId],
                [
                    'item_id' => $itemId,
                    'quantity' => $row[21],
                    'evolution_type' => in_array($materialGameId, [15, 16], true) ? 'mutation' : 'evolution',
                ],
            );
        }
    }

    /**
     * @param  list<int>  $row
     * @param  list<string>  $strings
     * @return array<string, mixed>|null
     */
    private function itemEffectParameters(int $sourceTable, array $row, array $strings): ?array
    {
        return match ($sourceTable) {
            2 => [
                'values' => array_slice($row, 5),
                'upgrade_description' => $this->gameString($strings, $row[3]),
                'condition' => $this->gameString($strings, $row[4]),
            ],
            3 => ['values' => array_slice($row, 3)],
            4 => ['values' => array_slice($row, 6)],
            default => null,
        };
    }

    private function itemCategory(int $sourceTable, int $gameId): string
    {
        return match ($sourceTable) {
            2 => 'badge',
            3 => match (true) {
                $gameId <= 11 => 'accessory',
                $gameId <= 14 => 'evolution_material',
                $gameId <= 16 => 'mutation_material',
                default => 'key',
            },
            4 => $gameId <= 3 ? 'capture_ball' : ($gameId <= 12 ? 'recovery' : 'utility'),
            5 => match (true) {
                $gameId === 0 => 'pet_egg',
                $gameId <= 4 => 'mount',
                $gameId === 5 => 'encyclopedia',
                $gameId === 6 => 'badge_book',
                $gameId <= 9 => 'stat_modifier',
                default => 'teleport',
            },
            default => throw new UnexpectedValueException("Unsupported item source table {$sourceTable}."),
        };
    }

    private function stableSlug(string $identity, string $name): string
    {
        return $identity.'-'.(Str::slug($name) ?: 'record');
    }

    private function sourceIdentity(int $sourceTable, int $gameId): string
    {
        return $sourceTable.':'.$gameId;
    }

    /**
     * @param  list<string>  $strings
     */
    private function gameString(array $strings, int $id): string
    {
        return $strings[$id] ?? throw new UnexpectedValueException("Missing game string {$id}.");
    }

    /**
     * @return list<list<list<int>>>
     */
    private function decodeDatabase(string $path): array
    {
        $binary = $this->readBinaryFile($path);
        $offset = 0;
        $tables = [];

        foreach (self::EXPECTED_TABLE_COUNTS as $tableIndex => $expectedCount) {
            $rowCount = $this->readSignedShort($binary, $offset);

            if ($rowCount !== $expectedCount) {
                throw new UnexpectedValueException(
                    "Table {$tableIndex} contains {$rowCount} rows; expected {$expectedCount}.",
                );
            }

            $rows = [];

            for ($rowIndex = 0; $rowIndex < $rowCount; $rowIndex++) {
                $width = $this->readSignedShort($binary, $offset);
                $row = [];

                for ($column = 0; $column < $width; $column++) {
                    $row[] = $this->readSignedShort($binary, $offset);
                }

                $rows[] = $row;
            }

            $tables[] = $rows;
        }

        if ($offset !== strlen($binary)) {
            throw new UnexpectedValueException('The decoded database did not consume the entire source file.');
        }

        return $tables;
    }

    /**
     * @return list<string>
     */
    private function decodeStrings(string $path): array
    {
        $binary = $this->readBinaryFile($path);
        $offset = 0;
        $stringCount = $this->readSignedShort($binary, $offset);
        $strings = [];

        for ($stringIndex = 0; $stringIndex < $stringCount; $stringIndex++) {
            $segmentCount = $this->readSignedShort($binary, $offset);
            $utf16 = '';

            for ($segmentIndex = 0; $segmentIndex < $segmentCount; $segmentIndex++) {
                $length = $this->readUnsignedByte($binary, $offset);

                if ($length === 255) {
                    $length = $this->readSignedShort($binary, $offset);
                }

                for ($character = 0; $character < $length; $character++) {
                    $utf16 .= pack('n', $this->readUnsignedShort($binary, $offset));
                }
            }

            $strings[] = mb_convert_encoding($utf16, 'UTF-8', 'UTF-16BE');
        }

        if ($offset !== strlen($binary)) {
            throw new UnexpectedValueException('The decoded string table did not consume the entire source file.');
        }

        return $strings;
    }

    private function readBinaryFile(string $path): string
    {
        $contents = file_get_contents($path);

        if ($contents === false) {
            throw new RuntimeException("Unable to read decoded game source: {$path}");
        }

        return $contents;
    }

    private function readSignedShort(string $binary, int &$offset): int
    {
        $value = $this->readUnsignedShort($binary, $offset);

        return $value >= 0x8000 ? $value - 0x10000 : $value;
    }

    private function readUnsignedShort(string $binary, int &$offset): int
    {
        $this->ensureBytesAvailable($binary, $offset, 2);
        $value = (ord($binary[$offset]) << 8) | ord($binary[$offset + 1]);
        $offset += 2;

        return $value;
    }

    private function readUnsignedByte(string $binary, int &$offset): int
    {
        $this->ensureBytesAvailable($binary, $offset, 1);
        $value = ord($binary[$offset]);
        $offset++;

        return $value;
    }

    private function ensureBytesAvailable(string $binary, int $offset, int $length): void
    {
        if ($offset < 0 || $offset + $length > strlen($binary)) {
            throw new UnexpectedValueException("Unexpected end of decoded game source at byte {$offset}.");
        }
    }
}
