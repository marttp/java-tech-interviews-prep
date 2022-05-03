package lc.pattern.treebfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import common.TreeNode;

public class AvgOfLevelsInBinaryTree_637 {

  public List<Double> averageOfLevels(TreeNode root) {
    List<Double> result = new ArrayList<>();
    if (root == null) {
      return result;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while (!q.isEmpty()) {
      int size = q.size();
      double sum = 0;
      while (size-- > 0) {
        var currNode = q.poll();
        sum += currNode.val;
        if (currNode.left != null) {
          q.add(currNode.left);
        }
        if (currNode.right != null) {
          q.add(currNode.right);
        }
      }
      result.add(sum / size);
    }
    return result;
  }
}
