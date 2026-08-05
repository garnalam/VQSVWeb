<?php

namespace App\Support;

use InvalidArgumentException;

final class Vqsv4SkillData
{
    public const FIRST_ACTIVE_ID = 0;

    public const LAST_ACTIVE_ID = 32;

    public const UNIFIED_EFFECT_SOURCE_TABLE = 12;

    /**
     * @return array<int, array<string, mixed>>
     */
    public static function definitions(): array
    {
        return [
            0 => self::skill('Mạn Độc Triền Sinh', 'moc', 0, 60, 15, 100, 'hybrid', self::rule('apply_status', 'Gây damage và chắc chắn đặt Hủ Thực 3 lượt (3%/6%/9% HP tối đa).', status: 'corrosion', duration: 3, value: 3), [11, 5]),
            1 => self::skill('Phấn Linh Xuyên Diệp', 'moc', 0, 90, 20, 30, 'hybrid', self::rule('corrosion_life_steal', 'Nếu mục tiêu Hủ Thực, hồi 35% damage thực gây ra (tối đa 8% HP) và bản thân tăng 10% DEF trong 2 lượt; không cộng dồn. Nếu chưa có, 30% gây Hủ Thực.', status: 'corrosion', duration: 3, value: 35, cap: 8, chance: 30, extra: ['secondary_status' => 'defense_up', 'secondary_value' => 10, 'secondary_duration' => 2]), [11, 5]),
            2 => self::skill('Bạo Chủng Liên Thứ', 'moc', 1, 110, 12, null, 'hybrid', self::rule('corrosion_detonate', 'Kích toàn bộ tick Hủ Thực còn lại, xóa trạng thái và hồi 50% damage kích nổ (tối đa 12% HP). Kích nổ thành công làm mục tiêu giảm 15% damage trong 2 lượt.', status: 'corrosion', value: 50, cap: 12, extra: ['secondary_status' => 'damage_down', 'secondary_value' => 15, 'secondary_duration' => 2]), [11, 5]),
            3 => self::skill('Diệp Nhẫn Cuồng Lam', 'moc', 2, 140, 8, null, 'hybrid', self::rule('conditional_pierce', 'Nếu mục tiêu Hủ Thực, đòn đánh bỏ qua 20% DEF và làm mục tiêu giảm 15% DEF trong 2 lượt; không xóa Hủ Thực.', status: 'corrosion', value: 20, extra: ['secondary_status' => 'defense_down', 'secondary_value' => 15, 'secondary_duration' => 2]), [11, 5]),
            4 => self::skill('Vạn Mộc Tận Thực', 'moc', 3, 170, 5, 100, 'hybrid', self::rule('corrosion_storm', 'Chắc chắn gây Hủ Thực, kích tick đầu ngay và hồi 50% tick đó (tối đa 5% HP). Mục tiêu giảm 20% damage và 15% Linh xảo trong 2 lượt; không cộng dồn.', status: 'corrosion', duration: 3, value: 50, cap: 5, extra: ['secondary_statuses' => ['damage_down' => 20, 'agility_down' => 15], 'secondary_duration' => 2]), [11, 5]),
            5 => self::skill('Nham Chùy Khai Giáp', 'tho', 0, 80, 20, 10, 'hybrid', self::rule('apply_status', '10% Thạch Hóa 1 lượt: mất hành động kế tiếp và giảm 30% damage nhận.', status: 'petrified', duration: 1, value: 30), [11, 0]),
            6 => self::skill('Thiết Phật Trấn Sơn', 'tho', 0, 75, 18, null, 'hybrid', self::rule('defense_stack', 'Đánh trúng nhận 1 tầng DEF +7% trong 2 lượt, tối đa 3 tầng.', duration: 2, value: 7, cap: 3)),
            7 => self::skill('Lôi Thiết Bạo Vũ', 'dien', 1, 110, 12, null, 'hybrid', self::rule('consume_defense_power', 'Tiêu thụ toàn bộ tầng Phòng ngự; mỗi tầng cộng 20 Power.', value: 20, cap: 3)),
            8 => self::skill('Toản Tinh Liệt Phá', 'dien', 2, 135, 8, null, 'damage', self::rule('defense_pierce', 'Bỏ qua 25% DEF của mục tiêu.', value: 25)),
            9 => self::skill('Bá Kim Trảm Địa', 'tho', 3, 155, 5, 25, 'control', self::rule('apply_status', '25% Thạch Hóa 1 lượt; không làm mới khi mục tiêu đang bị Thạch Hóa.', status: 'petrified', duration: 1, value: 30), [11, 0]),
            10 => self::skill('Phi Vũ Đoạn Không', 'phong', 0, 95, 25, null, 'hybrid', self::rule('first_action_power', 'Nếu hành động trước mục tiêu trong lượt, Power tăng thành 110.', conditionalPower: 110)),
            11 => self::skill('Long Quyển Phong Tỏa', 'phong', 0, 90, 14, 100, 'hybrid', self::rule('apply_status', 'Chắc chắn Giam Cầm 2 lượt: không đổi Pet/dùng Item và Linh xảo −15%.', status: 'bound', duration: 2, value: 15), [11, 4]),
            12 => self::skill('Tật Phong Trụy Không', 'phong', 1, 115, 12, null, 'hybrid', self::rule('self_buff_on_hit', 'Đánh trúng giúp Linh xảo +15% trong 2 lượt; không cộng dồn.', status: 'agility_up', duration: 2, value: 15)),
            13 => self::skill('Thánh Dực Xá Tội', 'phong', 2, 130, 8, null, 'hybrid', self::rule('cleanse_on_hit', 'Sau khi gây damage, xóa 1 debuff trên bản thân.')),
            14 => self::skill('Thiên Lôi Thịnh Nộ', 'dien', 3, 175, 5, 25, 'hybrid', self::rule('first_action_status', '25% Giam Cầm 2 lượt; nếu hành động trước, xác suất tăng thành 40%.', status: 'bound', duration: 2, value: 15, chance: 40), [11, 4]),
            15 => self::skill('Nham Nha Phệ Cốt', 'tho', 0, 95, 25, 25, 'hybrid', self::rule('apply_status', '25% Xé Rách 2 lượt; cuối mỗi lượt mất 4% HP tối đa.', status: 'bleeding', duration: 2, value: 4), [12, 0]),
            16 => self::skill('Liệt Trảo Xé Gió', 'dien', 0, 90, 20, 35, 'hybrid', self::rule('apply_status', '35% Xé Rách 2 lượt; cuối mỗi lượt mất 4% HP tối đa.', status: 'bleeding', duration: 2, value: 4), [12, 0]),
            17 => self::skill('Huyết Nộ Cuồng Thú', 'hoa', 1, 110, 14, null, 'hybrid', self::rule('conditional_power', 'Nếu mục tiêu đang Xé Rách, Power tăng thành 145; không xóa trạng thái.', status: 'bleeding', conditionalPower: 145), [12, 0]),
            18 => self::skill('Bạo Thú Xung Thiên', 'hoa', 2, 140, 8, null, 'hybrid', self::rule('consume_for_power', 'Nếu mục tiêu Xé Rách, Power tăng thành 185 rồi xóa trạng thái.', status: 'bleeding', conditionalPower: 185), [12, 0]),
            19 => self::skill('Vạn Thú Chấn Hống', 'hoa', 3, 160, 5, 30, 'hybrid', self::rule('low_hp_power_status', '30% gây Xé Rách; nếu người dùng dưới 35% HP, Power tăng thành 190.', status: 'bleeding', duration: 2, value: 4, conditionalPower: 190), [12, 0]),
            20 => self::skill('Phệ Hồn Ấn', 'quy', 0, 90, 22, 25, 'hybrid', self::rule('apply_status', '25% Mị Hoặc 3 lượt, làm giảm 15% damage của mục tiêu.', status: 'charmed', duration: 3, value: 15), [11, 3]),
            21 => self::skill('U Minh Triều', 'quy', 0, 100, 20, 25, 'hybrid', self::rule('pp_refund', 'Đánh trúng có 25% hoàn 1 PP vừa tiêu hao.', value: 1, chance: 25)),
            22 => self::skill('Địa Ngục Viêm', 'hoa', 1, 110, 12, 60, 'hybrid', self::rule('apply_status', '60% Mị Hoặc 2 lượt, làm giảm 15% damage của mục tiêu.', status: 'charmed', duration: 2, value: 15), [11, 3]),
            23 => self::skill('Hắc Luật Phán Quyết', 'quy', 2, 145, 8, null, 'hybrid', self::rule('life_steal', 'Hồi 30% damage thực gây ra, tối đa 10% HP tối đa.', value: 30, cap: 10)),
            24 => self::skill('Ma Thần Giáng Thế', 'quy', 3, 185, 5, null, 'hybrid', self::rule('consume_for_power', 'Nếu mục tiêu Mị Hoặc, Power tăng thành 220 rồi xóa trạng thái.', status: 'charmed', conditionalPower: 220), [11, 3]),
            25 => self::skill('Địa Mạch Kích', 'tho', 0, 80, 30, null, 'damage', self::rule('damage', 'Đòn đánh phổ thông, không kèm hiệu ứng.')),
            26 => self::skill('Thủy Linh Hồi Sinh', 'thuy', 0, 0, 6, null, 'heal', self::rule('direct_heal', 'Hồi 20% HP tối đa cho bản thân hoặc đồng minh.', value: 20), targetPattern: 'self_or_ally'),
            27 => self::skill('Lam Tuyền Chữa Lành', 'thuy', 1, 0, 4, null, 'heal', self::rule('direct_heal', 'Hồi 35% HP tối đa cho bản thân hoặc đồng minh.', value: 35), targetPattern: 'self_or_ally'),
            28 => self::skill('Hải Tâm Tái Tạo', 'thuy', 2, 0, 2, null, 'heal', self::rule('direct_heal', 'Hồi 50% HP tối đa cho bản thân hoặc đồng minh.', value: 50), targetPattern: 'self_or_ally'),
            29 => self::skill('Thiên Quang Phán Thủ', 'dien', 1, 115, 8, null, 'damage', self::rule('random_power', 'Power thực tế ngẫu nhiên từ 75 đến 155; giá trị 115 là trung tâm cân bằng.', extra: ['minimum_power' => 75, 'maximum_power' => 155])),
            30 => self::skill('Miên Ca Lam Mộng', 'thuy', 2, 0, 4, 70, 'control', self::rule('apply_status', '70% gây Ngủ trong 1 hành động; nhận damage trực tiếp sẽ tỉnh.', status: 'sleep', duration: 1, value: 1), [12, 1]),
            31 => self::skill('Huyết Viêm Đoạt Mệnh', 'hoa', 2, 120, 8, null, 'hybrid', self::rule('life_steal', 'Hồi 35% damage thực gây ra, tối đa 12% HP tối đa.', value: 35, cap: 12)),
            32 => self::skill('Tử Thần Xúc Ấn', 'quy', 3, 250, 1, null, 'damage', self::rule('exhaust_pp', 'Sau khi dùng, PP hiện tại của toàn bộ Skill đang mang trở về 0.')),
        ];
    }

