import { Head, Link } from '@inertiajs/react';
import {
    ArrowLeft,
    ArrowRight,
    BookOpen,
    ChevronRight,
    Compass,
    Dumbbell,
    Gauge,
    GitBranch,
    Heart,
    Leaf,
    LockKeyholeOpen,
    MapPin,
    PawPrint,
    Shield,
    Sparkles,
    Star,
    Swords,
    WandSparkles,
} from 'lucide-react';
import type { CSSProperties, ReactNode } from 'react';
import { useMemo, useState } from 'react';
import { GameArtwork } from '@/components/wiki/game-artwork';
import {
    effectIconUrl,
    elementIconUrl,
    itemArtworkUrl,
    petArtworkUrl,
    skillArtworkUrl,
} from '@/lib/game-assets';
import { index as petsIndex, show as petShow } from '@/routes/wiki/pets';
import { show as skillShow } from '@/routes/wiki/skills';
import type {
    WikiEvolutionPet,
    WikiEvolutionTransition,
    WikiPetDetail,
    WikiPetSkill,
    WikiPetStatFormula,
} from '@/types';

type PetShowProps = {
    pet: WikiPetDetail;
};

const qualityLabels: Record<number, string> = {
    1: 'Phổ thông',
    2: 'Khá',
    3: 'Tinh anh',
    4: 'Quý hiếm',
    5: 'Huyền thoại',
};

