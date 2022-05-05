package lc.blind75.hard;

import constant.GraphConstant;
import java.util.ArrayList;
import java.util.List;
import utility.Util;

public class WordSearchII_212 {

  public List<String> findWords(char[][] board, String[] words) {
    TrieNode root = buildTrie(words);
    int m = board.length;
    int n = board[0].length;
    List<String> result = new ArrayList<>();
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        search(board, r, c, root, result);
      }
    }
    return result;
  }

  public void search(char[][] board, int r, int c, TrieNode node, List<String> result) {
    char tmp = board[r][c];
    if (tmp == '#' || node.children[Util.getLowercaseIndex(tmp)] == null) {
      return;
    }
    node = node.children[Util.getLowercaseIndex(tmp)];
    if (node.word != null) {
      // We found some word, put it in result
      result.add(node.word);
      node.word = null;
      // Not stop! => We just pass it through
    }
    board[r][c] = '#';
    for (int[] dir : GraphConstant.FOUR_DIRECTIONS) {
      int nr = r + dir[0];
      int nc = c + dir[1];
      if (Util.isInbound(board, nr, nc)) {
        search(board, nr, nc, node, result);
      }
    }
    board[r][c] = tmp;
  }

  private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (var word : words) {
      TrieNode ptr = root;
      for (var c : word.toCharArray()) {
        if (ptr.children[Util.getLowercaseIndex(c)] == null) {
          ptr.children[Util.getLowercaseIndex(c)] = new TrieNode();
        }
        ptr = ptr.children[Util.getLowercaseIndex(c)];
      }
      ptr.word = word;
    }
    return root;
  }

  private static class TrieNode {

    String word = null;
    TrieNode[] children = new TrieNode[26];
  }
}
