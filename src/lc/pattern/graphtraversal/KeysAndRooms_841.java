package lc.pattern.graphtraversal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms_841 {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> visited = new HashSet<>();
    dfs(rooms, visited, 0);
    return visited.size() == rooms.size();
  }

  private void dfs(List<List<Integer>> rooms, Set<Integer> visited, int key) {
    if (!visited.contains(key)) {
      visited.add(key);
      for (int nextRoom : rooms.get(key)) {
        dfs(rooms, visited, nextRoom);
      }
    }
  }
}
