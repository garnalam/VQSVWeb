type WikiQueryValue = string | number | null | undefined;

export function compactWikiQuery(
    values: Record<string, WikiQueryValue>,
): Record<string, string | number> {
    return Object.fromEntries(
        Object.entries(values).filter(
            ([, value]) =>
                value !== null && value !== undefined && value !== '',
        ),
    ) as Record<string, string | number>;
}
