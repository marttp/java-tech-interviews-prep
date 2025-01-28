package lc.general;

public class MaximumNumberOfFishInAGrid_2658 {

    private static final int[][] DIRS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int findMaxFish(int[][] grid) {
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                int totalFish = catchFish(r, c, grid);
                if (ans < totalFish) {
                    ans = totalFish;
                }
            }
        }
        return ans;
    }

    private int catchFish(int r, int c, int[][] grid) {
        // Out or Land
        if (!isInbound(r, c, grid) || grid[r][c] == 0) {
            return 0;
        }
        // Take and assume land to prevent re-visit
        int totalFish = grid[r][c];
        grid[r][c] = 0;
        for (var dir : DIRS) {
            totalFish += catchFish(r + dir[0], c + dir[1], grid);
        }
        return totalFish;
    }

    private boolean isInbound(int r, int c, int[][] grid) {
        return r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    }

}
