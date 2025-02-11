package lc.pattern.inplacelinkedlist;

import common.ImmutableListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintImmutableLinkedListInReverse_1265 {

    class Solution1 {
        public void printLinkedListInReverse(ImmutableListNode head) {
            Deque<ImmutableListNode> stack = new ArrayDeque<>();
            ImmutableListNode curr = head;
            while (curr != null) {
                stack.push(curr);
                curr = curr.getNext();
            }
            while (!stack.isEmpty()) {
                stack.pop().printValue();
            }
        }
    }

    class Solution2 {
        public void printLinkedListInReverse(ImmutableListNode head) {
            if (head == null) {
                return;
            }
            printLinkedListInReverse(head.getNext());
            head.printValue();
        }
    }
}
