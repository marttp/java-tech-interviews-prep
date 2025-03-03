package lc.general.medium;

import java.util.LinkedList;
import java.util.Queue;

public class PartitionArrayAccordingToGivenPivot_2161 {

    class Solution1 {
        public int[] pivotArray(int[] nums, int pivot) {
            Queue<Integer>[] bucket = new Queue[2];
            int pivotCounter = 0;
            bucket[0] = new LinkedList<>();
            bucket[1] = new LinkedList<>();

            for (int n : nums) {
                if (n == pivot) {
                    pivotCounter++;
                } else {
                    int index = n > pivot ? 1 : 0;
                    bucket[index].add(n);
                }
            }

            int i = 0;
            while (!bucket[0].isEmpty()) {
                nums[i++] = bucket[0].poll();
            }
            while (pivotCounter-- > 0) {
                nums[i++] = pivot;
            }
            while (!bucket[1].isEmpty()) {
                nums[i++] = bucket[1].poll();
            }

            return nums;
        }
    }

    class Solution2 {
        public int[] pivotArray(int[] nums, int pivot) {
            int length = nums.length;
            int[] result = new int[length];
            int writeIndex = 0;
            for (int n : nums) {
                if (n < pivot) {
                    result[writeIndex++] = n;
                }
            }
            for (int n : nums) {
                if (n == pivot) {
                    result[writeIndex++] = n;
                }
            }
            for (int n : nums) {
                if (n > pivot) {
                    result[writeIndex++] = n;
                }
            }
            return result;
        }
    }
}
