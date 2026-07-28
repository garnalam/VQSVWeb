# Review từng Skill theo thiết kế cân bằng v2

> Review lý thuyết ngày 28/07/2026. Mười ba điều chỉnh đề xuất đã được duyệt và hợp nhất vào `skill-mechanics-redesign-v2.md`. Chưa cập nhật database hoặc runtime; kết luận cuối cùng vẫn phải dựa trên audit 1v1 bằng deck thực tế của 202 Pet.

## Quy ước đánh giá

- **Giữ:** ngân sách Power/PP và cơ chế đã hợp lý để đưa vào vòng mô phỏng.
- **Theo dõi:** thiết kế hợp lý nhưng có độ biến động hoặc tiềm năng kéo trận cao; chỉ chỉnh khi simulator xác nhận.
- **Chỉnh nhẹ:** đã thấy chênh lệch ngay trên giá trị một lượt hoặc điều kiện kích hoạt; nên sửa trước khi audit.
- **Giới hạn phân bổ:** bản thân Skill có thể giữ, nhưng phải kiểm soát Pet nào được học trong 1v1.

## I. Review 70 Skill theo 7 Hệ

### Hệ Hỏa

| Mã | Skill | Power/PP | Đánh giá | Nhận xét |
| --- | --- | ---: | --- | --- |
| `LH-00` | Hỏa trảo | 100/30 | **Giữ** | Chuẩn damage Tier 0, dùng làm mốc so sánh cho toàn bộ Skill mở đầu. |
| `LH-01` | Dương viêm | 75/18 | **Giữ** | 75 Power đổi lấy Gieo Hạt chắc chắn; tổng 9% HP tối đa qua 3 lượt đủ giá trị nhưng không bùng nổ ngay. |
| `LH-02` | Diễm kích | 95/20 | **Giữ** | Gần damage thuần nhưng Mê Muội chỉ có 20%; đúng vai trò gây rối nhẹ đầu trận. |
| `LH-03` | Hỏa Vân triệu | 115/14 | **Giữ** | 145 Power khi mục tiêu có Gieo Hạt là phần thưởng hợp lý sau một lượt setup và không tự tạo combo. |
| `LH-04` | Thiên Hỏa tế | 0/5 | **Theo dõi** | DEF +30% bù lượt chuẩn bị; đòn kế ×1,9 tạo burst lớn nhưng trung bình hai lượt chưa vượt hai lần tấn công thông thường quá xa. |
| `LH-05` | Viêm lôi phá | 0/4 | **Giữ** | Ba lượt +50% damage nhưng DEF −50% tạo đánh đổi thật; phù hợp Pet nhanh hoặc lối chơi liều lĩnh. |
| `LH-06` | Hỏa diễm đao | 155/12 | **Giữ** | Damage thuần Tier 2 đạt trần, không kèm Effect nên hợp lệ. |
| `LH-07` | Chước nhiệt chi xúc | 105/10 | **Giữ** | Power thấp để đổi lấy khả năng vừa đặt vừa kích nổ Gieo Hạt; linh hoạt nhưng không tự sinh lợi nếu dùng đơn lẻ. |
| `LH-08` | Liệt diễm phong bạo | 175/6 | **Giữ** | 175 Power và 25% Mê Muội nằm đúng đáy ngân sách Tier 3 có Effect. |
| `LH-09` | Vĩnh hằng hỏa ảnh | 195/5 | **Theo dõi** | 195 Power đã mạnh khi không setup; ngưỡng 250 có tiêu thụ Gieo Hạt là hợp lý nhưng cần kiểm tra Pet Hỏa có Sức mạnh cao. |

**Nhận xét Hỏa:** đường chơi đã rõ: đặt Gieo Hạt, khai thác hoặc tiêu thụ để kết liễu. Không có Skill yếu rõ ràng; `LH-04` và `LH-09` cần theo dõi burst.

### Hệ Mộc

