<?php

namespace App\Support;

use App\Models\Pet;

final class PetPowerClassResolver
{
    public const STANDARD = 'standard';

    public const DIVINE = 'divine';

    /**
     * Resolve the unified power class from each game's original Pet data.
     */
    public function resolve(Pet $pet): string
    {
        return $this->isDivine($pet) ? self::DIVINE : self::STANDARD;
    }

    /**
     * Determine whether the original game explicitly classifies the Pet as divine.
     */
    public function isDivine(Pet $pet): bool
    {
        $source = $pet->gameSource->slug;

        if ($source === 'liet-hoa') {
            return $pet->effectiveness_class === 2;
        }

        if ($source !== 'cau-vong') {
            return false;
        }

        $originalRank = data_get($pet->raw_values, 'evolution_stage')
            ?? data_get($pet->raw_values, 'raw_values.5');

        return (int) $originalRank === 5;
    }
}
