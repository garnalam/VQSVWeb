<?php

namespace App\Models;

use Database\Factories\EffectFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

#[Fillable([
    'source_table',
    'game_source_id',
    'game_id',
    'kind',
    'name_original',
    'name',
    'description',
    'duration',
    'parameters',
    'raw_values',
])]
class Effect extends Model
{
    /** @use HasFactory<EffectFactory> */
    use HasFactory;

    /** @return BelongsTo<GameSource, $this> */
    public function gameSource(): BelongsTo
    {
        return $this->belongsTo(GameSource::class);
    }

    /**
     * Get the skills that apply this effect.
     *
     * @return HasMany<Skill, $this>
     */
    public function skills(): HasMany
    {
        return $this->hasMany(Skill::class);
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
            'raw_values' => 'array',
        ];
    }
}
