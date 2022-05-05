package lc.pattern.topkelement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class RearrangeStringKDistanceApart_358 {

  public String rearrangeString(String s, int k) {
    if (s == null || s.isEmpty() || k == 0) {
      return s;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Entry<Character, Integer>> pq =
        new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
    pq.addAll(map.entrySet());

    StringBuilder sb = new StringBuilder();
    Queue<Entry<Character, Integer>> q = new LinkedList<>();

    while (!pq.isEmpty()) {
      // Burn Character
      Map.Entry<Character, Integer> current = pq.poll();
      sb.append(current.getKey());
      current.setValue(current.getValue() - 1);
      q.add(current);
      if (q.size() == k) {
        Map.Entry<Character, Integer> pending = q.poll();
        if (pending.getValue() > 0) {
          pq.add(pending);
        }
      }
    }

    return sb.length() == s.length() ? sb.toString() : "";
  }
}
