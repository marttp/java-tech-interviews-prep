package lc.general;

import common.ListNode;

public class MaximumTwinSumOfALinkedList_2130 {

    public int pairSum(ListNode head) {
        int max = 0;
        int n = 0;
        ListNode curr = head;
        while (curr != null) {
            n++;
            curr = curr.next;
        }
        int expectedSize = n / 2;

        int[] result = new int[expectedSize];
        curr = head;
        for (int left = 0; left < expectedSize; left++) {
            result[left] += curr.val;
            curr = curr.next;
        }
        for (int right = expectedSize - 1; right >= 0; right--) {
            result[right] += curr.val;
            max = Integer.max(max, result[right]);
            curr = curr.next;
        }

        return max;
    }
}
