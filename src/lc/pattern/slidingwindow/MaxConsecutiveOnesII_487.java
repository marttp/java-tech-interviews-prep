package lc.pattern.slidingwindow;

public class MaxConsecutiveOnesII_487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int longest = 0;
        int zeroCount = 0;
        while (right < nums.length) {
            int rn = nums[right++];
            zeroCount += rn == 0 ? 1 : 0;
            while (zeroCount > 1) {
                int ln = nums[left++];
                zeroCount -= ln == 0 ? 1 : 0;
            }
            longest = Integer.max(longest, right - left);
        }
        return longest;
    }
}
