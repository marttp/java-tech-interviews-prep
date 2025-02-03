package lc.general.easy;

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray_3105 {

    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int longest = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j - 1] >= nums[j]) {
                    break;
                }
                longest = Integer.max(longest, j - i + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j - 1] <= nums[j]) {
                    break;
                }
                longest = Integer.max(longest, j - i + 1);
            }
        }
        return longest;
    }

}
