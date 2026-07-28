import {
    Activity,
    Clock3,
    Gauge,
    Pause,
    Play,
    RotateCcw,
    Shield,
    Sparkles,
    Swords,
    Zap,
} from 'lucide-react';
import type { CSSProperties, ReactNode } from 'react';
import { useEffect, useMemo, useState } from 'react';
import { EffectIcon } from '@/components/wiki/effect-badge';
import { GameArtwork } from '@/components/wiki/game-artwork';
import { LietHoaProceduralEffectCanvas } from '@/components/wiki/liet-hoa-procedural-effect-canvas';
import {
    gameDecor,
    petArtworkUrl,
    petSkillAnimationUrl,
} from '@/lib/game-assets';
import { cn } from '@/lib/utils';
import type {
    WikiSkillBattleCombatant,
    WikiSkillBattleEffectRule,
    WikiSkillDetail,
    WikiSkillSourceAnimationEvent,
} from '@/types';

type BattleVisual =
    | 'ready'
    | 'caster-skill'
    | 'source-vfx'
    | 'impact'
    | 'status'
    | 'opponent-skill'
    | 'tick'
    | 'result';

type BattlePhase = {
    id: string;
    label: string;
    title: string;
    narration: string;
    duration: number;
    visual: BattleVisual;
    casterHp: number;
    opponentHp: number;
    casterDelta?: number;
    opponentDelta?: number;
    statusTarget?: 'caster' | 'opponent';
    floatingText?: string;
    sourceEventIndex?: number;
};

type SkillBattlePreviewProps = {
    skill: WikiSkillDetail;
};

export function SkillBattlePreview({ skill }: SkillBattlePreviewProps) {
    const preview = skill.battle_preview;
    const [selectedCasterId, setSelectedCasterId] = useState(
        preview.default_caster_id,
    );
    const [phaseIndex, setPhaseIndex] = useState(0);
    const [isPlaying, setIsPlaying] = useState(false);
    const [playbackId, setPlaybackId] = useState(0);
    const caster =
        preview.caster_options.find((pet) => pet.id === selectedCasterId) ??
        preview.caster_options[0] ??
        null;
    const opponent = preview.opponent;
    const phases = useMemo(
        () =>
            caster === null || opponent === null
                ? []
                : buildBattlePhases(skill, caster, opponent),
        [caster, opponent, skill],
    );
    const activePhase = phases[phaseIndex] ?? null;

    useEffect(() => {
        if (!isPlaying || activePhase === null) {
            return;
        }

        const timer = window.setTimeout(() => {
            if (phaseIndex >= phases.length - 1) {
                setIsPlaying(false);

                return;
            }

            setPhaseIndex((currentPhase) => currentPhase + 1);
        }, activePhase.duration);

        return () => window.clearTimeout(timer);
    }, [activePhase, isPlaying, phaseIndex, phases.length]);

    function replay() {
        setPlaybackId((currentId) => currentId + 1);
        setPhaseIndex(0);
        setIsPlaying(true);
    }

    function selectCaster(petId: number) {
        setSelectedCasterId(petId);
        setPhaseIndex(0);
        setIsPlaying(false);
        setPlaybackId((currentId) => currentId + 1);
    }

    if (caster === null || opponent === null || activePhase === null) {
        return (
            <section
                id="battle-preview"
                className="scroll-mt-34 border border-white/9 bg-[#081522]/92 p-6"
            >
                <p className="text-sm text-slate-400">
                    Skill này chưa có Pet tương thích để dựng Battle Preview.
                </p>
            </section>
        );
    }

    const style = {
        '--battle-accent': skill.element.color,
    } as CSSProperties;

    return (
        <section
            id="battle-preview"
            style={style}
            className="scroll-mt-34 overflow-hidden border border-[var(--battle-accent)]/25 bg-[#07121d] shadow-[0_24px_80px_rgba(0,0,0,.32)]"
        >
            <header className="grid gap-4 border-b border-white/8 p-5 lg:grid-cols-[minmax(0,1fr)_auto] lg:items-end lg:p-6">
                <div>
                    <div className="flex items-center gap-2 font-mono text-[9px] font-black tracking-[.16em] text-[var(--battle-accent)] uppercase">
                        <span className="size-1.5 bg-[var(--battle-accent)] shadow-[0_0_12px_var(--battle-accent)]" />
                        Battle Preview · Liệt Hỏa Core
                    </div>
                    <h2 className="mt-2 text-2xl font-black text-white sm:text-3xl">
                        Xem Skill vận hành trong trận
                    </h2>
                    <p className="mt-2 max-w-3xl text-sm leading-6 text-slate-400">
                        Động tác Pet và VFX có nhãn gốc được đọc từ sprite,
                        atlas và timeline của game. HP, sát thương cùng hậu quả
                        buff/debuff là lớp mô phỏng riêng theo luật Liệt Hỏa.
                    </p>
                    <SourceAnimationStatus skill={skill} />
                </div>

                <div className="flex flex-wrap items-end gap-2">
                    <label className="min-w-52 flex-1 lg:flex-none">
                        <span className="mb-1.5 block font-mono text-[8px] font-black tracking-[.12em] text-slate-500 uppercase">
                            Pet thi triển mặc định
                        </span>
                        <select
                            value={caster.id}
                            onChange={(event) =>
                                selectCaster(Number(event.target.value))
                            }
                            className="h-11 w-full border border-white/10 bg-[#0c1a28] px-3 text-xs font-bold text-white transition outline-none focus:border-[var(--battle-accent)]/50"
                        >
                            {preview.caster_options.map((pet) => (
                                <option key={pet.id} value={pet.id}>
                                    {pet.name} · Lv.{preview.level}
                                </option>
                            ))}
                        </select>
                    </label>
                    <button
                        type="button"
                        onClick={() => setIsPlaying((playing) => !playing)}
                        className="flex h-11 items-center gap-2 border border-white/10 bg-white/5 px-4 text-xs font-black text-white transition hover:border-[var(--battle-accent)]/45 hover:bg-[var(--battle-accent)]/10"
                    >
                        {isPlaying ? (
                            <Pause className="size-4" />
                        ) : (
                            <Play className="size-4" />
                        )}
                        {isPlaying
                            ? 'Tạm dừng'
                            : phaseIndex === 0
                              ? 'Bắt đầu'
                              : 'Tiếp tục'}
                    </button>
                    <button
                        type="button"
                        onClick={replay}
                        className="flex h-11 items-center gap-2 bg-[var(--battle-accent)] px-4 text-xs font-black text-slate-950 transition hover:brightness-110"
                    >
                        <RotateCcw className="size-4" />
                        Xem từ đầu
                    </button>
                </div>
            </header>

            <div className="grid xl:grid-cols-[minmax(0,1.65fr)_minmax(18rem,.75fr)]">
                <div className="relative min-w-0 border-b border-white/8 xl:border-r xl:border-b-0">
                    <BattleStage
                        skill={skill}
                        caster={caster}
                        opponent={opponent}
                        phase={activePhase}
                        playbackId={playbackId}
                    />

                    <div className="grid gap-px border-t border-white/8 bg-white/8 sm:grid-cols-3">
                        <BattleReadout
                            icon={<Swords />}
                            label="Công thức"
                            value={preview.damage.formula}
                        />
                        <BattleReadout
                            icon={<Gauge />}
                            label="Thứ tự lượt"
                            value={
                                caster.stats.agility >= opponent.stats.agility
                                    ? `${caster.name} đi trước`
                                    : `${opponent.name} đi trước`
                            }
                        />
                        <BattleReadout
                            icon={<Shield />}
                            label="Tương quan Hệ"
                            value="Trung tính ×1.0"
                        />
                    </div>
                </div>

                <aside className="flex min-w-0 flex-col bg-[#091827]">
                    <EffectRulePanel skill={skill} />
                    <div className="border-t border-white/8 p-5">
                        <span className="font-mono text-[8px] font-black tracking-[.14em] text-slate-500 uppercase">
                            Diễn biến đang phát
                        </span>
                        <strong className="mt-2 block text-lg text-white">
                            {activePhase.title}
                        </strong>
                        <p className="mt-2 min-h-18 text-sm leading-6 text-slate-400">
                            {activePhase.narration}
                        </p>
                    </div>
                </aside>
            </div>

            <BattleTimeline
                phases={phases}
                activePhaseIndex={phaseIndex}
                onSelect={(index) => {
                    setPhaseIndex(index);
                    setIsPlaying(false);
                    setPlaybackId((currentId) => currentId + 1);
                }}
            />
        </section>
    );
}

