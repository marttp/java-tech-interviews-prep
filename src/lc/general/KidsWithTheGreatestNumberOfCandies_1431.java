package lc.general;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies_1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) {
            max = Integer.max(c, max);
        }
        List<Boolean> result = new ArrayList<>();
        for (int c : candies) {
            result.add((c + extraCandies) >= max);
        }
        return result;
    }
}
