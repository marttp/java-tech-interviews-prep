package datastructurealgorithms.graph.mst;

import java.util.*;

import static datastructurealgorithms.graph.mst.Util.mockEdges;

public class PrimDemo {

    public static void main(String[] args) {
        var edges = mockEdges();
        // Adjacency List
        Map<String, Set<Edge>> adjacencyList = new HashMap<>();
        for (var edge : edges) {
            adjacencyList.putIfAbsent(edge.u(), new HashSet<>());
            adjacencyList.get(edge.u()).add(edge);
            adjacencyList.putIfAbsent(edge.v(), new HashSet<>());
            adjacencyList.get(edge.v()).add(new Edge(edge.v(), edge.u(), edge.weight()));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));
        Set<String> visited = new HashSet<>();
        int target = adjacencyList.size() - 1;

        int cost = 0;
        List<Edge> edgesToVisit = new ArrayList<>();
        String startNode = "H";

        pq.addAll(adjacencyList.get(startNode));
        visited.add(startNode);
        while (!pq.isEmpty() && edgesToVisit.size() < target) {
            Edge edge = pq.poll();
            if (visited.add(edge.v())) {
                cost += edge.weight();
                edgesToVisit.add(edge);
                // Load all edge from next vertex to PriorityQueue
                pq.addAll(adjacencyList.get(edge.v()));
            }
        }

        System.out.println("Cost: " + cost);
        System.out.println("Edges: " + edgesToVisit);
    }
}
