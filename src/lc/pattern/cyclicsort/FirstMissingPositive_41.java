package lc.pattern.cyclicsort;

import utility.Util;

public class FirstMissingPositive_41 {

  public int firstMissingPositive(int[] nums) {
    // Input include negative and zero
    // But we focus on positive value, so focus on that first
    // If negative or zero, ignore them
    int n = nums.length;
    int index = 0;
    // Cyclic Sort
    while (index < n) {
      int targetIndex = nums[index] - 1;
      // Only POSITIVE!!
      boolean isValidRange = targetIndex >= 0 && targetIndex < n;
      if (isValidRange && nums[targetIndex] != nums[index]) {
        Util.swap(nums, index, targetIndex);
      } else {
        index++;
      }
    }

    for (int i = 0; i < n; i++) {
      int expectedValue = i + 1;
      if (nums[i] != expectedValue) {
        return expectedValue;
      }
    }

    // Default one => if they have all positive within range
    return n + 1;
  }
}
