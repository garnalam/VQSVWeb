import { Head, Link } from '@inertiajs/react';
import {
    ArrowLeft,
    BarChart3,
    ChevronRight,
    Crown,
    Dna,
    Dumbbell,
    Expand,
    Gauge,
    GitBranch,
    GitCompareArrows,
    Heart,
    Layers3,
    LockKeyhole,
    PawPrint,
    Plus,
    Shield,
    ShieldCheck,
    Sparkles,
    Swords,
    Trash2,
    Users,
    WandSparkles,
    X,
    Zap,
} from 'lucide-react';
import type { CSSProperties, ReactNode } from 'react';
import { useState } from 'react';
import { GameArtwork } from '@/components/wiki/game-artwork';
import { PetArtworkMotion } from '@/components/wiki/pet-artwork-motion';
import { TraitBadge } from '@/components/wiki/trait-badge';
import {
    effectIconUrl,
    elementIconUrl,
    itemArtworkUrl,
    petArtworkUrl,
    skillArtworkUrl,
} from '@/lib/game-assets';
import { show as itemShow } from '@/routes/wiki/items';
import { index as petsIndex, show as petShow } from '@/routes/wiki/pets';
import { show as skillShow } from '@/routes/wiki/skills';
import type {
    WikiEvolutionPet,
    WikiEvolutionTransition,
    WikiPetDetail,
    WikiPetSkill,
    WikiPetStatFormula,
    WikiPetStatValues,
    WikiPetTrait,
    WikiPetTraitPolarity,
    WikiPetTraitSystem,
} from '@/types';

type PetShowProps = {
    pet: WikiPetDetail;
    trait_system: WikiPetTraitSystem;
};

type SkillDeckTab = 'ready' | 'locked' | 'alternate';

const statDefinitions = [
    { key: 'hp', label: 'Sinh mệnh', shortLabel: 'HP', color: '#fb7185' },
    {
        key: 'strength',
        label: 'Sức mạnh',
        shortLabel: 'ATK',
        color: '#fb923c',
    },
    {
        key: 'defense',
        label: 'Phòng ngự',
        shortLabel: 'DEF',
        color: '#60a5fa',
    },
    {
        key: 'agility',
        label: 'Linh xảo',
        shortLabel: 'SPD',
        color: '#22d3ee',
    },
] as const;

export default function PetShow({ pet, trait_system }: PetShowProps) {
    const [level, setLevel] = useState(50);
    const [star, setStar] = useState(pet.default_star);
    const [activeSkillTab, setActiveSkillTab] = useState<SkillDeckTab>('ready');
    const [equippedSkillIds, setEquippedSkillIds] = useState<number[]>([]);
    const [isSpriteOpen, setIsSpriteOpen] = useState(false);
    const [isComparisonOpen, setIsComparisonOpen] = useState(false);
    const [isTraitCatalogOpen, setIsTraitCatalogOpen] = useState(false);
    const accent = pet.combat_element.color;
    const style = { '--pet-accent': accent } as CSSProperties;
    const starMultiplier = pet.star_multipliers[star];
    const currentStats = calculateStatValues(pet.stats, level, starMultiplier);
    const benchmarkStats = interpolateBenchmarks(pet, level, starMultiplier);
    const readySkills = pet.skills.filter(
        (skill) =>
            skill.is_available_on_current_form && skill.unlock_level <= level,
    );
    const lockedSkills = pet.skills.filter(
        (skill) =>
            !skill.is_alternate_branch &&
            (!skill.is_available_on_current_form || skill.unlock_level > level),
    );
    const alternateSkills = pet.skills.filter(
        (skill) => skill.is_alternate_branch,
    );
    const visibleSkills =
        activeSkillTab === 'ready'
            ? readySkills
            : activeSkillTab === 'locked'
              ? lockedSkills
              : alternateSkills;
    const readySkillIds = new Set(readySkills.map((skill) => skill.id));
    const equippedSkills = equippedSkillIds
        .filter((skillId) => readySkillIds.has(skillId))
        .map((skillId) => pet.skills.find((skill) => skill.id === skillId))
        .filter((skill): skill is WikiPetSkill => skill !== undefined);
    const buildAnalysis = analyzeBuild(equippedSkills);

    function toggleSkill(skill: WikiPetSkill): void {
        if (!readySkillIds.has(skill.id)) {
            return;
        }

        setEquippedSkillIds((currentSkillIds) => {
            if (currentSkillIds.includes(skill.id)) {
                return currentSkillIds.filter(
                    (skillId) => skillId !== skill.id,
                );
            }

            if (currentSkillIds.length >= pet.equipped_skill_limit) {
                return currentSkillIds;
            }

            return [...currentSkillIds, skill.id];
        });
    }

    return (
        <div style={style} className="flex flex-col gap-5 text-slate-100">
            <Head title={`${pet.name} · Hồ sơ chiến thuật`} />

            <Link
                href={petsIndex()}
                className="flex w-fit items-center gap-2 rounded-full border border-white/10 bg-[#091522]/90 px-4 py-2.5 text-sm font-black text-slate-300 transition hover:-translate-x-1 hover:border-[var(--pet-accent)]/50 hover:text-white"
            >
                <ArrowLeft className="size-4" />
                Trở lại cẩm nang Pet
            </Link>

            <HeroSection pet={pet} onOpenSprite={() => setIsSpriteOpen(true)} />

            <QuickNavigation isDivine={pet.divine_ability !== null} />

            {pet.divine_ability !== null && <DivineAuthorityPanel pet={pet} />}

            <div className="grid items-start gap-5 xl:grid-cols-[minmax(0,1.85fr)_minmax(21rem,1fr)]">
                <main className="flex min-w-0 flex-col gap-5">
                    <section id="overview" className="scroll-mt-36">
                        <StatAnalysis
                            pet={pet}
                            level={level}
                            onLevelChange={setLevel}
                            star={star}
                            starMultiplier={starMultiplier}
                            onStarChange={setStar}
                            currentStats={currentStats}
                            benchmarkStats={benchmarkStats}
                        />
                    </section>

                    <section id="evolution" className="scroll-mt-36">
                        <DashboardPanel
                            icon={<GitBranch />}
                            eyebrow="Sơ đồ tiến hóa"
                            title="Cây tiến hóa phân nhánh"
                            description="Mỗi đường năng lượng là một công thức tiến hóa thật; nhấn node hoặc vật phẩm để mở hồ sơ tương ứng."
                            action={
                                <button
                                    type="button"
                                    onClick={() => setIsComparisonOpen(true)}
                                    className="flex items-center gap-2 rounded-xl border border-[var(--pet-accent)]/30 bg-[var(--pet-accent)]/8 px-3 py-2 text-xs font-black text-[var(--pet-accent)] transition hover:bg-[var(--pet-accent)]/15"
                                >
                                    <GitCompareArrows className="size-4" />
                                    So sánh form
                                </button>
                            }
                        >
                            <EvolutionTree pet={pet} />
                            {pet.mutation_recipe !== null && (
                                <MutationRecipeCard pet={pet} />
                            )}
                        </DashboardPanel>
                    </section>

                    <section id="skills" className="scroll-mt-36">
                        <DashboardPanel
                            icon={<Swords />}
                            eyebrow="Cấu hình kỹ năng"
                            title="Bể Skill & trình dựng Build"
                            description={`Thử lắp tối đa ${pet.equipped_skill_limit} Skill. Sandbox chỉ dùng để phân tích và không thay đổi dữ liệu tài khoản.`}
                        >
                            <SkillSandbox
                                pet={pet}
                                equippedSkills={equippedSkills}
                                buildAnalysis={buildAnalysis}
                                onRemoveSkill={toggleSkill}
                                onClear={() => setEquippedSkillIds([])}
                            />

                            <SkillDeckTabs
                                activeTab={activeSkillTab}
                                onTabChange={setActiveSkillTab}
                                counts={{
                                    ready: readySkills.length,
                                    locked: lockedSkills.length,
                                    alternate: alternateSkills.length,
                                }}
                            />

                            {visibleSkills.length === 0 ? (
                                <div className="mt-4 rounded-2xl border border-dashed border-white/12 bg-black/15 px-5 py-10 text-center text-sm font-semibold text-slate-500">
                                    Không có Skill trong nhóm này ở cấp {level}.
                                </div>
                            ) : (
                                <div className="mt-4 grid gap-3 md:grid-cols-2">
                                    {visibleSkills.map((skill) => (
                                        <SkillDeckCard
                                            key={`${activeSkillTab}-${skill.grant_pet.id}-${skill.id}`}
                                            skill={skill}
                                            isEquipped={equippedSkills.some(
                                                (equippedSkill) =>
                                                    equippedSkill.id ===
                                                    skill.id,
                                            )}
                                            canEquip={readySkillIds.has(
                                                skill.id,
                                            )}
                                            isBuildFull={
                                                equippedSkills.length >=
                                                pet.equipped_skill_limit
                                            }
                                            onToggle={() => toggleSkill(skill)}
                                        />
                                    ))}
                                </div>
                            )}
                        </DashboardPanel>
                    </section>
                </main>

                <TacticalSidebar
                    pet={pet}
                    level={level}
                    star={star}
                    starMultiplier={starMultiplier}
                    onOpenTraits={() => setIsTraitCatalogOpen(true)}
                    onOpenComparison={() => setIsComparisonOpen(true)}
                />
            </div>

            {isSpriteOpen && (
                <ModalShell
                    title={`Sprite Pixel · ${pet.name}`}
                    onClose={() => setIsSpriteOpen(false)}
                    size="max-w-3xl"
                >
                    <div className="relative flex min-h-120 items-center justify-center overflow-hidden bg-[radial-gradient(circle,color-mix(in_oklab,var(--pet-accent)_18%,#081522),#050b12_68%)] p-8">
                        <div className="absolute size-96 animate-[spin_20s_linear_infinite] rounded-full border border-dashed border-[var(--pet-accent)]/30" />
                        <GameArtwork
                            src={petArtworkUrl(
                                pet.sprite_id,
                                pet.game_source.asset_key,
                            )}
                            alt={pet.name}
                            className="relative z-10 h-96 w-full drop-shadow-[0_0_38px_var(--pet-accent)]"
                            fallback={
                                <PawPrint className="size-24 text-[var(--pet-accent)]" />
                            }
                        />
                    </div>
                </ModalShell>
            )}

            {isComparisonOpen && (
                <FormComparisonModal
                    pet={pet}
                    level={level}
                    starMultiplier={starMultiplier}
                    onClose={() => setIsComparisonOpen(false)}
                />
            )}

            {isTraitCatalogOpen && (
                <TraitCatalogModal
                    traitSystem={trait_system}
                    onClose={() => setIsTraitCatalogOpen(false)}
                />
            )}
        </div>
    );
}

