package lc.pattern.fastnslowpointer;

import common.ListNode;

public class DeleteTheMiddleNodeOfALinkedList_2095 {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        // slow is in the middle
        prev.next = slow.next;
        slow.next = null;
        return head;
    }
}
