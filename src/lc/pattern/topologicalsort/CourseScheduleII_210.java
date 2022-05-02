package lc.pattern.topologicalsort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import utility.Util;

public class CourseScheduleII_210 {

  // Kahn's Algorithm
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph.put(i, new ArrayList<>());
    }

    for (int[] pre : prerequisites) {
      int preCourse = pre[1];
      int currCourse = pre[0];
      graph.get(preCourse).add(currCourse);
      inDegree[currCourse]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[0] == 0) {
        q.add(i);
      }
    }

    List<Integer> sortOrder = new ArrayList<>();
    // or use writeIndex pattern
    // int writeIndex = 0;
    // int[] sorted = new int[numCourses];
    while (!q.isEmpty()) {
      int currCourse = q.poll();
      sortOrder.add(currCourse);
      // sorted[writeIndex++] = currCourse;
      for (int nextCourse : graph.get(currCourse)) {
        inDegree[nextCourse]--;
        if (inDegree[nextCourse] == 0) {
          q.add(nextCourse);
        }
      }
    }

    for (int n : inDegree) {
      if (n != 0) {
        return new int[0];
      }
    }

    return Util.listToIntArray(sortOrder);
  }
}
