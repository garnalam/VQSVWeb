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
        Schema::create('pet_skill_learnsets', function (Blueprint $table) {
            $table->id();
            $table->foreignId('pet_id')->constrained()->cascadeOnDelete();
            $table->foreignId('skill_id')->constrained()->cascadeOnDelete();
            $table->unsignedTinyInteger('unlock_level');
            $table->string('source_type', 20);
            $table->string('combat_role', 30);
            $table->boolean('is_signature')->default(false);
            $table->unsignedSmallInteger('sort_order');
            $table->timestamps();

            $table->unique(['pet_id', 'skill_id']);
            $table->index(['pet_id', 'unlock_level', 'sort_order']);
            $table->index(['skill_id', 'unlock_level']);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pet_skill_learnsets');
    }
};
