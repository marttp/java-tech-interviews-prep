package lc.pattern.inplacelinkedlist;

import common.ListNode;

public class PlusOneLinkedList_369 {

    public ListNode plusOne(ListNode head) {
        ListNode reversed = reverse(head);
        int carry = 1;
        ListNode curr = reversed;
        while (curr != null) {
            int sum = curr.val + carry;
            int digit = sum % 10;
            curr.val = digit;
            carry = sum / 10;
            curr = curr.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
        }
        return reverse(reversed);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
