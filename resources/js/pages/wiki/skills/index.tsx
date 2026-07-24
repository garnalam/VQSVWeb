import { Head } from '@inertiajs/react';
import { HeartPulse, Sparkles, Swords, Zap } from 'lucide-react';
import type { ReactNode } from 'react';
import { useEffect, useState } from 'react';
import { toast } from 'sonner';
import { SkillActionDock } from '@/components/wiki/skill-action-dock';
import { SkillArchiveCard } from '@/components/wiki/skill-archive-card';
import { SkillFilterDeck } from '@/components/wiki/skill-filter-deck';
import type { SkillFilters } from '@/components/wiki/skill-filter-deck';
import { SkillMatrixHeader } from '@/components/wiki/skill-matrix-header';
import type { SkillCatalogStats } from '@/components/wiki/skill-matrix-header';
import { WikiEmptyState } from '@/components/wiki/wiki-empty-state';
import { WikiPagination } from '@/components/wiki/wiki-pagination';
import { WikiResultsBar } from '@/components/wiki/wiki-results-bar';
import { compactWikiQuery } from '@/lib/wiki';
import { index as skillsIndex } from '@/routes/wiki/skills';
import type {
    PaginatedWikiData,
    WikiCombatElement,
    WikiSkillCatalogEntry,
} from '@/types';

type SkillIndexProps = {
    skills: PaginatedWikiData<WikiSkillCatalogEntry>;
    elements: WikiCombatElement[];
    catalogStats: SkillCatalogStats;
    filters: SkillFilters;
};

const PINNED_SKILL_STORAGE_KEY = 'vqsv-wiki:pinned-skills';

function storedPinnedSkillIds(): number[] {
    if (typeof window === 'undefined') {
        return [];
    }

    try {
        const storedValue = window.localStorage.getItem(
            PINNED_SKILL_STORAGE_KEY,
        );
        const storedIds =
            storedValue === null ? [] : (JSON.parse(storedValue) as unknown);

        return Array.isArray(storedIds)
            ? storedIds.filter(
                  (skillId): skillId is number => typeof skillId === 'number',
              )
            : [];
    } catch {
        window.localStorage.removeItem(PINNED_SKILL_STORAGE_KEY);

        return [];
    }
}

