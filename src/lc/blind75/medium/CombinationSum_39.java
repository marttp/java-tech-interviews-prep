package lc.blind75.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum_39 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> result = new ArrayList<>();
    backtracking(candidates, target, 0, result, new LinkedList<>());
    return result;
  }

  private void backtracking(int[] candidates, int target, int index,
      List<List<Integer>> result, LinkedList<Integer> tmpList) {
    if (index == candidates.length) {
      return;
    }
    if (target == 0) {
      result.add(new ArrayList<>(tmpList));
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      if (target - candidates[i] < 0) {
        continue;
      }
      tmpList.add(candidates[i]);
      // We can reuse current index number
      backtracking(candidates, target - candidates[i], i, result, tmpList);
      tmpList.pollLast();
    }
  }
}
