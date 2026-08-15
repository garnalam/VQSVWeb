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
        Schema::table('pet_evolutions', function (Blueprint $table) {
            $table->boolean('inherits_skills')->default(true)->after('evolution_type');
            $table->string('skill_inheritance_provenance', 40)->nullable()->after('inherits_skills');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('pet_evolutions', function (Blueprint $table) {
            $table->dropColumn(['inherits_skills', 'skill_inheritance_provenance']);
        });
    }
};
