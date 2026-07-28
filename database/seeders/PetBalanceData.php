<?php

namespace Database\Seeders;

use InvalidArgumentException;

final class PetBalanceData
{
    private const GUARDIAN_HP_PERCENT = 100;

    private const GUARDIAN_STRENGTH_PERCENT = 100;

    private const GUARDIAN_DEFENSE_PERCENT = 85;

    private const CONTROLLER_HP_PERCENT = 110;

    private const CONTROLLER_STRENGTH_PERCENT = 118;

    private const CONTROLLER_AGILITY_PERCENT = 100;

    private const EARTH_DEFENSE_PERCENT = 80;

    private const EARTH_HP_PERCENT = 85;

    private const EARTH_STRENGTH_PERCENT = 100;

    private const EARTH_AGILITY_PERCENT = 130;

    private const WIND_STRENGTH_PERCENT = 115;

    private const WIND_AGILITY_PERCENT = 90;

    /** @var array<string, array{hp: int, strength: int, defense: int, agility: int}> */
    private const DIVINE_RESTORATION_TARGETS = [
        'liet-hoa:15' => ['hp' => 1550, 'strength' => 410, 'defense' => 145, 'agility' => 42],
        'liet-hoa:31' => ['hp' => 1500, 'strength' => 350, 'defense' => 150, 'agility' => 40],
        'liet-hoa:47' => ['hp' => 1700, 'strength' => 370, 'defense' => 195, 'agility' => 23],
        'liet-hoa:63' => ['hp' => 1650, 'strength' => 380, 'defense' => 190, 'agility' => 24],
        'liet-hoa:75' => ['hp' => 1500, 'strength' => 430, 'defense' => 145, 'agility' => 43],
        'liet-hoa:87' => ['hp' => 1650, 'strength' => 410, 'defense' => 175, 'agility' => 32],
        'liet-hoa:99' => ['hp' => 1650, 'strength' => 390, 'defense' => 135, 'agility' => 48],
        'cau-vong:85' => ['hp' => 1750, 'strength' => 380, 'defense' => 175, 'agility' => 40],
        'cau-vong:86' => ['hp' => 1600, 'strength' => 430, 'defense' => 150, 'agility' => 44],
        'cau-vong:89' => ['hp' => 1550, 'strength' => 360, 'defense' => 180, 'agility' => 38],
        'cau-vong:92' => ['hp' => 1600, 'strength' => 430, 'defense' => 185, 'agility' => 31],
        'cau-vong:95' => ['hp' => 1675, 'strength' => 390, 'defense' => 165, 'agility' => 43],
        'cau-vong:98' => ['hp' => 1705, 'strength' => 420, 'defense' => 155, 'agility' => 44],
        'cau-vong:101' => ['hp' => 1600, 'strength' => 375, 'defense' => 175, 'agility' => 40],
    ];

