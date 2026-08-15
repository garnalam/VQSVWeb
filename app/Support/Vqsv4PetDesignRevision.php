<?php

namespace App\Support;

use InvalidArgumentException;

final class Vqsv4PetDesignRevision
{
    public const VERSION = 'unified-v4-pet-growth-v2';

    private const STAT_PROFILE_PATH = 'decoded/vqsv4/06_analysis/pet-growth-v2/profiles.tsv';

    private const STAT_PROFILE_FORMULA = 'anchor-l1-l50-over-49';

    /** @var array<int, array{pet_key: string, classification: string, profile_version: string, formula: string, hp_l1: int, hp_l50: int, strength_l1: int, strength_l50: int, defense_l1: int, defense_l50: int, agility_l1: int, agility_l50: int, provenance: string}>|null */
    private static ?array $statProfiles = null;

    /** @var array<string, array{hp: int, strength: int, defense: int, agility: int}> */
    private const GROWTH_PATTERNS = [
        'early' => ['hp' => 8, 'strength' => 3, 'defense' => 10, 'agility' => 2],
        'steady' => ['hp' => 12, 'strength' => 4, 'defense' => 12, 'agility' => 3],
        'late' => ['hp' => 16, 'strength' => 5, 'defense' => 14, 'agility' => 4],
        'burst' => ['hp' => 8, 'strength' => 5, 'defense' => 8, 'agility' => 6],
        'fortress' => ['hp' => 15, 'strength' => 3, 'defense' => 18, 'agility' => 1],
        'divine' => ['hp' => 20, 'strength' => 5, 'defense' => 18, 'agility' => 5],
        'colossus' => ['hp' => 30, 'strength' => 4, 'defense' => 25, 'agility' => 1],
    ];

