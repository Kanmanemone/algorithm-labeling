---

description: "Task list template for feature implementation"
---

# Tasks: 알고리즘 문제 라벨 통합 분류체계(Taxonomy) 구축

**Input**: Design documents from `/specs/001-algorithm-label-taxonomy/`

**Prerequisites**: plan.md, spec.md, research.md, data-model.md, quickstart.md (모두 존재; `contracts/`는 없음 — plan.md 참고)

**Tests**: 이 기능은 소프트웨어가 아니라 사람이 읽는 문서를 만드는 작업이라 자동화 테스트가 없다(plan.md Technical Context). 검증은 quickstart.md의 수동 절차로 대신한다.

**Organization**: 태스크는 spec.md의 유저 스토리(P1/P2/P3)별로 묶여 있다. 단, FR-001(일괄 조사)·FR-004(일괄 병합 후 매핑 완성)에 따라 네 출처 조사는 모든 스토리의 공통 선행 작업(Foundational)이다.

## Format: `[ID] [P?] [Story] Description`

- **[P]**: Can run in parallel (different files, no dependencies)
- **[Story]**: Which user story this task belongs to (e.g., US1, US2, US3)
- Include exact file paths in descriptions

## Path Conventions

- 이 기능은 src/tests 구조를 쓰지 않는다(plan.md Structure Decision).
- 최종 산출물: `taxonomy/taxonomy.md` (리포지토리 루트)
- 조사 중간 산출물(최종 산출물 아님, 병합 작업용 메모): `specs/001-algorithm-label-taxonomy/sources/`

## Phase 1: Setup

**Purpose**: 최종 문서 뼈대 준비

- [X] T001 `taxonomy/` 디렉터리와 `taxonomy/taxonomy.md`를 생성하고, 제목·카테고리 섹션이 들어갈 자리·`## 출처 태그 매핑` 헤더만 있는 빈 뼈대를 작성한다 (plan.md Project Structure)

---

## Phase 2: Foundational (Blocking Prerequisites)

**Purpose**: 네 출처의 원시 태그 목록을 확보한다. FR-001에 따라 이 조사는 네 출처 모두를 먼저 전부 마친 뒤에야 병합 단계(User Story 1)로 넘어갈 수 있다.

**⚠️ CRITICAL**: 이 Phase가 끝나기 전에는 어떤 User Story 작업도 시작할 수 없다.

- [X] T002 [P] solved.ac 태그 체계를 `help.solved.ac`(태그/난이도 도움말)와 `solved.ac/problems/tags`(전체 태그 목록)에서 조사해 원시 태그 목록을 `specs/001-algorithm-label-taxonomy/sources/solved-ac-tags.md`에 기록한다 (research.md Decision 3, FR-001)
- [X] T003 [P] LeetCode 태그 체계를 `leetcode.com/problemset`의 토픽 필터 UI에서 조사해 원시 태그 목록을 `specs/001-algorithm-label-taxonomy/sources/leetcode-tags.md`에 기록한다 (research.md Decision 3, FR-001)
- [X] T004 [P] Codeforces 태그 체계를 `codeforces.com/problemset`의 태그 필터 UI에서 조사해 원시 태그 목록을 `specs/001-algorithm-label-taxonomy/sources/codeforces-tags.md`에 기록한다 (research.md Decision 3, FR-001)
- [X] T005 [P] 프로그래머스 태그 체계를 "코딩테스트 고득점 Kit" 페이지에서 조사해 원시 태그 목록을 `specs/001-algorithm-label-taxonomy/sources/programmers-tags.md`에 기록한다 (research.md Decision 3, FR-001)

**Checkpoint**: 네 출처의 원시 태그 목록이 모두 확보됨 — 이제 병합(User Story 작업)을 시작할 수 있다.

---

## Phase 3: User Story 1 - 통합 라벨 집합으로 학습 계획 세우기 (Priority: P1) 🎯 MVP

**Goal**: 네 출처의 태그를 병합해 상위 카테고리(단일 부모) + 하위 라벨의 2단계 계층을 만들고, 라벨마다 이름·정의·대표 예시·판별기준을 채운 `taxonomy/taxonomy.md`를 완성한다.

**Independent Test**: `taxonomy/taxonomy.md`를 열어 상위 카테고리와 그 아래 라벨 목록이 계층 구조로 보이고, 임의의 라벨을 펼치면 이름·정의·대표 예시·판별기준이 모두 있는지 확인한다.

### Implementation for User Story 1