    /** @var array<string, array{hp: int, strength: int, defense: int}> */
    private const OUTLIER_STAT_PERCENT = [
        'cau-vong:0' => ['hp' => 104, 'strength' => 117, 'defense' => 102],
        'cau-vong:1' => ['hp' => 109, 'strength' => 132, 'defense' => 105],
        'cau-vong:3' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'cau-vong:4' => ['hp' => 91, 'strength' => 100, 'defense' => 93],
        'cau-vong:7' => ['hp' => 103, 'strength' => 115, 'defense' => 102],
        'cau-vong:8' => ['hp' => 100, 'strength' => 107, 'defense' => 100],
        'cau-vong:9' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'cau-vong:10' => ['hp' => 96, 'strength' => 100, 'defense' => 96],
        'cau-vong:12' => ['hp' => 100, 'strength' => 109, 'defense' => 100],
        'cau-vong:13' => ['hp' => 100, 'strength' => 117, 'defense' => 100],
        'cau-vong:16' => ['hp' => 109, 'strength' => 132, 'defense' => 105],
        'cau-vong:18' => ['hp' => 100, 'strength' => 116, 'defense' => 100],
        'cau-vong:19' => ['hp' => 100, 'strength' => 128, 'defense' => 100],
        'cau-vong:21' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'cau-vong:22' => ['hp' => 100, 'strength' => 111, 'defense' => 100],
        'cau-vong:23' => ['hp' => 100, 'strength' => 85, 'defense' => 100],
        'cau-vong:25' => ['hp' => 97, 'strength' => 100, 'defense' => 97],
        'cau-vong:27' => ['hp' => 101, 'strength' => 107, 'defense' => 101],
        'cau-vong:28' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'cau-vong:30' => ['hp' => 102, 'strength' => 111, 'defense' => 101],
        'cau-vong:31' => ['hp' => 100, 'strength' => 108, 'defense' => 100],
        'cau-vong:33' => ['hp' => 100, 'strength' => 104, 'defense' => 100],
        'cau-vong:35' => ['hp' => 100, 'strength' => 110, 'defense' => 100],
        'cau-vong:36' => ['hp' => 100, 'strength' => 106, 'defense' => 100],
        'cau-vong:37' => ['hp' => 100, 'strength' => 118, 'defense' => 100],
        'cau-vong:39' => ['hp' => 100, 'strength' => 76, 'defense' => 100],
        'cau-vong:41' => ['hp' => 100, 'strength' => 86, 'defense' => 100],
        'cau-vong:42' => ['hp' => 100, 'strength' => 87, 'defense' => 100],
        'cau-vong:44' => ['hp' => 100, 'strength' => 75, 'defense' => 100],
        'cau-vong:45' => ['hp' => 100, 'strength' => 89, 'defense' => 100],
        'cau-vong:46' => ['hp' => 107, 'strength' => 125, 'defense' => 104],
        'cau-vong:48' => ['hp' => 100, 'strength' => 91, 'defense' => 100],
        'cau-vong:50' => ['hp' => 100, 'strength' => 108, 'defense' => 100],
        'cau-vong:52' => ['hp' => 100, 'strength' => 111, 'defense' => 100],
        'cau-vong:53' => ['hp' => 100, 'strength' => 120, 'defense' => 100],
        'cau-vong:54' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'cau-vong:60' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'cau-vong:70' => ['hp' => 94, 'strength' => 100, 'defense' => 96],
        'cau-vong:71' => ['hp' => 97, 'strength' => 100, 'defense' => 97],
        'cau-vong:73' => ['hp' => 94, 'strength' => 100, 'defense' => 95],
        'cau-vong:74' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'cau-vong:77' => ['hp' => 100, 'strength' => 117, 'defense' => 100],
        'cau-vong:79' => ['hp' => 103, 'strength' => 115, 'defense' => 102],
        'cau-vong:80' => ['hp' => 97, 'strength' => 100, 'defense' => 97],
        'cau-vong:84' => ['hp' => 100, 'strength' => 90, 'defense' => 100],
        'cau-vong:86' => ['hp' => 100, 'strength' => 82, 'defense' => 100],
        'cau-vong:91' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'cau-vong:92' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'cau-vong:95' => ['hp' => 100, 'strength' => 84, 'defense' => 100],
        'cau-vong:96' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'cau-vong:97' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'cau-vong:98' => ['hp' => 100, 'strength' => 79, 'defense' => 100],
        'cau-vong:100' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
        'cau-vong:101' => ['hp' => 101, 'strength' => 107, 'defense' => 101],
        'liet-hoa:3' => ['hp' => 100, 'strength' => 87, 'defense' => 100],
        'liet-hoa:4' => ['hp' => 100, 'strength' => 80, 'defense' => 100],
        'liet-hoa:6' => ['hp' => 100, 'strength' => 109, 'defense' => 100],
        'liet-hoa:9' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'liet-hoa:11' => ['hp' => 100, 'strength' => 89, 'defense' => 100],
        'liet-hoa:13' => ['hp' => 100, 'strength' => 74, 'defense' => 100],
        'liet-hoa:14' => ['hp' => 100, 'strength' => 115, 'defense' => 100],
        'liet-hoa:15' => ['hp' => 100, 'strength' => 80, 'defense' => 100],
        'liet-hoa:16' => ['hp' => 100, 'strength' => 115, 'defense' => 100],
        'liet-hoa:17' => ['hp' => 90, 'strength' => 100, 'defense' => 92],
        'liet-hoa:24' => ['hp' => 106, 'strength' => 122, 'defense' => 103],
        'liet-hoa:25' => ['hp' => 104, 'strength' => 116, 'defense' => 102],
        'liet-hoa:26' => ['hp' => 106, 'strength' => 122, 'defense' => 103],
        'liet-hoa:32' => ['hp' => 103, 'strength' => 113, 'defense' => 102],
        'liet-hoa:35' => ['hp' => 100, 'strength' => 86, 'defense' => 100],
        'liet-hoa:37' => ['hp' => 90, 'strength' => 100, 'defense' => 93],
        'liet-hoa:38' => ['hp' => 105, 'strength' => 120, 'defense' => 103],
        'liet-hoa:39' => ['hp' => 100, 'strength' => 93, 'defense' => 100],
        'liet-hoa:41' => ['hp' => 89, 'strength' => 100, 'defense' => 91],
        'liet-hoa:42' => ['hp' => 100, 'strength' => 107, 'defense' => 100],
        'liet-hoa:43' => ['hp' => 100, 'strength' => 82, 'defense' => 100],
        'liet-hoa:44' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'liet-hoa:45' => ['hp' => 100, 'strength' => 80, 'defense' => 100],
        'liet-hoa:46' => ['hp' => 100, 'strength' => 91, 'defense' => 100],
        'liet-hoa:47' => ['hp' => 97, 'strength' => 100, 'defense' => 98],
        'liet-hoa:48' => ['hp' => 100, 'strength' => 120, 'defense' => 100],
        'liet-hoa:49' => ['hp' => 100, 'strength' => 106, 'defense' => 100],
        'liet-hoa:50' => ['hp' => 104, 'strength' => 118, 'defense' => 103],
        'liet-hoa:51' => ['hp' => 103, 'strength' => 114, 'defense' => 102],
        'liet-hoa:52' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'liet-hoa:55' => ['hp' => 102, 'strength' => 111, 'defense' => 101],
        'liet-hoa:56' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'liet-hoa:57' => ['hp' => 108, 'strength' => 128, 'defense' => 104],
        'liet-hoa:58' => ['hp' => 103, 'strength' => 114, 'defense' => 102],
        'liet-hoa:60' => ['hp' => 100, 'strength' => 111, 'defense' => 100],
        'liet-hoa:61' => ['hp' => 100, 'strength' => 112, 'defense' => 100],
        'liet-hoa:62' => ['hp' => 101, 'strength' => 107, 'defense' => 101],
        'liet-hoa:64' => ['hp' => 100, 'strength' => 115, 'defense' => 100],
        'liet-hoa:66' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'liet-hoa:68' => ['hp' => 100, 'strength' => 117, 'defense' => 100],
        'liet-hoa:70' => ['hp' => 101, 'strength' => 108, 'defense' => 101],
        'liet-hoa:73' => ['hp' => 100, 'strength' => 92, 'defense' => 100],
        'liet-hoa:75' => ['hp' => 100, 'strength' => 89, 'defense' => 100],
        'liet-hoa:76' => ['hp' => 100, 'strength' => 83, 'defense' => 100],
        'liet-hoa:78' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'liet-hoa:81' => ['hp' => 102, 'strength' => 112, 'defense' => 102],
        'liet-hoa:82' => ['hp' => 100, 'strength' => 92, 'defense' => 100],
        'liet-hoa:83' => ['hp' => 100, 'strength' => 92, 'defense' => 100],
        'liet-hoa:84' => ['hp' => 95, 'strength' => 100, 'defense' => 96],
        'liet-hoa:85' => ['hp' => 100, 'strength' => 93, 'defense' => 100],
        'liet-hoa:88' => ['hp' => 104, 'strength' => 115, 'defense' => 102],
        'liet-hoa:91' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'liet-hoa:92' => ['hp' => 104, 'strength' => 117, 'defense' => 102],
        'liet-hoa:94' => ['hp' => 100, 'strength' => 112, 'defense' => 100],
        'liet-hoa:96' => ['hp' => 100, 'strength' => 91, 'defense' => 100],
        'liet-hoa:97' => ['hp' => 88, 'strength' => 100, 'defense' => 91],
        'liet-hoa:99' => ['hp' => 100, 'strength' => 83, 'defense' => 100],
    ];

