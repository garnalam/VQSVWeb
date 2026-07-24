import {
    BarChart3,
    Layers3,
    Pin,
    RotateCcw,
    Scale,
    Sparkles,
    Target,
    UsersRound,
    X,
    Zap,
} from 'lucide-react';
import type { CSSProperties, ReactNode } from 'react';
import { Button } from '@/components/ui/button';
import {
    Dialog,
    DialogContent,
    DialogDescription,
    DialogHeader,
    DialogTitle,
    DialogTrigger,
} from '@/components/ui/dialog';
import {
    Sheet,
    SheetContent,
    SheetDescription,
    SheetHeader,
    SheetTitle,
    SheetTrigger,
} from '@/components/ui/sheet';
import { ElementBadge } from '@/components/wiki/element-badge';
import { cn } from '@/lib/utils';
import type { WikiSkillCatalogEntry } from '@/types';

type SkillActionDockProps = {
    visible: boolean;
    comparedSkills: WikiSkillCatalogEntry[];
    buildSkills: WikiSkillCatalogEntry[];
    pinnedCount: number;
    onRemoveCompared: (skill: WikiSkillCatalogEntry) => void;
    onRemoveFromBuild: (skill: WikiSkillCatalogEntry) => void;
    onClear: () => void;
};

export function SkillActionDock({
    visible,
    comparedSkills,
    buildSkills,
    pinnedCount,
    onRemoveCompared,
    onRemoveFromBuild,
    onClear,
}: SkillActionDockProps) {
    const hasSelection = comparedSkills.length > 0 || buildSkills.length > 0;

    return (
        <div
            className={cn(
                'fixed inset-x-3 bottom-3 z-50 mx-auto max-w-4xl transition duration-300 sm:bottom-5',
                visible || hasSelection
                    ? 'translate-y-0 opacity-100'
                    : 'pointer-events-none translate-y-[calc(100%+2rem)] opacity-0',
            )}
        >
            <div className="relative overflow-hidden border border-cyan-300/28 bg-[#03101b]/96 p-2.5 shadow-[0_24px_70px_rgba(0,0,0,.65),0_0_28px_rgba(0,229,255,.08)] backdrop-blur-xl [clip-path:polygon(0_10px,10px_0,calc(100%_-_16px)_0,100%_16px,100%_100%,16px_100%,0_calc(100%_-_16px))] sm:p-3">
                <div className="absolute inset-x-0 top-0 h-px bg-linear-to-r from-cyan-300 via-amber-300 to-transparent" />
                <div className="flex items-center gap-2 sm:gap-3">
                    <div className="hidden min-w-0 flex-1 items-center gap-2 md:flex">
                        <span className="flex size-9 shrink-0 items-center justify-center border border-cyan-300/30 bg-cyan-300/8 text-cyan-300">
                            <BarChart3 className="size-4" />
                        </span>
                        <span className="min-w-0">
                            <strong className="block truncate text-xs text-white">
                                Tactical Action Dock
                            </strong>
                            <span className="font-mono text-[8px] tracking-[.12em] text-slate-500 uppercase">
                                So sánh · Combo · Ghim
                            </span>
                        </span>
                    </div>

                    <Dialog>
                        <DialogTrigger asChild>
                            <Button
                                type="button"
                                disabled={comparedSkills.length < 2}
                                className="h-11 flex-1 rounded-none border border-cyan-300/28 bg-cyan-300/9 px-3 text-cyan-100 hover:bg-cyan-300/18 sm:flex-none"
                            >
                                <Scale />
                                So sánh
                                <DockCount
                                    current={comparedSkills.length}
                                    maximum={3}
                                    accent="cyan"
                                />
                            </Button>
                        </DialogTrigger>
                        <DialogContent className="max-h-[88vh] max-w-5xl overflow-y-auto rounded-none border-cyan-300/25 bg-[#04111d] p-0 text-white">
                            <DialogHeader className="border-b border-white/8 p-5 pr-12">
                                <DialogTitle className="flex items-center gap-2 text-cyan-200">
                                    <Scale className="size-5 text-amber-300" />
                                    Ma trận so sánh chiêu thức
                                </DialogTitle>
                                <DialogDescription className="text-slate-400">
                                    Đối chiếu trực tiếp tối đa ba kỹ năng bằng
                                    dữ liệu chiến đấu đã chuẩn hóa.
                                </DialogDescription>
                            </DialogHeader>
                            <SkillComparisonTable
                                skills={comparedSkills}
                                onRemove={onRemoveCompared}
                            />
                        </DialogContent>
                    </Dialog>

                    <Sheet>
                        <SheetTrigger asChild>
                            <Button
                                type="button"
                                className="h-11 flex-1 rounded-none border border-amber-300/30 bg-amber-300/9 px-3 text-amber-100 hover:bg-amber-300/18 sm:flex-none"
                            >
                                <Sparkles />
                                Build 5 Skill
                                <DockCount
                                    current={buildSkills.length}
                                    maximum={5}
                                    accent="amber"
                                />
                            </Button>
                        </SheetTrigger>
                        <SheetContent
                            side="bottom"
                            className="max-h-[90vh] overflow-y-auto border-cyan-300/24 bg-[#04111d] text-white"
                        >
                            <SheetHeader className="border-b border-white/8">
                                <SheetTitle className="flex items-center gap-2 text-cyan-200">
                                    <Sparkles className="size-5 text-amber-300" />
                                    Skill Build Sandbox
                                </SheetTitle>
                                <SheetDescription className="text-slate-400">
                                    Lắp thử năm kỹ năng để kiểm tra PP, độ phủ
                                    Hệ, mục tiêu và chuỗi vai trò chiến thuật.
                                </SheetDescription>
                            </SheetHeader>
                            <BuildSandbox
                                skills={buildSkills}
                                onRemove={onRemoveFromBuild}
                            />
                        </SheetContent>
                    </Sheet>

                    <div className="hidden h-11 items-center gap-2 border border-white/8 bg-white/4 px-3 text-slate-400 sm:flex">
                        <Pin className="size-3.5 text-amber-300" />
                        <span className="text-[9px] font-black uppercase">
                            {pinnedCount} ghim
                        </span>
                    </div>

                    <Button
                        type="button"
                        variant="ghost"
                        size="icon"
                        disabled={!hasSelection}
                        onClick={onClear}
                        aria-label="Xóa lựa chọn trong Action Dock"
                        className="size-11 shrink-0 rounded-none border border-white/8 bg-white/4 text-slate-500 hover:bg-white/8 hover:text-white"
                    >
                        <RotateCcw />
                    </Button>
                </div>
            </div>
        </div>
    );
}

