# Lộ trình tích hợp vào bản game Liệt Hỏa

## Nguyên tắc kiến trúc

- Giữ một chế độ `source-parity` để đối chiếu Liệt Hỏa gốc.
- Luật hợp nhất đi qua data/version boundary, không rải `if CV` khắp battle engine.
- Import snapshot ở build time, sinh resource runtime bất biến; không gọi MySQL/SQLite web trong lúc chơi.
- Stable key là định danh nghiệp vụ. Numeric runtime ID chỉ là mapping đã đóng băng.
- Mỗi phase phải chạy test baseline, test dữ liệu mới và test save migration.

## Phase 0 — Đóng băng baseline

1. Chạy toàn bộ test hiện có của `VQSV-Refactor`.
2. Lưu parity report và checksum resource Liệt Hỏa.
3. Tạo feature/data version `SOURCE_V1` và `UNIFIED_V1`.
4. Không sửa trực tiếp raw table loader trước khi có adapter mới.

Điều kiện qua phase: baseline có thể tái chạy và so sánh sau mọi phase.

## Phase 1 — Data boundary và ID registry

1. Tạo importer đọc SQLite snapshot.
2. Validate `schema_version`, `data_version` và SHA-256 từ manifest.
3. Sinh các resource runtime cho Pet, Skill, Effect, Trait, Item, Evolution, Learnset.
4. Đóng băng mapping stable key → numeric ID trong một file version-controlled ở game repo.
5. Giữ numeric ID Liệt Hỏa cũ; cấp namespace/range mới cho Cầu Vồng.

Điều kiện qua phase: importer phát hiện thiếu FK, duplicate stable key, record active thiếu mechanics và count lệch manifest.

## Phase 2 — Save schema v2

Mở rộng save trước khi bật gameplay mới:

- Stable/numeric species ID mới cho 102 Pet Cầu Vồng.
- Năm Skill slot và PP còn lại của từng slot.
- Sao 1–5.
- Trait thể chất đã roll và trait Chủng có thể tái dựng từ species.
- Equipment/item ID mới và alias migration.
- Data/save version.

Migration v1 → v2 phải giữ nguyên Pet Liệt Hỏa, level, HP hợp lệ, skill hiện có, inventory và story state. Alias Item phải đổi sang canonical ID, không làm mất số lượng.

## Phase 3 — Pet, chỉ số, sao, Hệ và Chủng

1. Port catalog 202 Pet.
2. Dùng công thức và hệ số sao trong snapshot; đối chiếu preview cấp 1/cấp 50.
3. Tách `combat_element` khỏi `species`.
4. Port role chỉ để AI/UI/build suggestion; không để role tự cộng stat ẩn.
5. Port một trait Chủng cố định và một trait thể chất random.
6. Chưa bật Thần Quyền.

Điều kiện qua phase: tất cả Pet tính đúng bốn stat ở 10 checkpoint snapshot (2 level × 5 sao).

## Phase 4 — Bể Skill và học Skill

1. Port 99 Skill active; giữ 20 passive Cầu Vồng inactive để truy vết, không cấp cho Pet.
2. Thay logic nhóm học cũ bằng `pet_skill_learnsets`.
3. Hỗ trợ mốc 5, 10, 15, …, 50 theo từng dòng dữ liệu.
4. Khi lên cấp, chỉ đề nghị Skill có `unlock_level` vừa đạt và Pet chưa biết.
5. Pet mang tối đa năm Skill; thay Skill phải có UI xác nhận.
6. Khi tiến hóa, giữ Skill đã học; mở Skill form mới theo learnset, không tự xóa Skill kế thừa.

Điều kiện qua phase: 1.160 learnset rows được import và mọi Pet active có deck hợp lệ, tối thiểu hai lựa chọn gây sát thương theo audit hiện tại.

## Phase 5 — Mechanics Skill, buff và debuff

1. Tạo registry/handler theo `mechanics_json.type`.
2. Port Power, PP, status chance, duration, cap, stack/refresh/consume rule.
3. Không suy logic từ tên Skill hoặc chuỗi mô tả.
4. Dùng battle order, hit/effect timing và renderer Liệt Hỏa làm baseline.
5. Mỗi mechanics type có unit test và ít nhất một battle trace test.
6. Animation không được coi là bằng chứng logic; logic và presentation phải có adapter riêng.

Điều kiện qua phase: 99 Skill active không rơi vào fallback im lặng; trạng thái hết hạn, cleanse, immunity, stack và PP đều có test.

## Phase 6 — Item, trang bị và tiến hóa

1. Port 87 Item active.
2. Dùng 25 alias cho migration/asset lookup nhưng không tạo inventory object riêng sau migration.
3. Chặn 10 Item `remove` ở importer.
4. Mở rộng Evolution từ một nguyên liệu sang danh sách `pet_evolution_ingredients`.
5. Trừ toàn bộ nguyên liệu trong một transaction; thiếu một loại thì không trừ gì.
6. Port trang bị/nội tại qua handler theo `mechanic_key`, không hard-code theo tên.

Điều kiện qua phase: 88 cạnh tiến hóa và 239 nguyên liệu khớp snapshot; save cũ không mất Item.

## Phase 7 — Pet và asset Cầu Vồng theo từng dòng tiến hóa

Không nhập đồng loạt 102 Pet. Chia theo một dòng tiến hóa hoàn chỉnh:

1. Đọc record Pet/Skill/Effect/Item liên quan trong snapshot.
2. Đọc `ak.java`, loader/parser và module sprite/animation Cầu Vồng liên quan.
3. Port sprite idle, hit, skill, death và skill effect.
4. Ánh xạ renderer/pixel transform sang pipeline Liệt Hỏa.
5. Test form chain, learnset, evolution material, animation bounds và save/load.

Điều kiện qua phase: không dùng animation dựng giả khi source asset/algorithm đã tồn tại.

## Phase 8 — Thần thú và tính năng tùy chọn

- Badge/đẳng cấp Thần có thể bật sau khi Pet cơ bản ổn định.
- `divine_abilities` chỉ bật bằng feature flag và một ADR duyệt riêng.
- Không dùng `effectiveness_class` làm điều kiện duy nhất để nhận diện Thần.

## Phase 9 — QA và phát hành

- Regression source-parity.
- Save migration ma trận: save trống, đầu game, giữa game, full inventory, Pet full skill.
- Deterministic battle trace cho mọi mechanics type.
- Asset leak/bounds/performance test.
- Count/checksum gate với manifest.
- Chỉ xóa feature flag cũ sau ít nhất một bản save tương thích đã phát hành.
