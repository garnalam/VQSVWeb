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
            $table->unsignedTinyInteger('cost_rank')->default(2)->after('evolution_type');
            $table->text('balance_notes')->nullable()->after('cost_rank');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('pet_evolutions', function (Blueprint $table) {
            $table->dropColumn(['cost_rank', 'balance_notes']);
        });
    }
};
