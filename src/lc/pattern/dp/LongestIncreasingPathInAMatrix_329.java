package lc.pattern.dp;

public class LongestIncreasingPathInAMatrix_329 {

    private static final int[][] DIRS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        // Not always start from 1, can start from any place
        // as long as it's increasing
        int m = matrix.length;
        int n = matrix[0].length;
        int maxPath = 0;
        // Init DP by 0
        int[][] memo = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                maxPath = Math.max(maxPath, dfs(matrix, r, c, memo));
            }
        }
        return maxPath;
    }

    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        int increasePath = 1;
        for (int[] dir : DIRS) {
            int nextR = r + dir[0];
            int nextC = c + dir[1];
            if (isInbound(matrix, nextR, nextC) &&
                    matrix[nextR][nextC] > matrix[r][c]) {
                increasePath = Math.max(
                        increasePath,
                        1 + dfs(matrix, nextR, nextC, memo)
                );
            }
        }
        memo[r][c] = increasePath;
        return memo[r][c];
    }

    private boolean isInbound(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length &&
                c >= 0 && c < matrix[0].length;
    }

}
