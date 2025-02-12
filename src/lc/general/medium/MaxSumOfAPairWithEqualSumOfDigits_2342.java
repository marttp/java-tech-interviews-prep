package lc.general.medium;

import java.util.Collections;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MaxSumOfAPairWithEqualSumOfDigits_2342 {

    class Solution1 {
        public int maximumSum(int[] nums) {
            Map<Integer, PriorityQueue<Integer>> mapPq = new TreeMap<>();
            for (int n : nums) {
                int dSum = digitSum(n);
                mapPq.putIfAbsent(dSum, new PriorityQueue<>(Collections.reverseOrder()));
                mapPq.get(dSum).add(n);
            }

            int maxSum = -1;
            for (var entry : mapPq.entrySet()) {
                var pq = entry.getValue();
                if (pq.size() >= 2) {
                    int sum = pq.poll() + pq.poll();
                    maxSum = Integer.max(maxSum, sum);
                }
            }
            return maxSum;
        }

        public int digitSum(int n) {
            int sum = 0;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }
    }

    class Solution2 {
        public int maximumSum(int[] nums) {
            // Value => 10^9 => Max possible of sum digit is 9 * 9 = 81
            int[] lastMaxValue = new int[82];
            int maxSum = -1;
            for (int n : nums) {
                int dSum = digitSum(n);
                if (lastMaxValue[dSum] != 0) {
                    maxSum = Integer.max(maxSum, n + lastMaxValue[dSum]);
                }
                lastMaxValue[dSum] = Integer.max(lastMaxValue[dSum], n);
            }
            return maxSum;
        }

        public int digitSum(int n) {
            int sum = 0;
            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }
    }
}
