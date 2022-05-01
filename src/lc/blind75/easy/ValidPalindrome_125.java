package lc.blind75.easy;

public class ValidPalindrome_125 {

  // Focus only character and digit
  public boolean isPalindrome(String s) {
    s = s.trim().toLowerCase();
    if (s.length() == 1) {
      return true;
    }
    int left = 0;
    int right = s.length() - 1;
    while (left < right) {
      while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
        left++;
      }
      while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
        right--;
      }
      if (s.charAt(left) != s.charAt(right)) {
        return false;
      }
      left++;
      right--;
    }
    return true;
  }
}
