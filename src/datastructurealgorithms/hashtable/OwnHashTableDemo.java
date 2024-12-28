package datastructurealgorithms.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OwnHashTableDemo {

    public static void main(String[] args) {
        ownHashTableExample();
        System.out.println();
        javaHashMapExample();
    }

    private static void ownHashTableExample() {
        OwnHashTable hashTable = new OwnHashTable(10);
        // Sample space: 1 - 100
        List<Entry> registerList = List.of(
                new Entry(76, "Mart"),
                new Entry(59, "Mary")
        );
        for (var entry : registerList) {
            hashTable.insert(entry);
        }
        hashTable.printTable();
        System.out.println("Is contains 76: " + hashTable.contains(76));
        System.out.println("Is contains 46: " + hashTable.contains(46));
        System.out.println();
        // Expected overwrite key
        hashTable.insert(new Entry(46, "Martial"));
        hashTable.printTable();
    }

    private static class OwnHashTable {
        private final int size;
        private final List<ListNode> table;

        OwnHashTable(int size) {
            this.size = size;
            this.table = new ArrayList<>(this.size);
            for (int i = 0; i < size; i++) {
                table.add(new ListNode(new Entry(Integer.MAX_VALUE, "")));
            }
        }

        void insert(Entry entry) {
            int address = hashFunction(entry);
            ListNode newNode = new ListNode(entry);
            ListNode head = table.get(address);
            newNode.next = head.next;
            head.next = newNode;
        }

        boolean contains(int key) {
            int address = hashFunction(key);
            return this.search(address, key);
        }

        boolean search(int address, int key) {
            ListNode current = table.get(address).next;
            while (current != null) {
                if (current.data.key == key) {
                    return true;
                }
                current = current.next;
            }
            return false;
        }

        int hashFunction(Entry entry) {
            return entry.key % this.size;
        }

        int hashFunction(int key) {
            return key % this.size;
        }


        void printTable() {
            for (int i = 0; i < table.size(); i++) {
                var result = traverseAddress(table.get(i));
                var valueJoined = String.join("->", result.stream()
                        .map(Record::toString).toList()
                );
                String sb = "Address: " + i + ": " + valueJoined;
                System.out.println(sb);
            }
        }

        List<Entry> traverseAddress(ListNode head) {
            List<Entry> result = new ArrayList<>();
            ListNode current = head.next;
            while (current != null) {
                result.add(current.data);
                current = current.next;
            }
            return result;
        }
    }

    private static class ListNode {
        Entry data;
        ListNode next;

        ListNode(Entry data) {
            this.data = data;
        }
    }

    private static void javaHashMapExample() {
        Map<Integer, String> tables = new HashMap<>();
        tables.put(76, "Mart");
        tables.put(59, "Mary");
        tables.put(46, "Martial");
        System.out.println(tables);
    }

    private record Entry(int key, String value) {
    }
}
