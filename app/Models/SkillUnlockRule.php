<?php

namespace App\Models;

use Database\Factories\SkillUnlockRuleFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

#[Fillable(['game_source_id', 'learning_group', 'level', 'maximum_skill_tier'])]
class SkillUnlockRule extends Model
{
    /** @use HasFactory<SkillUnlockRuleFactory> */
    use HasFactory;

    /** @return BelongsTo<GameSource, $this> */
    public function gameSource(): BelongsTo
    {
        return $this->belongsTo(GameSource::class);
    }

    /**
     * Get the pets governed by this learning-group rule.
     *
     * @return HasMany<Pet, $this>
     */
    public function pets(): HasMany
    {
        return $this->hasMany(Pet::class, 'learning_group', 'learning_group');
    }
}
