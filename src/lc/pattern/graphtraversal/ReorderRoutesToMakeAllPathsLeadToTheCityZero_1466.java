package lc.pattern.graphtraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero_1466 {

    public int minReorder(int n, int[][] connections) {
        int[] count = {0};
        var adjList = buildGraph(connections);
        dfs(0, -1, count, adjList);
        return count[0];
    }

    private void dfs(
            int node,
            int parent,
            int[] count,
            Map<Integer, List<List<Integer>>> graph) {
        if (graph.containsKey(node)) {
            for (var neighbor : graph.get(node)) {
                var n = neighbor.getFirst();
                var dir = neighbor.getLast();
                if (n != parent) {
                    count[0] += dir;
                    dfs(n, node, count, graph);
                }
            }
        }
    }

    private Map<Integer, List<List<Integer>>> buildGraph(int[][] connections) {
        Map<Integer, List<List<Integer>>> graph = new HashMap<>();
        for (int[] con : connections) {
            graph.putIfAbsent(con[0], new ArrayList<>());
            graph.putIfAbsent(con[1], new ArrayList<>());
            graph.get(con[0]).add(List.of(con[1], 1));
            graph.get(con[1]).add(List.of(con[0], 0));
        }
        return graph;
    }

}
