package lc.blind75;

import lc.common.TreeNode;

public class InvertBinaryTree_226 {

  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return null;
    }
    TreeNode invertRight = invertTree(root.right);
    TreeNode invertLeft = invertTree(root.left);
    root.left = invertRight;
    root.right = invertLeft;
    return root;
  }
}
