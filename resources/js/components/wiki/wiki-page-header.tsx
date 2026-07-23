import type { CSSProperties, ReactNode } from 'react';
import {
    elementIconUrl,
    itemArtworkUrl,
    petArtworkUrl,
} from '@/lib/game-assets';

type WikiTheme = 'pets' | 'skills' | 'items';

const HERO_THEMES: Record<
    WikiTheme,
    {
        accent: string;
        hot: string;
        code: string;
        label: string;
        status: string;
        artworks: string[];
    }
> = {
    pets: {
        accent: '#ffbd24',
        hot: '#ff5c35',
        code: '01',
        label: 'BESTIARY',
        status: 'SINH VẬT / NGUYÊN TỐ',
        artworks: [petArtworkUrl(185), petArtworkUrl(126)],
    },
    skills: {
        accent: '#66ecff',
        hot: '#f14cff',
        code: '02',
        label: 'MOVE LAB',
        status: 'SỨC MẠNH / HIỆU ỨNG',
        artworks: [elementIconUrl(4), elementIconUrl(5)],
    },
    items: {
        accent: '#79ffac',
        hot: '#ffe34c',
        code: '03',
        label: 'ITEM VAULT',
        status: 'VẬT PHẨM / CÔNG DỤNG',
        artworks: [
            itemArtworkUrl(3) ?? '',
            itemArtworkUrl(30) ?? '',
            itemArtworkUrl(43) ?? '',
        ],
    },
};

type WikiPageHeaderProps = {
    eyebrow: string;
    title: string;
    description: string;
    total: number;
    unit: string;
    icon: ReactNode;
    theme: WikiTheme;
};

