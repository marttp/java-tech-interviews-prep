package realworld.network;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import utility.GenerateExample;

public class TotalTime implements GenerateExample {

  public int totalTime(int mainServerId, List<Integer> parents, List<Integer> delays) {
    if (parents == null || parents.size() <= 1) {
      return 0;
    }
    Map<Integer, List<Integer>> children = new HashMap<>();

    for (int i = 0; i < parents.size(); i++) {
      children.putIfAbsent(parents.get(i), new ArrayList<>());
      children.get(parents.get(i)).add(i);
    }

    int result = 0;
    Queue<List<Integer>> q = new LinkedList<>();
    q.add(List.of(mainServerId, delays.get(mainServerId)));
    while (!q.isEmpty()) {
      var curr = q.poll();
      result = Math.max(result, curr.get(1));
      for (var child : children.getOrDefault(curr.get(0), List.of())) {
        q.add(List.of(child, curr.get(1) + delays.get(child)));
      }
    }
    return result;
  }

  @Override
  public void example() {
    int mainServer = 0;
    List<Integer> parents = List.of(-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6);
    List<Integer> delays = List.of(1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0);
    System.out.println("Time required to reach all: " + totalTime(mainServer, parents, delays));
  }
}
