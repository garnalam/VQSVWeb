#!/usr/bin/env python3
"""Decode the Rainbow Pet J2ME database into reusable JSON and CSV files."""

from __future__ import annotations

import csv
import hashlib
import json
from dataclasses import dataclass
from pathlib import Path
from typing import Any


ROOT = Path(__file__).resolve().parents[1]
RAW_ROOT = ROOT / "04_resources" / "raw"
ANALYSIS_ROOT = ROOT / "06_analysis"
INVENTORY_ROOT = ROOT / "00_inventory"
DATA_PATH = RAW_ROOT / "data" / "data.d"
JAR_PATH = ROOT / "01_original" / "AowVN.org-sung-vat-cau-vong-240x320s60.jar"

ELEMENT_SLUGS = ["thuc-vat", "kim-loai", "phi-hanh", "manh-thu", "hai-duong"]
ELEMENT_COLORS = ["#4fbd63", "#8593a6", "#65a9ff", "#f08b45", "#30bcd4"]
STATUS_EFFECTS = {
    0: ("Thạch Hóa", "Không thể hành động; sát thương nhận vào giảm 30%."),
    1: ("Thiêu Đốt", "Trạng thái gây sát thương theo thời gian."),
    2: ("Tê Liệt", "Mỗi hiệp mất 10% sinh mệnh hiện tại."),
    3: ("Mị Hoặc", "Không thể chạy trốn và dễ bị bắt hơn."),
    4: ("Giam Cầm", "Không thể chạy trốn, đổi Sủng Vật hoặc dùng đạo cụ."),
    5: ("Hủ Thực", "Mỗi hiệp nhận một lượng sát thương tăng dần."),
    6: ("Phong Bế", "Không thể sử dụng kỹ năng vượt quá bậc cho phép."),
}


@dataclass
class Reader:
    data: bytes
    offset: int = 0

    def unsigned_byte(self) -> int:
        value = self.data[self.offset]
        self.offset += 1
        return value

    def signed_byte_array(self) -> list[int]:
        length = self.unsigned_byte()
        raw = self.data[self.offset : self.offset + length]
        self.offset += length
        return [value - 256 if value >= 128 else value for value in raw]

    def signed_byte_table(self) -> list[list[int]]:
        return [self.signed_byte_array() for _ in range(self.unsigned_byte())]

    def strings(self) -> list[str]:
        values: list[str] = []
        for _ in range(self.unsigned_byte()):
            length = self.unsigned_byte()
            byte_length = length * 2
            values.append(self.data[self.offset : self.offset + byte_length].decode("utf-16be"))
            self.offset += byte_length
        return values


def load_payload(path: Path) -> bytes:
    binary = path.read_bytes()
    payload_length = int.from_bytes(binary[:2], "big")
    payload = binary[2 : 2 + payload_length]
    if len(payload) != payload_length or len(binary) != payload_length + 2:
        raise ValueError(f"Invalid length prefix in {path}")
    return payload