function BattleStage({
    skill,
    caster,
    opponent,
    phase,
    playbackId,
}: {
    skill: WikiSkillDetail;
    caster: WikiSkillBattleCombatant;
    opponent: WikiSkillBattleCombatant;
    phase: BattlePhase;
    playbackId: number;
}) {
    const sourceEvent =
        phase.visual === 'source-vfx' && phase.sourceEventIndex !== undefined
            ? skill.battle_preview.source_animation.events[
                  phase.sourceEventIndex
              ]
            : undefined;
    const casterAnimating =
        phase.visual === 'caster-skill' ||
        sourceEvent?.timeline_mode === 'concurrent_caster_action' ||
        (phase.visual === 'tick' && phase.id.includes('follow-up'));
    const opponentAnimating = phase.visual === 'opponent-skill';
    const hiddenProceduralAnchor =
        sourceEvent?.kind === 'procedural_pet_effect'
            ? sourceEvent.anchor
            : null;

    return (
        <div className="relative isolate min-h-105 overflow-hidden sm:min-h-120">
            <img
                src={gameDecor.scenicBackground}
                alt=""
                aria-hidden="true"
                className="wiki-pixel-art absolute inset-0 -z-30 size-full object-cover object-[50%_72%] opacity-75 saturate-75"
            />
            <div className="absolute inset-0 -z-20 bg-[linear-gradient(180deg,rgba(3,10,18,.18),rgba(3,10,18,.08)_48%,rgba(3,10,18,.78))]" />
            <div className="wiki-grid absolute inset-0 -z-10 [mask-image:linear-gradient(to_bottom,black,transparent_70%)] opacity-20" />
            <div className="absolute top-3 left-3 z-30 border border-white/10 bg-[#06111d]/88 px-3 py-2 backdrop-blur-md sm:top-5 sm:left-5">
                <span className="font-mono text-[8px] text-slate-500 uppercase">
                    Pha {phase.label}
                </span>
                <strong className="mt-0.5 block text-xs text-white">
                    {phase.title}
                </strong>
            </div>

            <CombatantHud combatant={caster} hp={phase.casterHp} side="left" />
            <CombatantHud
                combatant={opponent}
                hp={phase.opponentHp}
                side="right"
            />

            <CombatantSprite
                combatant={caster}
                side="left"
                isAnimating={casterAnimating}
                animationKey={`${playbackId}-${phase.id}`}
                delta={phase.casterDelta}
                hasStatus={phase.statusTarget === 'caster'}
                effectTone={skill.battle_preview.effect_rule.tone}
                isHidden={hiddenProceduralAnchor === 'caster'}
            />
            <CombatantSprite
                combatant={opponent}
                side="right"
                isAnimating={opponentAnimating}
                animationKey={`${playbackId}-${phase.id}`}
                delta={phase.opponentDelta}
                hasStatus={phase.statusTarget === 'opponent'}
                effectTone={skill.battle_preview.effect_rule.tone}
                isHidden={hiddenProceduralAnchor === 'opponent'}
            />

            <OriginalSkillVfx
                skill={skill}
                phase={phase}
                playbackId={playbackId}
                caster={caster}
                opponent={opponent}
            />

            {phase.visual === 'tick' && (
                <div
                    key={`${phase.id}-${playbackId}`}
                    className="skill-battle-tick absolute top-1/2 left-1/2 z-30 -translate-1/2 border border-[var(--battle-accent)]/35 bg-[#06111d]/92 px-5 py-3 text-center shadow-2xl"
                >
                    <Activity className="mx-auto size-5 text-[var(--battle-accent)]" />
                    <strong className="mt-1 block text-sm text-white">
                        {phase.floatingText ?? 'Kích hoạt hiệu ứng lượt kế'}
                    </strong>
                </div>
            )}

            <div className="absolute right-3 bottom-3 left-3 z-30 border border-white/10 bg-[#06111d]/88 px-4 py-3 backdrop-blur-md sm:right-5 sm:bottom-5 sm:left-5">
                <div className="flex items-start gap-3">
                    <span className="mt-0.5 flex size-7 shrink-0 items-center justify-center border border-[var(--battle-accent)]/30 bg-[var(--battle-accent)]/10">
                        <Zap className="size-3.5 text-[var(--battle-accent)]" />
                    </span>
                    <p className="text-xs leading-5 text-slate-300">
                        {phase.narration}
                    </p>
                </div>
            </div>
        </div>
    );
}

