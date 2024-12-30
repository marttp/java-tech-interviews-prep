package datastructurealgorithms.graph.shortestpath;

import datastructurealgorithms.graph.mst.Edge;

import java.util.HashMap;
import java.util.Map;

public class BellmanFordDemo {

    public static void main(String[] args) {
        Edge[] edges = {
                new Edge("A", "B", 5),
                new Edge("A", "C", 4),
                new Edge("B", "D", 3),
                new Edge("D", "C", -10)
        };
        Map<String, Integer> distances = new HashMap<>();
        for (var edge : edges) {
            distances.putIfAbsent(edge.u(), Integer.MAX_VALUE);
            distances.putIfAbsent(edge.v(), Integer.MAX_VALUE);
        }
        String source = "A";
        distances.put(source, 0);
        var round = distances.size() - 1;

        // Main
        for (int i = 0; i < round; i++) {
            for (var edge : edges) {
                if (distances.get(edge.u()) != Integer.MAX_VALUE) {
                    var nextDistance = distances.get(edge.u()) + edge.weight();
                    if (nextDistance < distances.get(edge.v())) {
                        distances.put(edge.v(), nextDistance);
                    }
                }
            }
        }

        // Check Negative Cycle
        for (var edge : edges) {
            if (distances.get(edge.u()) != Integer.MAX_VALUE) {
                var nextDistance = distances.get(edge.u()) + edge.weight();
                if (nextDistance < distances.get(edge.v())) {
                    throw new RuntimeException("Negative cycle detected!!");
                }
            }
        }

        System.out.println("Starting from node: " + source);
        for (var entry : distances.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
