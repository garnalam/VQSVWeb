import { Head, Link } from '@inertiajs/react';
import {
    ArrowLeft,
    ArrowRight,
    BarChart3,
    Check,
    ChevronRight,
    Crosshair,
    Database,
    Dna,
    GitBranch,
    HeartHandshake,
    Layers3,
    LockKeyhole,
    MonitorPlay,
    Pin,
    Plus,
    Scale,
    ShieldCheck,
    Sparkles,
    Swords,
    Target,
    X,
    Zap,
} from 'lucide-react';
import type { CSSProperties, ReactNode } from 'react';
import { useEffect, useMemo, useState } from 'react';
import { toast } from 'sonner';
import { EffectBadge, EffectIcon } from '@/components/wiki/effect-badge';
import { ElementBadge } from '@/components/wiki/element-badge';
import { GameArtwork } from '@/components/wiki/game-artwork';
import { SkillBattlePreview } from '@/components/wiki/skill-battle-preview';
import { SkillSigil } from '@/components/wiki/skill-sigil';
import { petArtworkUrl } from '@/lib/game-assets';
import { cn } from '@/lib/utils';
import { show as petShow } from '@/routes/wiki/pets';
import { index as skillsIndex, show as skillShow } from '@/routes/wiki/skills';
import type {
    WikiSkillDetail,
    WikiSkillLearnsetPet,
    WikiSkillSynergyEntry,
} from '@/types';

type SkillShowProps = {
    skill: WikiSkillDetail;
};

type BuildableSkill = Pick<
    WikiSkillSynergyEntry,
    'id' | 'name' | 'power_percent' | 'tier' | 'max_uses' | 'element' | 'effect'
>;

type Matchup = 'advantage' | 'neutral' | 'disadvantage';

const PINNED_SKILL_STORAGE_KEY = 'vqsv-wiki:pinned-skills';
const BUILD_SKILL_STORAGE_KEY = 'vqsv-wiki:skill-build';

const quickNavigation = [
    { href: '#battle-preview', icon: MonitorPlay, label: 'Demo chiến đấu' },
    { href: '#analysis', icon: Swords, label: 'Phân tích & Hiệu ứng' },
    { href: '#learnset', icon: GitBranch, label: 'Sơ đồ Pet học được' },
    { href: '#synergy', icon: Sparkles, label: 'Combo & Đội hình' },
    { href: '#simulator', icon: BarChart3, label: 'Mô phỏng sát thương' },
];

export default function SkillShow({ skill }: SkillShowProps) {
    const accent = skill.element.color ?? '#00e5ff';
    const style = { '--skill-accent': accent } as CSSProperties;
    const [learnLevel, setLearnLevel] = useState(50);
    const [strength, setStrength] = useState(700);
    const [defense, setDefense] = useState(320);
    const [matchup, setMatchup] = useState<Matchup>('neutral');
    const [pinnedSkillIds, setPinnedSkillIds] = useState<number[]>([]);
    const [buildSkillIds, setBuildSkillIds] = useState<number[]>([]);
    const [comparisonPickerOpen, setComparisonPickerOpen] = useState(false);
    const [comparisonSkill, setComparisonSkill] =
        useState<WikiSkillSynergyEntry | null>(null);

    const currentBuildSkill = useMemo<BuildableSkill>(
        () => ({
            id: skill.id,
            name: skill.name,
            power_percent: skill.power_percent,
            tier: skill.tier,
            max_uses: skill.max_uses,
            element: skill.element,
            effect: skill.effect,
        }),
        [skill],
    );
    const buildCandidates = useMemo(
        () =>
            uniqueSkills([
                currentBuildSkill,
                ...skill.related_skills,
                ...skill.synergies.setup_skills,
                ...skill.synergies.finisher_skills,
            ]),
        [currentBuildSkill, skill],
    );
    const activeBuildSkills = buildSkillIds
        .map((skillId) =>
            buildCandidates.find((candidate) => candidate.id === skillId),
        )
        .filter(
            (candidate): candidate is BuildableSkill => candidate !== undefined,
        );
    const powerMultiplier = skill.power_percent / 100;
    const elementMultiplier = skill.simulator.element_multipliers[matchup];
    const estimatedDamage = Math.max(
        1,
        (strength - defense) * powerMultiplier * elementMultiplier,
    );
    const damageMinimum =
        skill.power_percent === 0
            ? 0
            : Math.max(
                  1,
                  Math.floor(
                      estimatedDamage * skill.simulator.variance.minimum,
                  ),
              );
    const damageMaximum =
        skill.power_percent === 0
            ? 0
            : Math.max(
                  1,
                  Math.ceil(estimatedDamage * skill.simulator.variance.maximum),
              );

    useEffect(() => {
        const storageFrame = window.requestAnimationFrame(() => {
            setPinnedSkillIds(readStoredIds(PINNED_SKILL_STORAGE_KEY));
            setBuildSkillIds(readStoredIds(BUILD_SKILL_STORAGE_KEY));
        });

        return () => window.cancelAnimationFrame(storageFrame);
    }, []);

    function togglePinnedSkill() {
        const nextIds = pinnedSkillIds.includes(skill.id)
            ? pinnedSkillIds.filter((skillId) => skillId !== skill.id)
            : [...pinnedSkillIds, skill.id];

        setPinnedSkillIds(nextIds);
        window.localStorage.setItem(
            PINNED_SKILL_STORAGE_KEY,
            JSON.stringify(nextIds),
        );
        toast.success(
            nextIds.includes(skill.id)
                ? `Đã ghim ${skill.name}.`
                : `Đã bỏ ghim ${skill.name}.`,
        );
    }

    function toggleBuildSkill(candidate: BuildableSkill) {
        const isEquipped = buildSkillIds.includes(candidate.id);

        if (!isEquipped && buildSkillIds.length >= 5) {
            toast.warning('Sandbox đã đủ 5 Skill.');

            return;
        }

        const nextIds = isEquipped
            ? buildSkillIds.filter((skillId) => skillId !== candidate.id)
            : [...buildSkillIds, candidate.id];

        setBuildSkillIds(nextIds);
        window.localStorage.setItem(
            BUILD_SKILL_STORAGE_KEY,
            JSON.stringify(nextIds),
        );
        toast.success(
            isEquipped
                ? `Đã tháo ${candidate.name} khỏi Build.`
                : `Đã thêm ${candidate.name} vào Build thử nghiệm.`,
        );
    }

    return (
        <div style={style} className="flex flex-col gap-4 sm:gap-5">
            <Head title={`${skill.name} · Hồ sơ kỹ năng`} />

            <Link
                href={skillsIndex()}
                className="flex w-fit items-center gap-2 font-mono text-[10px] font-black tracking-[.16em] text-slate-400 uppercase transition hover:text-[var(--skill-accent)]"
            >
                <ArrowLeft className="size-3.5" />
                Trở lại thư viện kỹ năng
            </Link>

            <SkillHero skill={skill} />

            <UtilityDock
                skill={skill}
                isPinned={pinnedSkillIds.includes(skill.id)}
                isInBuild={buildSkillIds.includes(skill.id)}
                buildCount={buildSkillIds.length}
                comparisonPickerOpen={comparisonPickerOpen}
                onToggleBuild={() => toggleBuildSkill(currentBuildSkill)}
                onTogglePin={togglePinnedSkill}
                onToggleComparison={() =>
                    setComparisonPickerOpen((isOpen) => !isOpen)
                }
            />

            {comparisonPickerOpen && (
                <ComparisonPicker
                    skills={skill.related_skills}
                    onSelect={(candidate) => {
                        setComparisonSkill(candidate);
                        setComparisonPickerOpen(false);
                    }}
                />
            )}

            {activeBuildSkills.length > 0 && (
                <BuildStrip
                    skills={activeBuildSkills}
                    onRemove={toggleBuildSkill}
                />
            )}

            <nav className="sticky top-16 z-30 [scrollbar-width:none] overflow-x-auto border border-white/9 bg-[#06111d]/94 p-1.5 shadow-2xl backdrop-blur-xl [&::-webkit-scrollbar]:hidden">
                <div className="flex min-w-max gap-1.5">
                    {quickNavigation.map((item, index) => (
                        <a
                            key={item.href}
                            href={item.href}
                            className="group flex min-h-11 items-center gap-2 border border-transparent px-3 text-xs font-black text-slate-400 transition hover:border-[var(--skill-accent)]/30 hover:bg-[var(--skill-accent)]/7 hover:text-white"
                        >
                            <span className="font-mono text-[8px] text-[var(--skill-accent)]">
                                0{index + 1}
                            </span>
                            <item.icon className="size-3.5 text-[var(--skill-accent)]" />
                            {item.label}
                        </a>
                    ))}
                </div>
            </nav>

            <SkillBattlePreview skill={skill} />

            <div className="grid items-start gap-4 xl:grid-cols-[minmax(0,1.85fr)_minmax(20rem,1fr)]">
                <main className="flex min-w-0 flex-col gap-4">
                    <AnalysisSection skill={skill} />
                    <LearnsetMatrix
                        skill={skill}
                        level={learnLevel}
                        onLevelChange={setLearnLevel}
                    />
                    <SynergySection
                        skill={skill}
                        buildSkillIds={buildSkillIds}
                        onToggleBuild={toggleBuildSkill}
                    />
                    <SimulatorSection
                        skill={skill}
                        strength={strength}
                        defense={defense}
                        matchup={matchup}
                        damageMinimum={damageMinimum}
                        damageMaximum={damageMaximum}
                        onStrengthChange={setStrength}
                        onDefenseChange={setDefense}
                        onMatchupChange={setMatchup}
                    />
                </main>

                <SkillSidebar skill={skill} />
            </div>

            {comparisonSkill !== null && (
                <ComparisonModal
                    skill={skill}
                    comparisonSkill={comparisonSkill}
                    onClose={() => setComparisonSkill(null)}
                />
            )}
        </div>
    );
}

