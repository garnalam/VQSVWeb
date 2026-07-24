# Hệ thống hai Đặc tính cho 202 Pet — trait design v1

## Kết luận chốt

- Mỗi cá thể Pet có đúng **hai ô Đặc tính**, không chiếm một trong năm ô Skill.
- Ô 1 là **Tư chất thể chất**: khi cá thể được tạo, random đồng đều một trong 13 Tư chất; không phụ thuộc tên Pet, Hệ, Chủng, form hay nguồn nhận.
- Ô 2 là **Đặc tính chủng**: lấy từ Chủng của form hiện tại, không được đổi tự do.
- Hệ chiến đấu chỉ xử lý tương khắc nguyên tố. Chủng chỉ mở nhóm đặc tính; hai lớp không thay thế nhau.
- Bảng 202 Pet bên dưới chỉ phân bổ **Đặc tính chủng** cho từng form. Không tồn tại Tư chất thể chất mặc định theo loài.
- Năm Tư chất có lợi và năm Tư chất bất lợi có xác suất bằng nhau; Pet hiếm hoặc độc nhất cũng không có bảng xác suất ngầm khác.

## 1. Danh mục 13 Tư chất thể chất chung

| Mã | Tên | Cực tính | Luật chính xác |
|---|---|---|---|
| TC-00 | Bình hòa | Trung tính | Không cộng hoặc trừ chỉ số. |
| TC-01 | Khí lực suy yếu | Bất lợi | Sinh mệnh tối đa −8%. |
| TC-02 | Khí lực cường tráng | Có lợi | Sinh mệnh tối đa +8%. |
| TC-03 | Cơ lực suy giảm | Bất lợi | Sức mạnh cuối cùng −8%. |
| TC-04 | Cơ lực sung mãn | Có lợi | Sức mạnh cuối cùng +8%. |
| TC-05 | Ngoại xác rạn vỡ | Bất lợi | Phòng ngự cuối cùng −8%. |
| TC-06 | Ngoại xác vững chắc | Có lợi | Phòng ngự cuối cùng +8%. |
| TC-07 | Phản xạ chậm | Bất lợi | Linh xảo cuối cùng −8%. |
| TC-08 | Phản xạ linh hoạt | Có lợi | Linh xảo cuối cùng +8%. |
| TC-09 | Trao đổi trì trệ | Bất lợi | Mọi lượng hồi Sinh mệnh nhận được −25%. |
| TC-10 | Hồi phục tự nhiên | Có lợi | Cuối lượt hồi 2% Sinh mệnh tối đa; tạm ngừng khi đang Thiêu Đốt hoặc Hủ Thực; tổng hồi thụ động bị chặn ở 4% mỗi lượt. |
| TC-11 | Công kích dè dặt | Hỗn hợp | Sát thương gây ra −8%, độ chính xác kỹ năng +5 điểm phần trăm. |
| TC-12 | Công kích thô bạo | Hỗn hợp | Sát thương gây ra +8%, độ chính xác kỹ năng −5 điểm phần trăm. |

Bộ 13 này kế thừa ý tưởng lợi/hại của Cầu Vồng nhưng đổi các mô tả mơ hồ thành công thức có thể kiểm thử. Dữ liệu 13 tư chất gốc vẫn được giữ riêng để đối chiếu, không dùng trực tiếp làm luật mới.

## 2. Danh mục 20 Đặc tính chủng

### Chủng Thực Vật

| Mã | Tên | Luật chính xác |
|---|---|---|
| TV-01 | Quang hợp | Sau khi dùng Skill không gây sát thương, hồi 3% Sinh mệnh tối đa; hồi chiêu 3 lượt. |
| TV-02 | Rễ sâu | Debuff giảm chỉ số tác dụng lên Pet bị giảm 20%; thời gian Giam Cầm giảm 1 lượt, tối thiểu còn 1. |
| TV-03 | Gai phản kích | Khi nhận sát thương trực tiếp, phản lại 8% lượng sát thương vừa nhận; không vượt quá 5% Sinh mệnh tối đa của kẻ đánh. |
| TV-04 | Độc thể | Các Skill gây Thiêu Đốt, Hủ Thực hoặc độc trạng thái được cộng 5 điểm phần trăm xác suất, tối đa 95%. |

### Chủng Kim Loại

| Mã | Tên | Luật chính xác |
|---|---|---|
| KL-01 | Giáp hợp kim | Giảm 6% sát thương trực tiếp nhận vào; không giảm sát thương theo lượt. |
| KL-02 | Mạch dẫn | Kháng Tê Liệt +15 điểm phần trăm; khi kháng thành công, Linh xảo +5% trong lượt kế tiếp. |
| KL-03 | Cơ cấu chính xác | Độ chính xác +5 điểm phần trăm và bỏ qua 5% Phòng ngự của mục tiêu. |
| KL-04 | Vũ trang nặng | Sát thương trực tiếp +8%, Linh xảo −8%. |

