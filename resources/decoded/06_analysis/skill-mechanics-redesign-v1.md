# Thiết kế lại cơ chế 99 Skill — bản đề xuất v1

> Ngày 28/07/2026. Đây là bảng thiết kế để duyệt, chưa cập nhật database, seeder, Wiki hoặc simulator.

## Giới hạn thiết kế

- Giữ nguyên toàn bộ 99 Skill đang hoạt động: tên, ID, nguồn, artwork và animation.
- Không tạo Skill, hệ, chủng, chỉ số, tài nguyên chiến đấu hoặc trạng thái mới.
- Chỉ sử dụng cơ chế đã tồn tại trong hai game hoặc hệ thống hợp nhất: damage, PP, hồi HP, hồi PP, tăng/giảm chỉ số, phản damage, đánh lặp, hút HP, thanh tẩy, miễn nhiễm, đánh cắp buff, xuyên DEF và các Effect đã giải mã.
- Không đưa trở lại năng lượng Cầu Vồng; PP vẫn là tài nguyên duy nhất của Skill.
- Không dùng chí mạng, cooldown, mana, nộ khí, thời tiết, địa hình, combo point hoặc lớp khiên mới.

## Ngân sách chung

| Tier | Pure damage tham chiếu | Hybrid tham chiếu | PP phổ biến |
| ---: | ---: | ---: | ---: |
| 0 | 90–100 | 60–90 | 30–45 |
| 1 | 105–120 | 80–110 | 20–30 |
| 2 | 130–150 | 110–140 | 15–25 |
| 3 | 170–200 | 125–180 | 8–15 |

Skill hồi phục, buff và hard-control dùng Power 0, PP thấp hơn và phải dành một lượt để thi triển.

## Luật trạng thái dùng chung

| Trạng thái | Luật v1 |
| --- | --- |
| Gieo Hạt | Mất 3% HP tối đa ở đầu mỗi lượt mục tiêu, kéo dài 3 lượt. |
| Mê Muội | Linh xảo −20% trong 2 lượt mục tiêu. |
| Quấn Quanh | Không đổi Pet/dùng Item và DEF −10% trong 2 lượt mục tiêu. |
| Thực Loại | Sau 2 lượt mục tiêu nhận một đòn damage trễ có Power do Skill quy định. |
| Mục | Giảm chính xác theo mức ghi trên Skill. |
| Chậm Chạp | Giảm Linh xảo theo mức ghi trên Skill. |
| Nhụt Chí | Giảm damage gây ra theo mức ghi trên Skill. |
| Phòng Ngự bất lợi | Giảm DEF theo mức ghi trên Skill. |
| Quỷ Mị | Skill damage có 40% bị phản lại người sử dụng. |
| Hỗn Loạn | Mất quyền chọn Skill trong một hành động; Skill damage có 50% tự đánh mình. |
| Tê Liệt | Linh xảo −20% và không thể tạo hit phụ/đánh lặp trong 2 lượt. |
| Hủ Thực | Mất lần lượt 3%, 6%, 9% HP tối đa qua 3 lượt. |
| Thạch Hóa bất lợi | Mất hành động kế tiếp; damage nhận giảm 30% cho đến khi hành động bị mất. |
| Giam Cầm | Không đổi Pet/dùng Item và Linh xảo −15% trong 2 lượt. |
| Mị Hoặc | Damage gây ra −15%; hiệu quả bắt tăng 25%, kéo dài 3 lượt nếu Skill không ghi khác. |
| Phong Bế | Không dùng được Skill Tier 2–3 trong 2 lượt. |

## Quy tắc áp dụng Effect

- Effect của Skill gây damage chỉ được xét sau khi đòn đánh trúng.
- Cùng một buff/debuff không cộng dồn, chỉ làm mới thời lượng, trừ **Phòng ngự** ghi rõ tối đa 3 tầng.
- Thạch Hóa và Phong Bế không thể được làm mới khi đang còn hiệu lực.
- Thời lượng tính theo lượt hành động của mục tiêu chịu trạng thái.
- Hit phụ của đánh lặp không áp dụng Effect lần hai.
- Hút HP tính trên damage thực tế sau giảm trừ và luôn có trần ghi trong Skill.
- Preview Wiki vẫn được phép cưỡng chế Effect để người xem thấy animation; luật xác suất chỉ áp dụng trong chiến đấu thật.

