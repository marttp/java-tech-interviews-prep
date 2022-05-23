package lc.pattern.dp.lcs;

import utility.Util;

public class LongestCommonSubstring {

  public static class BottomUp {
    public int findLCSLength(String s1, String s2) {
      int m = s1.length();
      int n = s2.length();
      int[][] dp = new int[m + 1][n + 1];
      int maxLength = 0;
      for (int i1 = 1; i1 <= m; i1++) {
        for (int i2 = 1; i2 <= n; i2++) {
          if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
            dp[i1][i2] = 1 + dp[i1 - 1][i2 - 1];
            maxLength = Math.max(maxLength, dp[i1][i2]);
          }
        }
      }
      return maxLength;
    }

    public int findLCSLengthSpaceOptimize(String s1, String s2) {
      int m = s1.length();
      int n = s2.length();
      int[][] dp = new int[2][n + 1];
      int maxLength = 0;
      for (int i1 = 1; i1 <= m; i1++) {
        for (int i2 = 1; i2 <= n; i2++) {
          if (s1.charAt(i1 - 1) == s2.charAt(i2 - 1)) {
            dp[i1 % 2][i2] = 1 + dp[(i1 - 1) % 2][i2 - 1];
            maxLength = Math.max(maxLength, dp[i1 % 2][i2]);
          }
        }
      }
      return maxLength;
    }
  }

  public static class TopDown {

    public int findLCSLength(String s1, String s2) {
      int m = s1.length();
      int n = s2.length();
      int maxLength = Math.max(m, n);
      Integer[][][] memo = new Integer[m][n][maxLength];
      return findLCSLength(s1, s2, 0, 0, 0, memo);
    }

    private int findLCSLength(String s1, String s2, int i1, int i2, int count, Integer[][][] memo) {
      if (i1 == s1.length() || i2 == s2.length()) {
        return count;
      }
      if (memo[i1][i2][count] == null) {
        int c1 = count;
        if (s1.charAt(i1) == s2.charAt(i2)) {
          c1 = findLCSLength(s1, s2, i1 + 1, i2 + 1, count + 1, memo);
        }
        int c2 = findLCSLength(s1, s2, i1 + 1, i2, 0, memo);
        int c3 = findLCSLength(s1, s2, i1, i2 + 1, 0, memo);
        memo[i1][i2][count] = Util.max3Elem(c1, c2, c3);
      }
      return memo[i1][i2][count];
    }
  }

  public static class BruteForce {

    public int findLCSLength(String s1, String s2) {
      return findLCSLength(s1, s2, 0, 0, 0);
    }

    private int findLCSLength(String s1, String s2, int i1, int i2, int count) {
      if (i1 == s1.length() || i2 == s2.length()) {
        return count;
      }
      if (s1.charAt(i1) == s2.charAt(i2)) {
        count = findLCSLength(s1, s2, i1 + 1, i2 + 1, count + 1);
      }
      int c1 = findLCSLength(s1, s2, i1 + 1, i2, 0);
      int c2 = findLCSLength(s1, s2, i1, i2 + 1, 0);
      return Util.max3Elem(count, c1, c2);
    }
  }
}
