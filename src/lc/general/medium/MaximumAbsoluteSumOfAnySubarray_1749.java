package lc.general.medium;

public class MaximumAbsoluteSumOfAnySubarray_1749 {

    public int maxAbsoluteSum(int[] nums) {
        int currentMin = 0;
        int minSoFar = 0;
        int currentMax = 0;
        int maxSoFar = 0;

        for (int n : nums) {
            currentMin = Math.min(0, currentMin + n);
            minSoFar = Math.min(minSoFar, currentMin);

            currentMax = Math.max(0, currentMax + n);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return Math.max(maxSoFar, Math.abs(minSoFar));
    }
}
