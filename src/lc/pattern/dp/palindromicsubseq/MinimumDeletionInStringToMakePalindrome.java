package lc.pattern.dp.palindromicsubseq;

public class MinimumDeletionInStringToMakePalindrome {

  public int findMinimumDeletions(String st) {
    int longestPalindromeSubsequenceResult = new LongestPalindromicSubsequence
        .BottomUp()
        .findLPSLength(st);
    return st.length() - longestPalindromeSubsequenceResult;
  }

  public boolean isAlmostPalindrome(String st, int limitation) {
    int longestPalindromeSubsequenceResult = new LongestPalindromicSubsequence
        .BottomUp()
        .findLPSLength(st);
    int diff = st.length() - longestPalindromeSubsequenceResult;
    return diff <= limitation;
  }
}
