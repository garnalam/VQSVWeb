"""Extract browser-ready artwork from the decoded VQSV sprite resources.

The original J2ME game stores artwork as atlas regions plus composition data.
This script reproduces that pipeline and writes transparent PNGs for the wiki.
"""

from __future__ import annotations

import json
import shutil
import struct
import zlib
from dataclasses import dataclass
from pathlib import Path

from PIL import Image


PROJECT_ROOT = Path(__file__).resolve().parents[3]
DECODED_ROOT = PROJECT_ROOT / "resources" / "decoded" / "04_resources"
RAW_ROOT = DECODED_ROOT / "raw" / "data"
IMAGE_ROOT = DECODED_ROOT / "recognized" / "images" / "data" / "img"
OUTPUT_ROOT = PROJECT_ROOT / "public" / "assets" / "game"
GAME_TICK_MS = 66
SKILL_EFFECT_SPRITE_IDS = (
    262,
    263,
    264,
    265,
    266,
    267,
    268,
    299,
    300,
    301,
    304,
    306,
    307,
    308,
    309,
)
PROCEDURAL_EFFECT_TYPES = {1, 7, 8, 9, 11, 12, 13, 14, 15}


@dataclass(frozen=True)
class SpriteDefinition:
    regions: list[int]
    compositions: list[list[int]]
    animations: list[list[int]]


class BinaryReader:
    def __init__(self, payload: bytes) -> None:
        self.payload = payload
        self.offset = 0

    def short(self) -> int:
        value = struct.unpack_from(">h", self.payload, self.offset)[0]
        self.offset += 2
        return value

    def flat_short_table(self) -> list[int]:
        rows = self.short()
        columns = self.short()
        return [self.short() for _ in range(rows * columns)]

    def jagged_short_table(self) -> list[list[int]]:
        row_count = self.short()
        row_width = self.short()
        rows: list[list[int]] = []

        for _ in range(row_count):
            value_count = self.short() * row_width
            rows.append([self.short() for _ in range(value_count)])

        return rows


def read_jagged_byte_table(path: Path) -> list[list[int]]:
    """Read the signed-byte table format used by the original Skill timeline."""
    reader = BinaryReader(path.read_bytes())
    rows: list[list[int]] = []

    for _ in range(reader.short()):
        value_count = reader.short()
        values = reader.payload[reader.offset : reader.offset + value_count]
        reader.offset += value_count
        rows.append([value if value < 128 else value - 256 for value in values])

    if reader.offset != len(reader.payload):
        raise ValueError(f"Unread bytes in {path}: {len(reader.payload) - reader.offset}")

    return rows


def read_jagged_short_table(path: Path) -> list[list[int]]:
    """Read the signed-short table format used by special Skill effects."""
    reader = BinaryReader(path.read_bytes())
    rows = []

    for _ in range(reader.short()):
        rows.append([reader.short() for _ in range(reader.short())])

    if reader.offset != len(reader.payload):
        raise ValueError(f"Unread bytes in {path}: {len(reader.payload) - reader.offset}")

    return rows


def read_sprite_map() -> list[list[int]]:
    reader = BinaryReader((RAW_ROOT / "script" / "sprite.mid").read_bytes())
    row_count = reader.short()
    rows: list[list[int]] = []

    for _ in range(row_count):
        rows.append([reader.short() for _ in range(reader.short())])

    return rows


def read_sprite_definition(sprite_file_id: int) -> SpriteDefinition:
    path = RAW_ROOT / "spr" / f"spr_{sprite_file_id}_all(r)"
    reader = BinaryReader(path.read_bytes())
    regions = reader.flat_short_table()
    compositions = reader.jagged_short_table()
    animations = reader.jagged_short_table()

    # Collision and hit-box tables are intentionally consumed only by the game.
    reader.flat_short_table()
    reader.flat_short_table()

    return SpriteDefinition(regions, compositions, animations)


