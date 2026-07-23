import { Gamepad2 } from 'lucide-react';
import type { CSSProperties } from 'react';
import type { WikiGameSource } from '@/types';

export function GameSourceBadge({ source }: { source: WikiGameSource }) {
    return (
        <span
            style={{ '--source-color': source.color } as CSSProperties}
            className="inline-flex w-fit items-center gap-1.5 rounded-full border border-[var(--source-color)]/35 bg-[var(--source-color)]/12 px-2.5 py-1 text-[10px] font-black tracking-[.08em] text-[var(--source-color)] uppercase shadow-[0_0_18px_color-mix(in_oklab,var(--source-color)_14%,transparent)]"
        >
            <Gamepad2 className="size-3" />
            {source.name}
        </span>
    );
}
