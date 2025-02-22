package lc.pattern.graphtraversal;

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze_490 {

    private static final int[][] DIRS = {
            {1,0},{-1,0},{0,1},{0,-1}
    };

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            var curr = queue.poll();
            for (var dir : DIRS) {
                // Go straight on that direction
                int r = curr[0];
                int c = curr[1];

                while (isInbound(maze, r + dir[0], c + dir[1]) &&
                        maze[r + dir[0]][c + dir[1]] == 0) {
                    r += dir[0];
                    c += dir[1];
                }
                // If stopped and meet dest => return true
                if (r == destination[0] && c == destination[1]) {
                    return true;
                }
                if (!visited[r][c]) {
                    visited[r][c] = true;
                    int[] newStart = {r,c};
                    queue.add(newStart);
                }
            }
        }

        return false;
    }

    private boolean isInbound(int[][] maze, int r, int c) {
        return r >= 0 && r < maze.length && c >= 0 && c < maze[0].length;
    }
}
