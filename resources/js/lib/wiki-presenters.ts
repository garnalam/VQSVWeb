import type { WikiItem, WikiSkill } from '@/types';

export const ITEM_CATEGORY_LABELS: Record<string, string> = {
    consumable: 'Đạo cụ',
    mineral: 'Khoáng thạch',
    medal: 'Huy chương',
    ring: 'Vòng',
    accessory: 'Trang sức',
    badge: 'Huy chương',
    badge_book: 'Sổ huy chương',
    capture_ball: 'Cầu phong ấn',
    encyclopedia: 'Đồ giám',
    evolution_material: 'Nguyên liệu tiến hóa',
    signature_evolution_material: 'Xúc tác tiến hóa đặc trưng',
    key: 'Chìa khóa',
    mount: 'Thú cưỡi',
    mutation_material: 'Nguyên liệu dị hóa',
    passive_equipment: 'Trang bị nội tại',
    pet_egg: 'Trứng Pet',
    exploration: 'Khám phá',
    quest_item: 'Vật phẩm nhiệm vụ',
    archive_variant: 'Biến thể lưu trữ',
    recovery: 'Hồi phục',
    stat_modifier: 'Điều chỉnh thuộc tính',
    teleport: 'Truyền tống',
    utility: 'Tiện ích',
};

export const ITEM_SOURCE_LABELS: Record<number, string> = {
    0: 'Kho vật phẩm',
    2: 'Huy chương Đạo Tràng',
    3: 'Trang sức & Nguyên liệu',
    4: 'Cầu phong ấn & Dược phẩm',
    5: 'Nhiệm vụ & Vật phẩm đặc thù',
};

export const ITEM_SOURCE_ARTWORK: Record<number, string> = {
    0: 'from-cyan-400 via-sky-500 to-violet-600',
    2: 'from-amber-400 via-orange-500 to-rose-600',
    3: 'from-violet-500 via-fuchsia-500 to-pink-600',
    4: 'from-emerald-400 via-teal-500 to-cyan-600',
    5: 'from-sky-400 via-blue-600 to-indigo-700',
};

export function itemCategoryLabel(category: string): string {
    return ITEM_CATEGORY_LABELS[category] ?? category;
}

export function itemSourceLabel(sourceTable: number): string {
    return ITEM_SOURCE_LABELS[sourceTable] ?? 'Vật phẩm đặc biệt';
}

export function itemEffectLabel(
    item: Pick<WikiItem, 'category' | 'effect_type' | 'mechanic_key'>,
): string {
    const mechanicLabel =
        item.mechanic_key === null
            ? undefined
            : ITEM_MECHANIC_LABELS[item.mechanic_key];

    if (mechanicLabel !== undefined) {
        return mechanicLabel;
    }

    if (item.category === 'capture_ball') {
        return 'Hỗ trợ bắt giữ Pet';
    }

    return (
        {
            1: 'Hồi phục Sinh mệnh',
            2: 'Hồi phục PP',
            3: 'Hồi phục Sinh mệnh & PP',
            4: 'Hồi sinh Pet',
            5: 'Giải trạng thái',
            9: 'Rút ngắn thời gian ấp trứng',
            10: 'Tránh chạm trán kẻ địch',
        }[item.effect_type ?? -1] ?? 'Công dụng đặc thù'
    );
}