function SourceAnimationStatus({ skill }: { skill: WikiSkillDetail }) {
    const animation = skill.battle_preview.source_animation;
    const isOriginal = animation.provenance === 'decoded_original';

    return (
        <div className="mt-3 flex flex-wrap gap-2">
            <span
                className={cn(
                    'border px-2.5 py-1 font-mono text-[8px] font-black tracking-[.1em] uppercase',
                    isOriginal
                        ? 'border-emerald-300/25 bg-emerald-300/8 text-emerald-200'
                        : 'border-amber-300/25 bg-amber-300/8 text-amber-200',
                )}
            >
                {animation.label}
            </span>
            <span className="border border-cyan-300/15 bg-cyan-300/5 px-2.5 py-1 font-mono text-[8px] text-cyan-100/75 uppercase">
                Hậu hiệu ứng: mô phỏng Liệt Hỏa
            </span>
        </div>
    );
}

function OriginalSkillVfx({
    skill,
    phase,
    playbackId,
    caster,
    opponent,
}: {
    skill: WikiSkillDetail;
    phase: BattlePhase;
    playbackId: number;
    caster: WikiSkillBattleCombatant;
    opponent: WikiSkillBattleCombatant;
}) {
    if (phase.visual !== 'source-vfx' || phase.sourceEventIndex === undefined) {
        return null;
    }

    const event = skill.battle_preview.source_animation.events[
        phase.sourceEventIndex
    ] as WikiSkillSourceAnimationEvent | undefined;

    if (event?.render_status !== 'decoded_original') {
        return null;
    }

    const anchorCombatant = event.anchor === 'caster' ? caster : opponent;
    const isProcedural = event.kind === 'procedural_pet_effect';
    const snapshot =
        anchorCombatant.effect_snapshots[
            String(event.snapshot_composition_state ?? 0)
        ];
    const fallbackArtworkUrl = petArtworkUrl(
        anchorCombatant.sprite_id,
        anchorCombatant.game_source.asset_key,
    );
    const usesSourceOrigin =
        event.origin_x !== undefined &&
        event.origin_y !== undefined &&
        event.frame_width !== undefined &&
        event.frame_height !== undefined;
    const sourceScale = 1.5;
    const sourcePlacement = usesSourceOrigin
        ? ({
              left: `calc(50% + ${(event.origin_x ?? 0) * sourceScale}px)`,
              top: `calc(75% + ${(event.origin_y ?? 0) * sourceScale}px)`,
              width: `${(event.frame_width ?? 0) * sourceScale}px`,
              height: `${(event.frame_height ?? 0) * sourceScale}px`,
          } as CSSProperties)
        : undefined;

    return (
        <div
            key={`${event.index}-${playbackId}-${phase.id}`}
            className={cn(
                'pointer-events-none absolute bottom-20 z-20 flex h-52 w-[44%] items-center justify-center sm:h-64',
                event.anchor === 'caster' ? 'left-[3%]' : 'right-[3%]',
            )}
        >
            {isProcedural ? (
                <div className="relative size-36 sm:size-48">
                    <LietHoaProceduralEffectCanvas
                        artworkUrl={snapshot?.url ?? fallbackArtworkUrl}
                        fallbackArtworkUrl={fallbackArtworkUrl}
                        originX={snapshot?.origin_x ?? 0}
                        originY={snapshot?.origin_y ?? 0}
                        direction={event.anchor === 'opponent' ? 1 : 0}
                        event={event}
                        playbackKey={`${playbackId}-${phase.id}`}
                        className="wiki-pixel-art absolute top-1/2 left-1/2 max-w-none -translate-1/2 drop-shadow-[0_12px_16px_rgba(0,0,0,.35)]"
                    />
                </div>
            ) : (
                event.url !== undefined && (
                    <img
                        src={`${event.url}?preview=${playbackId}-${phase.id}`}
                        alt={`VFX gốc của ${skill.name}`}
                        style={sourcePlacement}
                        className={cn(
                            'wiki-pixel-art object-contain drop-shadow-[0_12px_16px_rgba(0,0,0,.35)]',
                            usesSourceOrigin
                                ? 'absolute max-w-none'
                                : 'max-h-full max-w-full',
                            event.global_transform === undefined &&
                                event.anchor === 'caster' &&
                                '-scale-x-100',
                            event.global_transform === 1 && '-scale-x-100',
                        )}
                    />
                )
            )}
            <span className="absolute bottom-1 border border-emerald-300/20 bg-[#06111d]/88 px-2 py-1 font-mono text-[7px] font-black tracking-[.08em] text-emerald-200 uppercase">
                {isProcedural
                    ? anchorCombatant.game_source.asset_key === 'liet-hoa'
                        ? `Pixel renderer gốc · a.a.b · state ${event.snapshot_composition_state ?? 0}`
                        : 'a.a.b gốc · artwork Pet quy đổi'
                    : event.timeline_mode === 'concurrent_caster_action'
                      ? 'Pet + VFX gốc · controller ak'
                      : 'VFX gốc · frame/timing source'}
            </span>
        </div>
    );
}

