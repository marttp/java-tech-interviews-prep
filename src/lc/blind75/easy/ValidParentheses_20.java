package lc.blind75.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses_20 {

  public boolean isValid(String s) {
    Map<Character, Character> map = Map.of(
        ')', '(',
        ']', '[',
        '}', '{'
    );

    Deque<Character> stack = new ArrayDeque<>();
    for (char c : s.toCharArray()) {
      if (map.containsKey(c)) {
        if (stack.isEmpty()) {
          return false;
        }
        char openChar = stack.removeFirst();
        if (openChar != map.get(c)) {
          return false;
        }
      } else {
        stack.addFirst(c);
      }
    }

    return stack.isEmpty();
  }
}
