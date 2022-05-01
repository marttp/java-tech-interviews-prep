package lc.blind75.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import lc.common.TreeNode;

public class KthSmallestElementInBST_230 {

  // Inorder traverse with K counter
  public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    int value = 0;
    TreeNode current = root;
    while ((!stack.isEmpty() || current != null) && k != 0) {
      // left most first
      while (current != null) {
        stack.addFirst(current);
        current = current.left;
      }
      current = stack.removeFirst();
      k--;
      value = current.val;
      current = current.right;
    }
    return value;
  }
}
