package lc.general;

import java.util.Arrays;

public class EqualRowAndColumnPairs_2352 {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int[][] cols = new int[n][n];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                cols[c][r] = grid[r][c];
            }
        }

        int count = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (Arrays.equals(grid[r], cols[c])) {
                    count++;
                }
            }
        }
        return count;
    }

}
