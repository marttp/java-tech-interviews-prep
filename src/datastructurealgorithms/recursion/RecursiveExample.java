package datastructurealgorithms.recursion;

public class RecursiveExample {

    public static void main(String[] args) {
        iterativeExample(5);
        System.out.println();
        recursiveExample(20);
    }

    private static void recursiveExample(int n) {
        var factorialResult = factorial(n);
        System.out.println("Factorial of " + n + " is " + factorialResult);
        var fibonacciResult = fibonacci(n);
        System.out.println("Fibonacci of " + n + " is " + fibonacciResult);
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    private static long factorial(int n) {
        // Base case
        if (n == 1) {
            return 1;
        }
        // Recursive case
        return factorial(n - 1) * n;
    }

    private static void iterativeExample(int n) {
        var result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println(result);
    }
}