    /** @return array<string, mixed> */
    public static function definition(int $gameId): array
    {
        return self::definitions()[$gameId]
            ?? throw new InvalidArgumentException("Missing approved VQSV4 Skill {$gameId}.");
    }

    /** @return array{power: int, pp: int, tier: int, status_chance: int|null, description: string, mechanics: array<string, mixed>} */
    public static function balanceProfile(int $gameId): array
    {
        $definition = self::definition($gameId);

        return [
            'power' => $definition['power'],
            'pp' => $definition['pp'],
            'tier' => $definition['tier'],
            'status_chance' => $definition['status_chance'],
            'description' => $definition['mechanics']['description'],
            'mechanics' => $definition['mechanics'],
        ];
    }

    /**
     * @return list<array<string, mixed>>
     */
    public static function effectDefinitions(): array
    {
        return [
            self::effect(0, 'harmful', 'Xé Rách', 'bleeding', 'Cuối mỗi lượt mất 4% HP tối đa trong 2 lượt; không cộng dồn, dùng lại làm mới thời gian.', ['tick_max_hp_percent' => 4, 'duration_turns' => 2, 'tick_timing' => 'end_turn', 'stacking' => 'refresh']),
            self::effect(1, 'harmful', 'Ngủ', 'sleep', 'Bỏ một hành động; nhận sát thương trực tiếp sẽ tỉnh.', ['skip_actions' => 1, 'wake_on_direct_damage' => true, 'stacking' => 'refresh']),
            self::effect(2, 'beneficial', 'Gia cố phòng ngự', 'defense_up', 'Tăng Phòng ngự trong thời gian hiệu lực; không cộng dồn.', ['default_value_percent' => 10, 'duration_turns' => 2, 'stacking' => 'refresh']),
            self::effect(3, 'harmful', 'Nhụt chí', 'damage_down', 'Giảm sát thương gây ra trong thời gian hiệu lực; không cộng dồn.', ['allowed_values_percent' => [15, 20], 'duration_turns' => 2, 'stacking' => 'refresh']),
            self::effect(4, 'harmful', 'Chậm chạp', 'agility_down', 'Giảm Linh xảo trong thời gian hiệu lực; không cộng dồn.', ['default_value_percent' => 15, 'duration_turns' => 2, 'stacking' => 'refresh']),
            self::effect(5, 'harmful', 'Phá phòng ngự', 'defense_down', 'Giảm Phòng ngự trong thời gian hiệu lực; không cộng dồn.', ['default_value_percent' => 15, 'duration_turns' => 2, 'stacking' => 'refresh']),
        ];
    }

