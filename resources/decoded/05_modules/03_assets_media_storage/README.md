# Asset, media, lưu trữ và codec dữ liệu

Đọc resource nhị phân, map/sprite, ảnh, âm thanh MIDI, RMS và bitmap font.

## Nội dung

- `source_vineflower/`: bản decompile ưu tiên để đọc.
- `source_cfr/`: bản decompile đối chiếu.
- `bytecode_javap/`: disassembly chính xác để kiểm chứng.

## Class

| Class    | Vai trò suy luận                                                           | Tin cậy |
| -------- | -------------------------------------------------------------------------- | ------: |
| `a.e`    | Utility nạp resource, ảnh, dữ liệu và vẽ chữ                               |    high |
| `a.a.c`  | RecordStore/RMS wrapper                                                    |    high |
| `a.a.d`  | Ảnh/animation frame helper                                                 |  medium |
| `a.a.e`  | Audio player/manager cho MIDI và media Java ME                             |    high |
| `a.a.i`  | PlayerListener cho audio lifecycle                                         |    high |
| `a.b.c`  | Nạp cơ sở dữ liệu asset/script toàn cục                                    |    high |
| `a.b.d`  | Nạp map và module scene                                                    |    high |
| `a.b.e`  | RMS persistence helper                                                     |    high |
| `a.b.f`  | Nạp sprite binary data/spr                                                 |    high |
| `a.b.g`  | Đọc resource nhị phân, map/sprite, ảnh, âm thanh MIDI, RMS và bitmap font. |     low |
| `a.b.h`  | Đọc resource nhị phân, map/sprite, ảnh, âm thanh MIDI, RMS và bitmap font. |     low |
| `b`      | DataInputStream có buffer/auto-close cho resource                          |    high |
| `b.a`    | Đọc resource nhị phân, map/sprite, ảnh, âm thanh MIDI, RMS và bitmap font. |     low |
| `b.b`    | Đọc resource nhị phân, map/sprite, ảnh, âm thanh MIDI, RMS và bitmap font. |     low |
| `game.n` | Bitmap font renderer đọc font.bin                                          |    high |

## Dependency thống kê

- Cạnh nội bộ module: 18
- Cạnh gọi sang module khác: 11
- Cạnh từ module khác gọi vào: 73