    /**
     * Each target tuple is the exact level-50 HP, Strength, Defense and Agility budget.
     * Individual stats may fall between forms, but the weighted combat budget must rise.
     *
     * @var array<string, array{
     *     archetype: string,
     *     combat_element?: string,
     *     species?: string,
     *     profiles: array<int, array{0: int, 1: int, 2: int, 3: int, 4: string, 5: string, 6: string, 7?: string}>
     * }>
     */
    private const LINEAGES = [
        'MOC-DAO-MOC' => [
            'archetype' => 'Ngân hàng sinh lực: Công thấp, hồi phục và phòng thủ tăng mạnh về cuối.',
            'profiles' => [
                4 => [920, 180, 112, 23, 'early', 'support', 'guardian'],
                5 => [980, 210, 124, 27, 'steady', 'support', 'controller'],
                6 => [1080, 250, 142, 32, 'late', 'controller', 'support'],
            ],
        ],
        'MOC-THU-MOC' => [
            'species' => 'manh-thu',
            'archetype' => 'Pháo đài phản kích: tốc độ thấp đổi lấy HP, DEF và áp lực sát thương theo lượt.',
            'profiles' => [
                7 => [780, 210, 130, 18, 'fortress', 'guardian', 'controller', 'MT-02'],
                8 => [900, 270, 145, 20, 'fortress', 'bruiser', 'guardian', 'MT-01'],
                9 => [1080, 330, 160, 22, 'fortress', 'bruiser', 'guardian', 'MT-02'],
            ],
        ],
        'MOC-KIM-QUA' => [
            'archetype' => 'Luyện kim trọng pháo: mỗi lần tiến hóa chậm hơn nhưng Công và giáp tăng đột biến.',
            'combat_element' => 'tho',
            'species' => 'kim-loai',
            'profiles' => [
                10 => [700, 260, 112, 14, 'early', 'bruiser', 'guardian', 'KL-01'],
                11 => [780, 305, 120, 13, 'steady', 'support', 'bruiser', 'KL-02'],
                12 => [900, 350, 128, 12, 'late', 'controller', 'bruiser', 'KL-03'],
                13 => [990, 410, 138, 10, 'late', 'striker', 'guardian', 'KL-04'],
            ],
        ],
        'MOC-LINH-CO' => [
            'archetype' => 'Nấm độc đánh lừa nhịp: mỏng, nhanh và bùng nổ sau khi đã gieo debuff.',
            'profiles' => [
                14 => [660, 230, 80, 42, 'burst', 'controller', 'support'],
                15 => [820, 375, 105, 46, 'burst', 'striker', 'controller'],
            ],
        ],
        'DIEN-DONG-XA' => [
            'archetype' => 'Đấu sĩ dẫn điện: cân bằng Công–Giáp, càng tiến hóa càng khó bị ngắt chuỗi tấn công.',
            'profiles' => [
                20 => [760, 240, 100, 28, 'early', 'versatile', 'bruiser'],
                21 => [860, 300, 116, 30, 'steady', 'bruiser', 'guardian'],
                22 => [980, 380, 132, 32, 'late', 'bruiser', 'striker'],
            ],
        ],
        'THUY-HAI-TAC' => [
            'archetype' => 'Hải tặc cướp nhịp: tốc độ khá, bể kỹ năng đa dụng và kết liễu mạnh ở form cuối.',
            'profiles' => [
                23 => [800, 250, 90, 34, 'early', 'versatile', 'controller'],
                24 => [900, 315, 105, 38, 'steady', 'bruiser', 'controller'],
                25 => [1000, 395, 120, 42, 'late', 'controller', 'striker'],
            ],
        ],
        'THO-KIM-DAM' => [
            'archetype' => 'Pháo đài công thành: gần như bỏ lượt đầu để đổi lấy phát bắn và lớp giáp cực nặng.',
            'profiles' => [
                30 => [850, 260, 140, 12, 'fortress', 'guardian', 'bruiser'],
                31 => [980, 380, 155, 8, 'fortress', 'bruiser', 'striker'],
            ],
        ],
        'DIEN-THIEN-LONG' => [
            'archetype' => 'Tempo Điện Long: HP thấp, Công và Tốc tăng cực nhanh để giành quyền chủ động.',
            'profiles' => [
                32 => [650, 250, 72, 40, 'burst', 'striker', 'versatile'],
                33 => [700, 310, 80, 48, 'burst', 'striker', 'controller'],
                34 => [800, 365, 90, 55, 'burst', 'striker', 'bruiser'],
                35 => [900, 430, 100, 62, 'burst', 'striker', 'bruiser'],
            ],
        ],
        'PHONG-LINH-DIEP' => [
            'archetype' => 'Hỗ trợ né tránh: thể lực mỏng nhưng điều khiển nhịp và mở cửa sổ an toàn cho đồng đội.',
            'profiles' => [
                36 => [620, 190, 75, 48, 'burst', 'support', 'controller'],
                37 => [760, 230, 90, 55, 'burst', 'controller', 'support'],
                38 => [920, 285, 115, 60, 'late', 'support', 'controller'],
            ],
        ],
        'DIEN-THIEN-SU' => [
            'archetype' => 'Chuyển pha thiên sứ: từ glass-cannon sang hộ vệ rồi kết thúc ở controller công thủ toàn diện.',
            'profiles' => [
                39 => [620, 320, 68, 50, 'burst', 'striker', 'controller'],
                40 => [900, 240, 130, 32, 'fortress', 'guardian', 'support'],
                41 => [980, 300, 135, 45, 'late', 'controller', 'support'],
            ],
        ],
        'PHONG-UNG-VUONG' => [
            'archetype' => 'Thợ săn không trung: máu thấp, áp lực lượt đầu và khả năng kết liễu tăng theo từng form.',
            'profiles' => [
                42 => [600, 280, 65, 48, 'burst', 'striker', 'controller'],
                43 => [720, 320, 75, 52, 'burst', 'striker', 'bruiser'],
                44 => [850, 360, 90, 56, 'burst', 'versatile', 'striker'],
                45 => [960, 420, 105, 64, 'burst', 'striker', 'bruiser'],
            ],
        ],
        'DIEN-LUC-DUC' => [
            'archetype' => 'Sát thủ ve sầu: HP/DEF thấp nhất roster thường, đổi lại tốc độ trần và Công bùng nổ.',
            'profiles' => [
                46 => [560, 300, 60, 58, 'burst', 'controller', 'striker'],
                47 => [650, 420, 72, 70, 'burst', 'striker', 'controller'],
            ],
        ],
        'THUY-NGUYET-HUNG' => [
            'archetype' => 'Gia phả phân nhánh: một form thành tường chắn, form còn lại hy sinh Công để hỗ trợ đội hình.',
            'profiles' => [
                48 => [820, 250, 100, 28, 'early', 'versatile', 'guardian'],
                49 => [940, 315, 118, 30, 'steady', 'bruiser', 'guardian'],
                50 => [1200, 310, 160, 18, 'fortress', 'guardian', 'bruiser'],
                51 => [1100, 275, 145, 40, 'late', 'support', 'controller'],
            ],
        ],
        'DIEN-LOI-DUONG' => [
            'archetype' => 'Tụ điện sống: càng tiến hóa càng chậm nhưng tích trữ HP/DEF và ép đối thủ đánh kéo dài.',
            'profiles' => [
                52 => [940, 190, 135, 16, 'fortress', 'guardian', 'support'],
                53 => [1030, 250, 150, 14, 'fortress', 'bruiser', 'guardian'],
                54 => [1160, 285, 165, 12, 'fortress', 'guardian', 'controller'],
            ],
        ],
        'THUY-TRIEU-OA' => [
            'archetype' => 'Bình sinh lực thủy triều: HP tăng khác thường, Công thấp và thắng bằng hồi phục–khống chế.',
            'profiles' => [
                55 => [900, 200, 110, 28, 'early', 'support', 'controller'],
                56 => [1000, 235, 125, 30, 'steady', 'controller', 'support'],
                57 => [1250, 270, 150, 25, 'fortress', 'guardian', 'support'],
            ],
        ],
        'HOA-HO-TUONG' => [
            'archetype' => 'Mãnh hổ áp sát: Công cao, phòng thủ mỏng và phải kết thúc trận trước khi bị bào mòn.',
            'profiles' => [
                58 => [650, 300, 70, 38, 'burst', 'striker', 'bruiser'],
                59 => [780, 350, 88, 40, 'burst', 'bruiser', 'striker'],
                60 => [900, 410, 105, 43, 'late', 'striker', 'bruiser'],
            ],
        ],
        'MOC-HAU-TIEN' => [
            'archetype' => 'Đấu sĩ Mộc cơ động: máu vừa, Công cao và đủ tốc để biến debuff thành nhịp tấn công.',
            'profiles' => [
                61 => [740, 300, 85, 40, 'burst', 'versatile', 'striker'],
                62 => [920, 420, 110, 48, 'late', 'bruiser', 'controller'],
            ],
        ],
        'QUY-U-HON' => [
            'archetype' => 'Quỷ chiến thuật: thắng bằng đổi nhịp và khống chế, ngân sách thô bị kìm thấp hơn Hỏa–Điện.',
            'profiles' => [
                63 => [650, 190, 75, 44, 'burst', 'controller', 'support'],
                64 => [750, 230, 85, 48, 'steady', 'versatile', 'controller'],
                65 => [820, 320, 90, 52, 'burst', 'striker', 'controller'],
                66 => [950, 340, 115, 54, 'late', 'controller', 'striker'],
            ],
        ],
        'THUY-DO-HON' => [
            'archetype' => 'Pháp sư thủy hồn: tốc cao, phòng thủ vừa và kiểm soát PP/debuff thay vì dồn sát thương thuần.',
            'profiles' => [
                67 => [720, 220, 90, 42, 'burst', 'controller', 'support'],
                68 => [850, 285, 105, 46, 'steady', 'bruiser', 'controller'],
                69 => [980, 330, 125, 52, 'late', 'support', 'controller'],
            ],
        ],
        'MOC-LAM-TINH' => [
            'species' => 'phi-hanh',
            'archetype' => 'Tiên rừng chuyển vai: hai form đầu mỏng và cực nhanh, form cuối giảm Công để dựng thế trận.',
            'profiles' => [
                70 => [620, 240, 80, 50, 'burst', 'controller', 'striker', 'PH-04'],
                71 => [700, 350, 85, 58, 'burst', 'striker', 'controller', 'PH-02'],
                72 => [900, 330, 130, 55, 'late', 'support', 'controller', 'PH-03'],
            ],
        ],
        'HOA-CO-DANG' => [
            'archetype' => 'Đèn cổ kéo dài tài nguyên: Công đầu trận thấp, càng về cuối càng khó hạ và khó cạn PP.',
            'profiles' => [
                73 => [720, 180, 100, 28, 'early', 'support', 'controller'],
                74 => [850, 220, 118, 30, 'steady', 'controller', 'support'],
                75 => [1030, 280, 145, 32, 'late', 'bruiser', 'controller'],
            ],
        ],
        'THO-MA-NHAN' => [
            'archetype' => 'Máy nghiền chống stall: HP/DEF cực cao, tốc thấp và Công chỉ bùng lên ở form cuối.',
            'profiles' => [
                76 => [900, 200, 125, 18, 'fortress', 'controller', 'guardian'],
                77 => [1020, 265, 140, 20, 'fortress', 'bruiser', 'controller'],
                78 => [1180, 310, 155, 22, 'fortress', 'guardian', 'bruiser'],
            ],
        ],
        'THAN-079' => [
            'archetype' => 'Thần tốc Điện: pet nhanh nhất catalog, đánh đổi một phần HP để giữ áp lực chủ động.',
            'profiles' => [79 => [1150, 430, 135, 85, 'divine', 'striker', 'controller']],
        ],
        'THAN-080' => [
            'archetype' => 'Cự thần thành lũy: HP/DEF cao nhất, tốc độ cực thấp và không phụ thuộc một Tư chất cụ thể.',
            'profiles' => [80 => [2200, 300, 230, 8, 'colossus', 'guardian', 'bruiser']],
        ],
        'THAN-081' => [
            'archetype' => 'Thánh mẫu sinh mệnh: HP/DEF áp đảo, Công thấp và tối ưu cho vai trò hỗ trợ.',
            'profiles' => [81 => [1800, 260, 190, 25, 'divine', 'support', 'guardian']],
        ],
        'THAN-082' => [
            'archetype' => 'Thần đồng khống chế: tốc cao, giáp tốt và thiên về debuff thay vì sát thương Quỷ thuần.',
            'profiles' => [82 => [1350, 330, 175, 60, 'divine', 'controller', 'support']],
        ],
        'THAN-083' => [
            'archetype' => 'Thần miêu thích nghi: không có điểm yếu chỉ số rõ rệt, đổi vai linh hoạt theo bể kỹ năng.',
            'profiles' => [83 => [1500, 410, 160, 50, 'divine', 'versatile', 'support']],
        ],
    ];

