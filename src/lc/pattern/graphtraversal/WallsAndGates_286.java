package lc.pattern.graphtraversal;

import java.util.LinkedList;

public class WallsAndGates_286 {

    private static final int WALL = -1;
    private static final int GATE = 0;
    private static final int EMPTY_ROOM = Integer.MAX_VALUE;
    private static final int[][] DIRS = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public void wallsAndGates(int[][] rooms) {
        var queue = new LinkedList<Position>();
        for (int r = 0; r < rooms.length; r++) {
            for (int c = 0; c < rooms[0].length; c++) {
                if (rooms[r][c] == GATE) {
                    queue.add(new Position(r, c, 0));
                }
            }
        }
        while (!queue.isEmpty()) {
            var pos = queue.poll();
            for (var dir : DIRS) {
                int nr = pos.r + dir[0];
                int nc = pos.c + dir[1];
                if (isInbound(nr, nc, rooms) && rooms[nr][nc] == EMPTY_ROOM) {
                    rooms[nr][nc] = pos.dist + 1;
                    queue.add(new Position(nr, nc, pos.dist + 1));
                }
            }
        }
    }

    private boolean isInbound(int r, int c, int[][] rooms) {
        return r >= 0 && r < rooms.length && c >= 0 && c < rooms[0].length;
    }

    public static record Position(int r, int c, int dist) {
    }

}
