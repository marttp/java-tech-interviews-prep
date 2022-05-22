package lc.pattern.dp.palindromicsubseq;

public class CountOfPalindromeSubstring {

  public static class BottomUp {

    public int findCPS(String st) {
      int size = st.length();
      boolean[][] dp = new boolean[size][size];
      int count = 0;
      for (int i = 0; i < size; i++) {
        dp[i][i] = true;
        count++;
      }
      for (int startIndex = size - 1; startIndex >= 0; startIndex--) {
        for (int endIndex = startIndex + 1; endIndex < size; endIndex++) {
          if (endIndex - startIndex == 1 || dp[startIndex + 1][endIndex - 1]) {
            dp[startIndex][endIndex] = true;
            count++;
          }
        }
      }
      return count;
    }
  }
}