    /**
     * @param  array<string, mixed>  $pet
     * @return array<string, mixed>
     */
    public static function apply(array $pet): array
    {
        $lineageCode = (string) $pet['lineage_code'];
        $gameId = (int) $pet['game_id'];
        $lineage = self::LINEAGES[$lineageCode] ?? throw new InvalidArgumentException(
            "Missing VQSV4 design revision for lineage {$lineageCode}.",
        );
        $lineageProfile = $lineage['profiles'][$gameId] ?? throw new InvalidArgumentException(
            "Missing VQSV4 design revision for Pet {$gameId}.",
        );
        $statProfile = self::statProfiles()[$gameId] ?? throw new InvalidArgumentException(
            "Missing VQSV4 stat profile for Pet {$gameId}.",
        );
        [, , , , $growthPattern, $primaryRole, $secondaryRole] = $lineageProfile;

        $stats = self::databaseStats($statProfile);

        $pet['combat_element'] = $lineage['combat_element'] ?? $pet['combat_element'];
        $pet['species'] = $lineage['species'] ?? $pet['species'];
        $pet['species_trait_code'] = $lineageProfile[7] ?? $pet['species_trait_code'];
        unset($pet['assigned_trait_code']);
        $pet['recommended_aptitude_code'] = $pet['recommended_talent_code'];
        unset($pet['recommended_talent_code']);
        $pet['primary_role'] = $primaryRole;
        $pet['secondary_role'] = $secondaryRole;
        $pet['stats'] = $stats;
        $pet['balance_notes'] = $lineage['archetype'];
        $pet['design_revision'] = [
            'version' => self::VERSION,
            'archetype' => $lineage['archetype'],
            'growth_pattern' => $growthPattern,
            'level_50_target' => [
                'hp' => $statProfile['hp_l50'],
                'strength' => $statProfile['strength_l50'],
                'defense' => $statProfile['defense_l50'],
                'agility' => $statProfile['agility_l50'],
            ],
            'stat_profile' => $statProfile,
        ];

        return $pet;
    }

