#!/usr/bin/env python3
"""Render original Rainbow Pet sprite data into transparent Wiki artwork."""

from __future__ import annotations

import json
from dataclasses import dataclass
from pathlib import Path

from PIL import Image


ROOT = Path(__file__).resolve().parents[1]
RAW_ROOT = ROOT / "04_resources" / "raw" / "data"
ANALYSIS_PATH = ROOT / "06_analysis" / "game-data.json"
PUBLIC_ROOT = ROOT.parents[2] / "public" / "assets" / "game" / "cau-vong"
GAME_TICK_MS = 60

# The metadata stores the game's compact transform index, not the constants
# accepted by Graphics.drawRegion(). This lookup is copied from ah.java.
GAME_TRANSFORM_TO_J2ME = (0, 5, 3, 6, 2, 4, 1, 7)


@dataclass
class SpriteData:
    regions: list[list[int]]
    compositions: list[list[list[int]]]
    animations: list[list[list[int]]]


@dataclass
class Reader:
    data: bytes
    offset: int = 0

    def unsigned(self, width: int) -> int:
        value = int.from_bytes(self.data[self.offset : self.offset + width], "big")
        self.offset += width
        return value

    def signed(self, width: int) -> int:
        value = int.from_bytes(self.data[self.offset : self.offset + width], "big", signed=True)
        self.offset += width
        return value

    def array(self, width: int) -> list[int]:
        return [self.signed(width) for _ in range(self.unsigned(width))]

    def table(self, width: int) -> list[list[int]]:
        return [self.array(width) for _ in range(self.unsigned(width))]

    def cube(self, width: int) -> list[list[list[int]]]:
        return [self.table(width) for _ in range(self.unsigned(width))]


def load_prefixed(path: Path) -> bytes:
    binary = path.read_bytes()
    payload_length = int.from_bytes(binary[:2], "big")
    payload = binary[2 : 2 + payload_length]
    if len(payload) != payload_length:
        raise ValueError(f"Invalid sprite payload in {path}")
    return payload


def parse_sprite(path: Path, width: int) -> SpriteData:
    reader = Reader(load_prefixed(path))
    sprite = SpriteData(reader.table(width), reader.cube(width), reader.cube(width))
    if reader.offset != len(reader.data):
        raise ValueError(f"Unread bytes in {path}: {len(reader.data) - reader.offset}")
    return sprite


def transform_region(region: Image.Image, transform: int) -> Image.Image:
    if transform < 0 or transform >= len(GAME_TRANSFORM_TO_J2ME):
        raise ValueError(f"Invalid sprite transform: {transform}")

    j2me_transform = GAME_TRANSFORM_TO_J2ME[transform]
    transpose = Image.Transpose
    return {
        0: lambda value: value,
        1: lambda value: value.transpose(transpose.FLIP_TOP_BOTTOM),
        2: lambda value: value.transpose(transpose.FLIP_LEFT_RIGHT),
        3: lambda value: value.transpose(transpose.ROTATE_180),
        4: lambda value: value.transpose(transpose.TRANSVERSE),
        5: lambda value: value.transpose(transpose.ROTATE_270),
        6: lambda value: value.transpose(transpose.ROTATE_90),
        7: lambda value: value.transpose(transpose.TRANSPOSE),
    }[j2me_transform](region)


def render_composition(
    atlas: Image.Image,
    sprite: SpriteData,
    composition_id: int,
    bounds: tuple[int, int, int, int] | None = None,
) -> Image.Image:
    parts: list[tuple[Image.Image, int, int]] = []
    for component in sprite.compositions[composition_id]:
        if len(component) < 4:
            continue
        region_id, x, y, transform = component[:4]
        rx, ry, width, height = sprite.regions[region_id][:4]
        part = atlas.crop((rx, ry, rx + width, ry + height))
        part = transform_region(part, transform)
        parts.append((part, x, y))

    if not parts:
        return Image.new("RGBA", (1, 1), (0, 0, 0, 0))
    if bounds is None:
        left = min(x for part, x, _ in parts)
        top = min(y for part, _, y in parts)
        right = max(x + part.width for part, x, _ in parts)
        bottom = max(y + part.height for part, _, y in parts)
    else:
        left, top, right, bottom = bounds
    canvas = Image.new("RGBA", (max(1, right - left), max(1, bottom - top)), (0, 0, 0, 0))
    for part, x, y in parts:
        canvas.alpha_composite(part, (x - left, y - top))
    return canvas


