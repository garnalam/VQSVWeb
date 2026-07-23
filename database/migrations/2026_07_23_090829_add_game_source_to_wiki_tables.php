<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        Schema::table('elements', function (Blueprint $table) {
            $table->dropUnique(['game_id']);
            $table->dropUnique(['slug']);
            $table->foreignId('game_source_id')->default(1)->after('id')->constrained()->restrictOnDelete();
            $table->unique(['game_source_id', 'game_id']);
            $table->unique(['game_source_id', 'slug']);
        });

        Schema::table('effects', function (Blueprint $table) {
            $table->dropUnique(['source_table', 'game_id']);
            $table->foreignId('game_source_id')->default(1)->after('id')->constrained()->restrictOnDelete();
            $table->unique(['game_source_id', 'source_table', 'game_id']);
        });

        Schema::table('pets', function (Blueprint $table) {
            $table->dropUnique(['game_id']);
            $table->dropUnique(['slug']);
            $table->foreignId('game_source_id')->default(1)->after('id')->constrained()->restrictOnDelete();
            $table->unique(['game_source_id', 'game_id']);
            $table->unique(['game_source_id', 'slug']);
        });

        Schema::table('skills', function (Blueprint $table) {
            $table->dropUnique(['game_id']);
            $table->dropUnique(['slug']);
            $table->foreignId('game_source_id')->default(1)->after('id')->constrained()->restrictOnDelete();
            $table->unique(['game_source_id', 'game_id']);
            $table->unique(['game_source_id', 'slug']);
        });

        Schema::table('items', function (Blueprint $table) {
            $table->dropUnique(['source_table', 'game_id']);
            $table->dropUnique(['slug']);
            $table->foreignId('game_source_id')->default(1)->after('id')->constrained()->restrictOnDelete();
            $table->unique(['game_source_id', 'source_table', 'game_id']);
            $table->unique(['game_source_id', 'slug']);
        });

        Schema::table('skill_unlock_rules', function (Blueprint $table) {
            $table->dropUnique(['learning_group', 'level']);
            $table->foreignId('game_source_id')->default(1)->after('id')->constrained()->restrictOnDelete();
            $table->unique(['game_source_id', 'learning_group', 'level']);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('skill_unlock_rules', function (Blueprint $table) {
            $table->dropUnique(['game_source_id', 'learning_group', 'level']);
            $table->dropConstrainedForeignId('game_source_id');
            $table->unique(['learning_group', 'level']);
        });

        Schema::table('items', function (Blueprint $table) {
            $table->dropUnique(['game_source_id', 'source_table', 'game_id']);
            $table->dropUnique(['game_source_id', 'slug']);
            $table->dropConstrainedForeignId('game_source_id');
            $table->unique(['source_table', 'game_id']);
            $table->unique('slug');
        });

        Schema::table('skills', function (Blueprint $table) {
            $table->dropUnique(['game_source_id', 'game_id']);
            $table->dropUnique(['game_source_id', 'slug']);
            $table->dropConstrainedForeignId('game_source_id');
            $table->unique('game_id');
            $table->unique('slug');
        });

        Schema::table('pets', function (Blueprint $table) {
            $table->dropUnique(['game_source_id', 'game_id']);
            $table->dropUnique(['game_source_id', 'slug']);
            $table->dropConstrainedForeignId('game_source_id');
            $table->unique('game_id');
            $table->unique('slug');
        });

        Schema::table('effects', function (Blueprint $table) {
            $table->dropUnique(['game_source_id', 'source_table', 'game_id']);
            $table->dropConstrainedForeignId('game_source_id');
            $table->unique(['source_table', 'game_id']);
        });

        Schema::table('elements', function (Blueprint $table) {
            $table->dropUnique(['game_source_id', 'game_id']);
            $table->dropUnique(['game_source_id', 'slug']);
            $table->dropConstrainedForeignId('game_source_id');
            $table->unique('game_id');
            $table->unique('slug');
        });
    }
};
