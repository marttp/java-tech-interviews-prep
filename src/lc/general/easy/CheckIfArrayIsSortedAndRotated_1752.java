package lc.general.easy;

public class CheckIfArrayIsSortedAndRotated_1752 {
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Check if sorted and rotated => Module to check on first element
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        return count <= 1;
    }
}
