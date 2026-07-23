<?php

namespace App\Http\Controllers\Wiki;

use App\Http\Controllers\Controller;
use App\Http\Requests\Wiki\SkillIndexRequest;
use App\Models\Element;
use App\Models\GameSource;
use App\Models\Pet;
use App\Models\Skill;
use App\Models\SkillUnlockRule;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Support\Collection;
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
        $sort = (string) ($filters['sort'] ?? 'game_id');
        $gameSlug = $filters['game'] ?? null;

        $skills = Skill::query()
            ->select([
                'id',
                'game_source_id',
                'game_id',
                'element_id',
                'effect_id',
                'name',
                'slug',
                'description',
                'power_percent',
                'tier',
                'max_uses',
                'effect_mode',
                'effect_parameter',
                'target_side',
                'energy_cost',
                'status_chance',
            ])
            ->with([
                'gameSource:id,name,slug,asset_key,color',
                'element:id,game_source_id,game_id,name,slug,color',
                'effect:id,game_source_id,source_table,game_id,name,kind,duration',
            ])
            ->when($gameSlug, fn (Builder $query): Builder => $query->whereHas(
                'gameSource',
                fn (Builder $sourceQuery): Builder => $sourceQuery->where('slug', $gameSlug),
            ))
            ->when($search !== '', function (Builder $query) use ($search): void {
                $query->where(function (Builder $searchQuery) use ($search): void {
                    $searchQuery->where('name', 'like', "%{$search}%")
                        ->orWhere('description', 'like', "%{$search}%");

                    if (ctype_digit($search)) {
                        $searchQuery->orWhere('game_id', (int) $search);
                    }
                });
            })
            ->when(isset($filters['element']), function (Builder $query) use ($filters): void {
                $query->whereHas('element', function (Builder $elementQuery) use ($filters): void {
                    $elementQuery->where('game_id', (int) $filters['element']);
                });
            })
            ->when(isset($filters['tier']), fn (Builder $query): Builder => $query->where('tier', (int) $filters['tier']))
            ->when(($filters['kind'] ?? null) === 'damage', fn (Builder $query): Builder => $query->where('power_percent', '>', 0))
            ->when(($filters['kind'] ?? null) === 'status', fn (Builder $query): Builder => $query->where('power_percent', 0))
            ->when(($filters['effect'] ?? null) === 'none', fn (Builder $query): Builder => $query->whereNull('effect_id'))
            ->when(in_array($filters['effect'] ?? null, ['beneficial', 'harmful'], true), function (Builder $query) use ($filters): void {
                $query->whereHas('effect', fn (Builder $effectQuery): Builder => $effectQuery->where(
                    'kind',
                    (string) $filters['effect'],
                ));
            })
            ->when(isset($filters['target']), fn (Builder $query): Builder => $query->where(
                'target_side',
                $filters['target'] === 'self' ? 1 : 0,
            ))
            ->orderBy(match ($sort) {
                'name' => 'name',
                'power' => 'power_percent',
                'tier' => 'tier',
                default => 'game_id',
            }, $sort === 'power' ? 'desc' : 'asc')
            ->orderBy('game_id')
            ->paginate(24)
            ->withQueryString()
            ->through(fn (Skill $skill): array => [
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
                'effect_mode' => $skill->effect_mode,
                'effect_parameter' => $skill->effect_parameter,
                'target_side' => $skill->target_side,
                'energy_cost' => $skill->energy_cost,
                'status_chance' => $skill->status_chance,
                'element' => $skill->element === null ? [
                    'game_id' => -1,
                    'name' => 'Kỹ năng chung',
                    'slug' => 'ky-nang-chung',
                    'color' => $skill->gameSource->color,
                ] : [
                    'game_id' => $skill->element->game_id,
                    'name' => $skill->element->name,
                    'slug' => $skill->element->slug,
                    'color' => $skill->element->color,
                ],
                'effect' => $skill->effect === null ? null : [
                    'source_table' => $skill->effect->source_table,
                    'game_id' => $skill->effect->game_id,
                    'name' => $skill->effect->name,
                    'kind' => $skill->effect->kind,
                    'duration' => $skill->effect->duration,
                ],
            ]);

        return Inertia::render('wiki/skills/index', [
            'skills' => $skills,
            'elements' => Element::query()
                ->select('id', 'game_source_id', 'game_id', 'name', 'slug', 'color')
                ->with('gameSource:id,name,slug,asset_key,color')
                ->when($gameSlug, fn (Builder $query): Builder => $query->whereHas(
                    'gameSource',
                    fn (Builder $sourceQuery): Builder => $sourceQuery->where('slug', $gameSlug),
                ))
                ->orderBy('game_source_id')
                ->orderBy('game_id')
                ->get(),
            'gameSources' => GameSource::query()->select('name', 'slug', 'asset_key', 'color')->orderBy('id')->get(),
            'filters' => [
                'q' => $search,
                'game' => $gameSlug,
                'element' => isset($filters['element']) ? (int) $filters['element'] : null,
                'tier' => isset($filters['tier']) ? (int) $filters['tier'] : null,
                'kind' => $filters['kind'] ?? null,
                'effect' => $filters['effect'] ?? null,
                'target' => $filters['target'] ?? null,
                'sort' => $sort,
            ],
        ]);
    }

    /**
     * Display a skill dossier with unlock rules and compatible pets.
     */
    public function show(Skill $skill): Response
    {
        $skill->load([
            'gameSource:id,name,slug,asset_key,color',
            'element:id,game_source_id,game_id,name,slug,color',
            'effect:id,game_source_id,source_table,game_id,name,kind,duration,description',
        ]);

        $unlockRules = SkillUnlockRule::query()
            ->select(['learning_group', 'level', 'maximum_skill_tier'])
            ->where('game_source_id', $skill->game_source_id)
            ->where('maximum_skill_tier', '>=', $skill->tier)
            ->orderBy('learning_group')
            ->orderBy('level')
            ->get()
            ->groupBy('learning_group')
            ->map(fn (Collection $rules): array => [
                'learning_group' => $rules->first()->learning_group,
                'unlock_level' => $rules->first()->level,
                'maximum_skill_tier' => $rules->first()->maximum_skill_tier,
            ])
            ->values();

        $compatiblePets = Pet::query()
            ->select(['id', 'game_id', 'name', 'slug', 'sprite_id', 'learning_group'])
            ->where('game_source_id', $skill->game_source_id)
            ->when($skill->element_id !== null, fn (Builder $query): Builder => $query->where('element_id', $skill->element_id))
            ->whereIn('learning_group', $unlockRules->pluck('learning_group'))
            ->orderBy('game_id')
            ->get()
            ->map(fn (Pet $pet): array => [
                'id' => $pet->id,
                'game_id' => $pet->game_id,
                'name' => $pet->name,
                'slug' => $pet->slug,
                'sprite_id' => $pet->sprite_id,
                'learning_group' => $pet->learning_group,
                'unlock_level' => $unlockRules->firstWhere('learning_group', $pet->learning_group)['unlock_level'],
            ]);

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
                'target_side' => $skill->target_side,
                'energy_cost' => $skill->energy_cost,
                'status_chance' => $skill->status_chance,
                'raw_values' => $skill->raw_values,
                'element' => $skill->element === null ? [
                    'game_id' => -1,
                    'name' => 'Kỹ năng chung',
                    'slug' => 'ky-nang-chung',
                    'color' => $skill->gameSource->color,
                ] : [
                    'game_id' => $skill->element->game_id,
                    'name' => $skill->element->name,
                    'slug' => $skill->element->slug,
                    'color' => $skill->element->color,
                ],
                'effect' => $skill->effect === null ? null : [
                    'source_table' => $skill->effect->source_table,
                    'game_id' => $skill->effect->game_id,
                    'name' => $skill->effect->name,
                    'kind' => $skill->effect->kind,
                    'duration' => $skill->effect->duration,
                    'description' => $skill->effect->description,
                ],
                'unlock_rules' => $unlockRules,
                'compatible_pets' => $compatiblePets,
            ],
        ]);
    }
}
