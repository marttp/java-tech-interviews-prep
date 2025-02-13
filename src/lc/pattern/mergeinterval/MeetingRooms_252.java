package lc.pattern.mergeinterval;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms_252 {

    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length <= 1) {
            return true;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}
