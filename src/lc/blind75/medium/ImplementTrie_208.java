package lc.blind75.medium;

import java.util.List;
import utility.GenerateExample;

public class ImplementTrie_208 implements GenerateExample {

  @Override
  public void example() {
    Trie trie = new Trie();
    List<String> words = List.of("apple", "app", "application", "ape");
    words.forEach(trie::insert);
    System.out.println("Search 'apple': " + trie.search("apple"));
    System.out.println("Contain prefix 'app': " + trie.startWith("app"));
  }
}

class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode ptr = root;
    for (char c : word.toCharArray()) {
      int index = getIndex(c);
      if (ptr.children[index] == null) {
        ptr.children[index] = new TrieNode();
      }
      ptr = ptr.children[index];
    }
    ptr.isWord = true;
  }

  public boolean search(String word) {
    TrieNode ptr = root;
    for (char c : word.toCharArray()) {
      int index = getIndex(c);
      if (ptr.children[index] == null) {
        return false;
      }
      ptr = ptr.children[index];
    }
    return true;
  }

  public boolean startWith(String prefix) {
    TrieNode ptr = root;
    for (char c : prefix.toCharArray()) {
      int index = getIndex(c);
      if (ptr.children[index] == null) {
        return false;
      }
      ptr = ptr.children[index];
    }
    return ptr != null;
  }

  private int getIndex(char c) {
    return c - 'a';
  }
}

class TrieNode {

  private static final int LOWERCASE_AMOUNT = 25;
  boolean isWord = true;
  TrieNode[] children = new TrieNode[LOWERCASE_AMOUNT];
}