import { Head, Link } from '@inertiajs/react';
import {
    ArrowLeft,
    ArrowRight,
    Backpack,
    Database,
    GitBranch,
    PackageOpen,
    PawPrint,
    ScrollText,
    Sparkles,
} from 'lucide-react';
import type { ReactNode } from 'react';
import { GameArtwork } from '@/components/wiki/game-artwork';
import {
    badgeArtworkUrl,
    itemArtworkUrl,
    petArtworkUrl,
} from '@/lib/game-assets';
import {
    itemCategoryLabel,
    itemEffectLabel,
    itemSourceLabel,
} from '@/lib/wiki-presenters';
import { index as itemsIndex } from '@/routes/wiki/items';
import { show as petShow } from '@/routes/wiki/pets';
import type { WikiItemDetail } from '@/types';

type ItemShowProps = {
    item: WikiItemDetail;
};

export default function ItemShow({ item }: ItemShowProps) {
    const artwork =
        item.source_table === 2
            ? badgeArtworkUrl(item.game_id)
            : itemArtworkUrl(item.frame_id, item.game_source.asset_key);
    const upgradeDescription = readTextParameter(
        item.effect_parameters,
        'upgrade_description',
    );
    const condition = readTextParameter(item.effect_parameters, 'condition');

    return (
        <div className="flex flex-col gap-5">
            <Head title={`${item.name} · Vật phẩm`} />

            <nav className="flex flex-wrap items-center gap-2 text-sm text-slate-500">
                <Link
                    href={itemsIndex()}
                    className="inline-flex items-center gap-2 font-bold text-slate-300 transition hover:text-[var(--wiki-shell-accent)]"
                >
                    <ArrowLeft className="size-4" />
                    Kho vật phẩm
                </Link>
                <span>/</span>
                <span>{itemCategoryLabel(item.category)}</span>
                <span>/</span>
                <strong className="text-white">{item.name}</strong>
            </nav>

            <div className="grid gap-5 xl:grid-cols-[minmax(0,1.85fr)_minmax(19rem,1fr)]">
                <main className="flex min-w-0 flex-col gap-5">
                    <section className="wiki-console wiki-panel relative isolate overflow-hidden [clip-path:polygon(0_20px,20px_0,calc(100%_-_56px)_0,calc(100%_-_36px)_20px,100%_20px,100%_calc(100%_-_20px),calc(100%_-_20px)_100%,20px_100%,0_calc(100%_-_20px))]">
                        <div className="absolute inset-x-0 top-0 h-[3px] bg-linear-to-r from-emerald-300 via-amber-300 to-transparent shadow-[0_0_20px_#79ffac]" />
                        <div className="wiki-grid absolute inset-0 -z-10 opacity-20" />
                        <div className="grid md:grid-cols-[17rem_minmax(0,1fr)]">
                            <div className="wiki-scanline relative flex min-h-72 items-center justify-center overflow-hidden border-b border-white/8 bg-[radial-gradient(circle_at_center,rgba(121,255,172,.19),transparent_55%),#0b1018] p-8 md:border-r md:border-b-0">
                                <div className="absolute size-48 rotate-45 border border-emerald-300/15" />
                                <div className="absolute size-36 rounded-full border border-dashed border-amber-200/25" />
                                <GameArtwork
                                    src={artwork}
                                    alt={item.name}
                                    className="wiki-float relative z-10 size-40 drop-shadow-[0_24px_18px_rgba(0,0,0,.45)]"
                                    fallback={
                                        <PackageOpen className="size-16 text-emerald-200" />
                                    }
                                />
                            </div>

                            <div className="flex flex-col justify-center px-6 py-8 sm:px-9 sm:py-10">
                                <div className="flex flex-wrap gap-2">
                                    <span className="border border-emerald-300/25 bg-emerald-300/8 px-3 py-1.5 text-xs font-black text-emerald-200">
                                        {itemCategoryLabel(item.category)}
                                    </span>
                                    <span className="border border-amber-300/25 bg-amber-300/8 px-3 py-1.5 text-xs font-black text-amber-200">
                                        {itemEffectLabel(item)}
                                    </span>
                                </div>
                                <h1 className="mt-5 text-4xl leading-none font-black tracking-[-0.045em] text-white sm:text-6xl">
                                    {item.name}
                                </h1>
                                <p className="mt-5 max-w-3xl border-l-2 border-emerald-300/55 pl-4 text-base leading-7 text-slate-300">
                                    {item.description ??
                                        upgradeDescription ??
                                        'Vật phẩm đặc thù được phục dựng từ dữ liệu game.'}
                                </p>
                            </div>
                        </div>
                    </section>

                    <section className="wiki-panel p-5 sm:p-7">
                        <SectionHeading
                            icon={<GitBranch />}
                            eyebrow="Liên kết tiến hóa"
                            title="Pet sử dụng vật phẩm này"
                            description="Mỗi tuyến cho biết Pet trước và sau tiến hóa cùng số lượng nguyên liệu cần dùng."
                        />

                        {item.evolution_usages.length === 0 ? (
                            <div className="mt-6 border border-dashed border-white/12 bg-white/3 px-5 py-12 text-center text-slate-400">
                                <Backpack className="mx-auto size-9 text-emerald-200" />
                                <p className="mt-3 font-bold">
                                    Vật phẩm này không nằm trong công thức tiến
                                    hóa Pet.
                                </p>
                            </div>
                        ) : (
                            <div className="mt-6 grid gap-3">
                                {item.evolution_usages.map((usage) => (
                                    <article
                                        key={usage.id}
                                        className="grid items-center gap-3 border border-white/8 bg-black/15 p-3 sm:grid-cols-[minmax(0,1fr)_9rem_minmax(0,1fr)]"
                                    >
                                        <EvolutionPetLink
                                            pet={usage.from_pet}
                                        />
                                        <div className="flex flex-col items-center justify-center text-center">
                                            <span className="flex w-full items-center gap-2 text-emerald-200">
                                                <span className="h-px flex-1 bg-emerald-300/25" />
                                                <ArrowRight className="size-5" />
                                                <span className="h-px flex-1 bg-emerald-300/25" />
                                            </span>
                                            <strong className="mt-2 text-sm text-amber-200">
                                                {item.name} ×{usage.quantity}
                                            </strong>
                                            <span className="mt-1 text-xs text-slate-500">
                                                {usage.type === 'mutation'
                                                    ? 'Dị hóa'
                                                    : 'Tiến hóa'}
                                                {' · '}
                                                {evolutionIngredientRoleLabel(
                                                    usage.role,
                                                )}
                                                {' · H'}
                                                {usage.cost_rank}
                                            </span>
                                        </div>
                                        <EvolutionPetLink
                                            pet={usage.to_pet}
                                        />
                                    </article>
                                ))}
                            </div>
                        )}
                    </section>
                </main>

                <aside className="flex min-w-0 flex-col gap-5">
                    <section className="wiki-panel p-5 sm:p-6">
                        <SectionHeading
                            icon={<ScrollText />}
                            eyebrow="Thông tin nhanh"
                            title="Tính năng và mục dùng"
                        />
                        <dl className="mt-6 grid gap-3 text-sm">
                            <FactRow
                                label="Phân loại"
                                value={itemCategoryLabel(item.category)}
                            />
                            <FactRow
                                label="Nhóm vật phẩm"
                                value={itemSourceLabel(item.source_table)}
                            />
                            <FactRow
                                label="Công dụng"
                                value={itemEffectLabel(item)}
                            />
                            <FactRow
                                label="Giá niêm yết"
                                value={
                                    item.cost === null
                                        ? 'Không giao dịch'
                                        : item.cost.toLocaleString('vi-VN')
                                }
                            />
                            <FactRow
                                label="Tuyến tiến hóa"
                                value={String(item.evolution_usages.length)}
                            />
                        </dl>
                    </section>

                    {condition !== null && (
                        <section className="wiki-panel p-5 sm:p-6">
                            <div className="flex items-center gap-3 text-amber-200">
                                <Sparkles className="size-5" />
                                <h2 className="font-black">Điều kiện sở hữu</h2>
                            </div>
                            <p className="mt-4 text-sm leading-6 text-slate-300">
                                {condition}
                            </p>
                        </section>
                    )}

                    <details className="group wiki-panel p-5 sm:p-6">
                        <summary className="flex cursor-pointer list-none items-center justify-between gap-3 font-bold text-slate-200 marker:hidden">
                            <span className="flex items-center gap-2">
                                <Database className="size-4 text-emerald-200" />
                                Thông số bản thô dành cho modder
                            </span>
                            <span className="text-emerald-200 transition group-open:rotate-45">
                                +
                            </span>
                        </summary>
                        <div className="mt-5 grid gap-4 border-t border-white/8 pt-5 text-xs text-slate-400">
                            <FactRow
                                label="Mã nguồn"
                                value={`${item.source_table}:${item.game_id}`}
                            />
                            <FactRow
                                label="Frame sprite"
                                value={String(item.frame_id ?? '—')}
                            />
                            <FactRow
                                label="Effect code"
                                value={String(item.effect_type ?? '—')}
                            />
                            <pre className="overflow-x-auto bg-black/20 p-3 font-mono text-[10px] leading-5 text-slate-500">
                                {JSON.stringify(
                                    {
                                        parameters: item.effect_parameters,
                                        raw_values: item.raw_values,
                                    },
                                    null,
                                    2,
                                )}
                            </pre>
                        </div>
                    </details>
                </aside>
            </div>
        </div>
    );
}

