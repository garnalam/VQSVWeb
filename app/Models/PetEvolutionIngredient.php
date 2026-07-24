<?php

namespace App\Models;

use Database\Factories\PetEvolutionIngredientFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

#[Fillable([
    'pet_evolution_id',
    'item_id',
    'quantity',
    'role',
    'position',
])]
class PetEvolutionIngredient extends Model
{
    public const ROLE_CORE = 'core';

    public const ROLE_SPECIES = 'species';

    public const ROLE_SIGNATURE = 'signature';

    /** @use HasFactory<PetEvolutionIngredientFactory> */
    use HasFactory;

    /** @return BelongsTo<PetEvolution, $this> */
    public function petEvolution(): BelongsTo
    {
        return $this->belongsTo(PetEvolution::class);
    }

    /** @return BelongsTo<Item, $this> */
    public function item(): BelongsTo
    {
        return $this->belongsTo(Item::class);
    }

    /** @return array<string, string> */
    protected function casts(): array
    {
        return [
            'quantity' => 'integer',
            'position' => 'integer',
        ];
    }
}
