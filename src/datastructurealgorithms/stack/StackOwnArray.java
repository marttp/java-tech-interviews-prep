package datastructurealgorithms.stack;

import java.util.EmptyStackException;

public class StackOwnArray {
    private final int[] stack;
    private int top;

    public StackOwnArray(int size) {
        stack = new int[size];
        top = -1;
    }

    // Push an element onto the stack
    public void push(int data) {
        if (top == stack.length - 1) {
            throw new StackOverflowError();
        }
        stack[++top] = data;
    }

    // Pop an element from the stack
    public int pop() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return stack[top--];
    }

    // Peek at the top element of the stack
    public int peek() {
        if (top == -1) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Get the size of the stack
    public int size() {
        return top + 1;
    }
}

