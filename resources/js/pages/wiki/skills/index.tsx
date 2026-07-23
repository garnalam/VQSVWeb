import { Head, Link, router } from '@inertiajs/react';
import { ArrowUpRight, Sparkles, Swords, Zap } from 'lucide-react';
import type { CSSProperties, FormEvent } from 'react';
import { useState } from 'react';
import { Badge } from '@/components/ui/badge';
import {
    Select,
    SelectContent,
    SelectItem,
    SelectTrigger,
    SelectValue,
} from '@/components/ui/select';
import { EffectBadge } from '@/components/wiki/effect-badge';
import { ElementBadge } from '@/components/wiki/element-badge';
import { GameSourceBadge } from '@/components/wiki/game-source-badge';
import { SkillSigil } from '@/components/wiki/skill-sigil';
import { WikiEmptyState } from '@/components/wiki/wiki-empty-state';
import { WikiFilterPanel } from '@/components/wiki/wiki-filter-panel';
import { WikiPageHeader } from '@/components/wiki/wiki-page-header';
import { WikiPagination } from '@/components/wiki/wiki-pagination';
import { WikiResultsBar } from '@/components/wiki/wiki-results-bar';
import { compactWikiQuery } from '@/lib/wiki';
import { index as skillsIndex, show as skillShow } from '@/routes/wiki/skills';
import type {
    PaginatedWikiData,
    WikiElement,
    WikiGameSource,
    WikiSkill,
} from '@/types';

type SkillFilters = {
    q: string;
    game: string | null;
    element: number | null;
    tier: number | null;
    kind: string | null;
    effect: string | null;
    target: string | null;
    sort: string;
};

type SkillIndexProps = {
    skills: PaginatedWikiData<WikiSkill>;
    elements: WikiElement[];
    gameSources: WikiGameSource[];
    filters: SkillFilters;
};

