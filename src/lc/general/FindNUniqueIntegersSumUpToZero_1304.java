package lc.general;

public class FindNUniqueIntegersSumUpToZero_1304 {

  public int[] sumZero(int n) {
    int left = 0;
    int right = n - 1; // if only one element => 1 - 1 => 0 => result is new int[] { 0 };
    int[] result = new int[n];
    int value = 1;

    while (left < right) {
      result[left++] = value;
      result[right--] = -value;
      value++;
    }

    return result;
  }
}
