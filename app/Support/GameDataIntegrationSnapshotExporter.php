<?php

namespace App\Support;

use App\Models\Pet;
use Illuminate\Filesystem\Filesystem;
use Illuminate\Support\Facades\DB;
use InvalidArgumentException;
use PDO;
use RuntimeException;

final class GameDataIntegrationSnapshotExporter
{
    public const SCHEMA_VERSION = '2.1.0';

    public const DATA_VERSION = 'unified-2026-08-16.1';

    /** @var list<string> */
    private const EXCLUDED_RAINBOW_ITEMS = [
        'Hưng phấn cô.',
        'Mật tâm đường.',
        'Quân tâm tan rã.',
        'Tử vong chi sờ.',
        'Trung thành đồng bọn.',
        'Hoa cỏ Ý Chí.',
        'Kim Loại Ý Chí.',
        'Bầu trời Ý Chí.',
        'Dã thú Ý Chí.',
        'Biển rộng Ý Chí.',
    ];

    public function __construct(
        private readonly Filesystem $files,
        private readonly PetStatCalculator $petStatCalculator,
    ) {}

    /**
     * Export the current gameplay catalog to a portable, read-only integration snapshot.
     *
     * @return array{database_path: string, manifest_path: string, checksum_sha256: string, counts: array<string, int>}
     */
    public function export(string $databasePath, ?string $manifestPath = null): array
    {
        if (trim($databasePath) === '') {
            throw new InvalidArgumentException('The integration database path cannot be empty.');
        }

        $manifestPath ??= $databasePath.'.manifest.json';
        $this->prepareOutputPath($databasePath);
        $this->prepareOutputPath($manifestPath);

        $pdo = new PDO('sqlite:'.$databasePath, null, null, [
            PDO::ATTR_ERRMODE => PDO::ERRMODE_EXCEPTION,
            PDO::ATTR_DEFAULT_FETCH_MODE => PDO::FETCH_ASSOC,
        ]);
        $pdo->exec('PRAGMA foreign_keys = ON');
        $pdo->exec('PRAGMA journal_mode = DELETE');

        $this->createSchema($pdo);
        $pdo->beginTransaction();

        try {
            $sourceKeys = $this->exportGameSources($pdo);
            $elementKeys = $this->exportElements($pdo, $sourceKeys);
            $effectKeys = $this->exportEffects($pdo, $sourceKeys);
            $traitKeys = $this->exportTraits($pdo);
            $petKeys = $this->exportPets($pdo, $sourceKeys, $elementKeys, $traitKeys);
            $skillKeys = $this->exportSkills($pdo, $sourceKeys, $elementKeys, $effectKeys);
            $itemKeys = $this->exportItems($pdo, $sourceKeys);

            $this->exportSkillUnlockRules($pdo, $sourceKeys);
            $this->exportLearnsets($pdo, $petKeys, $skillKeys);
            $this->exportItemDecisions($pdo, $sourceKeys, $itemKeys);
            $evolutionKeys = $this->exportEvolutions($pdo, $petKeys, $itemKeys);
            $this->exportEvolutionIngredients($pdo, $evolutionKeys, $itemKeys);
            $mutationKeys = $this->exportMutationRecipes($pdo, $petKeys);
            $this->exportMutationIngredients($pdo, $mutationKeys, $itemKeys);
            $this->exportDivineAbilities($pdo, $petKeys);
            $this->exportMetadata($pdo);

            $pdo->commit();
        } catch (\Throwable $throwable) {
            if ($pdo->inTransaction()) {
                $pdo->rollBack();
            }

            throw $throwable;
        }

        $counts = $this->snapshotCounts($pdo);
        $pdo = null;
        $checksum = hash_file('sha256', $databasePath);

        if ($checksum === false) {
            throw new RuntimeException("Unable to checksum integration snapshot: {$databasePath}");
        }

        $manifest = [
            'schema_version' => self::SCHEMA_VERSION,
            'data_version' => self::DATA_VERSION,
            'skill_balance_version' => SkillBalance::VERSION,
            'pet_stat_profile_version' => Vqsv4PetDesignRevision::VERSION,
            'learnset_version' => UnifiedPetLearnsetCatalog::VERSION,
            'item_balance_version' => ItemBalance::VERSION,
            'generated_at' => now()->toIso8601String(),
            'database_file' => basename($databasePath),
            'checksum_sha256' => $checksum,
            'counts' => $counts,
            'provenance_classes' => [
                'decoded_source' => 'Directly decoded or transcribed from an original game resource.',
                'source_normalized' => 'Source-backed data normalized into the unified schema.',
                'unified_balance' => 'A reviewed balance value that intentionally differs from source.',
                'unified_design' => 'A new integration rule composed from source-backed concepts.',
                'generated_unified_design' => 'A deterministic generated result of unified design rules.',
                'excluded_by_design' => 'A source record intentionally omitted from the unified game.',
            ],
        ];

        $encodedManifest = json_encode($manifest, JSON_PRETTY_PRINT | JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE);

        if ($encodedManifest === false) {
            throw new RuntimeException('Unable to encode the integration manifest.');
        }

        $this->files->put($manifestPath, $encodedManifest.PHP_EOL);

        return [
            'database_path' => $databasePath,
            'manifest_path' => $manifestPath,
            'checksum_sha256' => $checksum,
            'counts' => $counts,
        ];
    }

