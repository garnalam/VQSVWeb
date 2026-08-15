<?php

namespace App\Models;

use Database\Factories\PetEvolutionFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

#[Fillable([
    'from_pet_id',
    'to_pet_id',
    'item_id',
    'quantity',
    'required_level',
    'materials',
    'evolution_type',
    'inherits_skills',
    'skill_inheritance_provenance',
    'cost_rank',
    'balance_notes',
])]
class PetEvolution extends Model
{
    /** @use HasFactory<PetEvolutionFactory> */
    use HasFactory;

    /** @return array<string, string> */
    protected function casts(): array
    {
        return [
            'materials' => 'array',
            'cost_rank' => 'integer',
            'required_level' => 'integer',
            'inherits_skills' => 'boolean',
        ];
    }

    /**
     * Get the pet at the start of this evolution path.
     *
     * @return BelongsTo<Pet, $this>
     */
    public function sourcePet(): BelongsTo
    {
        return $this->belongsTo(Pet::class, 'from_pet_id');
    }

    /**
     * Get the pet at the end of this evolution path.
     *
     * @return BelongsTo<Pet, $this>
     */
    public function targetPet(): BelongsTo
    {
        return $this->belongsTo(Pet::class, 'to_pet_id');
    }

    /**
     * Get the item required for this evolution.
     *
     * @return BelongsTo<Item, $this>
     */
    public function item(): BelongsTo
    {
        return $this->belongsTo(Item::class);
    }

    /**
     * Get every canonical ingredient consumed by this evolution.
     *
     * @return HasMany<PetEvolutionIngredient, $this>
     */
    public function ingredients(): HasMany
    {
        return $this->hasMany(PetEvolutionIngredient::class)->orderBy('position');
    }
}
