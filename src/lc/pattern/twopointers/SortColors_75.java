package lc.pattern.twopointers;

import utility.Util;

public class SortColors_75 {
  // Only have 3 kind of numbers (0, 1, 2)

  private static final int RED = 0;
  private static final int WHITE = 1;
  private static final int BLUE = 2;

  public void sortColor(int[] nums) {
    // Write index for red
    int redIndex = 0;
    // Write index for white
    // Main pointer to move
    int whiteIndex = 0;
    // Write index for blue
    int blueIndex = nums.length - 1;
    while (whiteIndex <= blueIndex) {
      if (nums[whiteIndex] == RED) {
        Util.swap(nums, redIndex++, whiteIndex++);
      } else if (nums[whiteIndex] == BLUE) {
        Util.swap(nums, whiteIndex, blueIndex--);
      } else {
        whiteIndex++;
      }
    }
  }
}
