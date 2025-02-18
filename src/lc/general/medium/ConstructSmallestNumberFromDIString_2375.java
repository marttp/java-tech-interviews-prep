package lc.general.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ConstructSmallestNumberFromDIString_2375 {

    public String smallestNumber(String pattern) {
        int max = pattern.length();
        int current = 0;
        char[] result = new char[max + 1];
        Arrays.fill(result, '0');

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) == 'I') {
                result[i] = (char) ((int) '0' + ++current);
                while (!stack.isEmpty()) {
                    int prevIndex = stack.pop();
                    result[prevIndex] = (char) ((int) '0' + ++current);
                }
            } else {
                stack.push(i);
            }
        }

        if (pattern.charAt(pattern.length() - 1) == 'D') {
            stack.push(max);
            while (!stack.isEmpty()) {
                int prevIndex = stack.pop();
                result[prevIndex] = (char) ((int) '0' + ++current);
            }
        } else {
            result[max] = (char) ((int) '0' + ++current);
        }

        return String.valueOf(result);
    }

}
