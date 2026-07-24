import { Dna } from 'lucide-react';
import type { CSSProperties } from 'react';
import type { WikiPetTrait } from '@/types';

export function TraitBadge({
    trait,
    color = '#a78bfa',
    className = '',
}: {
    trait: WikiPetTrait;
    color?: string;
    className?: string;
}) {
    const style = { '--trait-color': color } as CSSProperties;

    return (
        <span
            style={style}
            className={`inline-flex w-fit items-center gap-2 rounded-full border border-[var(--trait-color)]/35 bg-[var(--trait-color)]/10 px-3 py-1.5 text-xs font-extrabold text-[var(--trait-color)] ${className}`}
            title={trait.description}
        >
            <Dna className="size-3.5" />
            {trait.name}
        </span>
    );
}
