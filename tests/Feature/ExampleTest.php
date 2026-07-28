<?php

test('redirects the home page to the pet wiki', function () {
    $this->get(route('home'))
        ->assertRedirectToRoute('wiki.pets.index');
});
