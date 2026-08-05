import type { InertiaLinkProps } from '@inertiajs/react';

export type WikiGameSource = {
    name: string;
    slug: 'liet-hoa' | 'cau-vong' | string;
    asset_key: string;
    color: string;
};

export type WikiElement = {
    id?: number;
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

export type WikiPetProvenance = {
    identity: 'decoded';
    taxonomy: 'unified';
    combat_profile: 'calculated';
    learnset: 'unified';
};

export type WikiSkillProvenance = {
    identity: 'decoded';
    description: 'decoded' | 'unified';
    combat_rules: 'unified';
    learnset: 'unified';
};

export type WikiPetTraitPolarity =
    'neutral' | 'beneficial' | 'harmful' | 'mixed';

export type WikiPetTrait = {
    code: string;
    name: string;
    slot_type: 'physical' | 'species';
    species: string | null;
    polarity: WikiPetTraitPolarity;
    description: string;
    parameters: Record<string, unknown> | null;
    roll_weight: number;
    is_cleanse_eligible: boolean;
};

export type WikiPetTraitSystem = {
    physical_traits: WikiPetTrait[];
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
    classification: 'normal' | 'divine';
    preview_level: number;
    preview_star: number;
    preview_stats: WikiPetStatValues;
    belongs_to_evolution_family: boolean;
    can_evolve: boolean;
    is_final_stage: boolean;
    evolution_stage: number;
    evolution_family_size: number;
    family_root_game_id: number;
    family_root_name: string;
    combat_element: WikiCombatElement;
    species: WikiSpecies;
    species_trait: WikiPetTrait;
    provenance: WikiPetProvenance;
};

export type WikiPetStatFormula = {
    base: number;
    per_level: number;
    offset: number;
    per_ten_levels: boolean;
};

export type WikiPetStats = {
    hp: WikiPetStatFormula;
    energy: WikiPetStatFormula | null;
    strength: WikiPetStatFormula;
    defense: WikiPetStatFormula;
    agility: WikiPetStatFormula;
};

export type WikiPetSkill = {
    id: number;
    game_source: WikiGameSource;
    game_id: number;
    name: string;
    slug: string;
    description: string;
    power_percent: number;
    tier: number;
    max_uses: number;
    status_chance: number | null;
    unlock_level: number;
    source_type: 'element' | 'species' | 'universal';
    combat_category: string;
    combat_category_label: string;
    target_pattern: string;
    target_label: string;
    battle_format: 'single' | 'double' | 'any';
    is_signature: boolean;
    is_available_on_current_form: boolean;
    is_evolution_locked: boolean;
    is_alternate_branch: boolean;
    grant_pet: Pick<
        WikiEvolutionPet,
        'id' | 'game_id' | 'name' | 'slug' | 'sprite_id' | 'stage'
    >;
    element: WikiCombatElement | null;
    species_affinity: WikiSpecies | null;
    effect: WikiEffect | null;
};

export type WikiEvolutionPet = {
    id: number;
    game_id: number;
    name: string;
    slug: string;
    sprite_id: number;
    quality_tier: number;
    combat_element: WikiCombatElement;
    species: WikiSpecies;
    primary_role: string;
    primary_role_label: string;
    secondary_role: string;
    secondary_role_label: string;
    stats: WikiPetStats;
    stage: number;
    is_current: boolean;
};

export type WikiEvolutionTransition = {
    from_pet_id: number;
    to_pet_id: number;
    type: 'evolution' | 'mutation';
    quantity: number;
    required_level: number | null;
    materials?: { item_game_id: number; quantity: number }[] | null;
    cost_rank: number;
    cost_rank_label: string;
    balance_notes: string | null;
    ingredients: WikiEvolutionIngredient[];
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

export type WikiEvolutionIngredient = {
    quantity: number;
    role:
        | 'core'
        | 'species'
        | 'signature'
        | 'species_primary'
        | 'species_secondary'
        | 'element_catalyst'
        | 'species_catalyst';
    role_label: string;
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

export type WikiMutationIngredient = {
    quantity: number;
    role: 'core' | 'element_catalyst' | 'species_catalyst';
    role_label: string;
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

export type WikiMutationRecipe = {
    status: string;
    notes: string | null;
    ingredients: WikiMutationIngredient[];
};

export type WikiDivineAbility = {
    code: string;
    name: string;
    activation_type: string;
    activation_type_label: string;
    description: string;
    parameters: Record<string, number | string>;
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
    classification: 'normal' | 'divine';
    rarity_or_growth_code: number;
    learning_group: number;
    effectiveness_class: number;
    primary_role: string;
    primary_role_label: string;
    secondary_role: string;
    secondary_role_label: string;
    preferred_battle_format: 'single' | 'double' | 'any';
    playstyle_summary: string;
    power_class: 'standard' | 'divine';
    divine_ability: WikiDivineAbility | null;
    equipped_skill_limit: number;
    raw_values: unknown[] | null;
    description: string | null;
    lore: string;
    combat_note: string | null;
    acquisition: {
        code: number | null;
        method: string | null;
        locations: string[];
    };
    default_star: number;
    star_multipliers: Record<number, number>;
    stats: WikiPetStats;
    stat_benchmarks: {
        level_one: WikiPetStatValues;
        level_fifty: WikiPetStatValues;
    };
    population_count: number;
    evolution_stage: number;
    evolution_stage_count: number;
    belongs_to_evolution_family: boolean;
    can_evolve: boolean;
    is_final_stage: boolean;
    combat_element: WikiCombatElement;
    species: WikiSpecies;
    species_trait: WikiPetTrait;
    mutation_recipe: WikiMutationRecipe | null;
    skills: WikiPetSkill[];
    evolution_family: {
        pets: WikiEvolutionPet[];
        transitions: WikiEvolutionTransition[];
    };
    provenance: WikiPetProvenance;
};

export type WikiPetStatValues = {
    hp: number;
    strength: number;
    defense: number;
    agility: number;
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
    status_chance: number | null;
    effect_mode: number;
    effect_parameter: number | null;
    combat_category: string;
    combat_category_label: string;
    target_pattern: string;
    target_label: string;
    effect_target_pattern: string | null;
    effect_target_label: string | null;
    battle_format: 'single' | 'double' | 'any';
    element: WikiCombatElement;
    species_affinity: WikiSpecies | null;
    effect: WikiEffect | null;
    provenance: WikiSkillProvenance;
};

export type WikiSkillCatalogEntry = WikiSkill & {
    source_types: Array<'element' | 'species' | 'universal'>;
    unlock_levels: number[];
    is_signature: boolean;
    learned_by_count: number;
    compatible_pet_preview: Array<{
        id: number;
        name: string;
        sprite_id: number;
        game_source: WikiGameSource;
    }>;
};

export type WikiSkillUnlockRule = {
    learning_group: number;
    unlock_level: number;
    maximum_skill_tier: number;
};

export type WikiCompatiblePet = {
    id: number;
    game_source: WikiGameSource;
    game_id: number;
    name: string;
    slug: string;
    sprite_id: number;
    primary_role: string;
    primary_role_label: string;
    combat_element: WikiCombatElement;
    species: WikiSpecies;
    unlock_level: number;
    source_type: 'element' | 'species' | 'universal';
    is_signature: boolean;
    is_inherited: boolean;
    grant_pet: Pick<WikiEvolutionPet, 'id' | 'game_id' | 'name' | 'slug'>;
};

export type WikiSkillPoolOrigin = {
    type: 'element' | 'species' | 'universal' | 'signature';
    label: string;
    name: string;
    pet_id: number | null;
};

export type WikiSkillNavigationEntry = {
    id: number;
    name: string;
};

export type WikiSkillLearnsetPet = {
    id: number;
    game_id: number;
    name: string;
    slug: string;
    sprite_id: number;
    stage: number;
    game_source: WikiGameSource;
    combat_element: WikiCombatElement;
    species: WikiSpecies;
    learning_state: 'direct' | 'inherited' | 'unavailable';
    unlock_level: number | null;
    grant_pet: { id: number; name: string } | null;
};

export type WikiSkillLearnsetFamily = {
    root_pet: Omit<
        WikiSkillLearnsetPet,
        'learning_state' | 'unlock_level' | 'grant_pet'
    >;
    pets: WikiSkillLearnsetPet[];
    transitions: Array<{ from_pet_id: number; to_pet_id: number }>;
};

export type WikiSkillSpeciesDistribution = WikiSpecies & {
    count: number;
    percentage: number;
};

export type WikiSkillSynergyEntry = {
    id: number;
    game_id: number;
    name: string;
    description: string;
    power_percent: number;
    tier: number;
    max_uses: number;
    status_chance: number | null;
    combat_category_label: string;
    element: WikiCombatElement;
    effect: Pick<WikiEffect, 'name' | 'kind' | 'duration'> | null;
    game_source: WikiGameSource;
};

export type WikiSkillTeammate = {
    id: number;
    name: string;
    sprite_id: number;
    primary_role_label: string;
    reason: string;
    game_source: WikiGameSource;
};

export type WikiSkillBattleCombatant = {
    id: number;
    name: string;
    sprite_id: number;
    quality_tier: number;
    primary_role_label: string;
    game_source: WikiGameSource;
    combat_element: WikiCombatElement;
    stats: WikiPetStatValues;
    effect_snapshots: Record<
        string,
        {
            url: string;
            origin_x: number;
            origin_y: number;
            width: number;
            height: number;
        }
    >;
    unlock_level?: number;
    is_inherited?: boolean;
};

export type WikiSkillBattleEffectRule = {
    key: string;
    title: string;
    summary: string;
    effect_name?: string;
    target: 'caster' | 'opponent';
    tone: 'beneficial' | 'harmful' | 'neutral';
    duration_turns: number | null;
    status_chance: number | null;
    stat_changes: Array<{
        stat: string;
        direction: 'up' | 'down';
        value: number;
        unit: 'percent';
    }>;
    follow_up: {
        kind: string;
        value: number | null;
        secondary_value: number | null;
        basis: 'percent' | 'points' | 'max_hp' | 'current_hp';
    };
    provenance: 'decoded' | 'unified';
};

export type WikiSkillSourceAnimationEvent = {
    index: number;
    kind: 'sprite_animation' | 'procedural_pet_effect';
    anchor: 'caster' | 'opponent';
    render_status: 'decoded_original' | 'source_metadata';
    url?: string;
    frame_count?: number;
    duration_ms?: number;
    tick_ms?: number;
    frame_durations_ms?: number[];
    timeline_mode?: 'concurrent_caster_action';
    source_controller?: string;
    stage_width?: number;
    stage_height?: number;
    anchor_x?: number;
    anchor_y?: number;
    origin_x?: number;
    origin_y?: number;
    frame_width?: number;
    frame_height?: number;
    global_transform?: number;
    runtime_renderer?: 'a.a.b.canvas.v1';
    snapshot_composition_state?: number;
    texture_url?: string;
    source_skill_id?: number;
    source_action_id?: number;
    source_sprite_id?: number;
    source_animation_id?: number;
    source_effect_id?: number;
    source_effect_type?: number;
    source_parameters?: number[];
    source_row?: number[];
    trigger_frame?: number | null;
    follow_up_frame?: number | null;
    follow_up_action?: number;
};

export type WikiSkillSourceAnimation = {
    provenance:
        | 'decoded_original'
        | 'source_metadata_only'
        | 'source_no_visual'
        | 'unavailable';
    label: string;
    source_timeline?: number[];
    events: WikiSkillSourceAnimationEvent[];
};

export type WikiSkillBattlePreview = {
    ruleset: 'liet-hoa-unified-v1';
    ruleset_label: string;
    level: number;
    default_caster_id: number | null;
    caster_options: WikiSkillBattleCombatant[];
    opponent: WikiSkillBattleCombatant | null;
    effect_rule: WikiSkillBattleEffectRule;
    source_animation: WikiSkillSourceAnimation;
    damage: {
        formula: string;
        element_multiplier: number;
        variance: number;
    };
};

export type WikiSkillDetail = WikiSkill & {
    name_original: string;
    description_original: string;
    raw_values: unknown[] | null;
    combat_category: string;
    combat_category_label: string;
    target_pattern: string;
    target_label: string;
    effect_target_pattern: string | null;
    effect_target_label: string | null;
    battle_format: 'single' | 'double' | 'any';
    species_affinity: WikiSpecies | null;
    is_signature: boolean;
    pool_origin: WikiSkillPoolOrigin;
    navigation: {
        previous: WikiSkillNavigationEntry | null;
        next: WikiSkillNavigationEntry | null;
    };
    learnset_families: WikiSkillLearnsetFamily[];
    species_distribution: WikiSkillSpeciesDistribution[];
    synergies: {
        setup_skills: WikiSkillSynergyEntry[];
        finisher_skills: WikiSkillSynergyEntry[];
        teammate_pets: WikiSkillTeammate[];
        provenance: 'calculated';
    };
    related_skills: WikiSkillSynergyEntry[];
    simulator: {
        formula: string;
        provenance: 'unified_estimate';
        variance: { minimum: number; maximum: number };
        element_multipliers: {
            advantage: number;
            neutral: number;
            disadvantage: number;
        };
    };
    battle_preview: WikiSkillBattlePreview;
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
    mechanic_key: string | null;
    usage_scope: string | null;
    equipment_slot: string | null;
    balance_version: string | null;
    is_active: boolean;
    source_variants_count: number;
    frame_id: number | null;
    cost: number | null;
    currency_code: number | null;
    effect_type: number | null;
    effect_parameters: Record<string, unknown> | null;
};

export type WikiItemEvolutionPet = {
    id: number;
    game_source: WikiGameSource;
    game_id: number;
    name: string;
    slug: string;
    sprite_id: number;
};

export type WikiItemEvolutionUsage = {
    id: number;
    type: 'evolution' | 'mutation';
    quantity: number;
    role:
        | 'core'
        | 'species'
        | 'signature'
        | 'species_primary'
        | 'species_secondary'
        | 'element_catalyst'
        | 'species_catalyst';
    cost_rank: number;
    from_pet: WikiItemEvolutionPet;
    to_pet: WikiItemEvolutionPet;
};

export type WikiItemDetail = WikiItem & {
    name_original: string;
    description_original: string | null;
    raw_values: unknown[] | null;
    canonical_item: Pick<
        WikiItem,
        | 'id'
        | 'game_source'
        | 'source_table'
        | 'game_id'
        | 'name'
        | 'slug'
        | 'frame_id'
        | 'category'
        | 'mechanic_key'
    > | null;
    source_variants: Array<
        Pick<
            WikiItem,
            | 'id'
            | 'game_source'
            | 'source_table'
            | 'game_id'
            | 'name'
            | 'slug'
            | 'frame_id'
        >
    >;
    evolution_usages: WikiItemEvolutionUsage[];
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
