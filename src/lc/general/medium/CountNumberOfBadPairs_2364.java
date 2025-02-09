package lc.general.medium;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfBadPairs_2364 {

    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            int key = nums[i] - i;
            // Reduce usage
            map.put(key, map.get(key) - 1);
            count += n - i - 1 - map.getOrDefault(key, 0);
        }

        return count;
    }

}
