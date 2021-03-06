package lc.blind75.easy;

import common.ListNode;

public class MergeTwoSortedList_21 {

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode dummy = new ListNode();
    ListNode l1 = list1;
    ListNode l2 = list2;
    ListNode itr = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        itr.next = l1;
        l1 = l1.next;
      } else {
        itr.next = l2;
        l2 = l2.next;
      }
      itr = itr.next;
    }

    itr.next = l1 == null ? l2 : l1;

    return dummy.next;
  }
}
