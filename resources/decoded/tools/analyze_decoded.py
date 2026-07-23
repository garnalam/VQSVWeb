from __future__ import annotations

import csv
import hashlib
import re
import shutil
import struct
from collections import Counter, defaultdict
from dataclasses import dataclass
from pathlib import Path

from PIL import Image, ImageDraw, ImageFont


ROOT = Path(__file__).resolve().parents[1]
ORIGINAL_ARCHIVE = ROOT / "01_original" / "archive"
CFR_ROOT = ROOT / "02_decompiled" / "cfr"
VINEFLOWER_ROOT = ROOT / "02_decompiled" / "vineflower"
JAVAP_ROOT = ROOT / "03_bytecode" / "javap"
RAW_RESOURCES = ROOT / "04_resources" / "raw"
RECOGNIZED_ROOT = ROOT / "04_resources" / "recognized"
MODULE_ROOT = ROOT / "05_modules"
ANALYSIS_ROOT = ROOT / "06_analysis"
INVENTORY_ROOT = ROOT / "00_inventory"


@dataclass(frozen=True)
class ModuleDefinition:
    slug: str
    title: str
    description: str
    classes: tuple[str, ...]


MODULES = (
    ModuleDefinition(
        "01_bootstrap_game_loop",
        "Khởi động và vòng lặp game",
        "MIDlet entry point, Canvas chính, luồng update/render/input và lớp scene nền.",
        ("game.GameMIDLet", "game.m", "a.a"),
    ),
    ModuleDefinition(
        "02_scene_input_primitives",
        "Scene, input và primitive engine",
        "Các callback, timer, base object và primitive dùng chung cho scene/rendering.",
        ("a.b", "a.c", "a.d", "a.f", "a.a.a", "a.a.b", "a.a.g", "a.a.h", "a.b.a", "a.b.b"),
    ),
    ModuleDefinition(
        "03_assets_media_storage",
        "Asset, media, lưu trữ và codec dữ liệu",
        "Đọc resource nhị phân, map/sprite, ảnh, âm thanh MIDI, RMS và bitmap font.",
        (
            "a.e", "a.a.c", "a.a.d", "a.a.e", "a.a.i", "a.b.c", "a.b.d", "a.b.e",
            "a.b.f", "a.b.g", "a.b.h", "b", "b.a", "b.b", "game.n",
        ),
    ),
    ModuleDefinition(
        "04_ui_framework",
        "UI framework nhị phân",
        "Widget, container, layout, event và renderer dùng để nạp các file data/ui/*.ui.",
        tuple(f"c.{name}" for name in "abcdefghijklm"),
    ),
    ModuleDefinition(
        "05_gameplay_battle_entities",
        "Chiến đấu và thực thể gameplay",
        "Battle state machine, pet/actor, NPC, reward/interactable và dữ liệu combat.",
        ("a.a.f", "game.a", "game.h", "game.i", "game.j"),
    ),
    ModuleDefinition(
        "06_world_events_save",
        "World, event, quest và save",
        "Scene/world controllers, nhiệm vụ-phần thưởng, nạp event và trạng thái lưu RMS.",
        ("game.b", "game.c", "game.e", "game.l"),
    ),
    ModuleDefinition(
        "07_menus_dialogs_flow",
        "Menu, dialog và luồng màn hình",
        "Dialog renderer, splash/pause, main menu và controller của toàn bộ UI gameplay.",
        ("game.d", "game.f", "game.g", "game.k"),
    ),
    ModuleDefinition(
        "08_lua_runtime",
        "Máy ảo Lua nhúng",
        "Loader bytecode, stack, table, interpreter/thread và standard-library subset của Lua.",
        tuple(f"d.{name}" for name in "abcdefghij"),
    ),
    ModuleDefinition(
        "09_activation_sms_payment",
        "Kích hoạt, SMS và payment",
        "Đọc thông tin thiết bị/kích hoạt, màn hình thanh toán và transport SMS Java ME.",
        (
            "a", "e.a.a.a.a.a", "e.a.a.a.b.a", "e.a.a.a.b.b", "e.a.a.a.b.c",
            "e.b.a.a.a", "e.b.a.a.b", "lavax.wireless.messaging.MessageConnection",
        ),
    ),
)


