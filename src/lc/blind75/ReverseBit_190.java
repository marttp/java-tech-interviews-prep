package lc.blind75;

public class ReverseBit_190 {

  public int reverseBits(int n) {
    int result = 0;
    int bit = 31;
    /*
     * Example 1: 0000 0000 0000 0000 0000 0000 0001 0010
     * => 0100 1000 0000 0000 0000 0000 0000 0000
     * */
    while (n != 0) {
      result += (n & 1) << bit;
      n >>= 1;
      bit--;
    }
    return result;
  }
}
