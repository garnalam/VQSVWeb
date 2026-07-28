<?php

namespace App\Models;

use Database\Factories\ItemFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Builder;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

#[Fillable([
    'game_source_id',
    'source_table',
    'game_id',
    'canonical_item_id',
    'name_original',
    'name',
    'slug',
    'description_original',
    'description',
    'category',
    'mechanic_key',
    'usage_scope',
    'equipment_slot',
    'balance_version',
    'is_active',
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

    /** @return BelongsTo<Item, $this> */
    public function canonicalItem(): BelongsTo
    {
        return $this->belongsTo(self::class, 'canonical_item_id');
    }

    /** @return HasMany<Item, $this> */
    public function sourceVariants(): HasMany
    {
        return $this->hasMany(self::class, 'canonical_item_id');
    }

    /**
     * Limit a query to Items published in the unified catalog.
     *
     * @param  Builder<Item>  $query
     * @return Builder<Item>
     */
    public function scopeActive(Builder $query): Builder
    {
        return $query->where('is_active', true);
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
     * Get canonical evolution recipe rows that consume this item.
     *
     * @return HasMany<PetEvolutionIngredient, $this>
     */
    public function evolutionIngredients(): HasMany
    {
        return $this->hasMany(PetEvolutionIngredient::class);
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
            'is_active' => 'boolean',
            'raw_values' => 'array',
        ];
    }
}
