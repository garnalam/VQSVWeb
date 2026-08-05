<?php

namespace App\Support;

use InvalidArgumentException;

class SkillBalance
{
    public const VERSION = 'unified-v7';

    /** @var array<int, array{power: int, pp: int}> */
    private const LIET_HOA_VALUES = [
        0 => ['power' => 100, 'pp' => 30], 1 => ['power' => 75, 'pp' => 18], 2 => ['power' => 95, 'pp' => 20],
        3 => ['power' => 115, 'pp' => 14], 4 => ['power' => 0, 'pp' => 5], 5 => ['power' => 0, 'pp' => 4],
        6 => ['power' => 155, 'pp' => 12], 7 => ['power' => 105, 'pp' => 10], 8 => ['power' => 175, 'pp' => 6],
        9 => ['power' => 195, 'pp' => 5], 10 => ['power' => 100, 'pp' => 30], 11 => ['power' => 90, 'pp' => 22],
        12 => ['power' => 75, 'pp' => 16], 13 => ['power' => 65, 'pp' => 12], 14 => ['power' => 0, 'pp' => 6],
        15 => ['power' => 0, 'pp' => 5], 16 => ['power' => 155, 'pp' => 12], 17 => ['power' => 125, 'pp' => 10],
        18 => ['power' => 140, 'pp' => 6], 19 => ['power' => 120, 'pp' => 5], 20 => ['power' => 100, 'pp' => 30],
        21 => ['power' => 80, 'pp' => 20], 22 => ['power' => 75, 'pp' => 18], 23 => ['power' => 115, 'pp' => 12],
        24 => ['power' => 0, 'pp' => 5], 25 => ['power' => 0, 'pp' => 4], 26 => ['power' => 155, 'pp' => 12],
        27 => ['power' => 115, 'pp' => 8], 28 => ['power' => 145, 'pp' => 6], 29 => ['power' => 185, 'pp' => 5],
        30 => ['power' => 100, 'pp' => 30], 31 => ['power' => 80, 'pp' => 20], 32 => ['power' => 80, 'pp' => 20],
        33 => ['power' => 105, 'pp' => 15], 34 => ['power' => 0, 'pp' => 5], 35 => ['power' => 0, 'pp' => 5],
        36 => ['power' => 155, 'pp' => 12], 37 => ['power' => 120, 'pp' => 9], 38 => ['power' => 145, 'pp' => 6],
        39 => ['power' => 135, 'pp' => 6], 40 => ['power' => 100, 'pp' => 30], 41 => ['power' => 95, 'pp' => 20],
        42 => ['power' => 90, 'pp' => 20], 43 => ['power' => 110, 'pp' => 14], 44 => ['power' => 0, 'pp' => 4],
        45 => ['power' => 0, 'pp' => 4], 46 => ['power' => 155, 'pp' => 12], 47 => ['power' => 135, 'pp' => 9],
        48 => ['power' => 145, 'pp' => 6], 49 => ['power' => 175, 'pp' => 5], 50 => ['power' => 100, 'pp' => 30],
        51 => ['power' => 85, 'pp' => 20], 52 => ['power' => 85, 'pp' => 20], 53 => ['power' => 115, 'pp' => 12],
        54 => ['power' => 0, 'pp' => 4], 55 => ['power' => 0, 'pp' => 5], 56 => ['power' => 155, 'pp' => 12],
        57 => ['power' => 115, 'pp' => 8], 58 => ['power' => 125, 'pp' => 6], 59 => ['power' => 175, 'pp' => 5],
        60 => ['power' => 100, 'pp' => 30], 61 => ['power' => 85, 'pp' => 20], 62 => ['power' => 85, 'pp' => 20],
        63 => ['power' => 105, 'pp' => 14], 64 => ['power' => 0, 'pp' => 4], 65 => ['power' => 0, 'pp' => 4],
        66 => ['power' => 155, 'pp' => 12], 67 => ['power' => 120, 'pp' => 8], 68 => ['power' => 130, 'pp' => 6],
        69 => ['power' => 155, 'pp' => 5],
    ];

    /** @var array<int, int> */
    private const LIET_HOA_STATUS_CHANCES = [
        1 => 100, 2 => 20, 8 => 25, 12 => 100, 13 => 100, 18 => 100, 19 => 100,
        22 => 40, 28 => 50, 31 => 100, 32 => 100, 33 => 100, 37 => 100, 38 => 100,
        39 => 100, 41 => 20, 47 => 35, 51 => 100, 54 => 100, 55 => 100, 57 => 100,
        61 => 100, 67 => 100,
    ];

