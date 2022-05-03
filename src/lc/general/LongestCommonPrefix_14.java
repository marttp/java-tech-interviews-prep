package lc.general;

public class LongestCommonPrefix_14 {

  public String longestCommonPrefix(String[] strs) {
    if (strs.length == 1) {
      return strs[0];
    }
    String firstWord = strs[0];
    for (int i = 0; i < firstWord.length(); i++) {
      char c = firstWord.charAt(i);
      for (int j = 1; j < strs.length; j++) {
        if (strs[j].length() <= i || strs[j].charAt(i) != c) {
          return firstWord.substring(0, i);
        }
      }
    }
    return firstWord;
  }
}
