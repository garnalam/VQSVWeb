# Đánh dấu vấn đề của 99 Skill

> Vòng sàng lọc hiện trạng ngày 28/07/2026. Đối chiếu với [bảng hiện trạng 99 Skill](skill-current-state.md). Chưa phải bảng cơ chế mới và chưa cập nhật database.

## Quy ước

- `TRÙNG`: trùng hoặc lặp khuôn cơ chế với Skill khác.
- `YẾU`: bị lựa chọn cùng bậc vượt trội, Effect quá nhỏ hoặc quyền lợi mô tả chưa hoạt động.
- `MẠNH`: vượt ngân sách Power/Effect rõ ràng theo Tier hoặc có nguy cơ áp đảo 1v1.
- `SAI/THIẾU`: runtime không khớp mô tả, dùng sai tham số hoặc chưa thực thi Effect.
- `LỆCH PHẠM VI`: Skill đấu đôi đang có thể ảnh hưởng audit 1v1.
- `ỔN TẠM`: chưa thấy vấn đề rõ ở vòng sàng lọc; vẫn phải đi qua review cơ chế toàn diện.

Một Skill có thể mang nhiều nhãn.

## Tổng số nhãn

| Nhãn | Số Skill |
| --- | ---: |
| Trùng cơ chế | 75 |
| Yếu | 23 |
| Mạnh | 10 |
| Sai hoặc thiếu runtime | 37 |
| Lệch phạm vi 1v1/đấu đôi | 3 |
| Ổn tạm | 6 |

## I. 70 Skill Liệt Hỏa

### Hệ Hỏa

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `LH-00` | Hỏa trảo | Hệ Hỏa | 100/45 | `TRÙNG` | Cùng khuôn damage cơ bản 100%/45 PP; chỉ khác Hệ. |
| `LH-01` | Dương viêm | Hệ Hỏa | 50/45 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng khuôn damage + Gieo Hạt. 50% Power; DoT chỉ 4 HP và runtime chỉ có 4% áp dụng. effect_parameter 4 vừa là DoT vừa bị dùng làm xác suất 4%. |
| `LH-02` | Diễm kích | Hệ Hỏa | 100/45 | `TRÙNG` | Cùng khuôn damage + Mê Muội của Hỏa. |
| `LH-03` | Hỏa Vân triệu | Hệ Hỏa | 100/30 | `SAI/THIẾU` | Bonus damage lên mục tiêu đang Cháy chưa được runtime xử lý. |
| `LH-04` | Thiên Hỏa tế | Hệ Hỏa | 0/10 | `ỔN TẠM` | Chưa thấy lỗi hoặc chênh lệch rõ ở vòng sàng lọc hiện trạng. |
| `LH-05` | Viêm lôi phá | Hệ Hỏa | 0/10 | `ỔN TẠM` | Chưa thấy lỗi hoặc chênh lệch rõ ở vòng sàng lọc hiện trạng. |
| `LH-06` | Hỏa diễm đao | Hệ Hỏa | 150/30 | `TRÙNG` | Cùng khuôn damage Tier 2 150%/30 PP; chỉ khác Hệ. |
| `LH-07` | Chước nhiệt chi xúc | Hệ Hỏa | 75/30 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng khuôn damage + Gieo Hạt. 75% Power; DoT chỉ 3 HP và runtime chỉ có 3% áp dụng. effect_parameter 3 vừa là DoT vừa bị dùng làm xác suất 3%. |
| `LH-08` | Liệt diễm phong bạo | Hệ Hỏa | 200/15 | `TRÙNG` `MẠNH` | Cùng khuôn damage + Mê Muội của Hỏa. 200% Power/15 PP bằng tuyệt kỹ damage thuần nhưng còn kèm Mê Muội. |
| `LH-09` | Vĩnh hằng hỏa ảnh | Hệ Hỏa | 200/15 | `SAI/THIẾU` | Bonus damage lên mục tiêu đang Cháy chưa được runtime xử lý. |

