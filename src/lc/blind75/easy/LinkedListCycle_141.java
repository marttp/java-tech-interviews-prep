package lc.blind75.easy;

import common.ListNode;

public class LinkedListCycle_141 {

  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
        break;
      }
    }
    return fast != null && fast.next != null;
  }

}
