package datastructurealgorithms.graph;

import java.util.*;

public class GraphPrinter {
    public static void printAdjacencyList(Map<Integer, List<Integer>> graph) {
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            System.out.printf("%d -> %s%n", entry.getKey(),
                    entry.getValue().toString());
        }
    }

    public static void printAdjacencyMatrix(int[][] graph) {
        System.out.print("  ");
        for (int i = 0; i < graph.length; i++) {
            System.out.printf("%d ", i);
        }
        System.out.println();

        for (int i = 0; i < graph.length; i++) {
            System.out.printf("%d ", i);
            for (int j = 0; j < graph[i].length; j++) {
                System.out.printf("%d ", graph[i][j]);
            }
            System.out.println();
        }
    }

    public static void printGraphDOT(Map<Integer, List<Integer>> graph, boolean directed) {
        String graphType = directed ? "digraph" : "graph";
        String edge = directed ? " -> " : " -- ";

        System.out.println(graphType + " {");
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            int node = entry.getKey();
            for (int neighbor : entry.getValue()) {
                if (!directed || node <= neighbor) {
                    System.out.println("    " + node + edge + neighbor);
                }
            }
        }
        System.out.println("}");
    }
}