    /** @var array<string, array{hp: int, strength: int, defense: int}> */
    private const OUTLIER_REFINEMENT_PERCENT = [
        'cau-vong:0' => ['hp' => 102, 'strength' => 108, 'defense' => 102],
        'cau-vong:1' => ['hp' => 103, 'strength' => 112, 'defense' => 103],
        'cau-vong:10' => ['hp' => 100, 'strength' => 104, 'defense' => 100],
        'cau-vong:100' => ['hp' => 100, 'strength' => 90, 'defense' => 100],
        'cau-vong:11' => ['hp' => 101, 'strength' => 104, 'defense' => 101],
        'cau-vong:12' => ['hp' => 100, 'strength' => 102, 'defense' => 100],
        'cau-vong:14' => ['hp' => 95, 'strength' => 100, 'defense' => 97],
        'cau-vong:18' => ['hp' => 100, 'strength' => 117, 'defense' => 100],
        'cau-vong:19' => ['hp' => 100, 'strength' => 86, 'defense' => 100],
        'cau-vong:26' => ['hp' => 102, 'strength' => 104, 'defense' => 101],
        'cau-vong:30' => ['hp' => 103, 'strength' => 109, 'defense' => 102],
        'cau-vong:35' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'cau-vong:36' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'cau-vong:42' => ['hp' => 100, 'strength' => 91, 'defense' => 100],
        'cau-vong:44' => ['hp' => 100, 'strength' => 90, 'defense' => 100],
        'cau-vong:46' => ['hp' => 102, 'strength' => 107, 'defense' => 102],
        'cau-vong:52' => ['hp' => 100, 'strength' => 108, 'defense' => 100],
        'cau-vong:53' => ['hp' => 100, 'strength' => 102, 'defense' => 100],
        'cau-vong:56' => ['hp' => 98, 'strength' => 100, 'defense' => 99],
        'cau-vong:59' => ['hp' => 100, 'strength' => 102, 'defense' => 100],
        'cau-vong:6' => ['hp' => 100, 'strength' => 115, 'defense' => 100],
        'cau-vong:64' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
        'cau-vong:66' => ['hp' => 100, 'strength' => 111, 'defense' => 100],
        'cau-vong:68' => ['hp' => 90, 'strength' => 108, 'defense' => 92],
        'cau-vong:69' => ['hp' => 90, 'strength' => 108, 'defense' => 92],
        'cau-vong:70' => ['hp' => 105, 'strength' => 117, 'defense' => 103],
        'cau-vong:75' => ['hp' => 102, 'strength' => 106, 'defense' => 102],
        'cau-vong:79' => ['hp' => 102, 'strength' => 105, 'defense' => 102],
        'cau-vong:84' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'cau-vong:85' => ['hp' => 100, 'strength' => 93, 'defense' => 100],
        'cau-vong:88' => ['hp' => 98, 'strength' => 100, 'defense' => 99],
        'cau-vong:89' => ['hp' => 97, 'strength' => 100, 'defense' => 99],
        'cau-vong:92' => ['hp' => 100, 'strength' => 82, 'defense' => 100],
        'cau-vong:95' => ['hp' => 100, 'strength' => 90, 'defense' => 100],
        'cau-vong:96' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'cau-vong:97' => ['hp' => 100, 'strength' => 88, 'defense' => 100],
        'cau-vong:98' => ['hp' => 100, 'strength' => 90, 'defense' => 100],
        'liet-hoa:13' => ['hp' => 100, 'strength' => 93, 'defense' => 100],
        'liet-hoa:15' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'liet-hoa:16' => ['hp' => 100, 'strength' => 109, 'defense' => 100],
        'liet-hoa:19' => ['hp' => 102, 'strength' => 106, 'defense' => 102],
        'liet-hoa:24' => ['hp' => 102, 'strength' => 108, 'defense' => 102],
        'liet-hoa:27' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'liet-hoa:3' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:32' => ['hp' => 104, 'strength' => 113, 'defense' => 103],
        'liet-hoa:36' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'liet-hoa:38' => ['hp' => 103, 'strength' => 110, 'defense' => 102],
        'liet-hoa:41' => ['hp' => 90, 'strength' => 100, 'defense' => 93],
        'liet-hoa:42' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'liet-hoa:43' => ['hp' => 100, 'strength' => 86, 'defense' => 100],
        'liet-hoa:48' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:5' => ['hp' => 101, 'strength' => 102, 'defense' => 101],
        'liet-hoa:51' => ['hp' => 101, 'strength' => 104, 'defense' => 101],
        'liet-hoa:54' => ['hp' => 100, 'strength' => 107, 'defense' => 100],
        'liet-hoa:55' => ['hp' => 102, 'strength' => 104, 'defense' => 101],
        'liet-hoa:57' => ['hp' => 103, 'strength' => 112, 'defense' => 103],
        'liet-hoa:59' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:60' => ['hp' => 100, 'strength' => 90, 'defense' => 100],
        'liet-hoa:61' => ['hp' => 100, 'strength' => 102, 'defense' => 100],
        'liet-hoa:62' => ['hp' => 103, 'strength' => 109, 'defense' => 102],
        'liet-hoa:66' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'liet-hoa:71' => ['hp' => 100, 'strength' => 104, 'defense' => 100],
        'liet-hoa:75' => ['hp' => 100, 'strength' => 93, 'defense' => 100],
        'liet-hoa:84' => ['hp' => 95, 'strength' => 100, 'defense' => 97],
        'liet-hoa:85' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'liet-hoa:88' => ['hp' => 103, 'strength' => 109, 'defense' => 102],
        'liet-hoa:9' => ['hp' => 102, 'strength' => 105, 'defense' => 101],
        'liet-hoa:94' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'liet-hoa:95' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:96' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'liet-hoa:97' => ['hp' => 96, 'strength' => 100, 'defense' => 97],
        'liet-hoa:99' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
    ];

