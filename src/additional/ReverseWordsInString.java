package additional;

import static utility.Util.reverse;

public class ReverseWordsInString {

  public String reverseWord(String strs) {
    int n = strs.length();
    char[] words = strs.toCharArray();
    // Reverse all character
    reverse(words, 0, n - 1);
    int start = 0;
    int end = 0;
    while (start < n) {
      while (start < end || (start < n && Character.isWhitespace(words[start]))) {
        start++;
      }
      while (end < start || (end < n && !Character.isWhitespace(words[end]))) {
        end++;
      }
      reverse(words, start, end - 1);
    }
    return String.valueOf(words);
  }
}
