# Vương Quốc Pokémon — kết quả giải mã/decompile

Thư mục này là bản phân tích tĩnh của `AowVN.org-S60-VuongQuoc-Pokemon-240x320.jar`. Game không được thực thi trong quá trình xử lý.

## Kết quả chính

- JAR Java ME: MIDP 2.0, CLDC 1.0, entry point `game.GameMIDLet`.
- 72/72 class đã được decompile bằng cả Vineflower 1.12.0 và CFR 0.152.
- 72/72 class có disassembly `javap -verbose` để đối chiếu chính xác bytecode.
- 858 resource đã được kiểm kê và giữ nguyên bản.
- 311 ảnh PNG đã được nhận diện, đổi sang đuôi `.png` ở bản copy và tạo 5 contact sheet.
- 7 file MIDI thật đã được nhận diện và tách riêng.
- 540 file custom binary/text-like được giữ raw; mỗi file có báo cáo hash, hex prefix và chuỗi phục hồi được.
- 363 dependency edge giữa các class đã được trích xuất.
- 72 class được chia chính xác vào 9 module chức năng.

## Cách đọc thư mục

| Thư mục                     | Nội dung                                                      |
| --------------------------- | ------------------------------------------------------------- |
| `00_inventory/`             | Hash, manifest, log decompiler và các bảng CSV đầy đủ         |
| `01_original/`              | Bản sao JAR và archive giải nén nguyên trạng                  |
| `02_decompiled/vineflower/` | Java source ưu tiên để đọc                                    |
| `02_decompiled/cfr/`        | Java source thứ hai để đối chiếu                              |
| `03_bytecode/javap/`        | Constant pool, descriptor và instruction bytecode đầy đủ      |
| `04_resources/raw/`         | Resource nguyên trạng                                         |
| `04_resources/recognized/`  | Ảnh, audio, text được nhận diện theo chữ ký thực              |
| `05_modules/`               | Source, CFR và bytecode được nhóm theo module chức năng       |
| `06_analysis/`              | Kiến trúc, class catalog, resource analysis, graph và strings |
| `tools/`                    | Script tái tạo inventory/module/contact sheet                 |

## Bắt đầu nhanh

1. Đọc [`06_analysis/architecture.md`](06_analysis/architecture.md) để hiểu luồng game.
2. Mở [`06_analysis/class-catalog.md`](06_analysis/class-catalog.md) để tra vai trò từng class.
3. Vào `05_modules/<module>/README.md` rồi đọc bản `source_vineflower/`.
4. Khi một đoạn source có vẻ sai, đối chiếu `source_cfr/` và `bytecode_javap/` cùng class.
5. Xem ảnh nhanh trong `04_resources/recognized/contact_sheets/`.

## Lưu ý về obfuscation

Tên class/method/field dạng `a`, `b`, `c` là tên còn lại sau obfuscation. Không có cách đáng tin cậy để phục hồi tuyệt đối tên biến, tên class, comment hoặc cấu trúc source gốc đã bị xóa. Tên module và vai trò trong tài liệu là suy luận có ghi mức tin cậy; source và package gốc không bị đổi tên.

Custom binary trong `data/map`, `data/spr`, `data/ui`, `data/script` và `data/event` là định dạng riêng của engine. Bản raw bảo toàn 100%; bảng inventory, loader mapping và chuỗi trích xuất giúp phân tích tiếp mà không giả định sai cấu trúc.
