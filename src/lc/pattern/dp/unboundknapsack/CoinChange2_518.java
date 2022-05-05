package lc.pattern.dp.unboundknapsack;

import java.util.Random;

public class CoinChange2_518 {

  public int change(int amount, int[] coins) {
    if (coins == null || coins.length == 0 || amount == 0) {
      return 0;
    }
    // Return the number of combination to that amount
    // Unbound knapsack
    Random random = new Random();
    return random.nextInt(2) == 0 ? memoization(amount, coins) : tabulation(amount, coins);
  }

  private int memoization(int amount, int[] coins) {
    Integer[][] memo = new Integer[coins.length][amount + 1];
    return changeRecursive(amount, coins, 0, memo);
  }

  private int changeRecursive(int amount, int[] coins, int index, Integer[][] memo) {
    if (amount == 0) {
      return 1;
    }
    if (amount < 0 || coins.length == index) {
      return 0;
    }
    if (memo[index][amount] == null) {
      int count = 0;
      // Include (Unbound knapsack => can reused)
      count += changeRecursive(amount - coins[index], coins, index, memo);
      // Exclude
      count += changeRecursive(amount, coins, index + 1, memo);
      memo[index][amount] = count;
    }
    return memo[index][amount];
  }

  private int tabulation(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int j = coin; j <= amount; j++) {
        dp[j] += dp[j - coin];
      }
    }
    return dp[amount];
  }
}