ROLE_OVERRIDES = {
    "game.GameMIDLet": ("MIDlet entry point; tạo Display và Canvas chính", "high"),
    "game.m": ("Canvas chính; game loop, paint, keypad và pointer input", "high"),
    "a.a": ("Lớp scene/state trừu tượng và cầu nối display/payment", "high"),
    "a.a.c": ("RecordStore/RMS wrapper", "high"),
    "a.a.d": ("Ảnh/animation frame helper", "medium"),
    "a.a.e": ("Audio player/manager cho MIDI và media Java ME", "high"),
    "a.a.i": ("PlayerListener cho audio lifecycle", "high"),
    "a.b.c": ("Nạp cơ sở dữ liệu asset/script toàn cục", "high"),
    "a.b.d": ("Nạp map và module scene", "high"),
    "a.b.e": ("RMS persistence helper", "high"),
    "a.b.f": ("Nạp sprite binary data/spr", "high"),
    "a.e": ("Utility nạp resource, ảnh, dữ liệu và vẽ chữ", "high"),
    "b": ("DataInputStream có buffer/auto-close cho resource", "high"),
    "game.a": ("Battle state machine và combat rendering", "high"),
    "game.d": ("Dialog renderer và phân trang hội thoại", "high"),
    "game.e": ("Quest/event/reward controller", "high"),
    "game.f": ("Splash/tutorial/pause screen", "medium"),
    "game.g": ("Main menu, thoát game và tạo game mới", "high"),
    "game.h": ("World actor/NPC runtime object", "medium"),
    "game.i": ("Pet/combatant model với stat, element và skill", "high"),
    "game.j": ("Player/inventory/world-interaction aggregate", "medium"),
    "game.k": ("Controller menu/UI gameplay", "high"),
    "game.l": ("World state, scene loader, save/load và game orchestration", "high"),
    "game.n": ("Bitmap font renderer đọc font.bin", "high"),
    "d.a": ("Lua standard library subset", "high"),
    "d.f": ("Lua bytecode loader", "high"),
    "d.g": ("Lua interpreter/thread execution", "high"),
    "d.h": ("Lua table implementation", "high"),
    "d.i": ("Lua value stack", "high"),
    "e.a.a.a.a.a": ("Cấu hình giá/nội dung SMS payment", "high"),
    "e.a.a.a.b.b": ("Canvas UI cho luồng payment", "high"),
    "e.b.a.a.b": ("Runnable gửi SMS qua Wireless Messaging API", "high"),
    "lavax.wireless.messaging.MessageConnection": ("Compatibility shim cho gửi SMS bất đồng bộ", "high"),
    "a": ("Đọc UID/Term/RefCode và dữ liệu kích hoạt từ l2.bin", "high"),
}


def ensure_directories() -> None:
    for path in (INVENTORY_ROOT, RECOGNIZED_ROOT, MODULE_ROOT, ANALYSIS_ROOT):
        path.mkdir(parents=True, exist_ok=True)


def sha256(path: Path) -> str:
    digest = hashlib.sha256()
    with path.open("rb") as stream:
        for block in iter(lambda: stream.read(1024 * 1024), b""):
            digest.update(block)
    return digest.hexdigest().upper()


def class_name_from_relative(relative: Path) -> str:
    return relative.with_suffix("").as_posix().replace("/", ".")


def source_path(root: Path, class_name: str, suffix: str) -> Path:
    return root / Path(*class_name.split(".")).with_suffix(suffix)


def module_lookup() -> dict[str, ModuleDefinition]:
    lookup: dict[str, ModuleDefinition] = {}
    for module in MODULES:
        for class_name in module.classes:
            if class_name in lookup:
                raise RuntimeError(f"Class {class_name} is assigned to multiple modules")
            lookup[class_name] = module
    return lookup


def parse_declaration(source: str) -> tuple[str, str, str]:
    pattern = re.compile(
        r"^\s*(?:public\s+)?(?:final\s+|abstract\s+)?(?:class|interface)\s+([\w$]+)"
        r"(?:\s+extends\s+([\w.$]+))?(?:\s+implements\s+([^\{]+))?",
        re.MULTILINE,
    )
    match = pattern.search(source)
    if not match:
        return "", "", ""
    return match.group(1) or "", match.group(2) or "", (match.group(3) or "").strip()


