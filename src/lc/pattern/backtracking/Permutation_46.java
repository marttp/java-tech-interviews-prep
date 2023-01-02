package lc.pattern.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation_46 {
    public List<List<Integer>> permute(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] isUsed = new boolean[nums.length];
        backtracking(nums, new LinkedList<>(), result, isUsed);
        return result;
    }

    private void backtracking(int[] nums, LinkedList<Integer> tmpList,
                              List<List<Integer>> result, boolean[] isUsed) {
        if (tmpList.size() == nums.length) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            isUsed[i] = true;
            tmpList.add(nums[i]);
            backtracking(nums, tmpList, result, isUsed);
            isUsed[i] = false;
            tmpList.pollLast();
        }
    }
}