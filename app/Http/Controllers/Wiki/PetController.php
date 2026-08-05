<?php

namespace App\Http\Controllers\Wiki;

use App\Http\Controllers\Controller;
use App\Http\Requests\Wiki\PetIndexRequest;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetEvolutionIngredient;
use App\Models\PetMutationIngredient;
use App\Models\PetSkillLearnset;
use App\Models\PetTrait;
use App\Models\Skill;
use App\Support\EvolutionRecipeData;
use App\Support\PetStatCalculator;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Pagination\LengthAwarePaginator;
use Illuminate\Support\Collection;
use Illuminate\Support\Str;
use Inertia\Inertia;
use Inertia\Response;
use UnexpectedValueException;

class PetController extends Controller
{
    private const CARD_PREVIEW_LEVEL = 50;

    public function __construct(private PetStatCalculator $petStatCalculator) {}

    /**
     * Display the searchable pet catalog grouped by evolution family.
     */
    public function index(PetIndexRequest $request): Response
    {
        $filters = $request->validated();
        $search = trim((string) ($filters['q'] ?? ''));
        $sort = (string) ($filters['sort'] ?? 'family');
        $gameSlug = $filters['game'] ?? null;

        $allPets = Pet::query()
            ->select(['id', 'game_source_id', 'game_id', 'name', 'learning_group'])
            ->when($gameSlug, fn (Builder $query): Builder => $query->whereHas(
                'gameSource',
                fn (Builder $sourceQuery): Builder => $sourceQuery->where('slug', $gameSlug),
            ))
            ->get()
            ->keyBy('id');
        $evolutions = PetEvolution::query()
            ->select(['from_pet_id', 'to_pet_id'])
            ->orderBy('id')
            ->get();
        $familyMetadata = $this->buildFamilyMetadata($allPets, $evolutions);

        $pets = Pet::query()
            ->select([
                'id',
                'game_source_id',
                'game_id',
                'element_id',
                'combat_element',
                'species',
                'species_trait_id',
                'name',
                'slug',
                'sprite_id',
                'learning_group',
                'quality_tier',
                'classification',
                'hp_base',
                'hp_per_level',
                'hp_offset',
                'stat_2_base',
                'stat_2_per_level',
                'stat_2_offset',
                'stat_3_base',
                'stat_3_per_10_levels',
                'stat_3_offset',
                'stat_4_base',
                'stat_4_per_10_levels',
                'stat_4_offset',
            ])
            ->with([
                'gameSource:id,name,slug,asset_key,color',
                'speciesTrait:id,code,name,slot_type,species,polarity,description,parameters,roll_weight,is_cleanse_eligible',
            ])
            ->withCount(['evolutions', 'previousEvolutions'])
            ->when($gameSlug, fn (Builder $query): Builder => $query->whereHas(
                'gameSource',
                fn (Builder $sourceQuery): Builder => $sourceQuery->where('slug', $gameSlug),
            ))
            ->when($search !== '', function (Builder $query) use ($search): void {
                if (ctype_digit($search)) {
                    $query->where('game_id', (int) $search);

                    return;
                }

                $query->where(function (Builder $searchQuery) use ($search): void {
                    $searchQuery->where('name', 'like', "%{$search}%")
                        ->orWhere('slug', 'like', "%{$search}%");
                });
            })
            ->when(isset($filters['element']), function (Builder $query) use ($filters): void {
                $query->where('combat_element', $filters['element']);
            })
            ->when(isset($filters['species']), fn (Builder $query): Builder => $query->where(
                'species',
                $filters['species'],
            ))
            ->when(isset($filters['learning_group']), fn (Builder $query): Builder => $query->where(
                'learning_group',
                (int) $filters['learning_group'],
            ))
            ->when(($filters['evolution'] ?? null) === 'has', function (Builder $query): void {
                $query->where(function (Builder $evolutionQuery): void {
                    $evolutionQuery->has('evolutions')->orHas('previousEvolutions');
                });
            })
            ->when(($filters['evolution'] ?? null) === 'none', function (Builder $query): void {
                $query->doesntHave('evolutions')->doesntHave('previousEvolutions');
            })
            ->get()
            ->map(function (Pet $pet) use ($familyMetadata): array {
                $metadata = $familyMetadata[$pet->id];

                return [
                    'id' => $pet->id,
                    'game_source' => [
                        'name' => $pet->gameSource->name,
                        'slug' => $pet->gameSource->slug,
                        'asset_key' => $pet->gameSource->asset_key,
                        'color' => $pet->gameSource->color,
                    ],
                    'game_id' => $pet->game_id,
                    'name' => $pet->name,
                    'slug' => $pet->slug,
                    'sprite_id' => $pet->sprite_id,
                    'learning_group' => $pet->learning_group,
                    'quality_tier' => $pet->quality_tier,
                    'classification' => $pet->classification,
                    'preview_level' => self::CARD_PREVIEW_LEVEL,
                    'preview_star' => PetStatCalculator::DEFAULT_STAR,
                    'preview_stats' => $this->petStatCalculator->calculate($pet, self::CARD_PREVIEW_LEVEL),
                    'belongs_to_evolution_family' => $metadata['family_size'] > 1,
                    'can_evolve' => $pet->evolutions_count > 0,
                    'is_final_stage' => $pet->previous_evolutions_count > 0 && $pet->evolutions_count === 0,
                    'evolution_stage' => $metadata['stage'] + 1,
                    'evolution_family_size' => $metadata['family_size'],
                    'family_root_game_id' => $metadata['root_game_id'],
                    'family_root_name' => $metadata['root_name'],
                    'family_root_learning_group' => $metadata['root_learning_group'],
                    'combat_element' => $this->combatElement($pet),
                    'species' => $this->species($pet),
                    'species_trait' => $this->trait($pet->speciesTrait),
                    'provenance' => $this->petProvenance(),
                ];
            })
            ->sort(function (array $left, array $right) use ($sort): int {
                $sourceComparison = $left['game_source']['slug'] <=> $right['game_source']['slug'];
                if ($sourceComparison !== 0) {
                    return $sourceComparison;
                }

                $familyComparison = match ($sort) {
                    'name' => strnatcasecmp($left['family_root_name'], $right['family_root_name']),
                    'learning_group' => $left['family_root_learning_group'] <=> $right['family_root_learning_group'],
                    default => $left['family_root_game_id'] <=> $right['family_root_game_id'],
                };

                if ($familyComparison !== 0) {
                    return $familyComparison;
                }

                return [$left['family_root_game_id'], $left['evolution_stage'], $left['game_id']]
                    <=> [$right['family_root_game_id'], $right['evolution_stage'], $right['game_id']];
            })
            ->values();

        $page = LengthAwarePaginator::resolveCurrentPage();
        $perPage = 24;
        $paginator = new LengthAwarePaginator(
            $pets->forPage($page, $perPage)->values(),
            $pets->count(),
            $perPage,
            $page,
            ['path' => $request->url(), 'query' => $request->query()],
        );

        return Inertia::render('wiki/pets/index', [
            'pets' => $paginator,
            'elements' => collect(Pet::COMBAT_ELEMENTS)
                ->map(fn (array $element, string $slug): array => ['slug' => $slug, ...$element])
                ->values(),
            'species' => collect(Pet::SPECIES)
                ->map(fn (array $species, string $slug): array => ['slug' => $slug, ...$species])
                ->values(),
            'filters' => [
                'q' => $search,
                'element' => $filters['element'] ?? null,
                'species' => $filters['species'] ?? null,
                'learning_group' => isset($filters['learning_group']) ? (int) $filters['learning_group'] : null,
                'evolution' => $filters['evolution'] ?? null,
                'sort' => $sort,
            ],
        ]);
    }

