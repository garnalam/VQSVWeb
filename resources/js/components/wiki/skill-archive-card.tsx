import { Link } from '@inertiajs/react';
import {
    ArrowUpRight,
    Check,
    Crosshair,
    HeartPulse,
    Pin,
    Plus,
    Scale,
    ShieldCheck,
    Sparkles,
    Swords,
    UsersRound,
    Zap,
} from 'lucide-react';
import type { CSSProperties, ReactNode } from 'react';
import { Badge } from '@/components/ui/badge';
import { ElementBadge } from '@/components/wiki/element-badge';
import { GameArtwork } from '@/components/wiki/game-artwork';
import { SkillSigil } from '@/components/wiki/skill-sigil';
import { petArtworkUrl } from '@/lib/game-assets';
import { cn } from '@/lib/utils';
import { show as skillShow } from '@/routes/wiki/skills';
import type { WikiSkillCatalogEntry } from '@/types';

type SkillArchiveCardProps = {
    skill: WikiSkillCatalogEntry;
    index: number;
    isPinned: boolean;
    isCompared: boolean;
    isInBuild: boolean;
    comparisonIsFull: boolean;
    buildIsFull: boolean;
    onTogglePin: (skill: WikiSkillCatalogEntry) => void;
    onToggleCompare: (skill: WikiSkillCatalogEntry) => void;
    onToggleBuild: (skill: WikiSkillCatalogEntry) => void;
};

type SkillArchetype = 'damage' | 'status' | 'recovery' | 'signature';

const SOURCE_LABELS = {
    element: 'Bể Hệ',
    species: 'Bể Chủng',
    universal: 'Phổ thông',
} as const;

