package lc.pattern.inplacelinkedlist;

public class InsertIntoASortedCircularLinkedList_708 {

    private Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node curr = head;
        Node next = head.next;

        while (true) {
            if (curr.val <= insertVal && insertVal <= next.val) {
                break;
            }
            if (curr.val > next.val && (insertVal >= curr.val || insertVal <= next.val)) {
                break;
            }
            curr = curr.next;
            next = next.next;
            if (curr == head) {
                break;
            }
        }

        curr.next = newNode;
        newNode.next = next;

        return head;
    }

    private static class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}