export default function PetShow({ pet }: PetShowProps) {
    const [level, setLevel] = useState(50);
    const accent = pet.combat_element.color;
    const style = { '--pet-accent': accent } as CSSProperties;
    const skillsByLevel = useMemo(
        () =>
            Object.entries(
                pet.skills.reduce<Record<number, WikiPetSkill[]>>(
                    (groups, skill) => {
                        (groups[skill.unlock_level] ??= []).push(skill);

                        return groups;
                    },
                    {},
                ),
            ).sort(([left], [right]) => Number(left) - Number(right)),
        [pet.skills],
    );

    return (
        <div style={style} className="flex flex-col gap-6 text-slate-100">
            <Head title={`${pet.name} · Hồ sơ Pet`} />

            <Link
                href={petsIndex()}
                className="flex w-fit items-center gap-2 rounded-full border border-white/12 bg-white/5 px-4 py-2.5 text-sm font-extrabold text-slate-300 shadow-sm transition hover:-translate-x-1 hover:border-[var(--pet-accent)]/55 hover:text-white"
            >
                <ArrowLeft className="size-4" />
                Trở lại cẩm nang Pet
            </Link>

            <section className="relative isolate overflow-hidden rounded-[2.25rem] border border-white/10 bg-[linear-gradient(125deg,#081522_0%,color-mix(in_oklab,var(--pet-accent)_12%,#091725)_54%,color-mix(in_oklab,var(--pet-accent)_22%,#07111e)_100%)] shadow-[0_28px_80px_rgba(0,0,0,.3)]">
                <div className="absolute -top-24 -right-12 -z-10 size-80 rounded-full bg-[var(--pet-accent)]/16 blur-3xl" />
                <div className="grid lg:grid-cols-[25rem_minmax(0,1fr)]">
                    <div className="relative flex min-h-90 items-center justify-center overflow-hidden p-7 sm:min-h-105">
                        <div className="absolute size-72 rounded-full border border-[var(--pet-accent)]/22 bg-white/3" />
                        <div className="absolute size-56 rounded-full border border-dashed border-[var(--pet-accent)]/25" />
                        <div className="absolute bottom-13 h-8 w-52 rounded-[50%] bg-[#45614d]/15 blur-lg" />
                        <GameArtwork
                            src={petArtworkUrl(
                                pet.sprite_id,
                                pet.game_source.asset_key,
                            )}
                            alt={pet.name}
                            className="relative z-10 h-68 w-full drop-shadow-[0_24px_18px_rgba(54,74,59,.22)] sm:h-80"
                            fallback={
                                <PawPrint className="size-20 text-[var(--pet-accent)]" />
                            }
                        />
                    </div>

                    <div className="flex flex-col justify-center border-t border-white/10 px-6 py-9 sm:px-10 lg:border-t-0 lg:border-l">
                        <div className="flex flex-wrap items-center gap-3">
                            <span className="inline-flex items-center gap-2 rounded-full border border-[var(--pet-accent)]/30 bg-[var(--pet-accent)]/10 px-4 py-2 text-sm font-extrabold text-[var(--pet-accent)] shadow-sm">
                                <img
                                    src={elementIconUrl(
                                        pet.combat_element.game_id,
                                    )}
                                    alt=""
                                    className="wiki-pixel-art size-6 object-contain"
                                />
                                Hệ {pet.combat_element.name}
                            </span>
                            <span
                                className="inline-flex items-center gap-2 rounded-full border px-4 py-2 text-sm font-extrabold shadow-sm"
                                style={{
                                    borderColor: `${pet.species.color}55`,
                                    color: pet.species.color,
                                    backgroundColor: `${pet.species.color}14`,
                                }}
                            >
                                <PawPrint className="size-5" />
                                Chủng {pet.species.name}
                            </span>
                            <span className="rounded-full border border-white/12 bg-white/5 px-4 py-2 text-sm font-bold text-slate-300">
                                Pet #{pet.game_id}
                            </span>
                        </div>
                        <h1 className="mt-6 max-w-3xl text-4xl leading-[1.05] font-black tracking-[-0.045em] text-white sm:text-6xl">
                            {pet.name}
                        </h1>
                        <p className="mt-4 text-lg font-bold text-[var(--pet-accent)]">
                            {evolutionStatus(pet)}
                        </p>
                        <div className="mt-7 grid gap-3 sm:grid-cols-3">
                            <ProfileFact
                                icon={<Star />}
                                label={
                                    pet.game_source.slug === 'cau-vong'
                                        ? 'Dạng dữ liệu gốc'
                                        : 'Phẩm chất'
                                }
                                value={
                                    pet.game_source.slug === 'cau-vong'
                                        ? `Dạng ${pet.quality_tier}`
                                        : (qualityLabels[pet.quality_tier] ??
                                          `Bậc ${pet.quality_tier}`)
                                }
                            />
                            <ProfileFact
                                icon={<BookOpen />}
                                label="Nhịp học kỹ năng"
                                value={`Nhóm ${pet.learning_group}`}
                            />
                            <ProfileFact
                                icon={<WandSparkles />}
                                label="Kỹ năng có thể học"
                                value={`${pet.skills.length} kỹ năng`}
                            />
                        </div>
                    </div>
                </div>
            </section>

            <section className="grid gap-6 lg:grid-cols-[minmax(0,1.25fr)_minmax(20rem,.75fr)]">
                <article className="relative overflow-hidden rounded-[2rem] border border-white/10 bg-[linear-gradient(145deg,#081522,#0b1d2d)] p-5 shadow-[0_18px_50px_rgba(0,0,0,.22)] sm:p-7">
                    <div className="absolute -right-16 -bottom-20 size-56 rounded-full bg-[var(--pet-accent)]/10 blur-3xl" />
                    <SectionTitle
                        icon={<BookOpen />}
                        eyebrow="Hồ sơ sinh vật"
                        title="Ghi chép trong game"
                        description="Mô tả được phục dựng trực tiếp từ dữ liệu Pet gốc."
                    />
                    <p className="relative mt-6 text-base leading-7 font-medium text-slate-200 sm:text-lg">
                        {pet.lore ||
                            'Game gốc không cung cấp mô tả cho Pet này.'}
                    </p>
                    {pet.combat_note && (
                        <div className="relative mt-5 flex items-start gap-3 rounded-2xl border border-[var(--pet-accent)]/25 bg-[var(--pet-accent)]/8 p-4">
                            <span className="flex size-10 shrink-0 items-center justify-center rounded-xl bg-[var(--pet-accent)]/14 text-[var(--pet-accent)]">
                                <Swords className="size-5" />
                            </span>
                            <div>
                                <p className="text-xs font-black tracking-[0.14em] text-[var(--pet-accent)] uppercase">
                                    Đặc tính chiến đấu
                                </p>
                                <p className="mt-1 font-bold text-white">
                                    {pet.combat_note}
                                </p>
                            </div>
                        </div>
                    )}
                </article>

                <aside className="rounded-[2rem] border border-white/10 bg-[#081522]/94 p-5 shadow-[0_18px_50px_rgba(0,0,0,.22)] sm:p-7">
                    <SectionTitle
                        icon={<Compass />}
                        eyebrow="Nguồn gốc"
                        title="Cách sở hữu"
                        description="Cách Pet xuất hiện trong dữ liệu của game."
                    />
                    <div className="mt-6 rounded-2xl border border-[var(--pet-accent)]/25 bg-[var(--pet-accent)]/9 px-5 py-4">
                        <span className="text-sm font-bold text-slate-400">
                            Phương thức
                        </span>
                        <strong className="mt-1 block text-xl font-black text-[var(--pet-accent)]">
                            {pet.acquisition.method ?? 'Chưa xác định'}
                        </strong>
                    </div>
                    <div className="mt-5">
                        <div className="flex items-center gap-2 text-sm font-black text-white">
                            <MapPin className="size-4 text-[var(--pet-accent)]" />
                            Phát hiện địa điểm
                        </div>
                        {pet.acquisition.locations.length > 0 ? (
                            <ul className="mt-3 space-y-2">
                                {pet.acquisition.locations.map((location) => (
                                    <li
                                        key={location}
                                        className="flex items-start gap-3 rounded-xl bg-white/5 px-4 py-3 text-sm font-semibold text-slate-300"
                                    >
                                        <span className="mt-1 size-1.5 shrink-0 rounded-full bg-[var(--pet-accent)]" />
                                        {location}
                                    </li>
                                ))}
                            </ul>
                        ) : (
                            <p className="mt-3 rounded-xl border border-dashed border-white/12 px-4 py-3 text-sm text-slate-500">
                                Không biết — dữ liệu game gốc không ghi địa
                                điểm.
                            </p>
                        )}
                    </div>
                </aside>
            </section>

            <section className="grid gap-6">
                <div className="rounded-[2rem] border border-white/10 bg-[#081522]/94 p-5 shadow-[0_18px_50px_rgba(0,0,0,.24)] sm:p-7">
                    <div className="flex flex-col gap-5 sm:flex-row sm:items-end sm:justify-between">
                        <SectionTitle
                            icon={<Gauge />}
                            eyebrow="Sức mạnh theo cấp"
                            title="Bộ chỉ số"
                            description="Kéo thanh cấp độ để xem chỉ số; giá trị gốc và nhịp tăng được ghi ngay trên từng thẻ."
                        />
                        <div className="shrink-0 rounded-2xl bg-white/5 px-5 py-3 text-center">
                            <span className="block text-sm font-bold text-slate-400">
                                Cấp đang xem
                            </span>
                            <strong className="text-3xl font-black text-[var(--pet-accent)] tabular-nums">
                                {level}
                            </strong>
                        </div>
                    </div>

                    <label className="mt-7 block">
                        <span className="sr-only">Chọn cấp Pet</span>
                        <input
                            type="range"
                            min="1"
                            max="50"
                            value={level}
                            onChange={(event) =>
                                setLevel(Number(event.target.value))
                            }
                            className="h-2 w-full cursor-pointer appearance-none rounded-full bg-white/10 accent-[var(--pet-accent)]"
                        />
                        <span className="mt-2 flex justify-between text-sm font-semibold text-slate-500">
                            <span>Cấp 1</span>
                            <span>Cấp 50</span>
                        </span>
                    </label>

                    <div className="mt-6 grid gap-3 sm:grid-cols-2 xl:grid-cols-5">
                        <StatCard
                            icon={<Heart />}
                            label="Sinh mệnh"
                            value={calculateStat(
                                pet.stats.hp,
                                level,
                                pet.quality_multiplier,
                            )}
                            formula={pet.stats.hp}
                            color="#ef6b6b"
                        />
                        {pet.stats.energy && (
                            <StatCard
                                icon={<Gauge />}
                                label="Năng lượng"
                                value={calculateStat(
                                    pet.stats.energy,
                                    level,
                                    pet.quality_multiplier,
                                )}
                                formula={pet.stats.energy}
                                color="#36c9d8"
                            />
                        )}
                        <StatCard
                            icon={<Dumbbell />}
                            label="Sức mạnh"
                            value={calculateStat(
                                pet.stats.strength,
                                level,
                                pet.quality_multiplier,
                            )}
                            formula={pet.stats.strength}
                            color="#e79b42"
                        />
                        <StatCard
                            icon={<Shield />}
                            label="Phòng ngự"
                            value={calculateStat(
                                pet.stats.defense,
                                level,
                                pet.quality_multiplier,
                            )}
                            formula={pet.stats.defense}
                            color="#578cc9"
                        />
                        <StatCard
                            icon={<Sparkles />}
                            label="Linh xảo"
                            value={calculateStat(
                                pet.stats.agility,
                                level,
                                pet.quality_multiplier,
                            )}
                            formula={pet.stats.agility}
                            color="#9a69c7"
                        />
                    </div>
                    <p className="mt-5 rounded-2xl bg-white/4 px-4 py-3 text-sm leading-6 text-slate-400">
                        {pet.game_source.slug === 'cau-vong'
                            ? 'Pet Cầu Vồng tăng chỉ số theo từng chu kỳ 10 cấp; các số “gốc” và “+ / 10 cấp” bên trên lấy nguyên vẹn từ dữ liệu game.'
                            : `Phẩm chất ${qualityLabels[pet.quality_tier] ?? pet.quality_tier} áp dụng hệ số ${pet.quality_multiplier}% lên chỉ số gốc.`}
                    </p>
                </div>

                <div className="rounded-[2rem] border border-white/10 bg-[linear-gradient(150deg,#081522,#0d2427)] p-5 shadow-[0_18px_50px_rgba(0,0,0,.24)] sm:p-7">
                    <SectionTitle
                        icon={<GitBranch />}
                        eyebrow="Gia phả"
                        title="Dòng tiến hóa"
                        description={
                            pet.belongs_to_evolution_family
                                ? 'Các dạng và nguyên liệu được giữ đúng thứ tự trong dữ liệu game.'
                                : 'Pet này không có dạng trước hoặc dạng tiến hóa tiếp theo.'
                        }
                    />
                    <EvolutionFamily pet={pet} />
                </div>
            </section>

            <section className="rounded-[2rem] border border-white/10 bg-[#081522]/94 p-5 shadow-[0_18px_50px_rgba(0,0,0,.24)] sm:p-7">
                <SectionTitle
                    icon={<WandSparkles />}
                    eyebrow="Bộ chiêu thức"
                    title="Kỹ năng có thể học"
                    description="Kỹ năng cùng hệ được sắp theo đúng cấp mở khóa của nhóm học Pet này."
                />

                {skillsByLevel.length === 0 ? (
                    <div className="mt-6 rounded-2xl border border-dashed border-white/15 bg-white/3 px-5 py-12 text-center text-slate-400">
                        Chưa xác định được kỹ năng phù hợp với nhóm học này.
                    </div>
                ) : (
                    <div className="mt-7 space-y-7">
                        {skillsByLevel.map(([unlockLevel, skills]) => (
                            <div
                                key={unlockLevel}
                                className="grid gap-4 lg:grid-cols-[8rem_minmax(0,1fr)]"
                            >
                                <div className="flex items-start gap-3 lg:block">
                                    <span className="flex size-11 items-center justify-center rounded-2xl bg-[var(--pet-accent)]/12 text-[var(--pet-accent)] lg:mb-3">
                                        <LockKeyholeOpen className="size-5" />
                                    </span>
                                    <div>
                                        <p className="text-sm font-bold text-slate-500">
                                            Mở khóa từ
                                        </p>
                                        <p className="text-xl font-black text-white">
                                            Cấp {unlockLevel}
                                        </p>
                                    </div>
                                </div>
                                <div className="grid gap-3 md:grid-cols-2 xl:grid-cols-3">
                                    {skills.map((skill) => (
                                        <SkillCard
                                            key={skill.id}
                                            skill={skill}
                                            pet={pet}
                                        />
                                    ))}
                                </div>
                            </div>
                        ))}
                    </div>
                )}
            </section>

            <details className="group rounded-[1.5rem] border border-white/10 bg-[#081522]/80 p-5 text-slate-400">
                <summary className="flex cursor-pointer list-none items-center justify-between gap-4 font-bold marker:hidden">
                    Dữ liệu kỹ thuật từ game gốc
                    <span className="text-xl text-[var(--pet-accent)] transition group-open:rotate-45">
                        +
                    </span>
                </summary>
                <dl className="mt-5 grid gap-3 border-t border-white/8 pt-5 text-sm sm:grid-cols-3">
                    <RawFact label="Sprite ID" value={pet.sprite_id} />
                    <RawFact label="Variant code" value={pet.variant_code} />
                    <RawFact
                        label="Growth code"
                        value={pet.rarity_or_growth_code}
                    />
                </dl>
                <pre className="mt-4 overflow-x-auto rounded-xl bg-black/20 p-4 text-xs leading-6 text-slate-500">
                    {JSON.stringify(pet.raw_values, null, 2)}
                </pre>
            </details>
        </div>
    );
}

