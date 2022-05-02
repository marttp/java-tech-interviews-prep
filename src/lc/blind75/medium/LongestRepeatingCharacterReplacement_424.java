package lc.blind75.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement_424 {

  public int characterReplacement(String s, int k) {
    int windowStart = 0;
    int windowEnd = 0;
    int longest = 0;
    Map<Character, Integer> map = new HashMap<>();
    int maxRepeat = 0; // most alphabet in text string
    while (windowEnd < s.length()) {
      char c1 = s.charAt(windowEnd++);
      map.put(c1, map.getOrDefault(c1, 0) + 1);
      maxRepeat = Integer.max(maxRepeat, map.get(c1));
      while (windowEnd - windowStart - maxRepeat > k) {
        char c2 = s.charAt(windowStart++);
        map.put(c2, map.get(c2));
        if (map.get(c2) == 0) {
          map.remove(c2);
        }
      }
      longest = Integer.max(longest, windowEnd - windowStart);
    }
    return longest;
  }
}
