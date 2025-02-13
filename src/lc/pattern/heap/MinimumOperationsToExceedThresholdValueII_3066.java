package lc.pattern.heap;

import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII_3066 {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int n : nums) {
            minHeap.add((long) n);
        }
        int operationCount = 0;
        while (!minHeap.isEmpty() && minHeap.peek() < k && minHeap.size() >= 2) {
            operationCount++;
            long x = minHeap.poll();
            long y = minHeap.poll();
            long result = Math.min(x, y) * 2 + Math.max(x, y);
            minHeap.add(result);
        }
        return operationCount;
    }
}
