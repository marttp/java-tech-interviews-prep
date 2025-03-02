package lc.pattern.twopointers;

import java.util.ArrayList;
import java.util.List;

public class MergeTwo2DArraysBySummingValues_2570 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;
        while (i1 < nums1.length && i2 < nums2.length) {
            int[] curr = new int[2];
            if (nums1[i1][0] == nums2[i2][0]) {
                curr[0] = nums1[i1][0];
                curr[1] = nums1[i1++][1] + nums2[i2++][1];
            } else if (nums1[i1][0] < nums2[i2][0]) {
                curr[0] = nums1[i1][0];
                curr[1] = nums1[i1++][1];
            } else {
                curr[0] = nums2[i2][0];
                curr[1] = nums2[i2++][1];
            }
            result.add(curr);
        }
        while (i1 < nums1.length) {
            int[] curr = new int[2];
            curr[0] = nums1[i1][0];
            curr[1] = nums1[i1++][1];
            result.add(curr);
        }
        while (i2 < nums2.length) {
            int[] curr = new int[2];
            curr[0] = nums2[i2][0];
            curr[1] = nums2[i2++][1];
            result.add(curr);
        }
        return result.toArray(new int[0][2]);
    }
}
