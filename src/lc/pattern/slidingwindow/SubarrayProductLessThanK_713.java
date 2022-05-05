package lc.pattern.slidingwindow;

public class SubarrayProductLessThanK_713 {

  public int numSubarrayProductLessThanK(int[] nums, int k) {
    if (k == 0) {
      return 0;
    }
    int counter = 0;
    int start = 0;
    int end = 0;
    int product = 1;
    while (end < nums.length) {
      product *= nums[end];
      while (start <= end && product >= k) {
        product /= nums[start++];
      }
      counter += end - start + 1;
      end++;
    }
    return counter;
  }
}
