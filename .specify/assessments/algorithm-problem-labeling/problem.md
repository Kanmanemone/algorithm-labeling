# Problem Definition: 알고리즘 문제 라벨링(유형화) 시스템

- **Slug**: algorithm-problem-labeling
- **Created**: 2026-07-21
- **Inputs used**: intake.md, research.md

## Problem Statement

Job seekers preparing for technical/coding-test interviews (취업준비생) need to understand the full landscape of algorithm problem *types* they may encounter, but authoritative problem sources (BOJ/solved.ac, 프로그래머스, LeetCode, Codeforces, etc.) each expose their own partial, mutually incompatible tagging and difficulty schemes — no single, unified, cross-source taxonomy exists today. As a result, a learner who wants comprehensive, systematic type coverage must manually reconcile fragmented labels across multiple sites, or pay for a commercial product that has already done so.

## Affected Users & Stakeholders

- **Users**: 취업준비생 (job seekers/candidates preparing for coding tests and technical interviews) — the people who must plan their study around problem types and currently do so by cross-referencing multiple, inconsistently-labeled sources. [source: research.md "Users & Demand"]
- **Stakeholders**:
  - Project owner/builder (the user running this assessment) — decides scope, bears build/legal/maintenance cost. [NEEDS CLARIFICATION: solo project or on behalf of a team/organization? — carried from intake.md]
  - Source platforms (BOJ/acmicpc.net, 프로그래머스, LeetCode, Codeforces, solved.ac) — hold the underlying problem data and existing tag systems; their ToS/API availability gates how this can be built. [source: research.md "Data & Constraints"]
  - Existing commercial competitors (Codetree, AlgoExpert) and open-source maintainers (`tony9402/baekjoon`, LeetCode classifier repos, solved.ac community) — indirect stakeholders whose prior work defines the bar for differentiation. [source: research.md "Prior Art"]

## Goals

- Comprehensive coverage: label the range of algorithm problem types job seekers actually encounter, spanning multiple authoritative sources rather than a single platform. [source: intake.md restated idea]
- A **unified, cross-platform taxonomy** — the one thing research confirmed does *not* yet exist anywhere (each source uses its own incompatible tags/difficulty scale). This is the clearest candidate differentiator versus existing prior art. [source: research.md "Evidence Against the Idea"]
- Labels grounded in, or traceable to, authoritative/credible sources ("공신력 있는 곳") rather than the builder's own unvalidated guesses.

## Non-Goals

- [NEEDS CLARIFICATION: Building a full learning curriculum (concept explanations, videos, guided problem progression) — this is Codetree/Programmers-Kit territory and was not requested; tentatively out of scope unless the user says otherwise.]
- Verbatim redistribution/hosting of full problem statements from source platforms — research flagged this as the highest legal-risk activity (copyright / 부정경쟁방지법 exposure); labeling/metadata with links back to the source is the safer boundary. [source: research.md "Data & Constraints", "Evidence Against the Idea"]
- Novel ML research into automatic tag classification as an end in itself — existing academic work already explores this (~78% accuracy ceiling); if automation is used, it is a means to labeling, not the deliverable. [source: research.md "Prior Art" — arXiv:2308.01863]

## Success Metrics

- [NEEDS CLARIFICATION: Target coverage — number/percentage of problems labeled, and across how many sources — no target defined yet (baseline: 0 problems labeled under a unified scheme today).]
- Cross-source consistency: a problem sourced from any covered platform can be mapped into the *same* shared taxonomy (baseline: 0 today — every platform's tags are separate and incompatible per research.md).
- [NEEDS CLARIFICATION: Label accuracy/quality bar — e.g. agreement rate against expert/community review — not yet defined; matters especially if any automated labeling is used, given the ~78% ceiling observed in academic work.]
- [NEEDS CLARIFICATION: Adoption/usage signal, if the output is meant for others (public dataset/service) rather than personal use — no baseline exists since scope/audience is undefined.]

## Cost of Inaction

If nothing is built, job seekers continue what they already do today: manually cross-reference several free, official, per-platform taxonomies (solved.ac tags, 프로그래머스 고득점 Kit, LeetCode topics, Codeforces tags) to piece together their own mental model of problem types — or pay for a commercial product (Codetree, AlgoExpert) that has already unified this for them. This is inefficient and duplicative but not blocking: credible alternatives already exist on both the free and paid ends of the spectrum, so inaction preserves the status quo rather than leaving a hard gap. [source: research.md "Market & Context", "Evidence Against the Idea"]

## Open Questions

- [NEEDS CLARIFICATION: Which sources are in scope (BOJ/solved.ac, 프로그래머스, LeetCode, Codeforces, others)? Carried from intake.md and research.md — unresolved.]
- [NEEDS CLARIFICATION: What are the taxonomy's dimensions/axes (자료구조, 기법, 난이도, 기업, 문제 출처 등) and how are conflicts between sources' existing tags reconciled?]
- [NEEDS CLARIFICATION: What is the end use of the labeled output — personal study tool, open dataset, public service, or ML training data? This changes both the success metrics and the legal-risk tolerance.]
- [NEEDS CLARIFICATION: What differentiates this effort from `tony9402/baekjoon`, solved.ac's tags, 프로그래머스's 고득점 Kit, and commercial products (Codetree, AlgoExpert)? Without an answer, the project risks duplicating existing, already-credible work.]
- [NEEDS CLARIFICATION: Will data be acquired via official/semi-official APIs (Codeforces API, solved.ac's unofficial API) or via direct scraping of HTML/problem text? This materially changes legal exposure — see research.md "Data & Constraints."]
- [NEEDS CLARIFICATION: acmicpc.net's and programmers.co.kr's actual Terms of Service text (crawling/redistribution clauses) remain unverified — needs direct human review before any data-collection design is finalized.]
- [NEEDS CLARIFICATION: Manual curation (as in existing prior art) vs. automated ML-based labeling at "전부" (comprehensive) scale — the two paths carry very different feasibility, cost, and quality trade-offs.]
- [NEEDS CLARIFICATION: Is this a solo effort or for a team/organization? Any target scale (problem count) or timeline?]