function SkillHero({ skill }: { skill: WikiSkillDetail }) {
    const isStatusSkill = skill.power_percent === 0;

    return (
        <section className="wiki-console relative isolate overflow-hidden border border-[var(--skill-accent)]/35 bg-[#081522]/95 [clip-path:polygon(0_18px,18px_0,calc(100%_-_52px)_0,calc(100%_-_34px)_18px,100%_18px,100%_calc(100%_-_18px),calc(100%_-_18px)_100%,18px_100%,0_calc(100%_-_18px))]">
            <div className="absolute inset-x-0 top-0 h-[3px] bg-linear-to-r from-[var(--skill-accent)] via-fuchsia-400 to-transparent shadow-[0_0_20px_var(--skill-accent)]" />
            <div className="wiki-grid absolute inset-0 -z-10 opacity-25" />
            <div className="absolute inset-0 -z-10 bg-[radial-gradient(circle_at_74%_42%,color-mix(in_oklab,var(--skill-accent)_24%,transparent),transparent_26rem)]" />

            <div className="grid lg:grid-cols-[minmax(0,1fr)_18rem]">
                <div className="px-6 py-8 sm:px-10 sm:py-10">
                    <div className="flex flex-wrap items-center gap-2">
                        <span className="bg-[var(--skill-accent)] px-3 py-1 font-mono text-[9px] font-black tracking-[.15em] text-[#07111e] [clip-path:polygon(0_0,calc(100%_-_7px)_0,100%_50%,calc(100%_-_7px)_100%,0_100%)]">
                            WIKI-SKILL-{String(skill.id).padStart(3, '0')}
                        </span>
                        <ElementBadge element={skill.element} />
                        <span className="border border-[var(--skill-accent)]/30 bg-[var(--skill-accent)]/8 px-3 py-1 font-mono text-[9px] font-black tracking-[.12em] text-[var(--skill-accent)] uppercase">
                            {skill.combat_category_label}
                        </span>
                        <span
                            className={cn(
                                'flex items-center gap-1.5 border px-3 py-1 font-mono text-[9px] font-black tracking-[.1em] uppercase',
                                skill.pool_origin.type === 'signature'
                                    ? 'border-amber-200/45 bg-amber-300/12 text-amber-200'
                                    : 'border-white/10 bg-white/4 text-slate-300',
                            )}
                        >
                            {skill.pool_origin.type === 'signature' ? (
                                <Sparkles className="size-3" />
                            ) : (
                                <Layers3 className="size-3" />
                            )}
                            {skill.pool_origin.label}: {skill.pool_origin.name}
                        </span>
                    </div>

                    <h1 className="mt-5 text-4xl leading-none font-black tracking-[-.045em] text-white sm:text-6xl">
                        {skill.name}
                    </h1>
                    <p className="mt-5 max-w-3xl border-l-2 border-[var(--skill-accent)]/55 pl-4 text-sm leading-7 text-slate-300 sm:text-base">
                        {skill.description}
                    </p>
                    <div className="mt-7 flex flex-wrap gap-2 font-mono text-[9px] font-black tracking-[.12em] uppercase">
                        <HeroFact label={`Tier ${skill.tier}`} />
                        <HeroFact label={`PP ${skill.max_uses}`} />
                        <HeroFact label={`Mục tiêu: ${skill.target_label}`} />
                        <HeroFact
                            label={
                                skill.battle_format === 'double'
                                    ? 'Ưu tiên đấu đôi'
                                    : 'Mọi thể thức'
                            }
                        />
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
                        {isStatusSkill ? 'HIỆU ỨNG' : `${skill.power_percent}%`}
                    </strong>
                    <span className="mt-1 font-mono text-[9px] tracking-[.18em] text-slate-500 uppercase">
                        {isStatusSkill
                            ? 'Kỹ năng trạng thái'
                            : 'Hệ số sát thương'}
                    </span>
                </div>
            </div>
        </section>
    );
}

