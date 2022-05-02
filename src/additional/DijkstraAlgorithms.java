package additional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import lc.common.Vertex;

public class DijkstraAlgorithms {

  public int[] dijkstrasAlgorithms(int start, int[][][] edges) {
    // edge[][][]: 0,1 edge relation | 2 weight
    // graph => edge list
    int n = edges.length;
    PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

    int[] shortestPath = new int[n];
    Arrays.fill(shortestPath, Integer.MAX_VALUE);
    boolean[] done = new boolean[n];
    shortestPath[start] = 0;
    pq.add(new Vertex(start, 0));
    while (!pq.isEmpty()) {
      Vertex node = pq.poll();
      for (int[] edge : edges[node.label]) {
        int u = node.label;
        int v = edge[0];
        int w = edge[1];
        // Edge relaxation
        if (!done[v] && shortestPath[u] + w < shortestPath[v]) {
          shortestPath[v] = shortestPath[u] + w;
          pq.add(new Vertex(v, shortestPath[v]));
        }
      }
      done[node.label] = true;
    }

    // Turn to -1, because starting point can't reach that label
    for (int i = 0; i < n; i++) {
      if (shortestPath[i] == Integer.MAX_VALUE) {
        shortestPath[i] = -1;
      }
    }
    return shortestPath;
  }
}
