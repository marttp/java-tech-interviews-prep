package datastructurealgorithms.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {

    private final List<List<Entry>> entries;
    private final int size;

    public HashTable(int size) {
        this.size = size;
        entries = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            entries.add(new LinkedList<>());
        }
    }

    public void put(int key, String value) {
        int index = key % size;
        List<Entry> bucket = entries.get(index);
        for (Entry entry : bucket) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry(key, value));
    }

    public String get(int key) {
        int index = key % size;
        List<Entry> bucket = entries.get(index);
        for (Entry entry : bucket) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        return null;
    }

    private static class Entry {
        int key;
        String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}

