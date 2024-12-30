package datastructurealgorithms.graph.shortestpath;

import datastructurealgorithms.graph.mst.Edge;

import java.util.*;

public class DijsktraDemo {

    public static void main(String[] args) {
        Edge[] edges = {
                new Edge("A", "B", 2),
                new Edge("A", "C", 4),
                new Edge("B", "C", 1),
                new Edge("B", "D", 7),
                new Edge("C", "E", 3),
                new Edge("E", "D", 2),
                new Edge("D", "F", 1),
                new Edge("E", "F", 5),
        };
        // Adjacency List
        Map<String, List<Edge>> graph = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();
        // Set Infinity
        for (var edge : edges) {
            distances.putIfAbsent(edge.u(), Integer.MAX_VALUE);
            distances.putIfAbsent(edge.v(), Integer.MAX_VALUE);
            graph.putIfAbsent(edge.u(), new ArrayList<>());
            graph.putIfAbsent(edge.v(), new ArrayList<>());
            graph.get(edge.u()).add(edge);
        }
        PriorityQueue<NodeDistance> pq = new PriorityQueue<>(Comparator.comparingInt(NodeDistance::totalWeight));
        Set<String> visited = new HashSet<>();
        String source = "A";
        // Set 0 on source
        distances.put(source, 0);
        pq.add(new NodeDistance(source, 0));

        while (!pq.isEmpty()) {
            var currVertex = pq.poll();
            if (!visited.contains(currVertex.u)) {
                for (var next : graph.get(currVertex.u)) {
                    if (!visited.contains(next.v())) {
                        var newDistance = distances.get(currVertex.u) + next.weight();
                        // Relaxation
                        if (newDistance < distances.get(next.v())) {
                            distances.put(next.v(), newDistance);
                            pq.add(new NodeDistance(next.v(), newDistance));
                        }
                    }
                }
            }
            visited.add(currVertex.u);
        }

        // Print result
        System.out.println("Starting from node: " + source);
        for (var entry : distances.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    private record NodeDistance(String u, int totalWeight) {}
}