| Mã | Skill | Power/PP | Đánh giá | Nhận xét |
| --- | --- | ---: | --- | --- |
| `LH-10` | Diệp Toàn | 100/30 | **Giữ** | Damage cơ bản ổn định, cần thiết cho Pet Mộc không muốn phụ thuộc hồi phục hoặc setup. |
| `LH-11` | Quang phản | 90/22 | **Giữ** | Hút 35% damage, trần 8% HP tạo hồi nhỏ đều đặn; Power 90 giúp không lấn át Diệp Toàn. |
| `LH-12` | Đằng Phược | 65/16 | **Chỉnh nhẹ** | Trong 1v1, cấm đổi Pet/Item ít giá trị; phần hữu dụng chủ yếu là DEF −10%. Nên tăng Power **65 → 75**. |
| `LH-13` | Thảo Chủng | 65/12 | **Theo dõi** | Tổng 65 Power tức thời + 120 Power trễ + hồi 8% rất đáng giá, nhưng phải chờ hai lượt và có nguy cơ mất hồi nếu bị hạ. |
| `LH-14` | Đằng chi bích lũy | 0/6 | **Giữ** | DEF +30% và phản 10% trong 3 lượt đủ bù lượt chuẩn bị, không biến thành nguồn damage chính. |
| `LH-15` | Thảo nguyện thuật | 0/5 | **Theo dõi** | Tổng hồi 29% đã giải quyết sự nghèo hồi phục; quy tắc không cộng dồn và chỉ 5 PP ngăn spam vô hạn. |
| `LH-16` | Châm Diệp Trảm | 155/12 | **Giữ** | Damage thuần Tier 2 để Pet Mộc có phương án gây áp lực trực tiếp. |
| `LH-17` | Diệp chi ân huệ | 125/10 | **Giữ** | Hút 50% damage nhưng trần 12% HP; Power thấp hơn đòn thuần 30 điểm là mức đánh đổi hợp lý. |
| `LH-18` | Đằng mạn triền nhiễu | 140/6 | **Giữ** | Lần đầu tạo Quấn Quanh, lần sau đạt 170 Power nhưng không làm mới; cơ chế buộc người chơi chọn damage hoặc duy trì trạng thái. |
| `LH-19` | Quang hợp hiệu ứng | 120/5 | **Theo dõi chặt** | Tổng 280 Power theo thời gian kèm hồi 12% là gói giá trị lớn nhất Mộc. Nếu vượt chuẩn, chỉ giảm damage trễ **160 → 145**, không giảm đồng thời hồi phục. |

**Nhận xét Mộc:** đã có hồi phục xuyên suốt đầu–giữa–cuối trận. Điểm yếu còn giữ được là damage cần thời gian và có thể bị kết liễu trước khi hồi trễ xảy ra.

### Hệ Thổ

| Mã | Skill | Power/PP | Đánh giá | Nhận xét |
| --- | --- | ---: | --- | --- |
| `LH-20` | Hất bụi | 100/30 | **Giữ** | Mốc damage Tier 0 chuẩn. |
| `LH-21` | Thổ thuẫn | 80/20 | **Giữ** | Mỗi lần chỉ nhận 10% DEF, cần ba lượt mới đạt trần; Power 80 ngăn việc vừa tích giáp vừa gây damage cao. |
| `LH-22` | Bão cát | 70/18 | **Chỉnh nhẹ** | 35% Mê Muội chỉ giảm Linh xảo nên chưa đủ bù Power 70 và combo Nham Băng thiếu ổn định. Nên dùng **75 Power, 40% Mê Muội**. |
| `LH-23` | Nham băng | 115/12 | **Giữ** | 170 Power khi mục tiêu Mê Muội là thưởng combo hợp lý vì cần Skill khác mở trạng thái. |
| `LH-24` | Người bảo vệ Địa Giới | 0/5 | **Giữ** | Trong 1v1 là xóa một debuff + hồi 15% qua 3 lượt; thấp hơn hồi Mộc và đúng bản sắc bảo hộ. |
| `LH-25` | Thạch phu thuật | 0/4 | **Chỉnh nhẹ** | Xóa toàn bộ debuff và miễn nhiễm 3 lượt có thể vô hiệu hóa hoàn toàn deck trạng thái. Nên giữ thanh tẩy nhưng giảm miễn nhiễm **3 → 2 lượt**. |
| `LH-26` | Nham bạo | 155/12 | **Giữ** | Damage thuần Tier 2, không Effect. |
| `LH-27` | Hàng rào cát đá | 115/8 | **Giữ** | Hai tầng DEF đổi lấy 40 Power so với đòn thuần; mạnh đúng vai trò Guardian nhưng vẫn bị giới hạn ba tầng. |
| `LH-28` | Bão cát | 145/6 | **Giữ** | 50% Mê Muội với Power ở trần hybrid Tier 3; Effect là giảm tốc chứ không khóa lượt. |
| `LH-29` | Thổ Chi Loạn Vũ | 185/5 | **Theo dõi** | 250 Power khi tiêu thụ Mê Muội là finisher mạnh; độ ổn định phụ thuộc `LH-22`/`LH-28`, nên chưa cần giảm trước audit. |

