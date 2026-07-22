# 알고리즘 문제 라벨 통합 분류체계 (Taxonomy)

개인 학습자 본인을 위한 학습 자료입니다. solved.ac, LeetCode, Codeforces, 프로그래머스 네 출처의 공개 태그 체계를 조사·병합해 만든, 조사 시점(2026-07-22) 기준의 **정적 스냅샷**입니다. 이후 각 출처의 태그 체계가 바뀌어도 이 문서가 자동으로 갱신되지는 않으며, 필요하면 별도 후속 작업으로 다룹니다.

범위: 취업 준비·코딩 테스트·일반적인 알고리즘 학습에 실질적으로 쓰이는 태그만 채택했고, ICPC/IOI 등 최상위권 대회 전용 고급 기법은 제외했습니다(자세한 사유는 문서 말미 "출처 태그 매핑" 참고). 예시는 문제 원문을 복제하지 않고 이름·출처·링크로만 참조합니다.

---

## 구현·기본기

### 구현

**정의**: 특정 알고리즘 이론보다는 문제에서 요구하는 절차를 정확하고 꼼꼼하게 코드로 옮기는 능력이 핵심인 유형. 배열/행렬을 그대로 다루는 문제(LeetCode의 "Array", "Matrix")도 여기 포함된다.

**대표 예시**: "Spiral Matrix" — LeetCode — https://leetcode.com/problems/spiral-matrix/

**판별기준**: 시간에 따라 상태가 변하는 과정을 흉내 내야 하면 **시뮬레이션**으로, 수식/구조화된 문자열을 해석해야 하면 **파싱/수식 처리**로 넘어간다. 그 외 "정해진 규칙대로 정확히 구현"만 요구하면 이 라벨.

---

### 시뮬레이션

**정의**: 게임 규칙, 로봇 이동, 물리적 과정 등 시간이 흐르며 상태가 단계적으로 바뀌는 과정을 그대로 코드로 재현하는 유형.

**대표 예시**: "Game of Life" — LeetCode — https://leetcode.com/problems/game-of-life/

**판별기준**: **구현**과 겹치지만, 시뮬레이션은 "각 턴/스텝마다 상태 전이 규칙을 반복 적용"하는 명확한 시간 축이 있다는 점이 다르다.

---

### 파싱/수식 처리

**정의**: 수식이나 구조화된 문자열 입력을 정해진 문법에 따라 해석(파싱)해 계산하거나 변환하는 유형.

**대표 예시**: "Basic Calculator" — LeetCode — https://leetcode.com/problems/basic-calculator/

**판별기준**: 일반 **문자열** 라벨은 문자열 자체의 패턴/매칭을 다루고, 이 라벨은 "정해진 문법 규칙에 따른 해석"이라는 점에서 더 좁고 구체적이다.

---

### 재귀

**정의**: 문제를 더 작은 동일한 형태의 하위 문제로 나누어 함수가 자기 자신을 호출하는 방식으로 푸는 유형 자체에 초점.

**대표 예시**: "Climbing Stairs" — LeetCode — https://leetcode.com/problems/climbing-stairs/

**판별기준**: 재귀 호출 결과를 저장해 중복 계산을 없애면 **DP 기초**로, "선택 후 되돌리기"를 반복하며 탐색 공간을 줄이면 **백트래킹**으로 넘어간다. 이 라벨은 그 이전 단계, 즉 재귀 구조 자체를 다루는 문제.

---

## 정렬

### 정렬

**정의**: 주어진 데이터를 특정 기준으로 순서대로 나열하는 기법과, 정렬을 전제로 하거나 정렬 자체가 핵심인 문제 유형.

**대표 예시**: "Merge Intervals" — LeetCode — https://leetcode.com/problems/merge-intervals/

**판별기준**: 정렬 결과를 활용해 특정 값을 빠르게 찾는 것이 핵심이면 **탐색** 카테고리 라벨로 넘어간다. 이 라벨은 "정렬 자체 또는 정렬 기준 설계"가 핵심인 문제.

---

## 탐색

### 이분 탐색

**정의**: 정렬된 데이터나 단조적인(모노토닉) 조건을 가진 값의 범위를 절반씩 좁혀가며 원하는 값을 찾는 기법. "매개변수 탐색"(최적화 문제를 판정 문제로 바꿔 이분 탐색으로 푸는 기법)도 이 라벨에 포함한다.

**대표 예시**: "Koko Eating Bananas" — LeetCode — https://leetcode.com/problems/koko-eating-bananas/

**판별기준**: 조건을 만족하는지 여부가 단조적으로 변하는 값 위에서 탐색하면 이 라벨. 단봉(볼록/오목) 함수의 극값을 찾는 문제라면 **삼분 탐색**으로 구분한다.

---

### 삼분 탐색

**정의**: 아래로 볼록하거나 위로 볼록한(단봉) 함수의 최솟값/최댓값을 구간을 삼등분하며 찾는 기법.

**대표 예시**: "Peak Index in a Mountain Array" — LeetCode — https://leetcode.com/problems/peak-index-in-a-mountain-array/

**판별기준**: **이분 탐색**은 "예/아니오로 판정 가능한 단조 조건"을 좁혀가지만, 삼분 탐색은 "함수 값 자체가 볼록/오목"이라는 다른 전제가 필요하다. 두 기법을 혼동하기 쉬우므로 반드시 함수의 개형(단조 vs 단봉)부터 확인한다.

---

### 투 포인터

**정의**: 정렬되었거나 특정 성질을 가진 배열에서 두 개의 포인터(인덱스)를 이동시키며 조건을 만족하는 구간이나 쌍을 찾는 기법.

**대표 예시**: "3Sum" — LeetCode — https://leetcode.com/problems/3sum/

