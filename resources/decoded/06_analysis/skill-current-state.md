# Hiện trạng toàn bộ 99 Skill đang hoạt động

> Snapshot dữ liệu MySQL ngày 28/07/2026, sau seeder `unified-v3`. Tài liệu này chỉ ghi nhận hiện trạng; chưa áp dụng phương án tái cân bằng mới.

## Cách đọc

- **Power** là phần trăm uy lực hiện lưu trong database.
- **PP** là số lượt dùng tối đa.
- **Effect dữ liệu** ghi Effect, xác suất và thời lượng.
- “**suy diễn**” nghĩa là database chưa có `status_chance` rõ ràng; simulator đang suy ra xác suất từ `effect_parameter` rồi giới hạn tối đa 95%.
- **Cơ chế runtime hiện tại** là hành vi của `PetBattleSimulator` dùng cho audit 1v1, không phải chế độ preview cưỡng chế Effect trên Wiki.
- `T` là số hiệp/thời lượng hiện tại.

## Tổng quan

| Nhóm | Số lượng |
| --- | ---: |
| Tổng Skill hoạt động | 99 |
| Liệt Hỏa | 70 |
| Cầu Vồng | 29 |
| Tấn công thuần | 29 |
| Hybrid | 45 |
| Khống chế | 11 |
| Buff | 6 |
| Hồi phục | 4 |
| Phòng thủ | 4 |
| Skill có Effect | 68 |
| Skill gây damage kèm Effect | 53 |
| Skill trạng thái không gây damage | 15 |

## I. 70 Skill Hệ Liệt Hỏa

### Hệ Hỏa — 10 Skill

| Mã | Skill | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `LH-00` | Hỏa trảo | Tấn công | 0 | 100 | 45 | 1 đối thủ | — | Chỉ gây 100% damage. |
| `LH-01` | Dương viêm | Hybrid | 0 | 50 | 45 | 1 đối thủ | Gieo Hạt · 4% suy diễn · 3T | DoT phẳng 4 HP ở đầu lượt. |
| `LH-02` | Diễm kích | Khống chế | 0 | 100 | 45 | 1 đối thủ | Mê Muội · 10% suy diễn · 2T | Giảm Linh xảo 20%. |
| `LH-03` | Hỏa Vân triệu | Tấn công | 1 | 100 | 30 | 1 đối thủ | — | Runtime mới gây 100% damage; bonus khi Cháy chưa chạy. |
| `LH-04` | Thiên Hỏa tế | Buff | 1 | 0 | 10 | Mình/đồng minh | Súc Lực · 100% · 2T | DEF +30%; damage +90%. |
| `LH-05` | Viêm lôi phá | Buff | 1 | 0 | 10 | Bản thân | Phá Phủ · 100% · 3T | Sức mạnh +50%; DEF −50%. |
| `LH-06` | Hỏa diễm đao | Tấn công | 2 | 150 | 30 | 1 đối thủ | — | Chỉ gây 150% damage. |
| `LH-07` | Chước nhiệt chi xúc | Hybrid | 2 | 75 | 30 | 1 đối thủ | Gieo Hạt · 3% suy diễn · 3T | DoT phẳng 3 HP ở đầu lượt. |
| `LH-08` | Liệt diễm phong bạo | Khống chế | 3 | 200 | 15 | 1 đối thủ | Mê Muội · 20% suy diễn · 2T | Giảm Linh xảo 20%. |
| `LH-09` | Vĩnh hằng hỏa ảnh | Tấn công | 3 | 200 | 15 | 1 đối thủ | — | Runtime mới gây 200% damage; bonus khi Cháy chưa chạy. |

### Hệ Mộc — 10 Skill

