package datastructurealgorithms.bigo;

import lc.pattern.backtracking.Subsets_78;
import utility.Util;

import java.util.List;

public class ExponentialTime {

    public static List<List<Integer>> example() {
        return new Subsets_78().subsets(Util.listToIntArray(List.of(5,2,6,4)));
    }
}
