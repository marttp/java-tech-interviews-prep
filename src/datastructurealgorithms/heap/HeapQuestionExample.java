package datastructurealgorithms.heap;

import utility.Util;

import java.util.*;

public class HeapQuestionExample {

    public static void main(String[] args) {
        var topKFrequentResult = topKFrequentElements(Util.listToIntArray(List.of(1, 1, 1, 2, 2, 3)), 2);
        System.out.println("Top K frequent elements: " + topKFrequentResult);
        var kClosestPointResult = kClosestPoints(
                List.of(List.of(3, 3), List.of(5, -1), List.of(-2, 4)), 2
        );
        System.out.println("K closest point: " + kClosestPointResult);
        var sortCharacterByFrequencyResult = sortCharacterByFrequency("Aabb");
        System.out.println("Sort character by Frequency: " + sortCharacterByFrequencyResult);
    }

    private static List<Integer> topKFrequentElements(int[] arr, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int n : arr) {
            countMap.put(n, countMap.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a, b) -> countMap.get(b).compareTo(countMap.get(a))
        );
        maxHeap.addAll(countMap.keySet());
        int current = k;
        List<Integer> result = new ArrayList<>();
        while (current-- > 0) {
            result.add(maxHeap.poll());
        }
        return result;
    }

    private static List<List<Integer>> kClosestPoints(List<List<Integer>> points, int k) {
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> Integer.compare(euclideanDistance(a), euclideanDistance(b))
        );
        minHeap.addAll(points);
        List<List<Integer>> result = new ArrayList<>();
        var current = k;
        while (current-- > 0) {
            result.add(minHeap.poll());
        }
        return result;
    }

    private static int euclideanDistance(List<Integer> arr) {
        return (int) Math.sqrt(Math.pow(arr.get(0), 2) + Math.pow(arr.get(1), 2));
    }

    private static String sortCharacterByFrequency(String s) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) ->
                        b.getValue().compareTo(a.getValue())
                );
        maxHeap.addAll(countMap.entrySet());

        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            var entry = maxHeap.poll();
            var n = entry.getValue();
            while (n-- > 0) {
                result.append(entry.getKey());
            }
        }
        return result.toString();
    }
}
