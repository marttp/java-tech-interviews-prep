package lc.pattern.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchSuggestionsSystem_1268 {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        for (String w : products) {
            trie.insert(w);
        }
        StringBuilder prefix = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            prefix.append(c);
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }

    private static class Node {
        boolean isWord = false;
        List<Node> children = Arrays.asList(new Node[26]);
    }

    private static class Trie {

        Node Root;

        Trie() {
            Root = new Node();
        }

        void dfsWithPrefix(Node curr, String word, List<String> resultBuffer) {
            if (resultBuffer.size() == 3) {
                return;
            }
            if (curr.isWord) {
                resultBuffer.add(word);
            }
            for (char c = 'a'; c <= 'z'; c++) {
                if (curr.children.get(c - 'a') != null) {
                    dfsWithPrefix(curr.children.get(c - 'a'), word + c, resultBuffer);
                }
            }
        }

        void insert(String s) {
            Node curr = Root;
            for (char c : s.toCharArray()) {
                if (curr.children.get(c - 'a') == null) {
                    curr.children.set(c - 'a', new Node());
                }
                curr = curr.children.get(c - 'a');
            }
            curr.isWord = true;
        }

        List<String> getWordsStartingWith(StringBuilder prefix) {
            Node curr = Root;
            List<String> resultBuffer = new ArrayList<>();
            for (char c : prefix.toString().toCharArray()) {
                if (curr.children.get(c - 'a') == null) {
                    return resultBuffer;
                }
                curr = curr.children.get(c - 'a');
            }
            dfsWithPrefix(curr, prefix.toString(), resultBuffer);
            return resultBuffer;
        }
    }

}