def transform_region(region: Image.Image, transform: int) -> Image.Image:
    transpose = Image.Transpose
    operations = {
        0: None,
        1: transpose.FLIP_TOP_BOTTOM,
        2: transpose.FLIP_LEFT_RIGHT,
        3: transpose.ROTATE_180,
        4: transpose.TRANSPOSE,
        5: transpose.ROTATE_270,
        6: transpose.ROTATE_90,
        7: transpose.TRANSVERSE,
    }
    operation = operations.get(transform)

    return region if operation is None else region.transpose(operation)


def render_composition(
    definition: SpriteDefinition,
    atlas_ids: list[int],
    composition_id: int,
    padding: int = 3,
    bounds: tuple[int, int, int, int] | None = None,
) -> Image.Image | None:
    if composition_id < 0 or composition_id >= len(definition.compositions):
        return None

    composition = definition.compositions[composition_id]
    if not composition:
        return None

    atlases = [
        Image.open(IMAGE_ROOT / f"img_{atlas_id}.png").convert("RGBA")
        for atlas_id in atlas_ids
    ]
    pieces: list[tuple[Image.Image, int, int]] = []

    for index in range(0, len(composition), 4):
        region_id, destination_x, destination_y, transform_index = composition[
            index : index + 4
        ]
        region_offset = region_id * 5
        atlas_slot, source_x, source_y, width, height = definition.regions[
            region_offset : region_offset + 5
        ]
        source = atlases[atlas_slot]
        cropped = source.crop(
            (source_x, source_y, source_x + width, source_y + height)
        )
        # The composition stores an index consumed by a.b.g.c in the game.
        j2me_transform = (0, 5, 3, 6, 2, 4, 1, 7)[transform_index]
        pieces.append(
            (transform_region(cropped, j2me_transform), destination_x, destination_y)
        )

    if bounds is None:
        left = min(x for _, x, _ in pieces)
        top = min(y for _, _, y in pieces)
        right = max(x + image.width for image, x, _ in pieces)
        bottom = max(y + image.height for image, _, y in pieces)
    else:
        left, top, right, bottom = bounds
    canvas = Image.new(
        "RGBA", (right - left + padding * 2, bottom - top + padding * 2)
    )

    for piece, destination_x, destination_y in pieces:
        canvas.alpha_composite(
            piece, (destination_x - left + padding, destination_y - top + padding)
        )

    return canvas


def composition_bounds(
    definition: SpriteDefinition, composition_id: int
) -> tuple[int, int, int, int] | None:
    """Return the direction-0 bounds produced by a.b.g.b for one composition."""
    if composition_id < 0 or composition_id >= len(definition.compositions):
        return None

    composition = definition.compositions[composition_id]
    if not composition:
        return None

    pieces: list[tuple[int, int, int, int]] = []
    for index in range(0, len(composition), 4):
        region_id, destination_x, destination_y, transform_index = composition[
            index : index + 4
        ]
        region_offset = region_id * 5
        width, height = definition.regions[region_offset + 3 : region_offset + 5]
        j2me_transform = (0, 5, 3, 6, 2, 4, 1, 7)[transform_index]
        if j2me_transform >= 4:
            width, height = height, width

        pieces.append((destination_x, destination_y, width, height))

    left = min(x for x, _, _, _ in pieces)
    top = min(y for _, y, _, _ in pieces)
    right = max(x + width for x, _, width, _ in pieces)
    bottom = max(y + height for _, y, _, height in pieces)

    return left, top, right, bottom


