package lc.pattern.graphtraversal;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze_1926 {

    private static final int[][] DIRS = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<Coord> queue = new LinkedList<>();
        queue.add(new Coord(entrance[0], entrance[1], 0));
        maze[entrance[0]][entrance[1]] = '+';
        while (!queue.isEmpty()) {
            var curr = queue.poll();
            var dist = curr.dist;
            for (var dir : DIRS) {
                int r = curr.r + dir[0];
                int c = curr.c + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && maze[r][c] != '+') {
                    // It's on edge, exit
                    if (r == 0 || r == m - 1 || c == 0 || c == n - 1) {
                        return dist + 1;
                    }
                    maze[r][c] = '+';
                    queue.add(new Coord(r, c, dist + 1));
                }
            }
        }
        return -1;
    }

    private record Coord(int r, int c, int dist) {
    }

}
