# Bảng quy đổi 49 Skill Cầu Vồng sang luật Liệt Hỏa

## Phạm vi và nguyên tắc

Tài liệu này là bản cân bằng đề xuất `v1`, không ghi đè dữ liệu giải mã. Nguồn xác nhận gồm `game-data.json`, `rainbow-game-knowledge.md` và logic chiến đấu trong `02_decompiled/cfr-renamed/ak.java`.

- `Power`, `PP`, mốc học, xác suất và thời lượng trong bảng là giá trị gameplay mới.
- `power 13–27`, `energy_cost` và effect gốc tiếp tục được giữ trong lớp dữ liệu nguồn.
- Năm nhóm Skill cũ không còn quyết định hệ của Pet. Việc gán Mộc/Thổ/Phong/Hỏa/Thủy dưới đây chỉ áp dụng cho chính các Skill này.
- `Công Kích thông dụng` trở thành hành động dự phòng, không chiếm một trong năm ô Skill.
- ID `31–48` là bị động trong logic gốc, được chuyển thành ứng viên đặc tính và không có Power/PP/mốc học Skill.
- Đây là cân bằng số liệu trước mô phỏng; các giá trị cần có `balance_version` để có thể điều chỉnh mà không sửa dữ liệu gốc.

## Quy ước effect mới

| Effect | Loại | Luật đề xuất v1 |
|---|---|---|
| Hủ Thực | Debuff | Gây sát thương tăng dần trong 3 hiệp. |
| Hóa Đá | Debuff khống chế | Không thể hành động 1 hiệp; sát thương nhận vào giảm 30% trong thời gian bị khóa. Đổi tên từ `Thạch Hóa` Cầu Vồng để không trùng status Liệt Hỏa. |
| Giam Cầm | Debuff khống chế | Trong 2 hiệp không thể bỏ chạy, đổi Pet hoặc dùng Item. |
| Xuất Huyết | Debuff sát thương | Mỗi hiệp mất 10% Sinh mệnh hiện tại trong 3 hiệp. Đổi tên từ `Tê Liệt` Cầu Vồng để không trùng `Tê Liệt` Điện của Liệt Hỏa. |
| Mị Hoặc | Debuff thu nhận | Trong 3 hiệp không thể bỏ chạy và hiệu quả bắt Pet tăng 25%; không cấm đổi Pet trong PvP. |
| Phong Bế | Debuff khống chế | Không thể dùng Skill tier 2–3 trong 2 hiệp. |

## 25 Skill tấn công theo nhóm cũ

Mỗi dãy dùng chung mốc `5/10/20/30/40`, tier `0/0/1/2/3` và PP `45/40/30/25/15`. Tất cả nhắm vào đối thủ. Xác suất effect `4/8/12/16/24%` được giữ từ dữ liệu nguồn; Power được hạ tương ứng với giá trị của effect.

