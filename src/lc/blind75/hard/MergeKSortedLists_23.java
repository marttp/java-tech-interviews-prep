package lc.blind75.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import lc.common.ListNode;

public class MergeKSortedLists_23 {

  // Merge K way pattern
  public ListNode mergeKListOptimize(ListNode[] lists) {
    // Min Heap implementation
    PriorityQueue<ListNode> pq = new PriorityQueue<>(
        Comparator.comparingInt(e -> e.val)
    );
    // Add just first node
    // because list already sorted
    for (ListNode l : lists) {
      if (l != null) {
        pq.add(l);
      }
    }
    ListNode dummyNode = new ListNode();
    ListNode iter = dummyNode;
    while (!pq.isEmpty()) {
      ListNode minNode = pq.poll();
      // If current node still have next node
      // push it back to heap
      if (minNode.next != null) {
        pq.add(minNode.next);
      }
      // Cut next node & combined
      minNode.next = null;
      iter.next = minNode;
      iter = iter.next;
    }
    return dummyNode.next;
  }

  public ListNode mergeKList1st(ListNode[] lists) {
    // Min Heap implementation
    PriorityQueue<ListNode> pq = new PriorityQueue<>(
        Comparator.comparingInt(e -> e.val)
    );
    // Add all element to heap
    for (ListNode l : lists) {
      if (l != null) {
        ListNode iter = l;
        while (iter != null) {
          pq.add(iter);
          iter = iter.next;
        }
      }
    }
    ListNode dummyNode = new ListNode();
    ListNode iter = dummyNode;
    while (!pq.isEmpty()) {
      iter.next = pq.poll();
      iter = iter.next;
    }
    return dummyNode.next;
  }
}
