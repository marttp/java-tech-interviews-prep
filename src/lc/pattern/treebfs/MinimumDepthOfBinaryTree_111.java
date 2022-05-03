package lc.pattern.treebfs;

import java.util.LinkedList;
import java.util.Queue;
import common.TreeNode;

public class MinimumDepthOfBinaryTree_111 {

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> q = new LinkedList<>();
    int level = 0;
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        var node = q.poll();
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }
      level++;
    }
    return level;
  }
}