### Hệ Mộc

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `LH-10` | Diệp Toàn | Hệ Mộc | 100/45 | `TRÙNG` | Cùng khuôn damage cơ bản 100%/45 PP; chỉ khác Hệ. |
| `LH-11` | Quang phản | Hệ Mộc | 90/45 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng ý tưởng damage kèm hồi HP. Power thấp hơn Diệp Toàn nhưng phần hồi HP chưa hoạt động. Mô tả có hồi HP nhưng runtime chỉ gây damage. |
| `LH-12` | Đằng Phược | Hệ Mộc | 50/45 | `TRÙNG` `SAI/THIẾU` | Cùng khuôn damage + Quấn Quanh. Mô tả áp dụng Quấn Quanh trực tiếp; runtime tự suy diễn thành 95%. |
| `LH-13` | Thảo Chủng | Hệ Mộc | 50/30 | `TRÙNG` `MẠNH` `SAI/THIẾU` | Cùng khuôn damage + Thực Loại trễ. 50% damage tức thời + 150 damage trễ với xác suất runtime 95% ở Tier 1. Mô tả áp dụng Thực Loại trực tiếp; runtime tự suy diễn thành 95%. |
| `LH-14` | Đằng chi bích lũy | Hệ Mộc | 0/10 | `ỔN TẠM` | Chưa thấy lỗi hoặc chênh lệch rõ ở vòng sàng lọc hiện trạng. |
| `LH-15` | Thảo nguyện thuật | Hệ Mộc | 0/10 | `YẾU` | Mất một lượt để hồi tổng 15% HP trong 3 hiệp; giá trị thấp so với các lựa chọn phòng thủ. |
| `LH-16` | Châm Diệp Trảm | Hệ Mộc | 150/30 | `TRÙNG` | Cùng khuôn damage Tier 2 150%/30 PP; chỉ khác Hệ. |
| `LH-17` | Diệp chi ân huệ | Hệ Mộc | 130/30 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng ý tưởng damage kèm hồi HP. Power thấp hơn Châm Diệp Trảm nhưng phần hồi HP chưa hoạt động. Mô tả có hồi HP nhưng runtime chỉ gây damage. |
| `LH-18` | Đằng mạn triền nhiễu | Hệ Mộc | 150/15 | `TRÙNG` `SAI/THIẾU` | Cùng khuôn damage + Quấn Quanh. Mô tả áp dụng Quấn Quanh trực tiếp; runtime tự suy diễn thành 95%. |
| `LH-19` | Quang hợp hiệu ứng | Hệ Mộc | 150/15 | `TRÙNG` `MẠNH` `SAI/THIẾU` | Cùng khuôn damage + Thực Loại trễ. 150% damage tức thời + 200 damage trễ với xác suất runtime 95%. Mô tả áp dụng Thực Loại trực tiếp; runtime tự suy diễn thành 95%. |