    /**
     * Display a complete pet profile with statistics, skills, and evolution family.
     */
    public function show(Pet $pet): Response
    {
        $pet->load([
            'gameSource:id,name,slug,asset_key,color',
            'speciesTrait:id,code,name,slot_type,species,polarity,description,parameters,roll_weight,is_cleanse_eligible',
            'divineAbility:id,pet_id,code,name,activation_type,description,parameters,is_active',
            'mutationRecipe:id,pet_id,status,notes',
            'mutationRecipe.ingredients:id,pet_mutation_recipe_id,item_id,quantity,role,position',
            'mutationRecipe.ingredients.item:id,game_source_id,source_table,game_id,name,slug,frame_id',
            'mutationRecipe.ingredients.item.gameSource:id,name,slug,asset_key,color',
        ]);

        $allPets = Pet::query()
            ->select([
                'id',
                'game_source_id',
                'game_id',
                'name',
                'slug',
                'sprite_id',
                'learning_group',
                'quality_tier',
                'combat_element',
                'species',
                'primary_role',
                'secondary_role',
                'hp_base',
                'hp_per_level',
                'hp_offset',
                'stat_2_base',
                'stat_2_per_level',
                'stat_2_offset',
                'stat_3_base',
                'stat_3_per_10_levels',
                'stat_3_offset',
                'stat_4_base',
                'stat_4_per_10_levels',
                'stat_4_offset',
            ])
            ->where('game_source_id', $pet->game_source_id)
            ->get()
            ->keyBy('id');
        $evolutions = PetEvolution::query()
            ->select(['id', 'from_pet_id', 'to_pet_id', 'item_id', 'quantity', 'required_level', 'materials', 'evolution_type', 'cost_rank', 'balance_notes'])
            ->whereHas('sourcePet', fn (Builder $query): Builder => $query->where('game_source_id', $pet->game_source_id))
            ->with([
                'item:id,game_source_id,source_table,game_id,name,slug,frame_id',
                'item.gameSource:id,name,slug,asset_key,color',
                'ingredients:id,pet_evolution_id,item_id,quantity,role,position',
                'ingredients.item:id,game_source_id,source_table,game_id,name,slug,frame_id',
                'ingredients.item.gameSource:id,name,slug,asset_key,color',
            ])
            ->orderBy('id')
            ->get();
        $familyMetadata = $this->buildFamilyMetadata($allPets, $evolutions);
        $currentMetadata = $familyMetadata[$pet->id];
        $familyPets = $allPets
            ->filter(fn (Pet $candidate): bool => $familyMetadata[$candidate->id]['root_id'] === $currentMetadata['root_id'])
            ->sortBy(fn (Pet $candidate): array => [$familyMetadata[$candidate->id]['stage'], $candidate->game_id])
            ->values();
        $familyPetIds = $familyPets->pluck('id');
        $familyEvolutions = $evolutions
            ->filter(fn (PetEvolution $evolution): bool => $familyPetIds->contains($evolution->from_pet_id))
            ->values();
        $incomingPetIds = $familyEvolutions->groupBy('to_pet_id')->map->pluck('from_pet_id');
        $outgoingPetIds = $familyEvolutions->groupBy('from_pet_id')->map->pluck('to_pet_id');
        $currentPathIds = $this->ancestorPetIds($pet->id, $incomingPetIds);
        $futurePathIds = $this->descendantPetIds($pet->id, $outgoingPetIds);
        $learnsetPetIds = $pet->gameSource->slug === 'vqsv4'
            ? collect([$pet->id])
            : $familyPetIds;
        $skills = PetSkillLearnset::query()
            ->whereIn('pet_id', $learnsetPetIds)
            ->with([
                'pet:id,game_id,name,slug,sprite_id',
                'skill:id,game_source_id,game_id,effect_id,name,slug,description,power_percent,tier,max_uses,status_chance,combat_element,species_affinity,combat_category,target_pattern,effect_target_pattern,battle_format',
                'skill.gameSource:id,name,slug,asset_key,color',
                'skill.effect:id,game_source_id,source_table,game_id,name,kind,duration',
            ])
            ->get()
            ->sortBy(fn (PetSkillLearnset $entry): array => [
                $familyMetadata[$entry->pet_id]['stage'],
                $entry->sort_order,
                $entry->unlock_level,
            ])
            ->map(function (PetSkillLearnset $entry) use ($currentPathIds, $futurePathIds, $familyMetadata): array {
                $skill = $entry->skill;
                $skillElement = $skill->combat_element === null
                    ? null
                    : Pet::COMBAT_ELEMENTS[$skill->combat_element];

                return [
                    'id' => $skill->id,
                    'game_source' => [
                        'name' => $skill->gameSource->name,
                        'slug' => $skill->gameSource->slug,
                        'asset_key' => $skill->gameSource->asset_key,
                        'color' => $skill->gameSource->color,
                    ],
                    'game_id' => $skill->game_id,
                    'name' => $skill->name,
                    'slug' => $skill->slug,
                    'description' => $skill->description,
                    'power_percent' => $skill->power_percent,
                    'tier' => $skill->tier,
                    'max_uses' => $skill->max_uses,
                    'status_chance' => $skill->status_chance,
                    'unlock_level' => $entry->unlock_level,
                    'source_type' => $entry->source_type,
                    'combat_category' => $skill->combat_category,
                    'combat_category_label' => Skill::COMBAT_CATEGORIES[$skill->combat_category],
                    'target_pattern' => $skill->target_pattern,
                    'target_label' => Skill::TARGET_PATTERNS[$skill->target_pattern],
                    'battle_format' => $skill->battle_format,
                    'is_signature' => $entry->is_signature,
                    'is_available_on_current_form' => $currentPathIds->contains($entry->pet_id),
                    'is_evolution_locked' => $futurePathIds->contains($entry->pet_id),
                    'is_alternate_branch' => ! $currentPathIds->contains($entry->pet_id)
                        && ! $futurePathIds->contains($entry->pet_id),
                    'grant_pet' => [
                        'id' => $entry->pet->id,
                        'game_id' => $entry->pet->game_id,
                        'name' => $entry->pet->name,
                        'slug' => $entry->pet->slug,
                        'sprite_id' => $entry->pet->sprite_id,
                        'stage' => $familyMetadata[$entry->pet_id]['stage'] + 1,
                    ],
                    'element' => $skillElement === null ? null : [
                        'game_id' => $skillElement['game_id'],
                        'name' => $skillElement['name'],
                        'slug' => $skill->combat_element,
                        'color' => $skillElement['color'],
                    ],
                    'species_affinity' => $skill->species_affinity === null ? null : [
                        'name' => Pet::SPECIES[$skill->species_affinity]['name'],
                        'slug' => $skill->species_affinity,
                        'color' => Pet::SPECIES[$skill->species_affinity]['color'],
                    ],
                    'effect' => $skill->effect === null ? null : [
                        'source_table' => $skill->effect->source_table,
                        'game_id' => $skill->effect->game_id,
                        'name' => $skill->effect->name,
                        'kind' => $skill->effect->kind,
                        'duration' => $skill->effect->duration,
                    ],
                ];
            })
            ->values();
        $statBenchmarks = $this->statBenchmarks();
        $description = Str::of((string) $pet->description)->trim();
        $hasCombatNote = $description->contains('[') && $description->contains(']');
        $divineAbility = $pet->divineAbility?->is_active === true
            ? $pet->divineAbility
            : null;
        $isDivine = $pet->classification === 'divine' || $divineAbility !== null;

        return Inertia::render('wiki/pets/show', [
            'pet' => [
                'id' => $pet->id,
                'game_source' => [
                    'name' => $pet->gameSource->name,
                    'slug' => $pet->gameSource->slug,
                    'asset_key' => $pet->gameSource->asset_key,
                    'color' => $pet->gameSource->color,
                ],
                'game_id' => $pet->game_id,
                'name' => $pet->name,
                'name_original' => $pet->name_original,
                'slug' => $pet->slug,
                'sprite_id' => $pet->sprite_id,
                'variant_code' => $pet->variant_code,
                'quality_tier' => $pet->quality_tier,
                'classification' => $pet->classification,
                'rarity_or_growth_code' => $pet->rarity_or_growth_code,
                'learning_group' => $pet->learning_group,
                'effectiveness_class' => $pet->effectiveness_class,
                'primary_role' => $pet->primary_role,
                'primary_role_label' => Pet::COMBAT_ROLES[$pet->primary_role],
                'secondary_role' => $pet->secondary_role,
                'secondary_role_label' => Pet::COMBAT_ROLES[$pet->secondary_role],
                'preferred_battle_format' => $pet->preferred_battle_format,
                'playstyle_summary' => $pet->playstyle_summary,
                'power_class' => $isDivine ? 'divine' : 'standard',
                'divine_ability' => $divineAbility === null ? null : [
                    'code' => $divineAbility->code,
                    'name' => $divineAbility->name,
                    'activation_type' => $divineAbility->activation_type,
                    'activation_type_label' => $this->divineActivationTypeLabel($divineAbility->activation_type),
                    'description' => $divineAbility->description,
                    'parameters' => $divineAbility->parameters,
                ],
                'equipped_skill_limit' => 5,
                'raw_values' => $pet->raw_values,
                'description' => $pet->description,
                'lore' => $hasCombatNote
                    ? $description->beforeLast('[')->trim()->toString()
                    : $description->toString(),
                'combat_note' => $hasCombatNote
                    ? $description->between('[', ']')->trim()->ucfirst()->toString()
                    : null,
                'acquisition' => [
                    'code' => $pet->acquisition_code,
                    'method' => in_array($pet->gameSource->slug, ['cau-vong', 'vqsv4'], true)
                        ? $this->acquisitionMethod($pet->acquisition_code)
                        : null,
                    'locations' => $pet->discovery_locations ?? [],
                ],
                'default_star' => PetStatCalculator::DEFAULT_STAR,
                'star_multipliers' => PetStatCalculator::STAR_MULTIPLIERS,
                'stats' => $this->statFormulas($pet),
                'stat_benchmarks' => $statBenchmarks,
                'population_count' => Pet::query()->count(),
                'evolution_stage' => $currentMetadata['stage'] + 1,
                'evolution_stage_count' => $familyPets->max(fn (Pet $candidate): int => $familyMetadata[$candidate->id]['stage']) + 1,
                'belongs_to_evolution_family' => $familyPets->count() > 1,
                'can_evolve' => $familyEvolutions->contains('from_pet_id', $pet->id),
                'is_final_stage' => $familyEvolutions->contains('to_pet_id', $pet->id)
                    && ! $familyEvolutions->contains('from_pet_id', $pet->id),
                'combat_element' => $this->combatElement($pet),
                'species' => $this->species($pet),
                'species_trait' => $this->trait($pet->speciesTrait),
                'mutation_recipe' => $pet->mutationRecipe === null ? null : [
                    'status' => $pet->mutationRecipe->status,
                    'notes' => $pet->mutationRecipe->notes,
                    'ingredients' => $pet->mutationRecipe->ingredients
                        ->map(fn (PetMutationIngredient $ingredient): array => $this->mutationIngredient($ingredient))
                        ->values(),
                ],
                'skills' => $skills,
                'provenance' => $this->petProvenance(),
                'evolution_family' => [
                    'pets' => $familyPets->map(fn (Pet $familyPet): array => [
                        'id' => $familyPet->id,
                        'game_id' => $familyPet->game_id,
                        'name' => $familyPet->name,
                        'slug' => $familyPet->slug,
                        'sprite_id' => $familyPet->sprite_id,
                        'quality_tier' => $familyPet->quality_tier,
                        'combat_element' => $this->combatElement($familyPet),
                        'species' => $this->species($familyPet),
                        'primary_role' => $familyPet->primary_role,
                        'primary_role_label' => Pet::COMBAT_ROLES[$familyPet->primary_role],
                        'secondary_role' => $familyPet->secondary_role,
                        'secondary_role_label' => Pet::COMBAT_ROLES[$familyPet->secondary_role],
                        'stats' => $this->statFormulas($familyPet),
                        'stage' => $familyMetadata[$familyPet->id]['stage'] + 1,
                        'is_current' => $familyPet->is($pet),
                    ])->values(),
                    'transitions' => $familyEvolutions->map(fn (PetEvolution $evolution): array => [
                        'from_pet_id' => $evolution->from_pet_id,
                        'to_pet_id' => $evolution->to_pet_id,
                        'type' => $evolution->evolution_type,
                        'quantity' => $evolution->quantity,
                        'required_level' => $evolution->required_level,
                        'materials' => $evolution->materials,
                        'cost_rank' => $evolution->cost_rank,
                        'cost_rank_label' => EvolutionRecipeData::RANK_LABELS[$evolution->cost_rank],
                        'balance_notes' => $evolution->balance_notes,
                        'ingredients' => $evolution->ingredients
                            ->map(fn (PetEvolutionIngredient $ingredient): array => $this->evolutionIngredient($ingredient))
                            ->values(),
                        'item' => [
                            'id' => $evolution->item->id,
                            'game_source' => [
                                'name' => $evolution->item->gameSource->name,
                                'slug' => $evolution->item->gameSource->slug,
                                'asset_key' => $evolution->item->gameSource->asset_key,
                                'color' => $evolution->item->gameSource->color,
                            ],
                            'source_table' => $evolution->item->source_table,
                            'game_id' => $evolution->item->game_id,
                            'name' => $evolution->item->name,
                            'slug' => $evolution->item->slug,
                            'frame_id' => $evolution->item->frame_id,
                        ],
                    ])->values(),
                ],
            ],
            'trait_system' => $this->physicalTraitSystem(),
        ]);
    }

