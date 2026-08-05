<?php

namespace App\Models;

use Database\Factories\PetMutationIngredientFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

#[Fillable(['pet_mutation_recipe_id', 'item_id', 'quantity', 'role', 'position'])]
class PetMutationIngredient extends Model
{
    public const ROLE_CORE = 'core';

    public const ROLE_ELEMENT_CATALYST = 'element_catalyst';

    public const ROLE_SPECIES_CATALYST = 'species_catalyst';

    /** @use HasFactory<PetMutationIngredientFactory> */
    use HasFactory;

    /** @return BelongsTo<PetMutationRecipe, $this> */
    public function recipe(): BelongsTo
    {
        return $this->belongsTo(PetMutationRecipe::class, 'pet_mutation_recipe_id');
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
