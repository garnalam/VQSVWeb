<?php

namespace App\Support;

use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\Skill;
use Illuminate\Database\Eloquent\Collection as EloquentCollection;
use Illuminate\Support\Collection;
use RuntimeException;

/**
 * @phpstan-type EvolutionMetadata array{family_root_id: int, form_number: int, family_max_forms: int, progress_ratio: float, evolution_tier: string, evolution_tier_label: string, has_previous_form: bool, has_next_form: bool}
 * @phpstan-type BattleParticipant array{pet: Pet, evolution: EvolutionMetadata, power_class: string, deck: list<Skill>, pool_size: int, combat_score: float|int, games: int, wins: int, losses: int, draws: int, rounds: int, opponents: array<int, true>}
 * @phpstan-type PetResult array{id: int, game_id: int, name: string, game_source: string, power_class: string, combat_element: string, species: string, species_trait: string, primary_role: string, family_root_id: int, form_number: int, family_max_forms: int, progress_ratio: float, evolution_tier: string, evolution_tier_label: string, pool_size: int, deck_size: int, damage_skills: int, deck: list<array{id: int, name: string, category: string, power: int}>, opponents: int, games: int, wins: int, losses: int, draws: int, win_rate: float, draw_rate: float, average_rounds: float}
 * @phpstan-type GroupResult array{pets: int, games: int, win_rate: float, draw_rate: float, average_rounds: float}
 * @phpstan-type AuditReport array{ruleset: array<string, mixed>, summary: array<string, int|float>, by_evolution_tier: array<string, GroupResult>, by_power_class: array<string, GroupResult>, by_element: array<string, GroupResult>, by_species: array<string, GroupResult>, by_role: array<string, GroupResult>, by_source: array<string, GroupResult>, outliers: array{low: list<PetResult>, high: list<PetResult>, stall: list<PetResult>}, divine_observations: list<PetResult>, invalid_decks: list<PetResult>, pets: list<PetResult>}
 */
class PetBalanceAudit
{
    private const LOW_WIN_RATE = 35.0;

    private const HIGH_WIN_RATE = 65.0;

    public function __construct(
        private PetStatCalculator $statCalculator,
        private PetBattleSimulator $simulator,
        private PetEvolutionStageResolver $evolutionStageResolver,
        private PetCombatBudget $combatBudget,
        private PetPowerClassResolver $powerClassResolver,
    ) {}

