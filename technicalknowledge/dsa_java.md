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
Big-O notation is used to describe the performance or complexity of an algorithm. It tells you how the runtime of an algorithm grows as the input size grows. (Big-O notation ใช้เพื่ออธิบายประสิทธิภาพหรือความซับซ้อนของอัลกอริทึม มันบอกคุณว่าเวลาในการทำงานของอัลกอริทึมเติบโตขึ้นอย่างไรเมื่อขนาดของอินพุตเพิ่มขึ้น)

*   **O(1) - Constant Time**: The runtime is constant, regardless of the input size. (เวลาในการทำงานคงที่ โดยไม่คำนึงถึงขนาดของอินพุต)
    *   Example: Accessing an element in an array by its index.
*   **O(log n) - Logarithmic Time**: The runtime grows logarithmically with the input size. (เวลาในการทำงานเติบโตแบบลอการิทึมตามขนาดของอินพุต)
    *   Example: Binary search in a sorted array.
*   **O(n) - Linear Time**: The runtime grows linearly with the input size. (เวลาในการทำงานเติบโตเชิงเส้นตามขนาดของอินพุต)
    *   Example: Iterating through an array.
*   **O(n log n) - Log-Linear Time**: The runtime grows n times log n. (เวลาในการทำงานเติบโต n เท่าของ log n)
    *   Example: Efficient sorting algorithms like Merge Sort and Quick Sort.
*   **O(n^2) - Quadratic Time**: The runtime grows quadratically with the input size. (เวลาในการทำงานเติบโตแบบยกกำลังสองตามขนาดของอินพุต)
    *   Example: Nested loops, Bubble Sort.
*   **O(2^n) - Exponential Time**: The runtime doubles with each addition to the input data set. (เวลาในการทำงานเพิ่มขึ้นสองเท่าทุกครั้งที่เพิ่มข้อมูลในชุดข้อมูล)
    *   Example: Recursive calculation of Fibonacci numbers.
*   **O(n!) - Factorial Time**: The runtime grows factorially with the input size. (เวลาในการทำงานเติบโตแบบแฟกทอเรียลตามขนาดของอินพุต)
    *   Example: Traveling Salesman Problem.

[INSERT_IMAGE] A graph showing the growth rates of different Big-O complexities. The x-axis represents the input size, and the y-axis represents the number of operations.

## 2. Bit Manipulations
Bit manipulation is the act of algorithmically manipulating bits or other pieces of data shorter than a word. (การจัดการบิตคือการจัดการบิตหรือข้อมูลอื่น ๆ ที่สั้นกว่าหนึ่งคำด้วยอัลกอริทึม)

*   **AND (&)**: Returns 1 if both bits are 1, otherwise 0. (คืนค่า 1 ถ้าทั้งสองบิตเป็น 1 มิฉะนั้นเป็น 0)
*   **OR (|)**: Returns 1 if at least one of the bits is 1, otherwise 0. (คืนค่า 1 ถ้ามีอย่างน้อยหนึ่งบิตเป็น 1 มิฉะนั้นเป็น 0)
*   **XOR (^)**: Returns 1 if the bits are different, otherwise 0. (คืนค่า 1 ถ้าบิตต่างกัน มิฉะนั้นเป็น 0)
*   **NOT (~)**: Inverts the bits. (กลับบิต)
*   **Left Shift (<<)**: Shifts the bits to the left, filling the rightmost bits with 0s. Equivalent to multiplying by 2. (เลื่อนบิตไปทางซ้าย โดยเติม 0 ที่บิตขวาสุด เทียบเท่ากับการคูณด้วย 2)
*   **Right Shift (>>)**: Shifts the bits to the right. For positive numbers, the leftmost bits are filled with 0s. For negative numbers, the behavior depends on the language (arithmetic vs. logical shift). (เลื่อนบิตไปทางขวา สำหรับจำนวนบวก บิตซ้ายสุดจะถูกเติมด้วย 0 สำหรับจำนวนลบ พฤติกรรมจะขึ้นอยู่กับภาษา (การเลื่อนแบบเลขคณิตกับการเลื่อนแบบตรรกะ))

**Common Use Cases:**
*   Checking if a number is even or odd: `(n & 1) == 0` for even, `(n & 1) == 1` for odd.
*   Setting a bit: `n | (1 << k)` sets the k-th bit of n.
*   Clearing a bit: `n & ~(1 << k)` clears the k-th bit of n.
*   Toggling a bit: `n ^ (1 << k)` toggles the k-th bit of n.

