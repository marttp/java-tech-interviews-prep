package lc.blind75.easy;

public class CountingBits_338 {

  public int[] countBits(int n) {
    int[] result = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      int count = 0;
      int num = i;
      while (num != 0) {
        // Hamming weight
        num = (num & (num - 1));
        count++;
      }
      result[i] = count;
    }
    return result;
  }
}