    /**
     * Convert an internal Divine Authority trigger into a player-facing label.
     */
    private function divineActivationTypeLabel(string $activationType): string
    {
        return match ($activationType) {
            'revival' => 'Hồi sinh khi chịu đòn chí tử',
            'charge_cycle' => 'Tích tầng qua chu kỳ Skill',
            'guard_counter' => 'Phòng thủ và phản công',
            'heavy_hit_response' => 'Phản ứng khi chịu đòn nặng',
            'mark_detonation' => 'Đặt và kích nổ dấu ấn',
            'hp_threshold' => 'Kích hoạt theo ngưỡng HP',
            'successful_control' => 'Kích hoạt khi khống chế thành công',
            'debuff_mastery' => 'Cường hóa mục tiêu chịu debuff',
            'execution' => 'Kết liễu mục tiêu suy yếu',
            'attack_cycle' => 'Kích hoạt theo chu kỳ tấn công',
            'failed_control' => 'Bù đắp khi khống chế thất bại',
            'speed_charge' => 'Tích tầng khi ra đòn trước',
            'support_cycle' => 'Chu kỳ Skill hỗ trợ',
            default => 'Năng lực đặc trưng',
        };
    }

    /** @return array<string, mixed> */
    private function evolutionIngredient(PetEvolutionIngredient $ingredient): array
    {
        return [
            'quantity' => $ingredient->quantity,
            'role' => $ingredient->role,
            'role_label' => match ($ingredient->role) {
                PetEvolutionIngredient::ROLE_CORE => 'Lõi tiến hóa',
                PetEvolutionIngredient::ROLE_SPECIES => 'Nguyên liệu Chủng',
                PetEvolutionIngredient::ROLE_SIGNATURE => 'Xúc tác đặc trưng',
                PetEvolutionIngredient::ROLE_SPECIES_PRIMARY => 'Nguyên liệu Chủng chính',
                PetEvolutionIngredient::ROLE_SPECIES_SECONDARY => 'Nguyên liệu Chủng phụ',
                PetEvolutionIngredient::ROLE_ELEMENT_CATALYST => 'Xúc tác Hệ',
                PetEvolutionIngredient::ROLE_SPECIES_CATALYST => 'Xúc tác Chủng',
            },
            'item' => [
                'id' => $ingredient->item->id,
                'game_source' => [
                    'name' => $ingredient->item->gameSource->name,
                    'slug' => $ingredient->item->gameSource->slug,
                    'asset_key' => $ingredient->item->gameSource->asset_key,
                    'color' => $ingredient->item->gameSource->color,
                ],
                'source_table' => $ingredient->item->source_table,
                'game_id' => $ingredient->item->game_id,
                'name' => $ingredient->item->name,
                'slug' => $ingredient->item->slug,
                'frame_id' => $ingredient->item->frame_id,
            ],
        ];
    }

