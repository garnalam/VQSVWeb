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
        Schema::create('skills', function (Blueprint $table) {
            $table->id();
            $table->unsignedTinyInteger('game_id')->unique();
            $table->foreignId('element_id')->constrained()->restrictOnDelete();
            $table->foreignId('effect_id')->nullable()->constrained()->nullOnDelete();
            $table->string('name_original');
            $table->string('name');
            $table->string('slug')->unique();
            $table->text('description_original');
            $table->text('description')->nullable();
            $table->unsignedSmallInteger('power_percent');
            $table->unsignedTinyInteger('tier');
            $table->unsignedTinyInteger('max_uses');
            $table->unsignedTinyInteger('effect_mode');
            $table->smallInteger('effect_parameter')->nullable();
            $table->unsignedTinyInteger('target_side');
            $table->json('raw_values')->nullable();
            $table->timestamps();

            $table->index(['element_id', 'tier']);
            $table->index(['effect_mode', 'target_side']);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('skills');
    }
};
