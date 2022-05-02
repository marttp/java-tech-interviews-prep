package lc.blind75.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix_54 {

  public List<Integer> spiralMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return Collections.emptyList();
    }
    int lowRow = 0;
    int lowCol = 0;
    int highRow = matrix.length - 1;
    int highCol = matrix[0].length - 1;
    List<Integer> result = new ArrayList<>();
    while (lowRow <= highRow && lowCol <= highCol) {
      for (int c = lowCol; c <= highCol; c++) {
        result.add(matrix[lowRow][c]);
      }
      for (int r = lowRow + 1; r <= highRow; r++) {
        result.add(matrix[r][highCol]);
      }
      if (lowRow < highRow && lowCol < highCol) {
        for (int c = highCol - 1; c >= lowCol; c--) {
          result.add(matrix[highRow][c]);
        }
        for (int r = highRow - 1; r > lowRow; r--) {
          result.add(matrix[r][lowCol]);
        }
      }
      lowRow++;
      lowCol++;
      highRow--;
      highCol--;
    }
    return result;
  }
}
