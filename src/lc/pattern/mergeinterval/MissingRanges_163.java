package lc.pattern.mergeinterval;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(List.of(lower, upper));
            return result;
        }
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && Math.abs(nums[i] - nums[i - 1]) > 1) {
                result.add(List.of(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[0] > lower) {
            result.add(0, List.of(lower, nums[0] - 1));
        }
        if (nums[n - 1] < upper) {
            result.add(List.of(nums[n - 1] + 1, upper));
        }
        return result;
    }
}