def count_source_members(source: str) -> tuple[int, int]:
    method_pattern = re.compile(
        r"^\s*(?:public|protected|private)\s+(?:static\s+)?(?:final\s+)?[\w.$<>\[\]]+\s+[\w$]+\s*\(",
        re.MULTILINE,
    )
    field_pattern = re.compile(
        r"^\s*(?:public|protected|private)\s+(?:static\s+)?(?:final\s+)?[\w.$<>\[\]]+\s+[\w$]+(?:\s*=|\s*;)",
        re.MULTILINE,
    )
    return len(field_pattern.findall(source)), len(method_pattern.findall(source))


def project_dependencies(javap_text: str, project_classes: set[str], current: str) -> set[str]:
    candidates = set(re.findall(r"(?:class\s+|//\s+)([A-Za-z_$][\w$]*(?:/[A-Za-z_$][\w$]*)+)", javap_text))
    candidates.update(re.findall(r"L([A-Za-z_$][\w$]*(?:/[A-Za-z_$][\w$]*)+);", javap_text))
    normalized = {candidate.replace("/", ".").split("$")[0] for candidate in candidates}
    return {candidate for candidate in normalized if candidate in project_classes and candidate != current}


def java_strings(source: str) -> list[str]:
    values: list[str] = []
    for value in re.findall(r'"((?:\\.|[^"\\])*)"', source):
        if value and value not in values:
            values.append(value)
    return values


def inferred_role(class_name: str, module: ModuleDefinition) -> tuple[str, str]:
    if class_name in ROLE_OVERRIDES:
        return ROLE_OVERRIDES[class_name]
    if class_name.startswith("c."):
        return ("Thành phần của UI framework nhị phân", "medium")
    if class_name.startswith("d."):
        return ("Thành phần nội bộ của máy ảo Lua", "medium")
    if class_name.startswith("e."):
        return ("Adapter/callback của hệ thống SMS payment", "medium")
    return (module.description, "low")


def analyze_classes() -> None:
    class_files = sorted(ORIGINAL_ARCHIVE.rglob("*.class"))
    project_classes = {class_name_from_relative(path.relative_to(ORIGINAL_ARCHIVE)) for path in class_files}
    modules = module_lookup()
    if project_classes != set(modules):
        missing = sorted(project_classes - set(modules))
        unknown = sorted(set(modules) - project_classes)
        raise RuntimeError(f"Module map mismatch; missing={missing}, unknown={unknown}")

    inventory_rows: list[dict[str, object]] = []
    dependency_rows: list[dict[str, str]] = []
    resource_reference_rows: list[dict[str, str]] = []
    strings_root = ANALYSIS_ROOT / "strings_by_class"
    strings_root.mkdir(parents=True, exist_ok=True)

    for class_file in class_files:
        relative = class_file.relative_to(ORIGINAL_ARCHIVE)
        class_name = class_name_from_relative(relative)
        module = modules[class_name]
        cfr_path = source_path(CFR_ROOT, class_name, ".java")
        vine_path = source_path(VINEFLOWER_ROOT, class_name, ".java")
        javap_path = source_path(JAVAP_ROOT, class_name, ".javap.txt")
        cfr_source = cfr_path.read_text(encoding="utf-8", errors="replace")
        vine_source = vine_path.read_text(encoding="utf-8", errors="replace")
        javap_text = javap_path.read_text(encoding="utf-8-sig", errors="replace")
        raw_header = class_file.read_bytes()[:8]
        minor, major = struct.unpack(">HH", raw_header[4:8])
        _, superclass, interfaces = parse_declaration(vine_source)
        fields, methods = count_source_members(vine_source)
        role, confidence = inferred_role(class_name, module)
        cfr_warning_count = cfr_source.count("Unable to fully structure code") + cfr_source.count("Could not resolve type clashes")
        vine_warning_count = vine_source.count("$VF:") + vine_source.count("Please report this")

        for dependency in sorted(project_dependencies(javap_text, project_classes, class_name)):
            dependency_rows.append({"source_class": class_name, "target_class": dependency})

        strings = java_strings(vine_source)
        string_output = strings_root / Path(*class_name.split(".")).with_suffix(".strings.txt")
        string_output.parent.mkdir(parents=True, exist_ok=True)
        string_output.write_text("\n".join(strings) + ("\n" if strings else ""), encoding="utf-8")
        for value in strings:
            for resource in re.findall(r"/data/[A-Za-z0-9_./()]+", value):
                resource_reference_rows.append({"class": class_name, "resource_literal": resource})

        inventory_rows.append(
            {
                "class": class_name,
                "module": module.slug,
                "inferred_role": role,
                "confidence": confidence,
                "superclass": superclass,
                "interfaces": interfaces,
                "class_bytes": class_file.stat().st_size,
                "class_major": major,
                "class_minor": minor,
                "estimated_fields": fields,
                "estimated_methods": methods,
                "vineflower_lines": len(vine_source.splitlines()),
                "cfr_lines": len(cfr_source.splitlines()),
                "cfr_warning_markers": cfr_warning_count,
                "vineflower_warning_markers": vine_warning_count,
                "sha256": sha256(class_file),
            }
        )

    write_csv(INVENTORY_ROOT / "class-inventory.csv", inventory_rows)
    write_csv(INVENTORY_ROOT / "class-dependencies.csv", dependency_rows)
    write_csv(INVENTORY_ROOT / "resource-references.csv", resource_reference_rows)
    write_class_catalog(inventory_rows, dependency_rows)
    build_modules(modules, inventory_rows, dependency_rows)