**판별기준**: 두 포인터가 항상 "연속된 구간"을 유지하며 움직이면 **슬라이딩 윈도우**의 특수한 경우로 볼 수 있다. 투 포인터는 두 포인터가 반드시 인접 구간을 이루지 않아도 되는 더 일반적인 기법(예: 정렬된 배열 양 끝에서 서로 다가가는 경우)까지 포함한다.

---

### 슬라이딩 윈도우

**정의**: 배열/문자열에서 크기가 변하거나 고정된 "연속 구간(윈도우)"을 유지하면서, 윈도우를 한 칸씩 넓히거나 좁혀가며 조건을 검사하는 기법.

**대표 예시**: "Minimum Window Substring" — LeetCode — https://leetcode.com/problems/minimum-window-substring/

**판별기준**: **투 포인터**의 하위 유형으로 볼 수 있지만, "항상 연속된 구간을 명시적으로 유지한다"는 점이 명확한 경우 이 라벨을 우선 적용한다.

---

## 자료구조

### 자료구조 일반

**정의**: 특정 자료구조 하나로 좁혀 말하기 어렵고, 문제 자체가 "적절한 자료구조 선택과 활용"을 폭넓게 요구하는 경우에 붙는 포괄 라벨. solved.ac의 `data_structures`, Codeforces의 `data structures`, LeetCode의 `Graph Theory`처럼 특정 기법을 지칭하지 않는 상위 태그가 여기 매핑된다.

**대표 예시**: "Design Twitter" — LeetCode — https://leetcode.com/problems/design-twitter/

**판별기준**: 더 구체적인 하위 라벨(스택/큐/덱, 집합과 맵, 세그먼트 트리 등)로 특정할 수 있으면 그 라벨을 우선 쓴다. 이 라벨은 "여러 자료구조를 조합해야 하거나 특정하기 애매한" 경우를 위한 것이다.

---

### 스택/큐/덱

**정의**: 후입선출(스택), 선입선출(큐), 양쪽에서 삽입/삭제가 가능한(덱) 기본 선형 자료구조를 활용하는 유형.

**대표 예시**: "Valid Parentheses" — LeetCode — https://leetcode.com/problems/valid-parentheses/

**판별기준**: 원소를 넣고 뺄 때 "단조성(항상 증가/감소하는 순서)"을 유지하도록 관리해야 하면 **모노토닉 스택/큐**로 구분한다.

---

### 모노토닉 스택/큐

**정의**: 스택이나 큐에 원소를 넣을 때, 항상 정렬된(단조 증가/감소) 상태를 유지하도록 필요 없는 원소를 미리 제거하며 관리하는 기법. 다음으로 더 큰/작은 원소 찾기류 문제에 자주 쓰인다.

**대표 예시**: "Daily Temperatures" — LeetCode — https://leetcode.com/problems/daily-temperatures/

**판별기준**: 단순히 넣고 빼는 순서만 중요하면 **스택/큐/덱**, "항상 정렬 상태를 유지"해야 하면 이 라벨.

---

### 우선순위 큐/힙

**정의**: 원소 중 최댓값 또는 최솟값을 빠르게 꺼낼 수 있는 힙 기반 자료구조를 활용하는 유형.

**대표 예시**: "Kth Largest Element in an Array" — LeetCode — https://leetcode.com/problems/kth-largest-element-in-an-array/

**판별기준**: 단순 삽입/삭제 순서만 중요하면 **스택/큐/덱**, "최댓값/최솟값을 계속 빠르게 꺼내야" 하면 이 라벨.

---

### 연결 리스트

**정의**: 노드가 다음(또는 이전) 노드를 가리키는 포인터로 연결된 자료구조를 다루는 유형.

**대표 예시**: "Reverse Linked List" — LeetCode — https://leetcode.com/problems/reverse-linked-list/

**판별기준**: 배열 인덱스 기반 접근이 아니라 "포인터를 직접 조작"하는 것이 핵심이면 이 라벨.

---

### 집합과 맵

**정의**: 중복 없는 원소 모음(집합)이나 키-값 대응(맵)을 관리하는 자료구조 활용 문제. 해시 기반(hash_set, Hash Table, 해시)이든 트리 기반(tree_set)이든 "집합/맵으로서의 활용"에 초점이 있으면 이 라벨.

**대표 예시**: "Two Sum" — LeetCode — https://leetcode.com/problems/two-sum/

**판별기준**: 해시 함수 설계나 해시 충돌·롤링 해시 같은 **기법 자체**가 핵심이면 **해싱**으로 구분한다(애매하게 겹치는 경우 많음 — merge-notes.md 참고). 이 라벨은 "집합/맵이라는 자료구조를 활용해 문제를 푼다"는 관점.

---

### 해싱

**정의**: 해시 함수를 설계하거나 활용해 데이터를 빠르게 비교·식별하는 기법 자체에 초점을 둔 유형.

**대표 예시**: "Longest Duplicate Substring" — LeetCode — https://leetcode.com/problems/longest-duplicate-substring/

**판별기준**: 위 **집합과 맵**과 판별기준 참고 — 명확히 구분하기 어려운 경우가 많아 보수적으로 분리했다. 롤링 해시 등 해시 값 자체의 성질을 이용하는 기법 중심이면 이 라벨을 우선한다.

---

### 트라이

**정의**: 문자열들을 공통 접두사를 공유하는 트리 형태로 저장해 접두사 검색을 빠르게 하는 자료구조.

**대표 예시**: "Implement Trie (Prefix Tree)" — LeetCode — https://leetcode.com/problems/implement-trie-prefix-tree/