def decode() -> dict[str, Any]:
    payload = load_payload(DATA_PATH)
    reader = Reader(payload)

    skill_unlock_matrix = reader.signed_byte_table()
    pet_rows = reader.signed_byte_table()
    skill_rows = reader.signed_byte_table()
    skill_descriptions = reader.strings()
    skill_names = reader.strings()
    element_names = reader.strings()
    pet_names = reader.strings()
    item_descriptions = reader.strings()
    item_names = reader.strings()
    location_names = reader.strings()
    trait_names = reader.strings()
    trait_descriptions = reader.strings()
    pet_location_rows = reader.signed_byte_table()
    pet_sprite_rows = reader.signed_byte_table()
    pet_evolution_rows = reader.signed_byte_table()
    pet_descriptions = reader.strings()
    trait_parameters = reader.signed_byte_array()
    trainer_level_requirements = reader.signed_byte_array()
    item_sound_ids = reader.signed_byte_array()
    short_sprite_groups = reader.signed_byte_array()
    map_rows = reader.signed_byte_table()
    encounter_rows = reader.signed_byte_table()

    if reader.offset != len(payload):
        raise ValueError(f"Parser left {len(payload) - reader.offset} unread bytes")

    elements = [
        {
            "game_id": game_id,
            "name": name,
            "slug": ELEMENT_SLUGS[game_id],
            "color": ELEMENT_COLORS[game_id],
        }
        for game_id, name in enumerate(element_names)
    ]
    elements.append(
        {
            "game_id": 255,
            "name": "Vô hệ",
            "slug": "vo-he",
            "color": "#9ca3af",
        }
    )

    effects = [
        {
            "source_table": 10,
            "game_id": game_id,
            "kind": "neutral" if game_id == 0 else ("harmful" if value < 0 else "beneficial"),
            "name": name,
            "description": trait_descriptions[game_id],
            "parameters": {"game_modifier": value},
        }
        for game_id, (name, value) in enumerate(zip(trait_names, trait_parameters, strict=True))
    ]
    effects.extend(
        {
            "source_table": 11,
            "game_id": game_id,
            "kind": "harmful",
            "name": name,
            "description": description,
            "parameters": None,
        }
        for game_id, (name, description) in STATUS_EFFECTS.items()
    )

    pets: list[dict[str, Any]] = []
    for game_id, row in enumerate(pet_rows):
        locations = pet_location_rows[game_id]
        element_game_id = row[6] if row[6] >= 0 else 255
        pets.append(
            {
                "game_id": game_id,
                "name": pet_names[game_id],
                "description": pet_descriptions[game_id],
                "element_game_id": element_game_id,
                "element": element_names[row[6]] if row[6] >= 0 else "Vô hệ",
                "hp_base": row[0],
                "energy_base": row[1],
                "agility_base": row[2],
                "strength_base": row[3],
                "defense_base": row[4],
                "evolution_stage": row[5],
                "hp_per_10_levels": row[7],
                "energy_per_10_levels": row[8],
                "agility_per_10_levels": row[9],
                "strength_per_10_levels": row[10],
                "defense_per_10_levels": row[11],
                "evolution_capacity": row[12],
                "flags": row[13:15],
                "sprite_group": pet_sprite_rows[game_id][0],
                "sprite_variant": pet_sprite_rows[game_id][1],
                "locations": [location_names[value] for value in locations if value >= 0],
                "acquisition_code": locations[0] if locations and locations[0] < 0 else None,
                "raw_values": row,
            }
        )

    skills: list[dict[str, Any]] = []
    for game_id, row in enumerate(skill_rows):
        element_game_id = game_id // 5 if game_id < 25 else None
        status_effect_id = (
            row[3]
            if len(row) >= 4 and row[2] > 0 and row[3] in STATUS_EFFECTS
            else None
        )
        skills.append(
            {
                "game_id": game_id,
                "name": skill_names[game_id],
                "description": skill_descriptions[game_id],
                "element_game_id": element_game_id,
                "power": row[0] if row else 0,
                "energy_cost": row[1] if len(row) >= 2 else 0,
                "status_chance": row[2] if len(row) >= 3 else 0,
                "status_effect_game_id": status_effect_id,
                "tier": game_id % 5 + 1 if game_id < 25 else 0,
                "category": "elemental_attack" if game_id < 25 else "common_or_passive",
                "artwork_group": min(game_id // 5, 5),
                "artwork_animation": game_id % 5 if game_id < 25 else game_id - 25,
                "raw_values": row,
            }
        )

    item_frames: list[int] = []
    encounter_pet_ids = encounter_rows[0]
    for game_id in range(len(item_names)):
        if game_id < 35:
            frame_id = game_id
        elif game_id < 58:
            frame_id = 34 + trainer_level_requirements[game_id - 35]
        else:
            pet_id = encounter_pet_ids[game_id - 58]
            frame_id = 40 + pet_rows[pet_id][6]
        item_frames.append(frame_id)

    items = [
        {
            "game_id": game_id,
            "name": name,
            "description": item_descriptions[game_id],
            "category": (
                "consumable" if game_id < 16 else
                "mineral" if game_id < 35 else
                "medal" if game_id < 58 else
                "ring"
            ),
            "frame_id": item_frames[game_id],
            "sound_id": item_sound_ids[game_id] if game_id < len(item_sound_ids) else None,
        }
        for game_id, name in enumerate(item_names)
    ]

    evolutions: list[dict[str, Any]] = []
    for from_pet_id, row in enumerate(pet_evolution_rows):
        if len(row) < 2:
            continue
        materials = [
            {"item_game_id": row[index], "quantity": row[index + 1]}
            for index in range(2, len(row) - 1, 2)
        ]
        normal_target = row[1]
        if normal_target != from_pet_id and normal_target > 0:
            evolutions.append(
                {
                    "from_pet_game_id": from_pet_id,
                    "to_pet_game_id": normal_target,
                    "evolution_type": "evolution",
                    "materials": materials,
                }
            )
        alternate_target = row[0]
        if alternate_target > 0 and alternate_target != from_pet_id:
            evolutions.append(
                {
                    "from_pet_game_id": from_pet_id,
                    "to_pet_game_id": alternate_target,
                    "evolution_type": "mutation",
                    "materials": [*materials, {"item_game_id": 34, "quantity": 1}],
                }
            )

    return {
        "meta": {
            "game": "Sủng Vật Cầu Vồng",
            "slug": "cau-vong",
            "jar_sha256": hashlib.sha256(JAR_PATH.read_bytes()).hexdigest().upper(),
            "data_payload_bytes": len(payload),
        },
        "elements": elements,
        "effects": effects,
        "pets": pets,
        "skills": skills,
        "items": items,
        "pet_evolutions": evolutions,
        "skill_unlock_matrix": skill_unlock_matrix,
        "locations": location_names,
        "internal": {
            "short_sprite_groups": short_sprite_groups,
            "map_rows": map_rows,
            "encounter_rows": encounter_rows,
        },
    }


def write_csv(path: Path, rows: list[dict[str, Any]]) -> None:
    if not rows:
        return
    with path.open("w", encoding="utf-8-sig", newline="") as handle:
        writer = csv.DictWriter(handle, fieldnames=list(rows[0]))
        writer.writeheader()
        for row in rows:
            writer.writerow({key: json.dumps(value, ensure_ascii=False) if isinstance(value, (list, dict)) else value for key, value in row.items()})


def write_inventory() -> None:
    rows = []
    for path in sorted(RAW_ROOT.rglob("*")):
        if not path.is_file():
            continue
        rows.append(
            {
                "path": path.relative_to(RAW_ROOT).as_posix(),
                "extension": path.suffix.lower() or "(none)",
                "bytes": path.stat().st_size,
                "sha256": hashlib.sha256(path.read_bytes()).hexdigest().upper(),
            }
        )
    write_csv(INVENTORY_ROOT / "resource-inventory.csv", rows)


def write_knowledge(data: dict[str, Any]) -> None:
    text = f"""# Kho tri thức Sủng Vật Cầu Vồng

## Nguồn giải mã

- JAR SHA256: `{data['meta']['jar_sha256']}`
- Database chính: `04_resources/raw/data/data.d`
- Loader: `02_decompiled/cfr-renamed/ak.java`, phương thức `j()`
- Parser nhị phân: `02_decompiled/cfr-renamed/ad.java`

## Dữ liệu đã xác nhận

| Module | Số bản ghi |
|---|---:|
| Hệ | {len(data['elements'])} |
| Pet | {len(data['pets'])} |
| Skill | {len(data['skills'])} |
| Item | {len(data['items'])} |
| Trait và hiệu ứng trạng thái | {len(data['effects'])} |
| Nhánh tiến hóa khác Pet | {len(data['pet_evolutions'])} |

Chỉ số Pet ở cấp `L` dùng công thức `base + growth * L / 10`. Pet có 5 hệ: Thực Vật, Kim Loại, Phi Hành, Mãnh Thú và Hải Dương. Skill 0–24 là năm bậc tấn công theo hệ; skill 25–48 là kỹ năng chung, chủ động đặc biệt hoặc bị động.

Item 0–15 là đạo cụ, 16–34 là khoáng thạch, 35–57 là huy chương và 58–69 là vòng. Mapping ảnh Item được khôi phục trực tiếp từ `ak.void_b(int,int,int,int)`, không suy đoán theo tên.

## Sprite

Pet dùng `data/npc2/{{group}}.png` và `{{group}}.data`. Bảng Pet trỏ đến `[sprite_group, variant]`; animation đại diện là `variant * 3`. Skill dùng `data/battle/s0..s5` với nhóm `min(skill_id / 5, 5)` và animation `skill_id % 5` hoặc `skill_id - 25` cho nhóm kỹ năng chung.
"""
    (ANALYSIS_ROOT / "rainbow-game-knowledge.md").write_text(text, encoding="utf-8")


def main() -> None:
    ANALYSIS_ROOT.mkdir(parents=True, exist_ok=True)
    INVENTORY_ROOT.mkdir(parents=True, exist_ok=True)
    data = decode()
    (ANALYSIS_ROOT / "game-data.json").write_text(
        json.dumps(data, ensure_ascii=False, indent=2),
        encoding="utf-8",
    )
    for key in ("pets", "skills", "items", "effects", "pet_evolutions"):
        write_csv(ANALYSIS_ROOT / f"{key}.csv", data[key])
    write_inventory()
    write_knowledge(data)
    print(
        f"Decoded {len(data['pets'])} pets, {len(data['skills'])} skills, "
        f"{len(data['items'])} items and {len(data['effects'])} effects."
    )


if __name__ == "__main__":
    main()
