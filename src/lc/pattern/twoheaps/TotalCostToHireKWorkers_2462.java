package lc.pattern.twoheaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TotalCostToHireKWorkers_2462 {

    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        Comparator<Candidate> cmp = (a, b) -> {
            var cmpRes = Integer.compare(a.cost, b.cost);
            return cmpRes != 0 ? cmpRes : Integer.compare(a.index, b.index);
        };
        return manageLargerCandidate(costs, k, candidates, cmp);
    }

    private long manageLargerCandidate(
            int[] costs,
            int k,
            int candidates,
            Comparator<Candidate> cmp
    ) {
        int n = costs.length;
        PriorityQueue<Candidate> leftHeap = new PriorityQueue<>(cmp);
        PriorityQueue<Candidate> rightHeap = new PriorityQueue<>(cmp);
        long cost = 0L;
        int left = 0;
        int right = n - 1;

        // Initialize the heaps with the first candidates from both ends
        for (int i = 0; i < candidates && left <= right; i++) {
            leftHeap.add(new Candidate(left, costs[left]));
            left++;
            if (left <= right) {
                rightHeap.add(new Candidate(right, costs[right]));
                right--;
            }
        }

        // k - sessions
        while (k-- > 0) {
            Candidate c;
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek().cost <= rightHeap.peek().cost)) {
                c = leftHeap.poll();
                if (left <= right) {
                    leftHeap.add(new Candidate(left, costs[left]));
                    left++;
                }
            } else {
                c = rightHeap.poll();
                if (left <= right) {
                    rightHeap.add(new Candidate(right, costs[right]));
                    right--;
                }
            }
            cost += c.cost;
        }
        return cost;
    }

    private static record Candidate(int index, int cost) {
    }


}
