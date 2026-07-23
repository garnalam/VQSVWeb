# Menu, dialog và luồng màn hình

Dialog renderer, splash/pause, main menu và controller của toàn bộ UI gameplay.

## Nội dung

- `source_vineflower/`: bản decompile ưu tiên để đọc.
- `source_cfr/`: bản decompile đối chiếu.
- `bytecode_javap/`: disassembly chính xác để kiểm chứng.

## Class

| Class    | Vai trò suy luận                        | Tin cậy |
| -------- | --------------------------------------- | ------: |
| `game.d` | Dialog renderer và phân trang hội thoại |    high |
| `game.f` | Splash/tutorial/pause screen            |  medium |
| `game.g` | Main menu, thoát game và tạo game mới   |    high |
| `game.k` | Controller menu/UI gameplay             |    high |

## Dependency thống kê

- Cạnh nội bộ module: 7
- Cạnh gọi sang module khác: 59
- Cạnh từ module khác gọi vào: 15