## I. 70 Skill Liệt Hỏa

### Hệ Hỏa

> Bùng nổ, Gieo Hạt, Mê Muội và đánh đổi phòng thủ lấy sát thương.

| Mã | Skill | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `LH-00` | Hỏa trảo | 0 | 100 | 45 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Đòn cơ bản ổn định. |
| `LH-01` | Dương viêm | 0 | 70 | 40 | Hybrid | 1 đối thủ | Đánh trúng chắc chắn gây Gieo Hạt trong 3 lượt mục tiêu. | Mở combo Thiêu Đốt. |
| `LH-02` | Diễm kích | 0 | 95 | 35 | Khống chế | 1 đối thủ | 20% gây Mê Muội trong 2 lượt mục tiêu. | Đòn gây rối sớm. |
| `LH-03` | Hỏa Vân triệu | 1 | 110 | 25 | Tấn công điều kiện | 1 đối thủ | Nếu mục tiêu có Gieo Hạt, Power tăng thành 145; không xóa trạng thái. | Khai thác Gieo Hạt. |
| `LH-04` | Thiên Hỏa tế | 1 | 0 | 10 | Buff | Bản thân/đồng minh | Súc Lực: DEF +30%; Skill gây damage kế tiếp đạt ×1,9 Power rồi buff kết thúc. | Chuẩn bị một đòn bùng nổ. |
| `LH-05` | Viêm lôi phá | 1 | 0 | 8 | Buff đánh đổi | Bản thân | Phá Phủ 3 lượt: damage gây ra +50%, DEF −50%. | Mạo hiểm để tăng áp lực. |
| `LH-06` | Hỏa diễm đao | 2 | 150 | 25 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Damage ổn định bậc cao. |
| `LH-07` | Chước nhiệt chi xúc | 2 | 100 | 20 | Kích nổ | 1 đối thủ | Nếu mục tiêu có Gieo Hạt, gây ngay toàn bộ số tick còn lại rồi xóa Gieo Hạt; nếu chưa có thì đặt Gieo Hạt. | Chọn đặt hoặc kích nổ DoT. |
| `LH-08` | Liệt diễm phong bạo | 3 | 175 | 12 | Hybrid | 1 đối thủ | 25% gây Mê Muội trong 2 lượt mục tiêu. | Damage diện áp lực cao nhưng thấp hơn tuyệt kỹ thuần. |
| `LH-09` | Vĩnh hằng hỏa ảnh | 3 | 190 | 10 | Kết liễu điều kiện | 1 đối thủ | Nếu mục tiêu có Gieo Hạt, Power tăng thành 250 và xóa Gieo Hạt. | Tuyệt kỹ kết thúc combo Hỏa. |

### Hệ Mộc

> Hồi phục, Quấn Quanh, Thực Loại và chuyển damage thành HP.

