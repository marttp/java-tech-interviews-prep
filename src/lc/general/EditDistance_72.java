package lc.general;

import utility.Util;

public class EditDistance_72 {

  public int minDistance(String word1, String word2) {
//    return topDown(word1, word2);
    return bottomUp(word1, word2);
  }

  private int topDown(String word1, String word2) {
    Integer[][] memo = new Integer[word1.length()][word2.length()];
    return minDistanceRecursive(word1, word2, 0, 0, memo);
  }

  private int minDistanceRecursive(String word1, String word2, int i1, int i2, Integer[][] memo) {
    if (i1 >= word1.length()) {
      return word2.length() - i2;
    } else if (i2 >= word2.length()) {
      return word1.length() - i1;
    }
    if (memo[i1][i2] == null) {
      if (word1.charAt(i1) == word2.charAt(i2)) {
        memo[i1][i2] = minDistanceRecursive(word1, word2, i1 + 1, i2 + 1, memo);
      } else {
        // Base on word1
        // 1. delete char from word1 => next index
        int delete = minDistanceRecursive(word1, word2, i1 + 1, i2, memo);
        // 2. insert char to word1 => move word2 index
        int insert = minDistanceRecursive(word1, word2, i1, i2 + 1, memo);
        // 3. Replace => just move
        int replace = minDistanceRecursive(word1, word2, i1 + 1, i2 + 1, memo);
        // Increment difference on this char
        memo[i1][i2] = 1 + Util.min3Elem(delete, insert, replace);
      }
    }
    return memo[i1][i2];
  }

  private int bottomUp(String word1, String word2) {
    int m = word1.length();
    int n = word2.length();
    int[][] dp = new int[m + 1][n + 1];
    for (int i1 = 0; i1 <= m; i1++) {
      // if word2 empty
      dp[i1][0] = i1;
    }
    for (int i2 = 0; i2 <= n; i2++) {
      // if word1 empty
      dp[0][i2] = i2;
    }
    for (int i1 = 1; i1 <= m; i1++) {
      for (int i2 = 1; i2 <= n; i2++) {
        if (word1.charAt(i1 - 1) == word2.charAt(i2 - 1)) {
          dp[i1][i2] = dp[i1 - 1][i2 - 1];
        } else {
          int delete = dp[i1 - 1][i2];
          int insert = dp[i1][i2 - 1];
          int replace = dp[i1 - 1][i2 - 1];
          dp[i1][i2] = 1 + Util.min3Elem(delete, insert, replace);
        }
      }
    }
    return dp[m][n];
  }
}
