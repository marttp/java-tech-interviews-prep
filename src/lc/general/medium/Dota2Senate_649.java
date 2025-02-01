package lc.general.medium;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate_649 {

    public String predictPartyVictory(String senate) {
        int n = senate.length();
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = senate.charAt(i);
            if (c == 'R') {
                radiantQueue.add(i);
            } else {
                direQueue.add(i);
            }
        }
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            var r = radiantQueue.poll();
            var d = direQueue.poll();
            if (r < d) {
                // Ban D => Put itself to queue
                // But want to ignore next compare as well
                radiantQueue.add(r + n);
            } else {
                direQueue.add(d + n);
            }
        }
        return !radiantQueue.isEmpty() ? "Radiant" : "Dire";
    }
}