def animation_frames(
    definition: SpriteDefinition,
    atlas_ids: list[int],
    animation_id: int,
    padding: int = 3,
) -> tuple[list[Image.Image], list[int]]:
    """Render one original action with a shared canvas and source timing."""
    if animation_id < 0 or animation_id >= len(definition.animations):
        return [], []

    animation = definition.animations[animation_id]
    if len(animation) < 2 or len(animation) % 2 != 0:
        return [], []

    rendered_frames: list[Image.Image] = []
    durations: list[int] = []
    frame_bounds: list[tuple[int, int, int, int]] = []

    for composition_id in animation[1::2]:
        composition = definition.compositions[composition_id]
        if not composition:
            continue

        atlases = [
            Image.open(IMAGE_ROOT / f"img_{atlas_id}.png").convert("RGBA")
            for atlas_id in atlas_ids
        ]
        pieces: list[tuple[Image.Image, int, int]] = []

        for index in range(0, len(composition), 4):
            region_id, destination_x, destination_y, transform_index = composition[
                index : index + 4
            ]
            region_offset = region_id * 5
            atlas_slot, source_x, source_y, width, height = definition.regions[
                region_offset : region_offset + 5
            ]
            cropped = atlases[atlas_slot].crop(
                (source_x, source_y, source_x + width, source_y + height)
            )
            j2me_transform = (0, 5, 3, 6, 2, 4, 1, 7)[transform_index]
            pieces.append(
                (
                    transform_region(cropped, j2me_transform),
                    destination_x,
                    destination_y,
                )
            )

        frame_bounds.append(
            (
                min(x for _, x, _ in pieces),
                min(y for _, _, y in pieces),
                max(x + image.width for image, x, _ in pieces),
                max(y + image.height for image, _, y in pieces),
            )
        )

    if not frame_bounds:
        return [], []

    shared_bounds = (
        min(bounds[0] for bounds in frame_bounds),
        min(bounds[1] for bounds in frame_bounds),
        max(bounds[2] for bounds in frame_bounds),
        max(bounds[3] for bounds in frame_bounds),
    )

    for duration_ticks, composition_id in zip(
        animation[0::2], animation[1::2], strict=True
    ):
        frame = render_composition(
            definition,
            atlas_ids,
            composition_id,
            padding=padding,
            bounds=shared_bounds,
        )
        if frame is None:
            left, top, right, bottom = shared_bounds
            frame = Image.new(
                "RGBA",
                (right - left + padding * 2, bottom - top + padding * 2),
                (0, 0, 0, 0),
            )

        rendered_frames.append(frame)
        durations.append(max(1, duration_ticks) * GAME_TICK_MS)

    return rendered_frames, durations


def save_animation(
    frames: list[Image.Image], durations: list[int], path: Path
) -> None:
    """Save lossless animated WebP while preserving per-frame durations."""
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


def default_composition_id(definition: SpriteDefinition) -> int | None:
    if definition.animations and len(definition.animations[0]) >= 2:
        return definition.animations[0][1]

    return 0 if definition.compositions else None


def extract_sprite(
    sprite_map: list[list[int]], sprite_id: int, composition_id: int | None = None
) -> Image.Image | None:
    if sprite_id >= len(sprite_map) or len(sprite_map[sprite_id]) < 2:
        return None

    sprite_file_id, *atlas_ids = sprite_map[sprite_id]
    definition = read_sprite_definition(sprite_file_id)
    selected_composition = (
        default_composition_id(definition)
        if composition_id is None
        else composition_id
    )

    if selected_composition is None:
        return None

    return render_composition(
        definition, atlas_ids, selected_composition, padding=3
    )


def save_image(image: Image.Image, path: Path) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    image.save(path, optimize=True)