def animation_frames(
    atlas: Image.Image,
    sprite: SpriteData,
    animation_id: int,
) -> tuple[list[Image.Image], list[int]]:
    """Render one original Rainbow animation on a stable shared canvas."""
    if animation_id < 0 or animation_id >= len(sprite.animations):
        return [], []

    animation = sprite.animations[animation_id]
    if not animation:
        return [], []

    frame_bounds: list[tuple[int, int, int, int]] = []
    for frame in animation:
        if len(frame) < 2:
            return [], []

        composition_id = frame[0]
        parts: list[tuple[Image.Image, int, int]] = []
        for component in sprite.compositions[composition_id]:
            if len(component) < 4:
                continue
            region_id, x, y, transform = component[:4]
            rx, ry, width, height = sprite.regions[region_id][:4]
            part = transform_region(
                atlas.crop((rx, ry, rx + width, ry + height)),
                transform,
            )
            parts.append((part, x, y))

        if not parts:
            return [], []

        frame_bounds.append(
            (
                min(x for _, x, _ in parts),
                min(y for _, _, y in parts),
                max(x + image.width for image, x, _ in parts),
                max(y + image.height for image, _, y in parts),
            )
        )

    shared_bounds = (
        min(bounds[0] for bounds in frame_bounds),
        min(bounds[1] for bounds in frame_bounds),
        max(bounds[2] for bounds in frame_bounds),
        max(bounds[3] for bounds in frame_bounds),
    )
    frames = [
        render_composition(atlas, sprite, frame[0], bounds=shared_bounds)
        for frame in animation
    ]
    durations = [(max(0, frame[1]) + 1) * GAME_TICK_MS for frame in animation]

    return frames, durations


def scale_animation_frames(
    frames: list[Image.Image], max_size: int
) -> list[Image.Image]:
    """Scale every animation frame uniformly so their shared origin is retained."""
    if not frames or max(frames[0].size) >= max_size:
        return frames

    scale = max_size / max(frames[0].size)
    size = (
        max(1, round(frames[0].width * scale)),
        max(1, round(frames[0].height * scale)),
    )
    return [frame.resize(size, Image.Resampling.NEAREST) for frame in frames]


def save_animation(
    frames: list[Image.Image], durations: list[int], path: Path
) -> None:
    """Save lossless animated WebP while preserving source frame timing."""
    if not frames or len(frames) != len(durations):
        raise ValueError("Animation frames and durations must be non-empty and aligned")

    path.parent.mkdir(parents=True, exist_ok=True)
    frames[0].save(
        path,
        save_all=True,
        append_images=frames[1:],
        duration=durations,
        loop=0,
        lossless=True,
        method=6,
    )


def representative_composition(sprite: SpriteData, animation_id: int, skip_control_frames: bool = False) -> int:
    if animation_id >= len(sprite.animations):
        animation_id = 0
    frames = sprite.animations[animation_id]
    candidates = [row[0] for row in frames if row]
    if skip_control_frames:
        candidates = [value for value in candidates if value >= 2] or candidates
    if not candidates:
        return 0
    return max(candidates, key=lambda value: len(sprite.compositions[value]))


def save_scaled(image: Image.Image, path: Path, max_size: int) -> None:
    image = image.crop(image.getbbox()) if image.getbbox() else image
    if max(image.size) < max_size:
        scale = max_size / max(image.size)
        image = image.resize(
            (max(1, round(image.width * scale)), max(1, round(image.height * scale))),
            Image.Resampling.NEAREST,
        )
    path.parent.mkdir(parents=True, exist_ok=True)
    image.save(path, optimize=True)


