package lc.general;

public class MaxConsecutiveOnesIII_1004 {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int longest = 0;
        int zero = k;
        while (right < nums.length) {
            int current = nums[right++];
            if (current == 0) {
                zero--;
                while (left < nums.length && zero < 0) {
                    int ln = nums[left];
                    if (ln == 0) {
                        zero++;
                    }
                    left++;
                }
            }
            longest = Integer.max(longest, right - left);
        }
        return longest;
    }
}