function HeroFact({ label }: { label: string }) {
    return (
        <span className="border border-white/10 bg-white/4 px-3 py-2 text-slate-300">
            {label}
        </span>
    );
}

function UtilityDock({
    skill,
    isPinned,
    isInBuild,
    buildCount,
    comparisonPickerOpen,
    onToggleBuild,
    onTogglePin,
    onToggleComparison,
}: {
    skill: WikiSkillDetail;
    isPinned: boolean;
    isInBuild: boolean;
    buildCount: number;
    comparisonPickerOpen: boolean;
    onToggleBuild: () => void;
    onTogglePin: () => void;
    onToggleComparison: () => void;
}) {
    return (
        <section className="grid gap-px overflow-hidden border border-white/9 bg-white/8 sm:grid-cols-3 xl:grid-cols-[1fr_1fr_1fr_1.25fr_1.25fr]">
            <UtilityButton
                icon={isInBuild ? <Check /> : <Plus />}
                label={isInBuild ? 'Đã thêm Build' : 'Thử Build'}
                detail={`${buildCount}/5 Skill`}
                active={isInBuild}
                onClick={onToggleBuild}
            />
            <UtilityButton
                icon={<Scale />}
                label="So sánh"
                detail="Chọn Skill cùng bể"
                active={comparisonPickerOpen}
                onClick={onToggleComparison}
            />
            <UtilityButton
                icon={<Pin />}
                label={isPinned ? 'Đã ghim' : 'Ghim'}
                detail="Lưu trên trình duyệt"
                active={isPinned}
                onClick={onTogglePin}
            />
            {skill.navigation.previous === null ? (
                <UtilityPlaceholder label="Đầu bể Skill" />
            ) : (
                <Link
                    href={skillShow(skill.navigation.previous.id)}
                    prefetch
                    className="group flex min-h-18 items-center gap-3 bg-[#071421] px-4 py-3 transition hover:bg-[var(--skill-accent)]/8"
                >
                    <ArrowLeft className="size-4 text-[var(--skill-accent)]" />
                    <span className="min-w-0">
                        <span className="block text-[9px] text-slate-500">
                            Skill trước
                        </span>
                        <strong className="block truncate text-xs text-white">
                            {skill.navigation.previous.name}
                        </strong>
                    </span>
                </Link>
            )}
            {skill.navigation.next === null ? (
                <UtilityPlaceholder label="Cuối bể Skill" />
            ) : (
                <Link
                    href={skillShow(skill.navigation.next.id)}
                    prefetch
                    className="group flex min-h-18 items-center justify-between gap-3 bg-[#071421] px-4 py-3 text-right transition hover:bg-[var(--skill-accent)]/8"
                >
                    <span className="min-w-0">
                        <span className="block text-[9px] text-slate-500">
                            Skill tiếp
                        </span>
                        <strong className="block truncate text-xs text-white">
                            {skill.navigation.next.name}
                        </strong>
                    </span>
                    <ArrowRight className="size-4 text-[var(--skill-accent)]" />
                </Link>
            )}
        </section>
    );
}

function UtilityButton({
    icon,
    label,
    detail,
    active,
    onClick,
}: {
    icon: ReactNode;
    label: string;
    detail: string;
    active: boolean;
    onClick: () => void;
}) {
    return (
        <button
            type="button"
            onClick={onClick}
            aria-pressed={active}
            className={cn(
                'flex min-h-18 items-center gap-3 bg-[#071421] px-4 py-3 text-left transition [&_svg]:size-4',
                active
                    ? 'bg-[var(--skill-accent)]/12 text-[var(--skill-accent)]'
                    : 'text-slate-300 hover:bg-[var(--skill-accent)]/8 hover:text-white',
            )}
        >
            <span className="flex size-9 shrink-0 items-center justify-center border border-current/25 bg-current/5">
                {icon}
            </span>
            <span>
                <strong className="block text-xs">{label}</strong>
                <span className="mt-1 block text-[9px] text-slate-500">
                    {detail}
                </span>
            </span>
        </button>
    );
}

function UtilityPlaceholder({ label }: { label: string }) {
    return (
        <div className="flex min-h-18 items-center justify-center bg-[#071421] px-4 py-3 text-center font-mono text-[9px] text-slate-600 uppercase">
            {label}
        </div>
    );
}

function ComparisonPicker({
    skills,
    onSelect,
}: {
    skills: WikiSkillSynergyEntry[];
    onSelect: (skill: WikiSkillSynergyEntry) => void;
}) {
    return (
        <section className="border border-cyan-300/18 bg-[#071522] p-4">
            <div className="flex items-center justify-between gap-3">
                <div>
                    <p className="font-mono text-[9px] font-black tracking-[.14em] text-cyan-300 uppercase">
                        Chọn đối tượng so sánh
                    </p>
                    <p className="mt-1 text-xs text-slate-500">
                        Các Skill gần Tier nhất trong cùng bể học.
                    </p>
                </div>
                <Scale className="size-5 text-cyan-300" />
            </div>
            <div className="mt-4 grid gap-2 sm:grid-cols-2 lg:grid-cols-4">
                {skills.map((candidate) => (
                    <button
                        key={candidate.id}
                        type="button"
                        onClick={() => onSelect(candidate)}
                        className="flex items-center justify-between gap-3 border border-white/8 bg-black/14 p-3 text-left transition hover:border-cyan-300/35 hover:bg-cyan-300/6"
                    >
                        <span>
                            <strong className="block text-xs text-white">
                                {candidate.name}
                            </strong>
                            <span className="mt-1 block font-mono text-[8px] text-slate-500">
                                Tier {candidate.tier} · PP {candidate.max_uses}
                            </span>
                        </span>
                        <ChevronRight className="size-3.5 text-cyan-300" />
                    </button>
                ))}
            </div>
        </section>
    );
}

