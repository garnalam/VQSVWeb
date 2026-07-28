<?php

namespace App\Support;

use App\Models\Pet;
use App\Models\PetEvolution;
use Illuminate\Database\Eloquent\Collection;

class PetEvolutionStageResolver
{
    /** @var array<string, string> */
    public const TIER_LABELS = [
        'standalone' => 'Pet độc lập',
        'initial' => 'Form đầu',
        'middle_early' => 'Form giữa sớm',
        'middle_late' => 'Form giữa muộn',
        'final' => 'Form cuối',
    ];

    /**
     * Resolve normalized evolution tiers for an entire Pet roster.
     *
     * @param  Collection<int, Pet>  $pets
     * @param  Collection<int, PetEvolution>  $evolutions
     * @return array<int, array{family_root_id: int, form_number: int, family_max_forms: int, progress_ratio: float, evolution_tier: string, evolution_tier_label: string, has_previous_form: bool, has_next_form: bool}>
     */
    public function resolve(Collection $pets, Collection $evolutions): array
    {
        $incoming = [];
        $outgoing = [];

        foreach ($evolutions as $evolution) {
            $incoming[$evolution->to_pet_id] ??= [];
            $incoming[$evolution->to_pet_id][] = $evolution->from_pet_id;
            $outgoing[$evolution->from_pet_id] ??= [];
            $outgoing[$evolution->from_pet_id][] = $evolution->to_pet_id;
        }

        $positions = [];
        $maximumDepthByRoot = [];

        foreach ($pets as $pet) {
            [$rootId, $stage] = $this->positionInFamily($pet->id, $incoming);
            $positions[$pet->id] = ['root_id' => $rootId, 'stage' => $stage];
            $maximumDepthByRoot[$rootId] = max($maximumDepthByRoot[$rootId] ?? 0, $stage);
        }

        $metadata = [];

        foreach ($pets as $pet) {
            $position = $positions[$pet->id];
            $maximumDepth = $maximumDepthByRoot[$position['root_id']];
            $hasPreviousForm = isset($incoming[$pet->id]);
            $hasNextForm = isset($outgoing[$pet->id]);
            $progressRatio = $maximumDepth === 0 ? 1.0 : $position['stage'] / $maximumDepth;
            $evolutionTier = $this->evolutionTier(
                $hasPreviousForm,
                $hasNextForm,
                $progressRatio,
            );

            $metadata[$pet->id] = [
                'family_root_id' => $position['root_id'],
                'form_number' => $position['stage'] + 1,
                'family_max_forms' => $maximumDepth + 1,
                'progress_ratio' => round($progressRatio, 4),
                'evolution_tier' => $evolutionTier,
                'evolution_tier_label' => self::TIER_LABELS[$evolutionTier],
                'has_previous_form' => $hasPreviousForm,
                'has_next_form' => $hasNextForm,
            ];
        }

        return $metadata;
    }

    /**
     * @param  array<int, list<int>>  $incoming
     * @return array{0: int, 1: int}
     */
    private function positionInFamily(int $petId, array $incoming): array
    {
        $currentPetId = $petId;
        $stage = 0;
        $visited = [];

        while (isset($incoming[$currentPetId]) && ! isset($visited[$currentPetId])) {
            $visited[$currentPetId] = true;
            $parentPetIds = $incoming[$currentPetId];

            if ($parentPetIds === []) {
                break;
            }

            $currentPetId = min($parentPetIds);
            $stage++;
        }

        return [$currentPetId, $stage];
    }

    private function evolutionTier(bool $hasPreviousForm, bool $hasNextForm, float $progressRatio): string
    {
        if (! $hasPreviousForm && ! $hasNextForm) {
            return 'standalone';
        }

        if (! $hasPreviousForm) {
            return 'initial';
        }

        if (! $hasNextForm) {
            return 'final';
        }

        return $progressRatio <= 0.5 ? 'middle_early' : 'middle_late';
    }
}
