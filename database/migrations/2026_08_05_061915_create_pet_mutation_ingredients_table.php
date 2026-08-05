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
        Schema::create('pet_mutation_ingredients', function (Blueprint $table) {
            $table->id();
            $table->foreignId('pet_mutation_recipe_id')->constrained()->cascadeOnDelete();
            $table->foreignId('item_id')->constrained()->restrictOnDelete();
            $table->unsignedSmallInteger('quantity');
            $table->string('role', 30);
            $table->unsignedTinyInteger('position');
            $table->timestamps();

            $table->unique(['pet_mutation_recipe_id', 'item_id', 'position'], 'pet_mutation_ingredient_unique');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pet_mutation_ingredients');
    }
};
