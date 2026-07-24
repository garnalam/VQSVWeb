<?php

namespace App\Support;

use App\Models\PetEvolutionIngredient;
use InvalidArgumentException;

final class EvolutionRecipeData
{
    public const RANK_LABELS = [
        1 => 'Tiết kiệm',
        2 => 'Tiêu chuẩn',
        3 => 'Cao cấp',
        4 => 'Tinh anh',
        5 => 'Đặc trưng',
    ];

    /** @var array<string, int> */
    private const COST_RANKS = [
        'liet-hoa:6:7' => 2,
        'liet-hoa:7:8' => 3,
        'liet-hoa:9:10' => 4,
        'liet-hoa:11:12' => 2,
        'liet-hoa:13:14' => 2,
        'liet-hoa:16:17' => 2,
        'liet-hoa:17:18' => 3,
        'liet-hoa:19:20' => 1,
        'liet-hoa:20:21' => 5,
        'liet-hoa:24:25' => 3,
        'liet-hoa:26:27' => 4,
        'liet-hoa:35:36' => 2,
        'liet-hoa:37:38' => 3,
        'liet-hoa:39:40' => 2,
        'liet-hoa:41:42' => 1,
        'liet-hoa:43:44' => 3,
        'liet-hoa:45:46' => 2,
        'liet-hoa:48:49' => 3,
        'liet-hoa:49:50' => 3,
        'liet-hoa:51:52' => 4,
        'liet-hoa:52:53' => 5,
        'liet-hoa:60:61' => 1,
        'liet-hoa:65:66' => 3,
        'liet-hoa:66:67' => 4,
        'liet-hoa:68:69' => 4,
        'liet-hoa:70:71' => 1,
        'liet-hoa:72:73' => 2,
        'liet-hoa:76:77' => 3,
        'liet-hoa:77:78' => 4,
        'liet-hoa:79:80' => 4,
        'liet-hoa:80:81' => 5,
        'liet-hoa:82:83' => 1,
        'liet-hoa:84:85' => 2,
        'liet-hoa:89:90' => 1,
        'liet-hoa:91:92' => 4,
        'liet-hoa:93:94' => 1,
        'liet-hoa:95:96' => 5,
        'liet-hoa:97:98' => 2,
        'cau-vong:0:1' => 2,
        'cau-vong:1:2' => 2,
        'cau-vong:2:3' => 5,
        'cau-vong:4:5' => 4,
        'cau-vong:4:6' => 5,
        'cau-vong:7:8' => 3,
        'cau-vong:8:9' => 4,
        'cau-vong:10:11' => 2,
        'cau-vong:11:12' => 4,
        'cau-vong:17:18' => 1,
        'cau-vong:18:19' => 2,
        'cau-vong:19:20' => 5,
        'cau-vong:21:22' => 3,
        'cau-vong:22:23' => 4,
        'cau-vong:25:26' => 2,
        'cau-vong:26:27' => 4,
        'cau-vong:30:31' => 3,
        'cau-vong:31:32' => 4,
        'cau-vong:34:35' => 5,
        'cau-vong:36:37' => 2,
        'cau-vong:37:38' => 3,
        'cau-vong:38:39' => 5,
        'cau-vong:40:41' => 2,
        'cau-vong:41:42' => 4,
        'cau-vong:43:44' => 3,
        'cau-vong:44:45' => 4,
        'cau-vong:49:50' => 5,
        'cau-vong:49:51' => 5,
        'cau-vong:52:53' => 1,
        'cau-vong:53:54' => 3,
        'cau-vong:54:55' => 5,
        'cau-vong:56:57' => 5,
        'cau-vong:56:84' => 5,
        'cau-vong:59:60' => 3,
        'cau-vong:60:61' => 4,
        'cau-vong:63:64' => 5,
        'cau-vong:68:69' => 1,
        'cau-vong:69:70' => 2,
        'cau-vong:70:71' => 4,
        'cau-vong:72:73' => 2,
        'cau-vong:73:74' => 4,
        'cau-vong:75:76' => 5,
        'cau-vong:75:77' => 4,
        'cau-vong:79:80' => 2,
        'cau-vong:80:81' => 4,
        'cau-vong:87:88' => 4,
        'cau-vong:90:91' => 5,
        'cau-vong:93:94' => 5,
        'cau-vong:96:97' => 5,
        'cau-vong:99:100' => 4,
    ];

    /** @var array<string, array{basic: int, advanced: int}> */
    private const SPECIES_MATERIALS = [
        'manh-thu' => ['basic' => 16, 'advanced' => 17],
        'thuc-vat' => ['basic' => 18, 'advanced' => 19],
        'hai-duong' => ['basic' => 20, 'advanced' => 21],
        'phi-hanh' => ['basic' => 22, 'advanced' => 23],
        'kim-loai' => ['basic' => 24, 'advanced' => 25],
    ];

