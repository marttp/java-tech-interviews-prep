package lc.blind75.medium;

import lc.common.TreeNode;

public class LcaOfBT_236 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    return helper(root, p, q).ancestor;
  }

  private LcaStatus helper(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return new LcaStatus(0, null);
    }
    LcaStatus left = helper(root.left, p, q);
    if (left.total == 2) {
      return left;
    }
    LcaStatus right = helper(root.right, p, q);
    if (right.total == 2) {
      return right;
    }
    // if face p => increment
    // if face q => increment
    int count = left.total + right.total + (root == p ? 1 : 0) + (root == q ? 1 : 0);
    return new LcaStatus(count, count == 2 ? root : null);
  }

  private static class LcaStatus {

    int total;
    TreeNode ancestor;

    LcaStatus(int total, TreeNode ancestor) {
      this.total = total;
      this.ancestor = ancestor;
    }
  }
}