package datastructurealgorithms.bigo;

import java.util.List;

public class LinearTime {

    public static int sum(int n) {
        int result = 0;

        for (int i = 0; i < n; i++) {
            result += i;
        }

        return result;
    }

    public static List<Integer> findingMinMax1(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Integer.min(min, array[i]);
            max = Integer.max(max, array[i]);
        }
        return List.of(min, max);
    }

    public static List<Integer> findingMinMax2(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Integer.min(min, array[i]);
        }
        for (int i = 0; i < array.length; i++) {
            max = Integer.max(max, array[i]);
        }
        return List.of(min, max);
    }
}
