package lc.pattern.backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString_1980 {
    public String findDifferentBinaryString(String[] nums) {
        Set<String> numsSet = new HashSet<>(Arrays.asList(nums));
        int n = nums.length;
        Set<String> generateResult = new HashSet<>();
        backtracking(new StringBuilder(), n, generateResult);
        for (String s : generateResult) {
            if (!numsSet.contains(s)) {
                return s;
            }
        }
        return "";
    }

    private void backtracking(StringBuilder curr, int n, Set<String> result) {
        if (curr.length() == n) {
            result.add(curr.toString());
            return;
        }
        curr.append('0');
        backtracking(curr, n, result);
        curr.deleteCharAt(curr.length() - 1);

        curr.append('1');
        backtracking(curr, n, result);
        curr.deleteCharAt(curr.length() - 1);
    }
}
