<?php

namespace App\Models;

use Database\Factories\SkillFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;

#[Fillable([
    'game_source_id',
    'game_id',
    'element_id',
    'combat_element',
    'species_affinity',
    'combat_category',
    'target_pattern',
    'effect_target_pattern',
    'battle_format',
    'role_tags',
    'balance_version',
    'is_active',
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

    /** @var array<string, string> */
    public const TARGET_PATTERNS = [
        'self' => 'Bản thân',
        'self_or_ally' => 'Bản thân hoặc đồng đội',
        'all_allies' => 'Toàn phe',
        'single_enemy' => 'Một đối thủ',
        'all_enemies' => 'Toàn bộ đối thủ',
        'battlefield' => 'Chiến trường',
    ];

    /** @var array<string, string> */
    public const COMBAT_CATEGORIES = [
        'damage' => 'Tấn công',
        'hybrid' => 'Công thủ kết hợp',
        'buff' => 'Cường hóa',
        'heal' => 'Hồi phục',
        'defense' => 'Bảo vệ',
        'control' => 'Khống chế',
        'disrupt' => 'Gây rối',
        'capture' => 'Thu nhận',
        'fallback' => 'Đòn dự phòng',
        'passive' => 'Bị động',
    ];

    /** @var array<string, mixed> */
    protected $attributes = [
        'combat_category' => 'damage',
        'target_pattern' => 'single_enemy',
        'battle_format' => 'any',
        'is_active' => true,
    ];

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

    /** @return HasMany<PetSkillLearnset, $this> */
    public function learnsetEntries(): HasMany
    {
        return $this->hasMany(PetSkillLearnset::class);
    }

    /**
     * Get the attributes that should be cast.
     *
     * @return array<string, string>
     */
    protected function casts(): array
    {
        return [
            'is_active' => 'boolean',
            'role_tags' => 'array',
            'raw_values' => 'array',
        ];
    }
}
