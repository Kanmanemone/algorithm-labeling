# solved.ac 원시 태그 목록 (T002)

**조사 방법**: solved.ac의 `problems/tags` 페이지와 공식 API는 이 세션의 웹 조사 도구로 접근이 차단(403)되어, 사용자가 직접 `solved.ac/problems/tags`에서 복사해 붙여넣은 전체 태그 목록을 원본으로 사용했다(2026-07-22).

**범위 축소 적용**: spec.md Clarifications(2026-07-22, 4번째 항목)·FR-001a·FR-010에 따라, 실제 태그 수가 250개 이상으로 확인되어 "취업 준비·코딩 테스트·일반적인 알고리즘 학습에 실질적으로 쓰이는 태그"만 범위 내(IN)로 채택하고, ICPC/IOI 등 최상위권 대회 전용 고급 기법은 범위 밖(OUT)으로 제외한다. OUT은 삭제가 아니라 이 문서에 사유와 함께 남겨 FR-004 매핑 기록에서 "제외됨"으로 추적한다.

## 원본 전체 목록 (그대로 보존)

math, implementation, dp, data_structures, graphs, greedy, string, bruteforcing, graph_traversal, sorting, ad_hoc, geometry, trees, number_theory, segtree, binary_search, set, constructive, prefix_sum, arithmetic, simulation, combinatorics, bfs, case_work, bitmask, shortest_path, dfs, hash_set, dijkstra, sweeping, disjoint_set, backtracking, dp_tree, priority_queue, parsing, parametric_search, tree_set, game_theory, divide_and_conquer, probability, stack, two_pointer, dp_bitfield, lazyprop, primality_test, flow, offline_queries, exponentiation_by_squaring, knapsack, dag, arbitrary_precision, coordinate_compression, recursion, euclidean, grid_graph, mst, topological_sorting, linear_algebra, precomputation, convex_hull, sieve, inclusion_and_exclusion, bipartite_matching, lca, sparse_table, traceback, parity, hashing, randomization, modular_multiplicative_inverse, floyd_warshall, scc, smaller_to_larger, line_intersection, sqrt_decomposition, fft, calculus, trie, deque, prime_factorization, geometry_3d, heuristics, ternary_search, sliding_window, euler_tour_technique, suffix_array, cht, mcmf, sprague_grundy, difference_array, mitm, pythagoras, lis, centroid, bitset, permutation_cycle_decomposition, kmp, gaussian_elimination, linearity_of_expectation, bipartite_graph, hld, mfmc, polygon_area, centroid_decomposition, physics, eulerian_path, flt, 0_1_bfs, flood_fill, articulation, 2_sat, queue, functional_graph, pigeonhole_principle, tsp, deque_trick, rerooting, pst, dp_digit, planar_graph, bcc, euler_phi, generating_function, point_in_convex_polygon, crt, angle_sorting, harmonic_number, linked_list, invariant, tree_diameter, mo, maximum_subarray, cactus, bellman_ford, divide_and_conquer_optimization, extended_euclidean, splay_tree, dp_sum_over_subsets, half_plane_intersection, pbs, euler_characteristic, rotating_calipers, regex, multi_segtree, lcs, manacher, pollard_rho, slope_trick, aho_corasick, miller_rabin, dp_deque, mobius_inversion, tree_isomorphism, merge_sort_tree, point_in_non_convex_polygon, cartesian_tree, numerical_analysis, link_cut_tree, simulated_annealing, rabin_karp, statistics, li_chao_tree, dp_connection_profile, hall, xor_basis, alien, berlekamp_massey, offline_dynamic_connectivity, z, geometric_boolean_operations, tree_compression, hungarian, linear_programming, beats, lucas, duality, circulation, voronoi, polynomial_interpolation, green, dual_graph, cdq, bulldozer, min_enclosing_circle, monotone_queue_optimization, kitamasa, discrete_log, general_matching, pick, matroid, suffix_tree, geometry_hyper, burnside, dominator_tree, differential_cryptanalysis, utf8, degree_sequence, tree_decomposition, pisano, top_tree, discrete_sqrt, palindrome_tree, bidirectional_search, lgv, dial, rope, knuth_x, dancing_links, gradient_descent, floor_sum, stable_marriage, bayes, delaunay, kinetic_segtree, knuth, birthday, bitset_lcs, multipoint_evaluation, hirschberg, chordal_graph, lte, directed_mst, stoer_wagner, hackenbush, majority_vote, rb_tree, a_star, treewidth, discrete_kth_root

**합계**: 약 216개 (원본 텍스트 그대로 옮김; 쉼표 구분 기준 실측치이며 사용자가 붙여넣은 원문에서 셈)

## 채택 기준 적용 결과

### IN-SCOPE (범위 내 — 취업 준비/코딩 테스트/일반 학습에 실질적으로 쓰임)