function CombatantHud({
    combatant,
    hp,
    side,
}: {
    combatant: WikiSkillBattleCombatant;
    hp: number;
    side: 'left' | 'right';
}) {
    const hpPercent = Math.max(
        0,
        Math.min(100, (hp / combatant.stats.hp) * 100),
    );

    return (
        <div
            className={cn(
                'absolute top-19 z-20 w-[44%] max-w-64 border border-white/10 bg-[#06111d]/88 p-2.5 shadow-xl backdrop-blur-md sm:top-21',
                side === 'left' ? 'left-3 sm:left-5' : 'right-3 sm:right-5',
            )}
        >
            <div className="flex items-center justify-between gap-2">
                <strong className="truncate text-[10px] text-white sm:text-xs">
                    {combatant.name}
                </strong>
                <span className="font-mono text-[8px] text-slate-500">
                    Lv.50
                </span>
            </div>
            <div className="mt-2 h-2 overflow-hidden border border-black/30 bg-black/50">
                <div
                    style={{ width: `${hpPercent}%` }}
                    className={cn(
                        'h-full transition-[width] duration-500',
                        hpPercent > 55
                            ? 'bg-emerald-400'
                            : hpPercent > 25
                              ? 'bg-amber-400'
                              : 'bg-rose-500',
                    )}
                />
            </div>
            <div className="mt-1 flex items-center justify-between font-mono text-[7px] text-slate-400 sm:text-[8px]">
                <span>HP</span>
                <span>
                    {hp.toLocaleString('vi-VN')} /{' '}
                    {combatant.stats.hp.toLocaleString('vi-VN')}
                </span>
            </div>
        </div>
    );
}

function CombatantSprite({
    combatant,
    side,
    isAnimating,
    animationKey,
    delta,
    hasStatus,
    effectTone,
    isHidden,
}: {
    combatant: WikiSkillBattleCombatant;
    side: 'left' | 'right';
    isAnimating: boolean;
    animationKey: string;
    delta?: number;
    hasStatus: boolean;
    effectTone: WikiSkillBattleEffectRule['tone'];
    isHidden: boolean;
}) {
    const staticSrc = petArtworkUrl(
        combatant.sprite_id,
        combatant.game_source.asset_key,
    );
    const animationSrc = petSkillAnimationUrl(
        combatant.sprite_id,
        combatant.game_source.asset_key,
    );

    return (
        <div
            className={cn(
                'absolute bottom-20 z-10 flex h-46 w-[42%] items-end justify-center sm:h-60',
                side === 'left' ? 'left-[5%]' : 'right-[5%]',
            )}
        >
            <div
                className={cn(
                    'absolute bottom-1 h-7 w-36 rounded-[50%] bg-black/35 blur-sm sm:w-48',
                    isAnimating && 'scale-110',
                )}
            />
            <div
                className={cn(
                    'relative z-10 size-36 sm:size-48',
                    side === 'right' && '-scale-x-100',
                    hasStatus &&
                        (effectTone === 'harmful'
                            ? 'skill-battle-status-harmful'
                            : 'skill-battle-status-beneficial'),
                    isHidden && 'opacity-0',
                )}
            >
                <GameArtwork
                    src={staticSrc}
                    alt={combatant.name}
                    className={cn(
                        'size-full object-contain transition-opacity duration-100',
                        isAnimating && 'opacity-0',
                    )}
                    fallback={
                        <span className="flex size-full items-center justify-center text-3xl font-black text-white/20">
                            ?
                        </span>
                    }
                />
                {isAnimating && (
                    <img
                        key={`${animationSrc}-${animationKey}`}
                        src={`${animationSrc}?battle=${animationKey}`}
                        alt=""
                        aria-hidden="true"
                        className="wiki-pixel-art absolute inset-0 size-full object-contain drop-shadow-[0_18px_18px_rgba(0,0,0,.4)]"
                    />
                )}
            </div>
            {delta !== undefined && delta !== 0 && (
                <strong
                    key={`${animationKey}-${delta}`}
                    className={cn(
                        'skill-battle-number absolute top-4 z-30 font-mono text-xl font-black text-white [text-shadow:0_2px_0_#020617,0_0_12px_currentColor] sm:text-3xl',
                        delta > 0 ? 'text-emerald-300' : 'text-rose-300',
                    )}
                >
                    {delta > 0 ? '+' : ''}
                    {delta.toLocaleString('vi-VN')}
                </strong>
            )}
        </div>
    );
}

