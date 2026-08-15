<?php

namespace Database\Seeders;

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetSkillLearnset;
use App\Models\Skill;
use App\Support\SkillBalance;
use App\Support\UnifiedPetLearnsetCatalog;
use App\Support\Vqsv4SkillData;
use Illuminate\Database\Seeder;
use Illuminate\Support\Collection;
use Illuminate\Support\Facades\DB;
use RuntimeException;

class PetLearnsetSeeder extends Seeder
{
    private const BALANCE_VERSION = SkillBalance::VERSION;

    /** @var array<int, string> */
    private const ELEMENT_BY_GAME_ID = [
        0 => 'hoa',
        1 => 'moc',
        2 => 'tho',
        3 => 'thuy',
        4 => 'dien',
        5 => 'quy',
        6 => 'phong',
    ];

    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::transaction(function (): void {
            $this->normalizeSkills();

            $pets = Pet::query()
                ->select([
                    'id',
                    'game_source_id',
                    'game_id',
                    'name',
                    'combat_element',
                    'species',
                    'primary_role',
                    'secondary_role',
                    'quality_tier',
                ])
                ->with('gameSource:id,slug')
                ->orderBy('game_source_id')
                ->orderBy('game_id')
                ->get();

            if ($pets->count() !== 274) {
                throw new RuntimeException('The unified learnset requires all 274 pets to be seeded first.');
            }

            if ($pets->contains(fn (Pet $pet): bool => $pet->primary_role === null || $pet->secondary_role === null)) {
                throw new RuntimeException('Every Pet must have an approved balance role before seeding learnsets.');
            }

            $this->seedLearnsets($pets);
        });
    }

    private function normalizeSkills(): void
    {
        $sources = GameSource::query()->whereIn('slug', ['liet-hoa', 'cau-vong', 'vqsv4'])->get()->keyBy('slug');
        $lietHoa = $sources->get('liet-hoa');
        $rainbow = $sources->get('cau-vong');
        $vqsv4 = $sources->get('vqsv4');

        if ($lietHoa === null || $rainbow === null) {
            throw new RuntimeException('Liá»‡t Há»a and Cầu Vồng sources must exist before normalizing skills.');
        }

        $this->normalizeLietHoaSkills($lietHoa);
        $this->normalizeRainbowSkills($rainbow);

        if ($vqsv4 !== null) {
            $this->normalizeRainbowSkills($vqsv4);
        }
    }

    private function normalizeLietHoaSkills(GameSource $gameSource): void
    {
        $selfOrAlly = [4, 14, 15, 25, 34, 35];
        $allAllies = [24];
        $selfOnly = [5, 44, 45, 65];
        $offensiveTeamBuffs = [21, 27, 42, 48, 62, 68];
        $healSkills = [15, 24];
        $defenseSkills = [14, 25, 34, 35];
        $controlSkills = [2, 8, 12, 18, 22, 28, 41, 47, 54, 55];

        Skill::query()
            ->whereBelongsTo($gameSource)
            ->with('element:id,game_id')
            ->orderBy('game_id')
            ->get()
            ->each(function (Skill $skill) use (
                $selfOrAlly,
                $allAllies,
                $selfOnly,
                $offensiveTeamBuffs,
                $healSkills,
                $defenseSkills,
                $controlSkills,
            ): void {
                $category = match (true) {
                    in_array($skill->game_id, $healSkills, true) => 'heal',
                    in_array($skill->game_id, $defenseSkills, true) => 'defense',
                    in_array($skill->game_id, $controlSkills, true) => 'control',
                    $skill->power_percent === 0 && $skill->effect_mode === 2 => 'disrupt',
                    $skill->power_percent === 0 && $skill->effect_mode === 1 => 'buff',
                    $skill->effect_mode !== 0 => 'hybrid',
                    default => 'damage',
                };
                $targetPattern = match (true) {
                    in_array($skill->game_id, $selfOrAlly, true) => 'self_or_ally',
                    in_array($skill->game_id, $allAllies, true) => 'all_allies',
                    in_array($skill->game_id, $selfOnly, true) => 'self',
                    default => 'single_enemy',
                };
                $effectTargetPattern = in_array($skill->game_id, $offensiveTeamBuffs, true)
                    ? 'all_allies'
                    : $targetPattern;
                $profile = SkillBalance::profile('liet-hoa', $skill->game_id);

                $skill->update([
                    'combat_element' => self::ELEMENT_BY_GAME_ID[$skill->element->game_id],
                    'species_affinity' => null,
                    'combat_category' => $category,
                    'target_pattern' => $targetPattern,
                    'effect_target_pattern' => $effectTargetPattern,
                    'battle_format' => $skill->game_id === 24 ? 'double' : 'any',
                    'role_tags' => $this->roleTags($category),
                    'balance_version' => self::BALANCE_VERSION,
                    'is_active' => true,
                    'description' => $profile['description'],
                    'power_percent' => $profile['power'],
                    'status_chance' => $profile['status_chance'],
                    'tier' => $profile['tier'],
                    'max_uses' => $profile['pp'],
                ]);
            });
    }

    private function normalizeRainbowSkills(GameSource $gameSource): void
    {
        $speciesGroups = [
            0 => 'thuc-vat',
            1 => 'kim-loai',
            2 => 'phi-hanh',
            3 => 'manh-thu',
            4 => 'hai-duong',
        ];

        Skill::query()
            ->whereBelongsTo($gameSource)
            ->orderBy('game_id')
            ->get()
            ->each(function (Skill $skill) use ($gameSource, $speciesGroups): void {
                if ($skill->game_id > Vqsv4SkillData::LAST_ACTIVE_ID) {
                    $skill->update([
                        'combat_element' => null,
                        'species_affinity' => null,
                        'combat_category' => 'passive',
                        'target_pattern' => 'self',
                        'effect_target_pattern' => 'self',
                        'battle_format' => 'any',
                        'role_tags' => [],
                        'balance_version' => null,
                        'is_active' => false,
                        'power_percent' => 0,
                        'energy_cost' => null,
                        'status_chance' => null,
                        'tier' => 0,
                        'max_uses' => 0,
                        'target_side' => 1,
                    ]);

                    return;
                }

                $definition = Vqsv4SkillData::definition($skill->game_id);
                $profile = SkillBalance::profile($gameSource->slug, $skill->game_id);
                $category = (string) $definition['combat_category'];

                $skill->update([
                    'name' => $definition['name'],
                    'combat_element' => $definition['combat_element'],
                    'species_affinity' => $skill->game_id <= 24
                        ? $speciesGroups[intdiv($skill->game_id, 5)]
                        : null,
                    'combat_category' => $category,
                    'target_pattern' => $definition['target_pattern'],
                    'effect_target_pattern' => $definition['effect_target_pattern'],
                    'battle_format' => $definition['battle_format'],
                    'role_tags' => $this->roleTags($category),
                    'balance_version' => self::BALANCE_VERSION,
                    'is_active' => true,
                    'power_percent' => $profile['power'],
                    'description' => $profile['description'],
                    'energy_cost' => null,
                    'status_chance' => $profile['status_chance'],
                    'tier' => $profile['tier'],
                    'max_uses' => $profile['pp'],
                    'target_side' => $definition['target_pattern'] === 'self_or_ally' ? 1 : 0,
                ]);
            });
    }

    /** @return list<string> */
    private function roleTags(string $category): array
    {
        return match ($category) {
            'damage' => ['striker', 'bruiser'],
            'hybrid' => ['bruiser', 'controller'],
            'buff' => ['striker', 'support'],
            'heal' => ['support', 'guardian'],
            'defense' => ['guardian', 'support'],
            'control', 'disrupt' => ['controller', 'support'],
            'capture' => ['controller'],
            default => ['versatile'],
        };
    }

    /** @param  Collection<int, Pet>  $pets */
    private function seedLearnsets(Collection $pets): void
    {
        $skills = Skill::query()
            ->select(['id', 'game_source_id', 'game_id', 'is_active'])
            ->with('gameSource:id,slug')
            ->where('is_active', true)
            ->get();
        $petByKey = $pets->keyBy(fn (Pet $pet): string => $this->petStableKey($pet));
        $skillByKey = $skills->keyBy(fn (Skill $skill): string => $this->skillStableKey($skill));
        $learnsets = UnifiedPetLearnsetCatalog::learnsets();
        $seenGrants = [];
        $seenPetKeys = [];
        $signatureCount = 0;
        $rows = [];
        $timestamp = now();

        foreach ($learnsets as $learnset) {
            $pet = $petByKey->get($learnset['pet_key']);
            $skill = $skillByKey->get($learnset['skill_key']);
            $requiredForm = $petByKey->get($learnset['required_form_pet_key']);
            $grantKey = $learnset['pet_key'].'/'.$learnset['skill_key'];
            $unlockLevel = (int) $learnset['unlock_level'];

            if ($pet === null || $skill === null || $requiredForm === null) {
                throw new RuntimeException("Unknown stable key in unified learnset grant {$grantKey}.");
            }

            if (isset($seenGrants[$grantKey])) {
                throw new RuntimeException("Duplicate unified learnset grant {$grantKey}.");
            }

            if (! in_array($unlockLevel, UnifiedPetLearnsetCatalog::UNLOCK_MILESTONES, true)) {
                throw new RuntimeException("Invalid unlock milestone for {$grantKey}: {$unlockLevel}.");
            }

            if (! in_array($learnset['source_type'], ['element', 'species', 'style'], true)) {
                throw new RuntimeException("Invalid source type for {$grantKey}: {$learnset['source_type']}.");
            }

            if (! in_array($learnset['is_signature'], ['0', '1'], true)) {
                throw new RuntimeException("Invalid signature flag for {$grantKey}.");
            }

            $seenGrants[$grantKey] = true;
            $seenPetKeys[$learnset['pet_key']] = true;
            $signatureCount += (int) $learnset['is_signature'];
            $rows[] = [
                'pet_id' => $pet->id,
                'skill_id' => $skill->id,
                'grant_set' => $learnset['grant_set'],
                'progression_grade' => $learnset['progression_grade'],
                'required_form_pet_id' => $requiredForm->id,
                'unlock_level' => $unlockLevel,
                'source_type' => $learnset['source_type'],
                'combat_role' => $learnset['combat_role'],
                'is_signature' => (bool) $learnset['is_signature'],
                'sort_order' => (int) $learnset['sort_order'],
                'provenance' => $learnset['provenance'],
                'created_at' => $timestamp,
                'updated_at' => $timestamp,
            ];
        }

        if (count($seenPetKeys) !== 274 || $signatureCount !== 274) {
            throw new RuntimeException(
                'Unified learnset contract must cover 274 Pets with one signature grant per Pet.',
            );
        }

        PetSkillLearnset::query()->delete();

        foreach (array_chunk($rows, 400) as $chunk) {
            PetSkillLearnset::query()->insert($chunk);
        }

        $this->syncEvolutionSkillInheritance($petByKey);
    }

    /** @param  Collection<string, Pet>  $petByKey */
    private function syncEvolutionSkillInheritance(Collection $petByKey): void
    {
        $evolutions = PetEvolution::query()
            ->with(['sourcePet.gameSource:id,slug', 'targetPet.gameSource:id,slug'])
            ->get();
        $evolutionByKey = $evolutions->keyBy(fn (PetEvolution $evolution): string => 'EVO-'
            .$this->petStableKey($evolution->sourcePet).'-'.$this->petStableKey($evolution->targetPet));
        $contractRows = UnifiedPetLearnsetCatalog::evolutions();
        $seenEvolutionKeys = [];

        foreach ($contractRows as $contractRow) {
            $evolution = $evolutionByKey->get($contractRow['evolution_key']);

            if ($evolution === null
                || ! $petByKey->has($contractRow['from_pet_key'])
                || ! $petByKey->has($contractRow['to_pet_key'])) {
                throw new RuntimeException("Unknown evolution stable key {$contractRow['evolution_key']}.");
            }

            if (isset($seenEvolutionKeys[$contractRow['evolution_key']])
                || ! in_array($contractRow['inherits_skills'], ['0', '1'], true)) {
                throw new RuntimeException("Invalid evolution learnset row {$contractRow['evolution_key']}.");
            }

            $seenEvolutionKeys[$contractRow['evolution_key']] = true;
            $evolution->update([
                'evolution_type' => $contractRow['evolution_type'],
                'inherits_skills' => (bool) $contractRow['inherits_skills'],
                'skill_inheritance_provenance' => $contractRow['topology_provenance'],
            ]);
        }

        if (count($seenEvolutionKeys) !== $evolutions->count()) {
            throw new RuntimeException('Unified learnset evolution contract does not cover every evolution edge.');
        }
    }

    private function petStableKey(Pet $pet): string
    {
        return $this->stableKey($pet->gameSource->slug, null, $pet->game_id, 3);
    }

    private function skillStableKey(Skill $skill): string
    {
        return $this->stableKey($skill->gameSource->slug, 'SKILL', $skill->game_id, 2);
    }

    private function stableKey(string $sourceSlug, ?string $domain, int $gameId, int $padding): string
    {
        $prefix = match ($sourceSlug) {
            'liet-hoa' => 'LH',
            'cau-vong' => 'CV',
            'vqsv4' => 'V4',
            default => throw new RuntimeException("Unknown game source {$sourceSlug}."),
        };

        return implode('-', array_filter([
            $prefix,
            $domain,
            str_pad((string) $gameId, $padding, '0', STR_PAD_LEFT),
        ]));
    }
}
