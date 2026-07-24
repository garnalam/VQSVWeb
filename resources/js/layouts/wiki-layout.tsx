import { Link, usePage } from '@inertiajs/react';
import {
    Backpack,
    LayoutDashboard,
    LogIn,
    PawPrint,
    Sparkles,
} from 'lucide-react';
import type { CSSProperties, PropsWithChildren } from 'react';
import { gameDecor, gameUi } from '@/lib/game-assets';
import { cn } from '@/lib/utils';
import { dashboard, home, login } from '@/routes';
import { index as itemsIndex } from '@/routes/wiki/items';
import { index as petsIndex } from '@/routes/wiki/pets';
import { index as skillsIndex } from '@/routes/wiki/skills';

const wikiNavigation = [
    {
        code: '01',
        title: 'Pet',
        caption: 'Sinh vật',
        href: petsIndex(),
        icon: PawPrint,
        accent: '#ffb21c',
    },
    {
        code: '02',
        title: 'Kỹ năng',
        caption: 'Chiêu thức',
        href: skillsIndex(),
        icon: Sparkles,
        accent: '#ff4ecb',
    },
    {
        code: '03',
        title: 'Vật phẩm',
        caption: 'Kho đồ',
        href: itemsIndex(),
        icon: Backpack,
        accent: '#6cffb0',
    },
];

