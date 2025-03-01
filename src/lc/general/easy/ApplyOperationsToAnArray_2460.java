package lc.general.easy;

public class ApplyOperationsToAnArray_2460 {

    public int[] applyOperations(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i - 1] = nums[i - 1] * 2;
                nums[i] = 0;
            }
        }
        shiftZero(nums);
        return nums;
    }

    public void shiftZero(int[] nums) {
        int read = 0;
        int write = 0;
        while (read < nums.length) {
            if (nums[read] != 0) {
                nums[write++] = nums[read];
            }
            read++;
        }
        while (write < nums.length) {
            nums[write++] = 0;
        }
    }

}
