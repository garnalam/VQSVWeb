<?php

namespace App\Models;

use Database\Factories\PetMutationRecipeFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

#[Fillable(['pet_id', 'status', 'notes'])]
class PetMutationRecipe extends Model
{
    /** @use HasFactory<PetMutationRecipeFactory> */
    use HasFactory;

    /** @return BelongsTo<Pet, $this> */
    public function pet(): BelongsTo
    {
        return $this->belongsTo(Pet::class);
    }

    /** @return HasMany<PetMutationIngredient, $this> */
    public function ingredients(): HasMany
    {
        return $this->hasMany(PetMutationIngredient::class)->orderBy('position');
    }
}
