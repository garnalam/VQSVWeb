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
        Schema::create('traits', function (Blueprint $table) {
            $table->id();
            $table->string('code', 20)->unique();
            $table->string('name', 100);
            $table->string('slot_type', 20);
            $table->string('species', 20)->nullable()->index();
            $table->string('polarity', 20);
            $table->text('description');
            $table->json('parameters')->nullable();
            $table->unsignedSmallInteger('roll_weight')->default(0);
            $table->boolean('is_cleanse_eligible')->default(false);
            $table->boolean('is_active')->default(true);
            $table->timestamps();

            $table->index(['slot_type', 'is_active']);
        });
    }

    /**
     * Reverse the migrations.
     */
    public function down(): void
    {
        Schema::dropIfExists('traits');
    }
};
