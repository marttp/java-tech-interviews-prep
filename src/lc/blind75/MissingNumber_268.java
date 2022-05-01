package lc.blind75;

import utility.Util;

public class MissingNumber_268 {

  public int missingNumber(int[] nums) {
    int n = nums.length;
    int maxSum = n * (n - 1) / 2;
    int actualSum = Util.sum(nums);
    return maxSum - actualSum;
  }
}
