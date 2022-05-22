package datastructurealgorithms.sorting;

import utility.Util;

public class SelectionSort {

  public static int[] sorted(int[] array) {
    for (int i = array.length - 1; i >= 0; i--) {
      int largestIndex = 0;
      for (int j = 0; j <= i; j++) {
        if (array[j] > array[largestIndex]) {
          largestIndex = j;
        }
      }
      Util.swap(array, i, largestIndex);
    }
    return array;
  }
}
