# Codeforces 원시 태그 목록 (T004)

**조사 방법**: `codeforces.com/problemset`의 태그 필터 UI는 웹 조사 도구로 접근이 차단(403)됐지만, Codeforces의 공식 공개 JSON API(`codeforces.com/api/problemset.problems`)는 정상 응답해 전체 문제 데이터의 `tags` 필드에서 고유 태그 전량을 직접 추출했다(2026-07-22). API 응답 기반이므로 페이지 조사보다 오히려 더 신뢰도 높은 1차 확인이다.

**범위 축소 적용**: solved-ac-tags.md·leetcode-tags.md와 동일한 FR-010 기준을 적용한다.

## 원본 전체 목록 (그대로 보존, API에서 추출)

2-sat, binary search, bitmasks, brute force, chinese remainder theorem, combinatorics, communication, constructive algorithms, data structures, dfs and similar, divide and conquer, dp, dsu, expression parsing, fft, flows, game matchings, games, geometry, greedy, hashing, implementation, interactive, math, matrices, meet-in-the-middle, number theory, probabilities, schedules, shortest paths, sortings, string suffix structures, strings, ternary search, trees, two pointers

**합계**: 36개

## 채택 기준 적용 결과

### IN-SCOPE

binary search, bitmasks, brute force, combinatorics, constructive algorithms, data structures, dfs and similar, divide and conquer, dp, dsu, expression parsing, flows, games, geometry, greedy, hashing, implementation, math, number theory, probabilities, shortest paths, sortings, strings, ternary search, trees, two pointers

→ 26개. T006 병합 입력으로 사용.

### OUT-OF-SCOPE

- 2-sat (solved.ac `2_sat`과 동일 개념, 이미 제외 결정)
- chinese remainder theorem (solved.ac `crt`와 동일 개념, 이미 제외 결정)
- communication, interactive (문제 형식 범주이지 알고리즘 기법이 아님 — LeetCode의 Interactive와 동일 사유로 제외)
- fft (solved.ac `fft`와 동일 개념, 이미 제외 결정)
- game matchings (게임이론+매칭의 고급 결합 기법, solved.ac `general_matching`과 유사 사유로 제외)
- matrices (행렬 거듭제곱 등 선형대수 기법 — solved.ac `linear_algebra`와 대응, 제외. **주의**: LeetCode의 "Matrix"는 격자形 자료 자체를 가리키는 IN-SCOPE 라벨이라 이름은 비슷해도 서로 다른 개념이며 병합 대상이 아니다 — T006에서 혼동하지 않도록 별도 기록)
- meet-in-the-middle (solved.ac `mitm`과 동일 개념, 이미 제외 결정)
- schedules (스케줄링 이론, 희귀·고급 주제로 제외)
- string suffix structures (solved.ac `suffix_array`/`suffix_tree`와 동일 계열, 이미 제외 결정)

→ FR-004 매핑 기록에 "제외됨"으로 남긴다(T013).

## Notes

- Codeforces 태그는 solved.ac·LeetCode와 겹치는 항목이 많아(binary search, dp, greedy, geometry 등) T006 병합에서 대부분 기존 병합 라벨에 합류할 것으로 예상된다.
- "matrices"(CF, OUT) vs "Matrix"(LeetCode, IN)의 이름 유사·개념 상이 사례는 병합 시 오판을 막기 위해 명시적으로 분리 기록했다.