    /**
     * @return array{power: int, pp: int, tier: int, status_chance: int|null, description: string, mechanics: array<string, mixed>}
     */
    public static function profile(string $sourceSlug, int $gameId): array
    {
        if ($sourceSlug === 'cau-vong') {
            return Vqsv4SkillData::balanceProfile($gameId);
        }

        $values = self::values($sourceSlug, $gameId);

        return [
            ...$values,
            'tier' => self::tier($sourceSlug, $gameId),
            'status_chance' => self::statusChance($sourceSlug, $gameId),
            'description' => self::description($sourceSlug, $gameId),
            'mechanics' => self::mechanics($sourceSlug, $gameId),
        ];
    }

    /** @return array{power: int, pp: int} */
    public static function values(string $sourceSlug, int $gameId): array
    {
        $values = match ($sourceSlug) {
            'liet-hoa' => self::LIET_HOA_VALUES[$gameId] ?? null,
            'cau-vong' => array_intersect_key(
                Vqsv4SkillData::balanceProfile($gameId),
                ['power' => true, 'pp' => true],
            ),
            default => null,
        };

        return $values ?? throw new InvalidArgumentException("Missing v2 Skill balance for {$sourceSlug}:{$gameId}.");
    }

    /** @return array<string, mixed> */
    public static function mechanics(string $sourceSlug, int $gameId): array
    {
        return $sourceSlug === 'liet-hoa'
            ? self::lietHoaMechanics($gameId)
            : Vqsv4SkillData::balanceProfile($gameId)['mechanics'];
    }

    private static function tier(string $sourceSlug, int $gameId): int
    {
        if ($sourceSlug === 'liet-hoa') {
            return [0, 0, 0, 1, 1, 1, 2, 2, 3, 3][$gameId % 10];
        }

        return Vqsv4SkillData::balanceProfile($gameId)['tier'];
    }

    private static function statusChance(string $sourceSlug, int $gameId): ?int
    {
        return match ($sourceSlug) {
            'liet-hoa' => self::LIET_HOA_STATUS_CHANCES[$gameId] ?? null,
            'cau-vong' => Vqsv4SkillData::balanceProfile($gameId)['status_chance'],
            default => null,
        };
    }

    private static function description(string $sourceSlug, int $gameId): string
    {
        $mechanics = self::mechanics($sourceSlug, $gameId);

        return (string) $mechanics['description'];
    }

