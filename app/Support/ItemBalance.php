<?php

namespace App\Support;

use InvalidArgumentException;

class ItemBalance
{
    public const VERSION = 'unified-item-v1';

    /**
     * Return the official unified profile for one decoded Item identity.
     *
     * @return array{
     *     name?: string,
     *     description: string,
     *     category: string,
     *     mechanic_key: string,
     *     usage_scope: string,
     *     equipment_slot: string|null,
     *     parameters: array<string, mixed>,
     *     is_active: bool,
     *     canonical?: array{source: string, source_table: int, game_id: int}
     * }
     */
    public static function profile(string $source, int $sourceTable, int $gameId): array
    {
        return match ($source) {
            'liet-hoa' => self::lietHoaProfile($sourceTable, $gameId),
            'cau-vong' => self::rainbowProfile($gameId),
            default => throw new InvalidArgumentException("Unknown Item source [{$source}]."),
        };
    }

    /**
     * Return the official Liệt Hỏa Item profile.
     *
     * @return array<string, mixed>
     */
    private static function lietHoaProfile(int $sourceTable, int $gameId): array
    {
        return match ($sourceTable) {
            2 => self::lietHoaBadge($gameId),
            3 => self::lietHoaAccessoryOrMaterial($gameId),
            4 => self::lietHoaConsumable($gameId),
            5 => self::lietHoaSpecialItem($gameId),
            default => throw new InvalidArgumentException(
                "Unknown Liệt Hỏa Item identity [{$sourceTable}:{$gameId}].",
            ),
        };
    }

    /** @return array<string, mixed> */
    private static function lietHoaBadge(int $gameId): array
    {
        $profiles = [
            0 => self::active(
                'Mở tầm nhìn trong bóng tối; khi cường hóa, hồi 10% HP cho đội sau chiến đấu.',
                'badge',
                'dark_vision_post_battle_heal',
                'account_passive',
                'badge',
                ['post_battle_hp_percent' => 10, 'exploration_ability' => 'dark_vision'],
            ),
            1 => self::active(
                'Cho phép dọn cây chắn đường; khi cường hóa, tăng 5% hiệu quả chiến đấu trong địa hình rừng.',
                'badge',
                'clear_plants_forest_bonus',
                'account_passive',
                'badge',
                ['terrain' => 'forest', 'terrain_bonus_percent' => 5, 'exploration_ability' => 'clear_plants'],
            ),
            2 => self::active(
                'Cho phép phá đá chắn đường; khi cường hóa, tăng 5% hiệu quả chiến đấu trong địa hình nham thạch.',
                'badge',
                'break_rocks_stone_bonus',
                'account_passive',
                'badge',
                ['terrain' => 'stone', 'terrain_bonus_percent' => 5, 'exploration_ability' => 'break_rocks'],
            ),
            3 => self::active(
                'Cho phép đi vào vùng nước; khi cường hóa, tăng 2% hiệu quả chiến đấu trong địa hình thủy vực.',
                'badge',
                'water_travel_water_bonus',
                'account_passive',
                'badge',
                ['terrain' => 'water', 'terrain_bonus_percent' => 2, 'exploration_ability' => 'water_travel'],
            ),
            4 => self::active(
                'Tăng 5% Phòng ngự; khi cường hóa, tăng thêm 2% Linh xảo.',
                'badge',
                'defense_agility_bonus',
                'account_passive',
                'badge',
                ['defense_percent' => 5, 'agility_percent' => 2],
            ),
            5 => self::active(
                'Cho phép thúc đẩy hạt giống; khi cường hóa, mỗi hiệp tăng 1% toàn bộ chỉ số, tối đa 20%.',
                'badge',
                'turn_stat_growth',
                'account_passive',
                'badge',
                ['per_turn_percent' => 1, 'maximum_percent' => 20, 'exploration_ability' => 'grow_seed'],
            ),
            6 => self::active(
                'Tăng 5% sát thương; khi cường hóa, giảm 50% thời lượng hiệu ứng bất lợi.',
                'badge',
                'damage_and_debuff_duration',
                'account_passive',
                'badge',
                ['damage_percent' => 5, 'debuff_duration_reduction_percent' => 50],
            ),
            7 => self::active(
                'Toàn bộ Pet dự bị nhận 100% EXP dù không trực tiếp tham chiến.',
                'badge',
                'full_bench_experience',
                'account_passive',
                'badge',
                ['bench_experience_percent' => 100],
            ),
        ];

        return $profiles[$gameId] ?? throw new InvalidArgumentException(
            "Unknown Liệt Hỏa badge [{$gameId}].",
        );
    }