    /**
     * Audit the complete Pet roster against similarly strong opponents.
     *
     * @return AuditReport
     */
    public function run(int $opponentsPerPet = 12, int $seedsPerMatchup = 5): array
    {
        if ($opponentsPerPet < 2 || $seedsPerMatchup < 1) {
            throw new RuntimeException('The audit requires at least two opponents and one seed.');
        }

        $pets = Pet::query()
            ->with([
                'gameSource:id,slug,name',
                'speciesTrait:id,code,name,parameters',
                'divineAbility:id,pet_id,code,parameters,is_active',
                'learnsetEntries.skill.effect',
                'learnsetEntries.skill.gameSource:id,slug',
            ])
            ->orderBy('id')
            ->get()
            ->keyBy('id');
        $evolutions = PetEvolution::query()
            ->get(['id', 'from_pet_id', 'to_pet_id']);
        $incoming = $this->incomingEvolutionIds($evolutions);
        $evolutionMetadata = $this->evolutionStageResolver->resolve($pets, $evolutions);
        $participants = $this->participants($pets, $incoming, $evolutionMetadata);
        $pairs = $this->matchupPairs($participants, $opponentsPerPet);

        foreach ($pairs as [$leftId, $rightId]) {
            for ($seed = 1; $seed <= $seedsPerMatchup; $seed++) {
                $swapSides = $seed % 2 === 0;
                $leftParticipant = $participants[$swapSides ? $rightId : $leftId];
                $rightParticipant = $participants[$swapSides ? $leftId : $rightId];
                $result = $this->simulator->simulate(
                    $leftParticipant['pet'],
                    $leftParticipant['deck'],
                    $rightParticipant['pet'],
                    $rightParticipant['deck'],
                    ($leftId * 100000) + ($rightId * 100) + $seed,
                );
                $this->recordResult($participants, $leftId, $rightId, $result);
            }
        }

        $petResults = $this->petResults($participants);
        $petResultCollection = collect($petResults);
        $standardResults = $petResultCollection->where('power_class', PetPowerClassResolver::STANDARD);

        return [
            'ruleset' => [
                'name' => 'liet-hoa-unified-1v1-v4',
                'level' => 50,
                'star' => 3,
                'physical_trait' => 'TC-00',
                'maximum_rounds' => PetBattleSimulator::MAX_ROUNDS,
                'element_multipliers' => ['advantage' => 1.5, 'neutral' => 1.0, 'disadvantage' => 0.75],
                'opponents_per_pet' => $opponentsPerPet,
                'seeds_per_matchup' => $seedsPerMatchup,
                'matchmaking' => 'same_power_class_and_evolution_tier_then_combat_score_and_element_relation',
                'combat_score_weights' => $this->combatBudget->weights(),
            ],
            'summary' => $this->summary($petResults, $pairs, $opponentsPerPet, $seedsPerMatchup),
            'by_evolution_tier' => $this->groupResults($petResults, 'evolution_tier'),
            'by_power_class' => $this->groupResults($petResults, 'power_class'),
            'by_element' => $this->groupResults($petResults, 'combat_element'),
            'by_species' => $this->groupResults($petResults, 'species'),
            'by_role' => $this->groupResults($petResults, 'primary_role'),
            'by_source' => $this->groupResults($petResults, 'game_source'),
            'outliers' => [
                'low' => array_values($standardResults->where('win_rate', '<', self::LOW_WIN_RATE)->sortBy('win_rate')->all()),
                'high' => array_values($standardResults->where('win_rate', '>', self::HIGH_WIN_RATE)->sortByDesc('win_rate')->all()),
                'stall' => array_values($petResultCollection->where('average_rounds', '>=', 24)->sortByDesc('average_rounds')->all()),
            ],
            'divine_observations' => array_values($petResultCollection
                ->where('power_class', PetPowerClassResolver::DIVINE)
                ->sortByDesc('win_rate')
                ->all()),
            'invalid_decks' => array_values($petResultCollection
                ->filter(fn (array $result): bool => $result['deck_size'] < 2 || $result['damage_skills'] < 2)
                ->all()),
            'pets' => array_values($petResults),
        ];
    }

    /**
     * @param  array<int, BattleParticipant>  $participants
     * @return list<array{0: int, 1: int}>
     */
    private function matchupPairs(array $participants, int $opponentsPerPet): array
    {
        $pairs = [];

        $participantCollection = collect($participants);

        foreach ($participants as $petId => $participant) {
            $eligibleOpponents = $participantCollection
                ->except([$petId])
                ->filter(fn (array $opponent): bool => $opponent['power_class'] === $participant['power_class']
                    && $opponent['evolution']['evolution_tier'] === $participant['evolution']['evolution_tier']
                );
            $quota = intdiv($opponentsPerPet, 3);
            $relationQuotas = [
                'advantage' => $quota,
                'disadvantage' => $quota,
                'neutral' => $opponentsPerPet - ($quota * 2),
            ];
            $opponents = collect();

            foreach ($relationQuotas as $relation => $relationQuota) {
                $bucket = $eligibleOpponents
                    ->filter(fn (array $opponent): bool => $this->elementRelation($participant['pet'], $opponent['pet']) === $relation)
                    ->sortBy(fn (array $opponent): float|int => abs($participant['combat_score'] - $opponent['combat_score']))
                    ->take($relationQuota);

                foreach ($bucket as $opponentId => $opponent) {
                    $opponents->put($opponentId, $opponent);
                }
            }

            $remainingSlots = $opponentsPerPet - $opponents->count();

            if ($remainingSlots > 0) {
                $fallbackOpponents = $eligibleOpponents
                    ->except($opponents->keys()->all())
                    ->sortBy(fn (array $opponent): float|int => abs($participant['combat_score'] - $opponent['combat_score']))
                    ->take($remainingSlots);

                foreach ($fallbackOpponents as $opponentId => $opponent) {
                    $opponents->put($opponentId, $opponent);
                }
            }

            foreach ($opponents as $opponentId => $opponent) {
                $leftId = min((int) $petId, (int) $opponentId);
                $rightId = max((int) $petId, (int) $opponentId);
                $pairs["{$leftId}:{$rightId}"] = [$leftId, $rightId];
            }
        }

        return array_values($pairs);
    }

