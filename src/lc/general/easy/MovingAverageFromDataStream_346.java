package lc.general.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream_346 {

    static class MovingAverage {

        private final int size;
        private int sum;
        private final Queue<Integer> queue;

        public MovingAverage(int size) {
            this.size = size;
            this.sum = 0;
            this.queue = new LinkedList<>();
        }

        public double next(int val) {
            sum += val;
            queue.offer(val);
            if (queue.size() > size) {
                int removedNum = queue.poll();
                sum -= removedNum;
            }
            return (double) sum / queue.size();
        }
    }

}
