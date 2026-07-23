# World, event, quest và save

Scene/world controllers, nhiệm vụ-phần thưởng, nạp event và trạng thái lưu RMS.

## Nội dung

- `source_vineflower/`: bản decompile ưu tiên để đọc.
- `source_cfr/`: bản decompile đối chiếu.
- `bytecode_javap/`: disassembly chính xác để kiểm chứng.

## Class

| Class    | Vai trò suy luận                                                                | Tin cậy |
| -------- | ------------------------------------------------------------------------------- | ------: |
| `game.b` | Scene/world controllers, nhiệm vụ-phần thưởng, nạp event và trạng thái lưu RMS. |     low |
| `game.c` | Scene/world controllers, nhiệm vụ-phần thưởng, nạp event và trạng thái lưu RMS. |     low |
| `game.e` | Quest/event/reward controller                                                   |    high |
| `game.l` | World state, scene loader, save/load và game orchestration                      |    high |

## Dependency thống kê

- Cạnh nội bộ module: 3
- Cạnh gọi sang module khác: 56
- Cạnh từ module khác gọi vào: 26
