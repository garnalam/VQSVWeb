<?php

use Inertia\Testing\AssertableInertia as Assert;

test('emulator page is available as a standalone inertia screen', function () {
    $this->get(route('emulator'))
        ->assertOk()
        ->assertInertia(fn (Assert $page): Assert => $page
            ->component('emulator')
        );
});
