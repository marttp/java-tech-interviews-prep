package lc.pattern.heap;

import java.util.PriorityQueue;

public class MinimumCostToConnectSticks_1167 {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int s : sticks) {
            minHeap.add(s);
        }
        int cost = 0;
        while (minHeap.size() != 1) {
            int newStick = minHeap.poll() + minHeap.poll();
            cost += newStick;
            minHeap.add(newStick);
        }
        return cost;
    }
}
