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
        Schema::create('pet_evolution_ingredients', function (Blueprint $table) {
            $table->id();
            $table->foreignId('pet_evolution_id')->constrained()->cascadeOnDelete();
            $table->foreignId('item_id')->constrained()->restrictOnDelete();
            $table->unsignedSmallInteger('quantity')->default(1);
            $table->string('role', 20)->index();
            $table->unsignedTinyInteger('position')->default(0);
            $table->timestamps();

            $table->unique(['pet_evolution_id', 'item_id']);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pet_evolution_ingredients');
    }
};
