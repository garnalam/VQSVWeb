# Bản đồ port sang VQSV-Refactor

Game repo được khảo sát tại `C:\Users\Dell\Downloads\VQSV-Refactor\VQSV-Refactor`.

| Domain | Contract web/snapshot | Điểm móc Liệt Hỏa hiện tại | Nguồn Cầu Vồng bắt buộc đọc |
|---|---|---|---|
| Pet catalog/stat | `pets`, `pet_stat_profiles` | `vqsv.battle.data.BattleSpeciesRow`, `VqsvBattleTables`, `vqsv.source.PetSourceAdapter` | `game-data.json`, `pets.csv`, loader `ak.java::j()` |
| Sao 1–5 | multiplier trong snapshot | `vqsv.pet.PetQuality` | Công thức stat trong decoded Pet/runtime |
| Pet state | stable ID, trait, 5 Skill | `vqsv.pet.PetState`, `GameSession.PetState` | Pet structure trong decompiled runtime |
| Learnset | `pet_skill_learnsets` | `LearnThresholdRow`, `PetSourceAdapter`, flow level-up | `ak.java` phần học Skill và `skills.csv` |
| Skill | `skills.mechanics_json` | `BattleSkillRow`, `BattleUnit`, `PetBattleAdapter` | `skills.csv`, `ak.java`, asset `data/battle/s0..s5` |
| Buff/debuff | mechanics JSON + `effects` | `BattleBuffRow`, `BattleDebuffRow`, `VqsvBattleEffectLogic` | `effects.csv`, battle branches trong `ak.java` |
| Battle timing | Power/PP/status handler | `BattleUnit`, `VqsvBattleEffectLogic`, `SourceCompatibleBattleRandom` | `ak.java`; chỉ port phần đã đối chiếu hành vi |
| Animation | sprite/effect source refs | `VqsvBattleAnimationTables`, render adapters, canonical sprite animator | `data/npc2/*`, `data/battle/s*`, renderer/parser `ad.java` và caller trong `ak.java` |
| Item | `items`, `item_decisions` | `ItemDefinition`, bag/material/equipment engines | `items.csv`, mapping ảnh/logic trong `ak.java` |
| Evolution | evolution + ingredients | `EvolutionCandidate`, `EvolutionProgression` | `pet_evolutions.csv`, source evolution checks |
| Save | data version, stable ID map | `SaveSnapshot`, `SavePropertiesCodec`, `SaveSessionSnapshotMapper` | Đọc source layout chỉ để tương thích; schema mới thuộc rebuild |
| Thần Quyền | `divine_abilities` | Chưa có handler chuẩn | Không có source tương đương; feature flag riêng |

## Các thay đổi cấu trúc chắc chắn cần thiết

### Data tables

`VqsvBattleTables` hiện đọc chín group trong `db.mid` Liệt Hỏa. Không mở rộng binary gốc ngay. Tạo `UnifiedGameData`/adapter song song nhận generated resource từ snapshot, sau đó cho battle mode chọn `SOURCE_V1` hoặc `UNIFIED_V1`.

### Pet state và save

`PetState` đã có năm `skillIds`, là điểm thuận lợi. Cần bổ sung stable/numeric species mapping, physical trait, data version và migration. `PetSourceAdapter.create()` hiện nhận hai Skill khởi tạo; không dùng chữ ký đó để giới hạn learnset mới.

### Battle effect registry

`VqsvBattleEffectLogic` đang bám bank/index nguồn. Mechanics mới nên đi qua registry typed theo `mechanics_json.type`; các handler có thể gọi primitive nguồn đã kiểm chứng. Không nhét stable key hoặc JSON parsing vào hot path mỗi lượt; importer phải sinh record typed trước runtime.

### Evolution transaction

`EvolutionCandidate`/`EvolutionProgression` đang biểu diễn một `materialNeed`. Cần chuyển sang danh sách ingredient và kiểm tra/trừ nguyên tử qua `MaterialInventoryEngine` trước khi đổi species.

### ID và save compatibility

- Giữ ID số Liệt Hỏa cũ để save v1 còn đọc được.
- Cấp range riêng cho Cầu Vồng và đóng băng trong registry version-controlled.
- Save ghi data version; loader v1 chuyển alias Item và bù trường trait/sao bằng policy rõ ràng.
- Không tính numeric ID bằng vị trí row SQLite vì thứ tự export có thể thay đổi.

## Quy trình bắt buộc khi port một dòng Pet Cầu Vồng

1. Query Pet, stat, trait, learnset, evolution, ingredient từ snapshot.
2. Query mọi Skill active của dòng Pet và liệt kê mechanics types.
3. Đọc raw record trong `game-data.json`/CSV.
4. Đọc `ak.java` và `ad.java` tại đường gọi tải/thi triển asset liên quan.
5. Đối chiếu sprite group/variant và Skill animation index.
6. Viết adapter/resource typed.
7. Viết test stat, học Skill, battle mechanics, tiến hóa, save/load và animation bounds.
8. Cập nhật coverage ledger.

Nếu decompiler không cấu trúc được một method, agent phải ghi `blocked/source-uncertain`, thu thập binary trace hoặc runtime repro; không tự bịa hành vi để lấp khoảng trống.
