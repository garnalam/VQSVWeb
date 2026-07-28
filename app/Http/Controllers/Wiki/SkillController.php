<?php

namespace App\Http\Controllers\Wiki;

use App\Http\Controllers\Controller;
use App\Http\Requests\Wiki\SkillIndexRequest;
use App\Models\Effect;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetSkillLearnset;
use App\Models\Skill;
use App\Support\SkillBattlePreview;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\Collection as EloquentCollection;
use Illuminate\Support\Collection;
use Illuminate\Support\Str;
use Inertia\Inertia;
use Inertia\Response;

class SkillController extends Controller
{
    /**
     * Display the searchable skill catalog.
     */
    public function index(SkillIndexRequest $request): Response
    {
        $filters = $request->validated();
        $search = trim((string) ($filters['q'] ?? ''));
        $sort = (string) ($filters['sort'] ?? 'id');

        $skills = Skill::query()
            ->select([
                'id',
                'game_source_id',
                'game_id',
                'effect_id',
                'name',
                'slug',
                'description_original',
                'description',
                'combat_element',
                'species_affinity',
                'combat_category',
                'target_pattern',
                'effect_target_pattern',
                'battle_format',
                'power_percent',
                'tier',
                'max_uses',
                'effect_mode',
                'effect_parameter',
                'status_chance',
            ])
            ->with([
                'gameSource:id,name,slug,asset_key,color',
                'effect:id,game_source_id,source_table,game_id,name,kind,duration,description',
                'learnsetEntries:id,pet_id,skill_id,unlock_level,source_type,is_signature',
            ])
            ->where('is_active', true)
            ->when($search !== '', function (Builder $query) use ($search): void {
                $query->where(function (Builder $searchQuery) use ($search): void {
                    $searchQuery->where('name', 'like', "%{$search}%")
                        ->orWhere('description', 'like', "%{$search}%");

                    if (ctype_digit($search)) {
                        $searchQuery->orWhere('id', (int) $search)
                            ->orWhere('game_id', (int) $search);
                    }
                });
            })
            ->when(isset($filters['element']), fn (Builder $query): Builder => $query->where('combat_element', $filters['element']))
            ->when(isset($filters['tier']), fn (Builder $query): Builder => $query->where('tier', (int) $filters['tier']))
            ->when(isset($filters['role']), function (Builder $query) use ($filters): void {
                match ($filters['role']) {
                    'attack' => $query->whereIn('combat_category', ['damage', 'hybrid']),
                    'defense' => $query->where('combat_category', 'defense'),
                    'heal' => $query->where('combat_category', 'heal'),
                    'control' => $query->where('combat_category', 'control'),
                    'disrupt' => $query->where('combat_category', 'disrupt'),
                    'modifier' => $query->where(function (Builder $roleQuery): void {
                        $roleQuery->where('combat_category', 'buff')
                            ->orWhere(function (Builder $debuffQuery): void {
                                $debuffQuery->where('power_percent', 0)
                                    ->whereHas('effect', fn (Builder $effectQuery): Builder => $effectQuery->where('kind', 'harmful'));
                            });
                    }),
                    default => null,
                };
            })
            ->when(($filters['effect'] ?? null) === 'none', fn (Builder $query): Builder => $query->whereNull('effect_id'))
            ->when(in_array($filters['effect'] ?? null, ['beneficial', 'harmful'], true), function (Builder $query) use ($filters): void {
                $query->whereHas('effect', fn (Builder $effectQuery): Builder => $effectQuery->where(
                    'kind',
                    (string) $filters['effect'],
                ));
            })
            ->when(isset($filters['target']), fn (Builder $query): Builder => $query->where('target_pattern', $filters['target']))
            ->when(isset($filters['source']), function (Builder $query) use ($filters): void {
                $query->whereHas('learnsetEntries', function (Builder $learnsetQuery) use ($filters): void {
                    if ($filters['source'] === 'signature') {
                        $learnsetQuery->where('is_signature', true);

                        return;
                    }

                    $learnsetQuery->where('source_type', $filters['source']);
                });
            })
            ->when(isset($filters['unlock']), fn (Builder $query): Builder => $query->whereHas(
                'learnsetEntries',
                fn (Builder $learnsetQuery): Builder => $learnsetQuery->where('unlock_level', (int) $filters['unlock']),
            ))
            ->orderBy(match ($sort) {
                'name' => 'name',
                'power' => 'power_percent',
                'tier' => 'tier',
                'popularity' => 'id',
                default => 'id',
            }, $sort === 'power' ? 'desc' : 'asc')
            ->orderBy('id')
            ->paginate(24)
            ->withQueryString();

        $catalogMetadata = $this->catalogMetadata($skills->getCollection());

        $skills->through(fn (Skill $skill): array => [
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
            'combat_category' => $skill->combat_category,
            'combat_category_label' => Skill::COMBAT_CATEGORIES[$skill->combat_category],
            'target_pattern' => $skill->target_pattern,
            'target_label' => Skill::TARGET_PATTERNS[$skill->target_pattern],
            'effect_target_pattern' => $skill->effect_target_pattern,
            'effect_target_label' => $skill->effect_target_pattern === null
                ? null
                : Skill::TARGET_PATTERNS[$skill->effect_target_pattern],
            'battle_format' => $skill->battle_format,
            'power_percent' => $skill->power_percent,
            'tier' => $skill->tier,
            'max_uses' => $skill->max_uses,
            'effect_mode' => $skill->effect_mode,
            'effect_parameter' => $skill->effect_parameter,
            'status_chance' => $this->effectiveStatusChance($skill),
            'element' => $skill->combat_element === null ? [
                'game_id' => -1,
                'name' => 'Kỹ năng chung',
                'slug' => 'ky-nang-chung',
                'color' => '#00e5ff',
            ] : [
                'game_id' => Pet::COMBAT_ELEMENTS[$skill->combat_element]['game_id'],
                'name' => Pet::COMBAT_ELEMENTS[$skill->combat_element]['name'],
                'slug' => $skill->combat_element,
                'color' => Pet::COMBAT_ELEMENTS[$skill->combat_element]['color'],
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
                'description' => $skill->effect->description,
            ],
            'source_types' => $catalogMetadata[$skill->id]['source_types'],
            'unlock_levels' => $catalogMetadata[$skill->id]['unlock_levels'],
            'is_signature' => $catalogMetadata[$skill->id]['is_signature'],
            'learned_by_count' => $catalogMetadata[$skill->id]['learned_by_count'],
            'compatible_pet_preview' => $catalogMetadata[$skill->id]['compatible_pet_preview'],
            'provenance' => $this->skillProvenance($skill),
        ]);

        $catalogStats = Skill::query()
            ->toBase()
            ->selectRaw('count(*) as decoded_total')
            ->selectRaw('sum(case when is_active = 1 then 1 else 0 end) as active_total')
            ->selectRaw('count(distinct case when is_active = 1 then combat_element end) as element_total')
            ->selectRaw('count(distinct case when is_active = 1 then tier end) as tier_total')
            ->selectRaw("sum(case when is_active = 1 and battle_format = 'double' then 1 else 0 end) as double_battle_total")
            ->first();

        return Inertia::render('wiki/skills/index', [
            'skills' => $skills,
            'elements' => collect(Pet::COMBAT_ELEMENTS)
                ->map(fn (array $element, string $slug): array => [
                    'game_id' => $element['game_id'],
                    'name' => $element['name'],
                    'slug' => $slug,
                    'color' => $element['color'],
                ])
                ->values(),
            'catalogStats' => [
                'decoded_total' => (int) $catalogStats->decoded_total,
                'active_total' => (int) $catalogStats->active_total,
                'element_total' => (int) $catalogStats->element_total,
                'tier_total' => (int) $catalogStats->tier_total,
                'double_battle_total' => (int) $catalogStats->double_battle_total,
            ],
            'filters' => [
                'q' => $search,
                'element' => $filters['element'] ?? null,
                'tier' => isset($filters['tier']) ? (int) $filters['tier'] : null,
                'effect' => $filters['effect'] ?? null,
                'target' => $filters['target'] ?? null,
                'source' => $filters['source'] ?? null,
                'role' => $filters['role'] ?? null,
                'unlock' => isset($filters['unlock']) ? (int) $filters['unlock'] : null,
                'sort' => $sort,
            ],
        ]);
    }

