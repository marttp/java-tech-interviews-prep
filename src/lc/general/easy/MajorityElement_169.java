package lc.general.easy;

public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = Integer.MIN_VALUE;
        for (int n : nums) {
            if (count == 0) {
                candidate = n;
            }
            count += (n == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
