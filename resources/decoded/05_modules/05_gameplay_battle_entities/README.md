# Chiến đấu và thực thể gameplay

Battle state machine, pet/actor, NPC, reward/interactable và dữ liệu combat.

## Nội dung

- `source_vineflower/`: bản decompile ưu tiên để đọc.
- `source_cfr/`: bản decompile đối chiếu.
- `bytecode_javap/`: disassembly chính xác để kiểm chứng.

## Class

| Class    | Vai trò suy luận                                                             | Tin cậy |
| -------- | ---------------------------------------------------------------------------- | ------: |
| `a.a.f`  | Battle state machine, pet/actor, NPC, reward/interactable và dữ liệu combat. |     low |
| `game.a` | Battle state machine và combat rendering                                     |    high |
| `game.h` | World actor/NPC runtime object                                               |  medium |
| `game.i` | Pet/combatant model với stat, element và skill                               |    high |
| `game.j` | Player/inventory/world-interaction aggregate                                 |  medium |

## Dependency thống kê

- Cạnh nội bộ module: 9
- Cạnh gọi sang module khác: 53
- Cạnh từ module khác gọi vào: 25
