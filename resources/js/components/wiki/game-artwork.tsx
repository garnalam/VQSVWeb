import type { ReactNode } from 'react';
import { useState } from 'react';
import { cn } from '@/lib/utils';

type GameArtworkProps = {
    src: string | null;
    alt: string;
    className?: string;
    fallback: ReactNode;
};

export function GameArtwork({
    src,
    alt,
    className,
    fallback,
}: GameArtworkProps) {
    const [failedSrc, setFailedSrc] = useState<string | null>(null);

    if (src === null || failedSrc === src) {
        return fallback;
    }

    return (
        <img
            src={src}
            alt={alt}
            loading="lazy"
            decoding="async"
            onError={() => setFailedSrc(src)}
            className={cn(
                'wiki-pixel-art object-contain drop-shadow-[0_16px_14px_rgba(2,6,23,0.34)]',
                className,
            )}
        />
    );
}