function HeroSection({
    pet,
    onOpenSprite,
}: {
    pet: WikiPetDetail;
    onOpenSprite: () => void;
}) {
    return (
        <section className="relative isolate overflow-hidden rounded-[2rem] border border-white/10 bg-[linear-gradient(120deg,#07111c_0%,color-mix(in_oklab,var(--pet-accent)_11%,#0a1724)_58%,color-mix(in_oklab,var(--pet-accent)_24%,#07111c)_100%)] shadow-[0_30px_90px_rgba(0,0,0,.36)]">
            <div className="wiki-grid absolute inset-0 -z-10 opacity-20" />
            <div className="absolute -top-32 right-4 -z-10 size-96 rounded-full bg-[var(--pet-accent)]/14 blur-3xl" />
            <div className="grid lg:grid-cols-[24rem_minmax(0,1fr)]">
                <div className="relative flex min-h-96 flex-col items-center justify-center overflow-hidden border-b border-white/8 p-7 lg:border-r lg:border-b-0">
                    <div className="absolute size-72 animate-[spin_22s_linear_infinite] rounded-full border border-dashed border-[var(--pet-accent)]/30" />
                    <div className="absolute size-56 animate-[spin_16s_linear_infinite_reverse] rounded-full border border-[var(--pet-accent)]/20" />
                    <div className="absolute inset-x-12 top-1/2 h-px bg-linear-to-r from-transparent via-[var(--pet-accent)]/60 to-transparent shadow-[0_0_14px_var(--pet-accent)]" />
                    <PetArtworkMotion
                        spriteId={pet.sprite_id}
                        assetKey={pet.game_source.asset_key}
                        staticSrc={petArtworkUrl(
                            pet.sprite_id,
                            pet.game_source.asset_key,
                        )}
                        alt={pet.name}
                        className="relative z-10 flex h-72 w-full items-center justify-center"
                        imageClassName="h-full w-full drop-shadow-[0_24px_24px_rgba(0,0,0,.42)]"
                        fallback={
                            <PawPrint className="size-20 text-[var(--pet-accent)]" />
                        }
                    />
                    <button
                        type="button"
                        onClick={onOpenSprite}
                        className="relative z-20 mt-3 flex items-center gap-2 rounded-full border border-white/12 bg-black/30 px-4 py-2 text-xs font-black text-slate-300 backdrop-blur transition hover:border-[var(--pet-accent)]/45 hover:text-white"
                    >
                        <Expand className="size-4 text-[var(--pet-accent)]" />
                        Phóng to Sprite Pixel
                    </button>
                </div>

                <div className="flex flex-col justify-center px-6 py-9 sm:px-10">
                    <div className="flex flex-wrap items-center gap-2 font-mono text-[10px] font-black tracking-[.12em] uppercase">
                        <span className="bg-[var(--pet-accent)] px-3 py-1.5 text-[#07111c]">
                            PET-{String(pet.game_id).padStart(3, '0')}
                        </span>
                        <span className="flex items-center gap-2 border border-[var(--pet-accent)]/35 bg-[var(--pet-accent)]/9 px-3 py-1.5 text-[var(--pet-accent)]">
                            <img
                                src={elementIconUrl(pet.combat_element.game_id)}
                                alt=""
                                className="wiki-pixel-art size-5 object-contain"
                            />
                            Hệ {pet.combat_element.name}
                        </span>
                        <span className="border border-white/10 bg-white/4 px-3 py-1.5 text-slate-300">
                            Form {pet.evolution_stage}/
                            {pet.evolution_stage_count}
                        </span>
                        {pet.power_class === 'divine' && (
                            <span className="relative flex items-center gap-2 overflow-hidden border border-amber-300/55 bg-linear-to-r from-amber-300 via-yellow-200 to-amber-400 px-3 py-1.5 text-[#321800] shadow-[0_0_22px_rgba(251,191,36,.28)]">
                                <span className="absolute inset-0 animate-pulse bg-linear-to-r from-transparent via-white/35 to-transparent" />
                                <Crown className="relative size-4" />
                                <span className="relative">Thần thú</span>
                            </span>
                        )}
                    </div>

                    <h1 className="mt-5 text-4xl leading-none font-black tracking-[-.05em] text-white uppercase sm:text-6xl">
                        {pet.name}
                    </h1>
                    <p className="mt-3 font-mono text-xs font-black tracking-[.15em] text-[var(--pet-accent)] uppercase">
                        {evolutionStatus(pet)}
                    </p>

                    <div className="mt-6 flex flex-wrap gap-2">
                        <TacticalBadge
                            icon={<Swords />}
                            label="Vai trò chiến thuật"
                            value={`${pet.primary_role_label} / ${pet.secondary_role_label}`}
                        />
                        <TacticalBadge
                            icon={<Users />}
                            label="Thể thức đề xuất"
                            value={
                                pet.preferred_battle_format === 'double'
                                    ? 'Ưu tiên đấu đôi'
                                    : 'Mọi thể thức'
                            }
                        />
                        <TacticalBadge
                            icon={<Shield />}
                            label="Chủng"
                            value={pet.species.name}
                        />
                    </div>

                    <div className="mt-5 border border-[var(--pet-accent)]/20 bg-black/18 p-4 backdrop-blur-sm [clip-path:polygon(0_0,calc(100%_-_18px)_0,100%_18px,100%_100%,18px_100%,0_calc(100%_-_18px))]">
                        <p className="text-sm leading-6 font-semibold text-slate-300">
                            <span className="mb-1 block font-mono text-[9px] font-black tracking-[.12em] text-[var(--pet-accent)] uppercase">
                                Định hướng chiến thuật
                            </span>
                            {pet.playstyle_summary}
                        </p>
                        {pet.lore && (
                            <p className="mt-2 text-xs leading-5 text-slate-500">
                                {pet.lore}
                            </p>
                        )}
                    </div>
                </div>
            </div>
        </section>
    );
}

function TacticalBadge({
    icon,
    label,
    value,
}: {
    icon: ReactNode;
    label: string;
    value: string;
}) {
    return (
        <span className="flex items-center gap-2 rounded-xl border border-white/10 bg-white/5 px-3 py-2 text-xs font-black text-slate-200 [&_svg]:size-4 [&_svg]:text-[var(--pet-accent)]">
            {icon}
            <span className="text-slate-500">{label}:</span>
            {value}
        </span>
    );
}

function QuickNavigation({ isDivine }: { isDivine: boolean }) {
    const items = [
        { href: '#overview', label: 'Tổng quan & Chỉ số', icon: <BarChart3 /> },
        ...(isDivine
            ? [
                  {
                      href: '#divine-authority',
                      label: 'Thần Quyền',
                      icon: <Crown />,
                  },
              ]
            : []),
        { href: '#evolution', label: 'Cây Tiến hóa', icon: <GitBranch /> },
        { href: '#skills', label: 'Bể Skill & Build', icon: <Swords /> },
        { href: '#traits', label: 'Đặc tính', icon: <Dna /> },
    ];

    return (
        <nav className="sticky top-[4.65rem] z-30 [scrollbar-width:none] overflow-x-auto rounded-2xl border border-white/10 bg-[#07111c]/92 p-2 shadow-[0_16px_45px_rgba(0,0,0,.35)] backdrop-blur-xl [&::-webkit-scrollbar]:hidden">
            <div className="flex min-w-max gap-2">
                {items.map((item, index) => (
                    <a
                        key={item.href}
                        href={item.href}
                        className="group flex items-center gap-2 rounded-xl border border-transparent px-3 py-2.5 text-xs font-black text-slate-400 transition hover:border-[var(--pet-accent)]/30 hover:bg-[var(--pet-accent)]/8 hover:text-white sm:px-4"
                    >
                        <span className="font-mono text-[9px] text-[var(--pet-accent)]">
                            0{index + 1}
                        </span>
                        <span className="[&_svg]:size-4">{item.icon}</span>
                        {item.label}
                    </a>
                ))}
            </div>
        </nav>
    );
}

