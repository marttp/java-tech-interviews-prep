# Data Structures & Algorithms in Java (Crash Course)

## Video format

[Data Structures & Algorithms in Java ที่พอจำเป็นในการใช้สมัครงาน](https://youtube.com/playlist?list=PLm3A9eDaMzun0A4KBOHYBAr8m_4Avad5C&si=J22RFpAHBzsT0nBt)

Playlist นี้ถูกจัดทำขึ้นด้วย Mindset ที่จะยกระดับความรู้พื้นฐานของ Java Developer และบุคคลที่สนใจในการเรียนรู้ Data
Structures และ Algorithms โดยมีเป้าหมายเพื่อให้ทักษะที่จำเป็นสำหรับการสมัครงาน โดยเฉพาะ Technical interview
กับบริษัทต่าง ๆเนื้อหาถูกออกแบบมาให้มีความเป็นประโยชน์และเกี่ยวข้องกับการใช้งานจริง
เพื่อให้ผู้เรียนสามารถนำสิ่งที่เรียนรู้ไปใช้ในสถานการณ์จริงได้
ไม่ว่าคุณจะเป็นนักพัฒนาที่มีประสบการณ์ที่ต้องการทบทวนทักษะของคุณ หรือเป็นผู้เริ่มต้นที่ต้องการเรียนรู้ Playlist
นี้ถูกออกแบบมาสำหรับทุกคน

## เนื้อหา

## 1. Big-O Notation
Big-O notation is used to describe the performance or complexity of an algorithm. It tells you how the runtime of an algorithm grows as the input size grows.

*   **O(1) - Constant Time**: The runtime is constant, regardless of the input size.
    *   Example: Accessing an element in an array by its index.
*   **O(log n) - Logarithmic Time**: The runtime grows logarithmically with the input size.
    *   Example: Binary search in a sorted array.
*   **O(n) - Linear Time**: The runtime grows linearly with the input size.
    *   Example: Iterating through an array.
*   **O(n log n) - Log-Linear Time**: The runtime grows n times log n.
    *   Example: Efficient sorting algorithms like Merge Sort and Quick Sort.
*   **O(n^2) - Quadratic Time**: The runtime grows quadratically with the input size.
    *   Example: Nested loops, Bubble Sort.
*   **O(2^n) - Exponential Time**: The runtime doubles with each addition to the input data set.
    *   Example: Recursive calculation of Fibonacci numbers.
*   **O(n!) - Factorial Time**: The runtime grows factorially with the input size.
    *   Example: Traveling Salesman Problem.

[INSERT_IMAGE] A graph showing the growth rates of different Big-O complexities. The x-axis represents the input size, and the y-axis represents the number of operations.

## 2. Bit Manipulations
Bit manipulation is the act of algorithmically manipulating bits or other pieces of data shorter than a word.

*   **AND (&)**: Returns 1 if both bits are 1, otherwise 0.
*   **OR (|)**: Returns 1 if at least one of the bits is 1, otherwise 0.
*   **XOR (^)**: Returns 1 if the bits are different, otherwise 0.
*   **NOT (~)**: Inverts the bits.
*   **Left Shift (<<)**: Shifts the bits to the left, filling the rightmost bits with 0s. Equivalent to multiplying by 2.
*   **Right Shift (>>)**: Shifts the bits to the right. For positive numbers, the leftmost bits are filled with 0s. For negative numbers, the behavior depends on the language (arithmetic vs. logical shift).

**Common Use Cases:**
*   Checking if a number is even or odd: `(n & 1) == 0` for even, `(n & 1) == 1` for odd.
*   Setting a bit: `n | (1 << k)` sets the k-th bit of n.
*   Clearing a bit: `n & ~(1 << k)` clears the k-th bit of n.
*   Toggling a bit: `n ^ (1 << k)` toggles the k-th bit of n.

## 3. Pointers and References in Java
Java does not have explicit pointers like C or C++. Instead, it uses references.

*   **Primitive Types**: `int`, `char`, `boolean`, etc., are passed by value. When you pass a primitive variable to a method, a copy of the variable is made.
*   **Object Types**: All objects in Java are accessed through references. When you pass an object to a method, the reference to the object is passed by value. This means the method gets a copy of the reference, but both the original reference and the copy point to the same object in memory. Therefore, changes made to the object's state within the method will be reflected outside the method.

## 4. Linked Lists
A linked list is a linear data structure where elements are not stored at contiguous memory locations. The elements in a linked list are linked using pointers.

[INSERT_DIAGRAM] A diagram of a simple linked list with 3 nodes. Each node contains a data field and a `next` pointer to the next node. The last node's `next` pointer is null.

### Singly Linked List
Each node in a singly linked list contains a data field and a `next` field, which points to the next node in the sequence.

**Complexity:**
*   Access: O(n)
*   Search: O(n)
*   Insertion: O(1) (if at the beginning) / O(n) (if at the end or in the middle)
*   Deletion: O(1) (if at the beginning) / O(n) (if at the end or in the middle)

### Doubly Linked List
Each node in a doubly linked list contains a data field, a `next` field, and a `prev` field, which points to the previous node in the sequence.

**Complexity:**
*   Access: O(n)
*   Search: O(n)
*   Insertion: O(1) (if at the beginning or end) / O(n) (if in the middle)
*   Deletion: O(1) (if at the beginning or end) / O(n) (if in the middle)

### Circular Linked List
In a circular linked list, the last node points to the first node, forming a circle. This can be a singly or doubly circular linked list.

### Fast & Slow Pointers
This is a technique used in linked lists and arrays to solve problems like cycle detection, finding the middle of a linked list, etc. Two pointers, a fast one and a slow one, are used. The fast pointer moves two steps at a time, while the slow pointer moves one step at a time.

## 5. Stacks
A stack is a linear data structure that follows the Last-In, First-Out (LIFO) principle.

[INSERT_DIAGRAM] A diagram of a stack, showing the push and pop operations.

**Common Operations:**
*   `push(element)`: Adds an element to the top of the stack.
*   `pop()`: Removes and returns the top element of the stack.
*   `peek()`: Returns the top element of the stack without removing it.
*   `isEmpty()`: Checks if the stack is empty.

**Implementation:**
*   Using an array or a linked list.

**Complexity (for both array and linked list implementations):**
*   Push: O(1)
*   Pop: O(1)
*   Peek: O(1)

## 6. Queues

A queue is a linear data structure that follows the First-In, First-Out (FIFO) principle.



[INSERT_DIAGRAM] A diagram of a queue, showing the enqueue and dequeue operations.



**Common Operations:**

*   `enqueue(element)`: Adds an element to the rear of the queue.

*   `dequeue()`: Removes and returns the front element of the queue.

*   `peek()`: Returns the front element of the queue without removing it.

*   `isEmpty()`: Checks if the queue is empty.



**Implementation:**

*   Using an array (with a circular buffer) or a linked list.



**Complexity (for both array and linked list implementations):**

*   Enqueue: O(1)

*   Dequeue: O(1)

*   Peek: O(1)



## 7. Searching

### Linear Search

Linear search is a simple search algorithm that sequentially checks each element of a list until a match is found or the whole list has been searched.



**Complexity:**

*   Best Case: O(1) (the first element is the match)

*   Worst Case: O(n)

*   Average Case: O(n)



### Binary Search

Binary search is an efficient algorithm for finding an item from a **sorted** list of items. It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one.



**Complexity:**

*   Best Case: O(1)

*   Worst Case: O(log n)

*   Average Case: O(log n)



## 8. Hash Tables

A hash table is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A hash table uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found.



[INSERT_DIAGRAM] A diagram of a hash table. It should show keys being passed through a hash function to generate an index. The diagram should also illustrate how collisions are handled, for example, by using a linked list at each index.



**Collision Handling:**

*   **Separate Chaining**: Each bucket is independent, and has some sort of list of entries with the same index.

*   **Open Addressing**: All entry records are stored in the bucket array itself. When a new entry has to be inserted, the buckets are examined, starting with the hashed-to slot and proceeding in some probe sequence, until an unoccupied slot is found.



**Complexity:**

*   Average Case (for search, insert, delete): O(1)

*   Worst Case (with collisions): O(n)



## 10. Sorting
### Insertion Sort
Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.

**Complexity:**
*   Best Case: O(n) (if the array is already sorted)
*   Worst Case: O(n^2)
*   Average Case: O(n^2)

### Selection Sort
Selection sort is an in-place comparison sorting algorithm. It has an O(n^2) time complexity, which makes it inefficient on large lists, and generally performs worse than the similar insertion sort.

**Complexity:**
*   Best Case: O(n^2)
*   Worst Case: O(n^2)
*   Average Case: O(n^2)

### Bubble Sort
Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order.

**Complexity:**
*   Best Case: O(n) (if the array is already sorted)
*   Worst Case: O(n^2)
*   Average Case: O(n^2)

### Quick Sort
Quicksort is an efficient, in-place sorting algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively.

**Complexity:**
*   Best Case: O(n log n)
*   Worst Case: O(n^2) (if the pivot is always the smallest or largest element)
*   Average Case: O(n log n)

### Merge Sort
Merge sort is an efficient, stable, comparison-based sorting algorithm. Most implementations produce a stable sort, which means that the order of equal elements is the same in the input and output.

**Complexity:**
*   Best Case: O(n log n)
*   Worst Case: O(n log n)
*   Average Case: O(n log n)

### Counting Sort
Counting sort is a sorting algorithm that sorts the elements of an array by counting the number of occurrences of each unique element in the array. It is only efficient if the range of input data is not significantly greater than the number of objects to be sorted.

**Complexity:**
*   Best Case: O(n + k) (where k is the range of the input data)
*   Worst Case: O(n + k)
*   Average Case: O(n + k)

## 11. Trees
A tree is a hierarchical data structure that consists of nodes connected by edges.

[INSERT_DIAGRAM] A diagram of a generic tree, showing the root, parent, child, and leaf nodes.

### Tree Traversal
*   **In-order Traversal**: Left, Root, Right.
*   **Pre-order Traversal**: Root, Left, Right.
*   **Post-order Traversal**: Left, Right, Root.

### Binary Search Tree (BST)
A binary search tree is a binary tree in which for each node, all elements in the left subtree are less than the node, and all elements in the right subtree are greater than the node.

**Complexity:**
*   Average Case (for search, insert, delete): O(log n)
*   Worst Case (if the tree is unbalanced): O(n)

### Heap
A heap is a specialized tree-based data structure that satisfies the heap property: if P is a parent node of C, then the key (the value) of P is either greater than or equal to (in a max heap) or less than or equal to (in a min heap) the key of C.

**Complexity:**
*   Insertion: O(log n)
*   Deletion of max/min: O(log n)
*   Peek: O(1)

### Trie
A trie, also called digital tree or prefix tree, is a type of search tree, a tree data structure used for locating specific keys from within a set.

[INSERT_DIAGRAM] A diagram of a trie, showing how words like "cat", "can", and "car" are stored.

## 12. Graphs
A graph is a data structure that consists of a set of vertices (or nodes) and a set of edges that connect these vertices.

[INSERT_DIAGRAM] A diagram of a simple graph with a few vertices and edges.

### Graph Traversal
*   **Depth-First Search (DFS)**: Explores as far as possible along each branch before backtracking.
*   **Breadth-First Search (BFS)**: Explores the neighbor nodes first, before moving to the next level neighbors.

### Disjoint Set (Union-Find)
A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. A union-find algorithm is an algorithm that performs two useful operations on such a data structure:
*   **Find**: Determine which subset a particular element is in.
*   **Union**: Join two subsets into a single subset.

### Directed Acyclic Graph (DAG)
A directed acyclic graph is a directed graph with no directed cycles.

### Topological Sort
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge from vertex u to vertex v, u comes before v in the ordering.

### Minimum Spanning Tree (MST)
A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight.
*   **Kruskal's Algorithm**: A greedy algorithm that finds an MST for a weighted undirected graph.
*   **Prim's Algorithm**: A greedy algorithm that finds an MST for a weighted undirected graph.

### Shortest Path Algorithms
*   **Dijkstra's Algorithm**: Finds the shortest paths between nodes in a graph, which may represent, for example, road networks. It works for graphs with non-negative edge weights.
*   **Bellman-Ford Algorithm**: Finds the shortest paths from a single source vertex to all of the other vertices in a weighted digraph. It is slower than Dijkstra's algorithm, but more versatile, as it is capable of handling graphs in which some of the edge weights are negative numbers.

## 13. Backtracking
Backtracking is a general algorithm for finding all (or some) solutions to some computational problems, notably constraint satisfaction problems, that incrementally builds candidates to the solutions, and abandons a candidate ("backtracks") as soon as it determines that the candidate cannot possibly be completed to a valid solution.

**Common Problems:**
*   N-Queens
*   Sudoku
*   Combinations and Permutations

[INSERT_DIAGRAM] A diagram of a backtracking algorithm solving a maze. The diagram should show the algorithm exploring a path, hitting a dead end, and then backtracking to try another path.

## 14. Greedy Algorithms
A greedy algorithm is an algorithmic paradigm that follows the problem-solving heuristic of making the locally optimal choice at each stage with the hope of finding a global optimum.

**Common Problems:**
*   Coin Change problem
*   Activity Selection problem
*   Huffman Coding

**Note:** Greedy algorithms do not always yield the optimal solution, but for many problems they do.