    private function prepareOutputPath(string $path): void
    {
        $this->files->ensureDirectoryExists(dirname($path));

        if ($this->files->exists($path) && ! $this->files->delete($path)) {
            throw new RuntimeException("Unable to replace integration output: {$path}");
        }
    }

    private function createSchema(PDO $pdo): void
    {
        foreach ($this->schemaStatements() as $statement) {
            $pdo->exec($statement);
        }
    }

    /** @return list<string> */
    private function schemaStatements(): array
    {
        return [
            'CREATE TABLE metadata (key TEXT PRIMARY KEY, value TEXT NOT NULL)',
            'CREATE TABLE game_sources (source_key TEXT PRIMARY KEY, name TEXT NOT NULL, decoded_reference TEXT NOT NULL, provenance TEXT NOT NULL, notes TEXT)',
            'CREATE TABLE elements (element_key TEXT PRIMARY KEY, source_key TEXT NOT NULL REFERENCES game_sources(source_key), source_game_id INTEGER NOT NULL, name TEXT NOT NULL, slug TEXT NOT NULL, color TEXT, icon_path TEXT, provenance TEXT NOT NULL)',
            'CREATE TABLE effects (effect_key TEXT PRIMARY KEY, source_key TEXT NOT NULL REFERENCES game_sources(source_key), source_table INTEGER NOT NULL, source_game_id INTEGER NOT NULL, kind TEXT NOT NULL, name_original TEXT NOT NULL, name TEXT NOT NULL, description TEXT, duration INTEGER, parameters_json TEXT, raw_json TEXT, provenance TEXT NOT NULL)',
            'CREATE TABLE traits (trait_key TEXT PRIMARY KEY, name TEXT NOT NULL, slot_type TEXT NOT NULL, species TEXT, polarity TEXT NOT NULL, description TEXT NOT NULL, parameters_json TEXT, roll_weight INTEGER NOT NULL, is_cleanse_eligible INTEGER NOT NULL, is_active INTEGER NOT NULL, provenance TEXT NOT NULL)',
            'CREATE TABLE pets (pet_key TEXT PRIMARY KEY, source_key TEXT NOT NULL REFERENCES game_sources(source_key), source_game_id INTEGER NOT NULL, source_element_key TEXT REFERENCES elements(element_key), combat_element TEXT NOT NULL, species TEXT NOT NULL, species_trait_key TEXT REFERENCES traits(trait_key), primary_role TEXT, secondary_role TEXT, preferred_battle_format TEXT, playstyle_summary TEXT, name_original TEXT NOT NULL, name TEXT NOT NULL, slug TEXT NOT NULL, description_original TEXT, description TEXT, quality_tier INTEGER NOT NULL, classification TEXT NOT NULL, variant_code INTEGER NOT NULL, rarity_or_growth_code INTEGER NOT NULL, hp_base INTEGER NOT NULL, hp_per_level INTEGER NOT NULL, hp_offset INTEGER NOT NULL, strength_base INTEGER NOT NULL, strength_per_level INTEGER NOT NULL, strength_offset INTEGER NOT NULL, defense_base INTEGER NOT NULL, defense_per_10_levels INTEGER NOT NULL, defense_offset INTEGER NOT NULL, agility_base INTEGER NOT NULL, agility_per_10_levels INTEGER NOT NULL, agility_offset INTEGER NOT NULL, sprite_id INTEGER NOT NULL, learning_group INTEGER NOT NULL, effectiveness_class INTEGER NOT NULL, raw_json TEXT, provenance_json TEXT NOT NULL, balance_version TEXT NOT NULL)',
            'CREATE TABLE pet_stat_profiles (pet_key TEXT NOT NULL REFERENCES pets(pet_key), level INTEGER NOT NULL, stars INTEGER NOT NULL, star_multiplier_percent INTEGER NOT NULL, hp INTEGER NOT NULL, strength INTEGER NOT NULL, defense INTEGER NOT NULL, agility INTEGER NOT NULL, provenance TEXT NOT NULL, PRIMARY KEY (pet_key, level, stars))',
            'CREATE TABLE skills (skill_key TEXT PRIMARY KEY, source_key TEXT NOT NULL REFERENCES game_sources(source_key), source_game_id INTEGER NOT NULL, source_element_key TEXT REFERENCES elements(element_key), combat_element TEXT, species_affinity TEXT, combat_category TEXT, target_pattern TEXT, effect_target_pattern TEXT, battle_format TEXT, role_tags_json TEXT, effect_key TEXT REFERENCES effects(effect_key), name_original TEXT NOT NULL, name TEXT NOT NULL, slug TEXT NOT NULL, description_original TEXT, description TEXT, power INTEGER NOT NULL, pp INTEGER NOT NULL, status_chance INTEGER, tier INTEGER NOT NULL, effect_mode INTEGER NOT NULL, effect_parameter INTEGER, target_side INTEGER NOT NULL, is_active INTEGER NOT NULL, mechanics_json TEXT, raw_json TEXT, provenance_json TEXT NOT NULL, balance_version TEXT)',
            'CREATE TABLE skill_unlock_rules (source_key TEXT NOT NULL REFERENCES game_sources(source_key), learning_group INTEGER NOT NULL, level INTEGER NOT NULL, maximum_skill_tier INTEGER NOT NULL, provenance TEXT NOT NULL, PRIMARY KEY (source_key, learning_group, level))',
            'CREATE TABLE pet_skill_learnsets (pet_key TEXT NOT NULL REFERENCES pets(pet_key), skill_key TEXT NOT NULL REFERENCES skills(skill_key), grant_set TEXT NOT NULL, progression_grade TEXT NOT NULL, required_form_pet_key TEXT NOT NULL REFERENCES pets(pet_key), unlock_level INTEGER NOT NULL, source_type TEXT NOT NULL, combat_role TEXT, is_signature INTEGER NOT NULL, sort_order INTEGER NOT NULL, provenance TEXT NOT NULL, PRIMARY KEY (pet_key, skill_key))',
            'CREATE TABLE items (item_key TEXT PRIMARY KEY, source_key TEXT NOT NULL REFERENCES game_sources(source_key), source_table INTEGER NOT NULL, source_game_id INTEGER NOT NULL, canonical_item_key TEXT REFERENCES items(item_key), name_original TEXT NOT NULL, name TEXT NOT NULL, slug TEXT NOT NULL, description_original TEXT, description TEXT, category TEXT NOT NULL, mechanic_key TEXT, usage_scope TEXT, equipment_slot TEXT, frame_id INTEGER, cost INTEGER, currency_code INTEGER, effect_type INTEGER, effect_parameters_json TEXT, raw_json TEXT, is_active INTEGER NOT NULL, decision TEXT NOT NULL, provenance_json TEXT NOT NULL, balance_version TEXT)',
            'CREATE TABLE item_decisions (decision_key TEXT PRIMARY KEY, source_key TEXT NOT NULL REFERENCES game_sources(source_key), item_key TEXT REFERENCES items(item_key), original_name TEXT NOT NULL, decision TEXT NOT NULL, replacement_item_key TEXT REFERENCES items(item_key), rationale TEXT NOT NULL, provenance TEXT NOT NULL)',
            'CREATE TABLE pet_evolutions (evolution_key TEXT PRIMARY KEY, from_pet_key TEXT NOT NULL REFERENCES pets(pet_key), to_pet_key TEXT NOT NULL REFERENCES pets(pet_key), primary_item_key TEXT REFERENCES items(item_key), primary_quantity INTEGER NOT NULL, required_level INTEGER, evolution_type TEXT NOT NULL, inherits_skills INTEGER NOT NULL, cost_rank INTEGER, balance_notes TEXT, source_materials_json TEXT, topology_provenance TEXT NOT NULL, recipe_provenance TEXT NOT NULL)',
            'CREATE TABLE pet_evolution_ingredients (evolution_key TEXT NOT NULL REFERENCES pet_evolutions(evolution_key), item_key TEXT NOT NULL REFERENCES items(item_key), quantity INTEGER NOT NULL, role TEXT NOT NULL, position INTEGER NOT NULL, provenance TEXT NOT NULL, PRIMARY KEY (evolution_key, item_key, position))',
            'CREATE TABLE pet_mutation_recipes (mutation_key TEXT PRIMARY KEY, pet_key TEXT NOT NULL UNIQUE REFERENCES pets(pet_key), status TEXT NOT NULL, notes TEXT, provenance TEXT NOT NULL)',
            'CREATE TABLE pet_mutation_ingredients (mutation_key TEXT NOT NULL REFERENCES pet_mutation_recipes(mutation_key), item_key TEXT NOT NULL REFERENCES items(item_key), quantity INTEGER NOT NULL, role TEXT NOT NULL, position INTEGER NOT NULL, provenance TEXT NOT NULL, PRIMARY KEY (mutation_key, item_key, position))',
            'CREATE TABLE divine_abilities (ability_key TEXT PRIMARY KEY, pet_key TEXT NOT NULL REFERENCES pets(pet_key), code TEXT NOT NULL, name TEXT NOT NULL, activation_type TEXT NOT NULL, description TEXT NOT NULL, parameters_json TEXT, is_active INTEGER NOT NULL, provenance TEXT NOT NULL, integration_policy TEXT NOT NULL)',
            'CREATE INDEX pets_source_game_id_index ON pets(source_key, source_game_id)',
            'CREATE INDEX pets_taxonomy_index ON pets(combat_element, species)',
            'CREATE INDEX skills_source_game_id_index ON skills(source_key, source_game_id)',
            'CREATE INDEX skills_pool_index ON skills(combat_element, species_affinity, is_active)',
            'CREATE INDEX learnsets_unlock_index ON pet_skill_learnsets(pet_key, unlock_level)',
            'CREATE INDEX items_decision_index ON items(source_key, decision)',
            'CREATE INDEX evolutions_from_pet_index ON pet_evolutions(from_pet_key)',
            'CREATE INDEX mutation_pet_index ON pet_mutation_recipes(pet_key)',
        ];
    }