    /** @return array<string, mixed> */
    private function mutationIngredient(PetMutationIngredient $ingredient): array
    {
        return [
            'quantity' => $ingredient->quantity,
            'role' => $ingredient->role,
            'role_label' => match ($ingredient->role) {
                PetMutationIngredient::ROLE_CORE => 'Lõi dị hóa',
                PetMutationIngredient::ROLE_ELEMENT_CATALYST => 'Xúc tác Hệ',
                PetMutationIngredient::ROLE_SPECIES_CATALYST => 'Xúc tác Chủng',
            },
            'item' => [
                'id' => $ingredient->item->id,
                'game_source' => [
                    'name' => $ingredient->item->gameSource->name,
                    'slug' => $ingredient->item->gameSource->slug,
                    'asset_key' => $ingredient->item->gameSource->asset_key,
                    'color' => $ingredient->item->gameSource->color,
                ],
                'source_table' => $ingredient->item->source_table,
                'game_id' => $ingredient->item->game_id,
                'name' => $ingredient->item->name,
                'slug' => $ingredient->item->slug,
                'frame_id' => $ingredient->item->frame_id,
            ],
        ];
    }

    /**
     * Resolve the acquisition label used by the original Rainbow game dossier.
     */
    private function acquisitionMethod(?int $code): string
    {
        return match ($code) {
            -1 => 'Nhiệm vụ',
            -2 => 'Tiến hóa',
            -3 => 'Dị hóa',
            -4 => 'Đấu trường',
            -5 => 'Ấp trứng',
            default => 'Tóm được',
        };
    }

