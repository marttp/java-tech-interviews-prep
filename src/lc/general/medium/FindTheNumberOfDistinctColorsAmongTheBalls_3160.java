package lc.general.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindTheNumberOfDistinctColorsAmongTheBalls_3160 {

    public int[] queryResults(int limit, int[][] queries) {
        int size = queries.length;
        Map<Integer, Set<Integer>> colors = new HashMap<>();
        Map<Integer, Integer> relations = new HashMap<>();
        int[] result = new int[size];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int ball = query[0];
            int color = query[1];
            if (relations.containsKey(ball)) {
                int prevColor = relations.get(ball);
                colors.get(prevColor).remove(ball);
                if (colors.get(prevColor).isEmpty()) {
                    colors.remove(prevColor);
                }
            }
            colors.putIfAbsent(color, new HashSet<>());
            colors.get(color).add(ball);
            relations.put(ball, color);
            result[i] = colors.size();
        }
        return result;
    }

}