### Hệ Thổ

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `LH-20` | Hất bụi | Hệ Thổ | 100/45 | `TRÙNG` | Cùng khuôn damage cơ bản 100%/45 PP; chỉ khác Hệ. |
| `LH-21` | Thổ thuẫn | Hệ Thổ | 80/45 | `TRÙNG` `SAI/THIẾU` | Cùng khuôn damage + tăng Phòng ngự. Mô tả +10% DEF có thể chồng; runtime +20% và chỉ ghi đè/làm mới. |
| `LH-22` | Bão cát | Hệ Thổ | 50/45 | `TRÙNG` | Cùng tên và cùng Effect Mê Muội; bản Tier cao chủ yếu tăng Power. |
| `LH-23` | Nham băng | Hệ Thổ | 100/30 | `SAI/THIẾU` | Bonus damage lên mục tiêu Mê Muội chưa được runtime xử lý. |
| `LH-24` | Người bảo vệ Địa Giới | Hệ Thổ | 0/10 | `SAI/THIẾU` `LỆCH PHẠM VI` | Runtime mới hồi theo lượt; thanh tẩy và mục tiêu toàn phe chưa hoàn chỉnh. Skill đấu đôi nhưng selector 1v1 chưa loại theo battle_format. |
| `LH-25` | Thạch phu thuật | Hệ Thổ | 0/10 | `SAI/THIẾU` | Runtime mới miễn debuff mới; phần thanh tẩy chưa hoạt động. |
| `LH-26` | Nham bạo | Hệ Thổ | 150/30 | `TRÙNG` | Cùng khuôn damage Tier 2 150%/30 PP; chỉ khác Hệ. |
| `LH-27` | Hàng rào cát đá | Hệ Thổ | 100/30 | `TRÙNG` `SAI/THIẾU` | Cùng khuôn damage + tăng Phòng ngự. Mô tả +10% DEF có thể chồng; runtime +20% và chỉ ghi đè/làm mới. |
| `LH-28` | Bão cát | Hệ Thổ | 150/15 | `TRÙNG` | Cùng tên và cùng Effect Mê Muội; bản Tier cao chủ yếu tăng Power. |
| `LH-29` | Thổ Chi Loạn Vũ | Hệ Thổ | 180/15 | `SAI/THIẾU` | Bonus damage lên mục tiêu Mê Muội chưa được runtime xử lý. |

### Hệ Thủy

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `LH-30` | Bong bóng | Hệ Thủy | 100/45 | `TRÙNG` | Cùng khuôn damage cơ bản 100%/45 PP; chỉ khác Hệ. |
| `LH-31` | Băng lao | Hệ Thủy | 60/45 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng khuôn damage + giảm chính xác. 60% Power và runtime chỉ có 1% áp dụng giảm chính xác. Mức giảm chính xác 1 bị dùng luôn làm xác suất áp dụng 1%. |
| `LH-32` | Tuyết ảnh | Hệ Thủy | 60/45 | `TRÙNG` `SAI/THIẾU` | Cùng khuôn damage + giảm Linh xảo. Mức giảm Linh xảo 10% bị dùng luôn làm xác suất áp dụng 10%. |
| `LH-33` | Thủy trụ | Hệ Thủy | 100/30 | `TRÙNG` `SAI/THIẾU` | Cùng khuôn damage + giảm damage đối thủ. Mức giảm damage 10% bị dùng luôn làm xác suất áp dụng 10%. |
| `LH-34` | Thuật cầu nguyện | Hệ Thủy | 0/10 | `SAI/THIẾU` | Mô tả là 30% xác suất phản toàn bộ; runtime cân bằng phản cố định 30% damage. |
| `LH-35` | Thủy bích | Hệ Thủy | 0/10 | `MẠNH` | Giảm 50% toàn bộ damage nhận trong 3 hiệp, mức phòng thủ rất cao. |
| `LH-36` | Bạo Phong Tuyết | Hệ Thủy | 150/30 | `TRÙNG` | Cùng khuôn damage Tier 2 150%/30 PP; chỉ khác Hệ. |
| `LH-37` | Lá chắn gió tuyết | Hệ Thủy | 100/30 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng khuôn damage + giảm chính xác. 100% Power ở Tier 2 và runtime chỉ có 2% áp dụng giảm chính xác. Mức giảm chính xác 2 bị dùng luôn làm xác suất áp dụng 2%. |
| `LH-38` | Băng Phong Hãm Tịnh | Hệ Thủy | 150/15 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng khuôn damage + giảm Linh xảo. 150% Power/15 PP ngang Skill Tier 2 nhưng Effect runtime chỉ có 10% áp dụng. Mức giảm Linh xảo 10% bị dùng luôn làm xác suất áp dụng 10%. |
| `LH-39` | Ray lạnh | Hệ Thủy | 150/15 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng khuôn damage + giảm damage đối thủ. 150% Power/15 PP ngang Skill Tier 2 nhưng Effect runtime chỉ có 10% áp dụng. Mức giảm damage 10% bị dùng luôn làm xác suất áp dụng 10%. |

