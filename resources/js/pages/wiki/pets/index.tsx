import { Head, Link, router } from '@inertiajs/react';
import {
    ArrowRight,
    ChevronLeft,
    ChevronDown,
    ChevronRight,
    Gauge,
    GitBranch,
    HeartPulse,
    PawPrint,
    Shield,
    Sparkles,
    Swords,
} from 'lucide-react';
import type { CSSProperties, FormEvent } from 'react';
import { useState } from 'react';
import {
    Select,
    SelectContent,
    SelectItem,
    SelectTrigger,
    SelectValue,
} from '@/components/ui/select';
import { GameArtwork } from '@/components/wiki/game-artwork';
import { PetArtworkMotion } from '@/components/wiki/pet-artwork-motion';
import { TraitBadge } from '@/components/wiki/trait-badge';
import { WikiFilterPanel } from '@/components/wiki/wiki-filter-panel';
import { WikiPageHeader } from '@/components/wiki/wiki-page-header';
import { WikiResultsBar } from '@/components/wiki/wiki-results-bar';
import { elementIconUrl, petArtworkUrl } from '@/lib/game-assets';
import { compactWikiQuery } from '@/lib/wiki';
import { index as petsIndex, show as petShow } from '@/routes/wiki/pets';
import type {
    PaginatedWikiData,
    WikiCombatElement,
    WikiPet,
    WikiSpecies,
} from '@/types';

type PetFilters = {
    q: string;
    element: string | null;
    species: string | null;
    learning_group: number | null;
    evolution: string | null;
    sort: string;
};

type PetIndexProps = {
    pets: PaginatedWikiData<WikiPet>;
    elements: WikiCombatElement[];
    species: WikiSpecies[];
    filters: PetFilters;
};

type PetFamily = {
    rootId: string;
    pets: WikiPet[];
};

const petCardStats = [
    {
        key: 'hp',
        label: 'Sinh mệnh',
        shortLabel: 'HP',
        icon: HeartPulse,
        color: '#fb7185',
    },
    {
        key: 'strength',
        label: 'Sức mạnh',
        shortLabel: 'ATK',
        icon: Swords,
        color: '#fb923c',
    },
    {
        key: 'defense',
        label: 'Phòng ngự',
        shortLabel: 'DEF',
        icon: Shield,
        color: '#60a5fa',
    },
    {
        key: 'agility',
        label: 'Linh xảo',
        shortLabel: 'SPD',
        icon: Gauge,
        color: '#22d3ee',
    },
] as const;