    /** @return array<string, mixed> */
    private static function lietHoaAccessoryOrMaterial(int $gameId): array
    {
        $accessories = [
            0 => self::active(
                'Khi HP còn dưới 30%, tăng 100% Sức mạnh cho đến khi HP vượt ngưỡng.',
                'accessory',
                'low_hp_strength',
                'held_passive',
                'accessory',
                ['hp_threshold_percent' => 30, 'strength_percent' => 100],
            ),
            1 => self::active(
                'Tăng 10% Sức mạnh của Pet đang mang.',
                'accessory',
                'strength_bonus',
                'held_passive',
                'accessory',
                ['strength_percent' => 10],
            ),
            2 => self::active(
                'Tăng 15% Phòng ngự của Pet đang mang.',
                'accessory',
                'defense_bonus',
                'held_passive',
                'accessory',
                ['defense_percent' => 15],
            ),
            3 => self::active(
                'Giảm 20% xác suất Pet phải nhận hiệu ứng bất lợi.',
                'accessory',
                'status_resistance',
                'held_passive',
                'accessory',
                ['status_chance_reduction_percent' => 20],
            ),
            4 => self::active(
                'Tăng 10 điểm phần trăm tỷ lệ chí mạng.',
                'accessory',
                'critical_chance_bonus',
                'held_passive',
                'accessory',
                ['critical_chance_points' => 10],
            ),
            5 => self::active(
                'Pet đang mang nhận thêm 20% EXP sau chiến đấu.',
                'accessory',
                'experience_bonus',
                'held_passive',
                'accessory',
                ['experience_percent' => 20],
            ),
            6 => self::active(
                'Pet đang mang vẫn nhận EXP dự bị dù không trực tiếp tham chiến.',
                'accessory',
                'bench_experience',
                'held_passive',
                'accessory',
                ['bench_experience_percent' => 100],
            ),
            7 => self::active(
                'Pet đang mang luôn hành động đầu tiên trong lượt có cùng độ ưu tiên.',
                'accessory',
                'opening_priority',
                'held_passive',
                'accessory',
                ['priority_bonus' => 1],
            ),
            8 => self::active(
                'Mỗi đòn gây sát thương có 10% xác suất hồi HP bằng 20% sát thương vừa gây.',
                'accessory',
                'lifesteal_proc',
                'held_passive',
                'accessory',
                ['chance' => 10, 'damage_to_heal_percent' => 20],
            ),
            9 => self::active(
                'Đòn tấn công của Pet đang mang bỏ qua kiểm tra né tránh thông thường.',
                'accessory',
                'sure_hit',
                'held_passive',
                'accessory',
                ['ignore_evasion' => true],
            ),
            10 => self::active(
                'Khi đánh Pet hoang để bắt giữ, sát thương không thể khiến mục tiêu xuống dưới 10 HP.',
                'accessory',
                'capture_hp_floor',
                'held_passive',
                'accessory',
                ['minimum_target_hp' => 10, 'wild_only' => true],
            ),
            11 => self::active(
                'Tăng 20% tỷ lệ bắt Pet hoang.',
                'accessory',
                'capture_rate_bonus',
                'held_passive',
                'accessory',
                ['capture_rate_percent' => 20],
            ),
        ];

        if (isset($accessories[$gameId])) {
            return $accessories[$gameId];
        }

        $materials = [
            12 => ['evolution_core', 1, 'Lõi tiến hóa phổ thông dùng trong các công thức bậc thấp và tiêu chuẩn.'],
            13 => ['evolution_core', 2, 'Lõi tiến hóa cao cấp dùng cho các form giữa và form cuối.'],
            14 => ['evolution_core', 3, 'Lõi tiến hóa hiếm dành cho form cuối mạnh hoặc dòng đặc trưng.'],
            15 => ['mutation_core', 2, 'Lõi dị hóa dùng để mở nhánh đột biến thông thường.'],
            16 => ['mutation_core', 3, 'Lõi dị hóa hiếm dành cho nhánh đột biến đặc biệt.'],
        ];

        if (isset($materials[$gameId])) {
            [$mechanic, $tier, $description] = $materials[$gameId];

            return self::active(
                $description,
                'evolution_material',
                $mechanic,
                'crafting',
                null,
                ['material_tier' => $tier, 'material_role' => 'core'],
            );
        }

        if ($gameId === 17) {
            return self::active(
                'Chìa khóa dùng để mở bảo rương đặc biệt trong quá trình khám phá.',
                'exploration',
                'open_treasure_chest',
                'exploration',
                null,
                ['chest_type' => 'golden'],
            );
        }

        throw new InvalidArgumentException("Unknown Liệt Hỏa table 3 Item [{$gameId}].");
    }

