package lc.pattern.dp.knapsack01;

public class LongestIncreasingSubsequence {

  public static class BottomUp {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     * */
    public int findLISLength(int[] nums) {
      int n = nums.length;
      int[] dp = new int[n];
      int maxLength = 1;
      dp[0] = 1;
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

  public static class TopDown {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     * */
    public int findLISLength(int[] nums) {
      Integer[][] memo = new Integer[nums.length][nums.length + 1];
      return findLISLength(nums, 0, -1, memo);
    }

    private int findLISLength(int[] nums, int currentIndex, int prevIndex, Integer[][] memo) {
      if (currentIndex == nums.length) {
        return 0;
      }
      if (memo[currentIndex][prevIndex + 1] == null) {
        int c1 = 0;
        if (prevIndex == -1 || nums[currentIndex] > nums[prevIndex]) {
          c1 = 1 + findLISLength(nums, currentIndex + 1, currentIndex, memo);
        }
        int c2 = findLISLength(nums, currentIndex + 1, prevIndex, memo);
        memo[currentIndex][prevIndex + 1] = Math.max(c1, c2);
      }
      return memo[currentIndex][prevIndex + 1];
    }
  }

  public static class BruteForce {

    /*
     * Time Complexity: O(2^n)
     * Space Complexity: O(n)
     * */
    public int findLISLength(int[] nums) {
      return findLISLength(nums, 0, -1);
    }

    private int findLISLength(int[] nums, int currentIndex, int prevIndex) {
      if (currentIndex == nums.length) {
        return 0;
      }
      int c1 = 0;
      if (prevIndex == -1 || nums[currentIndex] > nums[prevIndex]) {
        c1 = 1 + findLISLength(nums, currentIndex + 1, currentIndex);
      }
      int c2 = findLISLength(nums, currentIndex + 1, prevIndex);
      return Math.max(c1, c2);
    }
  }
}
