<?php

namespace App\Support;

use App\Models\Pet;
use InvalidArgumentException;

class PetStatCalculator
{
    public const DEFAULT_STAR = 3;

    /** @var array<int, int> */
    public const STAR_MULTIPLIERS = [1 => 90, 2 => 95, 3 => 100, 4 => 110, 5 => 125];

    /**
     * Calculate all unified combat stats at the requested level and star quality.
     *
     * @return array{hp: int, strength: int, defense: int, agility: int}
     */
    public function calculate(Pet $pet, int $level, int $star = self::DEFAULT_STAR): array
    {
        if ($level < 1 || $level > 50) {
            throw new InvalidArgumentException('Pet level must be between 1 and 50.');
        }

        $multiplier = $this->multiplierFor($star);

        return [
            'hp' => $this->applyMultiplier($pet->hp_base + $pet->hp_per_level * $level + $pet->hp_offset, $multiplier),
            'strength' => $this->applyMultiplier($pet->stat_2_base + $pet->stat_2_per_level * $level + $pet->stat_2_offset, $multiplier),
            'defense' => $this->applyMultiplier($pet->stat_3_base + $pet->stat_3_per_10_levels * $level / 10 + $pet->stat_3_offset, $multiplier),
            'agility' => $this->applyMultiplier($pet->stat_4_base + $pet->stat_4_per_10_levels * $level / 10 + $pet->stat_4_offset, $multiplier),
        ];
    }

    public function multiplierFor(int $star): int
    {
        return self::STAR_MULTIPLIERS[$star] ?? throw new InvalidArgumentException(
            'Pet star quality must be between 1 and 5.',
        );
    }

    private function applyMultiplier(float|int $value, int $multiplier): int
    {
        return (int) floor($value * $multiplier / 100);
    }
}
