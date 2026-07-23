<?php

namespace App\Http\Requests\Wiki;

use App\Models\GameSource;
use App\Models\Pet;
use Illuminate\Contracts\Validation\ValidationRule;
use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Validation\Rule;

class PetIndexRequest extends FormRequest
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
            'game' => ['nullable', 'string', Rule::exists(GameSource::class, 'slug')],
            'element' => ['nullable', Rule::in(array_keys(Pet::COMBAT_ELEMENTS))],
            'species' => ['nullable', Rule::in(array_keys(Pet::SPECIES))],
            'learning_group' => ['nullable', 'integer', 'between:0,255'],
            'evolution' => ['nullable', Rule::in(['has', 'none'])],
            'sort' => ['nullable', Rule::in(['family', 'game_id', 'name', 'learning_group'])],
        ];
    }
}