```java
public class BitManipulationExample {
    public static void main(String[] args) {
        int n = 10; // 1010 in binary

        // Check if even or odd
        if ((n & 1) == 0) {
            System.out.println(n + " is even.");
        } else {
            System.out.println(n + " is odd.");
        }

        // Set the 2nd bit (0-indexed)
        int numberWithBitSet = n | (1 << 2); // 1010 | 0100 = 1110 (14)
        System.out.println("Setting the 2nd bit of " + n + ": " + numberWithBitSet);

        // Clear the 3rd bit
        int numberWithBitCleared = n & ~(1 << 3); // 1010 & ~(1000) = 1010 & 0111 = 0010 (2)
        System.out.println("Clearing the 3rd bit of " + n + ": " + numberWithBitCleared);

        // Toggle the 1st bit
        int numberWithBitToggled = n ^ (1 << 1); // 1010 ^ 0010 = 1000 (8)
        System.out.println("Toggling the 1st bit of " + n + ": " + numberWithBitToggled);
    }
}
```

## 3. Pointers and References in Java
Java does not have explicit pointers like C or C++. Instead, it uses references. (Java ไม่มีพอยน์เตอร์ที่ชัดเจนเหมือนใน C หรือ C++ แต่จะใช้การอ้างอิงแทน)

*   **Primitive Types**: `int`, `char`, `boolean`, etc., are passed by value. When you pass a primitive variable to a method, a copy of the variable is made. (ประเภทข้อมูลพื้นฐาน: `int`, `char`, `boolean` ฯลฯ จะถูกส่งผ่านค่า เมื่อคุณส่งตัวแปรประเภทข้อมูลพื้นฐานไปยังเมธอด จะมีการสร้างสำเนาของตัวแปรขึ้น)
*   **Object Types**: All objects in Java are accessed through references. When you pass an object to a method, the reference to the object is passed by value. This means the method gets a copy of the reference, but both the original reference and the copy point to the same object in memory. Therefore, changes made to the object's state within the method will be reflected outside the method. (ประเภทอ็อบเจกต์: อ็อบเจกต์ทั้งหมดใน Java จะถูกเข้าถึงผ่านการอ้างอิง เมื่อคุณส่งอ็อบเจกต์ไปยังเมธอด การอ้างอิงไปยังอ็อบเจกต์จะถูกส่งผ่านค่า ซึ่งหมายความว่าเมธอดจะได้รับสำเนาของการอ้างอิง แต่ทั้งการอ้างอิงดั้งเดิมและสำเนาจะชี้ไปที่อ็อบเจกต์เดียวกันในหน่วยความจำ ดังนั้น การเปลี่ยนแปลงสถานะของอ็อบเจกต์ภายในเมธอดจะส่งผลต่อนอกเมธอดด้วย)

```java
public class PassByValueVsReference {

    public static void main(String[] args) {
        // Pass-by-value for primitive types
        int x = 10;
        System.out.println("Before calling modifyPrimitive: " + x);
        modifyPrimitive(x);
        System.out.println("After calling modifyPrimitive: " + x);

        System.out.println("--------------------");

        // Pass-by-reference for object types
        MyObject obj = new MyObject(20);
        System.out.println("Before calling modifyObject: " + obj.value);
        modifyObject(obj);
        System.out.println("After calling modifyObject: " + obj.value);
    }

    public static void modifyPrimitive(int value) {
        value = 100;
        System.out.println("Inside modifyPrimitive: " + value);
    }

    public static void modifyObject(MyObject myObj) {
        myObj.value = 200;
        System.out.println("Inside modifyObject: " + myObj.value);
    }
}

class MyObject {
    public int value;

    public MyObject(int value) {
        this.value = value;
    }
}
```

## 4. Linked Lists
A linked list is a linear data structure where elements are not stored at contiguous memory locations. The elements in a linked list are linked using pointers. (Linked list เป็นโครงสร้างข้อมูลเชิงเส้นที่องค์ประกอบไม่ได้ถูกจัดเก็บไว้ในตำแหน่งหน่วยความจำที่ต่อเนื่องกัน องค์ประกอบใน linked list จะถูกเชื่อมโยงโดยใช้พอยน์เตอร์)

[INSERT_DIAGRAM] A diagram of a simple linked list with 3 nodes. Each node contains a data field and a `next` pointer to the next node. The last node's `next` pointer is null.

### Singly Linked List
Each node in a singly linked list contains a data field and a `next` field, which points to the next node in the sequence. (แต่ละโหนดใน singly linked list จะมีฟิลด์ข้อมูลและฟิลด์ `next` ซึ่งชี้ไปยังโหนดถัดไปในลำดับ)

