---
name: integrate-vqsv-game-data
description: Integrate or review unified VQSV Pet, stats, stars, elements, species, traits, learnsets, Skills, buffs, debuffs, Items, evolutions, Rainbow assets, IDs, or saves in the Liệt Hỏa rebuild. Use whenever gameplay data from VQSV-Web or decoded Cầu Vồng is ported into the Java game, or when an integration phase, compatibility migration, source-parity review, or coverage audit is requested.
---

# Integrate VQSV Game Data

## Purpose

Port the reviewed unified contract into the Liệt Hỏa rebuild without losing source parity, save compatibility, provenance, or a dependent gameplay system. Treat Liệt Hỏa as the combat baseline and Cầu Vồng as a required decoded reference for imported content.

## Mandatory startup

1. Locate `docs/liet-hoa-integration/00-HANDOFF.md` in VQSV-Web. From the game repo, check a user-provided path and nearby sibling workspaces before asking for it.
2. Read all documents in their required order from `00-HANDOFF.md` through `06-DECISIONS-AND-RISKS.md`.
3. Read `references/integration-gates.md` in this skill.
4. Locate the current SQLite snapshot and manifest. If absent or stale, run `php artisan game:export-integration-data` in VQSV-Web.
5. Verify manifest checksum and versions before planning changes.
6. Inspect the current Liệt Hỏa implementation and tests for the selected domain.
7. For any Cầu Vồng record or asset, inspect its raw/CSV record and the relevant decoded module before editing game code.

Explicitly tell the user when this skill requires source inspection, snapshot regeneration, save migration work, or a pause caused by missing evidence.

## Provenance rules

- Preserve `decoded_source`, `source_normalized`, `unified_balance`, `unified_design`, `generated_unified_design`, and `excluded_by_design` distinctions.
- Never describe unified stats, taxonomy, learnsets, recipes, Skill mechanics, traits, or Divine abilities as decoded source.
- Never infer behavior from display text, a Wiki badge, filename, or `effectiveness_class` alone.
- Mark uncertain decompilation as `source-uncertain`; obtain a runtime trace or leave it gated. Do not invent a missing behavior.
- Use `skills.mechanics_json`, not prose, as the executable unified Skill contract.

## Plan before implementation

Create an evidence matrix for the scoped vertical slice:

| Record/domain | Stable keys | Snapshot tables/query | Liệt Hỏa baseline files | Cầu Vồng files/modules | Save impact | Tests |
|---|---|---|---|---|---|---|

The plan must include:

1. Data/import changes.
2. Stable-to-runtime ID mapping.
3. Runtime logic changes.
4. Save version and migration.
5. UI/animation/resource changes.
6. Source-parity and unified behavior tests.
7. Coverage ledger update.

Do not start with a broad rewrite. Port a complete vertical slice or mechanics family behind a data/feature version boundary.

## Implementation order

1. Validate/import typed data at build time; never connect the game runtime to the web database.
2. Freeze stable key → numeric runtime ID mapping while preserving existing Liệt Hỏa IDs.
3. Extend save schema and migration before enabling new records.
4. Implement domain models and pure mechanics.
5. Wire battle/progression/inventory adapters.
6. Port Cầu Vồng resources using decoded loader/renderer behavior.
7. Add UI only after the underlying state and migration are testable.
8. Update the coverage ledger with file and test evidence.

## Domain gates

### Pet and traits

- Validate four stats at levels 1 and 50 for all five stars against `pet_stat_profiles`.
- Keep element and species independent.
- Apply one fixed species trait and one random physical trait; neither consumes a Skill slot.
- Do not reintroduce Rainbow energy into unified battle.

### Skill, buffs, and debuffs

- Import only active Skills into learnable runtime catalogs.
- Read learn levels from `pet_skill_learnsets`; support every milestone present through level 50.
- Support five equipped Skills and saved PP per slot.
- Implement every active `mechanics_json.type` explicitly; forbid silent fallback.
- Test timing, duration, stacking, refresh, caps, consume, cleanse, immunity, heal, damage-over-time, and control where applicable.

### Item and evolution

- Resolve aliases to canonical Items before assigning runtime IDs.
- Reject Items whose decision is `remove`.
- Check and consume every evolution ingredient atomically.
- Preserve old inventory quantities during save migration.

### Cầu Vồng Pet and animation

- Read `game-data.json`/CSV, `ak.java`, `ad.java`, and the actual sprite/skill asset path used by the scoped record.
- Port frame timing, anchor, flip/pixel transformation, and battle event timing; do not substitute a fabricated animation when source behavior exists.

## Verification and completion

Run the smallest relevant unit/integration tests, then the baseline parity suite affected by the change. Validate data counts and snapshot keys. Exercise at least one old save migration fixture when persistent state changes.

Before claiming completion, walk every applicable item in `docs/liet-hoa-integration/05-COVERAGE-CHECKLIST.md`. Report remaining `pending` or `source-uncertain` entries plainly. A domain is complete only when its coverage ledger row is `verified`, not merely implemented.
