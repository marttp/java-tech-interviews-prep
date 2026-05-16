# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Purpose

Java-based LeetCode and technical interview preparation repository. Contains algorithmic solutions organized by pattern, foundational DSA implementations, and markdown reference notes covering system design, SQL, AI, microservices, and more — targeted at Java Backend Developer roles.

## Build & Run

No build tool (no Maven/Gradle). Uses plain `javac`/`java`.

**Compile all sources:**
```bash
javac -d out $(find src -name "*.java")
```

**Run a solution:**
```bash
java -cp out Main
```

To test a specific solution, edit `src/Main.java` and update the `tryQuestion(...)` call with the desired class, then recompile and run.

**Quick single-file compile (for top-level classes with no cross-package deps):**
```bash
javac src/Main.java
java -cp src Main
```

## Source Layout

```
src/
  Main.java                   # Entry point — swap in the class to test here
  Playground.java             # Scratch/experiment file
  common/                     # Shared data structure nodes (TreeNode, ListNode, Node, etc.)
  common/unionfind/           # Union-Find structure
  constant/                   # Shared constants (StringConstant.LOWERCASE_AMOUNT, GraphConstant)
  utility/                    # GenerateExample interface, Util, TreePrinter, MathUtil
  datastructurealgorithms/    # Standalone DSA demos (sorting, searching, graph, heap, trie, etc.)
  lc/
    blind75/                  # Blind 75 solutions (easy/medium/hard)
    general/                  # Miscellaneous LC problems
    pattern/                  # Solutions grouped by algorithmic pattern (primary learning path)
  additional/                 # Standalone complex algorithms (KMP, Dijkstra, Prim, etc.)
  realworld/                  # Real-world problem simulations
technicalknowledge/           # Markdown study notes (HLD, SDI, DSA, SQL, OOD, AI, microservices)
```

## Solution Conventions

Every solution class must:
1. Implement `utility.GenerateExample` (`void example()`)
2. The `example()` method contains all test cases and prints verification output — no separate test framework is used

**Pattern solutions** live under `src/lc/pattern/<pattern-name>/` and are the recommended focus for structured learning. Patterns include: sliding window, two pointers, fast/slow pointer, merge interval, cyclic sort, in-place linked list, BFS/DFS tree, graph traversal, heap, binary search, backtracking, topological sort, union-find, monotonic stack, prefix sum, k-way merge, two heaps, trie, and DP sub-patterns (fibonacci, knapsack 0/1, unbounded knapsack, LCS, palindromic subsequence).

## Shared Utilities

- `Util` — `swap`, `reverse`, `getLowercaseIndex`, `isInbound`, `sum`, `listToIntArray`
- `TreePrinter` — visualize `TreeNode` structures
- `MathUtil` — math helpers
- `constant.StringConstant.LOWERCASE_AMOUNT` — use instead of magic number `26`

## Technical Knowledge Notes

All markdown notes are in `technicalknowledge/`. Key files:
- `dsa_java.md` — DSA reference with Java syntax
- `question_pattern.md` — pattern-to-problem mapping
- `high_level_design.md` / `sdi_fundemental.md` — system design prep
- `ai_fundamentals.md`, `microservice_design_patterns.md`, `ood.md`, `db_schema_design.md`, `sql_crash_course.md`, `testing.md`, `network101.md`
