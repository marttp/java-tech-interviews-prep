package lc.blind75.medium;

import utility.Util;

public class MaximumProductSubarray_152 {

  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    int maxSoFar = nums[0];
    int minSoFar = nums[0];
    int lastResult = maxSoFar;

    for (int i = 1; i < nums.length; i++) {
      int curr = nums[i];
      // Store in tmp for avoid change in find minSoFar
      int tmp = Util.max3Elem(curr, curr * maxSoFar, curr * minSoFar);
      minSoFar = Util.min3Elem(curr, curr * maxSoFar, curr * minSoFar);
      maxSoFar = tmp;
      lastResult = Math.max(lastResult, maxSoFar);
    }

    return lastResult;
  }
}
