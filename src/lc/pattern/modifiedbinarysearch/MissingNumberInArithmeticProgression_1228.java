package lc.pattern.modifiedbinarysearch;

public class MissingNumberInArithmeticProgression_1228 {
    public int missingNumber(int[] arr) {
        if (arr.length == 3) {
            int diff = arr[2] - arr[1];
            return arr[0] + diff;
        }
        int n = arr.length;
        int diff = (arr[n - 1] - arr[0]) / n;
        int left = 0;
        int right = n - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == arr[0] + mid * diff) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return arr[0] + diff * left;
    }
}
