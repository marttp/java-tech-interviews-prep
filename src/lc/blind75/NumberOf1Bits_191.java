package lc.blind75;

public class NumberOf1Bits_191 {

  public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
      n = (n & (n - 1));
      count++;
    }
    return count;
  }

  public int hammingWeightShortForUse(int n) {
    return Integer.bitCount(n);
  }
}
