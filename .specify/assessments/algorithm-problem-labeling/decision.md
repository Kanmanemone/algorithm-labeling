# Decision: 알고리즘 문제 라벨링(유형화) 시스템 — 라벨 집합(taxonomy) 구축

- **Slug**: algorithm-problem-labeling
- **Decided**: 2026-07-21
- **Verdict**: go
- **Artifacts reviewed**: intake.md, research.md, problem.md, concept.md

## Scorecard

| Criterion | Rating | Justification |
|-----------|--------|---------------|
| Problem validity | strong | 목표가 "개별 문제 라벨링"에서 "여러 공신력 있는 출처를 병합한, 정의·예시·판별기준을 갖춘 통합 라벨 집합"으로 명확히 좁혀지면서, 실제로 어디에도 존재하지 않는 구체적 산출물을 겨냥하게 됨(research.md 확인). 개인 학습이라는 명확한 사용자·용도도 확정됨. |
| Evidence strength | adequate | research.md가 solved.ac 태그 체계, LeetCode 토픽, Codeforces 태그, 프로그래머스 고득점 Kit 등 각 출처의 공개 문서 존재를 이미 인용으로 확인했고, 이는 새 접근(웹 검색 기반 문서 조사)의 실행 가능성을 직접 뒷받침함. 다만 "2단계 계층으로 정보 손실 없이 병합 가능한지", "최종 라벨 개수 규모"는 실제로 조사·병합해보기 전까지 미검증(concept.md에 명시된 가정)이라 `strong`까지는 아님. |
| Value vs. cost of inaction | adequate | problem.md의 "Cost of Inaction"이 지적한 대로 무료/유료 대안은 이미 존재해 방치해도 파국은 아니지만(가치가 아주 크진 않음), 재정의된 산출물(정의·예시·판별기준을 갖춘 병합 라벨 집합)은 그 대안들에도 없는 것으로 확인됨. 동시에 실행 비용(appetite)이 small–medium으로 매우 낮아져, 적은 비용으로 실질적 이득을 얻는 구도가 됨. |
| Feasibility / appetite fit | strong | 데이터 수집이 사이트 스크래핑이 아니라 공개 문서에 대한 웹 검색 조사로 확정되면서, 별도 크롤링/API 인프라 없이 조사·정리 작업만으로 수행 가능해짐. concept.md Option B는 명확한 절차와 산출물 형식(구조화 문서)을 갖춘, 규모가 작고 구체적인 계획임. |
| Strategic fit | adequate | 이 저장소 자체가 "algorithm-labeling"이라는 이름으로 만들어져 있어 이 프로젝트가 저장소의 핵심 목적과 일치함을 시사하지만, `.specify/memory/constitution.md`는 아직 미작성 템플릿 상태라 공식적으로 확정된 프로젝트 원칙과 대조하지는 못함. |
| Risk posture | strong | 이전 결정에서 가장 심각했던 리스크(백준/프로그래머스 등 문제풀이 사이트에 대한 크롤링·이용약관 위반 가능성)는 "크롤링"의 의미가 공개 문서 조사였음이 명확해지면서 사실상 해소됨. 남은 리스크(태그 병합 시 주관적 판단, 계층 깊이 통제, 판별기준 작성 분량)는 concept.md에서 이미 구체적 rabbit hole로 식별되었고, 얕은 계층 제한·Option C(예시 뱅크) 보류 등 설계 차원에서 선제적으로 완화됨. |

## Verdict & Rationale

