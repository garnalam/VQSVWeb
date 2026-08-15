<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     */
    public function up(): void
    {
        if (! Schema::hasColumn('pet_skill_learnsets', 'grant_set')) {
            Schema::table('pet_skill_learnsets', function (Blueprint $table) {
                $table->string('grant_set', 40)->nullable()->after('skill_id');
            });
        }

        if (! Schema::hasColumn('pet_skill_learnsets', 'progression_grade')) {
            Schema::table('pet_skill_learnsets', function (Blueprint $table) {
                $table->string('progression_grade', 20)->nullable()->after('grant_set');
            });
        }

        if (! Schema::hasColumn('pet_skill_learnsets', 'required_form_pet_id')) {
            Schema::table('pet_skill_learnsets', function (Blueprint $table) {
                $table->unsignedBigInteger('required_form_pet_id')->nullable()->after('progression_grade');
            });
        }

        if (! Schema::hasColumn('pet_skill_learnsets', 'provenance')) {
            Schema::table('pet_skill_learnsets', function (Blueprint $table) {
                $table->string('provenance', 80)->nullable()->after('sort_order');
            });
        }

        DB::table('pet_skill_learnsets')->update([
            'grant_set' => 'legacy-migration',
            'progression_grade' => 'basic',
            'required_form_pet_id' => DB::raw('pet_id'),
            'provenance' => 'legacy_migration_placeholder',
        ]);

        Schema::table('pet_skill_learnsets', function (Blueprint $table) {
            $table->foreign('required_form_pet_id')
                ->references('id')
                ->on('pets')
                ->cascadeOnDelete();
        });

        Schema::table('pet_skill_learnsets', function (Blueprint $table) {
            $table->string('grant_set', 40)->nullable(false)->change();
            $table->string('progression_grade', 20)->nullable(false)->change();
            $table->unsignedBigInteger('required_form_pet_id')->nullable(false)->change();
            $table->string('provenance', 80)->nullable(false)->change();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('pet_skill_learnsets', function (Blueprint $table) {
            $table->dropConstrainedForeignId('required_form_pet_id');
            $table->dropColumn(['grant_set', 'progression_grade', 'provenance']);
        });
    }
};
