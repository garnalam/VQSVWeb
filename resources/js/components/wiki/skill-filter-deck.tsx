import { Link, router } from '@inertiajs/react';
import {
    Check,
    Filter,
    RotateCcw,
    Search,
    SlidersHorizontal,
    Sparkles,
} from 'lucide-react';
import type { CSSProperties, FormEvent } from 'react';
import { useState } from 'react';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import {
    Select,
    SelectContent,
    SelectItem,
    SelectTrigger,
    SelectValue,
} from '@/components/ui/select';
import {
    Sheet,
    SheetClose,
    SheetContent,
    SheetDescription,
    SheetFooter,
    SheetHeader,
    SheetTitle,
    SheetTrigger,
} from '@/components/ui/sheet';
import { elementIconUrl } from '@/lib/game-assets';
import { cn } from '@/lib/utils';
import { compactWikiQuery } from '@/lib/wiki';
import { index as skillsIndex } from '@/routes/wiki/skills';
import type { WikiCombatElement } from '@/types';

export type SkillFilters = {
    q: string;
    element: string | null;
    tier: number | null;
    effect: string | null;
    target: string | null;
    source: string | null;
    role: string | null;
    unlock: number | null;
    sort: string;
};

type SkillFilterDeckProps = {
    filters: SkillFilters;
    elements: WikiCombatElement[];
    unlockMilestones: number[];
};

const selectClassName =
    'h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-cyan-300/55 focus:ring-cyan-300/15';