이전 결정(needs-clarification)을 가로막았던 세 가지 약점 — 행동하지 않을 때의 가치(value vs. inaction), 전략적 정합성(strategic fit), 리스크 태세(risk posture) — 가 이번 재정의로 모두 개선됨. 특히 가장 무거웠던 법적/크롤링 리스크는 "크롤링"이 실제로는 공개 문서 조사를 뜻했다는 점이 확인되며 사실상 사라졌고, 목표 자체도 "존재하는 모든 문제에 라벨을 붙이는 것"에서 "공신력 있는 여러 출처를 병합한 라벨 집합 그 자체를 만드는 것"으로 좁혀지며 훨씬 다루기 쉬운 범위가 되었다. concept.md의 Option B는 이 좁혀진 목표에 정확히 맞는, 작고 구체적이며 인프라가 필요 없는 계획이다. Problem validity와 Evidence strength가 `adequate+` 기준을 충족하고, 신뢰할 만한 concept이 준비되어 있으므로 판정은 `go`이다. 다만 strategic fit(공식 constitution 부재)과 몇 가지 실행 세부사항(라벨 개수 규모, 2단계 계층의 충분성)은 여전히 `unknown`에 가까우므로, 이는 `kill`이나 재차 `needs-clarification`으로 되돌릴 사유가 아니라 `/speckit-specify` 단계에서 구체화하며 확인해 나갈 사항으로 넘긴다.

## If needs-clarification

해당 없음 — 판정은 `go`.

## If go — Handoff to `/speckit-specify`

- **Problem**: 개인 학습자(사용자 본인)가 알고리즘 문제 유형을 체계적으로 학습하려 하지만, BOJ/solved.ac·LeetCode·Codeforces·프로그래머스 등 공신력 있는 출처들이 각자 부분적이고 서로 호환되지 않는 분류 체계만 갖고 있어, 정의·예시·판별기준까지 갖춘 하나의 통합 라벨 집합이 존재하지 않는다.
- **Chosen approach**: concept.md Option B — 여러 공신력 있는 출처의 **공개 문서(공식 도움말/문서, 신뢰할 만한 커뮤니티 문서)를 웹 검색으로 조사**해 태그를 목록화하고, 유사·중복 개념을 병합하여 **상위 카테고리 + 하위 태그의 얕은 2단계 계층**으로 정리한 캐노니컬 라벨 집합을 만든다. 각 라벨(주로 하위 태그)에는 이름·정의·대표 예시(문제 원문 비복제, 이름/출처/링크로만 참조)·유사 라벨과 구분되는 판별 기준을 포함한다. 산출물은 코드가 아니라 구조화된 문서/데이터(Markdown 또는 YAML/JSON 등)이다.
- **In scope / out of scope**:
  - In scope: 다중 출처 조사·병합, 얕은 2단계 계층의 라벨 집합, 라벨별 정의·예시·판별기준 작성.
  - Out of scope: 개별 문제에 라벨을 실제로 부착하는 작업(라벨링 데이터셋 구축), "문제 입력 → 라벨 출력" 분류기 구현(후속 확장), 문제풀이 사이트에 대한 프로그램적 크롤링/스크래핑, 라벨별 다수 예시 문제 뱅크(Option C, 추후 검토), 공개 배포·서비스화, 문제 원문 복제·보관.
- **Success metrics**: (1) 조사 대상 출처들의 태그가 라벨 집합에 빠짐없이 반영되는 포괄성(baseline: 0 — 현재 통합 라벨 집합 없음), (2) 사용자 본인이 이 라벨 집합만으로 스스로 학습 계획을 세울 수 있는지(정성적 실사용 가능성).
- **Carried-forward open questions**:
  - [NEEDS CLARIFICATION: 상위/하위 2단계 계층만으로 여러 출처의 태그 다양성을 정보 손실 없이 담을 수 있는지 — 실제 조사·병합 과정에서 검증 필요.]
  - [NEEDS CLARIFICATION: 최종 라벨(하위 태그) 개수의 대략적 규모 — 정의·예시·판별기준 작성 분량을 가늠하기 위해 명세 단계에서 대략적 범위를 정할 필요.]
  - [NEEDS CLARIFICATION: 라벨 집합의 "완성" 기준 — 특정 시점에 조사 대상 출처들의 태그를 모두 흡수하면 완료로 볼지, 지속적으로 갱신되는 문서로 취급할지.]
  - [NEEDS CLARIFICATION: 지금 작성하는 정의·예시·판별기준 필드가 향후 "문제 입력 → 라벨 출력" 분류기 설계에 실제로 재사용 가능한 형태일지 — 분류기는 아직 설계 전이므로 확정된 요구사항은 아님.]
