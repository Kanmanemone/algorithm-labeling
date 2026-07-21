# Decision: 알고리즘 문제 라벨링(유형화) 시스템

- **Slug**: algorithm-problem-labeling
- **Decided**: 2026-07-21
- **Verdict**: needs-clarification
- **Artifacts reviewed**: intake.md, research.md, problem.md, concept.md

## Scorecard

| Criterion | Rating | Justification |
|-----------|--------|---------------|
| Problem validity | adequate | 실제로 근거 있는 고충임 (취업준비생이 solved.ac, 프로그래머스, LeetCode, Codeforces 등 플랫폼별로 서로 다른 분류 체계를 일일이 대조해야 함). 다만 심각도는 낮음 — 리서치 결과 이는 불편한 수준이지 진행을 막는 수준은 아님. |
| Evidence strength | adequate | research.md는 전체 확신도를 스스로 "medium"으로 평가함. 선행 사례 조사는 인용이 잘 되어 있고 탄탄하지만, 몇몇 핵심 주장(시장 공백 종합 분석, 이용약관 해석)은 명시적으로 ASSUMPTION(가정)으로 표시되어 있고, 백준/프로그래머스의 실제 이용약관 원문은 확인하지 못함. |
| Value vs. cost of inaction | weak | problem.md의 "Cost of Inaction" 항목 자체가 이미 신뢰할 만한 무료(solved.ac, 프로그래머스 Kit, LeetCode 태그) 및 유료(코드트리, AlgoExpert) 대안이 존재한다고 결론 내림 — 즉 아무것도 안 해도 감내할 만한 현 상태가 유지되므로, 구축의 명분은 명확한 고충 해소가 아니라 아직 검증되지 않은 좁은 차별점(플랫폼 간 통합)에 의존함. |
| Feasibility / appetite fit | adequate | concept.md의 Option B는 small–medium 규모이며 기존 API(Codeforces 공식, solved.ac 비공식)로 기술적으로 실현 가능함. 다만 실제 범위(어떤 소스를, 첫 단계 규모를 얼마로)는 기본적인 범위 설정 질문들이 해소되기 전까지는 확정할 수 없음. |
| Strategic fit | unknown | `.specify/memory/constitution.md`가 아직 미작성 템플릿 상태 — 이 아이디어를 대조해 볼 확정된 프로젝트 원칙이 아직 없음. |
| Risk posture | weak | 주요 리스크(백준/프로그래머스의 데이터 수집 관련 이용약관 미확인, solved.ac의 명시적으로 불안정한 비공식 API, 분류 체계 설계의 범위 확장 위험, 이미 포화된 기존 시장)는 파악되었으나 아직 구체적인 결정으로 완화되지 않음 — Option B는 설계상(API 우선, 텍스트 재배포 안 함) 노출을 줄이지만 미해결 상태인 이용약관 문제 자체를 해결해주지는 않음. |

## Verdict & Rationale

Problem validity와 Evidence strength는 둘 다 `go` 판정에 필요한 `adequate+` 기준을 충족하며, concept.md에서도 신뢰할 만하고 적정 규모의 추천 옵션(Option B)을 도출했음. 좁게 보면 이것만으로 통과할 수도 있음. 하지만 6개 기준 중 세 가지 — value vs. inaction, strategic fit, risk posture — 가 `weak`/`unknown`에 머물러 있고, problem.md(8개 항목)와 concept.md(5개 항목) 모두 구현 세부사항 수준이 아니라 대부분 *범위 자체를 정의하는* 미해결 질문들을 상당수 안고 있음: 어떤 소스가 범위에 포함되는지, 분류 체계의 축(axis)이 무엇인지, 그리고 가장 결정적으로 이것이 개인용 학습 도구인지 공개 데이터셋/제품인지. 이 마지막 질문 하나만으로도 리스크 수준(법적 노출), 적정 규모(개인용 소형 도구 vs. 다중 소스 공개 서비스), 그리고 현재 자리표시자(placeholder) 상태인 problem.md의 성공 지표가 크게 달라짐. 지금 상태로 `/speckit-specify`에 넘기면 `/speckit-clarify`가 정리해야 할 구현 디테일이 아니라, 원래 이 평가 파이프라인이 해소해야 할 범위 자체의 미지수를 안고 명세를 작성하게 되는 셈임. 따라서 정직한 판정은 `go`가 아니라 `needs-clarification`임 — 아이디어 자체는 유망하며 폐기(kill)하는 것은 아니지만, 아직 명세를 작성할 만큼 초점이 명확하지 않음.

## If needs-clarification

- **Blocking questions**:
  - [NEEDS CLARIFICATION: 최종 용도가 개인/소규모 학습 도구인가, 아니면 공개 데이터셋/서비스인가? 이 질문 하나에 대한 답이 성공 지표, 법적 리스크 허용 범위, 적정 규모 등 하위의 애매함 대부분을 해소함.]
  - [NEEDS CLARIFICATION: 첫 번째 제한된 범위에는 어떤 소스가 포함되는가 — 예를 들어 API 접근이 가능한 solved.ac(백준) + Codeforces만으로 시작하고, 공식 API가 없는 소스는 나중으로 미루는 방식은 어떤가?]
  - [NEEDS CLARIFICATION: 초안 수준에서 공통 분류 체계의 축/차원은 무엇인가(예: 자료구조 vs. 기법 vs. 난이도 vs. 기업 등) — 명세 작성 전에 Option B가 제안한 "약 15~25개 카테고리"의 범위를 정할 수 있을 정도로.]
  - [NEEDS CLARIFICATION: 데이터 수집 방식을 API 전용/문제 텍스트 스크래핑 없음으로 확정할 것인가, 그리고 그렇게 하면 시작 전에 백준/프로그래머스 이용약관에 대한 직접적인 법적 검토 없이도 충분한가?]
- **Revisit stage**: `define` — 이 항목들은 추가 문헌 조사로는 답할 수 없고 아이디어 소유자가 직접 결정해야 하는 범위 설정 사항임. 답이 정해지면 `/speckit-assess-define`을 다시 실행해 `problem.md`의 non-goals와 성공 지표를 다듬고, 이후 `/speckit-assess-shape`로 좁혀진 범위에 맞춰 Option B의 적정 규모를 재확인한 뒤, `/speckit-assess-decide`로 돌아올 것.

## If go — Handoff to `/speckit-specify`

Not applicable — verdict is `needs-clarification`.