**판별기준**: 문자열 검색이라도 접두사 공유 구조를 명시적으로 쓰지 않으면 **문자열**이나 **KMP 문자열 매칭**으로 분류한다.

---

### 세그먼트 트리

**정의**: 배열 구간에 대한 합·최솟값 등의 쿼리와 값 갱신을 모두 로그 시간에 처리하는 트리 기반 자료구조. 느리게 갱신되는(lazy propagation) 세그먼트 트리도 포함.

**대표 예시**: "구간 합 구하기" — 백준(BOJ) — https://www.acmicpc.net/problem/2042

**판별기준**: 값 갱신 없이 구간 합만 필요하면 **누적합과 좌표 압축**으로 충분할 수 있다. 갱신과 구간 쿼리가 함께 빈번히 필요하면 이 라벨이나 **인덱스 트리(BIT)**로 넘어간다.

---

### 인덱스 트리(BIT)

**정의**: 배열의 구간 합(주로)을 다루는, 세그먼트 트리보다 구현이 간단한 트리 기반 자료구조(펜윅 트리).

**대표 예시**: "Range Sum Query - Mutable" — LeetCode — https://leetcode.com/problems/range-sum-query-mutable/

**판별기준**: **세그먼트 트리**와 겹치는 문제가 많지만, BIT는 주로 구간 합/누적 연산에 특화돼 구현이 짧고, 세그먼트 트리는 최솟값·최댓값 등 더 다양한 연산과 지연 전파까지 일반적으로 지원한다는 차이가 있다.

---

### 유니온 파인드

**정의**: 원소들을 여러 그룹(집합)으로 묶고, 두 원소가 같은 그룹인지 빠르게 판별하거나 그룹을 합치는 자료구조(Disjoint Set Union).

**대표 예시**: "집합의 표현" — 백준(BOJ) — https://www.acmicpc.net/problem/1717

**판별기준**: 그래프의 연결 여부만 판별하면 **DFS**/**BFS**로도 풀 수 있지만, "그룹을 계속 합쳐 나가며 반복적으로 질의"해야 하면 이 라벨이 더 적합하다.

---

### 누적합과 좌표 압축

**정의**: 구간 합을 미리 계산해두는 누적합(prefix sum)/차분 배열 기법과, 값의 범위가 크지만 상대적 순서만 중요할 때 좌표를 압축하는 기법.

**대표 예시**: "Range Sum Query - Immutable" — LeetCode — https://leetcode.com/problems/range-sum-query-immutable/

**판별기준**: 값이 실행 중에 갱신돼야 하면 **세그먼트 트리**나 **인덱스 트리(BIT)**로 넘어간다. 이 라벨은 갱신 없이 미리 계산해두는 정적인 경우.

---

### 오프라인 쿼리

**정의**: 여러 개의 쿼리를 실시간(온라인)으로 즉시 처리하지 않고, 한꺼번에 모은 뒤 순서를 재배치(예: 정렬)해 한 번에 효율적으로 처리하는 기법.

**대표 예시**: "Range Sum Query 2D - Immutable" — LeetCode — https://leetcode.com/problems/range-sum-query-2d-immutable/ (오프라인 처리 아이디어의 입문 참고용 — 정확한 오프라인 쿼리 예시는 별도 검증 필요)

**판별기준**: 쿼리가 들어오는 즉시 답해야 하면 온라인 알고리즘(다른 자료구조 라벨), 쿼리를 모아 재정렬해도 되면 이 라벨.

---

## 그래프 이론

### 그래프 이론 일반

**정의**: 특정 그래프 알고리즘(탐색, 최단 경로 등)으로 좁혀지지 않는, 그래프라는 자료구조 자체를 폭넓게 다루는 포괄 라벨.

**대표 예시**: "Course Schedule" — LeetCode — https://leetcode.com/problems/course-schedule/

**판별기준**: 더 구체적인 하위 라벨(BFS, DFS, 최단 경로 등)로 특정할 수 있으면 그 라벨을 우선한다.

---

### BFS

**정의**: 그래프나 격자에서 시작점으로부터 가까운 노드부터 순서대로(레벨 단위로) 탐색하는 너비 우선 탐색. 격자(grid) 위에서의 탐색도 이 라벨과 **DFS**에 함께 매핑한다(격자는 그래프의 특수한 표현일 뿐).

**대표 예시**: "미로 탐색" — 백준(BOJ) — https://www.acmicpc.net/problem/2178

**판별기준**: 가중치 없는 그래프에서 "최단 거리(간선 수 기준)"를 구해야 하면 BFS, 단순히 도달 가능한 모든 노드를 훑기만 하면 **DFS**를 써도 무방하다 — 두 태그가 함께 붙는 문제도 많다.

---

### DFS

**정의**: 한 방향으로 갈 수 있는 데까지 깊이 파고들었다가 막히면 되돌아오는(백트랙) 방식으로 그래프를 탐색하는 깊이 우선 탐색.

**대표 예시**: "Number of Islands" — LeetCode — https://leetcode.com/problems/number-of-islands/

**판별기준**: BFS와 판별기준 참고. 재귀 호출 스택을 그대로 활용하기 쉽고, 경로 자체(예: 사이클 탐지, 위상 정렬의 기반)를 다뤄야 할 때 특히 DFS가 자연스럽다.

---

### 최단 경로

**정의**: 가중치가 있는 그래프에서 한 지점에서 다른 지점까지 최소 비용 경로를 구하는 유형(다익스트라, 벨만-포드, 플로이드-워셜 포함).

**대표 예시**: "최단경로" — 백준(BOJ) — https://www.acmicpc.net/problem/1753

**판별기준**: 음수 간선이 없으면 다익스트라, 음수 간선이 있으면 벨만-포드, 모든 쌍의 최단 경로가 필요하면 플로이드-워셜 — 이 라벨 안에서 구체적 알고리즘을 문제 조건에 맞춰 선택한다.

---

### 최소 스패닝 트리

**정의**: 그래프의 모든 정점을 최소 비용으로 연결하는 부분 그래프(트리)를 찾는 유형(크루스칼, 프림).

**대표 예시**: "최소 스패닝 트리" — 백준(BOJ) — https://www.acmicpc.net/problem/1197

**판별기준**: "모든 정점을 연결하는 최소 비용"이 목표면 이 라벨, "두 정점 사이의 최소 비용"이 목표면 **최단 경로**.

---

### 위상 정렬

**정의**: 방향 비순환 그래프(DAG)에서 선행 관계를 지키며 정점들을 순서대로 나열하는 유형.

**대표 예시**: "Course Schedule II" — LeetCode — https://leetcode.com/problems/course-schedule-ii/

**판별기준**: 그래프에 사이클이 있으면 위상 정렬이 불가능하므로, 이 라벨의 문제는 항상 "선행 순서가 있는 DAG"라는 전제를 깐다.

---

### 이분 그래프와 매칭

**정의**: 정점을 두 그룹으로 나눠 같은 그룹 안에는 간선이 없는 이분 그래프의 성질을 판별하거나, 이분 그래프에서 최대 매칭을 구하는 유형.

**대표 예시**: "Is Graph Bipartite?" — LeetCode — https://leetcode.com/problems/is-graph-bipartite/

**판별기준**: 단순히 두 그룹으로 나눌 수 있는지만 판별하면 이분 그래프 판별, 그룹 간 최대 짝을 지어야 하면 매칭까지 이 라벨에서 함께 다룬다.

---

### 네트워크 유량

**정의**: 그래프의 각 간선에 용량이 있을 때, 출발점에서 도착점까지 흘려보낼 수 있는 최대 유량을 구하는 유형.

**대표 예시**: "네트워크 유량" 계열 — 참고로 정확한 대표 문제 링크는 별도 검증 필요(대표 개념 문제: 최대 유량, 포드-풀커슨/에드몬드-카프).

**판별기준**: 단순 최단 경로가 아니라 "흐를 수 있는 총량"이 목표라는 점에서 **최단 경로**와 구분된다.

---

### 강한 연결 요소

**정의**: 방향 그래프에서 서로 도달 가능한(양방향으로 갈 수 있는) 정점들의 집합(SCC)을 찾는 유형.

**대표 예시**: "Critical Connections in a Network" — LeetCode — https://leetcode.com/problems/critical-connections-in-a-network/ (SCC와 밀접한 단절선 개념의 인접 문제 — 정확한 SCC 전용 예시는 별도 검증 권장)

**판별기준**: 무방향 그래프의 단순 연결 요소는 **유니온 파인드**/**DFS**로 충분하지만, 방향 그래프에서 "서로 도달 가능"이라는 조건이 붙으면 이 라벨.

