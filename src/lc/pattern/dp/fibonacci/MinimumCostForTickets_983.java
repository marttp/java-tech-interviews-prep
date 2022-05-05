package lc.pattern.dp.fibonacci;

public class MinimumCostForTickets_983 {

  public int mincostTickets(int[] days, int[] costs) {
    int lastDay = days[days.length - 1];
    int[] dp = new int[lastDay + 1];
    boolean[] isTravelDay = new boolean[lastDay + 1];
    for (int d : days) {
      isTravelDay[d] = true;
    }

    for (int i = 1; i <= lastDay; i++) {
      if (isTravelDay[i]) {
        // Take 1-Day pass
        dp[i] = costs[0] + dp[i - 1];
        // Take 7-Day Pass (compare with current day that compute before)
        dp[i] = Math.min(dp[i], costs[1] + dp[Math.max(i - 7, 0)]);
        // Take 30-Day Pass
        dp[i] = Math.min(dp[i], costs[2] + dp[Math.max(i - 30, 0)]);
      } else {
        dp[i] = dp[i - 1];
      }
    }

    return dp[lastDay];
  }
}
