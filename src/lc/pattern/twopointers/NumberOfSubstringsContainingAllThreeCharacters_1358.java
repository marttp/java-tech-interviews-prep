package lc.pattern.twopointers;

public class NumberOfSubstringsContainingAllThreeCharacters_1358 {

    public int numberOfSubstrings(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int left = 0;
        int right = 0;
        int[] count = new int[3];
        while (right < chars.length) {
            char cr = chars[right++];
            count[cr - 'a']++;
            while (hasAllThreeChars(count)) {
                char cl = chars[left++];
                count[cl - 'a']--;
            }
            result += left;
        }
        return result;
    }

    private boolean hasAllThreeChars(int[] count) {
        return count[0] > 0 && count[1] > 0 && count[2] > 0;
    }
}
