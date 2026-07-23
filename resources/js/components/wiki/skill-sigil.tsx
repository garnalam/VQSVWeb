import type { CSSProperties } from 'react';
import { elementIconUrl, skillArtworkUrl } from '@/lib/game-assets';
import { cn } from '@/lib/utils';
import type { WikiElement, WikiGameSource } from '@/types';

type SkillSigilProps = {
    element: WikiElement;
    skillId: number;
    powerPercent: number;
    effectMode: number;
    gameSource?: WikiGameSource;
    className?: string;
};

export function SkillSigil({
    element,
    skillId,
    powerPercent,
    effectMode,
    gameSource,
    className,
}: SkillSigilProps) {
    const accent = element.color ?? '#67e8f9';
    const style = {
        '--sigil-accent': accent,
        '--sigil-power': `${Math.max(20, Math.min(powerPercent, 100))}%`,
        '--sigil-angle': `${(skillId * 37) % 360}deg`,
    } as CSSProperties;

    return (
        <div
            style={style}
            className={cn(
                'relative isolate flex size-15 items-center justify-center',
                className,
            )}
            aria-hidden="true"
        >
            <span className="absolute inset-0 rotate-[var(--sigil-angle)] border border-[var(--sigil-accent)]/28 [clip-path:polygon(50%_0,100%_28%,88%_84%,50%_100%,12%_84%,0_28%)]" />
            <span className="absolute inset-1.5 rounded-full border border-dashed border-[var(--sigil-accent)]/35 motion-safe:animate-[spin_18s_linear_infinite]" />
            <span className="absolute inset-3 rounded-full bg-[var(--sigil-accent)]/13 shadow-[0_0_22px_color-mix(in_oklab,var(--sigil-accent)_26%,transparent)]" />
            <span className="absolute right-0 bottom-1 left-0 mx-auto h-0.5 w-[var(--sigil-power)] max-w-10 bg-[var(--sigil-accent)]/55" />
            <img
                src={
                    gameSource?.asset_key === 'cau-vong'
                        ? skillArtworkUrl(skillId, gameSource.asset_key)
                        : elementIconUrl(element.game_id)
                }
                alt=""
                className={cn(
                    'wiki-pixel-art relative z-10 object-contain drop-shadow-[0_5px_3px_rgba(0,0,0,.45)]',
                    gameSource?.asset_key === 'cau-vong'
                        ? 'size-13'
                        : 'size-8',
                )}
            />
            <span className="absolute -right-1 -bottom-1 flex size-4 items-center justify-center border border-[var(--sigil-accent)]/55 bg-[#071421] font-mono text-[7px] font-black text-[var(--sigil-accent)]">
                {effectMode === 0 ? 'DM' : 'FX'}
            </span>
        </div>
    );
}
