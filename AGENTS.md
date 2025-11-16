# Repository Guidelines

## Project Structure & Module Organization
The Java sources live in `src`, with `Main.java` for a quick showcase and `Playground.java` for ad-hoc experiments. Solutions stay in packages like `lc.pattern.<topic>` and `lc.blind75`, while reusable helpers sit under `common`, `constant`, `utility`, and domain-specific models in `datastructurealgorithms` or `realworld`. Reference notes, diagrams, and interview prep write-ups belong to `technicalknowledge` (use `technicalknowledge/img` for visuals). Keep assets, schemas, or drafts alongside the closest topic folder instead of the repo root.

## Build, Test, and Development Commands
- `mkdir -p out && javac -d out $(find src -name "*.java")`: compile every class into `out`.
- `java -cp out Main`: run the curated demo defined in `Main`.
- `java -cp out Playground`: execute scratch code; adjust `Playground.main` to exercise new utilities.
- `rg "TODO" -n src`: surface unfinished work before committing.

## Coding Style & Naming Conventions
Use 2-space indentation, braces on the same line, and descriptive CamelCase class names matching the LeetCode problem, e.g., `MaximumAscendingSubarraySum_1800`. Package names stay lowercase and reflect the folder tree (`lc.pattern.slidingwindow`). Prefer immutable method arguments, favor `List`/`Map` interfaces, and keep helper constants under `constant`. Reuse `utility.Util` methods when possible instead of re-implementing parsing or array helpers.

## Testing Guidelines
There is no dedicated JUnit suite yet, so showcase correctness through deterministic examples. Add a `GenerateExample` implementation and wire it up via `Main.tryQuestion(...)`, or instrument `Playground` with targeted inputs/prints. When adding problem-specific checks, name the method `example()` and cover both happy-path and edge inputs (empty arrays, single-character strings, etc.). Document non-trivial scenarios in `technicalknowledge/testing.md` so future contributors understand the approach.

## Commit & Pull Request Guidelines
Commits generally follow `Add <problemId>. <Problem Title>`; keep that style for discoverability. Each commit or PR should note the relevant LeetCode/Grokking link, outline the algorithmic strategy, and mention any helper changes outside the solution file. For pull requests, provide:
- summary of the solution and complexity
- verification steps (commands, sample output)
- linked issue or reference list
- screenshots only when UI assets change (rare here).
