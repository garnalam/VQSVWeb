# Kho tri thức Sủng Vật Cầu Vồng

## Nguồn giải mã

- JAR SHA256: `B96B7C627B1F117B66578E78F3A491F481125A9E52161AF0D185C143694FAC70`
- Database chính: `04_resources/raw/data/data.d`
- Loader: `02_decompiled/cfr-renamed/ak.java`, phương thức `j()`
- Parser nhị phân: `02_decompiled/cfr-renamed/ad.java`

## Dữ liệu đã xác nhận

| Module | Số bản ghi |
|---|---:|
| Hệ | 6 |
| Pet | 102 |
| Skill | 49 |
| Item | 70 |
| Trait và hiệu ứng trạng thái | 20 |
| Nhánh tiến hóa khác Pet | 50 |

Chỉ số Pet ở cấp `L` dùng công thức `base + growth * L / 10`. Pet có 5 hệ: Thực Vật, Kim Loại, Phi Hành, Mãnh Thú và Hải Dương. Skill 0–24 là năm bậc tấn công theo hệ; skill 25–48 là kỹ năng chung, chủ động đặc biệt hoặc bị động.

Item 0–15 là đạo cụ, 16–34 là khoáng thạch, 35–57 là huy chương và 58–69 là vòng. Mapping ảnh Item được khôi phục trực tiếp từ `ak.void_b(int,int,int,int)`, không suy đoán theo tên.

## Sprite

Pet dùng `data/npc2/{group}.png` và `{group}.data`. Bảng Pet trỏ đến `[sprite_group, variant]`; animation đại diện là `variant * 3`. Skill dùng `data/battle/s0..s5` với nhóm `min(skill_id / 5, 5)` và animation `skill_id % 5` hoặc `skill_id - 25` cho nhóm kỹ năng chung.
