package lc.blind75.hard;

import common.TreeNode;

public class BinaryTreeMaximumPathSum_124 {

  public int maxPathSum(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int[] max = {Integer.MIN_VALUE};
    findMaximum(root, max);
    return max[0];
  }

  private int findMaximum(TreeNode node, int[] max) {
    if (node == null) {
      return 0;
    }
    int left = Integer.max(0, findMaximum(node.left, max));
    int right = Integer.max(0, findMaximum(node.right, max));
    int current = node.val + left + right;
    max[0] = Integer.max(max[0], current);
    return node.val + Integer.max(left, right);
  }
}
