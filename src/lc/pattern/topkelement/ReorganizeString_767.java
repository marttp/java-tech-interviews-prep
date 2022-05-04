package lc.pattern.topkelement;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString_767 {

  public String reorganizeString(String s) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
        (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())
    );
    pq.addAll(freqMap.entrySet());

    Map.Entry<Character, Integer> prev = null;
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      var curr = pq.poll();
      if (prev != null && prev.getValue() > 0) {
        pq.add(prev);
      }
      sb.append(curr.getKey());
      curr.setValue(curr.getValue() - 1);
      prev = curr;
    }

    return sb.length() == s.length() ? sb.toString() : "";
  }
}