def write_csv(path: Path, rows: list[dict[str, object]]) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    if not rows:
        path.write_text("", encoding="utf-8")
        return
    with path.open("w", encoding="utf-8-sig", newline="") as stream:
        writer = csv.DictWriter(stream, fieldnames=list(rows[0]))
        writer.writeheader()
        writer.writerows(rows)


def write_class_catalog(rows: list[dict[str, object]], dependencies: list[dict[str, str]]) -> None:
    incoming = Counter(row["target_class"] for row in dependencies)
    outgoing = Counter(row["source_class"] for row in dependencies)
    lines = [
        "# Danh mục class đã phục hồi",
        "",
        "Tên và vai trò dưới đây là suy luận từ inheritance, API, resource literal và dependency; tên gốc đã mất do obfuscation.",
        "",
        "| Class | Module | Vai trò suy luận | Tin cậy | Dòng VF/CFR | Cảnh báo CFR/VF | Phụ thuộc vào / được gọi bởi |",
        "|---|---|---|---:|---:|---:|---:|",
    ]
    for row in sorted(rows, key=lambda item: str(item["class"])):
        name = str(row["class"])
        role = str(row["inferred_role"]).replace("|", "\\|")
        lines.append(
            f"| `{name}` | `{row['module']}` | {role} | {row['confidence']} | "
            f"{row['vineflower_lines']}/{row['cfr_lines']} | {row['cfr_warning_markers']}/{row['vineflower_warning_markers']} | "
            f"{outgoing[name]}/{incoming[name]} |"
        )
    (ANALYSIS_ROOT / "class-catalog.md").write_text("\n".join(lines) + "\n", encoding="utf-8")


def copy_class_artifact(source_root: Path, class_name: str, suffix: str, destination_root: Path) -> None:
    source = source_path(source_root, class_name, suffix)
    destination = source_path(destination_root, class_name, suffix)
    destination.parent.mkdir(parents=True, exist_ok=True)
    shutil.copy2(source, destination)