    /** @return array{game_id: int, name: string, slug: string, color: string} */
    private function combatElement(Pet $pet): array
    {
        $slug = $pet->combat_element;

        if ($slug === null || ! array_key_exists($slug, Pet::COMBAT_ELEMENTS)) {
            throw new UnexpectedValueException("Pet {$pet->id} has no valid combat element.");
        }

        $element = Pet::COMBAT_ELEMENTS[$slug];

        return [
            'game_id' => $element['game_id'],
            'name' => $element['name'],
            'slug' => $slug,
            'color' => $element['color'],
        ];
    }

    /** @return array{name: string, slug: string, color: string} */
    private function species(Pet $pet): array
    {
        $slug = $pet->species;

        if ($slug === null || ! array_key_exists($slug, Pet::SPECIES)) {
            throw new UnexpectedValueException("Pet {$pet->id} has no valid species.");
        }

        $species = Pet::SPECIES[$slug];

        return [
            'name' => $species['name'],
            'slug' => $slug,
            'color' => $species['color'],
        ];
    }

    /**
     * @return array{code: string, name: string, slot_type: string, species: string|null, polarity: string, description: string, parameters: array<string, mixed>|null, roll_weight: int, is_cleanse_eligible: bool}
     */
    private function trait(?PetTrait $trait): array
    {
        if ($trait === null) {
            throw new UnexpectedValueException('Pet has no assigned species trait.');
        }

        return [
            'code' => $trait->code,
            'name' => $trait->name,
            'slot_type' => $trait->slot_type,
            'species' => $trait->species,
            'polarity' => $trait->polarity,
            'description' => $trait->description,
            'parameters' => $trait->parameters,
            'roll_weight' => $trait->roll_weight,
            'is_cleanse_eligible' => $trait->is_cleanse_eligible,
        ];
    }

