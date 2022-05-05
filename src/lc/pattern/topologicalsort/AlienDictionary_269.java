package lc.pattern.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDictionary_269 {

  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) {
      return "";
    }
    Map<Character, Integer> inDegree = new HashMap<>();
    Map<Character, List<Character>> graph = new HashMap<>();
    for (var s : words) {
      if (!s.isEmpty()) {
        for (char c : s.toCharArray()) {
          inDegree.put(c, 0);
          graph.putIfAbsent(c, new ArrayList<>());
        }
      }
    }

    for (int i = 0; i < words.length - 1; i++) {
      String w1 = words[i];
      String w2 = words[i + 1];
      for (int j = 0; j < w1.length(); j++) {
        // Length is invalid
        if (j == w2.length()) {
          return "";
        }
        char parent = w1.charAt(j);
        char child = w2.charAt(j);
        if (parent != child) {
          inDegree.put(child, inDegree.get(child) + 1);
          graph.get(parent).add(child);
          break;
        }
      }
    }

    Queue<Character> q = new LinkedList<>();
    for (var entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) {
        q.add(entry.getKey());
      }
    }

    StringBuilder sortedOrder = new StringBuilder();
    while (!q.isEmpty()) {
      char c = q.poll();
      sortedOrder.append(c);
      for (char next : graph.get(c)) {
        inDegree.put(next, inDegree.get(next) - 1);
        if (inDegree.get(next) == 0) {
          q.add(next);
        }
      }
    }

    if (sortedOrder.length() != inDegree.size()) {
      return ""; // Invalid
    }

    return sortedOrder.toString();
  }
}