function EffectRulePanel({ skill }: { skill: WikiSkillDetail }) {
    const rule = skill.battle_preview.effect_rule;

    return (
        <div className="flex-1 p-5">
            <div className="flex items-start gap-3">
                <span className="flex size-12 shrink-0 items-center justify-center border border-[var(--battle-accent)]/25 bg-[var(--battle-accent)]/8">
                    {skill.effect === null ? (
                        <Sparkles className="size-5 text-[var(--battle-accent)]" />
                    ) : (
                        <EffectIcon effect={skill.effect} className="size-8" />
                    )}
                </span>
                <div className="min-w-0">
                    <span className="font-mono text-[8px] font-black tracking-[.14em] text-slate-500 uppercase">
                        Logic Effect
                    </span>
                    <h3 className="mt-1 text-base font-black text-white">
                        {rule.title}
                    </h3>
                </div>
            </div>
            <p className="mt-4 text-sm leading-6 text-slate-400">
                {rule.summary}
            </p>

            <div className="mt-4 flex flex-wrap gap-2 font-mono text-[8px] font-bold uppercase">
                {rule.status_chance !== null && (
                    <span className="border border-white/9 bg-black/15 px-2 py-1.5 text-slate-300">
                        Xác suất {rule.status_chance}%
                    </span>
                )}
                {rule.duration_turns !== null && (
                    <span className="border border-white/9 bg-black/15 px-2 py-1.5 text-slate-300">
                        {rule.duration_turns} hiệp
                    </span>
                )}
                <span className="border border-white/9 bg-black/15 px-2 py-1.5 text-[var(--battle-accent)]">
                    {rule.target === 'caster' ? 'Phe mình' : 'Đối thủ'}
                </span>
            </div>

            {rule.stat_changes.length > 0 && (
                <div className="mt-5 grid gap-2">
                    {rule.stat_changes.map((change) => (
                        <div
                            key={`${change.stat}-${change.direction}`}
                            className="flex items-center justify-between gap-3 border border-white/8 bg-black/14 px-3 py-2.5"
                        >
                            <span className="text-xs text-slate-400">
                                {statLabel(change.stat)}
                            </span>
                            <strong
                                className={cn(
                                    'font-mono text-xs',
                                    change.direction === 'up'
                                        ? 'text-emerald-300'
                                        : 'text-rose-300',
                                )}
                            >
                                {change.direction === 'up' ? '+' : '−'}
                                {change.value}%
                            </strong>
                        </div>
                    ))}
                </div>
            )}

            <div className="mt-5 border-l-2 border-[var(--battle-accent)]/50 bg-[var(--battle-accent)]/5 px-3 py-2.5 text-[10px] leading-5 text-slate-400">
                {rule.provenance === 'decoded'
                    ? 'Thông số Effect lấy từ bảng trạng thái Liệt Hỏa gốc.'
                    : 'Trạng thái Cầu Vồng đã được quy đổi sang nhịp lượt và chỉ số Liệt Hỏa.'}
            </div>
        </div>
    );
}

function BattleTimeline({
    phases,
    activePhaseIndex,
    onSelect,
}: {
    phases: BattlePhase[];
    activePhaseIndex: number;
    onSelect: (index: number) => void;
}) {
    return (
        <div className="border-t border-white/8 bg-[#06111d] p-4 sm:p-5">
            <div className="mb-3 flex items-center justify-between gap-3">
                <span className="font-mono text-[8px] font-black tracking-[.14em] text-slate-500 uppercase">
                    Timeline mô phỏng
                </span>
                <span className="flex items-center gap-1.5 font-mono text-[8px] text-slate-600">
                    <Clock3 className="size-3" /> Chọn từng pha để kiểm tra
                </span>
            </div>
            <div className="grid gap-2 md:grid-cols-3 xl:grid-cols-6">
                {phases.map((phase, index) => (
                    <button
                        key={phase.id}
                        type="button"
                        onClick={() => onSelect(index)}
                        className={cn(
                            'group min-h-20 border p-3 text-left transition',
                            activePhaseIndex === index
                                ? 'border-[var(--battle-accent)]/50 bg-[var(--battle-accent)]/10'
                                : index < activePhaseIndex
                                  ? 'border-emerald-300/15 bg-emerald-300/4'
                                  : 'border-white/8 bg-white/2 hover:border-white/18',
                        )}
                    >
                        <span className="font-mono text-[8px] text-[var(--battle-accent)]">
                            {String(index + 1).padStart(2, '0')}
                        </span>
                        <strong className="mt-1 block text-[11px] leading-4 text-white">
                            {phase.title}
                        </strong>
                    </button>
                ))}
            </div>
        </div>
    );
}

function BattleReadout({
    icon,
    label,
    value,
}: {
    icon: ReactNode;
    label: string;
    value: string;
}) {
    return (
        <div className="flex min-w-0 items-start gap-2.5 bg-[#081522] p-3.5">
            <span className="mt-0.5 text-[var(--battle-accent)] [&>svg]:size-3.5">
                {icon}
            </span>
            <div className="min-w-0">
                <span className="block font-mono text-[7px] text-slate-600 uppercase">
                    {label}
                </span>
                <strong className="mt-1 block truncate text-[10px] text-slate-300">
                    {value}
                </strong>
            </div>
        </div>
    );
}