### Chủng Phi Hành

| Mã | Tên | Luật chính xác |
|---|---|---|
| PH-01 | Thân pháp không trung | Né tránh +5 điểm phần trăm; tổng né từ nội tại bị chặn ở 25%. |
| PH-02 | Bổ nhào | Đòn gây sát thương đầu tiên sau khi vào sân được tăng 12% sát thương. |
| PH-03 | Luồng khí nâng | Sau khi nhận sát thương trực tiếp, Linh xảo +6% trong 2 lượt; hồi chiêu 3 lượt. |
| PH-04 | Định vị siêu âm | Hiệu lực debuff giảm độ chính xác bị giảm 50%; độ chính xác không thể xuống dưới 85%. |

### Chủng Mãnh Thú

| Mã | Tên | Luật chính xác |
|---|---|---|
| MT-01 | Bản năng săn mồi | Gây thêm 8% sát thương lên mục tiêu còn dưới 50% Sinh mệnh. |
| MT-02 | Da dày | Giảm 6% sát thương trực tiếp nhận vào. |
| MT-03 | Truy kích | Nếu đối thủ vừa dùng Skill không gây sát thương, đòn tấn công kế tiếp gây thêm 10%; không cộng dồn. |
| MT-04 | Cuồng nộ | Khi Sinh mệnh dưới 35%, sát thương +12% và Phòng ngự −8%; tắt khi hồi lên trên ngưỡng. |

### Chủng Hải Dương

| Mã | Tên | Luật chính xác |
|---|---|---|
| HD-01 | Da trơn | Kháng Thạch Hóa và Giam Cầm +15 điểm phần trăm. |
| HD-02 | Nhịp thủy triều | Cuối mỗi lượt thứ ba, hồi 1 PP cho Skill có tỷ lệ PP còn lại thấp nhất; không vượt PP tối đa. |
| HD-03 | Áp suất sâu | Khi còn từ 50% Sinh mệnh trở lên, giảm 6% mọi sát thương nhận vào. |
| HD-04 | Thủy lực phản kích | Sau khi nhận sát thương trực tiếp, Skill gây sát thương kế tiếp được tăng 8%; không cộng dồn. |

## 3. Luật vận hành chung

1. **Khởi tạo cá thể:** khi Pet được bắt, nở từ trứng, nhận từ nhiệm vụ, sự kiện hoặc nguồn khác, hệ thống random một số nguyên đồng đều từ 0 đến 12 và ánh xạ trực tiếp tới `TC-00`…`TC-12`. Mỗi Tư chất có xác suất chính xác `1/13`, tương đương khoảng **7,69%**.
2. **Không có ngoại lệ ngầm:** Hệ, Chủng, form tiến hóa, độ hiếm, phẩm chất và nguồn nhận không thay đổi bảng xác suất Tư chất. Nếu sau này có vật phẩm hoặc sự kiện tác động xác suất, giao diện phải công khai luật đó.
3. **Thứ tự chỉ số:** chỉ số theo cấp → phẩm chất/hệ số tiến hóa → Tư chất thể chất → trang bị → buff/debuff trong trận. Mỗi bước chỉ làm tròn xuống một lần ở cuối nhóm.
4. **Thứ tự sát thương:** sát thương gốc của Skill → tương khắc Hệ → buff/debuff → hệ số gây sát thương của Đặc tính → hệ số giảm sát thương của Đặc tính → giới hạn và làm tròn.
5. Bonus sát thương từ toàn bộ Đặc tính bị chặn ở **+20%**; giảm sát thương bị chặn ở **−15%**; hồi Sinh mệnh thụ động bị chặn ở **4% Sinh mệnh tối đa/lượt**.
6. Xác suất trạng thái luôn nằm trong **5–95%**. Kháng trạng thái được trừ theo điểm phần trăm, không nhân nhiều lần.
7. Sát thương phản lại không kích hoạt thêm phản đòn, hút máu hoặc hiệu ứng “khi bị đánh”, tránh vòng lặp vô hạn.
8. Đặc tính không tiêu hao PP, không chiếm slot Skill và không được tính là buff có thể giải trừ.
9. Tiến hóa thường giữ nguyên Tư chất thể chất của cá thể. Đặc tính chủng lấy theo form mới; nếu form vẫn cùng Chủng thì giữ nguyên đặc tính của dòng.
10. Dị hóa cũng giữ nguyên Tư chất thể chất nhưng có thể đổi Đặc tính chủng theo cấu hình form dị hóa.
11. **Tái định Tư chất:** random lại trong đủ 13 Tư chất với cùng xác suất `1/13`; kết quả có thể trùng Tư chất hiện tại.
12. **Thanh tẩy Tư chất:** random đồng đều trong tám Tư chất không bất lợi gồm `TC-00`, `TC-02`, `TC-04`, `TC-06`, `TC-08`, `TC-10`, `TC-11`, `TC-12`; mỗi kết quả có xác suất `1/8`.
13. Tái định và thanh tẩy chỉ thay Tư chất thể chất, tuyệt đối không thay Đặc tính chủng. Chi phí vật phẩm sẽ được chốt ở thiết kế Item, không hard-code vào luật Đặc tính.
14. Hệ chiến đấu không được suy ra từ Đặc tính chủng và Đặc tính chủng không sửa bảng tương khắc Hệ.

