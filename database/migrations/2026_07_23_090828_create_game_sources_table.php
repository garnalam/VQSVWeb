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
        Schema::create('game_sources', function (Blueprint $table) {
            $table->id();
            $table->string('name', 80);
            $table->string('slug', 40)->unique();
            $table->string('asset_key', 40)->unique();
            $table->string('color', 20);
            $table->timestamps();
        });

        DB::table('game_sources')->insert([
            ['id' => 1, 'name' => 'Liệt Hỏa', 'slug' => 'liet-hoa', 'asset_key' => 'liet-hoa', 'color' => '#ef5b3f', 'created_at' => now(), 'updated_at' => now()],
            ['id' => 2, 'name' => 'Cầu Vồng', 'slug' => 'cau-vong', 'asset_key' => 'cau-vong', 'color' => '#39b8d4', 'created_at' => now(), 'updated_at' => now()],
        ]);
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('game_sources');
    }
};
