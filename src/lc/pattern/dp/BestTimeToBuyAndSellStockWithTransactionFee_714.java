package lc.pattern.dp;

public class BestTimeToBuyAndSellStockWithTransactionFee_714 {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] free = new int[n];
        hold[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            hold[i] = Integer.max(hold[i - 1], free[i - 1] - prices[i]);
            free[i] = Integer.max(free[i - 1], hold[i - 1] + prices[i] - fee);
        }

        return free[n - 1];
    }
}