| Mã | Skill | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `LH-10` | Diệp Toàn | Tấn công | 0 | 100 | 45 | 1 đối thủ | — | Chỉ gây 100% damage. |
| `LH-11` | Quang phản | Tấn công | 0 | 90 | 45 | 1 đối thủ | — | Runtime mới gây 90% damage; hồi HP mô tả chưa chạy. |
| `LH-12` | Đằng Phược | Khống chế | 0 | 50 | 45 | 1 đối thủ | Quấn Quanh · 95% suy diễn · 3T | Giảm DEF 10%. |
| `LH-13` | Thảo Chủng | Hybrid | 1 | 50 | 30 | 1 đối thủ | Thực Loại · 95% suy diễn · 3T | Khi hết hạn nhận 150 damage phẳng. |
| `LH-14` | Đằng chi bích lũy | Phòng thủ | 1 | 0 | 10 | Mình/đồng minh | Kinh Cức · 100% · 3T | DEF +30%; phản 10% damage nhận. |
| `LH-15` | Thảo nguyện thuật | Hồi phục | 1 | 0 | 10 | Mình/đồng minh | Khôi phục · 100% · 3T | Hồi 5% HP tối đa cuối mỗi hiệp. |
| `LH-16` | Châm Diệp Trảm | Tấn công | 2 | 150 | 30 | 1 đối thủ | — | Chỉ gây 150% damage. |
| `LH-17` | Diệp chi ân huệ | Tấn công | 2 | 130 | 30 | 1 đối thủ | — | Runtime mới gây 130% damage; hồi HP mô tả chưa chạy. |
| `LH-18` | Đằng mạn triền nhiễu | Khống chế | 3 | 150 | 15 | 1 đối thủ | Quấn Quanh · 95% suy diễn · 3T | Giảm DEF 10%. |
| `LH-19` | Quang hợp hiệu ứng | Hybrid | 3 | 150 | 15 | 1 đối thủ | Thực Loại · 95% suy diễn · 3T | Khi hết hạn nhận 200 damage phẳng. |

### Hệ Thổ — 10 Skill

| Mã | Skill | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `LH-20` | Hất bụi | Tấn công | 0 | 100 | 45 | 1 đối thủ | — | Chỉ gây 100% damage. |
| `LH-21` | Thổ thuẫn | Hybrid | 0 | 80 | 45 | 1 đối thủ | Phòng ngự · 100% · 2T | DEF +20% (runtime tối thiểu 20%). |
| `LH-22` | Bão cát | Khống chế | 0 | 50 | 45 | 1 đối thủ | Mê Muội · 25% suy diễn · 2T | Giảm Linh xảo 25%. |
| `LH-23` | Nham băng | Tấn công | 1 | 100 | 30 | 1 đối thủ | — | Runtime mới gây 100% damage; bonus lên Mê Muội chưa chạy. |
| `LH-24` | Người bảo vệ Địa Giới | Hồi phục | 1 | 0 | 10 | Toàn phe | Thạch Hóa · 100% · 3T | Hồi 5% HP/hiệp; phần thanh tẩy chưa chạy. |
| `LH-25` | Thạch phu thuật | Phòng thủ | 1 | 0 | 10 | Mình/đồng minh | Thạch Phu · 100% · 3T | Chặn debuff mới; phần thanh tẩy chưa chạy. |
| `LH-26` | Nham bạo | Tấn công | 2 | 150 | 30 | 1 đối thủ | — | Chỉ gây 150% damage. |
| `LH-27` | Hàng rào cát đá | Hybrid | 2 | 100 | 30 | 1 đối thủ | Phòng ngự · 100% · 2T | DEF +20% (runtime tối thiểu 20%). |
| `LH-28` | Bão cát | Khống chế | 3 | 150 | 15 | 1 đối thủ | Mê Muội · 25% suy diễn · 2T | Giảm Linh xảo 25%. |
| `LH-29` | Thổ Chi Loạn Vũ | Tấn công | 3 | 180 | 15 | 1 đối thủ | — | Runtime mới gây 180% damage; bonus lên Mê Muội chưa chạy. |

### Hệ Thủy — 10 Skill