function DivineAuthorityPanel({ pet }: { pet: WikiPetDetail }) {
    const ability = pet.divine_ability;

    if (ability === null) {
        return null;
    }

    return (
        <section
            id="divine-authority"
            className="group relative scroll-mt-36 overflow-hidden rounded-[2rem] border border-amber-300/35 bg-[linear-gradient(125deg,#130d24_0%,#25143d_44%,#161027_70%,#2a1c0c_100%)] p-px shadow-[0_24px_80px_rgba(88,28,135,.2),0_0_38px_rgba(251,191,36,.08)]"
        >
            <div className="absolute -top-28 -left-20 size-72 rounded-full bg-violet-500/18 blur-3xl" />
            <div className="absolute -right-16 -bottom-28 size-72 rounded-full bg-amber-300/14 blur-3xl" />
            <div className="absolute inset-0 [background-image:linear-gradient(rgba(251,191,36,.15)_1px,transparent_1px),linear-gradient(90deg,rgba(167,139,250,.12)_1px,transparent_1px)] [background-size:42px_42px] opacity-20" />

            <div className="relative overflow-hidden rounded-[calc(2rem-1px)] bg-[#080c17]/56 px-5 py-6 backdrop-blur-sm sm:px-7 sm:py-7">
                <div className="grid items-center gap-6 lg:grid-cols-[10rem_minmax(0,1fr)]">
                    <div className="relative mx-auto flex size-36 items-center justify-center">
                        <div className="absolute inset-0 animate-[spin_18s_linear_infinite] rounded-full border border-dashed border-amber-300/45" />
                        <div className="absolute inset-3 animate-[spin_12s_linear_infinite_reverse] rounded-full border border-violet-300/30" />
                        <div className="absolute inset-7 rotate-45 border border-amber-200/25" />
                        <div className="absolute inset-10 rounded-full bg-[radial-gradient(circle,rgba(253,224,71,.3),rgba(124,58,237,.14)_50%,transparent_72%)] blur-sm transition duration-500 group-hover:scale-125" />
                        <Crown className="relative size-12 text-amber-200 drop-shadow-[0_0_18px_rgba(253,224,71,.75)]" />
                    </div>

                    <div className="min-w-0">
                        <div className="flex flex-wrap items-center gap-2">
                            <span className="rounded-full border border-amber-200/45 bg-amber-300/10 px-3 py-1 font-mono text-[10px] font-black tracking-[.2em] text-amber-200 uppercase">
                                Thần Quyền
                            </span>
                            <span className="rounded-full border border-violet-300/25 bg-violet-400/8 px-3 py-1 text-[10px] font-black tracking-[.08em] text-violet-200 uppercase">
                                Nội tại độc quyền
                            </span>
                        </div>

                        <h2 className="mt-3 bg-linear-to-r from-amber-100 via-yellow-300 to-violet-200 bg-clip-text text-3xl leading-tight font-black tracking-[-.04em] text-transparent sm:text-4xl">
                            {ability.name}
                        </h2>
                        <div className="mt-3 flex items-start gap-2 text-sm font-bold text-violet-100">
                            <Zap className="mt-0.5 size-4 shrink-0 text-amber-300" />
                            <span>
                                <span className="text-slate-500">
                                    Điều kiện kích hoạt:{' '}
                                </span>
                                {ability.activation_type_label}
                            </span>
                        </div>
                        <p className="mt-4 max-w-4xl text-sm leading-7 font-semibold text-slate-200 sm:text-base">
                            {ability.description}
                        </p>

                        <div className="mt-5 flex flex-wrap gap-2">
                            {Object.entries(ability.parameters).map(
                                ([parameter, value]) => (
                                    <div
                                        key={parameter}
                                        className="rounded-xl border border-white/9 bg-black/24 px-3.5 py-2.5 shadow-inner shadow-black/20"
                                    >
                                        <p className="text-[10px] font-bold tracking-[.08em] text-slate-500 uppercase">
                                            {divineParameterLabel(parameter)}
                                        </p>
                                        <p className="mt-0.5 font-mono text-sm font-black text-amber-200">
                                            {formatDivineParameterValue(
                                                parameter,
                                                value,
                                            )}
                                        </p>
                                    </div>
                                ),
                            )}
                        </div>

                        <div className="mt-5 flex items-center gap-2 border-t border-white/8 pt-4 text-xs font-semibold text-slate-500">
                            <ShieldCheck className="size-4 shrink-0 text-violet-300" />
                            Thần Quyền là năng lực bẩm sinh độc lập, không chiếm
                            ô Đặc tính hoặc một trong 5 ô Skill chiến đấu.
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
}

function DashboardPanel({
    icon,
    eyebrow,
    title,
    description,
    action,
    children,
}: {
    icon: ReactNode;
    eyebrow: string;
    title: string;
    description: string;
    action?: ReactNode;
    children: ReactNode;
}) {
    return (
        <div className="relative overflow-hidden rounded-[1.8rem] border border-white/9 bg-[#081522]/94 p-5 shadow-[0_20px_60px_rgba(0,0,0,.24)] sm:p-6">
            <div className="absolute top-0 left-0 h-px w-1/2 bg-linear-to-r from-[var(--pet-accent)]/70 to-transparent" />
            <div className="flex flex-wrap items-start justify-between gap-4">
                <div className="flex items-start gap-3">
                    <span className="flex size-10 shrink-0 items-center justify-center border border-[var(--pet-accent)]/30 bg-[var(--pet-accent)]/9 text-[var(--pet-accent)] [&_svg]:size-4">
                        {icon}
                    </span>
                    <div>
                        <p className="font-mono text-[9px] font-black tracking-[.18em] text-[var(--pet-accent)] uppercase">
                            {eyebrow}
                        </p>
                        <h2 className="mt-1 text-2xl font-black tracking-[-.035em] text-white">
                            {title}
                        </h2>
                        <p className="mt-2 max-w-2xl text-sm leading-6 text-slate-400">
                            {description}
                        </p>
                    </div>
                </div>
                {action}
            </div>
            <div className="mt-6">{children}</div>
        </div>
    );
}

function StatAnalysis({
    pet,
    level,
    onLevelChange,
    star,
    starMultiplier,
    onStarChange,
    currentStats,
    benchmarkStats,
}: {
    pet: WikiPetDetail;
    level: number;
    onLevelChange: (level: number) => void;
    star: number;
    starMultiplier: number;
    onStarChange: (star: number) => void;
    currentStats: WikiPetStatValues;
    benchmarkStats: WikiPetStatValues;
}) {
    return (
        <DashboardPanel
            icon={<Gauge />}
            eyebrow="Phân tích chỉ số"
            title="Phân tích chỉ số chiến đấu"
            description={`Radar so Pet với trung bình thật của toàn bộ ${pet.population_count} Pet tại cùng cấp độ.`}
            action={
                <div className="flex flex-wrap items-center gap-3">
                    <div className="border border-white/9 bg-white/4 px-4 py-2 text-center">
                        <span className="block font-mono text-[8px] tracking-[.15em] text-slate-500 uppercase">
                            Cấp đang mô phỏng
                        </span>
                        <strong className="text-2xl font-black text-[var(--pet-accent)] tabular-nums">
                            {level}
                        </strong>
                    </div>
                    <div className="border border-white/9 bg-white/4 px-3 py-2">
                        <span className="block font-mono text-[8px] tracking-[.15em] text-slate-500 uppercase">
                            Sao cá thể
                        </span>
                        <div
                            className="mt-1 flex gap-1"
                            aria-label="Chọn số sao mô phỏng"
                        >
                            {Object.keys(pet.star_multipliers)
                                .map(Number)
                                .map((option) => (
                                    <button
                                        key={option}
                                        type="button"
                                        onClick={() => onStarChange(option)}
                                        aria-pressed={star === option}
                                        aria-label={`${option} sao`}
                                        className={`flex size-7 items-center justify-center border transition ${
                                            star === option
                                                ? 'border-amber-300/70 bg-amber-300/15 text-amber-300'
                                                : 'border-white/8 text-slate-600 hover:border-amber-300/30 hover:text-amber-200'
                                        }`}
                                    >
                                        <Sparkles className="size-3.5 fill-current" />
                                    </button>
                                ))}
                        </div>
                    </div>
                </div>
            }
        >
            <div className="grid gap-5 lg:grid-cols-[20rem_minmax(0,1fr)]">
                <StatRadar values={currentStats} benchmark={benchmarkStats} />

                <div className="min-w-0">
                    <label className="block rounded-2xl border border-white/8 bg-black/15 p-4">
                        <span className="flex items-center justify-between gap-4 text-xs font-black text-slate-400">
                            <span>Mô phỏng cấp độ</span>
                            <span className="font-mono text-[var(--pet-accent)]">
                                LV.{String(level).padStart(2, '0')}
                            </span>
                        </span>
                        <input
                            type="range"
                            min="1"
                            max="50"
                            value={level}
                            onChange={(event) =>
                                onLevelChange(Number(event.target.value))
                            }
                            className="mt-3 h-2 w-full cursor-pointer appearance-none rounded-full bg-white/10 accent-[var(--pet-accent)]"
                        />
                        <span className="mt-2 flex justify-between font-mono text-[9px] text-slate-600">
                            <span>LV.01</span>
                            <span>LV.50</span>
                        </span>
                    </label>

                    <div className="mt-4 grid gap-3 sm:grid-cols-2">
                        <TacticalStatCard
                            icon={<Heart />}
                            definition={statDefinitions[0]}
                            value={currentStats.hp}
                            benchmark={benchmarkStats.hp}
                            formula={pet.stats.hp}
                        />
                        <TacticalStatCard
                            icon={<Dumbbell />}
                            definition={statDefinitions[1]}
                            value={currentStats.strength}
                            benchmark={benchmarkStats.strength}
                            formula={pet.stats.strength}
                        />
                        <TacticalStatCard
                            icon={<Shield />}
                            definition={statDefinitions[2]}
                            value={currentStats.defense}
                            benchmark={benchmarkStats.defense}
                            formula={pet.stats.defense}
                        />
                        <TacticalStatCard
                            icon={<Zap />}
                            definition={statDefinitions[3]}
                            value={currentStats.agility}
                            benchmark={benchmarkStats.agility}
                            formula={pet.stats.agility}
                        />
                    </div>
                </div>
            </div>
        </DashboardPanel>
    );
}

function StatRadar({
    values,
    benchmark,
}: {
    values: WikiPetStatValues;
    benchmark: WikiPetStatValues;
}) {
    const maxValues = Object.fromEntries(
        statDefinitions.map(({ key }) => [
            key,
            Math.max(values[key], benchmark[key], 1) * 1.15,
        ]),
    ) as Record<keyof WikiPetStatValues, number>;
    const petPoints = radarPoints(values, maxValues, 180, 165, 105);
    const benchmarkPoints = radarPoints(benchmark, maxValues, 180, 165, 105);

    return (
        <div className="relative overflow-hidden border border-white/8 bg-[radial-gradient(circle_at_center,color-mix(in_oklab,var(--pet-accent)_10%,#07111c),#07111c_68%)] p-3">
            <svg
                viewBox="0 0 360 330"
                role="img"
                aria-label="Biểu đồ radar so sánh chỉ số Pet với trung bình game"
                className="mx-auto w-full max-w-80"
            >
                {[0.25, 0.5, 0.75, 1].map((scale) => (
                    <polygon
                        key={scale}
                        points={statDefinitions
                            .map((_, index) => {
                                const point = radarCoordinate(
                                    index,
                                    180,
                                    165,
                                    105 * scale,
                                );

                                return `${point.x},${point.y}`;
                            })
                            .join(' ')}
                        fill="none"
                        stroke="rgba(255,255,255,.10)"
                        strokeWidth="1"
                    />
                ))}
                {statDefinitions.map((definition, index) => {
                    const point = radarCoordinate(index, 180, 165, 105);

                    return (
                        <line
                            key={definition.key}
                            x1="180"
                            y1="165"
                            x2={point.x}
                            y2={point.y}
                            stroke="rgba(255,255,255,.12)"
                        />
                    );
                })}
                <polygon
                    points={benchmarkPoints}
                    fill="rgba(148,163,184,.08)"
                    stroke="rgba(148,163,184,.65)"
                    strokeWidth="1.5"
                    strokeDasharray="5 5"
                />
                <polygon
                    points={petPoints}
                    fill="color-mix(in oklab, var(--pet-accent) 24%, transparent)"
                    stroke="var(--pet-accent)"
                    strokeWidth="2.5"
                    filter="drop-shadow(0 0 7px var(--pet-accent))"
                />
                {statDefinitions.map((definition, index) => {
                    const point = radarCoordinate(index, 180, 165, 137);

                    return (
                        <text
                            key={definition.key}
                            x={point.x}
                            y={point.y}
                            textAnchor="middle"
                            dominantBaseline="middle"
                            fill={definition.color}
                            fontSize="11"
                            fontWeight="900"
                            fontFamily="monospace"
                        >
                            {definition.shortLabel}
                        </text>
                    );
                })}
            </svg>
            <div className="absolute right-3 bottom-3 flex flex-col gap-1 font-mono text-[8px] font-bold text-slate-500 uppercase">
                <span className="flex items-center gap-2">
                    <span className="h-0.5 w-4 bg-[var(--pet-accent)]" /> Pet
                </span>
                <span className="flex items-center gap-2">
                    <span className="h-0.5 w-4 border-t border-dashed border-slate-400" />{' '}
                    Trung bình
                </span>
            </div>
        </div>
    );
}

function TacticalStatCard({
    icon,
    definition,
    value,
    benchmark,
    formula,
}: {
    icon: ReactNode;
    definition: (typeof statDefinitions)[number];
    value: number;
    benchmark: number;
    formula: WikiPetStatFormula;
}) {
    const difference =
        benchmark === 0 ? 0 : ((value - benchmark) / benchmark) * 100;
    const statStyle = { '--stat-color': definition.color } as CSSProperties;

    return (
        <article
            style={statStyle}
            className="relative overflow-hidden border border-white/8 bg-[#091827] p-4"
        >
            <span className="absolute inset-y-0 left-0 w-1 bg-[var(--stat-color)]" />
            <div className="flex items-start justify-between gap-3 pl-1">
                <div>
                    <span className="font-mono text-[9px] font-black tracking-[.12em] text-slate-500 uppercase">
                        {definition.shortLabel} · {definition.label}
                    </span>
                    <strong className="mt-1 block text-2xl font-black text-white tabular-nums">
                        {value.toLocaleString('vi-VN')}
                    </strong>
                </div>
                <span className="flex size-10 items-center justify-center bg-[var(--stat-color)]/10 text-[var(--stat-color)] [&_svg]:size-5">
                    {icon}
                </span>
            </div>
            <div className="mt-3 flex items-center justify-between gap-3 border-t border-white/7 pt-3 text-[10px] font-bold">
                <span className="text-slate-500">
                    +{formula.per_level.toLocaleString('vi-VN')} /
                    {formula.per_ten_levels ? '10 cấp' : 'cấp'}
                </span>
                <span
                    className={
                        difference >= 0 ? 'text-emerald-300' : 'text-rose-300'
                    }
                >
                    {difference >= 0 ? '+' : ''}
                    {difference.toFixed(0)}% TB
                </span>
            </div>
        </article>
    );
}

function EvolutionTree({ pet }: { pet: WikiPetDetail }) {
    const tree = buildEvolutionTreeLayout(pet.evolution_family.pets);

    return (
        <div className="grid gap-3">
            <div className="[scrollbar-width:none] overflow-x-auto rounded-2xl border border-white/8 bg-black/18 [&::-webkit-scrollbar]:hidden">
                <div
                    className="relative min-h-80"
                    style={{ width: tree.width, height: tree.height }}
                >
                    <svg
                        className="pointer-events-none absolute inset-0 size-full"
                        viewBox={`0 0 ${tree.width} ${tree.height}`}
                        aria-hidden="true"
                    >
                        <defs>
                            <filter id="treeGlow">
                                <feGaussianBlur
                                    stdDeviation="2.5"
                                    result="blur"
                                />
                                <feMerge>
                                    <feMergeNode in="blur" />
                                    <feMergeNode in="SourceGraphic" />
                                </feMerge>
                            </filter>
                        </defs>
                        {pet.evolution_family.transitions.map((transition) => {
                            const from = tree.positions.get(
                                transition.from_pet_id,
                            );
                            const to = tree.positions.get(transition.to_pet_id);

                            if (!from || !to) {
                                return null;
                            }

                            const midpoint = (from.x + to.x) / 2;

                            return (
                                <path
                                    key={`${transition.from_pet_id}-${transition.to_pet_id}`}
                                    d={`M ${from.x + 96} ${from.y} C ${midpoint} ${from.y}, ${midpoint} ${to.y}, ${to.x - 96} ${to.y}`}
                                    fill="none"
                                    stroke={
                                        transition.type === 'mutation'
                                            ? '#c084fc'
                                            : 'var(--pet-accent)'
                                    }
                                    strokeWidth="2"
                                    strokeDasharray={
                                        transition.type === 'mutation'
                                            ? '7 5'
                                            : undefined
                                    }
                                    opacity=".7"
                                    filter="url(#treeGlow)"
                                />
                            );
                        })}
                    </svg>

                    {pet.evolution_family.transitions.map((transition) => {
                        const from = tree.positions.get(transition.from_pet_id);
                        const to = tree.positions.get(transition.to_pet_id);

                        if (!from || !to) {
                            return null;
                        }

                        return (
                            <EvolutionMaterialLink
                                key={`${transition.from_pet_id}-${transition.to_pet_id}`}
                                transition={transition}
                                x={(from.x + to.x) / 2}
                                y={(from.y + to.y) / 2}
                            />
                        );
                    })}

                    {pet.evolution_family.pets.map((form) => {
                        const position = tree.positions.get(form.id);

                        if (!position) {
                            return null;
                        }

                        return (
                            <EvolutionNode
                                key={form.id}
                                form={form}
                                assetKey={pet.game_source.asset_key}
                                x={position.x}
                                y={position.y}
                            />
                        );
                    })}
                </div>
            </div>

            <div className="grid gap-3 md:grid-cols-2">
                {pet.evolution_family.transitions.map((transition) => (
                    <EvolutionRecipeCard
                        key={`${transition.from_pet_id}-${transition.to_pet_id}`}
                        transition={transition}
                        forms={pet.evolution_family.pets}
                    />
                ))}
            </div>
        </div>
    );
}

function EvolutionNode({
    form,
    assetKey,
    x,
    y,
}: {
    form: WikiEvolutionPet;
    assetKey: string;
    x: number;
    y: number;
}) {
    const content = (
        <>
            <div className="flex items-center gap-3">
                <GameArtwork
                    src={petArtworkUrl(form.sprite_id, assetKey)}
                    alt={form.name}
                    className="size-16 shrink-0"
                    fallback={
                        <PawPrint className="size-7 text-[var(--pet-accent)]" />
                    }
                />
                <div className="min-w-0">
                    <span className="font-mono text-[8px] font-black tracking-[.12em] text-slate-500 uppercase">
                        Form {form.stage} · #
                        {String(form.game_id).padStart(3, '0')}
                    </span>
                    <strong className="mt-1 line-clamp-2 block text-sm leading-5 text-white">
                        {form.name}
                    </strong>
                </div>
            </div>
            <div className="mt-3 flex flex-wrap gap-1.5 font-mono text-[8px] font-black uppercase">
                <span
                    className="px-2 py-1"
                    style={{
                        color: form.combat_element.color,
                        backgroundColor: `${form.combat_element.color}18`,
                    }}
                >
                    {form.combat_element.name}
                </span>
                <span className="bg-white/5 px-2 py-1 text-slate-400">
                    {form.primary_role_label}
                </span>
            </div>
        </>
    );

    return (
        <div
            className="absolute z-10 w-48 -translate-x-1/2 -translate-y-1/2"
            style={{ left: x, top: y }}
        >
            {form.is_current ? (
                <article className="border border-[var(--pet-accent)]/55 bg-[linear-gradient(145deg,color-mix(in_oklab,var(--pet-accent)_13%,#0a1724),#081522)] p-3 shadow-[0_0_24px_color-mix(in_oklab,var(--pet-accent)_20%,transparent)]">
                    {content}
                    <span className="absolute -top-2.5 left-3 bg-[var(--pet-accent)] px-2 py-1 font-mono text-[7px] font-black text-[#061018] uppercase">
                        Đang xem
                    </span>
                </article>
            ) : (
                <Link
                    href={petShow(form.id)}
                    prefetch
                    className="block border border-white/10 bg-[#0a1724]/95 p-3 shadow-lg transition hover:-translate-y-1 hover:border-[var(--pet-accent)]/45 hover:bg-[#0d2030]"
                >
                    {content}
                </Link>
            )}
        </div>
    );
}

function EvolutionMaterialLink({
    transition,
    x,
    y,
}: {
    transition: WikiEvolutionTransition;
    x: number;
    y: number;
}) {
    const rankTone = evolutionRankTone(transition.cost_rank);

    return (
        <div
            style={{ left: x, top: y }}
            title={transition.balance_notes ?? undefined}
            className={`absolute z-20 -translate-x-1/2 -translate-y-1/2 rounded-full border px-2 py-1 font-mono text-[7px] font-black whitespace-nowrap uppercase shadow-xl backdrop-blur ${rankTone}`}
        >
            {transition.required_level !== null
                ? `Cấp ${transition.required_level} · `
                : ''}
            H{transition.cost_rank} · {transition.ingredients.length} nguyên liệu
        </div>
    );
}

function EvolutionRecipeCard({
    transition,
    forms,
}: {
    transition: WikiEvolutionTransition;
    forms: WikiEvolutionPet[];
}) {
    const source = forms.find((form) => form.id === transition.from_pet_id);
    const target = forms.find((form) => form.id === transition.to_pet_id);
    const rankTone = evolutionRankTone(transition.cost_rank);

    return (
        <article className="border border-white/8 bg-[#07111c]/82 p-3">
            <div className="flex flex-wrap items-center justify-between gap-2">
                <div className="min-w-0">
                    <span className="font-mono text-[8px] font-black tracking-[.1em] text-slate-500 uppercase">
                        {transition.type === 'mutation'
                            ? 'Nhánh đột biến'
                            : 'Nhánh tiến hóa'}
                    </span>
                    <strong className="mt-1 block truncate text-xs text-white">
                        {source?.name ?? 'Pet nguồn'} →{' '}
                        {target?.name ?? 'Pet đích'}
                    </strong>
                </div>
                <span
                    className={`rounded-full border px-2 py-1 font-mono text-[8px] font-black uppercase ${rankTone}`}
                    title={transition.balance_notes ?? undefined}
                >
                    H{transition.cost_rank} · {transition.cost_rank_label}
                </span>
            </div>

            {transition.required_level !== null && (
                <p className="mt-2 font-mono text-[8px] font-black text-cyan-200 uppercase">
                    Yêu cầu cấp {transition.required_level}
                </p>
            )}

            <div className="mt-3 grid gap-1.5 sm:grid-cols-2">
                {transition.ingredients.map((ingredient) => (
                    <Link
                        key={`${ingredient.item.id}-${ingredient.role}`}
                        href={itemShow(ingredient.item.id)}
                        prefetch
                        className="group flex min-w-0 items-center gap-2 border border-white/7 bg-white/3 p-2 transition hover:border-[var(--pet-accent)]/45 hover:bg-[var(--pet-accent)]/8"
                    >
                        <GameArtwork
                            src={itemArtworkUrl(
                                ingredient.item.frame_id,
                                ingredient.item.game_source.asset_key,
                            )}
                            alt={ingredient.item.name}
                            className="size-9 shrink-0"
                            fallback={
                                <Sparkles className="size-4 text-[var(--pet-accent)]" />
                            }
                        />
                        <span className="min-w-0 flex-1">
                            <strong className="block truncate text-[9px] text-white">
                                {ingredient.item.name}
                            </strong>
                            <span className="block truncate font-mono text-[7px] font-bold text-slate-500">
                                {ingredient.role_label}
                            </span>
                        </span>
                        <strong className="font-mono text-[10px] text-amber-200">
                            ×{ingredient.quantity}
                        </strong>
                    </Link>
                ))}
            </div>

            {transition.balance_notes !== null && (
                <p className="mt-3 border-t border-white/7 pt-2 text-[10px] leading-5 text-slate-500">
                    {transition.balance_notes}
                </p>
            )}
        </article>
    );
}

function MutationRecipeCard({ pet }: { pet: WikiPetDetail }) {
    const recipe = pet.mutation_recipe;

    if (recipe === null) {
        return null;
    }

    return (
        <article className="mt-3 overflow-hidden border border-fuchsia-300/20 bg-[linear-gradient(135deg,rgba(217,70,239,.09),rgba(7,17,28,.92))] p-4">
            <div className="flex flex-wrap items-start justify-between gap-3">
                <div>
                    <span className="font-mono text-[8px] font-black tracking-[.12em] text-fuchsia-200 uppercase">
                        Công thức dị hóa riêng
                    </span>
                    <h3 className="mt-1 flex items-center gap-2 text-sm font-black text-white">
                        <Dna className="size-4 text-fuchsia-200" /> Biến thể dị hóa{' '}
                        {pet.name}
                    </h3>
                </div>
                <span className="border border-fuchsia-300/25 bg-fuchsia-300/8 px-2.5 py-1 font-mono text-[8px] font-black text-fuchsia-100 uppercase">
                    Cùng Pet ID · đổi biến thể
                </span>
            </div>

            <div className="mt-3 grid gap-2 sm:grid-cols-2 lg:grid-cols-3">
                {recipe.ingredients.map((ingredient) => (
                    <Link
                        key={`${ingredient.item.id}-${ingredient.role}`}
                        href={itemShow(ingredient.item.id)}
                        prefetch
                        className="group flex min-w-0 items-center gap-2 border border-white/8 bg-black/16 p-2.5 transition hover:border-fuchsia-300/35 hover:bg-fuchsia-300/7"
                    >
                        <GameArtwork
                            src={itemArtworkUrl(
                                ingredient.item.frame_id,
                                ingredient.item.game_source.asset_key,
                            )}
                            alt={ingredient.item.name}
                            className="size-10 shrink-0"
                            fallback={
                                <Sparkles className="size-4 text-fuchsia-200" />
                            }
                        />
                        <span className="min-w-0 flex-1">
                            <strong className="block truncate text-[10px] text-white">
                                {ingredient.item.name}
                            </strong>
                            <span className="block truncate font-mono text-[7px] font-bold text-slate-500">
                                {ingredient.role_label}
                            </span>
                        </span>
                        <strong className="font-mono text-[10px] text-fuchsia-100">
                            ×{ingredient.quantity}
                        </strong>
                    </Link>
                ))}
            </div>

            {recipe.notes !== null && (
                <p className="mt-3 border-t border-fuchsia-300/12 pt-3 text-[10px] leading-5 text-slate-400">
                    {recipe.notes}
                </p>
            )}
        </article>
    );
}

function evolutionRankTone(rank: number): string {
    if (rank >= 5) {
        return 'border-amber-300/35 bg-amber-300/10 text-amber-200';
    }

    if (rank === 4) {
        return 'border-violet-300/35 bg-violet-300/10 text-violet-200';
    }

    if (rank === 3) {
        return 'border-cyan-300/35 bg-cyan-300/10 text-cyan-200';
    }

    return 'border-white/12 bg-white/5 text-slate-400';
}

function SkillSandbox({
    pet,
    equippedSkills,
    buildAnalysis,
    onRemoveSkill,
    onClear,
}: {
    pet: WikiPetDetail;
    equippedSkills: WikiPetSkill[];
    buildAnalysis: ReturnType<typeof analyzeBuild>;
    onRemoveSkill: (skill: WikiPetSkill) => void;
    onClear: () => void;
}) {
    return (
        <div className="border border-[var(--pet-accent)]/20 bg-[linear-gradient(135deg,color-mix(in_oklab,var(--pet-accent)_7%,#07111c),#07111c)] p-4 sm:p-5">
            <div className="flex flex-wrap items-center justify-between gap-3">
                <div>
                    <p className="font-mono text-[9px] font-black tracking-[.16em] text-[var(--pet-accent)] uppercase">
                        Thử nghiệm 5 ô kỹ năng
                    </p>
                    <h3 className="mt-1 text-lg font-black text-white">
                        Build đang thử nghiệm
                    </h3>
                </div>
                <button
                    type="button"
                    onClick={onClear}
                    disabled={equippedSkills.length === 0}
                    className="flex items-center gap-2 rounded-lg border border-white/10 px-3 py-2 text-xs font-black text-slate-400 transition hover:border-rose-300/30 hover:text-rose-200 disabled:cursor-not-allowed disabled:opacity-35"
                >
                    <Trash2 className="size-3.5" /> Xóa Build
                </button>
            </div>

            <div className="mt-4 grid grid-cols-2 gap-2 sm:grid-cols-5">
                {Array.from({ length: pet.equipped_skill_limit }).map(
                    (_, index) => {
                        const skill = equippedSkills[index];

                        return (
                            <div
                                key={index}
                                className={`relative flex min-h-28 flex-col items-center justify-center border p-2 text-center ${skill ? 'border-[var(--pet-accent)]/35 bg-[var(--pet-accent)]/8' : 'border-dashed border-white/12 bg-black/12'}`}
                            >
                                <span className="absolute top-1.5 left-2 font-mono text-[7px] font-black text-slate-600">
                                    SLOT {index + 1}
                                </span>
                                {skill ? (
                                    <>
                                        <img
                                            src={skillArtworkUrl(
                                                skill.game_id,
                                                skill.game_source.asset_key,
                                            )}
                                            alt=""
                                            className="wiki-pixel-art size-10 object-contain"
                                        />
                                        <strong className="mt-1 line-clamp-2 text-[10px] leading-4 text-white">
                                            {skill.name}
                                        </strong>
                                        <button
                                            type="button"
                                            onClick={() => onRemoveSkill(skill)}
                                            aria-label={`Gỡ ${skill.name}`}
                                            className="absolute top-1 right-1 flex size-5 items-center justify-center text-slate-600 transition hover:text-rose-300"
                                        >
                                            <X className="size-3" />
                                        </button>
                                    </>
                                ) : (
                                    <>
                                        <Plus className="size-5 text-slate-700" />
                                        <span className="mt-2 text-[9px] font-bold text-slate-600">
                                            Chọn Skill
                                        </span>
                                    </>
                                )}
                            </div>
                        );
                    },
                )}
            </div>

            <div className="mt-4 grid gap-px overflow-hidden border border-white/8 bg-white/8 sm:grid-cols-3">
                <BuildMetric
                    label="Tổng PP"
                    value={String(buildAnalysis.totalPp)}
                />
                <BuildMetric
                    label="Phủ hệ"
                    value={
                        buildAnalysis.coverage.length > 0
                            ? buildAnalysis.coverage.join(' · ')
                            : 'Chưa có'
                    }
                />
                <BuildMetric
                    label="Gợi ý chiến thuật"
                    value={buildAnalysis.recommendation}
                />
            </div>
        </div>
    );
}

function BuildMetric({ label, value }: { label: string; value: string }) {
    return (
        <div className="bg-[#091827] px-4 py-3">
            <span className="font-mono text-[8px] font-black tracking-[.12em] text-slate-600 uppercase">
                {label}
            </span>
            <strong className="mt-1 block text-xs leading-5 text-slate-200">
                {value}
            </strong>
        </div>
    );
}

function SkillDeckTabs({
    activeTab,
    onTabChange,
    counts,
}: {
    activeTab: SkillDeckTab;
    onTabChange: (tab: SkillDeckTab) => void;
    counts: Record<SkillDeckTab, number>;
}) {
    const tabs: { key: SkillDeckTab; label: string }[] = [
        { key: 'ready', label: 'Đã mở ở form hiện tại' },
        { key: 'locked', label: 'Chưa đạt điều kiện' },
        { key: 'alternate', label: 'Nhánh đột biến khác' },
    ];

    return (
        <div className="mt-5 flex [scrollbar-width:none] gap-2 overflow-x-auto border-b border-white/8 pb-2 [&::-webkit-scrollbar]:hidden">
            {tabs.map((tab) => (
                <button
                    key={tab.key}
                    type="button"
                    onClick={() => onTabChange(tab.key)}
                    className={`flex shrink-0 items-center gap-2 border px-3 py-2 text-xs font-black transition ${activeTab === tab.key ? 'border-[var(--pet-accent)]/45 bg-[var(--pet-accent)]/10 text-[var(--pet-accent)]' : 'border-transparent text-slate-500 hover:border-white/10 hover:text-slate-300'}`}
                >
                    {tab.label}
                    <span className="rounded-full bg-black/25 px-2 py-0.5 font-mono text-[8px]">
                        {counts[tab.key]}
                    </span>
                </button>
            ))}
        </div>
    );
}

function SkillDeckCard({
    skill,
    isEquipped,
    canEquip,
    isBuildFull,
    onToggle,
}: {
    skill: WikiPetSkill;
    isEquipped: boolean;
    canEquip: boolean;
    isBuildFull: boolean;
    onToggle: () => void;
}) {
    const sourceLabel =
        skill.source_type === 'species'
            ? `Chủng ${skill.species_affinity?.name ?? ''}`
            : skill.source_type === 'element'
              ? `Hệ ${skill.element?.name ?? ''}`
              : 'Kỹ năng chung';
    const lockLabel = skill.is_alternate_branch
        ? 'Chỉ nhánh khác'
        : skill.is_evolution_locked
          ? `Cần ${skill.grant_pet.name}`
          : `Cần cấp ${skill.unlock_level}`;

    return (
        <article
            className={`group relative overflow-hidden border p-4 ${canEquip ? 'border-white/9 bg-[#091827]' : 'border-white/6 bg-[#07111c] opacity-65'} ${isEquipped ? 'ring-1 ring-[var(--pet-accent)]/70' : ''}`}
        >
            <img
                src={skillArtworkUrl(
                    skill.game_id,
                    skill.game_source.asset_key,
                )}
                alt=""
                className="wiki-pixel-art absolute -right-5 -bottom-4 size-24 object-contain opacity-5"
            />
            <div className="relative flex gap-3">
                <span className="flex size-12 shrink-0 items-center justify-center bg-[var(--pet-accent)]/9">
                    {skill.element ? (
                        <img
                            src={elementIconUrl(skill.element.game_id)}
                            alt=""
                            className="wiki-pixel-art size-8 object-contain"
                        />
                    ) : (
                        <WandSparkles className="size-6 text-[var(--pet-accent)]" />
                    )}
                </span>
                <div className="min-w-0 flex-1">
                    <div className="flex items-start justify-between gap-2">
                        <Link
                            href={skillShow(skill.id)}
                            prefetch
                            className="font-black text-white transition hover:text-[var(--pet-accent)]"
                        >
                            {skill.name}
                        </Link>
                        <ChevronRight className="size-4 shrink-0 text-slate-700" />
                    </div>
                    <p className="mt-1 line-clamp-2 text-xs leading-5 text-slate-500">
                        {skill.description}
                    </p>
                </div>
            </div>

            <div className="relative mt-3 flex flex-wrap gap-1.5 text-[9px] font-black">
                <span className="bg-[var(--pet-accent)]/9 px-2 py-1 text-[var(--pet-accent)]">
                    {sourceLabel}
                </span>
                <span className="bg-white/5 px-2 py-1 text-slate-400">
                    {skill.combat_category_label}
                </span>
                <span className="bg-sky-300/8 px-2 py-1 text-sky-200">
                    PP {skill.max_uses}
                </span>
                <span className="bg-white/5 px-2 py-1 text-slate-400">
                    {skill.power_percent > 0
                        ? `Uy lực ${skill.power_percent}%`
                        : 'Trạng thái'}
                </span>
                {skill.is_signature && (
                    <span className="bg-fuchsia-300/9 px-2 py-1 text-fuchsia-200">
                        Đặc trưng
                    </span>
                )}
            </div>

            <div className="relative mt-3 flex items-center justify-between gap-3 border-t border-white/7 pt-3">
                <span className="text-[10px] font-bold text-slate-500">
                    {skill.target_label}
                </span>
                <button
                    type="button"
                    onClick={onToggle}
                    disabled={!canEquip || (!isEquipped && isBuildFull)}
                    className={`flex items-center gap-1.5 rounded-lg px-2.5 py-1.5 text-[10px] font-black transition ${isEquipped ? 'bg-rose-300/10 text-rose-200 hover:bg-rose-300/15' : canEquip ? 'bg-[var(--pet-accent)]/12 text-[var(--pet-accent)] hover:bg-[var(--pet-accent)]/20' : 'cursor-not-allowed bg-white/4 text-slate-600'}`}
                >
                    {isEquipped ? (
                        <>
                            <X className="size-3" /> Gỡ
                        </>
                    ) : canEquip ? (
                        <>
                            <Plus className="size-3" /> Trang bị
                        </>
                    ) : (
                        <>
                            <LockKeyhole className="size-3" /> {lockLabel}
                        </>
                    )}
                </button>
            </div>

            {skill.effect && (
                <div className="relative mt-3 flex items-center gap-2 border-t border-white/7 pt-3">
                    <GameArtwork
                        src={effectIconUrl(
                            skill.effect.kind,
                            skill.effect.game_id,
                            skill.effect.source_table,
                        )}
                        alt={skill.effect.name}
                        className="size-7"
                        fallback={
                            <Sparkles className="size-4 text-[var(--pet-accent)]" />
                        }
                    />
                    <span className="text-[10px] font-black text-slate-400">
                        {skill.effect.name}
                    </span>
                </div>
            )}
        </article>
    );
}

function TacticalSidebar({
    pet,
    level,
    star,
    starMultiplier,
    onOpenTraits,
    onOpenComparison,
}: {
    pet: WikiPetDetail;
    level: number;
    star: number;
    starMultiplier: number;
    onOpenTraits: () => void;
    onOpenComparison: () => void;
}) {
    return (
        <aside
            id="traits"
            className="flex scroll-mt-36 flex-col gap-4 xl:sticky xl:top-36"
        >
            <section className="relative overflow-hidden rounded-[1.7rem] border border-[var(--pet-accent)]/20 bg-[linear-gradient(145deg,color-mix(in_oklab,var(--pet-accent)_8%,#081522),#081522)] p-5">
                <div className="absolute -top-24 -right-20 size-52 rounded-full bg-[var(--pet-accent)]/12 blur-3xl" />
                <div className="relative">
                    <p className="font-mono text-[9px] font-black tracking-[.16em] text-[var(--pet-accent)] uppercase">
                        Hồ sơ chiến thuật
                    </p>
                    <h2 className="mt-1 text-xl font-black text-white">
                        Định hướng chiến đấu
                    </h2>
                    <div className="mt-4 grid gap-px overflow-hidden border border-white/8 bg-white/8">
                        <SidebarFact
                            label="Vai trò chiến thuật"
                            value={pet.primary_role_label}
                        />
                        <SidebarFact
                            label="Hướng phụ"
                            value={pet.secondary_role_label}
                        />
                        <SidebarFact
                            label="Bể đã mở"
                            value={`${pet.skills.filter((skill) => skill.is_available_on_current_form && skill.unlock_level <= level).length} Skill tại cấp ${level}`}
                        />
                        <SidebarFact
                            label="Sao đang mô phỏng"
                            value={`${star}★ · ${starMultiplier}% chỉ số chuẩn`}
                        />
                    </div>
                </div>
            </section>

            <section className="rounded-[1.7rem] border border-violet-300/15 bg-[#0a1726] p-5">
                <div className="flex items-start justify-between gap-3">
                    <div>
                        <p className="font-mono text-[9px] font-black tracking-[.16em] text-violet-300 uppercase">
                            Đặc tính chủng
                        </p>
                        <h2 className="mt-1 text-xl font-black text-white">
                            Đặc tính Chủng
                        </h2>
                    </div>
                    <TraitBadge
                        trait={pet.species_trait}
                        color={pet.species.color}
                    />
                </div>
                <h3 className="mt-5 text-lg font-black text-white">
                    {pet.species_trait.name}
                </h3>
                <p className="mt-2 text-sm leading-6 text-slate-400">
                    {pet.species_trait.description}
                </p>
                <div className="mt-4 flex items-start gap-2 border-l-2 border-violet-300/40 bg-violet-300/5 p-3">
                    <ShieldCheck className="mt-0.5 size-4 shrink-0 text-violet-200" />
                    <p className="text-xs leading-5 text-slate-500">
                        Cố định theo Chủng và được giữ khi tiến hóa cùng cấu
                        hình.
                    </p>
                </div>
            </section>

            <button
                type="button"
                onClick={onOpenTraits}
                className="group flex items-center justify-between gap-3 rounded-2xl border border-white/9 bg-[#081522] p-4 text-left transition hover:border-violet-300/30"
            >
                <span className="flex items-center gap-3">
                    <span className="flex size-10 items-center justify-center bg-violet-300/9 text-violet-200">
                        <Dna className="size-5" />
                    </span>
                    <span>
                        <strong className="block text-sm text-white">
                            19 Tư chất ngẫu nhiên
                        </strong>
                        <span className="mt-1 block text-xs text-slate-500">
                            Xem danh sách và tác động chiến đấu
                        </span>
                    </span>
                </span>
                <ChevronRight className="size-4 text-slate-600 transition group-hover:translate-x-1 group-hover:text-violet-200" />
            </button>

            <button
                type="button"
                onClick={onOpenComparison}
                className="group flex items-center justify-between gap-3 rounded-2xl border border-white/9 bg-[#081522] p-4 text-left transition hover:border-[var(--pet-accent)]/30"
            >
                <span className="flex items-center gap-3">
                    <span className="flex size-10 items-center justify-center bg-[var(--pet-accent)]/9 text-[var(--pet-accent)]">
                        <GitCompareArrows className="size-5" />
                    </span>
                    <span>
                        <strong className="block text-sm text-white">
                            So sánh {pet.evolution_family.pets.length} form
                        </strong>
                        <span className="mt-1 block text-xs text-slate-500">
                            Chỉ số, hệ và vai trò trong cùng dòng
                        </span>
                    </span>
                </span>
                <ChevronRight className="size-4 text-slate-600 transition group-hover:translate-x-1 group-hover:text-[var(--pet-accent)]" />
            </button>

            <details className="group rounded-2xl border border-white/9 bg-[#081522] p-4">
                <summary className="flex cursor-pointer list-none items-center justify-between gap-3 text-sm font-black text-slate-300 marker:hidden">
                    <span className="flex items-center gap-2">
                        <Layers3 className="size-4 text-[var(--pet-accent)]" />
                        Dữ liệu dành cho modder
                    </span>
                    <Plus className="size-4 transition group-open:rotate-45" />
                </summary>
                <dl className="mt-4 grid gap-2 border-t border-white/7 pt-4 text-xs">
                    <SidebarFact label="Sprite ID" value={pet.sprite_id} />
                    <SidebarFact
                        label="Variant code"
                        value={pet.variant_code}
                    />
                    <SidebarFact
                        label="Growth code"
                        value={pet.rarity_or_growth_code}
                    />
                </dl>
                <pre className="mt-3 max-h-60 overflow-auto bg-black/20 p-3 text-[10px] leading-5 text-slate-600">
                    {JSON.stringify(pet.raw_values, null, 2)}
                </pre>
            </details>
        </aside>
    );
}

function SidebarFact({
    label,
    value,
}: {
    label: string;
    value: string | number;
}) {
    return (
        <div className="flex items-center justify-between gap-3 bg-[#091827] px-3 py-2.5">
            <dt className="text-xs font-bold text-slate-500">{label}</dt>
            <dd className="text-right text-xs font-black text-slate-200">
                {value}
            </dd>
        </div>
    );
}

function FormComparisonModal({
    pet,
    level,
    starMultiplier,
    onClose,
}: {
    pet: WikiPetDetail;
    level: number;
    starMultiplier: number;
    onClose: () => void;
}) {
    return (
        <ModalShell
            title={`So sánh Form · Cấp ${level}`}
            onClose={onClose}
            size="max-w-6xl"
        >
            <div className="overflow-x-auto">
                <table className="w-full min-w-220 border-collapse text-left">
                    <thead>
                        <tr className="border-b border-white/10 bg-white/3">
                            <th className="p-4 font-mono text-[9px] tracking-[.14em] text-slate-500 uppercase">
                                Form
                            </th>
                            {pet.evolution_family.pets.map((form) => (
                                <th key={form.id} className="p-4 align-top">
                                    <div className="flex items-center gap-3">
                                        <GameArtwork
                                            src={petArtworkUrl(
                                                form.sprite_id,
                                                pet.game_source.asset_key,
                                            )}
                                            alt={form.name}
                                            className="size-14"
                                            fallback={
                                                <PawPrint className="size-5 text-[var(--pet-accent)]" />
                                            }
                                        />
                                        <div>
                                            <span className="font-mono text-[8px] text-slate-600">
                                                FORM {form.stage}
                                            </span>
                                            <strong className="mt-1 block text-sm text-white">
                                                {form.name}
                                            </strong>
                                        </div>
                                    </div>
                                </th>
                            ))}
                        </tr>
                    </thead>
                    <tbody>
                        <ComparisonRow
                            label="Hệ / Chủng"
                            values={pet.evolution_family.pets.map(
                                (form) =>
                                    `${form.combat_element.name} · ${form.species.name}`,
                            )}
                        />
                        <ComparisonRow
                            label="Vai trò chiến thuật"
                            values={pet.evolution_family.pets.map(
                                (form) =>
                                    `${form.primary_role_label} / ${form.secondary_role_label}`,
                            )}
                        />
                        {statDefinitions.map((definition) => (
                            <ComparisonRow
                                key={definition.key}
                                label={`${definition.shortLabel} · ${definition.label}`}
                                values={pet.evolution_family.pets.map(
                                    (form) => {
                                        const values = calculateStatValues(
                                            form.stats,
                                            level,
                                            starMultiplier,
                                        );
                                        const formula =
                                            form.stats[definition.key];

                                        return `${values[definition.key].toLocaleString('vi-VN')} · gốc ${formula.base}`;
                                    },
                                )}
                            />
                        ))}
                        <ComparisonRow
                            label="Tổng 4 chỉ số"
                            values={pet.evolution_family.pets.map((form) => {
                                const values = calculateStatValues(
                                    form.stats,
                                    level,
                                    starMultiplier,
                                );

                                return Object.values(values)
                                    .reduce((total, value) => total + value, 0)
                                    .toLocaleString('vi-VN');
                            })}
                            emphasize
                        />
                    </tbody>
                </table>
            </div>
        </ModalShell>
    );
}

function ComparisonRow({
    label,
    values,
    emphasize = false,
}: {
    label: string;
    values: string[];
    emphasize?: boolean;
}) {
    return (
        <tr className="border-b border-white/7">
            <th className="p-4 text-xs font-black text-slate-500">{label}</th>
            {values.map((value, index) => (
                <td
                    key={`${label}-${index}`}
                    className={`p-4 text-sm ${emphasize ? 'font-black text-[var(--pet-accent)]' : 'font-semibold text-slate-300'}`}
                >
                    {value}
                </td>
            ))}
        </tr>
    );
}

function TraitCatalogModal({
    traitSystem,
    onClose,
}: {
    traitSystem: WikiPetTraitSystem;
    onClose: () => void;
}) {
    return (
        <ModalShell
            title="Bách khoa 19 Tư chất ngẫu nhiên"
            onClose={onClose}
            size="max-w-5xl"
        >
            <div className="grid max-h-[68vh] gap-3 overflow-y-auto p-5 md:grid-cols-2">
                {traitSystem.physical_traits.map((trait) => (
                    <TraitCatalogCard key={trait.code} trait={trait} />
                ))}
            </div>
        </ModalShell>
    );
}

const traitPolarityMeta: Record<
    WikiPetTraitPolarity,
    { label: string; className: string }
> = {
    neutral: {
        label: 'Trung tính',
        className: 'text-slate-300 bg-slate-300/8',
    },
    beneficial: {
        label: 'Có lợi',
        className: 'text-emerald-200 bg-emerald-300/8',
    },
    harmful: { label: 'Bất lợi', className: 'text-rose-200 bg-rose-300/8' },
    mixed: { label: 'Hỗn hợp', className: 'text-amber-200 bg-amber-300/8' },
};

function TraitCatalogCard({ trait }: { trait: WikiPetTrait }) {
    const meta = traitPolarityMeta[trait.polarity];

    return (
        <article className="border border-white/8 bg-[#091827] p-4">
            <div className="flex items-start justify-between gap-3">
                <div>
                    <span className="font-mono text-[8px] font-black text-slate-600">
                        {trait.code}
                    </span>
                    <h3 className="mt-1 font-black text-white">{trait.name}</h3>
                </div>
                <span
                    className={`px-2 py-1 text-[9px] font-black ${meta.className}`}
                >
                    {meta.label}
                </span>
            </div>
            <p className="mt-3 text-xs leading-5 text-slate-400">
                {trait.description}
            </p>
        </article>
    );
}

function ModalShell({
    title,
    onClose,
    size,
    children,
}: {
    title: string;
    onClose: () => void;
    size: string;
    children: ReactNode;
}) {
    return (
        <div
            role="dialog"
            aria-modal="true"
            aria-label={title}
            className="fixed inset-0 z-50 flex items-center justify-center bg-[#030810]/86 p-4 backdrop-blur-md"
        >
            <div
                className={`max-h-[92vh] w-full overflow-hidden border border-white/12 bg-[#07111c] shadow-[0_35px_120px_rgba(0,0,0,.65)] ${size}`}
            >
                <div className="flex items-center justify-between gap-4 border-b border-white/9 px-5 py-4">
                    <div>
                        <p className="font-mono text-[8px] font-black tracking-[.17em] text-[var(--pet-accent)] uppercase">
                            Bảng thông tin
                        </p>
                        <h2 className="mt-1 text-lg font-black text-white">
                            {title}
                        </h2>
                    </div>
                    <button
                        type="button"
                        onClick={onClose}
                        aria-label="Đóng"
                        className="flex size-10 items-center justify-center border border-white/10 text-slate-400 transition hover:border-rose-300/35 hover:text-rose-200"
                    >
                        <X className="size-5" />
                    </button>
                </div>
                {children}
            </div>
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

function calculateStatValues(
    stats: WikiPetDetail['stats'],
    level: number,
    qualityMultiplier: number,
): WikiPetStatValues {
    return {
        hp: calculateStat(stats.hp, level, qualityMultiplier),
        strength: calculateStat(stats.strength, level, qualityMultiplier),
        defense: calculateStat(stats.defense, level, qualityMultiplier),
        agility: calculateStat(stats.agility, level, qualityMultiplier),
    };
}

function interpolateBenchmarks(
    pet: WikiPetDetail,
    level: number,
    starMultiplier: number,
): WikiPetStatValues {
    const progress = (level - 1) / 49;

    return Object.fromEntries(
        statDefinitions.map(({ key }) => [
            key,
            Math.trunc(
                ((pet.stat_benchmarks.level_one[key] +
                    (pet.stat_benchmarks.level_fifty[key] -
                        pet.stat_benchmarks.level_one[key]) *
                        progress) *
                    starMultiplier) /
                    100,
            ),
        ]),
    ) as WikiPetStatValues;
}

function radarCoordinate(
    index: number,
    centerX: number,
    centerY: number,
    radius: number,
): { x: number; y: number } {
    const angle = -Math.PI / 2 + (Math.PI * 2 * index) / statDefinitions.length;

    return {
        x: centerX + Math.cos(angle) * radius,
        y: centerY + Math.sin(angle) * radius,
    };
}

function radarPoints(
    values: WikiPetStatValues,
    maxValues: Record<keyof WikiPetStatValues, number>,
    centerX: number,
    centerY: number,
    radius: number,
): string {
    return statDefinitions
        .map(({ key }, index) => {
            const point = radarCoordinate(
                index,
                centerX,
                centerY,
                radius * (values[key] / maxValues[key]),
            );

            return `${point.x},${point.y}`;
        })
        .join(' ');
}

function buildEvolutionTreeLayout(forms: WikiEvolutionPet[]): {
    width: number;
    height: number;
    positions: Map<number, { x: number; y: number }>;
} {
    const maximumStage = Math.max(...forms.map((form) => form.stage), 1);
    const groupedForms = new Map<number, WikiEvolutionPet[]>();

    forms.forEach((form) => {
        groupedForms.set(form.stage, [
            ...(groupedForms.get(form.stage) ?? []),
            form,
        ]);
    });

    const maximumFormsPerStage = Math.max(
        ...Array.from(groupedForms.values()).map(
            (stageForms) => stageForms.length,
        ),
        1,
    );
    const width = maximumStage === 1 ? 320 : Math.max(760, maximumStage * 270);
    const height = Math.max(330, maximumFormsPerStage * 180 + 80);
    const positions = new Map<number, { x: number; y: number }>();

    groupedForms.forEach((stageForms, stage) => {
        const x =
            maximumStage === 1
                ? width / 2
                : 120 + ((stage - 1) * (width - 240)) / (maximumStage - 1);

        stageForms.forEach((form, index) => {
            const y =
                stageForms.length === 1
                    ? height / 2
                    : 90 + (index * (height - 180)) / (stageForms.length - 1);
            positions.set(form.id, { x, y });
        });
    });

    return { width, height, positions };
}

function analyzeBuild(skills: WikiPetSkill[]): {
    totalPp: number;
    coverage: string[];
    recommendation: string;
} {
    const categories = new Set(skills.map((skill) => skill.combat_category));
    const coverage = Array.from(
        new Set(skills.map((skill) => skill.element?.name ?? 'Chung')),
    );
    const recommendation =
        skills.length === 0
            ? 'Chọn Skill để phân tích'
            : categories.has('heal') && categories.has('defense')
              ? 'Sustain · hồi phục và bảo vệ'
              : categories.has('control') && categories.has('damage')
                ? 'Lockdown · khóa rồi dồn sát thương'
                : categories.has('buff') &&
                    (categories.has('damage') || categories.has('hybrid'))
                  ? 'Setup burst · cường hóa trước khi đánh'
                  : coverage.length >= 3
                    ? 'Coverage · phủ nhiều hệ phản công'
                    : categories.has('control') || categories.has('disrupt')
                      ? 'Disruption · kiểm soát nhịp trận'
                      : 'Cân bằng · chưa hình thành combo rõ';

    return {
        totalPp: skills.reduce((total, skill) => total + skill.max_uses, 0),
        coverage,
        recommendation,
    };
}

const divineParameterLabels: Record<string, string> = {
    heal_percent: 'Hồi HP',
    damage_percent: 'Sát thương tăng thêm',
    duration: 'Thời hạn hiệu lực',
    uses: 'Giới hạn kích hoạt',
    maximum_charges: 'Tích tầng tối đa',
    damage_percent_per_charge: 'Sát thương mỗi tầng',
    heal_percent_per_charge: 'Hồi HP mỗi tầng',
    first_hit_reduction_percent: 'Giảm sát thương đòn đầu',
    hits_required: 'Số đòn cần chịu',
    counter_damage_percent: 'Sát thương phản công',
    defense_pierce_percent: 'Xuyên Phòng ngự',
    trigger_hp_percent: 'Ngưỡng HP kích hoạt',
    next_hit_reduction_percent: 'Giảm sát thương đòn kế',
    counter_heal_percent: 'Hồi HP khi phản công',
    cooldown: 'Hồi chiêu',
    mark_duration: 'Thời hạn dấu ấn',
    status_chance_bonus: 'Tăng xác suất hiệu ứng',
    critical_hp_percent: 'Ngưỡng HP nguy cấp',
    critical_damage_percent: 'Sát thương ở ngưỡng nguy cấp',
    reduction_percent: 'Giảm sát thương nhận',
    agility_percent: 'Tăng Linh xảo',
    next_damage_percent: 'Sát thương đòn kế',
    duration_bonus: 'Tăng thời hạn debuff',
    target_hp_percent: 'Ngưỡng HP mục tiêu',
    failure_cooldown: 'Khóa sau khi thất bại',
    cleanse_at_charges: 'Thanh tẩy khi đạt',
    attacks_required: 'Chu kỳ kích hoạt',
    current_hp_damage_percent: 'Sát thương theo HP hiện tại',
    maximum_actor_hp_percent: 'Giới hạn theo HP tối đa',
    fate_duration: 'Thời hạn Thiên Mệnh',
    damage_charge_cost: 'Tầng dùng cường hóa sát thương',
    debuff_charge_cost: 'Tầng dùng kéo dài debuff',
    pp_restore: 'PP hồi phục',
};

function divineParameterLabel(parameter: string): string {
    return divineParameterLabels[parameter] ?? parameter.replaceAll('_', ' ');
}

function formatDivineParameterValue(
    parameter: string,
    value: number | string,
): string {
    if (typeof value !== 'number') {
        return value;
    }

    if (parameter.includes('percent')) {
        return `${value}%`;
    }

    if (
        parameter === 'duration' ||
        parameter.includes('duration') ||
        parameter.includes('cooldown')
    ) {
        return `${value} hiệp`;
    }

    if (parameter === 'uses') {
        return `${value} lần / trận`;
    }

    if (parameter === 'pp_restore') {
        return `+${value} PP`;
    }

    if (parameter.includes('charge')) {
        return `${value} tầng`;
    }

    if (parameter.includes('hit') || parameter.includes('attack')) {
        return `${value} đòn`;
    }

    return String(value);
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
