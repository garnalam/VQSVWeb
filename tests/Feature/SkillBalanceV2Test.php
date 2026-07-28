<?php

use App\Models\GameSource;
use App\Models\Skill;
use App\Support\SkillBalance;
use Database\Seeders\DatabaseSeeder;

use function Pest\Laravel\seed;

beforeEach(function () {
    seed(DatabaseSeeder::class);
});

test('publishes the complete approved v2 catalog as official data', function () {
    $skills = Skill::query()
        ->with('gameSource:id,slug')
        ->where('is_active', true)
        ->get();

    expect($skills)->toHaveCount(99)
        ->and($skills->pluck('balance_version')->unique()->values()->all())->toBe([SkillBalance::VERSION])
        ->and($skills->whereNotNull('energy_cost'))->toBeEmpty();

    foreach ($skills as $skill) {
        $profile = SkillBalance::profile($skill->gameSource->slug, $skill->game_id);

        expect($skill->power_percent)->toBe($profile['power'], $skill->name)
            ->and($skill->max_uses)->toBe($profile['pp'], $skill->name)
            ->and($skill->tier)->toBe($profile['tier'], $skill->name)
            ->and($skill->status_chance)->toBe($profile['status_chance'], $skill->name)
            ->and($skill->description)->toBe($profile['description'], $skill->name);
    }
});

test('persists every approved post-review adjustment', function (
    string $source,
    int $gameId,
    int $power,
    int $pp,
    array $mechanics,
) {
    $gameSource = GameSource::query()->where('slug', $source)->firstOrFail();
    $skill = Skill::query()->whereBelongsTo($gameSource)->where('game_id', $gameId)->firstOrFail();
    $profile = SkillBalance::profile($source, $gameId);

    expect($skill->power_percent)->toBe($power)
        ->and($skill->max_uses)->toBe($pp)
        ->and($profile['mechanics'])->toMatchArray($mechanics);
})->with([
    'Đằng Phược' => ['liet-hoa', 12, 75, 16, ['duration' => 2, 'value' => 10]],
    'Bão cát đầu' => ['liet-hoa', 22, 75, 18, ['duration' => 2, 'value' => 20]],
    'Thạch phu thuật' => ['liet-hoa', 25, 0, 4, ['duration' => 2]],
    'Ray lạnh' => ['liet-hoa', 39, 135, 6, ['duration' => 3, 'value' => 25]],
    'Đoạt mệnh cao áp' => ['liet-hoa', 44, 0, 4, ['duration' => 3, 'value' => 40]],
    'Chú oán' => ['liet-hoa', 51, 85, 20, ['duration' => 2, 'value' => 12]],
    'Mị ảnh' => ['liet-hoa', 54, 0, 4, ['duration' => 1, 'value' => 40]],
    'Chú Phược Quỷ Lao' => ['liet-hoa', 57, 115, 8, ['duration' => 2, 'value' => 20]],
    'Vũ Liệt Thuật' => ['liet-hoa', 65, 0, 4, ['value' => 60, 'cap' => 2]],
    'Tật Phong Tốc Hàng' => ['cau-vong', 12, 115, 12, ['duration' => 2, 'value' => 15]],
    'Tứ Ngược Trùng Phong' => ['cau-vong', 18, 140, 8, ['conditional_power' => 160]],
    'Tiên Xạ Thủy Lãng' => ['cau-vong', 21, 100, 20, ['value' => 1, 'chance' => 25]],
    'Thủy Cầu Áp Sát' => ['cau-vong', 22, 110, 12, ['duration' => 2, 'value' => 15]],
]);

test('keeps persistent defense modifiers inside the approved unified v5 limits', function (
    string $source,
    int $gameId,
    string $mechanicKey,
    int $expectedValue,
) {
    $mechanics = SkillBalance::mechanics($source, $gameId);

    expect($mechanics[$mechanicKey])->toBe($expectedValue);
})->with([
    'Súc Lực defense bonus' => ['liet-hoa', 4, 'secondary_value', 15],
    'Phá Phủ defense penalty' => ['liet-hoa', 5, 'secondary_value', 25],
    'Kinh Cức defense bonus' => ['liet-hoa', 14, 'value', 15],
    'Thổ thuẫn defense stack' => ['liet-hoa', 21, 'value', 7],
    'Hàng rào cát đá defense stack' => ['liet-hoa', 27, 'value', 7],
    'Hỏa Thạch defense penalty' => ['liet-hoa', 45, 'secondary_value', 25],
    'Chú oán defense reduction' => ['liet-hoa', 51, 'value', 12],
    'Chú Phược Quỷ Lao defense reduction' => ['liet-hoa', 57, 'value', 20],
    'Thiết Phù Đồ defense stack' => ['cau-vong', 6, 'value', 7],
]);
