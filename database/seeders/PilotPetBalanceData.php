<?php

namespace Database\Seeders;

use InvalidArgumentException;

final class PilotPetBalanceData
{
    /**
     * @return array<string, array<int, array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}>>
     */
    public static function profiles(): array
    {
        return [
            'liet-hoa' => [
                6 => self::profile('hoa', 'manh-thu', 'bruiser', 'striker', 'MT-02', 20, 16, 10, 4, 5, 19, 5, 3),
                7 => self::profile('hoa', 'manh-thu', 'bruiser', 'striker', 'MT-04', 30, 18, 50, 4, 5, 21, 4, 4),
                8 => self::profile('hoa', 'manh-thu', 'striker', 'bruiser', 'MT-01', 50, 21, 30, 6, 5, 24, 5, 4),
                16 => self::profile('moc', 'hai-duong', 'controller', 'support', 'HD-01', 20, 14, 10, 4, 5, 19, 7, 3),
                17 => self::profile('moc', 'hai-duong', 'support', 'controller', 'HD-02', 60, 16, 35, 4, 5, 23, 5, 4),
                18 => self::profile('moc', 'hai-duong', 'guardian', 'controller', 'HD-03', 50, 20, 35, 5, 5, 30, 7, 3),
                41 => self::profile('tho', 'kim-loai', 'guardian', 'bruiser', 'KL-01', 50, 22, 30, 4, 10, 28, 4, 2),
                42 => self::profile('quy', 'kim-loai', 'bruiser', 'controller', 'KL-04', 70, 21, 40, 6, 10, 26, 6, 2),
                51 => self::profile('thuy', 'hai-duong', 'support', 'controller', 'HD-02', 50, 19, 5, 4, 5, 20, 3, 4),
                52 => self::profile('thuy', 'hai-duong', 'controller', 'support', 'HD-03', 80, 22, 40, 4, 5, 24, 5, 4),
                53 => self::profile('thuy', 'hai-duong', 'bruiser', 'guardian', 'HD-04', 70, 25, 60, 5, 10, 27, 7, 3),
                68 => self::profile('dien', 'manh-thu', 'versatile', 'support', 'MT-02', 20, 18, 10, 4, 5, 21, 5, 4),
                69 => self::profile('dien', 'manh-thu', 'controller', 'striker', 'MT-03', 30, 21, 25, 5, 5, 26, 4, 6),
                99 => self::profile('phong', 'phi-hanh', 'controller', 'support', 'PH-03', 100, 28, 40, 7, 10, 20, 9, 7),
            ],
            'cau-vong' => [
                4 => self::profile('moc', 'thuc-vat', 'support', 'controller', 'TV-01', 50, 13, 5, 4, 5, 19, 3, 4),
                5 => self::profile('moc', 'thuc-vat', 'support', 'controller', 'TV-01', 50, 20, 50, 4, 10, 26, 3, 5),
                6 => self::profile('quy', 'thuc-vat', 'striker', 'controller', 'TV-04', 50, 17, 35, 6, 5, 21, 6, 5),
                17 => self::profile('hoa', 'kim-loai', 'guardian', 'bruiser', 'KL-01', 60, 14, 20, 4, 5, 20, 5, 3),
                18 => self::profile('hoa', 'kim-loai', 'bruiser', 'guardian', 'KL-01', 80, 16, 10, 5, 5, 23, 3, 4),
                19 => self::profile('hoa', 'kim-loai', 'bruiser', 'striker', 'KL-03', 80, 19, 10, 6, 10, 26, 4, 4),
                20 => self::profile('hoa', 'kim-loai', 'striker', 'bruiser', 'KL-04', 100, 22, 10, 7, 10, 28, 6, 4),
                25 => self::profile('tho', 'kim-loai', 'guardian', 'support', 'KL-01', 70, 15, 5, 4, 5, 24, 5, 2),
                26 => self::profile('tho', 'kim-loai', 'guardian', 'controller', 'KL-02', 50, 20, 35, 4, 5, 30, 7, 2),
                27 => self::profile('tho', 'kim-loai', 'guardian', 'bruiser', 'KL-03', 100, 25, 50, 5, 10, 35, 9, 2),
                36 => self::profile('dien', 'phi-hanh', 'striker', 'versatile', 'PH-01', 30, 13, 50, 4, 5, 17, 5, 4),
                37 => self::profile('dien', 'phi-hanh', 'striker', 'versatile', 'PH-02', 70, 15, 50, 5, 5, 19, 5, 5),
                38 => self::profile('dien', 'phi-hanh', 'striker', 'controller', 'PH-02', 80, 18, 50, 6, 5, 21, 4, 6),
                39 => self::profile('dien', 'phi-hanh', 'striker', 'controller', 'PH-03', 100, 21, 50, 7, 5, 24, 4, 7),
                49 => self::profile('phong', 'phi-hanh', 'versatile', 'controller', 'PH-01', 70, 13, 20, 4, 5, 16, 3, 5),
                50 => self::profile('phong', 'phi-hanh', 'striker', 'controller', 'PH-02', 80, 18, 45, 6, 5, 18, 4, 7),
                51 => self::profile('phong', 'phi-hanh', 'support', 'controller', 'PH-03', 80, 20, 25, 5, 10, 26, 4, 6),
                68 => self::profile('thuy', 'hai-duong', 'support', 'controller', 'HD-01', 50, 16, 10, 4, 5, 22, 3, 3),
                69 => self::profile('thuy', 'hai-duong', 'support', 'guardian', 'HD-02', 50, 20, 40, 4, 5, 26, 4, 3),
                70 => self::profile('thuy', 'hai-duong', 'guardian', 'support', 'HD-03', 100, 23, 25, 5, 5, 30, 3, 3),
                71 => self::profile('thuy', 'hai-duong', 'guardian', 'controller', 'HD-04', 100, 29, 10, 6, 10, 34, 6, 2),
            ],
        ];
    }

    /** @return array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}|null */
    public static function find(string $source, int $gameId): ?array
    {
        return self::profiles()[$source][$gameId] ?? null;
    }

    /** @return array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int} */
    public static function for(string $source, int $gameId): array
    {
        return self::find($source, $gameId) ?? throw new InvalidArgumentException(
            "Missing pilot Pet balance profile for {$source}:{$gameId}.",
        );
    }

    /**
     * @return array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}
     */
    private static function profile(
        string $combatElement,
        string $species,
        string $primaryRole,
        string $secondaryRole,
        string $speciesTraitCode,
        int $hpBase,
        int $hpGrowth,
        int $strengthBase,
        int $strengthGrowth,
        int $defenseBase,
        int $defenseGrowth,
        int $agilityBase,
        int $agilityGrowth,
    ): array {
        return [
            'combat_element' => $combatElement,
            'species' => $species,
            'primary_role' => $primaryRole,
            'secondary_role' => $secondaryRole,
            'species_trait_code' => $speciesTraitCode,
            'hp_base' => $hpBase,
            'hp_growth' => $hpGrowth,
            'strength_base' => $strengthBase,
            'strength_growth' => $strengthGrowth,
            'defense_base' => $defenseBase,
            'defense_growth' => $defenseGrowth,
            'agility_base' => $agilityBase,
            'agility_growth' => $agilityGrowth,
        ];
    }
}
