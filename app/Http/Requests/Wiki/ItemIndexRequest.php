<?php

namespace App\Http\Requests\Wiki;

use App\Models\GameSource;
use App\Models\Item;
use Illuminate\Contracts\Validation\ValidationRule;
use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Validation\Rule;

class ItemIndexRequest extends FormRequest
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
            'source_table' => ['nullable', 'integer', 'between:0,5'],
            'category' => ['nullable', 'string', Rule::exists(Item::class, 'category')],
            'sort' => ['nullable', Rule::in(['game_id', 'name', 'cost'])],
        ];
    }
}
