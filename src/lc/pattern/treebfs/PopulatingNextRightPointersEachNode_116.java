package lc.pattern.treebfs;

import common.TreeNodeWithNext;
import java.util.LinkedList;

public class PopulatingNextRightPointersEachNode_116 {

  public TreeNodeWithNext connect(TreeNodeWithNext root) {
    if (root == null) {
      return root;
    }
    LinkedList<TreeNodeWithNext> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNodeWithNext node = queue.poll();
        if (i != size - 1) {
          node.next = queue.peek();
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
    return root;
  }
}