    /** @var array<string, array{hp: int, strength: int, defense: int}> */
    private const OUTLIER_FINALIZATION_PERCENT = [
        'cau-vong:0' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'cau-vong:3' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'cau-vong:8' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'cau-vong:10' => ['hp' => 103, 'strength' => 109, 'defense' => 102],
        'cau-vong:13' => ['hp' => 100, 'strength' => 102, 'defense' => 100],
        'cau-vong:14' => ['hp' => 96, 'strength' => 100, 'defense' => 97],
        'cau-vong:19' => ['hp' => 100, 'strength' => 104, 'defense' => 100],
        'cau-vong:20' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'cau-vong:21' => ['hp' => 100, 'strength' => 102, 'defense' => 100],
        'cau-vong:22' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'cau-vong:26' => ['hp' => 102, 'strength' => 104, 'defense' => 101],
        'cau-vong:36' => ['hp' => 100, 'strength' => 109, 'defense' => 100],
        'cau-vong:42' => ['hp' => 100, 'strength' => 91, 'defense' => 100],
        'cau-vong:52' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'cau-vong:53' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'cau-vong:55' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'cau-vong:56' => ['hp' => 96, 'strength' => 100, 'defense' => 97],
        'cau-vong:61' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'cau-vong:66' => ['hp' => 100, 'strength' => 107, 'defense' => 100],
        'cau-vong:69' => ['hp' => 104, 'strength' => 112, 'defense' => 103],
        'cau-vong:79' => ['hp' => 102, 'strength' => 107, 'defense' => 102],
        'cau-vong:85' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'cau-vong:86' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
        'cau-vong:89' => ['hp' => 95, 'strength' => 100, 'defense' => 96],
        'cau-vong:91' => ['hp' => 102, 'strength' => 105, 'defense' => 102],
        'cau-vong:92' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'cau-vong:95' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'cau-vong:96' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'liet-hoa:4' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
        'liet-hoa:19' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'liet-hoa:24' => ['hp' => 102, 'strength' => 104, 'defense' => 101],
        'liet-hoa:27' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'liet-hoa:29' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'liet-hoa:32' => ['hp' => 102, 'strength' => 105, 'defense' => 101],
        'liet-hoa:34' => ['hp' => 100, 'strength' => 104, 'defense' => 100],
        'liet-hoa:36' => ['hp' => 100, 'strength' => 104, 'defense' => 100],
        'liet-hoa:41' => ['hp' => 90, 'strength' => 100, 'defense' => 92],
        'liet-hoa:51' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'liet-hoa:52' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'liet-hoa:57' => ['hp' => 103, 'strength' => 109, 'defense' => 102],
        'liet-hoa:59' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'liet-hoa:60' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'liet-hoa:62' => ['hp' => 102, 'strength' => 106, 'defense' => 101],
        'liet-hoa:75' => ['hp' => 100, 'strength' => 91, 'defense' => 100],
        'liet-hoa:76' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'liet-hoa:82' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'liet-hoa:84' => ['hp' => 98, 'strength' => 100, 'defense' => 98],
        'liet-hoa:87' => ['hp' => 100, 'strength' => 88, 'defense' => 100],
        'liet-hoa:88' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'liet-hoa:92' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'liet-hoa:97' => ['hp' => 93, 'strength' => 100, 'defense' => 94],
        'liet-hoa:99' => ['hp' => 100, 'strength' => 93, 'defense' => 100],
    ];

