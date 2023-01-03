package datastructurealgorithms.graph;

import java.util.*;

public class GraphExample {
    public static Map<Integer, List<Integer>> buildGraph(int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] e : edges) {
            graph.putIfAbsent(e[0], new ArrayList<>());
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        return graph;
    }

    public static boolean dfs(int u, int destination, Map<Integer, List<Integer>> graph,
                                 Set<Integer> visited) {
        if (u == destination) {
            return true;
        }
        for (int v : graph.get(u)) {
            if (!visited.add(v)) {
                if (dfs(v, destination, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
}
