package lc.blind75.medium;

import java.util.Arrays;

public class SetMatrixZeros_73 {

  public void setZeros(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    int m = matrix.length;
    int n = matrix[0].length;
    boolean isFistRowContainsZero = false;
    for (int c = 0; c < n; c++) {
      if (matrix[0][c] == 0) {
        isFistRowContainsZero = true;
        break;
      }
    }
    boolean isFirstColContainsZero = false;
    for (int r = 0; r < m; r++) {
      if (matrix[r][0] == 0) {
        isFirstColContainsZero = true;
        break;
      }
    }

    // Marking process
    for (int r = 1; r < m; r++) {
      for (int c = 1; c < n; c++) {
        if (matrix[r][c] == 0) {
          matrix[r][0] = 0;
          matrix[0][c] = 0;
        }
      }
    }

    // Check border and turn inside
    for (int c = 1; c < n; c++) {
      if (matrix[0][c] == 0) {
        for (int r = 1; r < m; r++) {
          matrix[r][c] = 0;
        }
      }
    }
    for (int r = 1; r < m; r++) {
      if (matrix[r][0] == 0) {
        Arrays.fill(matrix[r], 0);
      }
    }

    if (isFistRowContainsZero) {
      Arrays.fill(matrix[0], 0);
    }
    if (isFirstColContainsZero) {
      for (int r = 0; r < m; r++) {
        matrix[r][0] = 0;
      }
    }
  }


}
