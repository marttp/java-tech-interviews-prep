package lc.blind75.easy;

import common.TreeNode;

public class LcaOfBst_235 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    int value = root.val;
    if (p.val < value && q.val < value) {
      return lowestCommonAncestor(root.left, p, q);
    } else if (p.val > value && q.val > value) {
      return lowestCommonAncestor(root.right, p, q);
    }
    return root;
  }
}
