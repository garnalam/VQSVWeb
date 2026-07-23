# Kích hoạt, SMS và payment

Đọc thông tin thiết bị/kích hoạt, màn hình thanh toán và transport SMS Java ME.

## Nội dung

- `source_vineflower/`: bản decompile ưu tiên để đọc.
- `source_cfr/`: bản decompile đối chiếu.
- `bytecode_javap/`: disassembly chính xác để kiểm chứng.

## Class

| Class                                        | Vai trò suy luận                                    | Tin cậy |
| -------------------------------------------- | --------------------------------------------------- | ------: |
| `a`                                          | Đọc UID/Term/RefCode và dữ liệu kích hoạt từ l2.bin |    high |
| `e.a.a.a.a.a`                                | Cấu hình giá/nội dung SMS payment                   |    high |
| `e.a.a.a.b.a`                                | Adapter/callback của hệ thống SMS payment           |  medium |
| `e.a.a.a.b.b`                                | Canvas UI cho luồng payment                         |    high |
| `e.a.a.a.b.c`                                | Adapter/callback của hệ thống SMS payment           |  medium |
| `e.b.a.a.a`                                  | Adapter/callback của hệ thống SMS payment           |  medium |
| `e.b.a.a.b`                                  | Runnable gửi SMS qua Wireless Messaging API         |    high |
| `lavax.wireless.messaging.MessageConnection` | Compatibility shim cho gửi SMS bất đồng bộ          |    high |

## Dependency thống kê

- Cạnh nội bộ module: 5
- Cạnh gọi sang module khác: 10
- Cạnh từ module khác gọi vào: 6