| Mã | Skill | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `LH-10` | Diệp Toàn | 0 | 100 | 45 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Đòn cơ bản ổn định. |
| `LH-11` | Quang phản | 0 | 85 | 35 | Hút sinh lực | 1 đối thủ | Hồi bằng 25% damage thực gây ra, tối đa 6% HP tối đa mỗi lần. | Nguồn hồi nhỏ nhưng đều. |
| `LH-12` | Đằng Phược | 0 | 60 | 25 | Khống chế | 1 đối thủ | Đánh trúng chắc chắn gây Quấn Quanh trong 2 lượt mục tiêu. | Khóa đổi Pet/Item và giảm 10% DEF. |
| `LH-13` | Thảo Chủng | 1 | 60 | 20 | Sát thương trễ | 1 đối thủ | Gây Thực Loại: sau 2 lượt mục tiêu nhận một đòn 120 Power; khi phát nổ, người gieo hồi 5% HP tối đa. | Gieo hạt và duy trì sinh lực. |
| `LH-14` | Đằng chi bích lũy | 1 | 0 | 10 | Phòng thủ | Bản thân/đồng minh | Kinh Cức 3 lượt: DEF +30%, phản lại 10% damage thực nhận. | Bảo vệ và phản đòn. |
| `LH-15` | Thảo nguyện thuật | 1 | 0 | 10 | Hồi phục | Bản thân/đồng minh | Hồi ngay 5% HP tối đa, sau đó Khôi Phục 5% cuối mỗi lượt trong 3 lượt. | Tổng hồi 20%, không cộng dồn. |
| `LH-16` | Châm Diệp Trảm | 2 | 150 | 25 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Đòn Mộc mạnh không cần setup. |
| `LH-17` | Diệp chi ân huệ | 2 | 120 | 20 | Hút sinh lực | 1 đối thủ | Hồi bằng 40% damage thực gây ra, tối đa 10% HP tối đa. | Phiên bản hút HP mạnh hơn Quang Phản. |
| `LH-18` | Đằng mạn triền nhiễu | 3 | 135 | 12 | Tấn công điều kiện | 1 đối thủ | Gây Quấn Quanh 2 lượt; nếu mục tiêu đã Quấn Quanh thì Power thành 170 thay vì làm mới trạng thái. | Thưởng cho việc duy trì khống chế. |
| `LH-19` | Quang hợp hiệu ứng | 3 | 130 | 10 | Sát thương trễ/Hồi phục | 1 đối thủ | Gây Thực Loại: sau 2 lượt nhận đòn 160 Power; khi phát nổ, người gieo hồi 10% HP tối đa. | Tuyệt kỹ bào mòn và hồi phục. |

### Hệ Thổ

> Tích Phòng ngự, thanh tẩy, miễn nhiễm và phản công lên mục tiêu Mê Muội.

| Mã | Skill | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `LH-20` | Hất bụi | 0 | 100 | 45 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Đòn cơ bản ổn định. |
| `LH-21` | Thổ thuẫn | 0 | 75 | 35 | Hybrid | 1 đối thủ | Sau khi đánh trúng nhận 1 tầng Phòng ngự: DEF +10% trong 2 lượt, tối đa 3 tầng. | Tích giáp khi tấn công. |
| `LH-22` | Bão cát | 0 | 65 | 30 | Khống chế | 1 đối thủ | 35% gây Mê Muội trong 2 lượt mục tiêu. | Đòn gây rối sớm. |
| `LH-23` | Nham băng | 1 | 110 | 20 | Tấn công điều kiện | 1 đối thủ | Nếu mục tiêu đang Mê Muội, Power tăng thành 170; không xóa Mê Muội. | Phản công sau Bão Cát. |
| `LH-24` | Người bảo vệ Địa Giới | 1 | 0 | 8 | Thanh tẩy/Hồi phục | Toàn phe | Xóa 1 debuff trên mỗi mục tiêu rồi cho Khôi Phục 5% HP cuối lượt trong 3 lượt. | Giữ đúng công dụng giải trạng thái và hồi phục. |
| `LH-25` | Thạch phu thuật | 1 | 0 | 5 | Thanh tẩy/Miễn nhiễm | Bản thân/đồng minh | Xóa toàn bộ debuff hiện có và miễn debuff mới trong 3 lượt. | Phòng thủ trạng thái mạnh, PP thấp. |
| `LH-26` | Nham bạo | 2 | 150 | 25 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Damage Thổ ổn định. |
| `LH-27` | Hàng rào cát đá | 2 | 110 | 20 | Hybrid | 1 đối thủ | Sau khi đánh trúng nhận 2 tầng Phòng ngự; tổng vẫn tối đa 3 tầng và kéo dài 2 lượt. | Tích giáp nhanh hơn Thổ Thuẫn. |
| `LH-28` | Bão cát | 3 | 140 | 12 | Khống chế | 1 đối thủ | 50% gây Mê Muội trong 2 lượt mục tiêu. | Bản mạnh hơn của Bão Cát nhưng không trùng Power. |
| `LH-29` | Thổ Chi Loạn Vũ | 3 | 180 | 10 | Kết liễu điều kiện | 1 đối thủ | Nếu mục tiêu Mê Muội, Power tăng thành 250 và xóa Mê Muội. | Tiêu thụ trạng thái để kết liễu. |