export default function SkillIndex({
    skills,
    elements,
    gameSources,
    filters,
}: SkillIndexProps) {
    const [query, setQuery] = useState(filters.q);
    const [element, setElement] = useState(
        filters.element === null ? 'all' : String(filters.element),
    );
    const [game, setGame] = useState(filters.game ?? 'all');
    const [tier, setTier] = useState(
        filters.tier === null ? 'all' : String(filters.tier),
    );
    const [kind, setKind] = useState(filters.kind ?? 'all');
    const [effect, setEffect] = useState(filters.effect ?? 'all');
    const [target, setTarget] = useState(filters.target ?? 'all');
    const [sort, setSort] = useState(filters.sort);

    const appliedQuery = compactWikiQuery(filters);
    const selectedSource = gameSources.find(
        (source) => source.slug === filters.game,
    );
    const description =
        selectedSource === undefined
            ? 'So sánh sức mạnh, chi phí, bậc mở khóa, mục tiêu và hiệu ứng kỹ năng giữa các phiên bản game.'
            : `Khám phá bộ kỹ năng ${selectedSource.name} với hình ảnh, sức mạnh, chi phí và hiệu ứng được phục hồi từ game.`;

    function submit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();

        router.visit(
            skillsIndex({
                query: compactWikiQuery({
                    q: query,
                    game: game === 'all' ? null : game,
                    element: element === 'all' ? null : Number(element),
                    tier: tier === 'all' ? null : Number(tier),
                    kind: kind === 'all' ? null : kind,
                    effect: effect === 'all' ? null : effect,
                    target: target === 'all' ? null : target,
                    sort,
                }),
            }),
            { preserveScroll: true, preserveState: true, replace: true },
        );
    }

    return (
        <>
            <Head title="Thư viện kỹ năng" />
            <WikiPageHeader
                eyebrow="VQSV Move Archive"
                title="Thư viện kỹ năng"
                description={description}
                total={skills.total}
                unit="kỹ năng phù hợp"
                icon={<Sparkles className="size-4" />}
                theme="skills"
            />

            <WikiFilterPanel
                query={query}
                onQueryChange={setQuery}
                onSubmit={submit}
                resetHref={skillsIndex()}
                placeholder="Tên, mô tả hoặc ID kỹ năng..."
            >
                <Select value={game} onValueChange={setGame}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-[var(--wiki-shell-accent)]/55 focus:ring-[var(--wiki-shell-accent)]/15">
                        <SelectValue placeholder="Nguồn game" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">Tất cả game</SelectItem>
                        {gameSources.map((source) => (
                            <SelectItem key={source.slug} value={source.slug}>
                                {source.name}
                            </SelectItem>
                        ))}
                    </SelectContent>
                </Select>

                <Select value={element} onValueChange={setElement}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-[var(--wiki-shell-accent)]/55 focus:ring-[var(--wiki-shell-accent)]/15">
                        <SelectValue placeholder="Tất cả hệ" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">Tất cả hệ</SelectItem>
                        {elements.map((option) => (
                            <SelectItem
                                key={`${option.game_source?.slug}-${option.game_id}`}
                                value={String(option.game_id)}
                            >
                                {filters.game === null &&
                                    option.game_source !== undefined &&
                                    `${option.game_source.name} · `}
                                {option.name}
                            </SelectItem>
                        ))}
                    </SelectContent>
                </Select>

                <Select value={tier} onValueChange={setTier}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-[var(--wiki-shell-accent)]/55 focus:ring-[var(--wiki-shell-accent)]/15">
                        <SelectValue placeholder="Bậc kỹ năng" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">Tất cả bậc</SelectItem>
                        {[0, 1, 2, 3, 4, 5].map((value) => (
                            <SelectItem key={value} value={String(value)}>
                                Bậc {value}
                            </SelectItem>
                        ))}
                    </SelectContent>
                </Select>

                <Select value={kind} onValueChange={setKind}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-[var(--wiki-shell-accent)]/55 focus:ring-[var(--wiki-shell-accent)]/15">
                        <SelectValue placeholder="Loại kỹ năng" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">Mọi loại</SelectItem>
                        <SelectItem value="damage">Có sát thương</SelectItem>
                        <SelectItem value="status">Trạng thái</SelectItem>
                    </SelectContent>
                </Select>

                <Select value={effect} onValueChange={setEffect}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-[var(--wiki-shell-accent)]/55 focus:ring-[var(--wiki-shell-accent)]/15">
                        <SelectValue placeholder="Hiệu ứng" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">Mọi hiệu ứng</SelectItem>
                        <SelectItem value="beneficial">Có lợi</SelectItem>
                        <SelectItem value="harmful">Bất lợi</SelectItem>
                        <SelectItem value="none">Không gắn status</SelectItem>
                    </SelectContent>
                </Select>

                <Select value={target} onValueChange={setTarget}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-[var(--wiki-shell-accent)]/55 focus:ring-[var(--wiki-shell-accent)]/15">
                        <SelectValue placeholder="Mục tiêu" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">Mọi mục tiêu</SelectItem>
                        <SelectItem value="opponent">Đối thủ</SelectItem>
                        <SelectItem value="self">Bản thân</SelectItem>
                    </SelectContent>
                </Select>

                <Select value={sort} onValueChange={setSort}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-[var(--wiki-shell-accent)]/55 focus:ring-[var(--wiki-shell-accent)]/15">
                        <SelectValue placeholder="Sắp xếp" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="game_id">Theo ID</SelectItem>
                        <SelectItem value="name">Theo tên</SelectItem>
                        <SelectItem value="power">Power cao nhất</SelectItem>
                        <SelectItem value="tier">Theo bậc</SelectItem>
                    </SelectContent>
                </Select>
            </WikiFilterPanel>

            <WikiResultsBar
                label="Kỹ năng chiến đấu"
                from={skills.from}
                to={skills.to}
                total={skills.total}
            />

            {skills.data.length === 0 ? (
                <WikiEmptyState />
            ) : (
                <section className="grid gap-4 md:grid-cols-2 xl:grid-cols-3">
                    {skills.data.map((skill, index) => {
                        const style = {
                            '--element-color': skill.element.color ?? '#64748b',
                            animationDelay: `${Math.min(index, 7) * 55}ms`,
                        } as CSSProperties;
                        const powerRingStyle = {
                            background: `conic-gradient(var(--element-color) ${Math.min(Math.max(skill.power_percent, 18), 100)}%, color-mix(in oklab, var(--element-color) 12%, transparent) 0)`,
                        };

                        return (
                            <Link
                                key={skill.id}
                                href={skillShow(skill.id)}
                                prefetch
                                style={style}
                                className="wiki-dossier wiki-card-fx group relative block overflow-hidden border border-white/10 bg-[#091725] shadow-[0_18px_42px_rgba(0,0,0,.26)] transition duration-300 hover:-translate-y-1 hover:border-[var(--element-color)]/55 hover:shadow-[0_22px_48px_color-mix(in_oklab,var(--element-color)_14%,rgba(0,0,0,.35))] focus-visible:outline-2 focus-visible:outline-offset-3 focus-visible:outline-[var(--element-color)]"
                            >
                                <div className="wiki-scanline relative flex items-center justify-between gap-3 overflow-hidden border-b border-[var(--element-color)]/18 bg-[radial-gradient(circle_at_52%_50%,color-mix(in_oklab,var(--element-color)_22%,transparent),transparent_38%),#071421] px-5 py-4">
                                    <span className="absolute inset-y-0 left-0 w-1.5 bg-[var(--element-color)]" />
                                    <span className="absolute -top-10 right-8 size-24 rounded-full border-[16px] border-white/4" />
                                    <span className="wiki-spark absolute top-2 left-1/2 size-1 rounded-full bg-[var(--element-color)] text-[var(--element-color)]" />
                                    <SkillSigil
                                        element={skill.element}
                                        gameSource={skill.game_source}
                                        skillId={skill.game_id}
                                        powerPercent={skill.power_percent}
                                        effectMode={skill.effect_mode}
                                        className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 opacity-78 transition duration-300 group-hover:scale-110 group-hover:opacity-100"
                                    />
                                    <ElementBadge element={skill.element} />
                                    <span className="relative bg-[var(--element-color)] px-2 py-1 font-mono text-[9px] font-black tracking-widest text-[#07111e] [clip-path:polygon(6px_0,100%_0,calc(100%_-_6px)_100%,0_100%)]">
                                        SKILL #
                                        {String(skill.game_id).padStart(2, '0')}
                                    </span>
                                </div>

                                <div className="p-5 sm:p-6">
                                    <GameSourceBadge
                                        source={skill.game_source}
                                    />
                                    <div className="flex items-start justify-between gap-3">
                                        <div className="min-w-0">
                                            <p className="text-[10px] font-black tracking-[0.16em] text-[var(--element-color)] uppercase">
                                                Combat protocol
                                            </p>
                                            <h2 className="mt-1 text-xl leading-7 font-black tracking-tight text-white">
                                                {skill.name}
                                            </h2>
                                            <div className="mt-3 flex flex-wrap gap-1.5">
                                                <Badge className="rounded-none bg-[var(--element-color)] text-[#07111e]">
                                                    Bậc {skill.tier}
                                                </Badge>
                                                <Badge
                                                    variant="outline"
                                                    className="rounded-none border-white/12 text-slate-300"
                                                >
                                                    {skill.energy_cost !== null
                                                        ? `NL ${skill.energy_cost}`
                                                        : `PP ${skill.max_uses}`}
                                                </Badge>
                                                <Badge
                                                    variant="outline"
                                                    className="rounded-none border-white/12 text-slate-300"
                                                >
                                                    {skill.target_side === 1
                                                        ? 'Bản thân'
                                                        : 'Đối thủ'}
                                                </Badge>
                                            </div>
                                        </div>
                                        <div
                                            style={powerRingStyle}
                                            className="relative flex size-19 shrink-0 items-center justify-center rounded-full p-1 shadow-[0_10px_28px_color-mix(in_oklab,var(--element-color)_22%,transparent)] transition-transform duration-300 group-hover:scale-105 group-hover:rotate-3"
                                        >
                                            <div className="flex size-full flex-col items-center justify-center rounded-full bg-[#091725] text-[var(--element-color)] shadow-inner">
                                                {skill.power_percent > 0 ? (
                                                    <>
                                                        <Swords className="size-4" />
                                                        <strong className="mt-0.5 text-sm font-black tabular-nums">
                                                            {
                                                                skill.power_percent
                                                            }
                                                            %
                                                        </strong>
                                                    </>
                                                ) : (
                                                    <>
                                                        <Zap className="size-4" />
                                                        <strong className="mt-0.5 text-[8px] font-black uppercase">
                                                            Status
                                                        </strong>
                                                    </>
                                                )}
                                            </div>
                                        </div>
                                    </div>

                                    <p className="mt-5 line-clamp-3 min-h-15 border-l-2 border-[var(--element-color)]/35 pl-3 text-sm leading-5 text-slate-400">
                                        {skill.description}
                                    </p>

                                    <div className="relative mt-5 flex min-h-14 items-center justify-between gap-3 overflow-hidden border border-white/7 bg-black/14 px-3.5 py-3 text-xs text-slate-200">
                                        <span className="absolute inset-y-0 left-0 w-0.5 bg-[var(--element-color)]/60" />
                                        {skill.effect ? (
                                            <EffectBadge
                                                effect={skill.effect}
                                            />
                                        ) : (
                                            <span className="text-slate-400">
                                                Không gắn trạng thái chuẩn
                                            </span>
                                        )}
                                        {skill.effect_parameter !== null && (
                                            <span className="bg-white/6 px-2 py-1 font-mono font-bold text-slate-400">
                                                P: {skill.effect_parameter}
                                            </span>
                                        )}
                                    </div>
                                    <span className="mt-4 flex items-center justify-end gap-1.5 font-mono text-[9px] font-black tracking-[.14em] text-[var(--element-color)] uppercase">
                                        Mở hồ sơ kỹ năng
                                        <ArrowUpRight className="size-3.5 transition-transform group-hover:translate-x-0.5 group-hover:-translate-y-0.5" />
                                    </span>
                                </div>
                            </Link>
                        );
                    })}
                </section>
            )}

            <WikiPagination
                pagination={skills}
                previousHref={skillsIndex({
                    query: {
                        ...appliedQuery,
                        page: Math.max(1, skills.current_page - 1),
                    },
                })}
                nextHref={skillsIndex({
                    query: {
                        ...appliedQuery,
                        page: Math.min(
                            skills.last_page,
                            skills.current_page + 1,
                        ),
                    },
                })}
            />
        </>
    );
}
