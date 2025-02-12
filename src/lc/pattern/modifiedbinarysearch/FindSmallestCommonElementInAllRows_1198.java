package lc.pattern.modifiedbinarysearch;

import java.util.*;

public class FindSmallestCommonElementInAllRows_1198 {

    class Solution2 {
        public int smallestCommonElement(int[][] mat) {
            int m = mat.length;
            int n = mat[0].length;
            for (int i = 0; i < n; i++) {
                boolean isFound = true;
                for (int j = 1; j < m; j++) {
                    // Note that this guarantees that
                    // the return value will be >= 0 if and only if the key is found.
                    isFound = Arrays.binarySearch(mat[j], mat[0][i]) >= 0;
                    if (!isFound) {
                        break;
                    }
                }
                if (isFound) {
                    return mat[0][i];
                }
            }
            return -1;
        }
    }

    class Solution1 {
        public int smallestCommonElement(int[][] mat) {
            int size = mat.length;
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int r = 0; r < mat.length; r++) {
                for (int c = 0; c < mat[0].length; c++) {
                    map.putIfAbsent(mat[r][c], new HashSet<>());
                    map.get(mat[r][c]).add(r);
                    if (map.get(mat[r][c]).size() == size) {
                        return mat[r][c];
                    }
                }
            }
            return -1;
        }
    }
}
