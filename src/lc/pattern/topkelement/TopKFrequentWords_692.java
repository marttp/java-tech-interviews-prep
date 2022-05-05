package lc.pattern.topkelement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentWords_692 {

  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> freqWordMap = new HashMap<>();
    for (String w : words) {
      freqWordMap.put(w, freqWordMap.getOrDefault(w, 0) + 1);
    }
    PriorityQueue<Entry<String, Integer>> pq = new PriorityQueue<>(
        (a, b) -> {
          int result = Integer.compare(a.getValue(), b.getValue());
          return result != 0 ? result : b.getKey().compareTo(a.getKey());
        });
    List<String> result = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : freqWordMap.entrySet()) {
      pq.add(entry);
      if (pq.size() > k) {
        pq.poll();
      }
    }
    while (!pq.isEmpty()) {
      result.add(0, pq.poll().getKey());
    }
    return result;
  }
}
