package common;

import lc.blind75.easy.ReverseLinkedList_206;

public class ListNode {

  public int val;
  public ListNode next;

  public ListNode() {
  }

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public static ListNode reverseLinkedList(ListNode head) {
    return new ReverseLinkedList_206().reverseLinkedList(head);
  }

  @Override
  public String toString() {
    return "[" + val + "]";
  }
}
