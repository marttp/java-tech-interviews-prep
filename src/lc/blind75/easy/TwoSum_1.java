package lc.blind75.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        return new int[]{map.get(nums[i]), i};
      }
      int diff = target - nums[i];
      map.put(diff, i);
    }
    return new int[]{-1, -1};
  }

}
