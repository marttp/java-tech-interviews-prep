package lc.pattern.topkelement;

import java.util.PriorityQueue;
import lc.common.Point;

public class KClosestPointsToOrigin_973 {

  public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<CoordinatePoint> maxHeap = new PriorityQueue<>(
        (e1, e2) -> Double.compare(e2.distance, e1.distance)
    );
    for (int[] p : points) {
      maxHeap.add(new CoordinatePoint(p[0], p[1]));
      if (maxHeap.size() > k) {
        maxHeap.poll();
      }
    }
    int[][] result = new int[maxHeap.size()][2];
    int writeIndex = 0;
    while (!maxHeap.isEmpty()) {
      var point = maxHeap.poll();
      result[writeIndex][0] = point.x;
      result[writeIndex][1] = point.y;
      writeIndex++;
    }
    return result;
  }

  private static class CoordinatePoint extends Point {

    public double distance;

    public CoordinatePoint(int x, int y) {
      super(x, y);
      this.distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
  }
}
