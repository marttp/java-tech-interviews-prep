package lc.general;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore_2542 {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i] = new int[]{nums2[i], nums1[i]};
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        long maximumScore = 0;
        long sum = 0;

        for (int[] pair : pairs) {
            pq.add(pair[1]);
            sum += pair[1];
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (pq.size() == k) {
                maximumScore = Math.max(maximumScore, sum * pair[0]);
            }
        }

        return maximumScore;
    }

}
