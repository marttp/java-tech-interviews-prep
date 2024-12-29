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

    public static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (var e : edges) {
            graph.putIfAbsent(e.getFirst(), new ArrayList<>());
            graph.putIfAbsent(e.getLast(), new ArrayList<>());
            graph.get(e.getFirst()).add(e.getLast());
            graph.get(e.getLast()).add(e.getFirst());
        }
        return graph;
    }

    public static boolean dfs(int source, int destination, Map<Integer, List<Integer>> graph,
                                 Set<Integer> visited) {
        if (source == destination) {
            return true;
        }
        for (int v : graph.get(source)) {
            if (visited.add(v)) {
                if (dfs(v, destination, graph, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean bfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int start, int end) {
        if (start == end) {
            return true;
        }

        Set<Integer> seen = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addAll(graph.get(start));

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == end) {
                return true;
            }
            for (int child : graph.get(node)) {
                if (!seen.contains(child)) {
                    queue.add(child);
                    seen.add(child);
                }
            }
        }

        return false;
    }
}