**Nhận xét Thổ:** vẫn mạnh trong trận dài nhưng không còn được tích DEF miễn phí. Hai điểm phải sửa trước audit là độ tin cậy của Bão Cát thấp và thời gian miễn nhiễm của Thạch Phu Thuật quá dài.

### Hệ Thủy

| Mã | Skill | Power/PP | Đánh giá | Nhận xét |
| --- | --- | ---: | --- | --- |
| `LH-30` | Bong bóng | 100/30 | **Giữ** | Damage cơ bản chuẩn. |
| `LH-31` | Băng lao | 80/20 | **Giữ** | Chính xác −15% trong 2 lượt có thể gây hụt đòn mạnh nên Power 80 là hợp lý. |
| `LH-32` | Tuyết ảnh | 80/20 | **Giữ** | Giảm Linh xảo ổn định, cho Pet Thủy chậm quyền tranh lượt nhưng không khóa hành động. |
| `LH-33` | Thủy trụ | 105/15 | **Theo dõi** | Damage −15% trong 2 lượt là debuff tốt hơn giảm tốc; Power 105 vẫn hợp Tier 1 nhưng có thể tạo vòng phòng thủ dai. |
| `LH-34` | Thuật cầu nguyện | 0/5 | **Theo dõi chặt** | Hồi 10% và 30% phản toàn bộ mỗi đòn trong 2 lượt có độ biến động cao; cần đo tỷ lệ lật kèo và số hiệp kéo dài. |
| `LH-35` | Thủy bích | 0/5 | **Giữ** | 50% cơ hội giảm nửa damage tương đương trung bình giảm 25%; phải mất lượt dựng nên không quá lời. |
| `LH-36` | Bạo Phong Tuyết | 155/12 | **Giữ** | Damage thuần Tier 2. |
| `LH-37` | Lá chắn gió tuyết | 120/9 | **Theo dõi** | Chính xác −25% trong 3 lượt tạo RNG lớn nhưng Power đã giảm 35 so với đòn thuần. |
| `LH-38` | Băng Phong Hãm Tịnh | 145/6 | **Giữ** | Giảm Linh xảo −25% không trực tiếp giảm damage; 145 Power phù hợp hybrid Tier 3. |
| `LH-39` | Ray lạnh | 145/6 | **Chỉnh nhẹ** | Damage đối thủ −25% trong 3 lượt giá trị cao hơn rõ rệt so với giảm tốc của `LH-38`. Nên giảm Power **145 → 135**. |

**Nhận xét Thủy:** vai trò làm chậm nhịp đối thủ đã rõ. `LH-34` cần simulator xử lý xác suất đúng; `LH-39` phải trả thêm Power cho debuff phòng thủ mạnh.

### Hệ Điện

| Mã | Skill | Power/PP | Đánh giá | Nhận xét |
| --- | --- | ---: | --- | --- |
| `LH-40` | Điện giật | 100/30 | **Giữ** | Damage cơ bản chuẩn. |
| `LH-41` | Lôi thiểm | 95/20 | **Giữ** | Tê Liệt 20% là hiệu ứng nhẹ và không khóa lượt; Power gần chuẩn là hợp lý. |
| `LH-42` | Nạp điện | 90/20 | **Giữ** | Linh xảo +10% trong 2 lượt tạo tempo nhỏ; không cộng dồn nên khó snowball. |
| `LH-43` | Sóng điện từ | 110/14 | **Giữ** | Khi mục tiêu không có buff vẫn là đòn Tier 1 vừa phải; khi có buff mới tạo giá trị chiến thuật. |
| `LH-44` | Đoạt mệnh cao áp | 0/4 | **Chỉnh nhẹ** | +30% trong 3 lượt sau một lượt setup chỉ gần hòa damage với tấn công liên tục, lại tốn gấp đôi PP. Nên tăng bonus damage **30% → 40%**. |
| `LH-45` | Điện năng chuyển đổi | 0/4 | **Giữ** | Linh xảo +50% đổi DEF −50% là đánh đổi sắc nét, phù hợp Pet cần giành quyền kết liễu. |
| `LH-46` | Tia lửa điện | 155/12 | **Giữ** | Damage thuần Tier 2. |
| `LH-47` | Chùm sấm sét | 135/9 | **Giữ** | 35% Tê Liệt và giảm 20 Power so với đòn thuần là hợp lý. |
| `LH-48` | Điện quang thạch hỏa | 145/6 | **Giữ** | Tier 3 thấp Power hơn đòn thuần để đổi lấy Linh xảo +20%; không cộng dồn. |
| `LH-49` | Cảm ứng điện từ | 175/5 | **Giữ** | Chỉ đạt 200 Power khi thực sự xóa được buff; thưởng đúng cho đọc tình huống. |

