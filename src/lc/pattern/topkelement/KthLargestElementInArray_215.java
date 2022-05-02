package lc.pattern.topkelement;

import java.util.PriorityQueue;

public class KthLargestElementInArray_215 {

  public int findKthLargest(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for (int n : nums) {
      minHeap.add(n);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return minHeap.peek();
  }
}
