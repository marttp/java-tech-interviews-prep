package datastructurealgorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DoublyLinkedListDemo {

    public static void main(String[] args) {
        var linkedList = new DoublyLinkedList();
        linkedList.insertHead(new ListNode<>("T"));
        linkedList.traverseLinkedList(); // T
        linkedList.insertHead(new ListNode<>("A"));
        linkedList.traverseLinkedList(); // A->T
        linkedList.insertTail(new ListNode<>("L"));
        linkedList.traverseLinkedList(); // A->T->L
        System.out.println(linkedList.deleteFromHead());
        linkedList.traverseLinkedList(); // T->L
        System.out.println(linkedList.deleteFromTail());
        linkedList.traverseLinkedList(); // T
        System.out.println("======");
        linkedList.insertHead(new ListNode<>("R"));
        linkedList.insertHead(new ListNode<>("A"));
        linkedList.insertHead(new ListNode<>("M"));
        linkedList.traverseLinkedList();
        System.out.println(linkedList.delete("A"));
        linkedList.traverseLinkedList();
    }

    private static class DoublyLinkedList {

        public ListNode<String> head;
        public ListNode<String> tail;
        public int size;

        public DoublyLinkedList() {
            this.head = new ListNode<>("HEAD");
            this.tail = new ListNode<>("TAIL");
            // Connect
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        // insert head
        public void insertHead(ListNode<String> newNode) {
            var nextHead = this.head.next;
            newNode.next = nextHead;
            nextHead.prev = newNode;
            this.head.next = newNode;
            newNode.prev = this.head;
            this.size++;
        }

        // insert tail
        public void insertTail(ListNode<String> newNode) {
            var prevTail = this.tail.prev;
            prevTail.next = newNode;
            newNode.prev = prevTail;
            newNode.next = this.tail;
            this.tail.prev = newNode;
            this.size++;
        }

        // traverse
        private void traverseLinkedList() {
            List<String> traverseResult = new ArrayList<>();
            var ignoreDataSet = Set.of("HEAD", "TAIL");
            var currNode = this.head;
            while (currNode != null) {
                if (!ignoreDataSet.contains(currNode.data)) {
                    traverseResult.add(currNode.data);
                }
                currNode = currNode.next;
            }
            var result = String.join("->", traverseResult);
            System.out.println(result);
        }

        // delete head
        public ListNode<String> deleteFromHead() {
            if (this.size == 0) {
                return null;
            }
            var nextHead = this.head.next;
            this.head.next = nextHead.next;
            nextHead.next.prev = this.head;
            nextHead.next = null;
            nextHead.prev = null;
            this.size--;
            return nextHead;
        }

        // delete tail
        public ListNode<String> deleteFromTail() {
            if (this.size == 0) {
                return null;
            }
            var prevTail = this.tail.prev;
            this.tail.prev = prevTail.prev;
            prevTail.prev.next = this.tail;
            prevTail.next = null;
            prevTail.prev = null;
            this.size--;
            return prevTail;
        }

        // delete between
        public ListNode<String> delete(String target) {
            ListNode<String> prev = head;
            ListNode<String> curr = head.next;
            while (curr != null) {
                if (curr.data.equals(target)) {
                    prev.next = curr.next;
                    curr.next.prev = prev;
                    curr.next = null;
                    curr.prev = null;
                    this.size--;
                    return curr;
                }
                prev = curr;
                curr = curr.next;
            }
            return null;
        }

    }

    private static class ListNode<T> {
        public T data;
        public ListNode<T> next;
        public ListNode<T> prev;

        public ListNode(T data) {
            this.data = data;
        }

        public ListNode(T data, ListNode<T> next, ListNode<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return "[" + this.data + "]";
        }
    }
}