    /** @return array<int, string> */
    private function exportGameSources(PDO $pdo): array
    {
        $statement = $pdo->prepare('INSERT INTO game_sources VALUES (?, ?, ?, ?, ?)');
        $sourceKeys = [];

        foreach (DB::table('game_sources')->orderBy('id')->cursor() as $source) {
            $sourceKey = (string) $source->slug;
            $sourceKeys[(int) $source->id] = $sourceKey;
            $reference = match ($sourceKey) {
                'liet-hoa' => 'resources/decoded/04_resources/raw/data/script/db.mid',
                'cau-vong' => 'resources/decoded/rainbow/04_resources/raw/data/data.d',
                'vqsv4' => 'resources/decoded/vqsv4/06_analysis/game-data.json',
            };
            $notes = match ($sourceKey) {
                'liet-hoa' => 'Original baseline and primary combat rules.',
                'cau-vong' => 'Decoded reference required when porting Rainbow pets, skills, effects, sprites, or item behavior.',
                'vqsv4' => 'Decoded VQSV4 identity/assets with an approved 72-Pet unified design contract.',
            };
            $statement->execute([$sourceKey, $source->name, $reference, 'decoded_source', $notes]);
        }

        return $sourceKeys;
    }

    /** @param array<int, string> $sourceKeys
     * @return array<int, string>
     */
    private function exportElements(PDO $pdo, array $sourceKeys): array
    {
        $statement = $pdo->prepare('INSERT INTO elements VALUES (?, ?, ?, ?, ?, ?, ?, ?)');
        $elementKeys = [];

        foreach (DB::table('elements')->orderBy('id')->cursor() as $element) {
            $sourceKey = $this->requiredMapValue($sourceKeys, (int) $element->game_source_id, 'element source');
            $elementKey = $this->stableKey($sourceKey, 'ELEMENT', (int) $element->game_id, 2);
            $elementKeys[(int) $element->id] = $elementKey;
            $statement->execute([
                $elementKey, $sourceKey, $element->game_id, $element->name, $element->slug,
                $element->color, $element->icon_path, 'decoded_source',
            ]);
        }

        return $elementKeys;
    }

