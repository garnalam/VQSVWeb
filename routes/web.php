<?php

use App\Http\Controllers\Wiki\ItemController;
use App\Http\Controllers\Wiki\PetController;
use App\Http\Controllers\Wiki\SkillController;
use Illuminate\Support\Facades\Route;

Route::inertia('/', 'welcome')->name('home');

Route::prefix('wiki')->name('wiki.')->group(function () {
    Route::get('pets', [PetController::class, 'index'])->name('pets.index');
    Route::get('pets/{pet}', [PetController::class, 'show'])->name('pets.show');
    Route::get('skills', [SkillController::class, 'index'])->name('skills.index');
    Route::get('skills/{skill}', [SkillController::class, 'show'])->name('skills.show');
    Route::get('items', [ItemController::class, 'index'])->name('items.index');
    Route::get('items/{item}', [ItemController::class, 'show'])->name('items.show');
});

Route::middleware(['auth', 'verified'])->group(function () {
    Route::inertia('dashboard', 'dashboard')->name('dashboard');
});

require __DIR__.'/settings.php';
