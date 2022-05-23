package lc.pattern.dp.lcs;

import java.util.List;

public class MinDeleteInsertToTransformToAnotherString {

  public List<Integer> findMDI(String s1, String s2) {
    int longestCommonSubsequenceResult = new LongestCommonSubsequence
        .BottomUp()
        .findLCSLength(s1, s2);
    int s1To2 = s1.length() - longestCommonSubsequenceResult;
    int s2To1 = s2.length() - longestCommonSubsequenceResult;
    return List.of(s1To2, s2To1);
  }
}
