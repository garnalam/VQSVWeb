<?php

namespace App\Models;

use Database\Factories\PetSkillLearnsetFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;

#[Fillable([
    'pet_id',
    'skill_id',
    'unlock_level',
    'source_type',
    'combat_role',
    'is_signature',
    'sort_order',
])]
class PetSkillLearnset extends Model
{
    /** @use HasFactory<PetSkillLearnsetFactory> */
    use HasFactory;

    /** @return BelongsTo<Pet, $this> */
    public function pet(): BelongsTo
    {
        return $this->belongsTo(Pet::class);
    }

    /** @return BelongsTo<Skill, $this> */
    public function skill(): BelongsTo
    {
        return $this->belongsTo(Skill::class);
    }

    /** @return array<string, string> */
    protected function casts(): array
    {
        return [
            'is_signature' => 'boolean',
        ];
    }
}
