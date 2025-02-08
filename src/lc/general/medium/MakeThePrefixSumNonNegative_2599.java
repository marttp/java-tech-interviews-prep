package lc.general.medium;

import java.util.PriorityQueue;

public class MakeThePrefixSumNonNegative_2599 {

    public int makePrefSumNonNegative(int[] nums) {
        int prefixSum = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int count = 0;
        for (int n : nums) {
            prefixSum += n;
            if (n < 0) {
                minHeap.add(n);
            }
            while (prefixSum < 0 && !minHeap.isEmpty()) {
                int lowestInHeap = minHeap.poll();
                prefixSum -= lowestInHeap;
                count++;
            }
        }
        return count;
    }
}