package lc.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberOfKSumPairs_1679 {
    public int maxOperations(int[] nums, int k) {
        int result = 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == k) {
                result++;
                left++;
                right--;
            } else if (sum < k) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public int maxOperations1Pass(int[] nums, int k) {
        int result = 0;
        Map<Integer, Integer> countSeen = new HashMap<>();
        for (int n : nums) {
            int diff = k - n;
            if (countSeen.containsKey(diff)) {
                int remaining = countSeen.get(diff) - 1;
                countSeen.put(diff, remaining);
                if (remaining == 0) {
                    countSeen.remove(diff);
                }
                result++;
            } else {
                countSeen.put(n, countSeen.getOrDefault(n, 0) + 1);
            }
        }
        return result;
    }
}