```java
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    Node head;

    public void append(int data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
```

**Complexity:**
*   Access: O(n)
*   Search: O(n)
*   Insertion: O(1) (if at the beginning) / O(n) (if at the end or in the middle)
*   Deletion: O(1) (if at the beginning) / O(n) (if at the end or in the middle)

### Doubly Linked List
Each node in a doubly linked list contains a data field, a `next` field, and a `prev` field, which points to the previous node in the sequence. (แต่ละโหนดใน doubly linked list จะมีฟิลด์ข้อมูล, ฟิลด์ `next`, และฟิลด์ `prev` ซึ่งชี้ไปยังโหนดก่อนหน้าในลำดับ)

**Complexity:**
*   Access: O(n)
*   Search: O(n)
*   Insertion: O(1) (if at the beginning or end) / O(n) (if in the middle)
*   Deletion: O(1) (if at the beginning or end) / O(n) (if in the middle)

### Circular Linked List
In a circular linked list, the last node points to the first node, forming a circle. This can be a singly or doubly circular linked list. (ใน circular linked list โหนดสุดท้ายจะชี้ไปที่โหนดแรก ทำให้เกิดเป็นวงกลม ซึ่งอาจเป็น singly or doubly circular linked list)

### Fast & Slow Pointers
This is a technique used in linked lists and arrays to solve problems like cycle detection, finding the middle of a linked list, etc. Two pointers, a fast one and a slow one, are used. The fast pointer moves two steps at a time, while the slow pointer moves one step at a time. (นี่เป็นเทคนิคที่ใช้ใน linked lists และ arrays เพื่อแก้ปัญหาต่างๆ เช่น การตรวจจับวงจร, การหาโหนดกลางของ linked list ฯลฯ โดยจะใช้พอยน์เตอร์สองตัว คือพอยน์เตอร์เร็วและพอยน์เตอร์ช้า พอยน์เตอร์เร็วจะเคลื่อนที่ทีละสองขั้นตอน ในขณะที่พอยน์เตอร์ช้าจะเคลื่อนที่ทีละหนึ่งขั้นตอน)

## 5. Stacks
A stack is a linear data structure that follows the Last-In, First-Out (LIFO) principle. (Stack เป็นโครงสร้างข้อมูลเชิงเส้นที่ทำงานตามหลักการ Last-In, First-Out (LIFO))

[INSERT_DIAGRAM] A diagram of a stack, showing the push and pop operations.

**Common Operations:**
*   `push(element)`: Adds an element to the top of the stack. (เพิ่มองค์ประกอบที่ด้านบนของ stack)
*   `pop()`: Removes and returns the top element of the stack. (ลบและคืนค่าองค์ประกอบบนสุดของ stack)
*   `peek()`: Returns the top element of the stack without removing it. (คืนค่าองค์ประกอบบนสุดของ stack โดยไม่ลบออก)
*   `isEmpty()`: Checks if the stack is empty. (ตรวจสอบว่า stack ว่างเปล่าหรือไม่)

**Implementation:**
*   Using an array or a linked list. (สามารถ υλο hóa โดยใช้อาร์เรย์หรือ linked list)

```java
import java.util.EmptyStackException;

class ArrayStack {
    private int[] arr;
    private int top;

    public ArrayStack(int capacity) {
        arr = new int[capacity];
        top = -1;
    }

    public void push(int element) {
        if (top == arr.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        arr[++top] = element;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
```

**Complexity (for both array and linked list implementations):**
*   Push: O(1)
*   Pop: O(1)
*   Peek: O(1)

## 6. Queues

A queue is a linear data structure that follows the First-In, First-Out (FIFO) principle. (Queue เป็นโครงสร้างข้อมูลเชิงเส้นที่ทำงานตามหลักการ First-In, First-Out (FIFO))



[INSERT_DIAGRAM] A diagram of a queue, showing the enqueue and dequeue operations.



**Common Operations:**

*   `enqueue(element)`: Adds an element to the rear of the queue. (เพิ่มองค์ประกอบที่ด้านหลังของคิว)

*   `dequeue()`: Removes and returns the front element of the queue. (ลบและคืนค่าองค์ประกอบด้านหน้าของคิว)

*   `peek()`: Returns the front element of the queue without removing it. (คืนค่าองค์ประกอบด้านหน้าของคิวโดยไม่ลบออก)

*   `isEmpty()`: Checks if the queue is empty. (ตรวจสอบว่าคิวว่างเปล่าหรือไม่)



**Implementation:**

