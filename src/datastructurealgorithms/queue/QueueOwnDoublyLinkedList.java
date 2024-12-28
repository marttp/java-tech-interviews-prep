package datastructurealgorithms.queue;

import java.util.List;

public class QueueOwnDoublyLinkedList {
    public static void main(String[] args) {
        var queue = new OwnQueue();
        var nums = List.of(1, 4, 5, 8, 6);
        for (var num : nums) {
            queue.enqueue(num);
        }
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(queue.dequeue());
        }
        System.out.println(queue.dequeue()); // Expected throw error
    }

    private static class OwnQueue {
        Node head;
        Node tail;

        OwnQueue() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
        }

        // enqueue - Insert Head
        void enqueue(int data) {
            Node newNode = new Node(data);

            Node nextHead = head.next;
            newNode.next = nextHead;
            nextHead.prev = newNode;

            head.next = newNode;
            newNode.prev = head;
        }

        // dequeue - Delete Tail
        int dequeue() {
            if (this.tail.prev.data == 0) {
                throw new RuntimeException("Queue is empty");
            }
            var prevTail = this.tail.prev;
            this.tail.prev = prevTail.prev;
            prevTail.prev.next = this.tail;
            prevTail.next = null;
            prevTail.prev = null;
            return prevTail.data;
        }

        // peek - See prev of tail
        int peek() {
            if (this.tail.prev.data == 0) {
                throw new RuntimeException("Queue is empty");
            }
            return this.tail.prev.data;
        }
    }

    private static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
        }
    }
}
