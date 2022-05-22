package lc.pattern.modifiedbinarysearch;

import java.util.Arrays;
import utility.GenerateExample;

public class FindFirstAndLastPositionInSortedArray_34 implements GenerateExample {

  public int[] searchRange(int[] nums, int target) {
    // Already sorted input
    int[] result = {-1, -1};
    result[0] = searchIndex(nums, target, false);
    if (result[0] != -1) {
      result[1] = searchIndex(nums, target, true);
    }
    return result;
  }

  private int searchIndex(int[] nums, int target, boolean isFindMax) {
    // can grouping 3 parameters as input class
    int result = -1;
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] < target) {
        left = mid + 1;
      } else if (nums[mid] > target) {
        right = mid - 1;
      } else {
        result = mid;
        if (isFindMax) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return result;
  }

  @Override
  public void example() {
    int[] nums = {3, 4, 4, 5, 6, 7, 7, 8, 8, 8, 10, 10};
    int target = 8;
    String result = Arrays.toString(searchRange(nums, target));
    System.out.println("First & Last Position of " + target + ": " + result);
  }
}
