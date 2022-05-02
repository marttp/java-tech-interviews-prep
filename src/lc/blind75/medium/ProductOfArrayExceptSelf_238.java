package lc.blind75.medium;

public class ProductOfArrayExceptSelf_238 {

  public int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] result = new int[len];
    int prefixLeft = 1;
    for (int i = 0; i < len; i++) {
      result[i] = prefixLeft;
      prefixLeft *= nums[i];
    }
    int prefixRight = 1;
    for (int i = len - 1; i >= 0; i--) {
      result[i] *= prefixRight;
      prefixRight *= nums[i];
    }
    return result;
  }
}