## 4. Phương pháp phân bổ

- Tư chất thể chất không được phân bổ theo 202 loài/form. Mọi cá thể đều dùng chung pool 13 Tư chất và cùng xác suất `1/13`.
- Bảng 202 Pet chỉ quyết định Đặc tính chủng của form. Dòng tiến hóa thường cùng Chủng giữ một Đặc tính chủng xuyên suốt để bảo toàn bản sắc; nhánh dị hóa được đánh giá riêng.
- Đặc tính chủng được chọn trong đúng pool của Chủng, dựa trên vai trò và hình thái. Không dùng quota để ép một lựa chọn trái bản sắc.
- Wiki loài hiển thị đủ 13 Tư chất có thể xuất hiện và Đặc tính chủng cố định của form. Hồ sơ Pet thuộc tài khoản hiển thị Tư chất thực tế của cá thể.

## 5. Bảng phân bổ Đặc tính chủng cho đủ 202 Pet

### Nhóm Pet Liệt Hỏa (khóa nội bộ LH)

| Khóa | Pet | Hệ | Chủng | Đặc tính chủng |
|---|---|---|---|---|
| LH-000 | Nhiên Dực Bức | Hỏa | Phi Hành | PH-04 · Định vị siêu âm |
| LH-001 | Bom tinh nghịch | Hỏa | Kim Loại | KL-04 · Vũ trang nặng |
| LH-002 | Nhiên Liệp Sư | Hỏa | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-003 | Hắc Thán Báo | Hỏa | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-004 | Hỏa Diễm Hồ | Hỏa | Mãnh Thú | MT-01 · Bản năng săn mồi |
| LH-005 | Viêm Ma | Hỏa | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-006 | Long bảo bối | Hỏa | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-007 | Phệ Hỏa Thú | Hỏa | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-008 | Bạo Long Thú | Hỏa | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-009 | Ly Ngưu Ngưu | Hỏa | Mãnh Thú | MT-02 · Da dày |
| LH-010 | Ly Ngưu Thản Khắc | Hỏa | Mãnh Thú | MT-02 · Da dày |
| LH-011 | Nhiệt Bạo Phong Tốc Khuyển | Hỏa | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-012 | Tuyệt Đối Linh Độ Khuyển | Hỏa | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-013 | Hỏa Diễm Tường Vân Khuyển | Hỏa | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-014 | Tà Vân Khuyển Thần | Hỏa | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-015 | Hỏa Phượng Hoàng | Hỏa | Phi Hành | PH-02 · Bổ nhào |
| LH-016 | Diệp Tán Oa | Mộc | Hải Dương | HD-03 · Áp suất sâu |
| LH-017 | Thụ Tán Oa | Mộc | Hải Dương | HD-03 · Áp suất sâu |
| LH-018 | Long Oa | Mộc | Hải Dương | HD-03 · Áp suất sâu |
| LH-019 | Tiên Nhân Cầu Bảo Bảo | Mộc | Thực Vật | TV-03 · Gai phản kích |
| LH-020 | Tiên Nhân Chưởng Thú | Mộc | Thực Vật | TV-03 · Gai phản kích |
| LH-021 | Thiết Tý Phách Vương Thụ | Mộc | Thực Vật | TV-03 · Gai phản kích |
| LH-022 | Khẩu Đại Thảo | Mộc | Thực Vật | TV-04 · Độc thể |
| LH-023 | Khốc Tị Mộc Linh | Mộc | Thực Vật | TV-01 · Quang hợp |
| LH-024 | La Phục Thảo | Mộc | Thực Vật | TV-02 · Rễ sâu |
| LH-025 | La phục Oa Oa | Mộc | Thực Vật | TV-02 · Rễ sâu |
| LH-026 | Tây Quan Tiểu Hương Trư | Mộc | Mãnh Thú | MT-02 · Da dày |
| LH-027 | Trư Lộc Điệp | Mộc | Mãnh Thú | MT-02 · Da dày |
| LH-028 | Cương Tán Ma Cô | Mộc | Kim Loại | KL-04 · Vũ trang nặng |
| LH-029 | Uy Qua Đệ Đệ | Mộc | Thực Vật | TV-01 · Quang hợp |
| LH-030 | Thảo Diệp Cô | Mộc | Thực Vật | TV-01 · Quang hợp |
| LH-031 | Linh Quang Lộc | Mộc | Mãnh Thú | MT-01 · Bản năng săn mồi |
| LH-032 | Kim Chỉ Ốc | Thổ | Kim Loại | KL-01 · Giáp hợp kim |
| LH-033 | Mèo YeDoon | Thổ | Mãnh Thú | MT-02 · Da dày |
| LH-034 | Thỏ Di Lặc Bunny | Thổ | Mãnh Thú | MT-02 · Da dày |
| LH-035 | Toản Địa Khâu Dẫn | Thổ | Mãnh Thú | MT-02 · Da dày |
| LH-036 | Toái nham Khâu Dẫn | Thổ | Mãnh Thú | MT-02 · Da dày |
| LH-037 | Nham Nham Quy | Thổ | Kim Loại | KL-04 · Vũ trang nặng |
| LH-038 | Kiếm Giáp Hạn Quy | Thổ | Kim Loại | KL-04 · Vũ trang nặng |
| LH-039 | Bạch Châm Bảo Bảo | Thổ | Kim Loại | KL-01 · Giáp hợp kim |
| LH-040 | Hắc Châm Yển Bảo Bảo | Thổ | Kim Loại | KL-04 · Vũ trang nặng |
| LH-041 | Nham Sơn Long | Thổ | Kim Loại | KL-01 · Giáp hợp kim |
| LH-042 | Zombie Nham Sơn Long | Thổ | Kim Loại | KL-04 · Vũ trang nặng |
| LH-043 | Thổ Lang Chu Chu | Thổ | Mãnh Thú | MT-02 · Da dày |
| LH-044 | Độc Lang Chu | Thổ | Mãnh Thú | MT-02 · Da dày |
| LH-045 | Sừng tê giác bạo long | Thổ | Mãnh Thú | MT-02 · Da dày |
| LH-046 | Khủng giác bạo long | Thổ | Mãnh Thú | MT-02 · Da dày |
| LH-047 | Chiến Thần Đà | Thổ | Mãnh Thú | MT-02 · Da dày |
| LH-048 | Tuyết Cầu Bảo Bảo | Thủy | Mãnh Thú | MT-01 · Bản năng săn mồi |
| LH-049 | Người tuyết | Thủy | Mãnh Thú | MT-01 · Bản năng săn mồi |
| LH-050 | Tuyết Sơn Cự Linh | Thủy | Mãnh Thú | MT-01 · Bản năng săn mồi |
| LH-051 | Thủy thủ chim cánh cụt | Thủy | Hải Dương | HD-03 · Áp suất sâu |
| LH-052 | Bá tước chim cánh cụt | Thủy | Hải Dương | HD-03 · Áp suất sâu |
| LH-053 | Võ thần chim cánh cụt | Thủy | Hải Dương | HD-03 · Áp suất sâu |
| LH-054 | Lục Hành Điểu | Thủy | Phi Hành | PH-01 · Thân pháp không trung |
| LH-055 | Cá Miệng Rộng | Thủy | Hải Dương | HD-03 · Áp suất sâu |
| LH-056 | Mực Ma | Thủy | Hải Dương | HD-01 · Da trơn |
| LH-057 | Cá Đèn Lồng | Thủy | Hải Dương | HD-03 · Áp suất sâu |
| LH-058 | Thủy Thượng Phiêu | Thủy | Hải Dương | HD-01 · Da trơn |
| LH-059 | Phi Thứ Hải Mã | Thủy | Hải Dương | HD-04 · Thủy lực phản kích |
| LH-060 | Tấn Cá Kiếm | Thủy | Kim Loại | KL-04 · Vũ trang nặng |
| LH-061 | Cốt Cá Kiếm | Thủy | Kim Loại | KL-04 · Vũ trang nặng |
| LH-062 | Độc Giác Kim Ngư | Thủy | Hải Dương | HD-02 · Nhịp thủy triều |
| LH-063 | Tương Quân Giải | Thủy | Kim Loại | KL-01 · Giáp hợp kim |
| LH-064 | Lôi Quang Hầu | Điện | Mãnh Thú | MT-03 · Truy kích |
| LH-065 | Lôi Vân Miêu | Điện | Mãnh Thú | MT-03 · Truy kích |
| LH-066 | Điện Nhãn Miêu | Điện | Mãnh Thú | MT-03 · Truy kích |
| LH-067 | Thân Sĩ Miêu | Điện | Mãnh Thú | MT-03 · Truy kích |
| LH-068 | Điện Miêu | Điện | Mãnh Thú | MT-02 · Da dày |
| LH-069 | Thiểm Điện Miêu | Điện | Mãnh Thú | MT-02 · Da dày |
| LH-070 | Phù Du Điện Long | Điện | Phi Hành | PH-02 · Bổ nhào |
| LH-071 | Phù Du Quỷ Long | Điện | Phi Hành | PH-04 · Định vị siêu âm |
| LH-072 | Chuột Điện | Điện | Mãnh Thú | MT-03 · Truy kích |
| LH-073 | Chuột Lôi Điện | Điện | Mãnh Thú | MT-03 · Truy kích |
| LH-074 | Dị Tiểu Hiệp | Điện | Phi Hành | PH-01 · Thân pháp không trung |
| LH-075 | Lôi Kỳ Lân | Điện | Mãnh Thú | MT-02 · Da dày |
| LH-076 | Độc Ba Lợi | Quỷ | Thực Vật | TV-04 · Độc thể |
| LH-077 | Kịch Độc Quái | Quỷ | Thực Vật | TV-04 · Độc thể |
| LH-078 | Kịch Độc Khủng Thú | Quỷ | Thực Vật | TV-04 · Độc thể |
| LH-079 | Đan nhãn thú | Quỷ | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-080 | Độc nhãn quái | Quỷ | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-081 | Độc nhãn cự thần | Quỷ | Mãnh Thú | MT-04 · Cuồng nộ |
| LH-082 | Túi quỷ | Quỷ | Phi Hành | PH-04 · Định vị siêu âm |
| LH-083 | Thi Đại Quỷ | Quỷ | Phi Hành | PH-04 · Định vị siêu âm |
| LH-084 | Kính ma | Quỷ | Kim Loại | KL-04 · Vũ trang nặng |
| LH-085 | Phá kính tà linh | Quỷ | Kim Loại | KL-04 · Vũ trang nặng |
| LH-086 | Hư không hành giả | Quỷ | Kim Loại | KL-01 · Giáp hợp kim |
| LH-087 | Minh vương Long | Quỷ | Mãnh Thú | MT-02 · Da dày |
| LH-088 | Lắc lắc | Phong | Hải Dương | HD-02 · Nhịp thủy triều |
| LH-089 | Chim xanh | Phong | Phi Hành | PH-03 · Luồng khí nâng |
| LH-090 | Tai tước | Phong | Phi Hành | PH-02 · Bổ nhào |
| LH-091 | Hải âu | Phong | Phi Hành | PH-03 · Luồng khí nâng |
| LH-092 | Dực thần | Phong | Phi Hành | PH-03 · Luồng khí nâng |
| LH-093 | Hồng nhạn | Phong | Phi Hành | PH-03 · Luồng khí nâng |
| LH-094 | Phi Dực Thú | Phong | Mãnh Thú | MT-03 · Truy kích |
| LH-095 | Đậu ưng | Phong | Phi Hành | PH-02 · Bổ nhào |
| LH-096 | Liệt ưng | Phong | Phi Hành | PH-02 · Bổ nhào |
| LH-097 | Quáng thạch dực long | Phong | Kim Loại | KL-04 · Vũ trang nặng |
| LH-098 | Tà ma dực long | Phong | Kim Loại | KL-04 · Vũ trang nặng |
| LH-099 | Tinh Vân Hạc | Phong | Phi Hành | PH-03 · Luồng khí nâng |

