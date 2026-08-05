import { queryParams, type RouteQueryOptions, type RouteDefinition, type RouteFormDefinition, applyUrlDefaults } from './../../../wayfinder'
/**
* @see \App\Http\Controllers\Wiki\PetController::index
 * @see app/Http/Controllers/Wiki/PetController.php:33
 * @route '/wiki/pets'
 */
export const index = (options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: index.url(options),
    method: 'get',
})

index.definition = {
    methods: ["get","head"],
    url: '/wiki/pets',
} satisfies RouteDefinition<["get","head"]>

/**
* @see \App\Http\Controllers\Wiki\PetController::index
 * @see app/Http/Controllers/Wiki/PetController.php:33
 * @route '/wiki/pets'
 */
index.url = (options?: RouteQueryOptions) => {
    return index.definition.url + queryParams(options)
}

/**
* @see \App\Http\Controllers\Wiki\PetController::index
 * @see app/Http/Controllers/Wiki/PetController.php:33
 * @route '/wiki/pets'
 */
index.get = (options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: index.url(options),
    method: 'get',
})
/**
* @see \App\Http\Controllers\Wiki\PetController::index
 * @see app/Http/Controllers/Wiki/PetController.php:33
 * @route '/wiki/pets'
 */
index.head = (options?: RouteQueryOptions): RouteDefinition<'head'> => ({
    url: index.url(options),
    method: 'head',
})

    /**
* @see \App\Http\Controllers\Wiki\PetController::index
 * @see app/Http/Controllers/Wiki/PetController.php:33
 * @route '/wiki/pets'
 */
    const indexForm = (options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
        action: index.url(options),
        method: 'get',
    })

            /**
* @see \App\Http\Controllers\Wiki\PetController::index
 * @see app/Http/Controllers/Wiki/PetController.php:33
 * @route '/wiki/pets'
 */
        indexForm.get = (options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
            action: index.url(options),
            method: 'get',
        })
            /**
* @see \App\Http\Controllers\Wiki\PetController::index
 * @see app/Http/Controllers/Wiki/PetController.php:33
 * @route '/wiki/pets'
 */
        indexForm.head = (options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
            action: index.url({
                        [options?.mergeQuery ? 'mergeQuery' : 'query']: {
                            _method: 'HEAD',
                            ...(options?.query ?? options?.mergeQuery ?? {}),
                        }
                    }),
            method: 'get',
        })
    
    index.form = indexForm
/**
* @see \App\Http\Controllers\Wiki\PetController::show
 * @see app/Http/Controllers/Wiki/PetController.php:211
 * @route '/wiki/pets/{pet}'
 */
export const show = (args: { pet: number | { id: number } } | [pet: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: show.url(args, options),
    method: 'get',
})

show.definition = {
    methods: ["get","head"],
    url: '/wiki/pets/{pet}',
} satisfies RouteDefinition<["get","head"]>

/**
* @see \App\Http\Controllers\Wiki\PetController::show
 * @see app/Http/Controllers/Wiki/PetController.php:211
 * @route '/wiki/pets/{pet}'
 */
show.url = (args: { pet: number | { id: number } } | [pet: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions) => {
    if (typeof args === 'string' || typeof args === 'number') {
        args = { pet: args }
    }

            if (typeof args === 'object' && !Array.isArray(args) && 'id' in args) {
            args = { pet: args.id }
        }
    
    if (Array.isArray(args)) {
        args = {
                    pet: args[0],
                }
    }

    args = applyUrlDefaults(args)

    const parsedArgs = {
                        pet: typeof args.pet === 'object'
                ? args.pet.id
                : args.pet,
                }

    return show.definition.url
            .replace('{pet}', parsedArgs.pet.toString())
            .replace(/\/+$/, '') + queryParams(options)
}

/**
* @see \App\Http\Controllers\Wiki\PetController::show
 * @see app/Http/Controllers/Wiki/PetController.php:211
 * @route '/wiki/pets/{pet}'
 */
show.get = (args: { pet: number | { id: number } } | [pet: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: show.url(args, options),
    method: 'get',
})
/**
* @see \App\Http\Controllers\Wiki\PetController::show
 * @see app/Http/Controllers/Wiki/PetController.php:211
 * @route '/wiki/pets/{pet}'
 */
show.head = (args: { pet: number | { id: number } } | [pet: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteDefinition<'head'> => ({
    url: show.url(args, options),
    method: 'head',
})

    /**
* @see \App\Http\Controllers\Wiki\PetController::show
 * @see app/Http/Controllers/Wiki/PetController.php:211
 * @route '/wiki/pets/{pet}'
 */
    const showForm = (args: { pet: number | { id: number } } | [pet: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
        action: show.url(args, options),
        method: 'get',
    })

            /**
* @see \App\Http\Controllers\Wiki\PetController::show
 * @see app/Http/Controllers/Wiki/PetController.php:211
 * @route '/wiki/pets/{pet}'
 */
        showForm.get = (args: { pet: number | { id: number } } | [pet: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
            action: show.url(args, options),
            method: 'get',
        })
            /**
* @see \App\Http\Controllers\Wiki\PetController::show
 * @see app/Http/Controllers/Wiki/PetController.php:211
 * @route '/wiki/pets/{pet}'
 */
        showForm.head = (args: { pet: number | { id: number } } | [pet: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
            action: show.url(args, {
                        [options?.mergeQuery ? 'mergeQuery' : 'query']: {
                            _method: 'HEAD',
                            ...(options?.query ?? options?.mergeQuery ?? {}),
                        }
                    }),
            method: 'get',
        })
    
    show.form = showForm
const pets = {
    index: Object.assign(index, index),
show: Object.assign(show, show),
}

export default pets