function EvolutionPetLink({
    pet,
}: {
    pet: WikiItemDetail['evolution_usages'][number]['from_pet'];
}) {
    return (
        <Link
            href={petShow(pet.id)}
            prefetch
            className="group flex min-w-0 items-center gap-3 border border-white/8 bg-white/3 p-3 transition hover:border-emerald-300/35 hover:bg-emerald-300/7"
        >
            <GameArtwork
                src={petArtworkUrl(
                    pet.sprite_id,
                    pet.game_source.asset_key,
                )}
                alt={pet.name}
                className="size-14 shrink-0 transition group-hover:scale-110"
                fallback={<PawPrint className="size-7 text-emerald-200" />}
            />
            <span className="min-w-0">
                <span className="block text-xs font-bold text-slate-500">
                    Pet #{pet.game_id}
                </span>
                <strong className="mt-1 block truncate text-sm text-white">
                    {pet.name}
                </strong>
            </span>
        </Link>
    );
}

function evolutionIngredientRoleLabel(
    role: WikiItemDetail['evolution_usages'][number]['role'],
): string {
    return {
        core: 'Lõi tiến hóa',
        species: 'Nguyên liệu Chủng',
        signature: 'Xúc tác đặc trưng',
    }[role];
}

function SectionHeading({
    icon,
    eyebrow,
    title,
    description,
}: {
    icon: ReactNode;
    eyebrow: string;
    title: string;
    description?: string;
}) {
    return (
        <div className="flex items-start gap-3">
            <span className="flex size-10 shrink-0 items-center justify-center border border-emerald-300/30 bg-emerald-300/9 text-emerald-200 [&_svg]:size-4">
                {icon}
            </span>
            <div>
                <p className="text-xs font-black tracking-[0.14em] text-emerald-200 uppercase">
                    {eyebrow}
                </p>
                <h2 className="mt-1 text-xl font-black text-white sm:text-2xl">
                    {title}
                </h2>
                {description !== undefined && (
                    <p className="mt-2 text-sm leading-6 text-slate-400">
                        {description}
                    </p>
                )}
            </div>
        </div>
    );
}

function FactRow({ label, value }: { label: string; value: string }) {
    return (
        <div className="flex items-start justify-between gap-4 border-b border-white/7 pb-3 last:border-0 last:pb-0">
            <dt className="text-slate-500">{label}</dt>
            <dd className="text-right font-bold text-slate-200">{value}</dd>
        </div>
    );
}

function readTextParameter(
    parameters: Record<string, unknown> | null,
    key: string,
): string | null {
    const value = parameters?.[key];

    return typeof value === 'string' && value.trim() !== '' ? value : null;
}
