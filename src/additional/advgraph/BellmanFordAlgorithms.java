package additional.advgraph;

import java.util.Arrays;
import java.util.List;
import common.Edge;

public class BellmanFordAlgorithms {

  // Single Source Shortest Path algorithms - Handle negative weight
  // But if guarantee all the weight are positive => prefer to use Dijsktra for faster
  public BellmanFordResult bellmanFordAlgorithm(List<Edge> edges, int N, int src) {
    int[] dist = new int[N];
    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[src] = 0;
    boolean isHaveUpdate = false;

    // Bellman-Ford
    // ทำไปเรื่อย ๆ ด้วย Loop ใหญ่ N - 1 รอบ หรือจนรอบนั้น ๆ ไม่มีการ relaxation อีกแล้ว
    for (int i = 0; i < N - 1; i++) {
      for (Edge e : edges) {
        if (dist[e.u] + e.weight < dist[e.v]) {
          dist[e.v] = dist[e.u] + e.weight;
          isHaveUpdate = true;
        }
      }
      if (!isHaveUpdate) {
        return new BellmanFordResult(dist, false);
      }
    }
    // If it updated until N - 1
    // we should check negative weight cycle
    // if we do optional round and update => We found NEGATIVE WEIGHT CYCLE
    for (Edge e : edges) {
      if (dist[e.u] + e.weight < dist[e.v]) {
        Arrays.fill(dist, Integer.MAX_VALUE);
      }
    }
    return new BellmanFordResult(dist, true);
  }

  public static class BellmanFordResult {

    public int[] dist;
    public boolean isFoundNegativeWeightCycle;

    public BellmanFordResult(int[] dist, boolean isFoundNegativeWeightCycle) {
      this.dist = dist;
      this.isFoundNegativeWeightCycle = isFoundNegativeWeightCycle;
    }
  }
}
