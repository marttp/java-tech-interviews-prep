package lc.blind75.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeInterval_56 {

  public int[][] merge(int[][] intervals) {
    // Sort ASC by start time
    Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
    LinkedList<int[]> mergeResult = new LinkedList<>();
    mergeResult.add(intervals[0]);
    for (int i = 1; i < intervals.length; i++) {
      int[] lastMergedInterval = mergeResult.getLast();
      if (intervals[i][0] <= lastMergedInterval[1]) {
        lastMergedInterval[1] = Integer.max(lastMergedInterval[1], intervals[i][1]);
      } else {
        mergeResult.add(intervals[i]);
      }
    }
    return mergeResult.toArray(new int[0][2]);
  }
}
