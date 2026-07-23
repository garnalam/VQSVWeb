import { Link } from '@inertiajs/react';
import { ChevronLeft, ChevronRight } from 'lucide-react';
import { Button } from '@/components/ui/button';
import type { PaginatedWikiData, WikiPaginationHref } from '@/types';

type WikiPaginationProps = {
    pagination: Pick<
        PaginatedWikiData<unknown>,
        'current_page' | 'last_page' | 'from' | 'to' | 'total'
    >;
    previousHref: WikiPaginationHref;
    nextHref: WikiPaginationHref;
};

export function WikiPagination({
    pagination,
    previousHref,
    nextHref,
}: WikiPaginationProps) {
    if (pagination.total === 0) {
        return null;
    }

    return (
        <div className="relative flex flex-col items-center justify-between gap-4 overflow-hidden border border-white/8 bg-[#081522]/88 px-5 py-4 shadow-[0_16px_38px_rgba(0,0,0,.24)] before:absolute before:inset-x-0 before:top-0 before:h-px before:bg-linear-to-r before:from-[var(--wiki-shell-accent)] before:to-transparent sm:flex-row">
            <p className="text-sm text-slate-400">
                Hiển thị{' '}
                <strong className="font-bold text-white">
                    {pagination.from}–{pagination.to}
                </strong>{' '}
                trong {pagination.total} kết quả
            </p>
            <div className="flex items-center gap-2">
                <Button
                    variant="outline"
                    size="sm"
                    className="rounded-none border-white/10 bg-white/4 text-slate-300 transition hover:border-[var(--wiki-shell-accent)]/45 hover:bg-[var(--wiki-shell-accent)]/10 hover:text-white"
                    asChild
                >
                    <Link
                        href={previousHref}
                        preserveScroll
                        aria-disabled={pagination.current_page <= 1}
                        className={
                            pagination.current_page <= 1
                                ? 'pointer-events-none opacity-50'
                                : undefined
                        }
                    >
                        <ChevronLeft />
                        Trước
                    </Link>
                </Button>
                <span className="min-w-20 bg-[var(--wiki-shell-accent)] px-3 py-1.5 text-center font-mono text-xs font-black text-[#07111e] tabular-nums [clip-path:polygon(6px_0,100%_0,calc(100%_-_6px)_100%,0_100%)]">
                    {pagination.current_page} / {pagination.last_page}
                </span>
                <Button
                    variant="outline"
                    size="sm"
                    className="rounded-none border-white/10 bg-white/4 text-slate-300 transition hover:border-[var(--wiki-shell-accent)]/45 hover:bg-[var(--wiki-shell-accent)]/10 hover:text-white"
                    asChild
                >
                    <Link
                        href={nextHref}
                        preserveScroll
                        aria-disabled={
                            pagination.current_page >= pagination.last_page
                        }
                        className={
                            pagination.current_page >= pagination.last_page
                                ? 'pointer-events-none opacity-50'
                                : undefined
                        }
                    >
                        Sau
                        <ChevronRight />
                    </Link>
                </Button>
            </div>
        </div>
    );
}