---

## 트리

### 트리 기초

**정의**: 사이클이 없는 연결 그래프인 트리, 그중에서도 각 노드의 자식이 최대 둘인 이진 트리와 정렬 성질을 가진 이진 탐색 트리(BST)를 다루는 유형.

**대표 예시**: "Binary Tree Inorder Traversal" — LeetCode — https://leetcode.com/problems/binary-tree-inorder-traversal/

**판별기준**: 트리 위에서 최적값을 재귀적으로 누적 계산해야 하면 **트리에서의 DP**로, 조상 관계를 빠르게 질의해야 하면 **최소 공통 조상**으로 넘어간다.

---

### 트리에서의 DP

**정의**: 트리의 각 노드에서 자식들의 결과를 조합해 최적값을 계산하는, 트리 구조 위에서의 다이나믹 프로그래밍.

**대표 예시**: "House Robber III" — LeetCode — https://leetcode.com/problems/house-robber-iii/

**판별기준**: 일반 배열/수열 위에서의 DP는 **DP 기초**, "부모-자식 관계를 따라 값을 전파"해야 하면 이 라벨.

---

### 최소 공통 조상

**정의**: 트리에서 두 노드의 가장 가까운 공통 조상을 빠르게 찾는 유형(LCA).

**대표 예시**: "Lowest Common Ancestor of a Binary Tree" — LeetCode — https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

**판별기준**: 단순 트리 순회로 조상을 찾으면 **트리 기초**, "여러 번 반복 질의"를 빠르게 처리해야 하면 이 라벨(희소 배열/이진 리프팅 등 최적화 필요).

---

### 트리의 지름

**정의**: 트리에서 가장 멀리 떨어진 두 노드 사이의 거리(경로 길이)를 구하는 유형.

**대표 예시**: "Diameter of Binary Tree" — LeetCode — https://leetcode.com/problems/diameter-of-binary-tree/

**판별기준**: 임의의 두 노드 사이 거리가 아니라 "트리 전체에서 최댓값"을 구한다는 점이 일반 트리 탐색과 다르다.

---

## 다이나믹 프로그래밍

### DP 기초

**정의**: 문제를 겹치는 부분 문제로 나누고, 계산 결과를 저장(메모이제이션)해 재활용하며 푸는 최적화 기법.

**대표 예시**: "Climbing Stairs" — LeetCode — https://leetcode.com/problems/climbing-stairs/

**판별기준**: 재귀 구조만 있고 저장/재활용이 없으면 **재귀**, 저장을 통해 중복 계산을 없애면 이 라벨. 배낭/LIS/LCS처럼 잘 알려진 패턴은 각각의 전용 라벨로 더 세분화했다.

---

### 배낭 문제

