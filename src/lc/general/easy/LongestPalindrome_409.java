package lc.general.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {

    public int longestPalindrome(String s) {
        int length = 0;
        int addition = 0;

        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (var entry : countMap.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                length += entry.getValue();
            } else {
                length += entry.getValue() - 1;
                addition = 1;
            }
        }
        return length + addition;
    }

}
