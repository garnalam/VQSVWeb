import { ListFilter } from 'lucide-react';

type WikiResultsBarProps = {
    label: string;
    from: number | null;
    to: number | null;
    total: number;
};

export function WikiResultsBar({
    label,
    from,
    to,
    total,
}: WikiResultsBarProps) {
    return (
        <div className="relative flex flex-wrap items-end justify-between gap-3 overflow-hidden border-b border-white/8 px-1 py-3 before:absolute before:top-2 before:bottom-2 before:left-0 before:w-[3px] before:bg-[var(--wiki-shell-accent)] before:shadow-[0_0_12px_var(--wiki-shell-accent)]">
            <div>
                <p className="flex items-center gap-2 pl-4 font-mono text-[9px] font-black tracking-[0.2em] text-[var(--wiki-shell-accent)] uppercase">
                    <ListFilter className="size-3.5" /> Kết quả tra cứu
                </p>
                <h2 className="mt-1 pl-4 text-xl font-black tracking-tight text-white">
                    {label}
                </h2>
            </div>
            <p className="border border-white/10 bg-white/4 px-3 py-1.5 font-mono text-[10px] font-semibold text-slate-400 [clip-path:polygon(6px_0,100%_0,100%_calc(100%_-_6px),calc(100%_-_6px)_100%,0_100%,0_6px)]">
                <strong className="text-[var(--wiki-shell-accent)]">
                    {from ?? 0}–{to ?? 0}
                </strong>{' '}
                / {total} hồ sơ
            </p>
        </div>
    );
}