def decode_mid_image(path: Path) -> Image.Image:
    """Rebuild the custom PNG container consumed by a.e.b in the J2ME client."""
    payload = path.read_bytes()
    reader = BinaryReader(payload)
    width = struct.unpack_from(">I", payload, reader.offset)[0]
    reader.offset += 4
    height = struct.unpack_from(">I", payload, reader.offset)[0]
    reader.offset += 4
    bit_depth = payload[reader.offset]
    color_type = payload[reader.offset + 1]
    reader.offset += 2
    chunks: list[tuple[bytes, bytes]] = [
        (
            b"IHDR",
            struct.pack(">IIBBBBB", width, height, bit_depth, color_type, 0, 0, 0),
        )
    ]

    if color_type == 3:
        palette_length = struct.unpack_from(">I", payload, reader.offset)[0]
        reader.offset += 4
        palette = payload[reader.offset : reader.offset + palette_length]
        reader.offset += palette_length
        chunks.append((b"PLTE", palette))

        next_value = struct.unpack_from(">I", payload, reader.offset)[0]
        reader.offset += 4
        if next_value == int.from_bytes(b"tRNS", "big"):
            alpha_count = payload[reader.offset] or 256
            reader.offset += 1
            transparent_index = payload[reader.offset]
            reader.offset += 1
            alpha = bytearray([255] * alpha_count)
            alpha[transparent_index] = 0
            chunks.append((b"tRNS", bytes(alpha)))
            data_length = struct.unpack_from(">I", payload, reader.offset)[0]
            reader.offset += 4
        else:
            data_length = next_value
    elif color_type == 6:
        data_length = struct.unpack_from(">I", payload, reader.offset)[0]
        reader.offset += 4
    else:
        data_length = 0

    compressed = payload[reader.offset : reader.offset + data_length]
    if len(compressed) != data_length:
        raise ValueError(f"Truncated image payload in {path}")

    chunks.extend([(b"IDAT", compressed), (b"IEND", b"")])
    png = bytearray(b"\x89PNG\r\n\x1a\n")
    for chunk_type, chunk_data in chunks:
        png.extend(struct.pack(">I", len(chunk_data)))
        png.extend(chunk_type)
        png.extend(chunk_data)
        png.extend(struct.pack(">I", zlib.crc32(chunk_type + chunk_data) & 0xFFFFFFFF))

    from io import BytesIO

    return Image.open(BytesIO(png)).convert("RGBA")


def procedural_duration_ticks(definition: list[int]) -> int:
    """Match the lifetime counters in a.a.b.d for every used procedural type."""
    effect_type = definition[0]
    if effect_type in {1, 7, 8}:
        return max(1, definition[2] + 1)

    if effect_type == 9:
        return max(1, definition[6] + 1)

    if effect_type in {11, 14, 15}:
        copy_count = definition[1]
        state = definition[2 + (copy_count - 1) * 4 :]
    elif effect_type == 12:
        copy_count = definition[1]
        state = definition[2 + copy_count :]
    elif effect_type == 13:
        copy_count = definition[1]
        state = definition[2 + copy_count :]
    else:
        raise ValueError(f"Unsupported a.a.b effect type: {effect_type}")

    return max(1, state[1] * (state[3] + 1))


def extract_procedural_textures() -> dict[str, str]:
    """Export the four repeating pixel masks loaded by a.b.c.e."""
    manifest: dict[str, str] = {}

    for texture_id in range(4):
        filename = f"texture-{texture_id}.png"
        image = decode_mid_image(RAW_ROOT / "tex" / f"tex_{texture_id}.mid")
        save_image(image, OUTPUT_ROOT / "skill-animations" / "textures" / filename)
        manifest[str(texture_id)] = (
            f"/assets/game/skill-animations/textures/{filename}"
        )

    return manifest


def copy_decorations() -> dict[str, str]:
    decorations = {
        "logo": 823,
        "scenic_background": 831,
        "panel_primary": 800,
        "panel_secondary": 801,
        "button_primary": 802,
        "button_secondary": 803,
        "button_tertiary": 804,
        "icon_atlas": 811,
    }
    manifest: dict[str, str] = {}

    for name, image_id in decorations.items():
        destination = OUTPUT_ROOT / "decor" / f"{name}.png"
        destination.parent.mkdir(parents=True, exist_ok=True)
        shutil.copyfile(IMAGE_ROOT / f"img_{image_id}.png", destination)
        manifest[name] = f"/assets/game/decor/{name}.png"

    return manifest


def extract_interface(sprite_map: list[list[int]]) -> dict[str, str]:
    """Export a small, named set of original game interface compositions."""
    interface_compositions = {
        "panel_tall": 0,
        "panel_wide": 23,
        "progress_cyan": 25,
        "frame_compact": 28,
        "pet_system": 40,
        "badge_system": 41,
        "quest": 42,
        "map": 43,
        "battle": 44,
        "element_fire": 46,
        "element_wood": 47,
        "element_earth": 48,
        "element_water": 49,
        "element_wind": 50,
        "element_ghost": 51,
        "element_electric": 52,
        "back": 76,
        "tab": 92,
        "action_toolbar": 93,
        "window": 145,
    }
    manifest: dict[str, str] = {}

    for name, composition_id in interface_compositions.items():
        image = extract_sprite(sprite_map, 257, composition_id)
        if image is None:
            continue

        save_image(image, OUTPUT_ROOT / "ui" / f"{name}.png")
        manifest[name] = f"/assets/game/ui/{name}.png"

    return manifest


