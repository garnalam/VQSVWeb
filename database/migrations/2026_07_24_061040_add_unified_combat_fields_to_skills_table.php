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
        Schema::table('skills', function (Blueprint $table) {
            $table->string('combat_element', 20)->nullable()->after('element_id')->index();
            $table->string('species_affinity', 20)->nullable()->after('combat_element')->index();
            $table->string('combat_category', 30)->default('damage')->after('species_affinity')->index();
            $table->string('target_pattern', 30)->default('single_enemy')->after('combat_category')->index();
            $table->string('effect_target_pattern', 30)->nullable()->after('target_pattern');
            $table->string('battle_format', 20)->default('any')->after('effect_target_pattern')->index();
            $table->json('role_tags')->nullable()->after('battle_format');
            $table->string('balance_version', 20)->nullable()->after('role_tags');
            $table->boolean('is_active')->default(true)->after('balance_version')->index();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('skills', function (Blueprint $table) {
            $table->dropColumn([
                'combat_element',
                'species_affinity',
                'combat_category',
                'target_pattern',
                'effect_target_pattern',
                'battle_format',
                'role_tags',
                'balance_version',
                'is_active',
            ]);
        });
    }
};
