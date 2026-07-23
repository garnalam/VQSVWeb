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
        Schema::table('users', function (Blueprint $table) {
            $table->string('username')->nullable()->unique();
            $table->string('avatar_path')->nullable();
            $table->string('role', 30)->default('member')->index();
            $table->string('status', 30)->default('active')->index();
            $table->timestamp('last_seen_at')->nullable()->index();
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::table('users', function (Blueprint $table) {
            $table->dropUnique(['username']);
            $table->dropIndex(['role']);
            $table->dropIndex(['status']);
            $table->dropIndex(['last_seen_at']);
            $table->dropColumn([
                'username',
                'avatar_path',
                'role',
                'status',
                'last_seen_at',
            ]);
        });
    }
};
