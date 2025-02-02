package lc.pattern.unionfind;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision_399 {

    public double[] calcEquation(
            List<List<String>> equations,
            double[] values,
            List<List<String>> queries
    ) {
        var uf = new UnionFind();
        for (int i = 0; i < equations.size(); i++) {
            var equation = equations.get(i);
            var value = values[i];
            uf.union(equation.get(0), equation.get(1), value);
        }
        int n = queries.size();
        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            var query = queries.get(i);
            String c = query.get(0);
            String d = query.get(1);
            if (!uf.parent.containsKey(c) || !uf.parent.containsKey(d)) {
                result[i] = -1.0;
                continue;
            }
            String parentC = uf.find(c);
            String parentD = uf.find(d);
            if (!parentC.equals(parentD)) {
                result[i] = -1.0;
                continue;
            }
            result[i] = uf.weights.get(c) / uf.weights.get(d);
        }
        return result;
    }

    private static class UnionFind {
        public Map<String, String> parent;
        public Map<String, Double> weights;

        public UnionFind() {
            parent = new HashMap<>();
            weights = new HashMap<>();
        }

        private void preprocessor(String x) {
            parent.putIfAbsent(x, x);
            weights.putIfAbsent(x, 1.0);
        }

        public void union(String x, String y, double value) {
            preprocessor(x);
            preprocessor(y);
            String rootX = find(x);
            String rootY = find(y);
            if (!rootX.equals(rootY)) {
                parent.put(rootX, rootY);
                weights.put(rootX, weights.get(y) * value / weights.get(x));
            }
        }

        public String find(String x) {
            preprocessor(x);
            if (parent.get(x).equals(x)) {
                return x;
            }
            String original = parent.get(x);
            parent.put(x, find(parent.get(x)));
            weights.put(x, weights.get(x) * weights.get(original));
            return parent.get(x);
        }
    }

}
