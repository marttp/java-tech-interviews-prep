package lc.general;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SmallestNumberInInfiniteSet_2336 {

    class SmallestInfiniteSet {

        private int index;
        private boolean[] existingStatus;

        public SmallestInfiniteSet() {
            index = 1;
            existingStatus = new boolean[1001];
            Arrays.fill(existingStatus, true);
        }

        public int popSmallest() {
            int targetIndex = index;
            while (targetIndex < 1001 && !existingStatus[targetIndex]) {
                targetIndex++;
            }
            existingStatus[targetIndex] = false;
            index = targetIndex;
            return index++;
        }

        public void addBack(int num) {
            if (existingStatus[num]) {
                return;
            }
            existingStatus[num] = true;
            index = Integer.min(index, num);
        }
    }

    class SmallestInfiniteSet1 {

        private final PriorityQueue<Integer> minHeap;
        private final boolean[] existingStatus;

        public SmallestInfiniteSet1() {
            minHeap = new PriorityQueue<>();
            existingStatus = new boolean[1001];
            Arrays.fill(existingStatus, true);
            for (int n = 1; n <= 1000; n++) {
                minHeap.add(n);
            }
        }

        public int popSmallest() {
            var target = minHeap.poll();
            existingStatus[target] = false;
            return target;
        }

        public void addBack(int num) {
            if (existingStatus[num]) {
                return;
            }
            minHeap.add(num);
            existingStatus[num] = true;
        }
    }

}
