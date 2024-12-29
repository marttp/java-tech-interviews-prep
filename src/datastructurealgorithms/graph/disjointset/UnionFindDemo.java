package datastructurealgorithms.graph.disjointset;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnionFindDemo {

    public static void main(String[] args) {
        List<Edge> edges = List.of(
                // Set 1
                new Edge("A", "B"),
                new Edge("A", "C"),
                new Edge("B", "C"),
                // Set 2
                new Edge("D", "F"),
                new Edge("F", "H"),
                new Edge("E", "H"),
                // Set 3
                new Edge("I", "G")
        );
        var uf = new UnionFind();
        for (var e : edges) {
            uf.union(e.a, e.b);
        }
//        System.out.println(uf.parents);
        System.out.println("Is A know E?: " + uf.isConnected("A", "E"));
        System.out.println("Is A know C?: " + uf.isConnected("A", "C"));
        // Check amount of root
        System.out.println("Number of authority: " + uf.countSet());
    }

    private static class UnionFind {

        public Map<String, String> parents = new HashMap<>();

        void setParent(String x) {
            parents.putIfAbsent(x, x);
        }

        long countSet() {
            return parents.entrySet()
                    .stream()
                    .filter(e -> e.getKey().equals(e.getValue()))
                    .count();
        }

        String find(String x) {
            if (!x.equals(parents.get(x))) {
                parents.put(x, find(parents.get(x)));
            }
            return parents.get(x);
        }

        boolean isConnected(String x, String y) {
            return find(x).equals(find(y));
        }

        boolean union(String x, String y) {
            setParent(x);
            setParent(y);
            var rootX = find(x);
            var rootY = find(y);
            if (!rootX.equals(rootY)) {
                parents.put(rootX, rootY);
                return true;
            }
            return false;
        }

    }

    private record Edge(String a, String b) {
    }
}
