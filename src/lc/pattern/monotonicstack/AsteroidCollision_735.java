package lc.pattern.monotonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision_735 {

    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int a : asteroids) {
            boolean isDestroyed = false;
            // Last seen need to be more than 0,
            // Otherwise, It's containing left direction
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                int lastAsteroid = stack.pop();
                int deducted = lastAsteroid + a;
                if (deducted == 0) {
                    isDestroyed = true;
                    break;
                } else if (deducted > 0) {
                    isDestroyed = true;
                    stack.push(lastAsteroid);
                    break;
                }
            }
            if (!isDestroyed) {
                stack.push(a);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

}
