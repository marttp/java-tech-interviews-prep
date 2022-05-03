package lc.pattern.twopointers;

public class MoveZeroes_283 {

  public void moveZeroes(int[] nums) {
    int writeIndex = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != 0) {
        nums[writeIndex++] = nums[i];
      }
    }
    while (writeIndex < nums.length) {
      nums[writeIndex++] = 0;
    }
  }
}
