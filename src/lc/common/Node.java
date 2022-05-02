package lc.common;

import java.util.ArrayList;
import java.util.List;

public class Node {

  public int val;
  public List<Node> neighbors;

  public Node() {
    this.val = 0;
    this.neighbors = new ArrayList<>();
  }

  public Node(int v) {
    this.val = v;
    this.neighbors = new ArrayList<>();
  }

  public Node(int v, List<Node> neighbors) {
    this.val = v;
    this.neighbors = neighbors;
  }
}
