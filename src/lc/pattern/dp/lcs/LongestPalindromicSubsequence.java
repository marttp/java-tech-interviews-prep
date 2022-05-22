package lc.pattern.dp.lcs;

public class LongestPalindromicSubsequence {

  public static class BottomUp {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     * */
    public int findLPSLength(String st) {
      int size = st.length();
      int[][] dp = new int[size][size];
      // diagonal == 1 => 1 character
      for (int i = 0; i < size; i++) {
        dp[i][i] = 1;
      }
      for (int startIndex = size - 1; startIndex >= 0; startIndex--) {
        for (int endIndex = startIndex + 1; endIndex < size; endIndex++) {
          if (st.charAt(startIndex) == st.charAt(endIndex)) {
            dp[startIndex][endIndex] = 2 + dp[startIndex + 1][endIndex - 1];
          } else {
            dp[startIndex][endIndex] = Math.max(
                dp[startIndex + 1][endIndex],
                dp[startIndex][endIndex - 1]
            );
          }
        }
      }
      return dp[0][size - 1];
    }
  }

  public static class TopDown {
    /*
     * Time Complexity: O(n^2)
     * Space Complexity: O(n^2)
     * */
    public int findLPSLength(String st) {
      Integer[][] memo = new Integer[st.length()][st.length()];
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
          memo[startIndex][endIndex] = 2 + findLPSLength(st, startIndex + 1, endIndex - 1, memo);
          return memo[startIndex][endIndex];
        }
        int c1 = findLPSLength(st, startIndex + 1, endIndex, memo);
        int c2 = findLPSLength(st, startIndex, endIndex - 1, memo);
        memo[startIndex][endIndex] = Math.max(c1, c2);
      }
      return memo[startIndex][endIndex];
    }
  }

  public static class BruteForce {
    /*
     * Time Complexity: O(2^n)
     * Space Complexity: O(n) // Call stack
     * */
    public int findLPSLength(String st) {
      return findLPSLength(st, 0, st.length() - 1);
    }

    private int findLPSLength(String st, int startIndex, int endIndex) {
      if (startIndex > endIndex) {
        return 0;
      }
      // Every sequence with one element is a palindrome of length 1
      if (startIndex == endIndex) {
        return 1;
      }
      // Case 1: Elements at the beginning and the end are the same
      if (st.charAt(startIndex) == st.charAt(endIndex)) {
        return 2 + findLPSLength(st, startIndex + 1, endIndex - 1);
      }
      // Case 2: Skip one element either from the beginning or the end
      int c1 = findLPSLength(st, startIndex + 1, endIndex);
      int c2 = findLPSLength(st, startIndex, endIndex - 1);
      return Math.max(c1, c2);
    }
  }
}
