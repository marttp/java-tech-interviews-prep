package lc.blind75.medium;

public class HouseRobberII_213 {

  public int rob(int[] nums) {
    // House planning as cycle
    if (nums.length == 1) {
      return nums[0];
    }
    int plan1 = helper(nums, 0, nums.length - 2);
    int plan2 = helper(nums, 1, nums.length - 1);
    return Integer.max(plan1, plan2);
  }

  private int helper(int[] nums, int start, int end) {
    int rob1 = 0;
    int rob2 = 0;
    for (int i = start; i <= end; i++) {
      int newRob = Integer.max(rob2, rob1 + nums[i]);
      rob1 = rob2;
      rob2 = newRob;
    }
    return rob2;
  }
}
