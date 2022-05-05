package lc.pattern.graphtraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindIfPathExistsInGraph_1971 {

  public boolean validPath(int n, int[][] edges, int source, int destination) {
    return validPathDFS(n, edges, source, destination);
  }

  private boolean validPathDFS(int n, int[][] edges, int source, int destination) {
    boolean[] visited = new boolean[n];
    Map<Integer, List<Integer>> graph = buildGraph(edges);
    return dfsRecursive(source, destination, graph, visited);
  }

  private Map<Integer, List<Integer>> buildGraph(int[][] edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] e : edges) {
      graph.putIfAbsent(e[0], new ArrayList<>());
      graph.putIfAbsent(e[1], new ArrayList<>());
      graph.get(e[0]).add(e[1]);
      graph.get(e[1]).add(e[0]);
    }
    return graph;
  }

  private boolean dfsRecursive(int u, int destination, Map<Integer, List<Integer>> graph,
      boolean[] visited) {
    if (u == destination) {
      return true;
    }
    for (int v : graph.get(u)) {
      if (!visited[v]) {
        visited[v] = true;
        if (dfsRecursive(v, destination, graph, visited)) {
          return true;
        }
      }
    }
    return false;
  }
}
