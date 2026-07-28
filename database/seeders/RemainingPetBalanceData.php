<?php

namespace Database\Seeders;

use InvalidArgumentException;

final class RemainingPetBalanceData
{
    /**
     * The approved level-50 targets for every form outside the 35-form pilot.
     *
     * @return array<string, array<int, array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}>>
     */
    public static function profiles(): array
    {
        return [
            'liet-hoa' => self::lietHoaProfiles(),
            'cau-vong' => self::rainbowProfiles(),
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
            "Missing remaining Pet balance profile for {$source}:{$gameId}.",
        );
    }

    /**
     * @return array<int, array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}>
     */
    private static function lietHoaProfiles(): array
    {
        return [
            0 => self::target('hoa', 'phi-hanh', 'controller', 'striker', 'PH-04', 780, 260, 95, 34),
            1 => self::target('hoa', 'kim-loai', 'controller', 'striker', 'KL-03', 760, 275, 105, 27),
            2 => self::target('hoa', 'manh-thu', 'striker', 'bruiser', 'MT-01', 900, 315, 105, 30),
            3 => self::target('hoa', 'manh-thu', 'striker', 'controller', 'MT-03', 800, 330, 90, 36),
            4 => self::target('hoa', 'manh-thu', 'controller', 'striker', 'MT-03', 780, 280, 95, 39),
            5 => self::target('hoa', 'manh-thu', 'guardian', 'controller', 'MT-02', 1180, 250, 155, 17),
            9 => self::target('hoa', 'manh-thu', 'guardian', 'bruiser', 'MT-02', 980, 230, 140, 16),
            10 => self::target('hoa', 'manh-thu', 'guardian', 'bruiser', 'MT-02', 1280, 290, 175, 18),
            11 => self::target('hoa', 'manh-thu', 'striker', 'controller', 'MT-03', 850, 320, 95, 35),
            12 => self::target('thuy', 'manh-thu', 'controller', 'striker', 'MT-03', 920, 335, 105, 40),
            13 => self::target('hoa', 'manh-thu', 'bruiser', 'striker', 'MT-04', 1050, 340, 125, 29),
            14 => self::target('quy', 'manh-thu', 'striker', 'controller', 'MT-01', 950, 450, 100, 36),
            15 => self::target('hoa', 'phi-hanh', 'striker', 'controller', 'PH-02', 1550, 410, 145, 42),
            19 => self::target('moc', 'thuc-vat', 'support', 'controller', 'TV-03', 760, 205, 105, 25),
            20 => self::target('moc', 'thuc-vat', 'bruiser', 'support', 'TV-03', 940, 265, 125, 24),
            21 => self::target('moc', 'thuc-vat', 'guardian', 'bruiser', 'TV-02', 1220, 315, 165, 20),
            22 => self::target('moc', 'thuc-vat', 'striker', 'controller', 'TV-04', 820, 305, 95, 28),
            23 => self::target('moc', 'thuc-vat', 'support', 'controller', 'TV-01', 980, 215, 120, 30),
            24 => self::target('moc', 'thuc-vat', 'support', 'guardian', 'TV-01', 830, 200, 115, 23),
            25 => self::target('moc', 'thuc-vat', 'guardian', 'support', 'TV-02', 1080, 245, 150, 21),
            26 => self::target('moc', 'manh-thu', 'guardian', 'bruiser', 'MT-02', 900, 225, 135, 18),
            27 => self::target('moc', 'manh-thu', 'bruiser', 'guardian', 'MT-04', 1180, 305, 155, 23),
            28 => self::target('moc', 'kim-loai', 'guardian', 'support', 'KL-01', 1000, 240, 160, 19),
            29 => self::target('moc', 'thuc-vat', 'controller', 'support', 'TV-03', 860, 235, 105, 31),
            30 => self::target('moc', 'thuc-vat', 'support', 'controller', 'TV-01', 1050, 230, 135, 29),
            31 => self::target('moc', 'manh-thu', 'support', 'controller', 'MT-03', 1500, 350, 150, 40),
            32 => self::target('tho', 'kim-loai', 'guardian', 'controller', 'KL-01', 900, 220, 145, 16),
            33 => self::target('tho', 'manh-thu', 'controller', 'versatile', 'MT-03', 820, 250, 105, 32),
            34 => self::target('tho', 'manh-thu', 'striker', 'controller', 'MT-03', 780, 300, 90, 35),
            35 => self::target('tho', 'manh-thu', 'bruiser', 'striker', 'MT-01', 800, 275, 110, 21),
            36 => self::target('tho', 'manh-thu', 'bruiser', 'controller', 'MT-04', 1020, 315, 130, 24),
            37 => self::target('tho', 'kim-loai', 'guardian', 'bruiser', 'KL-01', 920, 220, 150, 15),
            38 => self::target('tho', 'kim-loai', 'guardian', 'support', 'KL-04', 1200, 260, 185, 17),
            39 => self::target('tho', 'kim-loai', 'versatile', 'bruiser', 'KL-03', 840, 260, 120, 26),
            40 => self::target('quy', 'kim-loai', 'striker', 'controller', 'KL-04', 920, 370, 110, 30),
            43 => self::target('tho', 'manh-thu', 'controller', 'striker', 'MT-03', 800, 270, 100, 32),
            44 => self::target('quy', 'manh-thu', 'striker', 'controller', 'MT-01', 940, 360, 105, 35),
            45 => self::target('tho', 'manh-thu', 'bruiser', 'guardian', 'MT-02', 1080, 310, 145, 22),
            46 => self::target('tho', 'manh-thu', 'striker', 'bruiser', 'MT-04', 1000, 400, 115, 27),
            47 => self::target('tho', 'manh-thu', 'guardian', 'bruiser', 'MT-02', 1700, 370, 195, 23),
            48 => self::target('thuy', 'manh-thu', 'controller', 'support', 'MT-03', 760, 215, 100, 28),
            49 => self::target('thuy', 'manh-thu', 'bruiser', 'guardian', 'MT-02', 980, 270, 130, 22),
            50 => self::target('thuy', 'manh-thu', 'guardian', 'bruiser', 'MT-04', 1280, 330, 170, 20),
            54 => self::target('thuy', 'phi-hanh', 'controller', 'support', 'PH-01', 820, 220, 100, 37),
            55 => self::target('thuy', 'hai-duong', 'guardian', 'bruiser', 'HD-03', 1150, 270, 155, 17),
            56 => self::target('quy', 'hai-duong', 'controller', 'bruiser', 'HD-04', 1000, 300, 115, 28),
            57 => self::target('thuy', 'hai-duong', 'support', 'controller', 'HD-02', 980, 215, 125, 27),
            58 => self::target('thuy', 'hai-duong', 'support', 'versatile', 'HD-01', 1080, 240, 115, 31),
            59 => self::target('thuy', 'hai-duong', 'controller', 'striker', 'HD-04', 800, 285, 95, 34),
            60 => self::target('thuy', 'kim-loai', 'controller', 'striker', 'KL-03', 800, 285, 105, 32),
            61 => self::target('thuy', 'kim-loai', 'striker', 'bruiser', 'KL-04', 940, 380, 115, 30),
            62 => self::target('thuy', 'hai-duong', 'support', 'controller', 'HD-02', 950, 220, 120, 29),
            63 => self::target('thuy', 'kim-loai', 'guardian', 'bruiser', 'KL-04', 1650, 380, 190, 24),
            64 => self::target('dien', 'manh-thu', 'bruiser', 'controller', 'MT-04', 940, 295, 120, 29),
            65 => self::target('dien', 'manh-thu', 'controller', 'support', 'MT-03', 740, 210, 95, 31),
            66 => self::target('dien', 'manh-thu', 'striker', 'controller', 'MT-03', 880, 300, 105, 36),
            67 => self::target('dien', 'manh-thu', 'bruiser', 'striker', 'MT-04', 1100, 350, 130, 33),
            70 => self::target('dien', 'phi-hanh', 'guardian', 'controller', 'PH-03', 920, 235, 140, 22),
            71 => self::target('quy', 'phi-hanh', 'striker', 'controller', 'PH-04', 900, 365, 105, 34),
            72 => self::target('dien', 'manh-thu', 'controller', 'striker', 'MT-03', 820, 265, 100, 35),
            73 => self::target('dien', 'manh-thu', 'striker', 'bruiser', 'MT-01', 950, 380, 110, 38),
            74 => self::target('dien', 'phi-hanh', 'controller', 'striker', 'PH-01', 830, 280, 100, 36),
            75 => self::target('dien', 'manh-thu', 'striker', 'bruiser', 'MT-03', 1500, 430, 145, 43),
            76 => self::target('quy', 'thuc-vat', 'controller', 'support', 'TV-04', 760, 205, 105, 29),
            77 => self::target('quy', 'thuc-vat', 'guardian', 'controller', 'TV-04', 960, 250, 135, 26),
            78 => self::target('quy', 'thuc-vat', 'bruiser', 'controller', 'TV-04', 1180, 330, 145, 28),
            79 => self::target('quy', 'manh-thu', 'bruiser', 'striker', 'MT-04', 820, 275, 110, 23),
            80 => self::target('quy', 'manh-thu', 'guardian', 'bruiser', 'MT-02', 1040, 300, 145, 21),
            81 => self::target('quy', 'manh-thu', 'guardian', 'bruiser', 'MT-02', 1320, 355, 175, 19),
            82 => self::target('quy', 'phi-hanh', 'controller', 'guardian', 'PH-04', 900, 220, 135, 27),
            83 => self::target('quy', 'phi-hanh', 'striker', 'controller', 'PH-02', 900, 370, 105, 36),
            84 => self::target('quy', 'kim-loai', 'guardian', 'controller', 'KL-01', 980, 230, 155, 22),
            85 => self::target('quy', 'kim-loai', 'striker', 'controller', 'KL-03', 920, 380, 110, 32),
            86 => self::target('quy', 'kim-loai', 'controller', 'guardian', 'KL-02', 1080, 260, 145, 29),
            87 => self::target('quy', 'manh-thu', 'bruiser', 'controller', 'MT-04', 1650, 410, 175, 32),
            88 => self::target('phong', 'hai-duong', 'support', 'versatile', 'HD-01', 900, 235, 110, 30),
            89 => self::target('phong', 'phi-hanh', 'support', 'controller', 'PH-03', 740, 205, 100, 34),
            90 => self::target('phong', 'phi-hanh', 'striker', 'controller', 'PH-02', 900, 350, 100, 40),
            91 => self::target('phong', 'phi-hanh', 'controller', 'support', 'PH-01', 780, 215, 105, 35),
            92 => self::target('phong', 'phi-hanh', 'guardian', 'versatile', 'PH-03', 1080, 270, 145, 31),
            93 => self::target('phong', 'phi-hanh', 'support', 'guardian', 'PH-03', 900, 220, 135, 30),
            94 => self::target('phong', 'manh-thu', 'striker', 'bruiser', 'MT-03', 920, 365, 110, 37),
            95 => self::target('phong', 'phi-hanh', 'controller', 'support', 'PH-01', 790, 225, 100, 36),
            96 => self::target('phong', 'phi-hanh', 'striker', 'controller', 'PH-02', 980, 355, 115, 41),
            97 => self::target('tho', 'kim-loai', 'guardian', 'bruiser', 'KL-01', 980, 270, 150, 24),
            98 => self::target('quy', 'kim-loai', 'striker', 'bruiser', 'KL-04', 1000, 390, 120, 34),
        ];
    }