### Hệ Thủy

> Giảm nhịp đối phương, phản xạ, giảm damage và hồi phục vừa phải.

| Mã | Skill | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `LH-30` | Bong bóng | 0 | 100 | 45 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Đòn cơ bản ổn định. |
| `LH-31` | Băng lao | 0 | 75 | 35 | Debuff | 1 đối thủ | Đánh trúng chắc chắn gây Mục: chính xác −15% trong 2 lượt mục tiêu. | Giảm độ ổn định của đối thủ. |
| `LH-32` | Tuyết ảnh | 0 | 75 | 35 | Debuff | 1 đối thủ | Đánh trúng chắc chắn gây Chậm Chạp: Linh xảo −15% trong 2 lượt. | Điều khiển thứ tự hành động. |
| `LH-33` | Thủy trụ | 1 | 100 | 25 | Debuff | 1 đối thủ | Đánh trúng chắc chắn gây Nhụt Chí: damage gây ra −15% trong 2 lượt. | Giảm áp lực tấn công. |
| `LH-34` | Thuật cầu nguyện | 1 | 0 | 8 | Hồi phục/Phản xạ | Bản thân/đồng minh | Hồi 8% HP tối đa rồi nhận Vô Hình 2 lượt: mỗi đòn đến có 30% phản toàn bộ damage về người đánh. | Hồi nhẹ và phòng thủ xác suất. |
| `LH-35` | Thủy bích | 1 | 0 | 8 | Phòng thủ | Bản thân/đồng minh | Kiên Nhẫn 3 lượt: mỗi đòn đến có 50% giảm một nửa damage thực nhận. | Giữ nguyên cơ chế xác suất gốc. |
| `LH-36` | Bạo Phong Tuyết | 2 | 150 | 25 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Damage Thủy ổn định. |
| `LH-37` | Lá chắn gió tuyết | 2 | 115 | 20 | Debuff | 1 đối thủ | Gây Mục: chính xác −25% trong 3 lượt mục tiêu. | Bản mạnh hơn Băng Lao. |
| `LH-38` | Băng Phong Hãm Tịnh | 3 | 140 | 12 | Debuff | 1 đối thủ | Gây Chậm Chạp: Linh xảo −25% trong 3 lượt mục tiêu. | Khống chế tốc độ bậc cao. |
| `LH-39` | Ray lạnh | 3 | 140 | 12 | Debuff | 1 đối thủ | Gây Nhụt Chí: damage gây ra −25% trong 3 lượt mục tiêu. | Giảm sức tấn công bậc cao. |

### Hệ Điện

> Linh xảo, Tê Liệt, tiêu hao PP và phá trạng thái có lợi.

| Mã | Skill | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `LH-40` | Điện giật | 0 | 100 | 45 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Đòn cơ bản ổn định. |
| `LH-41` | Lôi thiểm | 0 | 90 | 35 | Khống chế | 1 đối thủ | 20% gây Tê Liệt trong 2 lượt mục tiêu. | Gây rối nhịp hành động. |
| `LH-42` | Nạp điện | 0 | 85 | 35 | Hybrid | 1 đối thủ | Sau khi đánh trúng, bản thân được Linh Xảo +10% trong 2 lượt; không cộng dồn. | Tự tăng nhịp bằng tấn công. |
| `LH-43` | Sóng điện từ | 1 | 105 | 25 | Gây rối | 1 đối thủ | Nếu đánh trúng, xóa 1 trạng thái có lợi của mục tiêu. | Phá buff thay vì tăng Power thuần. |
| `LH-44` | Đoạt mệnh cao áp | 1 | 0 | 8 | Buff đánh đổi | Bản thân | Điện Áp 3 lượt: damage +30%, mỗi lần dùng Skill tiêu hao 2 PP thay vì 1. | Quá tải đúng logic gốc. |
| `LH-45` | Điện năng chuyển đổi | 1 | 0 | 8 | Buff đánh đổi | Bản thân | Hỏa Thạch 3 lượt: Linh xảo +50%, DEF −50%. | Đổi độ bền lấy quyền ra đòn trước. |
| `LH-46` | Tia lửa điện | 2 | 150 | 25 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Damage Điện ổn định. |
| `LH-47` | Chùm sấm sét | 2 | 130 | 20 | Khống chế | 1 đối thủ | 35% gây Tê Liệt trong 2 lượt mục tiêu. | Tê Liệt đáng tin cậy hơn Lôi Thiểm. |
| `LH-48` | Điện quang thạch hỏa | 3 | 140 | 12 | Hybrid | 1 đối thủ | Sau khi đánh trúng, Linh xảo +20% trong 2 lượt; không cộng dồn. | Damage và tăng tốc bậc cao. |
| `LH-49` | Cảm ứng điện từ | 3 | 170 | 10 | Tấn công điều kiện | 1 đối thủ | Xóa 1 buff của mục tiêu; nếu thực sự xóa được, Power của đòn tăng thành 200. | Tuyệt kỹ trừng phạt Pet dựa vào buff. |

