package lc.blind75.medium;

import lc.common.ListNode;

public class RemoveNthNodeFromEndOfList_19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    if (head == null) {
      return null;
    }
    ListNode p1 = head;
    ListNode p2 = head;
    // Move lead pointer forward n times
    // so that's mean, when we try to move lead pointer to end of list
    // follow pointer will be at n - 1 node
    for (int i = 0; i < n; i++) {
      p2 = p2.next;
    }
    // it's get to the first node
    // delete first node
    if (p2 == null) {
      p1 = head.next;
      // Move reference pointer
      head = p1;
      return head;
    }
    // In case not first node
    while (p2.next != null) {
      p1 = p1.next;
      p2 = p2.next;
    }
    p1.next = p1.next.next;
    return head;
  }
}
