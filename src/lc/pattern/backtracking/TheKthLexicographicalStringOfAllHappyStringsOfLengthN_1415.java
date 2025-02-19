package lc.pattern.backtracking;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN_1415 {

    public String getHappyString(int n, int k) {
        char[] possibleChars = {'a', 'b', 'c'};
        int[] counter = {k};
        StringBuilder kStr = new StringBuilder();
        dfs(new StringBuilder(), n, possibleChars, counter, kStr);
        if (counter[0] != 0) {
            return "";
        }
        return kStr.toString();
    }

    private void dfs(
            StringBuilder str,
            int n,
            char[] possibleChars,
            int[] counter,
            StringBuilder kStr
    ) {
        if (counter[0] == 0) {
            return;
        }
        if (str.length() == n) {
            kStr.setLength(0);
            kStr.append(str);
            counter[0]--;
            return;
        }
        for (char c : possibleChars) {
            if (str.isEmpty() || str.charAt(str.length() - 1) != c) {
                str.append(c);
                dfs(str, n, possibleChars, counter, kStr);
                str.deleteCharAt(str.length() - 1);
            }
        }
    }


}