**Nhận xét Điện:** bộ Skill cân đối nhất v2. Chỉ `LH-44` đang thiếu động lực sử dụng do vừa mất lượt vừa trả thêm PP.

### Hệ Quỷ

| Mã | Skill | Power/PP | Đánh giá | Nhận xét |
| --- | --- | ---: | --- | --- |
| `LH-50` | Ảnh thứ | 100/30 | **Giữ** | Damage cơ bản chuẩn. |
| `LH-51` | Chú oán | 85/20 | **Chỉnh nhẹ** | DEF −20% trong 3 lượt quá hiệu quả ở Tier 0 và làm mờ bản nâng cấp `LH-57`. Nên dùng **DEF −15% trong 2 lượt**. |
| `LH-52` | Quỷ độc | 85/20 | **Theo dõi** | 25% hồi 10% HP có giá trị kỳ vọng thấp nhưng có thể lật kèo; đúng bản sắc hồi phục thiếu ổn định của Quỷ. |
| `LH-53` | Cơn ác mộng | 115/12 | **Giữ** | Power tăng từ 115 đến 190 theo HP đã mất; mạnh khi kết liễu nhưng yếu đầu trận. |
| `LH-54` | Mị ảnh | 0/4 | **Chỉnh nhẹ** | Hai lượt với 40% tự phản Skill damage có thể làm đối thủ mất nhiều hành động và tự gây damage. Nên giữ 40% nhưng giảm **2 → 1 lượt**. |
| `LH-55` | Hỗn loạn | 0/5 | **Theo dõi chặt** | Chỉ tác động hành động kế tiếp nên không phải khóa cứng; tuy vậy kết quả ngẫu nhiên và 50% tự đánh cần đo độ biến động. |
| `LH-56` | Độc ảnh thứ | 155/12 | **Giữ** | Damage thuần Tier 2. |
| `LH-57` | Chú Phược Quỷ Lao | 125/8 | **Chỉnh nhẹ** | 125 Power + DEF −30% trong 3 lượt quá lời. Nên dùng **115 Power, DEF −30% trong 2 lượt**. |
| `LH-58` | Quỷ độc tín ngưỡng | 125/6 | **Giữ** | Power thấp ở Tier 3 đổi lấy hút 35%, trần 12%; mạnh duy trì nhưng không burst. |
| `LH-59` | Lời nguyền cuối cùng | 175/5 | **Giữ** | Power tối đa 250 chỉ đạt khi mục tiêu gần cạn HP; đúng vai trò finisher và không cần tạo trạng thái mới. |

**Nhận xét Quỷ:** bản sắc kết liễu và phản phệ tốt, nhưng debuff DEF và `Mị ảnh` đang quá hiệu quả trong 1v1 nếu giữ nguyên thời lượng v2.

### Hệ Phong