    /** @var array<string, array{hp: int, strength: int, defense: int}> */
    private const OUTLIER_MICRO_PERCENT = [
        'cau-vong:4' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'cau-vong:13' => ['hp' => 100, 'strength' => 104, 'defense' => 100],
        'cau-vong:22' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'cau-vong:32' => ['hp' => 101, 'strength' => 102, 'defense' => 101],
        'cau-vong:34' => ['hp' => 102, 'strength' => 105, 'defense' => 101],
        'cau-vong:41' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'cau-vong:43' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'cau-vong:52' => ['hp' => 100, 'strength' => 102, 'defense' => 100],
        'cau-vong:63' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'cau-vong:66' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'cau-vong:69' => ['hp' => 101, 'strength' => 104, 'defense' => 101],
        'cau-vong:79' => ['hp' => 101, 'strength' => 102, 'defense' => 101],
        'cau-vong:85' => ['hp' => 100, 'strength' => 90, 'defense' => 100],
        'cau-vong:89' => ['hp' => 97, 'strength' => 100, 'defense' => 98],
        'cau-vong:92' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'cau-vong:94' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'cau-vong:95' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:4' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
        'liet-hoa:5' => ['hp' => 101, 'strength' => 104, 'defense' => 101],
        'liet-hoa:15' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'liet-hoa:17' => ['hp' => 95, 'strength' => 100, 'defense' => 96],
        'liet-hoa:31' => ['hp' => 98, 'strength' => 100, 'defense' => 98],
        'liet-hoa:32' => ['hp' => 102, 'strength' => 108, 'defense' => 102],
        'liet-hoa:36' => ['hp' => 100, 'strength' => 104, 'defense' => 100],
        'liet-hoa:45' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'liet-hoa:54' => ['hp' => 100, 'strength' => 104, 'defense' => 100],
        'liet-hoa:57' => ['hp' => 102, 'strength' => 105, 'defense' => 101],
        'liet-hoa:75' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'liet-hoa:76' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
        'liet-hoa:87' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
        'liet-hoa:92' => ['hp' => 103, 'strength' => 112, 'defense' => 102],
        'liet-hoa:93' => ['hp' => 98, 'strength' => 100, 'defense' => 98],
        'liet-hoa:97' => ['hp' => 95, 'strength' => 100, 'defense' => 96],
        'liet-hoa:99' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
    ];