    /**
     * @return array<int, array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}>
     */
    private static function rainbowProfiles(): array
    {
        return [
            0 => self::target('moc', 'thuc-vat', 'support', 'guardian', 'TV-01', 720, 195, 110, 22),
            1 => self::target('moc', 'thuc-vat', 'guardian', 'controller', 'TV-03', 860, 225, 130, 24),
            2 => self::target('quy', 'thuc-vat', 'controller', 'guardian', 'TV-04', 1020, 285, 140, 28),
            3 => self::target('moc', 'thuc-vat', 'guardian', 'support', 'TV-02', 1320, 315, 175, 25),
            7 => self::target('hoa', 'thuc-vat', 'support', 'controller', 'TV-01', 740, 210, 105, 24),
            8 => self::target('hoa', 'thuc-vat', 'controller', 'support', 'TV-03', 920, 260, 120, 29),
            9 => self::target('hoa', 'thuc-vat', 'striker', 'controller', 'TV-04', 1060, 345, 125, 32),
            10 => self::target('tho', 'thuc-vat', 'guardian', 'controller', 'TV-03', 780, 205, 125, 18),
            11 => self::target('tho', 'thuc-vat', 'guardian', 'bruiser', 'TV-03', 980, 255, 150, 20),
            12 => self::target('quy', 'thuc-vat', 'bruiser', 'controller', 'TV-04', 1120, 330, 140, 24),
            13 => self::target('phong', 'thuc-vat', 'controller', 'support', 'TV-01', 850, 220, 105, 34),
            14 => self::target('thuy', 'thuc-vat', 'support', 'guardian', 'TV-01', 1020, 210, 135, 27),
            15 => self::target('hoa', 'thuc-vat', 'striker', 'bruiser', 'TV-04', 980, 360, 115, 28),
            16 => self::target('dien', 'thuc-vat', 'support', 'controller', 'TV-03', 880, 230, 110, 33),
            21 => self::target('dien', 'kim-loai', 'controller', 'striker', 'KL-02', 760, 250, 105, 29),
            22 => self::target('dien', 'kim-loai', 'bruiser', 'controller', 'KL-01', 930, 295, 130, 27),
            23 => self::target('dien', 'kim-loai', 'striker', 'bruiser', 'KL-03', 1120, 375, 140, 32),
            24 => self::target('dien', 'kim-loai', 'controller', 'support', 'KL-02', 1080, 290, 145, 34),
            28 => self::target('hoa', 'kim-loai', 'striker', 'bruiser', 'KL-03', 1120, 375, 135, 29),
            29 => self::target('hoa', 'kim-loai', 'guardian', 'bruiser', 'KL-04', 1250, 325, 170, 22),
            30 => self::target('tho', 'kim-loai', 'guardian', 'bruiser', 'KL-01', 800, 220, 130, 16),
            31 => self::target('tho', 'kim-loai', 'bruiser', 'guardian', 'KL-04', 1020, 285, 150, 19),
            32 => self::target('tho', 'kim-loai', 'guardian', 'bruiser', 'KL-04', 1300, 335, 180, 20),
            33 => self::target('dien', 'kim-loai', 'controller', 'bruiser', 'KL-02', 1040, 300, 135, 31),
            34 => self::target('phong', 'kim-loai', 'guardian', 'controller', 'KL-01', 820, 215, 135, 20),
            35 => self::target('phong', 'kim-loai', 'bruiser', 'controller', 'KL-03', 1080, 320, 150, 29),
            40 => self::target('phong', 'phi-hanh', 'striker', 'controller', 'PH-02', 720, 275, 90, 32),
            41 => self::target('phong', 'phi-hanh', 'striker', 'bruiser', 'PH-01', 900, 325, 105, 36),
            42 => self::target('phong', 'phi-hanh', 'striker', 'versatile', 'PH-02', 1120, 390, 120, 39),
            43 => self::target('quy', 'phi-hanh', 'controller', 'striker', 'PH-04', 730, 245, 95, 33),
            44 => self::target('quy', 'phi-hanh', 'controller', 'striker', 'PH-04', 910, 300, 110, 37),
            45 => self::target('quy', 'phi-hanh', 'striker', 'controller', 'PH-02', 1080, 375, 115, 41),
            46 => self::target('tho', 'phi-hanh', 'guardian', 'bruiser', 'PH-03', 820, 225, 125, 25),
            47 => self::target('tho', 'phi-hanh', 'versatile', 'guardian', 'PH-01', 1000, 285, 140, 29),
            48 => self::target('tho', 'phi-hanh', 'bruiser', 'versatile', 'PH-02', 1220, 350, 150, 32),
            52 => self::target('tho', 'manh-thu', 'bruiser', 'striker', 'MT-01', 760, 260, 105, 24),
            53 => self::target('tho', 'manh-thu', 'bruiser', 'versatile', 'MT-04', 900, 300, 120, 26),
            54 => self::target('tho', 'manh-thu', 'striker', 'bruiser', 'MT-04', 1050, 350, 130, 29),
            55 => self::target('tho', 'manh-thu', 'bruiser', 'striker', 'MT-02', 1280, 390, 155, 28),
            56 => self::target('moc', 'manh-thu', 'support', 'versatile', 'MT-03', 780, 220, 105, 30),
            57 => self::target('moc', 'manh-thu', 'controller', 'support', 'MT-03', 1050, 285, 125, 38),
            58 => self::target('moc', 'manh-thu', 'striker', 'controller', 'MT-01', 1050, 365, 115, 35),
            59 => self::target('tho', 'manh-thu', 'guardian', 'bruiser', 'MT-02', 820, 220, 130, 17),
            60 => self::target('tho', 'manh-thu', 'bruiser', 'guardian', 'MT-04', 1020, 290, 145, 20),
            61 => self::target('tho', 'manh-thu', 'guardian', 'bruiser', 'MT-02', 1270, 335, 170, 21),
            62 => self::target('tho', 'manh-thu', 'versatile', 'guardian', 'MT-02', 1080, 285, 145, 24),
            63 => self::target('phong', 'manh-thu', 'striker', 'controller', 'MT-03', 740, 280, 90, 34),
            64 => self::target('phong', 'manh-thu', 'striker', 'bruiser', 'MT-01', 1050, 375, 110, 41),
            65 => self::target('quy', 'manh-thu', 'controller', 'striker', 'MT-03', 960, 325, 110, 38),
            66 => self::target('dien', 'manh-thu', 'striker', 'controller', 'MT-03', 810, 285, 95, 34),
            67 => self::target('dien', 'manh-thu', 'striker', 'bruiser', 'MT-01', 1040, 370, 115, 40),
            72 => self::target('phong', 'hai-duong', 'controller', 'support', 'HD-01', 750, 210, 100, 32),
            73 => self::target('phong', 'hai-duong', 'support', 'controller', 'HD-02', 950, 240, 120, 35),
            74 => self::target('phong', 'hai-duong', 'controller', 'support', 'HD-04', 1160, 300, 135, 39),
            75 => self::target('thuy', 'hai-duong', 'guardian', 'support', 'HD-03', 820, 205, 135, 18),
            76 => self::target('thuy', 'hai-duong', 'support', 'guardian', 'HD-02', 1080, 240, 155, 24),
            77 => self::target('quy', 'hai-duong', 'controller', 'guardian', 'HD-04', 1020, 300, 135, 31),
            78 => self::target('tho', 'hai-duong', 'guardian', 'controller', 'HD-03', 1320, 275, 185, 17),
            79 => self::target('tho', 'hai-duong', 'guardian', 'controller', 'HD-03', 780, 230, 135, 20),
            80 => self::target('tho', 'hai-duong', 'guardian', 'support', 'HD-04', 980, 270, 155, 23),
            81 => self::target('tho', 'hai-duong', 'support', 'guardian', 'HD-02', 1200, 300, 170, 27),
            82 => self::target('dien', 'hai-duong', 'striker', 'controller', 'HD-04', 800, 305, 100, 34),
            83 => self::target('phong', 'hai-duong', 'controller', 'support', 'HD-01', 900, 260, 110, 38),
            84 => self::target('hoa', 'manh-thu', 'striker', 'bruiser', 'MT-04', 1080, 380, 125, 35),
            85 => self::target('quy', 'phi-hanh', 'controller', 'support', 'PH-04', 1580, 350, 170, 39),
            86 => self::target('quy', 'phi-hanh', 'striker', 'controller', 'PH-02', 1500, 430, 145, 42),
            87 => self::target('quy', 'thuc-vat', 'controller', 'support', 'TV-04', 800, 220, 110, 29),
            88 => self::target('quy', 'thuc-vat', 'support', 'controller', 'TV-02', 1120, 280, 150, 32),
            89 => self::target('moc', 'thuc-vat', 'support', 'controller', 'TV-01', 1550, 360, 180, 38),
            90 => self::target('tho', 'kim-loai', 'bruiser', 'guardian', 'KL-01', 820, 250, 125, 21),
            91 => self::target('tho', 'kim-loai', 'guardian', 'bruiser', 'KL-04', 1160, 320, 170, 24),
            92 => self::target('quy', 'kim-loai', 'striker', 'guardian', 'KL-04', 1600, 430, 185, 31),
            93 => self::target('hoa', 'phi-hanh', 'support', 'striker', 'PH-03', 820, 235, 110, 31),
            94 => self::target('hoa', 'phi-hanh', 'striker', 'support', 'PH-02', 1120, 350, 140, 37),
            95 => self::target('quy', 'phi-hanh', 'controller', 'support', 'PH-04', 1520, 390, 165, 43),
            96 => self::target('quy', 'manh-thu', 'striker', 'controller', 'MT-03', 800, 280, 100, 33),
            97 => self::target('quy', 'manh-thu', 'striker', 'bruiser', 'MT-01', 1120, 370, 130, 39),
            98 => self::target('quy', 'manh-thu', 'controller', 'striker', 'MT-03', 1550, 420, 155, 44),
            99 => self::target('hoa', 'hai-duong', 'bruiser', 'striker', 'HD-04', 830, 280, 110, 24),
            100 => self::target('hoa', 'hai-duong', 'striker', 'bruiser', 'HD-04', 1180, 390, 135, 31),
            101 => self::target('thuy', 'hai-duong', 'support', 'controller', 'HD-02', 1600, 350, 175, 40),
        ];
    }

    /**
     * Convert readable level-50 targets into the native growth formula without offsets.
     *
     * @return array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}
     */
    private static function target(
        string $combatElement,
        string $species,
        string $primaryRole,
        string $secondaryRole,
        string $speciesTraitCode,
        int $hp,
        int $strength,
        int $defense,
        int $agility,
    ): array {
        [$hpBase, $hpGrowth] = self::formula($hp, 50);
        [$strengthBase, $strengthGrowth] = self::formula($strength, 50);
        [$defenseBase, $defenseGrowth] = self::formula($defense, 5);
        [$agilityBase, $agilityGrowth] = self::formula($agility, 5);

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

    /** @return array{int, int} */
    private static function formula(int $levelFiftyTarget, int $growthSteps): array
    {
        $growth = max(1, intdiv($levelFiftyTarget, $growthSteps) - 1);

        return [$levelFiftyTarget - $growth * $growthSteps, $growth];
    }
}
