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
        Schema::table('pets', function (Blueprint $table) {
            $table->text('description_original')->nullable()->after('slug');
            $table->text('description')->nullable()->after('description_original');
            $table->integer('energy_base')->nullable()->after('hp_offset');
            $table->integer('energy_per_10_levels')->nullable()->after('energy_base');
        });

        Schema::table('skills', function (Blueprint $table) {
            $table->foreignId('element_id')->nullable()->change();
            $table->unsignedSmallInteger('energy_cost')->nullable()->after('power_percent');
            $table->unsignedTinyInteger('status_chance')->nullable()->after('energy_cost');
        });

        Schema::table('pet_evolutions', function (Blueprint $table) {
            $table->json('materials')->nullable()->after('quantity');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('pet_evolutions', function (Blueprint $table) {
            $table->dropColumn('materials');
        });

        Schema::table('skills', function (Blueprint $table) {
            $table->dropColumn(['energy_cost', 'status_chance']);
            $table->foreignId('element_id')->nullable(false)->change();
        });

        Schema::table('pets', function (Blueprint $table) {
            $table->dropColumn(['description_original', 'description', 'energy_base', 'energy_per_10_levels']);
        });
    }
};