def build_modules(
    module_by_class: dict[str, ModuleDefinition],
    inventory_rows: list[dict[str, object]],
    dependencies: list[dict[str, str]],
) -> None:
    inventory = {str(row["class"]): row for row in inventory_rows}
    for module in MODULES:
        destination = MODULE_ROOT / module.slug
        for class_name in module.classes:
            copy_class_artifact(VINEFLOWER_ROOT, class_name, ".java", destination / "source_vineflower")
            copy_class_artifact(CFR_ROOT, class_name, ".java", destination / "source_cfr")
            copy_class_artifact(JAVAP_ROOT, class_name, ".javap.txt", destination / "bytecode_javap")

        class_set = set(module.classes)
        internal_edges = [row for row in dependencies if row["source_class"] in class_set and row["target_class"] in class_set]
        outbound = [row for row in dependencies if row["source_class"] in class_set and row["target_class"] not in class_set]
        inbound = [row for row in dependencies if row["source_class"] not in class_set and row["target_class"] in class_set]
        lines = [
            f"# {module.title}",
            "",
            module.description,
            "",
            "## Nội dung",
            "",
            "- `source_vineflower/`: bản decompile ưu tiên để đọc.",
            "- `source_cfr/`: bản decompile đối chiếu.",
            "- `bytecode_javap/`: disassembly chính xác để kiểm chứng.",
            "",
            "## Class",
            "",
            "| Class | Vai trò suy luận | Tin cậy |",
            "|---|---|---:|",
        ]
        for class_name in module.classes:
            row = inventory[class_name]
            lines.append(f"| `{class_name}` | {row['inferred_role']} | {row['confidence']} |")
        lines.extend(
            [
                "",
                "## Dependency thống kê",
                "",
                f"- Cạnh nội bộ module: {len(internal_edges)}",
                f"- Cạnh gọi sang module khác: {len(outbound)}",
                f"- Cạnh từ module khác gọi vào: {len(inbound)}",
                "",
            ]
        )
        (destination / "README.md").write_text("\n".join(lines), encoding="utf-8")


def file_kind(data: bytes) -> str:
    if data.startswith(b"\x89PNG\r\n\x1a\n"):
        return "png"
    if data.startswith((b"GIF87a", b"GIF89a")):
        return "gif"
    if data.startswith(b"\xff\xd8\xff"):
        return "jpeg"
    if data.startswith(b"MThd"):
        return "midi"
    if data.startswith(b"RIFF") and data[8:12] == b"WAVE":
        return "wave"
    if data.startswith(b"BM"):
        return "bmp"
    sample = data[:1024]
    if sample:
        readable = sum(byte in b"\t\r\n" or 32 <= byte < 127 for byte in sample) / len(sample)
        if readable >= 0.85:
            return "text_like"
    return "custom_binary"


def png_metadata(data: bytes) -> tuple[str, str]:
    if len(data) < 29 or not data.startswith(b"\x89PNG\r\n\x1a\n"):
        return "", ""
    width, height = struct.unpack(">II", data[16:24])
    color_types = {0: "grayscale", 2: "rgb", 3: "indexed", 4: "grayscale_alpha", 6: "rgba"}
    return f"{width}x{height}", color_types.get(data[25], str(data[25]))


def midi_metadata(data: bytes) -> tuple[str, str]:
    if len(data) < 14 or not data.startswith(b"MThd"):
        return "", ""
    midi_format, tracks, division = struct.unpack(">HHH", data[8:14])
    return f"format={midi_format};tracks={tracks}", str(division)


def extract_binary_strings(data: bytes) -> list[str]:
    values: list[str] = []
    for match in re.finditer(rb"[\x20-\x7e]{4,}", data):
        value = match.group().decode("ascii", errors="replace")
        if value not in values:
            values.append(value)
    for match in re.finditer(rb"(?:\x00[\x20-\x7e]){4,}", data):
        value = match.group().decode("utf-16-be", errors="replace")
        if value not in values:
            values.append(value)
    try:
        decoded = data.decode("utf-8")
    except UnicodeDecodeError:
        decoded = ""
    if decoded:
        for value in re.findall(r"[^\x00-\x1f\x7f]{4,}", decoded):
            if value not in values:
                values.append(value)
    return values


def recognized_destination(relative: Path, kind: str) -> Path:
    family = {
        "png": "images",
        "gif": "images",
        "jpeg": "images",
        "bmp": "images",
        "midi": "audio",
        "wave": "audio",
        "text_like": "text",
    }[kind]
    extension = {"png": ".png", "gif": ".gif", "jpeg": ".jpg", "bmp": ".bmp", "midi": ".mid", "wave": ".wav", "text_like": ".txt"}[kind]
    return RECOGNIZED_ROOT / family / relative.with_suffix(extension)