function BuildStrip({
    skills,
    onRemove,
}: {
    skills: BuildableSkill[];
    onRemove: (skill: BuildableSkill) => void;
}) {
    return (
        <section className="border border-amber-300/18 bg-amber-300/5 p-4">
            <div className="flex flex-wrap items-center gap-2">
                <span className="mr-2 font-mono text-[9px] font-black tracking-[.14em] text-amber-200 uppercase">
                    Build thử nghiệm {skills.length}/5
                </span>
                {skills.map((skill) => (
                    <button
                        key={skill.id}
                        type="button"
                        onClick={() => onRemove(skill)}
                        className="flex items-center gap-2 border border-white/10 bg-[#081522] px-3 py-2 text-xs text-slate-300 transition hover:border-rose-300/30 hover:text-rose-200"
                    >
                        {skill.name}
                        <X className="size-3" />
                    </button>
                ))}
            </div>
        </section>
    );
}

function AnalysisSection({ skill }: { skill: WikiSkillDetail }) {
    const isStatusSkill = skill.power_percent === 0;

    return (
        <section
            id="analysis"
            className="scroll-mt-34 border border-white/9 bg-[#081522]/92 p-5 sm:p-6"
        >
            <SectionHeading
                icon={<Zap />}
                eyebrow="Phân tích chiến đấu"
                title="Uy lực, mục tiêu và hiệu ứng"
            />
            <div className="mt-5 grid gap-px overflow-hidden border border-white/8 bg-white/8 sm:grid-cols-2 lg:grid-cols-4">
                <StatCell
                    icon={<Zap />}
                    label="Uy lực"
                    value={
                        isStatusSkill ? 'Trạng thái' : `${skill.power_percent}%`
                    }
                />
                <StatCell
                    icon={<Layers3 />}
                    label="PP tối đa"
                    value={String(skill.max_uses)}
                />
                <StatCell
                    icon={<ShieldCheck />}
                    label="Bậc"
                    value={String(skill.tier)}
                />
                <StatCell
                    icon={<Target />}
                    label="Mục tiêu"
                    value={skill.target_label}
                />
            </div>

            <div className="mt-5 border border-white/8 bg-black/14 p-5">
                {skill.effect !== null ? (
                    <div className="grid items-center gap-5 sm:grid-cols-[auto_minmax(0,1fr)]">
                        <span className="flex size-20 items-center justify-center border border-[var(--skill-accent)]/25 bg-[var(--skill-accent)]/7">
                            <EffectIcon
                                effect={skill.effect}
                                className="size-14"
                            />
                        </span>
                        <div>
                            <div className="flex flex-wrap items-center gap-2">
                                <h3 className="text-xl font-black text-white">
                                    {skill.effect.name}
                                </h3>
                                <EffectBadge effect={skill.effect} />
                            </div>
                            <p className="mt-3 text-sm leading-6 text-slate-400">
                                {skill.effect.description}
                            </p>
                            <div className="mt-4 flex flex-wrap gap-2 font-mono text-[9px] text-slate-400">
                                <span className="border border-white/8 px-2.5 py-1.5">
                                    Xác suất {skill.status_chance ?? 100}%
                                </span>
                                <span className="border border-white/8 px-2.5 py-1.5">
                                    {skill.effect.duration === null
                                        ? 'Thời lượng theo mô tả'
                                        : `${skill.effect.duration} hiệp`}
                                </span>
                                <span className="border border-white/8 px-2.5 py-1.5">
                                    {skill.effect.kind === 'harmful'
                                        ? 'Debuff đối phương'
                                        : 'Buff phe mình'}
                                </span>
                            </div>
                        </div>
                    </div>
                ) : (
                    <div className="flex items-start gap-3 text-sm leading-6 text-slate-400">
                        <Crosshair className="mt-1 size-4 shrink-0 text-[var(--skill-accent)]" />
                        Skill này không gắn Buff/Debuff chuẩn. Nếu mô tả có điều
                        kiện đặc biệt, điều kiện đó vẫn được giữ nguyên và dùng
                        khi tìm liên kết combo.
                    </div>
                )}
            </div>
        </section>
    );
}

function LearnsetMatrix({
    skill,
    level,
    onLevelChange,
}: {
    skill: WikiSkillDetail;
    level: number;
    onLevelChange: (level: number) => void;
}) {
    return (
        <section
            id="learnset"
            className="scroll-mt-34 border border-white/9 bg-[#081522]/92 p-5 sm:p-6"
        >
            <div className="flex flex-wrap items-end justify-between gap-4">
                <SectionHeading
                    icon={<GitBranch />}
                    eyebrow="Ma trận dòng tiến hóa"
                    title="Pet mở, kế thừa hoặc mất Skill"
                />
                <label className="w-full max-w-xs border border-white/8 bg-black/14 p-3">
                    <span className="flex items-center justify-between text-[10px] text-slate-500">
                        Cấp đang kiểm tra
                        <strong className="font-mono text-[var(--skill-accent)]">
                            LV.{level}
                        </strong>
                    </span>
                    <input
                        type="range"
                        min="1"
                        max="50"
                        value={level}
                        onChange={(event) =>
                            onLevelChange(Number(event.target.value))
                        }
                        className="mt-3 w-full accent-[var(--skill-accent)]"
                    />
                </label>
            </div>

            <div className="mt-4 flex flex-wrap gap-2 text-[9px] font-black uppercase">
                <Legend color="emerald" label="Mở trực tiếp" />
                <Legend color="cyan" label="Kế thừa" />
                <Legend color="rose" label="Không thể học" />
                <Legend color="amber" label="Chưa đạt cấp" />
            </div>

            <div className="mt-5 grid gap-4">
                {skill.learnset_families.map((family) => (
                    <EvolutionFamilyMatrix
                        key={family.root_pet.id}
                        family={family}
                        level={level}
                    />
                ))}
            </div>
        </section>
    );
}

