import { Head, Link } from '@inertiajs/react';
import {
    BatteryFull,
    ChevronDown,
    ChevronLeft,
    ChevronRight,
    ChevronUp,
    CircleDot,
    Gamepad2,
    Keyboard,
    Maximize2,
    Monitor,
    Pause,
    Play,
    RotateCcw,
    Settings2,
    Smartphone,
    Volume2,
    VolumeX,
    Wifi,
    Zap,
} from 'lucide-react';
import type { PointerEvent as ReactPointerEvent, ReactNode } from 'react';
import { useCallback, useEffect, useMemo, useRef, useState } from 'react';
import { gameDecor, petArtworkUrl } from '@/lib/game-assets';

type InputKey =
    'up' | 'down' | 'left' | 'right' | 'a' | 'b' | 'start' | 'select';
type InputSource = 'keyboard' | 'touch' | 'gamepad';

const sourceKeys: InputKey[] = [
    'up',
    'down',
    'left',
    'right',
    'a',
    'b',
    'start',
    'select',
];

const keyboardMap: Record<string, InputKey> = {
    ArrowUp: 'up',
    w: 'up',
    W: 'up',
    ArrowDown: 'down',
    s: 'down',
    S: 'down',
    ArrowLeft: 'left',
    a: 'left',
    A: 'left',
    ArrowRight: 'right',
    d: 'right',
    D: 'right',
    z: 'a',
    Z: 'a',
    x: 'b',
    X: 'b',
    Enter: 'start',
    Shift: 'select',
};

const keyLabels: Record<InputKey, string> = {
    up: 'Lên',
    down: 'Xuống',
    left: 'Trái',
    right: 'Phải',
    a: 'A',
    b: 'B',
    start: 'Start',
    select: 'Select',
};

const petSprites = [
    { id: 56, name: 'Mực Ma', side: 'ally' },
    { id: 57, name: 'Cá Đèn Lồng', side: 'enemy' },
] as const;

