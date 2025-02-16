package lc.general.medium;

public class ConstructTheLexicographicallyLargestValidSequence_1718 {

    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        backtrack(result, used, 0, n);
        return result;
    }

    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        if (index == result.length) {
            return true;
        }
        if (result[index] != 0) {
            return backtrack(result, used, index + 1, n);
        }

        for (int i = n; i >= 1; i--) {
            if (used[i]) {
                continue;
            }
            if (i == 1) {
                result[index] = 1;
                used[1] = true;
                if (backtrack(result, used, index + 1, n)) {
                    return true;
                }
                result[index] = 0;
                used[1] = false;
            } else if (index + i < result.length && result[index + i] == 0) {
                result[index] = i;
                result[index + i] = i;
                used[i] = true;
                if (backtrack(result, used, index + 1, n)) {
                    return true;
                }
                result[index] = 0;
                result[index + i] = 0;
                used[i] = false;
            }
        }
        return false;
    }


}
