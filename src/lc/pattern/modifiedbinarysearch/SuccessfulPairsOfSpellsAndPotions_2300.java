package lc.pattern.modifiedbinarysearch;

import java.util.Arrays;

public class SuccessfulPairsOfSpellsAndPotions_2300 {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] result = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                long spell = spells[i];
                int mid = left + (right - left) / 2;
                if (spell * potions[mid] < success) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            int length = m - left;
            result[i] = length;
        }
        return result;
    }

}