    /** @return array<string, mixed> */
    private static function skill(
        string $name,
        string $combatElement,
        int $tier,
        int $power,
        int $pp,
        ?int $statusChance,
        string $category,
        array $mechanics,
        ?array $primaryEffect = null,
        string $targetPattern = 'single_enemy',
    ): array {
        return [
            'name' => $name,
            'combat_element' => $combatElement,
            'tier' => $tier,
            'power' => $power,
            'pp' => $pp,
            'status_chance' => $statusChance,
            'combat_category' => $category,
            'target_pattern' => $targetPattern,
            'effect_target_pattern' => $targetPattern,
            'battle_format' => 'any',
            'primary_effect' => $primaryEffect,
            'mechanics' => $mechanics,
        ];
    }

    /** @return array<string, mixed> */
    private static function rule(
        string $type,
        string $description,
        ?string $status = null,
        ?int $duration = null,
        ?int $value = null,
        ?int $secondaryValue = null,
        ?int $conditionalPower = null,
        ?int $heal = null,
        ?int $cap = null,
        ?int $chance = null,
        array $extra = [],
    ): array {
        return [
            ...array_filter([
                'type' => $type,
                'description' => $description,
                'status' => $status,
                'duration' => $duration,
                'value' => $value,
                'secondary_value' => $secondaryValue,
                'conditional_power' => $conditionalPower,
                'heal' => $heal,
                'cap' => $cap,
                'chance' => $chance,
            ], static fn (mixed $item): bool => $item !== null),
            ...$extra,
        ];
    }

    /** @return array<string, mixed> */
    private static function effect(
        int $gameId,
        string $kind,
        string $name,
        string $statusKey,
        string $description,
        array $parameters,
    ): array {
        return [
            'source_table' => self::UNIFIED_EFFECT_SOURCE_TABLE,
            'game_id' => $gameId,
            'kind' => $kind,
            'name_original' => $name,
            'name' => $name,
            'description' => $description,
            'duration' => $parameters['duration_turns'] ?? null,
            'parameters' => [
                'status_key' => $statusKey,
                'provenance' => 'unified_design',
                ...$parameters,
            ],
            'raw_values' => [
                'provenance' => 'unified_design',
                'source' => 'VQSV4-Skill-Design-Review.xlsx',
                'status_key' => $statusKey,
            ],
        ];
    }
}