| ID | Skill | Hệ mới | Loại | Mốc | Tier | Power | PP | Mục tiêu | Effect |
|---:|---|---|---|---:|---:|---:|---:|---|---|
| 0 | Triền Nhiễu | Mộc | Sát thương + debuff | 5 | 0 | 70 | 45 | Đối thủ | 4% gây Hủ Thực · 3 hiệp |
| 1 | Phong Lợi Tiêm Thứ | Mộc | Sát thương + debuff | 10 | 0 | 80 | 40 | Đối thủ | 8% gây Hủ Thực · 3 hiệp |
| 2 | Bạo Tạc Chủng Tử | Mộc | Sát thương + debuff | 20 | 1 | 105 | 30 | Đối thủ | 12% gây Hủ Thực · 3 hiệp |
| 3 | Phi Diệp Đao Phong | Mộc | Sát thương + debuff | 30 | 2 | 130 | 25 | Đối thủ | 16% gây Hủ Thực · 3 hiệp |
| 4 | Thực Vật Phong Bạo | Mộc | Sát thương + debuff | 40 | 3 | 160 | 15 | Đối thủ | 24% gây Hủ Thực · 3 hiệp |
| 5 | Thiết Chuy | Thổ | Sát thương + khống chế | 5 | 0 | 60 | 45 | Đối thủ | 4% gây Hóa Đá · 1 hiệp |
| 6 | Thiết Phù Đồ | Thổ | Sát thương + khống chế | 10 | 0 | 70 | 40 | Đối thủ | 8% gây Hóa Đá · 1 hiệp |
| 7 | Bạo Liệt Vũ | Thổ | Sát thương + khống chế | 20 | 1 | 90 | 30 | Đối thủ | 12% gây Hóa Đá · 1 hiệp |
| 8 | Toản Thạch Thiết Cát | Thổ | Sát thương + khống chế | 30 | 2 | 110 | 25 | Đối thủ | 16% gây Hóa Đá · 1 hiệp |
| 9 | Kim Loại Liệt Trảm | Thổ | Sát thương + khống chế | 40 | 3 | 140 | 15 | Đối thủ | 24% gây Hóa Đá · 1 hiệp |
| 10 | Phi Tường Trảm | Phong | Sát thương + khống chế | 5 | 0 | 85 | 45 | Đối thủ | 4% gây Giam Cầm · 2 hiệp |
| 11 | Bạo Phong Toàn Trận | Phong | Sát thương + khống chế | 10 | 0 | 95 | 40 | Đối thủ | 8% gây Giam Cầm · 2 hiệp |
| 12 | Tật Phong Tốc Hàng | Phong | Sát thương + khống chế | 20 | 1 | 120 | 30 | Đối thủ | 12% gây Giam Cầm · 2 hiệp |
| 13 | Thánh Linh Khoan Thứ | Phong | Sát thương + khống chế | 30 | 2 | 145 | 25 | Đối thủ | 16% gây Giam Cầm · 2 hiệp |
| 14 | Thiên Nộ | Phong | Sát thương + khống chế | 40 | 3 | 175 | 15 | Đối thủ | 24% gây Giam Cầm · 2 hiệp |
| 15 | Phác Giảo | Hỏa | Sát thương + debuff | 5 | 0 | 70 | 45 | Đối thủ | 4% gây Xuất Huyết · 3 hiệp |
| 16 | Tê Liệt Kích | Hỏa | Sát thương + debuff | 10 | 0 | 80 | 40 | Đối thủ | 8% gây Xuất Huyết · 3 hiệp |
| 17 | Nộ Ý Cuồng Bạo | Hỏa | Sát thương + debuff | 20 | 1 | 105 | 30 | Đối thủ | 12% gây Xuất Huyết · 3 hiệp |
| 18 | Tứ Ngược Trùng Phong | Hỏa | Sát thương + debuff | 30 | 2 | 130 | 25 | Đối thủ | 16% gây Xuất Huyết · 3 hiệp |
| 19 | Cuồng Bạo Tê Hống | Hỏa | Sát thương + debuff | 40 | 3 | 160 | 15 | Đối thủ | 24% gây Xuất Huyết · 3 hiệp |
| 20 | Thủy Trụ | Thủy | Sát thương + thu nhận | 5 | 0 | 90 | 45 | Đối thủ | 4% gây Mị Hoặc · 3 hiệp |
| 21 | Tiên Xạ Thủy Lãng | Thủy | Sát thương + thu nhận | 10 | 0 | 100 | 40 | Đối thủ | 8% gây Mị Hoặc · 3 hiệp |
| 22 | Thủy Cầu Áp Sát | Thủy | Sát thương + thu nhận | 20 | 1 | 130 | 30 | Đối thủ | 12% gây Mị Hoặc · 3 hiệp |
| 23 | Phún Xạ Thủy Trụ | Thủy | Sát thương + thu nhận | 30 | 2 | 155 | 25 | Đối thủ | 16% gây Mị Hoặc · 3 hiệp |
| 24 | Hải Thần Phục Cừu | Thủy | Sát thương + thu nhận | 40 | 3 | 190 | 15 | Đối thủ | 24% gây Mị Hoặc · 3 hiệp |