- [X] T006 [US1] `specs/001-algorithm-label-taxonomy/sources/solved-ac-tags.md`·`leetcode-tags.md`·`codeforces-tags.md`·`programmers-tags.md`의 원시 태그를 서로 비교해 병합 여부를 판단한다 — 개념이 사실상 동일하면 병합, 범위/난이도가 달라 구분이 필요하면 별개 유지, 판단이 애매하면 기본적으로 별개 유지(보수적 분리)한다(FR-003, spec.md Clarifications). 판단 결과와 근거를 `specs/001-algorithm-label-taxonomy/sources/merge-notes.md`에 기록한다 (depends on: T002, T003, T004, T005)
- [X] T007 [US1] T006의 병합 결과로 상위 카테고리를 확정하고, 각 라벨을 정확히 하나의 상위 카테고리에 배정한다(단일 부모, 다중 소속 불가 — FR-002). `taxonomy/taxonomy.md`에 `## <카테고리명>` / `### <라벨명>` 헤딩 구조로 뼈대를 작성한다 (depends on: T006)
- [X] T008 [US1] `taxonomy/taxonomy.md`의 각 라벨 섹션에 이름·정의·대표 예시(문제 이름·출처·링크만, 원문 비복제, 최소 1개 — FR-005)·판별기준(유사 라벨과 구분되는 기준, 병합이 애매했던 라벨은 "명확히 구분하기 어려움"을 포함 — FR-003)을 작성한다 (depends on: T007)
- [X] T009 [US1] `taxonomy/taxonomy.md`를 quickstart.md의 SC-002(모든 라벨이 4개 필드를 빠짐없이 갖췄는지)·SC-003(카테고리→라벨 2단계를 초과하는 헤딩이 없는지) 절차로 자체 점검하고, 발견된 누락을 수정한다 (depends on: T008)

**Checkpoint**: User Story 1은 이 시점에서 완전히 동작하며 독립적으로 검증 가능하다(MVP).

---

## Phase 4: User Story 2 - 비슷한 라벨 간 구분하기 (Priority: P2)

**Goal**: 서로 다른 출처에서 유래했지만 이름·개념이 비슷한 라벨 쌍의 판별기준을, 실제로 두 라벨을 구분하는 데 쓸 수 있는 수준으로 보강한다.

**Independent Test**: 개념상 유사한 하위 태그 두 개를 골라, 각 라벨의 판별기준만 읽고 두 라벨의 차이를 설명할 수 있는지 확인한다.

### Implementation for User Story 2

- [X] T010 [US2] `specs/001-algorithm-label-taxonomy/sources/merge-notes.md`에서 "범위/난이도 차이로 분리" 또는 "애매해서 보수적으로 분리"로 기록된 유사 라벨 쌍을 전수 식별해 목록화한다 (depends on: T006)
- [X] T011 [US2] T010에서 식별한 유사 라벨 쌍마다 `taxonomy/taxonomy.md`의 판별기준을 재검토하고, 두 라벨을 실제로 구분하는 데 쓸 수 있는 수준으로 구체화한다 (depends on: T008, T010)
- [X] T012 [US2] 보강된 판별기준만 읽고 각 유사 라벨 쌍을 구분할 수 있는지 자체 검증한다(spec.md User Story 2 Acceptance Scenario) — 구분이 안 되는 쌍이 있으면 T011로 돌아가 보강한다 (depends on: T011)

**Checkpoint**: User Story 1과 2가 함께 독립적으로 동작한다.

---

## Phase 5: User Story 3 - 원본 출처 태그 대비 누락 여부 확인하기 (Priority: P3)

**Goal**: 네 출처의 원본 태그 전량이 어느 병합 라벨로 흡수됐는지 추적할 수 있는 매핑 기록을 `taxonomy/taxonomy.md`에 완성한다.

**Independent Test**: 네 출처 중 하나의 원본 태그 목록을 골라, 문서의 매핑 기록과 대조해 누락된 원본 태그가 없는지 확인한다.

### Implementation for User Story 3

- [X] T013 [US3] T006의 병합 판단 결과를 바탕으로, 네 출처 각각의 원본 태그마다 대응하는 병합 라벨(들)을 정리해 `taxonomy/taxonomy.md`의 `## 출처 태그 매핑` 섹션에 표로 작성한다. 새 카테고리 신설이나 애매한 병합 판정처럼 근거가 필요한 경우 note 칸에 남긴다(FR-004) (depends on: T006, T007)
- [X] T014 [US3] 네 출처 각각에 대해, 원시 태그 목록(T002~T005)의 태그가 매핑 표에 100% 존재하는지 대조한다(SC-001) — 누락된 태그가 있으면 T013으로 돌아가 보완한다 (depends on: T013)

