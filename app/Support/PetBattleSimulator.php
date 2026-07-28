<?php

namespace App\Support;

use App\Models\Pet;
use App\Models\Skill;

/**
 * @phpstan-type BattleStatus array{turns: int, value: int, elapsed?: int}
 * @phpstan-type DivineEvent array{code: string, event: string, round: int}
 * @phpstan-type BattleState array{hp: int, max_hp: int, strength: int, defense: int, agility: int, combat_element: string|null, statuses: array<string, BattleStatus>, pp: array<int, int>, trait_code: string|null, first_damage_used: bool, next_damage_percent: int, last_action_damage: bool, received_damage_since_action: bool, repeat_hits_remaining: int, repeat_power_percent: int, trait_cooldowns: array<string, int>, divine_code: string|null, divine_parameters: array<string, mixed>, divine_charges: int, divine_counters: array<string, int>, divine_cooldowns: array<string, int>, divine_flags: array<string, bool|int>, divine_events: list<DivineEvent>}
 */
class PetBattleSimulator
{
    public const MAX_ROUNDS = 30;

    /** @var array<string, string> */
    private const ELEMENT_ADVANTAGES = [
        'hoa' => 'moc',
        'moc' => 'tho',
        'tho' => 'thuy',
        'thuy' => 'hoa',
        'quy' => 'phong',
        'phong' => 'dien',
        'dien' => 'quy',
    ];

    /** @var list<string> */
    private const HARMFUL_STATUS_KEYS = [
        'action_block',
        'agility_down',
        'accuracy_down',
        'burn',
        'corrosion',
        'current_hp_dot',
        'damage_down',
        'dazed',
        'defense_down',
        'delayed_damage',
        'entangled',
        'flat_dot',
        'ghost_mirror',
        'confusion',
        'paralysis',
        'petrified',
        'bound',
        'charmed',
        'seeded_damage',
        'tier_lock',
    ];

    public function __construct(private PetStatCalculator $statCalculator) {}

    /**
     * Simulate one deterministic level-50, three-star single battle.
     *
     * @param  list<Skill>  $leftDeck
     * @param  list<Skill>  $rightDeck
     * @return array{winner_id: int|null, loser_id: int|null, is_draw: bool, rounds: int, left_hp: int, right_hp: int, left_hp_ratio: float, right_hp_ratio: float, actions: int, divine_ability_events: array<int, list<DivineEvent>>}
     */
    public function simulate(Pet $left, array $leftDeck, Pet $right, array $rightDeck, int $seed): array
    {
        $states = [
            $left->id => $this->initialState($left, $leftDeck),
            $right->id => $this->initialState($right, $rightDeck),
        ];
        $pets = [$left->id => $left, $right->id => $right];
        $decks = [$left->id => $leftDeck, $right->id => $rightDeck];
        $actions = 0;
        $round = 0;

        for ($round = 1; $round <= self::MAX_ROUNDS; $round++) {
            $order = $this->actionOrder($left, $right, $states, $seed, $round);

            foreach ($order as $actorId) {
                $targetId = $actorId === $left->id ? $right->id : $left->id;

                if ($states[$actorId]['hp'] <= 0 || $states[$targetId]['hp'] <= 0) {
                    continue;
                }

                $this->applyTurnStart($states[$actorId], $round);

                if ($states[$actorId]['hp'] <= 0) {
                    continue;
                }

                if ($this->isActionBlocked($states[$actorId])) {
                    $states[$actorId]['last_action_damage'] = false;
                    $actions++;

                    continue;
                }

                $skill = $this->chooseSkill(
                    $pets[$actorId],
                    $states[$actorId],
                    $states[$targetId],
                    $decks[$actorId],
                );
                $this->performAction(
                    $pets[$actorId],
                    $states[$actorId],
                    $pets[$targetId],
                    $states[$targetId],
                    $skill,
                    $seed,
                    $round,
                    $actions,
                );
                $actions++;
            }

            $this->applyRoundEnd($states[$left->id], $round);
            $this->applyRoundEnd($states[$right->id], $round);

            if ($states[$left->id]['hp'] <= 0 || $states[$right->id]['hp'] <= 0) {
                break;
            }
        }

        $leftRatio = max(0.0, $states[$left->id]['hp'] / $states[$left->id]['max_hp']);
        $rightRatio = max(0.0, $states[$right->id]['hp'] / $states[$right->id]['max_hp']);
        $isDraw = false;
        $winnerId = null;

        if ($states[$left->id]['hp'] <= 0 && $states[$right->id]['hp'] <= 0) {
            $isDraw = true;
        } elseif ($states[$left->id]['hp'] <= 0) {
            $winnerId = $right->id;
        } elseif ($states[$right->id]['hp'] <= 0) {
            $winnerId = $left->id;
        } elseif (abs($leftRatio - $rightRatio) <= 0.02) {
            $isDraw = true;
        } else {
            $winnerId = $leftRatio > $rightRatio ? $left->id : $right->id;
        }

        return [
            'winner_id' => $winnerId,
            'loser_id' => $winnerId === null ? null : ($winnerId === $left->id ? $right->id : $left->id),
            'is_draw' => $isDraw,
            'rounds' => min($round, self::MAX_ROUNDS),
            'left_hp' => max(0, $states[$left->id]['hp']),
            'right_hp' => max(0, $states[$right->id]['hp']),
            'left_hp_ratio' => round($leftRatio, 4),
            'right_hp_ratio' => round($rightRatio, 4),
            'actions' => $actions,
            'divine_ability_events' => [
                $left->id => $states[$left->id]['divine_events'],
                $right->id => $states[$right->id]['divine_events'],
            ],
        ];
    }

    public function elementMultiplier(?string $attackingElement, ?string $defendingElement): float
    {
        if ($attackingElement === null || $defendingElement === null || $attackingElement === $defendingElement) {
            return 1.0;
        }

        if ((self::ELEMENT_ADVANTAGES[$attackingElement] ?? null) === $defendingElement) {
            return 1.5;
        }

        if ((self::ELEMENT_ADVANTAGES[$defendingElement] ?? null) === $attackingElement) {
            return 0.75;
        }

        return 1.0;
    }

    /**
     * @param  list<Skill>  $deck
     * @return BattleState
     */
    private function initialState(Pet $pet, array $deck): array
    {
        $stats = $this->statCalculator->calculate($pet, 50, PetStatCalculator::DEFAULT_STAR);
        $traitCode = $pet->speciesTrait?->code;
        $divineAbility = $pet->divineAbility;

        if ($traitCode === 'KL-04') {
            $stats['agility'] = max(1, (int) floor($stats['agility'] * 0.92));
        }

        $pp = [];

        foreach ($deck as $skill) {
            $pp[$skill->id] = max(1, (int) $skill->max_uses);
        }

        return [
            'hp' => $stats['hp'],
            'max_hp' => $stats['hp'],
            'strength' => $stats['strength'],
            'defense' => $stats['defense'],
            'agility' => $stats['agility'],
            'combat_element' => $pet->combat_element,
            'statuses' => [],
            'pp' => $pp,
            'trait_code' => $traitCode,
            'first_damage_used' => false,
            'next_damage_percent' => 0,
            'last_action_damage' => false,
            'received_damage_since_action' => false,
            'repeat_hits_remaining' => 0,
            'repeat_power_percent' => 0,
            'trait_cooldowns' => [],
            'divine_code' => $divineAbility?->is_active === true ? $divineAbility->code : null,
            'divine_parameters' => $divineAbility?->is_active === true
                ? $divineAbility->parameters
                : [],
            'divine_charges' => 0,
            'divine_counters' => [],
            'divine_cooldowns' => [],
            'divine_flags' => [],
            'divine_events' => [],
        ];
    }

