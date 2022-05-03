package lc.general;

import utility.Util;

public class FindPivotIndex_724 {

  public int pivotIndex(int[] nums) {
    int leftSum = 0;
    int rightSum = Util.sum(nums);
    for (int i = 0; i < nums.length; i++) {
      leftSum += nums[i];
      if (leftSum == rightSum) {
        return i;
      }
      rightSum -= nums[i];
    }
    return -1;
  }
}
