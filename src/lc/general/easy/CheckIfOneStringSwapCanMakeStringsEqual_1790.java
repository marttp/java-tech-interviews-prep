package lc.general.easy;

import java.util.ArrayList;
import java.util.List;

public class CheckIfOneStringSwapCanMakeStringsEqual_1790 {

    class Solution1 {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            } else if (s1.equals(s2)) {
                return true;
            }
            int n = s1.length();
            int mismatchCount = 0;
            int[] counter = new int[26];
            for (int i = 0; i < n; i++) {
                char c1 = s1.charAt(i);
                counter[c1 - 'a']++;
                char c2 = s2.charAt(i);
                counter[c2 - 'a']--;
                if (c1 != c2) {
                    mismatchCount++;
                }
            }
            if (mismatchCount > 2) {
                return false;
            }
            for (int amount : counter) {
                if (amount != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    class Solution2 {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.length() != s2.length()) {
                return false;
            }
            List<Integer> mismatches = new ArrayList<>();
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    mismatches.add(i);
                }
            }
            if (mismatches.isEmpty()) {
                return true;
            }
            if (mismatches.size() != 2) {
                return false;
            }
            int i = mismatches.get(0);
            int j = mismatches.get(1);
            return s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i);
        }
    }

}
