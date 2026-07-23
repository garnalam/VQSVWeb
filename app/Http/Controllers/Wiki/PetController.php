<?php

namespace App\Http\Controllers\Wiki;

use App\Http\Controllers\Controller;
use App\Http\Requests\Wiki\PetIndexRequest;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\Skill;
use App\Models\SkillUnlockRule;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Pagination\LengthAwarePaginator;
use Illuminate\Support\Collection;
use Illuminate\Support\Str;
use Inertia\Inertia;
use Inertia\Response;
use UnexpectedValueException;

class PetController extends Controller
{
    private const QUALITY_MULTIPLIERS = [1 => 90, 2 => 95, 3 => 100, 4 => 110, 5 => 125];

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
                'name',
                'slug',
                'sprite_id',
                'learning_group',
                'quality_tier',
            ])
            ->with([
                'gameSource:id,name,slug,asset_key,color',
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
        ]);

        $allPets = Pet::query()
            ->select(['id', 'game_source_id', 'game_id', 'name', 'slug', 'sprite_id', 'learning_group', 'quality_tier'])
            ->where('game_source_id', $pet->game_source_id)
            ->get()
            ->keyBy('id');
        $evolutions = PetEvolution::query()
            ->select(['id', 'from_pet_id', 'to_pet_id', 'item_id', 'quantity', 'materials', 'evolution_type'])
            ->whereHas('sourcePet', fn (Builder $query): Builder => $query->where('game_source_id', $pet->game_source_id))
            ->with(['item:id,game_source_id,source_table,game_id,name,slug,frame_id', 'item.gameSource:id,name,slug,asset_key,color'])
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

        $unlockRules = SkillUnlockRule::query()
            ->select(['level', 'maximum_skill_tier'])
            ->where('game_source_id', $pet->game_source_id)
            ->where('learning_group', $pet->learning_group)
            ->orderBy('level')
            ->get();
        $skills = Skill::query()
            ->select([
                'id',
                'game_id',
                'element_id',
                'effect_id',
                'name',
                'slug',
                'description',
                'power_percent',
                'tier',
                'max_uses',
                'energy_cost',
                'status_chance',
            ])
            ->with('effect:id,game_source_id,source_table,game_id,name,kind,duration')
            ->where('game_source_id', $pet->game_source_id)
            ->where('element_id', $pet->element_id)
            ->orderBy('tier')
            ->orderBy('game_id')
            ->get()
            ->map(function (Skill $skill) use ($unlockRules): ?array {
                $unlockRule = $unlockRules->first(
                    fn (SkillUnlockRule $rule): bool => $rule->maximum_skill_tier >= $skill->tier,
                );

                if ($unlockRule === null) {
                    return null;
                }

                return [
                    'id' => $skill->id,
                    'game_id' => $skill->game_id,
                    'name' => $skill->name,
                    'slug' => $skill->slug,
                    'description' => $skill->description,
                    'power_percent' => $skill->power_percent,
                    'tier' => $skill->tier,
                    'max_uses' => $skill->max_uses,
                    'energy_cost' => $skill->energy_cost,
                    'status_chance' => $skill->status_chance,
                    'unlock_level' => $unlockRule->level,
                    'effect' => $skill->effect === null ? null : [
                        'source_table' => $skill->effect->source_table,
                        'game_id' => $skill->effect->game_id,
                        'name' => $skill->effect->name,
                        'kind' => $skill->effect->kind,
                        'duration' => $skill->effect->duration,
                    ],
                ];
            })
            ->filter()
            ->values();
        $description = Str::of((string) $pet->description)->trim();
        $hasCombatNote = $description->contains('[') && $description->contains(']');

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
                'rarity_or_growth_code' => $pet->rarity_or_growth_code,
                'learning_group' => $pet->learning_group,
                'effectiveness_class' => $pet->effectiveness_class,
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
                    'method' => $pet->gameSource->slug === 'cau-vong'
                        ? $this->acquisitionMethod($pet->acquisition_code)
                        : null,
                    'locations' => $pet->discovery_locations ?? [],
                ],
                'quality_multiplier' => $pet->gameSource->slug === 'liet-hoa'
                    ? self::QUALITY_MULTIPLIERS[$pet->quality_tier]
                    : 100,
                'stats' => [
                    'hp' => ['base' => $pet->hp_base, 'per_level' => $pet->hp_per_level, 'offset' => $pet->hp_offset, 'per_ten_levels' => $pet->gameSource->slug === 'cau-vong'],
                    'energy' => $pet->energy_base === null ? null : ['base' => $pet->energy_base, 'per_level' => $pet->energy_per_10_levels, 'offset' => 0, 'per_ten_levels' => true],
                    'strength' => ['base' => $pet->stat_2_base, 'per_level' => $pet->stat_2_per_level, 'offset' => $pet->stat_2_offset, 'per_ten_levels' => $pet->gameSource->slug === 'cau-vong'],
                    'defense' => ['base' => $pet->stat_3_base, 'per_level' => $pet->stat_3_per_10_levels, 'offset' => $pet->stat_3_offset, 'per_ten_levels' => true],
                    'agility' => ['base' => $pet->stat_4_base, 'per_level' => $pet->stat_4_per_10_levels, 'offset' => $pet->stat_4_offset, 'per_ten_levels' => true],
                ],
                'evolution_stage' => $currentMetadata['stage'] + 1,
                'evolution_stage_count' => $familyPets->max(fn (Pet $candidate): int => $familyMetadata[$candidate->id]['stage']) + 1,
                'belongs_to_evolution_family' => $familyPets->count() > 1,
                'can_evolve' => $familyEvolutions->contains('from_pet_id', $pet->id),
                'is_final_stage' => $familyEvolutions->contains('to_pet_id', $pet->id)
                    && ! $familyEvolutions->contains('from_pet_id', $pet->id),
                'combat_element' => $this->combatElement($pet),
                'species' => $this->species($pet),
                'skills' => $skills,
                'evolution_family' => [
                    'pets' => $familyPets->map(fn (Pet $familyPet): array => [
                        'id' => $familyPet->id,
                        'game_id' => $familyPet->game_id,
                        'name' => $familyPet->name,
                        'slug' => $familyPet->slug,
                        'sprite_id' => $familyPet->sprite_id,
                        'quality_tier' => $familyPet->quality_tier,
                        'stage' => $familyMetadata[$familyPet->id]['stage'] + 1,
                        'is_current' => $familyPet->is($pet),
                    ])->values(),
                    'transitions' => $familyEvolutions->map(fn (PetEvolution $evolution): array => [
                        'from_pet_id' => $evolution->from_pet_id,
                        'to_pet_id' => $evolution->to_pet_id,
                        'type' => $evolution->evolution_type,
                        'quantity' => $evolution->quantity,
                        'materials' => $evolution->materials,
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
        ]);
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
}
