package datastructurealgorithms.graph;

import java.util.*;

import static datastructurealgorithms.graph.GraphExample.buildGraph;

public class GraphDemo {

    public static void main(String[] args) {
        var graph = mockGraph();
        System.out.println("Adjacency List");
        System.out.println(graph);
        System.out.println();
        // Traverse -> DFS (Recursive)
        traverseDfsRecursive(graph);
        // Traverse -> DFS (Iterative)
        traverseDfsIterative(graph);
        // Traverse -> BFS
        traverseBfs(graph);
        // Find 7, 8, 9
        System.out.println("Find 7 in current graph: " +
                GraphExample.dfs(1, 7, graph, new HashSet<>())
        );
        System.out.println("Find 8 in current graph: " +
                GraphExample.bfs(graph, new HashSet<>(), 6, 7)
        );
        System.out.println("Find 9 in current graph: " +
                GraphExample.dfs(1, 9, graph, new HashSet<>())
        );
    }

    private static void traverseDfsRecursive(Map<Integer, List<Integer>> graph) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(graph, 1, visited, result);
        System.out.println("DFS - Recursive: " + result);
    }

    private static void traverseDfsIterative(Map<Integer, List<Integer>> graph) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(1);

        while (!stack.isEmpty()) {
            var currentNode = stack.pop();
            if (visited.add(currentNode)) {
                result.add(currentNode);
                for (var neighbor : graph.get(currentNode)) {
                    stack.push(neighbor);
                }
            }
        }

        System.out.println("DFS - Iterative: " + result);
    }

    private static void dfs(
            Map<Integer, List<Integer>> graph,
            int currentNode,
            Set<Integer> visited,
            List<Integer> result) {
        if (visited.add(currentNode)) {
            result.add(currentNode);
            for (var neighbor : graph.get(currentNode)) {
                dfs(graph, neighbor, visited, result);
            }
        }
    }

    private static void traverseBfs(Map<Integer, List<Integer>> graph) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            var currentNode = queue.poll();
            if (visited.add(currentNode)) {
                result.add(currentNode);
                for (var neighbor : graph.get(currentNode)) {
                    queue.offer(neighbor);
                }
            }
        }

        System.out.println("BFS: " + result);
    }

    private static Map<Integer, List<Integer>> mockGraph() {
        var edges = List.of(
                List.of(1, 3),
                List.of(3, 2),
                List.of(3, 6),
                List.of(3, 5),
                List.of(3, 4),
                List.of(2, 6),
                List.of(4, 5),
                List.of(6, 7),
                List.of(5, 7),
                List.of(5, 8)
        );
        return buildGraph(edges);
    }
}