    /** @return list<int> */
    public static function gameIds(): array
    {
        $gameIds = [];

        foreach (self::LINEAGES as $lineage) {
            array_push($gameIds, ...array_keys($lineage['profiles']));
        }

        sort($gameIds);

        return $gameIds;
    }

    /**
     * @param  array{hp_l1: int, hp_l50: int, strength_l1: int, strength_l50: int, defense_l1: int, defense_l50: int, agility_l1: int, agility_l50: int}  $profile
     * @return array{hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}
     */
    private static function databaseStats(array $profile): array
    {
        $hpGrowth = intdiv($profile['hp_l50'] - $profile['hp_l1'], 49);
        $strengthGrowth = intdiv($profile['strength_l50'] - $profile['strength_l1'], 49);
        $defenseGrowth = (int) round(($profile['defense_l50'] - $profile['defense_l1']) * 10 / 49);
        $agilityGrowth = (int) round(($profile['agility_l50'] - $profile['agility_l1']) * 10 / 49);

        return [
            'hp_base' => $profile['hp_l1'] - $hpGrowth,
            'hp_growth' => $hpGrowth,
            'strength_base' => $profile['strength_l1'] - $strengthGrowth,
            'strength_growth' => $strengthGrowth,
            'defense_base' => $profile['defense_l1'] - intdiv($defenseGrowth, 10),
            'defense_growth' => $defenseGrowth,
            'agility_base' => $profile['agility_l1'] - intdiv($agilityGrowth, 10),
            'agility_growth' => $agilityGrowth,
        ];
    }

