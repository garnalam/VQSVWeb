<?php

namespace App\Http\Requests\Wiki;

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
            'category' => [
                'nullable',
                'string',
                Rule::exists(Item::class, 'category')->where('is_active', true),
            ],
            'sort' => ['nullable', Rule::in(['game_id', 'name', 'cost'])],
        ];
    }
}