def render_pets(data: dict) -> dict[str, dict[str, object]]:
    short_groups = set(data["internal"]["short_sprite_groups"])
    cache: dict[int, tuple[Image.Image, SpriteData]] = {}
    animation_manifest: dict[str, dict[str, object]] = {}
    for pet in data["pets"]:
        group = pet["sprite_group"]
        if group not in cache:
            base = RAW_ROOT / "npc2" / str(group)
            cache[group] = (
                Image.open(base.with_suffix(".png")).convert("RGBA"),
                parse_sprite(base.with_suffix(".data"), 2 if group in short_groups else 1),
            )
        atlas, sprite = cache[group]
        animation_id = pet["sprite_variant"] * 3
        if animation_id >= len(sprite.animations):
            animation_id = 0
        composition_id = sprite.animations[animation_id][0][0]
        artwork = render_composition(atlas, sprite, composition_id)
        save_scaled(artwork, PUBLIC_ROOT / "pets" / f"{pet['game_id']}.png", 144)

        attack_animation_id = animation_id + 1
        frames, durations = animation_frames(atlas, sprite, attack_animation_id)
        if not frames:
            continue

        frames = scale_animation_frames(frames, 144)
        filename = f"{pet['game_id']}-skill.webp"
        save_animation(
            frames,
            durations,
            PUBLIC_ROOT / "pet-animations" / filename,
        )
        animation_manifest[str(pet["game_id"])] = {
            "action": "skill",
            "source_action_id": attack_animation_id,
            "url": f"/assets/game/cau-vong/pet-animations/{filename}",
            "frame_count": len(frames),
            "duration_ms": sum(durations),
            "tick_ms": GAME_TICK_MS,
        }

    return animation_manifest


def render_items(data: dict) -> None:
    atlas = Image.open(RAW_ROOT / "item.png").convert("RGBA")
    reader = Reader(load_prefixed(RAW_ROOT / "item_m.d"))
    regions = reader.table(1)
    if reader.offset != len(reader.data):
        raise ValueError("Unread bytes in item_m.d")
    for item in data["items"]:
        x, y, width, height = regions[item["frame_id"]][:4]
        artwork = atlas.crop((x, y, x + width, y + height))
        save_scaled(artwork, PUBLIC_ROOT / "items" / f"{item['game_id']}.png", 96)


def render_skills(data: dict) -> None:
    cache: dict[int, tuple[Image.Image, SpriteData]] = {}
    for skill in data["skills"]:
        group = skill["artwork_group"]
        if group not in cache:
            base = RAW_ROOT / "battle" / f"s{group}"
            cache[group] = (
                Image.open(base.with_suffix(".png")).convert("RGBA"),
                parse_sprite(base.with_suffix(".data"), 2),
            )
        atlas, sprite = cache[group]
        animation_id = skill["artwork_animation"]
        composition_id = representative_composition(sprite, animation_id, skip_control_frames=True)
        artwork = render_composition(atlas, sprite, composition_id)
        save_scaled(artwork, PUBLIC_ROOT / "skills" / f"{skill['game_id']}.png", 112)


def render_effects(data: dict) -> None:
    effect_root = PUBLIC_ROOT / "effects"
    effect_root.mkdir(parents=True, exist_ok=True)
    for effect in data["effects"]:
        if effect["source_table"] != 11:
            continue
        status_id = effect["game_id"]
        source_path = RAW_ROOT / "brow" / f"e{status_id}.png"
        if not source_path.exists():
            raise FileNotFoundError(f"Missing status icon for effect {status_id}: {source_path}")
        source = Image.open(source_path).convert("RGBA")
        save_scaled(source, effect_root / f"status-{status_id}.png", 96)


def main() -> None:
    data = json.loads(ANALYSIS_PATH.read_text(encoding="utf-8"))
    animation_manifest = render_pets(data)
    render_items(data)
    render_skills(data)
    render_effects(data)
    animation_manifest_path = PUBLIC_ROOT / "pet-animations" / "manifest.json"
    animation_manifest_path.parent.mkdir(parents=True, exist_ok=True)
    animation_manifest_path.write_text(
        json.dumps(
            {
                "source": "Decoded Rainbow J2ME Pet battle sprites",
                "animations": animation_manifest,
            },
            ensure_ascii=False,
            indent=2,
        )
        + "\n",
        encoding="utf-8",
    )
    print(
        f"Rendered {len(data['pets'])} pets, {len(animation_manifest)} original "
        f"Pet skill animations, {len(data['skills'])} skills and "
        f"{len(data['items'])} item images into {PUBLIC_ROOT}."
    )


if __name__ == "__main__":
    main()