- **기초/구현**: implementation, ad_hoc, arithmetic, simulation, case_work, parsing, recursion, backtracking, brute-force(bruteforcing), precomputation, traceback
- **정렬·탐색**: sorting, binary_search, parametric_search, ternary_search, two_pointer, sliding_window
- **자료구조(기본)**: data_structures, stack, queue, deque, priority_queue, linked_list, set, hash_set, tree_set, trie, segtree, lazyprop(세그먼트 트리에 병합), disjoint_set
- **그래프**: graphs, graph_traversal, bfs, dfs, 0_1_bfs, dijkstra, shortest_path, floyd_warshall, bellman_ford, mst, topological_sorting, dag, bipartite_graph, bipartite_matching, flow, grid_graph, scc, lca, tree_diameter
- **트리**: trees, dp_tree
- **DP**: dp, knapsack, lis, lcs, dp_bitfield, maximum_subarray
- **탐욕·분할정복**: greedy, divide_and_conquer
- **수학(기본)**: math, number_theory, euclidean, prime_factorization, sieve, combinatorics, probability, modular_multiplicative_inverse, exponentiation_by_squaring, coordinate_compression, prefix_sum, difference_array, primality_test, parity
- **문자열**: string, kmp
- **기하(기본)**: geometry, convex_hull, polygon_area, line_intersection
- **기타 핵심**: bitmask, hashing, game_theory, constructive, offline_queries

→ 위 항목을 병합·라벨화의 입력으로 사용 (T006).

### OUT-OF-SCOPE (범위 밖 — ICPC/IOI 등 최상위권 대회 전용 고급 기법, FR-010 제외 기준)

sweeping, dp_digit, dp_deque, dp_connection_profile, dp_sum_over_subsets, divide_and_conquer_optimization, monotone_queue_optimization, knuth, alien, slope_trick, cht, li_chao_tree, mcmf, mfmc, hungarian, general_matching, stoer_wagner, articulation, bcc, 2_sat, hld, centroid, centroid_decomposition, euler_tour_technique, rerooting, functional_graph, planar_graph, dual_graph, dominator_tree, tree_isomorphism, tree_compression, tree_decomposition, cactus, treewidth, chordal_graph, eulerian_path, directed_mst, offline_dynamic_connectivity, sparse_table, sqrt_decomposition, merge_sort_tree, pst, beats, kinetic_segtree, multi_segtree, splay_tree, link_cut_tree, top_tree, rope, cartesian_tree, rb_tree, dancing_links, xor_basis, fft, linear_algebra, gaussian_elimination, generating_function, mobius_inversion, crt, extended_euclidean, pollard_rho, miller_rabin, lucas, euler_phi, discrete_log, discrete_sqrt, discrete_kth_root, pisano, floor_sum, kitamasa, berlekamp_massey, lgv, matroid, burnside, duality, linear_programming, numerical_analysis, statistics, bayes, calculus, physics, pythagoras, harmonic_number, euler_characteristic, gradient_descent, simulated_annealing, arbitrary_precision, randomization, heuristics, invariant, pigeonhole_principle, linearity_of_expectation, permutation_cycle_decomposition, degree_sequence, sprague_grundy, hall, stable_marriage, a_star, tsp, mitm, mo, pbs, cdq, bulldozer, deque_trick, smaller_to_larger, bitset, bitset_lcs, hirschberg, majority_vote, knuth_x, bidirectional_search, dial, birthday, differential_cryptanalysis, utf8, regex, flood_fill, geometry_3d, geometry_hyper, voronoi, delaunay, rotating_calipers, half_plane_intersection, min_enclosing_circle, angle_sorting, point_in_convex_polygon, point_in_non_convex_polygon, geometric_boolean_operations, pick, green, circulation, suffix_array, suffix_tree, palindrome_tree, aho_corasick, manacher, rabin_karp, z, multipoint_evaluation, polynomial_interpolation, flt, hackenbush, inclusion_and_exclusion, lte

→ 이 항목들은 FR-004 매핑 기록에 "제외됨(대회 전용 고급 기법, FR-010)"으로 남긴다 (T013). (수정: 초안에서 누락됐던 flt·hackenbush·inclusion_and_exclusion·lte 4개를 T009 자체 점검 중 발견해 제외 목록에 추가함)

## Notes

- solved.ac는 계층형 태그 체계(예: dp 하위에 dp_tree, dp_bitfield 등)를 갖고 있어, IN-SCOPE로 남긴 세부 DP/트리 태그는 병합 시 상위 개념(다이나믹 프로그래밍, 트리)의 하위 라벨로 자연스럽게 편입된다.
- `set`, `tree_set`, `hash_set`은 모두 "집합/맵" 자료구조의 구현 방식 차이이므로 T006에서 병합 여부를 판단한다.
