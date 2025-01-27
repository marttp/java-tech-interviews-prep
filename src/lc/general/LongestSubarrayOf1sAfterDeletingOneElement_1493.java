package lc.general;

public class LongestSubarrayOf1sAfterDeletingOneElement_1493 {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int longest = 0;
        boolean isDelete = false;
        boolean isFoundZero = false;
        while (right < nums.length) {
            int rn = nums[right++];
            if (rn == 0) {
                isFoundZero = true;
                while (isDelete) {
                    int ln = nums[left];
                    if (ln == 0) {
                        isDelete = false;
                    }
                    left++;
                }
                isDelete = true;
            }
            longest = Integer.max(longest, right - left);
        }
        return longest - 1;
    }
}
