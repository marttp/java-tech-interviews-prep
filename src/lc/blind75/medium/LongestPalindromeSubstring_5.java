package lc.blind75.medium;

public class LongestPalindromeSubstring_5 {

  public String longestPalindrome(String s) {
    if (s == null || s.length() < 2) {
      return s;
    }
    int start = 0;
    int end = 0;

    for (int i = 0; i < s.length(); i++) {
      // try on both case that might be happened
      // assume odd length, try to expand palindrome as possible
      // odd-length palindromes, single character center
      int len1 = expandFromCenter(s, i, i);
      // assume even length
      // even-length palindromes, consecutive characters center (2 characters at center)
      int len2 = expandFromCenter(s, i, i + 1);
      int longest = Integer.max(len1, len2);

      if (longest > end - start) {
        start = i - ((longest - 1) / 2);
        end = i + (longest / 2);
      }

    }
    return s.substring(start, end + 1);
  }

  private int expandFromCenter(String s, int left, int right) {
    int l = left;
    int r = right;
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    return r - l - 1;
  }
}
