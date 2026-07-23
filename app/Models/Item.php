<?php

namespace App\Models;

use Database\Factories\ItemFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

#[Fillable([
    'game_source_id',
    'source_table',
    'game_id',
    'name_original',
    'name',
    'slug',
    'description_original',
    'description',
    'category',
    'frame_id',
    'cost',
    'currency_code',
    'effect_type',
    'effect_parameters',
    'raw_values',
])]
class Item extends Model
{
    /** @use HasFactory<ItemFactory> */
    use HasFactory;

    /** @return BelongsTo<GameSource, $this> */
    public function gameSource(): BelongsTo
    {
        return $this->belongsTo(GameSource::class);
    }

    /**
     * Get the pet evolutions that require this item.
     *
     * @return HasMany<PetEvolution, $this>
     */
    public function petEvolutions(): HasMany
    {
        return $this->hasMany(PetEvolution::class);
    }

    /**
     * Get the attributes that should be cast.
     *
     * @return array<string, string>
     */
    protected function casts(): array
    {
        return [
            'effect_parameters' => 'array',
            'raw_values' => 'array',
        ];
    }
}
