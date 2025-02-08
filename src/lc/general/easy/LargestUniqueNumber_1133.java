package lc.general.easy;

public class LargestUniqueNumber_1133 {
    public int largestUniqueNumber(int[] nums) {
        int[] count = new int[2001];
        for (int n : nums) {
            count[n]++;
        }
        for (int i = 2000; i >= 0; i--) {
            if (count[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
