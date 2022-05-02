package additional;

import java.util.List;
import utility.Util;

public class RotateArray {

  /*
   * Rotate Amount = 3
   * example: [0,1,2,3,4,5] => [3,4,5,0,1,2]
   * 1. [0,1,2,3,4,5]
   * 2. [5,4,3,2,1,0] (reverse all)
   * 3. [3,4,5,2,1,0] (reverse first half)
   * 4. [3,4,5,0,1,2] (reverse second half)
   * */
  public void rotateArray(int rotateAmount, List<Integer> A) {
    rotateAmount %= A.size();
    // reverse all
    Util.reverse(A, 0, A.size() - 1);
    // reverse only first part of rotate
    Util.reverse(A, 0, rotateAmount - 1);
    // reverse second half of rotate
    Util.reverse(A, rotateAmount, A.size() - 1);
  }

  public void rotateArray(int rotateAmount, int[] A) {
    rotateAmount %= A.length;
    Util.reverse(A, 0, A.length - 1);
    Util.reverse(A, 0, rotateAmount - 1);
    Util.reverse(A, rotateAmount, A.length - 1);
  }
}
