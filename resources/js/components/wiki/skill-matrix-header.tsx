import {
    Activity,
    Crosshair,
    Layers3,
    RadioTower,
    Swords,
    UsersRound,
    Zap,
} from 'lucide-react';
import type { CSSProperties, ReactNode } from 'react';
import { elementIconUrl } from '@/lib/game-assets';

export type SkillCatalogStats = {
    decoded_total: number;
    active_total: number;
    element_total: number;
    tier_total: number;
    double_battle_total: number;
};

type SkillMatrixHeaderProps = {
    matchingTotal: number;
    stats: SkillCatalogStats;
};

const waveform = [28, 52, 34, 76, 44, 88, 58, 100, 64, 82, 48, 70, 38, 56];

export function SkillMatrixHeader({
    matchingTotal,
    stats,
}: SkillMatrixHeaderProps) {
    return (
        <section className="relative isolate overflow-hidden border border-cyan-300/26 bg-[#04121f]/96 shadow-[0_28px_72px_rgba(0,0,0,.4)] [clip-path:polygon(0_24px,24px_0,calc(100%_-_72px)_0,calc(100%_-_48px)_24px,100%_24px,100%_calc(100%_-_20px),calc(100%_-_20px)_100%,20px_100%,0_calc(100%_-_20px))]">
            <div className="absolute inset-x-0 top-0 h-[3px] bg-linear-to-r from-[#00e5ff] via-[#eab308] to-transparent shadow-[0_0_24px_#00e5ff]" />
            <div className="wiki-grid absolute inset-0 -z-20 opacity-28" />
            <div className="absolute inset-0 -z-10 bg-[radial-gradient(circle_at_75%_42%,rgba(0,229,255,.18),transparent_27rem),radial-gradient(circle_at_88%_74%,rgba(234,179,8,.11),transparent_18rem),linear-gradient(115deg,rgba(4,18,31,.98),rgba(5,24,39,.92)_58%,rgba(7,15,27,.96))]" />

            <div className="grid min-h-80 lg:grid-cols-[minmax(0,1.08fr)_minmax(25rem,.92fr)]">
                <div className="relative flex flex-col justify-center px-6 py-10 sm:px-10 lg:px-14">
                    <div className="flex flex-wrap items-center gap-3">
                        <span className="flex h-7 items-center gap-2 bg-[#00e5ff] px-3 font-mono text-[9px] font-black tracking-[.18em] text-[#03111d] [clip-path:polygon(0_0,calc(100%_-_8px)_0,100%_50%,calc(100%_-_8px)_100%,0_100%)]">
                            <RadioTower className="size-3" />
                            MATRIX ONLINE
                        </span>
                        <span className="font-mono text-[9px] font-black tracking-[.22em] text-amber-300 uppercase">
                            Combat Skill Terminal // 02
                        </span>
                    </div>

                    <h1 className="mt-5 max-w-3xl text-4xl leading-[.92] font-black tracking-[-.055em] text-white sm:text-6xl lg:text-7xl">
                        Ma trận
                        <span className="block bg-linear-to-r from-cyan-300 via-white to-amber-300 bg-clip-text text-transparent">
                            chiêu thức
                        </span>
                    </h1>
                    <p className="mt-5 max-w-2xl text-sm leading-7 font-medium text-slate-300 sm:text-[15px]">
                        Quét toàn bộ kỹ năng chiến đấu theo Hệ, Chủng, vai trò
                        chiến thuật và ma trận mục tiêu. Dữ liệu dùng chung cho
                        đấu đơn lẫn đội hình đấu đôi.
                    </p>

                    <div className="mt-7 flex items-end gap-1.5" aria-hidden="true">
                        {waveform.map((height, index) => (
                            <span
                                key={`${height}-${index}`}
                                style={
                                    {
                                        height: `${Math.max(8, Math.round(height / 3))}px`,
                                        animationDelay: `${index * 70}ms`,
                                    } as CSSProperties
                                }
                                className="w-1 bg-linear-to-t from-cyan-500/35 via-cyan-300 to-amber-300 shadow-[0_0_8px_rgba(0,229,255,.45)] motion-safe:animate-pulse"
                            />
                        ))}
                        <span className="ml-2 font-mono text-[8px] tracking-[.18em] text-cyan-200/60 uppercase">
                            Frequency locked
                        </span>
                    </div>
                </div>

                <div className="relative hidden min-h-80 items-center justify-center overflow-hidden border-l border-cyan-200/10 bg-black/10 lg:flex">
                    <div className="absolute size-72 rounded-full border border-cyan-300/15 shadow-[0_0_70px_rgba(0,229,255,.09)]" />
                    <div className="absolute size-62 rounded-full border border-dashed border-cyan-300/35 motion-safe:animate-[spin_24s_linear_infinite]" />
                    <div className="absolute size-49 rotate-45 border border-amber-300/20 motion-safe:animate-[spin_34s_linear_infinite_reverse]" />
                    <div className="absolute size-35 rounded-full border-2 border-cyan-300/28 bg-cyan-300/5 shadow-[inset_0_0_36px_rgba(0,229,255,.14),0_0_28px_rgba(0,229,255,.12)]" />
                    <Crosshair className="size-20 text-cyan-200/75 drop-shadow-[0_0_18px_rgba(0,229,255,.75)]" strokeWidth={0.8} />
                    <Zap className="absolute size-7 fill-amber-300/18 text-amber-300 drop-shadow-[0_0_12px_rgba(234,179,8,.8)]" />

                    {[0, 1, 2, 3, 4, 5, 6].map((elementId, index) => {
                        const angle = (index / 7) * Math.PI * 2 - Math.PI / 2;
                        const radius = 126;

                        return (
                            <span
                                key={elementId}
                                style={{
                                    transform: `translate(${Math.cos(angle) * radius}px, ${Math.sin(angle) * radius}px)`,
                                }}
                                className="absolute flex size-10 items-center justify-center rounded-full border border-cyan-200/18 bg-[#061725]/92 shadow-[0_0_16px_rgba(0,229,255,.12)]"
                            >
                                <img
                                    src={elementIconUrl(elementId)}
                                    alt=""
                                    className="wiki-pixel-art size-7 object-contain"
                                />
                            </span>
                        );
                    })}

                    <span className="absolute top-6 right-7 font-mono text-[8px] tracking-[.2em] text-cyan-200/40 uppercase">
                        Skill resonance radar
                    </span>
                    <span className="absolute bottom-6 left-7 flex items-center gap-2 font-mono text-[8px] tracking-[.16em] text-emerald-300/70 uppercase">
                        <i className="wiki-signal size-1.5 rounded-full bg-emerald-400" />
                        Signal stable
                    </span>
                </div>
            </div>

            <div className="grid border-t border-cyan-200/10 bg-black/18 sm:grid-cols-2 lg:grid-cols-4">
                <MatrixStat
                    icon={<Zap />}
                    value={`${matchingTotal}/${stats.active_total}`}
                    label="Kỹ năng đang khớp"
                    accent="cyan"
                />
                <MatrixStat
                    icon={<Activity />}
                    value={String(stats.element_total)}
                    label="Hệ chiến đấu"
                    accent="amber"
                />
                <MatrixStat
                    icon={<Layers3 />}
                    value={String(stats.tier_total)}
                    label="Bậc Tier"
                    accent="cyan"
                />
                <MatrixStat
                    icon={stats.double_battle_total > 0 ? <UsersRound /> : <Swords />}
                    value="2V2"
                    label={`${stats.double_battle_total} chiêu hỗ trợ đấu đôi`}
                    accent="amber"
                />
            </div>
        </section>
    );
}

function MatrixStat({
    icon,
    value,
    label,
    accent,
}: {
    icon: ReactNode;
    value: string;
    label: string;
    accent: 'cyan' | 'amber';
}) {
    const isCyan = accent === 'cyan';

    return (
        <div className="flex min-h-22 items-center gap-3 border-b border-r border-white/7 px-5 py-4 last:border-r-0 sm:border-b-0">
            <span
                className={
                    isCyan
                        ? 'flex size-10 items-center justify-center border border-cyan-300/35 bg-cyan-300/8 text-cyan-300 [&_svg]:size-4'
                        : 'flex size-10 items-center justify-center border border-amber-300/35 bg-amber-300/8 text-amber-300 [&_svg]:size-4'
                }
            >
                {icon}
            </span>
            <span>
                <strong
                    className={
                        isCyan
                            ? 'block font-mono text-xl font-black text-cyan-200 tabular-nums'
                            : 'block font-mono text-xl font-black text-amber-200 tabular-nums'
                    }
                >
                    {value}
                </strong>
                <span className="mt-1 block text-[9px] font-black tracking-[.14em] text-slate-500 uppercase">
                    {label}
                </span>
            </span>
        </div>
    );
}
