package lc.general;

import java.util.HashMap;
import java.util.Map;
import lc.common.NodeWithRandomPointer;

public class CopyListWithRandomPointer_138 {

  public NodeWithRandomPointer<Integer> copyRandomList(NodeWithRandomPointer<Integer> head) {
    // return firstApproach(head);
    return optimize(head);
  }

  public NodeWithRandomPointer<Integer> optimize(NodeWithRandomPointer<Integer> head) {
    if (head == null) {
      return null;
    }
    var ptr = head;
    // 1. Create clone node and connect
    while (ptr != null) {
      var cloneNode = new NodeWithRandomPointer<>(ptr.val);
      cloneNode.next = ptr.next;
      ptr.next = cloneNode;
      ptr = ptr.next.next;
    }
    // 2. Mapping random node to clone node
    ptr = head;
    while (ptr != null) {
      if (ptr.random != null) {
        ptr.next.random = ptr.random.next;
      }
      ptr = ptr.next.next;
    }
    // 3. Undo first step
    ptr = head;
    var newHead = ptr.next;
    while (ptr.next != null) {
      var tmp = ptr.next;
      ptr.next = tmp.next;
      ptr = tmp;
    }
    return newHead;
  }

  public NodeWithRandomPointer<Integer> firstApproach(NodeWithRandomPointer<Integer> head) {
    if (head == null) {
      return null;
    }
    Map<NodeWithRandomPointer<Integer>, NodeWithRandomPointer<Integer>> cloneMap = new HashMap<>();
    NodeWithRandomPointer<Integer> ptr = head;
    cloneMap.put(ptr, new NodeWithRandomPointer<>(ptr.val));
    while (ptr != null) {
      if (ptr.next != null) {
        cloneMap.putIfAbsent(ptr.next, new NodeWithRandomPointer<>(ptr.next.val));
        cloneMap.get(ptr).next = cloneMap.get(ptr.next);
      }
      if (ptr.random != null) {
        cloneMap.putIfAbsent(ptr.random, new NodeWithRandomPointer<>(ptr.random.val));
        cloneMap.get(ptr).random = cloneMap.get(ptr.random);
      }
      ptr = ptr.next;
    }
    return cloneMap.get(head);
  }

}