    /**
     * Describe which pet fields came from decoded files and which belong to the unified ruleset.
     *
     * @return array{identity: string, taxonomy: string, combat_profile: string, learnset: string}
     */
    private function petProvenance(): array
    {
        return [
            'identity' => 'decoded',
            'taxonomy' => 'unified',
            'combat_profile' => 'calculated',
            'learnset' => 'unified',
        ];
    }

    /**
     * @return array{physical_traits: list<array<string, mixed>>}
     */
    private function physicalTraitSystem(): array
    {
        $traits = PetTrait::query()
            ->physical()
            ->active()
            ->select([
                'id',
                'code',
                'name',
                'slot_type',
                'species',
                'polarity',
                'description',
                'parameters',
                'roll_weight',
                'is_cleanse_eligible',
            ])
            ->orderBy('code')
            ->get();
        if ($traits->count() !== 19 || $traits->pluck('roll_weight')->unique()->count() !== 1) {
            throw new UnexpectedValueException('The physical trait pool must contain 19 equally weighted traits.');
        }

        return [
            'physical_traits' => $traits
                ->map(fn (PetTrait $trait): array => $this->trait($trait))
                ->values()
                ->all(),
        ];
    }

    /**
     * Build the four unified stat formulas used by the dossier and form comparison.
     *
     * @return array{hp: array{base: int, per_level: int, offset: int, per_ten_levels: bool}, energy: null, strength: array{base: int, per_level: int, offset: int, per_ten_levels: bool}, defense: array{base: int, per_level: int, offset: int, per_ten_levels: bool}, agility: array{base: int, per_level: int, offset: int, per_ten_levels: bool}}
     */
    private function statFormulas(Pet $pet): array
    {
        return [
            'hp' => ['base' => $pet->hp_base, 'per_level' => $pet->hp_per_level, 'offset' => $pet->hp_offset, 'per_ten_levels' => false],
            'energy' => null,
            'strength' => ['base' => $pet->stat_2_base, 'per_level' => $pet->stat_2_per_level, 'offset' => $pet->stat_2_offset, 'per_ten_levels' => false],
            'defense' => ['base' => $pet->stat_3_base, 'per_level' => $pet->stat_3_per_10_levels, 'offset' => $pet->stat_3_offset, 'per_ten_levels' => true],
            'agility' => ['base' => $pet->stat_4_base, 'per_level' => $pet->stat_4_per_10_levels, 'offset' => $pet->stat_4_offset, 'per_ten_levels' => true],
        ];
    }

