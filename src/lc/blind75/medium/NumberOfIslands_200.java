package lc.blind75.medium;

import static constant.GraphConstant.DIR_C;
import static constant.GraphConstant.DIR_R;

import utility.Util;

public class NumberOfIslands_200 {

  private static final char WATER = '0';
  private static final char LAND = '1';

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return 0;
    }
    int islands = 0;
    for (int r = 0; r < grid.length; r++) {
      for (int c = 0; c < grid[0].length; c++) {
        if (grid[r][c] == LAND) {
          islands++;
          turnLandToWater(grid, r, c);
        }
      }
    }
    return islands;
  }

  private void turnLandToWater(char[][] grid, int r, int c) {
    if (!Util.isInbound(grid, r, c) || grid[r][c] == WATER) {
      return;
    }
    grid[r][c] = WATER;
    for (int i = 0; i < 4; i++) {
      turnLandToWater(grid, r + DIR_R[i], c + DIR_C[i]);
    }
  }
}