def extract_effect_icons(sprite_map: list[list[int]]) -> dict[str, dict[str, str]]:
    """Export the 11 debuff and 15 buff icons used by the battle status UI."""
    definition = read_sprite_definition(sprite_map[325][0])
    atlas_ids = sprite_map[325][1:]
    effect_groups = {
        "harmful": (11, 1),
        "beneficial": (15, 12),
    }
    manifest: dict[str, dict[str, str]] = {}

    for kind, (effect_count, composition_offset) in effect_groups.items():
        manifest[kind] = {}

        for game_id in range(effect_count):
            image = render_composition(
                definition,
                atlas_ids,
                game_id + composition_offset,
                padding=2,
            )
            if image is None:
                continue

            filename = f"{kind}-{game_id}.png"
            save_image(image, OUTPUT_ROOT / "effects" / filename)
            manifest[kind][str(game_id)] = f"/assets/game/effects/{filename}"

    return manifest


def extract_badge_icons(sprite_map: list[list[int]]) -> dict[str, str]:
    """Export the eight badge icons used by badge.ui from sprite 257."""
    manifest: dict[str, str] = {}

    for game_id in range(8):
        image = extract_sprite(sprite_map, 257, game_id + 46)
        if image is None:
            continue

        filename = f"{game_id}.png"
        save_image(image, OUTPUT_ROOT / "badges" / filename)
        manifest[str(game_id)] = f"/assets/game/badges/{filename}"

    return manifest


