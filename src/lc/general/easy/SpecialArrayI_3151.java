package lc.general.easy;

public class SpecialArrayI_3151 {

    public boolean isArraySpecial(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        for (int i = 1; i < nums.length; i++) {
            boolean isCurrEven = nums[i] % 2 == 0;
            if ((isCurrEven && nums[i - 1] % 2 == 0) || (!isCurrEven && nums[i - 1] % 2 != 0)) {
                return false;
            }
        }
        return true;
    }
}
