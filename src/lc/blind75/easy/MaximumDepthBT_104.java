package lc.blind75.easy;

import lc.common.TreeNode;

public class MaximumDepthBT_104 {

  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return 1 + Integer.max(maxDepth(root.left), maxDepth(root.right));
  }
}
