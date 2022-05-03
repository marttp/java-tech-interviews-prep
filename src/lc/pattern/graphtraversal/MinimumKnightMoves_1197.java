package lc.pattern.graphtraversal;

import constant.GraphConstant;
import java.util.LinkedList;
import java.util.Queue;
import common.CellWithDistance;

public class MinimumKnightMoves_1197 {

  /*
   * Constraints: -300 <= x, y <= 300 AND 0 <= |x| + |y| <= 300
   * */
  public int minKnightMoves(int x, int y) {
    // x, y => target cell
    // we start at (x,y) = (0,0)
    if (x == 0 && y == 0) {
      return 0;
    }
    Queue<CellWithDistance> q = new LinkedList<>();
    q.add(new CellWithDistance(0, 0, 0));
    boolean[][] visited = new boolean[605][605];
    while (!q.isEmpty()) {
      int layerSize = q.size();
      while (layerSize-- > 0) {
        var currCell = q.poll();
        if (currCell.x == x && currCell.y == y) {
          return currCell.distance;
        }
        for (int[] move : GraphConstant.KNIGHT_MOVES) {
          int nx = currCell.x + move[0];
          int ny = currCell.y + move[1];
          var next = new CellWithDistance(nx, ny, currCell.distance + 1);
          if (!visited[nx + 302][ny + 302]) {
            visited[nx + 302][ny + 302] = true;
            q.add(next);
          }
        }
      }
    }
    return Integer.MAX_VALUE;
  }
}
