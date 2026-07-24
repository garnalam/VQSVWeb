<?php

namespace Database\Seeders;

use App\Models\PetTrait;
use InvalidArgumentException;

final class PetTraitData
{
    /** @var array<string, array<string, list<int>>> */
    private const SPECIES_TRAIT_PETS = [
        'liet-hoa' => [
            'HD-01' => [56, 58],
            'HD-02' => [62, 88],
            'HD-03' => [16, 17, 18, 51, 52, 53, 55, 57],
            'HD-04' => [59],
            'KL-01' => [32, 39, 41, 63, 86],
            'KL-04' => [1, 28, 37, 38, 40, 42, 60, 61, 84, 85, 97, 98],
            'MT-01' => [4, 31, 48, 49, 50],
            'MT-02' => [9, 10, 26, 27, 33, 34, 35, 36, 43, 44, 45, 46, 47, 68, 69, 75, 87],
            'MT-03' => [64, 65, 66, 67, 72, 73, 94],
            'MT-04' => [2, 3, 5, 6, 7, 8, 11, 12, 13, 14, 79, 80, 81],
            'PH-01' => [54, 74],
            'PH-02' => [15, 70, 90, 95, 96],
            'PH-03' => [89, 91, 92, 93, 99],
            'PH-04' => [0, 71, 82, 83],
            'TV-01' => [23, 29, 30],
            'TV-02' => [24, 25],
            'TV-03' => [19, 20, 21],
            'TV-04' => [22, 76, 77, 78],
        ],
        'cau-vong' => [
            'HD-01' => [72, 73, 74, 75, 76, 77, 79, 80, 81, 82, 83],
            'HD-02' => [101],
            'HD-03' => [68, 69, 70, 71, 78],
            'HD-04' => [99, 100],
            'KL-01' => [17, 18, 19, 20, 30, 31, 32, 90, 91],
            'KL-02' => [21, 22, 23, 24, 33],
            'KL-03' => [34, 35],
            'KL-04' => [25, 26, 27, 28, 29, 92],
            'MT-01' => [84],
            'MT-02' => [52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 98],
            'MT-04' => [96, 97],
            'PH-01' => [46],
            'PH-02' => [36, 37, 38, 39, 40, 41, 42, 47, 48, 49, 50, 51, 93, 94],
            'PH-04' => [43, 44, 45, 85, 86, 95],
            'TV-02' => [0, 1, 2, 3, 13, 14, 15, 16],
            'TV-03' => [10, 11, 12],
            'TV-04' => [4, 5, 6, 7, 8, 9, 87, 88, 89],
        ],
    ];

