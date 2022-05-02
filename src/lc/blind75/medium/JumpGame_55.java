package lc.blind75.medium;

public class JumpGame_55 {

  public boolean canJump(int[] nums) {
    int furthest = 0;
    int lastIndex = nums.length - 1;
    for (int i = 0; i <= furthest && i < lastIndex; i++) {
      furthest = Integer.max(furthest, i + nums[i]);
    }
    return furthest >= lastIndex;
  }
}