export function SkillArchiveCard({
    skill,
    index,
    isPinned,
    isCompared,
    isInBuild,
    comparisonIsFull,
    buildIsFull,
    onTogglePin,
    onToggleCompare,
    onToggleBuild,
}: SkillArchiveCardProps) {
    const archetype = skillArchetype(skill);
    const theme = archetypeTheme(archetype, skill.element.color);
    const isAreaTarget = ['all_enemies', 'all_allies', 'battlefield'].includes(
        skill.target_pattern,
    );
    const magnitude = skill.description.match(/(\d+)%/)?.[1] ?? null;
    const style = {
        '--skill-color': skill.element.color,
        '--card-accent': theme.accent,
        '--card-glow': theme.glow,
        animationDelay: `${Math.min(index, 7) * 55}ms`,
    } as CSSProperties;

    return (
        <article
            style={style}
            className={cn(
                'wiki-card-fx group/card relative flex min-h-130 flex-col overflow-hidden border bg-[#071522] shadow-[0_20px_46px_rgba(0,0,0,.3)] transition duration-300 hover:-translate-y-1 hover:shadow-[0_26px_58px_var(--card-glow)]',
                theme.borderClass,
                theme.clipClass,
            )}
        >
            <div
                className={cn(
                    'wiki-scanline relative flex min-h-28 items-start justify-between gap-3 overflow-hidden border-b px-5 py-4',
                    theme.headerClass,
                )}
            >
                <span className="absolute inset-x-0 top-0 h-1 bg-[var(--card-accent)] shadow-[0_0_18px_var(--card-accent)]" />
                {archetype === 'damage' && (
                    <span className="absolute -top-16 right-12 h-48 w-px rotate-45 bg-[var(--card-accent)]/45 shadow-[12px_0_0_var(--card-accent),24px_0_0_color-mix(in_oklab,var(--card-accent)_40%,transparent)]" />
                )}
                {archetype === 'status' && (
                    <div className="absolute inset-x-0 bottom-2 flex h-9 items-end gap-1 px-4 opacity-20">
                        {[30, 65, 42, 90, 55, 74, 38, 82, 48, 66].map(
                            (height, waveIndex) => (
                                <span
                                    key={`${height}-${waveIndex}`}
                                    style={{ height: `${height}%` }}
                                    className="w-1 flex-1 bg-[var(--card-accent)]"
                                />
                            ),
                        )}
                    </div>
                )}
                {archetype === 'recovery' && (
                    <span className="absolute top-5 right-20 size-22 rotate-45 border border-[var(--card-accent)]/22 shadow-[inset_0_0_20px_color-mix(in_oklab,var(--card-accent)_12%,transparent)]" />
                )}
                {archetype === 'signature' && (
                    <span className="absolute inset-0 bg-[linear-gradient(115deg,transparent,rgba(234,179,8,.12),transparent)]" />
                )}

                <SkillSigil
                    element={skill.element}
                    gameSource={skill.game_source}
                    skillId={skill.game_id}
                    powerPercent={skill.power_percent}
                    effectMode={skill.effect_mode}
                    className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 opacity-68 transition duration-500 group-hover/card:scale-110 group-hover/card:opacity-95"
                />
                <ElementBadge element={skill.element} />
                <span className="relative bg-[var(--card-accent)] px-2.5 py-1 font-mono text-[9px] font-black tracking-[.13em] text-[#04121f] [clip-path:polygon(6px_0,100%_0,calc(100%_-_6px)_100%,0_100%)]">
                    WIKI-SKILL-{String(skill.id).padStart(3, '0')}
                </span>
            </div>

            <div className="relative flex flex-1 flex-col p-5 sm:p-6">
                {skill.is_signature && (
                    <span className="absolute -top-3 right-5 z-10 flex h-7 items-center gap-1.5 border border-amber-200/50 bg-amber-300 px-3 font-mono text-[8px] font-black tracking-[.1em] text-[#201503] uppercase shadow-[0_0_18px_rgba(234,179,8,.22)] [clip-path:polygon(6px_0,100%_0,calc(100%_-_6px)_100%,0_100%)]">
                        <Sparkles className="size-3" />
                        Đặc trưng độc quyền
                    </span>
                )}

                <div className="flex items-start justify-between gap-4">
                    <div className="min-w-0 flex-1">
                        <p className="flex items-center gap-1.5 text-[9px] font-black tracking-[.14em] text-[var(--card-accent)] uppercase">
                            <ArchetypeIcon archetype={archetype} />
                            {skill.combat_category_label}
                        </p>
                        <Link
                            href={skillShow(skill.id)}
                            prefetch
                            className="mt-1 block focus-visible:outline-2 focus-visible:outline-offset-3 focus-visible:outline-[var(--card-accent)]"
                        >
                            <h2 className="text-xl leading-7 font-black tracking-tight text-white transition group-hover/card:text-[var(--card-accent)]">
                                {skill.name}
                            </h2>
                        </Link>
                        <div className="mt-3 flex flex-wrap gap-1.5">
                            <Badge className="rounded-none bg-[var(--card-accent)] text-[#04121f]">
                                Tier {skill.tier}
                            </Badge>
                            <Badge
                                variant="outline"
                                className="rounded-none border-white/12 text-slate-300"
                            >
                                PP {skill.max_uses}
                            </Badge>
                            <Badge
                                variant="outline"
                                className="rounded-none border-white/12 text-slate-300"
                            >
                                {skill.battle_format === 'double'
                                    ? 'Ưu tiên 2V2'
                                    : 'Mọi thể thức'}
                            </Badge>
                        </div>
                    </div>

                    <SkillMetric
                        skill={skill}
                        archetype={archetype}
                        magnitude={magnitude}
                    />
                </div>

                <p className="mt-5 line-clamp-3 min-h-15 border-l-2 border-[var(--card-accent)]/40 pl-3 text-sm leading-5 text-slate-400">
                    {skill.description}
                </p>

                <div className="mt-4 flex flex-wrap gap-1.5">
                    {skill.source_types.length > 0 ? (
                        skill.source_types.map((sourceType) => (
                            <span
                                key={sourceType}
                                className="border border-white/9 bg-white/4 px-2 py-1 font-mono text-[8px] font-black tracking-[.1em] text-slate-400 uppercase"
                            >
                                {SOURCE_LABELS[sourceType]}
                            </span>
                        ))
                    ) : (
                        <span className="border border-white/9 bg-white/4 px-2 py-1 font-mono text-[8px] text-slate-500 uppercase">
                            Chưa có Pet tương thích
                        </span>
                    )}
                    {skill.unlock_levels.map((level) => (
                        <span
                            key={level}
                            className="border border-cyan-300/12 bg-cyan-300/5 px-2 py-1 font-mono text-[8px] font-black text-cyan-200/70"
                        >
                            CẤP {level}
                        </span>
                    ))}
                </div>

                <div className="mt-4 grid grid-cols-2 gap-px overflow-visible border border-white/8 bg-white/8">
                    <div className="relative bg-[#06121e] p-3">
                        <span className="flex items-center gap-2 text-[9px] text-slate-500">
                            {isAreaTarget ? (
                                <UsersRound className="size-3.5 text-[var(--card-accent)]" />
                            ) : (
                                <Crosshair className="size-3.5 text-[var(--card-accent)]" />
                            )}
                            {isAreaTarget
                                ? 'Mục tiêu diện rộng'
                                : 'Mục tiêu đơn'}
                        </span>
                        <strong className="mt-1 block text-xs text-white">
                            {skill.target_label}
                        </strong>
                    </div>
                    <div className="group/pets relative bg-[#06121e] p-3">
                        <span className="flex items-center gap-2 text-[9px] text-slate-500">
                            <UsersRound className="size-3.5 text-[var(--card-accent)]" />
                            Độ phổ cập
                        </span>
                        <strong className="mt-1 block text-xs text-white">
                            {skill.learned_by_count} Pet học được
                        </strong>
                        {skill.compatible_pet_preview.length > 0 && (
                            <div className="pointer-events-none absolute right-0 bottom-[calc(100%+.5rem)] z-40 hidden w-62 border border-[var(--card-accent)]/30 bg-[#030d17]/98 p-3 shadow-2xl group-hover/pets:block">
                                <span className="font-mono text-[8px] font-black tracking-[.12em] text-[var(--card-accent)] uppercase">
                                    Pet tương thích tiêu biểu
                                </span>
                                <div className="mt-2 grid grid-cols-3 gap-2">
                                    {skill.compatible_pet_preview.map((pet) => (
                                        <span
                                            key={pet.id}
                                            className="flex min-w-0 flex-col items-center gap-1 border border-white/7 bg-white/4 p-1.5"
                                        >
                                            <GameArtwork
                                                src={petArtworkUrl(
                                                    pet.sprite_id,
                                                    pet.game_source.asset_key,
                                                )}
                                                alt={`Sprite ${pet.name}`}
                                                className="size-10"
                                                fallback={
                                                    <span className="flex size-10 items-center justify-center font-mono text-[8px] text-slate-500">
                                                        PET
                                                    </span>
                                                }
                                            />
                                            <span className="w-full truncate text-center text-[8px] text-slate-300">
                                                {pet.name}
                                            </span>
                                        </span>
                                    ))}
                                </div>
                            </div>
                        )}
                    </div>
                </div>

                <div className="mt-auto pt-5">
                    <div className="grid grid-cols-3 gap-2">
                        <QuickAction
                            active={isCompared}
                            disabled={comparisonIsFull && !isCompared}
                            icon={isCompared ? <Check /> : <Scale />}
                            label="So sánh"
                            onClick={() => onToggleCompare(skill)}
                        />
                        <QuickAction
                            active={isPinned}
                            icon={<Pin />}
                            label="Ghim"
                            onClick={() => onTogglePin(skill)}
                        />
                        <QuickAction
                            active={isInBuild}
                            disabled={buildIsFull && !isInBuild}
                            icon={isInBuild ? <Check /> : <Plus />}
                            label="Thử Build"
                            onClick={() => onToggleBuild(skill)}
                        />
                    </div>
                    <Link
                        href={skillShow(skill.id)}
                        prefetch
                        className="mt-4 flex items-center justify-end gap-1.5 font-mono text-[9px] font-black tracking-[.14em] text-[var(--card-accent)] uppercase"
                    >
                        Mở hồ sơ kỹ năng
                        <ArrowUpRight className="size-3.5 transition-transform group-hover/card:translate-x-0.5 group-hover/card:-translate-y-0.5" />
                    </Link>
                </div>
            </div>
        </article>
    );
}

