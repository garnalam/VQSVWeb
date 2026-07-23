<?php

namespace App\Models;

use Database\Factories\ElementFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

#[Fillable(['game_source_id', 'game_id', 'name', 'slug', 'color', 'icon_path'])]
class Element extends Model
{
    /** @use HasFactory<ElementFactory> */
    use HasFactory;

    /** @return BelongsTo<GameSource, $this> */
    public function gameSource(): BelongsTo
    {
        return $this->belongsTo(GameSource::class);
    }

    /**
     * Get the pets belonging to this element.
     *
     * @return HasMany<Pet, $this>
     */
    public function pets(): HasMany
    {
        return $this->hasMany(Pet::class);
    }

    /**
     * Get the skills belonging to this element.
     *
     * @return HasMany<Skill, $this>
     */
    public function skills(): HasMany
    {
        return $this->hasMany(Skill::class);
    }
}