    /**
     * Calculate the unified all-Pet average used as the radar-chart benchmark.
     *
     * @return array{level_one: array{hp: int, strength: int, defense: int, agility: int}, level_fifty: array{hp: int, strength: int, defense: int, agility: int}}
     */
    private function statBenchmarks(): array
    {
        $pets = Pet::query()
            ->select([
                'hp_base',
                'hp_per_level',
                'hp_offset',
                'stat_2_base',
                'stat_2_per_level',
                'stat_2_offset',
                'stat_3_base',
                'stat_3_per_10_levels',
                'stat_3_offset',
                'stat_4_base',
                'stat_4_per_10_levels',
                'stat_4_offset',
            ])
            ->get();

        return collect(['level_one' => 1, 'level_fifty' => 50])
            ->map(function (int $level) use ($pets): array {
                $calculatedStats = $pets->map(
                    fn (Pet $pet): array => $this->petStatCalculator->calculate($pet, $level),
                );

                return [
                    'hp' => (int) round($calculatedStats->avg('hp')),
                    'strength' => (int) round($calculatedStats->avg('strength')),
                    'defense' => (int) round($calculatedStats->avg('defense')),
                    'agility' => (int) round($calculatedStats->avg('agility')),
                ];
            })
            ->all();
    }

    /**
     * Build stable family roots and stages for every pet in the catalog.
     *
     * @param  Collection<int, Pet>  $pets
     * @param  Collection<int, PetEvolution>  $evolutions
     * @return array<int, array{root_id: int, root_game_id: int, root_name: string, root_learning_group: int, stage: int, family_size: int}>
     */
    private function buildFamilyMetadata(Collection $pets, Collection $evolutions): array
    {
        $previousPetIds = $evolutions
            ->sortBy('from_pet_id')
            ->groupBy('to_pet_id')
            ->map(fn (Collection $paths): int => (int) $paths->first()->from_pet_id);
        $rootAndStage = [];

        foreach ($pets as $pet) {
            $currentPetId = (int) $pet->id;
            $stage = 0;
            $visited = [];

            while ($previousPetIds->has($currentPetId) && ! isset($visited[$currentPetId])) {
                $visited[$currentPetId] = true;
                $currentPetId = (int) $previousPetIds->get($currentPetId);
                $stage++;
            }

            $rootAndStage[$pet->id] = ['root_id' => $currentPetId, 'stage' => $stage];
        }

        $familySizes = collect($rootAndStage)->countBy('root_id');

        return collect($rootAndStage)->mapWithKeys(function (array $metadata, int $petId) use ($pets, $familySizes): array {
            $rootPet = $pets->get($metadata['root_id']);

            return [$petId => [
                ...$metadata,
                'root_game_id' => (int) $rootPet->game_id,
                'root_name' => (string) $rootPet->name,
                'root_learning_group' => (int) $rootPet->learning_group,
                'family_size' => (int) $familySizes->get($metadata['root_id'], 1),
            ]];
        })->all();
    }

