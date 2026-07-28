import { queryParams, type RouteQueryOptions, type RouteDefinition, type RouteFormDefinition, applyUrlDefaults } from './../../../../../wayfinder'
/**
* @see \App\Http\Controllers\Wiki\ItemController::index
 * @see app/Http/Controllers/Wiki/ItemController.php:18
 * @route '/wiki/items'
 */
export const index = (options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: index.url(options),
    method: 'get',
})

index.definition = {
    methods: ["get","head"],
    url: '/wiki/items',
} satisfies RouteDefinition<["get","head"]>

/**
* @see \App\Http\Controllers\Wiki\ItemController::index
 * @see app/Http/Controllers/Wiki/ItemController.php:18
 * @route '/wiki/items'
 */
index.url = (options?: RouteQueryOptions) => {
    return index.definition.url + queryParams(options)
}

/**
* @see \App\Http\Controllers\Wiki\ItemController::index
 * @see app/Http/Controllers/Wiki/ItemController.php:18
 * @route '/wiki/items'
 */
index.get = (options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: index.url(options),
    method: 'get',
})
/**
* @see \App\Http\Controllers\Wiki\ItemController::index
 * @see app/Http/Controllers/Wiki/ItemController.php:18
 * @route '/wiki/items'
 */
index.head = (options?: RouteQueryOptions): RouteDefinition<'head'> => ({
    url: index.url(options),
    method: 'head',
})

    /**
* @see \App\Http\Controllers\Wiki\ItemController::index
 * @see app/Http/Controllers/Wiki/ItemController.php:18
 * @route '/wiki/items'
 */
    const indexForm = (options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
        action: index.url(options),
        method: 'get',
    })

            /**
* @see \App\Http\Controllers\Wiki\ItemController::index
 * @see app/Http/Controllers/Wiki/ItemController.php:18
 * @route '/wiki/items'
 */
        indexForm.get = (options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
            action: index.url(options),
            method: 'get',
        })
            /**
* @see \App\Http\Controllers\Wiki\ItemController::index
 * @see app/Http/Controllers/Wiki/ItemController.php:18
 * @route '/wiki/items'
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
* @see \App\Http\Controllers\Wiki\ItemController::show
 * @see app/Http/Controllers/Wiki/ItemController.php:117
 * @route '/wiki/items/{item}'
 */
export const show = (args: { item: number | { id: number } } | [item: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: show.url(args, options),
    method: 'get',
})

show.definition = {
    methods: ["get","head"],
    url: '/wiki/items/{item}',
} satisfies RouteDefinition<["get","head"]>

/**
* @see \App\Http\Controllers\Wiki\ItemController::show
 * @see app/Http/Controllers/Wiki/ItemController.php:117
 * @route '/wiki/items/{item}'
 */
show.url = (args: { item: number | { id: number } } | [item: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions) => {
    if (typeof args === 'string' || typeof args === 'number') {
        args = { item: args }
    }

            if (typeof args === 'object' && !Array.isArray(args) && 'id' in args) {
            args = { item: args.id }
        }
    
    if (Array.isArray(args)) {
        args = {
                    item: args[0],
                }
    }

    args = applyUrlDefaults(args)

    const parsedArgs = {
                        item: typeof args.item === 'object'
                ? args.item.id
                : args.item,
                }

    return show.definition.url
            .replace('{item}', parsedArgs.item.toString())
            .replace(/\/+$/, '') + queryParams(options)
}

/**
* @see \App\Http\Controllers\Wiki\ItemController::show
 * @see app/Http/Controllers/Wiki/ItemController.php:117
 * @route '/wiki/items/{item}'
 */
show.get = (args: { item: number | { id: number } } | [item: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: show.url(args, options),
    method: 'get',
})
/**
* @see \App\Http\Controllers\Wiki\ItemController::show
 * @see app/Http/Controllers/Wiki/ItemController.php:117
 * @route '/wiki/items/{item}'
 */
show.head = (args: { item: number | { id: number } } | [item: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteDefinition<'head'> => ({
    url: show.url(args, options),
    method: 'head',
})

    /**
* @see \App\Http\Controllers\Wiki\ItemController::show
 * @see app/Http/Controllers/Wiki/ItemController.php:117
 * @route '/wiki/items/{item}'
 */
    const showForm = (args: { item: number | { id: number } } | [item: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
        action: show.url(args, options),
        method: 'get',
    })

            /**
* @see \App\Http\Controllers\Wiki\ItemController::show
 * @see app/Http/Controllers/Wiki/ItemController.php:117
 * @route '/wiki/items/{item}'
 */
        showForm.get = (args: { item: number | { id: number } } | [item: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
            action: show.url(args, options),
            method: 'get',
        })
            /**
* @see \App\Http\Controllers\Wiki\ItemController::show
 * @see app/Http/Controllers/Wiki/ItemController.php:117
 * @route '/wiki/items/{item}'
 */
        showForm.head = (args: { item: number | { id: number } } | [item: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
            action: show.url(args, {
                        [options?.mergeQuery ? 'mergeQuery' : 'query']: {
                            _method: 'HEAD',
                            ...(options?.query ?? options?.mergeQuery ?? {}),
                        }
                    }),
            method: 'get',
        })
    
    show.form = showForm
const ItemController = { index, show }

export default ItemController