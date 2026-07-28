# Thiết kế lại cơ chế 99 Skill — bản cân bằng v2 đã duyệt review

> Ngày 28/07/2026. Đã hợp nhất 13 điều chỉnh sau review từng Skill. Database, seeder, Wiki và simulator chưa được cập nhật.

## Phạm vi và nguyên tắc

- Giữ nguyên 99 Skill, ID, tên, hệ/chủng, artwork và animation.
- Không thêm trạng thái, Skill, tài nguyên chiến đấu hoặc luật ngoài hai game gốc.
- PP là tài nguyên duy nhất của Skill; không đưa năng lượng Cầu Vồng trở lại.
- Cơ chế và luật trạng thái không được ghi đè tại tài liệu này tiếp tục dùng theo `skill-mechanics-redesign-v1.md`.
- Power trong bảng là Power cơ sở trước điều kiện; Power điều kiện vẫn dùng đúng cơ chế đã mô tả trong v1.
- Hút HP luôn tính theo damage thực tế sau giảm trừ và bị chặn bởi trần phần trăm HP tối đa.

## Ngân sách Power/PP chuẩn

| Tier | Skill thuần damage | Skill hybrid | PP phổ biến | Ý nghĩa |
| ---: | ---: | ---: | ---: | --- |
| 0 | 90–100 | 60–95 | 15–30 | Dùng thường xuyên, hiệu ứng phụ nhẹ hoặc xác suất thấp. |
| 1 | 105–120 | 80–115 | 10–18 | Bắt đầu hình thành combo và bản sắc hệ/chủng. |
| 2 | 130–155 | 110–145 | 8–12 | Chiêu mạnh giữa/cuối trận, hiệu ứng phải đổi lấy Power. |
| 3 | 170–200 | 125–185 | 4–6 | Tuyệt kỹ, PP thấp và không được vừa có Power trần vừa có hiệu ứng mạnh chắc chắn. |

Các Skill Power 0 không tuân theo dải damage. PP của chúng được xác định bởi giá trị một lượt hành động:

- Buff/phòng thủ thông thường: 4–6 PP.
- Hồi 25% HP: 4 PP.
- Hồi 50% HP: 2 PP.
- Khống chế mạnh hoặc miễn nhiễm nhiều lượt: 3–5 PP.
- Tuyệt kỹ đánh đổi toàn bộ tài nguyên: 1 PP.

## I. Power và PP chuẩn hóa — 70 Skill Liệt Hỏa

### Hệ Hỏa

| Mã | Skill | Tier | Power | PP |
| --- | --- | ---: | ---: | ---: |
| `LH-00` | Hỏa trảo | 0 | 100 | 30 |
| `LH-01` | Dương viêm | 0 | 75 | 18 |
| `LH-02` | Diễm kích | 0 | 95 | 20 |
| `LH-03` | Hỏa Vân triệu | 1 | 115 | 14 |
| `LH-04` | Thiên Hỏa tế | 1 | 0 | 5 |
| `LH-05` | Viêm lôi phá | 1 | 0 | 4 |
| `LH-06` | Hỏa diễm đao | 2 | 155 | 12 |
| `LH-07` | Chước nhiệt chi xúc | 2 | 105 | 10 |
| `LH-08` | Liệt diễm phong bạo | 3 | 175 | 6 |
| `LH-09` | Vĩnh hằng hỏa ảnh | 3 | 195 | 5 |

### Hệ Mộc

| Mã | Skill | Tier | Power | PP |
| --- | --- | ---: | ---: | ---: |
| `LH-10` | Diệp Toàn | 0 | 100 | 30 |
| `LH-11` | Quang phản | 0 | 90 | 22 |
| `LH-12` | Đằng Phược | 0 | 75 | 16 |
| `LH-13` | Thảo Chủng | 1 | 65 | 12 |
| `LH-14` | Đằng chi bích lũy | 1 | 0 | 6 |
| `LH-15` | Thảo nguyện thuật | 1 | 0 | 5 |
| `LH-16` | Châm Diệp Trảm | 2 | 155 | 12 |
| `LH-17` | Diệp chi ân huệ | 2 | 125 | 10 |
| `LH-18` | Đằng mạn triền nhiễu | 3 | 140 | 6 |
| `LH-19` | Quang hợp hiệu ứng | 3 | 120 | 5 |