| Mã | Skill | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `LH-30` | Bong bóng | Tấn công | 0 | 100 | 45 | 1 đối thủ | — | Chỉ gây 100% damage. |
| `LH-31` | Băng lao | Hybrid | 0 | 60 | 45 | 1 đối thủ | Mục · 1% suy diễn · 3T | Giảm chính xác 5%. |
| `LH-32` | Tuyết ảnh | Hybrid | 0 | 60 | 45 | 1 đối thủ | Chậm Chạp · 10% suy diễn · 3T | Giảm Linh xảo 10%. |
| `LH-33` | Thủy trụ | Hybrid | 1 | 100 | 30 | 1 đối thủ | Nhụt Chí · 10% suy diễn · 3T | Giảm damage gây ra 10%. |
| `LH-34` | Thuật cầu nguyện | Phòng thủ | 1 | 0 | 10 | Mình/đồng minh | Vô hình · 100% · 3T | Phản lại 30% damage nhận. |
| `LH-35` | Thủy bích | Phòng thủ | 1 | 0 | 10 | Mình/đồng minh | Kiên nhẫn · 100% · 3T | Giảm 50% damage nhận. |
| `LH-36` | Bạo Phong Tuyết | Tấn công | 2 | 150 | 30 | 1 đối thủ | — | Chỉ gây 150% damage. |
| `LH-37` | Lá chắn gió tuyết | Hybrid | 2 | 100 | 30 | 1 đối thủ | Mục · 2% suy diễn · 3T | Giảm chính xác 5%. |
| `LH-38` | Băng Phong Hãm Tịnh | Hybrid | 3 | 150 | 15 | 1 đối thủ | Chậm Chạp · 10% suy diễn · 3T | Giảm Linh xảo 10%. |
| `LH-39` | Ray lạnh | Hybrid | 3 | 150 | 15 | 1 đối thủ | Nhụt Chí · 10% suy diễn · 3T | Giảm damage gây ra 10%. |

### Hệ Điện — 10 Skill

| Mã | Skill | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `LH-40` | Điện giật | Tấn công | 0 | 100 | 45 | 1 đối thủ | — | Chỉ gây 100% damage. |
| `LH-41` | Lôi thiểm | Khống chế | 0 | 90 | 45 | 1 đối thủ | Tê Liệt · 10% suy diễn · 4T | Giảm Linh xảo 20%. |
| `LH-42` | Nạp điện | Hybrid | 0 | 90 | 45 | 1 đối thủ | Linh Xảo · 100% · 2T | Linh xảo +5%. |
| `LH-43` | Sóng điện từ | Tấn công | 1 | 100 | 30 | 1 đối thủ | — | Chỉ gây 100% damage. |
| `LH-44` | Đoạt mệnh cao áp | Buff | 1 | 0 | 10 | Bản thân | Điện áp · 100% · 4T | Damage +30%; tăng tiêu hao PP chưa chạy. |
| `LH-45` | Điện năng chuyển đổi | Buff | 1 | 0 | 10 | Bản thân | Hỏa Thạch · 100% · 3T | Linh xảo +50%; DEF −50%. |
| `LH-46` | Tia lửa điện | Tấn công | 2 | 150 | 30 | 1 đối thủ | — | Chỉ gây 150% damage. |
| `LH-47` | Chùm sấm sét | Khống chế | 2 | 130 | 30 | 1 đối thủ | Tê Liệt · 10% suy diễn · 4T | Giảm Linh xảo 20%. |
| `LH-48` | Điện quang thạch hỏa | Hybrid | 3 | 130 | 15 | 1 đối thủ | Linh Xảo · 100% · 2T | Linh xảo +5%. |
| `LH-49` | Cảm ứng điện từ | Tấn công | 3 | 180 | 15 | 1 đối thủ | — | Chỉ gây 180% damage. |

### Hệ Quỷ — 10 Skill

| Mã | Skill | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `LH-50` | Ảnh thứ | Tấn công | 0 | 100 | 45 | 1 đối thủ | — | Chỉ gây 100% damage. |
| `LH-51` | Chú oán | Hybrid | 0 | 80 | 45 | 1 đối thủ | Phòng Ngự · 20% suy diễn · 3T | Giảm DEF 20%. |
| `LH-52` | Quỷ độc | Tấn công | 0 | 80 | 45 | 1 đối thủ | — | Runtime mới gây 80% damage; hồi HP xác suất chưa chạy. |
| `LH-53` | Cơn ác mộng | Tấn công | 1 | 200 | 30 | 1 đối thủ | — | Runtime mới gây 200% damage; kết liễu theo HP thấp chưa chạy. |
| `LH-54` | Mị ảnh | Khống chế | 1 | 0 | 10 | 1 đối thủ | Quỷ Mị · 40% suy diễn · 4T | Chưa có hành vi runtime. |
| `LH-55` | Hỗn loạn | Khống chế | 1 | 0 | 10 | 1 đối thủ | Hỗn Loạn · 95% suy diễn · 1T | Mất một hành động kế tiếp. |
| `LH-56` | Độc ảnh thứ | Tấn công | 2 | 150 | 30 | 1 đối thủ | — | Chỉ gây 150% damage. |
| `LH-57` | Chú Phược Quỷ Lao | Hybrid | 2 | 120 | 30 | 1 đối thủ | Phòng Ngự · 20% suy diễn · 3T | Giảm DEF 20%. |
| `LH-58` | Quỷ độc tín ngưỡng | Tấn công | 3 | 100 | 15 | 1 đối thủ | — | Runtime mới gây 100% damage; hồi HP xác suất chưa chạy. |
| `LH-59` | Lời nguyền cuối cùng | Tấn công | 3 | 250 | 15 | 1 đối thủ | — | Runtime mới gây 250% damage; kết liễu theo HP thấp chưa chạy. |

