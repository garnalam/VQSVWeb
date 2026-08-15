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

## Verified Water and Earth family slices

| Stable key/domain | Snapshot query | Source Liet Hoa reviewed | Rainbow/V4 source reviewed | Runtime files | Tests | Status |
|---|---|---|---|---|---|---|
| Water Pet learnset v1 (`generated_water_family_design_v1`): 20 families / 21 paths / 38 forms / 306 direct grants | `pets`, `skills`, `pet_stat_profiles`, `pet_evolutions`; snapshot SHA-256 `3728139...EEB4` | Liet Hoa Water contracts, per-form stats/traits/roles, campaign AI decks | CV/V4 species variants and packaged animation ownership; V4-049 fork reviewed independently | `Generate-UnifiedPetSkillPools.php`, `UnifiedSkillLearnsetCatalog`, `learnsets.tsv`, `learnset-evolutions.tsv`, `water-pet-skill-pools.md`, AI deck alignment | `WaterPetSkillPoolDesignTest`, family/global/V4 audits, AI A2-B4/C/D suites, full `build.ps1` | verified |
| Earth Pet learnset v1 (`generated_earth_family_design_v1`): 27 families / 49 forms / 405 direct grants | `pets`, `skills`, `pet_stat_profiles`, `pet_evolutions`; snapshot SHA-256 `3728139...EEB4` | Liet Hoa Earth contracts, per-form stats/traits/roles, Niem Tho AI deck behavior | CV/V4 species variants preserve packaged animation ownership | `Generate-UnifiedPetSkillPools.php`, `UnifiedSkillLearnsetCatalog`, `learnsets.tsv`, `learnset-evolutions.tsv`, `earth-pet-skill-pools.md`, AI deck/counterplay alignment | `EarthPetSkillPoolDesignTest`, family/global/V4 audits, AI A2-B4/C/D suites, full `build.ps1` | verified |
| Electric Pet learnset v1 (`generated_electric_family_design_v1`): 21 families / 40 forms / 315 direct grants | `pets`, `skills`, `pet_stat_profiles`, `pet_evolutions`; snapshot SHA-256 `3728139...EEB4` | Liet Hoa Electric mechanics, per-form stats/traits/roles, Skill UI and campaign AI decks | Rainbow `skills.csv`, `ak.java` data/battle loader, `ad.java` image loader, CV/V4 packaged animation ownership | `Generate-UnifiedPetSkillPools.php`, `UnifiedSkillLearnsetCatalog`, `learnsets.tsv`, `learnset-evolutions.tsv`, `electric-pet-skill-pools.md`, AI counterplay alignment | `ElectricPetSkillPoolDesignTest`, `SkillManagementUiRedesignTest`, family/global/V4 audits, AI A2-B4/C/D suites, full `build.ps1` | verified |
| Wind Pet learnset v1 (`generated_wind_family_design_v1`): 16 families / 17 paths / 32 forms / 246 direct grants | `pets`, `skills`, `pet_stat_profiles`, `pet_evolutions`; snapshot SHA-256 `3728139...EEB4` | Liet Hoa Wind mechanics, per-form stats/traits/roles, Skill UI and campaign AI decks | Rainbow `skills.csv`, `ak.java` `data/battle/s*` loader, `ad.java` image loader, CV/V4 packaged animation ownership | `Generate-UnifiedPetSkillPools.php`, `UnifiedSkillLearnsetCatalog`, `learnsets.tsv`, `learnset-evolutions.tsv`, `wind-pet-skill-pools.md`, AI counterplay alignment | `WindPetSkillPoolDesignTest` (CV-049 fork and LH-093 -> LH-094 species isolation), family/global/V4 audits, AI A2-B4/C/D suites, full `build.ps1` | verified |
| Ghost Pet learnset v1 (`generated_ghost_family_design_v1`): 28 families / 41 forms / 420 direct grants; reviewed mixed-element style exceptions for Độc Ba Lợi and Tần số của dơi families | `pets`, `skills`, `pet_stat_profiles`, `pet_evolutions`; snapshot SHA-256 `3728139...EEB4` | Liet Hoa Ghost mechanics, per-form stats/traits/roles, Skill UI and campaign AI decks | Rainbow `skills.csv`, `ak.java` `data/battle/s*` loader, `ad.java` image loader, CV/V4 packaged animation ownership | `Generate-UnifiedPetSkillPools.php`, `UnifiedSkillLearnsetCatalog`, `learnsets.tsv`, `learnset-evolutions.tsv`, `ghost-pet-skill-pools.md`, AI deck/counterplay alignment | `GhostPetSkillPoolDesignTest` (two whitelisted mixed-style families, form gating and Tần số của dơi `LH-SKILL-59` finisher), family/global/V4 audits, AI A2-B4/C/D suites, full `build.ps1` | verified |

