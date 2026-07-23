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
        Schema::create('items', function (Blueprint $table) {
            $table->id();
            $table->unsignedTinyInteger('source_table');
            $table->unsignedSmallInteger('game_id');
            $table->string('name_original');
            $table->string('name');
            $table->string('slug')->unique();
            $table->text('description_original')->nullable();
            $table->text('description')->nullable();
            $table->string('category', 50)->index();
            $table->unsignedSmallInteger('frame_id')->nullable();
            $table->unsignedInteger('cost')->nullable();
            $table->unsignedTinyInteger('currency_code')->nullable();
            $table->unsignedTinyInteger('effect_type')->nullable();
            $table->json('effect_parameters')->nullable();
            $table->json('raw_values')->nullable();
            $table->timestamps();

            $table->unique(['source_table', 'game_id']);
            $table->index(['source_table', 'category']);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('items');
    }
};
