package lc.blind75;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms_252 {

  public boolean canAttendMeetingsOptimize(int[][] intervals) {
    if (intervals.length < 2) {
      return true;
    }
    Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
    int end = 0;
    for (int[] meeting : intervals) {
      if (end > meeting[0]) {
        return false;
      }
      end = meeting[1];
    }
    return true;
  }

  public boolean canAttendMeetings(int[][] intervals) {
    if (intervals.length < 2) {
      return true;
    }
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e[0]));
    Collections.addAll(pq, intervals);
    int end = 0;
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      if (end > curr[0]) {
        return false;
      }
      end = curr[1];
    }
    return true;
  }
}
