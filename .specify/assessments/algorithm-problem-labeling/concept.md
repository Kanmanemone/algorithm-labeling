# Concept: 알고리즘 문제 라벨링(유형화) 시스템

- **Slug**: algorithm-problem-labeling
- **Created**: 2026-07-21
- **Recommended option**: Option B — Canonical Cross-Platform Mapping Layer (bounded, manually curated)

## Options

### Option A — Adopt existing tools, build nothing
- **Sketch**: Don't build anything new. Point job-seekers at what already exists per-source: solved.ac tags + 난이도 tiers for BOJ, 프로그래머스's official 고득점 Kit for Programmers, LeetCode's own topic tags (optionally augmented by community repos like `berknology/leetcode-classifier`), and Codeforces' tags + rating API. For a unified, curated cross-platform experience, recommend a paid product (Codetree/AlgoExpert) instead.
- **Appetite**: small (a day or two to compile a pointer list).
- **Trade-offs**: Wins: zero build cost, zero legal exposure, immediately available, backed by sources research already confirmed are credible. Sacrifices: does not solve the actual confirmed gap — no shared taxonomy across sources, so the user is back to manual reconciliation (the status quo, per problem.md "Cost of Inaction") or has to pay for someone else's synthesis.
- **Rabbit holes**: None — this is intentionally inert. The risk is *appearing* to solve the problem while leaving the core pain (fragmented, incompatible taxonomies) untouched.

### Option B — Canonical Cross-Platform Mapping Layer (bounded, manually curated)
- **Sketch**: Define one small canonical taxonomy (e.g., ~15–25 types: DP, graph, greedy, DFS/BFS, two-pointer, binary search, implementation, etc. — refined during specification) and manually map a bounded, curated problem set from each in-scope source into it, pulling existing tags via official/semi-official APIs (Codeforces API, solved.ac's community API) rather than scraping problem text or claiming exhaustive "전부" coverage on day one. Output is metadata + links back to the source (no redistribution of problem statements), modeled on how `tony9402/baekjoon` and the LeetCode classifier repos already operate, but explicitly spanning multiple platforms under one shared schema — the piece research confirmed doesn't exist anywhere yet.
- **Appetite**: small–medium (a few weeks for a first useful slice; taxonomy + initial curated set for 1–2 sources before expanding).
- **Trade-offs**: Wins: directly targets the one confirmed differentiator (cross-platform unification) instead of re-doing what solved.ac/Programmers/LeetCode/Codeforces already do; avoids the highest legal-risk activity (bulk scraping/redistributing problem text) by using APIs and linking out; sidesteps the ~78% ML-accuracy ceiling by curating manually, like the credible prior art already does. Sacrifices: "전부" (comprehensive) coverage is not achieved immediately — coverage grows only as fast as curation capacity; still depends on solved.ac's *unofficial*, explicitly-unstable API for BOJ tag data.
- **Rabbit holes**: Taxonomy bikeshedding (endless refinement of category boundaries before shipping anything); scope creep from "bounded curated set" back toward "all problems on all platforms"; ambiguous problems that plausibly fit multiple canonical categories; source-platform tag schemas changing/APIs disappearing out from under the mapping.

### Option C — Automated, comprehensive cross-platform labeling pipeline
- **Sketch**: Build an ingestion + classification pipeline aiming for the literal "전부" (all problems, all sources) framing in the original idea — pulling problems wherever possible (APIs where they exist, scraping where they don't, e.g. BOJ has no official API) and using ML-based tag prediction (per research.md's academic prior art) to auto-assign canonical labels at scale, with human review as a secondary QA pass.
- **Appetite**: large (months) — ingestion infra per source, a maintained classifier, and an ongoing QA/relabeling loop.
- **Trade-offs**: Wins: only option that actually targets the stated "전부" scale. Sacrifices: inherits every risk research flagged as serious — scraping legal exposure on sources without APIs, an ML accuracy ceiling (~78% in published work) that necessitates heavy human QA anyway, and high ongoing maintenance as source sites change. Largely duplicates unresolved research problems rather than known-solvable engineering.
- **Rabbit holes**: Scraper/ToS legal risk (flagged unresolved in problem.md); classifier accuracy/QA loop becoming an open-ended research project; per-platform ingestion breakage as sites change; taxonomy design still has to happen first, so this doesn't avoid Option B's core challenge — it just adds automation and scale risk on top of it.

## Recommendation

**Option B.** Research and the problem definition converge on one specific, confirmed gap: a shared taxonomy spanning multiple authoritative sources doesn't exist anywhere — not in solved.ac, not in 프로그래머스's Kit, not in LeetCode's tags, not in Codeforces' tags, and not fully in any single prior-art repo (`tony9402/baekjoon` and the LeetCode classifiers are each single-platform). Option B is the smallest concept that targets exactly that gap rather than re-implementing work that already exists and is already credible (Option A) or chasing a "comprehensive + automated" scope whose two hardest parts (legal risk on non-API sources, ML labeling accuracy) are both open problems research couldn't resolve (Option C). Building the canonical taxonomy and a bounded curated mapping first also produces the artifact needed to *evaluate* whether automation (Option C) is worth pursuing later — it's a natural stepping stone, not a dead end.

## Out of Scope (for the recommended option)

- Full learning-curriculum content (concept explanations, videos, guided problem sequencing) — inherited from problem.md non-goals.
- Verbatim redistribution/hosting of problem statements — link back to source instead.
- Scraping sources that expose no official/semi-official API/tag data (e.g., BOJ has no official API of its own — only the unofficial solved.ac layer).
- Automated ML-based tag prediction as the primary labeling method — may be revisited later once the taxonomy and a manually-labeled reference set exist.
- Claiming exhaustive "all problems" coverage at launch — coverage is explicitly bounded and grows incrementally.

## Assumptions to Validate

- [NEEDS CLARIFICATION: A canonical taxonomy of roughly 15–25 categories can absorb solved.ac/LeetCode/Codeforces/Programmers tags without unacceptable information loss — not yet tested against real per-source tag lists.]
- solved.ac's API is unofficial and explicitly may be removed or changed without notice (per research.md) — the concept depends on it remaining usable long enough to bootstrap BOJ-side labels, or on a manual fallback being acceptable.
- [NEEDS CLARIFICATION: The end use is a personal/small-scale study aid rather than a public product or dataset — this was never confirmed in problem.md and changes the appetite and legal bar significantly; Option B's "small–medium" sizing assumes the lower-stakes case.]
- Manual, curation-first labeling (as in the credible prior art) is an acceptable trade-off to the user versus expecting full automation from day one.
- [NEEDS CLARIFICATION: Which sources belong in the first bounded slice — problem.md left source scope unresolved, and Option B's appetite depends on starting with 1–2 sources, not all four at once.]