### Hệ Quỷ

> Phá phòng, phản tác dụng, hút HP và kết liễu theo lượng HP thiếu.

| Mã | Skill | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `LH-50` | Ảnh thứ | 0 | 100 | 45 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Đòn cơ bản ổn định. |
| `LH-51` | Chú oán | 0 | 80 | 35 | Debuff | 1 đối thủ | Gây giảm Phòng ngự 20% trong 3 lượt mục tiêu. | Mở đường cho damage Quỷ. |
| `LH-52` | Quỷ độc | 0 | 80 | 35 | Tấn công/Hồi phục | 1 đối thủ | 25% xác suất hồi 10% HP tối đa sau khi gây damage. | Hồi phục xác suất đúng mô tả gốc. |
| `LH-53` | Cơn ác mộng | 1 | 110 | 20 | Kết liễu điều kiện | 1 đối thủ | Mỗi 1% HP mục tiêu đã mất cộng 0,8 Power, tối đa 190 Power. | Damage tăng dần khi đối thủ suy yếu. |
| `LH-54` | Mị ảnh | 1 | 0 | 6 | Khống chế phản phệ | 1 đối thủ | Gây Quỷ Mị trong 2 lượt: mỗi Skill damage mục tiêu dùng có 40% bị dội ngược vào chính nó và không trúng đối phương. | Giữ đúng phản phệ gốc. |
| `LH-55` | Hỗn loạn | 1 | 0 | 8 | Gây rối | 1 đối thủ | Trong hành động kế tiếp, mục tiêu dùng ngẫu nhiên một Skill còn PP; nếu là Skill damage có 50% đánh vào chính mình. | Mất quyền điều khiển nhưng không khóa cứng lượt. |
| `LH-56` | Độc ảnh thứ | 2 | 150 | 25 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Damage Quỷ ổn định. |
| `LH-57` | Chú Phược Quỷ Lao | 2 | 120 | 20 | Debuff | 1 đối thủ | Gây giảm Phòng ngự 30% trong 3 lượt mục tiêu. | Phá giáp mạnh hơn Chú Oán. |
| `LH-58` | Quỷ độc tín ngưỡng | 3 | 120 | 12 | Hút sinh lực | 1 đối thủ | Hồi bằng 30% damage thực gây ra, tối đa 10% HP tối đa. | Phiên bản hồi ổn định bậc cao. |
| `LH-59` | Lời nguyền cuối cùng | 3 | 170 | 8 | Kết liễu điều kiện | 1 đối thủ | Mỗi 1% HP mục tiêu đã mất cộng 0,9 Power, tối đa 250 Power. | Tuyệt kỹ kết liễu đúng mô tả gốc. |

### Hệ Phong

> Điều khiển Linh xảo, đánh lặp, đánh cắp buff và gia tăng Sức mạnh.

