<?php

namespace App\Models;

use Database\Factories\PetTraitFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasMany;

#[Fillable([
    'code',
    'name',
    'slot_type',
    'species',
    'polarity',
    'description',
    'parameters',
    'roll_weight',
    'is_cleanse_eligible',
    'is_active',
])]
class PetTrait extends Model
{
    /** @use HasFactory<PetTraitFactory> */
    use HasFactory;

    public const SLOT_PHYSICAL = 'physical';

    public const SLOT_SPECIES = 'species';

    public const POLARITY_NEUTRAL = 'neutral';

    public const POLARITY_BENEFICIAL = 'beneficial';

    public const POLARITY_HARMFUL = 'harmful';

    public const POLARITY_MIXED = 'mixed';

    protected $table = 'traits';

    /** @return HasMany<Pet, $this> */
    public function speciesPets(): HasMany
    {
        return $this->hasMany(Pet::class, 'species_trait_id');
    }

    /** @param Builder<PetTrait> $query */
    public function scopePhysical(Builder $query): Builder
    {
        return $query->where('slot_type', self::SLOT_PHYSICAL);
    }

    /** @param Builder<PetTrait> $query */
    public function scopeSpecies(Builder $query): Builder
    {
        return $query->where('slot_type', self::SLOT_SPECIES);
    }

    /** @param Builder<PetTrait> $query */
    public function scopeActive(Builder $query): Builder
    {
        return $query->where('is_active', true);
    }

    /**
     * Get the attributes that should be cast.
     *
     * @return array<string, string>
     */
    protected function casts(): array
    {
        return [
            'parameters' => 'array',
            'roll_weight' => 'integer',
            'is_cleanse_eligible' => 'boolean',
            'is_active' => 'boolean',
        ];
    }
}
