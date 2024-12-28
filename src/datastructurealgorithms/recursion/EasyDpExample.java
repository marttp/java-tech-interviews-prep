package datastructurealgorithms.recursion;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class EasyDpExample {

    public static void main(String[] args) {
        // Normal recursive
        // Fibonacci of 50 is 12586269025
        // Time taken: 32516 ms

        // Top-down approach
        // Fibonacci of 50 is 12586269025
        // Time taken: 6 ms

        // Bottom-up approach
        // Fibonacci of 50 is 12586269025
        // Time taken: 6 ms

        Instant start = Instant.now();

        bottomUpExample(50);

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Time taken: " + duration.toMillis() + " ms");
    }

    private static void recursiveExample(int n) {
        var fibonacciResult = fibonacci(n);
        System.out.println("Fibonacci of " + n + " is " + fibonacciResult);
    }

    private static void recursiveExampleTopDown(int n) {
        Map<Integer, Long> memo = new HashMap<>();
        var fibonacciResult = fibonacci(n, memo);
        System.out.println("Fibonacci of " + n + " is " + fibonacciResult);
    }

    private static void bottomUpExample(int n) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        for (int state = 2; state <= n; state++) {
            dp[state] = dp[state - 1] + dp[state - 2];
        }
        System.out.println("Fibonacci of " + n + " is " + dp[n]);
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static long fibonacci(int n, Map<Integer, Long> memo) {
        // Base case
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        if (n <= 1) {
            return n;
        }
        // Recursive case
        var result = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        memo.put(n, result);
        return memo.get(n);
    }
}
