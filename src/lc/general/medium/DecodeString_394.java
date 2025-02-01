package lc.general.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecodeString_394 {
    public String decodeString(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<StringBuilder> sbStack = new ArrayDeque<>();
        int current = 0;
        StringBuilder wordBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                stack.push(current);
                sbStack.push(wordBuilder);
                current = 0;
                wordBuilder = new StringBuilder();
            } else if (c == ']') {
                int prevCount = stack.pop();
                String chunkWord = wordBuilder.toString().repeat(prevCount);
                wordBuilder = sbStack.pop();
                wordBuilder.append(chunkWord);
            } else if (Character.isDigit(c)) {
                current = current * 10 + Character.getNumericValue(c);
            } else {
                wordBuilder.append(c);
            }
        }
        return wordBuilder.toString();
    }
}
