package lc.pattern.treebfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import common.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal_103 {

  public List<List<Integer>> levelZigzagOrder(TreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    boolean isFromRight = true;
    while (!q.isEmpty()) {
      int size = q.size();
      List<Integer> currentLevel = new ArrayList<>();
      while (size-- > 0) {
        var node = q.poll();
        if (isFromRight) {
          currentLevel.add(node.val);
        } else {
          currentLevel.add(0, node.val);
        }
        if (node.left != null) {
          q.add(node.left);
        }
        if (node.right != null) {
          q.add(node.right);
        }
      }
      result.add(currentLevel);
      isFromRight = !isFromRight;
    }
    return result;
  }
}