## 6 hành động chủ động đặc biệt

| ID | Skill | Hệ mới | Loại | Mốc | Tier | Power | PP | Mục tiêu | Effect |
|---:|---|---|---|---:|---:|---:|---:|---|---|
| 25 | Công Kích thông dụng | Thích ứng theo hệ Pet | Hành động dự phòng | Có sẵn | — | 60 | Không dùng PP | Đối thủ | Không effect; không chiếm ô Skill và không được hưởng hiệu ứng tăng Power của Skill đặc trưng. |
| 26 | Tàn quân | Quỷ | Sát thương + thu nhận | 20 | 1 | 80 | 10 | Đối thủ | Pet hoang trúng đòn bị giảm 25% kháng bắt trong 3 hiệp; không có hiệu lực PvP. |
| 27 | Trị liệu sơ cấp | Mộc | Hồi phục chủ động | 10 | 0 | 0 | 20 | Bản thân | Hồi 25% Sinh mệnh tối đa. |
| 28 | Trị liệu chuyên nghiệp | Mộc | Hồi phục chủ động | 30 | 2 | 0 | 10 | Bản thân | Hồi 50% Sinh mệnh tối đa. |
| 29 | Tử Vong Chi Xúc | Quỷ | Tuyệt kỹ sát thương | 40 | 3 | 250 | 1 | Đối thủ | Chỉ dùng 1 lần/trận; sau khi thi triển, PP hiện tại của năm Skill đang mang trở về 0. |
| 30 | Kỹ năng Phong Bế | Quỷ | Khống chế chủ động | 30 | 2 | 0 | 5 | Đối thủ | 70% gây Phong Bế · 2 hiệp. |

## 18 bị động chuyển thành ứng viên đặc tính

Các bản ghi dưới đây không nằm trong learnset năm Skill. Chúng được đưa vào kho đặc tính chủng, chiến đấu hoặc tiện ích. Cột mục tiêu mô tả nơi effect tác động, không phải mục tiêu được chọn trong lượt đánh.

