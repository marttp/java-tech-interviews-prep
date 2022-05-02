package lc.blind75.easy;

public class MaximumSubarray_53 {

  public int maxSubArray(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int maxSoFar = Integer.MIN_VALUE;
    int currMax = 0;
    for (int n : nums) {
      // Kadane's Algorithms
      currMax = Integer.max(currMax + n, n);
      maxSoFar = Integer.max(maxSoFar, currMax);
    }
    return maxSoFar;
  }
}