    private function elementRelation(Pet $attacker, Pet $defender): string
    {
        return match ($this->simulator->elementMultiplier($attacker->combat_element, $defender->combat_element)) {
            1.5 => 'advantage',
            0.75 => 'disadvantage',
            default => 'neutral',
        };
    }

    /**
     * @param  EloquentCollection<int, Pet>  $pets
     * @param  array<int, list<int>>  $incoming
     * @param  array<int, EvolutionMetadata>  $evolutionMetadata
     * @return array<int, BattleParticipant>
     */
    private function participants(EloquentCollection $pets, array $incoming, array $evolutionMetadata): array
    {
        $participants = [];

        foreach ($pets as $pet) {
            $pool = $this->accessibleSkills($pet, $pets, $incoming);
            $deck = $this->buildDeck($pet, $pool);
            $stats = $this->statCalculator->calculate($pet, 50, PetStatCalculator::DEFAULT_STAR);

            $participants[$pet->id] = $this->newParticipant(
                $pet,
                $evolutionMetadata[$pet->id],
                $deck,
                $pool->count(),
                $stats,
            );
        }

        return $participants;
    }

    /**
     * @param  EloquentCollection<int, Pet>  $pets
     * @param  array<int, list<int>>  $incoming
     * @return Collection<int, Skill>
     */
    private function accessibleSkills(Pet $pet, EloquentCollection $pets, array $incoming): Collection
    {
        $skills = collect();
        $currentPetId = $pet->id;
        $visited = [];

        while (! isset($visited[$currentPetId])) {
            $visited[$currentPetId] = true;
            $currentPet = $pets->get($currentPetId);

            if (! $currentPet instanceof Pet) {
                break;
            }

            $skills = $skills->concat($currentPet->learnsetEntries->pluck('skill'));

            if (! isset($incoming[$currentPetId])) {
                break;
            }

            $currentPetId = $incoming[$currentPetId][0];
        }

        return $skills
            ->filter(fn (mixed $skill): bool => $skill instanceof Skill && $skill->is_active)
            ->unique('id')
            ->values();
    }

    /**
     * Select up to five distinct skills while preserving each role's tactical identity.
     *
     * @param  Collection<int, Skill>  $pool
     * @return list<Skill>
     */
    private function buildDeck(Pet $pet, Collection $pool): array
    {
        $damage = $pool
            ->filter(fn (Skill $skill): bool => $skill->power_percent > 0)
            ->sortByDesc(fn (Skill $skill): float => $this->skillScore($pet, $skill, true))
            ->values();
        $utility = $pool
            ->filter(fn (Skill $skill): bool => $skill->power_percent <= 0 || in_array($skill->combat_category, ['heal', 'defense', 'buff', 'control', 'disrupt'], true))
            ->sortByDesc(fn (Skill $skill): float => $this->skillScore($pet, $skill, false))
            ->values();
        $damageSlots = match ($pet->primary_role) {
            'striker' => 4,
            'bruiser', 'versatile' => 3,
            'guardian', 'controller', 'support' => 2,
            default => 3,
        };
        $selected = $damage->take(min($damageSlots, $damage->count()));
        $selected = $selected
            ->concat($utility->whereNotIn('id', $selected->pluck('id'))->take(5 - $selected->count()))
            ->concat($damage->whereNotIn('id', $selected->pluck('id'))->take(5 - $selected->count()))
            ->concat($pool->whereNotIn('id', $selected->pluck('id'))->take(5 - $selected->count()))
            ->unique('id')
            ->take(5)
            ->values();

        return array_values($selected->all());
    }

