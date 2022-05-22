package datastructurealgorithms.sorting;

import utility.Util;

public class QuickSort {

  public static int[] sorted(int[] array) {
    quickSort(array, 0, array.length - 1);
    return array;
  }

  private static void quickSort(int[] array, int left, int right) {
    int partitionIndex = partition(array, left, right);
    if (left < partitionIndex - 1) {
      quickSort(array, left, partitionIndex - 1);
    }
    if (partitionIndex < right) {
      quickSort(array, partitionIndex, right);
    }
  }

  private static int partition(int[] array, int left, int right) {
    int pivotIndex = left + (right - left) / 2;
    int pivotData = array[pivotIndex];
    while (left <= right) {
      while (array[left] < pivotData) {
        left++;
      }
      while (array[right] > pivotData) {
        right--;
      }
      if (left <= right) {
        Util.swap(array, left++, right--);
      }
    }
    return left;
  }
}
