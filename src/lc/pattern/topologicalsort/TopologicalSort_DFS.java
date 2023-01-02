package lc.pattern.topologicalsort;

import java.util.ArrayDeque;
import java.util.List;

public class TopologicalSort_DFS {
    void topologicalSort(int n, List<Integer>[] adjacencyList, boolean[] visited, ArrayDeque<Integer> stack) {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack, adjacencyList);
            }
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.removeFirst());
        }
    }

    void topologicalSortUtil(int v, boolean[] visited, ArrayDeque<Integer> stack, List<Integer>[] adjacencyList) {
        visited[v] = true;
        for (int neighbor : adjacencyList[v]) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor, visited, stack, adjacencyList);
            }
        }
        stack.addFirst(v);
    }

}
