package lc.pattern.mergeinterval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfArrowsToBurstBalloons_452 {

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        List<int[]> overlap = new ArrayList<>();
        overlap.add(points[0]);
        for (int i = 1; i < n; i++) {
            int[] last = overlap.getLast();
            if (last[1] < points[i][0]) {
                overlap.add(points[i]);
            }
        }
        return overlap.size();
    }
}
