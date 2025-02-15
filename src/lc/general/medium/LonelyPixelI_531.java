package lc.general.medium;

import java.util.HashMap;
import java.util.Map;

public class LonelyPixelI_531 {
    class Solution1 {
        public int findLonelyPixel(char[][] picture) {
            Map<Integer, Integer> row = new HashMap<>();
            Map<Integer, Integer> col = new HashMap<>();
            for (int r = 0; r < picture.length; r++) {
                for (int c = 0; c < picture[0].length; c++) {
                    if (picture[r][c] == 'B') {
                        row.put(r, row.getOrDefault(r, 0) + 1);
                        col.put(c, col.getOrDefault(c, 0) + 1);
                    }
                }
            }
            int count = 0;
            for (int r = 0; r < picture.length; r++) {
                for (int c = 0; c < picture[0].length; c++) {
                    if (picture[r][c] == 'B' && row.get(r) == 1 && col.get(c) == 1) {
                        count++;
                    }
                }
            }
            return count;
        }
    }

    class Solution2 {
        public int findLonelyPixel(char[][] picture) {
            int rows = picture.length;
            int cols = picture[0].length;
            int[] rowCount = new int[rows];
            int[] colCount = new int[cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (picture[r][c] == 'B') {
                        rowCount[r]++;
                        colCount[c]++;
                    }
                }
            }

            int count = 0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (picture[r][c] == 'B' && rowCount[r] == 1 && colCount[c] == 1) {
                        count++;
                    }
                }
            }

            return count;
        }
    }
}
