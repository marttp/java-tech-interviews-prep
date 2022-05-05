package lc.blind75.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HouseRobber_198 {

  public int rob(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    return new Random().nextInt(2) == 0 ? memoization(nums) : tabulation(nums);
  }

  private int memoization(int[] nums) {
    Map<Integer, Integer> memo = new HashMap<>();
    return robRecursive(nums, nums.length - 1, memo);
  }

  private int robRecursive(int[] nums, int index, Map<Integer, Integer> memo) {
    if (index == 0) {
      return nums[0];
    }
    if (index == 1) {
      return Integer.max(nums[0], nums[1]);
    }
    if (!memo.containsKey(index)) {
      // it will automatically contact the police if two adjacent houses were broken into on the same night.
      // 1. Skip this house
      int v1 = robRecursive(nums, index - 1, memo);
      // 2. Take this house
      int v2 = robRecursive(nums, index - 2, memo) + nums[index];
      int max = Integer.max(v1, v2);
      memo.put(index, max);
    }
    return memo.get(index);
  }

  private int tabulation(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Integer.min(nums[0], nums[1]);
    for (int i = 2; i < n; i++) {
      dp[i] = Integer.max(dp[i - 1], nums[i] + dp[i - 2]);
    }
    return dp[n - 1];
  }

}
