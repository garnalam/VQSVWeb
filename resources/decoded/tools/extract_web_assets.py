"""Extract browser-ready artwork from the decoded VQSV sprite resources.

The original J2ME game stores artwork as atlas regions plus composition data.
This script reproduces that pipeline and writes transparent PNGs for the wiki.
"""

from __future__ import annotations

import json
import shutil
import struct
from dataclasses import dataclass
from pathlib import Path

from PIL import Image


PROJECT_ROOT = Path(__file__).resolve().parents[3]
DECODED_ROOT = PROJECT_ROOT / "resources" / "decoded" / "04_resources"
RAW_ROOT = DECODED_ROOT / "raw" / "data"
IMAGE_ROOT = DECODED_ROOT / "recognized" / "images" / "data" / "img"
OUTPUT_ROOT = PROJECT_ROOT / "public" / "assets" / "game"


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

    left = min(x for _, x, _ in pieces)
    top = min(y for _, _, y in pieces)
    right = max(x + image.width for image, x, _ in pieces)
    bottom = max(y + image.height for image, _, y in pieces)
    canvas = Image.new(
        "RGBA", (right - left + padding * 2, bottom - top + padding * 2)
    )

    for piece, destination_x, destination_y in pieces:
        canvas.alpha_composite(
            piece, (destination_x - left + padding, destination_y - top + padding)
        )

    return canvas


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


def main() -> None:
    sprite_map = read_sprite_map()
    pet_manifest: dict[str, str] = {}
    item_manifest: dict[str, str] = {}
    skill_manifest: dict[str, str] = {}

    for sprite_id in range(86, 186):
        image = extract_sprite(sprite_map, sprite_id)
        if image is None:
            continue

        save_image(image, OUTPUT_ROOT / "pets" / f"{sprite_id}.png")
        pet_manifest[str(sprite_id)] = f"/assets/game/pets/{sprite_id}.png"

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
    manifest = {
        "source": "Decoded VQSV J2ME sprite pipeline",
        "pets": pet_manifest,
        "items": item_manifest,
        "badges": badge_manifest,
        "skill_motifs": skill_manifest,
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
        f"Extracted {len(pet_manifest)} pets, {len(item_manifest)} item frames, "
        f"{len(badge_manifest)} badges, "
        f"{len(skill_manifest)} skill motifs, and "
        f"{sum(len(group) for group in effect_manifest.values())} effect icons "
        f"to {OUTPUT_ROOT}"
    )


if __name__ == "__main__":
    main()
