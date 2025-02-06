package lc.general.medium;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct_1726 {

    public int tupleSameProduct(int[] nums) {
        int count = 0;
        Map<Long, Integer> valueFreq = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                long productValue = nums[i] * nums[j];
                valueFreq.put(productValue, valueFreq.getOrDefault(productValue, 0) + 1);
            }
        }
        for (var freq : valueFreq.values()) {
            if (freq > 1) {
                // 8 combination of a,b,c,d
                count += freq * (freq - 1) / 2 * 8;
            }
        }
        return count;
    }
}