def extract_skill_animations(
    sprite_map: list[list[int]],
) -> dict[str, object]:
    """Export the original Liệt Hỏa Skill VFX and their seven-byte timelines."""
    timelines = read_jagged_byte_table(RAW_ROOT / "script" / "effect.mid")
    special_effects = read_jagged_short_table(
        RAW_ROOT / "script" / "speffect.mid"
    )
    rendered_actions: dict[tuple[int, int], dict[str, object]] = {}
    skills: dict[str, dict[str, object]] = {}

    for skill_id, timeline in enumerate(timelines):
        if len(timeline) % 7 != 0:
            raise ValueError(
                f"Skill {skill_id} has an invalid timeline length: {len(timeline)}"
            )

        events: list[dict[str, object]] = []
        for event_index in range(0, len(timeline), 7):
            target, event_type, source_id, animation_id, trigger, follow_up, action = (
                timeline[event_index : event_index + 7]
            )
            event: dict[str, object] = {
                "index": event_index // 7,
                "anchor": "opponent" if target == 0 else "caster",
                "source_row": timeline[event_index : event_index + 7],
                "trigger_frame": None if trigger == -1 else trigger,
                "follow_up_frame": None if follow_up == -1 else follow_up,
                "follow_up_action": action,
            }

            if event_type == 1:
                definition = special_effects[source_id]
                if definition[0] not in PROCEDURAL_EFFECT_TYPES:
                    raise ValueError(
                        f"Effect {source_id} uses unsupported a.a.b type {definition[0]}"
                    )

                event.update(
                    {
                        "kind": "procedural_pet_effect",
                        "source_effect_id": source_id,
                        "source_effect_type": definition[0],
                        "source_parameters": definition,
                        "render_status": "decoded_original",
                        "runtime_renderer": "a.a.b.canvas.v1",
                        "snapshot_composition_state": 1 if target == 1 else 0,
                        "duration_ms": procedural_duration_ticks(definition)
                        * GAME_TICK_MS,
                        "tick_ms": GAME_TICK_MS,
                    }
                )
                if definition[0] == 1:
                    event["texture_url"] = (
                        "/assets/game/skill-animations/textures/"
                        f"texture-{definition[3]}.png"
                    )
                events.append(event)
                continue

            if source_id < 20 or source_id - 20 >= len(SKILL_EFFECT_SPRITE_IDS):
                raise ValueError(
                    f"Skill {skill_id} references unsupported action {source_id}"
                )

            action_key = (source_id, animation_id)
            if action_key not in rendered_actions:
                sprite_id = SKILL_EFFECT_SPRITE_IDS[source_id - 20]
                sprite_file_id, *atlas_ids = sprite_map[sprite_id]
                definition = read_sprite_definition(sprite_file_id)
                frames, durations = animation_frames(
                    definition,
                    atlas_ids,
                    animation_id,
                    padding=4,
                )
                if not frames:
                    raise ValueError(
                        f"Action {source_id}:{animation_id} has no renderable frames"
                    )

                filename = f"action-{source_id}-{animation_id}.webp"
                save_animation(
                    frames,
                    durations,
                    OUTPUT_ROOT / "skill-animations" / filename,
                )
                rendered_actions[action_key] = {
                    "source_action_id": source_id,
                    "source_sprite_id": sprite_id,
                    "source_animation_id": animation_id,
                    "url": f"/assets/game/skill-animations/{filename}",
                    "frame_count": len(frames),
                    "duration_ms": sum(durations),
                    "tick_ms": GAME_TICK_MS,
                }

            event.update(
                {
                    "kind": "sprite_animation",
                    "render_status": "decoded_original",
                    **rendered_actions[action_key],
                }
            )
            events.append(event)

        skills[str(skill_id)] = {
            "source_skill_id": skill_id,
            "source_timeline": timeline,
            "events": events,
            "rendered_event_count": sum(
                event["render_status"] == "decoded_original" for event in events
            ),
        }

    return {
        "source": {
            "timeline": "/data/script/effect.mid",
            "special_effects": "/data/script/speffect.mid",
            "renderer": "a.a.b",
        },
        "tick_ms": GAME_TICK_MS,
        "procedural_renderer": {
            "runtime": "a.a.b.canvas.v1",
            "supported_types": sorted(PROCEDURAL_EFFECT_TYPES),
            "textures": extract_procedural_textures(),
            "snapshot_composition_states": [0, 1, 2, 3, 4],
        },
        "rendered_actions": {
            f"{action_id}:{animation_id}": metadata
            for (action_id, animation_id), metadata in rendered_actions.items()
        },
        "skills": skills,
    }