### Hệ Điện

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `LH-40` | Điện giật | Hệ Điện | 100/45 | `TRÙNG` | Cùng khuôn damage cơ bản 100%/45 PP; chỉ khác Hệ. |
| `LH-41` | Lôi thiểm | Hệ Điện | 90/45 | `TRÙNG` | Cùng khuôn damage + Tê Liệt. |
| `LH-42` | Nạp điện | Hệ Điện | 90/45 | `TRÙNG` | Cùng khuôn damage + tăng Linh xảo. |
| `LH-43` | Sóng điện từ | Hệ Điện | 100/30 | `ỔN TẠM` | Chưa thấy lỗi hoặc chênh lệch rõ ở vòng sàng lọc hiện trạng. |
| `LH-44` | Đoạt mệnh cao áp | Hệ Điện | 0/10 | `SAI/THIẾU` | Runtime tăng damage nhưng chưa thực thi tiêu hao PP gấp đôi. |
| `LH-45` | Điện năng chuyển đổi | Hệ Điện | 0/10 | `ỔN TẠM` | Chưa thấy lỗi hoặc chênh lệch rõ ở vòng sàng lọc hiện trạng. |
| `LH-46` | Tia lửa điện | Hệ Điện | 150/30 | `TRÙNG` | Cùng khuôn damage Tier 2 150%/30 PP; chỉ khác Hệ. |
| `LH-47` | Chùm sấm sét | Hệ Điện | 130/30 | `TRÙNG` | Cùng khuôn damage + Tê Liệt. |
| `LH-48` | Điện quang thạch hỏa | Hệ Điện | 130/15 | `TRÙNG` | Cùng khuôn damage + tăng Linh xảo. |
| `LH-49` | Cảm ứng điện từ | Hệ Điện | 180/15 | `ỔN TẠM` | Chưa thấy lỗi hoặc chênh lệch rõ ở vòng sàng lọc hiện trạng. |

### Hệ Quỷ

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `LH-50` | Ảnh thứ | Hệ Quỷ | 100/45 | `TRÙNG` | Cùng khuôn damage cơ bản 100%/45 PP; chỉ khác Hệ. |
| `LH-51` | Chú oán | Hệ Quỷ | 80/45 | `TRÙNG` `SAI/THIẾU` | Cùng khuôn damage + giảm Phòng ngự. Mức giảm DEF 20% bị dùng luôn làm xác suất áp dụng 20%. |
| `LH-52` | Quỷ độc | Hệ Quỷ | 80/45 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng ý tưởng damage kèm hồi HP xác suất. Chỉ còn 80% damage do phần hồi HP chưa hoạt động. Hồi HP xác suất trong mô tả chưa được runtime xử lý. |
| `LH-53` | Cơn ác mộng | Hệ Quỷ | 200/30 | `TRÙNG` `MẠNH` | Cùng ý tưởng kết liễu theo HP mục tiêu. 200% Power/30 PP ngay Tier 1, gấp đôi chuẩn Tier 1 phổ biến. |
| `LH-54` | Mị ảnh | Hệ Quỷ | 0/10 | `YẾU` `SAI/THIẾU` | 0 Power và Effect Quỷ Mị chưa có hành vi runtime. Quỷ Mị chưa có hành vi runtime. |
| `LH-55` | Hỗn loạn | Hệ Quỷ | 0/10 | `MẠNH` `SAI/THIẾU` | Runtime có thể chặn hành động với xác suất suy diễn 95%; giá trị cực lớn trong 1v1. Mô tả nguồn và Effect/behavior hiện mâu thuẫn; thời lượng còn phụ thuộc thứ tự hành động. |
| `LH-56` | Độc ảnh thứ | Hệ Quỷ | 150/30 | `TRÙNG` | Cùng khuôn damage Tier 2 150%/30 PP; chỉ khác Hệ. |
| `LH-57` | Chú Phược Quỷ Lao | Hệ Quỷ | 120/30 | `TRÙNG` `SAI/THIẾU` | Cùng khuôn damage + giảm Phòng ngự. Mức giảm DEF 20% bị dùng luôn làm xác suất áp dụng 20%. |
| `LH-58` | Quỷ độc tín ngưỡng | Hệ Quỷ | 100/15 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng ý tưởng damage kèm hồi HP xác suất. Tier 3 chỉ gây 100% damage; phần hồi HP chưa hoạt động. Hồi HP xác suất trong mô tả chưa được runtime xử lý. |
| `LH-59` | Lời nguyền cuối cùng | Hệ Quỷ | 250/15 | `TRÙNG` `MẠNH` | Cùng ý tưởng kết liễu theo HP mục tiêu. 250% Power/15 PP, cao nhất nhóm Liệt Hỏa ngay cả khi chưa chạy cơ chế kết liễu. |