    /**
     * @return array<int, array{pet_key: string, classification: string, profile_version: string, formula: string, hp_l1: int, hp_l50: int, strength_l1: int, strength_l50: int, defense_l1: int, defense_l50: int, agility_l1: int, agility_l50: int, provenance: string}>
     */
    private static function statProfiles(): array
    {
        if (self::$statProfiles !== null) {
            return self::$statProfiles;
        }

        $lines = file(self::profilePath(), FILE_IGNORE_NEW_LINES | FILE_SKIP_EMPTY_LINES);
        $header = str_getcsv((string) array_shift($lines), "\t");
        $profiles = [];

        foreach ($lines as $line) {
            $values = str_getcsv($line, "\t");
            $row = array_combine($header, $values);
            $gameId = (int) str_replace('V4-', '', $row['pet_key']);
            $profile = [
                'pet_key' => $row['pet_key'],
                'classification' => $row['classification'],
                'profile_version' => $row['profile_version'],
                'formula' => $row['formula'],
                'hp_l1' => (int) $row['hp_l1'],
                'hp_l50' => (int) $row['hp_l50'],
                'strength_l1' => (int) $row['strength_l1'],
                'strength_l50' => (int) $row['strength_l50'],
                'defense_l1' => (int) $row['defense_l1'],
                'defense_l50' => (int) $row['defense_l50'],
                'agility_l1' => (int) $row['agility_l1'],
                'agility_l50' => (int) $row['agility_l50'],
                'provenance' => $row['provenance'],
            ];

            if ($profile['profile_version'] !== self::VERSION
                || $profile['formula'] !== self::STAT_PROFILE_FORMULA
                || $profile['provenance'] !== 'generated_unified_balance') {
                throw new InvalidArgumentException("Invalid VQSV4 stat profile {$profile['pet_key']}.");
            }

            if (isset($profiles[$gameId])) {
                throw new InvalidArgumentException("Duplicate VQSV4 stat profile {$profile['pet_key']}.");
            }

            $profiles[$gameId] = $profile;
        }

        if (count($profiles) !== 72) {
            throw new InvalidArgumentException('The VQSV4 stat profile must contain exactly 72 Pets.');
        }

        ksort($profiles);

        return self::$statProfiles = $profiles;
    }

    private static function profilePath(): string
    {
        $path = resource_path(self::STAT_PROFILE_PATH);

        if (! is_file($path)) {
            throw new InvalidArgumentException("Missing VQSV4 stat profile resource {$path}.");
        }

        return $path;
    }
}