*   Using an array (with a circular buffer) or a linked list. (สามารถ υλο hóa โดยใช้อาร์เรย์ (พร้อมบัฟเฟอร์แบบวงกลม) หรือ linked list)



```java

import java.util.NoSuchElementException;



class LinkedListQueue {

    private Node front, rear;



    private class Node {

        int data;

        Node next;



        public Node(int data) {

            this.data = data;

            this.next = null;

        }

    }



    public void enqueue(int element) {

        Node newNode = new Node(element);

        if (isEmpty()) {

            front = rear = newNode;

        } else {

            rear.next = newNode;

            rear = newNode;

        }

    }



    public int dequeue() {

        if (isEmpty()) {

            throw new NoSuchElementException("Queue is empty");

        }

        int data = front.data;

        front = front.next;

        if (front == null) {

            rear = null;

        }

        return data;

    }



    public int peek() {

        if (isEmpty()) {

            throw new NoSuchElementException("Queue is empty");

        }

        return front.data;

    }



    public boolean isEmpty() {

        return front == null;

    }

}

```



**Complexity (for both array and linked list implementations):**

*   Enqueue: O(1)

*   Dequeue: O(1)

*   Peek: O(1)



## 7. Searching

### Linear Search

Linear search is a simple search algorithm that sequentially checks each element of a list until a match is found or the whole list has been searched. (Linear search เป็นอัลกอริทึมการค้นหาอย่างง่ายที่ตรวจสอบแต่ละองค์ประกอบของรายการตามลำดับจนกว่าจะพบรายการที่ตรงกันหรือค้นหารายการทั้งหมดแล้ว)



```java

public class LinearSearch {

    public int search(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {

                return i; // Return the index of the target

            }

        }

        return -1; // Target not found

    }

}

```



**Complexity:**

*   Best Case: O(1) (the first element is the match)

*   Worst Case: O(n)

*   Average Case: O(n)



### Binary Search

Binary search is an efficient algorithm for finding an item from a **sorted** list of items. It works by repeatedly dividing in half the portion of the list that could contain the item, until you've narrowed down the possible locations to just one. (Binary search เป็นอัลกอริทึมที่มีประสิทธิภาพในการค้นหารายการจากรายการที่ **เรียงลำดับแล้ว** โดยจะทำงานโดยการแบ่งครึ่งส่วนของรายการที่อาจมีรายการนั้นซ้ำ ๆ จนกว่าคุณจะจำกัดตำแหน่งที่เป็นไปได้ให้เหลือเพียงตำแหน่งเดียว)



```java

public class BinarySearch {

    public int search(int[] arr, int target) {

        int left = 0;

        int right = arr.length - 1;



        while (left <= right) {

            int mid = left + (right - left) / 2;



            if (arr[mid] == target) {

                return mid;

            }



            if (arr[mid] < target) {

                left = mid + 1;

            } else {

                right = mid - 1;

            }

        }

        return -1; // Target not found

    }

}

```



**Complexity:**

*   Best Case: O(1)

*   Worst Case: O(log n)

*   Average Case: O(log n)



## 8. Hash Tables

A hash table is a data structure that implements an associative array abstract data type, a structure that can map keys to values. A hash table uses a hash function to compute an index into an array of buckets or slots, from which the desired value can be found. (Hash table เป็นโครงสร้างข้อมูลที่ υλο hóa ชนิดข้อมูลนามธรรมของอาร์เรย์ที่เชื่อมโยง ซึ่งเป็นโครงสร้างที่สามารถจับคู่คีย์กับค่าได้ Hash table ใช้ฟังก์ชันแฮชเพื่อคำนวณดัชนีลงในอาร์เรย์ของบักเก็ตหรือสล็อต ซึ่งสามารถค้นหาค่าที่ต้องการได้)



[INSERT_DIAGRAM] A diagram of a hash table. It should show keys being passed through a hash function to generate an index. The diagram should also illustrate how collisions are handled, for example, by using a linked list at each index.



**Collision Handling:**

*   **Separate Chaining**: Each bucket is independent, and has some sort of list of entries with the same index. (แต่ละบักเก็ตเป็นอิสระต่อกัน และมีรายการของรายการที่มีดัชนีเดียวกัน)

*   **Open Addressing**: All entry records are stored in the bucket array itself. When a new entry has to be inserted, the buckets are examined, starting with the hashed-to slot and proceeding in some probe sequence, until an unoccupied slot is found. (เรกคอร์ดรายการทั้งหมดจะถูกเก็บไว้ในอาร์เรย์บักเก็ตเอง เมื่อต้องแทรกรายการใหม่ บักเก็ตจะถูกตรวจสอบ โดยเริ่มจากสล็อตที่แฮชไปและดำเนินการต่อไปในลำดับการตรวจสอบบางอย่าง จนกว่าจะพบสล็อตที่ว่าง)



