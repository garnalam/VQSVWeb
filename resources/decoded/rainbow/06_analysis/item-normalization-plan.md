# Phương án tinh giản Item và chuẩn hóa tiến hóa Cầu Vồng

> Trạng thái: đã áp dụng phần loại bỏ Item, vật liệu Chủng và 88 công thức tiến hóa vào database/Wiki ngày 2026-07-24. Lõi gốc Liệt Hỏa được giữ, mỗi công thức Liệt Hỏa được bổ sung vật liệu Chủng Cầu Vồng.

Nguồn công thức đang chạy và căn cứ định giá từng Pet: [evolution-recipes.md](../../06_analysis/evolution-recipes.md).

## Quy ước mã

- CV-Ixx: Item Cầu Vồng theo game_id gốc.
- LH-S3-Ixx: Item Liệt Hỏa ở source table 3.
- LH-S4-Ixx: Item Liệt Hỏa ở source table 4.
- Item gộp/chuyển đổi vẫn giữ artwork và raw source trong resources/decoded.

## Kết luận nhanh

- Nguồn Cầu Vồng: **70 Item**.
- Giữ độc lập: **33**.
- Gộp: **8**.
- Chuyển đổi: **19**.
- Loại khỏi catalog: **10**.
- Sau chuẩn hóa còn **35 Item Cầu Vồng độc lập**; nhu yếu phẩm phổ thông dùng chung kho Liệt Hỏa, còn 10 vật liệu Chủng được giữ để kết hợp với lõi Liệt Hỏa.
- Phủ đủ **102/102 Pet** và **50 công thức chuyển dạng**.

## Bảng 1 — Item Cầu Vồng: giữ, gộp, chuyển đổi hoặc loại bỏ