| PVP 1v1 six-Pet lifecycle, forced switch, held equipment and world resume (`vqsv-pvp-v4`) | `pets`, `integration_items`, Pet stats/traits/learnsets; snapshot SHA-256 `3728139...EEB4` | Source battle roster projection, held-equipment mechanics and world runtime ownership | Unified CV/V4 Pet IDs and canonical item mappings; no source behavior fabricated | `PvpMatchSession`, `PvpBattleModel`, `VqsvBattleRuntime`, `VqsvBattleScripts`, `VqsvGameRuntime`, `cloudflare/pvp-protocol.js`, `cloudflare/pvp-worker.js` | `PvpSixPetKnockoutRegressionTest`, `PvpTurnDeadlineProtocolTest`, `PvpBattleExitWorldResumeTest`, `PvpSourceBattleIntegrationTest`, `UnifiedHeldItemRuntimeRegressionTest`, `pvp-protocol.test.mjs`, full `build.ps1` | verified |
| Normal 1v1 battle-local Pet switching preserves the player's persistent roster order | `pets`; snapshot SHA-256 `3728139...EEB4` | Source P5 switch flow, PetState HP/PP/EXP persistence and next-battle entry ownership | Unified CV/V4 Pet identity retained by `PetState` object; no source behavior fabricated | `VqsvBattleRuntime` | `BattleRosterOrderPersistenceTest`, `BattlePetLifecycleTraceTest`, `PetSaveProfileMigrationTest`, `PvpSixPetKnockoutRegressionTest`, full `build.ps1` | verified |

| Rainbow mutation at the Bich Thuy badge envoy: `CV-004->006`, `CV-049->051`, `CV-056->084`, `CV-075->077` | `pet_evolutions` + `pet_evolution_ingredients`; current snapshot SHA-256 `3728139...EEB4` | Source mutation level policy, evolution comparison UI and atomic material transaction | Rainbow `pet_evolutions.csv`, `pets.csv`, `game-data.json`, `ak.java::j()` `data/data.d` loader and packaged target sprites | `UnifiedEvolutionCatalog`, `VqsvSourceEvolutionRuntime`, `EvolutionProgression`, `VqsvPanelRuntime`, `VqsvGameRuntime` | `RainbowMutationEnvoyIntegrationTest`, `UnifiedRainbowPetIntegrationTest`, `UnifiedEvolutionCommissioningTest`, `EvolutionUiRedesignTest`, `PetStateDashboardRedesignTest`, `BichThuyPetBankExpansionRegressionTest`, full `build.ps1` | verified |

## Verified pet-quality family fodder

| Stable key/domain | Snapshot query | Source Liet Hoa reviewed | Rainbow/V4 source reviewed | Runtime files | Tests | Status |
|---|---|---|---|---|---|---|
| Directional family-form quality fodder across 274 Pets (`unified_design` rate policy) | `pet_evolutions` topology; snapshot SHA-256 `3728139...EEB4`; packaged 133-edge LH/CV/V4 topology | `LH-068 -> LH-069` and `LH-076 -> LH-077 -> LH-078` evolution paths; existing exact-form quality rate matrix and atomic transaction | CV parallel evolution/mutation branches and `V4-004 -> V4-005 -> V4-006` reviewed; no fabricated edges | `UnifiedSkillLearnsetCatalog.evolutionDistance`, `PetQualityUpgradeService`, `VqsvGameRuntime`, `VqsvBattleRenderer` | `PetQualityUpgradeServiceTest` (same/direct/two-step, reverse and sibling rejection, V4 direction, additive rates), `PetQualityUpgradeUiTest` (candidate list/rate labels), `PetQualityUpgradeSaveTest`, full `build.ps1` | verified |

## Verified V4 stat balance

| Stable key/domain | Snapshot query | Source Liet Hoa reviewed | Rainbow/V4 source reviewed | Runtime files | Tests | Status |
|---|---|---|---|---|---|---|
| V4 Pet stat profile V7: 72 forms, runtime IDs `202..273`, 67 normal + 5 divine (`generated_unified_balance`) | `pets`, `pet_stat_profiles`, `pet_evolutions`; snapshot SHA-256 `a49f70a5...667a3` | Liệt Hỏa v4 level-1/50 checkpoints, quality multipliers `90/95/100/110/125%`, evolution ancestry floor | Rainbow v3 level-1/50 checkpoints and V4 source stat ordering; normal/divine percentiles balanced separately | `V4PetStatProfileCatalog`, `BattleSpeciesRow`, `EvolutionStatFloor`, `unified-v4-pet-growth-v2/{profiles,checkpoints,manifest}`, `generate_v4_pet_growth_profile.py` | `V4PetStatBalanceTest` (72,000 runtime values, 720 checkpoints, 45 evolution edges, non-V4 locks), `Vqsv4PetIntegrationTest` (720 web checkpoints), `PetSaveProfileMigrationTest` (V5->V6 HP ratio), full `build.ps1` | verified |