```java

import java.util.HashMap;

import java.util.Map;



public class HashTableExample {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();



        // Add key-value pairs

        map.put("apple", 1);

        map.put("banana", 2);

        map.put("cherry", 3);



        // Access a value

        System.out.println("The value for 'banana' is: " + map.get("banana"));



        // Check if a key exists

        if (map.containsKey("apple")) {

            System.out.println("The map contains the key 'apple'.");

        }



        // Iterate over the map

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());

        }

    }

}

```



**Complexity:**

*   Average Case (for search, insert, delete): O(1)

*   Worst Case (with collisions): O(n)



## 9. Recursion
Recursion is a method of solving a problem where the solution depends on solutions to smaller instances of the same problem. (Recursion เป็นวิธีการแก้ปัญหาที่วิธีแก้ปัญหาขึ้นอยู่กับวิธีแก้ปัญหาของอินสแตนซ์ที่เล็กกว่าของปัญหาเดียวกัน)

**Key Concepts:**
*   **Base Case**: The condition under which the recursion stops. (เงื่อนไขที่การเรียกซ้ำจะหยุดลง)
*   **Recursive Step**: The part of the function that calls itself. (ส่วนของฟังก์ชันที่เรียกตัวเอง)

**Example: Factorial**
```java
public class RecursionExample {
    public int factorial(int n) {
        // Base case
        if (n == 0) {
            return 1;
        }
        // Recursive step
        return n * factorial(n - 1);
    }
}
```

**Stack Overflow:**
If the base case is not reached or the recursion is too deep, it can lead to a stack overflow error. (หากไม่ถึงกรณีพื้นฐานหรือการเรียกซ้ำลึกเกินไป อาจทำให้เกิดข้อผิดพลาด stack overflow)

## 10. Sorting
### Insertion Sort
Insertion sort is a simple sorting algorithm that builds the final sorted array one item at a time. It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort. (Insertion sort เป็นอัลกอริทึมการเรียงลำดับอย่างง่ายที่สร้างอาร์เรย์ที่เรียงลำดับแล้วทีละรายการ มันมีประสิทธิภาพน้อยกว่ามากในรายการขนาดใหญ่เมื่อเทียบกับอัลกอริทึมขั้นสูงเช่น quicksort, heapsort หรือ merge sort)

```java
public class InsertionSort {
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
```

**Complexity:**
*   Best Case: O(n) (if the array is already sorted)
*   Worst Case: O(n^2)
*   Average Case: O(n^2)

### Selection Sort
Selection sort is an in-place comparison sorting algorithm. It has an O(n^2) time complexity, which makes it inefficient on large lists, and generally performs worse than the similar insertion sort. (Selection sort เป็นอัลกอริทึมการเรียงลำดับแบบเปรียบเทียบในพื้นที่ มีความซับซ้อนด้านเวลา O(n^2) ซึ่งทำให้ไม่มีประสิทธิภาพในรายการขนาดใหญ่ และโดยทั่วไปแล้วจะมีประสิทธิภาพต่ำกว่า insertion sort ที่คล้ายกัน)

```java
public class SelectionSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
```

**Complexity:**
*   Best Case: O(n^2)
*   Worst Case: O(n^2)
*   Average Case: O(n^2)

### Bubble Sort
Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent elements and swaps them if they are in the wrong order. (Bubble sort เป็นอัลกอริทึมการเรียงลำดับอย่างง่ายที่วนซ้ำผ่านรายการ เปรียบเทียบองค์ประกอบที่อยู่ติดกันและสลับตำแหน่งหากเรียงลำดับผิด)

```java
public class BubbleSort {
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
```

**Complexity:**
*   Best Case: O(n) (if the array is already sorted)
*   Worst Case: O(n^2)
*   Average Case: O(n^2)

### Quick Sort
Quicksort is an efficient, in-place sorting algorithm. It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays, according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively. (Quicksort เป็นอัลกอริทึมการเรียงลำดับในพื้นที่ที่มีประสิทธิภาพ ทำงานโดยการเลือกองค์ประกอบ 'pivot' จากอาร์เรย์และแบ่งองค์ประกอบอื่น ๆ ออกเป็นสองอาร์เรย์ย่อย ตามว่าน้อยกว่าหรือมากกว่า pivot จากนั้นอาร์เรย์ย่อยจะถูกเรียงลำดับแบบเรียกซ้ำ)

