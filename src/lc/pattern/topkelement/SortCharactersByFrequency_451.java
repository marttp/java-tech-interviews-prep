package lc.pattern.topkelement;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class SortCharactersByFrequency_451 {

  public String frequencySort(String s) {
    if (s == null || s.length() == 0) {
      return "";
    }
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }
    PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<>(
        (e1, e2) -> Integer.compare(e2.getValue(), e1.getValue())
    );
    pq.addAll(freqMap.entrySet());

    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      var curr = pq.poll();
      sb.append(String.valueOf(curr.getKey()).repeat(curr.getValue()));
    }
    return sb.toString();
  }
}