| ID nguồn | Item gốc | Nhóm | Quyết định | Lý do |
|---|---|---|---|---|
| CV-I00 | Đồ uống | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I01 | Bánh bích quy | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I02 | Chocolate | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I03 | Năng lượng thạch | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I04 | Tụ năng thạch | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I05 | Cây bạch quả quả | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I06 | Hoàng kim đường | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I07 | sinh mệnh thạch | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I08 | Vạn năng dược | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I09 | Phong ấn cầu | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I10 | Cao cấp cầu | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I11 | Đại sư cầu | consumable | **Chuyển đổi** | Trùng kho hồi phục, hồi PP hoặc bắt Pet của Liệt Hỏa. |
| CV-I12 | Hưng phấn cô | consumable | **Loại bỏ** | Phụ thuộc Trung thành, không thuộc bộ luật chung. |
| CV-I13 | Mật tâm đường | consumable | **Loại bỏ** | Phụ thuộc Trung thành, không thuộc bộ luật chung. |
| CV-I14 | Tránh quái hoàn | consumable | **Chuyển đổi** | Trùng công dụng tránh chạm quái. |
| CV-I15 | Nước hoa | consumable | **Chuyển đổi** | Trùng công dụng tránh chạm quái. |
| CV-I16 | Cứng cỏi thạch | mineral | **Giữ** | Vật liệu Mãnh Thú bậc cơ bản, dùng cùng lõi Liệt Hỏa. |
| CV-I17 | Thú hồn | mineral | **Giữ** | Vật liệu Mãnh Thú bậc cao, dùng cùng lõi Liệt Hỏa. |
| CV-I18 | Thụ chướng thạch | mineral | **Giữ** | Vật liệu Thực Vật bậc cơ bản, dùng cùng lõi Liệt Hỏa. |
| CV-I19 | Chu quả | mineral | **Giữ** | Vật liệu Thực Vật bậc cao, dùng cùng lõi Liệt Hỏa. |
| CV-I20 | Bong bóng | mineral | **Giữ** | Vật liệu Hải Dương bậc cơ bản, dùng cùng lõi Liệt Hỏa. |
| CV-I21 | Biển sâu san hô | mineral | **Giữ** | Vật liệu Hải Dương bậc cao, dùng cùng lõi Liệt Hỏa. |
| CV-I22 | Cách không thạch | mineral | **Giữ** | Vật liệu Phi Hành bậc cơ bản, dùng cùng lõi Liệt Hỏa. |
| CV-I23 | Thiên vũ | mineral | **Giữ** | Vật liệu Phi Hành bậc cao, dùng cùng lõi Liệt Hỏa. |
| CV-I24 | Tinh nguyên thạch | mineral | **Giữ và đổi tên** | Đổi thành Kim Tinh Thạch; vật liệu Kim Loại bậc cơ bản. |
| CV-I25 | Bạch kim | mineral | **Giữ** | Vật liệu Kim Loại bậc cao, dùng cùng lõi Liệt Hỏa. |
| CV-I26 | Bay lượn thiên thạch | mineral | **Giữ** | Xúc tác riêng cho một dạng tiến hóa cuối. |
| CV-I27 | Cổ thụ chi hạch | mineral | **Giữ** | Xúc tác riêng cho một dạng tiến hóa cuối. |
| CV-I28 | Tinh khiết thủy tinh | mineral | **Giữ** | Xúc tác riêng cho một dạng tiến hóa cuối. |
| CV-I29 | Cổ kình chi tâm | mineral | **Giữ** | Xúc tác riêng cho một dạng tiến hóa cuối. |
| CV-I30 | Vương chi chứng minh | mineral | **Giữ** | Xúc tác riêng cho một dạng tiến hóa cuối. |
| CV-I31 | Trị hết chi tâm | mineral | **Giữ** | Vật phẩm nhiệm vụ/thu phục Đao Thương Tướng Quân. |
| CV-I32 | Bảo rương | mineral | **Giữ** | Giữ vòng lặp bảo rương – chìa khóa. |
| CV-I33 | Cái chìa khóa | mineral | **Giữ** | Giữ vòng lặp bảo rương – chìa khóa. |
| CV-I34 | Dị hoá tài liệu | mineral | **Chuyển đổi** | Trùng vai trò đột biến với Hồn Tinh Thạch. |
| CV-I35 | Quân tâm tan rả | medal | **Loại bỏ** | Phụ thuộc Trung thành, không thuộc bộ luật chung. |
| CV-I36 | Sơ cấp trị liệu | medal | **Gộp** | Trùng chức năng với Cao cấp trị liệu. |
| CV-I37 | Cao cấp trị liệu | medal | **Giữ** | Có công dụng chiến đấu, thu phục hoặc khám phá riêng. |
| CV-I38 | Tử vong chi sờ | medal | **Loại bỏ** | Năng lượng tổng không tương thích PP riêng từng Skill. |
| CV-I39 | Kỹ năng Phong Bế | medal | **Giữ** | Có công dụng chiến đấu, thu phục hoặc khám phá riêng. |
| CV-I40 | Nọc độc công kích | medal | **Giữ** | Có công dụng chiến đấu, thu phục hoặc khám phá riêng. |
| CV-I41 | Răng nanh răng nhọn | medal | **Giữ** | Có công dụng chiến đấu, thu phục hoặc khám phá riêng. |
| CV-I42 | Thép thiết cốt | medal | **Giữ** | Có công dụng chiến đấu, thu phục hoặc khám phá riêng. |
| CV-I43 | Tinh thần công kích | medal | **Chuyển đổi** | Nội tại còn giá trị nhưng phải chuyển sang PP. |
| CV-I44 | Triều tịch năng lượng | medal | **Chuyển đổi** | Nội tại còn giá trị nhưng phải chuyển sang PP. |
| CV-I45 | Kinh nghiệm nhiều hơn | medal | **Chuyển đổi** | Trùng tăng kinh nghiệm; quy về Mật Phong Sào. |
| CV-I46 | Kinh nghiệm phong phú | medal | **Chuyển đổi** | Trùng tăng kinh nghiệm; quy về Mật Phong Sào. |
| CV-I47 | Trọng sinh làm tâm | medal | **Giữ** | Có công dụng chiến đấu, thu phục hoặc khám phá riêng. |
| CV-I48 | May mắn ngôi sao | medal | **Giữ** | Có công dụng chiến đấu, thu phục hoặc khám phá riêng. |
| CV-I49 | Trung thành đồng bọn | medal | **Loại bỏ** | Phụ thuộc Trung thành, không thuộc bộ luật chung. |
| CV-I50 | Thân hòa thiên sứ | medal | **Giữ** | Có công dụng chiến đấu, thu phục hoặc khám phá riêng. |
| CV-I51 | Chạy trối chết chuyên gia | medal | **Giữ** | Có công dụng chiến đấu, thu phục hoặc khám phá riêng. |
| CV-I52 | Hoa cỏ Ý Chí | medal | **Loại bỏ** | Nội tại địa hình không cần thiết trong bộ luật chiến đấu chung. |
| CV-I53 | Kim Loại Ý Chí | medal | **Loại bỏ** | Nội tại địa hình không cần thiết trong bộ luật chiến đấu chung. |
| CV-I54 | Bầu trời Ý Chí | medal | **Loại bỏ** | Nội tại địa hình không cần thiết trong bộ luật chiến đấu chung. |
| CV-I55 | Dã thú Ý Chí | medal | **Loại bỏ** | Nội tại địa hình không cần thiết trong bộ luật chiến đấu chung. |
| CV-I56 | Biển rộng Ý Chí | medal | **Loại bỏ** | Nội tại địa hình không cần thiết trong bộ luật chiến đấu chung. |
| CV-I57 | Thế thân tượng gỗ | medal | **Giữ** | Có công dụng chiến đấu, thu phục hoặc khám phá riêng. |
| CV-I58 | Thực Vật hệ | ring | **Giữ** | Nhẫn đại diện duy nhất cho một Chủng. |
| CV-I59 | Thực Vật hệ | ring | **Gộp** | Nhẫn trùng artwork/công dụng; gộp theo Chủng. |
| CV-I60 | Kim Loại hệ | ring | **Giữ** | Nhẫn đại diện duy nhất cho một Chủng. |
| CV-I61 | Kim Loại hệ | ring | **Gộp** | Nhẫn trùng artwork/công dụng; gộp theo Chủng. |
| CV-I62 | Bầu trời hệ | ring | **Giữ** | Nhẫn đại diện duy nhất cho một Chủng. |
| CV-I63 | Mãnh Thú hệ | ring | **Giữ** | Nhẫn đại diện duy nhất cho một Chủng. |
| CV-I64 | Hải Dương hệ | ring | **Giữ** | Nhẫn đại diện duy nhất cho một Chủng. |
| CV-I65 | Thực Vật hệ | ring | **Gộp** | Nhẫn trùng artwork/công dụng; gộp theo Chủng. |
| CV-I66 | Kim Loại hệ | ring | **Gộp** | Nhẫn trùng artwork/công dụng; gộp theo Chủng. |
| CV-I67 | Bầu trời hệ | ring | **Gộp** | Nhẫn trùng artwork/công dụng; gộp theo Chủng. |
| CV-I68 | Mãnh Thú hệ | ring | **Gộp** | Nhẫn trùng artwork/công dụng; gộp theo Chủng. |
| CV-I69 | Hải Dương hệ trứng sủng vật | ring | **Gộp** | Nhẫn trùng artwork/công dụng; gộp theo Chủng. |

