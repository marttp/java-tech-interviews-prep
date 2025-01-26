package lc.general;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindTheDifferenceOfTwoArrays_2215 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        for (int n : nums1) {
            set1.add(n);
        }
        var set2 = new HashSet<Integer>();
        for (int n : nums2) {
            set2.add(n);
        }

        for (int n : nums1) {
            if (set1.contains(n) && set2.contains(n)) {
                set1.remove(n);
                set2.remove(n);
            }
        }

        return List.of(
                new ArrayList<>(set1),
                new ArrayList<>(set2));
    }

}
