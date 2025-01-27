package lc.general;

import java.util.*;

public class CourseScheduleIV_1462 {

    public List<Boolean> checkIfPrerequisiteSolution1(
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
