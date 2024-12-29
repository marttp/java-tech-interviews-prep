package datastructurealgorithms.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class HeapExample {

    public static void main(String[] args) {
        // Min-Heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        // Max-Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
//        PriorityQueue<Integer> alternativeMaxHeap = new PriorityQueue<>(
//                (a, b) -> b.compareTo(a)
//        );
        for (int n : List.of(5, 18, 456, 486, 46, 81, 6, 4186)) {
            minHeap.offer(n);
            maxHeap.offer(n);
        }
        List<Integer> minHeapResult = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            minHeapResult.add(minHeap.poll());
        }
        System.out.println(minHeapResult);
        List<Integer> maxHeapResult = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            maxHeapResult.add(maxHeap.poll());
        }
        System.out.println(maxHeapResult);
    }
}