export default function Emulator() {
    const sourceState = useRef<Record<InputKey, Set<InputSource>>>(
        Object.fromEntries(
            sourceKeys.map((key) => [key, new Set<InputSource>()]),
        ) as Record<InputKey, Set<InputSource>>,
    );
    const activeInputsRef = useRef<Set<InputKey>>(new Set());
    const [activeInputs, setActiveInputs] = useState<Set<InputKey>>(new Set());
    const [lastInput, setLastInput] = useState('Sẵn sàng');
    const [gamepadConnected, setGamepadConnected] = useState(false);
    const [paused, setPaused] = useState(false);
    const [muted, setMuted] = useState(false);
    const [screenScale, setScreenScale] = useState('Tự động');
    const [showSettings, setShowSettings] = useState(false);

    const syncSource = useCallback(
        (key: InputKey, source: InputSource, pressed: boolean) => {
            const sources = sourceState.current[key];
            if (pressed) {
                sources.add(source);
            } else {
                sources.delete(source);
            }

            const next = new Set<InputKey>();
            sourceKeys.forEach((sourceKey) => {
                if (sourceState.current[sourceKey].size > 0) {
                    next.add(sourceKey);
                }
            });

            const previous = activeInputsRef.current;
            const changed =
                previous.size !== next.size ||
                sourceKeys.some(
                    (sourceKey) =>
                        previous.has(sourceKey) !== next.has(sourceKey),
                );
            if (changed) {
                activeInputsRef.current = next;
                setActiveInputs(next);
            }
        },
        [],
    );

    const pressInput = useCallback(
        (key: InputKey, source: InputSource) => {
            syncSource(key, source, true);
            setLastInput(
                `${keyLabels[key]} · ${source === 'touch' ? 'cảm ứng' : source}`,
            );
        },
        [syncSource],
    );

    const releaseInput = useCallback(
        (key: InputKey, source: InputSource) => syncSource(key, source, false),
        [syncSource],
    );

    useEffect(() => {
        const onKeyDown = (event: KeyboardEvent) => {
            const key = keyboardMap[event.key];
            if (!key) {
                return;
            }
            event.preventDefault();
            pressInput(key, 'keyboard');
        };
        const onKeyUp = (event: KeyboardEvent) => {
            const key = keyboardMap[event.key];
            if (key) {
                releaseInput(key, 'keyboard');
            }
        };
        const releaseAll = () => {
            sourceKeys.forEach((key) => releaseInput(key, 'keyboard'));
        };

        window.addEventListener('keydown', onKeyDown);
        window.addEventListener('keyup', onKeyUp);
        window.addEventListener('blur', releaseAll);
        return () => {
            window.removeEventListener('keydown', onKeyDown);
            window.removeEventListener('keyup', onKeyUp);
            window.removeEventListener('blur', releaseAll);
        };
    }, [pressInput, releaseInput]);

    useEffect(() => {
        let animationFrame = 0;
        let previousGamepadState = '';

        const pollGamepad = () => {
            const pad = navigator
                .getGamepads?.()
                .find((candidate): candidate is Gamepad => candidate !== null);
            const connected = Boolean(pad);
            setGamepadConnected((current) =>
                current === connected ? current : connected,
            );
            if (pad) {
                const axes = pad.axes ?? [];
                const buttons = pad.buttons ?? [];
                const state = [
                    axes[1] < -0.45,
                    axes[1] > 0.45,
                    axes[0] < -0.45,
                    axes[0] > 0.45,
                    Boolean(buttons[0]?.pressed),
                    Boolean(buttons[1]?.pressed),
                    Boolean(buttons[9]?.pressed),
                    Boolean(buttons[8]?.pressed),
                ]
                    .map(String)
                    .join('|');
                if (state !== previousGamepadState) {
                    previousGamepadState = state;
                    (
                        [
                            'up',
                            'down',
                            'left',
                            'right',
                            'a',
                            'b',
                            'start',
                            'select',
                        ] as InputKey[]
                    ).forEach((key, index) =>
                        syncSource(
                            key,
                            'gamepad',
                            state.split('|')[index] === 'true',
                        ),
                    );
                    if (
                        state !==
                        'false|false|false|false|false|false|false|false'
                    ) {
                        setLastInput('Gamepad · đang điều khiển');
                    }
                }
            } else if (previousGamepadState) {
                previousGamepadState = '';
                sourceKeys.forEach((key) => syncSource(key, 'gamepad', false));
            }
            animationFrame = window.requestAnimationFrame(pollGamepad);
        };

        animationFrame = window.requestAnimationFrame(pollGamepad);
        return () => window.cancelAnimationFrame(animationFrame);
    }, [syncSource]);

    const activeLabel = useMemo(() => {
        const labels = sourceKeys
            .filter((key) => activeInputs.has(key))
            .map((key) => keyLabels[key]);
        return labels.length > 0
            ? labels.join(' + ')
            : 'Không có nút đang nhấn';
    }, [activeInputs]);

    const toggleFullscreen = () => {
        if (!document.fullscreenElement) {
            void document.documentElement.requestFullscreen?.();
        } else {
            void document.exitFullscreen?.();
        }
    };

    const handleTouch = (key: InputKey, pressed: boolean) => {
        if (pressed) {
            pressInput(key, 'touch');
        } else {
            releaseInput(key, 'touch');
        }
    };

    const resetSession = () => {
        sourceKeys.forEach((key) => {
            sourceState.current[key].clear();
        });
        activeInputsRef.current = new Set();
        setActiveInputs(new Set());
        setPaused(false);
        setLastInput('Phiên đã khởi động lại');
    };

    return (
        <div className="emulator-app min-h-dvh text-white">
            <Head title="Web Emulator" />

            <header className="emulator-topbar">
                <Link
                    href="/wiki/pets"
                    className="emulator-brand"
                    aria-label="Quay lại Bách khoa VQSV"
                >
                    <img
                        src={gameDecor.logo}
                        alt="VQSV"
                        className="h-9 w-auto object-contain"
                    />
                    <span>
                        <strong>WEB EMULATOR</strong>
                        <small>VQSV LIỆT HỎA</small>
                    </span>
                </Link>
                <div className="emulator-topbar-actions">
                    <span className="emulator-live-status">
                        <i /> Trực tuyến
                    </span>
                    <button
                        className="emulator-icon-button"
                        type="button"
                        onClick={() => setShowSettings((value) => !value)}
                        aria-label="Mở cài đặt emulator"
                        title="Cài đặt emulator"
                    >
                        <Settings2 className="size-4" />
                    </button>
                </div>
            </header>

            <main className="emulator-layout">
                <section
                    className="emulator-console"
                    aria-label="Khu vực chơi emulator"
                >
                    <div className="emulator-console-heading">
                        <div>
                            <p className="emulator-eyebrow">
                                VQSV / SESSION 01
                            </p>
                            <h1>Chơi ngay trên trình duyệt</h1>
                        </div>
                        <div className="emulator-heading-actions">
                            <button
                                className="emulator-secondary-button"
                                type="button"
                                onClick={() => setPaused((value) => !value)}
                            >
                                {paused ? (
                                    <Play className="size-4" />
                                ) : (
                                    <Pause className="size-4" />
                                )}
                                <span>{paused ? 'Tiếp tục' : 'Tạm dừng'}</span>
                            </button>
                            <button
                                className="emulator-icon-button"
                                type="button"
                                onClick={toggleFullscreen}
                                aria-label="Toàn màn hình"
                                title="Toàn màn hình"
                            >
                                <Maximize2 className="size-4" />
                            </button>
                        </div>
                    </div>

                    <div className="emulator-play-area">
                        <div
                            className={`emulator-screen-shell ${paused ? 'is-paused' : ''} scale-${screenScale === 'Tự động' ? 'auto' : screenScale}`}
                        >
                            <div
                                className="emulator-screen"
                                tabIndex={0}
                                role="application"
                                aria-label="Màn hình game VQSV"
                            >
                                <div className="emulator-screen-vignette" />
                                <div className="emulator-screen-header">
                                    <span>VQSV / LIỆT HỎA</span>
                                    <span className="emulator-screen-battery">
                                        <BatteryFull className="size-3" /> 100%
                                    </span>
                                </div>
                                <div className="emulator-map-label">
                                    <span>NIÊM THỔ</span>
                                    <small>BẾN CẢNG</small>
                                </div>
                                <div className="emulator-pet-stage">
                                    {petSprites.map((pet) => (
                                        <div
                                            key={pet.id}
                                            className={`emulator-pet emulator-pet-${pet.side}`}
                                        >
                                            <div className="emulator-pet-shadow" />
                                            <img
                                                src={petArtworkUrl(pet.id)}
                                                alt={pet.name}
                                            />
                                            <span>{pet.name}</span>
                                        </div>
                                    ))}
                                </div>
                                <div className="emulator-player-chip">
                                    <CircleDot className="size-3" /> NGƯỜI CHƠI
                                    01
                                </div>
                                <div className="emulator-dialog-box">
                                    <span className="emulator-dialog-name">
                                        VQSV
                                    </span>
                                    <p>
                                        {paused
                                            ? 'Emulator đang tạm dừng.'
                                            : 'Sẵn sàng khám phá thế giới Pet.'}
                                    </p>
                                    <span className="emulator-dialog-arrow">
                                        ▼
                                    </span>
                                </div>
                                <div className="emulator-screen-footer">
                                    <span>HP 100%</span>
                                    <span>EXP 41 / 60</span>
                                </div>
                                {paused && (
                                    <div className="emulator-pause-layer">
                                        <Pause className="size-7" />
                                        <span>TẠM DỪNG</span>
                                    </div>
                                )}
                            </div>
                        </div>

                        <div
                            className="emulator-touch-controls"
                            aria-label="Điều khiển cảm ứng"
                        >
                            <DpadButton
                                keyName="up"
                                icon={<ChevronUp />}
                                onChange={handleTouch}
                                active={activeInputs.has('up')}
                            />
                            <DpadButton
                                keyName="left"
                                icon={<ChevronLeft />}
                                onChange={handleTouch}
                                active={activeInputs.has('left')}
                            />
                            <DpadButton
                                keyName="right"
                                icon={<ChevronRight />}
                                onChange={handleTouch}
                                active={activeInputs.has('right')}
                            />
                            <DpadButton
                                keyName="down"
                                icon={<ChevronDown />}
                                onChange={handleTouch}
                                active={activeInputs.has('down')}
                            />
                            <div className="emulator-action-cluster">
                                <TouchButton
                                    keyName="b"
                                    label="B"
                                    tone="blue"
                                    onChange={handleTouch}
                                    active={activeInputs.has('b')}
                                />
                                <TouchButton
                                    keyName="a"
                                    label="A"
                                    tone="pink"
                                    onChange={handleTouch}
                                    active={activeInputs.has('a')}
                                />
                            </div>
                            <div className="emulator-system-cluster">
                                <TouchButton
                                    keyName="select"
                                    label="SELECT"
                                    tone="dark"
                                    onChange={handleTouch}
                                    active={activeInputs.has('select')}
                                />
                                <TouchButton
                                    keyName="start"
                                    label="START"
                                    tone="dark"
                                    onChange={handleTouch}
                                    active={activeInputs.has('start')}
                                />
                            </div>
                        </div>
                    </div>
                </section>

                <aside className="emulator-sidebar">
                    <section className="emulator-status-panel">
                        <div className="emulator-panel-heading">
                            <span>THIẾT BỊ</span>
                            <Smartphone className="size-4 text-cyan-300" />
                        </div>
                        <div className="emulator-device-row">
                            <div className="emulator-device-icon">
                                <Monitor className="size-4" />
                            </div>
                            <div>
                                <strong>Web runtime</strong>
                                <small>Responsive canvas · 240 × 320</small>
                            </div>
                            <span className="emulator-ok-dot" />
                        </div>
                        <div className="emulator-device-row">
                            <div className="emulator-device-icon">
                                <Gamepad2 className="size-4" />
                            </div>
                            <div>
                                <strong>
                                    {gamepadConnected
                                        ? 'Gamepad đã kết nối'
                                        : 'Gamepad sẵn sàng'}
                                </strong>
                                <small>
                                    {gamepadConnected
                                        ? 'Bấm nút để điều khiển'
                                        : 'Kết nối tay cầm USB / Bluetooth'}
                                </small>
                            </div>
                            <span
                                className={`emulator-device-state ${gamepadConnected ? 'connected' : ''}`}
                            >
                                {gamepadConnected ? 'ON' : '—'}
                            </span>
                        </div>
                        <div className="emulator-device-row">
                            <div className="emulator-device-icon">
                                <Keyboard className="size-4" />
                            </div>
                            <div>
                                <strong>Keyboard</strong>
                                <small>WASD / mũi tên · Z / X · Enter</small>
                            </div>
                            <span className="emulator-device-state connected">
                                ON
                            </span>
                        </div>
                    </section>

                    <section className="emulator-status-panel emulator-input-panel">
                        <div className="emulator-panel-heading">
                            <span>INPUT MONITOR</span>
                            <Zap className="size-4 text-amber-300" />
                        </div>
                        <div className="emulator-input-readout">
                            <span>Đang nhấn</span>
                            <strong>{activeLabel}</strong>
                        </div>
                        <div className="emulator-last-input">
                            <span>Hoạt động gần nhất</span>
                            <strong>{lastInput}</strong>
                        </div>
                        <div className="emulator-key-grid">
                            {(
                                [
                                    'WASD',
                                    'Mũi tên',
                                    'Z / X',
                                    'Enter',
                                    'Shift',
                                ] as string[]
                            ).map((key) => (
                                <span key={key}>{key}</span>
                            ))}
                        </div>
                    </section>

                    <section className="emulator-status-panel emulator-quick-panel">
                        <div className="emulator-panel-heading">
                            <span>NHANH</span>
                            <Wifi className="size-4 text-emerald-300" />
                        </div>
                        <div className="emulator-quick-actions">
                            <button
                                type="button"
                                onClick={() => setMuted((value) => !value)}
                            >
                                {muted ? (
                                    <VolumeX className="size-4" />
                                ) : (
                                    <Volume2 className="size-4" />
                                )}{' '}
                                {muted ? 'Bật âm thanh' : 'Tắt âm thanh'}
                            </button>
                            <button type="button" onClick={resetSession}>
                                <RotateCcw className="size-4" /> Reset phiên
                            </button>
                        </div>
                    </section>

                    {showSettings && (
                        <section className="emulator-status-panel emulator-settings-panel">
                            <div className="emulator-panel-heading">
                                <span>HIỂN THỊ</span>
                                <Settings2 className="size-4 text-cyan-300" />
                            </div>
                            <label htmlFor="screen-scale">Tỉ lệ màn hình</label>
                            <select
                                id="screen-scale"
                                value={screenScale}
                                onChange={(event) =>
                                    setScreenScale(event.target.value)
                                }
                            >
                                <option>Tự động</option>
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                            </select>
                        </section>
                    )}
                </aside>
            </main>
        </div>
    );
}