```java
public class QuickSort {
    public void sort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            sort(arr, begin, partitionIndex - 1);
            sort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i + 1];
        arr[i + 1] = arr[end];
        arr[end] = swapTemp;

        return i + 1;
    }
}
```

**Complexity:**
*   Best Case: O(n log n)
*   Worst Case: O(n^2) (if the pivot is always the smallest or largest element)
*   Average Case: O(n log n)

### Merge Sort
Merge sort is an efficient, stable, comparison-based sorting algorithm. Most implementations produce a stable sort, which means that the order of equal elements is the same in the input and output. (Merge sort เป็นอัลกอริทึมการเรียงลำดับแบบเปรียบเทียบที่มีประสิทธิภาพและเสถียร การ υλο hóa ส่วนใหญ่จะให้การเรียงลำดับที่เสถียร ซึ่งหมายความว่าลำดับขององค์ประกอบที่เท่ากันจะเหมือนกันในอินพุตและเอาต์พุต)

```java
public class MergeSort {
    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }
}
```

**Complexity:**
*   Best Case: O(n log n)
*   Worst Case: O(n log n)
*   Average Case: O(n log n)

### Counting Sort
Counting sort is a sorting algorithm that sorts the elements of an array by counting the number of occurrences of each unique element in the array. It is only efficient if the range of input data is not significantly greater than the number of objects to be sorted. (Counting sort เป็นอัลกอริทึมการเรียงลำดับที่เรียงลำดับองค์ประกอบของอาร์เรย์โดยการนับจำนวนการปรากฏของแต่ละองค์ประกอบที่ไม่ซ้ำกันในอาร์เรย์ จะมีประสิทธิภาพก็ต่อเมื่อช่วงของข้อมูลอินพุตไม่มากกว่าจำนวนอ็อบเจกต์ที่จะเรียงลำดับอย่างมีนัยสำคัญ)

```java
public class CountingSort {
    void sort(int arr[]) {
        int n = arr.length;

        // The output array that will have sorted arr
        int output[] = new int[n];

        // Create a count array to store count of individual
        // characters and initialize count array as 0
        int count[] = new int[256];
        for (int i = 0; i < 256; ++i)
            count[i] = 0;

        // store count of each character
        for (int i = 0; i < n; ++i)
            ++count[arr[i]];

        // Change count[i] so that count[i] now contains actual
        // position of this character in output array
        for (int i = 1; i <= 255; ++i)
            count[i] += count[i - 1];

        // Build the output character array
        // To make it stable we are operating in reverse order.
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            --count[arr[i]];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            arr[i] = output[i];
    }
}
```

**Complexity:**
*   Best Case: O(n + k) (where k is the range of the input data)
*   Worst Case: O(n + k)
*   Average Case: O(n + k)

## 11. Trees
A tree is a hierarchical data structure that consists of nodes connected by edges. (Tree เป็นโครงสร้างข้อมูลแบบลำดับชั้นที่ประกอบด้วยโหนดที่เชื่อมต่อกันด้วยขอบ)

[INSERT_DIAGRAM] A diagram of a generic tree, showing the root, parent, child, and leaf nodes.

