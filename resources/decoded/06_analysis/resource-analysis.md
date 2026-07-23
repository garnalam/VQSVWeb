# Phân tích tài nguyên

File `.mid` trong game không đồng nghĩa với MIDI. Chữ ký thực tế được dùng để nhận diện; bản raw luôn được giữ nguyên.

## Tổng hợp kiểu thực

| Kiểu            | Số lượng |
| --------------- | -------: |
| `custom_binary` |      539 |
| `png`           |      311 |
| `midi`          |        7 |
| `text_like`     |        1 |

## Theo họ tài nguyên

| Họ       | Phân bố                                |
| -------- | -------------------------------------- |
| `event`  | custom_binary: 16                      |
| `img`    | png: 308                               |
| `logo`   | png: 2                                 |
| `map`    | custom_binary: 102                     |
| `mod`    | custom_binary: 8                       |
| `root`   | custom_binary: 3, png: 1, text_like: 1 |
| `script` | custom_binary: 19                      |
| `sound`  | midi: 7                                |
| `spr`    | custom_binary: 325                     |
| `tex`    | custom_binary: 24                      |
| `ui`     | custom_binary: 42                      |

## Loader tương ứng trong source

| Họ                              | Loader/consumer chính              | Ý nghĩa suy luận                         |
| ------------------------------- | ---------------------------------- | ---------------------------------------- |
| `data/img`                      | `a.e`, `a.b.c`, các class `game.*` | PNG đổi đuôi `.mid`                      |
| `data/sound`                    | `a.a.e`, `game.l`                  | Standard MIDI                            |
| `data/map`, `data/mod`          | `a.b.d`                            | Map tile, room/module binary             |
| `data/spr`                      | `a.b.f`, `a.b.g`                   | Sprite frame/animation binary            |
| `data/ui`                       | package `c.*`, `game.k`            | UI layout/widget binary                  |
| `data/script`                   | `a.b.c`, `a.e`, `game.a/e/l`       | Bảng dữ liệu và bytecode/script gameplay |
| `data/event`                    | `game.l`, Lua runtime `d.*`        | Event/scene scripts                      |
| `data/tex`                      | `a.b.c`, `a.e`                     | Metadata/texture effect data             |
| `font.bin`                      | `game.n`                           | Bitmap font table                        |
| `dcn.bin`, `l2.bin`, `cpid.txt` | `a`, `a.a.c` và payment module     | Activation/payment metadata              |

Mọi custom binary có file companion trong `06_analysis/binary_strings/` chứa hash, hex prefix và chuỗi có thể phục hồi.