function EvolutionFamilyMatrix({
    family,
    level,
}: {
    family: WikiSkillDetail['learnset_families'][number];
    level: number;
}) {
    const stages = groupPetsByStage(family.pets);

    return (
        <article className="overflow-hidden border border-white/8 bg-[#06131f]">
            <div className="flex items-center justify-between gap-3 border-b border-white/7 bg-white/3 px-4 py-3">
                <div className="flex items-center gap-3">
                    <GameArtwork
                        src={petArtworkUrl(
                            family.root_pet.sprite_id,
                            family.root_pet.game_source.asset_key,
                        )}
                        alt={family.root_pet.name}
                        className="size-10"
                        fallback={<Dna className="size-5 text-cyan-300" />}
                    />
                    <div>
                        <strong className="block text-sm text-white">
                            Dòng {family.root_pet.name}
                        </strong>
                        <span className="font-mono text-[8px] text-slate-500">
                            {family.pets.length} form ·{' '}
                            {family.transitions.length} đường tiến hóa
                        </span>
                    </div>
                </div>
                <GitBranch className="size-4 text-[var(--skill-accent)]" />
            </div>

            <div className="overflow-x-auto p-4">
                <div
                    className="grid min-w-170 items-stretch gap-7"
                    style={{
                        gridTemplateColumns: `repeat(${stages.length}, minmax(11rem, 1fr))`,
                    }}
                >
                    {stages.map(([stage, pets], stageIndex) => (
                        <div
                            key={stage}
                            className="relative grid content-center gap-3"
                        >
                            {stageIndex > 0 && (
                                <span className="absolute top-1/2 -left-7 h-px w-7 bg-linear-to-r from-[var(--skill-accent)]/20 to-[var(--skill-accent)]/70" />
                            )}
                            <span className="font-mono text-[8px] font-black tracking-[.14em] text-slate-600 uppercase">
                                Form {stage}
                            </span>
                            {pets.map((pet) => (
                                <LearnsetPetNode
                                    key={pet.id}
                                    pet={pet}
                                    level={level}
                                />
                            ))}
                        </div>
                    ))}
                </div>
            </div>
        </article>
    );
}

function LearnsetPetNode({
    pet,
    level,
}: {
    pet: WikiSkillLearnsetPet;
    level: number;
}) {
    const isLocked =
        pet.learning_state !== 'unavailable' &&
        pet.unlock_level !== null &&
        level < pet.unlock_level;
    const presentation = learningPresentation(
        isLocked ? 'locked' : pet.learning_state,
    );

    return (
        <Link
            href={petShow(pet.id)}
            prefetch
            className={cn(
                'group relative flex min-h-25 items-center gap-3 border p-3 transition hover:-translate-y-0.5',
                presentation.className,
            )}
        >
            <span className="flex size-14 shrink-0 items-center justify-center bg-black/18">
                <GameArtwork
                    src={petArtworkUrl(
                        pet.sprite_id,
                        pet.game_source.asset_key,
                    )}
                    alt={pet.name}
                    className="size-12 transition group-hover:scale-110"
                    fallback={<Dna className="size-6 text-cyan-300" />}
                />
            </span>
            <span className="min-w-0">
                <span className="font-mono text-[8px] text-slate-600">
                    #{String(pet.game_id).padStart(3, '0')}
                </span>
                <strong className="block truncate text-xs text-white">
                    {pet.name}
                </strong>
                <span className="mt-1 flex items-center gap-1 text-[9px] font-black">
                    <presentation.icon className="size-3" />
                    {presentation.label}
                </span>
                {pet.unlock_level !== null && (
                    <span className="mt-1 block font-mono text-[8px] text-slate-500">
                        {pet.learning_state === 'direct'
                            ? `Mở tại cấp ${pet.unlock_level}`
                            : `Từ ${pet.grant_pet?.name} · cấp ${pet.unlock_level}`}
                    </span>
                )}
            </span>
        </Link>
    );
}

function SynergySection({
    skill,
    buildSkillIds,
    onToggleBuild,
}: {
    skill: WikiSkillDetail;
    buildSkillIds: number[];
    onToggleBuild: (skill: BuildableSkill) => void;
}) {
    return (
        <section
            id="synergy"
            className="scroll-mt-34 border border-white/9 bg-[#081522]/92 p-5 sm:p-6"
        >
            <SectionHeading
                icon={<Sparkles />}
                eyebrow="Gợi ý có kiểm chứng"
                title="Mắt xích Combo & đội hình đấu đôi"
            />
            <p className="mt-3 max-w-3xl text-sm leading-6 text-slate-400">
                Các liên kết dưới đây được tính từ Effect, mô tả Skill và vai
                trò Pet hiện có. Đây là gợi ý chiến thuật, không phải dữ liệu
                nguyên văn của game.
            </p>

            <div className="mt-5 grid gap-4 lg:grid-cols-2">
                <SynergyColumn
                    title="Chiêu thức tiền đề"
                    description="Tạo trạng thái được Skill hiện tại nhắc đến."
                    icon={<Dna />}
                    skills={skill.synergies.setup_skills}
                    empty="Chưa tìm thấy Effect tiền đề được mô tả rõ."
                    buildSkillIds={buildSkillIds}
                    onToggleBuild={onToggleBuild}
                />
                <SynergyColumn
                    title="Chiêu thức nối tiếp"
                    description="Skill khác có mô tả tương tác với Effect hiện tại."
                    icon={<Zap />}
                    skills={skill.synergies.finisher_skills}
                    empty="Chưa có Skill nối tiếp được chứng minh bằng mô tả."
                    buildSkillIds={buildSkillIds}
                    onToggleBuild={onToggleBuild}
                />
            </div>

            <div className="mt-4 border border-white/8 bg-black/14 p-4">
                <div className="flex items-center gap-3">
                    <span className="flex size-9 items-center justify-center border border-fuchsia-300/25 bg-fuchsia-300/7 text-fuchsia-200">
                        <HeartHandshake className="size-4" />
                    </span>
                    <div>
                        <h3 className="font-black text-white">
                            Đồng đội hỗ trợ phù hợp
                        </h3>
                        <p className="text-xs text-slate-500">
                            Ưu tiên Pet có bể hồi phục, bảo vệ hoặc gây rối.
                        </p>
                    </div>
                </div>
                <div className="mt-4 grid gap-3 sm:grid-cols-2 xl:grid-cols-3">
                    {skill.synergies.teammate_pets.map((pet) => (
                        <Link
                            key={pet.id}
                            href={petShow(pet.id)}
                            prefetch
                            className="group flex items-center gap-3 border border-white/8 bg-[#071421] p-3 transition hover:border-fuchsia-300/30"
                        >
                            <GameArtwork
                                src={petArtworkUrl(
                                    pet.sprite_id,
                                    pet.game_source.asset_key,
                                )}
                                alt={pet.name}
                                className="size-12 transition group-hover:scale-110"
                                fallback={
                                    <HeartHandshake className="size-6 text-fuchsia-200" />
                                }
                            />
                            <span className="min-w-0">
                                <strong className="block truncate text-xs text-white">
                                    {pet.name}
                                </strong>
                                <span className="mt-1 block text-[9px] font-black text-fuchsia-200">
                                    {pet.primary_role_label}
                                </span>
                                <span className="mt-1 line-clamp-2 block text-[9px] leading-4 text-slate-500">
                                    {pet.reason}
                                </span>
                            </span>
                        </Link>
                    ))}
                </div>
            </div>
        </section>
    );
}

