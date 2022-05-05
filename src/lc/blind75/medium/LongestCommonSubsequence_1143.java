package lc.blind75.medium;

public class LongestCommonSubsequence_1143 {

  public int longestCommonSubsequence(String text1, String text2) {
//    return memoization(text1, text2);
    return tabulation(text1, text2);
  }

  private int memoization(String text1, String text2) {
    Integer[][] memo = new Integer[text1.length()][text2.length()];
    return longestCommonSubsequenceRecursive(text1, text2, 0, 0, memo);
  }

  private int longestCommonSubsequenceRecursive(String text1, String text2, int i1, int i2) {
    if (text1.length() == i1 || text2.length() == i2) {
      return 0;
    }
    // Match => Move both
    if (text1.charAt(i1) == text2.charAt(i2)) {
      return 1 + longestCommonSubsequenceRecursive(text1, text2, i1 + 1, i2 + 1);
    }
    // Not match => Move text1
    int len1 = longestCommonSubsequenceRecursive(text1, text2, i1 + 1, i2);
    // Not match => Move text2
    int len2 = longestCommonSubsequenceRecursive(text1, text2, i1, i2 + 1);
    // Longest result
    return Integer.max(len1, len2);
  }

  private int longestCommonSubsequenceRecursive(String text1, String text2, int i1, int i2, Integer[][] memo ) {
    if (text1.length() == i1 || text2.length() == i2) {
      return 0;
    }
    if (memo[i1][i2] == null) {
      // Match => Move both
      if (text1.charAt(i1) == text2.charAt(i2)) {
        int matchLen = 1 + longestCommonSubsequenceRecursive(text1, text2, i1 + 1, i2 + 1, memo);
        memo[i1][i2] = matchLen;
        return matchLen;
      }
      // Not match => Move text1
      int len1 = longestCommonSubsequenceRecursive(text1, text2, i1 + 1, i2, memo);
      // Not match => Move text2
      int len2 = longestCommonSubsequenceRecursive(text1, text2, i1, i2 + 1, memo);
      // Longest result
      memo[i1][i2] = Integer.max(len1, len2);
    }
    return memo[i1][i2];
  }

  private int tabulation(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];
    int maxLength = 0;
    for (int i1 = 1; i1 <= text1.length(); i1++) {
      for (int i2 = 1; i2 <= text2.length(); i2++) {
        if (text1.charAt(i1 - 1) == text2.charAt(i2 - 1)) {
          dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
        } else {
          dp[i1][i2] = Integer.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
        }
        maxLength = Integer.max(maxLength, dp[i1][i2]);
      }
    }
    return maxLength;
  }
}
