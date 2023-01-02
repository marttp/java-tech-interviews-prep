package datastructurealgorithms.bigo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static boolean hasDuplicateElement(List<Integer> a, List<Integer> b) {
        Set<Integer> set = new HashSet<>();
        for (int n : a) {
            set.add(n);
        }
        for (int n : b) {
            if (b.contains(n)) {
                return true;
            }
        }
        return false;
    }
}
