package lc.pattern.inplacelinkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache_146 {

  private static class LRUCache {

    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;
    int capacity;
    int size;
    Map<Integer, DoublyLinkedListNode> accessMap;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.head = new DoublyLinkedListNode(Integer.MIN_VALUE, Integer.MIN_VALUE);
      this.tail = new DoublyLinkedListNode(Integer.MAX_VALUE, Integer.MAX_VALUE);
      this.head.next = this.tail;
      this.tail.prev = this.head;
      this.size = 0;
      this.accessMap = new HashMap<>();
    }

    public int get(int key) {
      if (!accessMap.containsKey(key)) {
        return -1;
      }
      DoublyLinkedListNode node = accessMap.get(key);
      moveToHead(node);
      return node.val;
    }

    public void put(int key, int val) {
      if (accessMap.containsKey(key)) {
        accessMap.get(key).val = val;
        moveToHead(accessMap.get(key));
        return;
      }
      DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, val);
      if (this.size == this.capacity) {
        // Evict Cache
        deleteNode(this.tail.prev);
        this.size--;
      }
      insertHead(newNode);
      this.size++;
    }

    private void moveToHead(DoublyLinkedListNode node) {
      DoublyLinkedListNode unboundNode = deleteNode(node);
      insertHead(unboundNode);
    }

    private DoublyLinkedListNode deleteNode(DoublyLinkedListNode node) {
      DoublyLinkedListNode prevNode = node.prev;
      DoublyLinkedListNode nextNode = node.next;
      prevNode.next = nextNode;
      nextNode.prev = prevNode;
      node.next = null;
      node.prev = null;
      accessMap.remove(node.key);
      return node;
    }

    private void insertHead(DoublyLinkedListNode node) {
      DoublyLinkedListNode nextHead = this.head.next;
      node.next = nextHead;
      node.prev = this.head;
      this.head.next = node;
      nextHead.prev = node;
      accessMap.put(node.key, node);
    }

  }

  private static class DoublyLinkedListNode {

    int key;
    int val;
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;

    public DoublyLinkedListNode(int key, int val) {
      this.key = key;
      this.val = val;
    }

    public DoublyLinkedListNode(int key, int val,
        DoublyLinkedListNode prev, DoublyLinkedListNode next) {
      this.key = key;
      this.val = val;
      this.prev = prev;
      this.next = next;
    }
  }
}