    private function skillScore(Pet $pet, Skill $skill, bool $damage): float
    {
        $score = (int) $skill->power_percent + ((int) $skill->tier * 12) + ($skill->effect_id === null ? 0 : 18);

        if ($skill->combat_element === $pet->combat_element) {
            $score += 8;
        }

        if ($skill->species_affinity === $pet->species) {
            $score += 8;
        }

        if (! $damage) {
            $roleCategories = match ($pet->primary_role) {
                'guardian' => ['defense', 'buff', 'heal'],
                'controller' => ['control', 'disrupt'],
                'support' => ['heal', 'defense', 'buff', 'control', 'disrupt'],
                default => ['buff', 'defense', 'control'],
            };
            $score += in_array($skill->combat_category, $roleCategories, true) ? 70 : 0;
        }

        return $score;
    }

    /**
     * @param  array<int, BattleParticipant>  $participants
     * @param  array{winner_id: int|null, loser_id: int|null, is_draw: bool, rounds: int, left_hp: int, right_hp: int, left_hp_ratio: float, right_hp_ratio: float, actions: int}  $result
     */
    private function recordResult(array &$participants, int $leftId, int $rightId, array $result): void
    {
        foreach ([$leftId, $rightId] as $petId) {
            $participant = $participants[$petId];
            $participant['games']++;
            $participant['rounds'] += $result['rounds'];
            $participant['opponents'][$petId === $leftId ? $rightId : $leftId] = true;

            if ($result['is_draw']) {
                $participant['draws']++;
            } elseif ($result['winner_id'] === $petId) {
                $participant['wins']++;
            } else {
                $participant['losses']++;
            }

            $participants[$petId] = $participant;
        }
    }

    /**
     * @param  array<int, BattleParticipant>  $participants
     * @return array<int, PetResult>
     */
    private function petResults(array $participants): array
    {
        $results = [];

        foreach ($participants as $participant) {
            $pet = $participant['pet'];
            $deck = $participant['deck'];
            $games = max(1, (int) $participant['games']);
            $deckRows = [];

            foreach ($deck as $skill) {
                $deckRows[] = [
                    'id' => $skill->id,
                    'name' => $skill->name,
                    'category' => $skill->combat_category,
                    'power' => $skill->power_percent,
                ];
            }

            $results[$pet->id] = [
                'id' => $pet->id,
                'game_id' => $pet->game_id,
                'name' => $pet->name,
                'game_source' => $pet->gameSource->slug,
                'power_class' => $participant['power_class'],
                'combat_element' => $pet->combat_element ?? 'unknown',
                'species' => $pet->species ?? 'unknown',
                'species_trait' => $pet->speciesTrait->code,
                'primary_role' => $pet->primary_role ?? 'unknown',
                'family_root_id' => $participant['evolution']['family_root_id'],
                'form_number' => $participant['evolution']['form_number'],
                'family_max_forms' => $participant['evolution']['family_max_forms'],
                'progress_ratio' => $participant['evolution']['progress_ratio'],
                'evolution_tier' => $participant['evolution']['evolution_tier'],
                'evolution_tier_label' => $participant['evolution']['evolution_tier_label'],
                'pool_size' => $participant['pool_size'],
                'deck_size' => count($deck),
                'damage_skills' => collect($deck)->where('power_percent', '>', 0)->count(),
                'deck' => $deckRows,
                'opponents' => count($participant['opponents']),
                'games' => $participant['games'],
                'wins' => $participant['wins'],
                'losses' => $participant['losses'],
                'draws' => $participant['draws'],
                'win_rate' => round($participant['wins'] / $games * 100, 2),
                'draw_rate' => round($participant['draws'] / $games * 100, 2),
                'average_rounds' => round($participant['rounds'] / $games, 2),
            ];
        }

        ksort($results);

        return $results;
    }

