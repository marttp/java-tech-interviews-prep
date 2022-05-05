package lc.general;

public class DesignTicTacToe_348 {

  private static class TicTacToe {

    public int[] rows;
    public int[] cols;
    public int diagonal = 0;
    public int antiDiagonal = 0;

    public int n;

    public TicTacToe(int n) {
      this.n = n;
      this.rows = new int[n];
      this.cols = new int[n];
    }

    public int move(int row, int col, int player) {
      int score = player == 0 ? 1 : -1;
      rows[row] += score;
      cols[col] += score;
      if (row == col) {
        diagonal += score;
      }
      if (col == (cols.length - row - 1)) {
        antiDiagonal += score;
      }
      if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n
          || Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n) {
        return player;
      }
      return 0;
    }
  }
}