    /** @var array<string, array{hp: int, strength: int, defense: int}> */
    private const OUTLIER_LAST_MILE_PERCENT = [
        'cau-vong:37' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'cau-vong:46' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'cau-vong:52' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'cau-vong:73' => ['hp' => 96, 'strength' => 100, 'defense' => 97],
        'cau-vong:74' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
        'cau-vong:79' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'cau-vong:89' => ['hp' => 95, 'strength' => 100, 'defense' => 96],
        'cau-vong:95' => ['hp' => 100, 'strength' => 92, 'defense' => 100],
        'cau-vong:98' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'liet-hoa:5' => ['hp' => 102, 'strength' => 106, 'defense' => 101],
        'liet-hoa:8' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'liet-hoa:16' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'liet-hoa:20' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
        'liet-hoa:36' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'liet-hoa:55' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'liet-hoa:57' => ['hp' => 101, 'strength' => 104, 'defense' => 101],
        'liet-hoa:62' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'liet-hoa:86' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'liet-hoa:87' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
        'liet-hoa:91' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
        'liet-hoa:92' => ['hp' => 100, 'strength' => 102, 'defense' => 100],
        'liet-hoa:95' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:99' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
    ];

    /** @var array<string, array{hp: int, strength: int, defense: int}> */
    private const OUTLIER_RESIDUAL_PERCENT = [
        'cau-vong:4' => ['hp' => 101, 'strength' => 104, 'defense' => 101],
        'cau-vong:7' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'cau-vong:11' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'cau-vong:24' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'cau-vong:33' => ['hp' => 100, 'strength' => 99, 'defense' => 100],
        'cau-vong:41' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'cau-vong:61' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'cau-vong:86' => ['hp' => 100, 'strength' => 99, 'defense' => 100],
        'cau-vong:92' => ['hp' => 100, 'strength' => 88, 'defense' => 100],
        'liet-hoa:5' => ['hp' => 102, 'strength' => 107, 'defense' => 102],
        'liet-hoa:20' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:31' => ['hp' => 95, 'strength' => 100, 'defense' => 96],
        'liet-hoa:32' => ['hp' => 102, 'strength' => 107, 'defense' => 102],
        'liet-hoa:36' => ['hp' => 100, 'strength' => 106, 'defense' => 100],
        'liet-hoa:57' => ['hp' => 101, 'strength' => 104, 'defense' => 101],
        'liet-hoa:62' => ['hp' => 102, 'strength' => 106, 'defense' => 101],
        'liet-hoa:63' => ['hp' => 96, 'strength' => 100, 'defense' => 97],
        'liet-hoa:82' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:87' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:88' => ['hp' => 100, 'strength' => 102, 'defense' => 100],
        'liet-hoa:95' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:99' => ['hp' => 100, 'strength' => 95, 'defense' => 100],
    ];

    /** @var array<string, array{hp: int, strength: int, defense: int}> */
    private const OUTLIER_CLOSURE_PERCENT = [
        'cau-vong:4' => ['hp' => 102, 'strength' => 107, 'defense' => 102],
        'cau-vong:7' => ['hp' => 101, 'strength' => 104, 'defense' => 101],
        'cau-vong:50' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'cau-vong:63' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'cau-vong:66' => ['hp' => 100, 'strength' => 103, 'defense' => 100],
        'cau-vong:80' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'cau-vong:86' => ['hp' => 100, 'strength' => 94, 'defense' => 100],
        'cau-vong:92' => ['hp' => 100, 'strength' => 105, 'defense' => 100],
        'cau-vong:101' => ['hp' => 95, 'strength' => 100, 'defense' => 96],
        'liet-hoa:28' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'liet-hoa:47' => ['hp' => 96, 'strength' => 100, 'defense' => 97],
        'liet-hoa:55' => ['hp' => 101, 'strength' => 104, 'defense' => 101],
        'liet-hoa:87' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:95' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:99' => ['hp' => 100, 'strength' => 99, 'defense' => 100],
    ];

    /** @var array<string, array{hp: int, strength: int, defense: int}> */
    private const OUTLIER_VERIFICATION_PERCENT = [
        'cau-vong:48' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'cau-vong:78' => ['hp' => 102, 'strength' => 106, 'defense' => 102],
        'cau-vong:80' => ['hp' => 102, 'strength' => 105, 'defense' => 102],
        'cau-vong:86' => ['hp' => 100, 'strength' => 96, 'defense' => 100],
        'cau-vong:91' => ['hp' => 101, 'strength' => 103, 'defense' => 101],
        'liet-hoa:15' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:75' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:91' => ['hp' => 100, 'strength' => 99, 'defense' => 100],
        'liet-hoa:95' => ['hp' => 100, 'strength' => 98, 'defense' => 100],
        'liet-hoa:99' => ['hp' => 100, 'strength' => 97, 'defense' => 100],
    ];

    /** @var array<string, array{hp: int, strength: int, defense: int}> */
    private const EVOLUTION_PROGRESSION_PERCENT = [
        'liet-hoa:17' => ['hp' => 125, 'strength' => 100, 'defense' => 113],
    ];

    /** @var array<string, array{hp: int, strength: int, defense: int}> */
    private const APPROVED_META_TUNING_PERCENT = [
        'liet-hoa:17' => ['hp' => 103, 'strength' => 116, 'defense' => 100],
    ];

