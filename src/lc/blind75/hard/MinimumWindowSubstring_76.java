package lc.blind75.hard;

import utility.Util;

public class MinimumWindowSubstring_76 {

  public String minWindow(String s, String t) {
    // minimum window => s include substring t every character
    int[] map = new int[128];
    for (char c : t.toCharArray()) {
      map[c]++;
    }

    int windowStart = 0;
    int windowEnd = 0;
    int minLength = Integer.MAX_VALUE;
    int minStart = 0;
    int counter = t.length(); // To memorize how many character we use
    // if counter == 0 => contains all character

    while (windowEnd < s.length()) {
      char c1 = s.charAt(windowEnd++);
      if (map[c1] > 0) {
        counter--;
      }
      map[c1]--;
      while (counter == 0) {
        if (minLength > windowEnd - windowStart) {
          minLength = windowEnd - windowStart;
          minStart = windowStart;
        }
        char c2 = s.charAt(windowStart++);
        map[c2]++;
        if (map[c2] > 0) {
          counter++;
        }
      }
    }

    if (minLength == Integer.MAX_VALUE) {
      // It's mean don't have any window in s that have t substring
      return "";
    }
    return s.substring(minStart, minStart + minLength);
  }
}