## Bảng 2 — Item cũ sang Item chuẩn

| ID nguồn | Item cũ | Item chuẩn | Xử lý dữ liệu |
|---|---|---|---|
| CV-I00 | Đồ uống | LH-S4-I4 · Bánh Sandwich | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I01 | Bánh bích quy | LH-S4-I4 · Bánh Sandwich | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I02 | Chocolate | LH-S4-I5 · Chocolate | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I03 | Năng lượng thạch | LH-S4-I6 · Năng lượng Thạch (hồi PP) | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I04 | Tụ năng thạch | LH-S4-I7 · Tụ Năng Thạch (hồi đầy PP) | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I05 | Cây bạch quả quả | LH-S4-I8 · Khôi phục tề | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I06 | Hoàng kim đường | LH-S4-I9 · Siêu năng tề | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I07 | sinh mệnh thạch | LH-S4-I11 · Sinh mệnh thạch | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I08 | Vạn năng dược | LH-S4-I10 · Vạn năng dược | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I09 | Phong ấn cầu | LH-S4-I1 · Phong ấn cầu | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I10 | Cao cấp cầu | LH-S4-I2 · Cao cấp cầu | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I11 | Đại sư cầu | LH-S4-I0 · Tất Trung Cầu | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I12 | Hưng phấn cô | — | Không seed catalog, không dùng recipe; giữ raw source. |
| CV-I13 | Mật tâm đường | — | Không seed catalog, không dùng recipe; giữ raw source. |
| CV-I14 | Tránh quái hoàn | LH-S4-I13 · Tị quái hàn | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I15 | Nước hoa | LH-S4-I13 · Tị quái hàn | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I16 | Cứng cỏi thạch | CV-I16 · Cứng cỏi thạch | Giữ ID; nguyên liệu Chủng Mãnh Thú bậc cơ bản. |
| CV-I17 | Thú hồn | CV-I17 · Thú hồn | Giữ ID; nguyên liệu Chủng Mãnh Thú bậc cao. |
| CV-I18 | Thụ chướng thạch | CV-I18 · Thụ chướng thạch | Giữ ID; nguyên liệu Chủng Thực Vật bậc cơ bản. |
| CV-I19 | Chu quả | CV-I19 · Chu quả | Giữ ID; nguyên liệu Chủng Thực Vật bậc cao. |
| CV-I20 | Bong bóng | CV-I20 · Bong bóng | Giữ ID; nguyên liệu Chủng Hải Dương bậc cơ bản. |
| CV-I21 | Biển sâu san hô | CV-I21 · Biển sâu san hô | Giữ ID; nguyên liệu Chủng Hải Dương bậc cao. |
| CV-I22 | Cách không thạch | CV-I22 · Cách không thạch | Giữ ID; nguyên liệu Chủng Phi Hành bậc cơ bản. |
| CV-I23 | Thiên vũ | CV-I23 · Thiên vũ | Giữ ID; nguyên liệu Chủng Phi Hành bậc cao. |
| CV-I24 | Tinh nguyên thạch | CV-I24 · Kim Tinh Thạch | Giữ ID, đổi tên để tránh trùng lõi Liệt Hỏa. |
| CV-I25 | Bạch kim | CV-I25 · Bạch kim | Giữ ID; nguyên liệu Chủng Kim Loại bậc cao. |
| CV-I26 | Bay lượn thiên thạch | CV-I26 · Bay lượn thiên thạch | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I27 | Cổ thụ chi hạch | CV-I27 · Cổ thụ chi hạch | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I28 | Tinh khiết thủy tinh | CV-I28 · Tinh khiết thủy tinh | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I29 | Cổ kình chi tâm | CV-I29 · Cổ kình chi tâm | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I30 | Vương chi chứng minh | CV-I30 · Vương chi chứng minh | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I31 | Trị hết chi tâm | CV-I31 · Trị hết chi tâm | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I32 | Bảo rương | CV-I32 · Bảo rương | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I33 | Cái chìa khóa | CV-I33 · Cái chìa khóa | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I34 | Dị hoá tài liệu | LH-S3-I15 · Hồn Tinh Thạch | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I35 | Quân tâm tan rả | — | Không seed catalog, không dùng recipe; giữ raw source. |
| CV-I36 | Sơ cấp trị liệu | CV-I37 · Cao cấp trị liệu | Retarget quan hệ/inventory; artwork cũ chỉ lưu archive. |
| CV-I37 | Cao cấp trị liệu | CV-I37 · Cao cấp trị liệu | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I38 | Tử vong chi sờ | — | Không seed catalog, không dùng recipe; giữ raw source. |
| CV-I39 | Kỹ năng Phong Bế | CV-I39 · Kỹ năng Phong Bế | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I40 | Nọc độc công kích | CV-I40 · Nọc độc công kích | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I41 | Răng nanh răng nhọn | CV-I41 · Răng nanh răng nhọn | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I42 | Thép thiết cốt | CV-I42 · Thép thiết cốt | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I43 | Tinh thần công kích | CV-I43 · Tinh thần công kích · phiên bản PP | Giữ ID/artwork; thay logic năng lượng bằng PP. |
| CV-I44 | Triều tịch năng lượng | CV-I44 · Triều tịch năng lượng · phiên bản PP | Giữ ID/artwork; thay logic năng lượng bằng PP. |
| CV-I45 | Kinh nghiệm nhiều hơn | LH-S3-I5 · Mật Phong Sào | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I46 | Kinh nghiệm phong phú | LH-S3-I5 · Mật Phong Sào | Retarget sang Item Liệt Hỏa; artwork cũ chỉ lưu archive. |
| CV-I47 | Trọng sinh làm tâm | CV-I47 · Trọng sinh làm tâm | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I48 | May mắn ngôi sao | CV-I48 · May mắn ngôi sao | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I49 | Trung thành đồng bọn | — | Không seed catalog, không dùng recipe; giữ raw source. |
| CV-I50 | Thân hòa thiên sứ | CV-I50 · Thân hòa thiên sứ | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I51 | Chạy trối chết chuyên gia | CV-I51 · Chạy trối chết chuyên gia | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I52 | Hoa cỏ Ý Chí | — | Không seed catalog, không dùng recipe; giữ raw source. |
| CV-I53 | Kim Loại Ý Chí | — | Không seed catalog, không dùng recipe; giữ raw source. |
| CV-I54 | Bầu trời Ý Chí | — | Không seed catalog, không dùng recipe; giữ raw source. |
| CV-I55 | Dã thú Ý Chí | — | Không seed catalog, không dùng recipe; giữ raw source. |
| CV-I56 | Biển rộng Ý Chí | — | Không seed catalog, không dùng recipe; giữ raw source. |
| CV-I57 | Thế thân tượng gỗ | CV-I57 · Thế thân tượng gỗ | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I58 | Thực Vật hệ | CV-I58 · Nhẫn ấp trứng Thực Vật | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I59 | Thực Vật hệ | CV-I58 · Nhẫn ấp trứng Thực Vật | Retarget quan hệ/inventory; artwork cũ chỉ lưu archive. |
| CV-I60 | Kim Loại hệ | CV-I60 · Nhẫn ấp trứng Kim Loại | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I61 | Kim Loại hệ | CV-I60 · Nhẫn ấp trứng Kim Loại | Retarget quan hệ/inventory; artwork cũ chỉ lưu archive. |
| CV-I62 | Bầu trời hệ | CV-I62 · Nhẫn ấp trứng Phi Hành | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I63 | Mãnh Thú hệ | CV-I63 · Nhẫn ấp trứng Mãnh Thú | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I64 | Hải Dương hệ | CV-I64 · Nhẫn ấp trứng Hải Dương | Giữ ID; chuẩn hóa tên/mô tả nếu cần. |
| CV-I65 | Thực Vật hệ | CV-I58 · Nhẫn ấp trứng Thực Vật | Retarget quan hệ/inventory; artwork cũ chỉ lưu archive. |
| CV-I66 | Kim Loại hệ | CV-I60 · Nhẫn ấp trứng Kim Loại | Retarget quan hệ/inventory; artwork cũ chỉ lưu archive. |
| CV-I67 | Bầu trời hệ | CV-I62 · Nhẫn ấp trứng Phi Hành | Retarget quan hệ/inventory; artwork cũ chỉ lưu archive. |
| CV-I68 | Mãnh Thú hệ | CV-I63 · Nhẫn ấp trứng Mãnh Thú | Retarget quan hệ/inventory; artwork cũ chỉ lưu archive. |
| CV-I69 | Hải Dương hệ trứng sủng vật | CV-I64 · Nhẫn ấp trứng Hải Dương | Retarget quan hệ/inventory; artwork cũ chỉ lưu archive. |

