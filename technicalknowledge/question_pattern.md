# Coding question pattern in Java

เนื่องจากว่าตอนที่เราทำโจทย์ บางโจทย์เราสามารถที่จะ Apply pattern ต่าง ๆ ได้ ซึ่งต้องบอกว่า การรู้ pattern พวกนี้
ไม่ได้ทำให้เราแก้โจทย์ใน LeetCode ได้ทั้งหมด เพียงแต่จะทำให้เราเข้าใจ concept แต่ละโจทย์และประยุกต์ได้ง่ายมากขึ้น

## Array & HashTable

- [Two Sum](https://leetcode.com/problems/two-sum/)
- [Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)
- [Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)
- [Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
- [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)

### Tips (เคล็ดลับ)

- **Hash Table is your best friend**: เมื่อคุณต้องการค้นหาคู่ ตรวจสอบข้อมูลซ้ำ หรือนับความถี่ ตารางแฮช (หรือ `HashMap` ใน Java) มักจะเป็นโครงสร้างข้อมูลที่มีประสิทธิภาพมากที่สุด โดยให้ความซับซ้อนของเวลาเฉลี่ย O(1) สำหรับการค้นหา การแทรก และการลบข้อมูล
- **Pre-computation**: บางครั้ง คุณสามารถคำนวณค่าล่วงหน้าเพื่อเร่งการคำนวณหลัก ตัวอย่างเช่น คุณสามารถคำนวณผลรวมสะสม (prefix sums) หรือแผนผังความถี่ (frequency map)
- **Think about edge cases**: จะเกิดอะไรขึ้นถ้าอาร์เรย์ว่างเปล่า? จะเกิดอะไรขึ้นถ้ามีเพียงองค์ประกอบเดียว? จะเกิดอะไรขึ้นถ้าองค์ประกอบทั้งหมดเหมือนกัน?

## Two-Pointers

- [Move Zeroes](https://leetcode.com/problems/two-sum/)
- [Two Sum II - Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
- [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)
- [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)

### Tips (เคล็ดลับ)

- **Sorted Arrays**: เทคนิค two-pointers มีประโยชน์อย่างยิ่งสำหรับอาร์เรย์ที่เรียงลำดับแล้ว คุณสามารถมีพอยน์เตอร์หนึ่งตัวที่จุดเริ่มต้นและอีกตัวที่จุดสิ้นสุด และขยับพวกมันเข้าหากัน
- **Different Speeds**: บางครั้ง พอยน์เตอร์ทั้งสองจะเคลื่อนที่ด้วยความเร็วที่แตกต่างกัน นี่คือเทคนิค "fast and slow pointers" ซึ่งมีประโยชน์สำหรับการตรวจจับวงจร (cycle detection) หรือการค้นหากึ่งกลางของ linked list
- **Sliding Window**: พอยน์เตอร์ทั้งสองสามารถกำหนด "หน้าต่าง" ที่เลื่อนไปบนอาร์เรย์ได้ ซึ่งมีประโยชน์สำหรับปัญหาที่ถามหา subarray ที่ตรงตามเงื่อนไขบางอย่าง

## Sliding Windows

- [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
- [Fruit Into Baskets](https://leetcode.com/problems/fruit-into-baskets/)
- [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)

### Tips (เคล็ดลับ)

- **Dynamic Window Size**: ขนาดของหน้าต่างสามารถปรับเปลี่ยนได้ มันสามารถขยายหรือหดได้ขึ้นอยู่กับข้อจำกัดของปัญหา
- **Use a Hash Map**: สามารถใช้ hash map เพื่อติดตามตัวอักษรในหน้าต่างปัจจุบันและความถี่ของมัน
- **Two Pointers**: การเลื่อนหน้าต่างมักจะถูกทำโดยใช้สองพอยน์เตอร์ คือ `start` และ `end` โดย `end` จะขยายหน้าต่าง และ `start` จะหดหน้าต่าง

## String

- [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
- [Valid Anagram](https://leetcode.com/problems/valid-anagram/)
- [Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)
- [Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)
- [Group Anagrams](https://leetcode.com/problems/group-anagrams/)

### Tips (เคล็ดลับ)

- **Immutability**: ใน Java สตริงจะไม่สามารถแก้ไขได้ (immutable) ซึ่งหมายความว่าทุกครั้งที่คุณแก้ไขสตริง จะมีการสร้างอ็อบเจกต์สตริงใหม่ขึ้นมา หากคุณต้องการทำการแก้ไขมากๆ การใช้ `StringBuilder` จะมีประสิทธิภาพมากกว่า
- **Character Manipulation**: ควรรู้วิธีการทำงานกับตัวอักษร ประเภท `char` และคลาส `Character` คือเพื่อนของคุณ
- **Common Methods**: ทำความคุ้นเคยกับเมธอดทั่วไปของสตริง เช่น `substring()`, `indexOf()`, `charAt()`, `toCharArray()`, `split()` ฯลฯ

## Linked List

- [Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)
- [Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
- [Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)
- [Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)
- [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
- [LRU Cache](https://leetcode.com/problems/lru-cache/)

### Tips (เคล็ดลับ)

- **Dummy Head**: เมื่อคุณต้องการแก้ไขส่วนหัวของ linked list (เช่น ลบองค์ประกอบแรก) มักจะง่ายกว่าหากใช้ dummy head ซึ่งเป็นโหนดจำลองที่ชี้ไปยังส่วนหัวของรายการ
- **Two Pointers**: เทคนิค two-pointers เป็นที่นิยมมากในปัญหา linked list คุณสามารถใช้เพื่อหาจุดกึ่งกลางของรายการ ตรวจสอบวงจร หรือกลับด้านรายการ
- **Recursion**: ปัญหา linked list มักจะสามารถแก้ไขได้ด้วยวิธีการเรียกซ้ำ (recursion) โดย case พื้นฐานมักจะเป็นรายการว่างหรือรายการที่มีเพียงหนึ่งโหนด

## Fast & Slow Pointers

- [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
- [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)
- [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
- [Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)

### Tips (เคล็ดลับ)

- **Cycle Detection**: หากพอยน์เตอร์แบบเร็วและแบบช้ามาเจอกัน แสดงว่ามีวงจรใน linked list
- **Finding the Middle**: เมื่อพอยน์เตอร์แบบเร็วไปถึงจุดสิ้นสุดของรายการ พอยน์เตอร์แบบช้าจะอยู่ที่จุดกึ่งกลางพอดี
- **Array Problems**: เทคนิคพอยน์เตอร์แบบเร็วและแบบช้ายังสามารถใช้ในปัญหาอาร์เรย์ได้อีกด้วย เช่น การหาตัวเลขที่ซ้ำกัน

## Modified Binary Search

- [First Bad Version](https://leetcode.com/problems/first-bad-version/)
- [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
- [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

### Tips (เคล็ดลับ)

- **Search Space**: กุญแจสำคัญของ binary search คือการกำหนดขอบเขตพื้นที่ค้นหาให้ถูกต้อง พื้นที่ค้นหาควรถูกเรียงลำดับและคุณควรจะสามารถตัดครึ่งหนึ่งของพื้นที่ทิ้งได้ในแต่ละขั้นตอน
- **Variants**: มี binary search หลายรูปแบบ ตัวอย่างเช่น คุณอาจต้องหาตำแหน่งแรกหรือตำแหน่งสุดท้ายที่องค์ประกอบปรากฏ หรือหาองค์ประกอบที่เล็กที่สุดที่มากกว่าค่าที่กำหนด
- **2D Matrix**: Binary search สามารถนำไปใช้กับเมทริกซ์ 2 มิติ ที่มีการเรียงลำดับในลักษณะพิเศษได้

## Stack & Queue

- [Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
- [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
- [Find the Winner of the Circular Game](https://leetcode.com/problems/find-the-winner-of-the-circular-game)

### Tips (เคล็ดลับ)

- **LIFO vs. FIFO**: จำไว้ว่า Stack เป็นแบบเข้าหลังออกก่อน (LIFO) และ Queue เป็นแบบเข้าก่อนออกก่อน (FIFO)
- **Use Cases for Stack**: Stacks มีประโยชน์สำหรับปัญหาที่เกี่ยวข้องกับการจับคู่วงเล็บ การประเมินนิพจน์ และการ traverse tree หรือ graph (DFS)
- **Use Cases for Queue**: Queues มีประโยชน์สำหรับปัญหาที่เกี่ยวข้องกับการประมวลผลรายการตามลำดับที่เพิ่มเข้ามา และสำหรับการ traverse tree หรือ graph (BFS)

## Monotonic Stack

- [Next Greater Element I](https://leetcode.com/problems/next-greater-element-i/)
- [Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/)
- [Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
- [Online Stock Span](https://leetcode.com/problems/online-stock-span/)

### Tips (เคล็ดลับ)

- **Increasing or Decreasing**: Monotonic stack คือ stack ที่องค์ประกอบภายในเรียงลำดับจากน้อยไปมาก หรือมากไปน้อยเสมอ
- **Next Greater/Smaller Element**: Monotonic stacks มีประโยชน์มากสำหรับปัญหาที่ถามหาองค์ประกอบถัดไปที่มากกว่า หรือน้อยกว่า
- **Store Indices**: มักจะมีประโยชน์ในการเก็บ index ขององค์ประกอบใน stack แทนที่จะเก็บตัวองค์ประกอบเอง

## Backtracking

- [Subsets](https://leetcode.com/problems/subsets/)
- [Permutations](https://leetcode.com/problems/permutations/)
- [Combination Sum](https://leetcode.com/problems/combination-sum/)
- [Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)
- [Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)

### Tips (เคล็ดลับ)

- **Template**: ปัญหา backtracking มักจะสามารถแก้ไขได้ด้วย template มาตรฐาน คุณมีฟังก์ชันเรียกซ้ำ (recursive function) ที่ทำการสำรวจความเป็นไปได้ทั้งหมด
- **Pruning**: เพื่อเพิ่มประสิทธิภาพอัลกอริทึม backtracking คุณสามารถ "ตัดแต่งกิ่ง" (prune) พื้นที่ค้นหาโดยการละทิ้งเส้นทางทันทีที่คุณรู้ว่ามันไม่สามารถนำไปสู่คำตอบที่ถูกต้องได้
- **State Management**: คุณต้องจัดการสถานะของคำตอบที่กำลังสร้างอย่างระมัดระวัง ซึ่งมักเกี่ยวข้องกับการเพิ่มองค์ประกอบเข้าไปในคำตอบปัจจุบัน แล้วจึงลบออก (backtracking) เพื่อสำรวจความเป็นไปได้อื่น ๆ

## Merge Interval

- [Merge Intervals](https://leetcode.com/problems/merge-intervals/)
- [Insert Interval](https://leetcode.com/problems/insert-interval/)
- [Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)

### Tips (เคล็ดลับ)

- **Sort by Start Time**: ขั้นตอนแรกในปัญหาการรวมช่วงเวลาส่วนใหญ่ คือการเรียงลำดับช่วงเวลาตามเวลาเริ่มต้น
- **Overlapping Intervals**: ช่วงเวลาสองช่วง `[a, b]` และ `[c, d]` จะทับซ้อนกันถ้า `a <= d` และ `c <= b`
- **Merging**: หากช่วงเวลาสองช่วงทับซ้อนกัน คุณสามารถรวมพวกมันเป็นช่วงเวลาเดียวได้คือ `[min(a, c), max(b, d)]`

## Cyclic Sort

- [Missing Number](https://leetcode.com/problems/missing-number/)
- [Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
- [First Missing Positive](https://leetcode.com/problems/first-missing-positive/)

### Tips (เคล็ดลับ)

- **Range of Numbers**: Cyclic sort ใช้สำหรับปัญหาที่อินพุตเป็นอาร์เรย์ของตัวเลขในช่วงที่กำหนด (เช่น 1 ถึง n)
- **In-place**: ไอเดียคือการวางตัวเลขแต่ละตัวไว้ที่ index ที่ถูกต้องของมัน ตัวอย่างเช่น หากตัวเลขคือ 1 ถึง n ตัวเลข `i` ควรอยู่ที่ index `i - 1` ซึ่งทำได้แบบ in-place คือไม่ต้องใช้พื้นที่เพิ่มเติม
- **Find Missing/Duplicate Numbers**: หลังจากเรียงลำดับอาร์เรย์ด้วย cyclic sort แล้ว คุณสามารถวนลูปตรวจสอบเพื่อหาตัวเลขที่หายไป หรือซ้ำกันได้

## Tree - DFS

- [Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
- [Path Sum](https://leetcode.com/problems/path-sum/)
- [Merge Two Binary Trees](https://leetcode.com/problems/merge-two-binary-trees/)
- [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)
- [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)
- [Path Sum II](https://leetcode.com/problems/path-sum-ii/)
- [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

### Tips (เคล็ดลับ)

- **Recursion**: DFS บน tree นั้นทำได้โดยธรรมชาติด้วยการเรียกซ้ำ (recursion) โดย case พื้นฐานมักจะเป็น node ที่เป็น null
- **Pre-order, In-order, Post-order**: มีสามวิธีหลักในการ traverse tree ด้วย DFS: pre-order (root, left, right), in-order (left, root, right), และ post-order (left, right, root)
- **Path Problems**: DFS มีประโยชน์สำหรับปัญหาที่เกี่ยวข้องกับการค้นหาเส้นทางจาก root ไปยัง leaf หรือการหาผลรวมเส้นทางสูงสุด

## Tree - BFS

- [Minimum Depth of Binary Tree](https://leetcode.com/problems/minimum-depth-of-binary-tree/)
- [Average of Levels in Binary Tree](https://leetcode.com/problems/average-of-levels-in-binary-tree/)
- [Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)
- [Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)
- [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

### Tips (เคล็ดลับ)

- **Queue**: BFS บน tree จะถูก implement ด้วย queue คุณเพิ่ม root เข้าไปใน queue และในแต่ละขั้นตอน คุณจะ dequeue ปมออกมาและ enqueue ลูก ๆ ของมันเข้าไป
- **Level Order Traversal**: BFS ใช้สำหรับการ traverse tree แบบทีละระดับ (level by level)
- **Shortest Path**: BFS มีประโยชน์ในการค้นหาเส้นทางที่สั้นที่สุดจาก root ไปยัง node ใดๆ

## Trie

- [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)
- [Replace Words](https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/)
- [Design Add and Search Words Data Structure](https://leetcode.com/problems/design-add-and-search-words-data-structure/)
- [Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/)

### Tips (เคล็ดลับ)

- **Prefix Problems**: Tries มีประโยชน์มากสำหรับปัญหาที่เกี่ยวข้องกับคำนำหน้า (prefixes) เช่น autocomplete หรือการค้นหาคำที่มีคำนำหน้าตามที่กำหนด
- **Node Structure**: แต่ละโหนดใน trie เป็นตัวแทนของตัวอักษรหนึ่งตัว วิธีทั่วไปในการ implement โหนด trie คือการใช้ hash map หรืออาร์เรย์เพื่อเก็บลูก ๆ ของมัน
- **End of Word**: คุณต้องมีวิธีระบุการสิ้นสุดของคำใน trie ซึ่งมักทำได้ด้วย boolean flag ในโหนด

## Top K Elements

- [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
- [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)
- [K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)
- [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
- [Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/)
- [Find K Closest Elements](https://leetcode.com/problems/find-k-closest-elements/)
- [Reorganize String](https://leetcode.com/problems/reorganize-string/)

### Tips (เคล็ดลับ)

- **Heap (Priority Queue)**: วิธีที่พบบ่อยที่สุดในการแก้ปัญหา "Top K" คือการใช้ min-heap หรือ max-heap (หรือ `PriorityQueue` ใน Java)
- **Min-Heap vs. Max-Heap**: หากคุณต้องการค้นหาองค์ประกอบที่ใหญ่ที่สุด K อันดับแรก คุณสามารถใช้ min-heap ขนาด K หากคุณต้องการค้นหาองค์ประกอบที่เล็กที่สุด K อันดับแรก คุณสามารถใช้ max-heap ขนาด K
- **Quickselect**: Quickselect เป็นอีกหนึ่งอัลกอริทึมที่สามารถใช้ค้นหาองค์ประกอบที่เล็กที่สุดหรือใหญ่ที่สุดลำดับที่ K ในอาร์เรย์ที่ไม่ได้เรียงลำดับ โดยมีความซับซ้อนของเวลาเฉลี่ย O(n)

## K-way Merge

- [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
- [Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)
- [Find K Pairs with Smallest Sums](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/)
- [Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)

### Tips (เคล็ดลับ)

- **Min-Heap**: รูปแบบ K-way merge ถูกใช้เพื่อรวมรายการเรียงลำดับ K รายการ วิธีที่พบบ่อยที่สุดในการแก้ปัญหานี้คือการใช้ min-heap
- **Storing Tuples**: คุณสามารถเก็บ tuple ของ (ค่า, index ของรายการ, index ขององค์ประกอบ) ใน min-heap เพื่อติดตามว่าองค์ประกอบไหนมาจากรายการใด
- **Matrix Problems**: รูปแบบนี้ยังสามารถนำไปใช้กับปัญหาที่เกี่ยวข้องกับเมทริกซ์ที่เรียงลำดับแล้วได้อีกด้วย

## 2 Heaps

- [Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)

### Tips (เคล็ดลับ)

- **Median Problems**: รูปแบบ 2 heaps มีประโยชน์มากสำหรับปัญหาที่เกี่ยวข้องกับการค้นามัธยฐานของกระแสข้อมูลตัวเลข
- **Max-Heap and Min-Heap**: คุณใช้ max-heap เพื่อเก็บครึ่งหนึ่งที่มีค่าน้อยกว่า และ min-heap เพื่อเก็บครึ่งหนึ่งที่มีค่ามากกว่า
- **Balancing**: ฮีปทั้งสองควรมีความสมดุล เพื่อให้มีจำนวนองค์ประกอบใกล้เคียงกัน

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

### Tips (เคล็ดลับ)

- **Adjacency List vs. Adjacency Matrix**: คุณสามารถแสดงกราฟด้วย adjacency list หรือ adjacency matrix โดย adjacency list มักจะมีประสิทธิภาพมากกว่าสำหรับกราฟที่มีเส้นเชื่อน้อย (sparse) ในขณะที่ adjacency matrix เหมาะกับกราฟที่มีเส้นเชื่อมมาก (dense)
- **DFS and BFS**: ควรทำความเข้าใจทั้ง Depth-First Search (DFS) และ Breadth-First Search (BFS) สำหรับการ traverse กราฟ
- **Visited Set**: เมื่อ traverse กราฟ คุณต้องติดตาม node ที่เยี่ยมชมแล้วเพื่อป้องกันการวนลูปไม่รู้จบ

## Union-Find

- [Find if Path Exists in Graph - Union Find](https://leetcode.com/problems/find-if-path-exists-in-graph/)
- [Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
- [Number of Operations to Make Network Connected](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)

### Tips (เคล็ดลับ)

- **Disjoint Sets**: โครงสร้างข้อมูล Union-Find ใช้เพื่อติดตามชุดขององค์ประกอบที่ถูกแบ่งออกเป็นเซตย่อยที่ไม่ซ้ำซ้อนกันหลายชุด
- **`union()` and `find()`**: สองการดำเนินการหลักคือ `union()` ซึ่งรวมสองเซตย่อยเข้าด้วยกัน และ `find()` ซึ่งกำหนดว่าองค์ประกอบใดอยู่ในเซตย่อยใด
- **Path Compression and Union by Rank/Size**: เหล่านี้เป็นสองการเพิ่มประสิทธิภาพที่สามารถใช้เพื่อทำให้โครงสร้างข้อมูล Union-Find มีประสิทธิภาพมากขึ้น

## Topological Sort

- [Course Schedule](https://leetcode.com/problems/course-schedule/)
- [Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)

### Tips (เคล็ดลับ)

- **DAGs**: Topological sort ใช้สำหรับ Directed Acyclic Graphs (DAGs)
- **In-degree**: อัลกอริทึมใช้ in-degree ของแต่ละ node (จำนวนเส้นเชื่อมขาเข้า)
- **Queue**: คุณเริ่มต้นด้วย node ที่มี in-degree เป็น 0 และเพิ่มเข้าไปใน queue จากนั้นคุณประมวลผล node ใน queue และสำหรับแต่ละ node ที่ประมวลผล คุณจะลดค่า in-degree ของเพื่อนบ้านลง

## Minimum Spanning Tree

- [Min Cost to Connect All Points [Kruskal]](https://leetcode.com/problems/min-cost-to-connect-all-points/)
- [Min Cost to Connect All Points [Prim]](https://leetcode.com/problems/min-cost-to-connect-all-points/)

### Tips (เคล็ดลับ)

- **Weighted Undirected Graphs**: อัลกอริทึม MST ใช้สำหรับกราฟแบบไม่มีทิศทางที่มีน้ำหนัก
- **Kruskal's vs. Prim's**: อัลกอริทึม Kruskal's เรียงลำดับเส้นเชื่อมตามน้ำหนักและเพิ่มเข้าไปใน MST หากไม่ทำให้เกิดวงจร ส่วน Prim's เริ่มจาก node เดียวและขยาย MST โดยการเพิ่มเส้นเชื่อมที่ถูกที่สุดที่เชื่อมต่อ node ใน MST กับ node ภายนอก MST
- **Union-Find**: อัลกอริทึม Kruskal's ใช้โครงสร้างข้อมูล Union-Find เพื่อตรวจสอบวงจร

## Single-Source-Shortest Path

- [Network Delay Time [Djisktra]](https://leetcode.com/problems/network-delay-time/)
- [Network Delay Time [Bellman-ford]](https://leetcode.com/problems/network-delay-time/)

### Tips (เคล็ดลับ)

- **Dijkstra's vs. Bellman-Ford**: Dijkstra's เร็วกว่า แต่ทำงานได้กับกราฟที่มีน้ำหนักเส้นเชื่อมไม่ติดลบเท่านั้น Bellman-Ford ช้ากว่า แต่สามารถจัดการกับน้ำหนักเส้นเชื่อมที่ติดลบได้
- **Priority Queue**: Dijkstra's ใช Priority Queue เพื่อเลือก node ถัดไปที่จะเยี่ยมชมอย่างมีประสิทธิภาพ
- **Relaxation**: ทั้งสองอัลกอริทึมใช้แนวคิดของการ "ผ่อนคลาย" (relaxation) ซึ่งคุณจะอัปเดตระยะทางที่สั้นที่สุดที่คาดการณ์ไว้ไปยัง node ซ้ำ ๆ

## Dynamic Programming - 0/1 Knapsack

- [Target Sum](https://leetcode.com/problems/target-sum/)
- [Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)
- [House Robber](https://leetcode.com/problems/house-robber/)

### Tips (เคล็ดลับ)

- **Choice**: สำหรับแต่ละไอเทม คุณมีสองทางเลือก: ใส่ไว้ในกระเป๋าเป้ หรือไม่ใส่
- **DP Table**: คุณสามารถใช้ตาราง DP แบบ 2 มิติ โดย `dp[i][j]` แทนค่าสูงสุดที่คุณจะได้รับด้วยไอเทม `i` ชิ้นแรกและกระเป๋าเป้ที่มีความจุ `j`
- **Bottom-up or Top-down**: คุณสามารถแก้ปัญหา knapsack ได้ด้วยวิธี bottom-up (tabulation) หรือ top-down (memoization)

## Dynamic Programming - Unbound Knapsack

- [Coin Change](https://leetcode.com/problems/coin-change/)
- [Coin Change II](https://leetcode.com/problems/coin-change-ii/)

### Tips (เคล็ดลับ)

- **Unlimited Items**: ในปัญหา unbound knapsack คุณสามารถใช้แต่ละไอเทมได้ไม่จำกัดจำนวนครั้ง
- **1D DP Table**: คุณสามารถแก้ปัญหานี้ด้วยตาราง DP แบบ 1 มิติ โดย `dp[j]` แทนค่าสูงสุดที่คุณจะได้รับด้วยกระเป๋าเป้ที่มีความจุ `j`
- **Order of Loops**: ลำดับของลูปมีความสำคัญ ลูปนอกควรเป็นสำหรับไอเทม และลูปในควรเป็นสำหรับความจุกระเป๋าเป้

## Dynamic Programming - Fibonacci

- [Fibonacci Number](https://leetcode.com/problems/fibonacci-number/)
- [Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)

### Tips (เคล็ดลับ)

- **Overlapping Subproblems**: จำนวน Fibonacci เป็นตัวอย่างคลาสสิกของปัญหาที่มีปัญหาย่อยที่ซ้อนทับกัน (overlapping subproblems)
- **Memoization**: คุณสามารถใช้ memoization (วิธี top-down) เพื่อเก็บผลลัพธ์ของปัญหาย่อยที่ถูกแก้แล้ว
- **Tabulation**: คุณยังสามารถใช้ tabulation (วิธี bottom-up) เพื่อแก้ปัญหาแบบวนซ้ำได้ด้วย

## Dynamic Programming - Longest Palindromic Subsequence (LPS)

- [Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)
- [Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)
- [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)

### Tips (เคล็ดลับ)

- **Reverse the String**: Longest palindromic subsequence ของสตริง คือ longest common subsequence ของสตริงนั้นกับสตริงที่กลับด้านแล้ว
- **DP Table**: คุณสามารถใช้ตาราง DP แบบ 2 มิติ โดย `dp[i][j]` แทนความยาวของ longest palindromic subsequence ของ substring `s[i...j]`
- **Base Case**: base case คือ `dp[i][i] = 1` สำหรับทุก ๆ `i`

## Dynamic Programming - Longest Common Subsequence (LCS)

- [Longest Common Subsequence](https://leetcode.com/problems/longest-common-subsequence/)
- [Shortest Common Supersequence](https://leetcode.com/problems/shortest-common-supersequence/)
- [Edit Distance](https://leetcode.com/problems/edit-distance/)
- [Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)

### Tips (เคล็ดลับ)

- **2D DP Table**: คุณสามารถใช้ตาราง DP แบบ 2 มิติ โดย `dp[i][j]` แทนความยาวของ longest common subsequence ของ `i` ตัวอักษรแรกของสตริง `s1` และ `j` ตัวอักษรแรกของสตริง `s2`
- **Recurrence Relation**: ถ้า `s1[i] == s2[j]` แล้ว `dp[i][j] = 1 + dp[i-1][j-1]` มิฉะนั้น `dp[i][j] = max(dp[i-1][j], dp[i][j-1])`
- **Variations**: มีรูปแบบที่หลากหลายของปัญหา LCS เช่น การหา shortest common supersequence หรือ edit distance ระหว่างสองสตริง

## Dynamic Programming - General

- [Unique Paths](https://leetcode.com/problems/unique-paths/)
- [Perfect Squares](https://leetcode.com/problems/perfect-squares/)
- [Triangle](https://leetcode.com/problems/triangle/)
- [Word Break](https://leetcode.com/problems/word-break/)
- [Word Break II](https://leetcode.com/problems/word-break-ii/)
- [Concatenated Words](https://leetcode.com/problems/concatenated-words/)
- [Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)

### Tips (เคล็ดลับ)

- **Identify the Subproblem**: กุญแจสำคัญในการแก้ปัญหา DP คือการระบุปัญหาย่อยและความสัมพันธ์เวียนเกิด (recurrence relation)
- **Memoization vs. Tabulation**: ตัดสินใจว่าจะใช้วิธี top-down (memoization) หรือ bottom-up (tabulation) โดย memoization มักจะเข้าใจง่ายกว่า แต่ tabulation อาจมีประสิทธิภาพมากกว่า
- **State Transition**: คิดถึงวิธีการเปลี่ยนสถานะจากจุดหนึ่งไปยังอีกจุดหนึ่ง

## Bitwise

- [Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)
- [Hamming Distance](https://leetcode.com/problems/hamming-distance/)
- [Counting Bits](https://leetcode.com/problems/counting-bits/)
- [Total Hamming Distance](https://leetcode.com/problems/total-hamming-distance/)

### Tips (เคล็ดลับ)

- **Know the Operators**: ทำความคุ้นเคยกับตัวดำเนินการ bitwise: `&` (AND), `|` (OR), `^` (XOR), `~` (NOT), `<<` (left shift), และ `>>` (right shift)
- **Common Tricks**: มีเทคนิค bitwise ทั่วไปหลายอย่าง เช่น การตรวจสอบว่าตัวเลขเป็นเลขยกกำลัง 2 หรือไม่ (`n & (n - 1) == 0`) หรือการสลับสองตัวเลขโดยไม่ใช้ตัวแปรชั่วคราว (`a ^= b; b ^= a; a ^= b;`)
- **Masks**: คุณสามารถใช้ mask เพื่อตั้งค่า ล้าง หรือสลับบิตที่ระบุได้
