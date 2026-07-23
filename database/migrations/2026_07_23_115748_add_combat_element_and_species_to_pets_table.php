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
            $table->string('combat_element', 20)->nullable()->after('element_id')->index();
            $table->string('species', 20)->nullable()->after('combat_element')->index();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('pets', function (Blueprint $table) {
            $table->dropIndex(['combat_element']);
            $table->dropIndex(['species']);
            $table->dropColumn(['combat_element', 'species']);
        });
    }
};