export default function WikiLayout({ children }: PropsWithChildren) {
    const page = usePage();
    const { auth } = page.props;
    const activeNavigation =
        wikiNavigation.find((item) => page.url.startsWith(item.href.url)) ??
        wikiNavigation[0];
    const shellStyle = {
        '--wiki-shell-accent': activeNavigation.accent,
    } as CSSProperties;

    return (
        <div
            style={shellStyle}
            className="wiki-shell relative min-h-screen overflow-hidden text-white"
        >
            <div
                style={{
                    backgroundImage: `url(${gameDecor.scenicBackground})`,
                }}
                className="wiki-pixel-art pointer-events-none fixed inset-0 bg-cover bg-center opacity-32"
            />
            <div className="pointer-events-none fixed inset-0 bg-[linear-gradient(90deg,rgba(3,9,18,.96)_0%,rgba(5,15,28,.74)_44%,rgba(4,10,20,.91)_100%),linear-gradient(180deg,rgba(5,14,26,.30),#07111e_88%)]" />
            <div className="wiki-grid pointer-events-none fixed inset-0 opacity-24" />
            <div className="pointer-events-none fixed inset-x-0 top-0 h-44 bg-[radial-gradient(ellipse_at_top,color-mix(in_oklab,var(--wiki-shell-accent)_18%,transparent),transparent_68%)]" />

            <header className="relative z-40 border-b border-cyan-300/18 bg-[#050c17]/90 shadow-[0_14px_40px_rgba(0,0,0,.42)] backdrop-blur-xl">
                <div className="absolute inset-x-0 bottom-0 h-px bg-linear-to-r from-transparent via-[var(--wiki-shell-accent)] to-transparent opacity-80" />
                <div className="mx-auto flex min-h-19 w-full max-w-[1440px] items-center gap-3 px-3 sm:px-6">
                    <Link
                        href={home()}
                        className="group relative flex shrink-0 items-center gap-3 pr-2 lg:pr-7"
                    >
                        <span className="absolute -inset-y-3 -left-8 w-48 -skew-x-12 bg-cyan-400/5 transition group-hover:bg-cyan-400/10" />
                        <img
                            src={gameDecor.logo}
                            alt="Vương Quốc Siêu Thú"
                            className="wiki-pixel-art relative h-12 w-auto max-w-24 object-contain drop-shadow-[0_5px_0_rgba(0,0,0,.42)] transition-transform group-hover:-translate-y-0.5 sm:max-w-32"
                        />
                        <span className="relative hidden border-l border-cyan-200/20 pl-3 xl:block">
                            <span className="block font-mono text-[9px] font-black tracking-[.28em] text-cyan-300 uppercase">
                                Game archive
                            </span>
                            <strong className="mt-1 block text-xs tracking-wide text-white">
                                BÁCH KHOA VQSV
                            </strong>
                        </span>
                    </Link>

                    <nav className="flex min-w-0 flex-1 [scrollbar-width:none] items-center justify-center gap-1.5 overflow-x-auto [&::-webkit-scrollbar]:hidden">
                        {wikiNavigation.map((item) => {
                            const isActive = page.url.startsWith(item.href.url);

                            return (
                                <Link
                                    key={item.code}
                                    href={item.href}
                                    prefetch
                                    style={
                                        {
                                            '--nav-accent': item.accent,
                                        } as CSSProperties
                                    }
                                    className={cn(
                                        'group/nav relative flex h-12 min-w-12 shrink-0 items-center gap-2.5 overflow-hidden border px-3 transition duration-300 [clip-path:polygon(10px_0,100%_0,calc(100%_-_10px)_100%,0_100%)] sm:min-w-35 sm:px-4',
                                        isActive
                                            ? 'border-[var(--nav-accent)]/70 bg-[var(--nav-accent)]/14 text-white shadow-[inset_0_-3px_0_var(--nav-accent),0_0_22px_color-mix(in_oklab,var(--nav-accent)_18%,transparent)]'
                                            : 'border-white/7 bg-white/3 text-slate-400 hover:border-white/18 hover:bg-white/7 hover:text-white',
                                    )}
                                >
                                    <span
                                        className={cn(
                                            'flex size-7 shrink-0 items-center justify-center border font-mono text-[9px] font-black transition [clip-path:polygon(5px_0,100%_0,calc(100%_-_5px)_100%,0_100%)]',
                                            isActive
                                                ? 'border-[var(--nav-accent)] bg-[var(--nav-accent)] text-[#07111e]'
                                                : 'border-white/12 bg-white/5 group-hover/nav:border-[var(--nav-accent)]/55 group-hover/nav:text-[var(--nav-accent)]',
                                        )}
                                    >
                                        {item.code}
                                    </span>
                                    <span className="hidden min-w-0 sm:block">
                                        <strong className="block text-xs leading-none font-black">
                                            {item.title}
                                        </strong>
                                        <span className="mt-1 block font-mono text-[8px] tracking-[.16em] text-slate-500 uppercase group-hover/nav:text-slate-300">
                                            {item.caption}
                                        </span>
                                    </span>
                                    <item.icon className="absolute -right-1 -bottom-2 size-8 rotate-[-12deg] text-[var(--nav-accent)] opacity-0 transition group-hover/nav:opacity-15 sm:block" />
                                </Link>
                            );
                        })}
                    </nav>

                    <Link
                        href={auth.user ? dashboard() : login()}
                        className="group flex h-11 shrink-0 items-center gap-2 border border-cyan-200/16 bg-cyan-300/6 px-3 text-xs font-black text-cyan-100 transition [clip-path:polygon(8px_0,100%_0,100%_calc(100%_-_8px),calc(100%_-_8px)_100%,0_100%,0_8px)] hover:border-cyan-300/45 hover:bg-cyan-300/12 sm:px-4"
                    >
                        {auth.user ? (
                            <LayoutDashboard className="size-4 text-[var(--wiki-shell-accent)]" />
                        ) : (
                            <LogIn className="size-4 text-[var(--wiki-shell-accent)]" />
                        )}
                        <span className="hidden lg:inline">
                            {auth.user ? 'Quản lý' : 'Đăng nhập'}
                        </span>
                    </Link>
                </div>
            </header>

            <main className="relative z-10 mx-auto flex w-full max-w-[1440px] flex-col gap-4 px-3 py-4 sm:gap-5 sm:px-6 sm:py-7">
                {children}
            </main>

            <footer className="relative z-10 mt-12 border-t border-cyan-200/10 bg-[#040a13]/86">
                <div className="mx-auto flex max-w-[1440px] flex-col gap-3 px-4 py-6 text-[10px] font-bold tracking-[.16em] text-slate-500 uppercase sm:flex-row sm:items-center sm:justify-between sm:px-6">
                    <span className="flex items-center gap-2">
                        <i className="size-1.5 bg-[var(--wiki-shell-accent)] shadow-[0_0_10px_var(--wiki-shell-accent)]" />
                        VQSV Database · Dữ liệu giải mã & luật hợp nhất
                    </span>
                    <img
                        src={gameUi.actionToolbar}
                        alt=""
                        className="wiki-pixel-art h-7 w-auto opacity-45"
                    />
                </div>
            </footer>
        </div>
    );
}