    /**
     * @return array<string, array<int, array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}>>
     */
    public static function profiles(): array
    {
        $remaining = RemainingPetBalanceData::profiles();

        foreach (PilotPetBalanceData::profiles() as $source => $profiles) {
            $remaining[$source] = array_replace($remaining[$source], $profiles);
            ksort($remaining[$source]);
        }

        foreach ($remaining as $source => $profiles) {
            foreach ($profiles as $gameId => $profile) {
                $remaining[$source][$gameId] = self::rebalanceOutlierProfile(
                    $source,
                    $gameId,
                    self::rebalanceElementProfile(
                        self::rebalanceRoleProfile($profile),
                    ),
                    self::OUTLIER_STAT_PERCENT,
                );
                $remaining[$source][$gameId] = self::rebalanceOutlierProfile(
                    $source,
                    $gameId,
                    $remaining[$source][$gameId],
                    self::OUTLIER_REFINEMENT_PERCENT,
                );
                $remaining[$source][$gameId] = self::rebalanceOutlierProfile(
                    $source,
                    $gameId,
                    $remaining[$source][$gameId],
                    self::OUTLIER_FINALIZATION_PERCENT,
                );
                $remaining[$source][$gameId] = self::rebalanceOutlierProfile(
                    $source,
                    $gameId,
                    $remaining[$source][$gameId],
                    self::OUTLIER_MICRO_PERCENT,
                );
                $remaining[$source][$gameId] = self::rebalanceOutlierProfile(
                    $source,
                    $gameId,
                    $remaining[$source][$gameId],
                    self::OUTLIER_LAST_MILE_PERCENT,
                );
                $remaining[$source][$gameId] = self::rebalanceOutlierProfile(
                    $source,
                    $gameId,
                    $remaining[$source][$gameId],
                    self::OUTLIER_RESIDUAL_PERCENT,
                );
                $remaining[$source][$gameId] = self::rebalanceOutlierProfile(
                    $source,
                    $gameId,
                    $remaining[$source][$gameId],
                    self::OUTLIER_CLOSURE_PERCENT,
                );
                $remaining[$source][$gameId] = self::rebalanceOutlierProfile(
                    $source,
                    $gameId,
                    $remaining[$source][$gameId],
                    self::OUTLIER_VERIFICATION_PERCENT,
                );
                $remaining[$source][$gameId] = self::rebalanceOutlierProfile(
                    $source,
                    $gameId,
                    $remaining[$source][$gameId],
                    self::EVOLUTION_PROGRESSION_PERCENT,
                );
                $remaining[$source][$gameId] = self::rebalanceOutlierProfile(
                    $source,
                    $gameId,
                    $remaining[$source][$gameId],
                    self::APPROVED_META_TUNING_PERCENT,
                );
                $remaining[$source][$gameId] = self::restoreDivineProfile(
                    $source,
                    $gameId,
                    $remaining[$source][$gameId],
                );
            }
        }

        return $remaining;
    }

    /** @return array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}|null */
    public static function find(string $source, int $gameId): ?array
    {
        return self::profiles()[$source][$gameId] ?? null;
    }

    /** @return array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int} */
    public static function for(string $source, int $gameId): array
    {
        return self::find($source, $gameId) ?? throw new InvalidArgumentException(
            "Missing Pet balance profile for {$source}:{$gameId}.",
        );
    }

    /**
     * @param  array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}  $profile
     * @return array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}
     */
    private static function rebalanceRoleProfile(array $profile): array
    {
        if ($profile['primary_role'] === 'guardian') {
            $hp = self::scaledStat($profile['hp_base'], $profile['hp_growth'], 50, self::GUARDIAN_HP_PERCENT);
            $strength = self::scaledStat($profile['strength_base'], $profile['strength_growth'], 50, self::GUARDIAN_STRENGTH_PERCENT);
            $defense = self::scaledStat($profile['defense_base'], $profile['defense_growth'], 5, self::GUARDIAN_DEFENSE_PERCENT);
            $profile['hp_base'] = $hp['base'];
            $profile['hp_growth'] = $hp['growth'];
            $profile['strength_base'] = $strength['base'];
            $profile['strength_growth'] = $strength['growth'];
            $profile['defense_base'] = $defense['base'];
            $profile['defense_growth'] = $defense['growth'];
        }

        if ($profile['primary_role'] === 'controller') {
            $hp = self::scaledStat($profile['hp_base'], $profile['hp_growth'], 50, self::CONTROLLER_HP_PERCENT);
            $strength = self::scaledStat($profile['strength_base'], $profile['strength_growth'], 50, self::CONTROLLER_STRENGTH_PERCENT);
            $agility = self::scaledStat($profile['agility_base'], $profile['agility_growth'], 5, self::CONTROLLER_AGILITY_PERCENT);
            $profile['hp_base'] = $hp['base'];
            $profile['hp_growth'] = $hp['growth'];
            $profile['strength_base'] = $strength['base'];
            $profile['strength_growth'] = $strength['growth'];
            $profile['agility_base'] = $agility['base'];
            $profile['agility_growth'] = $agility['growth'];
        }

        return $profile;
    }

