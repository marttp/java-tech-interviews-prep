package lc.general;

public class MaxDiffBetweenIncreasingElement_2016 {

  public int maximumDifference(int[] nums) {
    int max = -1;
    int i = 0;
    int j = 0;
    while (j < nums.length) {
      if (nums[i] >= nums[j]) {
        i = j;
      }
      if (nums[j] > nums[i]) {
        max = Integer.max(max, Math.abs(nums[j] - nums[i]));
      }
      j++;
    }
    return max;
  }
}
