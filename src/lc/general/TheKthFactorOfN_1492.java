package lc.general;

public class TheKthFactorOfN_1492 {

  public int kthFactor(int n, int k) {
    for (int i = 1; i <= n; i++) {
      // Factor หรือตัวประกอบ
      // คือตัวที่มันจะหารลงตัว (n % factor == 0)
      if (n % i == 0) {
        k--;
        if (k == 0) {
          return i;
        }
      }
    }
    return -1;
  }
}
