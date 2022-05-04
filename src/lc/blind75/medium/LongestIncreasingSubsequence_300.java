package lc.blind75.medium;

public class LongestIncreasingSubsequence_300 {

  public int lengthOfLIS(int[] nums) {
//    return memoization(nums);
    return tabulation(nums);
  }

  private int memoization(int[] nums) {
    int n = nums.length;
    Integer[][] memo = new Integer[n][n + 1];
    return lengthOfLIS(nums, 0, -1, memo);
  }

  private int lengthOfLIS(int[] nums, int currentIndex, int prevIndex, Integer[][] memo) {
    if (currentIndex == nums.length) {
      return 0;
    }
    // 0/1 Knapsack
    if (memo[currentIndex][prevIndex + 1] == null) {
      int v1 = 0;
      // Select
      if (prevIndex == -1 || nums[currentIndex] > nums[prevIndex]) {
        v1 = 1 + lengthOfLIS(nums, currentIndex + 1, currentIndex, memo);
      }
      // Skip
      int v2 = lengthOfLIS(nums, currentIndex + 1, prevIndex, memo);
      memo[currentIndex][prevIndex + 1] = Math.max(v1, v2);
    }
    return memo[currentIndex][prevIndex + 1];
  }

  public int tabulation(int[] nums) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = 1;
    int maxLength = 1;

    for (int i = 1; i < n; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j] && dp[i] <= dp[j]) {
          dp[i] = 1 + dp[j];
          maxLength = Math.max(maxLength, dp[i]);
        }
      }
    }
    return maxLength;
  }
}
