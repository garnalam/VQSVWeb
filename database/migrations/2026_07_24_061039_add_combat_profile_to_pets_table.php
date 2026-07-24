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
            $table->string('primary_role', 30)->nullable()->after('species_trait_id')->index();
            $table->string('secondary_role', 30)->nullable()->after('primary_role');
            $table->string('preferred_battle_format', 20)->default('any')->after('secondary_role')->index();
            $table->text('playstyle_summary')->nullable()->after('preferred_battle_format');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('pets', function (Blueprint $table) {
            $table->dropColumn([
                'primary_role',
                'secondary_role',
                'preferred_battle_format',
                'playstyle_summary',
            ]);
        });
    }
};
