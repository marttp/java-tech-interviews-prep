package lc.pattern.graphtraversal;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathToGetFood_1730 {


    private static final int[][] DIRS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int getFood(char[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        boolean isFoundStart = false;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '*') {
                    queue.add(new int[]{r, c, 0});
                    isFoundStart = true;
                    break;
                }
            }
            if (isFoundStart) {
                break;
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int distance = current[2];
            if (grid[current[0]][current[1]] == '#') {
                return distance;
            }
            if (!visited[current[0]][current[1]]) {
                visited[current[0]][current[1]] = true;
                for (int[] dir : DIRS) {
                    int nr = current[0] + dir[0];
                    int nc = current[1] + dir[1];
                    if (nr >= 0 && nr < grid.length &&
                            nc >= 0 && nc < grid[0].length &&
                            grid[nr][nc] != 'X'
                    ) {
                        queue.add(new int[]{nr, nc, distance + 1});
                    }
                }
            }
        }
        return -1;
    }

}
