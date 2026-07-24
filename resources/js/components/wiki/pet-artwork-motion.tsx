import type { ReactNode } from 'react';
import { useState } from 'react';
import { petSkillAnimationUrl } from '@/lib/game-assets';
import { cn } from '@/lib/utils';
import { GameArtwork } from './game-artwork';

type PetArtworkMotionProps = {
    spriteId: number;
    assetKey: string;
    staticSrc: string;
    alt: string;
    fallback: ReactNode;
    className?: string;
    imageClassName?: string;
};

export function PetArtworkMotion({
    spriteId,
    assetKey,
    staticSrc,
    alt,
    fallback,
    className,
    imageClassName,
}: PetArtworkMotionProps) {
    const [playbackId, setPlaybackId] = useState(0);
    const [isPlaying, setIsPlaying] = useState(false);
    const [isAnimationReady, setIsAnimationReady] = useState(false);
    const animationSrc = petSkillAnimationUrl(spriteId, assetKey);

    const startAnimation = () => {
        if (
            typeof window !== 'undefined' &&
            window.matchMedia('(prefers-reduced-motion: reduce)').matches
        ) {
            return;
        }

        setIsAnimationReady(false);
        setPlaybackId((currentId) => currentId + 1);
        setIsPlaying(true);
    };

    const stopAnimation = () => {
        setIsPlaying(false);
        setIsAnimationReady(false);
    };

    return (
        <div
            onMouseEnter={startAnimation}
            onMouseLeave={stopAnimation}
            data-pet-animation={isPlaying ? 'skill' : 'idle'}
            className={cn('relative isolate cursor-crosshair', className)}
        >
            <div
                data-pet-animation-stage
                className={cn('relative shrink-0', imageClassName)}
            >
                <GameArtwork
                    src={staticSrc}
                    alt={alt}
                    className={cn(
                        'relative z-10 h-full w-full transition-opacity duration-100',
                        isAnimationReady && 'opacity-0',
                    )}
                    fallback={fallback}
                />

                {isPlaying && (
                    <img
                        key={`${animationSrc}-${playbackId}`}
                        src={`${animationSrc}?play=${playbackId}`}
                        alt=""
                        aria-hidden="true"
                        decoding="async"
                        onLoad={() => setIsAnimationReady(true)}
                        onError={stopAnimation}
                        className={cn(
                            'wiki-pixel-art pointer-events-none absolute inset-0 z-20 h-full w-full object-contain opacity-0 drop-shadow-[0_16px_14px_rgba(2,6,23,0.34)] transition-opacity duration-100',
                            isAnimationReady && 'opacity-100',
                        )}
                    />
                )}
            </div>
        </div>
    );
}