    /** @param array<int, string> $sourceKeys
     * @return array<int, string>
     */
    private function exportEffects(PDO $pdo, array $sourceKeys): array
    {
        $statement = $pdo->prepare('INSERT INTO effects VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)');
        $effectKeys = [];

        foreach (DB::table('effects')->orderBy('id')->cursor() as $effect) {
            $sourceKey = $this->requiredMapValue($sourceKeys, (int) $effect->game_source_id, 'effect source');
            $effectKey = $this->stableKey($sourceKey, 'EFFECT-'.$effect->source_table, (int) $effect->game_id, 2);
            $effectKeys[(int) $effect->id] = $effectKey;
            $provenance = (int) $effect->source_table === Vqsv4SkillData::UNIFIED_EFFECT_SOURCE_TABLE
                ? 'unified_design'
                : 'decoded_source';
            $statement->execute([
                $effectKey, $sourceKey, $effect->source_table, $effect->game_id, $effect->kind,
                $effect->name_original, $effect->name, $effect->description, $effect->duration,
                $this->json($effect->parameters), $this->json($effect->raw_values), $provenance,
            ]);
        }

        return $effectKeys;
    }

    /** @return array<int, string> */
    private function exportTraits(PDO $pdo): array
    {
        $statement = $pdo->prepare('INSERT INTO traits VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)');
        $traitKeys = [];

        foreach (DB::table('traits')->orderBy('id')->cursor() as $trait) {
            $traitKeys[(int) $trait->id] = (string) $trait->code;
            $statement->execute([
                $trait->code, $trait->name, $trait->slot_type, $trait->species, $trait->polarity,
                $trait->description, $this->json($trait->parameters), $trait->roll_weight,
                (int) $trait->is_cleanse_eligible, (int) $trait->is_active, 'unified_design',
            ]);
        }

        return $traitKeys;
    }

