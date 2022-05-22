package datastructurealgorithms.sorting;

public class MergeSort {

  public static int[] sorted(int[] array) {
    // Create helper array
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length - 1);
    return array;
  }

  private static void mergeSort(int[] array, int[] helper, int start, int end) {
    if (start < end) {
      int mid = start + (end - start) / 2;
      mergeSort(array, helper, start, mid);
      mergeSort(array, helper, mid + 1, end);
      merge(array, helper, start, mid, end);
    }
  }

  private static void merge(int[] array, int[] helper, int start, int mid, int end) {
    // Copy to helper
    for (int i = start; i <= end; i++) {
      helper[i] = array[i];
    }
    // Places 2 pointers
    int helperLeft = start;
    int writeIndex = start;
    int helperRight = mid + 1;

    while (helperLeft <= mid && helperRight <= end) {
      if (helper[helperLeft] <= helper[helperRight]) {
        array[writeIndex] = helper[helperLeft++];
      } else {
        array[writeIndex] = helper[helperRight++];
      }
      writeIndex++;
    }

    int remaining = mid - helperLeft;
    for (int i = 0; i <= remaining; i++) {
      array[writeIndex++] = helper[helperLeft++];
    }
  }
}
