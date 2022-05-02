package lc.blind75.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElement_347 {

  public int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int n : nums) {
      freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
    }
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        Comparator.comparingInt(Entry::getValue));
    for (var entry : freqMap.entrySet()) {
      minHeap.add(entry);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    int[] result = new int[k];
    // min heap => min coming first
    for (int i = 0; i < k; i++) {
      result[i] = minHeap.poll().getKey();
    }
    return result;
  }
}