function EvolutionFamily({ pet }: { pet: WikiPetDetail }) {
    const transitions = new Map(
        pet.evolution_family.transitions.map((transition) => [
            transition.from_pet_id,
            transition,
        ]),
    );

    return (
        <div className="mt-7 overflow-x-auto pb-2">
            <div className="flex min-w-max items-stretch gap-3">
                {pet.evolution_family.pets.map((familyPet, index) => {
                    const transition = transitions.get(familyPet.id);

                    return (
                        <div
                            key={familyPet.id}
                            className="flex items-center gap-3"
                        >
                            <EvolutionPetCard
                                pet={familyPet}
                                assetKey={pet.game_source.asset_key}
                            />
                            {index < pet.evolution_family.pets.length - 1 &&
                                transition !== undefined && (
                                    <EvolutionConnector
                                        transition={transition}
                                    />
                                )}
                        </div>
                    );
                })}
            </div>
        </div>
    );
}

function EvolutionPetCard({
    pet,
    assetKey,
}: {
    pet: WikiEvolutionPet;
    assetKey: string;
}) {
    const content = (
        <div
            className={`flex h-full w-37 flex-col items-center rounded-[1.5rem] border p-3 text-center transition ${
                pet.is_current
                    ? 'border-[var(--pet-accent)] bg-[var(--pet-accent)]/10 shadow-[0_12px_28px_color-mix(in_oklab,var(--pet-accent)_18%,transparent)]'
                    : 'border-white/10 bg-[#091725] hover:-translate-y-1 hover:border-[var(--pet-accent)]/50'
            }`}
        >
            <div className="flex h-27 w-full items-center justify-center rounded-2xl bg-[var(--pet-accent)]/7">
                <GameArtwork
                    src={petArtworkUrl(pet.sprite_id, assetKey)}
                    alt={pet.name}
                    className="h-23 w-full"
                    fallback={
                        <PawPrint className="size-8 text-[var(--pet-accent)]" />
                    }
                />
            </div>
            <span className="mt-3 text-sm font-bold text-[var(--pet-accent)]">
                Dạng {pet.stage}
            </span>
            <strong className="mt-1 line-clamp-2 text-sm leading-5 text-white">
                {pet.name}
            </strong>
            {pet.is_current && (
                <span className="mt-2 rounded-full bg-[var(--pet-accent)] px-2.5 py-1 text-xs font-bold text-white">
                    Đang xem
                </span>
            )}
        </div>
    );

    return pet.is_current ? (
        content
    ) : (
        <Link href={petShow(pet.id)}>{content}</Link>
    );
}

