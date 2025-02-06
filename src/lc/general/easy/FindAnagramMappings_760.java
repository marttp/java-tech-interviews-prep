package lc.general.easy;

import java.util.HashMap;
import java.util.Map;

public class FindAnagramMappings_760 {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        Map<Integer, Integer> valToIdx = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            valToIdx.put(nums2[i], i);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            result[i] = valToIdx.get(nums1[i]);
        }
        return result;
    }
}
