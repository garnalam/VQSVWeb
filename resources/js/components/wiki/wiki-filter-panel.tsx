import { Link } from '@inertiajs/react';
import { RotateCcw, Search, SlidersHorizontal } from 'lucide-react';
import type { FormEvent, ReactNode } from 'react';
import { Button } from '@/components/ui/button';
import { Input } from '@/components/ui/input';
import { gameUi } from '@/lib/game-assets';
import type { WikiPaginationHref } from '@/types';

type WikiFilterPanelProps = {
    query: string;
    onQueryChange: (value: string) => void;
    onSubmit: (event: FormEvent<HTMLFormElement>) => void;
    resetHref: WikiPaginationHref;
    placeholder: string;
    children: ReactNode;
};

export function WikiFilterPanel({
    query,
    onQueryChange,
    onSubmit,
    resetHref,
    placeholder,
    children,
}: WikiFilterPanelProps) {
    return (
        <form
            onSubmit={onSubmit}
            className="relative border border-cyan-200/14 bg-[#081522]/94 p-3 shadow-[0_18px_45px_rgba(0,0,0,.28)] [clip-path:polygon(0_10px,10px_0,calc(100%_-_14px)_0,100%_14px,100%_100%,14px_100%,0_calc(100%_-_14px))] sm:p-4"
        >
            <div className="absolute inset-x-0 top-0 h-px bg-linear-to-r from-cyan-300 via-[var(--wiki-shell-accent)] to-transparent" />
            <div className="mb-3 flex items-center justify-between gap-3 px-1">
                <div className="flex items-center gap-2 font-mono text-[9px] font-black tracking-[.18em] text-cyan-200 uppercase">
                    <SlidersHorizontal className="size-3.5 text-[var(--wiki-shell-accent)]" />
                    Bộ lọc dữ liệu
                    <span className="hidden text-slate-600 sm:inline">
                        // Query console
                    </span>
                </div>
                <img
                    src={gameUi.progressCyan}
                    alt=""
                    className="wiki-pixel-art h-3 w-auto max-w-28 opacity-55"
                />
            </div>

            <div className="grid grid-cols-1 gap-2.5 sm:grid-cols-2 lg:grid-cols-4 xl:grid-cols-6">
                <label className="relative block sm:col-span-2">
                    <span className="sr-only">Tìm kiếm</span>
                    <Search className="pointer-events-none absolute top-1/2 left-3.5 size-4 -translate-y-1/2 text-[var(--wiki-shell-accent)]" />
                    <Input
                        value={query}
                        onChange={(event) => onQueryChange(event.target.value)}
                        placeholder={placeholder}
                        className="h-11 rounded-none border-cyan-100/12 bg-white/5 pl-10 text-white shadow-inner placeholder:text-slate-500 focus-visible:border-[var(--wiki-shell-accent)]/65 focus-visible:ring-[var(--wiki-shell-accent)]/15"
                    />
                </label>
                {children}
                <div className="flex h-11 gap-2 sm:col-span-2 lg:col-span-1">
                    <Button
                        variant="ghost"
                        size="icon"
                        className="h-11 w-11 shrink-0 rounded-none border border-white/8 bg-white/4 text-slate-400 hover:border-white/16 hover:bg-white/8 hover:text-white"
                        asChild
                    >
                        <Link
                            href={resetHref}
                            preserveScroll
                            aria-label="Đặt lại bộ lọc"
                        >
                            <RotateCcw />
                        </Link>
                    </Button>
                    <Button
                        type="submit"
                        className="group h-11 flex-1 rounded-none border border-[var(--wiki-shell-accent)] bg-[var(--wiki-shell-accent)] px-5 font-black text-[#07111e] shadow-[0_0_22px_color-mix(in_oklab,var(--wiki-shell-accent)_22%,transparent)] [clip-path:polygon(8px_0,100%_0,100%_calc(100%_-_8px),calc(100%_-_8px)_100%,0_100%,0_8px)] hover:bg-white"
                    >
                        <Search className="transition-transform group-hover:scale-110" />
                        Tra cứu
                    </Button>
                </div>
            </div>
        </form>
    );
}
