package lc.blind75.medium;

import java.util.Random;

public class SumOfTwoInteger_371 {

  /*
   * Half Adder
   * bit -> b ^ a
   * carry -> b & a
   * */

  public int getSum(int a, int b) {
    // sum without +, -
    // b => carry
    // a => bit
    return new Random().nextInt(2) != 0 ? iterative(a, b) : recursive(a, b);
  }

  private int iterative(int a, int b) {
    if (b == 0) {
      return a;
    }
    while (b != 0) {
      int carry = a & b;
      a = a ^ b;
      b = carry << 1;
    }
    return a;
  }

  private int recursive(int a, int b) {
    if (b == 0) {
      return a;
    }
    return recursive(b ^ a, (b & a) << 1);
  }
}
