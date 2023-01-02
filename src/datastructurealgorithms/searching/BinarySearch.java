package datastructurealgorithms.searching;

public class BinarySearch {

    public static int iterative(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target < array[mid]) {
                right = mid - 1;
            } else if (target > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static int recursive(int[] array, int target) {
        return recursive(array, 0, array.length - 1, target);
    }

    private static int recursive(int[] array, int left, int right, int target) {
        int mid = left + (right - left) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (target < array[mid]) {
            return recursive(array, left, mid -  1, target);
        } else if (target > array[mid]) {
            return recursive(array, mid + 1, right, target);
        }
        return -1;
    }
}
