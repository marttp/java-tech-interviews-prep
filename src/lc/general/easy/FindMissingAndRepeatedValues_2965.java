package lc.general.easy;

public class FindMissingAndRepeatedValues_2965 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] count = new int[size + 1];
        for (var row : grid) {
            for (var num : row) {
                count[num]++;
            }
        }

        int[] result = {0, 0};
        for (int i = 1; i <= size; i++) {
            if (count[i] == 0) {
                result[1] = i;
            } else if (count[i] > 1) {
                result[0] = i;
            }
        }
        return result;
    }
}
