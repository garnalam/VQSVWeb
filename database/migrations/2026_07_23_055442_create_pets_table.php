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
        Schema::create('pets', function (Blueprint $table) {
            $table->id();
            $table->unsignedTinyInteger('game_id')->unique();
            $table->foreignId('element_id')->constrained()->restrictOnDelete();
            $table->string('name_original');
            $table->string('name');
            $table->string('slug')->unique();
            $table->smallInteger('variant_code');
            $table->unsignedTinyInteger('quality_tier');
            $table->smallInteger('rarity_or_growth_code');
            $table->integer('hp_base');
            $table->integer('hp_per_level');
            $table->integer('hp_offset');
            $table->integer('stat_2_base');
            $table->integer('stat_2_per_level');
            $table->integer('stat_2_offset');
            $table->integer('stat_3_base');
            $table->integer('stat_3_per_10_levels');
            $table->integer('stat_3_offset');
            $table->integer('stat_4_base');
            $table->integer('stat_4_per_10_levels');
            $table->integer('stat_4_offset');
            $table->unsignedSmallInteger('sprite_id');
            $table->unsignedTinyInteger('learning_group');
            $table->smallInteger('effectiveness_class');
            $table->json('raw_values')->nullable();
            $table->timestamps();

            $table->index(['element_id', 'learning_group']);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pets');
    }
};