function buildBattlePhases(
    skill: WikiSkillDetail,
    caster: WikiSkillBattleCombatant,
    opponent: WikiSkillBattleCombatant,
): BattlePhase[] {
    const rule = skill.battle_preview.effect_rule;
    const startsInjured =
        rule.target === 'caster' || rule.follow_up.kind === 'direct_heal';
    let casterHp = startsInjured
        ? Math.round(caster.stats.hp * 0.64)
        : caster.stats.hp;
    let opponentHp = opponent.stats.hp;
    const sourceEvents = skill.battle_preview.source_animation.events;
    const hasConcurrentSourceSequence = sourceEvents.some(
        (event) =>
            event.render_status === 'decoded_original' &&
            event.timeline_mode === 'concurrent_caster_action',
    );
    const phases: BattlePhase[] = [
        phase(
            'ready',
            '00',
            'Sẵn sàng giao chiến',
            `${caster.name} đối đầu ${opponent.name} ở cấp 50; Linh xảo quyết định thứ tự ra tay.`,
            'ready',
            casterHp,
            opponentHp,
            900,
        ),
    ];

    if (!hasConcurrentSourceSequence) {
        phases.push(
            phase(
                'cast',
                '01',
                `Thi triển ${skill.name}`,
                `${caster.name} dùng animation tung Skill gốc và tiêu hao 1 PP của ${skill.name}.`,
                'caster-skill',
                casterHp,
                opponentHp,
                1350,
            ),
        );
    }

    sourceEvents.forEach((event, index) => {
        if (event.render_status !== 'decoded_original') {
            return;
        }

        phases.push({
            ...phase(
                `source-vfx-${index}`,
                `VFX ${String(index + 1).padStart(2, '0')}`,
                event.timeline_mode === 'concurrent_caster_action'
                    ? 'Pet tung chiêu + VFX gốc'
                    : 'Phát VFX từ resource gốc',
                sourceVfxNarration(skill, event),
                'source-vfx',
                casterHp,
                opponentHp,
                Math.max(event.tick_ms ?? 66, event.duration_ms ?? 900),
            ),
            sourceEventIndex: index,
        });
    });

    const directDamage = calculateDamage(
        caster.stats.strength,
        opponent.stats.defense,
        skill.power_percent,
    );

    if (skill.power_percent > 0) {
        opponentHp = clampHp(opponentHp - directDamage, opponent.stats.hp);
        phases.push({
            ...phase(
                'impact',
                '02',
                'Đòn đánh chạm mục tiêu',
                `${skill.power_percent}% uy lực gây ${directDamage.toLocaleString('vi-VN')} sát thương trung tính theo công thức Liệt Hỏa.`,
                'impact',
                casterHp,
                opponentHp,
                1100,
            ),
            opponentDelta: -directDamage,
        });
    }

    if (rule.key !== 'direct_action') {
        const targetName =
            rule.target === 'caster' ? caster.name : opponent.name;
        phases.push({
            ...phase(
                'status',
                '03',
                rule.effect_name ?? rule.title,
                `${targetName} nhận ${rule.title}. ${rule.summary}`,
                'status',
                casterHp,
                opponentHp,
                1200,
            ),
            statusTarget: rule.target,
        });
    }

    const followUpPhases = buildFollowUpPhases(
        rule,
        skill,
        caster,
        opponent,
        casterHp,
        opponentHp,
    );
    phases.push(...followUpPhases.phases);
    casterHp = followUpPhases.casterHp;
    opponentHp = followUpPhases.opponentHp;
    phases.push(
        phase(
            'result',
            '05',
            'Kết thúc chuỗi minh họa',
            resultNarration(rule, casterHp, opponentHp, caster, opponent),
            'result',
            casterHp,
            opponentHp,
            1600,
        ),
    );

    return phases;
}

