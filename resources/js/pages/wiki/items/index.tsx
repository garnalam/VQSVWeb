import { Head, router } from '@inertiajs/react';
import {
    Backpack,
    BadgeCheck,
    CircleDollarSign,
    PackageOpen,
    ScrollText,
} from 'lucide-react';
import type { FormEvent } from 'react';
import { useState } from 'react';
import { Badge } from '@/components/ui/badge';
import {
    Select,
    SelectContent,
    SelectItem,
    SelectTrigger,
    SelectValue,
} from '@/components/ui/select';
import { GameArtwork } from '@/components/wiki/game-artwork';
import { GameSourceBadge } from '@/components/wiki/game-source-badge';
import { WikiEmptyState } from '@/components/wiki/wiki-empty-state';
import { WikiFilterPanel } from '@/components/wiki/wiki-filter-panel';
import { WikiPageHeader } from '@/components/wiki/wiki-page-header';
import { WikiPagination } from '@/components/wiki/wiki-pagination';
import { WikiResultsBar } from '@/components/wiki/wiki-results-bar';
import { badgeArtworkUrl, itemArtworkUrl } from '@/lib/game-assets';
import { compactWikiQuery } from '@/lib/wiki';
import { index as itemsIndex } from '@/routes/wiki/items';
import type { PaginatedWikiData, WikiGameSource, WikiItem } from '@/types';

const SOURCE_TABLE_LABELS: Record<number, string> = {
    0: 'Kho vật phẩm Cầu Vồng',
    2: 'Huy chương',
    3: 'Trang sức & nguyên liệu',
    4: 'Tiêu hao',
    5: 'Đặc thù',
};

const CATEGORY_LABELS: Record<string, string> = {
    consumable: 'Đạo cụ',
    mineral: 'Khoáng thạch',
    medal: 'Huy chương',
    ring: 'Vòng',
    accessory: 'Trang sức',
    badge: 'Huy chương',
    badge_book: 'Sổ huy chương',
    capture_ball: 'Cầu phong ấn',
    encyclopedia: 'Đồ giám',
    evolution_material: 'Nguyên liệu tiến hóa',
    key: 'Chìa khóa',
    mount: 'Thú cưỡi',
    mutation_material: 'Nguyên liệu dị hóa',
    pet_egg: 'Trứng Pet',
    recovery: 'Hồi phục',
    stat_modifier: 'Chỉnh thuộc tính',
    teleport: 'Truyền tống',
    utility: 'Tiện ích',
};

const SOURCE_TABLE_ARTWORK: Record<number, string> = {
    0: 'from-cyan-400 via-sky-500 to-violet-600',
    2: 'from-amber-400 via-orange-500 to-rose-600',
    3: 'from-violet-500 via-fuchsia-500 to-pink-600',
    4: 'from-emerald-400 via-teal-500 to-cyan-600',
    5: 'from-sky-400 via-blue-600 to-indigo-700',
};

type ItemFilters = {
    q: string;
    game: string | null;
    source_table: number | null;
    category: string | null;
    sort: string;
};

type ItemIndexProps = {
    items: PaginatedWikiData<WikiItem>;
    categories: string[];
    gameSources: WikiGameSource[];
    filters: ItemFilters;
};

