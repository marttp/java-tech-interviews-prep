package lc.general;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import utility.GenerateExample;

public class EvaluateRPN_150 implements GenerateExample {

  // Postfix
  // Example Input: ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
  public int evalRPN(String[] tokens) {
    Deque<Integer> stack = new ArrayDeque<>();
    Set<String> operatorSet = Set.of("+", "-", "*", "/");
    for (String t : tokens) {
      if (!operatorSet.contains(t)) {
        stack.addFirst(Integer.parseInt(t));
      } else {
        int operand2 = stack.removeFirst();
        int operand1 = stack.removeFirst();
        stack.addFirst(operation(t, operand1, operand2));
      }
    }
    return stack.peekFirst();
  }

  private int operation(String s, int left, int right) {
    return switch (s) {
      case "+" -> left + right;
      case "-" -> left - right;
      case "*" -> left * right;
      case "/" -> left / right;
      default -> 0;
    };
  }

  @Override
  public void example() {
    List<String> tokens = List.of("10", "6", "9", "3", "+",
        "-11", "*", "/", "*", "17", "+", "5", "+");
    int result = evalRPN(tokens.toArray(new String[0]));
    System.out.printf("Result: %d%n", result);
  }
}
