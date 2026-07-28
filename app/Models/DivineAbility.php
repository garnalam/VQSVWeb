<?php

namespace App\Models;

use Database\Factories\DivineAbilityFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

/** @property array<string, mixed> $parameters */
#[Fillable([
    'pet_id',
    'code',
    'name',
    'activation_type',
    'description',
    'parameters',
    'is_active',
])]
class DivineAbility extends Model
{
    /** @use HasFactory<DivineAbilityFactory> */
    use HasFactory;

    /** @return BelongsTo<Pet, $this> */
    public function pet(): BelongsTo
    {
        return $this->belongsTo(Pet::class);
    }

    /** @return array<string, string> */
    protected function casts(): array
    {
        return [
            'parameters' => 'array',
            'is_active' => 'boolean',
        ];
    }
}
