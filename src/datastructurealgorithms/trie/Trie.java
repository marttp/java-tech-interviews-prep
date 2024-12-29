package datastructurealgorithms.trie;

public class Trie {

    public TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    public void insert(String word) {
        char[] chars = word.toCharArray();
        TrieNode current = root;
        for (char c : chars) {
            int index = c - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode(c);
            }
            current = current.children[index];
        }
        // Assume it's already on last index
        current.isWord = true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        TrieNode current = root;
        for (char c : chars) {
            int index = c - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isWord;
    }

    public static class TrieNode {
        public char value;
        public boolean isWord;
        public TrieNode[] children;

        TrieNode(char value) {
            this.value = value;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
}