    /**
     * @return list<array{code: string, name: string, slot_type: string, species: string|null, polarity: string, description: string, parameters: array<string, mixed>, roll_weight: int, is_cleanse_eligible: bool, is_active: bool}>
     */
    public static function definitions(): array
    {
        return [
            self::physical('TC-00', 'Bình hòa', PetTrait::POLARITY_NEUTRAL, 'Không cộng hoặc trừ chỉ số.', []),
            self::physical('TC-01', 'Khí lực suy yếu', PetTrait::POLARITY_HARMFUL, 'Sinh mệnh tối đa giảm 8%.', ['max_hp_percent' => -8]),
            self::physical('TC-02', 'Khí lực cường tráng', PetTrait::POLARITY_BENEFICIAL, 'Sinh mệnh tối đa tăng 8%.', ['max_hp_percent' => 8]),
            self::physical('TC-03', 'Cơ lực suy giảm', PetTrait::POLARITY_HARMFUL, 'Sức mạnh cuối cùng giảm 8%.', ['strength_percent' => -8]),
            self::physical('TC-04', 'Cơ lực sung mãn', PetTrait::POLARITY_BENEFICIAL, 'Sức mạnh cuối cùng tăng 8%.', ['strength_percent' => 8]),
            self::physical('TC-05', 'Ngoại xác rạn vỡ', PetTrait::POLARITY_HARMFUL, 'Phòng ngự cuối cùng giảm 8%.', ['defense_percent' => -8]),
            self::physical('TC-06', 'Ngoại xác vững chắc', PetTrait::POLARITY_BENEFICIAL, 'Phòng ngự cuối cùng tăng 8%.', ['defense_percent' => 8]),
            self::physical('TC-07', 'Phản xạ chậm', PetTrait::POLARITY_HARMFUL, 'Linh xảo cuối cùng giảm 8%.', ['agility_percent' => -8]),
            self::physical('TC-08', 'Phản xạ linh hoạt', PetTrait::POLARITY_BENEFICIAL, 'Linh xảo cuối cùng tăng 8%.', ['agility_percent' => 8]),
            self::physical('TC-09', 'Trao đổi trì trệ', PetTrait::POLARITY_HARMFUL, 'Mọi lượng hồi Sinh mệnh nhận được giảm 25%.', ['healing_received_percent' => -25]),
            self::physical('TC-10', 'Hồi phục tự nhiên', PetTrait::POLARITY_BENEFICIAL, 'Cuối lượt hồi 2% Sinh mệnh tối đa; tạm ngừng khi đang Thiêu Đốt hoặc Hủ Thực; tổng hồi thụ động bị chặn ở 4% mỗi lượt.', ['heal_max_hp_percent' => 2, 'blocked_by' => ['burn', 'corrosion'], 'passive_heal_cap_percent' => 4]),
            self::physical('TC-11', 'Công kích dè dặt', PetTrait::POLARITY_MIXED, 'Sát thương gây ra giảm 8%, đổi lại độ chính xác kỹ năng tăng 5 điểm phần trăm.', ['damage_percent' => -8, 'accuracy_points' => 5]),
            self::physical('TC-12', 'Công kích thô bạo', PetTrait::POLARITY_MIXED, 'Sát thương gây ra tăng 8%, đổi lại độ chính xác kỹ năng giảm 5 điểm phần trăm.', ['damage_percent' => 8, 'accuracy_points' => -5]),
            self::species('TV-01', 'Quang hợp', 'thuc-vat', 'Sau khi dùng Skill không gây sát thương, hồi 3% Sinh mệnh tối đa; hồi chiêu 3 lượt.', ['trigger' => 'non_damage_skill', 'heal_max_hp_percent' => 3, 'cooldown_turns' => 3]),
            self::species('TV-02', 'Rễ sâu', 'thuc-vat', 'Debuff giảm chỉ số tác dụng lên Pet bị giảm 20%; thời gian Giam Cầm giảm 1 lượt, tối thiểu còn 1.', ['stat_debuff_reduction_percent' => 20, 'bind_duration_reduction' => 1, 'minimum_bind_turns' => 1]),
            self::species('TV-03', 'Gai phản kích', 'thuc-vat', 'Khi nhận sát thương trực tiếp, phản lại 8% lượng sát thương vừa nhận; không vượt quá 5% Sinh mệnh tối đa của kẻ đánh.', ['reflect_damage_percent' => 8, 'attacker_max_hp_cap_percent' => 5]),
            self::species('TV-04', 'Độc thể', 'thuc-vat', 'Skill gây Thiêu Đốt, Hủ Thực hoặc Độc được cộng 5 điểm phần trăm xác suất, tối đa 95%.', ['status_chance_points' => 5, 'statuses' => ['burn', 'corrosion', 'poison'], 'chance_cap_percent' => 95]),
            self::species('KL-01', 'Giáp hợp kim', 'kim-loai', 'Giảm 6% sát thương trực tiếp nhận vào; không giảm sát thương theo lượt.', ['direct_damage_reduction_percent' => 6]),
            self::species('KL-02', 'Mạch dẫn', 'kim-loai', 'Kháng Tê Liệt tăng 15 điểm phần trăm; khi kháng thành công, Linh xảo tăng 5% trong lượt kế tiếp.', ['paralysis_resistance_points' => 15, 'resist_agility_percent' => 5, 'duration_turns' => 1]),
            self::species('KL-03', 'Cơ cấu chính xác', 'kim-loai', 'Độ chính xác tăng 5 điểm phần trăm và bỏ qua 5% Phòng ngự của mục tiêu.', ['accuracy_points' => 5, 'defense_ignore_percent' => 5]),
            self::species('KL-04', 'Vũ trang nặng', 'kim-loai', 'Sát thương trực tiếp tăng 8%, Linh xảo giảm 8%.', ['direct_damage_percent' => 8, 'agility_percent' => -8]),
            self::species('PH-01', 'Thân pháp không trung', 'phi-hanh', 'Né tránh tăng 5 điểm phần trăm; tổng né từ nội tại bị chặn ở 25%.', ['evasion_points' => 5, 'passive_evasion_cap_percent' => 25]),
            self::species('PH-02', 'Bổ nhào', 'phi-hanh', 'Đòn gây sát thương đầu tiên sau khi vào sân được tăng 12% sát thương.', ['first_hit_damage_percent' => 12]),
            self::species('PH-03', 'Luồng khí nâng', 'phi-hanh', 'Sau khi nhận sát thương trực tiếp, Linh xảo tăng 6% trong 2 lượt; hồi chiêu 3 lượt.', ['agility_percent' => 6, 'duration_turns' => 2, 'cooldown_turns' => 3]),
            self::species('PH-04', 'Định vị siêu âm', 'phi-hanh', 'Hiệu lực debuff giảm độ chính xác bị giảm 50%; độ chính xác không thể xuống dưới 85%.', ['accuracy_debuff_reduction_percent' => 50, 'accuracy_floor_percent' => 85]),
            self::species('MT-01', 'Bản năng săn mồi', 'manh-thu', 'Gây thêm 8% sát thương lên mục tiêu còn dưới 50% Sinh mệnh.', ['target_hp_below_percent' => 50, 'damage_percent' => 8]),
            self::species('MT-02', 'Da dày', 'manh-thu', 'Giảm 6% sát thương trực tiếp nhận vào.', ['direct_damage_reduction_percent' => 6]),
            self::species('MT-03', 'Truy kích', 'manh-thu', 'Nếu đối thủ vừa dùng Skill không gây sát thương, đòn tấn công kế tiếp gây thêm 10%; không cộng dồn.', ['trigger' => 'opponent_non_damage_skill', 'next_attack_damage_percent' => 10, 'stackable' => false]),
            self::species('MT-04', 'Cuồng nộ', 'manh-thu', 'Khi Sinh mệnh dưới 35%, sát thương tăng 12% và Phòng ngự giảm 8%; tắt khi hồi lên trên ngưỡng.', ['hp_below_percent' => 35, 'damage_percent' => 12, 'defense_percent' => -8]),
            self::species('HD-01', 'Da trơn', 'hai-duong', 'Kháng Thạch Hóa và Giam Cầm tăng 15 điểm phần trăm.', ['resistance_points' => 15, 'statuses' => ['petrification', 'bind']]),
            self::species('HD-02', 'Nhịp thủy triều', 'hai-duong', 'Cuối mỗi lượt thứ ba, hồi 1 PP cho Skill có tỷ lệ PP còn lại thấp nhất; không vượt PP tối đa.', ['interval_turns' => 3, 'restore_pp' => 1, 'target' => 'lowest_pp_ratio']),
            self::species('HD-03', 'Áp suất sâu', 'hai-duong', 'Khi còn từ 50% Sinh mệnh trở lên, giảm 6% mọi sát thương nhận vào.', ['hp_at_least_percent' => 50, 'damage_reduction_percent' => 6]),
            self::species('HD-04', 'Thủy lực phản kích', 'hai-duong', 'Sau khi nhận sát thương trực tiếp, Skill gây sát thương kế tiếp được tăng 8%; không cộng dồn.', ['next_skill_damage_percent' => 8, 'stackable' => false]),
        ];
    }