| Mã | Skill | Power/PP | Đánh giá | Nhận xét |
| --- | --- | ---: | --- | --- |
| `LH-60` | Phong nhận | 100/30 | **Giữ** | Damage cơ bản chuẩn. |
| `LH-61` | Phong áp | 85/20 | **Giữ** | Giảm Linh xảo −15% trong 2 lượt với Power 85 là gói Tier 0 hợp lý. |
| `LH-62` | Thuận phong | 85/20 | **Giữ** | Sức mạnh +10% trong 2 lượt, không cộng dồn; tăng áp lực từ từ chứ không burst. |
| `LH-63` | Long quyển | 105/14 | **Theo dõi** | Hit phụ 20% × 50% cho Power kỳ vọng khoảng 110; giá trị chính nằm ở biến động và tương tác buff. |
| `LH-64` | Nghịch Phong Đoạt | 0/4 | **Giữ** | Rất mạnh khi gặp Pet buff nhưng hoàn toàn mất giá trị nếu đối thủ không có buff; counter-pick đúng nghĩa. |
| `LH-65` | Vũ Liệt Thuật | 0/4 | **Chỉnh nhẹ** | Setup + hai đòn 150% tạo tổng damage xấp xỉ ba lần tấn công thường trong ba lượt, gần như không sinh lợi. Nên tăng hit phụ **50% → 60%**. |
| `LH-66` | Yến Hồi Thiểm | 155/12 | **Giữ** | Damage thuần Tier 2. |
| `LH-67` | Phong Chi Tuyền Qua | 120/8 | **Giữ** | Giảm Linh xảo −25% trong 3 lượt và Power 120 đúng ngân sách hybrid Tier 2. |
| `LH-68` | Phong Chi Tí Hữu | 130/6 | **Giữ** | Power thấp ở Tier 3 đổi lấy Sức mạnh +20% cho hai lượt sau; tạo nhịp snowball có giới hạn. |
| `LH-69` | Phi Yến Hoàn Sào | 155/5 | **Theo dõi** | Power kỳ vọng khoảng 193 khi tính 35% hit phụ 70%; đạt chuẩn tuyệt kỹ nhưng có độ biến động cao. |

**Nhận xét Phong:** đã hết tình trạng thiếu damage rõ rệt. `LH-65` cần lợi ích thực sau lượt setup; hai Skill đánh lặp phải được simulator xử lý hit phụ không kích hoạt Effect lần hai.

## II. Review 25 Skill theo 5 Chủng

### Chủng Thực Vật

| Mã | Skill | Hệ | Power/PP | Đánh giá | Nhận xét |
| --- | --- | --- | ---: | --- | --- |
| `CV-00` | Triền Nhiễu | Mộc | 60/15 | **Giữ** | Đặt Hủ Thực chắc chắn; 18% HP tối đa qua ba tick rất tốt trước Pet trâu nhưng cần thời gian và không cộng dồn. |
| `CV-01` | Phong Lợi Tiêm Thứ | Mộc | 90/20 | **Giữ** | Không có Hủ Thực thì chỉ 30% tạo trạng thái; có trạng thái mới hồi tối đa 8%, nên không thay thế hoàn toàn Quang Phản. |
| `CV-02` | Bạo Tạc Chủng Tử | Hỏa | 110/12 | **Theo dõi** | Kích nổ các tick còn lại và hồi tối đa 12% tạo swing lớn, nhưng phải setup và xóa Hủ Thực. |
| `CV-03` | Phi Diệp Đao Phong | Phong | 140/8 | **Giữ** | Xuyên 20% DEF chỉ khi mục tiêu Hủ Thực; lựa chọn damage duy trì thay vì kích nổ. |
| `CV-04` | Thực Vật Phong Bạo | Mộc | 160/5 | **Giữ** | Power thấp hơn tuyệt kỹ thuần, đổi lấy đặt Hủ Thực, tick đầu và hồi tối đa 5%; đủ mạnh nhưng không dồn hồi quá lớn. |

**Nhận xét Thực Vật:** năm Skill đã không còn là năm bản tăng số của cùng một Effect. Chủng này bổ sung hồi phục và bào mòn cho Mộc mà vẫn có nhánh Hỏa/Phong để phản công khắc hệ.

### Chủng Kim Loại

| Mã | Skill | Hệ | Power/PP | Đánh giá | Nhận xét |
| --- | --- | --- | ---: | --- | --- |
| `CV-05` | Thiết Chuy | Thổ | 80/20 | **Giữ** | 10% Thạch Hóa thấp, và mục tiêu được giảm 30% damage khi mất lượt nên Effect có cơ chế tự cân bằng. |
| `CV-06` | Thiết Phù Đồ | Thổ | 75/18 | **Giữ** | Tích một tầng DEF với Power thấp; là nhánh phòng thủ thay vì bản sao Thiết Chuy. |
| `CV-07` | Bạo Liệt Vũ | Hỏa | 110/12 | **Giữ** | Tối đa 170 Power khi tiêu ba tầng DEF; cần nhiều lượt tích và phải bỏ phòng thủ để đổi burst. |
| `CV-08` | Toản Thạch Thiết Cát | Điện | 135/8 | **Giữ** | Xuyên 25% DEF cho Kim Loại công kích nhưng không kèm khống chế; đúng Tier 2. |
| `CV-09` | Kim Loại Liệt Trảm | Điện | 155/5 | **Giữ** | 25% Thạch Hóa ở Tier 3 mạnh nhưng Power thấp, trạng thái không làm mới và còn giảm damage nhận của mục tiêu. |

