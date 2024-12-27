package datastructurealgorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class CircularLinkedListDemo {

    public static void main(String[] args) {
        var circularLinkedList = new CircularLinkedList(new ListNode<>("M"));
        System.out.println(circularLinkedList.getNth(3));
        System.out.println("====");
        circularLinkedList.add(new ListNode<>("N"));
        circularLinkedList.add(new ListNode<>("K"));
        circularLinkedList.add(new ListNode<>("W"));
        // M->W->K-N
        // Print by step
        circularLinkedList.traverse(8);
    }

    private static class CircularLinkedList {

        public ListNode<String> startNode;

        public CircularLinkedList(ListNode<String> startNode) {
            this.startNode = startNode;
            this.startNode.next = this.startNode;
        }

        public ListNode<String> getNth(int n) {
            ListNode<String> node = this.startNode;
            for (int i = 0; i < n; i++) {
                node = node.next;
            }
            return node;
        }

        public void traverse(int steps) {
            List<String> traverseResult = new ArrayList<>();
            var currNode = this.startNode;
            while (steps-- > 0) {
                traverseResult.add(currNode.data);
                currNode = currNode.next;
            }
            var result = String.join("->", traverseResult);
            System.out.println(result);
        }

        public void add(ListNode<String> node) {
            node.next = this.startNode.next;
            this.startNode.next = node;
        }
    }

    private static class ListNode<T> {
        public T data;
        public ListNode<T> next;

        public ListNode(T data) {
            this.data = data;
        }

        public ListNode(T data, ListNode<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return "[" + this.data + "]";
        }
    }
}
