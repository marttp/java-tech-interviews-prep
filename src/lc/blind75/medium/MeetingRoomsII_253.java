package lc.blind75.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII_253 {

  public int minMeetingRooms(int[][] intervals) {
    if (intervals.length == 1) {
      return 1;
    }
    // Sort by start time
    // to reserve earliest room first
    Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));
    // then try to use min heap to store earliest end meeting time
    PriorityQueue<Integer> end = new PriorityQueue<>();
    int requiredRooms = 0;
    for (int[] interval : intervals) {
      int startTime = interval[0];
      int endTime = interval[1];
      while (!end.isEmpty() && end.peek() <= startTime) {
        end.poll();
      }
      end.add(endTime);
      requiredRooms = Integer.max(requiredRooms, end.size());
    }
    return requiredRooms;
  }
}
