<?php

namespace App\Http\Requests\Wiki;

use App\Models\Element;
use App\Models\GameSource;
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
            'game' => ['nullable', 'string', Rule::exists(GameSource::class, 'slug')],
            'element' => ['nullable', 'integer', Rule::exists(Element::class, 'game_id')],
            'tier' => ['nullable', 'integer', 'between:0,5'],
            'kind' => ['nullable', Rule::in(['damage', 'status'])],
            'effect' => ['nullable', Rule::in(['none', 'beneficial', 'harmful'])],
            'target' => ['nullable', Rule::in(['opponent', 'self'])],
            'sort' => ['nullable', Rule::in(['game_id', 'name', 'power', 'tier'])],
        ];
    }
}