function EvolutionConnector({
    transition,
}: {
    transition: WikiEvolutionTransition;
}) {
    return (
        <div className="flex w-28 flex-col items-center justify-center text-center">
            <div className="flex w-full items-center gap-1 text-[var(--pet-accent)]">
                <span className="h-px flex-1 bg-[var(--pet-accent)]/35" />
                <ArrowRight className="size-5" />
                <span className="h-px flex-1 bg-[var(--pet-accent)]/35" />
            </div>
            <div className="mt-3 flex items-center gap-2 rounded-xl border border-white/10 bg-[#091725] px-2.5 py-2 shadow-sm">
                <GameArtwork
                    src={itemArtworkUrl(
                        transition.item.frame_id,
                        transition.item.game_source.asset_key,
                    )}
                    alt={transition.item.name}
                    className="size-8"
                    fallback={
                        <Leaf className="size-5 text-[var(--pet-accent)]" />
                    }
                />
                <span className="text-left text-xs leading-4 font-bold text-slate-300">
                    {transition.item.name}
                    <strong className="block text-[var(--pet-accent)]">
                        ×{transition.quantity}
                    </strong>
                </span>
            </div>
            {transition.type === 'mutation' && (
                <span className="mt-2 text-xs font-bold text-amber-300">
                    Dị hóa
                </span>
            )}
        </div>
    );
}

