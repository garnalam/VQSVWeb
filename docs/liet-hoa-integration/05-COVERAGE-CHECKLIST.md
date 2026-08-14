# Checklist chống bỏ sót khi tích hợp

Sao chép phần phù hợp vào plan/PR của game repo. Mỗi ô hoàn tất phải có file/test/query làm bằng chứng.

## Cổng dữ liệu chung

- [ ] Manifest schema/data version được kiểm tra.
- [ ] SHA-256 được kiểm tra.
- [ ] Stable key → numeric ID map đã đóng băng.
- [ ] Import count khớp manifest.
- [ ] Provenance được giữ trong generated catalog/debug metadata.
- [ ] Chế độ source-parity vẫn chạy.

## Pet

- [ ] Identity, tên nguồn, sprite mapping.
- [ ] Hệ chiến đấu và Chủng tách độc lập.
- [ ] Vai trò không tạo buff ẩn.
- [ ] Công thức HP/Sức mạnh/Phòng ngự/Linh xảo.
- [ ] Preview cấp 1 và 50 ở đủ 1–5 sao.
- [ ] Trait Chủng cố định.
- [ ] Trait thể chất random trong đúng 13 trait.
- [ ] Trait không chiếm Skill slot.
- [ ] Dòng tiến hóa và form đơn.
- [ ] Save/load và migration.

## Skill và học Skill

- [ ] Chỉ Skill `is_active=1` được cấp.
- [ ] Power, PP, tier, target, chance.
- [ ] Mechanics handler đúng `mechanics_json.type`.
- [ ] Duration, stack, refresh, cap, consume, cleanse, immunity.
- [ ] Learnset đúng Pet, source type và level.
- [ ] Các mốc 5–50 không bị hard-code thiếu.
- [ ] Năm slot Skill và flow thay Skill.
- [ ] PP còn lại được save/load.
- [ ] Skill kế thừa sau tiến hóa.
- [ ] Không dùng energy Cầu Vồng trong unified battle.

## Buff/debuff

- [ ] Thứ tự apply so với damage.
- [ ] Thời điểm tick đầu/cuối lượt.
- [ ] Stack/refresh/replace rule.
- [ ] Giới hạn tăng/giảm DEF.
- [ ] Heal, regeneration, life steal và heal cap.
- [ ] Damage over time/delayed damage.
- [ ] Control skip action và kháng trạng thái.
- [ ] Cleanse/immunity.
- [ ] Effect icon và animation không thay đổi logic.
- [ ] Battle trace có kết quả trước/sau mỗi effect.

## Item và tiến hóa

- [ ] 87 Item active được import.
- [ ] 25 alias quy về canonical item.
- [ ] 10 Item remove bị chặn.
- [ ] Equipment slot/mechanic handler.
- [ ] Inventory save migration không mất số lượng.
- [ ] 88 cạnh tiến hóa.
- [ ] 239 ingredient rows.
- [ ] Kiểm tra đủ toàn bộ nguyên liệu trước khi trừ.
- [ ] Rollback nếu tiến hóa thất bại.
- [ ] Giá/cost rank và UI hiển thị.

## Asset Cầu Vồng

- [ ] Đã đọc module `ak.java` liên quan.
- [ ] Đã đọc parser/renderer `ad.java` hoặc caller thực tế.
- [ ] Sprite group và variant khớp raw record.
- [ ] Idle/hit/skill/death frames.
- [ ] Pixel transform/flip/anchor khớp nguồn.
- [ ] Skill effect asset/index khớp nguồn.
- [ ] Không dùng animation dựng giả nếu có nguồn.
- [ ] Không rò resource và không vượt bounds.

## Save và regression

- [ ] Save trống v1 → v2.
- [ ] Save giữa game v1 → v2.
- [ ] Save có đầy Pet/Skill/Item v1 → v2.
- [ ] Alias Item migration idempotent.
- [ ] Save v2 load lại không đổi stable IDs.
- [ ] Story/world/inventory baseline không regression.
- [ ] Deterministic battle tests.
- [ ] Source-parity tests.

