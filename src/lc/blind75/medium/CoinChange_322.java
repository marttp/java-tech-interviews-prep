package lc.blind75.medium;

import java.util.Arrays;
import java.util.Random;

public class CoinChange_322 {

  public int coinChange(int[] coins, int amount) {
    if (coins == null || coins.length == 0 || amount == 0) {
      return 0;
    }
    // Return the fewest number of coins
    Random random = new Random();
    return switch (random.nextInt(3)) {
      case 0 -> memoization(coins, amount);
      case 1 -> tabulation(coins, amount);
      default -> tabulationOptimize(coins, amount);
    };
  }

  private int memoization(int[] coins, int amount) {
    Integer[][] memo = new Integer[coins.length][amount + 1];
    int result = coinChangeRecursive(coins, amount, 0, memo);
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private int coinChangeRecursive(int[] coins, int amount, int index, Integer[][] memo) {
    if (amount == 0) {
      return 0;
    }
    if (coins.length == index || amount < 0) {
      return Integer.MAX_VALUE;
    }
    if (memo[index][amount] == null) {
      int include = Integer.MAX_VALUE;
      // current coin can be deducted from all amount
      if (coins[index] <= amount) {
        int selected = coinChangeRecursive(coins, amount - coins[index], index, memo);
        if (selected != Integer.MAX_VALUE) {
          include = selected + 1;
        }
      }
      int exclude = coinChangeRecursive(coins, amount, index + 1, memo);
      memo[index][amount] = Integer.min(include, exclude);
    }
    return memo[index][amount];
  }

  private int tabulation(int[] coins, int amount) {
    int[][] dp = new int[coins.length][amount + 1];
    // Fill MAX_VALUE in the default case
    for (int[] row : dp) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    for (int i = 0; i < coins.length; i++) {
      // amount == 0
      dp[i][0] = 0;
    }
    for (int i = 0; i < coins.length; i++) {
      for (int j = 0; j <= amount; j++) {
        // Exclude
        if (i > 0) {
          dp[i][j] = dp[i - 1][j];
        }
        if (coins[i] <= j) {
          int prev = dp[i][j - coins[i]];
          if (prev != Integer.MAX_VALUE) {
            dp[i][j] = Integer.min(dp[i][j], 1 + prev);
          }
        }
      }
    }
    int result = dp[coins.length - 1][amount];
    return result == Integer.MAX_VALUE ? -1 : result;
  }

  private int tabulationOptimize(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    for (int coin : coins) {
      // Start from the coin value
      for (int j = coin; j <= amount; j++) {
        dp[j] = Integer.min(dp[j], 1 + dp[j - coin]);
      }
    }
    return dp[amount] > amount ? -1 : dp[amount];
  }
}