export function SkillFilterDeck({
    filters,
    elements,
    unlockMilestones,
}: SkillFilterDeckProps) {
    const [query, setQuery] = useState(filters.q);
    const [element, setElement] = useState(filters.element ?? 'all');
    const [tier, setTier] = useState(
        filters.tier === null ? 'all' : String(filters.tier),
    );
    const [effect, setEffect] = useState(filters.effect ?? 'all');
    const [target, setTarget] = useState(filters.target ?? 'all');
    const [source, setSource] = useState(filters.source ?? 'all');
    const [role, setRole] = useState(filters.role ?? 'all');
    const [unlock, setUnlock] = useState(
        filters.unlock === null ? 'all' : String(filters.unlock),
    );
    const [sort, setSort] = useState(filters.sort);

    const advancedFilterCount = [
        tier,
        effect,
        target,
        source,
        role,
        unlock,
    ].filter((value) => value !== 'all').length;

    function submit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();
        visitCatalog();
    }

    function visitCatalog(overrides: Partial<SkillFilters> = {}) {
        const nextElement = Object.hasOwn(overrides, 'element')
            ? (overrides.element ?? null)
            : element === 'all'
              ? null
              : element;

        router.visit(
            skillsIndex({
                query: compactWikiQuery({
                    q: overrides.q ?? query,
                    element: nextElement,
                    tier:
                        overrides.tier ??
                        (tier === 'all' ? null : Number(tier)),
                    effect:
                        overrides.effect ?? (effect === 'all' ? null : effect),
                    target:
                        overrides.target ?? (target === 'all' ? null : target),
                    source:
                        overrides.source ?? (source === 'all' ? null : source),
                    role: overrides.role ?? (role === 'all' ? null : role),
                    unlock:
                        overrides.unlock ??
                        (unlock === 'all' ? null : Number(unlock)),
                    sort: overrides.sort ?? sort,
                }),
            }),
            {
                preserveScroll: true,
                preserveState: true,
                replace: true,
            },
        );
    }

    function selectElement(nextElement: string) {
        setElement(nextElement);
        visitCatalog({
            element: nextElement === 'all' ? null : nextElement,
        });
    }

    const advancedFields = (
        <>
            <Select value={source} onValueChange={setSource}>
                <SelectTrigger className={selectClassName}>
                    <SelectValue placeholder="Nguồn học" />
                </SelectTrigger>
                <SelectContent>
                    <SelectItem value="all">Mọi nguồn học</SelectItem>
                    <SelectItem value="element">Bể kỹ năng Hệ</SelectItem>
                    <SelectItem value="species">Bể kỹ năng Chủng</SelectItem>
                    <SelectItem value="style">Bể kỹ năng phong cách</SelectItem>
                    <SelectItem value="signature">
                        Đặc trưng Form / Dòng
                    </SelectItem>
                </SelectContent>
            </Select>

            <Select value={role} onValueChange={setRole}>
                <SelectTrigger className={selectClassName}>
                    <SelectValue placeholder="Vai trò chiến thuật" />
                </SelectTrigger>
                <SelectContent>
                    <SelectItem value="all">Mọi vai trò</SelectItem>
                    <SelectItem value="attack">Tấn công trực diện</SelectItem>
                    <SelectItem value="defense">Bảo vệ / Lá chắn</SelectItem>
                    <SelectItem value="heal">Hồi phục</SelectItem>
                    <SelectItem value="control">Khống chế</SelectItem>
                    <SelectItem value="disrupt">Gây rối nhịp đấu</SelectItem>
                    <SelectItem value="modifier">Buff / Debuff</SelectItem>
                </SelectContent>
            </Select>

            <Select value={unlock} onValueChange={setUnlock}>
                <SelectTrigger className={selectClassName}>
                    <SelectValue placeholder="Mốc mở khóa" />
                </SelectTrigger>
                <SelectContent>
                    <SelectItem value="all">Mọi mốc mở khóa</SelectItem>
                    {unlockMilestones.map((level) => (
                        <SelectItem key={level} value={String(level)}>
                            Cấp {level}
                        </SelectItem>
                    ))}
                </SelectContent>
            </Select>

            <Select value={target} onValueChange={setTarget}>
                <SelectTrigger className={selectClassName}>
                    <SelectValue placeholder="Ma trận mục tiêu" />
                </SelectTrigger>
                <SelectContent>
                    <SelectItem value="all">Mọi mục tiêu</SelectItem>
                    <SelectItem value="self">Bản thân</SelectItem>
                    <SelectItem value="single_enemy">Một đối thủ</SelectItem>
                    <SelectItem value="self_or_ally">
                        Bản thân hoặc 1 đồng minh
                    </SelectItem>
                    <SelectItem value="all_enemies">Toàn bộ đối thủ</SelectItem>
                    <SelectItem value="all_allies">
                        Toàn đội, gồm bản thân
                    </SelectItem>
                    <SelectItem value="battlefield">
                        Toàn chiến trường
                    </SelectItem>
                </SelectContent>
            </Select>

            <Select value={tier} onValueChange={setTier}>
                <SelectTrigger className={selectClassName}>
                    <SelectValue placeholder="Bậc Tier" />
                </SelectTrigger>
                <SelectContent>
                    <SelectItem value="all">Tất cả Tier</SelectItem>
                    {[0, 1, 2, 3].map((value) => (
                        <SelectItem key={value} value={String(value)}>
                            Tier {value}
                        </SelectItem>
                    ))}
                </SelectContent>
            </Select>

            <Select value={effect} onValueChange={setEffect}>
                <SelectTrigger className={selectClassName}>
                    <SelectValue placeholder="Tính chất Effect" />
                </SelectTrigger>
                <SelectContent>
                    <SelectItem value="all">Mọi Effect</SelectItem>
                    <SelectItem value="beneficial">Buff có lợi</SelectItem>
                    <SelectItem value="harmful">Debuff bất lợi</SelectItem>
                    <SelectItem value="none">Không gắn trạng thái</SelectItem>
                </SelectContent>
            </Select>

            <Select value={sort} onValueChange={setSort}>
                <SelectTrigger className={selectClassName}>
                    <SelectValue placeholder="Sắp xếp" />
                </SelectTrigger>
                <SelectContent>
                    <SelectItem value="id">Theo Wiki ID</SelectItem>
                    <SelectItem value="name">Theo tên</SelectItem>
                    <SelectItem value="power">Uy lực cao nhất</SelectItem>
                    <SelectItem value="tier">Theo Tier</SelectItem>
                </SelectContent>
            </Select>
        </>
    );

    return (
        <section className="relative border border-cyan-300/18 bg-[#061522]/94 p-3 shadow-[0_20px_48px_rgba(0,0,0,.3)] [clip-path:polygon(0_12px,12px_0,calc(100%_-_16px)_0,100%_16px,100%_100%,16px_100%,0_calc(100%_-_16px))] sm:p-4">
            <div className="absolute inset-x-0 top-0 h-px bg-linear-to-r from-cyan-300 via-amber-300 to-transparent" />

            <div className="mb-3 flex items-center justify-between gap-3 px-1">
                <div className="flex items-center gap-2 font-mono text-[9px] font-black tracking-[.18em] text-cyan-200 uppercase">
                    <SlidersHorizontal className="size-3.5 text-amber-300" />
                    Smart Filter Deck
                    <span className="hidden text-slate-600 sm:inline">
                        // Tactical Query
                    </span>
                </div>
                <span className="flex items-center gap-2 font-mono text-[8px] tracking-[.14em] text-slate-500 uppercase">
                    <i className="wiki-signal size-1.5 rounded-full bg-emerald-400" />
                    Live scan
                </span>
            </div>

            <form onSubmit={submit} className="flex flex-wrap gap-2">
                <label className="relative block min-w-0 flex-1 basis-full lg:basis-auto">
                    <span className="sr-only">Tìm kiếm kỹ năng</span>
                    <Search className="pointer-events-none absolute top-1/2 left-3.5 size-4 -translate-y-1/2 text-cyan-300" />
                    <Input
                        value={query}
                        onChange={(event) => setQuery(event.target.value)}
                        placeholder="Tên, mô tả hoặc Wiki ID kỹ năng..."
                        className="h-12 rounded-none border-cyan-100/14 bg-white/5 pr-24 pl-10 text-white shadow-inner placeholder:text-slate-500 focus-visible:border-cyan-300/65 focus-visible:ring-cyan-300/15"
                    />
                    <Button
                        type="submit"
                        aria-label="Tìm kiếm kỹ năng"
                        className="absolute top-1 right-1 h-10 rounded-none border border-cyan-200/20 bg-cyan-300 px-4 font-black text-[#04121f] hover:bg-white"
                    >
                        <Search />
                        <span className="hidden sm:inline">Quét</span>
                    </Button>
                </label>

                <Sheet>
                    <SheetTrigger asChild>
                        <Button
                            type="button"
                            variant="outline"
                            aria-label={`Bộ lọc nâng cao (${advancedFilterCount})`}
                            className="h-12 w-full rounded-none border-amber-300/35 bg-amber-300/8 px-3 text-amber-200 hover:bg-amber-300/15 hover:text-amber-100 lg:hidden"
                        >
                            <Filter />
                            <span>Bộ lọc nâng cao</span>
                            {advancedFilterCount > 0 && (
                                <span className="flex size-5 items-center justify-center bg-amber-300 font-mono text-[9px] font-black text-[#07111e]">
                                    {advancedFilterCount}
                                </span>
                            )}
                        </Button>
                    </SheetTrigger>
                    <SheetContent
                        side="bottom"
                        className="max-h-[86vh] overflow-y-auto border-cyan-300/24 bg-[#06121f] text-white"
                    >
                        <SheetHeader className="border-b border-white/8">
                            <SheetTitle className="flex items-center gap-2 text-cyan-200">
                                <SlidersHorizontal className="size-4 text-amber-300" />
                                Bộ lọc chiến thuật nâng cao
                            </SheetTitle>
                            <SheetDescription className="text-slate-400">
                                Lọc theo nguồn học, vai trò, mốc cấp, mục tiêu,
                                Tier và Effect.
                            </SheetDescription>
                        </SheetHeader>
                        <div className="grid gap-3 px-4 sm:grid-cols-2">
                            {advancedFields}
                        </div>
                        <SheetFooter className="border-t border-white/8 sm:flex-row">
                            <Button
                                variant="outline"
                                className="rounded-none border-white/12 bg-white/4 text-slate-300"
                                asChild
                            >
                                <Link href={skillsIndex()}>
                                    <RotateCcw /> Đặt lại
                                </Link>
                            </Button>
                            <SheetClose asChild>
                                <Button
                                    type="button"
                                    onClick={() => visitCatalog()}
                                    className="rounded-none bg-cyan-300 font-black text-[#04121f] hover:bg-white"
                                >
                                    <Check /> Áp dụng bộ lọc
                                </Button>
                            </SheetClose>
                        </SheetFooter>
                    </SheetContent>
                </Sheet>
            </form>

            <div className="mt-3 flex [scrollbar-width:none] gap-2 overflow-x-auto pb-1 [&::-webkit-scrollbar]:hidden">
                <button
                    type="button"
                    onClick={() => selectElement('all')}
                    className={cn(
                        'flex h-10 shrink-0 items-center gap-2 border px-3 font-mono text-[9px] font-black tracking-[.1em] uppercase transition',
                        element === 'all'
                            ? 'border-cyan-300 bg-cyan-300 text-[#04121f] shadow-[0_0_18px_rgba(0,229,255,.2)]'
                            : 'border-white/9 bg-white/4 text-slate-400 hover:border-cyan-300/35 hover:text-cyan-100',
                    )}
                >
                    <Sparkles className="size-3.5" />
                    Tất cả Hệ
                </button>
                {elements.map((option) => (
                    <button
                        key={option.slug}
                        type="button"
                        onClick={() => selectElement(option.slug)}
                        style={
                            {
                                '--filter-element': option.color,
                            } as CSSProperties
                        }
                        className={cn(
                            'flex h-10 shrink-0 items-center gap-2 border px-3 font-mono text-[9px] font-black tracking-[.1em] uppercase transition',
                            element === option.slug
                                ? 'border-[var(--filter-element)] bg-[var(--filter-element)]/18 text-white shadow-[inset_0_-2px_0_var(--filter-element),0_0_18px_color-mix(in_oklab,var(--filter-element)_18%,transparent)]'
                                : 'border-white/9 bg-white/4 text-slate-400 hover:border-[var(--filter-element)]/45 hover:text-white',
                        )}
                    >
                        <img
                            src={elementIconUrl(option.game_id)}
                            alt=""
                            className="wiki-pixel-art size-5 object-contain"
                        />
                        {option.name}
                    </button>
                ))}
            </div>

            <div className="mt-3 hidden grid-cols-4 gap-2 border-t border-white/7 pt-3 lg:grid">
                {advancedFields}
                <Button
                    type="button"
                    onClick={() => visitCatalog()}
                    className="h-11 rounded-none border border-cyan-300 bg-cyan-300 font-black text-[#04121f] hover:bg-white"
                >
                    <Filter /> Áp dụng
                    {advancedFilterCount > 0 && ` (${advancedFilterCount})`}
                </Button>
                <Button
                    variant="outline"
                    className="h-11 rounded-none border-white/10 bg-white/4 text-slate-400 hover:border-white/20 hover:bg-white/8 hover:text-white"
                    asChild
                >
                    <Link href={skillsIndex()} preserveScroll>
                        <RotateCcw /> Đặt lại
                    </Link>
                </Button>
            </div>
        </section>
    );
}
