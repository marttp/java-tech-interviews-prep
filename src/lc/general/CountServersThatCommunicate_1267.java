package lc.general;

public class CountServersThatCommunicate_1267 {

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        int serverCount = 0;

        // Collect server counts
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    rowCount[r]++;
                    colCount[c]++;
                }
            }
        }

        // Scan each row where there are more than 1 server
        // On that row, check each column that is connected with this row
        // and consume connected column
        for (int r = 0; r < m; r++) {
            if (rowCount[r] > 1) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == 1) {
                        serverCount += colCount[c];
                        colCount[c] = 0;
                    }
                }
            }
        }

        // Since most of the servers have been counted by row scanning
        // Remaining region is column connected only
        for (int c = 0; c < n; c++) {
            if (colCount[c] > 1) {
                serverCount += colCount[c];
            }
        }

        return serverCount;
    }

}
