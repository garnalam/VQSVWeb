# Bàn giao tích hợp dữ liệu VQSV vào game Liệt Hỏa

Phiên bản bộ bàn giao: `2026-07-28`  
Data contract: `unified-2026-07-28`  
Skill balance: `unified-v5`  
Item balance: `unified-item-v1`

## Mục tiêu

Bộ tài liệu này là điểm vào bắt buộc cho agent phát triển bản game Liệt Hỏa tại `C:\Users\Dell\Downloads\VQSV-Refactor\VQSV-Refactor`. Nó mô tả cách đưa dữ liệu hợp nhất từ Wiki vào game mà vẫn giữ được baseline Liệt Hỏa, khả năng đọc save cũ và bằng chứng nguồn của cả hai game.

Không được kết nối game runtime trực tiếp tới MySQL của web. MySQL là nguồn quản trị; file SQLite snapshot là hợp đồng dữ liệu có thể truy vấn trong lúc tích hợp; game phải sinh bảng/resource runtime riêng ở build time.

## Thứ tự đọc bắt buộc

1. Tài liệu này.
2. [01-DATA-PROVENANCE.md](01-DATA-PROVENANCE.md).
3. [02-INTEGRATION-ROADMAP.md](02-INTEGRATION-ROADMAP.md).
4. [03-DATABASE-CONTRACT.md](03-DATABASE-CONTRACT.md).
5. [04-GAME-PORTING-MAP.md](04-GAME-PORTING-MAP.md).
6. [05-COVERAGE-CHECKLIST.md](05-COVERAGE-CHECKLIST.md).
7. [06-DECISIONS-AND-RISKS.md](06-DECISIONS-AND-RISKS.md).
8. Skill project `.agents/skills/integrate-vqsv-game-data/SKILL.md`.

## Thứ tự nguồn sự thật

Khi hai nguồn mâu thuẫn, dùng thứ tự sau:

1. Binary/resource gốc và hành vi runtime đã kiểm chứng.
2. Decompiled code cùng decoder có thể tái chạy.
3. SQLite integration snapshot cho luật hợp nhất đã được duyệt.
4. Seeder và support class sinh snapshot.
5. Markdown chỉ dùng để giải thích, không được dùng thay dữ liệu truy vấn.

`resources/decoded/**/06_analysis/*.md` không tự động là dữ liệu gốc chỉ vì nằm trong thư mục `decoded`. Phải kiểm tra tài liệu đó dẫn đến binary, CSV giải mã hoặc decompiled method nào.

## Bức tranh dữ liệu hiện tại

| Miền | Toàn bộ nguồn | Được dùng trong catalog hợp nhất |
|---|---:|---:|
| Pet | 202 | 202 |
| Skill | 119 | 99 active |
| Effect nguồn | 46 | 46 bản ghi tham chiếu |
| Item trong DB | 112 | 87 active, 25 alias đã gộp |
| Item Cầu Vồng loại hẳn | 10 | 0 |
| Nhánh tiến hóa | 88 | 88 |
| Nguyên liệu công thức | 239 | 239 |
| Learnset Pet–Skill | 1.160 | 1.160 |
| Trait | 33 | 13 thể chất + 20 đặc tính Chủng |
| Thần Quyền | 14 | tùy chọn, chưa phải hành vi gốc |

## Những điều agent game phải hiểu trước khi sửa code

- Liệt Hỏa vẫn là lõi: công thức chiến đấu, PP, mục tiêu và nhịp battle lấy baseline từ Liệt Hỏa.
- Cầu Vồng cung cấp Pet, sprite, skill/effect animation, trait/item concept và topology tiến hóa; không bê nguyên cơ chế năng lượng vào battle hợp nhất.
- Mỗi Pet có một `combat_element`, một `species`, một trait Chủng cố định và một trait thể chất được random trong 13 trait `TC-00..TC-12`.
- Pet mang tối đa năm Skill. `pet_skill_learnsets` là danh sách học chuẩn; `skill_unlock_rules` chỉ còn là tham chiếu legacy.
- Mốc học có thể chạy từ cấp 5 đến 50 theo bước 5; phải đọc từng hàng learnset, không hard-code năm mốc cũ.
- Phẩm chất/sao 1–5 dùng hệ số `90, 95, 100, 110, 125%`. Snapshot có preview cấp 1 và 50 cho mọi sao.
- Chỉ số năng lượng của Pet Cầu Vồng chỉ được giữ trong raw/source reference; battle hợp nhất dùng PP theo từng Skill.
- Mười Item đã loại không được tái sinh dưới tên khác. Hai mươi lăm Item alias chỉ giữ nhận diện/artwork; gameplay phải quy về `canonical_item_key`.
- Thần Quyền là thiết kế hợp nhất tùy chọn. Không được gọi là “dữ liệu giải mã” và không bật mặc định trước khi có feature flag/test.

## Cách bắt đầu một task tích hợp

Tại project web:

```powershell
php artisan game:export-integration-data
```

Kết quả:

- `storage/app/private/integration/vqsv-game-data.sqlite`
- `storage/app/private/integration/vqsv-game-data.sqlite.manifest.json`

Agent game phải ghi rõ trong plan:

1. Domain sẽ tích hợp.
2. Bảng và khóa snapshot sẽ dùng.
3. Module Liệt Hỏa baseline sẽ giữ nguyên/được mở rộng.
4. Module Cầu Vồng bắt buộc phải đọc.
5. Thay đổi save schema và migration nếu có.
6. Test nguồn, test luật mới và regression test.

Không được tuyên bố hoàn tất nếu checklist coverage chưa có bằng chứng cho domain vừa sửa.
