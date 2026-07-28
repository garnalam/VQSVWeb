<?php

namespace App\Console\Commands;

use App\Support\PetBalanceAudit;
use Illuminate\Console\Attributes\Description;
use Illuminate\Console\Attributes\Signature;
use Illuminate\Console\Command;

#[Signature('game:audit-pet-balance {--opponents=12 : Number of nearby opponents selected per Pet} {--seeds=5 : Deterministic simulations per matchup} {--json : Emit the complete JSON report}')]
#[Description('Audit level-50, three-star 1v1 balance for the complete Pet roster')]
class PetBalanceAuditCommand extends Command
{
    /**
     * Execute the console command.
     */
    public function handle(PetBalanceAudit $audit): int
    {
        $opponents = max(2, (int) $this->option('opponents'));
        $seeds = max(1, (int) $this->option('seeds'));
        $report = $audit->run($opponents, $seeds);

        if ($this->option('json')) {
            $this->line((string) json_encode($report, JSON_PRETTY_PRINT | JSON_UNESCAPED_UNICODE));

            return self::SUCCESS;
        }

        $this->components->info('Kiểm thử cân bằng Pet 1v1 hoàn tất');
        $this->table(['Chỉ số', 'Kết quả'], collect($report['summary'])
            ->map(fn (int|float $value, string $key): array => [$key, $value])
            ->values()
            ->all());

        foreach (['by_evolution_tier' => 'Theo bậc tiến hóa', 'by_power_class' => 'Theo tầng sức mạnh', 'by_element' => 'Theo Hệ', 'by_species' => 'Theo Chủng', 'by_role' => 'Theo vai trò', 'by_source' => 'Theo nguồn dữ liệu'] as $key => $label) {
            $this->newLine();
            $this->components->twoColumnDetail($label, '');
            $this->table(
                ['Nhóm', 'Pet', 'Trận', 'Thắng %', 'Hòa %', 'Hiệp TB'],
                collect($report[$key])->map(fn (array $group, string $name): array => [
                    $name,
                    $group['pets'],
                    $group['games'],
                    $group['win_rate'],
                    $group['draw_rate'],
                    $group['average_rounds'],
                ])->values()->all(),
            );
        }

        $this->renderOutliers('Pet dưới 35% thắng', $report['outliers']['low']);
        $this->renderOutliers('Pet trên 65% thắng', $report['outliers']['high']);
        $this->renderOutliers('Pet có dấu hiệu kéo dài trận', $report['outliers']['stall']);
        $this->renderOutliers('Deck thiếu ít nhất 2 chiêu gây sát thương', $report['invalid_decks']);

        return self::SUCCESS;
    }

    /** @param list<array<string, mixed>> $pets */
    private function renderOutliers(string $label, array $pets): void
    {
        $this->newLine();
        $this->components->twoColumnDetail($label, (string) count($pets));

        if ($pets === []) {
            return;
        }

        $this->table(
            ['ID', 'Pet', 'Bậc tiến hóa', 'Nguồn', 'Hệ', 'Vai trò', 'Thắng %', 'Hòa %', 'Hiệp TB', 'Damage Skill'],
            collect($pets)->take(20)->map(fn (array $pet): array => [
                $pet['id'],
                $pet['name'],
                $pet['evolution_tier_label'],
                $pet['game_source'],
                $pet['combat_element'],
                $pet['primary_role'],
                $pet['win_rate'],
                $pet['draw_rate'],
                $pet['average_rounds'],
                $pet['damage_skills'],
            ])->all(),
        );
    }
}
