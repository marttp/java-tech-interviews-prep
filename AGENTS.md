# AGENTS.md

## Build & Run

No Maven/Gradle. Plain `javac`/`java` only.

**Run a specific solution:**
1. Edit `src/Main.java` — change the import and the `tryQuestion(new ...())` call to the target class
2. Compile and run:
   ```bash
   javac -d out $(find src -name "*.java")
   java -cp out Main
   ```
   For a quick compile of a top-level-only class (no cross-package deps):
   ```bash
   javac src/Main.java
   java -cp src Main
   ```

`out/` is gitignored. There is no test framework — verification is done visually via `example()` output.

## Solution Conventions

- Every solution class **must** implement `utility.GenerateExample` (single method: `void example()`)
- `example()` contains all test cases and prints results — no JUnit or other test runners
- When creating a new solution, follow this pattern:
  ```java
  package lc.pattern.<patternname>;
  import utility.GenerateExample;

  public class ProblemName_XXX implements GenerateExample {
      @Override
      public void example() { /* test cases + System.out here */ }
  }
  ```

## Shared Utilities

- `utility.Util` — `swap`, `reverse`, `getLowercaseIndex`, `isInbound`, `sum`, `listToIntArray`, `min3Elem`, `max3Elem`
- `utility.TreePrinter` — visualize `TreeNode` structures
- `utility.MathUtil` — math helpers
- `constant.StringConstant.LOWERCASE_AMOUNT` (value `26`) — use instead of magic number 26
- `constant.GraphConstant` — graph-related constants
- Common data structure nodes in `src/common/`: `TreeNode`, `ListNode`, `Node`, `Edge`, `Point`, `Cell`, `Vertex`, `TreeNodeWithNext`, `NodeWithRandomPointer`, `ImmutableListNode`
- Union-Find in `src/common/unionfind/`

## Source Layout

- `src/Main.java` — entry point, swap in the class to test here
- `src/Playground.java` — scratch/experiment file
- `src/lc/pattern/<pattern>/` — solutions grouped by algorithmic pattern (primary learning path, 21 patterns)
- `src/lc/blind75/` — Blind 75 solutions (easy/medium/hard)
- `src/lc/general/` — miscellaneous LeetCode problems
- `src/additional/` — standalone complex algorithms (KMP, Dijkstra, Prim, etc.)
- `src/datastructurealgorithms/` — foundational DSA demos (sorting, searching, graph, heap, trie)
- `src/realworld/` — real-world problem simulations
- `technicalknowledge/` — markdown study notes (HLD, SDI, DSA, SQL, AI, microservices, OOD, testing, networking)

## Gotchas

- `isInbound` in `Util` checks `grid.length` for both row and column bounds (not `grid[0].length`) — this assumes square grids
- Solution class names follow the pattern `ProblemName_XXX` where `XXX` is the LeetCode problem number
- Pattern directory names are lowercase with no separators (e.g., `slidingwindow`, `fastnslowpointer`, `modifiedbinarysearch`)