### Nhóm Pet Cầu Vồng (khóa nội bộ CV)

| Khóa | Pet | Hệ | Chủng | Đặc tính chủng |
|---|---|---|---|---|
| CV-000 | Thụ quái | Mộc | Thực Vật | TV-02 · Rễ sâu |
| CV-001 | Bụi gai | Mộc | Thực Vật | TV-02 · Rễ sâu |
| CV-002 | Cây chứa dịch độc | Mộc | Thực Vật | TV-02 · Rễ sâu |
| CV-003 | Cổ Thụ Chi Vương | Mộc | Thực Vật | TV-02 · Rễ sâu |
| CV-004 | Cỏ thơm | Quỷ | Thực Vật | TV-04 · Độc thể |
| CV-005 | Hoa ngũ sắc | Quỷ | Thực Vật | TV-04 · Độc thể |
| CV-006 | Hoa ăn thịt người | Quỷ | Thực Vật | TV-04 · Độc thể |
| CV-007 | Thảo quả | Hỏa | Thực Vật | TV-04 · Độc thể |
| CV-008 | Mạn đà la | Hỏa | Thực Vật | TV-04 · Độc thể |
| CV-009 | Hoa Mạn đà la | Hỏa | Thực Vật | TV-04 · Độc thể |
| CV-010 | Tiên Nhân Chưởng | Thổ | Thực Vật | TV-03 · Gai phản kích |
| CV-011 | Gai khổng lồ | Thổ | Thực Vật | TV-03 · Gai phản kích |
| CV-012 | Gai độc | Thổ | Thực Vật | TV-03 · Gai phản kích |
| CV-013 | Quả Tử Tiểu Tả | Phong | Thực Vật | TV-02 · Rễ sâu |
| CV-014 | Tứ Diệp Tiểu Tả | Thủy | Thực Vật | TV-02 · Rễ sâu |
| CV-015 | Bá Vương Hoa | Hỏa | Thực Vật | TV-02 · Rễ sâu |
| CV-016 | Ái Tâm Thảo | Điện | Thực Vật | TV-02 · Rễ sâu |
| CV-017 | Bạch Liệt Sư | Thủy | Kim Loại | KL-01 · Giáp hợp kim |
| CV-018 | Vương Sư | Thủy | Kim Loại | KL-01 · Giáp hợp kim |
| CV-019 | Đế Vương Sư | Thủy | Kim Loại | KL-01 · Giáp hợp kim |
| CV-020 | Thủy Tinh Hùng Sư | Thủy | Kim Loại | KL-01 · Giáp hợp kim |
| CV-021 | Xích Đồng Xà | Điện | Kim Loại | KL-02 · Mạch dẫn |
| CV-022 | Thiết Giáp Xà | Điện | Kim Loại | KL-02 · Mạch dẫn |
| CV-023 | Xích Kim Xà Vương | Điện | Kim Loại | KL-02 · Mạch dẫn |
| CV-024 | Xích Kim Xà Hậu | Điện | Kim Loại | KL-02 · Mạch dẫn |
| CV-025 | Binh lính Thiết Giáp | Hỏa | Kim Loại | KL-04 · Vũ trang nặng |
| CV-026 | Đội trưởng Thiết Giáp | Hỏa | Kim Loại | KL-04 · Vũ trang nặng |
| CV-027 | Tướng Thiết Giáp | Hỏa | Kim Loại | KL-04 · Vũ trang nặng |
| CV-028 | Song Đao Tướng Quân | Hỏa | Kim Loại | KL-04 · Vũ trang nặng |
| CV-029 | Đao Thương Tướng Quân | Hỏa | Kim Loại | KL-04 · Vũ trang nặng |
| CV-030 | Thiết Đầu | Thổ | Kim Loại | KL-01 · Giáp hợp kim |
| CV-031 | Thiết Cự Nhân | Thổ | Kim Loại | KL-01 · Giáp hợp kim |
| CV-032 | Thiết Cự Linh | Thổ | Kim Loại | KL-01 · Giáp hợp kim |
| CV-033 | Người điện | Điện | Kim Loại | KL-02 · Mạch dẫn |
| CV-034 | Đồng Cầu huynh đệ | Phong | Kim Loại | KL-03 · Cơ cấu chính xác |
| CV-035 | Thiết Cầu huynh đệ | Phong | Kim Loại | KL-03 · Cơ cấu chính xác |
| CV-036 | Ấu Long | Điện | Phi Hành | PH-02 · Bổ nhào |
| CV-037 | Tiểu Bạch Long | Điện | Phi Hành | PH-02 · Bổ nhào |
| CV-038 | Kim Dực Long | Điện | Phi Hành | PH-02 · Bổ nhào |
| CV-039 | Bạch Kim Long | Điện | Phi Hành | PH-02 · Bổ nhào |
| CV-040 | Ưng | Phong | Phi Hành | PH-02 · Bổ nhào |
| CV-041 | Vương Thứu | Phong | Phi Hành | PH-02 · Bổ nhào |
| CV-042 | Sư Thứu | Phong | Phi Hành | PH-02 · Bổ nhào |
| CV-043 | Dơi khổng lồ | Quỷ | Phi Hành | PH-04 · Định vị siêu âm |
| CV-044 | Răng nanh của dơi | Quỷ | Phi Hành | PH-04 · Định vị siêu âm |
| CV-045 | Tần số của dơi | Quỷ | Phi Hành | PH-04 · Định vị siêu âm |
| CV-046 | Thiên Mã cánh bạc | Thổ | Phi Hành | PH-01 · Thân pháp không trung |
| CV-047 | Thiên Mã một sừng | Thổ | Phi Hành | PH-02 · Bổ nhào |
| CV-048 | Thiên Mã Vương | Thổ | Phi Hành | PH-02 · Bổ nhào |
| CV-049 | Mao Cầu Điểu | Mộc | Phi Hành | PH-02 · Bổ nhào |
| CV-050 | Phiêu Phù Mao Cầu | Mộc | Phi Hành | PH-02 · Bổ nhào |
| CV-051 | Pháp Quan Mao Cầu | Mộc | Phi Hành | PH-02 · Bổ nhào |
| CV-052 | Hổ Thú | Thổ | Mãnh Thú | MT-02 · Da dày |
| CV-053 | Công phu hổ | Thổ | Mãnh Thú | MT-02 · Da dày |
| CV-054 | Hổ Dũng Sĩ | Thổ | Mãnh Thú | MT-02 · Da dày |
| CV-055 | Hổ Tù Trường | Thổ | Mãnh Thú | MT-02 · Da dày |
| CV-056 | Ngựa núi | Mộc | Mãnh Thú | MT-02 · Da dày |
| CV-057 | Ngựa vằn | Mộc | Mãnh Thú | MT-02 · Da dày |
| CV-058 | Ngựa lưỡi liềm khổng lồ | Mộc | Mãnh Thú | MT-02 · Da dày |
| CV-059 | Heo núi | Thổ | Mãnh Thú | MT-02 · Da dày |
| CV-060 | Heo răng nanh khổng lồ | Thổ | Mãnh Thú | MT-02 · Da dày |
| CV-061 | Trư Vương | Thổ | Mãnh Thú | MT-02 · Da dày |
| CV-062 | Heo đốm | Thổ | Mãnh Thú | MT-02 · Da dày |
| CV-063 | Sơn báo | Phong | Mãnh Thú | MT-02 · Da dày |
| CV-064 | Beo răng kiếm | Phong | Mãnh Thú | MT-02 · Da dày |
| CV-065 | Mị Ảnh | Quỷ | Mãnh Thú | MT-02 · Da dày |
| CV-066 | Dị Thú | Điện | Mãnh Thú | MT-02 · Da dày |
| CV-067 | Chân Dị Thú | Điện | Mãnh Thú | MT-02 · Da dày |
| CV-068 | Tiểu Lam Kình | Điện | Hải Dương | HD-03 · Áp suất sâu |
| CV-069 | Cá Kình khổng lồ | Điện | Hải Dương | HD-03 · Áp suất sâu |
| CV-070 | Cá Kình một sừng | Điện | Hải Dương | HD-03 · Áp suất sâu |
| CV-071 | Yếu Tắc Kình | Điện | Hải Dương | HD-03 · Áp suất sâu |
| CV-072 | Tiểu Cánh Cụt | Phong | Hải Dương | HD-01 · Da trơn |
| CV-073 | Đao Phong Cánh Cụt | Phong | Hải Dương | HD-01 · Da trơn |
| CV-074 | Đế Vương Cánh Cụt | Phong | Hải Dương | HD-01 · Da trơn |
| CV-075 | Hải Quy (rùa biển) | Thủy | Hải Dương | HD-01 · Da trơn |
| CV-076 | Rùa trinh sát | Thủy | Hải Dương | HD-01 · Da trơn |
| CV-077 | Rùa ma biển sâu | Quỷ | Hải Dương | HD-01 · Da trơn |
| CV-078 | Rùa khổng lồ biển sâu | Thổ | Hải Dương | HD-03 · Áp suất sâu |
| CV-079 | Cua vàng | Thổ | Hải Dương | HD-01 · Da trơn |
| CV-080 | Cua vân Bạc | Thổ | Hải Dương | HD-01 · Da trơn |
| CV-081 | Cua thiên sứ | Thổ | Hải Dương | HD-01 · Da trơn |
| CV-082 | Cá heo | Điện | Hải Dương | HD-01 · Da trơn |
| CV-083 | Cá heo tốc độ | Phong | Hải Dương | HD-01 · Da trơn |
| CV-084 | Ngựa chiến | Hỏa | Mãnh Thú | MT-01 · Bản năng săn mồi |
| CV-085 | Quỷ Vương Địa Phủ | Quỷ | Phi Hành | PH-04 · Định vị siêu âm |
| CV-086 | Quỷ Vương Địa Phủ | Quỷ | Phi Hành | PH-04 · Định vị siêu âm |
| CV-087 | Cáp Cáp Thụ | Quỷ | Thực Vật | TV-04 · Độc thể |
| CV-088 | Thụ tinh ngàn năm | Quỷ | Thực Vật | TV-04 · Độc thể |
| CV-089 | Hoa Tiên Tử | Quỷ | Thực Vật | TV-04 · Độc thể |
| CV-090 | Cá Chép Rồng | Thổ | Kim Loại | KL-01 · Giáp hợp kim |
| CV-091 | Cá Chép Rồng sắt | Thổ | Kim Loại | KL-01 · Giáp hợp kim |
| CV-092 | Phá Hư Thần | Quỷ | Kim Loại | KL-04 · Vũ trang nặng |
| CV-093 | Bạch Thiên Sử | Hỏa | Phi Hành | PH-02 · Bổ nhào |
| CV-094 | Thiên Sử Trường | Hỏa | Phi Hành | PH-02 · Bổ nhào |
| CV-095 | Phi Thiên Huyền Nữ | Quỷ | Phi Hành | PH-04 · Định vị siêu âm |
| CV-096 | Sói mặt trăng | Quỷ | Mãnh Thú | MT-04 · Cuồng nộ |
| CV-097 | Sói Vương Cao Ngạo | Quỷ | Mãnh Thú | MT-04 · Cuồng nộ |
| CV-098 | Ngân Hồ Vương Tử | Quỷ | Mãnh Thú | MT-02 · Da dày |
| CV-099 | Tê Lợi Sa (cá mập) | Hỏa | Hải Dương | HD-04 · Thủy lực phản kích |
| CV-100 | Sa Vương Cuồng Bạo | Hỏa | Hải Dương | HD-04 · Thủy lực phản kích |
| CV-101 | Mỹ Nhân Ngư | Thủy | Hải Dương | HD-02 · Nhịp thủy triều |

