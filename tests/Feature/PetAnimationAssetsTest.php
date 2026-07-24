<?php

test('exports the original skill animation for every pet in both games', function () {
    $lietHoaManifest = json_decode(
        file_get_contents(public_path('assets/game/manifest.json')),
        true,
        flags: JSON_THROW_ON_ERROR,
    );
    $rainbowManifest = json_decode(
        file_get_contents(public_path('assets/game/cau-vong/pet-animations/manifest.json')),
        true,
        flags: JSON_THROW_ON_ERROR,
    );

    expect($lietHoaManifest['pet_animations'])->toHaveCount(100)
        ->and($rainbowManifest['animations'])->toHaveCount(102);

    foreach ($lietHoaManifest['pet_animations'] as $spriteId => $animation) {
        expect($animation['action'])->toBe('skill')
            ->and($animation['source_action_id'])->toBe(1)
            ->and($animation['frame_count'])->toBeGreaterThan(1)
            ->and($animation['duration_ms'])->toBeGreaterThan(0)
            ->and($animation['tick_ms'])->toBe(66)
            ->and($animation['url'])->toBe("/assets/game/pet-animations/{$spriteId}-skill.webp")
            ->and(public_path(ltrim($animation['url'], '/')))->toBeFile();
    }

    foreach ($rainbowManifest['animations'] as $gameId => $animation) {
        expect($animation['action'])->toBe('skill')
            ->and($animation['source_action_id'] % 3)->toBe(1)
            ->and($animation['frame_count'])->toBeGreaterThan(1)
            ->and($animation['duration_ms'])->toBeGreaterThan(0)
            ->and($animation['tick_ms'])->toBe(60)
            ->and($animation['url'])->toBe("/assets/game/cau-vong/pet-animations/{$gameId}-skill.webp")
            ->and(public_path(ltrim($animation['url'], '/')))->toBeFile();
    }
});

test('anchors static and animated pet artwork to the same centered stage', function () {
    $component = file_get_contents(
        resource_path('js/components/wiki/pet-artwork-motion.tsx'),
    );

    expect($component)
        ->toContain('data-pet-animation-stage')
        ->toContain("className={cn('relative shrink-0', imageClassName)}")
        ->toContain("'relative z-10 h-full w-full transition-opacity duration-100'")
        ->toContain("'wiki-pixel-art pointer-events-none absolute inset-0 z-20 h-full w-full object-contain");
});
