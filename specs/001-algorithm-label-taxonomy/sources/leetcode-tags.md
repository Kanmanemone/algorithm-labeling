# LeetCode 원시 태그 목록 (T003)

**조사 방법**: `leetcode.com/problemset/`의 토픽 필터 UI는 이 세션의 웹 조사 도구로 접근이 차단(403)되어, 사용자가 직접 페이지에서 복사해 붙여넣은 전체 토픽 목록을 원본으로 사용했다(2026-07-22).

**범위 축소 적용**: solved-ac-tags.md와 동일한 FR-010 기준(취업 준비·코딩 테스트·일반 알고리즘 학습에 실질적으로 쓰이는 태그만 채택)을 적용한다. LeetCode 태그는 solved.ac보다 이미 실용적인 편이라 제외 비율은 낮지만, 알고리즘 "기법"이 아니라 형식/구현 세부사항인 태그(Database, Shell, Concurrency 등)와 solved.ac에서 이미 제외 결정한 것과 대응되는 고급/희귀 기법은 동일한 기준으로 제외한다.

## 원본 전체 목록 (그대로 보존)

Array, String, Hash Table, Math, Dynamic Programming, Sorting, Greedy, Depth-First Search, Binary Search, Database, Bit Manipulation, Matrix, Tree, Prefix Sum, Breadth-First Search, Two Pointers, Heap (Priority Queue), Simulation, Counting, Graph Theory, Binary Tree, Stack, Sliding Window, Enumeration, Design, Backtracking, Number Theory, Union-Find, Linked List, Segment Tree, Ordered Set, Monotonic Stack, Divide and Conquer, Combinatorics, Trie, Queue, Bitmask, Recursion, Geometry, Binary Indexed Tree, Hash Function, Memoization, Binary Search Tree, Shortest Path, Topological Sort, String Matching, Rolling Hash, Game Theory, Monotonic Queue, Interactive, Data Stream, Brainteaser, Doubly-Linked List, Merge Sort, Randomized, Counting Sort, Iterator, Concurrency, Quickselect, Suffix Array, Sweep Line, Probability and Statistics, Minimum Spanning Tree, Bucket Sort, Shell, Reservoir Sampling, Eulerian Circuit, Radix Sort, Strongly Connected Component, Rejection Sampling, Biconnected Component

**합계**: 70개

## 채택 기준 적용 결과

### IN-SCOPE

Array, String, Hash Table, Math, Dynamic Programming, Sorting, Greedy, Depth-First Search, Binary Search, Bit Manipulation, Bitmask, Matrix, Tree, Prefix Sum, Breadth-First Search, Two Pointers, Heap (Priority Queue), Simulation, Counting, Graph Theory, Binary Tree, Stack, Sliding Window, Enumeration, Design, Backtracking, Number Theory, Union-Find, Linked List, Segment Tree, Monotonic Stack, Divide and Conquer, Combinatorics, Trie, Queue, Recursion, Geometry, Binary Indexed Tree, Memoization, Binary Search Tree, Shortest Path, Topological Sort, Game Theory, Monotonic Queue, Minimum Spanning Tree, Strongly Connected Component, Probability and Statistics

→ 47개. T006 병합 입력으로 사용. (수정: 초안에서 Bitmask가 Bit Manipulation과 중복으로 보여 누락됐던 것을 T009 자체 점검 중 발견해 추가함 — 둘 다 같은 "비트마스킹" 라벨로 병합)

### OUT-OF-SCOPE

- **알고리즘 기법이 아닌 형식/구현 범주** (FR-010 기준상 애초에 "알고리즘 유형" 라벨 대상이 아님): Database, Shell, Concurrency, Interactive, Iterator, Data Stream, Brainteaser
- **다른 IN-SCOPE 라벨의 구현 세부사항으로 흡수되어 별도 라벨이 불필요** (Sorting/Linked List/Hash Table 등에 흡수): Merge Sort, Counting Sort, Bucket Sort, Radix Sort, Doubly-Linked List, Hash Function
- **solved.ac에서 이미 제외 결정한 고급/희귀 기법과 대응** (일관성 유지): Ordered Set(≈splay/BBST류), String Matching·Rolling Hash(≈rabin_karp), Suffix Array, Sweep Line(≈sweeping), Randomized(≈randomization), Quickselect, Reservoir Sampling, Rejection Sampling, Eulerian Circuit(≈eulerian_path), Biconnected Component(≈bcc)

→ 이 항목들은 FR-004 매핑 기록에 "제외됨"으로 남긴다(T013). Database/Shell/Concurrency/Interactive/Iterator/Data Stream/Brainteaser는 "제외됨(알고리즘 유형이 아님, FR-010)"으로, 나머지는 "제외됨(다른 라벨에 흡수 또는 대회 전용 고급 기법, FR-010)"으로 구분해 기록한다.

## Notes

- Bitmask는 solved.ac의 `bitmask`와 동일 개념이라 T006에서 자동 병합 후보.
- Design은 "자료구조/시스템 설계" 인터뷰 유형으로, 코딩테스트 실전에서 실질적으로 자주 등장해 IN-SCOPE로 유지했다(solved.ac에는 대응 태그가 없어 LeetCode 고유 라벨이 될 가능성이 높음).
