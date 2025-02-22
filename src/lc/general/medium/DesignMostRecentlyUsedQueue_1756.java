package lc.general.medium;

public class DesignMostRecentlyUsedQueue_1756 {

    class MRUQueue {
        private int[] nums;
        private int size;

        public MRUQueue(int n) {
            nums = new int[n];
            size = n;
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
        }

        public int fetch(int k) {
            k--;  // Convert to 0-based index
            int val = nums[k];

            // Shift elements in bulk using System.arraycopy
            System.arraycopy(nums, k + 1, nums, k, size - k - 1);
            nums[size - 1] = val;

            return val;
        }
    }

}
