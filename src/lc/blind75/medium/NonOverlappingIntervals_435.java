package lc.blind75.medium;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals_435 {

  public int eraseOverlapIntervals(int[][] intervals) {
    // return minimum number to remove
    // to make intervals not overlap at all
    int n = intervals.length;
    if (n <= 1) {
      return 0;
    }
    // Sort end time ascending
    Arrays.sort(intervals, Comparator.comparingInt(e -> e[1]));
    int endTime = intervals[0][1];
    int count = 0;
    for (int i = 1; i < n; i++) {
      if (endTime <= intervals[i][0]) {
        endTime = intervals[i][1];
        count++;
      }
    }
    return n - count;
  }
}
