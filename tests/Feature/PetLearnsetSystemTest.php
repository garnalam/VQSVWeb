<?php

use App\Models\Pet;
use App\Models\PetEvolution;
use App\Models\PetSkillLearnset;
use App\Models\Skill;
use App\Support\UnifiedPetLearnsetCatalog;
use Database\Seeders\DatabaseSeeder;
use Illuminate\Support\Collection;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('assigns the v3 learnset contract to all 274 pets', function () {
    $pets = Pet::query()->withCount('learnsetEntries')->get();

    expect($pets)->toHaveCount(274)
        ->and($pets->where('learnset_entries_count', 0))->toBeEmpty()
        ->and(PetSkillLearnset::query()->count())->toBe(UnifiedPetLearnsetCatalog::LEARNSET_COUNT)
        ->and(PetSkillLearnset::query()->where('is_signature', true)->count())->toBe(274);
});

test('normalizes 136 active skills while allowing catalog-only skills outside learnsets', function () {
    $skills = Skill::query()
        ->with('gameSource:id,slug')
        ->where('is_active', true)
        ->get();
    $unusedSkillKeys = $skills
        ->filter(fn (Skill $skill): bool => $skill->learnsetEntries()->doesntExist())
        ->map(fn (Skill $skill): string => skillStableKey($skill))
        ->sort()
        ->values()
        ->all();

    expect($skills)->toHaveCount(136)
        ->and($unusedSkillKeys)->toBe([
            'CV-SKILL-25',
            'CV-SKILL-26',
            'CV-SKILL-27',
            'CV-SKILL-28',
            'CV-SKILL-29',
            'CV-SKILL-30',
            'CV-SKILL-32',
            'LH-SKILL-28',
        ]);
});

test('persists every v3 grant exactly by stable pet and skill key', function () {
    $pets = Pet::query()->with('gameSource:id,slug')->get()->keyBy(fn (Pet $pet): string => petStableKey($pet));
    $skills = Skill::query()->with('gameSource:id,slug')->get()->keyBy(fn (Skill $skill): string => skillStableKey($skill));
    $databaseRows = PetSkillLearnset::query()->get()->keyBy(
        fn (PetSkillLearnset $entry): string => $entry->pet_id.'/'.$entry->skill_id,
    );

    foreach (UnifiedPetLearnsetCatalog::learnsets() as $sourceRow) {
        $pet = $pets[$sourceRow['pet_key']];
        $skill = $skills[$sourceRow['skill_key']];
        $requiredForm = $pets[$sourceRow['required_form_pet_key']];
        $databaseRow = $databaseRows[$pet->id.'/'.$skill->id];

        expect([
            $databaseRow->grant_set,
            $databaseRow->progression_grade,
            $databaseRow->required_form_pet_id,
            $databaseRow->unlock_level,
            $databaseRow->source_type,
            $databaseRow->combat_role,
            $databaseRow->is_signature,
            $databaseRow->sort_order,
            $databaseRow->provenance,
        ])->toBe([
            $sourceRow['grant_set'],
            $sourceRow['progression_grade'],
            $requiredForm->id,
            (int) $sourceRow['unlock_level'],
            $sourceRow['source_type'],
            $sourceRow['combat_role'],
            (bool) $sourceRow['is_signature'],
            (int) $sourceRow['sort_order'],
            $sourceRow['provenance'],
        ], $sourceRow['pet_key'].'/'.$sourceRow['skill_key']);
    }
});

test('uses the exact 15 unlock milestones from the refactor', function () {
    expect(PetSkillLearnset::query()->distinct()->pluck('unlock_level')->sort()->values()->all())
        ->toBe(UnifiedPetLearnsetCatalog::UNLOCK_MILESTONES);
});

test('preserves the approved direct pool size distribution', function () {
    $distribution = PetSkillLearnset::query()
        ->selectRaw('pet_id, COUNT(*) as grant_count')
        ->groupBy('pet_id')
        ->get()
        ->countBy('grant_count')
        ->sortKeys()
        ->all();

    expect($distribution)->toBe([
        3 => 16,
        4 => 39,
        5 => 39,
        6 => 34,
        7 => 30,
        8 => 30,
        9 => 1,
        15 => 85,
    ]);
});

test('preserves source type grant set and progression grade totals', function () {
    expect(PetSkillLearnset::query()->get()->countBy('source_type')->sortKeys()->all())->toBe([
        'element' => 779,
        'species' => 779,
        'style' => 779,
    ])->and(PetSkillLearnset::query()->get()->countBy('grant_set')->sortKeys()->all())->toBe([
        'legacy-v5' => 1307,
        'vqsv4-additive-v1' => 619,
        'vqsv4-bridge-v1' => 250,
        'vqsv4-native-v1' => 161,
    ])->and(PetSkillLearnset::query()->get()->countBy('progression_grade')->sortKeys()->all())->toBe([
        'advanced' => 465,
        'basic' => 775,
        'elite' => 783,
        'ultimate' => 314,
    ]);
});