### Hai nội tại phải chuyển sang PP

| Item | Luật mới đề xuất |
|---|---|
| CV-I43 · Tinh thần công kích | Khi gây sát thương: 20% xác suất làm Skill mục tiêu vừa dùng mất thêm 1 PP; tối đa một lần mỗi lượt. |
| CV-I44 · Triều tịch năng lượng | Khi dùng Skill: 20% xác suất không tiêu hao PP; không kích hoạt liên tiếp quá một lần. |

## Bảng 3 — Bản quy đổi một lớp cũ cho 102 Pet Cầu Vồng (đã ngừng dùng)

> Bảng dưới chỉ được giữ làm lịch sử quyết định. Công thức đang chạy là mô hình hai lớp Lõi + Chủng trong [evolution-recipes.md](../../06_analysis/evolution-recipes.md).

Giữ lượng vật liệu và cấu trúc nhánh gốc; thay vật liệu Chủng đại trà bằng vật liệu Liệt Hỏa cùng bậc.

| Pet | Tên | Stage gốc | Trạng thái | Kết quả chuyển dạng | Công thức mới |
|---|---|---:|---|---|---|
| CV-000 | Thụ quái | 1 | Dạng đầu | Tiến hóa → CV-001 Bụi gai | → CV-001: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-001 | Bụi gai | 2 | Dạng trung gian | Tiến hóa → CV-002 Cây chứa dịch độc | → CV-002: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-002 | Cây chứa dịch độc | 3 | Dạng trung gian | Tiến hóa → CV-003 Cổ Thụ Chi Vương | → CV-003: LH-S3-I13 Thiên Giới Tinh Thạch ×3 + CV-I27 Cổ thụ chi hạch ×1 |
| CV-003 | Cổ Thụ Chi Vương | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-004 | Cỏ thơm | 1 | Dạng đầu | Tiến hóa → CV-005 Hoa ngũ sắc<br>Đột biến → CV-006 Hoa ăn thịt người | → CV-005: LH-S3-I12 Tinh Nguyên Thạch ×3<br>→ CV-006: LH-S3-I12 Tinh Nguyên Thạch ×3 + LH-S3-I15 Hồn Tinh Thạch ×1 |
| CV-005 | Hoa ngũ sắc | 2 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-006 | Hoa ăn thịt người | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-007 | Thảo quả | 1 | Dạng đầu | Tiến hóa → CV-008 Mạn đà la | → CV-008: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-008 | Mạn đà la | 2 | Dạng trung gian | Tiến hóa → CV-009 Hoa Mạn đà la | → CV-009: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-009 | Hoa Mạn đà la | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-010 | Tiên Nhân Chưởng | 1 | Dạng đầu | Tiến hóa → CV-011 Gai khổng lồ | → CV-011: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-011 | Gai khổng lồ | 2 | Dạng trung gian | Tiến hóa → CV-012 Gai độc | → CV-012: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-012 | Gai độc | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-013 | Quả Tử Tiểu Tả | 1 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-014 | Tứ Diệp Tiểu Tả | 2 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-015 | Bá Vương Hoa | 4 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-016 | Ái Tâm Thảo | 4 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-017 | Bạch Liệt Sư | 1 | Dạng đầu | Tiến hóa → CV-018 Vương Sư | → CV-018: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-018 | Vương Sư | 2 | Dạng trung gian | Tiến hóa → CV-019 Đế Vương Sư | → CV-019: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-019 | Đế Vương Sư | 3 | Dạng trung gian | Tiến hóa → CV-020 Thủy Tinh Hùng Sư | → CV-020: LH-S3-I13 Thiên Giới Tinh Thạch ×3 + CV-I28 Tinh khiết thủy tinh ×1 |
| CV-020 | Thủy Tinh Hùng Sư | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-021 | Xích Đồng Xà | 1 | Dạng đầu | Tiến hóa → CV-022 Thiết Giáp Xà | → CV-022: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-022 | Thiết Giáp Xà | 2 | Dạng trung gian | Tiến hóa → CV-023 Xích Kim Xà Vương | → CV-023: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-023 | Xích Kim Xà Vương | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-024 | Xích Kim Xà Hậu | 4 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-025 | Binh lính Thiết Giáp | 1 | Dạng đầu | Tiến hóa → CV-026 Đội trưởng Thiết Giáp | → CV-026: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-026 | Đội trưởng Thiết Giáp | 2 | Dạng trung gian | Tiến hóa → CV-027 Tướng Thiết Giáp | → CV-027: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-027 | Tướng Thiết Giáp | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-028 | Song Đao Tướng Quân | 4 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-029 | Đao Thương Tướng Quân | 4 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-030 | Thiết Đầu | 1 | Dạng đầu | Tiến hóa → CV-031 Thiết Cự Nhân | → CV-031: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-031 | Thiết Cự Nhân | 2 | Dạng trung gian | Tiến hóa → CV-032 Thiết Cự Linh | → CV-032: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-032 | Thiết Cự Linh | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-033 | Người điện | 4 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-034 | Đồng Cầu huynh đệ | 1 | Dạng đầu | Tiến hóa → CV-035 Thiết Cầu huynh đệ | → CV-035: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-035 | Thiết Cầu huynh đệ | 2 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-036 | Ấu Long | 1 | Dạng đầu | Tiến hóa → CV-037 Tiểu Bạch Long | → CV-037: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-037 | Tiểu Bạch Long | 2 | Dạng trung gian | Tiến hóa → CV-038 Kim Dực Long | → CV-038: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-038 | Kim Dực Long | 3 | Dạng trung gian | Tiến hóa → CV-039 Bạch Kim Long | → CV-039: LH-S3-I13 Thiên Giới Tinh Thạch ×3 + CV-I26 Bay lượn thiên thạch ×1 |
| CV-039 | Bạch Kim Long | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-040 | Ưng | 1 | Dạng đầu | Tiến hóa → CV-041 Vương Thứu | → CV-041: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-041 | Vương Thứu | 2 | Dạng trung gian | Tiến hóa → CV-042 Sư Thứu | → CV-042: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-042 | Sư Thứu | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-043 | Dơi khổng lồ | 1 | Dạng đầu | Tiến hóa → CV-044 Răng nanh của dơi | → CV-044: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-044 | Răng nanh của dơi | 2 | Dạng trung gian | Tiến hóa → CV-045 Tần số của dơi | → CV-045: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-045 | Tần số của dơi | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-046 | Thiên Mã cánh bạc | 1 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-047 | Thiên Mã một sừng | 2 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-048 | Thiên Mã Vương | 3 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-049 | Mao Cầu Điểu | 2 | Dạng đầu | Tiến hóa → CV-050 Phiêu Phù Mao Cầu<br>Đột biến → CV-051 Pháp Quan Mao Cầu | → CV-050: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2<br>→ CV-051: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 + LH-S3-I15 Hồn Tinh Thạch ×1 |
| CV-050 | Phiêu Phù Mao Cầu | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-051 | Pháp Quan Mao Cầu | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-052 | Hổ Thú | 1 | Dạng đầu | Tiến hóa → CV-053 Công phu hổ | → CV-053: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-053 | Công phu hổ | 2 | Dạng trung gian | Tiến hóa → CV-054 Hổ Dũng Sĩ | → CV-054: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-054 | Hổ Dũng Sĩ | 3 | Dạng trung gian | Tiến hóa → CV-055 Hổ Tù Trường | → CV-055: LH-S3-I13 Thiên Giới Tinh Thạch ×3 + CV-I30 Vương chi chứng minh ×1 |
| CV-055 | Hổ Tù Trường | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-056 | Ngựa núi | 1 | Dạng đầu | Tiến hóa → CV-057 Ngựa vằn<br>Đột biến → CV-084 Ngựa chiến | → CV-057: LH-S3-I12 Tinh Nguyên Thạch ×3<br>→ CV-084: LH-S3-I12 Tinh Nguyên Thạch ×3 + LH-S3-I15 Hồn Tinh Thạch ×1 |
| CV-057 | Ngựa vằn | 2 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-058 | Ngựa lưỡi liềm khổng lồ | 3 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-059 | Heo núi | 1 | Dạng đầu | Tiến hóa → CV-060 Heo răng nanh khổng lồ | → CV-060: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-060 | Heo răng nanh khổng lồ | 2 | Dạng trung gian | Tiến hóa → CV-061 Trư Vương | → CV-061: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-061 | Trư Vương | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-062 | Heo đốm | 4 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-063 | Sơn báo | 1 | Dạng đầu | Tiến hóa → CV-064 Beo răng kiếm | → CV-064: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-064 | Beo răng kiếm | 2 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-065 | Mị Ảnh | 3 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-066 | Dị Thú | 2 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-067 | Chân Dị Thú | 3 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-068 | Tiểu Lam Kình | 1 | Dạng đầu | Tiến hóa → CV-069 Cá Kình khổng lồ | → CV-069: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-069 | Cá Kình khổng lồ | 2 | Dạng trung gian | Tiến hóa → CV-070 Cá Kình một sừng | → CV-070: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-070 | Cá Kình một sừng | 3 | Dạng trung gian | Tiến hóa → CV-071 Yếu Tắc Kình | → CV-071: LH-S3-I13 Thiên Giới Tinh Thạch ×3 + CV-I29 Cổ kình chi tâm ×1 |
| CV-071 | Yếu Tắc Kình | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-072 | Tiểu Cánh Cụt | 1 | Dạng đầu | Tiến hóa → CV-073 Đao Phong Cánh Cụt | → CV-073: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-073 | Đao Phong Cánh Cụt | 2 | Dạng trung gian | Tiến hóa → CV-074 Đế Vương Cánh Cụt | → CV-074: LH-S3-I12 Tinh Nguyên Thạch ×3 + LH-S3-I13 Thiên Giới Tinh Thạch ×1 |
| CV-074 | Đế Vương Cánh Cụt | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-075 | Hải Quy (rùa biển) | 1 | Dạng đầu | Tiến hóa → CV-076 Rùa trinh sát<br>Đột biến → CV-077 Rùa ma biển sâu | → CV-076: LH-S3-I12 Tinh Nguyên Thạch ×3<br>→ CV-077: LH-S3-I12 Tinh Nguyên Thạch ×3 + LH-S3-I15 Hồn Tinh Thạch ×1 |
| CV-076 | Rùa trinh sát | 2 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-077 | Rùa ma biển sâu | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-078 | Rùa khổng lồ biển sâu | 4 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-079 | Cua vàng | 1 | Dạng đầu | Tiến hóa → CV-080 Cua vân Bạc | → CV-080: LH-S3-I12 Tinh Nguyên Thạch ×3 |
| CV-080 | Cua vân Bạc | 2 | Dạng trung gian | Tiến hóa → CV-081 Cua thiên sứ | → CV-081: LH-S3-I12 Tinh Nguyên Thạch ×2 + LH-S3-I13 Thiên Giới Tinh Thạch ×2 |
| CV-081 | Cua thiên sứ | 3 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-082 | Cá heo | 1 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-083 | Cá heo tốc độ | 2 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-084 | Ngựa chiến | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-085 | Quỷ Vương Địa Phủ | 5 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-086 | Quỷ Vương Địa Phủ | 5 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-087 | Cáp Cáp Thụ | 3 | Dạng đầu | Tiến hóa → CV-088 Thụ tinh ngàn năm | → CV-088: LH-S3-I13 Thiên Giới Tinh Thạch ×3 |
| CV-088 | Thụ tinh ngàn năm | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-089 | Hoa Tiên Tử | 5 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-090 | Cá Chép Rồng | 3 | Dạng đầu | Tiến hóa → CV-091 Cá Chép Rồng sắt | → CV-091: LH-S3-I13 Thiên Giới Tinh Thạch ×3 |
| CV-091 | Cá Chép Rồng sắt | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-092 | Phá Hư Thần | 5 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-093 | Bạch Thiên Sử | 3 | Dạng đầu | Tiến hóa → CV-094 Thiên Sử Trường | → CV-094: LH-S3-I13 Thiên Giới Tinh Thạch ×3 |
| CV-094 | Thiên Sử Trường | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-095 | Phi Thiên Huyền Nữ | 5 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-096 | Sói mặt trăng | 3 | Dạng đầu | Tiến hóa → CV-097 Sói Vương Cao Ngạo | → CV-097: LH-S3-I13 Thiên Giới Tinh Thạch ×3 |
| CV-097 | Sói Vương Cao Ngạo | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-098 | Ngân Hồ Vương Tử | 5 | Pet độc lập | — | Không cần công thức tiến hóa. |
| CV-099 | Tê Lợi Sa (cá mập) | 3 | Dạng đầu | Tiến hóa → CV-100 Sa Vương Cuồng Bạo | → CV-100: LH-S3-I13 Thiên Giới Tinh Thạch ×3 |
| CV-100 | Sa Vương Cuồng Bạo | 4 | Dạng cuối | — | Không cần công thức tiến hóa. |
| CV-101 | Mỹ Nhân Ngư | 5 | Pet độc lập | — | Không cần công thức tiến hóa. |

## Kiểm tra toàn vẹn

- [x] 70 dòng Item nguồn.
- [x] 23 giữ + 8 gộp + 29 chuyển đổi + 10 loại = 70.
- [x] 102 dòng Pet và 50 quan hệ chuyển dạng.
- [x] Mọi vật liệu recipe đều có Item chuẩn đích.
- [x] Không Item loại bỏ nào còn trong recipe.
- [x] Không thay đổi dữ liệu tiến hóa Liệt Hỏa.

## Sau khi bảng được duyệt

1. Tạo pet_evolution_ingredients để hỗ trợ nhiều Item và foreign key thật.
2. Retarget 50 recipe Cầu Vồng theo Bảng 3.
3. Seeder chỉ giữ 25 Item Cầu Vồng độc lập và lưu ánh xạ legacy.
4. Ẩn Item gộp/loại khỏi Wiki, vẫn giữ raw source/artwork.
5. Thêm test phủ 102 Pet, 50 quan hệ và không có foreign key mồ côi.