    /** @param array<int, string> $sourceKeys
     * @param  array<int, string>  $elementKeys
     * @param  array<int, string>  $traitKeys
     * @return array<int, string>
     */
    private function exportPets(PDO $pdo, array $sourceKeys, array $elementKeys, array $traitKeys): array
    {
        $petStatement = $pdo->prepare('INSERT INTO pets VALUES ('.implode(', ', array_fill(0, 38, '?')).')');
        $statStatement = $pdo->prepare('INSERT INTO pet_stat_profiles VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)');
        $petKeys = [];

        foreach (DB::table('pets')->orderBy('id')->cursor() as $pet) {
            $sourceKey = $this->requiredMapValue($sourceKeys, (int) $pet->game_source_id, 'pet source');
            $petKey = $this->stableKey($sourceKey, null, (int) $pet->game_id, 3);
            $petKeys[(int) $pet->id] = $petKey;
            $provenance = $this->json([
                'identity_name_raw' => 'decoded_source',
                'source_element' => 'decoded_source',
                'combat_element_species_roles' => 'unified_design',
                'stats' => 'unified_balance',
                'learnset' => 'generated_unified_design',
            ]);
            $petStatement->execute([
                $petKey, $sourceKey, $pet->game_id,
                $this->nullableMapValue($elementKeys, $pet->element_id), $pet->combat_element,
                $pet->species, $this->nullableMapValue($traitKeys, $pet->species_trait_id),
                $pet->primary_role, $pet->secondary_role, $pet->preferred_battle_format,
                $pet->playstyle_summary, $pet->name_original, $pet->name, $pet->slug,
                $pet->description_original, $pet->description, $pet->quality_tier, $pet->classification, $pet->variant_code,
                $pet->rarity_or_growth_code, $pet->hp_base, $pet->hp_per_level, $pet->hp_offset,
                $pet->stat_2_base, $pet->stat_2_per_level, $pet->stat_2_offset,
                $pet->stat_3_base, $pet->stat_3_per_10_levels, $pet->stat_3_offset,
                $pet->stat_4_base, $pet->stat_4_per_10_levels, $pet->stat_4_offset,
                $pet->sprite_id, $pet->learning_group, $pet->effectiveness_class,
                $this->json($pet->raw_values), $provenance, self::DATA_VERSION,
            ]);

            $model = new Pet;
            $model->setRawAttributes((array) $pet, true);

            foreach ([1, 50] as $level) {
                foreach (PetStatCalculator::STAR_MULTIPLIERS as $stars => $multiplier) {
                    $stats = $this->petStatCalculator->calculate($model, $level, $stars);
                    $statStatement->execute([
                        $petKey, $level, $stars, $multiplier, $stats['hp'], $stats['strength'],
                        $stats['defense'], $stats['agility'], 'unified_balance',
                    ]);
                }
            }
        }

        return $petKeys;
    }

    /** @param array<int, string> $sourceKeys
     * @param  array<int, string>  $elementKeys
     * @param  array<int, string>  $effectKeys
     * @return array<int, string>
     */
    private function exportSkills(PDO $pdo, array $sourceKeys, array $elementKeys, array $effectKeys): array
    {
        $statement = $pdo->prepare('INSERT INTO skills VALUES ('.implode(', ', array_fill(0, 29, '?')).')');
        $skillKeys = [];

        foreach (DB::table('skills')->orderBy('id')->cursor() as $skill) {
            $sourceKey = $this->requiredMapValue($sourceKeys, (int) $skill->game_source_id, 'skill source');
            $skillKey = $this->stableKey($sourceKey, 'SKILL', (int) $skill->game_id, 2);
            $skillKeys[(int) $skill->id] = $skillKey;
            $mechanics = null;

            if ((bool) $skill->is_active) {
                $mechanics = SkillBalance::profile($sourceKey, (int) $skill->game_id)['mechanics'];
            }

            $provenance = $this->json([
                'identity_name_raw' => 'decoded_source',
                'combat_taxonomy' => (bool) $skill->is_active ? 'unified_design' : 'source_normalized',
                'power_pp_description' => (bool) $skill->is_active ? 'unified_balance' : 'decoded_source',
                'mechanics' => (bool) $skill->is_active ? 'unified_balance' : 'not_integrated',
            ]);
            $statement->execute([
                $skillKey, $sourceKey, $skill->game_id,
                $this->nullableMapValue($elementKeys, $skill->element_id), $skill->combat_element,
                $skill->species_affinity, $skill->combat_category, $skill->target_pattern,
                $skill->effect_target_pattern, $skill->battle_format, $this->json($skill->role_tags),
                $this->nullableMapValue($effectKeys, $skill->effect_id), $skill->name_original,
                $skill->name, $skill->slug, $skill->description_original, $skill->description,
                $skill->power_percent, $skill->max_uses, $skill->status_chance, $skill->tier,
                $skill->effect_mode, $skill->effect_parameter, $skill->target_side,
                (int) $skill->is_active, $this->json($mechanics), $this->json($skill->raw_values),
                $provenance, $skill->balance_version,
            ]);
        }

        return $skillKeys;
    }

