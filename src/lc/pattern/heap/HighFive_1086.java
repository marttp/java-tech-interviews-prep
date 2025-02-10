package lc.pattern.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HighFive_1086 {

    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> scores = new HashMap<>();
        for (var score : items) {
            scores.putIfAbsent(score[0], new PriorityQueue<>());
            scores.get(score[0]).add(score[1]);
            if (scores.get(score[0]).size() > 5) {
                scores.get(score[0]).poll();
            }
        }
        int size = scores.size();
        int[][] result = new int[size][2];
        int i = 0;
        for (var entry : scores.entrySet()) {
            int sum = 0;
            while (!entry.getValue().isEmpty()) {
                sum += entry.getValue().poll();
            }
            result[i][0] = entry.getKey();
            result[i][1] = sum / 5;
            i++;
        }
        return result;
    }

}
