package lc.general;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation_1386 {

  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    // Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent
    // so that's mean 3 | 4 | 3
    // 4 group can be in 2,3,4,5 | 4,5,6,7 | 6,7,8,9
    Map<Integer, Integer> mapSeat = new HashMap<>();
    for (int[] row : reservedSeats) {
      int r = row[0];
      int label = row[1];
      // 10 - label => เราทำจากท้าย
      mapSeat.put(r, mapSeat.getOrDefault(r, 0) | 1 << (10 - label));
    }
    // maximum per row => 2
    int res = (n - mapSeat.size()) * 2; // กรณีที่มีบางแถวไม่มีเลย
    for (int row : mapSeat.keySet()) {
      int seat = mapSeat.get(row);
      // Bitwise 0b0111111110 => Expected value
      // if seat == 0b0000000000 => ถึงจะจองที่นั่งแบบนี้ได้เท่านั้น
      if ((seat & 0b0111111110) == 0) {
        res += 2;
      } else if ((seat & 0b0111100000) == 0 ||
          (seat & 0b0001111000) == 0 ||
          (seat & 0b0000011110) == 0) {
        res += 1;
      }
    }
    return res;
  }
}