test('preserves direct learnset totals for every source catalog', function () {
    $counts = PetSkillLearnset::query()
        ->join('pets', 'pets.id', '=', 'pet_skill_learnsets.pet_id')
        ->join('game_sources', 'game_sources.id', '=', 'pets.game_source_id')
        ->selectRaw('game_sources.slug, COUNT(*) as grant_count')
        ->groupBy('game_sources.slug')
        ->pluck('grant_count', 'slug')
        ->map(fn (mixed $count): int => (int) $count)
        ->sortKeys()
        ->all();

    expect($counts)->toBe([
        'cau-vong' => 876,
        'liet-hoa' => 1050,
        'vqsv4' => 411,
    ]);
});

test('syncs every evolution inheritance flag exactly', function () {
    $pets = Pet::query()->with('gameSource:id,slug')->get()->keyBy('id');
    $evolutions = PetEvolution::query()->get()->keyBy(
        fn (PetEvolution $evolution): string => evolutionStableKey($evolution, $pets),
    );

    foreach (UnifiedPetLearnsetCatalog::evolutions() as $sourceRow) {
        $evolution = $evolutions[$sourceRow['evolution_key']];

        expect([
            $evolution->evolution_type,
            $evolution->inherits_skills,
            $evolution->skill_inheritance_provenance,
        ])->toBe([
            $sourceRow['evolution_type'],
            (bool) $sourceRow['inherits_skills'],
            $sourceRow['topology_provenance'],
        ], $sourceRow['evolution_key']);
    }

    expect($evolutions)->toHaveCount(UnifiedPetLearnsetCatalog::EVOLUTION_COUNT)
        ->and($evolutions->where('inherits_skills', false))->toHaveCount(14);
});

test('stops inheritance at a non inheriting evolution edge', function () {
    $pets = Pet::query()->with(['gameSource:id,slug', 'learnsetEntries'])->get();
    $petByKey = $pets->keyBy(fn (Pet $pet): string => petStableKey($pet));
    $sourcePet = $petByKey['CV-001'];
    $targetPet = $petByKey['CV-002'];
    $incoming = PetEvolution::query()
        ->where('inherits_skills', true)
        ->get()
        ->groupBy('to_pet_id')
        ->map->pluck('from_pet_id');

    expect(PetEvolution::query()
        ->where('from_pet_id', $sourcePet->id)
        ->where('to_pet_id', $targetPet->id)
        ->firstOrFail()
        ->inherits_skills)->toBeFalse()
        ->and(accessibleSkillIds($targetPet->id, $pets->keyBy('id'), $incoming))
        ->toBe($targetPet->learnsetEntries->pluck('skill_id')->unique()->values()->all());
});

test('keeps all 33 VQSV4 skills represented in the unified pools', function () {
    $vqsv4SkillCount = PetSkillLearnset::query()
        ->whereHas('skill.gameSource', fn ($query) => $query->where('slug', 'vqsv4'))
        ->join('skills', 'skills.id', '=', 'pet_skill_learnsets.skill_id')
        ->distinct('skills.game_id')
        ->count('skills.game_id');

    expect($vqsv4SkillCount)->toBe(33);
});

test('can rebuild all learnsets repeatedly without creating duplicates', function () {
    seed(DatabaseSeeder::class);

    expect(PetSkillLearnset::query()->count())->toBe(UnifiedPetLearnsetCatalog::LEARNSET_COUNT)
        ->and(PetSkillLearnset::query()
            ->selectRaw('pet_id, skill_id, COUNT(*) as aggregate')
            ->groupBy('pet_id', 'skill_id')
            ->having('aggregate', '>', 1)
            ->exists())->toBeFalse();
});

function sourcePrefix(string $sourceSlug): string
{
    return match ($sourceSlug) {
        'liet-hoa' => 'LH',
        'cau-vong' => 'CV',
        'vqsv4' => 'V4',
    };
}

function petStableKey(Pet $pet): string
{
    return sourcePrefix($pet->gameSource->slug).'-'.str_pad((string) $pet->game_id, 3, '0', STR_PAD_LEFT);
}

function skillStableKey(Skill $skill): string
{
    return sourcePrefix($skill->gameSource->slug).'-SKILL-'.str_pad((string) $skill->game_id, 2, '0', STR_PAD_LEFT);
}

/** @param Collection<int, Pet> $pets */
function evolutionStableKey(PetEvolution $evolution, Collection $pets): string
{
    return 'EVO-'.petStableKey($pets[$evolution->from_pet_id]).'-'.petStableKey($pets[$evolution->to_pet_id]);
}

/**
 * @param  Collection<int, Pet>  $pets
 * @param  Collection<int, Collection<int, int>>  $incoming
 * @return list<int>
 */
function accessibleSkillIds(int $petId, Collection $pets, Collection $incoming): array
{
    $skillIds = [];
    $visited = [];
    $currentPetId = $petId;

    while (! isset($visited[$currentPetId])) {
        $visited[$currentPetId] = true;
        $skillIds = [...$skillIds, ...$pets[$currentPetId]->learnsetEntries->pluck('skill_id')->all()];

        if (! $incoming->has($currentPetId)) {
            break;
        }

        $currentPetId = (int) $incoming[$currentPetId]->first();
    }

    return array_values(array_unique($skillIds));
}
