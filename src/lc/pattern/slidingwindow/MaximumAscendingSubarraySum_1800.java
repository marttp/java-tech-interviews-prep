package lc.pattern.slidingwindow;

public class MaximumAscendingSubarraySum_1800 {

    public int maxAscendingSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int left = 0;
        int right = 1;
        int maxSum = nums[0];
        int sum = nums[0];
        while (right < nums.length) {
            sum += nums[right];
            while (left < right && nums[right] <= nums[right - 1]) {
                sum -= nums[left++];
            }
            right++;
            maxSum = Integer.max(maxSum, sum);
        }
        return maxSum;
    }

}