function buildFollowUpPhases(
    rule: WikiSkillBattleEffectRule,
    skill: WikiSkillDetail,
    caster: WikiSkillBattleCombatant,
    opponent: WikiSkillBattleCombatant,
    initialCasterHp: number,
    initialOpponentHp: number,
): { phases: BattlePhase[]; casterHp: number; opponentHp: number } {
    let casterHp = initialCasterHp;
    let opponentHp = initialOpponentHp;
    const phases: BattlePhase[] = [];
    const value = rule.follow_up.value ?? 0;
    const baseCounter = calculateDamage(
        opponent.stats.strength,
        caster.stats.defense,
        100,
    );
    const defenseChange = rule.stat_changes.find(
        (change) => change.stat === 'defense',
    );
    const adjustedDefense =
        defenseChange === undefined
            ? caster.stats.defense
            : Math.round(
                  caster.stats.defense *
                      (defenseChange.direction === 'up'
                          ? 1 + defenseChange.value / 100
                          : 1 - defenseChange.value / 100),
              );
    const defenseAdjustedCounter = calculateDamage(
        opponent.stats.strength,
        adjustedDefense,
        100,
    );

    if (
        [
            'counter_reduced',
            'counter_reflect',
            'reflection_chance',
            'counter_amplified',
            'counter_weakened',
            'self_hit_chance',
        ].includes(rule.follow_up.kind)
    ) {
        let casterDamage = defenseAdjustedCounter;
        let reflectedDamage = 0;

        if (
            rule.follow_up.kind === 'counter_reduced' &&
            rule.key === 'patience'
        ) {
            casterDamage = Math.max(
                1,
                Math.round(baseCounter * (1 - value / 100)),
            );
        }

        if (rule.follow_up.kind === 'counter_weakened') {
            casterDamage = Math.max(
                1,
                Math.round(baseCounter * (1 - value / 100)),
            );
        }

        if (rule.follow_up.kind === 'counter_reflect') {
            reflectedDamage = Math.round(baseCounter * (value / 100));
        }

        if (
            rule.follow_up.kind === 'reflection_chance' ||
            rule.follow_up.kind === 'self_hit_chance'
        ) {
            reflectedDamage = baseCounter;
            casterDamage = 0;
        }

        casterHp = clampHp(casterHp - casterDamage, caster.stats.hp);
        opponentHp = clampHp(opponentHp - reflectedDamage, opponent.stats.hp);
        phases.push({
            ...phase(
                'counter',
                '04',
                'Đối thủ phản công',
                counterNarration(
                    rule,
                    baseCounter,
                    casterDamage,
                    reflectedDamage,
                ),
                'opponent-skill',
                casterHp,
                opponentHp,
                1400,
            ),
            casterDelta: casterDamage > 0 ? -casterDamage : undefined,
            opponentDelta: reflectedDamage > 0 ? -reflectedDamage : undefined,
            statusTarget: rule.target,
        });
    }

    if (rule.follow_up.kind === 'heal_tick') {
        const heal = effectAmount(
            value,
            rule.follow_up.basis,
            caster.stats.hp,
            casterHp,
        );
        casterHp = clampHp(casterHp + heal, caster.stats.hp);
        phases.push({
            ...phase(
                'follow-up-heal',
                '04',
                'Cuối hiệp: hồi phục',
                `${rule.title} hồi ${heal.toLocaleString('vi-VN')} HP cho ${caster.name}.`,
                'tick',
                casterHp,
                opponentHp,
                1200,
            ),
            casterDelta: heal,
            statusTarget: 'caster',
            floatingText: `+${heal.toLocaleString('vi-VN')} HP`,
        });
    }

    if (rule.follow_up.kind === 'direct_heal') {
        const heal = effectAmount(
            value,
            rule.follow_up.basis,
            caster.stats.hp,
            casterHp,
        );
        casterHp = clampHp(casterHp + heal, caster.stats.hp);
        phases.push({
            ...phase(
                'follow-up-heal',
                '04',
                'Hồi phục trực tiếp',
                `${skill.name} hồi ${heal.toLocaleString('vi-VN')} HP, không gây sát thương.`,
                'tick',
                casterHp,
                opponentHp,
                1200,
            ),
            casterDelta: heal,
            floatingText: `+${heal.toLocaleString('vi-VN')} HP`,
        });
    }

    if (
        ['damage_tick', 'delayed_damage', 'escalating_damage'].includes(
            rule.follow_up.kind,
        )
    ) {
        const tickValue =
            rule.follow_up.kind === 'escalating_damage'
                ? value + (rule.follow_up.secondary_value ?? 0)
                : value;
        const damage = effectAmount(
            tickValue,
            rule.follow_up.basis,
            opponent.stats.hp,
            opponentHp,
        );
        opponentHp = clampHp(opponentHp - damage, opponent.stats.hp);
        phases.push({
            ...phase(
                'follow-up-damage',
                '04',
                rule.follow_up.kind === 'delayed_damage'
                    ? 'Đủ lượt: sát thương bùng nổ'
                    : 'Cuối hiệp: sát thương trạng thái',
                `${rule.title} gây thêm ${damage.toLocaleString('vi-VN')} sát thương cho ${opponent.name}.`,
                'tick',
                casterHp,
                opponentHp,
                1200,
            ),
            opponentDelta: -damage,
            statusTarget: 'opponent',
            floatingText: `−${damage.toLocaleString('vi-VN')} HP`,
        });
    }

    if (['attack_boost', 'double_action'].includes(rule.follow_up.kind)) {
        const bonusMultiplier =
            rule.follow_up.kind === 'double_action' ? 1 : 1 + value / 100;
        const followUpDamage = Math.max(
            1,
            Math.round(
                calculateDamage(
                    caster.stats.strength,
                    opponent.stats.defense,
                    skill.power_percent > 0 ? skill.power_percent : 100,
                ) * bonusMultiplier,
            ),
        );
        opponentHp = clampHp(opponentHp - followUpDamage, opponent.stats.hp);
        phases.push({
            ...phase(
                'follow-up-attack',
                '04',
                rule.follow_up.kind === 'double_action'
                    ? 'Hành động lần hai miễn PP'
                    : 'Đòn đánh được cường hóa',
                `${caster.name} gây thêm ${followUpDamage.toLocaleString('vi-VN')} sát thương nhờ ${rule.title}.`,
                'tick',
                casterHp,
                opponentHp,
                1350,
            ),
            opponentDelta: -followUpDamage,
            statusTarget: 'caster',
            floatingText: `−${followUpDamage.toLocaleString('vi-VN')} HP`,
        });
    }

    if (
        [
            'action_blocked',
            'action_delayed',
            'restriction',
            'accuracy_check',
            'tier_lock',
            'status_immunity',
            'buff_transfer',
            'defense_break',
            'turn_priority',
            'status_only',
        ].includes(rule.follow_up.kind)
    ) {
        phases.push({
            ...phase(
                'follow-up-control',
                '04',
                followUpTitle(rule.follow_up.kind),
                followUpNarration(rule, caster, opponent),
                'tick',
                casterHp,
                opponentHp,
                1200,
            ),
            statusTarget: rule.target,
            floatingText: followUpTitle(rule.follow_up.kind),
        });
    }

    return { phases, casterHp, opponentHp };
}

