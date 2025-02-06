package lc.general.easy;

public class PalindromePermutation_266 {

    public boolean canPermutePalindrome(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean isFoundOdd = false;
        for (int n : count) {
            if (n % 2 != 0 && isFoundOdd) {
                return false;
            } else if (n % 2 != 0) {
                isFoundOdd = true;
            }
        }
        return true;
    }

}
