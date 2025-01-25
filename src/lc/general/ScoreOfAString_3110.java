package lc.general;

public class ScoreOfAString_3110 {
    public int scoreOfString(String s) {
        int sum = 0;
        for (int i = 1; i < s.length(); i++) {
            sum += Math.abs((int) s.charAt(i) - (int) s.charAt(i - 1));
        }
        return sum;
    }
}