    /**
     * Resolve the current form and every ancestor on its active evolution branch.
     *
     * @param  Collection<int, Collection<int, int>>  $incomingPetIds
     * @return Collection<int, int>
     */
    private function ancestorPetIds(int $petId, Collection $incomingPetIds): Collection
    {
        $petIds = collect();
        $currentPetId = $petId;

        while (! $petIds->contains($currentPetId)) {
            $petIds->push($currentPetId);

            if (! $incomingPetIds->has($currentPetId)) {
                break;
            }

            $currentPetId = (int) $incomingPetIds->get($currentPetId)->first();
        }

        return $petIds;
    }

    /**
     * Resolve every future form reachable from the current form.
     *
     * @param  Collection<int, Collection<int, int>>  $outgoingPetIds
     * @return Collection<int, int>
     */
    private function descendantPetIds(int $petId, Collection $outgoingPetIds): Collection
    {
        $descendantIds = collect();
        $pendingIds = collect([$petId]);

        while ($pendingIds->isNotEmpty()) {
            $currentPetId = (int) $pendingIds->shift();

            foreach ($outgoingPetIds->get($currentPetId, collect()) as $descendantId) {
                if ($descendantIds->contains($descendantId)) {
                    continue;
                }

                $descendantIds->push((int) $descendantId);
                $pendingIds->push((int) $descendantId);
            }
        }

        return $descendantIds;
    }
}