**Nhận xét Kim Loại:** cân bằng tốt giữa tích giáp, tiêu giáp, xuyên giáp và khống chế. Chưa cần chỉnh trước simulator.

### Chủng Phi Hành

| Mã | Skill | Hệ | Power/PP | Đánh giá | Nhận xét |
| --- | --- | --- | ---: | --- | --- |
| `CV-10` | Phi Tường Trảm | Phong | 95/25 | **Giữ** | Pet nhanh đạt 110 Power, Pet chậm chỉ 95; thưởng đúng cho bản sắc tiên thủ. |
| `CV-11` | Bạo Phong Toàn Trận | Phong | 90/14 | **Giữ** | Giam Cầm chắc chắn nhưng trong 1v1 chủ yếu là giảm 15% Linh xảo; Power 90 phù hợp. |
| `CV-12` | Tật Phong Tốc Hàng | Phong | 125/12 | **Chỉnh nhẹ** | Vượt trần hybrid Tier 1 dù còn tăng Linh xảo +15%. Nên giảm Power **125 → 115**. |
| `CV-13` | Thánh Linh Khoan Thứ | Quỷ | 130/8 | **Giữ** | Thanh tẩy một debuff sau khi gây damage, không giúp thoát debuff trước khi ra đòn; Power 130 phù hợp Tier 2. |
| `CV-14` | Thiên Nộ | Điện | 175/5 | **Giữ** | Giam Cầm không khóa hành động; 25–40% theo quyền tiên thủ tạo bản sắc nhưng không vượt ngân sách tuyệt kỹ. |

**Nhận xét Phi Hành:** chỉ `CV-12` vượt ngân sách. Các Skill còn lại thưởng tốc độ mà không biến Linh xảo thành damage miễn phí.

### Chủng Mãnh Thú

| Mã | Skill | Hệ | Power/PP | Đánh giá | Nhận xét |
| --- | --- | --- | ---: | --- | --- |
| `CV-15` | Phác Giảo | Thổ | 95/25 | **Giữ** | 110 Power khi con mồi dưới 50% chỉ là finisher nhẹ, phù hợp Tier 0. |
| `CV-16` | Tê Liệt Kích | Điện | 90/20 | **Giữ** | 25% Tê Liệt và Power 90 đủ tạo lựa chọn gây rối đầu trận. |
| `CV-17` | Nộ Ý Cuồng Bạo | Hỏa | 110/14 | **Giữ** | Dưới 50% HP mới đạt khoảng 143 Power; có rủi ro bị kết liễu trước khi nhận thưởng. |
| `CV-18` | Tứ Ngược Trùng Phong | Thổ | 140/8 | **Chỉnh nhẹ** | Điều kiện “đã nhận damage từ hành động trước” gần như tự đạt trên Pet chậm; 170 Power quá dễ cho Tier 2. Nên giảm Power điều kiện **170 → 160**. |
| `CV-19` | Cuồng Bạo Tê Hống | Hỏa | 160/5 | **Theo dõi** | 30% Tê Liệt và 185 Power dưới 35% HP là tuyệt kỹ mạnh, nhưng điều kiện khiến người dùng ở vùng dễ bị hạ. |

**Nhận xét Mãnh Thú:** đã có đường săn mục tiêu yếu và cuồng nộ khi bị thương. Chỉ `CV-18` có điều kiện quá dễ kích hoạt đối với Pet chậm.

### Chủng Hải Dương

| Mã | Skill | Hệ | Power/PP | Đánh giá | Nhận xét |
| --- | --- | --- | ---: | --- | --- |
| `CV-20` | Thủy Trụ | Thủy | 90/22 | **Giữ** | 25% Mị Hoặc và Power 90 tạo debuff đầu trận vừa phải. |
| `CV-21` | Tiên Xạ Thủy Lãng | Thủy | 105/20 | **Chỉnh nhẹ** | Tier 0 đang vượt mốc damage thuần 100 dù còn 25% hoàn PP. Nên giảm Power **105 → 100**. |
| `CV-22` | Thủy Cầu Áp Sát | Thủy | 125/12 | **Chỉnh nhẹ** | 60% Mị Hoặc trong 2 lượt đã là Effect mạnh, Power 125 vượt ngân sách Tier 1. Nên giảm **125 → 110**. |
| `CV-23` | Phún Xạ Thủy Trụ | Thủy | 145/8 | **Theo dõi** | Power ở trần hybrid Tier 2 và hút tối đa 10% HP; hợp lý nhưng có thể đẩy Guardian Hải Dương kéo trận. |
| `CV-24` | Hải Thần Phục Cừu | Quỷ | 185/5 | **Giữ** | Chỉ đạt 220 Power khi tiêu thụ Mị Hoặc; thấp hơn finisher 250 của Hỏa/Thổ/Quỷ và đúng bản sắc bền bỉ. |

