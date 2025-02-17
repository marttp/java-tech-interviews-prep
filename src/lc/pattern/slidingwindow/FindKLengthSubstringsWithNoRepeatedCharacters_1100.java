package lc.pattern.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class FindKLengthSubstringsWithNoRepeatedCharacters_1100 {

    public int numKLenSubstrNoRepeats(String s, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            char cr = s.charAt(right++);
            while (!set.isEmpty() && set.contains(cr)) {
                char cl = s.charAt(left++);
                set.remove(cl);
            }
            set.add(cr);
            if (right - left >= k) {
                count++;
            }
        }
        return count;
    }

}