**정의**: 무게/부피 제한이 있는 배낭에 가치가 있는 물건들을 담아 최대 가치를 얻는 고전 DP 패턴(0/1 배낭, 무한 배낭 등).

**대표 예시**: "평범한 배낭" — 백준(BOJ) — https://www.acmicpc.net/problem/12865

**판별기준**: "제한된 용량 안에서 선택 조합의 최적화"라는 틀이 명확하면 이 라벨, 그렇지 않은 일반적인 DP는 **DP 기초**.

---

### 최장 증가 부분 수열

**정의**: 수열에서 순서를 유지하며 값이 계속 증가하는 부분 수열 중 가장 긴 것을 찾는 고전 DP 패턴(LIS).

**대표 예시**: "가장 긴 증가하는 부분 수열" — 백준(BOJ) — https://www.acmicpc.net/problem/11053

**판별기준**: "부분 수열의 증가 조건"이 핵심이면 이 라벨. O(n log n) 최적화(이분 탐색 활용)까지 이 라벨 범위로 본다.

---

### 최장 공통 부분 수열

**정의**: 두 수열/문자열에 공통으로 나타나는(순서는 유지, 연속일 필요는 없는) 가장 긴 부분 수열을 찾는 고전 DP 패턴(LCS).

**대표 예시**: "Longest Common Subsequence" — LeetCode — https://leetcode.com/problems/longest-common-subsequence/

**판별기준**: 두 시퀀스를 비교한다는 점에서 LIS(하나의 수열)와 다르다.

---

### 비트마스킹 DP

**정의**: 원소의 방문/선택 여부 같은 상태를 비트마스크(정수의 이진 표현)로 압축해 DP 상태로 사용하는 기법. 외판원 순회(TSP) 스타일 문제에 자주 쓰인다.

**대표 예시**: "Partition to K Equal Sum Subsets" — LeetCode — https://leetcode.com/problems/partition-to-k-equal-sum-subsets/

**판별기준**: 일반 **비트마스킹**(카테고리: 비트마스킹)이 비트 연산 자체를 다루는 폭넓은 라벨이라면, 이 라벨은 "그 비트마스크를 DP의 상태로 사용"하는 결합 기법이라는 점에서 더 좁다.

---

### 최대 부분 배열

**정의**: 배열의 연속된 부분 구간 중 합이 최대인 구간을 찾는 고전 패턴(카데인 알고리즘).

**대표 예시**: "Maximum Subarray" — LeetCode — https://leetcode.com/problems/maximum-subarray/

**판별기준**: "연속 구간의 합 최적화"라는 좁고 명확한 패턴이라 **DP 기초**에서 따로 분리했다.

---

## 그리디

### 그리디

**정의**: 매 순간 당장 최선으로 보이는 선택을 반복해 전체 최적해에 도달하는 기법. (전역 최적성이 실제로 성립함을 증명/직관적으로 확인할 수 있는 문제에 적용된다.)

**대표 예시**: "Jump Game" — LeetCode — https://leetcode.com/problems/jump-game/

**판별기준**: 부분 선택이 이후 선택에 영향을 줘 "모든 경우를 저장해 비교"해야 하면 **DP 기초**로 넘어가야 할 가능성이 크다. 그리디는 이전 선택을 다시 고려하지 않고 앞으로만 진행한다.

---

## 분할 정복

### 분할 정복

**정의**: 문제를 독립적인 더 작은 부분 문제로 나누고, 각각을 해결한 뒤 결과를 합쳐 전체 답을 구하는 기법.

**대표 예시**: "Maximum Subarray"(분할 정복 풀이 관점) — LeetCode — https://leetcode.com/problems/maximum-subarray/

**판별기준**: 하위 문제들이 서로 겹치면(중복 계산 발생) **DP 기초**로 접근하는 것이 더 적합하고, 겹치지 않고 독립적으로 나뉘면 이 라벨.

---

## 완전탐색과 백트래킹

### 완전탐색

**정의**: 가능한 모든 경우의 수를 빠짐없이 시도해 답을 찾는 유형(브루트포스).

**대표 예시**: "Subsets" — LeetCode — https://leetcode.com/problems/subsets/

**판별기준**: 가능성이 아닌 것으로 판명되면 더 진행하지 않고 되돌아가는 "가지치기"를 적극적으로 하면 **백트래킹**으로 구분한다. 이 라벨은 가지치기 없이 모든 경우를 그대로 탐색하는 경우.

---

### 백트래킹

**정의**: 해를 하나씩 선택해 나가다가 조건을 만족할 수 없음이 확인되면 이전 선택으로 되돌아가(백트랙) 다른 경우를 시도하는 탐색 기법.

**대표 예시**: "N-Queens" — LeetCode — https://leetcode.com/problems/n-queens/

**판별기준**: 완전탐색과의 차이는 "가지치기 여부" — 조건에 안 맞는 부분 해를 조기에 포기하는지가 핵심이다.

---

## 수학

### 수학 일반

**정의**: 특정 정수론/조합론 기법으로 좁혀지지 않는, 수학적 사고와 공식 유도가 필요한 폭넓은 유형. 홀짝성(parity) 판단처럼 단순하지만 수학적인 관찰도 포함한다.

**대표 예시**: "Watermelon" — Codeforces — https://codeforces.com/problemset/problem/4/A

**판별기준**: 더 구체적인 하위 라벨(정수론, 조합론과 확률 등)로 특정할 수 있으면 그 라벨을 우선한다.

---

### 정수론

**정의**: 정수의 성질(나머지, 약수, 배수 등)을 다루는 수학 이론을 활용하는 유형.

**대표 예시**: "Theatre Square" — Codeforces — https://codeforces.com/problemset/problem/1/A

