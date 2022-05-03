package lc.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeastNumberOfUniqueIntegersAfterKRemovals_1481 {

  public int findLeastNumOfUniqueInts(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int a : arr) {
      map.put(a, map.getOrDefault(a, 0) + 1);
    }
    List<Integer> list = new ArrayList<>(map.values());
    Collections.sort(list);
    int counter = 0;
    // Remove with make least remaining number in array
    // so that's mean, we focus on lowest frequency (that's why we sort)
    for (int freq : list) {
      k -= freq;
      if (k < 0) {
        break;
      }
      counter++;
    }
    // key size represent number members in array
    return map.size() - counter;
  }
}
