package datastructurealgorithms.trie;

public class TrieExample {

    public static void main(String[] args) {
        String[] words = {
                "apple", "banana", "grape", "orange", "watermelon",
                "kiwi", "strawberry", "blueberry", "mango", "pineapple",
                "peach", "cherry", "pear", "plum", "apricot",
                "blackberry", "raspberry", "coconut", "papaya", "fig"
        };
        var trieRoot = new Trie();
        // Insert
        for (String word : words) {
            trieRoot.insert(word);
        }
        // Search
        System.out.println("Is banana in trie?: " + trieRoot.search("banana"));
        System.out.println("Is coconut in trie?: " + trieRoot.search("coconut"));
        System.out.println("Is beef in trie?: " + trieRoot.search("beef"));
    }
}
