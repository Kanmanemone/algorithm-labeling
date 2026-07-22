# Data Model: 알고리즘 문제 라벨 통합 분류체계(Taxonomy) 구축

**Feature**: [spec.md](./spec.md) | **Date**: 2026-07-22

이 데이터 모델은 데이터베이스 스키마가 아니라, `taxonomy/taxonomy.md` 한 문서 안에서 각 엔티티가 어떤 필드를 가지고 어떻게 연결되는지를 정의한다(research.md Decision 1: Markdown 단일 문서).

## Entities

### Category (상위 카테고리)

라벨 집합의 최상위 분류 단위. spec.md Key Entities 참고.

| Field | Type | Required | Notes |
|---|---|---|---|
| name | string | Yes | 문서 전체에서 고유. 예: 자료구조, 그래프, 탐색, DP |
| labels | Label[] | Yes (≥1) | 이 카테고리에 속한 하위 라벨 목록 |

**Validation rules**:
- 카테고리는 Label을 최소 1개 이상 가져야 한다(빈 카테고리 없음).
- 카테고리 아래에는 Label만 올 수 있고, 그 아래 추가 하위 분류(3단계)는 존재할 수 없다(spec.md FR-002, SC-003).

### Label (하위 태그)

실제 학습·판별의 단위. spec.md Key Entities, Clarifications 참고.

| Field | Type | Required | Notes |
|---|---|---|---|
| name | string | Yes | 문서 전체에서 고유 |
| category | Category (단일 참조) | Yes | 정확히 하나의 상위 카테고리에만 소속(단일 부모, 다중 소속 불가 — FR-002) |
| definition | text | Yes | 이 라벨이 가리키는 개념의 정의 |
| representative_examples | Example[] | Yes (≥1) | 이름·출처·링크만 참조, 문제 원문 비복제(FR-005) |
| discriminating_criteria | text | Yes | 유사 라벨과 구분되는 기준. 병합 판단이 애매했던 경우 "명확히 구분하기 어려움"을 포함(FR-003) |

**Validation rules**:
- name, category, definition, representative_examples(≥1), discriminating_criteria 다섯 필드 모두 빈 값이면 안 된다(FR-003, SC-002).
- 개념적으로 여러 카테고리에 걸치는 라벨이라도 category는 하나만 지정하고, 그 연관성은 discriminating_criteria에 서술한다(spec.md Clarifications Q1).
- 병합 여부가 애매했던 라벨은 discriminating_criteria에 그 사실을 명시해야 한다(spec.md Clarifications Q3, Edge Cases).

### Example (대표 예시) — Label의 하위 값 객체

| Field | Type | Required | Notes |
|---|---|---|---|
| problem_name | string | Yes | 문제 이름 |
| source | string | Yes | 출처(solved.ac / LeetCode / Codeforces / 프로그래머스 / 기타) |
| link | string (URL) | Yes | 문제로 연결되는 링크 |

**Validation rules**: 문제 원문(지문) 텍스트를 포함하지 않는다(FR-005). 값 객체이므로 독립적인 식별자를 갖지 않는다.

### Source Tag Mapping (출처 태그 매핑)

각 출처의 원본 태그가 통합 라벨 집합의 어느 라벨로 흡수되었는지 추적하는 기록. spec.md Key Entities, FR-004 참고.

| Field | Type | Required | Notes |
|---|---|---|---|
| source | enum | Yes | solved.ac / LeetCode / Codeforces / 프로그래머스 (그 외 신뢰할 만한 추가 출처가 채택된 경우 그 이름) |
| original_tag_name | string | Yes | 해당 출처에서 사용하는 원래 태그 이름(원어 그대로) |
| mapped_labels | Label[] (참조) | Yes (≥1) | 이 원본 태그가 대응하는 병합 라벨. 하나의 원본 태그가 여러 라벨로 쪼개질 수 있음 |
| note | text | No | 병합 판단 근거 — 특히 새 카테고리 신설, 애매한 병합 판정 등 Edge Case가 발생했을 때 그 근거를 남긴다 |

**Validation rules**:
- 네 출처(FR-001) 각각의 공개 태그 목록에 있는 모든 original_tag_name이 최소 한 개의 SourceTagMapping 레코드로 존재해야 한다(SC-001, 완전성 100%).
- 이 레코드 전체는 FR-001의 일괄 병합 절차가 끝난 뒤, 전체 태그 목록을 대상으로 한 번에 작성을 완료한다(spec.md Clarifications Q2).

## Relationships

```
Category (1) ──< (N) Label (N) ──< (N) SourceTagMapping.mapped_labels
                    │
                    └──< (N) Example (값 객체, Label에 내장)
```

- Category → Label: 1:N, 단일 부모(각 Label은 정확히 하나의 Category에 속함).
- Label → SourceTagMapping: 1:N — 하나의 Label이 여러 출처·여러 원본 태그로부터 매핑받을 수 있음(다대다이지만 매핑 레코드 기준으로는 Label을 참조하는 방향).
- Label → Example: 1:N, Example은 Label에 내장되는 값 객체.

## Lifecycle / State

이 데이터에는 상태 전이가 없다. spec.md FR-009에 따라 전체 taxonomy는 조사 시점 기준 정적 스냅샷이며, "완료" 이후 지속 갱신은 이번 기능 범위 밖이다.

## Document Layout Mapping (Markdown 표현)

`taxonomy/taxonomy.md` 한 문서 안에서 위 엔티티는 다음과 같이 표현한다(research.md Decision 1):

- `## <Category.name>` — Category 하나당 레벨-2 헤딩
- `### <Label.name>` — 그 아래 레벨-3 헤딩(3단계 초과 헤딩 금지 = SC-003의 문서 상 근거)
  - 정의, 대표 예시(이름/출처/링크 목록), 판별기준을 각각 하위 항목으로 기술
- 문서 말미에 `## 출처 태그 매핑` 섹션 — source / original_tag_name / mapped_labels / note를 표 형태로 나열(SourceTagMapping 레코드 전체)