export default function PetIndex({
    pets,
    elements,
    species,
    filters,
}: PetIndexProps) {
    const [query, setQuery] = useState(filters.q);
    const [element, setElement] = useState(
        filters.element === null ? 'all' : String(filters.element),
    );
    const [speciesFilter, setSpeciesFilter] = useState(
        filters.species ?? 'all',
    );
    const [evolution, setEvolution] = useState(filters.evolution ?? 'all');
    const [sort, setSort] = useState(
        filters.sort === 'learning_group' ? 'family' : filters.sort,
    );
    const appliedQuery = compactWikiQuery({
        ...filters,
        learning_group: null,
    });
    const families = groupPetFamilies(pets.data);

    function submit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();

        visitCatalog(element);
    }

    function visitCatalog(nextElement: string) {
        router.visit(
            petsIndex({
                query: compactWikiQuery({
                    q: query,
                    element: nextElement === 'all' ? null : nextElement,
                    species: speciesFilter === 'all' ? null : speciesFilter,
                    evolution: evolution === 'all' ? null : evolution,
                    sort,
                }),
            }),
            { preserveScroll: true, preserveState: true, replace: true },
        );
    }

    return (
        <div className="flex flex-col gap-6 text-slate-100">
            <Head title="Hồ sơ Pet" />

            <WikiPageHeader
                eyebrow="VQSV Bestiary"
                title="Cẩm nang Pet"
                description="Tra cứu Hệ, Chủng, chỉ số, kỹ năng và toàn bộ dòng tiến hóa trong một kho dữ liệu thống nhất."
                total={pets.total}
                unit="Pet phù hợp"
                icon={<PawPrint className="size-4" />}
                theme="pets"
            />

            <section className="wiki-panel overflow-hidden p-3 sm:p-4">
                <div className="mb-3 flex items-center justify-between gap-3">
                    <strong className="text-sm text-white">Hệ chiến đấu</strong>
                    <span className="text-xs text-slate-500">
                        {elements.length} nguyên tố
                    </span>
                </div>
                <div className="flex [scrollbar-width:none] gap-2 overflow-x-auto pb-1 [&::-webkit-scrollbar]:hidden">
                    <ElementTab
                        active={element === 'all'}
                        label="Tất cả"
                        onClick={() => {
                            setElement('all');
                            visitCatalog('all');
                        }}
                    />
                    {elements.map((option) => (
                        <ElementTab
                            key={option.slug}
                            active={element === option.slug}
                            label={option.name}
                            color={option.color}
                            icon={elementIconUrl(option.game_id)}
                            onClick={() => {
                                setElement(option.slug);
                                visitCatalog(option.slug);
                            }}
                        />
                    ))}
                </div>
            </section>

            <WikiFilterPanel
                query={query}
                onQueryChange={setQuery}
                onSubmit={submit}
                resetHref={petsIndex()}
                placeholder="Tên hoặc ID Pet..."
            >
                <Select value={speciesFilter} onValueChange={setSpeciesFilter}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none">
                        <SelectValue placeholder="Chủng Pet" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">Tất cả chủng</SelectItem>
                        {species.map((option) => (
                            <SelectItem key={option.slug} value={option.slug}>
                                {option.name}
                            </SelectItem>
                        ))}
                    </SelectContent>
                </Select>
                <Select value={evolution} onValueChange={setEvolution}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none">
                        <SelectValue placeholder="Dòng tiến hóa" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="all">Mọi dòng tiến hóa</SelectItem>
                        <SelectItem value="has">Có tiến hóa</SelectItem>
                        <SelectItem value="none">Pet độc lập</SelectItem>
                    </SelectContent>
                </Select>
                <Select value={sort} onValueChange={setSort}>
                    <SelectTrigger className="h-11 w-full rounded-none border-cyan-100/12 bg-white/5 text-slate-200 shadow-none">
                        <SelectValue placeholder="Sắp xếp" />
                    </SelectTrigger>
                    <SelectContent>
                        <SelectItem value="family">Theo gia phả</SelectItem>
                        <SelectItem value="name">Theo tên gia phả</SelectItem>
                    </SelectContent>
                </Select>
            </WikiFilterPanel>

            <WikiResultsBar
                label="Danh sách Pet"
                from={pets.from}
                to={pets.to}
                total={pets.total}
            />

            {pets.data.length === 0 ? (
                <div className="rounded-[2rem] border border-dashed border-white/15 bg-[#081522]/80 px-6 py-20 text-center">
                    <PawPrint className="mx-auto size-10 text-emerald-300" />
                    <h2 className="mt-4 text-xl font-black">
                        Không có Pet phù hợp
                    </h2>
                    <p className="mt-2 text-slate-400">
                        Hãy thử đổi hệ, gia phả hoặc từ khóa tìm kiếm.
                    </p>
                </div>
            ) : (
                <section className="grid gap-5">
                    {families.map((family) => (
                        <PetFamilyRow
                            key={`family-${family.rootId}`}
                            family={family}
                        />
                    ))}
                </section>
            )}

            {pets.total > 0 && (
                <nav className="flex flex-col items-center justify-between gap-4 rounded-[1.5rem] border border-white/10 bg-[#081522]/88 px-5 py-4 shadow-sm sm:flex-row">
                    <p className="text-sm font-semibold text-slate-400">
                        Trang {pets.current_page} / {pets.last_page}
                    </p>
                    <div className="flex items-center gap-2">
                        <PageLink
                            href={petsIndex({
                                query: {
                                    ...appliedQuery,
                                    page: Math.max(1, pets.current_page - 1),
                                },
                            })}
                            disabled={pets.current_page <= 1}
                        >
                            <ChevronLeft className="size-4" />
                            Trang trước
                        </PageLink>
                        <PageLink
                            href={petsIndex({
                                query: {
                                    ...appliedQuery,
                                    page: Math.min(
                                        pets.last_page,
                                        pets.current_page + 1,
                                    ),
                                },
                            })}
                            disabled={pets.current_page >= pets.last_page}
                        >
                            Trang sau
                            <ChevronRight className="size-4" />
                        </PageLink>
                    </div>
                </nav>
            )}
        </div>
    );
}

