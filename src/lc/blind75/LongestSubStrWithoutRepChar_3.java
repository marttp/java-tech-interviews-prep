package lc.blind75;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrWithoutRepChar_3 {

  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    int longest = 0;
    int start = 0;
    int end = 0;

    while (end < s.length()) {
      char endChar = s.charAt(end++);
      map.put(endChar, map.getOrDefault(endChar, 0) + 1);
      while (map.get(endChar) > 1) {
        char startChar = s.charAt(start++);
        map.put(startChar, map.get(startChar) - 1);
        if (map.get(startChar) == 0) {
          map.remove(startChar);
        }
      }
      longest = Integer.max(longest, end - start);
    }

    return longest;
  }
}
