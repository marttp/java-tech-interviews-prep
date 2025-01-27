package lc.general;

import java.util.*;

public class CourseScheduleIV_1462 {

    public List<Boolean> checkIfPrerequisite(
            int numCourses,
            int[][] prerequisites,
            int[][] queries
    ) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (var p : prerequisites) {
            adjList.putIfAbsent(p[0], new ArrayList<>());
            adjList.get(p[0]).add(p[1]);
        }

        boolean[][] isPrerequisiteTable = new boolean[numCourses][numCourses];
        for (int course = 0; course < numCourses; course++) {
            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(course);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next : adjList.getOrDefault(current, List.of())) {
                    if (!isPrerequisiteTable[course][next]) {
                        isPrerequisiteTable[course][next] = true;
                        queue.offer(next);
                    }
                }
            }
        }

        List<Boolean> result = new ArrayList<>();
        for (var q : queries) {
            result.add(isPrerequisiteTable[q[0]][q[1]]);
        }
        return result;
    }

    public List<Boolean> checkIfPrerequisiteNaive(
            int numCourses,
            int[][] prerequisites,
            int[][] queries
    ) {
        Map<Integer, Set<Integer>> inDegree = new HashMap<>();
        // Init
        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i, new HashSet<>());
        }
        // Bind course relation
        for (var p : prerequisites) {
            int pre = p[0];
            int next = p[1];
            inDegree.get(next).add(pre);
            if (!inDegree.get(pre).isEmpty()) {
                inDegree.get(next).addAll(inDegree.get(pre));
            }
            for (var entry : inDegree.entrySet()) {
                if (entry.getValue().contains(next)) {
                    entry.getValue().add(pre);
                    entry.getValue().addAll(inDegree.get(pre));
                }
            }
        }
        List<Boolean> result = new ArrayList<>();
        for (var q : queries) {
            int pre = q[0];
            int course = q[1];
            result.add(inDegree.get(course).contains(pre));
        }
        return result;
    }
}