    /** @return array<string, mixed> */
    private static function lietHoaConsumable(int $gameId): array
    {
        $profiles = [
            0 => self::active('Bắt Pet hoang với xác suất thành công tuyệt đối.', 'capture_ball', 'capture', 'battle_consumable', null, ['capture_multiplier' => 9999, 'guaranteed' => true]),
            1 => self::active('Cầu phong ấn phổ thông với hệ số bắt giữ 100%.', 'capture_ball', 'capture', 'battle_consumable', null, ['capture_multiplier' => 100]),
            2 => self::active('Cầu phong ấn cao cấp với hệ số bắt giữ 140%.', 'capture_ball', 'capture', 'battle_consumable', null, ['capture_multiplier' => 140]),
            3 => self::active('Cầu dành cho Pet đặc biệt với hệ số bắt giữ 200%.', 'capture_ball', 'capture', 'battle_consumable', null, ['capture_multiplier' => 200]),
            4 => self::active('Hồi 50% HP tối đa và thêm 50 HP cho một Pet còn sống.', 'recovery', 'restore_hp', 'consumable', null, ['hp_percent' => 50, 'hp_flat' => 50, 'living_only' => true]),
            5 => self::active('Hồi đầy HP cho một Pet còn sống.', 'recovery', 'restore_hp', 'consumable', null, ['hp_percent' => 100, 'living_only' => true]),
            6 => self::active('Hồi 50% PP tối đa cho một Skill đã chọn.', 'recovery', 'restore_pp', 'consumable', null, ['pp_percent' => 50, 'target' => 'one_skill']),
            7 => self::active('Hồi đầy PP cho một Skill đã chọn.', 'recovery', 'restore_pp', 'consumable', null, ['pp_percent' => 100, 'target' => 'one_skill']),
            8 => self::active('Hồi 50% HP và 50% PP tối đa cho một Skill đã chọn.', 'recovery', 'restore_hp_pp', 'consumable', null, ['hp_percent' => 50, 'pp_percent' => 50, 'target' => 'pet_and_one_skill']),
            9 => self::active('Hồi đầy HP và PP cho toàn bộ Skill của một Pet còn sống.', 'recovery', 'restore_hp_pp', 'consumable', null, ['hp_percent' => 100, 'pp_percent' => 100, 'target' => 'pet_and_all_skills']),
            10 => self::active('Loại bỏ toàn bộ trạng thái bất lợi có thể thanh tẩy khỏi một Pet.', 'recovery', 'cleanse_status', 'consumable', null, ['cleanse' => 'all_removable']),
            11 => self::active('Hồi sinh một Pet với 50% HP và hồi 50% PP cho toàn bộ Skill.', 'recovery', 'revive', 'consumable', null, ['hp_percent' => 50, 'pp_percent' => 50, 'target' => 'fainted_pet']),
            12 => self::active('Hồi sinh một Pet với đầy HP và PP.', 'recovery', 'revive', 'consumable', null, ['hp_percent' => 100, 'pp_percent' => 100, 'target' => 'fainted_pet']),
            13 => self::active('Ngăn các cuộc chạm trán ngẫu nhiên trong 500 bước di chuyển.', 'exploration', 'repel_encounters', 'exploration_consumable', null, ['steps' => 500]),
            14 => self::active('Hoàn tất ngay thời gian ấp của một trứng Pet.', 'exploration', 'finish_incubation', 'consumable', null, ['incubation_reduction_percent' => 100]),
        ];

        return $profiles[$gameId] ?? throw new InvalidArgumentException(
            "Unknown Liệt Hỏa table 4 Item [{$gameId}].",
        );
    }