### Hệ Phong — 10 Skill

| Mã | Skill | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `LH-60` | Phong nhận | Tấn công | 0 | 100 | 45 | 1 đối thủ | — | Chỉ gây 100% damage. |
| `LH-61` | Phong áp | Hybrid | 0 | 80 | 45 | 1 đối thủ | Chậm Chạp · 5% suy diễn · 3T | Giảm Linh xảo 5%. |
| `LH-62` | Thuận phong | Hybrid | 0 | 80 | 45 | 1 đối thủ | Man Lực · 100% · 2T | Sức mạnh +5%. |
| `LH-63` | Long quyển | Tấn công | 1 | 100 | 30 | 1 đối thủ | — | Runtime mới gây 100% damage; đánh lặp 5% chưa chạy. |
| `LH-64` | Nghịch Phong Đoạt | Buff | 1 | 0 | 10 | 1 đối thủ | Thâu Thủ · 100% · 3T | Chưa có hành vi runtime. |
| `LH-65` | Vũ Liệt Thuật | Buff | 1 | 0 | 10 | Bản thân | Gia Tốc · 100% · 2T | Chưa có hành vi runtime. |
| `LH-66` | Yến Hồi Thiểm | Tấn công | 2 | 150 | 30 | 1 đối thủ | — | Chỉ gây 150% damage. |
| `LH-67` | Phong Chi Tuyền Qua | Hybrid | 2 | 110 | 30 | 1 đối thủ | Chậm Chạp · 5% suy diễn · 3T | Giảm Linh xảo 5%. |
| `LH-68` | Phong Chi Tí Hữu | Hybrid | 3 | 110 | 15 | 1 đối thủ | Man Lực · 100% · 2T | Sức mạnh +5%. |
| `LH-69` | Phi Yến Hoàn Sào | Tấn công | 3 | 150 | 15 | 1 đối thủ | — | Runtime mới gây 150% damage; đánh lặp 8% chưa chạy. |

## II. 25 Skill theo Chủng Cầu Vồng

### Chủng Thực Vật — 5 Skill

| Mã | Skill | Hệ | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `CV-00` | Triền Nhiễu | Mộc | Hybrid | 0 | 70 | 45 | 1 đối thủ | Hủ Thực · 4% · 3T quy đổi | DoT tăng dần 4% → 8% → 12% HP tối đa. |
| `CV-01` | Phong Lợi Tiêm Thứ | Mộc | Hybrid | 0 | 80 | 40 | 1 đối thủ | Hủ Thực · 8% · 3T quy đổi | DoT tăng dần 4% → 8% → 12% HP tối đa. |
| `CV-02` | Bạo Tạc Chủng Tử | Hỏa | Hybrid | 1 | 105 | 30 | 1 đối thủ | Hủ Thực · 12% · 3T quy đổi | DoT tăng dần 4% → 8% → 12% HP tối đa. |
| `CV-03` | Phi Diệp Đao Phong | Phong | Hybrid | 2 | 130 | 25 | 1 đối thủ | Hủ Thực · 16% · 3T quy đổi | DoT tăng dần 4% → 8% → 12% HP tối đa. |
| `CV-04` | Thực Vật Phong Bạo | Mộc | Hybrid | 3 | 160 | 15 | 1 đối thủ | Hủ Thực · 24% · 3T quy đổi | DoT tăng dần 4% → 8% → 12% HP tối đa. |

