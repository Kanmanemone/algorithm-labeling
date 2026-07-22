# Quickstart: 알고리즘 문제 라벨 통합 분류체계(Taxonomy) 검증 가이드

**Feature**: [spec.md](./spec.md) | **Data model**: [data-model.md](./data-model.md)

이 기능은 실행 가능한 코드가 없으므로 "빌드/실행" 절차가 없다. 이 문서는 산출물(`taxonomy/taxonomy.md`)이 완성됐을 때, spec.md의 Success Criteria를 사람이 직접 확인하는 절차를 안내한다.

## Prerequisites

- 별도 설치나 툴체인 불필요. Markdown을 읽을 수 있는 텍스트 에디터 또는 뷰어만 있으면 된다.
- 검증 중 원본 출처와 대조하려면 인터넷 접속이 필요하다(research.md Decision 3의 네 페이지: `help.solved.ac`/`solved.ac/problems/tags`, `leetcode.com/problemset`, `codeforces.com/problemset`, 프로그래머스 고득점 Kit 페이지).

## 산출물 위치

```
taxonomy/taxonomy.md
```

## 검증 절차

### SC-001 — 출처 태그 100% 매핑

1. `taxonomy/taxonomy.md`의 "출처 태그 매핑" 섹션을 연다.
2. 출처 하나를 고른다(예: Codeforces).
3. `codeforces.com/problemset`의 태그 필터 UI에서 그 출처가 실제로 노출하는 태그 전체 목록을 센다.
4. 매핑 섹션에서 해당 출처(`source` = Codeforces)로 필터링된 행 수·태그명 목록과 3번의 목록을 대조한다.
5. 네 출처 모두에 대해 반복한다. 어느 한 출처라도 매핑 섹션에 없는 원본 태그가 있으면 SC-001 미충족.

### SC-002 — 라벨 완성도 100%

1. 문서의 모든 `### <Label>` 섹션을 훑는다.
2. 각 라벨마다 이름, 정의, 대표 예시(1개 이상), 판별기준 네 항목이 모두 채워져 있는지 확인한다(data-model.md Label validation rules).
3. 빠진 항목이 있는 라벨을 목록화한다 — 하나라도 있으면 SC-002 미충족.

### SC-003 — 계층 깊이 2단계 준수

1. 문서의 목차(헤딩 구조)를 확인한다.
2. `##`(Category) 아래 `###`(Label)만 있고, `####` 이상의 하위 헤딩이 라벨 내용 안에 없는지 확인한다(정의/예시/판별기준은 헤딩이 아니라 본문 항목으로 표현되므로 이 규칙에 저촉되지 않는다).

### SC-004 — 문서만으로 학습 계획 수립 가능

1. 원본 출처 사이트를 열지 않은 상태로, `taxonomy/taxonomy.md`만 보고 학습 순서(어떤 카테고리부터 어떤 라벨을 공부할지)를 실제로 한 번 짜본다.
2. 계획을 짜는 도중 정의나 판별기준이 불충분해 원본 사이트를 다시 찾아가야 했는지 스스로 점검한다.
3. 원본 사이트 재방문 없이 계획을 완성할 수 있었다면 SC-004 충족(정성적 자가평가).

## 완료 판정

위 4개 기준을 모두 충족하면 spec.md FR-009가 정의한 "완성된 정적 스냅샷"으로 간주한다. 이후 출처 태그 체계 변경 반영은 이번 기능 범위 밖의 별도 후속 작업이다(spec.md Assumptions).
