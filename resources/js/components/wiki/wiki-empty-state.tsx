import { SearchX } from 'lucide-react';

export function WikiEmptyState() {
    return (
        <div className="wiki-hologram relative flex min-h-72 flex-col items-center justify-center gap-4 overflow-hidden rounded-[2rem] border border-dashed border-slate-300 bg-linear-to-br from-white via-sky-50 to-violet-50 p-8 text-center shadow-inner dark:border-white/15 dark:from-white/5 dark:via-cyan-400/5 dark:to-violet-400/5">
            <span className="wiki-pulse-ring wiki-float relative flex size-16 items-center justify-center rounded-2xl bg-linear-to-br from-sky-400 to-violet-500 text-white shadow-[0_12px_35px_rgba(99,102,241,0.28)]">
                <SearchX className="size-6" />
            </span>
            <div>
                <h2 className="text-lg font-black">Không tìm thấy dữ liệu</h2>
                <p className="mt-1 text-sm text-slate-500 dark:text-slate-400">
                    Hãy thử từ khóa khác hoặc đặt lại bộ lọc.
                </p>
            </div>
        </div>
    );
}
