package lc.blind75.hard;

import java.util.Collections;
import java.util.PriorityQueue;
import utility.GenerateExample;

public class FindMedianFromDataStream_295 implements GenerateExample {

  private static class MedianFinder {

    // to Store on left side
    private PriorityQueue<Integer> maxHeap;
    // to Store on right side
    private PriorityQueue<Integer> minHeap;

    // Keep right side have element >= left side
    public MedianFinder() {
      maxHeap = new PriorityQueue<>(Collections.reverseOrder());
      minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
      maxHeap.add(num);
      minHeap.add(maxHeap.poll());
      if (minHeap.size() > maxHeap.size()) {
        maxHeap.add(minHeap.poll());
      }
    }

    public double findMedian() {
      if (maxHeap.size() == minHeap.size()) {
        return maxHeap.peek() * 0.5 + minHeap.peek() * 0.5;
      }
      return minHeap.peek();
    }
  }


  @Override
  public void example() {
    MedianFinder mf = new MedianFinder();
    mf.addNum(2);
    mf.addNum(3);
    System.out.println("Current Median: " + mf.findMedian());
    mf.addNum(1);
    mf.addNum(6);
    mf.addNum(4);
    System.out.println("Current Median: " + mf.findMedian());
  }
}