| Mã | Skill | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `LH-60` | Phong nhận | 0 | 100 | 45 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Đòn cơ bản ổn định. |
| `LH-61` | Phong áp | 0 | 80 | 35 | Debuff | 1 đối thủ | Gây Chậm Chạp: Linh xảo −15% trong 2 lượt mục tiêu. | Điều khiển tempo sớm. |
| `LH-62` | Thuận phong | 0 | 80 | 35 | Hybrid | 1 đối thủ | Sau khi đánh trúng, bản thân nhận Man Lực: Sức mạnh +10% trong 2 lượt. | Tấn công và tự cường hóa. |
| `LH-63` | Long quyển | 1 | 100 | 25 | Đánh lặp | 1 đối thủ | 20% đánh thêm lần hai ở 50% Power; đòn phụ không áp dụng Effect. | Giữ cơ chế đánh tiếp của game gốc. |
| `LH-64` | Nghịch Phong Đoạt | 1 | 0 | 5 | Đánh cắp buff | 1 đối thủ | Chuyển tối đa 2 trạng thái có lợi của mục tiêu sang người dùng, giữ thời lượng còn lại. | Thâu Thủ có giới hạn để tránh lấy toàn bộ thế trận. |
| `LH-65` | Vũ Liệt Thuật | 1 | 0 | 5 | Buff đánh lặp | Bản thân | Gia Tốc 2 lượt: hai Skill damage tiếp theo đánh thêm một hit 50% Power; hit phụ không gây Effect. | Hai lần công kích theo mô tả gốc. |
| `LH-66` | Yến Hồi Thiểm | 2 | 150 | 25 | Tấn công | 1 đối thủ | Damage thuần, không Effect. | Damage Phong ổn định. |
| `LH-67` | Phong Chi Tuyền Qua | 2 | 115 | 20 | Debuff | 1 đối thủ | Gây Chậm Chạp: Linh xảo −25% trong 3 lượt mục tiêu. | Giảm tốc bậc cao. |
| `LH-68` | Phong Chi Tí Hữu | 3 | 125 | 12 | Hybrid | 1 đối thủ | Sau khi đánh trúng, nhận Man Lực: Sức mạnh +20% trong 2 lượt. | Tự buff mạnh hơn Thuận Phong. |
| `LH-69` | Phi Yến Hoàn Sào | 3 | 150 | 10 | Đánh lặp | 1 đối thủ | 35% đánh thêm lần hai ở 70% Power; đòn phụ không áp dụng Effect. | Tuyệt kỹ đánh lặp. |

## II. 25 Skill theo Chủng Cầu Vồng

### Chủng Thực Vật

> Hủ Thực, hút HP và kích nổ trạng thái.

| Mã | Skill | Hệ | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `CV-00` | Triền Nhiễu | Mộc | 0 | 60 | 35 | Debuff setup | 1 đối thủ | Đánh trúng chắc chắn gây Hủ Thực trong 3 lượt. | Nguồn đặt Hủ Thực đáng tin cậy. |
| `CV-01` | Phong Lợi Tiêm Thứ | Mộc | 0 | 85 | 35 | Hút sinh lực | 1 đối thủ | Nếu mục tiêu Hủ Thực, hồi 25% damage thực gây ra, tối đa 6% HP; nếu chưa có, 20% gây Hủ Thực. | Khai thác trạng thái để hồi. |
| `CV-02` | Bạo Tạc Chủng Tử | Hỏa | 1 | 105 | 25 | Kích nổ | 1 đối thủ | Nếu mục tiêu Hủ Thực, gây ngay toàn bộ tick còn lại rồi xóa Hủ Thực. | Bạo tạc đúng tên Skill. |
| `CV-03` | Phi Diệp Đao Phong | Phong | 2 | 135 | 18 | Tấn công điều kiện | 1 đối thủ | Nếu mục tiêu Hủ Thực, đòn đánh bỏ qua 20% DEF; không xóa Hủ Thực. | Lựa chọn damage duy trì. |
| `CV-04` | Thực Vật Phong Bạo | Mộc | 3 | 155 | 10 | Hybrid | 1 đối thủ | Gây Hủ Thực chắc chắn và kích hoạt ngay tick đầu tiên. | Tuyệt kỹ bào mòn của Chủng. |

### Chủng Kim Loại

> Tích Phòng ngự, chuyển giáp thành damage, xuyên DEF và Thạch Hóa.