function phase(
    id: string,
    label: string,
    title: string,
    narration: string,
    visual: BattleVisual,
    casterHp: number,
    opponentHp: number,
    duration: number,
): BattlePhase {
    return {
        id,
        label,
        title,
        narration,
        duration,
        visual,
        casterHp,
        opponentHp,
    };
}

function sourceVfxNarration(
    skill: WikiSkillDetail,
    event: WikiSkillSourceAnimationEvent,
): string {
    if (event.kind === 'procedural_pet_effect') {
        return `${skill.name} chạy effect #${event.source_effect_id ?? 0}, type ${event.source_effect_type ?? 0} trên composition state ${event.snapshot_composition_state ?? 0}, bằng phép biến đổi pixel, quỹ đạo và tick 66 ms đã port trực tiếp từ a.a.b; không dùng CSS filter.`;
    }

    if (event.timeline_mode === 'concurrent_caster_action') {
        return `${skill.name} chạy đồng thời animation Pet và ${event.frame_count ?? 0} frame VFX theo controller ak.b(z), origin, điểm bám mục tiêu và tick ${event.tick_ms ?? 60} ms của game Cầu Vồng gốc.`;
    }

    const frameSummary =
        event.frame_count === undefined
            ? 'frame gốc'
            : `${event.frame_count} frame gốc`;
    const sourceReference =
        event.source_action_id === undefined
            ? `animation #${event.source_animation_id ?? 0}`
            : `action #${event.source_action_id}, animation #${event.source_animation_id ?? 0}`;

    return `${skill.name} phát ${frameSummary} với timing đã giải mã (${sourceReference}); lớp này không dùng VFX CSS dựng lại.`;
}

function calculateDamage(
    strength: number,
    defense: number,
    powerPercent: number,
): number {
    if (powerPercent <= 0) {
        return 0;
    }

    return Math.max(1, Math.round((strength - defense) * (powerPercent / 100)));
}

function effectAmount(
    value: number,
    basis: WikiSkillBattleEffectRule['follow_up']['basis'],
    maximumHp: number,
    currentHp: number,
): number {
    if (basis === 'max_hp') {
        return Math.max(1, Math.round(maximumHp * (value / 100)));
    }

    if (basis === 'current_hp') {
        return Math.max(1, Math.round(currentHp * (value / 100)));
    }

    return Math.max(0, value);
}

function clampHp(hp: number, maximumHp: number): number {
    return Math.max(0, Math.min(maximumHp, hp));
}

function counterNarration(
    rule: WikiSkillBattleEffectRule,
    baseDamage: number,
    finalDamage: number,
    reflectedDamage: number,
): string {
    if (reflectedDamage > 0) {
        return `${rule.title} kích hoạt: đòn ${baseDamage.toLocaleString('vi-VN')} sát thương bị phản lại ${reflectedDamage.toLocaleString('vi-VN')}.`;
    }

    if (finalDamage !== baseDamage) {
        return `Đòn phản công cơ sở ${baseDamage.toLocaleString('vi-VN')} được điều chỉnh còn ${finalDamage.toLocaleString('vi-VN')} bởi ${rule.title}.`;
    }

    return `Đối thủ phản công và gây ${finalDamage.toLocaleString('vi-VN')} sát thương.`;
}

function followUpTitle(kind: string): string {
    return (
        {
            action_blocked: 'Lượt hành động bị chặn',
            action_delayed: 'Lượt hành động bị trì hoãn',
            restriction: 'Khóa thao tác chiến thuật',
            accuracy_check: 'Kiểm tra chính xác thất bại',
            tier_lock: 'Skill tier cao bị khóa',
            status_immunity: 'Chặn Debuff kế tiếp',
            buff_transfer: 'Buff đổi chủ',
            defense_break: 'Phòng ngự đã suy giảm',
            turn_priority: 'Thay đổi thứ tự hành động',
            status_only: 'Trạng thái đang có hiệu lực',
        }[kind] ?? 'Hiệu ứng lượt kế'
    );
}

function followUpNarration(
    rule: WikiSkillBattleEffectRule,
    caster: WikiSkillBattleCombatant,
    opponent: WikiSkillBattleCombatant,
): string {
    const affected = rule.target === 'caster' ? caster.name : opponent.name;

    return `${affected}: ${rule.summary}`;
}

function resultNarration(
    rule: WikiSkillBattleEffectRule,
    casterHp: number,
    opponentHp: number,
    caster: WikiSkillBattleCombatant,
    opponent: WikiSkillBattleCombatant,
): string {
    return `${caster.name} còn ${casterHp.toLocaleString('vi-VN')} HP; ${opponent.name} còn ${opponentHp.toLocaleString('vi-VN')} HP. ${rule.duration_turns === null ? 'Hiệu ứng kết thúc theo mô tả.' : `${rule.title} còn được theo dõi theo thời lượng ${rule.duration_turns} hiệp.`}`;
}

function statLabel(stat: string): string {
    return (
        {
            hp: 'Sinh mệnh',
            strength: 'Sức mạnh',
            defense: 'Phòng ngự',
            agility: 'Linh xảo',
            accuracy: 'Chính xác',
            damage: 'Sát thương gây ra',
            damage_received: 'Sát thương nhận vào',
            pp_cost: 'Tiêu hao PP',
        }[stat] ?? stat
    );
}