    /** @var list<int> */
    private const SIGNATURE_MATERIAL_IDS = [26, 27, 28, 29, 30];

    /**
     * Resolve the reviewed price rank for one exact evolution edge.
     */
    public static function costRank(string $sourceSlug, int $fromGameId, int $toGameId): int
    {
        $identity = self::identity($sourceSlug, $fromGameId, $toGameId);

        return self::COST_RANKS[$identity] ?? throw new InvalidArgumentException(
            "Missing reviewed evolution cost rank for {$identity}.",
        );
    }

    /**
     * Build the canonical cross-game ingredient recipe for one evolution.
     *
     * @param  list<array{item_game_id: int, quantity: int}>  $originalMaterials
     * @return list<array{source: string, source_table: int, game_id: int, quantity: int, role: string}>
     */
    public static function ingredients(
        string $sourceSlug,
        int $fromGameId,
        int $toGameId,
        string $targetSpecies,
        int $targetQualityTier,
        string $evolutionType,
        int $legacyCoreGameId,
        int $legacyCoreQuantity,
        array $originalMaterials,
    ): array {
        $rank = self::costRank($sourceSlug, $fromGameId, $toGameId);
        $ingredients = $sourceSlug === 'liet-hoa'
            ? [self::ingredient('liet-hoa', 3, $legacyCoreGameId, $legacyCoreQuantity, PetEvolutionIngredient::ROLE_CORE)]
            : [self::rainbowCore($targetQualityTier, $evolutionType, $rank, $originalMaterials)];

        $ingredients = [...$ingredients, ...self::speciesIngredients($targetSpecies, $rank)];

        if ($sourceSlug === 'cau-vong') {
            foreach ($originalMaterials as $material) {
                if (in_array($material['item_game_id'], self::SIGNATURE_MATERIAL_IDS, true)) {
                    $ingredients[] = self::ingredient(
                        'cau-vong',
                        0,
                        $material['item_game_id'],
                        $material['quantity'],
                        PetEvolutionIngredient::ROLE_SIGNATURE,
                    );
                }
            }
        }

        return $ingredients;
    }

    /** @return array{source: string, source_table: int, game_id: int, quantity: int, role: string} */
    private static function rainbowCore(
        int $targetQualityTier,
        string $evolutionType,
        int $rank,
        array $originalMaterials,
    ): array {
        $hasSignatureMaterial = collect($originalMaterials)->contains(
            fn (array $material): bool => in_array($material['item_game_id'], self::SIGNATURE_MATERIAL_IDS, true),
        );
        $gameId = $evolutionType === 'mutation'
            ? ($targetQualityTier >= 4 ? 16 : 15)
            : match (true) {
                $targetQualityTier <= 2 => 12,
                $targetQualityTier === 3 => 13,
                default => 14,
            };
        $quantity = $rank === 5 && ! $hasSignatureMaterial ? 2 : 1;

        return self::ingredient('liet-hoa', 3, $gameId, $quantity, PetEvolutionIngredient::ROLE_CORE);
    }

    /**
     * @return list<array{source: string, source_table: int, game_id: int, quantity: int, role: string}>
     */
    private static function speciesIngredients(string $species, int $rank): array
    {
        $materialIds = self::SPECIES_MATERIALS[$species] ?? throw new InvalidArgumentException(
            "Missing evolution materials for species {$species}.",
        );
        [$basicQuantity, $advancedQuantity] = match ($rank) {
            1 => [1, 0],
            2 => [2, 0],
            3 => [2, 1],
            4 => [2, 2],
            5 => [3, 3],
        };
        $ingredients = [self::ingredient(
            'cau-vong',
            0,
            $materialIds['basic'],
            $basicQuantity,
            PetEvolutionIngredient::ROLE_SPECIES,
        )];

        if ($advancedQuantity > 0) {
            $ingredients[] = self::ingredient(
                'cau-vong',
                0,
                $materialIds['advanced'],
                $advancedQuantity,
                PetEvolutionIngredient::ROLE_SPECIES,
            );
        }

        return $ingredients;
    }

    /** @return array{source: string, source_table: int, game_id: int, quantity: int, role: string} */
    private static function ingredient(
        string $source,
        int $sourceTable,
        int $gameId,
        int $quantity,
        string $role,
    ): array {
        return [
            'source' => $source,
            'source_table' => $sourceTable,
            'game_id' => $gameId,
            'quantity' => $quantity,
            'role' => $role,
        ];
    }

    private static function identity(string $sourceSlug, int $fromGameId, int $toGameId): string
    {
        return "{$sourceSlug}:{$fromGameId}:{$toGameId}";
    }
}
