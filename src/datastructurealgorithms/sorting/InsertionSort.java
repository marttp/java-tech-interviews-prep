package datastructurealgorithms.sorting;

import utility.Util;

public class InsertionSort {

  public static int[] sorted(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int j = i;
      while (j > 0 && array[j] < array[j - 1]) {
        Util.swap(array, j, j - 1);
        j--;
      }
    }
    return array;
  }
}
