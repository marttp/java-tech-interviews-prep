package lc.pattern.treebfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lc.common.TreeNode;

public class BinaryTreeLevelOrderTraversal_102 {

  public List<List<Integer>> levelOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> currentLevel = new ArrayList<>();
      while (size-- > 0) {
        var node = q.poll();
        currentLevel.add(node.val);
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }
      result.add(currentLevel);
    }
    return result;
  }
}