**Checkpoint**: 세 User Story가 모두 독립적으로 기능한다.

---

## Phase 6: Polish & Cross-Cutting Concerns

**Purpose**: 전체 산출물에 대한 최종 점검

- [X] T015 [P] `taxonomy/taxonomy.md`에 대해 quickstart.md의 SC-001~004 절차를 처음부터 끝까지 실행해 최종 점검한다 (depends on: T009, T012, T014)
- [X] T016 `taxonomy/taxonomy.md` 서두에 문서 성격 안내(사용자 본인의 개인 학습 용도, 조사 시점 기준 정적 스냅샷임 — FR-008, FR-009)를 추가한다 (depends on: T001)

---

## Dependencies & Execution Order

### Phase Dependencies

- **Setup (Phase 1)**: 의존성 없음 — 바로 시작 가능
- **Foundational (Phase 2)**: Setup 완료 후 시작 — 모든 User Story를 막는(blocking) 단계
- **User Story 1 (Phase 3)**: Foundational 완료 후 시작 가능. 다른 스토리에 의존하지 않음
- **User Story 2 (Phase 4)**: Foundational 완료 후 시작 가능하지만, T011이 T008(US1의 판별기준 작성)을 소비하므로 실질적으로 US1 완료 후 진행
- **User Story 3 (Phase 5)**: Foundational 완료 후 시작 가능하지만, T013이 T007(US1의 카테고리·라벨 구조)을 소비하므로 실질적으로 US1 완료 후 진행
- **Polish (Phase 6)**: 원하는 모든 User Story 완료 후 진행

### User Story Dependencies

- **User Story 1 (P1)**: Foundational 이후 시작 가능. 다른 스토리에 의존하지 않음(진짜 독립)
- **User Story 2 (P2)**: Foundational 이후 시작 가능하나, 보강할 대상 라벨과 판별기준이 US1 산출물이므로 US1 완료 후 진행하는 것을 권장
- **User Story 3 (P3)**: Foundational 이후 시작 가능하나, 매핑할 대상 라벨 구조가 US1 산출물이므로 US1 완료 후 진행하는 것을 권장

### Within Each User Story

- US1: 병합 판단(T006) → 카테고리/라벨 구조(T007) → 필드 작성(T008) → 자체 점검(T009)
- US2·US3는 각각 US1의 결과물을 입력으로 받아 독립적인 결과물(판별기준 보강 / 매핑 표)을 추가한다

### Parallel Opportunities

- Foundational의 T002~T005(출처별 조사)는 서로 다른 파일이라 전부 병렬 실행 가능
- User Story 2와 User Story 3은 둘 다 US1 완료를 전제하지만, 서로 다른 산출물(판별기준 보강 vs. 매핑 표)을 다루므로 US1 완료 후에는 서로 병렬 진행 가능

---

## Parallel Example: Foundational

```bash
# 네 출처 조사를 동시에 진행:
Task: "solved.ac 태그 체계 조사 → specs/001-algorithm-label-taxonomy/sources/solved-ac-tags.md"
Task: "LeetCode 태그 체계 조사 → specs/001-algorithm-label-taxonomy/sources/leetcode-tags.md"
Task: "Codeforces 태그 체계 조사 → specs/001-algorithm-label-taxonomy/sources/codeforces-tags.md"
Task: "프로그래머스 태그 체계 조사 → specs/001-algorithm-label-taxonomy/sources/programmers-tags.md"
```

---

## Implementation Strategy

### MVP First (User Story 1 Only)

1. Phase 1: Setup 완료
2. Phase 2: Foundational 완료(네 출처 조사 — CRITICAL, 모든 스토리를 막음)
3. Phase 3: User Story 1 완료
4. **STOP and VALIDATE**: quickstart.md의 SC-002·SC-003 절차로 User Story 1을 독립적으로 검증
5. 이 시점에서 이미 "하나의 문서로 학습 계획 세우기"라는 핵심 가치는 제공됨

### Incremental Delivery

1. Setup + Foundational 완료 → 병합 준비 완료
2. User Story 1 추가 → 독립 검증 → MVP로 사용 가능
3. User Story 2 추가 → 독립 검증 → 유사 라벨 구분이 쉬워짐
4. User Story 3 추가 → 독립 검증 → 출처 누락 없음을 스스로 확인 가능
5. Polish로 SC-001~004 전체 재확인 및 문서 서두 안내 추가

---

## Notes

