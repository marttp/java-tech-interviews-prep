package lc.pattern.inplacelinkedlist;

import common.ListNode;

public class OddEvenLinkedList_328 {

    public ListNode oddEvenList(ListNode head) {
        ListNode[] slots = new ListNode[2];
        // Put dummy node
        slots[0] = new ListNode(0);
        slots[1] = new ListNode(0);

        ListNode odd = slots[0];
        ListNode even = slots[1];
        ListNode curr = head;

        int flag = 1;

        while (curr != null) {
            if (flag == 1) {
                odd.next = curr;
                odd = odd.next;
            } else {
                even.next = curr;
                even = even.next;
            }
            flag ^= 1;
            curr = curr.next;
        }

        // Set next to null on both
        odd.next = null;
        even.next = null;
        // Connect odd to head of even
        odd.next = slots[1].next;
        // Return head of odd
        return slots[0].next;
    }

}