### Chủng Kim Loại — 5 Skill

| Mã | Skill | Hệ | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `CV-05` | Thiết Chuy | Thổ | Hybrid | 0 | 60 | 45 | 1 đối thủ | Thạch Hóa · 4% · 2T quy đổi | Mất một hành động; damage nhận giảm 30%. |
| `CV-06` | Thiết Phù Đồ | Thổ | Hybrid | 0 | 70 | 40 | 1 đối thủ | Thạch Hóa · 8% · 2T quy đổi | Mất một hành động; damage nhận giảm 30%. |
| `CV-07` | Bạo Liệt Vũ | Hỏa | Hybrid | 1 | 90 | 30 | 1 đối thủ | Thạch Hóa · 12% · 2T quy đổi | Mất một hành động; damage nhận giảm 30%. |
| `CV-08` | Toản Thạch Thiết Cát | Điện | Hybrid | 2 | 110 | 25 | 1 đối thủ | Thạch Hóa · 16% · 2T quy đổi | Mất một hành động; damage nhận giảm 30%. |
| `CV-09` | Kim Loại Liệt Trảm | Điện | Hybrid | 3 | 140 | 15 | 1 đối thủ | Thạch Hóa · 24% · 2T quy đổi | Mất một hành động; damage nhận giảm 30%. |

### Chủng Phi Hành — 5 Skill

| Mã | Skill | Hệ | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `CV-10` | Phi Tường Trảm | Phong | Hybrid | 0 | 85 | 45 | 1 đối thủ | Giam Cầm · 4% · 3T quy đổi | Giảm 15% Linh xảo. |
| `CV-11` | Bạo Phong Toàn Trận | Phong | Hybrid | 0 | 95 | 40 | 1 đối thủ | Giam Cầm · 8% · 3T quy đổi | Giảm 15% Linh xảo. |
| `CV-12` | Tật Phong Tốc Hàng | Phong | Hybrid | 1 | 120 | 30 | 1 đối thủ | Giam Cầm · 12% · 3T quy đổi | Giảm 15% Linh xảo. |
| `CV-13` | Thánh Linh Khoan Thứ | Quỷ | Hybrid | 2 | 145 | 25 | 1 đối thủ | Giam Cầm · 16% · 3T quy đổi | Giảm 15% Linh xảo. |
| `CV-14` | Thiên Nộ | Điện | Hybrid | 3 | 175 | 15 | 1 đối thủ | Giam Cầm · 24% · 3T quy đổi | Giảm 15% Linh xảo. |

### Chủng Mãnh Thú — 5 Skill

| Mã | Skill | Hệ | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `CV-15` | Phác Giảo | Thổ | Hybrid | 0 | 70 | 45 | 1 đối thủ | Tê Liệt · 4% · 3T quy đổi | Mất 10% HP hiện tại ở đầu lượt. |
| `CV-16` | Tê Liệt Kích | Điện | Hybrid | 0 | 80 | 40 | 1 đối thủ | Tê Liệt · 8% · 3T quy đổi | Mất 10% HP hiện tại ở đầu lượt. |
| `CV-17` | Nộ Ý Cuồng Bạo | Hỏa | Hybrid | 1 | 105 | 30 | 1 đối thủ | Tê Liệt · 12% · 3T quy đổi | Mất 10% HP hiện tại ở đầu lượt. |
| `CV-18` | Tứ Ngược Trùng Phong | Thổ | Hybrid | 2 | 130 | 25 | 1 đối thủ | Tê Liệt · 16% · 3T quy đổi | Mất 10% HP hiện tại ở đầu lượt. |
| `CV-19` | Cuồng Bạo Tê Hống | Hỏa | Hybrid | 3 | 160 | 15 | 1 đối thủ | Tê Liệt · 24% · 3T quy đổi | Mất 10% HP hiện tại ở đầu lượt. |

### Chủng Hải Dương — 5 Skill

