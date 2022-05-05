package lc.pattern.topkelement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class LongestHappyString_1405 {
  public String longestDiverseString(int a, int b, int c) {
    Map<Character, Integer> map = new HashMap<>();
    if (a > 0) {
      map.put('a', a);
    }
    if (b > 0) {
      map.put('b', b);
    }
    if (c > 0) {
      map.put('c', c);
    }

    PriorityQueue<Entry<Character, Integer>> pq =
        new PriorityQueue<>((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));
    pq.addAll(map.entrySet());

    StringBuilder sb = new StringBuilder();
    Map.Entry<Character, Integer> holder = null;

    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> curr = pq.poll();
      if (holder != null && holder.getValue() != 0) {
        pq.add(holder);
      }
      int amount = 0;
      if (holder != null && holder.getValue() > 0) {
        amount = Integer.min(holder.getValue() > curr.getValue() ? 1 : 2, curr.getValue());
      } else {
        amount = Integer.min(2, curr.getValue());
      }
      sb.append(String.valueOf(curr.getKey()).repeat(amount));
      curr.setValue(curr.getValue() - amount);
      holder = curr;
    }

    return sb.toString();
  }
}
