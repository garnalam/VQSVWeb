# Quyết định kiến trúc và rủi ro

## Các quyết định đã chốt

1. Liệt Hỏa là lõi chiến đấu.
2. Có 7 Hệ chiến đấu: Hỏa, Mộc, Thổ, Thủy, Điện, Quỷ, Phong.
3. Có 5 Chủng: Thực Vật, Kim Loại, Phi Hành, Mãnh Thú, Hải Dương.
4. Hệ quyết định tương khắc; Chủng quyết định đặc tính.
5. Pet có bốn stat: Sinh mệnh, Sức mạnh, Phòng ngự, Linh xảo.
6. Pet có sao 1–5 với hệ số 90/95/100/110/125%.
7. Pet có hai trait: một thể chất random, một Chủng cố định.
8. Mỗi Skill có PP riêng; Pet mang tối đa năm Skill.
9. Learnset kết hợp bể Hệ, Chủng và Skill đặc trưng theo vai trò/form.
10. Năng lượng Cầu Vồng chỉ là dữ liệu tham khảo nguồn.
11. Item Liệt Hỏa được giữ; Item Cầu Vồng được giữ/gộp/loại theo decision table.
12. Công thức tiến hóa có thể cần nhiều nguyên liệu và trộn hai nguồn.

## Rủi ro lớn

### Mất tương thích save

Rủi ro cao nhất là tái sử dụng numeric ID hoặc đổi shape Pet/Skill/Item mà không migration. Giảm thiểu bằng stable key registry, data version và test ma trận save.

### Nhầm thiết kế mới là dữ liệu nguồn

Stat, taxonomy, learnset, unified mechanics, recipe và Thần Quyền có phần thiết kế mới. Giảm thiểu bằng provenance JSON và cấm dùng Markdown/nhãn UI làm bằng chứng nguồn.

### Battle engine thành chuỗi ngoại lệ

Nếu mỗi Skill tạo một `switch` theo ID, hệ thống sẽ khó kiểm tra và dễ lệch. Dùng mechanics type + parameter typed, nhưng chỉ tạo type cần cho 99 Skill hiện có; không phát minh hệ thống ngoài nguồn.

### Port animation không trung thực

Ảnh đúng chưa đủ; anchor, frame duration, flip/pixel transform và thời điểm effect phải theo source. Mỗi dòng Pet Cầu Vồng phải đọc module giải mã liên quan trước khi port.

### Recipe trừ nguyên liệu nửa chừng

Game cũ thiên về một nguyên liệu; contract mới có nhiều ingredient. Phải validate toàn bộ rồi mới trừ trong một transaction logic.

### Scope quá lớn

Không bật đồng thời 202 Pet + 99 mechanics + asset Cầu Vồng. Tích hợp theo vertical slice hoàn chỉnh: data → save → battle → UI → animation → test cho từng dòng Pet/mechanics family.

## Các điểm chưa được phép suy đoán

- Ý nghĩa marketing chính xác của `effectiveness_class`.
- Một-một giữa 13 trait hợp nhất và 13 trait nguồn Cầu Vồng.
- Thần Quyền là cơ chế gốc.
- Hành vi decompiled method bị lỗi cấu trúc mà chưa có runtime trace.
- Đấu đôi: dữ liệu target có thể lưu để chuẩn bị, nhưng cơ chế chuẩn hóa đấu đôi chưa phải scope hiện tại.

Mọi điểm chưa chắc phải được đánh dấu `source-uncertain`, không tự hoàn thiện bằng giả định.
