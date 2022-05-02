package lc.blind75.medium;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {

  public int[][] insert(int[][] intervals, int[] newInterval) {
    if (intervals.length == 0) {
      return new int[][]{newInterval};
    }
    int n = intervals.length;
    List<int[]> result = new ArrayList<>();
    int i = 0;
    // 3 Step
    // 1. End time lower than start time of new interval
    while (i < n && intervals[i][1] < newInterval[0]) {
      result.add(intervals[i++]);
    }
    // 2. Conflict between newInterval, Merging start, end
    // Then add to interval
    while (i < n && intervals[i][0] <= newInterval[1]) {
      // we use newInterval to hold latest end time
      newInterval[0] = Integer.min(newInterval[0], intervals[i][0]);
      newInterval[1] = Integer.max(newInterval[1], intervals[i][1]);
      i++;
    }
    result.add(newInterval);
    // 3. The rest that doesn't affect
    while (i < n) {
      result.add(intervals[i++]);
    }
    return result.toArray(new int[0][2]);
  }
}