function SkillCard({
    skill,
    pet,
}: {
    skill: WikiPetSkill;
    pet: WikiPetDetail;
}) {
    return (
        <Link
            href={skillShow(skill.id)}
            className="group relative overflow-hidden rounded-[1.5rem] border border-white/10 bg-[#091725] p-4 transition hover:-translate-y-1 hover:border-[var(--pet-accent)]/55 hover:bg-[#0c1d2c] hover:shadow-[0_16px_32px_rgba(0,0,0,.22)]"
        >
            <img
                src={skillArtworkUrl(skill.game_id, pet.game_source.asset_key)}
                alt=""
                className="wiki-pixel-art absolute -right-5 -bottom-5 size-24 object-contain opacity-6"
            />
            <div className="relative flex items-start gap-3">
                <span className="flex size-13 shrink-0 items-center justify-center rounded-2xl bg-[var(--pet-accent)]/10">
                    <img
                        src={elementIconUrl(pet.combat_element.game_id)}
                        alt=""
                        className="wiki-pixel-art size-9 object-contain"
                    />
                </span>
                <div className="min-w-0 flex-1">
                    <div className="flex items-start justify-between gap-2">
                        <h3 className="text-base font-black text-white">
                            {skill.name}
                        </h3>
                        <ChevronRight className="mt-0.5 size-4 shrink-0 text-slate-600 transition group-hover:translate-x-1 group-hover:text-[var(--pet-accent)]" />
                    </div>
                    <p className="mt-1 line-clamp-2 text-sm leading-5 text-slate-400">
                        {skill.description}
                    </p>
                </div>
            </div>
            <div className="relative mt-4 flex flex-wrap items-center gap-2">
                <span className="rounded-full bg-white/6 px-3 py-1 text-xs font-bold text-slate-300">
                    Bậc {skill.tier}
                </span>
                {skill.power_percent > 0 && (
                    <span className="rounded-full bg-amber-300/10 px-3 py-1 text-xs font-bold text-amber-200">
                        Sức mạnh {skill.power_percent}%
                    </span>
                )}
                <span className="rounded-full bg-sky-300/10 px-3 py-1 text-xs font-bold text-sky-200">
                    {skill.max_uses} lượt dùng
                </span>
            </div>
            {skill.effect !== null && (
                <div className="relative mt-3 flex items-center gap-2 border-t border-white/8 pt-3">
                    <GameArtwork
                        src={effectIconUrl(
                            skill.effect.kind,
                            skill.effect.game_id,
                            skill.effect.source_table,
                        )}
                        alt={skill.effect.name}
                        className="size-7"
                        fallback={
                            <Sparkles className="size-5 text-[var(--pet-accent)]" />
                        }
                    />
                    <span className="text-sm font-bold text-slate-300">
                        {skill.effect.name}
                    </span>
                </div>
            )}
        </Link>
    );
}