### Hệ Phong

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `LH-60` | Phong nhận | Hệ Phong | 100/45 | `TRÙNG` | Cùng khuôn damage cơ bản 100%/45 PP; chỉ khác Hệ. |
| `LH-61` | Phong áp | Hệ Phong | 80/45 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng khuôn damage + giảm Linh xảo. 80% Power đổi lấy Effect chỉ có 5% xác suất runtime. Mức giảm Linh xảo 5% bị dùng luôn làm xác suất áp dụng 5%. |
| `LH-62` | Thuận phong | Hệ Phong | 80/45 | `TRÙNG` | Cùng khuôn damage + tăng Sức mạnh. |
| `LH-63` | Long quyển | Hệ Phong | 100/30 | `TRÙNG` `SAI/THIẾU` | Cùng ý tưởng có xác suất đánh lặp. Đánh lặp 5% trong mô tả chưa được runtime xử lý. |
| `LH-64` | Nghịch Phong Đoạt | Hệ Phong | 0/10 | `YẾU` `SAI/THIẾU` | Tốn lượt và PP nhưng Thâu Thủ chưa có hành vi runtime. Thâu Thủ chưa có hành vi runtime. |
| `LH-65` | Vũ Liệt Thuật | Hệ Phong | 0/10 | `YẾU` `SAI/THIẾU` | Tốn lượt và PP nhưng Gia Tốc chưa có hành vi runtime. Gia Tốc/đánh hai lần chưa có hành vi runtime. |
| `LH-66` | Yến Hồi Thiểm | Hệ Phong | 150/30 | `TRÙNG` | Cùng khuôn damage Tier 2 150%/30 PP; chỉ khác Hệ. |
| `LH-67` | Phong Chi Tuyền Qua | Hệ Phong | 110/30 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng khuôn damage + giảm Linh xảo. Tier 2 chỉ 110% Power và Effect có 5% xác suất runtime. Mức giảm Linh xảo 5% bị dùng luôn làm xác suất áp dụng 5%. |
| `LH-68` | Phong Chi Tí Hữu | Hệ Phong | 110/15 | `TRÙNG` | Cùng khuôn damage + tăng Sức mạnh. |
| `LH-69` | Phi Yến Hoàn Sào | Hệ Phong | 150/15 | `TRÙNG` `YẾU` `SAI/THIẾU` | Cùng ý tưởng có xác suất đánh lặp. Tier 3 vẫn chỉ 150% Power; đánh lặp 8% chưa hoạt động. Đánh lặp 8% trong mô tả chưa được runtime xử lý. |

## II. 25 Skill theo Chủng Cầu Vồng