function DockCount({
    current,
    maximum,
    accent,
}: {
    current: number;
    maximum: number;
    accent: 'cyan' | 'amber';
}) {
    return (
        <span
            className={cn(
                'flex h-5 min-w-8 items-center justify-center px-1 font-mono text-[8px] font-black text-[#04111d]',
                accent === 'cyan' ? 'bg-cyan-300' : 'bg-amber-300',
            )}
        >
            {current}/{maximum}
        </span>
    );
}

function SkillComparisonTable({
    skills,
    onRemove,
}: {
    skills: WikiSkillCatalogEntry[];
    onRemove: (skill: WikiSkillCatalogEntry) => void;
}) {
    const rows = [
        {
            label: 'Uy lực',
            value: (skill: WikiSkillCatalogEntry) =>
                skill.power_percent > 0
                    ? `${skill.power_percent}%`
                    : 'Trạng thái',
        },
        {
            label: 'PP',
            value: (skill: WikiSkillCatalogEntry) => String(skill.max_uses),
        },
        {
            label: 'Tier',
            value: (skill: WikiSkillCatalogEntry) => `Tier ${skill.tier}`,
        },
        {
            label: 'Effect',
            value: (skill: WikiSkillCatalogEntry) =>
                skill.effect === null
                    ? 'Không có'
                    : `${skill.effect.name}${skill.status_chance ? ` · ${skill.status_chance}%` : ''}`,
        },
        {
            label: 'Pet học được',
            value: (skill: WikiSkillCatalogEntry) =>
                String(skill.learned_by_count),
        },
        {
            label: 'Mục tiêu',
            value: (skill: WikiSkillCatalogEntry) => skill.target_label,
        },
        {
            label: 'Đấu đôi',
            value: (skill: WikiSkillCatalogEntry) =>
                skill.battle_format === 'double'
                    ? 'Chuyên biệt 2V2'
                    : 'Dùng được',
        },
    ];

    return (
        <div className="overflow-x-auto p-4 sm:p-6">
            <table className="w-full min-w-180 border-collapse text-left">
                <thead>
                    <tr>
                        <th className="w-40 border border-white/8 bg-white/3 p-3 font-mono text-[9px] tracking-[.12em] text-slate-500 uppercase">
                            Chỉ số
                        </th>
                        {skills.map((skill) => (
                            <th
                                key={skill.id}
                                style={
                                    {
                                        '--compare-color': skill.element.color,
                                    } as CSSProperties
                                }
                                className="min-w-48 border border-white/8 bg-[var(--compare-color)]/7 p-4 align-top"
                            >
                                <div className="flex items-start justify-between gap-3">
                                    <span>
                                        <ElementBadge element={skill.element} />
                                        <strong className="mt-2 block text-sm text-white">
                                            {skill.name}
                                        </strong>
                                    </span>
                                    <button
                                        type="button"
                                        onClick={() => onRemove(skill)}
                                        aria-label={`Bỏ ${skill.name} khỏi bảng so sánh`}
                                        className="flex size-7 items-center justify-center border border-white/9 text-slate-500 transition hover:border-red-300/40 hover:text-red-300"
                                    >
                                        <X className="size-3.5" />
                                    </button>
                                </div>
                            </th>
                        ))}
                    </tr>
                </thead>
                <tbody>
                    {rows.map((row) => (
                        <tr key={row.label}>
                            <th className="border border-white/8 bg-white/3 p-3 text-xs font-bold text-slate-400">
                                {row.label}
                            </th>
                            {skills.map((skill) => (
                                <td
                                    key={skill.id}
                                    className="border border-white/8 bg-black/10 p-3 font-mono text-xs font-bold text-white"
                                >
                                    {row.value(skill)}
                                </td>
                            ))}
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

function BuildSandbox({
    skills,
    onRemove,
}: {
    skills: WikiSkillCatalogEntry[];
    onRemove: (skill: WikiSkillCatalogEntry) => void;
}) {
    const totalPp = skills.reduce((total, skill) => total + skill.max_uses, 0);
    const elements = Array.from(
        new Map(
            skills.map((skill) => [skill.element.slug, skill.element]),
        ).values(),
    );
    const effectNames = Array.from(
        new Set(
            skills
                .map((skill) => skill.effect?.name)
                .filter((name): name is string => name !== undefined),
        ),
    );
    const areaSkillCount = skills.filter((skill) =>
        ['all_enemies', 'all_allies', 'battlefield'].includes(
            skill.target_pattern,
        ),
    ).length;
    const comboHints = buildComboHints(skills);

    return (
        <div className="grid gap-5 px-4 pb-6 lg:grid-cols-[minmax(0,1.25fr)_minmax(20rem,.75fr)] lg:px-6">
            <div>
                <div className="grid gap-3 sm:grid-cols-5">
                    {Array.from({ length: 5 }, (_, index) => {
                        const skill = skills[index];

                        return (
                            <div
                                key={skill?.id ?? `empty-${index}`}
                                className={cn(
                                    'relative min-h-31 border p-3',
                                    skill
                                        ? 'border-cyan-300/24 bg-cyan-300/6'
                                        : 'border-dashed border-white/10 bg-white/2',
                                )}
                            >
                                <span className="font-mono text-[8px] font-black tracking-[.14em] text-slate-600 uppercase">
                                    Slot {index + 1}
                                </span>
                                {skill ? (
                                    <>
                                        <ElementBadge element={skill.element} />
                                        <strong className="mt-3 block text-xs leading-4 text-white">
                                            {skill.name}
                                        </strong>
                                        <span className="mt-2 block font-mono text-[8px] text-slate-500">
                                            PP {skill.max_uses} ·{' '}
                                            {skill.combat_category_label}
                                        </span>
                                        <button
                                            type="button"
                                            onClick={() => onRemove(skill)}
                                            aria-label={`Bỏ ${skill.name} khỏi Build`}
                                            className="absolute top-2 right-2 flex size-6 items-center justify-center border border-white/8 text-slate-600 transition hover:text-red-300"
                                        >
                                            <X className="size-3" />
                                        </button>
                                    </>
                                ) : (
                                    <span className="mt-6 flex items-center justify-center font-mono text-[9px] text-slate-700 uppercase">
                                        Chưa lắp
                                    </span>
                                )}
                            </div>
                        );
                    })}
                </div>

                <div className="mt-4 grid grid-cols-2 gap-px overflow-hidden border border-white/8 bg-white/8 sm:grid-cols-4">
                    <BuildStat
                        icon={<Zap />}
                        label="Tổng PP"
                        value={String(totalPp)}
                    />
                    <BuildStat
                        icon={<Layers3 />}
                        label="Độ phủ Hệ"
                        value={`${elements.length} Hệ`}
                    />
                    <BuildStat
                        icon={<Target />}
                        label="Diện rộng"
                        value={`${areaSkillCount} Skill`}
                    />
                    <BuildStat
                        icon={<UsersRound />}
                        label="Effect"
                        value={`${effectNames.length} loại`}
                    />
                </div>
            </div>

            <aside className="border border-white/8 bg-black/12 p-4">
                <p className="font-mono text-[9px] font-black tracking-[.14em] text-amber-300 uppercase">
                    Phân tích Combo
                </p>

                <div className="mt-3 flex flex-wrap gap-2">
                    {elements.length > 0 ? (
                        elements.map((element) => (
                            <ElementBadge
                                key={element.slug}
                                element={element}
                            />
                        ))
                    ) : (
                        <span className="text-xs text-slate-600">
                            Chưa có độ phủ nguyên tố.
                        </span>
                    )}
                </div>

                <div className="mt-4 grid gap-2">
                    {comboHints.length > 0 ? (
                        comboHints.map((hint) => (
                            <div
                                key={hint}
                                className="flex items-start gap-2 border-l-2 border-cyan-300/45 bg-cyan-300/5 p-3 text-xs leading-5 text-slate-300"
                            >
                                <Sparkles className="mt-0.5 size-3.5 shrink-0 text-amber-300" />
                                {hint}
                            </div>
                        ))
                    ) : (
                        <p className="border border-dashed border-white/10 p-3 text-xs leading-5 text-slate-500">
                            Lắp thêm Skill để hệ thống nhận diện chuỗi khống
                            chế, cường hóa, phòng thủ hoặc hồi phục.
                        </p>
                    )}
                </div>

                {effectNames.length > 0 && (
                    <div className="mt-4 border-t border-white/8 pt-4">
                        <span className="text-[9px] font-bold text-slate-500 uppercase">
                            Chuỗi Effect hiện có
                        </span>
                        <p className="mt-2 font-mono text-xs text-cyan-100">
                            {effectNames.join(' → ')}
                        </p>
                    </div>
                )}
            </aside>
        </div>
    );
}

function BuildStat({
    icon,
    label,
    value,
}: {
    icon: ReactNode;
    label: string;
    value: string;
}) {
    return (
        <div className="bg-[#06121e] p-3">
            <span className="flex items-center gap-2 text-[9px] text-slate-500 [&_svg]:size-3.5 [&_svg]:text-cyan-300">
                {icon}
                {label}
            </span>
            <strong className="mt-1 block font-mono text-sm text-white">
                {value}
            </strong>
        </div>
    );
}

function buildComboHints(skills: WikiSkillCatalogEntry[]): string[] {
    const categories = new Set(skills.map((skill) => skill.combat_category));
    const hints: string[] = [];

    if (
        (categories.has('control') || categories.has('disrupt')) &&
        (categories.has('damage') || categories.has('hybrid'))
    ) {
        hints.push(
            'Khống chế hoặc gây rối trước, sau đó chuyển sang nhịp dồn sát thương.',
        );
    }

    if (
        categories.has('buff') &&
        (categories.has('damage') || categories.has('hybrid'))
    ) {
        hints.push(
            'Cường hóa bản thân hoặc đồng minh trước khi tung Skill tấn công.',
        );
    }

    if (categories.has('defense') && categories.has('heal')) {
        hints.push(
            'Lá chắn kết hợp hồi phục tạo lõi phòng thủ bền cho đội hình 2V2.',
        );
    }

    if (
        skills.some((skill) => skill.target_pattern === 'all_allies') &&
        skills.some((skill) => skill.target_pattern === 'all_enemies')
    ) {
        hints.push(
            'Build bao phủ cả toàn đội và toàn bộ đối thủ trong cùng một vòng chiến đấu.',
        );
    }

    return hints;
}
