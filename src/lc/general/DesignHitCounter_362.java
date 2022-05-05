package lc.general;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter_362 {

  private static class HitCounter {

    Queue<Integer> queue;

    public HitCounter() {
      queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
      queue.add(timestamp);
    }

    public int getHits(int timestamp) {
      int start = timestamp - 300;
      while (!queue.isEmpty() && queue.peek() <= start) {
        queue.poll();
      }
      return queue.size();
    }
  }
}