### Tree Traversal
*   **In-order Traversal**: Left, Root, Right. (ซ้าย, ราก, ขวา)
*   **Pre-order Traversal**: Root, Left, Right. (ราก, ซ้าย, ขวา)
*   **Post-order Traversal**: Left, Right, Root. (ซ้าย, ขวา, ราก)

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class TreeTraversal {
    // In-order traversal
    public void inOrder(TreeNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.val + " ");
            inOrder(node.right);
        }
    }

    // Pre-order traversal
    public void preOrder(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Post-order traversal
    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.val + " ");
        }
    }
}
```

### Binary Search Tree (BST)
A binary search tree is a binary tree in which for each node, all elements in the left subtree are less than the node, and all elements in the right subtree are greater than the node. (Binary search tree เป็น binary tree ที่สำหรับแต่ละโหนด องค์ประกอบทั้งหมดในแผนผังย่อยด้านซ้ายจะน้อยกว่าโหนด และองค์ประกอบทั้งหมดในแผนผังย่อยด้านขวาจะมากกว่าโหนด)

```java
public class BST {
    TreeNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    private TreeNode insertRecursive(TreeNode current, int value) {
        if (current == null) {
            return new TreeNode(value);
        }

        if (value < current.val) {
            current.left = insertRecursive(current.left, value);
        } else if (value > current.val) {
            current.right = insertRecursive(current.right, value);
        }

        return current;
    }
}
```

**Complexity:**
*   Average Case (for search, insert, delete): O(log n)
*   Worst Case (if the tree is unbalanced): O(n)

### Heap
A heap is a specialized tree-based data structure that satisfies the heap property: if P is a parent node of C, then the key (the value) of P is either greater than or equal to (in a max heap) or less than or equal to (in a min heap) the key of C. (Heap เป็นโครงสร้างข้อมูลแบบต้นไม้พิเศษที่สอดคล้องกับคุณสมบัติของฮีป: หาก P เป็นโหนดพาเรนต์ของ C ดังนั้นคีย์ (ค่า) ของ P จะมากกว่าหรือเท่ากับ (ใน max heap) หรือน้อยกว่าหรือเท่ากับ (ใน min heap) คีย์ของ C)

**Complexity:**
*   Insertion: O(log n)
*   Deletion of max/min: O(log n)
*   Peek: O(1)

### Trie
A trie, also called digital tree or prefix tree, is a type of search tree, a tree data structure used for locating specific keys from within a set. (Trie หรือที่เรียกว่า digital tree หรือ prefix tree เป็นประเภทของ search tree ซึ่งเป็นโครงสร้างข้อมูลแบบต้นไม้ที่ใช้สำหรับค้นหาคีย์เฉพาะจากภายในชุด)

[INSERT_DIAGRAM] A diagram of a trie, showing how words like "cat", "can", and "car" are stored.

## 12. Graphs
A graph is a data structure that consists of a set of vertices (or nodes) and a set of edges that connect these vertices. (กราฟเป็นโครงสร้างข้อมูลที่ประกอบด้วยชุดของจุดยอด (หรือโหนด) และชุดของขอบที่เชื่อมต่อจุดยอดเหล่านี้)

[INSERT_DIAGRAM] A diagram of a simple graph with a few vertices and edges.

### Graph Traversal
*   **Depth-First Search (DFS)**: Explores as far as possible along each branch before backtracking. (สำรวจไปตามแต่ละสาขาให้ไกลที่สุดเท่าที่จะทำได้ก่อนที่จะย้อนกลับ)
*   **Breadth-First Search (BFS)**: Explores the neighbor nodes first, before moving to the next level neighbors. (สำรวจโหนดเพื่อนบ้านก่อน จากนั้นจึงย้ายไปยังโหนดเพื่อนบ้านระดับถัดไป)

```java
import java.util.*;

