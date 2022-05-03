package lc.blind75.medium;

import common.TreeNode;

public class ValidateBST_98 {

  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);
  }

  private boolean isValidBST(TreeNode node, Integer min, Integer max) {
    if (node == null) {
      return true; // Leaf node will combine left/right as true
    }
    if (min != null && node.val <= min) {
      return false;
    }
    if (max != null && node.val >= max) {
      return false;
    }
    return isValidBST(node.left, min, node.val) &&
        isValidBST(node.right, node.val, max);
  }
}
