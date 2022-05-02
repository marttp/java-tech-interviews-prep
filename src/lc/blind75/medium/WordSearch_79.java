package lc.blind75.medium;

import utility.Util;

public class WordSearch_79 {

  public boolean exist(char[][] board, String word) {
    if (board == null || board.length == 0 || board[0].length == 0 ||
        word == null || word.isEmpty()) {
      return false;
    }
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        if (board[r][c] == word.charAt(0)) {
          if (dfs(board, r, c, word, 0)) {
            return true;
          }
        }
      }
    }
    return false;
  }

  private boolean dfs(char[][] board, int row, int col, String word, int currentIndex) {
    if (currentIndex >= word.length()) {
      return false;
    }
    if (!Util.isInbound(board, row, col) || board[row][col] != word.charAt(currentIndex)) {
      return false;
    }
    char tmp = board[row][col];
    // Marked visited
    board[row][col] = '#';
    // You can use loop 4 directions
    // but you can use simple OR 4 times and use benefit of short-circuit
    // Directions => UP, RIGHT, DOWN, LEFT
    int nextIndex = currentIndex + 1;
    boolean isExists = dfs(board, row - 1, col, word, nextIndex) ||
        dfs(board, row, col + 1, word, nextIndex) ||
        dfs(board, row + 1, col, word, nextIndex) ||
        dfs(board, row, col - 1, word, nextIndex);
    if (isExists) {
      return true;
    }
    // Return it back coz make it backtracking
    board[row][col] = tmp;
    return false;
  }
}
