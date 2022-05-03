package lc.blind75.medium;

import common.ListNode;

public class ReorderList_143 {

  public void reorderList(ListNode head) {
    if (head == null) {
      return;
    }
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode secondHalf = slow.next;
    slow.next = null;
    ListNode reverseSecondHalf = ListNode.reverseLinkedList(secondHalf);

    ListNode first = head;
    ListNode second = reverseSecondHalf;
    while (first != null && second != null) {
      // Created auxiliary node
      ListNode tmp = first.next;
      // Connected first to second
      first.next = second;
      // Move first
      first = tmp;
      // Change ref of auxiliary
      tmp = second.next;
      second.next = first;
      second = tmp;
    }
  }
}
