package lc.blind75.medium;

import static utility.Util.listToIntArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import utility.GenerateExample;

public class ThreeSum_15 implements GenerateExample {

  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for (int i = 0; i < nums.length - 2; i++) {
      // check duplicate with previous value
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      twoSumWithSortDup(nums, result, i, -nums[i]);
    }
    return result;
  }

  private void twoSumWithSortDup(int[] nums, List<List<Integer>> result, int index, int target) {
    int left = index;
    int right = nums.length - 1;
    while (left < right) {
      int sum = nums[left] + nums[right];
      if (sum == target) {
        // update 2 pointers index
        result.add(List.of(nums[index], nums[left++], nums[right--]));
        // check duplicate
        while (left < right && nums[left] == nums[left - 1]) {
          left++;
        }
        while (left < right && nums[right] == nums[right + 1]) {
          right--;
        }
      } else if (sum < target) {
        left++;
      } else {
        right--;
      }
    }
  }

  @Override
  public void example() {
    List<Integer> nums = List.of(-1, 0, 1, 2, -1, -4);
    List<List<Integer>> result = threeSum(listToIntArray(nums));
    System.out.printf("Result: " + result);
  }
}
