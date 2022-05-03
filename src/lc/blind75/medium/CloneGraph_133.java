package lc.blind75.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import common.Node;

public class CloneGraph_133 {

  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Map<Node, Node> cloneMap = new HashMap<>();
    cloneMap.put(node, new Node(node.val));
    // Traverse graph with Breath First Search
    Queue<Node> q = new LinkedList<>();
    q.add(node);
    while (!q.isEmpty()) {
      Node currNode = q.poll();
      for (Node neighbor : node.neighbors) {
        if (!cloneMap.containsKey(neighbor)) {
          cloneMap.put(neighbor, new Node(neighbor.val));
          q.add(neighbor);
        }
        cloneMap.get(currNode).neighbors.add(cloneMap.get(neighbor));
      }
    }
    return cloneMap.get(node);
  }
}
