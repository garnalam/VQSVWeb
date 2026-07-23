import type { CSSProperties } from 'react';
import type { WikiElement } from '@/types';

export function ElementBadge({ element }: { element: WikiElement }) {
    const color = element.color ?? '#64748b';
    const style = {
        '--element-color': color,
    } as CSSProperties;

    return (
        <span
            style={style}
            className="inline-flex h-6 w-fit items-center gap-2 border border-[var(--element-color)]/45 bg-[var(--element-color)]/10 px-2.5 font-mono text-[9px] font-black tracking-[.13em] text-[var(--element-color)] uppercase shadow-[inset_3px_0_0_var(--element-color)] [clip-path:polygon(0_0,calc(100%_-_7px)_0,100%_50%,calc(100%_-_7px)_100%,0_100%)]"
        >
            <span className="size-1.5 rotate-45 bg-[var(--element-color)] shadow-[0_0_8px_var(--element-color)]" />
            {element.name}
        </span>
    );
}