### Hệ Thổ

| Mã | Skill | Tier | Power | PP |
| --- | --- | ---: | ---: | ---: |
| `LH-20` | Hất bụi | 0 | 100 | 30 |
| `LH-21` | Thổ thuẫn | 0 | 80 | 20 |
| `LH-22` | Bão cát | 0 | 75 | 18 |
| `LH-23` | Nham băng | 1 | 115 | 12 |
| `LH-24` | Người bảo vệ Địa Giới | 1 | 0 | 5 |
| `LH-25` | Thạch phu thuật | 1 | 0 | 4 |
| `LH-26` | Nham bạo | 2 | 155 | 12 |
| `LH-27` | Hàng rào cát đá | 2 | 115 | 8 |
| `LH-28` | Bão cát | 3 | 145 | 6 |
| `LH-29` | Thổ Chi Loạn Vũ | 3 | 185 | 5 |

### Hệ Thủy

| Mã | Skill | Tier | Power | PP |
| --- | --- | ---: | ---: | ---: |
| `LH-30` | Bong bóng | 0 | 100 | 30 |
| `LH-31` | Băng lao | 0 | 80 | 20 |
| `LH-32` | Tuyết ảnh | 0 | 80 | 20 |
| `LH-33` | Thủy trụ | 1 | 105 | 15 |
| `LH-34` | Thuật cầu nguyện | 1 | 0 | 5 |
| `LH-35` | Thủy bích | 1 | 0 | 5 |
| `LH-36` | Bạo Phong Tuyết | 2 | 155 | 12 |
| `LH-37` | Lá chắn gió tuyết | 2 | 120 | 9 |
| `LH-38` | Băng Phong Hãm Tịnh | 3 | 145 | 6 |
| `LH-39` | Ray lạnh | 3 | 135 | 6 |

### Hệ Điện

| Mã | Skill | Tier | Power | PP |
| --- | --- | ---: | ---: | ---: |
| `LH-40` | Điện giật | 0 | 100 | 30 |
| `LH-41` | Lôi thiểm | 0 | 95 | 20 |
| `LH-42` | Nạp điện | 0 | 90 | 20 |
| `LH-43` | Sóng điện từ | 1 | 110 | 14 |
| `LH-44` | Đoạt mệnh cao áp | 1 | 0 | 4 |
| `LH-45` | Điện năng chuyển đổi | 1 | 0 | 4 |
| `LH-46` | Tia lửa điện | 2 | 155 | 12 |
| `LH-47` | Chùm sấm sét | 2 | 135 | 9 |
| `LH-48` | Điện quang thạch hỏa | 3 | 145 | 6 |
| `LH-49` | Cảm ứng điện từ | 3 | 175 | 5 |

### Hệ Quỷ

| Mã | Skill | Tier | Power | PP |
| --- | --- | ---: | ---: | ---: |
| `LH-50` | Ảnh thứ | 0 | 100 | 30 |
| `LH-51` | Chú oán | 0 | 85 | 20 |
| `LH-52` | Quỷ độc | 0 | 85 | 20 |
| `LH-53` | Cơn ác mộng | 1 | 115 | 12 |
| `LH-54` | Mị ảnh | 1 | 0 | 4 |
| `LH-55` | Hỗn loạn | 1 | 0 | 5 |
| `LH-56` | Độc ảnh thứ | 2 | 155 | 12 |
| `LH-57` | Chú Phược Quỷ Lao | 2 | 115 | 8 |
| `LH-58` | Quỷ độc tín ngưỡng | 3 | 125 | 6 |
| `LH-59` | Lời nguyền cuối cùng | 3 | 175 | 5 |

### Hệ Phong

