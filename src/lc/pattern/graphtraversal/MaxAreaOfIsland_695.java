package lc.pattern.graphtraversal;

import constant.GraphConstant;
import utility.Util;

public class MaxAreaOfIsland_695 {

  private static final int LAND = 1;
  private static final int WATER = 0;

  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int max = 0;
    int m = grid.length;
    int n = grid[0].length;
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == LAND) {
          int size = islandTraverse(grid, r, c);
          if (size > max) {
            max = size;
          }
        }
      }
    }
    return max;
  }

  private int islandTraverse(int[][] grid, int row, int col) {
    int size = 0;
    if (!Util.isInbound(grid, row, col) || grid[row][col] == WATER) {
      return size;
    }
    grid[row][col] = WATER;
    size += 1;
    for (int[] dir : GraphConstant.FOUR_DIRECTIONS) {
      size += islandTraverse(grid, row + dir[0], col + dir[1]);
    }
    return size;
  }
}