    /** @return array<string, mixed> */
    private static function lietHoaSpecialItem(int $gameId): array
    {
        $profiles = [
            0 => self::active('Trứng Pet chưa xác định Chủng, được ấp để nhận một Pet mới.', 'pet_egg', 'hatch_random_pet', 'incubation', null, ['species' => null]),
            1 => self::active('Dây cương tăng tốc độ di chuyển trên bản đồ.', 'exploration', 'mount_speed', 'exploration', null, ['mount_tier' => 1, 'avoid_encounters' => false]),
            2 => self::active('Dây cương tăng tốc và ngăn chạm trán ngẫu nhiên khi cưỡi.', 'exploration', 'mount_speed_repel', 'exploration', null, ['mount_tier' => 2, 'avoid_encounters' => true]),
            3 => self::active('Phương tiện đặc biệt cho phép di chuyển tới Thiên Giới.', 'exploration', 'sky_travel', 'exploration', null, ['mount_tier' => 3, 'destination' => 'sky_realm']),
            4 => self::active('Phương tiện có thể phá chướng ngại và tránh chạm trán khi di chuyển.', 'exploration', 'mount_break_obstacles', 'exploration', null, ['mount_tier' => 4, 'avoid_encounters' => true, 'break_obstacles' => true]),
            5 => self::active('Mở mục tra cứu thông tin Pet đã phát hiện.', 'exploration', 'open_pet_encyclopedia', 'key_item', null, ['feature' => 'pet_encyclopedia']),
            6 => self::active('Mở mục tra cứu huy chương và thành tựu đã đạt.', 'exploration', 'open_badge_book', 'key_item', null, ['feature' => 'badge_book']),
            7 => self::statModifier('agility', ['strength', 'hp']),
            8 => self::statModifier('strength', ['hp', 'agility']),
            9 => self::statModifier('hp', ['strength', 'agility']),
            10 => self::active('Cho phép truyền tống giữa các điểm đã mở trên Đại Địa Đồ.', 'exploration', 'world_teleport', 'key_item', null, ['destination_scope' => 'unlocked_world_map']),
        ];

        return $profiles[$gameId] ?? throw new InvalidArgumentException(
            "Unknown Liệt Hỏa table 5 Item [{$gameId}].",
        );
    }

