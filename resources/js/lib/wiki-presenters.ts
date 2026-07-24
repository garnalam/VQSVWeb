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
    item: Pick<WikiItem, 'category' | 'effect_type'>,
): string {
    if (item.category === 'capture_ball') {
        return 'Hỗ trợ bắt giữ Pet';
    }

    return (
        {
            1: 'Hồi phục Sinh mệnh',
            2: 'Hồi phục năng lượng',
            3: 'Hồi phục Sinh mệnh & năng lượng',
            4: 'Hồi sinh Pet',
            5: 'Giải trạng thái',
            9: 'Rút ngắn thời gian ấp trứng',
            10: 'Tránh chạm trán kẻ địch',
        }[item.effect_type ?? -1] ?? 'Công dụng đặc thù'
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
