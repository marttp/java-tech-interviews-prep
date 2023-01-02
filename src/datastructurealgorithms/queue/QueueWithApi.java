package datastructurealgorithms.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueWithApi {

    public static void exampleByLinkedList() {
        // Create a new queue
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        // Remove an element from the queue
        int removed = queue.remove();  // removed will be 1

        // Peek at the element at the head of the queue
        int head = queue.peek();  // head will be 2

        // Check if the queue is empty
        boolean isEmpty = queue.isEmpty();  // isEmpty will be false

        // Get the size of the queue
        int size = queue.size();  // size will be 4
    }
}
