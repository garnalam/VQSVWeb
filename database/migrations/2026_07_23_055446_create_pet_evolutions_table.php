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
        Schema::create('pet_evolutions', function (Blueprint $table) {
            $table->id();
            $table->foreignId('from_pet_id')->constrained('pets')->cascadeOnDelete();
            $table->foreignId('to_pet_id')->constrained('pets')->cascadeOnDelete();
            $table->foreignId('item_id')->constrained()->restrictOnDelete();
            $table->unsignedSmallInteger('quantity')->default(1);
            $table->string('evolution_type', 30)->default('evolution');
            $table->timestamps();

            $table->unique(['from_pet_id', 'to_pet_id']);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('pet_evolutions');
    }
};