    /**
     * Build learnset coverage metadata for the current catalog page.
     *
     * @param  EloquentCollection<int, Skill>  $skills
     * @return array<int, array{
     *     source_types: array<int, string>,
     *     unlock_levels: array<int, int>,
     *     is_signature: bool,
     *     learned_by_count: int,
     *     compatible_pet_preview: array<int, array<string, mixed>>
     * }>
     */
    private function catalogMetadata(EloquentCollection $skills): array
    {
        $pets = Pet::query()
            ->select(['id', 'game_source_id', 'name', 'sprite_id'])
            ->with('gameSource:id,name,slug,asset_key,color')
            ->orderBy('id')
            ->get()
            ->keyBy('id');
        $parentPetIds = PetEvolution::query()
            ->select(['from_pet_id', 'to_pet_id'])
            ->orderBy('id')
            ->get()
            ->groupBy('to_pet_id')
            ->map(fn (EloquentCollection $paths): int => (int) $paths->first()->from_pet_id);
        $ancestorPaths = $pets->mapWithKeys(function (Pet $pet) use ($parentPetIds): array {
            $path = [];
            $visited = [];
            $currentPetId = (int) $pet->id;

            while (! isset($visited[$currentPetId])) {
                $visited[$currentPetId] = true;
                $path[] = $currentPetId;

                if (! $parentPetIds->has($currentPetId)) {
                    break;
                }

                $currentPetId = (int) $parentPetIds->get($currentPetId);
            }

            return [$pet->id => $path];
        });

        return $skills->mapWithKeys(function (Skill $skill) use ($pets, $ancestorPaths): array {
            $grantPetIds = $skill->learnsetEntries
                ->pluck('pet_id')
                ->map(fn (int $petId): int => $petId)
                ->flip();
            $compatiblePets = $pets->filter(function (Pet $pet) use ($ancestorPaths, $grantPetIds): bool {
                return collect($ancestorPaths->get($pet->id, []))
                    ->contains(fn (int $ancestorPetId): bool => $grantPetIds->has($ancestorPetId));
            });

            return [$skill->id => [
                'source_types' => $skill->learnsetEntries->pluck('source_type')->unique()->sort()->values()->all(),
                'unlock_levels' => $skill->learnsetEntries->pluck('unlock_level')->unique()->sort()->values()->all(),
                'is_signature' => $skill->learnsetEntries->contains('is_signature', true),
                'learned_by_count' => $compatiblePets->count(),
                'compatible_pet_preview' => $compatiblePets
                    ->take(6)
                    ->map(fn (Pet $pet): array => [
                        'id' => $pet->id,
                        'name' => $pet->name,
                        'sprite_id' => $pet->sprite_id,
                        'game_source' => [
                            'name' => $pet->gameSource->name,
                            'slug' => $pet->gameSource->slug,
                            'asset_key' => $pet->gameSource->asset_key,
                            'color' => $pet->gameSource->color,
                        ],
                    ])
                    ->values()
                    ->all(),
            ]];
        })->all();
    }