## 6. Phân bố và kiểm tra

### Xác suất Tư chất thể chất ở cấp cá thể

| Cực tính | Mã | Số Tư chất | Xác suất tổng |
|---|---|---:|---:|
| Trung tính | TC-00 | 1 | 1/13 ≈ 7,69% |
| Có lợi | TC-02, TC-04, TC-06, TC-08, TC-10 | 5 | 5/13 ≈ 38,46% |
| Bất lợi | TC-01, TC-03, TC-05, TC-07, TC-09 | 5 | 5/13 ≈ 38,46% |
| Hỗn hợp | TC-11, TC-12 | 2 | 2/13 ≈ 15,38% |

Mỗi mã riêng lẻ luôn có xác suất `1/13 ≈ 7,69%` khi khởi tạo hoặc tái định. Bảng 202 Pet không tham gia phép random này.

### Đặc tính chủng

| Mã | Tên | Số Pet |
|---|---|---:|
| HD-01 | Da trơn | 13 |
| HD-02 | Nhịp thủy triều | 3 |
| HD-03 | Áp suất sâu | 13 |
| HD-04 | Thủy lực phản kích | 3 |
| KL-01 | Giáp hợp kim | 14 |
| KL-02 | Mạch dẫn | 5 |
| KL-03 | Cơ cấu chính xác | 2 |
| KL-04 | Vũ trang nặng | 18 |
| MT-01 | Bản năng săn mồi | 6 |
| MT-02 | Da dày | 34 |
| MT-03 | Truy kích | 7 |
| MT-04 | Cuồng nộ | 15 |
| PH-01 | Thân pháp không trung | 3 |
| PH-02 | Bổ nhào | 19 |
| PH-03 | Luồng khí nâng | 5 |
| PH-04 | Định vị siêu âm | 10 |
| TV-01 | Quang hợp | 3 |
| TV-02 | Rễ sâu | 10 |
| TV-03 | Gai phản kích | 6 |
| TV-04 | Độc thể | 13 |

