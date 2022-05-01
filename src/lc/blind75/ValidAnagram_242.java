package lc.blind75;

import java.util.Arrays;

public class ValidAnagram_242 {

  public boolean isAnagram(String s, String t) {
    // Unicode size (2^16)
    int size = (int) Math.pow(2, 16);
    int[] count1 = new int[size];
    for (char c : s.toCharArray()) {
      count1[c]++;
    }
    int[] count2 = new int[size];
    for (char c : t.toCharArray()) {
      count2[c]++;
    }
    // Time/Space complexity: O(s + t)
    return Arrays.equals(count1, count2);
  }
}
