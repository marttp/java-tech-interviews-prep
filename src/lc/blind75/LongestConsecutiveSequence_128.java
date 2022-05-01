package lc.blind75;

import static utility.Util.listToIntArray;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import utility.GenerateExample;

public class LongestConsecutiveSequence_128 implements GenerateExample {

  public int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 0;
    }
    Set<Integer> set = new HashSet<>();
    for (int n : nums) {
      set.add(n);
    }
    int longest = 1;
    for (int n : set) {
      // Skip if contains previous
      // We can start from their number instead in the future
      if (!set.contains(n - 1)) {
        int curr = n;
        int streak = 1;
        while (set.contains(curr + 1)) {
          curr++;
          streak++;
        }
        longest = Integer.max(longest, streak);
      }
    }
    return longest;
  }

  @Override
  public void example() {
    List<Integer> nums = List.of(0, 3, 7, 2, 5, 8, 4, 6, 0, 1);
    int result = longestConsecutive(listToIntArray(nums));
    System.out.printf("Result: " + result); // 9
  }
}
