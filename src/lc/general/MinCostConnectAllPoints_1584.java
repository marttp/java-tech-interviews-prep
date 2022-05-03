package lc.general;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import common.Edge;
import common.unionfind.UnionFindNumArr;
import utility.MathUtil;

public class MinCostConnectAllPoints_1584 {

  public int minCostConnectPoints(int[][] points) {
    return new Random().nextInt(2) != 0 ? prim(points) : kruskal(points);
  }

  private int prim(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    int n = points.length;
    // Min Heap => For combined the shortest distance first
    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
    int[] initPoint = points[0];
    for (int i = 1; i < n; i++) {
      int[] target = points[i];
      int costBetween = (int) MathUtil.manhattanDistance(initPoint[0],
          target[0], initPoint[1], target[1]);
      Edge edge = new Edge(0, i, costBetween);
      pq.add(edge);
    }
    boolean[] visited = new boolean[n];
    visited[0] = true;
    int cost = 0;
    int size = n - 1; // Prim do (n - 1) times due to edge size
    while (!pq.isEmpty() && size > 0) {
      Edge edge = pq.poll();
      if (!visited[edge.v]) {
        cost += edge.weight;
        size--;
        visited[edge.v] = true;
        for (int i = 0; i < n; i++) {
          if (!visited[i]) {
            int costBetween = (int) MathUtil.manhattanDistance(
                points[edge.v][0], points[i][0], points[edge.v][1], points[i][1]);
            pq.add(new Edge(edge.v, i, costBetween));
          }
        }
      }
    }
    return cost;
  }

  private int kruskal(int[][] points) {
    if (points == null || points.length == 0) {
      return 0;
    }
    int n = points.length;
    UnionFindNumArr uf = new UnionFindNumArr(n);
    // Min Heap => For combined the shortest distance first
    PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
    for (int i = 0; i < n; i++) {
      int[] source = points[i];
      for (int j = 1; j < n; j++) {
        int[] target = points[j];
        int costBetween = (int) MathUtil.manhattanDistance(source[0],
            target[0], source[1], target[1]);
        Edge edge = new Edge(i, j, costBetween);
        pq.add(edge);
      }
    }
    int cost = 0;
    int size = n - 1; // Kruskal do (n - 1) times due to edge size
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
