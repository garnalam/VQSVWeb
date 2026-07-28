import { queryParams, type RouteQueryOptions, type RouteDefinition, type RouteFormDefinition, applyUrlDefaults } from './../../../../../wayfinder'
/**
* @see \App\Http\Controllers\Wiki\SkillController::index
 * @see app/Http/Controllers/Wiki/SkillController.php:25
 * @route '/wiki/skills'
 */
export const index = (options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: index.url(options),
    method: 'get',
})

index.definition = {
    methods: ["get","head"],
    url: '/wiki/skills',
} satisfies RouteDefinition<["get","head"]>

/**
* @see \App\Http\Controllers\Wiki\SkillController::index
 * @see app/Http/Controllers/Wiki/SkillController.php:25
 * @route '/wiki/skills'
 */
index.url = (options?: RouteQueryOptions) => {
    return index.definition.url + queryParams(options)
}

/**
* @see \App\Http\Controllers\Wiki\SkillController::index
 * @see app/Http/Controllers/Wiki/SkillController.php:25
 * @route '/wiki/skills'
 */
index.get = (options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: index.url(options),
    method: 'get',
})
/**
* @see \App\Http\Controllers\Wiki\SkillController::index
 * @see app/Http/Controllers/Wiki/SkillController.php:25
 * @route '/wiki/skills'
 */
index.head = (options?: RouteQueryOptions): RouteDefinition<'head'> => ({
    url: index.url(options),
    method: 'head',
})

    /**
* @see \App\Http\Controllers\Wiki\SkillController::index
 * @see app/Http/Controllers/Wiki/SkillController.php:25
 * @route '/wiki/skills'
 */
    const indexForm = (options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
        action: index.url(options),
        method: 'get',
    })

            /**
* @see \App\Http\Controllers\Wiki\SkillController::index
 * @see app/Http/Controllers/Wiki/SkillController.php:25
 * @route '/wiki/skills'
 */
        indexForm.get = (options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
            action: index.url(options),
            method: 'get',
        })
            /**
* @see \App\Http\Controllers\Wiki\SkillController::index
 * @see app/Http/Controllers/Wiki/SkillController.php:25
 * @route '/wiki/skills'
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
* @see \App\Http\Controllers\Wiki\SkillController::show
 * @see app/Http/Controllers/Wiki/SkillController.php:307
 * @route '/wiki/skills/{skill}'
 */
export const show = (args: { skill: number | { id: number } } | [skill: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: show.url(args, options),
    method: 'get',
})

show.definition = {
    methods: ["get","head"],
    url: '/wiki/skills/{skill}',
} satisfies RouteDefinition<["get","head"]>

/**
* @see \App\Http\Controllers\Wiki\SkillController::show
 * @see app/Http/Controllers/Wiki/SkillController.php:307
 * @route '/wiki/skills/{skill}'
 */
show.url = (args: { skill: number | { id: number } } | [skill: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions) => {
    if (typeof args === 'string' || typeof args === 'number') {
        args = { skill: args }
    }

            if (typeof args === 'object' && !Array.isArray(args) && 'id' in args) {
            args = { skill: args.id }
        }
    
    if (Array.isArray(args)) {
        args = {
                    skill: args[0],
                }
    }

    args = applyUrlDefaults(args)

    const parsedArgs = {
                        skill: typeof args.skill === 'object'
                ? args.skill.id
                : args.skill,
                }

    return show.definition.url
            .replace('{skill}', parsedArgs.skill.toString())
            .replace(/\/+$/, '') + queryParams(options)
}

/**
* @see \App\Http\Controllers\Wiki\SkillController::show
 * @see app/Http/Controllers/Wiki/SkillController.php:307
 * @route '/wiki/skills/{skill}'
 */
show.get = (args: { skill: number | { id: number } } | [skill: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteDefinition<'get'> => ({
    url: show.url(args, options),
    method: 'get',
})
/**
* @see \App\Http\Controllers\Wiki\SkillController::show
 * @see app/Http/Controllers/Wiki/SkillController.php:307
 * @route '/wiki/skills/{skill}'
 */
show.head = (args: { skill: number | { id: number } } | [skill: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteDefinition<'head'> => ({
    url: show.url(args, options),
    method: 'head',
})

    /**
* @see \App\Http\Controllers\Wiki\SkillController::show
 * @see app/Http/Controllers/Wiki/SkillController.php:307
 * @route '/wiki/skills/{skill}'
 */
    const showForm = (args: { skill: number | { id: number } } | [skill: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
        action: show.url(args, options),
        method: 'get',
    })

            /**
* @see \App\Http\Controllers\Wiki\SkillController::show
 * @see app/Http/Controllers/Wiki/SkillController.php:307
 * @route '/wiki/skills/{skill}'
 */
        showForm.get = (args: { skill: number | { id: number } } | [skill: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
            action: show.url(args, options),
            method: 'get',
        })
            /**
* @see \App\Http\Controllers\Wiki\SkillController::show
 * @see app/Http/Controllers/Wiki/SkillController.php:307
 * @route '/wiki/skills/{skill}'
 */
        showForm.head = (args: { skill: number | { id: number } } | [skill: number | { id: number } ] | number | { id: number }, options?: RouteQueryOptions): RouteFormDefinition<'get'> => ({
            action: show.url(args, {
                        [options?.mergeQuery ? 'mergeQuery' : 'query']: {
                            _method: 'HEAD',
                            ...(options?.query ?? options?.mergeQuery ?? {}),
                        }
                    }),
            method: 'get',
        })
    
    show.form = showForm
const SkillController = { index, show }

export default SkillController