| Mã | Skill | Tier | Power | PP |
| --- | --- | ---: | ---: | ---: |
| `LH-60` | Phong nhận | 0 | 100 | 30 |
| `LH-61` | Phong áp | 0 | 85 | 20 |
| `LH-62` | Thuận phong | 0 | 85 | 20 |
| `LH-63` | Long quyển | 1 | 105 | 14 |
| `LH-64` | Nghịch Phong Đoạt | 1 | 0 | 4 |
| `LH-65` | Vũ Liệt Thuật | 1 | 0 | 4 |
| `LH-66` | Yến Hồi Thiểm | 2 | 155 | 12 |
| `LH-67` | Phong Chi Tuyền Qua | 2 | 120 | 8 |
| `LH-68` | Phong Chi Tí Hữu | 3 | 130 | 6 |
| `LH-69` | Phi Yến Hoàn Sào | 3 | 155 | 5 |

## II. Power và PP chuẩn hóa — 25 Skill theo Chủng Cầu Vồng

### Chủng Thực Vật

| Mã | Skill | Hệ | Tier | Power | PP |
| --- | --- | --- | ---: | ---: | ---: |
| `CV-00` | Triền Nhiễu | Mộc | 0 | 60 | 15 |
| `CV-01` | Phong Lợi Tiêm Thứ | Mộc | 0 | 90 | 20 |
| `CV-02` | Bạo Tạc Chủng Tử | Hỏa | 1 | 110 | 12 |
| `CV-03` | Phi Diệp Đao Phong | Phong | 2 | 140 | 8 |
| `CV-04` | Thực Vật Phong Bạo | Mộc | 3 | 160 | 5 |

### Chủng Kim Loại

| Mã | Skill | Hệ | Tier | Power | PP |
| --- | --- | --- | ---: | ---: | ---: |
| `CV-05` | Thiết Chuy | Thổ | 0 | 80 | 20 |
| `CV-06` | Thiết Phù Đồ | Thổ | 0 | 75 | 18 |
| `CV-07` | Bạo Liệt Vũ | Hỏa | 1 | 110 | 12 |
| `CV-08` | Toản Thạch Thiết Cát | Điện | 2 | 135 | 8 |
| `CV-09` | Kim Loại Liệt Trảm | Điện | 3 | 155 | 5 |

### Chủng Phi Hành

| Mã | Skill | Hệ | Tier | Power | PP |
| --- | --- | --- | ---: | ---: | ---: |
| `CV-10` | Phi Tường Trảm | Phong | 0 | 95 | 25 |
| `CV-11` | Bạo Phong Toàn Trận | Phong | 0 | 90 | 14 |
| `CV-12` | Tật Phong Tốc Hàng | Phong | 1 | 115 | 12 |
| `CV-13` | Thánh Linh Khoan Thứ | Quỷ | 2 | 130 | 8 |
| `CV-14` | Thiên Nộ | Điện | 3 | 175 | 5 |

### Chủng Mãnh Thú

| Mã | Skill | Hệ | Tier | Power | PP |
| --- | --- | --- | ---: | ---: | ---: |
| `CV-15` | Phác Giảo | Thổ | 0 | 95 | 25 |
| `CV-16` | Tê Liệt Kích | Điện | 0 | 90 | 20 |
| `CV-17` | Nộ Ý Cuồng Bạo | Hỏa | 1 | 110 | 14 |
| `CV-18` | Tứ Ngược Trùng Phong | Thổ | 2 | 140 | 8 |
| `CV-19` | Cuồng Bạo Tê Hống | Hỏa | 3 | 160 | 5 |

### Chủng Hải Dương

| Mã | Skill | Hệ | Tier | Power | PP |
| --- | --- | --- | ---: | ---: | ---: |
| `CV-20` | Thủy Trụ | Thủy | 0 | 90 | 22 |
| `CV-21` | Tiên Xạ Thủy Lãng | Thủy | 0 | 100 | 20 |
| `CV-22` | Thủy Cầu Áp Sát | Thủy | 1 | 110 | 12 |
| `CV-23` | Phún Xạ Thủy Trụ | Thủy | 2 | 145 | 8 |
| `CV-24` | Hải Thần Phục Cừu | Quỷ | 3 | 185 | 5 |

## III. Power và PP chuẩn hóa — 4 Skill đặc biệt Cầu Vồng

