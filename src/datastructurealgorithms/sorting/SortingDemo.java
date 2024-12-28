package datastructurealgorithms.sorting;

import utility.Util;

import java.util.Arrays;
import java.util.List;

public class SortingDemo {

    public static void main(String[] args) {
        var array = Util.listToIntArray(List.of(26, 8, 54, 37, 12, 78));
        // Quadratic Time Complexity
        insertionSortExample(cloneArray(array));
        selectionSortExample(cloneArray(array));
        bubbleSortExample(cloneArray(array));
        // Linear Logarithm Time Complexity
        quickSortExample(cloneArray(array));
        mergeSortExample(cloneArray(array));
    }

    private static int[] cloneArray(int[] array) {
        return Arrays.copyOfRange(array, 0, array.length);
    }

    private static void insertionSortExample(int[] array) {
        for (int i = 1; i < array.length; i++) {
            var j = i;
            while (j > 0 && array[j] < array[j - 1]) {
                Util.swap(array, j, j - 1);
                j--;
            }
        }
        System.out.println("Insertion sort result: " + Arrays.toString(array));
    }

    private static void selectionSortExample(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            // Searching for largest value
            int largestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (array[j] > array[largestIndex]) {
                    largestIndex = j;
                }
            }
            Util.swap(array, i, largestIndex);
        }
        System.out.println("Selection sort result: " + Arrays.toString(array));
    }

    private static void bubbleSortExample(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            // i => consideration index
            // j => bubble value
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    Util.swap(array, j, j + 1);
                }
            }
        }
        System.out.println("Bubble sort result: " + Arrays.toString(array));
    }

    private static void quickSortExample(int[] array) {
        quickSort(array, 0, array.length - 1);
        System.out.println("Quick sort result: " + Arrays.toString(array));
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int partitionIndex = findPartition(array, left, right);
            // Left
            quickSort(array, left, partitionIndex - 1);
            // Right
            quickSort(array, partitionIndex + 1, right);
        }
    }

    private static int findPartition(int[] array, int left, int right) {
        int pivotIndex = left;
        int leftPointer = pivotIndex + 1;
        int rightPointer = right;
        // Do until it's cross
        while (leftPointer <= rightPointer) {
            while (leftPointer <= rightPointer && array[leftPointer] < array[pivotIndex]) {
                leftPointer++;
            }
            while (leftPointer <= rightPointer && array[rightPointer] > array[pivotIndex]) {
                rightPointer--;
            }
            if (leftPointer <= rightPointer) {
                Util.swap(array, leftPointer, rightPointer);
            }
        }
        Util.swap(array, pivotIndex, rightPointer);
        return rightPointer;
    }

    private static void mergeSortExample(int[] array) {
        mergeSort(array);
        System.out.println("Merge sort result: " + Arrays.toString(array));
    }

    private static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;
            int[] leftArray = Arrays.copyOfRange(array, 0, mid);
            int[] rightArray = Arrays.copyOfRange(array, mid, array.length);
            // Divide to 2 sides
            mergeSort(leftArray);
            mergeSort(rightArray);

            int left = 0;
            int right = 0;
            int writer = 0;

            while (left < leftArray.length && right < rightArray.length) {
                if (leftArray[left] < rightArray[right]) {
                    array[writer] = leftArray[left];
                    left++;
                } else {
                    array[writer] = rightArray[right];
                    right++;
                }
                writer++;
            }

            // Check if left still available
            while (left < leftArray.length) {
                array[writer++] = leftArray[left++];
            }

            // Check if right still available
            while (right < rightArray.length) {
                array[writer++] = rightArray[right++];
            }
        }
    }
}
