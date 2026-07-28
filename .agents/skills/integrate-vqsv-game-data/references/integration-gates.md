# Integration gates quick reference

## Required inputs

- VQSV-Web handoff documents `00` through `06`.
- Current SQLite snapshot and matching manifest.
- Liệt Hỏa baseline source and tests.
- Relevant decoded Cầu Vồng raw record, decompiled call path, and assets.

## Stop conditions

Stop and report the exact missing evidence when:

- snapshot checksum/version does not match the manifest;
- an active Skill has no mechanics contract;
- a stable key has no frozen runtime ID mapping;
- a Cầu Vồng animation/behavior cannot be traced to decoded source;
- a persistent field changes without a save migration plan;
- an Item marked `remove` or an inactive Skill would enter gameplay.

## Completion evidence

- query/result proving imported keys and counts;
- source file/method path for behavior and assets;
- generated data/resource diff;
- unit test for pure mechanics;
- integration/battle trace test;
- save migration test where applicable;
- source-parity regression result;
- updated coverage ledger row marked `verified`.