| Mã | Skill | Hệ/Bể | Tier | Power | PP |
| --- | --- | --- | ---: | ---: | ---: |
| `CV-27` | Trị liệu sơ cấp | Phổ thông | 0 | 0 | 4 |
| `CV-28` | Trị liệu chuyên nghiệp | Phổ thông | 2 | 0 | 2 |
| `CV-29` | Tử Vong Chi Xúc | Quỷ | 3 | 250 | 1 |
| `CV-30` | Kỹ năng Phong Bế | Quỷ | 2 | 0 | 3 |

## IV. Điều chỉnh cơ chế đã duyệt sau review

Các luật dưới đây ghi đè cơ chế tương ứng trong v1. Power/PP đã được phản ánh trực tiếp trong các bảng phía trên.

| Mã | Skill | Cơ chế chính thức sau review |
| --- | --- | --- |
| `LH-12` | Đằng Phược | Power 75; đánh trúng chắc chắn gây Quấn Quanh trong 2 lượt. |
| `LH-22` | Bão cát | Power 75; 40% gây Mê Muội trong 2 lượt. |
| `LH-25` | Thạch phu thuật | Xóa toàn bộ debuff hiện có và miễn debuff mới trong 2 lượt. |
| `LH-39` | Ray lạnh | Power 135; gây Nhụt Chí, giảm 25% damage trong 3 lượt. |
| `LH-44` | Đoạt mệnh cao áp | Điện Áp 3 lượt: damage +40%; mỗi lần dùng Skill tiêu hao 2 PP thay vì 1. |
| `LH-51` | Chú oán | Power 85; giảm DEF 15% trong 2 lượt. |
| `LH-54` | Mị ảnh | Gây Quỷ Mị trong 1 lượt: mỗi Skill damage mục tiêu dùng có 40% bị dội ngược và không trúng đối phương. |
| `LH-57` | Chú Phược Quỷ Lao | Power 115; giảm DEF 30% trong 2 lượt. |
| `LH-65` | Vũ Liệt Thuật | Hai Skill damage tiếp theo đánh thêm một hit 60% Power; hit phụ không gây Effect. |
| `CV-12` | Tật Phong Tốc Hàng | Power 115; sau khi đánh trúng, Linh xảo +15% trong 2 lượt, không cộng dồn. |
| `CV-18` | Tứ Ngược Trùng Phong | Power 140; nếu đã nhận damage từ hành động trước, Power tăng thành 160. |
| `CV-21` | Tiên Xạ Thủy Lãng | Power 100; 25% hoàn lại 1 PP vừa tiêu hao sau khi đánh trúng. |
| `CV-22` | Thủy Cầu Áp Sát | Power 110; 60% gây Mị Hoặc trong 2 lượt. |

## V. Cân bằng hồi phục Mộc và Thực Vật

Mộc có năm đường hồi phục khác nhau, đều xuất phát từ cơ chế Skill đã tồn tại. Chúng không cộng thêm tài nguyên hoặc trạng thái mới.

| Mã | Skill | Cơ chế hồi phục v2 | Tổng giá trị và giới hạn |
| --- | --- | --- | --- |
| `LH-11` | Quang phản | Hồi 35% damage thực tế gây ra. | Tối đa 8% HP tối đa mỗi lần dùng. |
| `LH-13` | Thảo Chủng | Giữ đòn Thực Loại trễ 120 Power; khi phát nổ, người gieo hồi HP. | Hồi 8% HP tối đa khi phát nổ. |
| `LH-15` | Thảo nguyện thuật | Hồi ngay 8% HP, sau đó Khôi Phục 7% cuối mỗi lượt trong 3 lượt. | Tổng 29%; không cộng dồn, dùng lại chỉ làm mới thời lượng. |
| `LH-17` | Diệp chi ân huệ | Hồi 50% damage thực tế gây ra. | Tối đa 12% HP tối đa mỗi lần dùng. |
| `LH-19` | Quang hợp hiệu ứng | Đòn đầu 120 Power; Thực Loại phát nổ với 160 Power và hồi HP cho người gieo. | Hồi 12% HP tối đa khi damage trễ kích hoạt. |
| `CV-01` | Phong Lợi Tiêm Thứ | Nếu mục tiêu có Hủ Thực, hồi 35% damage thực; nếu chưa có, 30% gây Hủ Thực. | Hồi tối đa 8% HP mỗi lần dùng. |
| `CV-02` | Bạo Tạc Chủng Tử | Kích hoạt toàn bộ tick Hủ Thực còn lại, xóa Hủ Thực rồi hồi 50% damage kích nổ. | Hồi tối đa 12% HP. Không hồi nếu không có Hủ Thực để kích nổ. |
| `CV-04` | Thực Vật Phong Bạo | Gây Hủ Thực chắc chắn, kích hoạt tick đầu ngay và hồi 50% damage của tick đó. | Hồi tối đa 5% HP. |

