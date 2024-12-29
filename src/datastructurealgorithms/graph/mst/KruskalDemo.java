package datastructurealgorithms.graph.mst;

import java.util.*;

import static datastructurealgorithms.graph.mst.Util.mockEdges;

public class KruskalDemo {

    public static void main(String[] args) {
        var edges = mockEdges();

        Set<String> sets = new HashSet<>();
        for (var edge : edges) {
            sets.add(edge.u());
            sets.add(edge.v());
        }
        var size = sets.size() - 1; // N
        UnionFind uf = new UnionFind();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));
        pq.addAll(edges);

        int cost = 0;
        List<Edge> edgesToVisit = new ArrayList<>();

        while (!pq.isEmpty() && size > 0) {
            Edge edge = pq.poll();
            if (uf.union(edge.u(), edge.v())) {
                edgesToVisit.add(edge);
                cost += edge.weight();
                size--;
            }
        }

        System.out.println("Cost: " + cost);
        System.out.println("Edges: " + edgesToVisit);
    }

    private static class UnionFind {
        private final Map<String, String> parent = new HashMap<>();

        void setParent(String x) {
            parent.putIfAbsent(x, x);
        }

        String find(String x) {
            if (!x.equals(parent.get(x))) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        boolean union(String x, String y) {
            setParent(x);
            setParent(y);
            String rootX = find(x);
            String rootY = find(y);
            if (!rootX.equals(rootY)) {
                parent.put(rootX, rootY);
                return true;
            }
            return false;
        }
    }
}
