package additional;

import common.ListNode;

public class RearrangeLinkedList {

  public ListNode rearrangeLinkedList(ListNode head, int k) {
    // k => pivot value
    if (head == null || head.next == null) {
      return head;
    }
    ListNode ptr = head;
    ListNode lowerDummy = new ListNode();
    ListNode lower = lowerDummy;
    ListNode pivotDummy = new ListNode();
    ListNode pivot = pivotDummy;
    ListNode higherDummy = new ListNode();
    ListNode higher = higherDummy;

    while (ptr != null) {
      if (ptr.val < k) {
        lower.next = ptr;
        lower = lower.next;
      } else if (ptr.val == k) {
        pivot.next = ptr;
        pivot = pivot.next;
      } else {
        higher.next = ptr;
        higher = higher.next;
      }
      ptr = ptr.next;
    }

    higher.next = null;
    pivot.next = higherDummy.next;
    lower.next = pivotDummy.next;

    return lowerDummy.next;
  }
}