**판별기준**: 최대공약수/최소공배수 계산이 핵심이면 **최대공약수와 최소공배수**로, 소수 판별/소인수분해가 핵심이면 **소수 판정과 소인수분해**로 더 구체화한다.

---

### 최대공약수와 최소공배수

**정의**: 유클리드 호제법 등을 이용해 두 수의 최대공약수(GCD)·최소공배수(LCM)를 구하거나 활용하는 유형.

**대표 예시**: "Greatest Common Divisor of Strings" — LeetCode — https://leetcode.com/problems/greatest-common-divisor-of-strings/

**판별기준**: GCD/LCM 계산 자체가 핵심이면 이 라벨, 더 일반적인 수 이론 문제면 **정수론**.

---

### 소수 판정과 소인수분해

**정의**: 어떤 수가 소수인지 판별하거나(에라토스테네스의 체 포함), 수를 소인수로 분해하는 유형.

**대표 예시**: "Count Primes" — LeetCode — https://leetcode.com/problems/count-primes/

**판별기준**: "소수와의 관계"가 명시적으로 핵심이면 이 라벨.

---

### 모듈러 연산

**정의**: 큰 수를 다룰 때 특정 값으로 나눈 나머지로 계산을 진행하는 기법(모듈러 거듭제곱, 모듈러 역원 등).

**대표 예시**: "Super Pow" — LeetCode — https://leetcode.com/problems/super-pow/

**판별기준**: "나머지 연산 자체의 성질"을 다뤄야 하면 이 라벨, 일반적인 정수 성질만 다루면 **정수론**.

---

## 조합론과 확률

### 조합론

**정의**: 경우의 수를 세는 방법(순열, 조합, 중복조합 등)을 다루는 유형.

**대표 예시**: "Combinations" — LeetCode — https://leetcode.com/problems/combinations/

**판별기준**: "경우의 수를 정확히 센다"가 목표면 이 라벨, 확률·기댓값을 구해야 하면 **확률과 통계**.

---

### 확률과 통계

**정의**: 사건이 일어날 확률이나 기댓값, 통계적 수치를 계산하는 유형.

**대표 예시**: "New 21 Game" — LeetCode — https://leetcode.com/problems/new-21-game/

**판별기준**: 경우의 수를 "세는" 것이 아니라 "확률/기댓값을 계산"하는 것이 목표면 이 라벨.

---

## 문자열

### 문자열

**정의**: 문자열의 패턴, 부분 문자열, 문자 단위 조작을 다루는 유형 전반.

**대표 예시**: "Longest Palindromic Substring" — LeetCode — https://leetcode.com/problems/longest-palindromic-substring/

**판별기준**: 특정 패턴 매칭 알고리즘(KMP 등)이 명시적으로 핵심이면 **KMP 문자열 매칭**으로 더 구체화한다.

---

### KMP 문자열 매칭

**정의**: 접두사·접미사가 겹치는 정보를 미리 계산해, 긴 문자열 안에서 패턴 문자열을 선형 시간에 찾는 문자열 매칭 알고리즘.

**대표 예시**: "찾기" — 백준(BOJ) — https://www.acmicpc.net/problem/1786

**판별기준**: 단순 문자열 다루기가 아니라 "패턴을 빠르게 찾는 알고리즘 자체"가 핵심이면 이 라벨.

---

## 기하

### 기하

**정의**: 점, 선, 다각형 등 기하학적 대상의 성질을 다루는 유형 전반.

**대표 예시**: "Max Points on a Line" — LeetCode — https://leetcode.com/problems/max-points-on-a-line/

**판별기준**: 볼록 껍질이나 다각형 넓이·선분 교차처럼 구체적인 하위 기법이 핵심이면 해당 라벨로 더 구체화한다.

---

### 볼록 껍질

**정의**: 평면 위의 점들을 모두 포함하는 가장 작은 볼록 다각형을 구하는 유형.

**대표 예시**: "Erect the Fence" — LeetCode — https://leetcode.com/problems/erect-the-fence/

**판별기준**: "모든 점을 감싸는 최소 볼록 도형"이 목표면 이 라벨.

---

### 다각형과 선분 기하

**정의**: 다각형의 넓이를 계산(신발끈 공식 등)하거나, 두 선분이 교차하는지 판별하는 등 기하 공식·판정 위주의 유형.

**대표 예시**: "Max Points on a Line" — LeetCode — https://leetcode.com/problems/max-points-on-a-line/ (선분/직선 판정의 입문 참고용)

**판별기준**: 특정 공식(신발끈 공식, CCW 판정 등)을 직접 적용하는 것이 핵심이면 이 라벨, 더 폭넓은 기하 알고리즘 설계가 필요하면 **기하**.

---

## 비트마스킹

### 비트마스킹

**정의**: 정수의 이진 표현(비트)을 직접 조작해 집합이나 상태를 표현하고 연산하는 기법.

**대표 예시**: "Single Number" — LeetCode — https://leetcode.com/problems/single-number/

**판별기준**: 그 비트마스크를 DP의 "상태"로 사용해 반복 계산을 저장하면 **비트마스킹 DP**로 더 구체화한다.

---

## 게임 이론

### 게임 이론

**정의**: 두 명 이상의 참가자가 번갈아 최선의 수를 두는 게임에서 승패나 최적 전략을 분석하는 유형.

**대표 예시**: "Nim Game" — LeetCode — https://leetcode.com/problems/nim-game/

**판별기준**: "상대의 대응을 고려한 최적 전략"을 분석해야 한다는 점에서 일반 **그리디**나 **DP 기초**와 다르다(다만 내부적으로 DP를 함께 쓰는 경우가 많다).

---

## 설계

### 자료구조 설계

