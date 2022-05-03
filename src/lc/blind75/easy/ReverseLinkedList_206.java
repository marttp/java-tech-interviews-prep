package lc.blind75.easy;

import common.ListNode;

public class ReverseLinkedList_206 {

  public ListNode reverseLinkedList(ListNode head) {
    ListNode prev = null;
    ListNode itr = head;
    while (itr != null) {
      ListNode auxNode = itr.next;
      itr.next = prev;
      prev = itr;
      itr = auxNode;
    }
    return prev;
  }

  public ListNode reverseLinkedListRecursive(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode p = reverseLinkedListRecursive(head.next);
    head.next.next = head;
    head.next = null;
    return p;
  }
}