export function WikiPageHeader({
    eyebrow,
    title,
    description,
    total,
    unit,
    icon,
    theme,
}: WikiPageHeaderProps) {
    const themeConfig = HERO_THEMES[theme];
    const themeStyle = {
        '--wiki-accent': themeConfig.accent,
        '--wiki-hot': themeConfig.hot,
    } as CSSProperties;

    return (
        <section
            style={themeStyle}
            className="wiki-console relative isolate min-h-70 overflow-hidden border border-[var(--wiki-accent)]/28 bg-[#071426]/92 shadow-[0_26px_70px_rgba(0,0,0,.35)] [clip-path:polygon(0_22px,22px_0,calc(100%_-_76px)_0,calc(100%_-_52px)_22px,100%_22px,100%_calc(100%_-_20px),calc(100%_-_20px)_100%,20px_100%,0_calc(100%_-_20px))]"
        >
            <div className="absolute inset-x-0 top-0 h-[3px] bg-linear-to-r from-[var(--wiki-accent)] via-[var(--wiki-hot)] to-transparent shadow-[0_0_18px_var(--wiki-accent)]" />
            <div className="absolute inset-0 -z-10 bg-[radial-gradient(circle_at_78%_48%,color-mix(in_oklab,var(--wiki-hot)_25%,transparent),transparent_25%),linear-gradient(112deg,rgba(7,20,38,.98)_0%,rgba(8,30,48,.95)_58%,rgba(12,18,34,.82)_100%)]" />
            <div className="wiki-grid absolute inset-0 -z-10 [mask-image:linear-gradient(90deg,black,transparent_70%)] opacity-30" />
            <div className="absolute top-7 bottom-7 left-4 hidden w-8 border-y border-l border-[var(--wiki-accent)]/40 md:block">
                <span className="absolute top-1/2 -left-3 -rotate-90 font-mono text-[8px] font-black tracking-[.28em] text-[var(--wiki-accent)] uppercase">
                    Database
                </span>
            </div>

            <div className="grid min-h-70 md:grid-cols-[minmax(0,1.2fr)_minmax(17rem,.72fr)_10rem]">
                <div className="relative flex flex-col justify-center px-6 py-9 sm:px-10 md:pl-16 lg:px-20">
                    <div className="flex items-center gap-3">
                        <span className="flex h-6 items-center bg-[var(--wiki-accent)] px-2.5 font-mono text-[9px] font-black tracking-[.18em] text-[#06101d] [clip-path:polygon(0_0,calc(100%_-_8px)_0,100%_50%,calc(100%_-_8px)_100%,0_100%)]">
                            FILE {themeConfig.code}
                        </span>
                        <span className="font-mono text-[9px] font-black tracking-[.22em] text-[var(--wiki-accent)] uppercase">
                            {eyebrow}
                        </span>
                    </div>

                    <h1 className="mt-4 text-4xl leading-[.95] font-black tracking-[-.055em] text-white sm:text-5xl lg:text-6xl">
                        {title}
                    </h1>
                    <p className="mt-4 max-w-2xl text-sm leading-6 font-medium text-slate-300 sm:text-[15px]">
                        {description}
                    </p>

                    <div className="mt-6 flex flex-wrap items-center gap-x-5 gap-y-2 font-mono text-[9px] font-bold tracking-[.16em] text-slate-400 uppercase">
                        <span className="flex items-center gap-2 text-[var(--wiki-accent)]">
                            <i className="wiki-signal size-2 rounded-full bg-emerald-400" />
                            Data online
                        </span>
                        <span>{themeConfig.status}</span>
                        <span className="hidden sm:inline">
                            Build // VQSV-WIKI
                        </span>
                    </div>
                </div>

                <div className="relative hidden min-h-70 items-center justify-center overflow-hidden border-x border-white/6 bg-[linear-gradient(120deg,transparent,rgba(255,255,255,.035),transparent)] md:flex">
                    <div className="absolute size-52 rotate-45 border border-[var(--wiki-accent)]/18" />
                    <div className="absolute size-40 rounded-full border border-dashed border-[var(--wiki-hot)]/34 motion-safe:animate-[spin_24s_linear_infinite]" />
                    <div className="absolute size-28 rounded-full bg-[var(--wiki-hot)]/14 blur-2xl" />
                    <span className="absolute top-5 right-5 font-mono text-[9px] tracking-[.16em] text-white/30">
                        ARTIFACT // {themeConfig.code}
                    </span>
                    <span className="absolute bottom-5 left-5 h-px w-16 bg-[var(--wiki-accent)] shadow-[0_0_12px_var(--wiki-accent)]" />
                    {themeConfig.artworks.map((artwork, index) => (
                        <img
                            key={`${artwork}-${index}`}
                            src={artwork}
                            alt=""
                            style={{
                                animationDelay: `-${index * 1.7}s`,
                            }}
                            className={
                                index === 0
                                    ? 'wiki-pixel-art wiki-float relative z-10 h-40 w-52 scale-110 object-contain drop-shadow-[0_24px_8px_rgba(0,0,0,.38)]'
                                    : 'wiki-pixel-art wiki-float absolute right-8 bottom-8 z-20 h-20 w-24 object-contain opacity-75 drop-shadow-[0_12px_8px_rgba(0,0,0,.45)]'
                            }
                        />
                    ))}
                </div>

                <div className="relative flex items-center justify-between gap-4 border-t border-white/7 bg-black/18 px-6 py-5 md:flex-col md:items-stretch md:justify-center md:border-t-0 md:px-5">
                    <span className="absolute top-0 right-0 border-t-[12px] border-r-[12px] border-t-[var(--wiki-accent)] border-r-transparent" />
                    <img
                        src={themeConfig.artworks[0]}
                        alt=""
                        className="wiki-pixel-art wiki-float absolute right-7 bottom-1 h-20 w-24 object-contain opacity-40 drop-shadow-[0_8px_5px_rgba(0,0,0,.45)] md:hidden"
                    />
                    <div className="flex items-center gap-3 md:block">
                        <span className="flex size-11 items-center justify-center border border-[var(--wiki-accent)]/55 bg-[var(--wiki-accent)]/12 text-[var(--wiki-accent)] [clip-path:polygon(8px_0,100%_0,100%_calc(100%_-_8px),calc(100%_-_8px)_100%,0_100%,0_8px)] [&_svg]:size-5">
                            {icon}
                        </span>
                        <span className="md:mt-5 md:block">
                            <strong className="block font-mono text-4xl leading-none font-black text-[var(--wiki-accent)] tabular-nums [text-shadow:0_0_22px_color-mix(in_oklab,var(--wiki-accent)_45%,transparent)]">
                                {String(total).padStart(2, '0')}
                            </strong>
                            <span className="mt-1 block text-[10px] font-bold tracking-[.12em] text-slate-400 uppercase">
                                {unit}
                            </span>
                        </span>
                    </div>
                    <div className="hidden border-t border-white/8 pt-4 font-mono text-[8px] leading-4 tracking-[.16em] text-slate-500 uppercase md:block">
                        <span className="block text-white/55">
                            {themeConfig.label}
                        </span>
                        <span className="text-[var(--wiki-accent)]">
                            Extraction 100%
                        </span>
                    </div>
                </div>
            </div>
        </section>
    );
}
