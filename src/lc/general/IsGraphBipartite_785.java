package lc.general;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite_785 {

  // Bipartite => 2 coloring graph
  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] colors = new int[n];
    Arrays.fill(colors, -1);
    for (int i = 0; i < n; i++) {
//      if (colors[i] == -1 && !bfs(graph, i, colors)) {
//        return false;
//      }
      if (colors[i] == -1 && !dfs(graph, i, colors)) {
        return false;
      }
    }
    return true;
  }

  private boolean bfs(int[][] graph, int start, int[] colors) {
    Queue<Integer> q = new LinkedList<>();
    q.add(start);
    colors[start] = 0;
    while (!q.isEmpty()) {
      int u = q.poll();
      for (int v : graph[u]) {
        if (colors[v] == -1) {
          colors[v] = 1 - colors[u];
          q.add(v);
        } else if (colors[v] == colors[u]) {
          return false;
        }
      }
    }
    return true;
  }

  private boolean dfs(int[][] graph, int u, int[] colors) {
    if (colors[u] == -1) {
      colors[u] = 0;
    }
    for (int v : graph[u]) {
      if (colors[v] == -1) {
        colors[v] = 1 - colors[u];
        if (!dfs(graph, v, colors)) {
          return false;
        }
      } else if (colors[v] == colors[u]) {
        return false;
      }
    }
    return true;
  }
}