def analyze_resources() -> None:
    rows: list[dict[str, object]] = []
    summary = Counter()
    family_summary: defaultdict[str, Counter[str]] = defaultdict(Counter)
    strings_root = ANALYSIS_ROOT / "binary_strings"
    strings_root.mkdir(parents=True, exist_ok=True)
    image_paths: list[tuple[Path, str]] = []

    for path in sorted(RAW_RESOURCES.rglob("*")):
        if not path.is_file():
            continue
        relative = path.relative_to(RAW_RESOURCES)
        data = path.read_bytes()
        kind = file_kind(data)
        summary[kind] += 1
        family = relative.parts[1] if len(relative.parts) > 1 and relative.parts[0] == "data" else "root"
        family_summary[family][kind] += 1
        dimensions = ""
        detail = ""
        if kind == "png":
            dimensions, detail = png_metadata(data)
        elif kind == "midi":
            dimensions, detail = midi_metadata(data)

        recognized = ""
        if kind != "custom_binary":
            destination = recognized_destination(relative, kind)
            destination.parent.mkdir(parents=True, exist_ok=True)
            shutil.copy2(path, destination)
            recognized = destination.relative_to(ROOT).as_posix()
            if kind in {"png", "gif", "jpeg", "bmp"}:
                image_paths.append((destination, relative.as_posix()))

        extracted_strings = extract_binary_strings(data)
        if kind == "custom_binary" or extracted_strings:
            string_output = strings_root / relative.with_suffix(relative.suffix + ".strings.txt")
            string_output.parent.mkdir(parents=True, exist_ok=True)
            header = [
                f"path={relative.as_posix()}",
                f"kind={kind}",
                f"size={len(data)}",
                f"sha256={sha256(path)}",
                f"hex_prefix={data[:64].hex(' ')}",
                "",
            ]
            string_output.write_text("\n".join(header + extracted_strings) + "\n", encoding="utf-8")

        rows.append(
            {
                "path": relative.as_posix(),
                "family": family,
                "original_extension": relative.suffix,
                "detected_type": kind,
                "size_bytes": len(data),
                "dimensions_or_midi": dimensions,
                "detail": detail,
                "recognized_copy": recognized,
                "extracted_string_count": len(extracted_strings),
                "hex_prefix_32": data[:32].hex(" "),
                "sha256": sha256(path),
            }
        )

    write_csv(INVENTORY_ROOT / "resource-inventory.csv", rows)
    summary_rows = [
        {"family": family, "detected_type": kind, "count": count}
        for family, counts in sorted(family_summary.items())
        for kind, count in sorted(counts.items())
    ]
    write_csv(INVENTORY_ROOT / "resource-type-summary.csv", summary_rows)
    build_contact_sheets(image_paths)
    write_resource_analysis(summary, family_summary, rows)


def build_contact_sheets(images: list[tuple[Path, str]]) -> None:
    sheets_root = RECOGNIZED_ROOT / "contact_sheets"
    sheets_root.mkdir(parents=True, exist_ok=True)
    columns, rows_per_sheet = 8, 8
    cell_width, cell_height = 128, 128
    thumb_width, thumb_height = 112, 94
    per_sheet = columns * rows_per_sheet
    font = ImageFont.load_default()
    for sheet_index, start in enumerate(range(0, len(images), per_sheet), start=1):
        subset = images[start:start + per_sheet]
        sheet = Image.new("RGB", (columns * cell_width, rows_per_sheet * cell_height), "#20242a")
        draw = ImageDraw.Draw(sheet)
        for index, (path, label) in enumerate(subset):
            column = index % columns
            row = index // columns
            left = column * cell_width
            top = row * cell_height
            try:
                with Image.open(path) as image:
                    preview = image.convert("RGBA")
                    preview.thumbnail((thumb_width, thumb_height), Image.Resampling.NEAREST)
                    backdrop = Image.new("RGBA", preview.size, "white")
                    backdrop.alpha_composite(preview)
                    x = left + (cell_width - preview.width) // 2
                    y = top + 3 + (thumb_height - preview.height) // 2
                    sheet.paste(backdrop.convert("RGB"), (x, y))
            except Exception:
                draw.rectangle((left + 8, top + 8, left + cell_width - 8, top + thumb_height), outline="#ff6b6b")
            short_label = Path(label).name
            if len(short_label) > 19:
                short_label = short_label[:18] + "…"
            draw.text((left + 4, top + 102), short_label, fill="white", font=font)
            draw.rectangle((left, top, left + cell_width - 1, top + cell_height - 1), outline="#555b66")
        sheet.save(sheets_root / f"images_{sheet_index:02d}.png", optimize=True)