function skillArchetype(skill: WikiSkillCatalogEntry): SkillArchetype {
    if (skill.is_signature) {
        return 'signature';
    }

    if (['heal', 'defense'].includes(skill.combat_category)) {
        return 'recovery';
    }

    if (
        skill.power_percent === 0 ||
        ['buff', 'control', 'disrupt'].includes(skill.combat_category)
    ) {
        return 'status';
    }

    return 'damage';
}

function archetypeTheme(archetype: SkillArchetype, elementColor: string) {
    return {
        damage: {
            accent: elementColor,
            glow: `color-mix(in oklab, ${elementColor} 16%, rgba(0,0,0,.38))`,
            borderClass:
                'border-[var(--card-accent)]/25 hover:border-[var(--card-accent)]/62',
            headerClass:
                'border-[var(--card-accent)]/20 bg-[radial-gradient(circle_at_50%_50%,color-mix(in_oklab,var(--card-accent)_22%,transparent),transparent_45%),#06131f]',
            clipClass:
                '[clip-path:polygon(0_0,calc(100%_-_24px)_0,100%_24px,100%_100%,18px_100%,0_calc(100%_-_18px))]',
        },
        status: {
            accent: '#d946ef',
            glow: 'rgba(217,70,239,.16)',
            borderClass: 'border-fuchsia-300/24 hover:border-fuchsia-300/62',
            headerClass:
                'border-fuchsia-300/18 bg-[radial-gradient(circle_at_50%_45%,rgba(217,70,239,.22),transparent_45%),#071321]',
            clipClass:
                '[clip-path:polygon(12px_0,calc(100%_-_12px)_0,100%_12px,100%_calc(100%_-_12px),calc(100%_-_12px)_100%,12px_100%,0_calc(100%_-_12px),0_12px)]',
        },
        recovery: {
            accent: '#34d399',
            glow: 'rgba(52,211,153,.16)',
            borderClass: 'border-emerald-300/24 hover:border-emerald-300/62',
            headerClass:
                'border-emerald-300/18 bg-[radial-gradient(circle_at_50%_48%,rgba(52,211,153,.2),transparent_45%),#061521]',
            clipClass:
                '[clip-path:polygon(0_16px,16px_0,100%_0,100%_calc(100%_-_16px),calc(100%_-_16px)_100%,0_100%)]',
        },
        signature: {
            accent: '#eab308',
            glow: 'rgba(234,179,8,.19)',
            borderClass: 'border-amber-300/35 hover:border-amber-200/75',
            headerClass:
                'border-amber-300/24 bg-[radial-gradient(circle_at_50%_48%,rgba(234,179,8,.23),transparent_45%),#171508]',
            clipClass:
                '[clip-path:polygon(0_0,calc(100%_-_28px)_0,100%_28px,100%_calc(100%_-_18px),calc(100%_-_18px)_100%,18px_100%,0_calc(100%_-_18px))]',
        },
    }[archetype];
}