function SynergyColumn({
    title,
    description,
    icon,
    skills,
    empty,
    buildSkillIds,
    onToggleBuild,
}: {
    title: string;
    description: string;
    icon: ReactNode;
    skills: WikiSkillSynergyEntry[];
    empty: string;
    buildSkillIds: number[];
    onToggleBuild: (skill: BuildableSkill) => void;
}) {
    return (
        <div className="border border-white/8 bg-black/14 p-4">
            <div className="flex items-center gap-3">
                <span className="flex size-9 items-center justify-center border border-[var(--skill-accent)]/25 bg-[var(--skill-accent)]/7 text-[var(--skill-accent)] [&_svg]:size-4">
                    {icon}
                </span>
                <div>
                    <h3 className="font-black text-white">{title}</h3>
                    <p className="text-[10px] text-slate-500">{description}</p>
                </div>
            </div>
            <div className="mt-4 grid gap-2">
                {skills.length === 0 ? (
                    <p className="border border-dashed border-white/8 p-4 text-xs leading-5 text-slate-500">
                        {empty}
                    </p>
                ) : (
                    skills.map((candidate) => (
                        <div
                            key={candidate.id}
                            className="flex items-center gap-3 border border-white/8 bg-[#071421] p-3"
                        >
                            <span className="flex size-10 shrink-0 items-center justify-center border border-white/8">
                                <SkillSigil
                                    element={candidate.element}
                                    gameSource={candidate.game_source}
                                    skillId={candidate.game_id}
                                    powerPercent={candidate.power_percent}
                                    effectMode={
                                        candidate.effect === null ? 0 : 1
                                    }
                                    className="size-9 [&>span]:hidden"
                                />
                            </span>
                            <span className="min-w-0 flex-1">
                                <Link
                                    href={skillShow(candidate.id)}
                                    prefetch
                                    className="block truncate text-xs font-black text-white hover:text-[var(--skill-accent)]"
                                >
                                    {candidate.name}
                                </Link>
                                <span className="mt-1 block font-mono text-[8px] text-slate-500">
                                    Tier {candidate.tier} · PP{' '}
                                    {candidate.max_uses}
                                    {candidate.effect !== null
                                        ? ` · ${candidate.effect.name}`
                                        : ''}
                                </span>
                            </span>
                            <button
                                type="button"
                                onClick={() => onToggleBuild(candidate)}
                                aria-label={`Thêm ${candidate.name} vào Build`}
                                className={cn(
                                    'flex size-8 items-center justify-center border transition',
                                    buildSkillIds.includes(candidate.id)
                                        ? 'border-emerald-300/30 bg-emerald-300/8 text-emerald-200'
                                        : 'border-white/8 text-slate-500 hover:border-[var(--skill-accent)]/30 hover:text-[var(--skill-accent)]',
                                )}
                            >
                                {buildSkillIds.includes(candidate.id) ? (
                                    <Check className="size-3.5" />
                                ) : (
                                    <Plus className="size-3.5" />
                                )}
                            </button>
                        </div>
                    ))
                )}
            </div>
        </div>
    );
}

function SimulatorSection({
    skill,
    strength,
    defense,
    matchup,
    damageMinimum,
    damageMaximum,
    onStrengthChange,
    onDefenseChange,
    onMatchupChange,
}: {
    skill: WikiSkillDetail;
    strength: number;
    defense: number;
    matchup: Matchup;
    damageMinimum: number;
    damageMaximum: number;
    onStrengthChange: (value: number) => void;
    onDefenseChange: (value: number) => void;
    onMatchupChange: (value: Matchup) => void;
}) {
    return (
        <section
            id="simulator"
            className="scroll-mt-34 overflow-hidden border border-[var(--skill-accent)]/22 bg-[#081522]/92"
        >
            <div className="p-5 sm:p-6">
                <SectionHeading
                    icon={<BarChart3 />}
                    eyebrow="Ước tính luật hợp nhất"
                    title="Mô phỏng sát thương & trạng thái"
                />
                <p className="mt-3 max-w-3xl text-sm leading-6 text-slate-400">
                    Công cụ dùng công thức cân bằng hợp nhất và biên dao động
                    ±5%. Kết quả không được ghi ngược lại database.
                </p>
            </div>

            <div className="grid border-t border-white/8 lg:grid-cols-[minmax(0,1fr)_20rem]">
                <div className="grid gap-5 p-5 sm:p-6">
                    <SimulatorSlider
                        label="Sức mạnh Pet"
                        value={strength}
                        min={100}
                        max={1500}
                        onChange={onStrengthChange}
                    />
                    <SimulatorSlider
                        label="Phòng ngự mục tiêu"
                        value={defense}
                        min={50}
                        max={1000}
                        onChange={onDefenseChange}
                    />
                    <div>
                        <span className="text-[10px] font-black tracking-[.12em] text-slate-500 uppercase">
                            Tương quan Hệ
                        </span>
                        <div className="mt-2 grid grid-cols-3 gap-2">
                            {(
                                [
                                    ['advantage', 'Khắc Hệ', '×1.5'],
                                    ['neutral', 'Bình thường', '×1.0'],
                                    ['disadvantage', 'Bị khắc', '×0.75'],
                                ] as const
                            ).map(([value, label, multiplier]) => (
                                <button
                                    key={value}
                                    type="button"
                                    onClick={() => onMatchupChange(value)}
                                    className={cn(
                                        'border p-3 text-left transition',
                                        matchup === value
                                            ? 'border-[var(--skill-accent)]/45 bg-[var(--skill-accent)]/10 text-white'
                                            : 'border-white/8 bg-black/14 text-slate-500 hover:border-white/16',
                                    )}
                                >
                                    <strong className="block text-xs">
                                        {label}
                                    </strong>
                                    <span className="mt-1 block font-mono text-[9px] text-[var(--skill-accent)]">
                                        {multiplier}
                                    </span>
                                </button>
                            ))}
                        </div>
                    </div>
                </div>

                <div className="relative flex flex-col justify-center border-t border-white/8 bg-[var(--skill-accent)]/6 p-6 lg:border-t-0 lg:border-l">
                    <span className="font-mono text-[9px] font-black tracking-[.14em] text-[var(--skill-accent)] uppercase">
                        Kết quả trực tiếp
                    </span>
                    {skill.power_percent === 0 ? (
                        <strong className="mt-3 text-3xl font-black text-white">
                            Không gây sát thương
                        </strong>
                    ) : (
                        <strong className="mt-3 font-mono text-4xl font-black text-white tabular-nums">
                            {damageMinimum.toLocaleString('vi-VN')}–
                            {damageMaximum.toLocaleString('vi-VN')}
                        </strong>
                    )}
                    <span className="mt-2 text-xs text-slate-500">
                        {skill.power_percent === 0
                            ? 'Skill thuần trạng thái hoặc hỗ trợ.'
                            : `HP ước tính · Uy lực ${skill.power_percent}%`}
                    </span>
                    {skill.effect !== null && (
                        <div className="mt-5 border border-white/8 bg-black/14 p-3">
                            <span className="text-[9px] text-slate-500">
                                Hiệu ứng đi kèm
                            </span>
                            <strong className="mt-1 block text-sm text-[var(--skill-accent)]">
                                {skill.status_chance ?? 100}%{' '}
                                {skill.effect.name}
                                {skill.effect.duration === null
                                    ? ''
                                    : ` · ${skill.effect.duration} hiệp`}
                            </strong>
                        </div>
                    )}
                    <code className="mt-5 block text-[9px] leading-4 text-slate-600">
                        {skill.simulator.formula}
                    </code>
                </div>
            </div>
        </section>
    );
}