export default function SkillIndex({
    skills,
    elements,
    catalogStats,
    filters,
}: SkillIndexProps) {
    const [comparedSkills, setComparedSkills] = useState<
        WikiSkillCatalogEntry[]
    >([]);
    const [buildSkills, setBuildSkills] = useState<WikiSkillCatalogEntry[]>([]);
    const [pinnedSkillIds, setPinnedSkillIds] = useState<number[]>([]);
    const [dockIsVisible, setDockIsVisible] = useState(false);

    useEffect(() => {
        const pinnedStateFrame = window.requestAnimationFrame(() => {
            setPinnedSkillIds(storedPinnedSkillIds());
        });

        const updateDockVisibility = () => {
            setDockIsVisible(window.scrollY > 280);
        };

        updateDockVisibility();
        window.addEventListener('scroll', updateDockVisibility, {
            passive: true,
        });

        return () => {
            window.cancelAnimationFrame(pinnedStateFrame);
            window.removeEventListener('scroll', updateDockVisibility);
        };
    }, []);

    function toggleComparedSkill(skill: WikiSkillCatalogEntry) {
        setComparedSkills((currentSkills) => {
            if (currentSkills.some((current) => current.id === skill.id)) {
                return currentSkills.filter(
                    (current) => current.id !== skill.id,
                );
            }

            if (currentSkills.length >= 3) {
                toast.warning('Chỉ có thể so sánh tối đa 3 kỹ năng.');

                return currentSkills;
            }

            return [...currentSkills, skill];
        });
    }

    function toggleBuildSkill(skill: WikiSkillCatalogEntry) {
        setBuildSkills((currentSkills) => {
            if (currentSkills.some((current) => current.id === skill.id)) {
                return currentSkills.filter(
                    (current) => current.id !== skill.id,
                );
            }

            if (currentSkills.length >= 5) {
                toast.warning('Build thử nghiệm đã đủ 5 kỹ năng.');

                return currentSkills;
            }

            return [...currentSkills, skill];
        });
    }

    function togglePinnedSkill(skill: WikiSkillCatalogEntry) {
        setPinnedSkillIds((currentIds) => {
            const nextIds = currentIds.includes(skill.id)
                ? currentIds.filter((skillId) => skillId !== skill.id)
                : [...currentIds, skill.id];

            window.localStorage.setItem(
                PINNED_SKILL_STORAGE_KEY,
                JSON.stringify(nextIds),
            );

            toast.success(
                currentIds.includes(skill.id)
                    ? `Đã bỏ ghim ${skill.name}.`
                    : `Đã ghim ${skill.name} trên trình duyệt này.`,
            );

            return nextIds;
        });
    }

    const appliedQuery = compactWikiQuery(filters);

    return (
        <>
            <Head title="Ma trận kỹ năng" />

            <SkillMatrixHeader
                matchingTotal={skills.total}
                stats={catalogStats}
            />

            <SkillFilterDeck filters={filters} elements={elements} />

            <div className="flex flex-col gap-3 border-y border-white/7 bg-black/10 px-1 py-3 lg:flex-row lg:items-center lg:justify-between">
                <WikiResultsBar
                    label="Kỹ năng chiến đấu đang hoạt động"
                    from={skills.from}
                    to={skills.to}
                    total={skills.total}
                />
                <div className="flex [scrollbar-width:none] gap-2 overflow-x-auto pb-1 lg:pb-0 [&::-webkit-scrollbar]:hidden">
                    <CardLegend
                        icon={<Swords />}
                        label="Tấn công"
                        color="cyan"
                    />
                    <CardLegend
                        icon={<Zap />}
                        label="Trạng thái"
                        color="fuchsia"
                    />
                    <CardLegend
                        icon={<HeartPulse />}
                        label="Hồi phục / Bảo vệ"
                        color="emerald"
                    />
                    <CardLegend
                        icon={<Sparkles />}
                        label="Đặc trưng độc quyền"
                        color="amber"
                    />
                </div>
            </div>

            {skills.data.length === 0 ? (
                <WikiEmptyState />
            ) : (
                <section className="grid gap-4 md:grid-cols-2 xl:grid-cols-3">
                    {skills.data.map((skill, index) => (
                        <SkillArchiveCard
                            key={skill.id}
                            skill={skill}
                            index={index}
                            isPinned={pinnedSkillIds.includes(skill.id)}
                            isCompared={comparedSkills.some(
                                (comparedSkill) =>
                                    comparedSkill.id === skill.id,
                            )}
                            isInBuild={buildSkills.some(
                                (buildSkill) => buildSkill.id === skill.id,
                            )}
                            comparisonIsFull={comparedSkills.length >= 3}
                            buildIsFull={buildSkills.length >= 5}
                            onTogglePin={togglePinnedSkill}
                            onToggleCompare={toggleComparedSkill}
                            onToggleBuild={toggleBuildSkill}
                        />
                    ))}
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

            {(comparedSkills.length > 0 || buildSkills.length > 0) && (
                <div className="h-20" aria-hidden="true" />
            )}

            <SkillActionDock
                visible={dockIsVisible}
                comparedSkills={comparedSkills}
                buildSkills={buildSkills}
                pinnedCount={pinnedSkillIds.length}
                onRemoveCompared={toggleComparedSkill}
                onRemoveFromBuild={toggleBuildSkill}
                onClear={() => {
                    setComparedSkills([]);
                    setBuildSkills([]);
                }}
            />
        </>
    );
}

function CardLegend({
    icon,
    label,
    color,
}: {
    icon: ReactNode;
    label: string;
    color: 'cyan' | 'fuchsia' | 'emerald' | 'amber';
}) {
    const colorClass = {
        cyan: 'border-cyan-300/20 bg-cyan-300/6 text-cyan-200',
        fuchsia: 'border-fuchsia-300/20 bg-fuchsia-300/6 text-fuchsia-200',
        emerald: 'border-emerald-300/20 bg-emerald-300/6 text-emerald-200',
        amber: 'border-amber-300/20 bg-amber-300/6 text-amber-200',
    }[color];

    return (
        <span
            className={`${colorClass} flex h-8 shrink-0 items-center gap-1.5 border px-2.5 text-[8px] font-black tracking-[.1em] uppercase [&_svg]:size-3`}
        >
            {icon}
            {label}
        </span>
    );
}
