package lc.pattern.topologicalsort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MinimumHeightTrees_310 {

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n <= 0) {
      return Collections.emptyList();
    }
    if (n == 1) {
      return List.of(0);
    }

    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();
    for (int i = 0; i < n; i++) {
      graph.put(i, new ArrayList<>());
      inDegree.put(i, 0);
    }

    for (int[] edge : edges) {
      int u = edge[0];
      int v = edge[1];
      inDegree.put(u, inDegree.get(u) + 1);
      inDegree.put(v, inDegree.get(v) + 1);
      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    Queue<Integer> leavesQueue = new LinkedList<>();
    for (var entry : inDegree.entrySet()) {
      // Leaf node => 1 degree
      if (entry.getValue() == 1) {
        leavesQueue.add(entry.getKey());
      }
    }

    int totalNode = n;
    while (totalNode > 2) {
      int leafSize = leavesQueue.size();
      totalNode -= leafSize;
      while (leafSize-- > 0) {
        int leaf = leavesQueue.poll();
        for (int parent : graph.get(leaf)) {
          inDegree.put(parent, inDegree.get(parent) - 1);
          if (inDegree.get(parent) == 1) {
            leavesQueue.add(parent);
          }
        }
      }
    }

    return new ArrayList<>(leavesQueue);
  }
}