function SimulatorSlider({
    label,
    value,
    min,
    max,
    onChange,
}: {
    label: string;
    value: number;
    min: number;
    max: number;
    onChange: (value: number) => void;
}) {
    return (
        <label className="block">
            <span className="flex items-center justify-between text-[10px] font-black tracking-[.12em] text-slate-500 uppercase">
                {label}
                <strong className="font-mono text-sm text-white tabular-nums">
                    {value.toLocaleString('vi-VN')}
                </strong>
            </span>
            <input
                type="range"
                min={min}
                max={max}
                value={value}
                onChange={(event) => onChange(Number(event.target.value))}
                className="mt-3 w-full accent-[var(--skill-accent)]"
            />
            <span className="mt-1 flex justify-between font-mono text-[8px] text-slate-600">
                <span>{min}</span>
                <span>{max}</span>
            </span>
        </label>
    );
}

function SkillSidebar({ skill }: { skill: WikiSkillDetail }) {
    return (
        <aside className="flex flex-col gap-4 xl:sticky xl:top-34">
            <section className="border border-white/9 bg-[#081522]/92 p-5">
                <div className="flex items-center gap-2 text-[var(--skill-accent)]">
                    <Layers3 className="size-4" />
                    <h2 className="font-mono text-[10px] font-black tracking-[.14em] uppercase">
                        Phân bố Chủng
                    </h2>
                </div>
                <p className="mt-2 text-xs leading-5 text-slate-500">
                    Tỷ lệ trên {skill.compatible_pets.length} Pet có thể sử dụng
                    Skill này.
                </p>
                <div className="mt-4 grid gap-3">
                    {skill.species_distribution.map((entry) => (
                        <div key={entry.slug}>
                            <div className="flex items-center justify-between gap-3 text-[10px]">
                                <span className="font-black text-slate-300">
                                    {entry.name}
                                </span>
                                <span className="font-mono text-slate-500">
                                    {entry.count} · {entry.percentage}%
                                </span>
                            </div>
                            <div className="mt-1.5 h-1.5 overflow-hidden bg-white/6">
                                <span
                                    className="block h-full"
                                    style={{
                                        width: `${entry.percentage}%`,
                                        backgroundColor: entry.color,
                                    }}
                                />
                            </div>
                        </div>
                    ))}
                </div>
            </section>

            <details className="group border border-white/9 bg-[#081522]/92 p-5">
                <summary className="flex cursor-pointer list-none items-center justify-between gap-3 font-mono text-[10px] font-black tracking-[.15em] text-slate-300 uppercase marker:hidden">
                    <span className="flex items-center gap-2">
                        <Database className="size-4 text-[var(--skill-accent)]" />
                        Dữ liệu dành cho modder
                    </span>
                    <span className="text-[var(--skill-accent)] transition group-open:rotate-45">
                        +
                    </span>
                </summary>
                <dl className="mt-5 grid gap-3 border-t border-white/8 pt-5 text-xs">
                    <DataRow label="Bảng" value="db[1] · Skill" />
                    <DataRow label="Game ID" value={skill.game_id} />
                    <DataRow
                        label="Chế độ hiệu ứng"
                        value={skill.effect_mode}
                    />
                    <DataRow
                        label="Cường độ raw"
                        value={skill.effect_parameter ?? '—'}
                    />
                    <DataRow label="Tên" value="Dữ liệu giải mã" />
                    <DataRow
                        label="Mô tả hiển thị"
                        value={
                            skill.provenance.description === 'decoded'
                                ? 'Dữ liệu giải mã'
                                : 'Luật hợp nhất'
                        }
                    />
                    <DataRow label="Learnset" value="Luật hợp nhất" />
                    <DataRow label="Combo" value="Gợi ý tính toán" />
                </dl>
            </details>

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
                        Thông số bản thô
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
    );
}