function SectionTitle({
    icon,
    eyebrow,
    title,
    description,
}: {
    icon: ReactNode;
    eyebrow: string;
    title: string;
    description: string;
}) {
    return (
        <div className="flex items-start gap-4">
            <span className="flex size-12 shrink-0 items-center justify-center rounded-2xl bg-[var(--pet-accent)]/12 text-[var(--pet-accent)] [&_svg]:size-5">
                {icon}
            </span>
            <div>
                <p className="text-sm font-extrabold text-[var(--pet-accent)]">
                    {eyebrow}
                </p>
                <h2 className="mt-1 text-2xl font-black tracking-[-0.025em] text-white sm:text-3xl">
                    {title}
                </h2>
                <p className="mt-2 max-w-2xl text-sm leading-6 text-slate-400 sm:text-base">
                    {description}
                </p>
            </div>
        </div>
    );
}

function ProfileFact({
    icon,
    label,
    value,
}: {
    icon: ReactNode;
    label: string;
    value: string;
}) {
    return (
        <div className="rounded-2xl border border-white/10 bg-white/5 p-4 shadow-sm">
            <span className="flex items-center gap-2 text-sm font-bold text-slate-400 [&_svg]:size-4 [&_svg]:text-[var(--pet-accent)]">
                {icon}
                {label}
            </span>
            <strong className="mt-2 block text-base text-white">{value}</strong>
        </div>
    );
}

