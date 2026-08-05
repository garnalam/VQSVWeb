const GAME_ASSET_ROOT = '/assets/game';

export const gameDecor = {
    logo: `${GAME_ASSET_ROOT}/decor/logo.png`,
    scenicBackground: `${GAME_ASSET_ROOT}/decor/scenic_background.png`,
    panelPrimary: `${GAME_ASSET_ROOT}/decor/panel_primary.png`,
} as const;

export const gameUi = {
    actionToolbar: `${GAME_ASSET_ROOT}/ui/action_toolbar.png`,
    back: `${GAME_ASSET_ROOT}/ui/back.png`,
    badgeSystem: `${GAME_ASSET_ROOT}/ui/badge_system.png`,
    battle: `${GAME_ASSET_ROOT}/ui/battle.png`,
    frameCompact: `${GAME_ASSET_ROOT}/ui/frame_compact.png`,
    map: `${GAME_ASSET_ROOT}/ui/map.png`,
    panelTall: `${GAME_ASSET_ROOT}/ui/panel_tall.png`,
    panelWide: `${GAME_ASSET_ROOT}/ui/panel_wide.png`,
    petSystem: `${GAME_ASSET_ROOT}/ui/pet_system.png`,
    progressCyan: `${GAME_ASSET_ROOT}/ui/progress_cyan.png`,
    quest: `${GAME_ASSET_ROOT}/ui/quest.png`,
    tab: `${GAME_ASSET_ROOT}/ui/tab.png`,
} as const;

const ELEMENT_ICON_NAMES = [
    'fire',
    'wood',
    'earth',
    'water',
    'electric',
    'ghost',
    'wind',
] as const;

export function elementIconUrl(elementId: number): string {
    const iconName = ELEMENT_ICON_NAMES[elementId] ?? 'earth';

    return `${GAME_ASSET_ROOT}/ui/element_${iconName}.png`;
}

export function petArtworkUrl(spriteId: number, assetKey = 'liet-hoa'): string {
    if (assetKey === 'cau-vong' || assetKey === 'vqsv4') {
        return `${GAME_ASSET_ROOT}/${assetKey}/pets/${spriteId}.png`;
    }

    return `${GAME_ASSET_ROOT}/pets/${spriteId}.png`;
}

export function petSkillAnimationUrl(
    spriteId: number,
    assetKey = 'liet-hoa',
): string {
    const filename = `${spriteId}-skill.webp`;

    return assetKey === 'cau-vong' || assetKey === 'vqsv4'
        ? `${GAME_ASSET_ROOT}/${assetKey}/pet-animations/${filename}`
        : `${GAME_ASSET_ROOT}/pet-animations/${filename}`;
}

export function itemArtworkUrl(
    frameId: number | null,
    assetKey = 'liet-hoa',
): string | null {
    if (frameId === null || (assetKey !== 'cau-vong' && frameId <= 0)) {
        return null;
    }

    return assetKey === 'cau-vong'
        ? `${GAME_ASSET_ROOT}/cau-vong/items/${frameId}.png`
        : `${GAME_ASSET_ROOT}/items/${frameId}.png`;
}

export function badgeArtworkUrl(gameId: number): string | null {
    if (gameId < 0 || gameId > 7) {
        return null;
    }

    return `${GAME_ASSET_ROOT}/badges/${gameId}.png`;
}

export function effectIconUrl(
    kind: 'beneficial' | 'harmful' | 'neutral',
    gameId: number,
    sourceTable?: number,
): string {
    if (sourceTable === 11) {
        return `${GAME_ASSET_ROOT}/cau-vong/effects/status-${gameId}.png`;
    }

    return `${GAME_ASSET_ROOT}/effects/${kind}-${gameId}.png`;
}

export function skillArtworkUrl(skillId: number, assetKey: string): string {
    return assetKey === 'cau-vong'
        ? `${GAME_ASSET_ROOT}/cau-vong/skills/${skillId}.png`
        : skillMotifUrl(skillId, 0);
}

export function skillMotifUrl(skillId: number, elementId: number): string {
    const motifId = Math.abs(skillId * 3 + elementId) % 12;

    return `${GAME_ASSET_ROOT}/skills/motif-${motifId}.png`;
}
