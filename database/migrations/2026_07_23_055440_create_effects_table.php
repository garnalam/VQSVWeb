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
        Schema::create('effects', function (Blueprint $table) {
            $table->id();
            $table->unsignedTinyInteger('source_table');
            $table->unsignedTinyInteger('game_id');
            $table->string('kind', 30)->index();
            $table->string('name_original');
            $table->string('name');
            $table->text('description')->nullable();
            $table->unsignedTinyInteger('duration')->nullable();
            $table->json('parameters')->nullable();
            $table->json('raw_values')->nullable();
            $table->timestamps();

            $table->unique(['source_table', 'game_id']);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('effects');
    }
};
