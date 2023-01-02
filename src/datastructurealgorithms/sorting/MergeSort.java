package datastructurealgorithms.sorting;

import java.util.Arrays;

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

    private static void mergeSortArrayCopy(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] left = Arrays.copyOfRange(array, 0, mid);
            int[] right = Arrays.copyOfRange(array, mid, array.length);

            mergeSortArrayCopy(left);
            mergeSortArrayCopy(right);

            int i = 0;
            int j = 0;
            int k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] < right[j]) {
                    array[k] = left[i];
                    i++;
                } else {
                    array[k] = right[j];
                    j++;
                }

                k++;
            }

            while (i < left.length) {
                array[k] = left[i];
                i++;
                k++;
            }

            while (j < right.length) {
                array[k] = right[j];
                j++;
                k++;
            }
        }
    }

}
