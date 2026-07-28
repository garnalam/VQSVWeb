<?php

namespace App\Models;

use Database\Factories\PetFactory;
use Illuminate\Database\Eloquent\Attributes\Fillable;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Relations\BelongsTo;
use Illuminate\Database\Eloquent\Relations\HasMany;
use Illuminate\Database\Eloquent\Relations\HasOne;

#[Fillable([
    'game_source_id',
    'game_id',
    'element_id',
    'combat_element',
    'species',
    'species_trait_id',
    'primary_role',
    'secondary_role',
    'preferred_battle_format',
    'playstyle_summary',
    'name_original',
    'name',
    'slug',
    'description_original',
    'description',
    'discovery_locations',
    'acquisition_code',
    'variant_code',
    'quality_tier',
    'rarity_or_growth_code',
    'hp_base',
    'hp_per_level',
    'hp_offset',
    'energy_base',
    'energy_per_10_levels',
    'stat_2_base',
    'stat_2_per_level',
    'stat_2_offset',
    'stat_3_base',
    'stat_3_per_10_levels',
    'stat_3_offset',
    'stat_4_base',
    'stat_4_per_10_levels',
    'stat_4_offset',
    'sprite_id',
    'learning_group',
    'effectiveness_class',
    'raw_values',
])]
class Pet extends Model
{
    /** @use HasFactory<PetFactory> */
    use HasFactory;

    /** @var array<string, array{name: string, color: string, game_id: int}> */
    public const COMBAT_ELEMENTS = [
        'hoa' => ['name' => 'Hỏa', 'color' => '#ef4444', 'game_id' => 0],
        'moc' => ['name' => 'Mộc', 'color' => '#10b981', 'game_id' => 1],
        'tho' => ['name' => 'Thổ', 'color' => '#b45309', 'game_id' => 2],
        'thuy' => ['name' => 'Thủy', 'color' => '#0284c7', 'game_id' => 3],
        'dien' => ['name' => 'Điện', 'color' => '#eab308', 'game_id' => 4],
        'quy' => ['name' => 'Quỷ', 'color' => '#8b5cf6', 'game_id' => 5],
        'phong' => ['name' => 'Phong', 'color' => '#06b6d4', 'game_id' => 6],
    ];

    /** @var array<string, array{name: string, color: string}> */
    public const SPECIES = [
        'thuc-vat' => ['name' => 'Thực Vật', 'color' => '#65a30d'],
        'kim-loai' => ['name' => 'Kim Loại', 'color' => '#94a3b8'],
        'phi-hanh' => ['name' => 'Phi Hành', 'color' => '#38bdf8'],
        'manh-thu' => ['name' => 'Mãnh Thú', 'color' => '#f97316'],
        'hai-duong' => ['name' => 'Hải Dương', 'color' => '#14b8a6'],
    ];

    /** @var array<string, string> */
    public const COMBAT_ROLES = [
        'striker' => 'Công kích',
        'bruiser' => 'Đấu sĩ',
        'guardian' => 'Phòng thủ',
        'controller' => 'Khống chế',
        'support' => 'Hỗ trợ',
        'versatile' => 'Đa dụng',
    ];

    /** @return BelongsTo<GameSource, $this> */
    public function gameSource(): BelongsTo
    {
        return $this->belongsTo(GameSource::class);
    }

    /**
     * Get the pet's element.
     *
     * @return BelongsTo<Element, $this>
     */
    public function element(): BelongsTo
    {
        return $this->belongsTo(Element::class);
    }

    /** @return BelongsTo<PetTrait, $this> */
    public function speciesTrait(): BelongsTo
    {
        return $this->belongsTo(PetTrait::class, 'species_trait_id');
    }

    /**
     * Get the evolution paths starting from this pet.
     *
     * @return HasMany<PetEvolution, $this>
     */
    public function evolutions(): HasMany
    {
        return $this->hasMany(PetEvolution::class, 'from_pet_id');
    }

    /**
     * Get the evolution paths ending at this pet.
     *
     * @return HasMany<PetEvolution, $this>
     */
    public function previousEvolutions(): HasMany
    {
        return $this->hasMany(PetEvolution::class, 'to_pet_id');
    }

    /** @return HasMany<PetSkillLearnset, $this> */
    public function learnsetEntries(): HasMany
    {
        return $this->hasMany(PetSkillLearnset::class);
    }

    /** @return HasOne<DivineAbility, $this> */
    public function divineAbility(): HasOne
    {
        return $this->hasOne(DivineAbility::class);
    }

    /**
     * Get the skill unlock rules for this pet's learning group.
     *
     * @return HasMany<SkillUnlockRule, $this>
     */
    public function unlockRules(): HasMany
    {
        return $this->hasMany(SkillUnlockRule::class, 'learning_group', 'learning_group');
    }

    /**
     * Get the attributes that should be cast.
     *
     * @return array<string, string>
     */
    protected function casts(): array
    {
        return [
            'discovery_locations' => 'array',
            'raw_values' => 'array',
        ];
    }
}