**정의**: 특정 연산들을 효율적으로 지원하는 자료구조/시스템을 처음부터 설계해 구현하는 유형(예: LRU 캐시, 트위터 피드).

**대표 예시**: "LRU Cache" — LeetCode — https://leetcode.com/problems/lru-cache/

**판별기준**: 기존에 잘 알려진 자료구조 하나를 그대로 쓰면 되면 해당 자료구조 라벨(스택/큐/덱, 우선순위 큐/힙 등)로 충분하다. 여러 자료구조를 조합해 "새로운 인터페이스"를 설계해야 하면 이 라벨.

---

## 구성적 알고리즘

### 구성적 알고리즘

**정의**: 답이 존재함을 증명하기보다, 조건을 만족하는 답 하나를 직접 만들어내는(구성하는) 것이 핵심인 유형.

**대표 예시**: "Beautiful Array" — LeetCode — https://leetcode.com/problems/beautiful-array/

**판별기준**: 여러 선택지 중 "최적"을 고르는 **그리디**와 달리, 이 라벨은 "조건을 만족하는 하나의 구성 방법을 찾아내는" 창의적 구성이 핵심이다.

---

## 출처 태그 매핑

아래 표는 네 출처의 원본 태그가 위 라벨 중 어디로 흡수되었는지 정리한 기록이다(FR-004). 범위 밖(OUT-OF-SCOPE)으로 제외된 태그는 "제외됨"으로 표시했으며, 상세 제외 사유는 `specs/001-algorithm-label-taxonomy/sources/*.md`를 참고한다.

### solved.ac (84개 범위 내 + 145개 제외)

| 원본 태그 | 병합 라벨 |
|---|---|
| implementation, ad_hoc, arithmetic, case_work, precomputation, traceback | 구현 |
| simulation | 시뮬레이션 |
| parsing | 파싱/수식 처리 |
| recursion | 재귀 |
| backtracking | 백트래킹 |
| bruteforcing | 완전탐색 |
| sorting | 정렬 |
| binary_search, parametric_search | 이분 탐색 |
| ternary_search | 삼분 탐색 |
| two_pointer | 투 포인터 |
| sliding_window | 슬라이딩 윈도우 |
| data_structures | 자료구조 일반 |
| stack, queue, deque | 스택/큐/덱 |
| priority_queue | 우선순위 큐/힙 |
| linked_list | 연결 리스트 |
| set, hash_set, tree_set | 집합과 맵 |
| hashing | 해싱 |
| trie | 트라이 |
| segtree, lazyprop | 세그먼트 트리 |
| disjoint_set | 유니온 파인드 |
| prefix_sum, difference_array, coordinate_compression | 누적합과 좌표 압축 |
| offline_queries | 오프라인 쿼리 |
| graphs, graph_traversal | 그래프 이론 일반 |
| bfs, 0_1_bfs, grid_graph | BFS |
| dfs, grid_graph | DFS |
| dijkstra, shortest_path, floyd_warshall, bellman_ford | 최단 경로 |
| mst | 최소 스패닝 트리 |
| topological_sorting, dag | 위상 정렬 |
| bipartite_graph, bipartite_matching | 이분 그래프와 매칭 |
| flow | 네트워크 유량 |
| scc | 강한 연결 요소 |
| trees | 트리 기초 |
| dp_tree | 트리에서의 DP |
| lca | 최소 공통 조상 |
| tree_diameter | 트리의 지름 |
| dp | DP 기초 |
| knapsack | 배낭 문제 |
| lis | 최장 증가 부분 수열 |
| lcs | 최장 공통 부분 수열 |
| dp_bitfield | 비트마스킹 DP |
| maximum_subarray | 최대 부분 배열 |
| greedy | 그리디 |
| divide_and_conquer | 분할 정복 |
| math, parity | 수학 일반 |
| number_theory | 정수론 |
| euclidean | 최대공약수와 최소공배수 |
| prime_factorization, sieve, primality_test | 소수 판정과 소인수분해 |
| modular_multiplicative_inverse, exponentiation_by_squaring | 모듈러 연산 |
| combinatorics | 조합론 |
| probability | 확률과 통계 |
| string | 문자열 |
| kmp | KMP 문자열 매칭 |
| geometry | 기하 |
| convex_hull | 볼록 껍질 |
| polygon_area, line_intersection | 다각형과 선분 기하 |
| bitmask | 비트마스킹 |
| game_theory | 게임 이론 |
| constructive | 구성적 알고리즘 |

**제외됨(대회 전용 고급 기법 또는 형식 범주, FR-010)**: sweeping, dp_digit, dp_deque, dp_connection_profile, dp_sum_over_subsets, divide_and_conquer_optimization, monotone_queue_optimization, knuth, alien, slope_trick, cht, li_chao_tree, mcmf, mfmc, hungarian, general_matching, stoer_wagner, articulation, bcc, 2_sat, hld, centroid, centroid_decomposition, euler_tour_technique, rerooting, functional_graph, planar_graph, dual_graph, dominator_tree, tree_isomorphism, tree_compression, tree_decomposition, cactus, treewidth, chordal_graph, eulerian_path, directed_mst, offline_dynamic_connectivity, sparse_table, sqrt_decomposition, merge_sort_tree, pst, beats, kinetic_segtree, multi_segtree, splay_tree, link_cut_tree, top_tree, rope, cartesian_tree, rb_tree, dancing_links, xor_basis, fft, linear_algebra, gaussian_elimination, generating_function, mobius_inversion, crt, extended_euclidean, pollard_rho, miller_rabin, lucas, euler_phi, discrete_log, discrete_sqrt, discrete_kth_root, pisano, floor_sum, kitamasa, berlekamp_massey, lgv, matroid, burnside, duality, linear_programming, numerical_analysis, statistics, bayes, calculus, physics, pythagoras, harmonic_number, euler_characteristic, gradient_descent, simulated_annealing, arbitrary_precision, randomization, heuristics, invariant, pigeonhole_principle, linearity_of_expectation, permutation_cycle_decomposition, degree_sequence, sprague_grundy, hall, stable_marriage, a_star, tsp, mitm, mo, pbs, cdq, bulldozer, deque_trick, smaller_to_larger, bitset, bitset_lcs, hirschberg, majority_vote, knuth_x, bidirectional_search, dial, birthday, differential_cryptanalysis, utf8, regex, flood_fill, geometry_3d, geometry_hyper, voronoi, delaunay, rotating_calipers, half_plane_intersection, min_enclosing_circle, angle_sorting, point_in_convex_polygon, point_in_non_convex_polygon, geometric_boolean_operations, pick, green, circulation, suffix_array, suffix_tree, palindrome_tree, aho_corasick, manacher, rabin_karp, z, multipoint_evaluation, polynomial_interpolation, flt(페르마의 소정리), hackenbush(하켄부시 게임), inclusion_and_exclusion(포함배제의 원리), lte(지수승강 보조정리)