    /**
     * Return the official Cầu Vồng Item profile.
     *
     * @return array<string, mixed>
     */
    private static function rainbowProfile(int $gameId): array
    {
        $canonicalMappings = [
            0 => ['liet-hoa', 4, 4],
            1 => ['liet-hoa', 4, 4],
            2 => ['liet-hoa', 4, 5],
            3 => ['liet-hoa', 4, 6],
            4 => ['liet-hoa', 4, 7],
            5 => ['liet-hoa', 4, 8],
            6 => ['liet-hoa', 4, 9],
            7 => ['liet-hoa', 4, 11],
            8 => ['liet-hoa', 4, 10],
            9 => ['liet-hoa', 4, 1],
            10 => ['liet-hoa', 4, 2],
            11 => ['liet-hoa', 4, 0],
            14 => ['liet-hoa', 4, 13],
            15 => ['liet-hoa', 4, 13],
            34 => ['liet-hoa', 3, 15],
            36 => ['cau-vong', 0, 37],
            45 => ['liet-hoa', 3, 5],
            46 => ['liet-hoa', 3, 5],
            59 => ['cau-vong', 0, 58],
            61 => ['cau-vong', 0, 60],
            65 => ['cau-vong', 0, 58],
            66 => ['cau-vong', 0, 60],
            67 => ['cau-vong', 0, 62],
            68 => ['cau-vong', 0, 63],
            69 => ['cau-vong', 0, 64],
        ];

        if (isset($canonicalMappings[$gameId])) {
            [$source, $sourceTable, $canonicalGameId] = $canonicalMappings[$gameId];

            return self::variant($source, $sourceTable, $canonicalGameId);
        }

        if ($gameId >= 16 && $gameId <= 25) {
            $speciesByGameId = [
                16 => 'manh-thu',
                17 => 'manh-thu',
                18 => 'thuc-vat',
                19 => 'thuc-vat',
                20 => 'hai-duong',
                21 => 'hai-duong',
                22 => 'phi-hanh',
                23 => 'phi-hanh',
                24 => 'kim-loai',
                25 => 'kim-loai',
            ];
            $tier = $gameId % 2 === 0 ? 1 : 2;

            return self::active(
                $tier === 1
                    ? 'Nguyên liệu Chủng cơ bản dùng cùng lõi tiến hóa trong công thức Pet hợp nhất.'
                    : 'Nguyên liệu Chủng cao cấp dùng cùng lõi tiến hóa cho các form mạnh hơn.',
                'evolution_material',
                'species_evolution_material',
                'crafting',
                null,
                ['material_role' => 'species', 'material_tier' => $tier, 'species' => $speciesByGameId[$gameId]],
            );
        }

        if ($gameId >= 26 && $gameId <= 30) {
            return self::active(
                'Xúc tác đặc trưng chỉ dùng trong công thức tiến hóa của một dòng Pet hiếm hoặc form cuối đặc biệt.',
                'evolution_material',
                'signature_evolution_material',
                'crafting',
                null,
                ['material_role' => 'signature', 'material_tier' => 3],
            );
        }

        $profiles = [
            31 => self::active('Vật phẩm nhiệm vụ dùng để mở tuyến thu phục Đao Thương Tướng Quân.', 'quest_item', 'unlock_pet_quest', 'quest', null, ['quest_target' => 'dao-thuong-tuong-quan']),
            32 => self::active('Bảo rương cần một chìa khóa tương ứng để mở và nhận phần thưởng.', 'exploration', 'locked_treasure_chest', 'exploration', null, ['requires_mechanic' => 'treasure_key']),
            33 => self::active('Chìa khóa dùng để mở một bảo rương Cầu Vồng.', 'exploration', 'treasure_key', 'exploration', null, ['opens_mechanic' => 'locked_treasure_chest']),
            37 => self::active('Khi HP dưới 50%, tự hồi 10% HP tối đa một lần mỗi trận.', 'passive_equipment', 'emergency_self_heal', 'held_passive', 'passive', ['hp_threshold_percent' => 50, 'heal_percent' => 10, 'maximum_activations' => 1]),
            39 => self::active('Khi bắt đầu trận, giới hạn đối thủ sử dụng tối đa ba Skill trong hai hiệp đầu.', 'passive_equipment', 'skill_seal', 'held_passive', 'passive', ['skill_slot_limit' => 3, 'duration' => 2]),
            40 => self::active('Pet Chủng Thực Vật tăng 25% sát thương của hiệu ứng Hủ Thực.', 'passive_equipment', 'corrosion_power', 'held_passive', 'passive', ['species' => 'thuc-vat', 'effect' => 'corrosion', 'damage_percent' => 25]),
            41 => self::active('Pet Chủng Mãnh Thú kéo dài hiệu ứng Tê Liệt do mình gây thêm một hiệp.', 'passive_equipment', 'paralysis_duration', 'held_passive', 'passive', ['species' => 'manh-thu', 'effect' => 'paralysis', 'duration_bonus' => 1]),
            42 => self::active('Pet Chủng Kim Loại tăng 15% hiệu quả Phòng ngự.', 'passive_equipment', 'metal_defense', 'held_passive', 'passive', ['species' => 'kim-loai', 'defense_percent' => 15]),
            43 => self::active('Đòn đánh của Pet Chủng Phi Hành có 25% xác suất làm Skill vừa dùng của đối thủ mất thêm 1 PP.', 'passive_equipment', 'enemy_pp_drain', 'held_passive', 'passive', ['species' => 'phi-hanh', 'chance' => 25, 'pp_amount' => 1]),
            44 => self::active('Pet Chủng Hải Dương có 25% xác suất được hoàn lại 1 PP sau khi dùng Skill gây sát thương.', 'passive_equipment', 'self_pp_refund', 'held_passive', 'passive', ['species' => 'hai-duong', 'chance' => 25, 'pp_amount' => 1]),
            47 => self::active('Khi bị hạ gục, có 70% xác suất hồi sinh với 30% HP; chỉ kích hoạt một lần mỗi trận.', 'passive_equipment', 'battle_revive', 'held_passive', 'passive', ['chance' => 70, 'hp_percent' => 30, 'maximum_activations' => 1]),
            48 => self::active('Tăng 20% xác suất gặp Pet hiếm khi khám phá.', 'passive_equipment', 'rare_encounter_bonus', 'held_passive', 'passive', ['rare_encounter_percent' => 20]),
            50 => self::active('Khi bắt Pet thất bại, mục tiêu sẽ không bỏ chạy vì lần bắt đó.', 'passive_equipment', 'prevent_capture_flee', 'held_passive', 'passive', ['prevent_flee' => true]),
            51 => self::active('Bảo đảm chạy trốn thành công khỏi trận đấu với Pet hoang.', 'passive_equipment', 'guaranteed_escape', 'held_passive', 'passive', ['success_percent' => 100, 'wild_only' => true]),
            57 => self::active('Khi bị tấn công, có 30% xác suất né hoàn toàn đòn đánh.', 'passive_equipment', 'evasion_proc', 'held_passive', 'passive', ['chance' => 30]),
            58 => self::speciesEgg('Trứng Chủng Thực Vật', 'thuc-vat'),
            60 => self::speciesEgg('Trứng Chủng Kim Loại', 'kim-loai'),
            62 => self::speciesEgg('Trứng Chủng Phi Hành', 'phi-hanh'),
            63 => self::speciesEgg('Trứng Chủng Mãnh Thú', 'manh-thu'),
            64 => self::speciesEgg('Trứng Chủng Hải Dương', 'hai-duong'),
        ];

        return $profiles[$gameId] ?? throw new InvalidArgumentException(
            "Unknown active Cầu Vồng Item [{$gameId}].",
        );
    }