function StatCard({
    icon,
    label,
    value,
    formula,
    color,
}: {
    icon: ReactNode;
    label: string;
    value: number;
    formula: WikiPetStatFormula;
    color: string;
}) {
    const style = { '--stat-color': color } as CSSProperties;

    return (
        <div
            style={style}
            className="relative overflow-hidden rounded-[1.4rem] border border-white/10 bg-[#091725] p-5"
        >
            <span className="absolute inset-y-0 left-0 w-1.5 bg-[var(--stat-color)]" />
            <div className="flex items-center justify-between gap-4 pl-1">
                <div>
                    <span className="text-sm font-bold text-slate-400">
                        {label}
                    </span>
                    <strong className="mt-1 block text-3xl font-black text-white tabular-nums">
                        {value.toLocaleString('vi-VN')}
                    </strong>
                    <span className="mt-2 block text-xs font-bold text-slate-500 tabular-nums">
                        Gốc {formula.base.toLocaleString('vi-VN')} · +
                        {formula.per_level.toLocaleString('vi-VN')} /
                        {formula.per_ten_levels ? '10 cấp' : 'cấp'}
                    </span>
                </div>
                <span className="flex size-12 items-center justify-center rounded-2xl bg-[var(--stat-color)]/12 text-[var(--stat-color)] [&_svg]:size-6">
                    {icon}
                </span>
            </div>
        </div>
    );
}

function RawFact({ label, value }: { label: string; value: number }) {
    return (
        <div className="rounded-xl bg-white/4 px-4 py-3">
            <dt className="font-semibold text-slate-500">{label}</dt>
            <dd className="mt-1 font-bold text-slate-300">{value}</dd>
        </div>
    );
}

function calculateStat(
    formula: WikiPetStatFormula,
    level: number,
    qualityMultiplier: number,
): number {
    const levelFactor = formula.per_ten_levels ? level / 10 : level;

    return Math.trunc(
        ((formula.base + formula.per_level * levelFactor + formula.offset) *
            qualityMultiplier) /
            100,
    );
}

function evolutionStatus(pet: WikiPetDetail): string {
    if (!pet.belongs_to_evolution_family) {
        return 'Pet độc lập · Không có dạng tiến hóa';
    }

    if (pet.is_final_stage) {
        return `Dạng cuối · Cấp ${pet.evolution_stage}/${pet.evolution_stage_count}`;
    }

    return `Dạng tiến hóa ${pet.evolution_stage}/${pet.evolution_stage_count}`;
}
