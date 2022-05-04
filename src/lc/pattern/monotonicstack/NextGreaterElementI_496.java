package lc.pattern.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class NextGreaterElementI_496 {

  // where num1 is subset of num2
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> indexMap = new HashMap<>();
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < nums2.length; i++) {
      indexMap.put(nums2[i], -1);
      while (!stack.isEmpty() && nums2[stack.peekFirst()] < nums2[i]) {
        int prev = stack.removeFirst();
        indexMap.put(nums2[prev], nums2[i]);
      }
      stack.addFirst(i);
    }
    int[] result = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      result[i] = indexMap.get(nums1[i]);
    }
    return result;
  }
}
