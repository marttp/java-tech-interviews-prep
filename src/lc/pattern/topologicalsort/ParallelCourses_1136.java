package lc.pattern.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ParallelCourses_1136 {

  public int minimumSemester(int n, int[][] relations) {
    if (n == 0) {
      return 0;
    }
    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> inDegree = new HashMap<>();
    for (int i = 1; i <= n; i++) {
      graph.put(i, new ArrayList<>());
      inDegree.put(i, 0);
    }

    for (int[] relation : relations) {
      int preCourse = relation[0];
      int nextCourse = relation[1];
      graph.get(preCourse).add(nextCourse);
      inDegree.put(nextCourse, inDegree.get(nextCourse) + 1);
    }

    Queue<Integer> q = new LinkedList<>();
    for (var entry : inDegree.entrySet()) {
      if (entry.getValue() == 0) {
        q.add(entry.getKey());
      }
    }

    int semesters = 0;
    while (!q.isEmpty()) {
      int parallelSize = q.size();
      while (parallelSize-- > 0) {
        int course = q.poll();
        for (int nextCourse : graph.get(course)) {
          inDegree.put(nextCourse, inDegree.get(nextCourse) - 1);
          if (inDegree.get(nextCourse) == 0) {
            q.add(nextCourse);
          }
        }
      }
      semesters++;
    }

//    if (inDegree.values().stream().anyMatch(v -> v > 0)) {
//      return -1;
//    }
    for (int degree : inDegree.values()) {
      if (degree > 0) {
        return -1;
      }
    }

    return semesters;
  }
}