export const ITEM_MECHANIC_LABELS: Record<string, string> = {
    canonical_variant: 'Dùng chung Item chuẩn',
    capture: 'Hỗ trợ bắt giữ Pet',
    restore_hp: 'Hồi phục Sinh mệnh',
    restore_pp: 'Hồi phục PP',
    restore_hp_pp: 'Hồi phục Sinh mệnh & PP',
    revive: 'Hồi sinh Pet',
    cleanse_status: 'Giải trạng thái',
    evolution_core: 'Lõi tiến hóa',
    mutation_core: 'Lõi dị hóa',
    species_evolution_material: 'Nguyên liệu tiến hóa theo Chủng',
    signature_evolution_material: 'Xúc tác tiến hóa đặc trưng',
    low_hp_strength: 'Cường công khi thấp HP',
    strength_bonus: 'Tăng Sức mạnh',
    defense_bonus: 'Tăng Phòng ngự',
    status_resistance: 'Kháng hiệu ứng',
    critical_chance_bonus: 'Tăng tỷ lệ chí mạng',
    experience_bonus: 'Tăng EXP',
    bench_experience: 'Nhận EXP dự bị',
    opening_priority: 'Ưu tiên hành động đầu',
    lifesteal_proc: 'Hút HP theo đòn đánh',
    sure_hit: 'Đòn đánh chắc chắn trúng',
    capture_hp_floor: 'Giữ HP mục tiêu khi bắt Pet',
    capture_rate_bonus: 'Tăng tỷ lệ bắt Pet',
    emergency_self_heal: 'Tự hồi phục khẩn cấp',
    skill_seal: 'Phong bế Skill',
    corrosion_power: 'Cường hóa Hủ Thực',
    paralysis_duration: 'Kéo dài Tê Liệt',
    metal_defense: 'Cường hóa phòng ngự Kim Loại',
    enemy_pp_drain: 'Rút PP đối thủ',
    self_pp_refund: 'Hoàn lại PP',
    battle_revive: 'Hồi sinh trong chiến đấu',
    rare_encounter_bonus: 'Tăng gặp Pet hiếm',
    prevent_capture_flee: 'Ngăn Pet bỏ chạy',
    guaranteed_escape: 'Bảo đảm chạy trốn',
    evasion_proc: 'Né tránh đòn đánh',
    hatch_random_pet: 'Ấp Pet ngẫu nhiên',
    hatch_species_pet: 'Ấp Pet theo Chủng',
    redistribute_stats: 'Điều chỉnh thiên hướng chỉ số',
    repel_encounters: 'Ngăn chạm trán',
    finish_incubation: 'Hoàn tất ấp trứng',
    world_teleport: 'Truyền tống thế giới',
    mount_speed: 'Tăng tốc di chuyển',
    mount_speed_repel: 'Tăng tốc và tránh địch',
    sky_travel: 'Di chuyển tới Thiên Giới',
    mount_break_obstacles: 'Phá chướng ngại',
    open_pet_encyclopedia: 'Mở hồ sơ Pet',
    open_badge_book: 'Mở sổ huy chương',
    open_treasure_chest: 'Mở bảo rương',
    locked_treasure_chest: 'Bảo rương khóa',
    treasure_key: 'Chìa khóa bảo rương',
    unlock_pet_quest: 'Mở nhiệm vụ Pet',
    dark_vision_post_battle_heal: 'Tầm nhìn tối & hồi phục',
    clear_plants_forest_bonus: 'Dọn cây & cường hóa rừng',
    break_rocks_stone_bonus: 'Phá đá & cường hóa nham thạch',
    water_travel_water_bonus: 'Đi thủy & cường hóa thủy vực',
    defense_agility_bonus: 'Tăng Phòng ngự & Linh xảo',
    turn_stat_growth: 'Tăng chỉ số theo hiệp',
    damage_and_debuff_duration: 'Tăng sát thương & giảm debuff',
    full_bench_experience: 'Toàn đội dự bị nhận EXP',
};

export function itemUsageScopeLabel(scope: string | null): string {
    return (
        {
            account_passive: 'Hiệu lực toàn tài khoản',
            held_passive: 'Pet mang để kích hoạt',
            battle_consumable: 'Dùng trong chiến đấu',
            consumable: 'Vật phẩm tiêu hao',
            exploration_consumable: 'Tiêu hao khi khám phá',
            crafting: 'Dùng trong công thức',
            incubation: 'Dùng tại khu ấp trứng',
            exploration: 'Dùng khi khám phá',
            key_item: 'Vật phẩm tính năng',
            quest: 'Dùng trong nhiệm vụ',
            archive: 'Chỉ lưu dữ liệu nguồn',
        }[scope ?? ''] ?? 'Công dụng đặc thù'
    );
}

export function itemEquipmentSlotLabel(slot: string | null): string {
    return (
        {
            accessory: 'Ô Trang sức Pet',
            passive: 'Ô Trang bị nội tại',
            badge: 'Ô Huy chương',
        }[slot ?? ''] ?? 'Không cần trang bị'
    );
}

export type SkillRole = {
    label: string;
    shortLabel: string;
    kind: 'attack' | 'hybrid' | 'support';
};

export function skillRole(
    skill: Pick<WikiSkill, 'power_percent' | 'effect'>,
): SkillRole {
    if (skill.power_percent === 0) {
        return {
            label: 'Bổ trợ / Hiệu ứng',
            shortLabel: 'Chiêu thức hiệu ứng',
            kind: 'support',
        };
    }

    if (skill.effect !== null) {
        return {
            label: 'Tấn công kèm trạng thái',
            shortLabel: 'Tấn công + trạng thái',
            kind: 'hybrid',
        };
    }

    return {
        label: 'Kỹ năng tấn công',
        shortLabel: 'Tấn công',
        kind: 'attack',
    };
}
