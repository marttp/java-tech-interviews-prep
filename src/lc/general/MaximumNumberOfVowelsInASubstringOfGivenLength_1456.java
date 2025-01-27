package lc.general;

public class MaximumNumberOfVowelsInASubstringOfGivenLength_1456 {

    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int maxVowelsInLength = 0;
        int[] counter = new int[26];
        while (right < s.length()) {
            char rc = s.charAt(right++);
            counter[rc - 'a']++;
            if (right - left == k) {
                maxVowelsInLength = Integer.max(
                        maxVowelsInLength,
                        countVowels(counter)
                );
                char lc = s.charAt(left++);
                counter[lc - 'a']--;
            }
        }
        return maxVowelsInLength;
    }

    private int countVowels(int[] counter) {
        return counter['a' - 'a'] +
                counter['e' - 'a'] +
                counter['i' - 'a'] +
                counter['o' - 'a'] +
                counter['u' - 'a'];
    }
}