    /**
     * @param  array<int, PetResult>  $petResults
     * @param  list<array{0: int, 1: int}>  $pairs
     * @return array<string, int|float>
     */
    private function summary(
        array $petResults,
        array $pairs,
        int $opponentsPerPet,
        int $seedsPerMatchup,
    ): array {
        $results = collect($petResults);
        $standardResults = $results->where('power_class', PetPowerClassResolver::STANDARD);
        $totalGames = count($pairs) * $seedsPerMatchup;
        $totalDrawEntries = (int) $results->sum('draws');
        $stageMismatchMatchups = collect($pairs)->filter(
            fn (array $pair): bool => $petResults[$pair[0]]['evolution_tier'] !== $petResults[$pair[1]]['evolution_tier'],
        )->count();
        $powerClassMismatchMatchups = collect($pairs)->filter(
            fn (array $pair): bool => $petResults[$pair[0]]['power_class'] !== $petResults[$pair[1]]['power_class'],
        )->count();

        return [
            'pets' => count($petResults),
            'unique_matchups' => count($pairs),
            'battles' => $totalGames,
            'average_rounds' => round((float) $results->avg('average_rounds'), 2),
            'draw_rate' => $totalGames === 0 ? 0.0 : round(($totalDrawEntries / 2) / $totalGames * 100, 2),
            'stage_mismatch_matchups' => $stageMismatchMatchups,
            'power_class_mismatch_matchups' => $powerClassMismatchMatchups,
            'undersampled_pets' => $results->where('opponents', '<', $opponentsPerPet)->count(),
            'low_outliers' => $standardResults->where('win_rate', '<', self::LOW_WIN_RATE)->count(),
            'high_outliers' => $standardResults->where('win_rate', '>', self::HIGH_WIN_RATE)->count(),
            'stall_outliers' => $results->where('average_rounds', '>=', 24)->count(),
        ];
    }

    /**
     * @param  array<int, PetResult>  $petResults
     * @return array<string, array{pets: int, games: int, win_rate: float, draw_rate: float, average_rounds: float}>
     */
    private function groupResults(array $petResults, string $key): array
    {
        return collect($petResults)
            ->groupBy($key)
            ->map(function (Collection $group): array {
                $games = max(1, (int) $group->sum('games'));

                return [
                    'pets' => $group->count(),
                    'games' => (int) $group->sum('games'),
                    'win_rate' => round((int) $group->sum('wins') / $games * 100, 2),
                    'draw_rate' => round((int) $group->sum('draws') / $games * 100, 2),
                    'average_rounds' => round((float) $group->avg('average_rounds'), 2),
                ];
            })
            ->sortKeys()
            ->all();
    }

    /**
     * @param  EloquentCollection<int, PetEvolution>  $evolutions
     * @return array<int, list<int>>
     */
    private function incomingEvolutionIds(EloquentCollection $evolutions): array
    {
        $incoming = [];

        foreach ($evolutions as $evolution) {
            $incoming[$evolution->to_pet_id] ??= [];
            $incoming[$evolution->to_pet_id][] = $evolution->from_pet_id;
        }

        return $incoming;
    }

    /**
     * @param  list<Skill>  $deck
     * @param  EvolutionMetadata  $evolutionMetadata
     * @param  array{hp: int, strength: int, defense: int, agility: int}  $stats
     * @return BattleParticipant
     */
    private function newParticipant(
        Pet $pet,
        array $evolutionMetadata,
        array $deck,
        int $poolSize,
        array $stats,
    ): array {
        return [
            'pet' => $pet,
            'evolution' => $evolutionMetadata,
            'power_class' => $this->powerClassResolver->resolve($pet),
            'deck' => $deck,
            'pool_size' => $poolSize,
            'combat_score' => $this->combatBudget->score($stats),
            'games' => 0,
            'wins' => 0,
            'losses' => 0,
            'draws' => 0,
            'rounds' => 0,
            'opponents' => [],
        ];
    }
}
