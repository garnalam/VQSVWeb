import { GameArtwork } from '@/components/wiki/game-artwork';
import { effectIconUrl } from '@/lib/game-assets';
import { cn } from '@/lib/utils';
import type { WikiEffect } from '@/types';

type EffectIconProps = {
    effect: WikiEffect;
    className?: string;
};

export function EffectIcon({ effect, className }: EffectIconProps) {
    const isBeneficial = effect.kind === 'beneficial';

    return (
        <span
            className={cn(
                'relative flex size-10 shrink-0 items-center justify-center border bg-[#071421]',
                isBeneficial
                    ? 'border-emerald-400/35 shadow-[inset_0_0_14px_rgba(52,211,153,.08),0_0_14px_rgba(52,211,153,.08)]'
                    : 'border-rose-400/35 shadow-[inset_0_0_14px_rgba(251,113,133,.08),0_0_14px_rgba(251,113,133,.08)]',
                className,
            )}
        >
            <span
                className={cn(
                    'absolute top-0 left-0 size-1.5',
                    isBeneficial ? 'bg-emerald-400' : 'bg-rose-400',
                )}
            />
            <GameArtwork
                src={effectIconUrl(
                    effect.kind,
                    effect.game_id,
                    effect.source_table,
                )}
                alt={`Icon ${effect.name} trong game`}
                className="size-7 drop-shadow-[0_3px_5px_rgba(0,0,0,.55)]"
                fallback={
                    <span
                        className={cn(
                            'font-mono text-[9px] font-black',
                            isBeneficial ? 'text-emerald-300' : 'text-rose-300',
                        )}
                    >
                        {isBeneficial ? 'UP' : 'DN'}
                    </span>
                }
            />
        </span>
    );
}

type EffectBadgeProps = {
    effect: WikiEffect;
    className?: string;
};

export function EffectBadge({ effect, className }: EffectBadgeProps) {
    return (
        <div className={cn('flex min-w-0 items-center gap-2.5', className)}>
            <EffectIcon effect={effect} />
            <div className="min-w-0">
                <span className="block truncate font-semibold text-slate-100">
                    {effect.name}
                </span>
                <span
                    className={cn(
                        'font-mono text-[8px] font-black tracking-[.12em] uppercase',
                        effect.kind === 'beneficial'
                            ? 'text-emerald-400'
                            : 'text-rose-400',
                    )}
                >
                    {effect.kind === 'beneficial' ? 'Buff' : 'Debuff'}
                    {effect.duration === null
                        ? ''
                        : ` · ${effect.duration} hiệp`}
                </span>
            </div>
        </div>
    );
}
