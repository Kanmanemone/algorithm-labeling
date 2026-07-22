# Phase 0 Research: 알고리즘 문제 라벨 통합 분류체계(Taxonomy) 구축

**Feature**: [spec.md](./spec.md) | **Date**: 2026-07-22

이 기능은 소프트웨어가 아니라 사람이 읽는 문서를 만드는 작업이라, Technical Context의 대부분(언어, 의존성, 성능 등)은 N/A다. 실제로 결정이 필요했던 항목은 산출물 형식·위치, 1차 조사 대상 페이지, 검증 방식 네 가지였다.

## Decision 1: 산출물 형식 — Markdown 단일 문서

**Decision**: 최종 산출물은 YAML/JSON 구조화 데이터가 아니라 Markdown 단일 문서(`taxonomy/taxonomy.md`)로 작성한다.

**Rationale**: spec.md의 SC-004("문서만으로 학습 순서를 정할 수 있다")와 User Story 1·3이 전제하는 것은 사람이 눈으로 읽는 단일 문서다. 개인 학습자 본인이 텍스트 에디터/Markdown 뷰어만으로 열람·수정할 수 있어야 하며, 별도 파서나 렌더링 도구가 필요 없어야 한다. spec.md Assumptions는 "정의·예시·판별기준이 향후 분류기에 재사용될 수도 있지만 확정 요구사항은 아니다"라고 명시하므로, 지금 시점에는 기계 판독 최적화보다 사람의 가독성을 우선한다.

**Alternatives considered**:
- **YAML/JSON 구조화 데이터**: 향후 분류기 재사용에는 유리하지만, 사람이 직접 훑어보기 불편하고 별도 뷰어가 필요해 개인 학습 용도(SC-004)에 맞지 않는다. 아직 분류기 설계가 확정되지 않은 시점에 기계 판독 형식에 미리 맞추는 것은 과설계(premature optimization)다.
- **Markdown + YAML frontmatter 하이브리드**: 두 형식의 이점을 일부 취하지만 개인용 소규모 문서 하나에 적용하기엔 복잡도 대비 이득이 적다.

## Decision 2: 산출물 위치 — 리포지토리 루트의 `taxonomy/`

**Decision**: 최종 문서는 `specs/001-algorithm-label-taxonomy/` 하위가 아니라 리포지토리 루트의 `taxonomy/taxonomy.md`에 둔다.

**Rationale**: 이 리포지토리 자체가 "algorithm-labeling"이라는 이름으로 만들어졌고(.specify/assessments/algorithm-problem-labeling/decision.md의 strategic fit 참고), 이 산출물이 리포지토리의 핵심 목적이다. `specs/.../`는 spec-kit의 기획 산출물(spec/plan/research 등) 저장 용도이므로, 실제 사용할 학습 자료와 계획 문서를 같은 디렉터리에 섞으면 나중에 찾기 어렵다.

**Alternatives considered**:
- `specs/001-algorithm-label-taxonomy/taxonomy.md`: spec-kit 산출물과 최종본이 뒤섞여 발견성이 떨어짐.
- `docs/taxonomy.md`: 범용적인 관례지만, 이 리포지토리에는 아직 다른 `docs/` 콘텐츠가 없어 불필요한 깊이만 추가함.

## Decision 3: 1차 조사 대상 페이지 고정

**Decision**: 네 출처의 태그 체계는 아래 공개 페이지를 1차 출처로 조사한다(모두 웹 열람만 필요, 프로그램적 접근 없음 — FR-001).

| 출처 | 1차 조사 페이지 |
|---|---|
| solved.ac | `help.solved.ac`(태그/난이도 도움말), `solved.ac/problems/tags`(전체 태그 목록) |
| LeetCode | `leetcode.com/problemset`(토픽 필터 UI — LeetCode는 태그를 별도 문서로 공개하지 않고 이 필터 UI가 사실상 유일한 공식 태그 목록 소재) |
| Codeforces | `codeforces.com/problemset`(태그 필터 UI — 공식 페이지) |
| 프로그래머스 | `school.programmers.co.kr`의 "코딩테스트 고득점 Kit" 페이지 |

**Rationale**: `.specify/assessments/algorithm-problem-labeling/research.md`에서 이미 이 네 출처의 공개 문서 존재가 확인되었다(solved.ac 도움말, 프로그래머스 고득점 Kit, Codeforces 공식 API/블로그, LeetCode 공식 토픽 태그). 이번 계획 단계에서 LeetCode·Codeforces의 정확한 1차 페이지를 웹 검색으로 재확인한 결과, 두 사이트 모두 별도의 "전체 태그 목록" 문서 페이지 대신 problemset 화면의 태그 필터 UI가 공식 소스임을 확인했다.

**Alternatives considered**: `tony9402/baekjoon`, `berknology/leetcode-classifier` 같은 커뮤니티 재큐레이션 저장소를 1차 출처로 삼는 안 — 이미 사람이 재해석·재분류한 2차 자료라 원본 출처의 태그 체계를 있는 그대로 반영하지 못할 위험이 있다. 참고 자료로는 남기되 1차 출처로는 채택하지 않는다.

## Decision 4: 검증 방식 — 체크리스트 기반 수동 검증

**Decision**: 자동화 테스트 스위트 대신, Success Criteria(SC-001~004) 각각을 quickstart.md의 수동 점검 절차로 변환해 검증한다.

**Rationale**: 산출물이 코드가 아니라 문서이므로 unit/integration test 프레임워크가 적용 대상이 아니다. 라벨 수가 사전 목표치 없이 자연 발생하지만 성격상 수십 개 수준(concept.md에서 예시로 언급된 20~40개대)일 것으로 예상되어, 수동 대조로 충분히 검증 가능한 규모다.

**Alternatives considered**: 출처 태그 매핑 완전성을 자동 대조하는 스크립트 작성 — 이는 결과적으로 별도 코드를 만드는 일이라 "산출물은 코드가 아니다"라는 이번 기능의 성격(Technical Context)과 어긋나고, 이 규모에서는 이득 대비 과한 작업이다.

## Resolved Technical Context

Phase 0 진입 시 Technical Context에 남아 있던 미확정 항목(산출물 형식·위치, 조사 대상 페이지, 검증 방식)은 위 Decision 1~4로 모두 해소되었다. 남은 NEEDS CLARIFICATION 없음.
