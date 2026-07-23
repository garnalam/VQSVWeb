import { Head, Link, router } from '@inertiajs/react';
import {
    ArrowRight,
    ChevronLeft,
    ChevronRight,
    GitBranch,
    Leaf,
    PawPrint,
    Search,
    Sparkles,
} from 'lucide-react';
import type { CSSProperties, FormEvent } from 'react';
import { useState } from 'react';
import { GameArtwork } from '@/components/wiki/game-artwork';
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

const fieldClass =
    'h-12 w-full rounded-2xl border border-white/10 bg-[#0b1b2a] px-4 text-[15px] font-semibold text-slate-100 outline-none transition focus:border-emerald-400/55 focus:ring-4 focus:ring-emerald-400/10';

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
    const [learningGroup, setLearningGroup] = useState(
        filters.learning_group === null
            ? 'all'
            : String(filters.learning_group),
    );
    const [evolution, setEvolution] = useState(filters.evolution ?? 'all');
    const [sort, setSort] = useState(filters.sort);
    const appliedQuery = compactWikiQuery(filters);
    const families = groupPetFamilies(pets.data);

    function submit(event: FormEvent<HTMLFormElement>) {
        event.preventDefault();

        router.visit(
            petsIndex({
                query: compactWikiQuery({
                    q: query,
                    element: element === 'all' ? null : element,
                    species: speciesFilter === 'all' ? null : speciesFilter,
                    learning_group:
                        learningGroup === 'all' ? null : Number(learningGroup),
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

            <section className="relative isolate overflow-hidden rounded-[2rem] border border-cyan-200/12 bg-[linear-gradient(120deg,#091725_0%,#10243a_48%,#15302b_100%)] px-6 py-9 shadow-[0_24px_70px_rgba(0,0,0,.3)] sm:px-10 sm:py-12">
                <div className="absolute -top-24 -right-10 -z-10 size-72 rounded-full bg-[#ffd777]/45 blur-3xl" />
                <div className="absolute -bottom-28 left-1/3 -z-10 size-72 rounded-full bg-[#7ddfc3]/30 blur-3xl" />
                <div className="max-w-3xl">
                    <span className="inline-flex items-center gap-2 rounded-full border border-emerald-300/25 bg-emerald-300/8 px-4 py-2 text-sm font-bold text-emerald-200 shadow-sm">
                        <Leaf className="size-4" />
                        Cẩm nang sinh vật VQSV
                    </span>
                    <h1 className="mt-5 text-4xl leading-tight font-black tracking-[-0.04em] text-white sm:text-6xl">
                        Gặp gỡ từng Pet,
                        <span className="block text-emerald-300">
                            hiểu rõ từng sức mạnh.
                        </span>
                    </h1>
                    <p className="mt-5 max-w-2xl text-base leading-7 text-slate-300 sm:text-lg">
                        Các dạng tiến hóa được xếp thành gia phả liền nhau. Chọn
                        một Pet để xem chỉ số theo cấp, kỹ năng có thể học và
                        nguyên liệu tiến hóa.
                    </p>
                </div>
                <div className="mt-8 flex flex-wrap gap-3">
                    <span className="rounded-2xl bg-emerald-400 px-5 py-3 text-base font-bold text-[#06131c] shadow-lg shadow-emerald-400/15">
                        {pets.total} Pet được ghi nhận
                    </span>
                    <span className="rounded-2xl border border-white/12 bg-white/6 px-5 py-3 text-base font-semibold text-slate-200">
                        {elements.length} hệ chiến đấu · {species.length} chủng
                    </span>
                </div>
            </section>

            <form
                onSubmit={submit}
                className="rounded-[1.75rem] border border-white/10 bg-[#081522]/92 p-4 shadow-[0_16px_45px_rgba(0,0,0,.24)] sm:p-6"
            >
                <div className="grid gap-3 md:grid-cols-2 xl:grid-cols-[1.4fr_repeat(5,minmax(0,1fr))_auto]">
                    <label className="relative block">
                        <span className="sr-only">Tìm Pet</span>
                        <Search className="absolute top-1/2 left-4 size-5 -translate-y-1/2 text-slate-500" />
                        <input
                            value={query}
                            onChange={(event) => setQuery(event.target.value)}
                            placeholder="Tìm theo tên hoặc ID..."
                            className={`${fieldClass} pl-12`}
                        />
                    </label>
                    <select
                        value={speciesFilter}
                        onChange={(event) =>
                            setSpeciesFilter(event.target.value)
                        }
                        className={fieldClass}
                        aria-label="Lọc theo chủng"
                    >
                        <option value="all">Tất cả chủng</option>
                        {species.map((option) => (
                            <option key={option.slug} value={option.slug}>
                                Chủng {option.name}
                            </option>
                        ))}
                    </select>
                    <select
                        value={element}
                        onChange={(event) => setElement(event.target.value)}
                        className={fieldClass}
                        aria-label="Lọc theo hệ"
                    >
                        <option value="all">Tất cả hệ</option>
                        {elements.map((option) => (
                            <option key={option.slug} value={option.slug}>
                                Hệ {option.name}
                            </option>
                        ))}
                    </select>
                    <select
                        value={learningGroup}
                        onChange={(event) =>
                            setLearningGroup(event.target.value)
                        }
                        className={fieldClass}
                        aria-label="Lọc theo nhóm học"
                    >
                        <option value="all">Mọi nhóm học</option>
                        {[0, 1, 2, 3, 4].map((group) => (
                            <option key={group} value={String(group)}>
                                Nhóm học {group}
                            </option>
                        ))}
                    </select>
                    <select
                        value={evolution}
                        onChange={(event) => setEvolution(event.target.value)}
                        className={fieldClass}
                        aria-label="Lọc theo tiến hóa"
                    >
                        <option value="all">Mọi gia phả</option>
                        <option value="has">Thuộc chuỗi tiến hóa</option>
                        <option value="none">Pet độc lập</option>
                    </select>
                    <select
                        value={sort}
                        onChange={(event) => setSort(event.target.value)}
                        className={fieldClass}
                        aria-label="Sắp xếp Pet"
                    >
                        <option value="family">Theo gia phả</option>
                        <option value="name">Theo tên gia phả</option>
                        <option value="learning_group">Theo nhóm học</option>
                    </select>
                    <button
                        type="submit"
                        className="h-12 rounded-2xl bg-emerald-400 px-6 text-[15px] font-extrabold text-[#06131c] shadow-lg shadow-emerald-400/20 transition hover:-translate-y-0.5 hover:bg-emerald-300"
                    >
                        Áp dụng
                    </button>
                </div>
            </form>

            <div className="flex flex-wrap items-end justify-between gap-3 px-1">
                <div>
                    <p className="text-sm font-bold text-emerald-300">
                        Kết quả tra cứu
                    </p>
                    <h2 className="mt-1 text-2xl font-black tracking-tight text-white">
                        {pets.total === 0
                            ? 'Chưa tìm thấy Pet phù hợp'
                            : `${pets.total} Pet trong cẩm nang`}
                    </h2>
                </div>
                {pets.from !== null && (
                    <p className="text-sm font-semibold text-slate-400">
                        Đang xem {pets.from}–{pets.to}
                    </p>
                )}
            </div>

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
                <section className="grid gap-5 sm:grid-cols-2 xl:grid-cols-3">
                    {families.map((family) =>
                        family.pets.length > 1 ? (
                            <PetFamilyRow
                                key={`family-${family.rootId}`}
                                family={family}
                            />
                        ) : (
                            <PetCard
                                key={`pet-${family.pets[0].id}`}
                                pet={family.pets[0]}
                            />
                        ),
                    )}
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
    return (
        <section className="rounded-[2rem] border border-white/10 bg-[linear-gradient(135deg,rgba(8,21,34,.97),rgba(12,35,39,.94))] p-4 shadow-[0_18px_50px_rgba(0,0,0,.24)] sm:col-span-2 sm:p-5 xl:col-span-3">
            <div className="mb-4 flex flex-wrap items-center justify-between gap-3 px-1">
                <div className="flex items-center gap-3">
                    <span className="flex size-10 items-center justify-center rounded-2xl bg-emerald-300/12 text-emerald-300">
                        <GitBranch className="size-5" />
                    </span>
                    <div>
                        <h3 className="text-lg font-black text-white">
                            Gia phả {family.pets[0].family_root_name}
                        </h3>
                        <p className="text-sm text-slate-400">
                            {family.pets.length} dạng được xếp theo thứ tự tiến
                            hóa
                        </p>
                    </div>
                </div>
                <span className="rounded-full bg-amber-300/12 px-4 py-2 text-sm font-bold text-amber-200">
                    Xem từ trái sang phải
                </span>
            </div>
            <div className="grid gap-4 sm:grid-cols-2 xl:grid-cols-3">
                {family.pets.map((pet, index) => (
                    <div key={pet.id} className="relative">
                        <PetCard pet={pet} compact />
                        {index < family.pets.length - 1 && (
                            <span className="absolute top-1/2 -right-4 z-20 hidden size-8 -translate-y-1/2 items-center justify-center rounded-full border-4 border-[#0b1b29] bg-emerald-400 text-[#06131c] shadow-md xl:flex">
                                <ArrowRight className="size-4" />
                            </span>
                        )}
                    </div>
                ))}
            </div>
        </section>
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
        : 'Pet độc lập';

    return (
        <Link
            href={petShow(pet.id)}
            prefetch
            style={style}
            className={`group relative flex overflow-hidden rounded-[1.75rem] border border-white/10 bg-[#091725] shadow-[0_14px_36px_rgba(0,0,0,.24)] transition duration-300 hover:-translate-y-1 hover:border-[var(--pet-accent)]/55 hover:shadow-[0_22px_50px_rgba(0,0,0,.34)] ${compact ? 'min-h-58' : 'min-h-62'}`}
        >
            <div className="relative flex w-[42%] shrink-0 items-center justify-center overflow-hidden bg-[linear-gradient(155deg,color-mix(in_oklab,var(--pet-accent)_18%,#07111e),color-mix(in_oklab,var(--pet-accent)_32%,#0a1724))] p-4">
                <div className="absolute size-30 rounded-full border border-[var(--pet-accent)]/25 bg-white/4" />
                <div className="absolute size-22 rounded-full border border-[var(--pet-accent)]/18" />
                <GameArtwork
                    src={petArtworkUrl(
                        pet.sprite_id,
                        pet.game_source.asset_key,
                    )}
                    alt={pet.name}
                    className="relative z-10 h-30 w-full transition duration-300 group-hover:scale-110 sm:h-34"
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
                <div className="mt-auto flex items-center justify-between gap-3 pt-5">
                    <span
                        className="flex items-center gap-1 text-[#e0a72f]"
                        aria-label={`${pet.quality_tier} sao`}
                    >
                        {Array.from({ length: 5 }, (_, index) => (
                            <Sparkles
                                key={index}
                                className={`size-3.5 ${index < pet.quality_tier ? 'fill-current' : 'opacity-20'}`}
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
