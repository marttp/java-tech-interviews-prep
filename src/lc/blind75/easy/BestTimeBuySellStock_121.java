package lc.blind75.easy;

public class BestTimeBuySellStock_121 {

  public int maxProfit(int[] prices) {
    int profit = 0;
    int minSoFar = Integer.MAX_VALUE;
    for (int p : prices) {
      profit = Integer.max(profit, p - minSoFar);
      minSoFar = Integer.min(minSoFar, p);
    }
    return profit;
  }

}
