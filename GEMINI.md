# Project Overview

This is a Java project for practicing LeetCode problems and preparing for technical interviews. The project is structured to allow for easy testing of different LeetCode problems. It contains a collection of solutions to various LeetCode problems, organized by category and difficulty. The project also includes a `technicalknowledge` directory with markdown files containing notes on various technical interview topics.

# Building and Running

This project does not use a build tool like Maven or Gradle. To compile and run the project, you can use `javac` and `java` directly.

**To run a specific LeetCode problem:**

1.  Open the `src/Main.java` file.
2.  In the `main` method, change the line `tryQuestion(new FindFirstAndLastPositionInSortedArray_34());` to instantiate the class for the problem you want to run.
3.  Compile and run the `Main.java` file:

```bash
javac src/Main.java
java src.Main
```

# Development Conventions

*   Each LeetCode problem has its own class, typically in the `src/lc` directory.
*   The class for a LeetCode problem should extend the `utility.GenerateExample` class and implement the `example()` method to provide test cases.
*   The `Main.java` file is used to run and test a specific LeetCode problem.
*   The `technicalknowledge` directory is for storing notes and resources for technical interviews.
