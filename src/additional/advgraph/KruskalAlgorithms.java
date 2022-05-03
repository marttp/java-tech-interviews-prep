package additional.advgraph;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import common.Edge;
import common.unionfind.UnionFindNumArr;

public class KruskalAlgorithms {

  public int kruskalAlgorithms(int n, List<Edge> edges) {
    if (edges == null || edges.isEmpty()) {
      return 0;
    }
    int size = n - 1;
    UnionFindNumArr uf = new UnionFindNumArr(n);
    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
    pq.addAll(edges);
    int cost = 0;
    while (!pq.isEmpty() && size > 0) {
      Edge edge = pq.poll();
      if (uf.union(edge.u, edge.v)) {
        cost += edge.weight;
        size--;
      }
    }
    return cost;
  }
}
