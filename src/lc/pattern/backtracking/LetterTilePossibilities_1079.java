package lc.pattern.backtracking;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities_1079 {


    public int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        boolean[] isUsed = new boolean[tiles.length()];
        StringBuilder sb = new StringBuilder();
        calculatePossibilities(tiles, sb, isUsed, result);
        return result.size();
    }

    public void calculatePossibilities(
            String tiles,
            StringBuilder sb,
            boolean[] isUsed,
            Set<String> result
    ) {
        if (!sb.isEmpty()) {
            result.add(sb.toString());
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                sb.append(tiles.charAt(i));
                calculatePossibilities(tiles, sb, isUsed, result);
                sb.deleteCharAt(sb.length() - 1);
                isUsed[i] = false;
            }
        }
    }

}
