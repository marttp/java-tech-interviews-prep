package lc.pattern.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, new LinkedList<>(), result);
        return result;
    }

    private void backtracking(int[] nums, int currIndex,
                              LinkedList<Integer> tmpList, List<List<Integer>> result) {
        result.add(new ArrayList<>(tmpList));
        for (int i = currIndex; i < nums.length; i++) {
            tmpList.add(nums[i]);
            backtracking(nums, i + 1, tmpList, result);
            tmpList.pollLast();
        }
    }
}