def main() -> None:
    sprite_map = read_sprite_map()
    pet_manifest: dict[str, str] = {}
    pet_effect_snapshot_manifest: dict[str, dict[str, dict[str, int | str]]] = {}
    pet_animation_manifest: dict[str, dict[str, object]] = {}
    item_manifest: dict[str, str] = {}
    skill_manifest: dict[str, str] = {}

    for sprite_id in range(86, 186):
        image = extract_sprite(sprite_map, sprite_id)
        if image is None:
            continue

        save_image(image, OUTPUT_ROOT / "pets" / f"{sprite_id}.png")
        pet_manifest[str(sprite_id)] = f"/assets/game/pets/{sprite_id}.png"

        sprite_file_id, *atlas_ids = sprite_map[sprite_id]
        definition = read_sprite_definition(sprite_file_id)
        pet_effect_snapshot_manifest[str(sprite_id)] = {}
        for composition_state in range(min(5, len(definition.compositions))):
            snapshot = render_composition(
                definition,
                atlas_ids,
                composition_state,
                padding=0,
            )
            if snapshot is None:
                continue

            bounds = composition_bounds(definition, composition_state)
            if bounds is None:
                continue

            snapshot_url = (
                "/assets/game/pet-effect-snapshots/"
                f"{sprite_id}-state-{composition_state}.png"
            )
            save_image(
                snapshot,
                OUTPUT_ROOT
                / "pet-effect-snapshots"
                / f"{sprite_id}-state-{composition_state}.png",
            )
            left, top, right, bottom = bounds
            pet_effect_snapshot_manifest[str(sprite_id)][str(composition_state)] = {
                "url": snapshot_url,
                "origin_x": left,
                "origin_y": top,
                "width": right - left,
                "height": bottom - top,
            }

        frames, durations = animation_frames(definition, atlas_ids, animation_id=1)
        if not frames:
            continue

        animation_url = f"/assets/game/pet-animations/{sprite_id}-skill.webp"
        save_animation(
            frames,
            durations,
            OUTPUT_ROOT / "pet-animations" / f"{sprite_id}-skill.webp",
        )
        pet_animation_manifest[str(sprite_id)] = {
            "action": "skill",
            "source_action_id": 1,
            "url": animation_url,
            "frame_count": len(frames),
            "duration_ms": sum(durations),
            "tick_ms": GAME_TICK_MS,
        }

    item_definition = read_sprite_definition(sprite_map[258][0])
    item_atlas_ids = sprite_map[258][1:]
    for frame_id in range(len(item_definition.compositions)):
        image = render_composition(
            item_definition, item_atlas_ids, frame_id, padding=2
        )
        if image is None:
            continue

        save_image(image, OUTPUT_ROOT / "items" / f"{frame_id}.png")
        item_manifest[str(frame_id)] = f"/assets/game/items/{frame_id}.png"

    # Sprite 260 contains the game's creature silhouettes. They are used as
    # atmospheric skill motifs, not presented as one-to-one skill artwork.
    skill_definition = read_sprite_definition(sprite_map[260][0])
    skill_atlas_ids = sprite_map[260][1:]
    for motif_id in range(len(skill_definition.compositions)):
        image = render_composition(
            skill_definition, skill_atlas_ids, motif_id, padding=2
        )
        if image is None:
            continue

        save_image(image, OUTPUT_ROOT / "skills" / f"motif-{motif_id}.png")
        skill_manifest[str(motif_id)] = (
            f"/assets/game/skills/motif-{motif_id}.png"
        )

    badge_manifest = extract_badge_icons(sprite_map)
    effect_manifest = extract_effect_icons(sprite_map)
    skill_animation_manifest = extract_skill_animations(sprite_map)
    skill_animation_manifest_path = OUTPUT_ROOT / "skill-animations" / "manifest.json"
    skill_animation_manifest_path.parent.mkdir(parents=True, exist_ok=True)
    skill_animation_manifest_path.write_text(
        json.dumps(skill_animation_manifest, ensure_ascii=False, indent=2) + "\n",
        encoding="utf-8",
    )
    manifest = {
        "source": "Decoded VQSV J2ME sprite pipeline",
        "pets": pet_manifest,
        "pet_effect_snapshots": pet_effect_snapshot_manifest,
        "pet_animations": pet_animation_manifest,
        "items": item_manifest,
        "badges": badge_manifest,
        "skill_motifs": skill_manifest,
        "skill_animations_manifest": "/assets/game/skill-animations/manifest.json",
        "effects": effect_manifest,
        "decor": copy_decorations(),
        "ui": extract_interface(sprite_map),
    }
    OUTPUT_ROOT.mkdir(parents=True, exist_ok=True)
    (OUTPUT_ROOT / "manifest.json").write_text(
        json.dumps(manifest, ensure_ascii=False, indent=2) + "\n",
        encoding="utf-8",
    )

    print(
        f"Extracted {len(pet_manifest)} pets, "
        f"{sum(len(states) for states in pet_effect_snapshot_manifest.values())} "
        "Pet effect composition snapshots, "
        f"{len(pet_animation_manifest)} original Pet skill animations, "
        f"{len(item_manifest)} item frames, "
        f"{len(badge_manifest)} badges, "
        f"{len(skill_manifest)} skill motifs, and "
        f"{len(skill_animation_manifest['skills'])} original Skill timelines, "
        f"{sum(len(group) for group in effect_manifest.values())} effect icons "
        f"to {OUTPUT_ROOT}"
    )


if __name__ == "__main__":
    main()
