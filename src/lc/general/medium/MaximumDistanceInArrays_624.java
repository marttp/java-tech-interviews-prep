package lc.general.medium;

import java.util.List;

public class MaximumDistanceInArrays_624 {

    public int maxDistance(List<List<Integer>> arrays) {
        int result = 0;
        int min = arrays.get(0).getFirst();
        int max = arrays.get(0).getLast();
        for (int i = 1; i < arrays.size(); i++) {
            int nextMin = arrays.get(i).getFirst();
            int nextMax = arrays.get(i).getLast();
            result = Integer.max(result, Math.abs(min - nextMax));
            result = Integer.max(result, Math.abs(max - nextMin));
            min = Integer.min(min, nextMin);
            max = Integer.max(max, nextMax);
        }
        return result;
    }
}