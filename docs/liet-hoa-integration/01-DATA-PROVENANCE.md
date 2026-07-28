# Phân loại nguồn và giới hạn diễn giải

## Nhãn provenance

| Nhãn | Ý nghĩa | Có được gọi là dữ liệu gốc? |
|---|---|---|
| `decoded_source` | Đọc trực tiếp từ binary/resource hoặc decompiled behavior | Có, nếu dẫn được tới nguồn |
| `source_normalized` | Dữ liệu nguồn được đổi cấu trúc/tên trường nhưng không đổi ý nghĩa | Có điều kiện |
| `unified_balance` | Power, PP, stat hoặc cơ chế đã cân bằng lại | Không |
| `unified_design` | Luật kết hợp mới dùng khái niệm có trong hai game | Không |
| `generated_unified_design` | Kết quả sinh tự động từ luật hợp nhất, ví dụ learnset | Không |
| `excluded_by_design` | Bản ghi nguồn bị loại theo quyết định thiết kế | Vẫn là nguồn, nhưng không còn trong gameplay |

Mỗi record trong snapshot có provenance ở cột riêng hoặc `provenance_json`. Agent phải giữ nhãn này khi sinh resource Java/binary.

## Provenance theo miền

### Pet

- `name_original`, `raw_json`, sprite/source identity: nguồn giải mã.
- Bốn chỉ số cuối cùng của toàn bộ 202 Pet: `unified_balance`; tất cả đã khác raw source.
- `primary_role`, `secondary_role`, `playstyle_summary`: `unified_design`.
- 100 Pet Liệt Hỏa được gán Chủng mới.
- 102 Pet Cầu Vồng được ánh xạ sang bảy Hệ chiến đấu.
- Chín Pet Liệt Hỏa đổi Hệ chiến đấu so với raw: `LH-012`, `LH-014`, `LH-040`, `LH-042`, `LH-044`, `LH-056`, `LH-071`, `LH-097`, `LH-098`.
- `effectiveness_class` không chứng minh Pet là Thần. Không suy diễn rarity/divine chỉ từ trường này.

### Skill và buff/debuff

- 70 Skill Liệt Hỏa đều đã đổi PP; 46 Skill đã đổi Power.
- 25 Skill nguyên tố Cầu Vồng active đã thay effect chance hoặc mechanics.
- 99 Skill active có `mechanics_json` là contract hợp nhất `unified-v5`.
- 20 Skill/passive Cầu Vồng inactive chỉ là hồ sơ nguồn, không tự động được học hoặc thi triển.
- Learnset 1.160 dòng là `generated_unified_design`, không phải bảng giải mã.
- Bảng `effects` lưu Effect nguồn. Luật thực thi cuối cùng phải đọc `skills.mechanics_json`; không được suy cơ chế mới chỉ từ mô tả Effect nguồn.
- `app/Support/SkillBattlePreview.php` từng dùng nhãn `decoded` cho nhánh mechanics đã cân bằng. Nhãn giao diện đó không được dùng làm bằng chứng provenance.

### Trait

- 13 trait thể chất hiện tại không ánh xạ một-một với 13 tư chất nguồn Cầu Vồng.
- 13 trait `TC-*` và 20 trait Chủng đều là thiết kế hợp nhất.
- Luật hai ô: một trait thể chất random + một trait Chủng cố định. Trait không chiếm slot Skill.

### Item và tiến hóa

- 52 Item Liệt Hỏa được giữ active.
- Cầu Vồng: 35 active, 25 alias gộp, 10 loại hoàn toàn.
- Toàn bộ 88 công thức hiện tại trộn nguyên liệu hai game và là `unified_design`, dù topology from/to Pet dựa trên nguồn.
- Không xóa alias khỏi snapshot: alias cần cho save migration, asset lookup và đối chiếu tên cũ.

Mười Item Cầu Vồng loại hoàn toàn:

1. Hưng phấn cô.
2. Mật tâm đường.
3. Quân tâm tan rã.
4. Tử vong chi sờ.
5. Trung thành đồng bọn.
6. Hoa cỏ Ý Chí.
7. Kim Loại Ý Chí.
8. Bầu trời Ý Chí.
9. Dã thú Ý Chí.
10. Biển rộng Ý Chí.

### Thần thú và Thần Quyền

- Danh sách 14 Pet thần đã được phục hồi sức mạnh theo dữ liệu/đẳng cấp nguồn đã rà soát.
- Tên và mechanics của 14 `divine_abilities` là `unified_design`, không phải dữ liệu giải mã.
- Phải đặt sau feature flag và có quyết định duyệt riêng trước khi tích hợp runtime.

## Nguồn gốc bắt buộc phải đối chiếu

Liệt Hỏa:

- `resources/decoded/04_resources/raw/data/script/db.mid`
- `resources/decoded/04_resources/raw/data/script/chs.mid`
- `resources/decoded/02_decompiled/`
- `resources/decoded/05_modules/`

Cầu Vồng:

- `resources/decoded/rainbow/04_resources/raw/data/data.d`
- `resources/decoded/rainbow/06_analysis/game-data.json`
- `resources/decoded/rainbow/06_analysis/pets.csv`
- `resources/decoded/rainbow/06_analysis/skills.csv`
- `resources/decoded/rainbow/06_analysis/effects.csv`
- `resources/decoded/rainbow/06_analysis/items.csv`
- `resources/decoded/rainbow/06_analysis/pet_evolutions.csv`
- `resources/decoded/rainbow/02_decompiled/cfr-renamed/ak.java`
- `resources/decoded/rainbow/02_decompiled/cfr-renamed/ad.java`

Không đưa một record vào runtime nếu không thể chỉ ra stable key, provenance, nguồn đối chiếu và test tương ứng.