**Nhận xét Hải Dương:** `CV-21` và `CV-22` đang được trả quá nhiều Power cho khả năng quản lý PP/debuff. Nhánh hồi phục Tier 2 cần theo dõi trên Pet phòng thủ cao.

## III. Review 4 Skill đặc biệt Cầu Vồng

| Mã | Skill | Power/PP | Đánh giá | Nhận xét |
| --- | --- | ---: | --- | --- |
| `CV-27` | Trị liệu sơ cấp | 0/4 | **Giới hạn phân bổ** | Bốn lần hồi 25% tương đương tối đa 100% HP; chấp nhận được cho Support nhưng không nên trở thành Skill phổ thông cho mọi Pet 1v1. |
| `CV-28` | Trị liệu chuyên nghiệp | 0/2 | **Giới hạn phân bổ** | Hai lần hồi 50% cũng tương đương 100% HP và tạo swing lớn; chỉ nên cấp cho deck thiên hỗ trợ/phòng thủ có chủ đích. |
| `CV-29` | Tử Vong Chi Xúc | 250/1 | **Theo dõi chặt** | Xóa toàn bộ PP sau khi dùng là đánh đổi cực lớn, nhưng nhược điểm không còn ý nghĩa nếu Pet nhanh dùng 250 Power để kết liễu. Phải audit riêng theo Pet được học. |
| `CV-30` | Kỹ năng Phong Bế | 0/3 | **Giữ** | 60% khóa Tier 2–3 trong 2 lượt vẫn cho đối thủ dùng Tier 0–1; mạnh nhưng có đối sách và chỉ ba lần dùng. |

## IV. Kết luận review trước simulator

### Đã được duyệt và hợp nhất vào v2

| Mã | Thay đổi đề xuất |
| --- | --- |
| `LH-12` | Power 65 → 75. |
| `LH-22` | Power 70 → 75; Mê Muội 35% → 40%. |
| `LH-25` | Miễn debuff 3 → 2 lượt. |
| `LH-39` | Power 145 → 135. |
| `LH-44` | Bonus damage 30% → 40%. |
| `LH-51` | DEF −20%/3 lượt → DEF −15%/2 lượt. |
| `LH-54` | Quỷ Mị 2 → 1 lượt. |
| `LH-57` | Power 125 → 115; giảm DEF −30% còn 2 lượt. |
| `LH-65` | Hit phụ 50% → 60% Power. |
| `CV-12` | Power 125 → 115. |
| `CV-18` | Power điều kiện 170 → 160. |
| `CV-21` | Power 105 → 100. |
| `CV-22` | Power 125 → 110. |

### Theo dõi bằng audit, chưa chỉnh ngay

- Burst: `LH-04`, `LH-09`, `LH-29`, `CV-19`, `CV-29`.
- Hồi phục/kéo trận: `LH-13`, `LH-15`, `LH-19`, `LH-34`, `CV-02`, `CV-23`, `CV-27`, `CV-28`.
- RNG/đánh lặp/khống chế: `LH-37`, `LH-52`, `LH-55`, `LH-63`, `LH-69`.

### Tiêu chí audit tiếp theo

- So đúng bậc tiến hóa và cùng khoảng sức mạnh Pet.
- Mỗi Skill phải được test trong deck thực tế, không dùng một bộ Skill chung giả định.
- Theo dõi win rate, damage mỗi lượt, số hiệp trung bình, lượng HP hồi thực, PP còn lại và tỷ lệ Effect thực sự kích hoạt.
- Audit riêng các Pet có Sức mạnh/Linh xảo cao dùng finisher và Pet Guardian dùng hồi phục.
- Không nerf Pet Thần chỉ vì vượt ngưỡng Pet thường; phải đánh giá theo nhóm Thần riêng.
