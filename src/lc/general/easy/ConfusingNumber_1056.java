package lc.general.easy;

import java.util.Map;

public class ConfusingNumber_1056 {

    public boolean confusingNumber(int n) {
        if (n == 0) {
            return false;
        }
        int input = n;
        while (n % 10 == 0) {
            n /= 10;
        }
        Map<Integer, Integer> rotateMap = Map.of(
                0, 0,
                1, 1,
                6, 9,
                8, 8,
                9, 6
        );
        int rotate = 0;
        while (n != 0) {
            int digit = n % 10;
            if (!rotateMap.containsKey(digit)) {
                return false;
            }
            rotate = rotate * 10 + rotateMap.get(digit);
            n /= 10;
        }
        return rotate != input;
    }

}
