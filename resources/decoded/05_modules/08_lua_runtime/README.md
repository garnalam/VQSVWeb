# Máy ảo Lua nhúng

Loader bytecode, stack, table, interpreter/thread và standard-library subset của Lua.

## Nội dung

- `source_vineflower/`: bản decompile ưu tiên để đọc.
- `source_cfr/`: bản decompile đối chiếu.
- `bytecode_javap/`: disassembly chính xác để kiểm chứng.

## Class

| Class | Vai trò suy luận                 | Tin cậy |
| ----- | -------------------------------- | ------: |
| `d.a` | Lua standard library subset      |    high |
| `d.b` | Thành phần nội bộ của máy ảo Lua |  medium |
| `d.c` | Thành phần nội bộ của máy ảo Lua |  medium |
| `d.d` | Thành phần nội bộ của máy ảo Lua |  medium |
| `d.e` | Thành phần nội bộ của máy ảo Lua |  medium |
| `d.f` | Lua bytecode loader              |    high |
| `d.g` | Lua interpreter/thread execution |    high |
| `d.h` | Lua table implementation         |    high |
| `d.i` | Lua value stack                  |    high |
| `d.j` | Thành phần nội bộ của máy ảo Lua |  medium |

## Dependency thống kê

- Cạnh nội bộ module: 36
- Cạnh gọi sang module khác: 1
- Cạnh từ module khác gọi vào: 8
