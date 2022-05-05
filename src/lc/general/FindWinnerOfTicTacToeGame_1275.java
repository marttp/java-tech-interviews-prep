package lc.general;

public class FindWinnerOfTicTacToeGame_1275 {

  public String tictactoe(int[][] moves) {
    // rule: 3 x 3
    int[] rows = new int[3];
    int[] cols = new int[3];
    int diagonal = 0;
    int antiDiagonal = 0;
    int turn = 0; // A == 0 && B == 1

    for (int[] m : moves) {
      int score = turn == 0 ? 1 : -1;
      int targetRow = m[0];
      int targetCol = m[1];

      // Straight
      rows[targetRow] += score;
      cols[targetCol] += score;
      // Diagonal
      if (targetRow == targetCol) {
        diagonal += score;
      }
      // Anti-Diagonal
      if (targetCol == (3 - targetRow - 1)) {
        antiDiagonal += score;
      }
      if (Math.abs(rows[targetRow]) == 3 || Math.abs(cols[targetCol]) == 3
          || Math.abs(diagonal) == 3 || Math.abs(antiDiagonal) == 3) {
        return turn == 0 ? "A" : "B";
      }
      turn ^= 1;
    }

    return moves.length == 9 ? "DRAW" : "Pending";
  }
}
