package lc.general.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemovingStarsFromAString {

    class Solution {
        public String removeStars(String s) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                if (c == '*') {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    class Solution1 {
        public String removeStars(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == '*' && !stack.isEmpty()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.insert(0, stack.pop());
            }
            return sb.toString();
        }
    }
}