function ArchetypeIcon({ archetype }: { archetype: SkillArchetype }) {
    if (archetype === 'recovery') {
        return <HeartPulse className="size-3.5" />;
    }

    if (archetype === 'status') {
        return <Zap className="size-3.5" />;
    }

    if (archetype === 'signature') {
        return <Sparkles className="size-3.5" />;
    }

    return <Swords className="size-3.5" />;
}

function SkillMetric({
    skill,
    archetype,
    magnitude,
}: {
    skill: WikiSkillCatalogEntry;
    archetype: SkillArchetype;
    magnitude: string | null;
}) {
    if (['heal', 'defense'].includes(skill.combat_category)) {
        return (
            <div className="flex size-20 shrink-0 flex-col items-center justify-center border border-emerald-300/35 bg-emerald-300/8 text-emerald-200 shadow-[inset_0_0_24px_rgba(52,211,153,.08)]">
                {skill.combat_category === 'heal' ? (
                    <HeartPulse className="size-4" />
                ) : (
                    <ShieldCheck className="size-4" />
                )}
                <strong className="mt-1 text-center font-mono text-xs font-black">
                    {magnitude === null
                        ? skill.combat_category === 'heal'
                            ? 'HỒI PHỤC'
                            : 'BẢO HỘ'
                        : `${magnitude}%`}
                </strong>
                {magnitude !== null && (
                    <span className="text-[7px] font-black tracking-wider uppercase">
                        {skill.combat_category === 'heal' ? 'HP' : 'Hiệu lực'}
                    </span>
                )}
            </div>
        );
    }

    if (
        archetype === 'status' ||
        (archetype === 'signature' && skill.power_percent === 0)
    ) {
        const polarity = skill.effect?.kind === 'harmful' ? '−' : '+';
        const displayedChance = skill.status_chance ?? magnitude;

        return (
            <div className="flex min-h-19 w-24 shrink-0 flex-col items-center justify-center border border-[var(--card-accent)]/40 bg-[var(--card-accent)]/9 px-2 text-center shadow-[inset_0_0_22px_color-mix(in_oklab,var(--card-accent)_10%,transparent)]">
                <Zap className="size-4 text-[var(--card-accent)]" />
                <strong className="mt-1 text-[9px] leading-3 font-black text-white uppercase">
                    {skill.effect
                        ? `${polarity} ${skill.effect.name}`
                        : 'Trạng thái'}
                </strong>
                {displayedChance !== null && Number(displayedChance) > 0 && (
                    <span className="mt-1 font-mono text-[8px] text-[var(--card-accent)]">
                        TỈ LỆ {displayedChance}%
                    </span>
                )}
            </div>
        );
    }

    const ringStyle = {
        background: `conic-gradient(var(--card-accent) ${Math.min(Math.max(skill.power_percent, 16), 100)}%, color-mix(in oklab, var(--card-accent) 10%, transparent) 0)`,
    };

    return (
        <div
            style={ringStyle}
            className="relative flex size-20 shrink-0 items-center justify-center rounded-full p-1 shadow-[0_10px_28px_color-mix(in_oklab,var(--card-accent)_22%,transparent)]"
        >
            <div className="flex size-full flex-col items-center justify-center rounded-full bg-[#071522] text-[var(--card-accent)] shadow-inner">
                <Swords className="size-4" />
                <strong className="mt-0.5 text-sm font-black tabular-nums">
                    {skill.power_percent}%
                </strong>
                <span className="font-mono text-[7px] text-slate-500 uppercase">
                    Uy lực
                </span>
            </div>
        </div>
    );
}

function QuickAction({
    active,
    disabled = false,
    icon,
    label,
    onClick,
}: {
    active: boolean;
    disabled?: boolean;
    icon: ReactNode;
    label: string;
    onClick: () => void;
}) {
    return (
        <button
            type="button"
            onClick={onClick}
            disabled={disabled}
            aria-pressed={active}
            className={cn(
                'flex min-h-10 items-center justify-center gap-1.5 border px-2 text-[9px] font-black transition disabled:cursor-not-allowed disabled:opacity-35 [&_svg]:size-3.5',
                active
                    ? 'border-[var(--card-accent)] bg-[var(--card-accent)] text-[#04121f]'
                    : 'border-white/9 bg-white/4 text-slate-400 hover:border-[var(--card-accent)]/45 hover:bg-[var(--card-accent)]/8 hover:text-white',
            )}
        >
            {icon}
            {label}
        </button>
    );
}
