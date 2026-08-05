<?php

namespace Database\Seeders;

use App\Models\DivineAbility;
use App\Models\Pet;
use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use RuntimeException;

class DivineAbilitySeeder extends Seeder
{
    use WithoutModelEvents;

    /** @var array<string, array{code: string, name: string, activation_type: string, description: string, parameters: array<string, int|float|string>}> */
    private const ABILITIES = [
        'liet-hoa:15' => [
            'code' => 'phoenix-rebirth',
            'name' => 'Niết Bàn Vĩnh Hỏa',
            'activation_type' => 'revival',
            'description' => 'Lần đầu nhận sát thương chí tử, Hỏa Phượng Hoàng sống lại, thanh tẩy và bước vào trạng thái bùng nổ.',
            'parameters' => ['heal_percent' => 25, 'damage_percent' => 20, 'duration' => 2, 'uses' => 1],
        ],
        'liet-hoa:31' => [
            'code' => 'sacred-light-cycle',
            'name' => 'Tuần Hoàn Linh Quang',
            'activation_type' => 'charge_cycle',
            'description' => 'Skill hỗ trợ tích Linh Quang; đòn tấn công kế tiếp chuyển Linh Quang thành sát thương và hồi phục.',
            'parameters' => ['maximum_charges' => 2, 'damage_percent_per_charge' => 15, 'heal_percent_per_charge' => 5],
        ],
        'liet-hoa:47' => [
            'code' => 'immovable-war-god',
            'name' => 'Bất Động Chiến Thần',
            'activation_type' => 'guard_counter',
            'description' => 'Giảm đòn đầu mỗi hiệp và tích thế phản công sau khi chịu đủ hai đòn.',
            'parameters' => ['first_hit_reduction_percent' => 18, 'hits_required' => 2, 'counter_damage_percent' => 20, 'defense_pierce_percent' => 12],
        ],
        'liet-hoa:63' => [
            'code' => 'tidal-counter-armor',
            'name' => 'Thủy Giáp Phản Chấn',
            'activation_type' => 'heavy_hit_response',
            'description' => 'Đòn đánh nặng dựng Thủy Giáp cho lần phòng thủ kế tiếp và chuẩn bị hồi phục khi phản công.',
            'parameters' => ['trigger_hp_percent' => 15, 'next_hit_reduction_percent' => 20, 'counter_heal_percent' => 6, 'cooldown' => 2],
        ],
        'liet-hoa:75' => [
            'code' => 'heavenly-thunder-pursuit',
            'name' => 'Thiên Lôi Truy Kích',
            'activation_type' => 'mark_detonation',
            'description' => 'Đòn Điện đầu đặt Lôi Ấn; đòn Điện tiếp theo kích nổ ấn để tăng sát thương và khả năng gây hiệu ứng.',
            'parameters' => ['mark_duration' => 2, 'damage_percent' => 22, 'status_chance_bonus' => 10],
        ],
        'liet-hoa:87' => [
            'code' => 'nether-king-wrath',
            'name' => 'Minh Vương Chi Nộ',
            'activation_type' => 'hp_threshold',
            'description' => 'Khi HP xuống thấp, Minh Vương thanh tẩy một debuff và duy trì trạng thái cuồng chiến đến hết trận.',
            'parameters' => ['trigger_hp_percent' => 50, 'critical_hp_percent' => 25, 'damage_percent' => 15, 'critical_damage_percent' => 22, 'reduction_percent' => 10],
        ],
        'liet-hoa:99' => [
            'code' => 'astral-flow',
            'name' => 'Tinh Vân Lưu Chuyển',
            'activation_type' => 'successful_control',
            'description' => 'Debuff thành công tạo một nhịp tăng tốc và cường hóa đòn tấn công kế tiếp.',
            'parameters' => ['agility_percent' => 25, 'duration' => 2, 'next_damage_percent' => 15, 'cooldown' => 3],
        ],
        'cau-vong:85' => [
            'code' => 'underworld-judgment',
            'name' => 'U Minh Phán Quyết',
            'activation_type' => 'debuff_mastery',
            'description' => 'Định kỳ kéo dài debuff đầu tiên và tăng sát thương lên mục tiêu đang chịu trạng thái bất lợi.',
            'parameters' => ['duration_bonus' => 1, 'damage_percent' => 12, 'cooldown' => 3],
        ],
        'cau-vong:86' => [
            'code' => 'demon-king-descent',
            'name' => 'Ma Vương Giáng Thế',
            'activation_type' => 'execution',
            'description' => 'Gia tăng sức mạnh kết liễu khi mục tiêu đã suy yếu, nhưng thất bại sẽ khóa hiệu ứng trong hai hiệp.',
            'parameters' => ['target_hp_percent' => 35, 'damage_percent' => 18, 'defense_pierce_percent' => 10, 'failure_cooldown' => 2],
        ],
        'cau-vong:89' => [
            'code' => 'myriad-blossom-domain',
            'name' => 'Vạn Hoa Thánh Vực',
            'activation_type' => 'charge_cycle',
            'description' => 'Skill hỗ trợ tích Hoa Ấn; tấn công tiêu hao ấn để gây sát thương, hồi phục và thanh tẩy khi đạt tối đa.',
            'parameters' => ['maximum_charges' => 2, 'damage_percent_per_charge' => 12, 'heal_percent_per_charge' => 6, 'cleanse_at_charges' => 2],
        ],
        'cau-vong:92' => [
            'code' => 'realm-breaking-strike',
            'name' => 'Phá Giới Thần Kích',
            'activation_type' => 'attack_cycle',
            'description' => 'Mỗi đòn gây sát thương thứ ba xuyên giáp và gây thêm sát thương dựa trên HP hiện tại của mục tiêu.',
            'parameters' => ['attacks_required' => 3, 'defense_pierce_percent' => 20, 'current_hp_damage_percent' => 6, 'maximum_actor_hp_percent' => 10],
        ],
        'cau-vong:95' => [
            'code' => 'heavenly-fate-seal',
            'name' => 'Thiên Mệnh Phong Ấn',
            'activation_type' => 'failed_control',
            'description' => 'Debuff bị kháng tạo Thiên Mệnh, tăng độ chính xác và miễn tiêu hao PP cho lần áp dụng trạng thái kế tiếp.',
            'parameters' => ['status_chance_bonus' => 20, 'fate_duration' => 2, 'cooldown' => 3],
        ],
        'cau-vong:98' => [
            'code' => 'moonshadow-hunt',
            'name' => 'Nguyệt Ảnh Săn Hồn',
            'activation_type' => 'speed_charge',
            'description' => 'Ra đòn trước để tích Nguyệt Ấn, sau đó lựa chọn cường hóa sát thương hoặc kéo dài debuff.',
            'parameters' => ['maximum_charges' => 3, 'damage_charge_cost' => 1, 'damage_percent' => 15, 'debuff_charge_cost' => 2, 'duration_bonus' => 1],
        ],
        'cau-vong:101' => [
            'code' => 'holy-tide-song',
            'name' => 'Hải Triều Thánh Ca',
            'activation_type' => 'support_cycle',
            'description' => 'Skill hỗ trợ chuẩn bị Hải Triều; đòn Thủy kế tiếp gây thêm sát thương, hồi HP và phục hồi PP.',
            'parameters' => ['damage_percent' => 25, 'heal_percent' => 5, 'pp_restore' => 1, 'cooldown' => 3],
        ],
    ];

    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $pets = Pet::query()
            ->with('gameSource:id,slug')
            ->get()
            ->keyBy(fn (Pet $pet): string => "{$pet->gameSource->slug}:{$pet->game_id}");

        foreach (self::ABILITIES as $identity => $ability) {
            $pet = $pets->get($identity);

            if (! $pet instanceof Pet) {
                throw new RuntimeException("Cannot seed divine ability for missing Pet [{$identity}].");
            }

            $pet->update(['classification' => 'divine']);

            DivineAbility::query()->updateOrCreate(
                ['pet_id' => $pet->id],
                [...$ability, 'is_active' => true],
            );
        }
    }
}
