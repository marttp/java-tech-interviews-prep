package lc.blind75.medium;

public class DecodeWays_91 {

  public int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    // s contains only digits and may contain leading zero(s).
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;

    for (int i = 2; i <= s.length(); i++) {
      if (s.charAt(i - 1) != '0') {
        dp[i] += dp[i - 1];
      }
      int twoDigit = Integer.parseInt(s.substring(i - 2, i));
      if (twoDigit >= 10 && twoDigit <= 26) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length()];
  }
}