    public static function speciesTraitCode(string $source, int $gameId): string
    {
        $traitGroups = self::SPECIES_TRAIT_PETS[$source] ?? throw new InvalidArgumentException(
            "Unknown Pet source {$source}.",
        );

        foreach ($traitGroups as $traitCode => $gameIds) {
            if (in_array($gameId, $gameIds, true)) {
                return $traitCode;
            }
        }

        throw new InvalidArgumentException("Missing species trait for {$source}:{$gameId}.");
    }

    /**
     * @param  array<string, mixed>  $parameters
     * @return array{code: string, name: string, slot_type: string, species: null, polarity: string, description: string, parameters: array<string, mixed>, roll_weight: int, is_cleanse_eligible: bool, is_active: bool}
     */
    private static function physical(
        string $code,
        string $name,
        string $polarity,
        string $description,
        array $parameters,
    ): array {
        return [
            'code' => $code,
            'name' => $name,
            'slot_type' => PetTrait::SLOT_PHYSICAL,
            'species' => null,
            'polarity' => $polarity,
            'description' => $description,
            'parameters' => $parameters,
            'roll_weight' => 1,
            'is_cleanse_eligible' => $polarity !== PetTrait::POLARITY_HARMFUL,
            'is_active' => true,
        ];
    }

    /**
     * @param  array<string, mixed>  $parameters
     * @return array{code: string, name: string, slot_type: string, species: string, polarity: string, description: string, parameters: array<string, mixed>, roll_weight: int, is_cleanse_eligible: bool, is_active: bool}
     */
    private static function species(
        string $code,
        string $name,
        string $species,
        string $description,
        array $parameters,
    ): array {
        return [
            'code' => $code,
            'name' => $name,
            'slot_type' => PetTrait::SLOT_SPECIES,
            'species' => $species,
            'polarity' => PetTrait::POLARITY_NEUTRAL,
            'description' => $description,
            'parameters' => $parameters,
            'roll_weight' => 0,
            'is_cleanse_eligible' => false,
            'is_active' => true,
        ];
    }
}