| Mã | Skill | Hệ | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `CV-05` | Thiết Chuy | Thổ | 0 | 75 | 35 | Khống chế | 1 đối thủ | 10% gây Thạch Hóa, làm mất hành động kế tiếp và giảm 30% damage nhận cho tới khi trạng thái kết thúc. | Khống chế sớm nhưng xác suất thấp. |
| `CV-06` | Thiết Phù Đồ | Thổ | 0 | 70 | 30 | Hybrid | 1 đối thủ | Sau khi đánh trúng nhận 1 tầng Phòng ngự +10% DEF trong 2 lượt, tối đa 3 tầng. | Tích giáp bằng tấn công. |
| `CV-07` | Bạo Liệt Vũ | Hỏa | 1 | 105 | 25 | Chuyển hóa giáp | 1 đối thủ | Tiêu thụ toàn bộ tầng Phòng ngự; mỗi tầng cộng 20 Power cho đòn này. | Đổi giáp lấy burst. |
| `CV-08` | Toản Thạch Thiết Cát | Điện | 2 | 130 | 18 | Xuyên phòng | 1 đối thủ | Bỏ qua 25% DEF của mục tiêu. | Cắt giáp bằng cơ chế xuyên phòng đã có. |
| `CV-09` | Kim Loại Liệt Trảm | Điện | 3 | 150 | 10 | Hybrid khống chế | 1 đối thủ | 25% gây Thạch Hóa; không thể làm mới khi mục tiêu đã Thạch Hóa. | Tuyệt kỹ khống chế của Kim Loại. |

### Chủng Phi Hành

> Ra đòn trước, Giam Cầm, tăng Linh xảo và tự thanh tẩy.

| Mã | Skill | Hệ | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `CV-10` | Phi Tường Trảm | Phong | 0 | 90 | 40 | Tấn công điều kiện | 1 đối thủ | Nếu người dùng hành động trước mục tiêu trong lượt, Power tăng thành 110. | Thưởng quyền tiên thủ. |
| `CV-11` | Bạo Phong Toàn Trận | Phong | 0 | 90 | 30 | Giam Cầm | 1 đối thủ | Gây Giam Cầm chắc chắn trong 2 lượt: không đổi Pet/dùng Item và Linh xảo −15%. | Kiểm soát vị trí, không khóa hành động. |
| `CV-12` | Tật Phong Tốc Hàng | Phong | 1 | 120 | 25 | Hybrid | 1 đối thủ | Sau khi đánh trúng, Linh xảo bản thân +15% trong 2 lượt; không cộng dồn. | Tăng tốc qua bổ nhào. |
| `CV-13` | Thánh Linh Khoan Thứ | Quỷ | 2 | 125 | 15 | Tấn công/Thanh tẩy | 1 đối thủ | Sau khi gây damage, xóa 1 debuff trên bản thân. | Khoan thứ bằng cơ chế thanh tẩy đã có. |
| `CV-14` | Thiên Nộ | Điện | 3 | 170 | 8 | Hybrid khống chế | 1 đối thủ | 25% gây Giam Cầm trong 2 lượt; nếu hành động trước, xác suất tăng thành 40%. | Tuyệt kỹ tận dụng tiên thủ. |

### Chủng Mãnh Thú

> Áp lực liên tục, Tê Liệt và tăng damage khi bị thương hoặc khi con mồi suy yếu.

| Mã | Skill | Hệ | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `CV-15` | Phác Giảo | Thổ | 0 | 90 | 40 | Tấn công điều kiện | 1 đối thủ | Nếu mục tiêu dưới 50% HP, Power tăng thành 110. | Bản năng săn con mồi yếu. |
| `CV-16` | Tê Liệt Kích | Điện | 0 | 85 | 35 | Khống chế | 1 đối thủ | 25% gây Tê Liệt trong 2 lượt. | Đòn gây rối đặc trưng. |
| `CV-17` | Nộ Ý Cuồng Bạo | Hỏa | 1 | 105 | 25 | Tấn công điều kiện | 1 đối thủ | Nếu người dùng dưới 50% HP, damage của đòn tăng 30%. | Cuồng nộ khi bị thương. |
| `CV-18` | Tứ Ngược Trùng Phong | Thổ | 2 | 135 | 18 | Phản công | 1 đối thủ | Nếu người dùng đã nhận damage kể từ hành động trước, Power tăng thành 170. | Chuyển việc bị đánh thành áp lực. |
| `CV-19` | Cuồng Bạo Tê Hống | Hỏa | 3 | 155 | 10 | Hybrid | 1 đối thủ | 30% gây Tê Liệt; nếu người dùng dưới 35% HP, Power tăng thành 185. | Tuyệt kỹ cuồng nộ. |

