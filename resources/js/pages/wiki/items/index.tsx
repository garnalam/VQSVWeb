import { Head, Link, router } from '@inertiajs/react';
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
import { WikiEmptyState } from '@/components/wiki/wiki-empty-state';
import { WikiFilterPanel } from '@/components/wiki/wiki-filter-panel';
import { WikiPageHeader } from '@/components/wiki/wiki-page-header';
import { WikiPagination } from '@/components/wiki/wiki-pagination';
import { WikiResultsBar } from '@/components/wiki/wiki-results-bar';
import { badgeArtworkUrl, itemArtworkUrl } from '@/lib/game-assets';
import { compactWikiQuery } from '@/lib/wiki';
import {
    ITEM_CATEGORY_LABELS,
    ITEM_SOURCE_ARTWORK,
    ITEM_SOURCE_LABELS,
    itemCategoryLabel,
    itemEffectLabel,
    itemSourceLabel,
} from '@/lib/wiki-presenters';
import { index as itemsIndex, show as itemShow } from '@/routes/wiki/items';
import type { PaginatedWikiData, WikiGameSource, WikiItem } from '@/types';

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
                        <SelectValue placeholder="Nhóm vật phẩm" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">
                            Tất cả nhóm vật phẩm
                        </SelectItem>
                        {Object.entries(ITEM_SOURCE_LABELS).map(
                            ([value, label]) => (
                                <SelectItem key={value} value={value}>
                                    {label}
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
                                {ITEM_CATEGORY_LABELS[value] ?? value}
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
                        <Link
                            key={item.id}
                            href={itemShow(item.id)}
                            prefetch
                            style={{
                                animationDelay: `${Math.min(index, 7) * 55}ms`,
                            }}
                            className="wiki-dossier wiki-card-fx group relative flex min-h-82 flex-col overflow-hidden border border-white/10 bg-[#091725] shadow-[0_18px_42px_rgba(0,0,0,.26)] transition duration-300 hover:-translate-y-1 hover:border-[var(--wiki-shell-accent)]/50 hover:shadow-[0_22px_48px_color-mix(in_oklab,var(--wiki-shell-accent)_14%,rgba(0,0,0,.35))]"
                        >
                            <div
                                className={`wiki-hologram wiki-scanline relative flex h-34 items-center justify-center overflow-hidden bg-linear-to-br ${ITEM_SOURCE_ARTWORK[item.source_table] ?? 'from-slate-500 to-slate-800'}`}
                            >
                                <span className="absolute -top-9 -left-8 size-28 rounded-full border-[18px] border-white/10" />
                                <span className="absolute -right-8 -bottom-12 size-36 rounded-full border border-white/20" />
                                <span className="wiki-spark absolute top-8 left-[34%] size-1.5 rounded-full bg-white text-white [animation-delay:-.4s]" />
                                <span className="wiki-spark absolute right-[28%] bottom-5 size-1 rounded-full bg-yellow-200 text-yellow-200 [animation-delay:-1.4s]" />
                                <span className="absolute top-4 right-4 rounded-full border border-white/20 bg-slate-950/25 px-2.5 py-1 font-mono text-[10px] font-black tracking-wider text-white backdrop-blur-sm">
                                    Vật phẩm #{item.game_id}
                                </span>
                                <span className="absolute top-4 left-4 rounded-full border border-white/20 bg-white/15 px-2.5 py-1 text-[9px] font-black tracking-widest text-white uppercase backdrop-blur-sm">
                                    {itemSourceLabel(item.source_table)}
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
                                </div>
                            </div>

                            <div className="flex flex-1 flex-col p-5">
                                <div>
                                    <Badge
                                        variant="outline"
                                        className="rounded-none border-[var(--wiki-shell-accent)]/30 bg-[var(--wiki-shell-accent)]/8 text-[9px] font-black tracking-wide text-[var(--wiki-shell-accent)] uppercase"
                                    >
                                        {itemCategoryLabel(item.category)}
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
                                                ? 'Không bán'
                                                : item.cost.toLocaleString(
                                                      'vi-VN',
                                                  )}
                                        </strong>
                                    </div>
                                    <div className="border border-cyan-300/12 bg-cyan-500/8 px-3 py-2.5">
                                        <span className="flex items-center gap-1 text-cyan-300/75">
                                            {item.effect_type === null ? (
                                                <ScrollText className="size-3.5" />
                                            ) : (
                                                <BadgeCheck className="size-3.5" />
                                            )}
                                            Công dụng
                                        </span>
                                        <strong className="mt-1 block text-sm text-white">
                                            {itemEffectLabel(item)}
                                        </strong>
                                    </div>
                                </div>
                            </div>
                        </Link>
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