    /**
     * @param  array<int, BattleState>  $states
     * @return list<int>
     */
    private function actionOrder(Pet $left, Pet $right, array $states, int $seed, int $round): array
    {
        $leftAgility = $this->effectiveStat($states[$left->id], 'agility');
        $rightAgility = $this->effectiveStat($states[$right->id], 'agility');

        if ($leftAgility === $rightAgility) {
            return $this->randomPercent($seed, $round, 0, $left->id, 'initiative') < 50
                ? [$left->id, $right->id]
                : [$right->id, $left->id];
        }

        return $leftAgility > $rightAgility
            ? [$left->id, $right->id]
            : [$right->id, $left->id];
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     * @param  list<Skill>  $deck
     */
    private function chooseSkill(Pet $pet, array $actor, array $target, array $deck): ?Skill
    {
        $available = collect($deck)
            ->filter(fn (Skill $skill): bool => ($actor['pp'][$skill->id] ?? 0) > 0)
            ->filter(fn (Skill $skill): bool => ! $this->isTierLocked($actor, $skill))
            ->values();

        if ($available->isEmpty()) {
            return null;
        }

        return $available
            ->sortByDesc(function (Skill $skill) use ($pet, $actor, $target): float {
                $score = $this->expectedDamage($pet, $actor, $target, $skill);
                $hpRatio = $actor['hp'] / $actor['max_hp'];

                if ($skill->combat_category === 'heal') {
                    $healPercent = $skill->game_id === 28 ? 50 : 25;
                    $score = $hpRatio <= 0.62 ? $actor['max_hp'] * $healPercent / 100 : -1000;
                } elseif ($skill->power_percent <= 0) {
                    $alreadyActive = $this->effectIsActive($skill, $actor, $target);
                    $score = $alreadyActive ? -100 : 85 + ((int) $skill->tier * 12);
                } elseif ($skill->effect_id !== null) {
                    $score += 12 + ($this->statusChance($pet, $skill) / 4);
                }

                if ($pet->primary_role === 'guardian' && in_array($skill->combat_category, ['defense', 'buff'], true) && $hpRatio > 0.45) {
                    $score += 45;
                }

                if ($pet->primary_role === 'controller' && in_array($skill->combat_category, ['control', 'disrupt'], true)) {
                    $score += 35;
                }

                if ($pet->primary_role === 'support' && in_array($skill->combat_category, ['heal', 'defense', 'buff'], true)) {
                    $score += 30;
                }

                return $score;
            })
            ->first();
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function performAction(
        Pet $actorPet,
        array &$actor,
        Pet $targetPet,
        array &$target,
        ?Skill $skill,
        int $seed,
        int $round,
        int $action,
    ): void {
        $skipPpCost = $this->prepareDivineAction($actorPet, $actor, $targetPet, $target, $skill, $round);

        if ($skill === null) {
            $damage = $this->calculateDamage($actorPet, $actor, $targetPet, $target, null, $seed, $round, $action);
            $this->dealDamage($actorPet, $actor, $targetPet, $target, $damage, null, $round);
            $actor['last_action_damage'] = true;

            return;
        }

        if (! $skipPpCost) {
            $ppCost = isset($actor['statuses']['pp_overdrive']) ? 2 : 1;
            $actor['pp'][$skill->id] = max(0, $actor['pp'][$skill->id] - $ppCost);
        }

        $dealtDamage = $skill->power_percent > 0;
        $hit = false;
        $damageDealt = 0;

        if ($dealtDamage && $this->attackHits($actorPet, $actor, $targetPet, $target, $seed, $round, $action)) {
            $hit = true;
            $damage = $this->calculateDamage($actorPet, $actor, $targetPet, $target, $skill, $seed, $round, $action);

            if ($this->ghostMirrorReflects($target, $skill, $seed, $round, $action, $targetPet->id)) {
                $damageDealt = $this->dealDamage($targetPet, $target, $actorPet, $actor, $damage, $skill, $round);
            } else {
                $damageDealt = $this->dealDamage($actorPet, $actor, $targetPet, $target, $damage, $skill, $round);
                $this->resolveApprovedDamageMechanics(
                    $actorPet,
                    $actor,
                    $targetPet,
                    $target,
                    $skill,
                    $damageDealt,
                    $seed,
                    $round,
                    $action,
                );
            }
        }

        if ($skill->combat_category === 'heal') {
            $healPercent = $skill->game_id === 28 ? 50 : 25;
            $this->heal($actor, $healPercent);
        }

        $effectApplied = false;

        if ($skill->effect !== null && $this->effectApplies($actorPet, $actor, $targetPet, $target, $skill, $seed, $round, $action)) {
            $effectApplied = $this->applyEffect($skill, $actor, $target);
        }

        $this->resolveDivineEffect($actor, $target, $skill, $effectApplied, $round);

        if (! $dealtDamage) {
            $target['last_action_damage'] = false;

            if ($target['trait_code'] === 'MT-03') {
                $target['next_damage_percent'] = max(10, $target['next_damage_percent']);
            }

            if ($actor['trait_code'] === 'TV-01' && ($actor['trait_cooldowns']['TV-01'] ?? 0) <= 0) {
                $this->heal($actor, 3);
                $actor['trait_cooldowns']['TV-01'] = 3;
            }
        }

        $this->resolveDivineActionEnd($actorPet, $actor, $target, $skill, $hit, $round);
        $actor['last_action_damage'] = $dealtDamage;
        $actor['received_damage_since_action'] = false;
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function calculateDamage(
        Pet $actorPet,
        array &$actor,
        Pet $targetPet,
        array $target,
        ?Skill $skill,
        int $seed,
        int $round,
        int $action,
        ?int $powerOverride = null,
    ): int {
        $power = $powerOverride ?? ($skill === null ? 60 : $this->resolvedPower($skill, $actor, $target));
        $element = $skill === null
            ? $actorPet->combat_element
            : ($skill->combat_element ?? $actorPet->combat_element);
        $defense = $this->effectiveStat($target, 'defense');

        if ($actor['trait_code'] === 'KL-03') {
            $defense = (int) floor($defense * 0.95);
        }

        $divineDefensePierce = 0;

        if (($actor['divine_flags']['war_counter_active'] ?? false) === true) {
            $divineDefensePierce += $this->divineParameter($actor, 'defense_pierce_percent');
        }

        if (($actor['divine_flags']['realm_break_active'] ?? false) === true) {
            $divineDefensePierce += $this->divineParameter($actor, 'defense_pierce_percent');
        }

        if (($actor['divine_flags']['execution_active'] ?? false) === true) {
            $divineDefensePierce += $this->divineParameter($actor, 'defense_pierce_percent');
        }

        $defense = (int) floor($defense * max(0.1, 1 - $divineDefensePierce / 100));

        $base = max(1, $this->effectiveStat($actor, 'strength') - $defense);
        $damage = $base * ($power / 100) * $this->elementMultiplier($element, $targetPet->combat_element);
        $damage *= $this->variance($seed, $round, $action, $actorPet->id);
        $damageMultiplier = 1.0 + ($this->statusValue($actor, 'damage_up') - $this->statusValue($actor, 'damage_down')) / 100;
        $damageMultiplier -= $this->statusValue($actor, 'charmed') / 100;
        $damageMultiplier += max(0, $this->statusValue($actor, 'next_attack_percent') - 100) / 100;
        $damageMultiplier += $this->statusValue($actor, 'divine_damage_up') / 100;

        if ($actor['trait_code'] === 'KL-04') {
            $damageMultiplier += 0.08;
        }

        if ($actor['trait_code'] === 'PH-02' && ! $actor['first_damage_used']) {
            $damageMultiplier += 0.12;
        }

        if ($actor['trait_code'] === 'MT-01' && $target['hp'] / $target['max_hp'] < 0.5) {
            $damageMultiplier += 0.08;
        }

        if ($actor['trait_code'] === 'MT-04' && $actor['hp'] / $actor['max_hp'] < 0.35) {
            $damageMultiplier += 0.12;
        }

        if ($actor['divine_code'] === 'nether-king-wrath' && ($actor['divine_flags']['wrath_active'] ?? false) === true) {
            $damageMultiplier += $this->divineParameter(
                $actor,
                ($actor['divine_flags']['wrath_critical'] ?? false) === true ? 'critical_damage_percent' : 'damage_percent',
            ) / 100;
        }

        if ($actor['divine_code'] === 'underworld-judgment' && $this->hasHarmfulStatus($target)) {
            $damageMultiplier += $this->divineParameter($actor, 'damage_percent') / 100;
        }

        if (in_array($actor['divine_code'], ['sacred-light-cycle', 'myriad-blossom-domain'], true) && $actor['divine_charges'] > 0) {
            $damageMultiplier += $this->divineParameter($actor, 'damage_percent_per_charge') * $actor['divine_charges'] / 100;
        }

        if (($actor['divine_flags']['war_counter_active'] ?? false) === true) {
            $damageMultiplier += $this->divineParameter($actor, 'counter_damage_percent') / 100;
        }

        if (($actor['divine_flags']['lightning_detonated'] ?? false) === true) {
            $damageMultiplier += $this->divineParameter($actor, 'damage_percent') / 100;
        }

        if (($actor['divine_flags']['execution_active'] ?? false) === true) {
            $damageMultiplier += $this->divineParameter($actor, 'damage_percent') / 100;
        }

        if (($actor['divine_flags']['moon_damage_active'] ?? false) === true) {
            $damageMultiplier += $this->divineParameter($actor, 'damage_percent') / 100;
        }

        if (($actor['divine_flags']['holy_tide_consuming'] ?? false) === true) {
            $damageMultiplier += $this->divineParameter($actor, 'damage_percent') / 100;
        }

        if (($actor['divine_flags']['astral_damage_ready'] ?? false) === true) {
            $damageMultiplier += $this->divineParameter($actor, 'next_damage_percent') / 100;
        }

        $damageMultiplier += $actor['next_damage_percent'] / 100;
        $actor['next_damage_percent'] = 0;
        $actor['first_damage_used'] = true;

        $damage *= max(0.1, $damageMultiplier);

        if (($actor['divine_flags']['realm_break_active'] ?? false) === true) {
            $bonus = min(
                $target['hp'] * $this->divineParameter($actor, 'current_hp_damage_percent') / 100,
                $actor['max_hp'] * $this->divineParameter($actor, 'maximum_actor_hp_percent') / 100,
            );
            $damage += $bonus;
        }

        return max(1, (int) round($damage));
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function expectedDamage(Pet $pet, array $actor, array $target, Skill $skill): float
    {
        if ($skill->power_percent <= 0) {
            return 0.0;
        }

        $defense = $this->effectiveStat($target, 'defense');
        $base = max(1, $this->effectiveStat($actor, 'strength') - $defense);

        return $base * ($this->resolvedPower($skill, $actor, $target) / 100) * $this->elementMultiplier(
            $skill->combat_element ?? $pet->combat_element,
            $target['combat_element'],
        );
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function resolvedPower(Skill $skill, array $actor, array $target): int
    {
        $basePower = max(1, (int) $skill->power_percent);

        if ($skill->balance_version !== SkillBalance::VERSION) {
            return $basePower;
        }

        $mechanics = SkillBalance::mechanics($skill->gameSource->slug, $skill->game_id);
        $conditionalPower = (int) ($mechanics['conditional_power'] ?? $basePower);

        return match ($mechanics['type']) {
            'conditional_power', 'consume_for_power', 'status_or_power' => $this->hasBalancedStatus(
                $target,
                (string) ($mechanics['status'] ?? ''),
            ) ? $conditionalPower : $basePower,
            'missing_hp_power' => min(
                $conditionalPower,
                $basePower + (int) floor(
                    (100 - ($target['hp'] / $target['max_hp'] * 100)) * ((int) $mechanics['value'] / 10),
                ),
            ),
            'first_action_power' => $this->effectiveStat($actor, 'agility') > $this->effectiveStat($target, 'agility')
                ? $conditionalPower
                : $basePower,
            'target_hp_power' => $target['hp'] / $target['max_hp'] < 0.5 ? $conditionalPower : $basePower,
            'self_hp_damage' => $actor['hp'] / $actor['max_hp'] < 0.5
                ? (int) round($basePower * (1 + (int) $mechanics['value'] / 100))
                : $basePower,
            'retaliation_power' => $actor['received_damage_since_action'] ? $conditionalPower : $basePower,
            'low_hp_power_status' => $actor['hp'] / $actor['max_hp'] < 0.35 ? $conditionalPower : $basePower,
            'remove_buff_power' => $this->beneficialStatusKeys($target) !== [] ? $conditionalPower : $basePower,
            default => $basePower,
        };
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function dealDamage(
        Pet $actorPet,
        array &$actor,
        Pet $targetPet,
        array &$target,
        int $damage,
        ?Skill $skill,
        int $round,
    ): int {
        $reduction = $this->statusValue($target, 'damage_reduction');

        if (in_array($target['trait_code'], ['KL-01', 'MT-02'], true)) {
            $reduction += 6;
        }

        if ($target['trait_code'] === 'HD-03' && $target['hp'] / $target['max_hp'] >= 0.5) {
            $reduction += 6;
        }

        if ($target['divine_code'] === 'immovable-war-god' && ($target['divine_counters']['guard_round'] ?? 0) !== $round) {
            $reduction += $this->divineParameter($target, 'first_hit_reduction_percent');
            $target['divine_counters']['guard_round'] = $round;
            $this->recordDivineEvent($target, 'first_hit_reduced', $round);
        }

        if (($target['divine_flags']['tidal_armor_ready'] ?? false) === true) {
            $reduction += $this->divineParameter($target, 'next_hit_reduction_percent');
            unset($target['divine_flags']['tidal_armor_ready']);
            $this->recordDivineEvent($target, 'tidal_armor_absorbed', $round);
        }

        if ($target['divine_code'] === 'nether-king-wrath' && ($target['divine_flags']['wrath_active'] ?? false) === true) {
            $reduction += $this->divineParameter($target, 'reduction_percent');
        }

        $received = max(1, (int) round($damage * max(0.1, 1 - $reduction / 100)));
        $target['hp'] -= $received;
        $target['received_damage_since_action'] = true;

        if ($target['trait_code'] === 'TV-03') {
            $reflected = min((int) round($received * 0.08), (int) round($actor['max_hp'] * 0.05));
            $actor['hp'] -= max(1, $reflected);
        }

        $reflect = $this->statusValue($target, 'reflect');

        if ($reflect > 0) {
            $actor['hp'] -= max(1, (int) round($received * $reflect / 100));
        }

        $mirrorGuard = $this->statusValue($target, 'mirror_guard');

        if ($mirrorGuard > 0) {
            $actor['hp'] -= max(1, (int) round($received * $mirrorGuard / 100));
        }

        if ($target['trait_code'] === 'PH-03' && ($target['trait_cooldowns']['PH-03'] ?? 0) <= 0) {
            $target['statuses']['trait_agility'] = ['turns' => 2, 'value' => 6];
            $target['trait_cooldowns']['PH-03'] = 3;
        }

        if ($target['trait_code'] === 'HD-04') {
            $target['next_damage_percent'] = max(8, $target['next_damage_percent']);
        }

        $this->resolveDivineDamageTaken($target, $received, $round);
        $this->resolveDivineDamageTaken($actor, 0, $round);
        $this->resolveDivineDamageDealt($actor, $target, $skill, $round);

        return $received;
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function applyEffect(Skill $skill, array &$actor, array &$target): bool
    {
        if ($skill->effect === null) {
            return false;
        }

        if ($skill->balance_version === SkillBalance::VERSION) {
            return $this->applyBalancedEffect($skill, $actor, $target);
        }

        if ($skill->effect->kind === 'harmful' && isset($target['statuses']['status_immunity'])) {
            return false;
        }

        $sourceTable = (int) $skill->effect->source_table;
        $gameId = (int) $skill->effect->game_id;
        $duration = (int) ($skill->effect->duration ?? ($sourceTable === 11 ? ($gameId === 0 || $gameId === 6 ? 2 : 3) : 3));
        $parameter = max(0, (int) $skill->effect_parameter);

        if ($sourceTable === 6) {
            match ($gameId) {
                0 => $this->setStatuses($actor, $duration, ['defense_up' => 30, 'damage_up' => 90]),
                1 => $this->setStatuses($actor, $duration, ['strength_up' => 50, 'defense_down' => 50]),
                2 => $this->setStatuses($actor, $duration, ['defense_up' => 30, 'reflect' => 10]),
                3 => $this->setStatuses($actor, $duration, ['regeneration' => 5]),
                4 => $this->setStatuses($actor, $duration, ['defense_up' => max(20, $parameter)]),
                5 => $this->setStatuses($actor, $duration, ['mirror_guard' => 30]),
                6 => $this->setStatuses($actor, $duration, ['damage_reduction' => 50]),
                7 => $this->setStatuses($actor, $duration, ['agility_up' => max(5, $parameter)]),
                8 => $this->setStatuses($actor, $duration, ['damage_up' => 30]),
                9 => $this->setStatuses($actor, $duration, ['agility_up' => 50, 'defense_down' => 50]),
                10 => $this->setStatuses($actor, $duration, ['strength_up' => max(5, $parameter)]),
                13 => $this->setStatuses($actor, $duration, ['regeneration' => 5]),
                14 => $this->setStatuses($actor, $duration, ['status_immunity' => 1]),
                default => null,
            };

            return true;
        }

        if ($sourceTable === 7) {
            match ($gameId) {
                0 => $this->setStatuses($target, $duration, ['flat_dot' => max(3, $parameter)]),
                1, 10 => $this->setStatuses($target, $duration, ['agility_down' => max(20, $parameter)]),
                2 => $this->setStatuses($target, $duration, ['defense_down' => 10]),
                3 => $this->setStatuses($target, $duration, ['delayed_damage' => max(25, $parameter)]),
                4 => $this->setStatuses($target, $duration, ['accuracy_down' => max(5, $parameter)]),
                5 => $this->setStatuses($target, $duration, ['agility_down' => max(5, $parameter)]),
                6 => $this->setStatuses($target, $duration, ['damage_down' => max(10, $parameter)]),
                7 => $this->setStatuses($target, $duration, ['defense_down' => max(10, $parameter)]),
                9 => $this->setStatuses($target, 1, ['action_block' => 1]),
                default => null,
            };

            return true;
        }

        if ($sourceTable === 11) {
            match ($gameId) {
                0 => $this->setStatuses($target, $duration, ['action_block' => 1, 'damage_reduction' => 30]),
                1 => $this->setStatuses($target, $duration, ['burn' => 8]),
                2 => $this->setStatuses($target, $duration, ['current_hp_dot' => 10]),
                3 => $this->setStatuses($target, $duration, ['damage_down' => 10]),
                4 => $this->setStatuses($target, $duration, ['agility_down' => 15]),
                5 => $this->setStatuses($target, $duration, ['corrosion' => 4]),
                6 => $this->setStatuses($target, $duration, ['tier_lock' => 1]),
                default => null,
            };

            return true;
        }

        return false;
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function applyBalancedEffect(Skill $skill, array &$actor, array &$target): bool
    {
        $mechanics = SkillBalance::mechanics($skill->gameSource->slug, $skill->game_id);
        $type = (string) $mechanics['type'];
        $duration = (int) ($mechanics['duration'] ?? 1);
        $value = (int) ($mechanics['value'] ?? 0);

        switch ($type) {
            case 'apply_status':
                $this->applyBalancedStatus($target, (string) $mechanics['status'], $duration, $value);
                break;
            case 'next_attack':
                $this->setStatuses($actor, $duration, ['defense_up' => (int) $mechanics['secondary_value'], 'next_attack_percent' => $value]);
                break;
            case 'tradeoff_buff':
                $this->setStatuses($actor, $duration, ['damage_up' => $value, 'defense_down' => (int) $mechanics['secondary_value']]);
                break;
            case 'detonate_or_apply':
                if ($this->hasBalancedStatus($target, (string) $mechanics['status'])) {
                    $this->removeBalancedStatus($target, (string) $mechanics['status']);
                } else {
                    $this->applyBalancedStatus($target, (string) $mechanics['status'], $duration, $value);
                }
                break;
            case 'delayed_damage':
                $this->setStatuses($target, $duration, ['delayed_damage' => $value]);
                break;
            case 'defense_reflect':
                $this->setStatuses($actor, $duration, ['defense_up' => $value, 'reflect' => (int) $mechanics['secondary_value']]);
                break;
            case 'heal_regeneration':
                $this->applyHealRegeneration($actor, $value, (int) $mechanics['secondary_value'], $duration);
                break;
            case 'status_or_power':
                if (! $this->hasBalancedStatus($target, (string) $mechanics['status'])) {
                    $this->applyBalancedStatus($target, (string) $mechanics['status'], $duration, $value);
                }
                break;
            case 'defense_stack':
                $this->addDefenseStacks($actor, (int) ($mechanics['secondary_value'] ?? 1), $value, (int) $mechanics['cap'], $duration);
                break;
            case 'cleanse_regeneration':
                $this->cleanseAndRegenerate($actor, $value, $duration);
                break;
            case 'cleanse_immunity':
                $this->cleanseAndProtect($actor, $duration);
                break;
            case 'heal_reflect_chance':
                $this->healAndApply($actor, $value, $duration, 'full_reflect_chance', (int) $mechanics['secondary_value']);
                break;
            case 'damage_reduction_chance':
                $this->setStatuses($actor, $duration, ['half_damage_chance' => $value]);
                break;
            case 'self_buff_on_hit':
                $this->setStatuses($actor, $duration, [(string) $mechanics['status'] => $value]);
                break;
            case 'remove_buff':
            case 'remove_buff_power':
                $this->removeBeneficialStatuses($target, 1);
                break;
            case 'pp_overdrive':
                $this->setStatuses($actor, $duration, ['damage_up' => $value, 'pp_overdrive' => 1]);
                break;
            case 'tradeoff_speed':
                $this->setStatuses($actor, $duration, ['agility_up' => $value, 'defense_down' => (int) $mechanics['secondary_value']]);
                break;
            case 'steal_buffs':
                $this->stealBeneficialStatuses($actor, $target, $value);
                break;
            case 'repeat_buff':
                $this->applyRepeatBuff($actor, $value, (int) $mechanics['cap']);
                break;
            case 'corrosion_life_steal':
                if (! $this->hasBalancedStatus($target, 'corrosion')) {
                    $this->applyBalancedStatus($target, 'corrosion', $duration, 3);
                }
                break;
            case 'corrosion_storm':
                $this->applyBalancedStatus($target, 'corrosion', $duration, 3);
                break;
            case 'consume_defense_power':
                $this->removeBalancedStatus($actor, 'defense_stack');
                break;
        }

        return true;
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function resolveApprovedDamageMechanics(
        Pet $actorPet,
        array &$actor,
        Pet $targetPet,
        array &$target,
        Skill $skill,
        int $damageDealt,
        int $seed,
        int $round,
        int $action,
    ): void {
        if ($skill->balance_version !== SkillBalance::VERSION) {
            return;
        }

        $mechanics = SkillBalance::mechanics($skill->gameSource->slug, $skill->game_id);
        $type = (string) $mechanics['type'];

        if ($type === 'life_steal') {
            $this->healFromDamage($actor, $damageDealt, (int) $mechanics['value'], (int) $mechanics['cap']);
        }

        if ($type === 'chance_heal'
            && $this->randomPercent($seed, $round, $action, $actorPet->id, 'skill-heal') < (int) $mechanics['chance']
        ) {
            $this->heal($actor, (int) $mechanics['value']);
        }

        if ($type === 'corrosion_life_steal' && $this->hasBalancedStatus($target, 'corrosion')) {
            $this->healFromDamage($actor, $damageDealt, (int) $mechanics['value'], (int) $mechanics['cap']);
        }

        if ($type === 'pp_refund'
            && $this->randomPercent($seed, $round, $action, $actorPet->id, 'pp-refund') < (int) $mechanics['chance']
        ) {
            $actor['pp'][$skill->id] = min($skill->max_uses, $actor['pp'][$skill->id] + (int) $mechanics['value']);
        }

        if ($type === 'cleanse_on_hit') {
            $this->removeHarmfulStatuses($actor, 1);
        }

        if (in_array($type, ['consume_for_power', 'corrosion_detonate'], true)
            && isset($mechanics['status'])
        ) {
            $this->removeBalancedStatus($target, (string) $mechanics['status']);
        }

        if ($type === 'exhaust_pp') {
            foreach (array_keys($actor['pp']) as $skillId) {
                $actor['pp'][$skillId] = 0;
            }
        }

        $repeatPowerPercent = 0;

        if ($type === 'repeat_hit'
            && $this->randomPercent($seed, $round, $action, $actorPet->id, 'repeat-hit') < (int) $mechanics['chance']
        ) {
            $repeatPowerPercent = (int) $mechanics['value'];
        } elseif ($actor['repeat_hits_remaining'] > 0) {
            $repeatPowerPercent = $actor['repeat_power_percent'];
            $actor['repeat_hits_remaining']--;
        }

        if ($repeatPowerPercent > 0 && $target['hp'] > 0) {
            $repeatPower = max(1, (int) round($this->resolvedPower($skill, $actor, $target) * $repeatPowerPercent / 100));
            $repeatDamage = $this->calculateDamage(
                $actorPet,
                $actor,
                $targetPet,
                $target,
                $skill,
                $seed,
                $round,
                $action,
                $repeatPower,
            );
            $this->dealDamage($actorPet, $actor, $targetPet, $target, $repeatDamage, $skill, $round);
        }

        unset($actor['statuses']['next_attack_percent']);
    }

    /** @param BattleState $state */
    private function applyBalancedStatus(array &$state, string $status, int $duration, int $value): void
    {
        if ($status === 'petrified') {
            $this->setStatuses($state, $duration, ['petrified' => $value, 'action_block' => 1, 'damage_reduction' => 30]);

            return;
        }

        $this->setStatuses($state, $duration, [$status => $value]);
    }

    /** @param BattleState $state */
    private function hasBalancedStatus(array $state, string $status): bool
    {
        return isset($state['statuses'][$status]);
    }

    /** @param BattleState $state */
    private function removeBalancedStatus(array &$state, string $status): void
    {
        unset($state['statuses'][$status]);

        if ($status === 'petrified') {
            unset($state['statuses']['action_block'], $state['statuses']['damage_reduction']);
        }
    }

    /** @param BattleState $state */
    private function applyHealRegeneration(array &$state, int $healPercent, int $tickPercent, int $duration): void
    {
        $this->heal($state, $healPercent);
        $this->setStatuses($state, $duration, ['regeneration' => $tickPercent]);
    }

    /** @param BattleState $state */
    private function healAndApply(array &$state, int $healPercent, int $duration, string $status, int $value): void
    {
        $this->heal($state, $healPercent);
        $this->setStatuses($state, $duration, [$status => $value]);
    }

    /** @param BattleState $state */
    private function addDefenseStacks(array &$state, int $stacks, int $value, int $cap, int $duration): void
    {
        $currentStacks = $this->statusValue($state, 'defense_stack');
        $newStacks = min($cap, $currentStacks + $stacks);
        $this->setStatuses($state, $duration, ['defense_stack' => $newStacks, 'defense_up' => $newStacks * $value]);
    }

    /** @param BattleState $state */
    private function cleanseAndRegenerate(array &$state, int $tickPercent, int $duration): void
    {
        $this->removeHarmfulStatuses($state, 1);
        $this->setStatuses($state, $duration, ['regeneration' => $tickPercent]);
    }

    /** @param BattleState $state */
    private function cleanseAndProtect(array &$state, int $duration): void
    {
        $this->removeHarmfulStatuses($state);
        $this->setStatuses($state, $duration, ['status_immunity' => 1]);
    }

    /** @param BattleState $state */
    private function removeHarmfulStatuses(array &$state, ?int $limit = null): void
    {
        $removed = 0;

        foreach (self::HARMFUL_STATUS_KEYS as $status) {
            if (! isset($state['statuses'][$status])) {
                continue;
            }

            $this->removeBalancedStatus($state, $status);
            $removed++;

            if ($limit !== null && $removed >= $limit) {
                break;
            }
        }
    }

    /** @param BattleState $state */
    private function beneficialStatusKeys(array $state): array
    {
        $keys = [
            'agility_up', 'damage_reduction', 'damage_up', 'defense_stack', 'defense_up',
            'full_reflect_chance', 'half_damage_chance', 'mirror_guard', 'next_attack_percent',
            'pp_overdrive', 'reflect', 'regeneration', 'status_immunity', 'strength_up',
        ];

        return array_values(array_filter($keys, fn (string $key): bool => isset($state['statuses'][$key])));
    }

    /** @param BattleState $state */
    private function removeBeneficialStatuses(array &$state, int $limit): void
    {
        foreach (array_slice($this->beneficialStatusKeys($state), 0, $limit) as $status) {
            unset($state['statuses'][$status]);
        }
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function stealBeneficialStatuses(array &$actor, array &$target, int $limit): void
    {
        foreach (array_slice($this->beneficialStatusKeys($target), 0, $limit) as $status) {
            $actor['statuses'][$status] = $target['statuses'][$status];
            unset($target['statuses'][$status]);
        }
    }

    /** @param BattleState $state */
    private function applyRepeatBuff(array &$state, int $powerPercent, int $hits): void
    {
        $state['repeat_power_percent'] = $powerPercent;
        $state['repeat_hits_remaining'] = $hits;
    }

    /** @param BattleState $state */
    private function healFromDamage(array &$state, int $damage, int $percent, int $capPercent): void
    {
        $amount = min(
            (int) round($damage * $percent / 100),
            (int) round($state['max_hp'] * $capPercent / 100),
        );
        $state['hp'] = min($state['max_hp'], $state['hp'] + max(0, $amount));
    }

    /** @param BattleState $target */
    private function ghostMirrorReflects(
        array $target,
        Skill $skill,
        int $seed,
        int $round,
        int $action,
        int $targetPetId,
    ): bool {
        if ($skill->power_percent <= 0 || ! isset($target['statuses']['ghost_mirror'])) {
            return false;
        }

        return $this->randomPercent($seed, $round, $action, $targetPetId, 'ghost-mirror')
            < $this->statusValue($target, 'ghost_mirror');
    }

    /**
     * @param  BattleState  $state
     * @param  array<string, int>  $statuses
     */
    private function setStatuses(array &$state, int $duration, array $statuses): void
    {
        foreach ($statuses as $key => $value) {
            $state['statuses'][$key] = ['turns' => max(1, $duration), 'value' => $value, 'elapsed' => 0];
        }
    }

    /** @param BattleState $state */
    private function applyTurnStart(array &$state, int $round): void
    {
        $burn = $this->statusValue($state, 'burn');
        $currentHpDot = $this->statusValue($state, 'current_hp_dot');
        $flatDot = $this->statusValue($state, 'flat_dot');
        $seededDamage = $this->statusValue($state, 'seeded_damage');
        $corrosion = $state['statuses']['corrosion'] ?? null;

        if ($burn > 0) {
            $state['hp'] -= max(1, (int) round($state['max_hp'] * $burn / 100));
        }

        if ($currentHpDot > 0) {
            $state['hp'] -= max(1, (int) round(max(0, $state['hp']) * $currentHpDot / 100));
        }

        if ($flatDot > 0) {
            $state['hp'] -= $flatDot;
        }

        if ($seededDamage > 0) {
            $state['hp'] -= max(1, (int) round($state['max_hp'] * $seededDamage / 100));
        }

        if ($corrosion !== null) {
            $tick = min((int) $corrosion['value'] * 3, ((int) ($corrosion['elapsed'] ?? 0) + 1) * (int) $corrosion['value']);
            $state['hp'] -= max(1, (int) round($state['max_hp'] * $tick / 100));
            $corrosion['elapsed'] = (int) ($corrosion['elapsed'] ?? 0) + 1;
            $state['statuses']['corrosion'] = $corrosion;
        }

        $this->resolveDivineDamageTaken($state, 0, $round);
    }

    /** @param BattleState $state */
    private function applyRoundEnd(array &$state, int $round): void
    {
        $regeneration = $this->statusValue($state, 'regeneration');

        if ($regeneration > 0 && $state['hp'] > 0) {
            $this->heal($state, $regeneration);
        }

        if ($state['trait_code'] === 'HD-02' && $round % 3 === 0) {
            $this->restoreLowestPp($state);
        }

        foreach ($state['statuses'] as $key => $status) {
            $state['statuses'][$key]['turns'] = (int) $status['turns'] - 1;

            if ($state['statuses'][$key]['turns'] <= 0) {
                if ($key === 'delayed_damage') {
                    $state['hp'] -= $status['value'];
                }

                unset($state['statuses'][$key]);
            }
        }

        $this->resolveDivineDamageTaken($state, 0, $round);

        foreach ($state['trait_cooldowns'] as $key => $turns) {
            $state['trait_cooldowns'][$key] = max(0, (int) $turns - 1);
        }

        foreach ($state['divine_cooldowns'] as $key => $turns) {
            $state['divine_cooldowns'][$key] = max(0, (int) $turns - 1);
        }

        foreach (['lightning_mark_turns', 'fate_turns'] as $durationKey) {
            if (! isset($state['divine_counters'][$durationKey])) {
                continue;
            }

            $state['divine_counters'][$durationKey]--;

            if ($state['divine_counters'][$durationKey] <= 0) {
                unset($state['divine_counters'][$durationKey]);

                if ($durationKey === 'lightning_mark_turns') {
                    unset($state['divine_flags']['lightning_marked']);
                }

                if ($durationKey === 'fate_turns') {
                    unset($state['divine_flags']['heavenly_fate_ready']);
                }
            }
        }

        if ($state['divine_code'] === 'nether-king-wrath'
            && ($state['divine_flags']['wrath_active'] ?? false) === true
            && $this->divineParameter($state, 'critical_hp_percent') / 100 > $state['hp'] / $state['max_hp']
        ) {
            $state['divine_flags']['wrath_critical'] = true;
        }
    }

    /** @param BattleState $state */
    private function isActionBlocked(array &$state): bool
    {
        if (! isset($state['statuses']['action_block'])) {
            return false;
        }

        unset($state['statuses']['action_block']);

        return true;
    }

    /** @param BattleState $state */
    private function isTierLocked(array $state, Skill $skill): bool
    {
        return isset($state['statuses']['tier_lock']) && (int) $skill->tier > 1;
    }

    /** @param BattleState $state */
    private function heal(array &$state, int $percent): void
    {
        $amount = max(1, (int) round($state['max_hp'] * $percent / 100));
        $state['hp'] = min($state['max_hp'], $state['hp'] + $amount);
    }

    /** @param BattleState $state */
    private function effectiveStat(array $state, string $stat): int
    {
        $baseValue = match ($stat) {
            'strength' => $state['strength'],
            'defense' => $state['defense'],
            'agility' => $state['agility'],
            default => 1,
        };
        $up = $this->statusValue($state, "{$stat}_up");
        $down = $this->statusValue($state, "{$stat}_down");

        if ($stat === 'agility') {
            $up += $this->statusValue($state, 'trait_agility');
            $up += $this->statusValue($state, 'divine_agility_up');
            $down += $this->statusValue($state, 'dazed');
            $down += $this->statusValue($state, 'paralysis');
            $down += $this->statusValue($state, 'bound');
        }

        if ($stat === 'defense') {
            $down += $this->statusValue($state, 'entangled');
        }

        if ($stat === 'defense' && $state['trait_code'] === 'MT-04' && $state['hp'] / $state['max_hp'] < 0.35) {
            $down += 8;
        }

        return max(1, (int) round($baseValue * max(0.1, 1 + ($up - $down) / 100)));
    }

    /** @param BattleState $state */
    private function statusValue(array $state, string $key): int
    {
        return (int) ($state['statuses'][$key]['value'] ?? 0);
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function effectApplies(
        Pet $actorPet,
        array $actor,
        Pet $targetPet,
        array $target,
        Skill $skill,
        int $seed,
        int $round,
        int $action,
    ): bool {
        if ($skill->effect === null || $skill->effect->kind !== 'harmful') {
            return true;
        }

        if ($skill->balance_version === SkillBalance::VERSION) {
            $statusChance = SkillBalance::profile($skill->gameSource->slug, $skill->game_id)['status_chance'];

            if ($statusChance === null) {
                return true;
            }

            return $this->randomPercent($seed, $round, $action, $actorPet->id, 'effect') < $statusChance;
        }

        if ($skill->effect->source_table === 11 && $targetPet->speciesTrait?->code === 'HD-01' && in_array($skill->effect->game_id, [0, 4], true)) {
            $resistance = 15;
        } else {
            $resistance = $skill->effect->game_id === 2 && $targetPet->speciesTrait?->code === 'KL-02' ? 15 : 0;
        }

        $chance = max(0, $this->statusChance($actorPet, $skill, $actor) - $resistance);

        return $this->randomPercent($seed, $round, $action, $actorPet->id, 'effect') < $chance;
    }

    /** @param BattleState|null $state */
    private function statusChance(Pet $pet, Skill $skill, ?array $state = null): int
    {
        if ($skill->effect === null || $skill->effect->kind !== 'harmful') {
            return 100;
        }

        $chance = $skill->status_chance ?? ($skill->effect_parameter > 0 && $skill->effect_parameter <= 100 ? $skill->effect_parameter : 100);

        if ($pet->speciesTrait?->code === 'TV-04' && $skill->effect->source_table === 11 && in_array($skill->effect->game_id, [1, 5], true)) {
            $chance += 5;
        }

        if ($state !== null && ($state['divine_flags']['lightning_detonated'] ?? false) === true) {
            $chance += $this->divineParameter($state, 'status_chance_bonus');
        }

        if ($state !== null && ($state['divine_flags']['heavenly_fate_consuming'] ?? false) === true) {
            $chance += $this->divineParameter($state, 'status_chance_bonus');
        }

        return min(95, max(0, (int) $chance));
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function attackHits(Pet $actorPet, array $actor, Pet $targetPet, array $target, int $seed, int $round, int $action): bool
    {
        $accuracy = 100 - $this->statusValue($actor, 'accuracy_down');

        if ($actor['trait_code'] === 'KL-03') {
            $accuracy += 5;
        }

        if ($target['trait_code'] === 'PH-01') {
            $accuracy -= 5;
        }

        if ($actor['trait_code'] === 'PH-04') {
            $accuracy = max(85, $accuracy);
        }

        return $this->randomPercent($seed, $round, $action, $actorPet->id + $targetPet->id, 'hit') < min(100, max(5, $accuracy));
    }

    private function variance(int $seed, int $round, int $action, int $petId): float
    {
        return 0.95 + $this->randomPercent($seed, $round, $action, $petId, 'variance') / 1000;
    }

    private function randomPercent(int $seed, int $round, int $action, int $petId, string $salt): float
    {
        $hash = crc32("{$seed}:{$round}:{$action}:{$petId}:{$salt}");

        return ($hash % 10000) / 100;
    }

    /**
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function effectIsActive(Skill $skill, array $actor, array $target): bool
    {
        if ($skill->effect === null) {
            return false;
        }

        $statusKeys = match ([(int) $skill->effect->source_table, (int) $skill->effect->game_id]) {
            [6, 0] => ['defense_up', 'damage_up'],
            [6, 1] => ['strength_up', 'defense_down'],
            [6, 2] => ['defense_up', 'reflect'],
            [6, 3], [6, 13] => ['regeneration'],
            [6, 4] => ['defense_up'],
            [6, 5] => ['mirror_guard'],
            [6, 6] => ['damage_reduction'],
            [6, 7] => ['agility_up'],
            [6, 8] => ['damage_up'],
            [6, 9] => ['agility_up', 'defense_down'],
            [6, 10] => ['strength_up'],
            [6, 14] => ['status_immunity'],
            [7, 0] => ['flat_dot'],
            [7, 1], [7, 5], [7, 10] => ['agility_down'],
            [7, 2] => ['defense_down'],
            [7, 3] => ['delayed_damage'],
            [7, 4] => ['accuracy_down'],
            [7, 6] => ['damage_down'],
            [7, 7] => ['defense_down'],
            [7, 9], [11, 0] => ['action_block'],
            [11, 1] => ['burn'],
            [11, 2] => ['current_hp_dot'],
            [11, 3] => ['damage_down'],
            [11, 4] => ['agility_down'],
            [11, 5] => ['corrosion'],
            [11, 6] => ['tier_lock'],
            default => [],
        };
        $state = $skill->effect->kind === 'harmful' ? $target : $actor;

        foreach ($statusKeys as $statusKey) {
            if (isset($state['statuses'][$statusKey])) {
                return true;
            }
        }

        return false;
    }

    /**
     * Prepare temporary Divine Ability state for the selected action.
     *
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function prepareDivineAction(
        Pet $actorPet,
        array &$actor,
        Pet $targetPet,
        array &$target,
        ?Skill $skill,
        int $round,
    ): bool {
        foreach ([
            'execution_active',
            'heavenly_fate_consuming',
            'holy_tide_consuming',
            'lightning_detonated',
            'moon_damage_active',
            'moon_debuff_pending',
            'realm_break_active',
            'war_counter_active',
        ] as $flag) {
            unset($actor['divine_flags'][$flag]);
        }

        if ($actor['divine_code'] === 'moonshadow-hunt'
            && $this->effectiveStat($actor, 'agility') > $this->effectiveStat($target, 'agility')
        ) {
            $maximumCharges = $this->divineParameter($actor, 'maximum_charges');
            $actor['divine_charges'] = min($maximumCharges, $actor['divine_charges'] + 1);
            $this->recordDivineEvent($actor, 'moon_charge_gained', $round);
        }

        if ($skill === null || $skill->power_percent <= 0) {
            return false;
        }

        if ($actor['divine_code'] === 'immovable-war-god' && ($actor['divine_flags']['war_counter_ready'] ?? false) === true) {
            $actor['divine_flags']['war_counter_active'] = true;
        }

        if ($actor['divine_code'] === 'heavenly-thunder-pursuit'
            && $this->skillElement($actorPet, $skill) === 'dien'
            && ($target['divine_flags']['lightning_marked'] ?? false) === true
        ) {
            $actor['divine_flags']['lightning_detonated'] = true;
        }

        if ($actor['divine_code'] === 'realm-breaking-strike') {
            $attacksRequired = max(1, $this->divineParameter($actor, 'attacks_required'));
            $actor['divine_counters']['attack_cycle'] = ($actor['divine_counters']['attack_cycle'] ?? 0) + 1;

            if ($actor['divine_counters']['attack_cycle'] >= $attacksRequired) {
                $actor['divine_counters']['attack_cycle'] = 0;
                $actor['divine_flags']['realm_break_active'] = true;
            }
        }

        if ($actor['divine_code'] === 'demon-king-descent'
            && ($actor['divine_cooldowns']['execution'] ?? 0) <= 0
            && $this->divineParameter($actor, 'target_hp_percent') / 100 > $target['hp'] / $target['max_hp']
        ) {
            $actor['divine_flags']['execution_active'] = true;
        }

        if ($actor['divine_code'] === 'moonshadow-hunt') {
            if ($skill->effect?->kind === 'harmful'
                && $actor['divine_charges'] >= $this->divineParameter($actor, 'debuff_charge_cost')
            ) {
                $actor['divine_flags']['moon_debuff_pending'] = true;
            } elseif ($actor['divine_charges'] >= $this->divineParameter($actor, 'damage_charge_cost')) {
                $actor['divine_flags']['moon_damage_active'] = true;
            }
        }

        if ($actor['divine_code'] === 'holy-tide-song'
            && ($actor['divine_flags']['holy_tide_ready'] ?? false) === true
            && $this->skillElement($actorPet, $skill) === 'thuy'
        ) {
            $actor['divine_flags']['holy_tide_consuming'] = true;
        }

        if ($actor['divine_code'] === 'heavenly-fate-seal'
            && ($actor['divine_flags']['heavenly_fate_ready'] ?? false) === true
            && $skill->effect?->kind === 'harmful'
        ) {
            $actor['divine_flags']['heavenly_fate_consuming'] = true;

            return true;
        }

        return false;
    }

    /**
     * Resolve Divine Ability reactions after damage is received.
     *
     * @param  BattleState  $target
     */
    private function resolveDivineDamageTaken(array &$target, int $received, int $round): void
    {
        if ($target['divine_code'] === 'phoenix-rebirth'
            && $target['hp'] <= 0
            && ($target['divine_flags']['rebirth_used'] ?? false) !== true
        ) {
            $target['hp'] = 1;
            $this->heal($target, $this->divineParameter($target, 'heal_percent'));
            $this->cleanseHarmfulStatuses($target);
            $target['statuses']['divine_damage_up'] = [
                'turns' => $this->divineParameter($target, 'duration'),
                'value' => $this->divineParameter($target, 'damage_percent'),
                'elapsed' => 0,
            ];
            $target['divine_flags']['rebirth_used'] = true;
            $this->recordDivineEvent($target, 'rebirth', $round);
        }

        if ($received > 0 && $target['divine_code'] === 'immovable-war-god') {
            $hitsRequired = max(1, $this->divineParameter($target, 'hits_required'));
            $target['divine_counters']['hits_taken'] = ($target['divine_counters']['hits_taken'] ?? 0) + 1;

            if ($target['divine_counters']['hits_taken'] >= $hitsRequired) {
                $target['divine_counters']['hits_taken'] = 0;
                $target['divine_flags']['war_counter_ready'] = true;
                $this->recordDivineEvent($target, 'counter_ready', $round);
            }
        }

        if ($received > 0
            && $target['divine_code'] === 'tidal-counter-armor'
            && ($target['divine_cooldowns']['tidal_armor'] ?? 0) <= 0
            && $received / $target['max_hp'] >= $this->divineParameter($target, 'trigger_hp_percent') / 100
        ) {
            $target['divine_flags']['tidal_armor_ready'] = true;
            $target['divine_flags']['tidal_counter_ready'] = true;
            $target['divine_cooldowns']['tidal_armor'] = $this->divineParameter($target, 'cooldown');
            $this->recordDivineEvent($target, 'tidal_armor_ready', $round);
        }

        if ($target['divine_code'] === 'nether-king-wrath'
            && $target['hp'] > 0
            && ($target['divine_flags']['wrath_active'] ?? false) !== true
            && $this->divineParameter($target, 'trigger_hp_percent') / 100 > $target['hp'] / $target['max_hp']
        ) {
            $target['divine_flags']['wrath_active'] = true;
            $target['divine_flags']['wrath_critical'] = $this->divineParameter($target, 'critical_hp_percent') / 100 > $target['hp'] / $target['max_hp'];
            $this->cleanseHarmfulStatuses($target, 1);
            $this->recordDivineEvent($target, 'wrath_activated', $round);
        }
    }

    /**
     * Resolve Divine Ability rewards after a successful damaging hit.
     *
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function resolveDivineDamageDealt(array &$actor, array &$target, ?Skill $skill, int $round): void
    {
        if (in_array($actor['divine_code'], ['sacred-light-cycle', 'myriad-blossom-domain'], true) && $actor['divine_charges'] > 0) {
            $charges = $actor['divine_charges'];
            $this->heal($actor, $this->divineParameter($actor, 'heal_percent_per_charge') * $charges);

            if ($actor['divine_code'] === 'myriad-blossom-domain'
                && $charges >= $this->divineParameter($actor, 'cleanse_at_charges')
            ) {
                $this->cleanseHarmfulStatuses($actor, 1);
            }

            $actor['divine_charges'] = 0;
            $this->recordDivineEvent($actor, 'support_charges_consumed', $round);
        }

        if (($actor['divine_flags']['war_counter_active'] ?? false) === true) {
            unset($actor['divine_flags']['war_counter_active'], $actor['divine_flags']['war_counter_ready']);
            $this->recordDivineEvent($actor, 'war_counter', $round);
        }

        if (($actor['divine_flags']['tidal_counter_ready'] ?? false) === true) {
            $this->heal($actor, $this->divineParameter($actor, 'counter_heal_percent'));
            unset($actor['divine_flags']['tidal_counter_ready']);
            $this->recordDivineEvent($actor, 'tidal_counter_heal', $round);
        }

        if (($actor['divine_flags']['lightning_detonated'] ?? false) === true) {
            unset(
                $target['divine_flags']['lightning_marked'],
                $target['divine_counters']['lightning_mark_turns'],
            );
            $this->recordDivineEvent($actor, 'lightning_mark_detonated', $round);
        }

        if (($actor['divine_flags']['realm_break_active'] ?? false) === true) {
            unset($actor['divine_flags']['realm_break_active']);
            $this->recordDivineEvent($actor, 'realm_break', $round);
        }

        if (($actor['divine_flags']['execution_active'] ?? false) === true) {
            if ($target['hp'] > 0) {
                $actor['divine_cooldowns']['execution'] = $this->divineParameter($actor, 'failure_cooldown');
                $this->recordDivineEvent($actor, 'execution_failed', $round);
            } else {
                $this->recordDivineEvent($actor, 'execution_succeeded', $round);
            }

            unset($actor['divine_flags']['execution_active']);
        }

        if (($actor['divine_flags']['moon_damage_active'] ?? false) === true) {
            $actor['divine_charges'] = max(0, $actor['divine_charges'] - $this->divineParameter($actor, 'damage_charge_cost'));
            unset($actor['divine_flags']['moon_damage_active']);
            $this->recordDivineEvent($actor, 'moon_damage', $round);
        }

        if (($actor['divine_flags']['holy_tide_consuming'] ?? false) === true) {
            $this->heal($actor, $this->divineParameter($actor, 'heal_percent'));
            $this->restoreLowestPp($actor, $this->divineParameter($actor, 'pp_restore'));
            $actor['divine_cooldowns']['holy_tide'] = $this->divineParameter($actor, 'cooldown');
            unset($actor['divine_flags']['holy_tide_consuming'], $actor['divine_flags']['holy_tide_ready']);
            $this->recordDivineEvent($actor, 'holy_tide', $round);
        }

        if (($actor['divine_flags']['astral_damage_ready'] ?? false) === true) {
            unset($actor['divine_flags']['astral_damage_ready']);
            $this->recordDivineEvent($actor, 'astral_damage', $round);
        }
    }

    /**
     * Resolve Divine Ability reactions to a harmful status attempt.
     *
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function resolveDivineEffect(array &$actor, array &$target, Skill $skill, bool $effectApplied, int $round): void
    {
        if ($skill->effect?->kind !== 'harmful') {
            return;
        }

        if ($effectApplied
            && $actor['divine_code'] === 'underworld-judgment'
            && ($actor['divine_cooldowns']['judgment'] ?? 0) <= 0
        ) {
            $this->extendOneHarmfulStatus($target, $this->divineParameter($actor, 'duration_bonus'));
            $actor['divine_cooldowns']['judgment'] = $this->divineParameter($actor, 'cooldown');
            $this->recordDivineEvent($actor, 'judgment_extended', $round);
        }

        if ($effectApplied
            && $actor['divine_code'] === 'astral-flow'
            && ($actor['divine_cooldowns']['astral_flow'] ?? 0) <= 0
        ) {
            $actor['statuses']['divine_agility_up'] = [
                'turns' => $this->divineParameter($actor, 'duration'),
                'value' => $this->divineParameter($actor, 'agility_percent'),
                'elapsed' => 0,
            ];
            $actor['divine_flags']['astral_damage_ready'] = true;
            $actor['divine_cooldowns']['astral_flow'] = $this->divineParameter($actor, 'cooldown');
            $this->recordDivineEvent($actor, 'astral_flow', $round);
        }

        if ($actor['divine_code'] === 'heavenly-fate-seal') {
            if (($actor['divine_flags']['heavenly_fate_consuming'] ?? false) === true) {
                unset(
                    $actor['divine_flags']['heavenly_fate_consuming'],
                    $actor['divine_flags']['heavenly_fate_ready'],
                    $actor['divine_counters']['fate_turns'],
                );
                $this->recordDivineEvent($actor, 'heavenly_fate_consumed', $round);
            } elseif (! $effectApplied && ($actor['divine_cooldowns']['heavenly_fate'] ?? 0) <= 0) {
                $actor['divine_flags']['heavenly_fate_ready'] = true;
                $actor['divine_counters']['fate_turns'] = $this->divineParameter($actor, 'fate_duration');
                $actor['divine_cooldowns']['heavenly_fate'] = $this->divineParameter($actor, 'cooldown');
                $this->recordDivineEvent($actor, 'heavenly_fate_ready', $round);
            }
        }

        if ($effectApplied && ($actor['divine_flags']['moon_debuff_pending'] ?? false) === true) {
            $actor['divine_charges'] = max(0, $actor['divine_charges'] - $this->divineParameter($actor, 'debuff_charge_cost'));
            $this->extendOneHarmfulStatus($target, $this->divineParameter($actor, 'duration_bonus'));
            unset($actor['divine_flags']['moon_debuff_pending']);
            $this->recordDivineEvent($actor, 'moon_debuff', $round);
        }
    }

    /**
     * Resolve Divine Ability state generated by the completed action.
     *
     * @param  BattleState  $actor
     * @param  BattleState  $target
     */
    private function resolveDivineActionEnd(
        Pet $actorPet,
        array &$actor,
        array &$target,
        Skill $skill,
        bool $hit,
        int $round,
    ): void {
        if ($skill->power_percent <= 0 && in_array($actor['divine_code'], ['sacred-light-cycle', 'myriad-blossom-domain'], true)) {
            $maximumCharges = $this->divineParameter($actor, 'maximum_charges');
            $actor['divine_charges'] = min($maximumCharges, $actor['divine_charges'] + 1);
            $this->recordDivineEvent($actor, 'support_charge_gained', $round);
        }

        if ($skill->power_percent <= 0
            && $actor['divine_code'] === 'holy-tide-song'
            && ($actor['divine_cooldowns']['holy_tide'] ?? 0) <= 0
        ) {
            $actor['divine_flags']['holy_tide_ready'] = true;
            $this->recordDivineEvent($actor, 'holy_tide_ready', $round);
        }

        if (! $hit && ($actor['divine_flags']['execution_active'] ?? false) === true) {
            $actor['divine_cooldowns']['execution'] = $this->divineParameter($actor, 'failure_cooldown');
            unset($actor['divine_flags']['execution_active']);
            $this->recordDivineEvent($actor, 'execution_failed', $round);
        }

        if (! $hit && ($actor['divine_flags']['moon_damage_active'] ?? false) === true) {
            unset($actor['divine_flags']['moon_damage_active']);
        }

        if (! $hit && ($actor['divine_flags']['holy_tide_consuming'] ?? false) === true) {
            unset($actor['divine_flags']['holy_tide_consuming']);
        }

        if ($actor['divine_code'] === 'heavenly-thunder-pursuit'
            && $hit
            && $this->skillElement($actorPet, $skill) === 'dien'
        ) {
            if (($actor['divine_flags']['lightning_detonated'] ?? false) === true) {
                unset($actor['divine_flags']['lightning_detonated']);
            } elseif (($target['divine_flags']['lightning_marked'] ?? false) !== true) {
                $target['divine_flags']['lightning_marked'] = true;
                $target['divine_counters']['lightning_mark_turns'] = $this->divineParameter($actor, 'mark_duration');
                $this->recordDivineEvent($actor, 'lightning_mark_applied', $round);
            }
        }
    }

    /** @param BattleState $state */
    private function divineParameter(array $state, string $key, int $default = 0): int
    {
        return (int) ($state['divine_parameters'][$key] ?? $default);
    }

    /** @param BattleState $state */
    private function recordDivineEvent(array &$state, string $event, int $round): void
    {
        if ($state['divine_code'] === null) {
            return;
        }

        $state['divine_events'][] = [
            'code' => $state['divine_code'],
            'event' => $event,
            'round' => $round,
        ];
    }

    /** @param BattleState $state */
    private function hasHarmfulStatus(array $state): bool
    {
        return collect(self::HARMFUL_STATUS_KEYS)->contains(
            fn (string $status): bool => isset($state['statuses'][$status]),
        );
    }

    /** @param BattleState $state */
    private function cleanseHarmfulStatuses(array &$state, ?int $limit = null): void
    {
        $removed = 0;

        foreach (self::HARMFUL_STATUS_KEYS as $status) {
            if (! isset($state['statuses'][$status])) {
                continue;
            }

            unset($state['statuses'][$status]);
            $removed++;

            if ($limit !== null && $removed >= $limit) {
                return;
            }
        }
    }

    /** @param BattleState $state */
    private function extendOneHarmfulStatus(array &$state, int $turns): void
    {
        foreach (self::HARMFUL_STATUS_KEYS as $status) {
            if (! isset($state['statuses'][$status])) {
                continue;
            }

            $state['statuses'][$status]['turns'] += max(0, $turns);

            return;
        }
    }

    private function skillElement(Pet $pet, Skill $skill): ?string
    {
        return $skill->combat_element ?? $pet->combat_element;
    }

    /** @param BattleState $state */
    private function restoreLowestPp(array &$state, int $amount = 1): void
    {
        if ($state['pp'] === []) {
            return;
        }

        $lowestSkillId = null;
        $lowestPp = PHP_INT_MAX;

        foreach ($state['pp'] as $skillId => $pp) {
            if ($pp < $lowestPp) {
                $lowestSkillId = $skillId;
                $lowestPp = $pp;
            }
        }

        if ($lowestSkillId !== null) {
            $state['pp'][$lowestSkillId] += max(1, $amount);
        }
    }
}
