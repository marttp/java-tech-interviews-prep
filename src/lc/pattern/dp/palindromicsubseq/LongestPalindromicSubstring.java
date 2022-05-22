package lc.pattern.dp.palindromicsubseq;

public class LongestPalindromicSubstring {

  public static class BottomUp {
    public int findLPSLength(String st) {
      int size = st.length();
      boolean[][] dp = new boolean[size][size];
      for (int i = 0; i < size; i++) {
        dp[i][i] = true;
      }
      // 1 character also palindrome
      int maxLength = 1;
      for (int startIndex = size - 1; startIndex >= 0; startIndex--) {
        for (int endIndex = startIndex + 1; endIndex < size; endIndex++) {
          if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
            dp[startIndex][endIndex] = true;
            maxLength = Math.max(maxLength, endIndex - startIndex + 1);
          }
        }
      }
      return maxLength;
    }
  }

  public static class TopDown {

    public int findLPSLength(String st) {
      int size = st.length();
      Integer[][] memo = new Integer[size][size];
      return findLPSLength(st, 0, st.length() - 1, memo);
    }

    private int findLPSLength(String st, int startIndex, int endIndex, Integer[][] memo) {
      if (startIndex > endIndex) {
        return 0;
      }
      if (startIndex == endIndex) {
        return 1;
      }
      if (memo[startIndex][endIndex] == null) {
        if (st.charAt(startIndex) == st.charAt(endIndex)) {
          int remainingLength = endIndex - startIndex - 1;
          if (remainingLength == findLPSLength(st, startIndex + 1, endIndex - 1, memo)) {
            memo[startIndex][endIndex] = 2 + remainingLength;
            return memo[startIndex][endIndex];
          }
        }
        int c1 = findLPSLength(st, startIndex + 1, endIndex, memo);
        int c2 = findLPSLength(st, startIndex, endIndex - 1, memo);
        memo[startIndex][endIndex] = Math.max(c1, c2);
      }
      return memo[startIndex][endIndex];
    }
  }

  public static class BruteForce {

    public int findLPSLength(String st) {
      return findLPSLength(st, 0, st.length() - 1);
    }

    private int findLPSLength(String st, int startIndex, int endIndex) {
      if (startIndex > endIndex) {
        return 0;
      }
      if (startIndex == endIndex) {
        return 1;
      }
      if (st.charAt(startIndex) == st.charAt(endIndex)) {
        int remainingLength = endIndex - startIndex - 1;
        if (remainingLength == findLPSLength(st, startIndex + 1, endIndex - 1)) {
          return 2 + remainingLength;
        }
      }
      int c1 = findLPSLength(st, startIndex + 1, endIndex);
      int c2 = findLPSLength(st, startIndex, endIndex - 1);
      return Math.max(c1, c2);
    }
  }
}