function PetFamilyRow({ family }: { family: PetFamily }) {
    const firstPet = family.pets[0];
    const accent = firstPet.combat_element.color;

    return (
        <details
            style={{ '--pet-accent': accent } as CSSProperties}
            className="group wiki-panel overflow-hidden"
        >
            <summary className="grid cursor-pointer list-none items-center gap-4 p-4 marker:hidden sm:grid-cols-[7rem_minmax(0,1fr)_auto] sm:p-5">
                <div className="relative flex h-24 items-center justify-center overflow-hidden bg-[var(--pet-accent)]/8">
                    <span className="absolute size-20 rounded-full border border-[var(--pet-accent)]/20" />
                    <GameArtwork
                        src={petArtworkUrl(
                            firstPet.sprite_id,
                            firstPet.game_source.asset_key,
                        )}
                        alt={firstPet.name}
                        className="relative z-10 size-22 transition group-open:scale-110"
                        fallback={
                            <PawPrint className="size-9 text-[var(--pet-accent)]" />
                        }
                    />
                </div>
                <div className="min-w-0">
                    <div className="flex flex-wrap items-center gap-2">
                        <span className="flex items-center gap-2 text-sm font-black text-[var(--pet-accent)]">
                            <GitBranch className="size-4" />
                            Dòng tiến hóa
                        </span>
                        <span className="border border-white/10 bg-white/4 px-2.5 py-1 text-xs font-bold text-slate-300">
                            {family.pets.length} dạng
                        </span>
                    </div>
                    <h3 className="mt-2 truncate text-2xl font-black text-white">
                        {firstPet.family_root_name}
                    </h3>
                    <p className="mt-1 text-sm text-slate-400">
                        Pet #{firstPet.game_id} · {firstPet.combat_element.name}{' '}
                        · {firstPet.species.name}
                    </p>
                </div>
                <span className="flex items-center justify-between gap-3 text-sm font-black text-[var(--pet-accent)] sm:justify-end">
                    Mở chuỗi
                    <ChevronDown className="size-5 transition group-open:rotate-180" />
                </span>
            </summary>

            <div className="border-t border-white/8 bg-black/12 p-4 sm:p-5">
                <div className="grid gap-4 sm:grid-cols-2 xl:grid-cols-3">
                    {family.pets.map((pet, index) => (
                        <div key={pet.id} className="relative">
                            <PetCard pet={pet} compact />
                            {index < family.pets.length - 1 && (
                                <span className="absolute top-1/2 -right-4 z-20 hidden size-8 -translate-y-1/2 items-center justify-center border-4 border-[#0b0f17] bg-[var(--pet-accent)] text-[#06131c] shadow-md xl:flex">
                                    <ArrowRight className="size-4" />
                                </span>
                            )}
                        </div>
                    ))}
                </div>
            </div>
        </details>
    );
}

function PetCard({
    pet,
    compact = false,
}: {
    pet: WikiPet;
    compact?: boolean;
}) {
    const accent = pet.combat_element.color;
    const style = { '--pet-accent': accent } as CSSProperties;
    const stageLabel = pet.belongs_to_evolution_family
        ? pet.is_final_stage
            ? 'Dạng cuối'
            : `Dạng ${pet.evolution_stage}/${pet.evolution_family_size}`
        : 'Dạng duy nhất';

    return (
        <Link
            href={petShow(pet.id)}
            prefetch
            style={style}
            className={`wiki-dossier wiki-card-fx group relative flex overflow-hidden border border-white/10 bg-[#161c28]/90 shadow-[0_14px_36px_rgba(0,0,0,.24)] transition duration-300 hover:-translate-y-1 hover:border-[var(--pet-accent)]/55 hover:shadow-[0_22px_50px_rgba(0,0,0,.34)] ${compact ? 'min-h-78' : 'min-h-82'}`}
        >
            <div className="relative flex w-[42%] shrink-0 items-center justify-center overflow-hidden bg-[linear-gradient(155deg,color-mix(in_oklab,var(--pet-accent)_18%,#07111e),color-mix(in_oklab,var(--pet-accent)_32%,#0a1724))] p-4">
                <div className="absolute size-30 rounded-full border border-[var(--pet-accent)]/25 bg-white/4" />
                <div className="absolute size-22 rounded-full border border-[var(--pet-accent)]/18" />
                <PetArtworkMotion
                    spriteId={pet.sprite_id}
                    assetKey={pet.game_source.asset_key}
                    staticSrc={petArtworkUrl(
                        pet.sprite_id,
                        pet.game_source.asset_key,
                    )}
                    alt={pet.name}
                    className="relative z-10 flex h-full w-full items-center justify-center"
                    imageClassName="h-30 w-full sm:h-34"
                    fallback={
                        <PawPrint className="size-10 text-[var(--pet-accent)]" />
                    }
                />
            </div>
            <div className="flex min-w-0 flex-1 flex-col p-5">
                <div className="flex flex-wrap items-center gap-2">
                    <img
                        src={elementIconUrl(pet.combat_element.game_id)}
                        alt=""
                        className="wiki-pixel-art size-6 object-contain"
                    />
                    <span className="text-sm font-bold text-[var(--pet-accent)]">
                        Hệ {pet.combat_element.name}
                    </span>
                    <span
                        className="rounded-full border px-2.5 py-1 text-xs font-extrabold"
                        style={{
                            borderColor: `${pet.species.color}55`,
                            color: pet.species.color,
                            backgroundColor: `${pet.species.color}14`,
                        }}
                    >
                        Chủng {pet.species.name}
                    </span>
                </div>
                <h2 className="mt-3 text-xl leading-tight font-black tracking-[-0.025em] text-white">
                    {pet.name}
                </h2>
                <span className="mt-3 w-fit rounded-full bg-[var(--pet-accent)]/10 px-3 py-1.5 text-sm font-bold text-[var(--pet-accent)]">
                    {stageLabel}
                </span>
                <TraitBadge
                    trait={pet.species_trait}
                    color={pet.species.color}
                    className="mt-2"
                />
                <div className="mt-3 border-y border-white/8 bg-black/14 py-2">
                    <div className="flex items-center justify-between gap-2 px-2 pb-1.5 font-mono text-[8px] font-black tracking-[.12em] uppercase">
                        <span className="text-slate-500">Chỉ số chiến đấu</span>
                        <span className="text-[var(--pet-accent)]">
                            LV.{pet.preview_level}
                        </span>
                    </div>
                    <div className="grid gap-px">
                        {petCardStats.map((stat) => {
                            const StatIcon = stat.icon;

                            return (
                                <div
                                    key={stat.key}
                                    className="grid grid-cols-[auto_minmax(0,1fr)_auto] items-center gap-2 border-t border-white/5 px-2 py-1.5"
                                >
                                    <StatIcon
                                        className="size-3.5"
                                        style={{ color: stat.color }}
                                    />
                                    <span className="truncate text-[10px] font-bold text-slate-400">
                                        {stat.label}
                                        <span className="ml-1 font-mono text-[8px] text-slate-600">
                                            {stat.shortLabel}
                                        </span>
                                    </span>
                                    <strong
                                        className="font-mono text-xs tabular-nums"
                                        style={{ color: stat.color }}
                                    >
                                        {pet.preview_stats[
                                            stat.key
                                        ].toLocaleString('vi-VN')}
                                    </strong>
                                </div>
                            );
                        })}
                    </div>
                </div>
                <div className="mt-auto flex items-center justify-between gap-3 pt-3">
                    <span
                        className="flex items-center gap-1 text-[#e0a72f]"
                        aria-label={`${pet.preview_star} sao mô phỏng`}
                    >
                        {Array.from({ length: 5 }, (_, index) => (
                            <Sparkles
                                key={index}
                                className={`size-3.5 ${index < pet.preview_star ? 'fill-current' : 'opacity-20'}`}
                            />
                        ))}
                    </span>
                    <span className="flex items-center gap-1 text-sm font-extrabold text-emerald-300">
                        Hồ sơ
                        <ArrowRight className="size-4 transition group-hover:translate-x-1" />
                    </span>
                </div>
            </div>
        </Link>
    );
}

