package datastructurealgorithms.bigo;

import datastructurealgorithms.sorting.QuickSort;
import utility.Util;

import java.util.List;

public class LogLinearTime {

    public static int[] example() {
        return QuickSort.sorted(Util.listToIntArray(List.of(5,2,6,4)));
    }
}