    /**
     * Display a skill dossier with unlock rules and compatible pets.
     */
    public function show(Skill $skill, SkillBattlePreview $battlePreview): Response
    {
        $skill->load([
            'gameSource:id,name,slug,asset_key,color',
            'element:id,game_source_id,game_id,name,slug,color',
            'effect:id,game_source_id,source_table,game_id,name,kind,duration,description,parameters',
            'learnsetEntries:id,pet_id,skill_id,unlock_level,source_type,combat_role,is_signature,sort_order',
        ]);

        $allPets = Pet::query()
            ->select([
                'id',
                'game_source_id',
                'game_id',
                'name',
                'slug',
                'sprite_id',
                'combat_element',
                'species',
                'primary_role',
                'secondary_role',
                'quality_tier',
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
            ->with('gameSource:id,name,slug,asset_key,color')
            ->orderBy('game_source_id')
            ->orderBy('game_id')
            ->get()
            ->keyBy('id');
        $evolutions = PetEvolution::query()
            ->select(['from_pet_id', 'to_pet_id'])
            ->orderBy('id')
            ->get();
        $incomingPetIds = $evolutions
            ->groupBy('to_pet_id')
            ->map->pluck('from_pet_id');
        $grantEntries = $skill->learnsetEntries->keyBy('pet_id');
        $compatiblePets = $allPets
            ->map(function (Pet $pet) use ($grantEntries, $incomingPetIds, $allPets): ?array {
                $currentPetId = (int) $pet->id;
                $visited = [];
                $grantEntry = null;

                while (! isset($visited[$currentPetId])) {
                    $visited[$currentPetId] = true;
                    $grantEntry = $grantEntries->get($currentPetId);

                    if ($grantEntry !== null || ! $incomingPetIds->has($currentPetId)) {
                        break;
                    }

                    $currentPetId = (int) $incomingPetIds->get($currentPetId)->first();
                }

                if ($grantEntry === null) {
                    return null;
                }

                $grantPet = $allPets->get($grantEntry->pet_id);

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
                    'primary_role' => $pet->primary_role,
                    'primary_role_label' => Pet::COMBAT_ROLES[$pet->primary_role],
                    'combat_element' => $this->combatElementData($pet->combat_element),
                    'species' => $this->speciesData($pet->species),
                    'unlock_level' => $grantEntry->unlock_level,
                    'source_type' => $grantEntry->source_type,
                    'is_signature' => $grantEntry->is_signature,
                    'is_inherited' => $grantEntry->pet_id !== $pet->id,
                    'grant_pet' => [
                        'id' => $grantPet->id,
                        'game_id' => $grantPet->game_id,
                        'name' => $grantPet->name,
                        'slug' => $grantPet->slug,
                    ],
                ];
            })
            ->filter()
            ->values();
        $combatElement = $skill->combat_element === null
            ? null
            : Pet::COMBAT_ELEMENTS[$skill->combat_element];
        $activeSkills = Skill::query()
            ->select([
                'id',
                'game_source_id',
                'game_id',
                'effect_id',
                'name',
                'slug',
                'description',
                'combat_element',
                'species_affinity',
                'combat_category',
                'target_pattern',
                'battle_format',
                'power_percent',
                'tier',
                'max_uses',
                'effect_parameter',
                'status_chance',
                'is_active',
            ])
            ->with([
                'gameSource:id,name,slug,asset_key,color',
                'effect:id,name,kind,duration',
            ])
            ->where('is_active', true)
            ->orderBy('id')
            ->get();
        $familyMetadata = $this->skillFamilyMetadata($allPets, $incomingPetIds);

        return Inertia::render('wiki/skills/show', [
            'skill' => [
                'id' => $skill->id,
                'game_source' => [
                    'name' => $skill->gameSource->name,
                    'slug' => $skill->gameSource->slug,
                    'asset_key' => $skill->gameSource->asset_key,
                    'color' => $skill->gameSource->color,
                ],
                'game_id' => $skill->game_id,
                'name' => $skill->name,
                'name_original' => $skill->name_original,
                'slug' => $skill->slug,
                'description' => $skill->description,
                'description_original' => $skill->description_original,
                'power_percent' => $skill->power_percent,
                'tier' => $skill->tier,
                'max_uses' => $skill->max_uses,
                'effect_mode' => $skill->effect_mode,
                'effect_parameter' => $skill->effect_parameter,
                'status_chance' => $this->effectiveStatusChance($skill),
                'combat_category' => $skill->combat_category,
                'combat_category_label' => Skill::COMBAT_CATEGORIES[$skill->combat_category],
                'target_pattern' => $skill->target_pattern,
                'target_label' => Skill::TARGET_PATTERNS[$skill->target_pattern],
                'effect_target_pattern' => $skill->effect_target_pattern,
                'effect_target_label' => $skill->effect_target_pattern === null
                    ? null
                    : Skill::TARGET_PATTERNS[$skill->effect_target_pattern],
                'battle_format' => $skill->battle_format,
                'species_affinity' => $skill->species_affinity === null ? null : [
                    'name' => Pet::SPECIES[$skill->species_affinity]['name'],
                    'slug' => $skill->species_affinity,
                    'color' => Pet::SPECIES[$skill->species_affinity]['color'],
                ],
                'raw_values' => $skill->raw_values,
                'element' => $combatElement === null ? [
                    'game_id' => -1,
                    'name' => 'Kỹ năng chung',
                    'slug' => 'ky-nang-chung',
                    'color' => $skill->gameSource->color,
                ] : [
                    'game_id' => $combatElement['game_id'],
                    'name' => $combatElement['name'],
                    'slug' => $skill->combat_element,
                    'color' => $combatElement['color'],
                ],
                'effect' => $skill->effect === null ? null : [
                    'source_table' => $skill->effect->source_table,
                    'game_id' => $skill->effect->game_id,
                    'name' => $skill->effect->name,
                    'kind' => $skill->effect->kind,
                    'duration' => $skill->effect->duration,
                    'description' => $skill->effect->description,
                ],
                'is_signature' => $skill->learnsetEntries->isNotEmpty()
                    && $skill->learnsetEntries->every('is_signature', true),
                'pool_origin' => $this->poolOrigin($skill, $allPets),
                'navigation' => $this->skillNavigation($skill, $activeSkills),
                'learnset_families' => $this->learnsetFamilies(
                    $allPets,
                    $evolutions,
                    $incomingPetIds,
                    $grantEntries,
                    $familyMetadata,
                    $compatiblePets,
                ),
                'species_distribution' => $this->speciesDistribution($compatiblePets),
                'synergies' => $this->skillSynergies($skill, $activeSkills, $allPets),
                'related_skills' => $this->relatedSkills($skill, $activeSkills),
                'simulator' => [
                    'formula' => 'max(1, (strength - defense) × power × element)',
                    'provenance' => 'unified_estimate',
                    'variance' => ['minimum' => 0.95, 'maximum' => 1.05],
                    'element_multipliers' => [
                        'advantage' => 1.5,
                        'neutral' => 1.0,
                        'disadvantage' => 0.75,
                    ],
                ],
                'battle_preview' => $battlePreview->build(
                    $skill,
                    $compatiblePets,
                    $allPets,
                    $this->effectiveStatusChance($skill),
                ),
                'compatible_pets' => $compatiblePets,
                'provenance' => $this->skillProvenance($skill),
            ],
        ]);
    }

    /**
     * Describe which skill fields came from decoded files and which belong to the unified ruleset.
     *
     * @return array{identity: string, description: string, combat_rules: string, learnset: string}
     */
    private function skillProvenance(Skill $skill): array
    {
        return [
            'identity' => 'decoded',
            'description' => $skill->description === $skill->description_original ? 'decoded' : 'unified',
            'combat_rules' => 'unified',
            'learnset' => 'unified',
        ];
    }

    /** @return array{game_id: int, name: string, slug: string, color: string} */
    private function combatElementData(string $slug): array
    {
        return ['slug' => $slug, ...Pet::COMBAT_ELEMENTS[$slug]];
    }

    /** @return array{name: string, slug: string, color: string} */
    private function speciesData(string $slug): array
    {
        return ['slug' => $slug, ...Pet::SPECIES[$slug]];
    }

    /**
     * @param  EloquentCollection<int, Pet>  $pets
     * @param  Collection<int, Collection<int, int>>  $incomingPetIds
     * @return array<int, array{root_id: int, stage: int}>
     */
    private function skillFamilyMetadata(EloquentCollection $pets, Collection $incomingPetIds): array
    {
        return $pets->mapWithKeys(function (Pet $pet) use ($incomingPetIds): array {
            $currentPetId = (int) $pet->id;
            $stage = 0;
            $visited = [];

            while ($incomingPetIds->has($currentPetId) && ! isset($visited[$currentPetId])) {
                $visited[$currentPetId] = true;
                $currentPetId = (int) $incomingPetIds->get($currentPetId)->first();
                $stage++;
            }

            return [$pet->id => ['root_id' => $currentPetId, 'stage' => $stage]];
        })->all();
    }

    /** @return array{type: string, label: string, name: string, pet_id: int|null} */
    private function poolOrigin(Skill $skill, EloquentCollection $pets): array
    {
        if ($skill->learnsetEntries->isNotEmpty() && $skill->learnsetEntries->every('is_signature', true)) {
            $signaturePet = $pets->get($skill->learnsetEntries->first()->pet_id);

            return [
                'type' => 'signature',
                'label' => 'Độc quyền Form',
                'name' => $signaturePet->name,
                'pet_id' => $signaturePet->id,
            ];
        }

        if ($skill->species_affinity !== null) {
            return [
                'type' => 'species',
                'label' => 'Bể Chủng',
                'name' => Pet::SPECIES[$skill->species_affinity]['name'],
                'pet_id' => null,
            ];
        }

        if ($skill->combat_element !== null) {
            return [
                'type' => 'element',
                'label' => 'Bể Hệ',
                'name' => Pet::COMBAT_ELEMENTS[$skill->combat_element]['name'],
                'pet_id' => null,
            ];
        }

        return ['type' => 'universal', 'label' => 'Bể Phổ thông', 'name' => 'Dùng chung', 'pet_id' => null];
    }

    /**
     * @param  EloquentCollection<int, Skill>  $activeSkills
     * @return array{previous: array{id: int, name: string}|null, next: array{id: int, name: string}|null}
     */
    private function skillNavigation(Skill $skill, EloquentCollection $activeSkills): array
    {
        $samePoolSkills = $activeSkills
            ->filter(function (Skill $candidate) use ($skill): bool {
                if ($skill->species_affinity !== null) {
                    return $candidate->species_affinity === $skill->species_affinity;
                }

                return $candidate->species_affinity === null
                    && $candidate->combat_element === $skill->combat_element;
            })
            ->values();
        $currentIndex = $samePoolSkills->search(fn (Skill $candidate): bool => $candidate->is($skill));

        if ($currentIndex === false) {
            return ['previous' => null, 'next' => null];
        }

        $previous = $currentIndex > 0 ? $samePoolSkills->get($currentIndex - 1) : null;
        $next = $currentIndex < $samePoolSkills->count() - 1 ? $samePoolSkills->get($currentIndex + 1) : null;

        return [
            'previous' => $previous === null ? null : ['id' => $previous->id, 'name' => $previous->name],
            'next' => $next === null ? null : ['id' => $next->id, 'name' => $next->name],
        ];
    }

    /**
     * @param  EloquentCollection<int, Pet>  $pets
     * @param  EloquentCollection<int, PetEvolution>  $evolutions
     * @param  Collection<int, Collection<int, int>>  $incomingPetIds
     * @param  EloquentCollection<int, PetSkillLearnset>  $grantEntries
     * @param  array<int, array{root_id: int, stage: int}>  $familyMetadata
     * @param  Collection<int, array<string, mixed>>  $compatiblePets
     * @return list<array<string, mixed>>
     */
    private function learnsetFamilies(
        EloquentCollection $pets,
        EloquentCollection $evolutions,
        Collection $incomingPetIds,
        EloquentCollection $grantEntries,
        array $familyMetadata,
        Collection $compatiblePets,
    ): array {
        $familyRootIds = $compatiblePets
            ->pluck('id')
            ->map(fn (int $petId): int => $familyMetadata[$petId]['root_id'])
            ->unique()
            ->values();

        return $familyRootIds
            ->map(function (int $rootId) use (
                $pets,
                $evolutions,
                $incomingPetIds,
                $grantEntries,
                $familyMetadata,
            ): array {
                $familyPets = $pets
                    ->filter(fn (Pet $pet): bool => $familyMetadata[$pet->id]['root_id'] === $rootId)
                    ->sortBy(fn (Pet $pet): array => [$familyMetadata[$pet->id]['stage'], $pet->game_id])
                    ->values();
                $familyPetIds = $familyPets->pluck('id');

                return [
                    'root_pet' => $this->learnsetPetData($pets->get($rootId), $familyMetadata[$rootId]['stage']),
                    'pets' => $familyPets->map(function (Pet $pet) use (
                        $incomingPetIds,
                        $grantEntries,
                        $familyMetadata,
                        $pets,
                    ): array {
                        $learning = $this->learningState($pet->id, $grantEntries, $incomingPetIds);
                        $grantPet = $learning['entry'] === null
                            ? null
                            : $pets->get($learning['entry']->pet_id);

                        return [
                            ...$this->learnsetPetData($pet, $familyMetadata[$pet->id]['stage']),
                            'learning_state' => $learning['state'],
                            'unlock_level' => $learning['entry']?->unlock_level,
                            'grant_pet' => $grantPet === null ? null : [
                                'id' => $grantPet->id,
                                'name' => $grantPet->name,
                            ],
                        ];
                    })->all(),
                    'transitions' => $evolutions
                        ->filter(fn (PetEvolution $evolution): bool => $familyPetIds->contains($evolution->from_pet_id)
                            && $familyPetIds->contains($evolution->to_pet_id))
                        ->map(fn (PetEvolution $evolution): array => [
                            'from_pet_id' => $evolution->from_pet_id,
                            'to_pet_id' => $evolution->to_pet_id,
                        ])
                        ->values()
                        ->all(),
                ];
            })
            ->values()
            ->all();
    }

    /**
     * @param  EloquentCollection<int, PetSkillLearnset>  $grantEntries
     * @param  Collection<int, Collection<int, int>>  $incomingPetIds
     * @return array{state: string, entry: PetSkillLearnset|null}
     */
    private function learningState(
        int $petId,
        EloquentCollection $grantEntries,
        Collection $incomingPetIds,
    ): array {
        $currentPetId = $petId;
        $visited = [];

        while (! isset($visited[$currentPetId])) {
            $visited[$currentPetId] = true;
            $grantEntry = $grantEntries->get($currentPetId);

            if ($grantEntry !== null) {
                return [
                    'state' => $currentPetId === $petId ? 'direct' : 'inherited',
                    'entry' => $grantEntry,
                ];
            }

            if (! $incomingPetIds->has($currentPetId)) {
                break;
            }

            $currentPetId = (int) $incomingPetIds->get($currentPetId)->first();
        }

        return ['state' => 'unavailable', 'entry' => null];
    }

    /** @return array<string, mixed> */
    private function learnsetPetData(Pet $pet, int $stage): array
    {
        return [
            'id' => $pet->id,
            'game_id' => $pet->game_id,
            'name' => $pet->name,
            'slug' => $pet->slug,
            'sprite_id' => $pet->sprite_id,
            'stage' => $stage + 1,
            'game_source' => [
                'name' => $pet->gameSource->name,
                'slug' => $pet->gameSource->slug,
                'asset_key' => $pet->gameSource->asset_key,
                'color' => $pet->gameSource->color,
            ],
            'combat_element' => $this->combatElementData($pet->combat_element),
            'species' => $this->speciesData($pet->species),
        ];
    }

    /**
     * @param  Collection<int, array<string, mixed>>  $compatiblePets
     * @return list<array{name: string, slug: string, color: string, count: int, percentage: float}>
     */
    private function speciesDistribution(Collection $compatiblePets): array
    {
        $total = $compatiblePets->count();

        if ($total === 0) {
            return [];
        }

        $distribution = $compatiblePets
            ->countBy('species.slug')
            ->map(function (int $count, string $slug) use ($total): array {
                $species = $this->speciesData($slug);

                return [
                    ...$species,
                    'count' => $count,
                    'percentage' => round($count * 100 / $total, 1),
                ];
            })
            ->sortByDesc('count')
            ->values();
        $roundingDifference = round(100 - $distribution->sum('percentage'), 1);

        if ($roundingDifference !== 0.0 && $distribution->isNotEmpty()) {
            $lastIndex = $distribution->count() - 1;
            $lastEntry = $distribution->get($lastIndex);
            $lastEntry['percentage'] = round($lastEntry['percentage'] + $roundingDifference, 1);
            $distribution->put($lastIndex, $lastEntry);
        }

        return $distribution->all();
    }

    /**
     * @param  EloquentCollection<int, Skill>  $activeSkills
     * @param  EloquentCollection<int, Pet>  $pets
     * @return array{setup_skills: list<array<string, mixed>>, finisher_skills: list<array<string, mixed>>, teammate_pets: list<array<string, mixed>>, provenance: string}
     */
    private function skillSynergies(Skill $skill, EloquentCollection $activeSkills, EloquentCollection $pets): array
    {
        $effects = $activeSkills
            ->pluck('effect')
            ->filter()
            ->unique('id')
            ->values();
        $referencedEffects = $effects->filter(
            fn (Effect $effect): bool => $this->hasConditionalEffectReference(
                $skill->description,
                $effect->name,
            ),
        );
        $setupEffectIds = $referencedEffects->pluck('id');
        $setupSkills = $activeSkills
            ->filter(fn (Skill $candidate): bool => ! $candidate->is($skill)
                && $candidate->effect_id !== null
                && $setupEffectIds->contains($candidate->effect_id))
            ->sortByDesc('status_chance')
            ->take(4)
            ->map(fn (Skill $candidate): array => $this->synergySkillData($candidate))
            ->values();
        $currentEffectName = $skill->effect?->name;
        $finisherSkills = $currentEffectName === null
            ? collect()
            : $activeSkills
                ->filter(fn (Skill $candidate): bool => ! $candidate->is($skill)
                    && $this->hasConditionalEffectReference($candidate->description, $currentEffectName))
                ->sortByDesc('power_percent')
                ->take(4)
                ->map(fn (Skill $candidate): array => $this->synergySkillData($candidate))
                ->values();
        $supportSkillIds = $activeSkills
            ->filter(fn (Skill $candidate): bool => in_array($candidate->target_pattern, ['self_or_ally', 'all_allies'], true)
                || in_array($candidate->combat_category, ['heal', 'defense', 'control', 'disrupt'], true))
            ->pluck('id');
        $supportPetIds = PetSkillLearnset::query()
            ->whereIn('skill_id', $supportSkillIds)
            ->distinct()
            ->pluck('pet_id');
        $teammatePets = $pets
            ->whereIn('id', $supportPetIds)
            ->filter(fn (Pet $pet): bool => in_array($pet->primary_role, ['support', 'guardian', 'controller'], true))
            ->sortBy(fn (Pet $pet): array => [
                array_search($pet->primary_role, ['support', 'guardian', 'controller'], true),
                $pet->game_id,
            ])
            ->take(6)
            ->map(fn (Pet $pet): array => [
                'id' => $pet->id,
                'name' => $pet->name,
                'sprite_id' => $pet->sprite_id,
                'primary_role_label' => Pet::COMBAT_ROLES[$pet->primary_role],
                'reason' => match ($pet->primary_role) {
                    'support' => 'Bổ sung hồi phục, buff hoặc bảo vệ đồng đội.',
                    'guardian' => 'Che chắn và duy trì nhịp triển khai combo.',
                    default => 'Tạo khống chế hoặc gây rối để mở lượt an toàn.',
                },
                'game_source' => [
                    'name' => $pet->gameSource->name,
                    'slug' => $pet->gameSource->slug,
                    'asset_key' => $pet->gameSource->asset_key,
                    'color' => $pet->gameSource->color,
                ],
            ])
            ->values();

        return [
            'setup_skills' => $setupSkills->all(),
            'finisher_skills' => $finisherSkills->all(),
            'teammate_pets' => $teammatePets->all(),
            'provenance' => 'calculated',
        ];
    }

    /** @return array<string, mixed> */
    private function synergySkillData(Skill $skill): array
    {
        return [
            'id' => $skill->id,
            'game_id' => $skill->game_id,
            'name' => $skill->name,
            'description' => $skill->description,
            'power_percent' => $skill->power_percent,
            'tier' => $skill->tier,
            'max_uses' => $skill->max_uses,
            'status_chance' => $this->effectiveStatusChance($skill),
            'combat_category_label' => Skill::COMBAT_CATEGORIES[$skill->combat_category],
            'element' => $skill->combat_element === null
                ? ['game_id' => -1, 'name' => 'Kỹ năng chung', 'slug' => 'ky-nang-chung', 'color' => '#00e5ff']
                : $this->combatElementData($skill->combat_element),
            'effect' => $skill->effect === null ? null : [
                'name' => $skill->effect->name,
                'kind' => $skill->effect->kind,
                'duration' => $skill->effect->duration,
            ],
            'game_source' => [
                'name' => $skill->gameSource->name,
                'slug' => $skill->gameSource->slug,
                'asset_key' => $skill->gameSource->asset_key,
                'color' => $skill->gameSource->color,
            ],
        ];
    }

    private function effectiveStatusChance(Skill $skill): ?int
    {
        if ($skill->status_chance !== null) {
            return $skill->status_chance;
        }

        if ($skill->effect_id === null) {
            return null;
        }

        $effectParameter = $skill->effect_parameter;

        if ($effectParameter !== null
            && $effectParameter > 0
            && $effectParameter <= 100
            && Str::contains($skill->description, $effectParameter.'%')) {
            return $effectParameter;
        }

        return 100;
    }

    private function hasConditionalEffectReference(string $description, string $effectName): bool
    {
        $normalizedDescription = Str::lower($description);

        return Str::contains($normalizedDescription, Str::lower($effectName))
            && Str::contains($normalizedDescription, [
                'nếu ',
                'nếu như ',
                'khi ',
                'đang ',
                'đã ',
                'trong trạng thái ',
            ]);
    }

    /**
     * @param  EloquentCollection<int, Skill>  $activeSkills
     * @return list<array<string, mixed>>
     */
    private function relatedSkills(Skill $skill, EloquentCollection $activeSkills): array
    {
        return $activeSkills
            ->filter(function (Skill $candidate) use ($skill): bool {
                if ($candidate->is($skill)) {
                    return false;
                }

                if ($skill->species_affinity !== null) {
                    return $candidate->species_affinity === $skill->species_affinity;
                }

                return $candidate->species_affinity === null
                    && $candidate->combat_element === $skill->combat_element;
            })
            ->sortBy(fn (Skill $candidate): array => [abs($candidate->tier - $skill->tier), $candidate->id])
            ->take(8)
            ->map(fn (Skill $candidate): array => $this->synergySkillData($candidate))
            ->values()
            ->all();
    }
}
