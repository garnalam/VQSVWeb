# Khởi động và vòng lặp game

MIDlet entry point, Canvas chính, luồng update/render/input và lớp scene nền.

## Nội dung

- `source_vineflower/`: bản decompile ưu tiên để đọc.
- `source_cfr/`: bản decompile đối chiếu.
- `bytecode_javap/`: disassembly chính xác để kiểm chứng.

## Class

| Class             | Vai trò suy luận                                        | Tin cậy |
| ----------------- | ------------------------------------------------------- | ------: |
| `game.GameMIDLet` | MIDlet entry point; tạo Display và Canvas chính         |    high |
| `game.m`          | Canvas chính; game loop, paint, keypad và pointer input |    high |
| `a.a`             | Lớp scene/state trừu tượng và cầu nối display/payment   |    high |

## Dependency thống kê

- Cạnh nội bộ module: 5
- Cạnh gọi sang module khác: 17
- Cạnh từ module khác gọi vào: 19
