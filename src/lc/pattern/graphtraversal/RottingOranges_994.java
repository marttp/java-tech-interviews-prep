package lc.pattern.graphtraversal;

import constant.GraphConstant;
import java.util.LinkedList;
import java.util.Queue;
import utility.Util;

public class RottingOranges_994 {

  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    Queue<int[]> q = new LinkedList<>();
    int fresh = 0;

    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == 1) {
          fresh++;
        } else if (grid[r][c] == 2) {
          q.add(new int[]{r, c});
        }
      }
    }

    if (fresh == 0) {
      return 0;
    }

    int minutes = 0;
    while (!q.isEmpty()) {
      if (fresh == 0) {
        return minutes;
      }
      int size = q.size();
      while (size-- > 0) {
        int[] rotten = q.poll();
        for (int[] dir : GraphConstant.FOUR_DIRECTIONS) {
          int nr = rotten[0] + dir[0];
          int nc = rotten[1] + dir[1];
          if (Util.isInbound(grid, nr, nc) && grid[nr][nc] == 1) {
            grid[nr][nc] = 2;
            fresh--;
            q.add(new int[]{nr, nc});
          }
        }
      }
      minutes++;
    }

    return fresh == 0 ? minutes : -1;
  }
}