def write_resource_analysis(
    summary: Counter[str],
    family_summary: defaultdict[str, Counter[str]],
    rows: list[dict[str, object]],
) -> None:
    lines = [
        "# Phân tích tài nguyên",
        "",
        "File `.mid` trong game không đồng nghĩa với MIDI. Chữ ký thực tế được dùng để nhận diện; bản raw luôn được giữ nguyên.",
        "",
        "## Tổng hợp kiểu thực",
        "",
        "| Kiểu | Số lượng |",
        "|---|---:|",
    ]
    for kind, count in summary.most_common():
        lines.append(f"| `{kind}` | {count} |")
    lines.extend(["", "## Theo họ tài nguyên", "", "| Họ | Phân bố |", "|---|---|"])
    for family, counts in sorted(family_summary.items()):
        rendered = ", ".join(f"{kind}: {count}" for kind, count in sorted(counts.items()))
        lines.append(f"| `{family}` | {rendered} |")
    lines.extend(
        [
            "",
            "## Loader tương ứng trong source",
            "",
            "| Họ | Loader/consumer chính | Ý nghĩa suy luận |",
            "|---|---|---|",
            "| `data/img` | `a.e`, `a.b.c`, các class `game.*` | PNG đổi đuôi `.mid` |",
            "| `data/sound` | `a.a.e`, `game.l` | Standard MIDI |",
            "| `data/map`, `data/mod` | `a.b.d` | Map tile, room/module binary |",
            "| `data/spr` | `a.b.f`, `a.b.g` | Sprite frame/animation binary |",
            "| `data/ui` | package `c.*`, `game.k` | UI layout/widget binary |",
            "| `data/script` | `a.b.c`, `a.e`, `game.a/e/l` | Bảng dữ liệu và bytecode/script gameplay |",
            "| `data/event` | `game.l`, Lua runtime `d.*` | Event/scene scripts |",
            "| `data/tex` | `a.b.c`, `a.e` | Metadata/texture effect data |",
            "| `font.bin` | `game.n` | Bitmap font table |",
            "| `dcn.bin`, `l2.bin`, `cpid.txt` | `a`, `a.a.c` và payment module | Activation/payment metadata |",
            "",
            "Mọi custom binary có file companion trong `06_analysis/binary_strings/` chứa hash, hex prefix và chuỗi có thể phục hồi.",
            "",
        ]
    )
    (ANALYSIS_ROOT / "resource-analysis.md").write_text("\n".join(lines), encoding="utf-8")


def write_dependency_dot() -> None:
    dependency_csv = INVENTORY_ROOT / "class-dependencies.csv"
    with dependency_csv.open("r", encoding="utf-8-sig", newline="") as stream:
        rows = list(csv.DictReader(stream))
    modules = module_lookup()
    module_colors = {module.slug: f"#{(index * 2654435761) & 0xFFFFFF:06x}" for index, module in enumerate(MODULES, start=1)}
    lines = ["digraph GameDependencies {", "  rankdir=LR;", "  node [shape=box, fontname=Arial, fontsize=9];"]
    for module in MODULES:
        lines.append(f'  subgraph "cluster_{module.slug}" {{')
        lines.append(f'    label="{module.title}";')
        lines.append(f'    color="{module_colors[module.slug]}";')
        for class_name in module.classes:
            lines.append(f'    "{class_name}";')
        lines.append("  }")
    for row in rows:
        lines.append(f'  "{row["source_class"]}" -> "{row["target_class"]}";')
    lines.append("}")
    (ANALYSIS_ROOT / "class-dependencies.dot").write_text("\n".join(lines) + "\n", encoding="utf-8")


def main() -> None:
    ensure_directories()
    analyze_classes()
    analyze_resources()
    write_dependency_dot()
    print(f"classes={len(list(ORIGINAL_ARCHIVE.rglob('*.class')))}")
    print(f"resources={sum(1 for path in RAW_RESOURCES.rglob('*') if path.is_file())}")
    print(f"modules={len(MODULES)}")


if __name__ == "__main__":
    main()