function ElementTab({
    active,
    label,
    color = '#f8fafc',
    icon,
    onClick,
}: {
    active: boolean;
    label: string;
    color?: string;
    icon?: string;
    onClick: () => void;
}) {
    const style = { '--element-tab': color } as CSSProperties;

    return (
        <button
            type="button"
            style={style}
            onClick={onClick}
            aria-pressed={active}
            className={`flex h-11 shrink-0 items-center gap-2 border px-3.5 text-sm font-black transition ${
                active
                    ? 'border-[var(--element-tab)] bg-[var(--element-tab)]/14 text-white shadow-[0_0_18px_color-mix(in_oklab,var(--element-tab)_20%,transparent)]'
                    : 'border-white/8 bg-white/3 text-slate-400 hover:border-[var(--element-tab)]/40 hover:text-white'
            }`}
        >
            {icon !== undefined ? (
                <img
                    src={icon}
                    alt=""
                    className="wiki-pixel-art size-6 object-contain"
                />
            ) : (
                <span className="size-2 rounded-full bg-current" />
            )}
            {label}
        </button>
    );
}

function PageLink({
    href,
    disabled,
    children,
}: {
    href: ReturnType<typeof petsIndex>;
    disabled: boolean;
    children: React.ReactNode;
}) {
    return (
        <Link
            href={href}
            preserveScroll
            aria-disabled={disabled}
            className={`flex h-11 items-center gap-2 rounded-xl border px-4 text-sm font-extrabold transition ${
                disabled
                    ? 'pointer-events-none border-white/7 text-slate-600'
                    : 'border-white/12 bg-white/5 text-emerald-200 hover:border-emerald-300/45 hover:bg-emerald-300/10'
            }`}
        >
            {children}
        </Link>
    );
}

function groupPetFamilies(pets: WikiPet[]): PetFamily[] {
    return pets.reduce<PetFamily[]>((families, pet) => {
        const currentFamily = families.at(-1);
        const rootId = `${pet.game_source.slug}:${pet.family_root_game_id}`;

        if (currentFamily?.rootId === rootId) {
            currentFamily.pets.push(pet);
        } else {
            families.push({
                rootId,
                pets: [pet],
            });
        }

        return families;
    }, []);
}
