package datastructurealgorithms.sorting;

import utility.Util;

public class BubbleSort {

  public static int[] sorted(int[] array) {
    for (int i = array.length - 1; i >= 0; i--) {
      // j < i that's mean even i is last element
      // j will not equals i => j + 1 valid
      for (int j = 0; j < i; j++) {
        if (array[j] > array[j + 1]) {
          Util.swap(array, j, j + 1);
        }
      }
    }
    return array;
  }
}
