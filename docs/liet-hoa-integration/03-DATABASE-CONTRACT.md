# Hợp đồng SQLite cho agent và game importer

## Sinh snapshot

```powershell
cd C:\Users\Dell\Downloads\VQSV-Web
php artisan game:export-integration-data
```

Đường dẫn mặc định:

- Database: `storage/app/private/integration/vqsv-game-data.sqlite`
- Manifest: `storage/app/private/integration/vqsv-game-data.sqlite.manifest.json`

Có thể chọn đường dẫn khác:

```powershell
php artisan game:export-integration-data `
  --database=C:\temp\vqsv-game-data.sqlite `
  --manifest=C:\temp\vqsv-game-data.manifest.json
```

Luôn kiểm tra SHA-256 trong manifest trước khi import. Snapshot được sinh lại từ MySQL hiện tại; không chỉnh trực tiếp file SQLite.

## Khóa ổn định

| Domain | Ví dụ |
|---|---|
| Pet Liệt Hỏa | `LH-006` |
| Pet Cầu Vồng | `CV-000` |
| Skill Liệt Hỏa | `LH-SKILL-01` |
| Skill Cầu Vồng | `CV-SKILL-00` |
| Item | `LH-ITEM-3-12`, `CV-ITEM-1-00` |
| Effect | `LH-EFFECT-7-00` |
| Trait | `TC-12`, `TV-01`, `KL-03` |
| Evolution | `EVO-LH-006-LH-007` |

Không lưu `pets.id`, `skills.id` hoặc `items.id` của MySQL vào save game.

## Các bảng

| Bảng | Công dụng |
|---|---|
| `metadata` | Version và policy bắt buộc |
| `game_sources` | Nguồn cùng đường dẫn decoded chính |
| `elements` | Hệ nguồn để đối chiếu |
| `pets` | Hồ sơ Pet, stat formula và provenance |
| `pet_stat_profiles` | Stat đã tính ở cấp 1/50, sao 1–5 |
| `traits` | 13 trait thể chất + 20 trait Chủng |
| `skills` | 119 record nguồn, 99 active, mechanics JSON |
| `effects` | 46 Effect nguồn |
| `skill_unlock_rules` | Threshold legacy/reference |
| `pet_skill_learnsets` | Learnset chuẩn theo từng Pet |
| `items` | 112 Item và canonical alias |
| `item_decisions` | Giữ/gộp/loại, gồm 10 Item không có row trong `items` |
| `pet_evolutions` | Cạnh tiến hóa và provenance topology/recipe |
| `pet_evolution_ingredients` | Danh sách nguyên liệu mới |
| `divine_abilities` | Tính năng hợp nhất tùy chọn |

## Query thường dùng

Hồ sơ đầy đủ của một Pet:

```sql
SELECT p.*, t.name AS species_trait_name, t.parameters_json AS species_trait_parameters
FROM pets p
LEFT JOIN traits t ON t.trait_key = p.species_trait_key
WHERE p.pet_key = 'CV-000';
```

Chỉ số cấp 50 ở mọi sao:

```sql
SELECT stars, star_multiplier_percent, hp, strength, defense, agility
FROM pet_stat_profiles
WHERE pet_key = 'CV-000' AND level = 50
ORDER BY stars;
```

Learnset theo thứ tự mở:

```sql
SELECT l.unlock_level, l.source_type, l.is_signature,
       s.skill_key, s.name, s.combat_element, s.species_affinity,
       s.power, s.pp, s.mechanics_json
FROM pet_skill_learnsets l
JOIN skills s ON s.skill_key = l.skill_key
WHERE l.pet_key = 'CV-000' AND s.is_active = 1
ORDER BY l.unlock_level, l.sort_order;
```

Tất cả Skill active thiếu mechanics — kết quả bắt buộc bằng 0:

```sql
SELECT skill_key, name
FROM skills
WHERE is_active = 1 AND mechanics_json IS NULL;
```

Item alias và đích chuẩn:

```sql
SELECT item_key, name_original, canonical_item_key
FROM items
WHERE decision = 'merge'
ORDER BY item_key;
```

Item bị loại:

```sql
SELECT original_name, rationale
FROM item_decisions
WHERE decision = 'remove';
```

Công thức tiến hóa đầy đủ:

```sql
SELECT e.evolution_key, e.from_pet_key, e.to_pet_key,
       i.position, i.item_key, item.name, i.quantity, i.role
FROM pet_evolutions e
JOIN pet_evolution_ingredients i ON i.evolution_key = e.evolution_key
JOIN items item ON item.item_key = i.item_key
WHERE e.from_pet_key = 'CV-000'
ORDER BY e.evolution_key, i.position;
```

## Quy tắc importer

1. Từ chối schema version chưa hỗ trợ.
2. Từ chối checksum sai.
3. Từ chối duplicate stable key/FK thiếu.
4. Từ chối active Skill thiếu `mechanics_json`.
5. Từ chối Item `remove` xuất hiện trong runtime catalog.
6. Resolve alias trước khi sinh numeric ID.
7. Sinh resource theo thứ tự: source/element → effect/trait → Pet/Skill/Item → learnset/evolution.
8. Lưu generated resource cùng data version để save loader biết mapping nào đang dùng.