| ID | Tên gốc | Hệ mới | Loại sau quy đổi | Mốc | Power | PP | Mục tiêu | Effect đề xuất v1 |
|---:|---|---|---|---|---:|---:|---|---|
| 31 | Độc Dịch Công Kích | — | Đặc tính chủng · Thực Vật | Khi gắn đặc tính | — | — | Đối thủ bị Hủ Thực | Hủ Thực do chủ sở hữu gây ra kéo dài thêm 2 hiệp. |
| 32 | Tiêm Nha Lợi Xỉ | — | Đặc tính chủng · Mãnh Thú | Khi gắn đặc tính | — | — | Đối thủ bị Xuất Huyết | Xuất Huyết do chủ sở hữu gây ra kéo dài thêm 1 hiệp. |
| 33 | Cương Cân Thiết Cốt | — | Đặc tính chủng · Kim Loại | Khi gắn đặc tính | — | — | Bản thân | Sát thương trực tiếp nhận vào giảm 20%. |
| 34 | Tinh Thần Công Kích | — | Đặc tính chủng · Phi Hành | Khi gắn đặc tính | — | — | Đối thủ | Khi gây sát thương có 20% xác suất trừ thêm 1 PP của Skill đối thủ vừa sử dụng gần nhất. |
| 35 | Triều Tịch Năng Lượng | — | Đặc tính chủng · Hải Dương | Khi gắn đặc tính | — | — | Bản thân | Khi dùng Skill có 20% xác suất hoàn lại 1 PP vừa tiêu hao. |
| 36 | Kinh nghiệm đa dạng | — | Đặc tính tiện ích | Khi gắn đặc tính | — | — | Bản thân | Kinh nghiệm nhận được ×2; không cộng dồn với Kinh nghiệm phong phú. |
| 37 | Kinh nghiệm phong phú | — | Đặc tính tiện ích | Khi gắn đặc tính | — | — | Bản thân | Kinh nghiệm nhận được ×3; không cộng dồn với Kinh nghiệm đa dạng. |
| 38 | Trọng Sinh Chi Tâm | — | Đặc tính chiến đấu | Khi gắn đặc tính | — | — | Bản thân | Một lần mỗi trận, khi bị hạ có 30% xác suất hồi sinh với 30% Sinh mệnh tối đa. |
| 39 | Hạnh Vận Chi Tinh | — | Đặc tính tiện ích | Khi gắn đặc tính | — | — | Thế giới | Tăng 20% tương đối tỷ lệ gặp Pet hiếm. |
| 40 | Đồng bạn trung thành | — | Đặc tính tiện ích | Khi gắn đặc tính | — | — | Bản thân | Độ trung thành không giảm xuống dưới mức hiện tại do chiến đấu hoặc bỏ đói. |
| 41 | Thân Hòa Thiên Sử | — | Đặc tính thu nhận | Khi gắn đặc tính | — | — | Pet hoang | Bắt thất bại không khiến Pet hoang bỏ chạy; không có hiệu lực với boss. |
| 42 | Đào tẩu chuyên nghiệp | — | Đặc tính tiện ích | Khi gắn đặc tính | — | — | Bản thân | Bỏ chạy chắc chắn thành công, trừ boss, nhiệm vụ khóa chạy và PvP. |
| 43 | Hoa Thảo Ý Chí | — | Đặc tính chủng · Thực Vật | Khi gắn đặc tính | — | — | Bản thân | Ở địa hình Hoa Viên/Rừng, Sức mạnh và Phòng ngự tăng 10%. |
| 44 | Kim Loại Ý Chí | — | Đặc tính chủng · Kim Loại | Khi gắn đặc tính | — | — | Bản thân | Ở địa hình Di Tích, Sức mạnh và Phòng ngự tăng 10%. |
| 45 | Phi Hành Ý Chí | — | Đặc tính chủng · Phi Hành | Khi gắn đặc tính | — | — | Bản thân | Ở địa hình Không Trung, Sức mạnh và Phòng ngự tăng 10%. |
| 46 | Mãnh Thú Ý Chí | — | Đặc tính chủng · Mãnh Thú | Khi gắn đặc tính | — | — | Bản thân | Ở địa hình Đồng Bằng, Sức mạnh và Phòng ngự tăng 10%. |
| 47 | Hải Dương Ý Chí | — | Đặc tính chủng · Hải Dương | Khi gắn đặc tính | — | — | Bản thân | Ở địa hình Đại Dương, Sức mạnh và Phòng ngự tăng 10%. |
| 48 | Thế Thân Mộc Ngẫu | — | Đặc tính chiến đấu | Khi gắn đặc tính | — | — | Bản thân | Khi nhận đòn có 30% xác suất giảm 50% sát thương của đòn đó. |

## Quy tắc đưa vào learnset

- Pet chỉ học Skill phù hợp với hệ nguyên tố và hồ sơ chiến đấu mới; không tự động học cả năm Skill chỉ vì cùng chủng Cầu Vồng cũ.
- Một mốc chỉ mở một Skill đang được gắn trong learnset của loài Pet. Skill chủ động đặc biệt có thể thay thế Skill tấn công ở cùng mốc.
- `Công Kích thông dụng` luôn khả dụng khi năm Skill còn lại hết PP nhưng không chiếm slot.
- Bị động ID `31–48` phải đi qua hệ thống hai đặc tính; một cá thể không nhận chúng như Skill thứ sáu.
- Các effect liên quan bắt Pet hoặc thế giới phải vô hiệu trong PvP nếu bảng ghi rõ.

## Trường cần lưu cho lớp gameplay

```text
source_game_id
source_power
source_energy_cost
source_status_chance
element_id
combat_category
unlock_level
tier
power
pp_max
target_side
effect_id
effect_chance
effect_duration
balance_version
conversion_notes
```

