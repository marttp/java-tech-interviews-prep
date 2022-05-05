package lc.blind75.medium;

import static constant.StringConstant.LOWERCASE_AMOUNT;

import utility.Util;

public class DesignAddSearchWord_211 {

  private static class Trie {

    TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode ptr = root;
      for (char c : word.toCharArray()) {
        int index = Util.getLowercaseIndex(c);
        if (ptr.children[index] == null) {
          ptr.children[index] = new TrieNode();
        }
        ptr = ptr.children[index];
      }
      ptr.isWord = true;
    }

    public boolean search(String word) {
      return match(word.toCharArray(), 0, root);
    }

    private boolean match(char[] word, int index, TrieNode node) {
      if (index >= word.length) {
        return node.isWord;
      }
      char c = word[index];
      // Wild card search
      // Whatever next character that would be go to next step
      if (c == '.') {
        for (int i = 0; i < node.children.length; i++) {
          if (node.children[i] != null && match(word, index + 1, node.children[i])) {
            return true;
          }
        }
        return false;
      }
      int nextIndex = Util.getLowercaseIndex(c);
      return node.children[nextIndex] != null &&
          match(word, index + 1, node.children[nextIndex]);
    }
  }

  private static class TrieNode {
    boolean isWord = true;
    TrieNode[] children = new TrieNode[LOWERCASE_AMOUNT];
  }
}