    /** @return array<string, mixed> */
    private static function lietHoaMechanics(int $gameId): array
    {
        return match ($gameId) {
            0, 6, 10, 16, 20, 26, 30, 36, 40, 46, 50, 56, 60, 66 => self::rule('damage', 'Gây sát thương thuần, không kèm hiệu ứng.'),
            1 => self::rule('apply_status', 'Gây sát thương và chắc chắn đặt Gieo Hạt trong 3 lượt.', status: 'seeded_damage', duration: 3, value: 3),
            2 => self::rule('apply_status', 'Gây sát thương; 20% gây Mê Muội trong 2 lượt.', status: 'dazed', duration: 2, value: 20),
            3 => self::rule('conditional_power', 'Power tăng thành 145 nếu mục tiêu có Gieo Hạt; không xóa trạng thái.', status: 'seeded_damage', conditionalPower: 145),
            4 => self::rule('next_attack', 'DEF +15%; Skill gây damage kế tiếp đạt 190% Power rồi hiệu ứng kết thúc.', duration: 3, value: 190, secondaryValue: 15),
            5 => self::rule('tradeoff_buff', 'Trong 3 lượt, damage gây ra +50% và DEF −25%.', duration: 3, value: 50, secondaryValue: 25),
            7 => self::rule('detonate_or_apply', 'Nếu mục tiêu có Gieo Hạt, kích hoạt các tick còn lại rồi xóa; nếu chưa có thì đặt Gieo Hạt.', status: 'seeded_damage', duration: 3, value: 3),
            8 => self::rule('apply_status', 'Gây sát thương; 25% gây Mê Muội trong 2 lượt.', status: 'dazed', duration: 2, value: 20),
            9 => self::rule('consume_for_power', 'Power tăng thành 250 nếu mục tiêu có Gieo Hạt, sau đó xóa trạng thái.', status: 'seeded_damage', conditionalPower: 250),
            11 => self::rule('life_steal', 'Hồi 35% damage thực gây ra, tối đa 8% HP tối đa.', value: 35, cap: 8),
            12 => self::rule('apply_status', 'Gây sát thương và chắc chắn gây Quấn Quanh trong 2 lượt; DEF mục tiêu −10%.', status: 'entangled', duration: 2, value: 10),
            13 => self::rule('delayed_damage', 'Sau 2 lượt gây thêm 120 Power và hồi 8% HP tối đa cho người gieo.', duration: 2, value: 120, heal: 8),
            14 => self::rule('defense_reflect', 'Trong 3 lượt, DEF +15% và phản 10% damage thực nhận.', duration: 3, value: 15, secondaryValue: 10),
            15 => self::rule('heal_regeneration', 'Hồi ngay 8% HP, sau đó hồi 7% cuối mỗi lượt trong 3 lượt; không cộng dồn.', duration: 3, value: 8, secondaryValue: 7),
            17 => self::rule('life_steal', 'Hồi 50% damage thực gây ra, tối đa 12% HP tối đa.', value: 50, cap: 12),
            18 => self::rule('status_or_power', 'Gây Quấn Quanh 2 lượt; nếu đã Quấn Quanh thì Power tăng thành 170 và không làm mới.', status: 'entangled', duration: 2, value: 10, conditionalPower: 170),
            19 => self::rule('delayed_damage', 'Gây 120 Power ngay; sau 2 lượt gây thêm 160 Power và hồi 12% HP tối đa.', duration: 2, value: 160, heal: 12),
            21 => self::rule('defense_stack', 'Sau khi đánh trúng nhận một tầng DEF +7% trong 2 lượt, tối đa 3 tầng.', duration: 2, value: 7, cap: 3),
            22 => self::rule('apply_status', 'Gây sát thương; 40% gây Mê Muội trong 2 lượt.', status: 'dazed', duration: 2, value: 20),
            23 => self::rule('conditional_power', 'Power tăng thành 170 nếu mục tiêu đang Mê Muội; không xóa trạng thái.', status: 'dazed', conditionalPower: 170),
            24 => self::rule('cleanse_regeneration', 'Xóa một debuff rồi hồi 5% HP cuối mỗi lượt trong 3 lượt.', duration: 3, value: 5),
            25 => self::rule('cleanse_immunity', 'Xóa toàn bộ debuff và miễn debuff mới trong 2 lượt.', duration: 2),
            27 => self::rule('defense_stack', 'Sau khi đánh trúng nhận hai tầng DEF +7% trong 2 lượt, tối đa 3 tầng.', duration: 2, value: 7, secondaryValue: 2, cap: 3),
            28 => self::rule('apply_status', 'Gây sát thương; 50% gây Mê Muội trong 2 lượt.', status: 'dazed', duration: 2, value: 20),
            29 => self::rule('consume_for_power', 'Power tăng thành 250 nếu mục tiêu Mê Muội, sau đó xóa trạng thái.', status: 'dazed', conditionalPower: 250),
            31 => self::rule('apply_status', 'Gây sát thương và giảm 15% chính xác trong 2 lượt.', status: 'accuracy_down', duration: 2, value: 15),
            32 => self::rule('apply_status', 'Gây sát thương và giảm 15% Linh xảo trong 2 lượt.', status: 'agility_down', duration: 2, value: 15),
            33 => self::rule('apply_status', 'Gây sát thương và giảm 15% damage đối thủ trong 2 lượt.', status: 'damage_down', duration: 2, value: 15),
            34 => self::rule('heal_reflect_chance', 'Hồi 10% HP; trong 2 lượt, mỗi đòn đến có 30% phản toàn bộ damage.', duration: 2, value: 10, secondaryValue: 30),
            35 => self::rule('damage_reduction_chance', 'Trong 3 lượt, mỗi đòn đến có 50% giảm một nửa damage thực nhận.', duration: 3, value: 50, secondaryValue: 50),
            37 => self::rule('apply_status', 'Gây sát thương và giảm 25% chính xác trong 3 lượt.', status: 'accuracy_down', duration: 3, value: 25),
            38 => self::rule('apply_status', 'Gây sát thương và giảm 25% Linh xảo trong 3 lượt.', status: 'agility_down', duration: 3, value: 25),
            39 => self::rule('apply_status', 'Gây sát thương và giảm 25% damage đối thủ trong 3 lượt.', status: 'damage_down', duration: 3, value: 25),
            41 => self::rule('apply_status', 'Gây sát thương; 20% gây Tê Liệt trong 2 lượt.', status: 'paralysis', duration: 2, value: 20),
            42 => self::rule('self_buff_on_hit', 'Sau khi đánh trúng, Linh xảo +10% trong 2 lượt; không cộng dồn.', status: 'agility_up', duration: 2, value: 10),
            43 => self::rule('remove_buff', 'Sau khi đánh trúng, xóa một trạng thái có lợi của mục tiêu.'),
            44 => self::rule('pp_overdrive', 'Trong 3 lượt, damage +40% nhưng mỗi Skill tiêu hao 2 PP.', duration: 3, value: 40),
            45 => self::rule('tradeoff_speed', 'Trong 3 lượt, Linh xảo +50% và DEF −25%.', duration: 3, value: 50, secondaryValue: 25),
            47 => self::rule('apply_status', 'Gây sát thương; 35% gây Tê Liệt trong 2 lượt.', status: 'paralysis', duration: 2, value: 20),
            48 => self::rule('self_buff_on_hit', 'Sau khi đánh trúng, Linh xảo +20% trong 2 lượt; không cộng dồn.', status: 'agility_up', duration: 2, value: 20),
            49 => self::rule('remove_buff_power', 'Xóa một buff; nếu thực sự xóa được, Power tăng thành 200.', conditionalPower: 200),
            51 => self::rule('apply_status', 'Gây sát thương và giảm 12% DEF trong 2 lượt.', status: 'defense_down', duration: 2, value: 12),
            52 => self::rule('chance_heal', 'Sau khi gây damage, có 25% hồi 10% HP tối đa.', value: 10, chance: 25),
            53 => self::rule('missing_hp_power', 'Mỗi 1% HP mục tiêu đã mất cộng 0,8 Power, tối đa 190.', value: 8, conditionalPower: 190),
            54 => self::rule('apply_status', 'Gây Quỷ Mị trong 1 lượt; Skill damage có 40% dội ngược và không trúng đối phương.', status: 'ghost_mirror', duration: 1, value: 40),
            55 => self::rule('apply_status', 'Trong hành động kế tiếp, mục tiêu dùng Skill ngẫu nhiên; Skill damage có 50% tự đánh mình.', status: 'confusion', duration: 1, value: 50),
            57 => self::rule('apply_status', 'Gây sát thương và giảm 20% DEF trong 2 lượt.', status: 'defense_down', duration: 2, value: 20),
            58 => self::rule('life_steal', 'Hồi 35% damage thực gây ra, tối đa 12% HP tối đa.', value: 35, cap: 12),
            59 => self::rule('missing_hp_power', 'Mỗi 1% HP mục tiêu đã mất cộng 0,9 Power, tối đa 250.', value: 9, conditionalPower: 250),
            61 => self::rule('apply_status', 'Gây sát thương và giảm 15% Linh xảo trong 2 lượt.', status: 'agility_down', duration: 2, value: 15),
            62 => self::rule('self_buff_on_hit', 'Sau khi đánh trúng, Sức mạnh +10% trong 2 lượt; không cộng dồn.', status: 'strength_up', duration: 2, value: 10),
            63 => self::rule('repeat_hit', 'Có 20% đánh thêm một hit 50% Power; hit phụ không áp dụng Effect.', value: 50, chance: 20),
            64 => self::rule('steal_buffs', 'Chuyển tối đa hai trạng thái có lợi của mục tiêu sang người dùng.', value: 2),
            65 => self::rule('repeat_buff', 'Hai Skill damage tiếp theo đánh thêm một hit 60% Power; hit phụ không gây Effect.', value: 60, cap: 2),
            67 => self::rule('apply_status', 'Gây sát thương và giảm 25% Linh xảo trong 3 lượt.', status: 'agility_down', duration: 3, value: 25),
            68 => self::rule('self_buff_on_hit', 'Sau khi đánh trúng, Sức mạnh +20% trong 2 lượt; không cộng dồn.', status: 'strength_up', duration: 2, value: 20),
            69 => self::rule('repeat_hit', 'Có 35% đánh thêm một hit 70% Power; hit phụ không áp dụng Effect.', value: 70, chance: 35),
            default => throw new InvalidArgumentException("Missing Liệt Hỏa v2 mechanics for Skill {$gameId}."),
        };
    }

    /**
     * @return array<string, mixed>
     */
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
    ): array {
        return array_filter([
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
        ], static fn (mixed $value): bool => $value !== null);
    }
}
