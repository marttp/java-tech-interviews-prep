package lc.general.medium;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUniqueNumber_1429 {

    class FirstUnique {

        private Set<Integer> queue;
        private Set<Integer> seen;

        public FirstUnique(int[] nums) {
            queue = new LinkedHashSet<>();
            seen = new HashSet<>();
            for (int n : nums) {
                add(n);
            }
        }

        public int showFirstUnique() {
            return queue.isEmpty() ? -1 : queue.iterator().next();
        }

        public void add(int value) {
            if (!seen.add(value)) {
                queue.remove(value);
            } else {
                queue.add(value);
            }
        }
    }
}
