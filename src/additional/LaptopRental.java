package additional;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LaptopRental {

  public int laptopRental(List<List<Integer>> times) {
    // Sort by starting time asc
    times.sort(Comparator.comparingInt(e -> e.get(0)));
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int max = 0;
    for (List<Integer> t : times) {
      while (!pq.isEmpty() && pq.peek() <= t.get(0)) {
        pq.poll();
      }
      // Add end time of rent laptop
      pq.add(t.get(1));
      max = Integer.max(max, pq.size());
    }
    return max;
  }
}
