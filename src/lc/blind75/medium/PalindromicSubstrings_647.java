package lc.blind75.medium;

public class PalindromicSubstrings_647 {

  public int countSubstrings(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int counter = 0;
    for (int i = 0; i < s.length(); i++) {
      // odd-length palindromes, single character center
      counter += expandLeftRightWithPalindromeCounter(s, i, i);
      // even-length palindromes, consecutive characters center (2 characters at center)
      counter += expandLeftRightWithPalindromeCounter(s, i, i + 1);
    }
    return counter;
  }

  private int expandLeftRightWithPalindromeCounter(String s, int left, int right) {
    int l = left;
    int r = right;
    int counter = 0;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
      counter++;
    }
    return counter;
  }
}
