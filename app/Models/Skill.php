<?php

namespace App\Models;

use Database\Factories\SkillFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

#[Fillable([
    'game_source_id',
    'game_id',
    'element_id',
    'effect_id',
    'name_original',
    'name',
    'slug',
    'description_original',
    'description',
    'power_percent',
    'energy_cost',
    'status_chance',
    'tier',
    'max_uses',
    'effect_mode',
    'effect_parameter',
    'target_side',
    'raw_values',
])]
class Skill extends Model
{
    /** @use HasFactory<SkillFactory> */
    use HasFactory;

    /** @return BelongsTo<GameSource, $this> */
    public function gameSource(): BelongsTo
    {
        return $this->belongsTo(GameSource::class);
    }

    /**
     * Get the skill's element.
     *
     * @return BelongsTo<Element, $this>
     */
    public function element(): BelongsTo
    {
        return $this->belongsTo(Element::class);
    }

    /**
     * Get the status effect applied by this skill.
     *
     * @return BelongsTo<Effect, $this>
     */
    public function effect(): BelongsTo
    {
        return $this->belongsTo(Effect::class);
    }

    /**
     * Get the attributes that should be cast.
     *
     * @return array<string, string>
     */
    protected function casts(): array
    {
        return [
            'raw_values' => 'array',
        ];
    }
}