function DpadButton({
    keyName,
    icon,
    active,
    onChange,
}: {
    keyName: InputKey;
    icon: ReactNode;
    active: boolean;
    onChange: (key: InputKey, pressed: boolean) => void;
}) {
    return (
        <TouchButton
            keyName={keyName}
            label=""
            icon={icon}
            tone="dpad"
            onChange={onChange}
            active={active}
        />
    );
}

function TouchButton({
    keyName,
    label,
    tone,
    icon,
    active,
    onChange,
}: {
    keyName: InputKey;
    label: string;
    tone: 'blue' | 'pink' | 'dark' | 'dpad';
    icon?: ReactNode;
    active: boolean;
    onChange: (key: InputKey, pressed: boolean) => void;
}) {
    const handlePointer = (
        event: ReactPointerEvent<HTMLButtonElement>,
        pressed: boolean,
    ) => {
        event.preventDefault();
        if (pressed) {
            event.currentTarget.setPointerCapture?.(event.pointerId);
        }
        onChange(keyName, pressed);
    };

    return (
        <button
            type="button"
            data-key={keyName}
            className={`emulator-touch-button tone-${tone} ${active ? 'is-active' : ''}`}
            aria-label={keyLabels[keyName]}
            onPointerDown={(event) => handlePointer(event, true)}
            onPointerUp={(event) => handlePointer(event, false)}
            onPointerCancel={(event) => handlePointer(event, false)}
            onPointerLeave={(event) => {
                if (event.currentTarget.hasPointerCapture?.(event.pointerId))
                    handlePointer(event, false);
            }}
        >
            {icon ?? label}
        </button>
    );
}