export default function ItemIndex({
    items,
    categories,
    gameSources,
    filters,
}: ItemIndexProps) {
    const [query, setQuery] = useState(filters.q);
    const [sourceTable, setSourceTable] = useState(
        filters.source_table === null ? 'all' : String(filters.source_table),
    );
    const [game, setGame] = useState(filters.game ?? 'all');
    const [category, setCategory] = useState(filters.category ?? 'all');
    const [sort, setSort] = useState(filters.sort);

    const appliedQuery = compactWikiQuery(filters);
    const selectedSource = gameSources.find(
        (source) => source.slug === filters.game,
    );
    const description =
        selectedSource === undefined
            ? 'Tra cứu vật phẩm, nguyên liệu, huy chương và đạo cụ theo đúng nguồn dữ liệu của từng phiên bản game.'
            : `Tra cứu kho vật phẩm ${selectedSource.name} với tên, mô tả và icon được phục hồi trực tiếp từ game.`;

    function submit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();

        router.visit(
            itemsIndex({
                query: compactWikiQuery({
                    q: query,
                    game: game === 'all' ? null : game,
                    source_table:
                        sourceTable === 'all' ? null : Number(sourceTable),
                    category: category === 'all' ? null : category,
                    sort,
                }),
            }),
            { preserveScroll: true, preserveState: true, replace: true },
        );
    }

    return (
        <>
            <Head title="Kho vật phẩm" />
            <WikiPageHeader
                eyebrow="VQSV Item Vault"
                title="Kho vật phẩm"
                description={description}
                total={items.total}
                unit="vật phẩm phù hợp"
                icon={<Backpack className="size-4" />}
                theme="items"
            />

            <WikiFilterPanel
                query={query}
                onQueryChange={setQuery}
                onSubmit={submit}
                resetHref={itemsIndex()}
                placeholder="Tên, mô tả hoặc ID vật phẩm..."
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

                <Select value={sourceTable} onValueChange={setSourceTable}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-[var(--wiki-shell-accent)]/55 focus:ring-[var(--wiki-shell-accent)]/15">
                        <SelectValue placeholder="Bảng nguồn" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">Tất cả bảng nguồn</SelectItem>
                        {Object.entries(SOURCE_TABLE_LABELS).map(
                            ([value, label]) => (
                                <SelectItem key={value} value={value}>
                                    db[{value}] · {label}
                                </SelectItem>
                            ),
                        )}
                    </SelectContent>
                </Select>

                <Select value={category} onValueChange={setCategory}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-[var(--wiki-shell-accent)]/55 focus:ring-[var(--wiki-shell-accent)]/15">
                        <SelectValue placeholder="Phân loại" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">Tất cả phân loại</SelectItem>
                        {categories.map((value) => (
                            <SelectItem key={value} value={value}>
                                {CATEGORY_LABELS[value] ?? value}
                            </SelectItem>
                        ))}
                    </SelectContent>
                </Select>

                <Select value={sort} onValueChange={setSort}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none focus:border-[var(--wiki-shell-accent)]/55 focus:ring-[var(--wiki-shell-accent)]/15">
                        <SelectValue placeholder="Sắp xếp" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="game_id">Theo ID nguồn</SelectItem>
                        <SelectItem value="name">Theo tên</SelectItem>
                        <SelectItem value="cost">Giá cao nhất</SelectItem>
                    </SelectContent>
                </Select>
            </WikiFilterPanel>

            <WikiResultsBar
                label="Kho trang bị & đạo cụ"
                from={items.from}
                to={items.to}
                total={items.total}
            />

            {items.data.length === 0 ? (
                <WikiEmptyState />
            ) : (
                <section className="grid gap-4 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4">
                    {items.data.map((item, index) => (
                        <article
                            key={item.id}
                            style={{
                                animationDelay: `${Math.min(index, 7) * 55}ms`,
                            }}
                            className="wiki-dossier wiki-card-fx group relative flex min-h-82 flex-col overflow-hidden border border-white/10 bg-[#091725] shadow-[0_18px_42px_rgba(0,0,0,.26)] transition duration-300 hover:-translate-y-1 hover:border-[var(--wiki-shell-accent)]/50 hover:shadow-[0_22px_48px_color-mix(in_oklab,var(--wiki-shell-accent)_14%,rgba(0,0,0,.35))]"
                        >
                            <div
                                className={`wiki-hologram wiki-scanline relative flex h-34 items-center justify-center overflow-hidden bg-linear-to-br ${SOURCE_TABLE_ARTWORK[item.source_table] ?? 'from-slate-500 to-slate-800'}`}
                            >
                                <span className="absolute -top-9 -left-8 size-28 rounded-full border-[18px] border-white/10" />
                                <span className="absolute -right-8 -bottom-12 size-36 rounded-full border border-white/20" />
                                <span className="wiki-spark absolute top-8 left-[34%] size-1.5 rounded-full bg-white text-white [animation-delay:-.4s]" />
                                <span className="wiki-spark absolute right-[28%] bottom-5 size-1 rounded-full bg-yellow-200 text-yellow-200 [animation-delay:-1.4s]" />
                                <span className="absolute top-4 right-4 rounded-full border border-white/20 bg-slate-950/25 px-2.5 py-1 font-mono text-[10px] font-black tracking-wider text-white backdrop-blur-sm">
                                    db[{item.source_table}]#{item.game_id}
                                </span>
                                <span className="absolute top-4 left-4 rounded-full border border-white/20 bg-white/15 px-2.5 py-1 text-[9px] font-black tracking-widest text-white uppercase backdrop-blur-sm">
                                    {SOURCE_TABLE_LABELS[item.source_table] ??
                                        `Bảng ${item.source_table}`}
                                </span>

                                <div
                                    style={{
                                        animationDelay: `-${(item.id % 5) * 0.7}s`,
                                    }}
                                    className="wiki-float relative z-10 flex size-24 items-center justify-center border border-white/35 bg-[#071421]/70 text-white shadow-[0_18px_38px_rgba(2,6,23,0.28)] backdrop-blur-sm [clip-path:polygon(10px_0,100%_0,100%_calc(100%_-_10px),calc(100%_-_10px)_100%,0_100%,0_10px)]"
                                >
                                    <GameArtwork
                                        src={
                                            item.source_table === 2
                                                ? badgeArtworkUrl(item.game_id)
                                                : itemArtworkUrl(
                                                      item.frame_id,
                                                      item.game_source
                                                          .asset_key,
                                                  )
                                        }
                                        alt={`Icon gốc của ${item.name}`}
                                        className="size-16 transition-transform duration-300 group-hover:scale-125"
                                        fallback={
                                            <PackageOpen className="size-9" />
                                        }
                                    />
                                    <span className="absolute -right-2 -bottom-2 rounded-lg bg-[#0d1b33] px-2 py-1 text-[9px] font-black shadow-lg">
                                        {item.source_table === 2
                                            ? `C${item.game_id + 46}`
                                            : `F${item.frame_id ?? '—'}`}
                                    </span>
                                </div>
                            </div>

                            <div className="flex flex-1 flex-col p-5">
                                <GameSourceBadge source={item.game_source} />
                                <div>
                                    <Badge
                                        variant="outline"
                                        className="rounded-none border-[var(--wiki-shell-accent)]/30 bg-[var(--wiki-shell-accent)]/8 text-[9px] font-black tracking-wide text-[var(--wiki-shell-accent)] uppercase"
                                    >
                                        {CATEGORY_LABELS[item.category] ??
                                            item.category}
                                    </Badge>
                                    <h2 className="mt-3 min-h-12 text-lg leading-6 font-black tracking-tight text-white">
                                        {item.name}
                                    </h2>
                                </div>

                                <p className="mt-3 line-clamp-3 text-sm leading-5 text-slate-400">
                                    {item.description ??
                                        'Chưa có mô tả hiển thị trong dữ liệu gốc.'}
                                </p>

                                <div className="mt-auto grid grid-cols-2 gap-2 border-t border-white/8 pt-4 text-xs">
                                    <div className="border border-amber-400/12 bg-amber-500/8 px-3 py-2.5">
                                        <span className="flex items-center gap-1 text-amber-300/75">
                                            <CircleDollarSign className="size-3.5" />
                                            Giá
                                        </span>
                                        <strong className="mt-1 block text-sm text-white tabular-nums">
                                            {item.cost === null
                                                ? '—'
                                                : `${item.cost} · C${item.currency_code}`}
                                        </strong>
                                    </div>
                                    <div className="border border-cyan-300/12 bg-cyan-500/8 px-3 py-2.5">
                                        <span className="flex items-center gap-1 text-cyan-300/75">
                                            {item.effect_type === null ? (
                                                <ScrollText className="size-3.5" />
                                            ) : (
                                                <BadgeCheck className="size-3.5" />
                                            )}
                                            Effect
                                        </span>
                                        <strong className="mt-1 block text-sm text-white">
                                            {item.effect_type === null
                                                ? 'Dữ liệu riêng'
                                                : `Type ${item.effect_type}`}
                                        </strong>
                                    </div>
                                </div>
                            </div>
                        </article>
                    ))}
                </section>
            )}

            <WikiPagination
                pagination={items}
                previousHref={itemsIndex({
                    query: {
                        ...appliedQuery,
                        page: Math.max(1, items.current_page - 1),
                    },
                })}
                nextHref={itemsIndex({
                    query: {
                        ...appliedQuery,
                        page: Math.min(items.last_page, items.current_page + 1),
                    },
                })}
            />
        </>
    );
}
