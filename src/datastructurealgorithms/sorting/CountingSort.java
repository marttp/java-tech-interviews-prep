package datastructurealgorithms.sorting;

public class CountingSort {

  // Assume possible elements is in range 0 - 99
  public static int[] sorted(int[] array) {
    int size = array.length;
    int[] counter = new int[100];
    for (int n : array) {
      counter[n]++;
    }

    int writeIndex = 0;
    int[] result = new int[size];
    for (int i = 0; i < counter.length; i++) {
      int n = counter[i];
      while (n-- > 0) {
        result[writeIndex++] = i;
      }
    }

    return result;
  }
}