class Graph {
    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFSUtil(v, visited);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
```

### Disjoint Set (Union-Find)
A disjoint-set data structure is a data structure that keeps track of a set of elements partitioned into a number of disjoint (non-overlapping) subsets. A union-find algorithm is an algorithm that performs two useful operations on such a data structure:
*   **Find**: Determine which subset a particular element is in. (กำหนดว่าองค์ประกอบใดอยู่ในเซตย่อยใด)
*   **Union**: Join two subsets into a single subset. (รวมสองเซตย่อยเป็นเซตย่อยเดียว)

### Directed Acyclic Graph (DAG)
A directed acyclic graph is a directed graph with no directed cycles. (กราฟแบบมีทิศทางที่ไม่มีวงจรแบบมีทิศทาง)

### Topological Sort
Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge from vertex u to vertex v, u comes before v in the ordering. (การเรียงลำดับเชิงทอพอโลยีสำหรับกราฟแบบมีทิศทางที่ไม่มีวงจร (DAG) คือการเรียงลำดับเชิงเส้นของจุดยอดโดยที่สำหรับทุกขอบแบบมีทิศทางจากจุดยอด u ไปยังจุดยอด v, u จะมาก่อน v ในการเรียงลำดับ)

### Minimum Spanning Tree (MST)
A minimum spanning tree (MST) or minimum weight spanning tree is a subset of the edges of a connected, edge-weighted undirected graph that connects all the vertices together, without any cycles and with the minimum possible total edge weight. (Minimum spanning tree (MST) หรือ minimum weight spanning tree เป็นเซตย่อยของขอบของกราฟที่ไม่มีทิศทางที่มีน้ำหนักและเชื่อมต่อกัน ซึ่งเชื่อมต่อจุดยอดทั้งหมดเข้าด้วยกัน โดยไม่มีวงจรและมีน้ำหนักขอบรวมน้อยที่สุดเท่าที่จะเป็นไปได้)
*   **Kruskal's Algorithm**: A greedy algorithm that finds an MST for a weighted undirected graph. (อัลกอริทึมแบบละโมบที่ค้นหา MST สำหรับกราฟที่ไม่มีทิศทางที่มีน้ำหนัก)
*   **Prim's Algorithm**: A greedy algorithm that finds an MST for a weighted undirected graph. (อัลกอริทึมแบบละโมบที่ค้นหา MST สำหรับกราฟที่ไม่มีทิศทางที่มีน้ำหนัก)

### Shortest Path Algorithms
*   **Dijkstra's Algorithm**: Finds the shortest paths between nodes in a graph, which may represent, for example, road networks. It works for graphs with non-negative edge weights. (ค้นหาเส้นทางที่สั้นที่สุดระหว่างโหนดในกราฟ ซึ่งอาจเป็นตัวแทนของเครือข่ายถนน เป็นต้น ทำงานได้กับกราฟที่มีน้ำหนักขอบไม่เป็นลบ)
*   **Bellman-Ford Algorithm**: Finds the shortest paths from a single source vertex to all of the other vertices in a weighted digraph. It is slower than Dijkstra's algorithm, but more versatile, as it is capable of handling graphs in which some of the edge weights are negative numbers. (ค้นหาเส้นทางที่สั้นที่สุดจากจุดยอดต้นทางเดียวไปยังจุดยอดอื่น ๆ ทั้งหมดในไดกราฟที่มีน้ำหนัก ช้ากว่าอัลกอริทึมของ Dijkstra แต่มีความหลากหลายมากกว่า เนื่องจากสามารถจัดการกับกราฟที่น้ำหนักขอบบางส่วนเป็นจำนวนลบได้)

## 13. Backtracking
Backtracking is a general algorithm for finding all (or some) solutions to some computational problems, notably constraint satisfaction problems, that incrementally builds candidates to the solutions, and abandons a candidate ("backtracks") as soon as it determines that the candidate cannot possibly be completed to a valid solution. (Backtracking เป็นอัลกอริทึมทั่วไปสำหรับการค้นหาคำตอบทั้งหมด (หรือบางส่วน) สำหรับปัญหาเชิงคำนวณบางอย่าง โดยเฉพาะอย่างยิ่งปัญหาความพึงพอใจในข้อจำกัด ซึ่งจะสร้างผู้สมัครสำหรับคำตอบเพิ่มขึ้นเรื่อย ๆ และละทิ้งผู้สมัคร ("ย้อนกลับ") ทันทีที่พิจารณาแล้วว่าผู้สมัครไม่สามารถทำให้สมบูรณ์เป็นคำตอบที่ถูกต้องได้)

**Common Problems:**
*   N-Queens
*   Sudoku
*   Combinations and Permutations

```java
public class NQueens {

    final int N = 4;

    void printSolution(int board[][]) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
    }

    boolean isSafe(int board[][], int row, int col) {
        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    boolean solveNQUtil(int board[][], int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;

                if (solveNQUtil(board, col + 1) == true)
                    return true;

                board[i][col] = 0; // BACKTRACK
            }
        }

        return false;
    }

    boolean solveNQ() {
        int board[][] = {{0, 0, 0, 0},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0},
                         {0, 0, 0, 0}};

        if (solveNQUtil(board, 0) == false) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board);
        return true;
    }
}
```

[INSERT_DIAGRAM] A diagram of a backtracking algorithm solving a maze. The diagram should show the algorithm exploring a path, hitting a dead end, and then backtracking to try another path.

## 14. Greedy Algorithms
A greedy algorithm is an algorithmic paradigm that follows the problem-solving heuristic of making the locally optimal choice at each stage with the hope of finding a global optimum. (อัลกอริทึมแบบละโมบเป็นกระบวนทัศน์อัลกอริทึมที่ปฏิบัติตามฮิวริสติกการแก้ปัญหาของการเลือกตัวเลือกที่เหมาะสมที่สุดในแต่ละขั้นตอนโดยหวังว่าจะพบค่าที่เหมาะสมที่สุดทั่วโลก)

**Common Problems:**
*   Coin Change problem
*   Activity Selection problem
*   Huffman Coding

```java
import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int count = 0;
        for (int i = coins.length - 1; i >= 0; i--) {
            if (amount >= coins[i]) {
                int numCoins = amount / coins[i];
                amount -= numCoins * coins[i];
                count += numCoins;
            }
        }
        return amount == 0 ? count : -1;
    }
}
```

**Note:** Greedy algorithms do not always yield the optimal solution, but for many problems they do. (หมายเหตุ: อัลกอริทึมแบบละโมบไม่ได้รับประกันว่าจะให้ผลลัพธ์ที่ดีที่สุดเสมอไป แต่สำหรับหลาย ๆ ปัญหาก็สามารถทำได้)

