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
        Schema::table('items', function (Blueprint $table) {
            $table->foreignId('canonical_item_id')
                ->nullable()
                ->after('game_id')
                ->constrained('items')
                ->nullOnDelete();
            $table->string('mechanic_key', 50)->nullable()->after('category')->index();
            $table->string('usage_scope', 30)->nullable()->after('mechanic_key')->index();
            $table->string('equipment_slot', 30)->nullable()->after('usage_scope')->index();
            $table->string('balance_version', 30)->nullable()->after('equipment_slot')->index();
            $table->boolean('is_active')->default(true)->after('balance_version');
            $table->index(['is_active', 'category']);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('items', function (Blueprint $table) {
            $table->dropIndex(['is_active', 'category']);
            $table->dropForeign(['canonical_item_id']);
            $table->dropColumn([
                'canonical_item_id',
                'mechanic_key',
                'usage_scope',
                'equipment_slot',
                'balance_version',
                'is_active',
            ]);
        });
    }
};
