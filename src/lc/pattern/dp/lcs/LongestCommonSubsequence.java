package lc.pattern.dp.lcs;

public class LongestCommonSubsequence {

  public static class BottomUp {

    /*
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     * */
    public int findLCSLength(String s1, String s2) {
      int m = s1.length();
      int n = s2.length();
      int[][] dp = new int[m + 1][n + 1];
      int maxLength = 0;
      for (int i1 = 1; i1 <= m; i1++) {
        for (int i2 = 1; i2 <= n; i2++) {
          if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
            dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
          } else {
            dp[i1][i2] = Math.max(dp[i1 - 1][i2], dp[i1][i2 - 1]);
          }
          maxLength = Math.max(maxLength, dp[i1][i2]);
        }
      }
      return maxLength;
    }
  }

  public static class TopDown {

    /*
     * Time Complexity: O(m * n)
     * Space Complexity: O(m * n)
     * */
    public int findLCSLength(String s1, String s2) {
      Integer[][] memo = new Integer[s1.length()][s2.length()];
      return findLCSLength(s1, s2, 0, 0, memo);
    }

    private int findLCSLength(String s1, String s2, int i1, int i2, Integer[][] memo) {
      if (i1 == s1.length() || i2 == s2.length()) {
        return 0;
      }
      if (memo[i1][i2] == null) {
        if (s1.charAt(i1) == s2.charAt(i2)) {
          memo[i1][i2] = 1 + findLCSLength(s1, s2, i1 + 1, i2 + 1, memo);
          return memo[i1][i2];
        }
        int c1 = findLCSLength(s1, s2, i1 + 1, i2, memo);
        int c2 = findLCSLength(s1, s2, i1, i2 + 1, memo);
        memo[i1][i2] = Math.max(c1, c2);
      }
      return memo[i1][i2];
    }
  }

  public static class BruteForce {

    /*
     * Time Complexity: O(2^mn)
     * Space Complexity: O(m + n)
     * */
    public int findLCSLength(String s1, String s2) {
      return findLCSLength(s1, s2, 0, 0);
    }

    private int findLCSLength(String s1, String s2, int i1, int i2) {
      if (i1 == s1.length() || i2 == s2.length()) {
        return 0;
      }
      if (s1.charAt(i1) == s2.charAt(i2)) {
        return 1 + findLCSLength(s1, s2, i1 + 1, i2 + 1);
      }
      int c1 = findLCSLength(s1, s2, i1 + 1, i2);
      int c2 = findLCSLength(s1, s2, i1, i2 + 1);
      return Math.max(c1, c2);
    }
  }
}
