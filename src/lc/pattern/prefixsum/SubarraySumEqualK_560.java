package lc.pattern.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualK_560 {

  public int subarraySum(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Map<Integer, Integer> map = new HashMap<>();
    int sum = 0;
    int counter = 0;
    map.put(0, 1);
    for (int n : nums) {
      sum += n;
      if (map.containsKey(sum - k)) {
        counter += map.get(sum - k);
      }
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    return counter;
  }
}