### LeetCode (47개 범위 내 + 24개 제외)

| 원본 태그 | 병합 라벨 |
|---|---|
| Array, Matrix | 구현 |
| Simulation | 시뮬레이션 |
| Recursion | 재귀 |
| Backtracking | 백트래킹 |
| Enumeration | 완전탐색 |
| Sorting | 정렬 |
| Binary Search | 이분 탐색 |
| Two Pointers | 투 포인터 |
| Sliding Window | 슬라이딩 윈도우 |
| Graph Theory | 그래프 이론 일반 |
| Stack, Queue | 스택/큐/덱 |
| Monotonic Stack, Monotonic Queue | 모노토닉 스택/큐 |
| Heap (Priority Queue) | 우선순위 큐/힙 |
| Linked List | 연결 리스트 |
| Hash Table | 집합과 맵 |
| Trie | 트라이 |
| Segment Tree | 세그먼트 트리 |
| Binary Indexed Tree | 인덱스 트리(BIT) |
| Union-Find | 유니온 파인드 |
| Prefix Sum | 누적합과 좌표 압축 |
| Depth-First Search | DFS |
| Breadth-First Search | BFS |
| Shortest Path | 최단 경로 |
| Minimum Spanning Tree | 최소 스패닝 트리 |
| Topological Sort | 위상 정렬 |
| Strongly Connected Component | 강한 연결 요소 |
| Tree, Binary Tree, Binary Search Tree | 트리 기초 |
| Dynamic Programming, Memoization | DP 기초 |
| Divide and Conquer | 분할 정복 |
| Math | 수학 일반 |
| Number Theory | 정수론 |
| Combinatorics, Counting | 조합론 |
| Probability and Statistics | 확률과 통계 |
| String | 문자열 |
| Geometry | 기하 |
| Bit Manipulation, Bitmask | 비트마스킹 |
| Game Theory | 게임 이론 |
| Design | 자료구조 설계 |
| Greedy | 그리디 |

**제외됨(알고리즘 유형이 아님, FR-010)**: Database, Shell, Concurrency, Interactive, Iterator, Data Stream, Brainteaser

**제외됨(다른 라벨의 구현 세부사항으로 흡수)**: Merge Sort, Counting Sort, Bucket Sort, Radix Sort, Doubly-Linked List, Hash Function

**제외됨(대회 전용 고급 기법, solved.ac와 동일 사유)**: Ordered Set, String Matching, Rolling Hash, Suffix Array, Sweep Line, Randomized, Quickselect, Reservoir Sampling, Rejection Sampling, Eulerian Circuit, Biconnected Component

### Codeforces (26개 범위 내 + 10개 제외)

| 원본 태그 | 병합 라벨 |
|---|---|
| implementation | 구현 |
| brute force | 완전탐색 |
| sortings | 정렬 |
| binary search | 이분 탐색 |
| ternary search | 삼분 탐색 |
| two pointers | 투 포인터 |
| data structures | 자료구조 일반 |
| dsu | 유니온 파인드 |
| dfs and similar | DFS |
| flows | 네트워크 유량 |
| trees | 트리 기초 |
| dp | DP 기초 |
| divide and conquer | 분할 정복 |
| greedy | 그리디 |
| math | 수학 일반 |
| number theory | 정수론 |
| combinatorics | 조합론 |
| probabilities | 확률과 통계 |
| strings | 문자열 |
| expression parsing | 파싱/수식 처리 |
| geometry | 기하 |
| bitmasks | 비트마스킹 |
| games | 게임 이론 |
| hashing | 해싱 |
| constructive algorithms | 구성적 알고리즘 |
| shortest paths | 최단 경로 |

**제외됨**: 2-sat, chinese remainder theorem, communication, fft, game matchings, interactive, matrices(선형대수 기법 — LeetCode의 "Matrix"와 이름은 비슷하지만 다른 개념이므로 혼동 주의), meet-in-the-middle, schedules, string suffix structures

### 프로그래머스 (10개 범위 내, 제외 없음)

| 원본 태그 | 병합 라벨 |
|---|---|
| 해시 | 집합과 맵 |
| 스택/큐 | 스택/큐/덱 |
| 힙 | 우선순위 큐/힙 |
| 정렬 | 정렬 |
| 완전탐색 | 완전탐색 |
| 탐욕법 | 그리디 |
| 동적계획법 | DP 기초 |
| 깊이/너비 우선 탐색 | BFS, DFS |
| 이분탐색 | 이분 탐색 |
| 그래프 | 그래프 이론 일반 |
