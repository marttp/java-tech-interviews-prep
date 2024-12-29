package datastructurealgorithms.graph.mst;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Util {

    public static List<Edge> mockEdges() {
        Edge[] edges = {
                new Edge("A", "B", 7),
                new Edge("A", "C", 6),
                new Edge("A", "D", 4),
                new Edge("B", "C", 1),
                new Edge("D", "E", 5),
                new Edge("D", "F", 8),
                new Edge("E", "H", 2),
                new Edge("F", "G", 2),
                new Edge("F", "H", 3),
                new Edge("G", "I", 2),
                new Edge("H", "G", 7),
                new Edge("H", "I", 6),
                new Edge("C", "F", 4)
        };
        return Arrays.stream(edges).collect(Collectors.toList());
    }
}