    /** @param array<int, string> $sourceKeys */
    private function exportSkillUnlockRules(PDO $pdo, array $sourceKeys): void
    {
        $statement = $pdo->prepare('INSERT INTO skill_unlock_rules VALUES (?, ?, ?, ?, ?)');

        foreach (DB::table('skill_unlock_rules')->orderBy('id')->cursor() as $rule) {
            $sourceKey = $this->requiredMapValue($sourceKeys, (int) $rule->game_source_id, 'unlock-rule source');
            $provenance = $sourceKey === 'liet-hoa' ? 'decoded_source' : 'source_normalized';
            $statement->execute([$sourceKey, $rule->learning_group, $rule->level, $rule->maximum_skill_tier, $provenance]);
        }
    }

    /** @param array<int, string> $petKeys
     * @param  array<int, string>  $skillKeys
     */
    private function exportLearnsets(PDO $pdo, array $petKeys, array $skillKeys): void
    {
        $statement = $pdo->prepare('INSERT INTO pet_skill_learnsets VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)');

        foreach (DB::table('pet_skill_learnsets')->orderBy('id')->cursor() as $learnset) {
            $statement->execute([
                $this->requiredMapValue($petKeys, (int) $learnset->pet_id, 'learnset pet'),
                $this->requiredMapValue($skillKeys, (int) $learnset->skill_id, 'learnset skill'),
                $learnset->grant_set, $learnset->progression_grade,
                $this->requiredMapValue($petKeys, (int) $learnset->required_form_pet_id, 'required learnset form'),
                $learnset->unlock_level, $learnset->source_type, $learnset->combat_role,
                (int) $learnset->is_signature, $learnset->sort_order, $learnset->provenance,
            ]);
        }
    }

    /** @param array<int, string> $sourceKeys
     * @return array<int, string>
     */
    private function exportItems(PDO $pdo, array $sourceKeys): array
    {
        $rows = DB::table('items')->orderBy('id')->get();
        $itemKeys = [];

        foreach ($rows as $item) {
            $sourceKey = $this->requiredMapValue($sourceKeys, (int) $item->game_source_id, 'item source');
            $itemKeys[(int) $item->id] = $this->stableKey($sourceKey, 'ITEM-'.$item->source_table, (int) $item->game_id, 2);
        }

        $statement = $pdo->prepare('INSERT INTO items VALUES ('.implode(', ', array_fill(0, 24, '?')).')');

        foreach ($rows as $item) {
            $sourceKey = $this->requiredMapValue($sourceKeys, (int) $item->game_source_id, 'item source');
            $decision = (bool) $item->is_active ? 'keep' : 'merge';
            $provenance = $this->json([
                'identity_name_raw' => 'decoded_source',
                'classification' => 'source_normalized',
                'mechanics_and_decision' => 'unified_design',
            ]);
            $statement->execute([
                $itemKeys[(int) $item->id], $sourceKey, $item->source_table, $item->game_id,
                null, $item->name_original,
                $item->name, $item->slug, $item->description_original, $item->description,
                $item->category, $item->mechanic_key, $item->usage_scope, $item->equipment_slot,
                $item->frame_id, $item->cost, $item->currency_code, $item->effect_type,
                $this->json($item->effect_parameters), $this->json($item->raw_values),
                (int) $item->is_active, $decision, $provenance, $item->balance_version,
            ]);
        }

        $canonicalStatement = $pdo->prepare('UPDATE items SET canonical_item_key = ? WHERE item_key = ?');

        foreach ($rows as $item) {
            if ($item->canonical_item_id === null) {
                continue;
            }

            $canonicalStatement->execute([
                $this->requiredMapValue($itemKeys, (int) $item->canonical_item_id, 'canonical item'),
                $this->requiredMapValue($itemKeys, (int) $item->id, 'item'),
            ]);
        }

        return $itemKeys;
    }

