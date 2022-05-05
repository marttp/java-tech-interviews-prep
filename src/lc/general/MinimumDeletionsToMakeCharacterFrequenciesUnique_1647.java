package lc.general;

import constant.StringConstant;
import java.util.HashSet;
import java.util.Set;
import utility.Util;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique_1647 {

  public int minDeletions(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int[] freq = new int[StringConstant.LOWERCASE_AMOUNT];
    for (char c : s.toCharArray()) {
      freq[Util.getLowercaseIndex(c)]++;
    }

    Set<Integer> countSet = new HashSet<>();
    int result = 0;
    for (int n : freq) {
      int curr = n;
      while (curr > 0 && !countSet.add(curr)) {
        curr--;
        result++;
      }
    }
    return result;
  }
}
