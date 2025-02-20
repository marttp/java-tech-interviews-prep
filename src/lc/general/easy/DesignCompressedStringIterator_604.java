package lc.general.easy;

import java.util.LinkedList;
import java.util.Queue;

public class DesignCompressedStringIterator_604 {

    class StringIterator {

        private Queue<CharCount> queue;

        public StringIterator(String compressedString) {
            queue = new LinkedList<>();

            int current = 0;
            CharCount cc = null;
            for (char c : compressedString.toCharArray()) {
                if (Character.isDigit(c)) {
                    current = (current * 10) + Character.getNumericValue(c);
                } else {
                    if (cc != null) {
                        cc.amount = current;
                        queue.offer(cc);
                    }
                    cc = new CharCount();
                    cc.c = c;
                    current = 0;
                }
            }
            if (cc != null) {
                cc.amount = current;
                queue.offer(cc);
            }
        }

        public char next() {
            if (!hasNext()) {
                return ' ';
            }
            var cc = queue.peek();
            char ans = cc.c;
            cc.amount = cc.amount - 1;
            if (cc.amount == 0) {
                queue.poll();
            }
            return ans;
        }

        public boolean hasNext() {
            return !queue.isEmpty();
        }

        private class CharCount {
            char c;
            int amount;
        }
    }

}
