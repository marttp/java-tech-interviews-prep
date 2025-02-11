package lc.pattern.inplacelinkedlist;

import common.ListNode;

public class DeleteNNodesAfterMNodesOfALinkedList_1474 {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode curr = head;
        ListNode prev = dummy;
        while (curr != null) {
            int move = m;
            while (curr != null && move-- > 0) {
                prev = curr;
                curr = curr.next;
            }
            int delete = n;
            while (curr != null && delete-- > 0) {
                curr = curr.next;
            }
            prev.next = curr;
        }

        return dummy.next;
    }
}