- [P] tasks = 서로 다른 파일, 의존성 없음
- [Story] 라벨은 태스크를 특정 User Story에 매핑해 추적성을 제공한다
- 이 기능에는 자동화 테스트가 없다 — 대신 각 스토리의 Independent Test와 quickstart.md 절차로 검증한다
- `specs/001-algorithm-label-taxonomy/sources/*.md`는 병합 작업용 중간 산출물이며, 최종 산출물이 아니다(plan.md 참고)
- 애매한 병합 판단은 항상 보수적 분리가 기본값이다(FR-003) — 병합할지 확신이 서지 않으면 분리하고 넘어간다

---

## Phase 7: Convergence

- [X] T017 `taxonomy/taxonomy.md`의 61개 라벨 헤딩과 출처 태그 매핑 표의 라벨명을 "한글 (English)" 형식(예: "이분 탐색 (Binary Search)")으로 갱신 — 해당 라벨에 대응하는 solved.ac/LeetCode/Codeforces 원본 태그 중 가장 대표적인 영어 표현을 괄호 안에 병기 per FR-003 (partial)
- [X] T018 `README.md`의 전체 라벨 목록(카테고리·라벨 링크 텍스트)을 `[**한글**&nbsp;&nbsp;&nbsp;&nbsp;*English*]` 형식(볼드체 한글 + 4칸 간격 + 괄호 없이 이탤릭체 영문)으로 갱신하고, 앵커 링크는 `taxonomy.md`의 실제 헤딩 슬러그와 다시 일치시킴(영문 병기로 헤딩 텍스트가 바뀌면 앵커도 바뀜) per FR-003 (partial)
- [X] T019 "오프라인 쿼리" 라벨의 대표 예시(`taxonomy.md` 오프라인 쿼리 절)를 오프라인 쿼리 기법에 정확히 부합하는 검증된 문제(이름·출처·링크)로 교체 per FR-005 (partial)
- [X] T020 "네트워크 유량" 라벨의 대표 예시를 구체적인 이름·출처·링크를 갖춘 검증된 문제로 교체 per FR-005 (partial)
- [X] T021 "강한 연결 요소" 라벨의 대표 예시를 SCC 개념에 정확히 부합하는 검증된 문제로 교체 per FR-005 (partial)
- [X] T022 "다각형과 선분 기하" 라벨의 대표 예시를 신발끈 공식/선분 교차 판정에 정확히 부합하는 검증된 문제로 교체 per FR-005 (partial)

---

## Phase 8: Convergence

- [X] T023 `README.md`의 잘못된 앵커 링크 15개를 실제 GitHub 슬러그로 수정 per tasks.md T018 (contradicts) — 영문 표기에 공백으로 둘러싸인 `/` 또는 `&`가 있는 라벨(예: "Stack / Queue / Deque", "Set & Map")은 GitHub 슬러거가 구두점만 삭제하고 남은 공백 2개를 하이픈 2개로 바꾸므로, 해당 구간을 하이픈 1개가 아닌 2개로 교정해야 한다. 대상: 구현·기본기, 파싱/수식 처리, 스택/큐/덱, 모노토닉 스택/큐, 우선순위 큐/힙, 집합과 맵, 누적합과 좌표 압축, 이분 그래프와 매칭, 분할 정복(카테고리), 완전탐색과 백트래킹, 최대공약수와 최소공배수, 소수 판정과 소인수분해, 조합론과 확률, 확률과 통계, 다각형과 선분 기하

---

## Phase 9: Convergence

- [X] T024 `taxonomy/taxonomy.md`에서 백준(BOJ)/acmicpc.net 링크를 대표 예시로 쓰는 11개 라벨을 전부 살아있는 다른 출처(LeetCode/Codeforces/프로그래머스)의 문제로 교체 per FR-005 (contradicts) — 백준 사이트 서비스가 종료되어 acmicpc.net으로의 링크는 더 이상 유효한 대표 예시가 될 수 없음. 향후에도 acmicpc.net/백준 링크는 사용하지 않는다. 대상 라벨과 현재(교체 대상) 예시: 세그먼트 트리(BOJ 2042 구간 합 구하기), 유니온 파인드(BOJ 1717 집합의 표현), BFS(BOJ 2178 미로 탐색), 최단 경로(BOJ 1753 최단경로), 최소 스패닝 트리(BOJ 1197), 네트워크 유량(BOJ 6086 최대 유량), 강한 연결 요소(BOJ 2150), 배낭 문제(BOJ 12865 평범한 배낭), 최장 증가 부분 수열(BOJ 11053), KMP 문자열 매칭(BOJ 1786 찾기), 다각형과 선분 기하(BOJ 2166 다각형의 넓이)