    /**
     * Build one active Item profile.
     *
     * @param  array<string, mixed>  $parameters
     * @return array<string, mixed>
     */
    private static function active(
        string $description,
        string $category,
        string $mechanicKey,
        string $usageScope,
        ?string $equipmentSlot,
        array $parameters,
    ): array {
        return [
            'description' => $description,
            'category' => $category,
            'mechanic_key' => $mechanicKey,
            'usage_scope' => $usageScope,
            'equipment_slot' => $equipmentSlot,
            'parameters' => $parameters,
            'is_active' => true,
        ];
    }

    /**
     * Build an inactive source variant that points to its canonical Item.
     *
     * @return array<string, mixed>
     */
    private static function variant(string $source, int $sourceTable, int $gameId): array
    {
        return [
            'description' => 'Biến thể tài nguyên gốc đã được quy về Item chuẩn có cùng công dụng.',
            'category' => 'archive_variant',
            'mechanic_key' => 'canonical_variant',
            'usage_scope' => 'archive',
            'equipment_slot' => null,
            'parameters' => [],
            'is_active' => false,
            'canonical' => [
                'source' => $source,
                'source_table' => $sourceTable,
                'game_id' => $gameId,
            ],
        ];
    }

    /**
     * Build one stat-budget redistribution stone.
     *
     * @param  list<string>  $donorStats
     * @return array<string, mixed>
     */
    private static function statModifier(string $targetStat, array $donorStats): array
    {
        return self::active(
            'Chuyển 5% chỉ số cấp 50 từ mỗi chỉ số phụ sang chỉ số đích; tổng ngân sách chỉ số không đổi.',
            'stat_modifier',
            'redistribute_stats',
            'consumable',
            null,
            [
                'target_stat' => $targetStat,
                'donor_stats' => $donorStats,
                'transfer_percent_each' => 5,
                'preserve_total_budget' => true,
            ],
        );
    }

    /** @return array<string, mixed> */
    private static function speciesEgg(string $name, string $species): array
    {
        return [
            ...self::active(
                'Trứng Pet bảo đảm nở ra Pet thuộc đúng Chủng được ghi trên trứng.',
                'pet_egg',
                'hatch_species_pet',
                'incubation',
                null,
                ['species' => $species],
            ),
            'name' => $name,
        ];
    }
}