### Vì sao Mộc không còn nghèo hồi phục

| Giai đoạn | Nguồn hồi | Đặc điểm chiến thuật |
| --- | --- | --- |
| Đầu trận | Quang phản | Hút máu nhỏ nhưng ổn định, không cần setup. |
| Giữa trận | Thảo Chủng | Chấp nhận chờ để nhận damage trễ và hồi cố định. |
| Phòng thủ | Thảo nguyện thuật | Hồi tức thời để chống kết liễu và hồi theo lượt để duy trì. |
| Cuối trận | Diệp chi ân huệ | Hút máu mạnh, nhưng Power thấp hơn Skill damage thuần cùng Tier. |
| Tuyệt kỹ | Quang hợp hiệu ứng | Đòi hỏi sống đủ lâu để nhận damage và hồi bùng nổ trễ. |
| Bể Chủng | Ba Skill Thực Vật | Hủ Thực trở thành chuỗi setup → duy trì → kích nổ/hồi phục. |

Mộc vẫn có nhược điểm rõ: hồi phục cần gây trúng damage hoặc chờ trạng thái phát nổ; không có miễn nhiễm mạnh như Thổ, phản xạ như Thủy hay khả năng kết liễu nhanh như Hỏa/Quỷ.

## VI. Điều chỉnh hồi phục ngoài Mộc

Các hệ/chủng khác chỉ có hồi phục phụ để không lấn bản sắc Mộc:

| Mã | Skill | Cơ chế v2 |
| --- | --- | --- |
| `LH-34` | Thuật cầu nguyện | Hồi ngay 10% HP tối đa trước khi nhận Vô Hình. |
| `LH-58` | Quỷ độc tín ngưỡng | Hồi 35% damage thực gây ra, tối đa 12% HP tối đa. |
| `CV-23` | Phún Xạ Thủy Trụ | Hồi 30% damage thực gây ra, tối đa 10% HP tối đa. |
| `CV-27` | Trị liệu sơ cấp | Hồi 25% HP tối đa, 4 PP. |
| `CV-28` | Trị liệu chuyên nghiệp | Hồi 50% HP tối đa, 2 PP. |

## VII. Các chốt chống lạm dụng

- Khôi Phục không cộng dồn; dùng lại chỉ làm mới thời lượng.
- Hút HP không thể hồi vượt HP tối đa và không kích hoạt nếu đòn đánh trượt hoặc gây 0 damage.
- Damage trễ chỉ hồi cho Pet đã tạo trạng thái; nếu Pet đó bị hạ trước lúc kích nổ thì không có hồi phục.
- Kích nổ Hủ Thực chỉ hồi theo damage thực tế của phần bị kích nổ, không tính damage của đòn đánh cơ sở lần hai.
- PP thấp của hồi mạnh khiến người chơi phải lựa chọn thời điểm, không thể kéo dài trận vô hạn.
- Skill có Power điều kiện cao không đồng thời được hưởng mức Power cơ sở trần của cùng Tier.

## VIII. Kiểm tra biên thiết kế

- Tổng Skill được định danh trong bảng Power/PP: **99**.
- Liệt Hỏa: **70**; Cầu Vồng: **29**.
- Skill mới: **0**; Skill bị xóa: **0**; Skill đổi tên: **0**.
- Trạng thái mới: **0**; tài nguyên chiến đấu mới: **0**.
- Hệ Mộc có **5 Skill hệ** tạo hồi phục có ý nghĩa và Chủng Thực Vật có **3 Skill** tham gia chuỗi hồi phục Hủ Thực.
- Bản v2 này phải được audit 1v1 bằng chính deck của 202 Pet trước khi áp dụng chính thức; các con số là baseline cân bằng, chưa phải kết quả simulator cuối cùng.
