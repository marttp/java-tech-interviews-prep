package lc.blind75.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import lc.common.TreeNode;

public class SerializeDeserializeBST_449 {

  public String serialize(TreeNode root) {
    StringBuilder sb = new StringBuilder();
    preorder(root, sb);
    return sb.toString();
  }

  private void preorder(TreeNode node, StringBuilder sb) {
    if (node == null) {
      sb.append('X').append('#');
      return;
    }
    sb.append(node.val).append('#');
    preorder(node.left, sb);
    preorder(node.right, sb);
  }

  public TreeNode deserialize(String data) {
    List<String> list = Arrays.asList(data.split("#"));
    LinkedList<String> q = new LinkedList<>(list);
    return deserializeHelper(q);
  }

  private TreeNode deserializeHelper(Queue<String> queue) {
    String value = queue.poll();
    if (value.equals("X")) {
      return null;
    }
    TreeNode node = new TreeNode(Integer.parseInt(value));
    node.left = deserializeHelper(queue);
    node.right = deserializeHelper(queue);
    return node;
  }
}
