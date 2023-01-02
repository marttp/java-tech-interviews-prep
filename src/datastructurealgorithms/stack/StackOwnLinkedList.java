package datastructurealgorithms.stack;

import common.ListNode;

import java.util.EmptyStackException;

public class StackOwnLinkedList {

    ListNode top;
    public StackOwnLinkedList() {
        this.top = null;
    }

    // Push an element onto the stack
    public void push(int data) {
        ListNode newListNode = new ListNode(data);
        newListNode.next = top;
        top = newListNode;
    }

    // Pop an element from the stack
    public int pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        int data = top.val;
        top = top.next;
        return data;
    }

    // Peek at the top element of the stack
    public int peek() {
        if (top == null) {
            throw new EmptyStackException();
        }
        return top.val;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Get the size of the stack
    public int size() {
        int size = 0;
        ListNode current = top;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

}
