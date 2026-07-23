<?php

use Illuminate\Support\Facades\Schema;

test('community and wiki tables have the expected schema', function () {
    expect(Schema::hasColumns('users', [
        'username',
        'avatar_path',
        'role',
        'status',
        'last_seen_at',
    ]))->toBeTrue()
        ->and(Schema::hasColumns('elements', [
            'game_id',
            'name',
            'slug',
            'color',
            'icon_path',
        ]))->toBeTrue()
        ->and(Schema::hasColumns('pets', [
            'game_id',
            'element_id',
            'combat_element',
            'species',
            'name_original',
            'name',
            'slug',
            'sprite_id',
            'learning_group',
            'raw_values',
        ]))->toBeTrue()
        ->and(Schema::hasColumns('skills', [
            'game_id',
            'element_id',
            'effect_id',
            'power_percent',
            'tier',
            'max_uses',
            'effect_mode',
            'target_side',
        ]))->toBeTrue()
        ->and(Schema::hasColumns('effects', [
            'source_table',
            'game_id',
            'kind',
            'duration',
            'parameters',
        ]))->toBeTrue()
        ->and(Schema::hasColumns('items', [
            'source_table',
            'game_id',
            'category',
            'frame_id',
            'effect_parameters',
        ]))->toBeTrue()
        ->and(Schema::hasColumns('pet_evolutions', [
            'from_pet_id',
            'to_pet_id',
            'item_id',
            'quantity',
            'evolution_type',
        ]))->toBeTrue()
        ->and(Schema::hasColumns('skill_unlock_rules', [
            'learning_group',
            'level',
            'maximum_skill_tier',
        ]))->toBeTrue()
        ->and(Schema::hasColumns('forum_categories', [
            'parent_id',
            'name',
            'slug',
            'position',
            'is_locked',
        ]))->toBeTrue()
        ->and(Schema::hasColumns('forum_threads', [
            'category_id',
            'author_id',
            'title',
            'slug',
            'status',
            'posts_count',
            'views_count',
            'deleted_at',
        ]))->toBeTrue()
        ->and(Schema::hasColumns('forum_posts', [
            'thread_id',
            'author_id',
            'quoted_post_id',
            'body_markdown',
            'status',
            'edited_at',
            'deleted_at',
        ]))->toBeTrue()
        ->and(Schema::hasColumns('notifications', [
            'id',
            'type',
            'notifiable_type',
            'notifiable_id',
            'data',
            'read_at',
        ]))->toBeTrue();
});
