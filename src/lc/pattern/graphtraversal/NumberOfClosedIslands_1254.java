package lc.pattern.graphtraversal;

import constant.GraphConstant;

public class NumberOfClosedIslands_1254 {

  private static final int LAND = 0;
  private static final int WATER = 1;

  public int closedIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int m = grid.length;
    int n = grid[0].length;
    // left-right
    for (int r = 0; r < m; r++) {
      if (grid[r][0] == LAND) {
        islandTraverse(grid, r, 0);
      }
    }
    for (int r = 0; r < m; r++) {
      if (grid[r][n - 1] == LAND) {
        islandTraverse(grid, r, n - 1);
      }
    }
    // top-down
    for (int c = 0; c < n; c++) {
      if (grid[0][c] == LAND) {
        islandTraverse(grid, 0, c);
      }
    }
    for (int c = 0; c < n; c++) {
      if (grid[m - 1][c] == LAND) {
        islandTraverse(grid, m - 1, c);
      }
    }

    int counter = 0;
    for (int r = 1; r < m - 1; r++) {
      for (int c = 1; c < n - 1; c++) {
        if (grid[r][c] == LAND) {
          ++counter;
          islandTraverse(grid, r, c);
        }
      }
    }
    return counter;
  }

  private void islandTraverse(int[][] grid, int r, int c) {
    boolean isInbound = r >= 0 && r < grid.length && c >= 0 && c < grid[0].length;
    if (!isInbound || grid[r][c] == WATER) {
      return;
    }
    grid[r][c] = WATER;
    for (int[] dir : GraphConstant.FOUR_DIRECTIONS) {
      islandTraverse(grid, r + dir[0], c + dir[1]);
    }
  }
}
