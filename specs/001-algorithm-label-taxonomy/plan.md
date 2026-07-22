# Implementation Plan: 알고리즘 문제 라벨 통합 분류체계(Taxonomy) 구축

**Branch**: `001-algorithm-label-taxonomy` | **Date**: 2026-07-22 | **Spec**: [spec.md](./spec.md)

**Input**: Feature specification from `/specs/001-algorithm-label-taxonomy/spec.md`

**Note**: This template is filled in by the `/speckit-plan` command; its definition describes the execution workflow.

## Summary

solved.ac·LeetCode·Codeforces·프로그래머스 네 출처의 공개 태그 문서를 일괄 조사한 뒤 한 번에 비교·병합하여, 상위 카테고리(단일 부모) + 하위 라벨의 얕은 2단계 계층을 만든다. 각 라벨에는 이름·정의·대표 예시(원문 비복제, 이름/출처/링크만)·판별기준(애매하면 기본 분리)을 기록하고, 네 출처의 원본 태그 전량을 병합 라벨에 매핑한 기록을 함께 남긴다. 산출물은 코드가 아니라 사람이 읽는 Markdown 문서 하나이며, 완성 기준은 조사 시점 기준 정적 스냅샷이다(spec.md Clarifications 참고).

## Technical Context

**Language/Version**: N/A — 이 기능은 소프트웨어를 만들지 않는다. 산출물은 구조화된 Markdown 문서이며 실행 가능한 코드가 없다.

**Primary Dependencies**: N/A — 별도 라이브러리/프레임워크 없음. 조사 도구는 웹 검색·웹 열람뿐이며, 문제풀이 사이트에 대한 프로그램적 접근(크롤링/API 클라이언트)은 FR-001에 따라 사용하지 않는다.

**Storage**: 리포지토리 내 버전관리되는 로컬 텍스트 파일. 형식은 Markdown 단일 문서로 결정(근거: research.md Decision 1).

**Testing**: N/A — 자동화 테스트 없음. Success Criteria(SC-001~004)를 quickstart.md의 수동 점검 절차로 검증한다.

**Target Platform**: N/A — 텍스트 에디터/Markdown 뷰어로 열람하는 로컬 파일. 별도 배포·호스팅 플랫폼 없음(FR-008).

**Project Type**: 문서/콘텐츠 저작물 — 소프트웨어 프로젝트가 아니므로 src/tests 구조를 적용하지 않는다.

**Performance Goals**: N/A

**Constraints**: 계층 깊이 정확히 2단계 초과 금지(FR-002), 라벨당 상위 카테고리 정확히 1개(FR-002), 문제 원문 비복제(FR-005), 완성 기준은 조사 시점 정적 스냅샷(FR-009).

**Scale/Scope**: 최소 조사 출처 4곳(FR-001), 최종 라벨 개수에 대한 사전 목표치 없음 — 병합 결과로 자연 결정(spec.md Assumptions).

## Constitution Check

*GATE: Must pass before Phase 0 research. Re-check after Phase 1 design.*

`.specify/memory/constitution.md`는 아직 플레이스홀더 템플릿 상태이며 비준된 프로젝트 원칙이 없다. 따라서 적용할 수 있는 게이트가 없고, 이번 계획은 원칙 위반 없이 진행한다. (참고: decision.md의 scorecard도 동일한 이유로 strategic fit을 `adequate`로만 평가했다 — 향후 여러 기능이 쌓이면 `/speckit-constitution`으로 공식 원칙을 정하는 것을 권장.)

**Post-Design Re-check (Phase 1 이후)**: 데이터 모델·산출물 구조를 확정한 뒤에도 constitution이 여전히 비어 있어 재평가할 게이트가 없다. 위반 없음.

## Project Structure

### Documentation (this feature)

```text
specs/001-algorithm-label-taxonomy/
├── plan.md              # This file (/speckit-plan command output)
├── research.md          # Phase 0 output (/speckit-plan command)
├── data-model.md         # Phase 1 output (/speckit-plan command)
├── quickstart.md         # Phase 1 output (/speckit-plan command)
└── tasks.md              # Phase 2 output (/speckit-tasks command - NOT created by /speckit-plan)
```

`contracts/`는 생성하지 않는다 — 이 기능은 다른 시스템/사용자에게 노출하는 API·CLI·UI 인터페이스가 없는, 순수 개인용 정적 문서 산출물이다(FR-006, FR-007, FR-008로 분류기·서비스화가 명시적으로 범위 밖).

### 산출물 (repository root)

```text
taxonomy/
└── taxonomy.md           # 이 기능의 실제 산출물: 통합 라벨 집합 문서 (카테고리 → 라벨 계층 +
                           # 라벨별 정의/예시/판별기준 + 출처 태그 매핑 기록, 전부 한 문서 안에)
```

**Structure Decision**: 소스 코드 프로젝트가 아니므로 src/tests 구조를 적용하지 않는다. 최종 학습 자료는 리포지토리 루트의 `taxonomy/taxonomy.md` 단일 Markdown 파일에 둔다 — User Story 1·3과 SC-004가 "문서 하나만으로" 학습 계획 수립·매핑 조회가 가능해야 한다고 요구하므로, 라벨 계층과 출처 태그 매핑을 별도 파일로 쪼개지 않고 한 문서에 통합한다(근거: research.md Decision 1·2). `specs/001-algorithm-label-taxonomy/`는 이 기능을 계획·설계하는 spec-kit 산출물 전용이며, 최종 학습 자료 자체와는 구분한다.

## Complexity Tracking

*Constitution Check에서 위반이 발견되지 않아 이 섹션은 해당 없음(N/A).*
