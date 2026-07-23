import { Head, Link } from '@inertiajs/react';
import {
    ArrowLeft,
    ArrowUpRight,
    BookOpenText,
    Database,
    Layers3,
    ShieldCheck,
    Target,
    Users,
    Zap,
} from 'lucide-react';
import type { CSSProperties, ReactNode } from 'react';
import { EffectBadge, EffectIcon } from '@/components/wiki/effect-badge';
import { ElementBadge } from '@/components/wiki/element-badge';
import { GameArtwork } from '@/components/wiki/game-artwork';
import { GameSourceBadge } from '@/components/wiki/game-source-badge';
import { SkillSigil } from '@/components/wiki/skill-sigil';
import { petArtworkUrl } from '@/lib/game-assets';
import { index as petsIndex } from '@/routes/wiki/pets';
import { index as skillsIndex } from '@/routes/wiki/skills';
import type { WikiSkillDetail } from '@/types';

type SkillShowProps = {
    skill: WikiSkillDetail;
};

export default function SkillShow({ skill }: SkillShowProps) {
    const accent = skill.element.color ?? '#f14cff';
    const style = {
        '--skill-accent': accent,
    } as CSSProperties;
    const isStatusSkill = skill.power_percent === 0;

    return (
        <div style={style} className="flex flex-col gap-4 sm:gap-5">
            <Head title={`${skill.name} · Kỹ năng`} />

            <Link
                href={skillsIndex()}
                className="flex w-fit items-center gap-2 font-mono text-[10px] font-black tracking-[.16em] text-slate-400 uppercase transition hover:text-[var(--skill-accent)]"
            >
                <ArrowLeft className="size-3.5" />
                Trở lại thư viện kỹ năng
            </Link>

            <section className="wiki-console relative isolate overflow-hidden border border-[var(--skill-accent)]/35 bg-[#081522]/95 [clip-path:polygon(0_18px,18px_0,calc(100%_-_52px)_0,calc(100%_-_34px)_18px,100%_18px,100%_calc(100%_-_18px),calc(100%_-_18px)_100%,18px_100%,0_calc(100%_-_18px))]">
                <div className="absolute inset-x-0 top-0 h-[3px] bg-linear-to-r from-[var(--skill-accent)] via-fuchsia-400 to-transparent shadow-[0_0_20px_var(--skill-accent)]" />
                <div className="wiki-grid absolute inset-0 -z-10 opacity-25" />
                <div className="absolute inset-0 -z-10 bg-[radial-gradient(circle_at_74%_42%,color-mix(in_oklab,var(--skill-accent)_24%,transparent),transparent_26rem)]" />

                <div className="grid lg:grid-cols-[minmax(0,1fr)_18rem]">
                    <div className="px-6 py-8 sm:px-10 sm:py-10">
                        <div className="flex flex-wrap items-center gap-3">
                            <GameSourceBadge source={skill.game_source} />
                            <span className="bg-[var(--skill-accent)] px-3 py-1 font-mono text-[9px] font-black tracking-[.15em] text-[#07111e] [clip-path:polygon(0_0,calc(100%_-_7px)_0,100%_50%,calc(100%_-_7px)_100%,0_100%)]">
                                SKILL-{String(skill.game_id).padStart(2, '0')}
                            </span>
                            <ElementBadge element={skill.element} />
                        </div>
                        <h1 className="mt-5 text-4xl leading-none font-black tracking-[-.045em] text-white sm:text-6xl">
                            {skill.name}
                        </h1>
                        <p className="mt-5 max-w-3xl border-l-2 border-[var(--skill-accent)]/55 pl-4 text-sm leading-7 text-slate-300 sm:text-base">
                            {skill.description}
                        </p>
                        <div className="mt-7 flex flex-wrap gap-2 font-mono text-[9px] font-black tracking-[.12em] uppercase">
                            <span className="border border-white/10 bg-white/4 px-3 py-2 text-slate-300">
                                Bậc {skill.tier}
                            </span>
                            <span className="border border-white/10 bg-white/4 px-3 py-2 text-slate-300">
                                {skill.energy_cost !== null
                                    ? `Năng lượng ${skill.energy_cost}`
                                    : `PP ${skill.max_uses}`}
                            </span>
                            <span className="border border-white/10 bg-white/4 px-3 py-2 text-slate-300">
                                {skill.target_side === 1
                                    ? 'Mục tiêu: Bản thân'
                                    : 'Mục tiêu: Đối thủ'}
                            </span>
                        </div>
                    </div>

                    <div className="relative flex min-h-64 flex-col items-center justify-center border-t border-white/7 bg-black/17 p-7 lg:border-t-0 lg:border-l">
                        <SkillSigil
                            element={skill.element}
                            gameSource={skill.game_source}
                            skillId={skill.game_id}
                            powerPercent={skill.power_percent}
                            effectMode={skill.effect_mode}
                            className="size-42 [&>img]:size-20 [&>span:last-child]:size-7 [&>span:last-child]:text-[9px]"
                        />
                        <strong className="mt-5 font-mono text-3xl font-black text-[var(--skill-accent)]">
                            {isStatusSkill
                                ? 'STATUS'
                                : `${skill.power_percent}%`}
                        </strong>
                        <span className="mt-1 font-mono text-[9px] tracking-[.18em] text-slate-500 uppercase">
                            {isStatusSkill
                                ? 'Kỹ năng trạng thái'
                                : 'Hệ số sát thương'}
                        </span>
                    </div>
                </div>
            </section>

            <div className="grid gap-4 xl:grid-cols-[minmax(0,1fr)_22rem]">
                <div className="flex min-w-0 flex-col gap-4">
                    <section className="border border-white/9 bg-[#081522]/92 p-5 sm:p-6">
                        <div className="flex items-center gap-3">
                            <span className="flex size-9 items-center justify-center border border-[var(--skill-accent)]/40 bg-[var(--skill-accent)]/10 text-[var(--skill-accent)]">
                                <Zap className="size-4" />
                            </span>
                            <div>
                                <p className="font-mono text-[8px] font-black tracking-[.18em] text-[var(--skill-accent)] uppercase">
                                    Combat analysis
                                </p>
                                <h2 className="text-xl font-black text-white">
                                    Thông số chiến đấu
                                </h2>
                            </div>
                        </div>

                        <div className="mt-5 grid grid-cols-2 gap-px overflow-hidden border border-white/8 bg-white/8 sm:grid-cols-4">
                            <StatCell
                                icon={<Zap />}
                                label="Power"
                                value={
                                    isStatusSkill
                                        ? 'Trạng thái'
                                        : `${skill.power_percent}%`
                                }
                            />
                            <StatCell
                                icon={<ShieldCheck />}
                                label="PP tối đa"
                                value={String(skill.max_uses)}
                            />
                            <StatCell
                                icon={<Layers3 />}
                                label="Bậc"
                                value={String(skill.tier)}
                            />
                            <StatCell
                                icon={<Target />}
                                label="Mục tiêu"
                                value={
                                    skill.target_side === 1
                                        ? 'Bản thân'
                                        : 'Đối thủ'
                                }
                            />
                        </div>
                    </section>

                    <section className="border border-white/9 bg-[#081522]/92 p-5 sm:p-6">
                        <div className="flex items-center gap-3">
                            <span className="flex size-9 items-center justify-center border border-[var(--skill-accent)]/40 bg-[var(--skill-accent)]/10 text-[var(--skill-accent)]">
                                {skill.effect ? (
                                    <EffectIcon
                                        effect={skill.effect}
                                        className="size-9 border-0 bg-transparent shadow-none"
                                    />
                                ) : (
                                    <Zap className="size-4" />
                                )}
                            </span>
                            <div>
                                <p className="font-mono text-[8px] font-black tracking-[.18em] text-[var(--skill-accent)] uppercase">
                                    Status protocol
                                </p>
                                <h2 className="text-xl font-black text-white">
                                    Hiệu ứng liên quan
                                </h2>
                            </div>
                        </div>

                        {skill.effect ? (
                            <div className="mt-5 grid gap-4 sm:grid-cols-[minmax(0,1fr)_11rem]">
                                <div className="border-l-2 border-[var(--skill-accent)]/55 bg-white/3 p-4">
                                    <EffectBadge
                                        effect={skill.effect}
                                        className="[&_div>span:first-child]:text-lg"
                                    />
                                    <p className="mt-2 text-sm leading-6 text-slate-400">
                                        {skill.effect.description ??
                                            'Game không cung cấp mô tả hiệu ứng riêng.'}
                                    </p>
                                </div>
                                <div className="grid grid-cols-2 gap-px bg-white/8 sm:grid-cols-1">
                                    <MiniStat
                                        label="Thời lượng"
                                        value={
                                            skill.effect.duration === null
                                                ? 'Dữ liệu gốc'
                                                : `${skill.effect.duration} hiệp`
                                        }
                                    />
                                    <MiniStat
                                        label="Tham số raw"
                                        value={
                                            skill.effect_parameter === null
                                                ? '—'
                                                : String(skill.effect_parameter)
                                        }
                                    />
                                </div>
                            </div>
                        ) : (
                            <p className="mt-5 border border-white/7 bg-white/3 p-4 text-sm text-slate-400">
                                Kỹ năng này không gắn trạng thái buff/debuff
                                chuẩn. Tham số raw vẫn được giữ ở mục dữ liệu
                                nguồn.
                            </p>
                        )}
                    </section>

                    <section className="border border-white/9 bg-[#081522]/92 p-5 sm:p-6">
                        <div className="flex items-center gap-3">
                            <span className="flex size-9 items-center justify-center border border-[var(--skill-accent)]/40 bg-[var(--skill-accent)]/10 text-[var(--skill-accent)]">
                                <BookOpenText className="size-4" />
                            </span>
                            <div>
                                <p className="font-mono text-[8px] font-black tracking-[.18em] text-[var(--skill-accent)] uppercase">
                                    Learning matrix
                                </p>
                                <h2 className="text-xl font-black text-white">
                                    Mốc mở khóa theo nhóm học
                                </h2>
                            </div>
                        </div>
                        <p className="mt-3 max-w-3xl text-sm leading-6 text-slate-400">
                            Đây là level sớm nhất nhóm Pet có thể mở bậc của kỹ
                            năng này. Pet vẫn cần cùng hệ với kỹ năng.
                        </p>
                        <div className="mt-5 grid grid-cols-2 gap-3 sm:grid-cols-4">
                            {skill.unlock_rules.map((rule) => (
                                <div
                                    key={rule.learning_group}
                                    className="relative overflow-hidden border border-white/8 bg-black/16 p-4"
                                >
                                    <span className="absolute top-0 right-0 h-1 w-10 bg-[var(--skill-accent)]" />
                                    <span className="font-mono text-[9px] font-black tracking-[.14em] text-slate-500 uppercase">
                                        Nhóm {rule.learning_group}
                                    </span>
                                    <strong className="mt-2 block text-2xl font-black text-[var(--skill-accent)]">
                                        Lv.{rule.unlock_level}
                                    </strong>
                                    <span className="mt-1 block text-[10px] text-slate-500">
                                        Mở đến bậc {rule.maximum_skill_tier}
                                    </span>
                                </div>
                            ))}
                        </div>
                    </section>

                    <section className="border border-white/9 bg-[#081522]/92 p-5 sm:p-6">
                        <div className="flex flex-wrap items-end justify-between gap-3">
                            <div className="flex items-center gap-3">
                                <span className="flex size-9 items-center justify-center border border-[var(--skill-accent)]/40 bg-[var(--skill-accent)]/10 text-[var(--skill-accent)]">
                                    <Users className="size-4" />
                                </span>
                                <div>
                                    <p className="font-mono text-[8px] font-black tracking-[.18em] text-[var(--skill-accent)] uppercase">
                                        Compatible creatures
                                    </p>
                                    <h2 className="text-xl font-black text-white">
                                        Pet cùng hệ có thể học
                                    </h2>
                                </div>
                            </div>
                            <span className="font-mono text-[9px] text-slate-500 uppercase">
                                {skill.compatible_pets.length} hồ sơ
                            </span>
                        </div>
                        <div className="mt-5 grid gap-3 sm:grid-cols-2 lg:grid-cols-3">
                            {skill.compatible_pets.map((pet) => (
                                <Link
                                    key={pet.id}
                                    href={petsIndex({
                                        query: { q: pet.game_id },
                                    })}
                                    prefetch
                                    className="group flex items-center gap-3 border border-white/8 bg-black/14 p-3 transition hover:border-[var(--skill-accent)]/40 hover:bg-[var(--skill-accent)]/6"
                                >
                                    <span className="flex size-14 shrink-0 items-center justify-center bg-[var(--skill-accent)]/8">
                                        <GameArtwork
                                            src={petArtworkUrl(
                                                pet.sprite_id,
                                                skill.game_source.asset_key,
                                            )}
                                            alt={`Sprite của ${pet.name}`}
                                            className="size-12 transition-transform group-hover:scale-110"
                                            fallback={
                                                <span className="font-mono text-xs text-[var(--skill-accent)]">
                                                    PET
                                                </span>
                                            }
                                        />
                                    </span>
                                    <span className="min-w-0 flex-1">
                                        <strong className="block truncate text-sm text-white">
                                            {pet.name}
                                        </strong>
                                        <span className="mt-1 block font-mono text-[8px] text-slate-500 uppercase">
                                            Nhóm {pet.learning_group} · Lv.
                                            {pet.unlock_level}
                                        </span>
                                    </span>
                                    <ArrowUpRight className="size-3.5 text-slate-600 transition group-hover:text-[var(--skill-accent)]" />
                                </Link>
                            ))}
                        </div>
                    </section>
                </div>

                <aside className="flex flex-col gap-4">
                    <section className="border border-white/9 bg-[#081522]/92 p-5">
                        <div className="flex items-center gap-2 text-[var(--skill-accent)]">
                            <Database className="size-4" />
                            <h2 className="font-mono text-[10px] font-black tracking-[.16em] uppercase">
                                Dữ liệu nguồn
                            </h2>
                        </div>
                        <dl className="mt-5 grid gap-3 text-xs">
                            <DataRow label="Bảng" value="db[1] · Skill" />
                            <DataRow label="Game ID" value={skill.game_id} />
                            <DataRow
                                label="Effect mode"
                                value={skill.effect_mode}
                            />
                            <DataRow
                                label="Effect parameter"
                                value={skill.effect_parameter ?? '—'}
                            />
                            <DataRow
                                label="Target side"
                                value={skill.target_side}
                            />
                        </dl>
                    </section>

                    <details className="group border border-white/9 bg-[#081522]/92 p-5">
                        <summary className="cursor-pointer list-none font-mono text-[10px] font-black tracking-[.15em] text-slate-300 uppercase marker:hidden">
                            <span className="flex items-center justify-between gap-3">
                                Mô tả nguyên văn
                                <span className="text-[var(--skill-accent)] group-open:rotate-45">
                                    +
                                </span>
                            </span>
                        </summary>
                        <p className="mt-4 border-t border-white/8 pt-4 text-sm leading-6 text-slate-400">
                            {skill.description_original}
                        </p>
                    </details>

                    <details className="group border border-white/9 bg-[#081522]/92 p-5">
                        <summary className="cursor-pointer list-none font-mono text-[10px] font-black tracking-[.15em] text-slate-300 uppercase marker:hidden">
                            <span className="flex items-center justify-between gap-3">
                                Raw values
                                <span className="text-[var(--skill-accent)] group-open:rotate-45">
                                    +
                                </span>
                            </span>
                        </summary>
                        <pre className="mt-4 overflow-x-auto border-t border-white/8 pt-4 font-mono text-[10px] leading-5 text-slate-500">
                            {JSON.stringify(skill.raw_values, null, 2)}
                        </pre>
                    </details>
                </aside>
            </div>
        </div>
    );
}

function StatCell({
    icon,
    label,
    value,
}: {
    icon: ReactNode;
    label: string;
    value: string;
}) {
    return (
        <div className="bg-[#071421] p-4">
            <span className="flex items-center gap-2 text-[10px] text-slate-500 [&_svg]:size-3.5 [&_svg]:text-[var(--skill-accent)]">
                {icon}
                {label}
            </span>
            <strong className="mt-2 block text-base font-black text-white">
                {value}
            </strong>
        </div>
    );
}

function MiniStat({ label, value }: { label: string; value: string }) {
    return (
        <div className="bg-[#071421] p-3">
            <span className="block text-[9px] text-slate-500">{label}</span>
            <strong className="mt-1 block font-mono text-xs text-white">
                {value}
            </strong>
        </div>
    );
}

function DataRow({ label, value }: { label: string; value: string | number }) {
    return (
        <div className="flex items-center justify-between gap-3 border-b border-white/6 pb-3 last:border-0 last:pb-0">
            <dt className="text-slate-500">{label}</dt>
            <dd className="font-mono font-bold text-slate-300">{value}</dd>
        </div>
    );
}
