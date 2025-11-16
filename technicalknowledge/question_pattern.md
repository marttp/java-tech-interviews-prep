# Coding question pattern in Java

เนื่องจากว่าตอนที่เราทำโจทย์ บางโจทย์เราสามารถที่จะ Apply pattern ต่าง ๆ ได้ ซึ่งต้องบอกว่า การรู้ pattern พวกนี้
ไม่ได้ทำให้เราแก้โจทย์ใน LeetCode ได้ทั้งหมด เพียงแต่จะทำให้เราเข้าใจ concept แต่ละโจทย์และประยุกต์ได้ง่ายมากขึ้น

## Array & HashTable

- [Two Sum](https://leetcode.com/problems/two-sum/)
- [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
- [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
- [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
- [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)

### Tips

- **Hash Table is your best friend**: When you need to find pairs, check for duplicates, or count frequencies, a hash table (or `HashMap` in Java) is often the most efficient data structure. It provides O(1) average time complexity for lookups, insertions, and deletions.
- **Pre-computation**: Sometimes, you can pre-compute some values to speed up the main computation. For example, you can compute prefix sums or a frequency map.
- **Think about edge cases**: What if the array is empty? What if it contains only one element? What if all elements are the same?

## Two-Pointers

- [Move Zeroes](https://leetcode.com/problems/two-sum/)
- [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
- [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)
- [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

### Tips

- **Sorted Arrays**: The two-pointers technique is particularly useful for sorted arrays. You can have one pointer at the beginning and one at the end, and move them towards each other.
- **Different Speeds**: Sometimes, the two pointers move at different speeds. This is the "fast and slow pointers" technique, which is useful for cycle detection or finding the middle of a linked list.
- **Sliding Window**: The two pointers can define a "window" that slides over the array. This is useful for problems that ask for a subarray that satisfies certain conditions.

## Sliding Windows

- [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)
- [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)

### Tips

- **Dynamic Window Size**: The size of the window can be dynamic. It can grow or shrink depending on the problem's constraints.
- **Use a Hash Map**: A hash map can be used to keep track of the characters in the current window and their frequencies.
- **Two Pointers**: The sliding window is usually implemented with two pointers, a `start` and an `end` pointer. The `end` pointer expands the window, and the `start` pointer shrinks it.

## String

- [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
- [Valid Anagram](https://leetcode.com/problems/valid-anagram/)
- [Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)
- [Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)
- [Group Anagrams](https://leetcode.com/problems/group-anagrams/)

### Tips

- **Immutability**: In Java, strings are immutable. This means that every time you modify a string, a new string object is created. If you need to do a lot of modifications, it's more efficient to use a `StringBuilder`.
- **Character Manipulation**: Know how to work with characters. The `char` primitive type and the `Character` wrapper class are your friends.
- **Common Methods**: Be familiar with the common string methods like `substring()`, `indexOf()`, `charAt()`, `toCharArray()`, `split()`, etc.

## Linked List

- [Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)
- [Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
- [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
- [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)
- [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
- [LRU Cache](https://leetcode.com/problems/lru-cache/)

### Tips

- **Dummy Head**: When you need to modify the head of the linked list (e.g., remove the first element), it's often easier to use a dummy head. This is a dummy node that points to the head of the list.
- **Two Pointers**: The two-pointers technique is very common in linked list problems. You can use it to find the middle of the list, detect a cycle, or reverse a list.
- **Recursion**: Linked list problems can often be solved recursively. The base case is usually an empty list or a list with one node.

## Fast & Slow Pointers

- [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
- [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)
- [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
- [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)

### Tips

- **Cycle Detection**: If the fast pointer and the slow pointer meet, it means there is a cycle in the linked list.
- **Finding the Middle**: When the fast pointer reaches the end of the list, the slow pointer will be at the middle.
- **Array Problems**: The fast and slow pointers technique can also be used in array problems, for example, to find a duplicate number.

## Modified Binary Search

- [First Bad Version](https://leetcode.com/problems/first-bad-version/)
- [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
- [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

### Tips

- **Search Space**: The key to binary search is to correctly define the search space. The search space should be sorted and you should be able to discard half of it in each step.
- **Variants**: There are many variants of binary search. For example, you might need to find the first or last occurrence of an element, or find the smallest element that is greater than a given value.
- **2D Matrix**: Binary search can be applied to a 2D matrix that is sorted in a special way.

## Stack & Queue

- [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
- [Find the Winner of the Circular Game](https://leetcode.com/problems/find-the-winner-of-the-circular-game)

### Tips

- **LIFO vs. FIFO**: Remember that a stack is Last-In, First-Out (LIFO) and a queue is First-In, First-Out (FIFO).
- **Use Cases for Stack**: Stacks are useful for problems that involve matching parentheses, evaluating expressions, and traversing a tree or graph (DFS).
- **Use Cases for Queue**: Queues are useful for problems that involve processing items in the order they were added, and for traversing a tree or graph (BFS).

## Monotonic Stack

- [Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)
- [Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/)
- [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
- [Online Stock Span](https://leetcode.com/problems/online-stock-span/)

### Tips

- **Increasing or Decreasing**: A monotonic stack is a stack whose elements are always in increasing or decreasing order.
- **Next Greater/Smaller Element**: Monotonic stacks are very useful for problems that ask for the next greater or smaller element.
- **Store Indices**: It's often useful to store the indices of the elements in the stack instead of the elements themselves.

## Backtracking

- [Subsets](https://leetcode.com/problems/subsets/)
- [Permutations](https://leetcode.com/problems/permutations/)
- [Combination Sum](https://leetcode.com/problems/combination-sum/)
- [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)
- [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

### Tips

- **Template**: Backtracking problems can often be solved with a standard template. You have a recursive function that explores all possible solutions.
- **Pruning**: To optimize the backtracking algorithm, you can "prune" the search space by abandoning a path as soon as you know it cannot lead to a valid solution.
- **State Management**: You need to carefully manage the state of the solution being built. This often involves adding an element to the current solution and then removing it (backtracking) to explore other possibilities.

## Merge Interval

- [Merge Intervals](https://leetcode.com/problems/merge-intervals/)
- [Insert Interval](https://leetcode.com/problems/insert-interval/)
- [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)

### Tips

- **Sort by Start Time**: The first step in most merge interval problems is to sort the intervals by their start times.
- **Overlapping Intervals**: Two intervals `[a, b]` and `[c, d]` overlap if `a <= d` and `c <= b`.
- **Merging**: If two intervals overlap, you can merge them into a single interval `[min(a, c), max(b, d)]`.

## Cyclic Sort

- [Missing Number](https://leetcode.com/problems/missing-number/)
- [Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
- [First Missing Positive](https://leetcode.com/problems/first-missing-positive/)

### Tips

- **Range of Numbers**: Cyclic sort is used for problems where the input is an array of numbers in a specific range (e.g., 1 to n).
- **In-place**: The idea is to place each number at its correct index. For example, if the numbers are from 1 to n, the number `i` should be at index `i - 1`. This is done in-place, i.e., without using any extra space.
- **Find Missing/Duplicate Numbers**: After sorting the array with cyclic sort, you can iterate through it to find missing or duplicate numbers.

## Tree - DFS

- [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
- [Path Sum](https://leetcode.com/problems/path-sum/)
- [Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/)
- [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
- [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
- [Path Sum II](https://leetcode.com/problems/path-sum-ii/)
- [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

### Tips

- **Recursion**: DFS on a tree is naturally implemented with recursion. The base case is usually a null node.
- **Pre-order, In-order, Post-order**: There are three main ways to traverse a tree with DFS: pre-order (root, left, right), in-order (left, root, right), and post-order (left, right, root).
- **Path Problems**: DFS is useful for problems that involve finding a path from the root to a leaf, or finding the maximum path sum.

## Tree - BFS

- [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)
- [Average of Levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree/)
- [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
- [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
- [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

### Tips

- **Queue**: BFS on a tree is implemented with a queue. You add the root to the queue, and then in each step, you dequeue a node and enqueue its children.
- **Level Order Traversal**: BFS is used for level order traversal of a tree, where you visit the nodes level by level.
- **Shortest Path**: BFS is useful for finding the shortest path from the root to a node.

## Trie

- [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)
- [Replace Words](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)
- [Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)
- [Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/)

### Tips

- **Prefix Problems**: Tries are very useful for problems that involve prefixes, such as autocomplete or finding all words with a given prefix.
- **Node Structure**: Each node in a trie represents a character. A common way to implement a trie node is with a hash map or an array to store its children.
- **End of Word**: You need a way to mark the end of a word in the trie. This is usually done with a boolean flag in the node.

## Top K Elements

- [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
- [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
- [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)
- [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
- [Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/)
- [Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/)
- [Reorganize String](https://leetcode.com/problems/reorganize-string/)

### Tips

- **Heap (Priority Queue)**: The most common way to solve "Top K" problems is to use a min-heap or a max-heap (or a `PriorityQueue` in Java).
- **Min-Heap vs. Max-Heap**: If you need to find the top K largest elements, you can use a min-heap of size K. If you need to find the top K smallest elements, you can use a max-heap of size K.
- **Quickselect**: Quickselect is another algorithm that can be used to find the Kth smallest or largest element in an unsorted array. It has an average time complexity of O(n).

## K-way Merge

- [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
- [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
- [Find K Pairs with Smallest Sums](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/)
- [Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)

### Tips

- **Min-Heap**: The K-way merge pattern is used to merge K sorted lists. The most common way to solve this is to use a min-heap.
- **Storing Tuples**: You can store tuples of (element, list_index, element_index) in the min-heap to keep track of which element came from which list.
- **Matrix Problems**: This pattern can also be applied to problems that involve a sorted matrix.

## 2 Heaps

- [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)

### Tips

- **Median Problems**: The 2 heaps pattern is very useful for problems that involve finding the median of a stream of numbers.
- **Max-Heap and Min-Heap**: You use a max-heap to store the smaller half of the numbers and a min-heap to store the larger half.
- **Balancing**: The two heaps should be kept balanced, so that they have roughly the same number of elements.

## Graph

- [Clone Graph](https://leetcode.com/problems/clone-graph/)
- [Find if Path Exists in Graph - DFS](https://leetcode.com/problems/find-if-path-exists-in-graph/)
- [Find if Path Exists in Graph - BFS](https://leetcode.com/problems/find-if-path-exists-in-graph/)
- [All Paths From Source to Target](https://leetcode.com/problems/all-paths-from-source-to-target/)
- [Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)
- [Word Search](https://leetcode.com/problems/word-search/)
- [Word Search II](https://leetcode.com/problems/word-search-ii/)
- [Number of Islands](https://leetcode.com/problems/number-of-islands/)
- [Surrounded Regions](https://leetcode.com/problems/surrounded-regions/)
- [Max Area of Island](https://leetcode.com/problems/max-area-of-island/)
- [01 Matrix](https://leetcode.com/problems/01-matrix/)
- [Word Ladder](https://leetcode.com/problems/word-ladder/)

### Tips

- **Adjacency List vs. Adjacency Matrix**: You can represent a graph with an adjacency list or an adjacency matrix. An adjacency list is usually more efficient for sparse graphs, while an adjacency matrix is better for dense graphs.
- **DFS and BFS**: Be comfortable with both Depth-First Search (DFS) and Breadth-First Search (BFS) for traversing a graph.
- **Visited Set**: When traversing a graph, you need to keep track of the visited nodes to avoid infinite loops.

## Union-Find

- [Find if Path Exists in Graph - Union Find](https://leetcode.com/problems/find-if-path-exists-in-graph/)
- [Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
- [Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)

### Tips

- **Disjoint Sets**: The Union-Find data structure is used to keep track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets.
- **`union()` and `find()`**: The two main operations are `union()`, which merges two subsets, and `find()`, which determines which subset an element belongs to.
- **Path Compression and Union by Rank/Size**: These are two optimizations that can be used to make the Union-Find data structure more efficient.

## Topological Sort

- [Course Schedule](https://leetcode.com/problems/course-schedule/)
- [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)

### Tips

- **DAGs**: Topological sort is used for Directed Acyclic Graphs (DAGs).
- **In-degree**: The algorithm uses the in-degree of each node (the number of incoming edges).
- **Queue**: You start with the nodes that have an in-degree of 0 and add them to a queue. Then, you process the nodes in the queue, and for each node you process, you decrement the in-degree of its neighbors.

## Minimum Spanning Tree

- [Min Cost to Connect All Points [Kruskal]](https://leetcode.com/problems/min-cost-to-connect-all-points/)
- [Min Cost to Connect All Points [Prim]](https://leetcode.com/problems/min-cost-to-connect-all-points/)

### Tips

- **Weighted Undirected Graphs**: MST algorithms are used for weighted undirected graphs.
- **Kruskal's vs. Prim's**: Kruskal's algorithm sorts the edges by weight and adds them to the MST if they don't form a cycle. Prim's algorithm starts from a single node and grows the MST by adding the cheapest edge that connects a node in the MST to a node outside the MST.
- **Union-Find**: Kruskal's algorithm uses the Union-Find data structure to detect cycles.

## Single-Source-Shortest Path

- [Network Delay Time [Djisktra]](https://leetcode.com/problems/network-delay-time/)
- [Network Delay Time [Bellman-ford]](https://leetcode.com/problems/network-delay-time/)

### Tips

- **Dijkstra's vs. Bellman-Ford**: Dijkstra's algorithm is faster, but it only works for graphs with non-negative edge weights. Bellman-Ford is slower, but it can handle negative edge weights.
- **Priority Queue**: Dijkstra's algorithm uses a priority queue to efficiently select the next node to visit.
- **Relaxation**: Both algorithms use the concept of "relaxation", where you repeatedly update the estimated shortest distance to a node.

## Dynamic Programming - 0/1 Knapsack

- [Target Sum](https://leetcode.com/problems/target-sum/)
- [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
- [House Robber](https://leetcode.com/problems/house-robber/)

### Tips

- **Choice**: For each item, you have two choices: either include it in the knapsack or not.
- **DP Table**: You can use a 2D DP table, where `dp[i][j]` represents the maximum value you can get with the first `i` items and a knapsack of capacity `j`.
- **Bottom-up or Top-down**: You can solve knapsack problems with a bottom-up (tabulation) or a top-down (memoization) approach.

## Dynamic Programming - Unbound Knapsack

- [Coin Change](https://leetcode.com/problems/coin-change/)
- [Coin Change II](https://leetcode.com/problems/coin-change-ii/)

### Tips

- **Unlimited Items**: In the unbound knapsack problem, you can use each item an unlimited number of times.
- **1D DP Table**: You can solve this problem with a 1D DP table, where `dp[j]` represents the maximum value you can get with a knapsack of capacity `j`.
- **Order of Loops**: The order of the loops matters. The outer loop should be for the items, and the inner loop should be for the knapsack capacity.

## Dynamic Programming - Fibonacci

- [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)
- [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

### Tips

- **Overlapping Subproblems**: Fibonacci numbers are a classic example of a problem with overlapping subproblems.
- **Memoization**: You can use memoization (a top-down approach) to store the results of subproblems that have already been solved.
- **Tabulation**: You can also use tabulation (a bottom-up approach) to solve the problem iteratively.

## Dynamic Programming - Longest Palindromic Subsequence (LPS)

- [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)
- [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)
- [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

### Tips

- **Reverse the String**: The longest palindromic subsequence of a string is the longest common subsequence of the string and its reverse.
- **DP Table**: You can use a 2D DP table, where `dp[i][j]` represents the length of the longest palindromic subsequence of the substring `s[i...j]`.
- **Base Case**: The base case is `dp[i][i] = 1` for all `i`.

## Dynamic Programming - Longest Common Subsequence (LCS)

- [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)
- [Shortest Common Supersequence](https://leetcode.com/problems/shortest-common-supersequence/)
- [Edit Distance](https://leetcode.com/problems/edit-distance/)
- [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

### Tips

- **2D DP Table**: You can use a 2D DP table, where `dp[i][j]` represents the length of the longest common subsequence of the first `i` characters of string `s1` and the first `j` characters of string `s2`.
- **Recurrence Relation**: If `s1[i] == s2[j]`, then `dp[i][j] = 1 + dp[i-1][j-1]`. Otherwise, `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`.
- **Variations**: There are many variations of the LCS problem, such as finding the shortest common supersequence or the edit distance between two strings.

## Dynamic Programming - General

- [Unique Paths](https://leetcode.com/problems/unique-paths/)
- [Perfect Squares](https://leetcode.com/problems/perfect-squares/)
- [Triangle](https://leetcode.com/problems/triangle/)
- [Word Break](https://leetcode.com/problems/word-break/)
- [Word Break II](https://leetcode.com/problems/word-break-ii/)
- [Concatenated Words](https://leetcode.com/problems/concatenated-words/)
- [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)

### Tips

- **Identify the Subproblem**: The key to solving a DP problem is to identify the subproblem and the recurrence relation.
- **Memoization vs. Tabulation**: Decide whether to use a top-down (memoization) or a bottom-up (tabulation) approach. Memoization is often more intuitive, but tabulation can be more efficient.
- **State Transition**: Think about how to transition from one state to another.

## Bitwise

- [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)
- [Hamming Distance](https://leetcode.com/problems/hamming-distance/)
- [Counting Bits](https://leetcode.com/problems/counting-bits/)
- [Total Hamming Distance](https://leetcode.com/problems/total-hamming-distance/)

### Tips

- **Know the Operators**: Be familiar with the bitwise operators: `&` (AND), `|` (OR), `^` (XOR), `~` (NOT), `<<` (left shift), and `>>` (right shift).
- **Common Tricks**: There are many common bitwise tricks, such as checking if a number is a power of 2 (`n & (n - 1) == 0`), or swapping two numbers without a temporary variable (`a ^= b; b ^= a; a ^= b;`).
- **Masks**: You can use masks to set, clear, or toggle a specific bit.