## Coverage ledger

| Stable key/domain | Snapshot query | Source Liệt Hỏa đã đọc | Module Cầu Vồng đã đọc | Runtime files | Tests | Trạng thái |
|---|---|---|---|---|---|---|
| Ví dụ `CV-000` | `pets + learnsets + evolutions` | battle adapter | `ak.java`, sprite data | … | … | pending |
| `CV-ITEM-037/039/040/041/042/043/044/047/048/050/051/057` team charms (`unified_design`) | `integration_items` + `integration_item_assets` | inventory/equipment, 1v1/2v2 battle, encounter, save v19 | decoded Item icons and canonical item asset mapping | `vqsv.charm.*`, battle/world adapters, `VqsvPanelRuntime`, save v20 | `RainbowTeamCharmIntegrationTest` (exact five-tier matrix for all 12 charms, capture-failure pity stack/cap, mouse confirm/cancel + retired starter cleanup), `RainbowCharmRuntimeActivationRegressionTest` (1v1/2v2 effects, restricted ordinary-wild escape with trainer/story guards), `RainbowCharmCorrosionMechanicsTest`, `RainbowControlFamilyTest`, `UnifiedItemCatalogIntegrationTest`, full `build.ps1` | verified |
| Healing Skill matrix: `CV/V4-26/27/28`, `LH-15/24/34`, post-damage and delayed heal families (25 total) | `skills` + `mechanics_json` + provenance; snapshot SHA-256 `3728139...EEB4` | `db.mid` Skill rows 15/24/34 and buff/debuff rows 3/5/13 | Rainbow `skills.csv`, `ak.java`, `z.java` source heal route | `LietHoaSkillMechanics`, `VqsvBattleRuntime`, `VqsvDoubleBattleRuntime`, `PvpBattleModel` | `UnifiedLietHoaSkillContractTest`, `PvpHealingRuntimeRegressionTest`, `LietHoaDebuffReconciliationTest`, full `build.ps1` | verified |
| Fire Pet learnset v1 (`generated_fire_family_design_v1`): 21 families / 35 forms / 315 direct grants | `pets`, `skills`, `pet_stat_profiles`, `pet_evolutions`; snapshot SHA-256 `3728139...EEB4` | Liệt Hỏa active Skill rows, role/stat/trait contracts, battle AI encounter decks | CV/V4 species Skill variants and packaged animation mappings | `Generate-UnifiedPetSkillPools.php`, `UnifiedSkillLearnsetCatalog`, `learnsets.tsv`, `learnset-evolutions.tsv`, AI deck/counterplay alignment | `FirePetSkillPoolDesignTest`, `UnifiedPetSkillPoolRuleTest`, `UnifiedV4AdditiveLearnsetAuditTest`, `UnifiedSkillCanonicalParityTest`, AI A2-B4/C/D suites, full `build.ps1` | verified |
| Wood Pet learnset v1 (`generated_wood_family_design_v1`): 22 families / 39 forms / 330 direct grants | `pets`, `skills`, `pet_stat_profiles`, `pet_evolutions`; snapshot SHA-256 `3728139...EEB4` | Liệt Hỏa Wood Skill contracts, per-form stats/traits/roles, Niêm Thổ AI deck behavior | CV/V4 species variants preserve packaged animation ownership | `Generate-UnifiedPetSkillPools.php`, `UnifiedSkillLearnsetCatalog`, `learnsets.tsv`, `learnset-evolutions.tsv`, `wood-pet-skill-pools.md`, AI deck/counterplay alignment | `WoodPetSkillPoolDesignTest`, family/global/V4 audits, AI A2-B4/C/D suites, full `build.ps1` | verified |

Trạng thái hợp lệ: `pending`, `source-uncertain`, `implemented`, `verified`. Không dùng `done` khi chưa có test và source evidence.
