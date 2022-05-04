package lc.pattern.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperature_739 {

  public int[] dailyTemperatures(int[] temperatures) {
    if (temperatures == null || temperatures.length == 0) {
      return new int[0];
    }
    int[] answer = new int[temperatures.length];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[stack.peekFirst()] < temperatures[i]) {
        int prevIndex = stack.removeFirst();
        answer[i] = i - prevIndex;
      }
      stack.addFirst(i);
    }
    return answer;
  }
}
