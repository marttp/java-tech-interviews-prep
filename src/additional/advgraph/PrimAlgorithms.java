package additional.advgraph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import common.Edge;

public class PrimAlgorithms {

  public int primAlgorithms(int n, List<Edge> edges) {
    if (edges == null || edges.isEmpty()) {
      return 0;
    }
    int size = n - 1; // Prim do (n - 1) times due to edge size
    // Min Heap => For combined the shortest distance first
    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
    pq.addAll(edges);

    boolean[] visited = new boolean[n];
    Edge sourceNode = pq.peek();
    visited[sourceNode.u] = true;
    int cost = 0;

    while (!pq.isEmpty() && size > 0) {
      Edge edge = pq.poll();
      if (!visited[edge.v]) {
        cost += edge.weight;
        size--;
        visited[edge.v] = true;
      }
    }
    return cost;
  }
}