### Chủng Hải Dương

> Mị Hoặc, hồi HP, hoàn PP và kết liễu theo trạng thái.

| Mã | Skill | Hệ | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `CV-20` | Thủy Trụ | Thủy | 0 | 85 | 40 | Hybrid | 1 đối thủ | 25% gây Mị Hoặc trong 3 lượt. | Giảm áp lực của đối phương. |
| `CV-21` | Tiên Xạ Thủy Lãng | Thủy | 0 | 100 | 35 | Quản lý PP | 1 đối thủ | 25% hoàn lại 1 PP vừa tiêu hao sau khi đánh trúng. | Dùng cơ chế Triều Tịch Năng Lượng gốc. |
| `CV-22` | Thủy Cầu Áp Sát | Thủy | 1 | 120 | 25 | Debuff | 1 đối thủ | 60% gây Mị Hoặc trong 2 lượt. | Bản Mị Hoặc đáng tin cậy hơn. |
| `CV-23` | Phún Xạ Thủy Trụ | Thủy | 2 | 140 | 18 | Hút sinh lực | 1 đối thủ | Hồi bằng 25% damage thực gây ra, tối đa 8% HP tối đa. | Duy trì sức chiến đấu. |
| `CV-24` | Hải Thần Phục Cừu | Quỷ | 3 | 180 | 10 | Kết liễu điều kiện | 1 đối thủ | Nếu mục tiêu Mị Hoặc, Power tăng thành 220 và xóa Mị Hoặc. | Tuyệt kỹ phục cừu theo trạng thái. |

## III. 4 Skill đặc biệt Cầu Vồng

| Mã | Skill | Hệ/Bể | Tier | Power | PP | Loại | Mục tiêu | Cơ chế mới | Vai trò |
| --- | --- | --- | ---: | ---: | ---: | --- | --- | --- | --- |
| `CV-27` | Trị liệu sơ cấp | Phổ thông | 0 | 0 | 5 | Hồi phục | Bản thân/đồng minh | Hồi 25% HP tối đa. | Hồi trực tiếp cơ bản; giới hạn PP để không kéo dài 1v1. |
| `CV-28` | Trị liệu chuyên nghiệp | Phổ thông | 2 | 0 | 3 | Hồi phục | Bản thân/đồng minh | Hồi 50% HP tối đa. | Hồi mạnh nhưng chỉ dùng 3 lần. |
| `CV-29` | Tử Vong Chi Xúc | Quỷ | 3 | 250 | 1 | Tuyệt kỹ | 1 đối thủ | Sau khi dùng, PP hiện tại của toàn bộ Skill đang mang trở về 0. | Giữ nguyên đánh đổi toàn bộ tài nguyên gốc. |
| `CV-30` | Kỹ năng Phong Bế | Quỷ | 2 | 0 | 3 | Khống chế | 1 đối thủ | 60% gây Phong Bế trong 2 lượt: không dùng được Skill Tier 2–3. | Khóa Skill mạnh nhưng không bảo đảm thành công. |

## IV. Kiểm tra biên thiết kế

- Tổng số Skill trong bảng: **99**.
- Liệt Hỏa: **70**.
- Cầu Vồng theo Chủng: **25**.
- Cầu Vồng đặc biệt: **4**.
- Skill mới: **0**.
- Trạng thái mới: **0**.
- Tài nguyên chiến đấu mới: **0**.
- Mọi cơ chế đều truy được về mô tả Skill, buff/debuff, Skill đặc biệt, bị động Cầu Vồng, Đặc tính Chủng hoặc thuật toán chiến đấu đã có.

