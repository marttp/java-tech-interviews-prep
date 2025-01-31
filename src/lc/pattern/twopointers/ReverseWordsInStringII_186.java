package lc.pattern.twopointers;

import utility.Util;

public class ReverseWordsInStringII_186 {

  public void reverseWords(char[] s) {
    int n = s.length;
    Util.reverse(s, 0, n - 1);
    int start = 0;
    int end = 0;
    while (end < n) {
      while (start < n && (start < end || Character.isWhitespace(s[start]))) {
        start++;
      }
      while (end < n && (end < start || !Character.isWhitespace(s[end]))) {
        end++;
      }
      Util.reverse(s, start, end - 1);
    }
  }
}
