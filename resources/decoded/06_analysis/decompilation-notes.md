# Ghi chú độ chính xác của decompile

## Ba lớp kiểm chứng

1. **Vineflower 1.12.0** — bản source ưu tiên, phục hồi 72/72 class.
2. **CFR 0.152** — bản source độc lập để so sánh, phục hồi 72/72 class.
3. **JDK 26 `javap -p -c -s -constants -l -v`** — bytecode, descriptor, constant pool và metadata chính xác.

## Cảnh báo đã phát hiện

CFR không cấu trúc hoàn toàn một số method trong 9 class:

- `c.c`
- `d.h`
- `e.a.a.a.b.b`
- `game.a`
- `game.d`
- `game.e`
- `game.g`
- `game.i`
- `game.l`

Vineflower phục hồi đủ các class trên và chỉ cảnh báo việc bảo toàn `finally` trong `e.b.a.a.b.run()`. Với các method nhạy cảm, cần đọc cả hai bản rồi dùng file `03_bytecode/javap/<class>.javap.txt` làm nguồn quyết định.

## Những gì không thể phục hồi tuyệt đối

- Tên biến cục bộ đã bị xóa khỏi bytecode.
- Tên class/method/field gốc đã bị obfuscate.
- Comment, định dạng và cấu trúc file source ban đầu không tồn tại trong JAR.
- Một biểu thức Java decompile có thể khác source gốc nhưng tương đương bytecode.
- Source decompile không được coi là project có thể build ngay; còn thiếu Java ME MIDP/CLDC SDK và một số class platform theo thiết bị.

Vì vậy output không tự ý đổi tên symbol. Các tên vai trò trong tài liệu chỉ là lớp chú giải bên ngoài.
