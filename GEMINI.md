# Gemini CLI Project Guide: Java Technical Interview Prep

This repository is a comprehensive resource for practicing LeetCode problems and preparing for technical interviews, specifically tailored for Java developers. It includes solutions to various algorithmic challenges and a wealth of theoretical knowledge.

## Project Overview

- **Purpose:** A structured environment for mastering Data Structures & Algorithms (DSA) and technical interview concepts.
- **Language:** Java (standard version, no specific framework required for core logic).
- **Core Components:**
    - `src/`: Primarily for LeetCode solutions (in `src/lc/`) and fundamental Data Structures & Algorithms implementations.
    - `technicalknowledge/`: General technical interview knowledge (HLD, LLD, SQL, AI) curated specifically for Java Backend Developer roles.
    - `src/additional`: Miscellaneous complex algorithms (e.g., KMP, Graph algorithms like Dijkstra, Prim).
    - `src/utility`: Helper classes for tree printing, math utilities, and test case generation.

## Building and Running

This project does not use Maven or Gradle. It relies on standard `javac` and `java` commands.

### Running a Specific Solution
To execute and test a particular LeetCode solution or algorithm:
1.  Open `src/Main.java`.
2.  In the `main` method, update the `tryQuestion` call to instantiate the desired class.
    *   Example: `tryQuestion(new FindFirstAndLastPositionInSortedArray_34());`
3.  Compile and run from the root directory:
    ```bash
    javac src/Main.java
    java -cp src Main
    ```
    *Note: Since the files are in packages, you might need to compile all files or specify the source path:*
    ```bash
    javac -d out $(find src -name "*.java")
    java -cp out Main
    ```

### Using the Playground
- `src/Playground.java` is available for quick experiments or scratchpad work.

## Development Conventions

- **Solution Structure:** Each LeetCode or algorithm class should:
    - Implement the `utility.GenerateExample` interface.
    - Implement the `example()` method to provide self-contained test cases and output.
- **Helper Usage:** 
    - Use `utility.Util` for common operations like array swapping, reversing, and boundary checks.
    - Use `utility.TreePrinter` for visualizing `TreeNode` structures.
- **Documentation:**
    - Technical notes are located in `technicalknowledge/`.
    - When contributing or modifying solutions, ensure the `example()` method provides clear output for verification.

## Architecture & Patterns
- Solutions in `src/lc/pattern/` are grouped by common algorithmic techniques (e.g., Slidng Window, Two Pointers, Modified Binary Search), which is highly recommended for structured learning.
- Common data structures (TreeNode, ListNode, Node) are centralized in `src/common/`.
