package datastructurealgorithms.bigo;

import datastructurealgorithms.sorting.BubbleSort;
import utility.Util;

import java.util.List;

public class QuadraticTime {
    public static int[] example() {
        return BubbleSort.sorted(Util.listToIntArray(List.of(5,2,6,4)));
    }
}