function ComparisonModal({
    skill,
    comparisonSkill,
    onClose,
}: {
    skill: WikiSkillDetail;
    comparisonSkill: WikiSkillSynergyEntry;
    onClose: () => void;
}) {
    return (
        <div
            role="dialog"
            aria-modal="true"
            aria-label="So sánh kỹ năng"
            className="fixed inset-0 z-50 flex items-center justify-center bg-[#020710]/88 p-4 backdrop-blur-md"
        >
            <div className="w-full max-w-3xl overflow-hidden border border-cyan-300/22 bg-[#07111d] shadow-[0_30px_100px_rgba(0,0,0,.7)]">
                <div className="flex items-center justify-between gap-4 border-b border-white/9 p-5">
                    <div>
                        <p className="font-mono text-[9px] font-black tracking-[.14em] text-cyan-300 uppercase">
                            Đối chiếu cùng bể Skill
                        </p>
                        <h2 className="mt-1 text-xl font-black text-white">
                            {skill.name} ↔ {comparisonSkill.name}
                        </h2>
                    </div>
                    <button
                        type="button"
                        onClick={onClose}
                        aria-label="Đóng so sánh"
                        className="flex size-10 items-center justify-center border border-white/9 text-slate-400 transition hover:border-rose-300/30 hover:text-rose-200"
                    >
                        <X className="size-4" />
                    </button>
                </div>
                <div className="overflow-x-auto p-5">
                    <table className="w-full min-w-130 border-collapse text-left">
                        <thead>
                            <tr className="border-b border-white/9 text-xs text-white">
                                <th className="p-3 text-slate-500">Thông số</th>
                                <th className="p-3">{skill.name}</th>
                                <th className="p-3">{comparisonSkill.name}</th>
                            </tr>
                        </thead>
                        <tbody>
                            <ComparisonRow
                                label="Uy lực"
                                left={`${skill.power_percent}%`}
                                right={`${comparisonSkill.power_percent}%`}
                            />
                            <ComparisonRow
                                label="PP"
                                left={String(skill.max_uses)}
                                right={String(comparisonSkill.max_uses)}
                            />
                            <ComparisonRow
                                label="Tier"
                                left={String(skill.tier)}
                                right={String(comparisonSkill.tier)}
                            />
                            <ComparisonRow
                                label="Effect"
                                left={skill.effect?.name ?? 'Không có'}
                                right={
                                    comparisonSkill.effect?.name ?? 'Không có'
                                }
                            />
                            <ComparisonRow
                                label="Tỷ lệ Effect"
                                left={`${skill.status_chance ?? 0}%`}
                                right={`${comparisonSkill.status_chance ?? 0}%`}
                            />
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    );
}

function ComparisonRow({
    label,
    left,
    right,
}: {
    label: string;
    left: string;
    right: string;
}) {
    return (
        <tr className="border-b border-white/7 text-sm">
            <th className="p-3 text-xs text-slate-500">{label}</th>
            <td className="p-3 font-mono font-black text-[var(--skill-accent)]">
                {left}
            </td>
            <td className="p-3 font-mono font-black text-cyan-200">{right}</td>
        </tr>
    );
}

function SectionHeading({
    icon,
    eyebrow,
    title,
}: {
    icon: ReactNode;
    eyebrow: string;
    title: string;
}) {
    return (
        <div className="flex items-center gap-3">
            <span className="flex size-10 items-center justify-center border border-[var(--skill-accent)]/35 bg-[var(--skill-accent)]/8 text-[var(--skill-accent)] [&_svg]:size-4">
                {icon}
            </span>
            <div>
                <p className="font-mono text-[8px] font-black tracking-[.18em] text-[var(--skill-accent)] uppercase">
                    {eyebrow}
                </p>
                <h2 className="text-xl font-black text-white">{title}</h2>
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

function Legend({
    color,
    label,
}: {
    color: 'emerald' | 'cyan' | 'rose' | 'amber';
    label: string;
}) {
    const colorClasses = {
        emerald: 'border-emerald-300/20 bg-emerald-300/7 text-emerald-200',
        cyan: 'border-cyan-300/20 bg-cyan-300/7 text-cyan-200',
        rose: 'border-rose-300/20 bg-rose-300/7 text-rose-200',
        amber: 'border-amber-300/20 bg-amber-300/7 text-amber-200',
    };

    return (
        <span className={cn('border px-2.5 py-1.5', colorClasses[color])}>
            {label}
        </span>
    );
}

function DataRow({ label, value }: { label: string; value: string | number }) {
    return (
        <div className="flex items-center justify-between gap-3 border-b border-white/6 pb-3 last:border-0 last:pb-0">
            <dt className="text-slate-500">{label}</dt>
            <dd className="text-right font-mono font-bold text-slate-300">
                {value}
            </dd>
        </div>
    );
}

function readStoredIds(storageKey: string): number[] {
    try {
        const value = window.localStorage.getItem(storageKey);
        const parsed = value === null ? [] : (JSON.parse(value) as unknown);

        return Array.isArray(parsed)
            ? parsed.filter((item): item is number => typeof item === 'number')
            : [];
    } catch {
        window.localStorage.removeItem(storageKey);

        return [];
    }
}

function uniqueSkills<T extends { id: number }>(skills: T[]): T[] {
    return Array.from(
        new Map(skills.map((skill) => [skill.id, skill])).values(),
    );
}

function groupPetsByStage(
    pets: WikiSkillLearnsetPet[],
): Array<[number, WikiSkillLearnsetPet[]]> {
    const grouped = pets.reduce<Record<number, WikiSkillLearnsetPet[]>>(
        (stages, pet) => ({
            ...stages,
            [pet.stage]: [...(stages[pet.stage] ?? []), pet],
        }),
        {},
    );

    return Object.entries(grouped)
        .map(([stage, stagePets]): [number, WikiSkillLearnsetPet[]] => [
            Number(stage),
            stagePets,
        ])
        .sort(([leftStage], [rightStage]) => leftStage - rightStage);
}

function learningPresentation(
    state: WikiSkillLearnsetPet['learning_state'] | 'locked',
) {
    return {
        direct: {
            label: 'Mở trực tiếp',
            icon: Check,
            className:
                'border-emerald-300/22 bg-emerald-300/5 text-emerald-200 hover:border-emerald-300/45',
        },
        inherited: {
            label: 'Kế thừa',
            icon: GitBranch,
            className:
                'border-cyan-300/22 bg-cyan-300/5 text-cyan-200 hover:border-cyan-300/45',
        },
        unavailable: {
            label: 'Không thể học',
            icon: X,
            className:
                'border-rose-300/18 bg-rose-300/4 text-rose-200 opacity-72 hover:border-rose-300/35',
        },
        locked: {
            label: 'Chưa đạt cấp',
            icon: LockKeyhole,
            className:
                'border-amber-300/20 bg-amber-300/5 text-amber-200 hover:border-amber-300/40',
        },
    }[state];
}
