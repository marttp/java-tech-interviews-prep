package datastructurealgorithms.bigo;

public class LogNTime {

    public static int binarySearch(int[] array, int x) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (x < array[mid]) {
                right = mid - 1;
            } else if (x > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