### Điều kiện đã đạt

- Đủ 202 khóa nội bộ, gồm 100 LH và 102 CV.
- Mỗi form Pet có đúng một Đặc tính chủng cố định.
- Mọi cá thể của cả 202 Pet đều có thể nhận bất kỳ mã nào trong 13 Tư chất với cùng xác suất.
- Đủ 20 Đặc tính chủng; không có đặc tính nào bị bỏ trống.
- Không có Pet nào nhận Đặc tính chủng ngoài pool của Chủng.
- Dòng tiến hóa thường cùng Chủng giữ Đặc tính chủng; dị hóa có thể mang cấu hình khác nhưng luôn giữ Tư chất cá thể.

## 7. Mô hình dữ liệu đề xuất khi triển khai

- Bảng `traits`: `code`, `name`, `slot_type` (physical/species), `species` nullable, `polarity`, `description`, `parameters` JSON, `roll_weight`, `is_cleanse_eligible`, `is_active`.
- Bảng `pets` lưu trực tiếp `species_trait_id` vì mỗi form chỉ có đúng một Đặc tính chủng; không có cột Tư chất thể chất mặc định.
- Bảng Pet thuộc tài khoản lưu `physical_trait_id` thực tế. Giá trị được random một lần khi tạo cá thể rồi lưu bền vững, không tính lại khi đọc hồ sơ.
- `species_trait_id` của cá thể được suy ra từ form Pet hiện tại để tránh dữ liệu trùng và lệch sau tiến hóa.
- Nên có bảng lịch sử thay đổi Tư chất gồm cá thể, Tư chất cũ, Tư chất mới, phương thức `reroll/cleanse`, người thực hiện và thời điểm để kiểm tra giao dịch vật phẩm.
- Wiki hiển thị pool 13 Tư chất và Đặc tính chủng của form. Hồ sơ người chơi hiển thị Tư chất thật của cá thể và đánh dấu rõ có lợi, bất lợi hoặc hỗn hợp.
