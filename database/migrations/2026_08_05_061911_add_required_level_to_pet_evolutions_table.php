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
            $table->unsignedTinyInteger('required_level')->nullable()->after('quantity');
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('pet_evolutions', function (Blueprint $table) {
            $table->dropColumn('required_level');
        });
    }
};
