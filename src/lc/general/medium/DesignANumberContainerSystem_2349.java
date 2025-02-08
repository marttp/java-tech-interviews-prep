package lc.general.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class DesignANumberContainerSystem_2349 {

    class NumberContainers {

        private Map<Integer, TreeSet<Integer>> numToIndexMap;
        private Map<Integer, Integer> indexToValueMap;

        public NumberContainers() {
            numToIndexMap = new HashMap<>();
            indexToValueMap = new HashMap<>();
        }

        public void change(int index, int number) {
            if (indexToValueMap.containsKey(index)) {
                int prevNum = indexToValueMap.get(index);
                numToIndexMap.get(prevNum).remove(index);
            }
            indexToValueMap.put(index, number);
            numToIndexMap.putIfAbsent(number, new TreeSet<>());
            numToIndexMap.get(number).add(index);
        }

        public int find(int number) {
            if (!numToIndexMap.containsKey(number)) {
                return -1;
            }
            var set = numToIndexMap.get(number);
            return set.isEmpty() ? -1 : set.first();
        }
    }
}
