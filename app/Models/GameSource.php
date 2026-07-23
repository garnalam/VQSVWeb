<?php

namespace App\Models;

use Database\Factories\GameSourceFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\HasMany;

#[Fillable(['name', 'slug', 'asset_key', 'color'])]
class GameSource extends Model
{
    /** @use HasFactory<GameSourceFactory> */
    use HasFactory;

    /** @return HasMany<Element, $this> */
    public function elements(): HasMany
    {
        return $this->hasMany(Element::class);
    }

    /** @return HasMany<Pet, $this> */
    public function pets(): HasMany
    {
        return $this->hasMany(Pet::class);
    }

    /** @return HasMany<Skill, $this> */
    public function skills(): HasMany
    {
        return $this->hasMany(Skill::class);
    }

    /** @return HasMany<Item, $this> */
    public function items(): HasMany
    {
        return $this->hasMany(Item::class);
    }

    /** @return HasMany<Effect, $this> */
    public function effects(): HasMany
    {
        return $this->hasMany(Effect::class);
    }
}
