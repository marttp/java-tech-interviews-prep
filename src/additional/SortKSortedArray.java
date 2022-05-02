package additional;

import java.util.PriorityQueue;

public class SortKSortedArray {

  public int[] sortKSortedArray(int[] array, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int[] result = new int[array.length];
    int writeIndex = 0;
    for (int n : array) {
      minHeap.add(n);
      if (minHeap.size() > k) {
        result[writeIndex++] = minHeap.poll();
      }
    }
    while (!minHeap.isEmpty()) {
      result[writeIndex++] = minHeap.poll();
    }
    return result;
  }
}
