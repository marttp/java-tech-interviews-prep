package lc.pattern.unionfind;

public class RedundantConnection_684 {

    public int[] findRedundantConnection(int[][] edges) {
        int[] result = new int[2];
        var uf = new UnionFind(edges.length);
        for (var edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                result = edge;
            }
        }
        return result;
    }

    private static class UnionFind {
        public int[] parent;

        public UnionFind(int n) {
            // Easier in index management
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
                return true;
            }
            return false;
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

}