### Chủng Thực Vật

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `CV-00` | Triền Nhiễu | Chủng Thực Vật · Hệ Mộc | 70/45 | `TRÙNG` `YẾU` | Năm bậc Thực Vật đều damage + Hủ Thực. 70% Power và chỉ 4% Hủ Thực; gần như không tạo bản sắc. |
| `CV-01` | Phong Lợi Tiêm Thứ | Chủng Thực Vật · Hệ Mộc | 80/40 | `TRÙNG` `YẾU` | Năm bậc Thực Vật đều damage + Hủ Thực. 80% Power và chỉ 8% Hủ Thực; ít giá trị hơn Skill cơ bản 100%. |
| `CV-02` | Bạo Tạc Chủng Tử | Chủng Thực Vật · Hệ Hỏa | 105/30 | `TRÙNG` | Năm bậc Thực Vật đều damage + Hủ Thực. |
| `CV-03` | Phi Diệp Đao Phong | Chủng Thực Vật · Hệ Phong | 130/25 | `TRÙNG` | Năm bậc Thực Vật đều damage + Hủ Thực. |
| `CV-04` | Thực Vật Phong Bạo | Chủng Thực Vật · Hệ Mộc | 160/15 | `TRÙNG` | Năm bậc Thực Vật đều damage + Hủ Thực. |

### Chủng Kim Loại

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `CV-05` | Thiết Chuy | Chủng Kim Loại · Hệ Thổ | 60/45 | `TRÙNG` `YẾU` | Năm bậc Kim Loại đều damage + Thạch Hóa. 60% Power và chỉ 4% Thạch Hóa. |
| `CV-06` | Thiết Phù Đồ | Chủng Kim Loại · Hệ Thổ | 70/40 | `TRÙNG` `YẾU` | Năm bậc Kim Loại đều damage + Thạch Hóa. 70% Power và chỉ 8% Thạch Hóa. |
| `CV-07` | Bạo Liệt Vũ | Chủng Kim Loại · Hệ Hỏa | 90/30 | `TRÙNG` | Năm bậc Kim Loại đều damage + Thạch Hóa. |
| `CV-08` | Toản Thạch Thiết Cát | Chủng Kim Loại · Hệ Điện | 110/25 | `TRÙNG` | Năm bậc Kim Loại đều damage + Thạch Hóa. |
| `CV-09` | Kim Loại Liệt Trảm | Chủng Kim Loại · Hệ Điện | 140/15 | `TRÙNG` | Năm bậc Kim Loại đều damage + Thạch Hóa. |

### Chủng Phi Hành

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `CV-10` | Phi Tường Trảm | Chủng Phi Hành · Hệ Phong | 85/45 | `TRÙNG` | Năm bậc Phi Hành đều damage + Giam Cầm. |
| `CV-11` | Bạo Phong Toàn Trận | Chủng Phi Hành · Hệ Phong | 95/40 | `TRÙNG` | Năm bậc Phi Hành đều damage + Giam Cầm. |
| `CV-12` | Tật Phong Tốc Hàng | Chủng Phi Hành · Hệ Phong | 120/30 | `TRÙNG` | Năm bậc Phi Hành đều damage + Giam Cầm. |
| `CV-13` | Thánh Linh Khoan Thứ | Chủng Phi Hành · Hệ Quỷ | 145/25 | `TRÙNG` | Năm bậc Phi Hành đều damage + Giam Cầm. |
| `CV-14` | Thiên Nộ | Chủng Phi Hành · Hệ Điện | 175/15 | `TRÙNG` | Năm bậc Phi Hành đều damage + Giam Cầm. |

