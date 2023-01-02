package datastructurealgorithms.hashtable;

import java.util.HashMap;

public class HashTableWithHashMap {
    public static void example() {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");
        System.out.println(map.get(1));  // prints "One"
        System.out.println(map.get(2));  // prints "Two"
        System.out.println(map.get(3));  // prints "Three"
    }
}
