package lc.general;

public class PalindromeNumber_9 {

    public boolean isPalindrome1(int x) {
        String num = String.valueOf(x);
        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            if (num.charAt(left) != num.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int num = x;
        int newValue = 0;
        while (num != 0) {
            int digit = num % 10;
            newValue = newValue * 10 + digit;
            num /= 10;
        }
        return newValue == x;
    }
}
