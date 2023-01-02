package datastructurealgorithms.stack;

import java.util.ArrayDeque;
import java.util.Stack;

public class StackWithApi {

    public static void exampleWithStack() {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Pop an element from the stack
        int popped = stack.pop();  // popped will be 5

        // Peek at the top element of the stack
        int top = stack.peek();  // top will be 4

        // Check if the stack is empty
        boolean isEmpty = stack.empty();  // isEmpty will be false

        // Get the size of the stack
        int size = stack.size();  // size will be 4
    }

    public static void exampleWithArrayDeque() {
        // Create a new stack
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        // Pop an element from the stack
        int popped = stack.pop();  // popped will be 5

        // Peek at the top element of the stack
        int top = stack.peek();  // top will be 4

        // Check if the stack is empty
        boolean isEmpty = stack.isEmpty();  // isEmpty will be false

        // Get the size of the stack
        int size = stack.size();  // size will be 4
    }
}
