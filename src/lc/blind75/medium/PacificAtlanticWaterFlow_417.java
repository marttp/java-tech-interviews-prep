package lc.blind75.medium;

import constant.GraphConstant;
import java.util.ArrayList;
import java.util.List;
import utility.Util;

public class PacificAtlanticWaterFlow_417 {

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int m = heights.length;
    int n = heights[0].length;
    // Check from border instead check on each highest cell
    // if check from border, will convert logic -> lower to higher
    // 1. Declare visited flag array for pacific, atlantic
    boolean[][] pacificVisited = new boolean[m][n];
    boolean[][] atlanticVisited = new boolean[m][n];
    // 2. Top-Bottom dfs
    for (int c = 0; c < n; c++) {
      dfs(heights, 0, c, pacificVisited, -1);
      dfs(heights, m - 1, c, atlanticVisited, -1);
    }
    // 3. Left-Right dfs
    for (int r = 0; r < m; r++) {
      dfs(heights, r, 0, pacificVisited, -1);
      dfs(heights, r, n - 1, atlanticVisited, -1);
    }
    // 4 Iterate all of those cells and check is contains in both visited array
    List<List<Integer>> result = new ArrayList<>();
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (pacificVisited[r][c] && atlanticVisited[r][c]) {
          result.add(List.of(r, c));
        }
      }
    }
    return result;
  }

  private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight) {
    if (!Util.isInbound(heights, r, c) || visited[r][c] || heights[r][c] < prevHeight) {
      return;
    }
    visited[r][c] = true;
    for (int[] dir : GraphConstant.FOUR_DIRECTIONS) {
      dfs(heights, r + dir[0], c + dir[1], visited, heights[r][c]);
    }
  }
}