    /**
     * @param  array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}  $profile
     * @return array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}
     */
    private static function rebalanceElementProfile(array $profile): array
    {
        if ($profile['combat_element'] === 'tho') {
            $hp = self::scaledStat($profile['hp_base'], $profile['hp_growth'], 50, self::EARTH_HP_PERCENT);
            $strength = self::scaledStat($profile['strength_base'], $profile['strength_growth'], 50, self::EARTH_STRENGTH_PERCENT);
            $defense = self::scaledStat($profile['defense_base'], $profile['defense_growth'], 5, self::EARTH_DEFENSE_PERCENT);
            $agility = self::scaledStat($profile['agility_base'], $profile['agility_growth'], 5, self::EARTH_AGILITY_PERCENT);
            $profile['hp_base'] = $hp['base'];
            $profile['hp_growth'] = $hp['growth'];
            $profile['strength_base'] = $strength['base'];
            $profile['strength_growth'] = $strength['growth'];
            $profile['defense_base'] = $defense['base'];
            $profile['defense_growth'] = $defense['growth'];
            $profile['agility_base'] = $agility['base'];
            $profile['agility_growth'] = $agility['growth'];
        }

        if ($profile['combat_element'] === 'phong') {
            $strength = self::scaledStat($profile['strength_base'], $profile['strength_growth'], 50, self::WIND_STRENGTH_PERCENT);
            $agility = self::scaledStat($profile['agility_base'], $profile['agility_growth'], 5, self::WIND_AGILITY_PERCENT);
            $profile['strength_base'] = $strength['base'];
            $profile['strength_growth'] = $strength['growth'];
            $profile['agility_base'] = $agility['base'];
            $profile['agility_growth'] = $agility['growth'];
        }

        return $profile;
    }

    /**
     * @param  array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}  $profile
     * @param  array<string, array{hp: int, strength: int, defense: int}>  $adjustments
     * @return array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}
     */
    private static function rebalanceOutlierProfile(string $source, int $gameId, array $profile, array $adjustments): array
    {
        $percentages = $adjustments["{$source}:{$gameId}"] ?? null;

        if ($percentages === null) {
            return $profile;
        }

        $hp = self::scaledStat($profile['hp_base'], $profile['hp_growth'], 50, $percentages['hp']);
        $strength = self::scaledStat($profile['strength_base'], $profile['strength_growth'], 50, $percentages['strength']);
        $defense = self::scaledStat($profile['defense_base'], $profile['defense_growth'], 5, $percentages['defense']);
        $profile['hp_base'] = $hp['base'];
        $profile['hp_growth'] = $hp['growth'];
        $profile['strength_base'] = $strength['base'];
        $profile['strength_growth'] = $strength['growth'];
        $profile['defense_base'] = $defense['base'];
        $profile['defense_growth'] = $defense['growth'];

        return $profile;
    }

    /**
     * Restore divine-class targets after ordinary outlier adjustments have been applied.
     *
     * @param  array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}  $profile
     * @return array{combat_element: string, species: string, primary_role: string, secondary_role: string, species_trait_code: string, hp_base: int, hp_growth: int, strength_base: int, strength_growth: int, defense_base: int, defense_growth: int, agility_base: int, agility_growth: int}
     */
    private static function restoreDivineProfile(string $source, int $gameId, array $profile): array
    {
        $targets = self::DIVINE_RESTORATION_TARGETS["{$source}:{$gameId}"] ?? null;

        if ($targets === null) {
            return $profile;
        }

        [$profile['hp_base'], $profile['hp_growth']] = self::targetFormula($targets['hp'], 50);
        [$profile['strength_base'], $profile['strength_growth']] = self::targetFormula($targets['strength'], 50);
        [$profile['defense_base'], $profile['defense_growth']] = self::targetFormula($targets['defense'], 5);
        [$profile['agility_base'], $profile['agility_growth']] = self::targetFormula($targets['agility'], 5);

        return $profile;
    }

    /** @return array{base: int, growth: int} */
    private static function scaledStat(int $base, int $growth, int $growthSteps, int $percent): array
    {
        $target = (int) round(($base + $growth * $growthSteps) * $percent / 100);
        $scaledGrowth = (int) round($growth * $percent / 100);

        return [
            'base' => $target - $scaledGrowth * $growthSteps,
            'growth' => $scaledGrowth,
        ];
    }

    /** @return array{int, int} */
    private static function targetFormula(int $levelFiftyTarget, int $growthSteps): array
    {
        $growth = max(1, intdiv($levelFiftyTarget, $growthSteps) - 1);

        return [$levelFiftyTarget - $growth * $growthSteps, $growth];
    }
}
