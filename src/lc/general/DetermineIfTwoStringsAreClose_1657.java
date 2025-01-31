package lc.general;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose_1657 {

    public boolean closeStrings(String word1, String word2) {
        if (word1 == null || word2 == null || word1.length() != word2.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        if (Arrays.equals(count1, count2)) {
            return true;
        }
        return checkOccurrence(count1, count2);
    }

    private boolean checkOccurrence(int[] count1, int[] count2) {
        for (char c = 'a'; c <= 'z'; c++) {
            if (count1[c - 'a'] != 0 && count2[c - 'a'] == 0) {
                return false;
            }
        }
        Arrays.sort(count1);
        Arrays.sort(count2);
        return Arrays.equals(count1, count2);
    }

}
