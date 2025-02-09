package lc.pattern.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters_159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char rc = s.charAt(right++);
            map.put(rc, map.getOrDefault(rc, 0) + 1);
            while (left < right && map.size() > 2) {
                char lc = s.charAt(left++);
                map.put(lc, map.get(lc) - 1);
                if (map.get(lc) == 0) {
                    map.remove(lc);
                }
            }
            longest = Integer.max(longest, right - left);
        }
        return longest;
    }

}
