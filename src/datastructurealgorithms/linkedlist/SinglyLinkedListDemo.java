package datastructurealgorithms.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class SinglyLinkedListDemo {

    public static void main(String[] args) {
        var head = new ListNode<>("HEAD");

        var aNode = new ListNode<>("A");
        var kNode = new ListNode<>("K");
        var pNode = new ListNode<>("P");
        var wNode = new ListNode<>("W");
        var iNode = new ListNode<>("I");

        head.next = aNode;
        aNode.next = kNode;
        kNode.next = pNode;
        pNode.next = wNode;
        wNode.next = iNode;

        System.out.println(traverseLinkedList(head.next));

        var nNode = new ListNode<>("N");
        insertNext(pNode, nNode);
        System.out.println(traverseLinkedList(head.next));

        var xNode = new ListNode<>("X");
        insertBySearching(head, "W", xNode);
        System.out.println(traverseLinkedList(head.next));

        deleteNode(head, "P");
        System.out.println(traverseLinkedList(head.next));
    }

    private static void deleteNode(ListNode<String> head, String targetData) {
        ListNode<String> prev = head;
        ListNode<String> curr = head.next;
        while (curr != null) {
            if (curr.data.equals(targetData)) {
                prev.next = curr.next;
                curr.next = null;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    private static void insertBySearching(ListNode<String> head, String searchTarget, ListNode<String> newNode) {
        var currNode = head;
        while (currNode != null) {
            if (currNode.data.equals(searchTarget)) {
                insertNext(currNode, newNode);
            }
            currNode = currNode.next;
        }
    }

    private static void insertNext(ListNode<String> targetNode, ListNode<String> newNode) {
        ListNode<String> tmp = targetNode.next;
        targetNode.next = newNode;
        newNode.next = tmp;
    }

    private static String traverseLinkedList(ListNode<String> head) {
        List<String> traverseResult = new ArrayList<>();
        var currNode = head;
        while (currNode != null) {
            traverseResult.add(currNode.data);
            currNode = currNode.next;
        }
        return String.join("->", traverseResult);
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
    }
}