    /** @param array<int, string> $sourceKeys
     * @param  array<int, string>  $itemKeys
     */
    private function exportItemDecisions(PDO $pdo, array $sourceKeys, array $itemKeys): void
    {
        $statement = $pdo->prepare('INSERT INTO item_decisions VALUES (?, ?, ?, ?, ?, ?, ?, ?)');
        $items = DB::table('items')->orderBy('id')->get();

        foreach ($items as $item) {
            $itemKey = $this->requiredMapValue($itemKeys, (int) $item->id, 'item decision');
            $decision = (bool) $item->is_active ? 'keep' : 'merge';
            $rationale = (bool) $item->is_active
                ? 'Retained in the unified catalog.'
                : 'Source artwork/name remains traceable, but gameplay resolves to canonical_item_key.';
            $statement->execute([
                'DECISION-'.$itemKey,
                $this->requiredMapValue($sourceKeys, (int) $item->game_source_id, 'item decision source'),
                $itemKey, $item->name_original, $decision,
                $this->nullableMapValue($itemKeys, $item->canonical_item_id), $rationale, 'unified_design',
            ]);
        }

        foreach (self::EXCLUDED_RAINBOW_ITEMS as $index => $name) {
            $statement->execute([
                sprintf('DECISION-CV-EXCLUDED-%02d', $index + 1), 'cau-vong', null, $name,
                'remove', null, 'Explicitly removed from the unified item catalog.', 'excluded_by_design',
            ]);
        }
    }

    /** @param array<int, string> $petKeys
     * @param  array<int, string>  $itemKeys
     * @return array<int, string>
     */
    private function exportEvolutions(PDO $pdo, array $petKeys, array $itemKeys): array
    {
        $statement = $pdo->prepare('INSERT INTO pet_evolutions VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)');
        $evolutionKeys = [];

        foreach (DB::table('pet_evolutions')->orderBy('id')->cursor() as $evolution) {
            $fromPetKey = $this->requiredMapValue($petKeys, (int) $evolution->from_pet_id, 'evolution source pet');
            $toPetKey = $this->requiredMapValue($petKeys, (int) $evolution->to_pet_id, 'evolution target pet');
            $evolutionKey = 'EVO-'.$fromPetKey.'-'.$toPetKey;
            $evolutionKeys[(int) $evolution->id] = $evolutionKey;
            $statement->execute([
                $evolutionKey, $fromPetKey, $toPetKey,
                $this->nullableMapValue($itemKeys, $evolution->item_id), $evolution->quantity,
                $evolution->required_level, $evolution->evolution_type, (int) $evolution->inherits_skills,
                $evolution->cost_rank, $evolution->balance_notes, $this->json($evolution->materials),
                $evolution->skill_inheritance_provenance, 'unified_design',
            ]);
        }

        return $evolutionKeys;
    }

    /** @param array<int, string> $evolutionKeys
     * @param  array<int, string>  $itemKeys
     */
    private function exportEvolutionIngredients(PDO $pdo, array $evolutionKeys, array $itemKeys): void
    {
        $statement = $pdo->prepare('INSERT INTO pet_evolution_ingredients VALUES (?, ?, ?, ?, ?, ?)');

        foreach (DB::table('pet_evolution_ingredients')->orderBy('id')->cursor() as $ingredient) {
            $statement->execute([
                $this->requiredMapValue($evolutionKeys, (int) $ingredient->pet_evolution_id, 'ingredient evolution'),
                $this->requiredMapValue($itemKeys, (int) $ingredient->item_id, 'ingredient item'),
                $ingredient->quantity, $ingredient->role, $ingredient->position, 'unified_design',
            ]);
        }
    }

    /**
     * @param  array<int, string>  $petKeys
     * @return array<int, string>
     */
    private function exportMutationRecipes(PDO $pdo, array $petKeys): array
    {
        $statement = $pdo->prepare('INSERT INTO pet_mutation_recipes VALUES (?, ?, ?, ?, ?)');
        $mutationKeys = [];

        foreach (DB::table('pet_mutation_recipes')->orderBy('id')->cursor() as $recipe) {
            $petKey = $this->requiredMapValue($petKeys, (int) $recipe->pet_id, 'mutation Pet');
            $mutationKey = 'MUT-'.$petKey;
            $mutationKeys[(int) $recipe->id] = $mutationKey;
            $statement->execute([$mutationKey, $petKey, $recipe->status, $recipe->notes, 'unified_design']);
        }

        return $mutationKeys;
    }

    /**
     * @param  array<int, string>  $mutationKeys
     * @param  array<int, string>  $itemKeys
     */
    private function exportMutationIngredients(PDO $pdo, array $mutationKeys, array $itemKeys): void
    {
        $statement = $pdo->prepare('INSERT INTO pet_mutation_ingredients VALUES (?, ?, ?, ?, ?, ?)');

        foreach (DB::table('pet_mutation_ingredients')->orderBy('id')->cursor() as $ingredient) {
            $statement->execute([
                $this->requiredMapValue($mutationKeys, (int) $ingredient->pet_mutation_recipe_id, 'mutation recipe'),
                $this->requiredMapValue($itemKeys, (int) $ingredient->item_id, 'mutation ingredient'),
                $ingredient->quantity, $ingredient->role, $ingredient->position, 'unified_design',
            ]);
        }
    }

