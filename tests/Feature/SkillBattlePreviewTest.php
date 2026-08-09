<?php

use App\Models\GameSource;
use App\Models\Pet;
use App\Models\Skill;
use App\Support\SkillBattlePreview;
use Database\Seeders\DatabaseSeeder;
use Illuminate\Support\Collection;
use Inertia\Testing\AssertableInertia as Assert;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('skill dossier exposes a deterministic Liệt Hỏa battle preview', function () {
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $skill = Skill::query()
        ->whereBelongsTo($lietHoa)
        ->where('game_id', 35)
        ->firstOrFail();

    $this->get(route('wiki.skills.show', $skill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('wiki/skills/show')
            ->where('skill.battle_preview.ruleset', 'liet-hoa-unified-v1')
            ->where('skill.battle_preview.level', 50)
            ->where('skill.battle_preview.damage.element_multiplier', 1)
            ->where('skill.battle_preview.effect_rule.key', 'patience')
            ->where('skill.battle_preview.effect_rule.follow_up.kind', 'counter_reduced')
            ->where('skill.battle_preview.effect_rule.follow_up.value', 50)
            ->where('skill.battle_preview.effect_rule.provenance', 'decoded')
            ->where('skill.battle_preview.default_caster_id', fn (?int $id): bool => $id !== null)
            ->where('skill.battle_preview.opponent.game_source.slug', 'liet-hoa')
            ->where('skill.battle_preview.caster_options', fn (Collection $pets): bool => $pets->isNotEmpty()
                && $pets->every(fn (array $pet): bool => $pet['stats']['hp'] > 0
                    && $pet['stats']['strength'] > 0
                    && $pet['stats']['defense'] > 0
                    && $pet['stats']['agility'] > 0))
            ->where('skill.battle_preview.opponent.stats.hp', fn (int $hp): bool => $hp > 0));
});

test('converted Rainbow statuses explain their Liệt Hỏa follow-up behavior', function () {
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $corrosionSkill = Skill::query()
        ->whereBelongsTo($rainbow)
        ->where('game_id', 0)
        ->firstOrFail();
    $healingSkill = Skill::query()
        ->whereBelongsTo($rainbow)
        ->where('game_id', 27)
        ->firstOrFail();

    $this->get(route('wiki.skills.show', $corrosionSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.effect_rule.key', 'corrosion')
            ->where('skill.battle_preview.effect_rule.target', 'opponent')
            ->where('skill.battle_preview.effect_rule.status_chance', 100)
            ->where('skill.battle_preview.effect_rule.follow_up.kind', 'escalating_damage')
            ->where('skill.battle_preview.effect_rule.follow_up.value', 3)
            ->where('skill.battle_preview.effect_rule.provenance', 'unified'));

    $this->get(route('wiki.skills.show', $healingSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.effect_rule.key', 'direct_heal')
            ->where('skill.battle_preview.effect_rule.target', 'caster')
            ->where('skill.battle_preview.effect_rule.follow_up.kind', 'direct_heal')
            ->where('skill.battle_preview.effect_rule.follow_up.value', 35));
});

test('control previews expose their single battle soft penalties', function () {
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $entangledSkill = Skill::query()->whereBelongsTo($lietHoa)->where('game_id', 12)->firstOrFail();
    $charmedSkill = Skill::query()->whereBelongsTo($rainbow)->where('game_id', 20)->firstOrFail();
    $boundSkill = Skill::query()->whereBelongsTo($rainbow)->where('game_id', 11)->firstOrFail();

    $this->get(route('wiki.skills.show', $entangledSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.effect_rule.key', 'entangled')
            ->where('skill.battle_preview.effect_rule.follow_up.kind', 'defense_break')
            ->where('skill.battle_preview.effect_rule.stat_changes.0.stat', 'defense')
            ->where('skill.battle_preview.effect_rule.stat_changes.0.value', 10));

    $this->get(route('wiki.skills.show', $charmedSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.effect_rule.key', 'charmed')
            ->where('skill.battle_preview.effect_rule.follow_up.kind', 'counter_weakened')
            ->where('skill.battle_preview.effect_rule.stat_changes.0.stat', 'damage')
            ->where('skill.battle_preview.effect_rule.stat_changes.0.value', 15));

    $this->get(route('wiki.skills.show', $boundSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.effect_rule.key', 'bound')
            ->where('skill.battle_preview.effect_rule.follow_up.kind', 'action_delayed')
            ->where('skill.battle_preview.effect_rule.stat_changes.0.stat', 'agility')
            ->where('skill.battle_preview.effect_rule.stat_changes.0.value', 15));
});

test('earth regeneration previews expose the balanced five percent healing tick', function () {
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $regenerationSkill = Skill::query()
        ->whereBelongsTo($lietHoa)
        ->where('game_id', 24)
        ->firstOrFail();

    $this->get(route('wiki.skills.show', $regenerationSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.effect_rule.key', 'regeneration')
            ->where('skill.battle_preview.effect_rule.follow_up.kind', 'heal_tick')
            ->where('skill.battle_preview.effect_rule.follow_up.value', 5)
            ->where('skill.battle_preview.effect_rule.follow_up.basis', 'max_hp'));
});

test('skill preview only labels decoded source animations as original', function () {
    $lietHoa = GameSource::query()->where('slug', 'liet-hoa')->firstOrFail();
    $rainbow = GameSource::query()->where('slug', 'cau-vong')->firstOrFail();
    $renderedLietHoaSkill = Skill::query()->whereBelongsTo($lietHoa)->where('game_id', 0)->firstOrFail();
    $proceduralLietHoaSkill = Skill::query()->whereBelongsTo($lietHoa)->where('game_id', 35)->firstOrFail();
    $renderedRainbowSkill = Skill::query()->whereBelongsTo($rainbow)->where('game_id', 0)->firstOrFail();
    $rainbowHealingSkill = Skill::query()->whereBelongsTo($rainbow)->where('game_id', 27)->firstOrFail();
    $passiveRainbowSkill = Skill::query()->whereBelongsTo($rainbow)->where('game_id', 33)->firstOrFail();

    $this->get(route('wiki.skills.show', $renderedLietHoaSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.source_animation.provenance', 'decoded_original')
            ->where('skill.battle_preview.source_animation.events.0.render_status', 'decoded_original')
            ->where('skill.battle_preview.source_animation.events.0.url', '/assets/game/skill-animations/action-20-0.webp'));

    $this->get(route('wiki.skills.show', $proceduralLietHoaSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.source_animation.provenance', 'decoded_original')
            ->where('skill.battle_preview.source_animation.events.0.render_status', 'decoded_original')
            ->where('skill.battle_preview.source_animation.events.0.kind', 'procedural_pet_effect')
            ->where('skill.battle_preview.source_animation.events.0.runtime_renderer', 'a.a.b.canvas.v1')
            ->missing('skill.battle_preview.source_animation.events.0.url'));

    $this->get(route('wiki.skills.show', $renderedRainbowSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.source_animation.provenance', 'unified_scaled_source')
            ->where('skill.battle_preview.source_animation.events.0.url', '/assets/game/cau-vong/skill-animations/0.webp')
            ->where('skill.battle_preview.source_animation.events.0.timeline_mode', 'concurrent_caster_action')
            ->where('skill.battle_preview.source_animation.events.0.anchor', 'opponent'));

    $this->get(route('wiki.skills.show', $rainbowHealingSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.source_animation.provenance', 'unified_scaled_source')
            ->where('skill.battle_preview.source_animation.events.0.url', '/assets/game/cau-vong/skill-animations/27.webp')
            ->where('skill.battle_preview.source_animation.events.0.anchor', 'caster'));

    $this->get(route('wiki.skills.show', $passiveRainbowSkill))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->where('skill.battle_preview.source_animation.provenance', 'source_no_visual')
            ->has('skill.battle_preview.source_animation.events', 0));
});

test('decoded animation manifests cover both original game sources', function () {
    $gameManifest = json_decode(
        file_get_contents(public_path('assets/game/manifest.json')),
        true,
        flags: JSON_THROW_ON_ERROR,
    );
    $lietHoaManifest = json_decode(
        file_get_contents(public_path('assets/game/skill-animations/manifest.json')),
        true,
        flags: JSON_THROW_ON_ERROR,
    );
    $rainbowManifest = json_decode(
        file_get_contents(public_path('assets/game/cau-vong/skill-animations/manifest.json')),
        true,
        flags: JSON_THROW_ON_ERROR,
    );

    expect($lietHoaManifest['skills'])->toHaveCount(70)
        ->and($lietHoaManifest['rendered_actions'])->toHaveCount(67)
        ->and($lietHoaManifest['procedural_renderer']['runtime'])->toBe('a.a.b.canvas.v1')
        ->and($lietHoaManifest['procedural_renderer']['supported_types'])->toBe([1, 7, 8, 9, 11, 12, 13, 14, 15])
        ->and($lietHoaManifest['procedural_renderer']['textures'])->toHaveCount(4)
        ->and($rainbowManifest['controller']['class'])->toBe('VQSV4 decoded battle renderer')
        ->and($rainbowManifest['controller']['method'])->toBe('artwork group + animation slot')
        ->and($rainbowManifest['controller']['active_skill_ids'])->toBe(range(0, 32))
        ->and($rainbowManifest['animations'])->toHaveCount(33)
        ->and(array_map('intval', array_keys($rainbowManifest['animations'])))->toBe(range(0, 32));

    expect($gameManifest['pet_effect_snapshots'])->toHaveCount(100);

    expect(collect($gameManifest['pet_effect_snapshots'])->sum(fn (array $snapshots): int => count($snapshots)))->toBe(498);

    foreach ($gameManifest['pet_effect_snapshots'] as $snapshots) {
        expect($snapshots)->toHaveKey('0');

        foreach ($snapshots as $snapshot) {
            expect($snapshot)->toHaveKeys(['url', 'origin_x', 'origin_y', 'width', 'height'])
                ->and(public_path($snapshot['url']))->toBeFile()
                ->and($snapshot['width'])->toBeGreaterThan(0)
                ->and($snapshot['height'])->toBeGreaterThan(0);
        }
    }

    foreach ($lietHoaManifest['rendered_actions'] as $animation) {
        expect(public_path($animation['url']))->toBeFile();
    }

    foreach ($lietHoaManifest['procedural_renderer']['textures'] as $textureUrl) {
        expect(public_path($textureUrl))->toBeFile();
    }

    $proceduralEvents = collect($lietHoaManifest['skills'])
        ->flatMap(fn (array $skill): array => $skill['events'])
        ->where('kind', 'procedural_pet_effect');

    expect($proceduralEvents)->toHaveCount(56)
        ->and($proceduralEvents->pluck('render_status')->unique()->all())->toBe(['decoded_original'])
        ->and($proceduralEvents->pluck('runtime_renderer')->unique()->all())->toBe(['a.a.b.canvas.v1'])
        ->and($proceduralEvents->where('anchor', 'opponent')->pluck('snapshot_composition_state')->unique()->all())->toBe([0])
        ->and($proceduralEvents->where('anchor', 'caster')->pluck('snapshot_composition_state')->unique()->all())->toBe([1]);

    foreach ($rainbowManifest['animations'] as $animation) {
        expect(public_path($animation['url']))->toBeFile()
            ->and($animation['timeline_mode'])->toBe('concurrent_caster_action')
            ->and($animation['frame_durations_ms'])->toHaveCount($animation['frame_count'])
            ->and($animation)->toHaveKeys([
                'source_controller',
                'anchor',
                'anchor_x',
                'anchor_y',
                'origin_x',
                'origin_y',
                'frame_width',
                'frame_height',
                'global_transform',
            ]);
    }
});

test('every active skill can build a preview with a real caster and mapped effect rule', function () {
    $allPets = Pet::query()
        ->with('gameSource:id,name,slug,asset_key,color')
        ->get()
        ->keyBy('id');
    $skills = Skill::query()
        ->with(['effect', 'gameSource', 'learnsetEntries'])
        ->where('is_active', true)
        ->get();
    $previewBuilder = app(SkillBattlePreview::class);

    expect($skills)->toHaveCount(136);

    foreach ($skills as $skill) {
        $entry = $skill->learnsetEntries->first();

        expect($entry)->not->toBeNull();

        $preview = $previewBuilder->build(
            $skill,
            collect([[
                'id' => $entry->pet_id,
                'unlock_level' => $entry->unlock_level,
                'is_inherited' => false,
            ]]),
            $allPets,
            $skill->status_chance ?? ($skill->effect === null ? null : 100),
        );

        expect($preview['default_caster_id'])->toBe($entry->pet_id)
            ->and($preview['opponent'])->not->toBeNull()
            ->and($preview['source_animation']['provenance'])->not->toBe('unavailable')
            ->and($preview['effect_rule']['key'])->not->toBe('generic_status');
    }
});
