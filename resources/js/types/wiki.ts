import type { InertiaLinkProps } from '@inertiajs/react';

export type WikiGameSource = {
    name: string;
    slug: 'liet-hoa' | 'cau-vong' | string;
    asset_key: string;
    color: string;
};

export type WikiElement = {
    game_id: number;
    name: string;
    slug: string;
    color: string | null;
    game_source?: WikiGameSource;
};

export type WikiCombatElement = {
    game_id: number;
    name: string;
    slug: string;
    color: string;
};

export type WikiSpecies = {
    name: string;
    slug: string;
    color: string;
};

export type WikiPet = {
    id: number;
    game_source: WikiGameSource;
    game_id: number;
    name: string;
    slug: string;
    sprite_id: number;
    learning_group: number;
    quality_tier: number;
    belongs_to_evolution_family: boolean;
    can_evolve: boolean;
    is_final_stage: boolean;
    evolution_stage: number;
    evolution_family_size: number;
    family_root_game_id: number;
    family_root_name: string;
    combat_element: WikiCombatElement;
    species: WikiSpecies;
};

export type WikiPetStatFormula = {
    base: number;
    per_level: number;
    offset: number;
    per_ten_levels: boolean;
};

export type WikiPetSkill = {
    id: number;
    game_id: number;
    name: string;
    slug: string;
    description: string;
    power_percent: number;
    tier: number;
    max_uses: number;
    energy_cost: number | null;
    status_chance: number | null;
    unlock_level: number;
    effect: WikiEffect | null;
};

export type WikiEvolutionPet = {
    id: number;
    game_id: number;
    name: string;
    slug: string;
    sprite_id: number;
    quality_tier: number;
    stage: number;
    is_current: boolean;
};

export type WikiEvolutionTransition = {
    from_pet_id: number;
    to_pet_id: number;
    type: 'evolution' | 'mutation';
    quantity: number;
    materials?: { item_game_id: number; quantity: number }[] | null;
    item: Pick<
        WikiItem,
        | 'id'
        | 'game_source'
        | 'source_table'
        | 'game_id'
        | 'name'
        | 'slug'
        | 'frame_id'
    >;
};

export type WikiPetDetail = {
    id: number;
    game_source: WikiGameSource;
    game_id: number;
    name: string;
    name_original: string;
    slug: string;
    sprite_id: number;
    variant_code: number;
    quality_tier: number;
    rarity_or_growth_code: number;
    learning_group: number;
    effectiveness_class: number;
    raw_values: unknown[] | null;
    description: string | null;
    lore: string;
    combat_note: string | null;
    acquisition: {
        code: number | null;
        method: string | null;
        locations: string[];
    };
    quality_multiplier: number;
    stats: {
        hp: WikiPetStatFormula;
        energy: WikiPetStatFormula | null;
        strength: WikiPetStatFormula;
        defense: WikiPetStatFormula;
        agility: WikiPetStatFormula;
    };
    evolution_stage: number;
    evolution_stage_count: number;
    belongs_to_evolution_family: boolean;
    can_evolve: boolean;
    is_final_stage: boolean;
    combat_element: WikiCombatElement;
    species: WikiSpecies;
    skills: WikiPetSkill[];
    evolution_family: {
        pets: WikiEvolutionPet[];
        transitions: WikiEvolutionTransition[];
    };
};

export type WikiEffect = {
    source_table: number;
    game_id: number;
    name: string;
    kind: 'beneficial' | 'harmful' | 'neutral';
    duration: number | null;
    description?: string | null;
};

export type WikiSkill = {
    id: number;
    game_source: WikiGameSource;
    game_id: number;
    name: string;
    slug: string;
    description: string;
    power_percent: number;
    tier: number;
    max_uses: number;
    energy_cost: number | null;
    status_chance: number | null;
    effect_mode: number;
    effect_parameter: number | null;
    target_side: number;
    element: WikiElement;
    effect: WikiEffect | null;
};

export type WikiSkillUnlockRule = {
    learning_group: number;
    unlock_level: number;
    maximum_skill_tier: number;
};

export type WikiCompatiblePet = {
    id: number;
    game_id: number;
    name: string;
    slug: string;
    sprite_id: number;
    learning_group: number;
    unlock_level: number;
};

export type WikiSkillDetail = WikiSkill & {
    name_original: string;
    description_original: string;
    raw_values: unknown[] | null;
    unlock_rules: WikiSkillUnlockRule[];
    compatible_pets: WikiCompatiblePet[];
};

export type WikiItem = {
    id: number;
    game_source: WikiGameSource;
    source_table: number;
    game_id: number;
    name: string;
    slug: string;
    description: string | null;
    category: string;
    frame_id: number | null;
    cost: number | null;
    currency_code: number | null;
    effect_type: number | null;
    effect_parameters: Record<string, unknown> | null;
};

export type PaginatedWikiData<T> = {
    data: T[];
    current_page: number;
    last_page: number;
    per_page: number;
    from: number | null;
    to: number | null;
    total: number;
};

export type WikiPaginationHref = NonNullable<InertiaLinkProps['href']>;