    /** @param array<int, string> $petKeys */
    private function exportDivineAbilities(PDO $pdo, array $petKeys): void
    {
        $statement = $pdo->prepare('INSERT INTO divine_abilities VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)');

        foreach (DB::table('divine_abilities')->orderBy('id')->cursor() as $ability) {
            $petKey = $this->requiredMapValue($petKeys, (int) $ability->pet_id, 'divine ability pet');
            $statement->execute([
                'DIVINE-'.$ability->code, $petKey, $ability->code, $ability->name,
                $ability->activation_type, $ability->description, $this->json($ability->parameters),
                (int) $ability->is_active, 'unified_design',
                'Optional feature flag; requires explicit approval because it is not decoded source behavior.',
            ]);
        }
    }

    private function exportMetadata(PDO $pdo): void
    {
        $statement = $pdo->prepare('INSERT INTO metadata VALUES (?, ?)');
        $metadata = [
            'schema_version' => self::SCHEMA_VERSION,
            'data_version' => self::DATA_VERSION,
            'skill_balance_version' => SkillBalance::VERSION,
            'pet_stat_profile_version' => Vqsv4PetDesignRevision::VERSION,
            'learnset_version' => UnifiedPetLearnsetCatalog::VERSION,
            'item_balance_version' => ItemBalance::VERSION,
            'generated_at' => now()->toIso8601String(),
            'runtime_policy' => 'reference_only_do_not_connect_game_runtime_to_web_database',
            'authoritative_order' => 'original_binary_then_decompiled_behavior_then_snapshot_unified_contract_then_markdown',
            'physical_trait_policy' => 'one_equal_weight_random_trait_from_the_19_active_traits_where_slot_type_is_physical',
            'species_trait_policy' => 'one_fixed_species_trait_from_pets.species_trait_key',
            'mutation_policy' => 'same_pet_variant_recipe; never represented as a self-loop evolution edge',
            'learnset_policy' => 'pet_skill_learnsets_v3_and_inherits_skills_are_authoritative; skill_unlock_rules_is_legacy_reference',
            'rainbow_energy_policy' => 'source_reference_only; unified battle uses PP',
            'divine_policy' => 'optional_unified_design_not_source_proven',
        ];

        foreach ($metadata as $key => $value) {
            $statement->execute([$key, $value]);
        }
    }

    /** @return array<string, int> */
    private function snapshotCounts(PDO $pdo): array
    {
        $tables = [
            'game_sources', 'elements', 'effects', 'traits', 'pets', 'pet_stat_profiles',
            'skills', 'skill_unlock_rules', 'pet_skill_learnsets', 'items', 'item_decisions',
            'pet_evolutions', 'pet_evolution_ingredients', 'pet_mutation_recipes',
            'pet_mutation_ingredients', 'divine_abilities',
        ];
        $counts = [];

        foreach ($tables as $table) {
            $counts[$table] = (int) $pdo->query("SELECT COUNT(*) FROM {$table}")->fetchColumn();
        }

        $counts['active_skills'] = (int) $pdo->query('SELECT COUNT(*) FROM skills WHERE is_active = 1')->fetchColumn();
        $counts['active_items'] = (int) $pdo->query('SELECT COUNT(*) FROM items WHERE is_active = 1')->fetchColumn();

        return $counts;
    }

    private function stableKey(string $sourceKey, ?string $domain, int $gameId, int $padding): string
    {
        $prefix = match ($sourceKey) {
            'liet-hoa' => 'LH',
            'cau-vong' => 'CV',
            'vqsv4' => 'V4',
            default => throw new InvalidArgumentException("Unknown game source: {$sourceKey}"),
        };
        $segments = array_filter([$prefix, $domain, str_pad((string) $gameId, $padding, '0', STR_PAD_LEFT)]);

        return implode('-', $segments);
    }

    /** @param array<int, string> $map */
    private function requiredMapValue(array $map, int $id, string $context): string
    {
        return $map[$id] ?? throw new RuntimeException("Missing {$context} mapping for database ID {$id}.");
    }

    /** @param array<int, string> $map */
    private function nullableMapValue(array $map, mixed $id): ?string
    {
        if ($id === null) {
            return null;
        }

        return $map[(int) $id] ?? null;
    }

    private function json(mixed $value): ?string
    {
        if ($value === null || $value === '') {
            return null;
        }

        if (is_string($value)) {
            json_decode($value, true);

            if (json_last_error() === JSON_ERROR_NONE) {
                return $value;
            }
        }

        $encoded = json_encode($value, JSON_UNESCAPED_SLASHES | JSON_UNESCAPED_UNICODE);

        if ($encoded === false) {
            throw new RuntimeException('Unable to encode snapshot JSON value.');
        }

        return $encoded;
    }
}
