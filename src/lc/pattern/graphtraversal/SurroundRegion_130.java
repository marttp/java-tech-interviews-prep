package lc.pattern.graphtraversal;

import constant.GraphConstant;
import utility.Util;

public class SurroundRegion_130 {

  private static final char X = 'X';
  private static final char O = 'O';
  private static final char MARK = '#';

  public void solve(char[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }
    for (int r = 0; r < board.length; ++r) {
      turnAndMark(board, r, 0);
      turnAndMark(board, r, board[0].length - 1);
    }
    for (int c = 0; c < board[0].length; ++c) {
      turnAndMark(board, 0, c);
      turnAndMark(board, board.length - 1, c);
    }

    for (char[] col : board) {
      for (int i = 0; i < col.length; ++i) {
        col[i] = col[i] == MARK ? O : X;
      }
    }
  }

  private void turnAndMark(char[][] board, int r, int c) {
    if (!Util.isInbound(board, r, c) || board[r][c] != O) {
      return;
    }
    board[r][c] = MARK;
    for (int[] dir : GraphConstant.FOUR_DIRECTIONS) {
      turnAndMark(board, r + dir[0], c + dir[1]);
    }
  }
}
