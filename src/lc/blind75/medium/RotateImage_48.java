package lc.blind75.medium;

public class RotateImage_48 {

  public void rotate(int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return;
    }
    // First
    transposeReverse(matrix);
    // Second
    layerByLayer(matrix);
  }

  private void layerByLayer(int[][] matrix) {
    int n = matrix.length;
    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - layer - 1;
      for (int i = first; i < last; i++) {
        int offset = i - first;
        // สำรองบนซ้าย
        int tmp = matrix[first][i];
        // ซ้าย => บน
        matrix[first][i] = matrix[last - offset][first];
        // ล่าง => ซ้าย
        matrix[last - offset][first] = matrix[last][last - offset];
        // ขวา => ล่าง
        matrix[last][last - offset] = matrix[i][last];
        // เอาตัวที่ฝากไว้มาใส่
        matrix[i][last] = tmp;
      }
    }
  }

  private void transposeReverse(int[][] matrix) {
    transpose(matrix);
    for (int[] row : matrix) {
      reverseRow(row);
    }
  }

  private void transpose(int[][] matrix) {
    for (int r = 0; r < matrix.length; r++) {
      for (int c = 0; c < matrix[0].length; c++) {
        int tmp = matrix[c][r];
        matrix[c][r] = matrix[r][c];
        matrix[r][c] = tmp;
      }
    }
  }

  private void reverseRow(int[] row) {
    for (int i = 0, j = row.length - 1; i < j; i++, j--) {
      int tmp = row[i];
      row[i] = row[j];
      row[j] = tmp;
    }
  }
}
