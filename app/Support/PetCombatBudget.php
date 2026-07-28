<?php

namespace App\Support;

final class PetCombatBudget
{
    public const HP_WEIGHT = 0.25;

    public const STRENGTH_WEIGHT = 1.0;

    public const DEFENSE_WEIGHT = 3.0;

    public const AGILITY_WEIGHT = 2.0;

    /**
     * Convert level-adjusted Pet stats into a matchmaking budget score.
     *
     * @param  array{hp: int, strength: int, defense: int, agility: int}  $stats
     */
    public function score(array $stats): float
    {
        return $stats['hp'] * self::HP_WEIGHT
            + $stats['strength'] * self::STRENGTH_WEIGHT
            + $stats['defense'] * self::DEFENSE_WEIGHT
            + $stats['agility'] * self::AGILITY_WEIGHT;
    }

    /** @return array{hp: float, strength: float, defense: float, agility: float} */
    public function weights(): array
    {
        return [
            'hp' => self::HP_WEIGHT,
            'strength' => self::STRENGTH_WEIGHT,
            'defense' => self::DEFENSE_WEIGHT,
            'agility' => self::AGILITY_WEIGHT,
        ];
    }
}
