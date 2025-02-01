package lc.general.easy;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray_697 {

  public int findShortestSubArray(int[] nums) {
    Map<Integer, Integer> startMap = new HashMap<>();
    Map<Integer, Integer> freqMap = new HashMap<>();
    int maxDegree = 0;
    int maxLength = 0;
    for (int i = 0; i < nums.length; i++) {
      int num = nums[i];
      // Place first met of this number
      startMap.putIfAbsent(num, i);
      freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
      // in case same index => the result would be length == 1
      int currentLength = i - startMap.get(num) + 1;
      if (maxDegree < freqMap.get(num)) {
        maxDegree = freqMap.get(num);
        maxLength = currentLength;
      } else if (maxDegree == freqMap.get(num)) {
        maxLength = Integer.max(maxLength, currentLength);
      }
    }
    return maxLength;
  }
}
