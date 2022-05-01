package lc.blind75.easy;

public class ClimbingStairs_70 {

  public int climbStairs(int n) {
    int[] memo = new int[n + 1];
    return climbStairsRecursive(n, memo);
  }

  public int climbStairsRecursive(int n, int[] memo) {
    if (n <= 1) {
      return 1;
    }
    if (memo[n] == 0) {
      int take1Step = climbStairsRecursive(n - 1, memo);
      int take2Step = climbStairsRecursive(n - 2, memo);
      memo[n] = take1Step + take2Step;
    }
    return memo[n];
  }

  public int climbStairsIterative(int n) {
    if (n <= 1) {
      return 1;
    }
    int n1 = 1; // start from 0
    int n2 = 1; // start from 1
    for (int i = 2; i <= n; i++) {
      int result = n1 + n2;
      n1 = n2;
      n2 = result;
    }
    return n2;
  }
}