| Mã | Skill | Hệ | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `CV-20` | Thủy Trụ | Thủy | Hybrid | 0 | 90 | 45 | 1 đối thủ | Mị Hoặc · 4% · 3T quy đổi | Giảm 10% damage gây ra. |
| `CV-21` | Tiên Xạ Thủy Lãng | Thủy | Hybrid | 0 | 100 | 40 | 1 đối thủ | Mị Hoặc · 8% · 3T quy đổi | Giảm 10% damage gây ra. |
| `CV-22` | Thủy Cầu Áp Sát | Thủy | Hybrid | 1 | 130 | 30 | 1 đối thủ | Mị Hoặc · 12% · 3T quy đổi | Giảm 10% damage gây ra. |
| `CV-23` | Phún Xạ Thủy Trụ | Thủy | Hybrid | 2 | 155 | 25 | 1 đối thủ | Mị Hoặc · 16% · 3T quy đổi | Giảm 10% damage gây ra. |
| `CV-24` | Hải Thần Phục Cừu | Quỷ | Hybrid | 3 | 190 | 15 | 1 đối thủ | Mị Hoặc · 24% · 3T quy đổi | Giảm 10% damage gây ra. |

## III. 4 Skill đặc biệt Cầu Vồng

| Mã | Skill | Hệ | Loại | Tier | Power | PP | Mục tiêu | Effect dữ liệu | Cơ chế runtime hiện tại |
| --- | --- | --- | --- | --- | --- | --- | --- | --- | --- |
| `CV-27` | Trị liệu sơ cấp | Mộc | Hồi phục | 0 | 0 | 20 | Mình/đồng minh | — | Hồi 25% HP tối đa. |
| `CV-28` | Trị liệu chuyên nghiệp | Mộc | Hồi phục | 2 | 0 | 10 | Mình/đồng minh | — | Hồi 50% HP tối đa. |
| `CV-29` | Tử Vong Chi Xúc | Quỷ | Tấn công | 3 | 250 | 1 | 1 đối thủ | — | Runtime gây 250% damage; xóa PP còn lại chưa chạy. |
| `CV-30` | Kỹ năng Phong Bế | Quỷ | Khống chế | 2 | 0 | 5 | 1 đối thủ | Phong Bế · 70% · 2T quy đổi | Không dùng được Skill Tier 2–3. |

## IV. Các vấn đề hiện trạng nhìn thấy trực tiếp

1. **25 Skill Chủng dùng năm khuôn lặp:** mỗi Chủng có năm Skill cùng một Effect, chỉ tăng Power, PP và xác suất theo bậc.
2. **Xác suất và cường độ đang dùng chung `effect_parameter`:** ví dụ Dương Viêm bị runtime hiểu là 4% áp dụng, trong khi số 4 đồng thời được dùng làm lượng DoT; Băng Lao bị hiểu là 1%.
3. **Mười ba Skill có cơ chế phụ trong mô tả nhưng runtime mới xử lý damage cơ bản:** 12 Skill Liệt Hỏa và Tử Vong Chi Xúc.
4. **Ba Effect chưa có hành vi runtime:** Quỷ Mị, Thâu Thủ và Gia Tốc.
5. **Hai Effect thanh tẩy chưa đầy đủ:** Người bảo vệ Địa Giới mới hồi theo lượt; Thạch Phu Thuật mới chặn debuff mới.
6. **Hồi phục Mộc nghèo hơn dữ liệu mô tả:** Quang Phản và Diệp Chi Ân Huệ hiện không hồi HP trong runtime; chỉ Thảo Nguyện Thuật thực thi hồi theo lượt.
7. **Ba Skill đánh dấu đấu đôi vẫn có thể đi vào audit 1v1:** Người bảo vệ Địa Giới, Trị liệu sơ cấp và Trị liệu chuyên nghiệp.
8. **Phân loại `hybrid` quá rộng:** 45 Skill gồm cả damage + buff, damage + debuff và các cơ chế hoàn toàn khác nhau.
9. **Thời lượng Effect Cầu Vồng không lưu trực tiếp trong Effect:** simulator đang quy đổi Thạch Hóa/Phong Bế thành 2 hiệp, các Effect còn lại thành 3 hiệp.
10. **Nhiều Effect cùng ghi vào một status key:** Mê Muội, Chậm Chạp và Tê Liệt có thể cùng trở thành giảm Linh xảo, khiến bản sắc hiển thị khác nhau nhưng runtime gần giống nhau.

