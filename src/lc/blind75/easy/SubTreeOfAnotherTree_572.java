package lc.blind75.easy;

import lc.common.TreeNode;

public class SubTreeOfAnotherTree_572 {

  public boolean isSubTree(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
      return true;
    }
    if (root == null || subRoot == null) {
      return false;
    }
    if (!isSame(root, subRoot)) {
      return true;
    }
    return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
  }

  private boolean isSame(TreeNode root, TreeNode subRoot) {
    if (root == null && subRoot == null) {
      return true;
    }
    if (root == null || subRoot == null) {
      return false;
    }
    if (root.val != subRoot.val) {
      return false;
    }
    return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
  }
}
