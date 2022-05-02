package lc.blind75.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule_207 {

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // Course Schedule => Topological Sort strategy in BFS
    // 1. Initial graph & inDegree
    Map<Integer, List<Integer>> graph = new HashMap<>();
    int[] inDegree = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      graph.put(i, new ArrayList<>());
    }
    // 2. Create graph & inDegree from prerequisites
    // graph => represent parent => child (this question => this course -> next course)
    // inDegree => Incoming direct arrow to this vertex
    for (int[] pre : prerequisites) {
      int preCourse = pre[1];
      int currCourse = pre[0];
      graph.get(preCourse).add(currCourse);
      inDegree[currCourse]++;
    }
    // 3. Topological sort [BFS Strategy]
    //   3.1 Create Queue
    //   3.2 Put value that incoming degree == 0 to Queue (Put source to Queue)
    // Source: Vertex that have only outward edges
    // Sink: Vertex that have only inward edges
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) {
      if (inDegree[i] == 0) {
        q.add(i);
      }
    }
    // 4. Sort
    while (!q.isEmpty()) {
      int currCourse = q.poll();
      for (int nextCourse : graph.get(currCourse)) {
        inDegree[nextCourse]--;
        if (inDegree[nextCourse] == 0) {
          q.add(nextCourse);
        }
      }
    }
    // Optional step: Check inDegree to investigate any remaining, if remaining exist, not complete DAG
    for (int n : inDegree) {
      if (n != 0) {
        return false;
      }
    }
    return true;
  }
}