### Chủng Mãnh Thú

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `CV-15` | Phác Giảo | Chủng Mãnh Thú · Hệ Thổ | 70/45 | `TRÙNG` `YẾU` | Năm bậc Mãnh Thú đều damage + Tê Liệt. 70% Power và chỉ 4% Tê Liệt. |
| `CV-16` | Tê Liệt Kích | Chủng Mãnh Thú · Hệ Điện | 80/40 | `TRÙNG` `YẾU` | Năm bậc Mãnh Thú đều damage + Tê Liệt. 80% Power và chỉ 8% Tê Liệt. |
| `CV-17` | Nộ Ý Cuồng Bạo | Chủng Mãnh Thú · Hệ Hỏa | 105/30 | `TRÙNG` | Năm bậc Mãnh Thú đều damage + Tê Liệt. |
| `CV-18` | Tứ Ngược Trùng Phong | Chủng Mãnh Thú · Hệ Thổ | 130/25 | `TRÙNG` | Năm bậc Mãnh Thú đều damage + Tê Liệt. |
| `CV-19` | Cuồng Bạo Tê Hống | Chủng Mãnh Thú · Hệ Hỏa | 160/15 | `TRÙNG` | Năm bậc Mãnh Thú đều damage + Tê Liệt. |

### Chủng Hải Dương

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `CV-20` | Thủy Trụ | Chủng Hải Dương · Hệ Thủy | 90/45 | `TRÙNG` | Năm bậc Hải Dương đều damage + Mị Hoặc. |
| `CV-21` | Tiên Xạ Thủy Lãng | Chủng Hải Dương · Hệ Thủy | 100/40 | `TRÙNG` | Năm bậc Hải Dương đều damage + Mị Hoặc. |
| `CV-22` | Thủy Cầu Áp Sát | Chủng Hải Dương · Hệ Thủy | 130/30 | `TRÙNG` | Năm bậc Hải Dương đều damage + Mị Hoặc. |
| `CV-23` | Phún Xạ Thủy Trụ | Chủng Hải Dương · Hệ Thủy | 155/25 | `TRÙNG` | Năm bậc Hải Dương đều damage + Mị Hoặc. |
| `CV-24` | Hải Thần Phục Cừu | Chủng Hải Dương · Hệ Quỷ | 190/15 | `TRÙNG` | Năm bậc Hải Dương đều damage + Mị Hoặc. |

## III. 4 Skill đặc biệt Cầu Vồng

| Mã | Skill | Hệ/Chủng | Power/PP | Đánh dấu | Lý do |
| --- | --- | --- | ---: | --- | --- |
| `CV-27` | Trị liệu sơ cấp | Hệ Mộc | 0/20 | `LỆCH PHẠM VI` | Skill đấu đôi nhưng selector 1v1 chưa loại theo battle_format. |
| `CV-28` | Trị liệu chuyên nghiệp | Hệ Mộc | 0/10 | `MẠNH` `LỆCH PHẠM VI` | Hồi 50% HP tối đa, 10 PP; quá mạnh nếu lọt vào chiến đấu 1v1. Skill đấu đôi nhưng selector 1v1 chưa loại theo battle_format. |
| `CV-29` | Tử Vong Chi Xúc | Hệ Quỷ | 250/1 | `MẠNH` `SAI/THIẾU` | 250% Power trong khi hậu quả xóa toàn bộ PP chưa hoạt động. Hậu quả đưa PP của năm Skill về 0 chưa được runtime xử lý. |
| `CV-30` | Kỹ năng Phong Bế | Hệ Quỷ | 0/5 | `MẠNH` | 70% khóa toàn bộ Skill Tier 2–3 trong 2 hiệp; áp lực rất lớn trong 1v1. |

## Kết luận sàng lọc

- Các nhãn `SAI/THIẾU` phải được xử lý trước khi cân bằng Power.
- Các Skill `TRÙNG` không bắt buộc đổi tên hoặc xóa; chúng là ứng viên cần thay đổi logic để thể hiện bản sắc Hệ/Chủng.
- Các nhãn `MẠNH` và `YẾU` được đánh giá theo runtime hiện tại. Sau khi Effect hoạt động đúng, chúng phải được đo lại bằng audit matchup.
- Không có Skill mới nào được đề xuất hoặc tạo trong tài liệu này.

