<?php

namespace App\Http\Requests\Wiki;

use App\Models\Pet;
use App\Models\Skill;
use App\Support\UnifiedPetLearnsetCatalog;
use Illuminate\Contracts\Validation\ValidationRule;
use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Validation\Rule;

class SkillIndexRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    public function authorize(): bool
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        return [
            'q' => ['nullable', 'string', 'max:100'],
            'element' => ['nullable', Rule::in(array_keys(Pet::COMBAT_ELEMENTS))],
            'tier' => ['nullable', 'integer', 'between:0,3'],
            'effect' => ['nullable', Rule::in(['none', 'beneficial', 'harmful'])],
            'target' => ['nullable', Rule::in(array_keys(Skill::TARGET_PATTERNS))],
            'source' => ['nullable', Rule::in(['element', 'species', 'style', 'signature'])],
            'role' => ['nullable', Rule::in(['attack', 'defense', 'heal', 'control', 'disrupt', 'modifier'])],
            'unlock' => ['nullable', 'integer', Rule::in(UnifiedPetLearnsetCatalog::UNLOCK_MILESTONES)],
            'sort' => ['nullable', Rule::in(['id', 'name', 'power', 'tier'])],
        ];
    }
}
