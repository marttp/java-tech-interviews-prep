package datastructurealgorithms.graph.topological;

import java.util.*;
import java.util.stream.Collectors;

public class TopologicalDemo {

    public static void main(String[] args) {
        var referenceMap = csCourses.stream()
                .collect(Collectors.toMap(Course::courseId, c -> c));
        // Adjacency List + inDegree graph
        // course => next possible course (prerequisite)
        // inDegree => storing on data which no in degree
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (var course : csCourses) {
            graph.putIfAbsent(course.courseId(), new ArrayList<>());
            inDegree.putIfAbsent(course.courseId(), 0);
            if (!course.prerequisite().isEmpty()) {
                for (var prerequisiteCourse : course.prerequisite()) {
                    graph.get(prerequisiteCourse).add(course.courseId());
                    inDegree.put(course.courseId(), inDegree.get(course.courseId()) + 1);
                }
            }
        }

        // BFS => Queue
        Queue<Integer> queue = new LinkedList<>();
        // Select only in-degree = 0
        inDegree.entrySet().stream().filter(e -> e.getValue() == 0)
                .forEach(e -> queue.offer(e.getKey()));

        List<Integer> traverseResult = new ArrayList<>();
        while (!queue.isEmpty()) {
            int courseId = queue.poll();
            traverseResult.add(courseId);
            for (var nextCourse : graph.get(courseId)) {
                inDegree.put(nextCourse, inDegree.get(nextCourse) - 1);
                if (inDegree.get(nextCourse) == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // Check in-degree if any in-degree more than 0
        if (inDegree.values().stream().anyMatch(e -> e > 0)) {
            throw new IllegalArgumentException("Some courses are not valid");
        }

        for (var id : traverseResult) {
            System.out.println("Study: " + referenceMap.get(id));
        }
    }

    private static final List<Course> csCourses = List.of(
            new Course(1, "Introduction to Computer Science", List.of()),
            new Course(2, "Statistics", List.of()),
            new Course(3, "Discrete Math", List.of()),
            new Course(4, "Data Structures & Algorithms", List.of()),
            new Course(5, "Digital", List.of()),
            new Course(6, "Data Communication", List.of()),
            new Course(7, "Mobile App Development", List.of(1, 4)),
            new Course(8, "Web Application", List.of(1, 4)),
            new Course(9, "Software Engineering", List.of(4)),
            new Course(10, "Database", List.of(4)),
            new Course(11, "Computer Architecture & Organization", List.of(5)),
            new Course(12, "IoT Development", List.of(11)),
            new Course(13, "Operating Systems", List.of(4, 11)),
            new Course(14, "Computer Network", List.of(6)),
            new Course(15, "Computer Security", List.of(11, 14)),
            new Course(16, "Cloud Computing", List.of(9)),
            new Course(17, "Operations for SDLC", List.of(9)),
            new Course(18, "Data Engineering", List.of(10)),
            new Course(19, "Artificial Intelligence", List.of(1, 2)),
            new Course(20, "Graduate!", List.of(3, 13, 15, 16, 17, 19))
    );
}
