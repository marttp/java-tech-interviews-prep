package lc.general;

public class CanPlaceFlowers_605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0 || flowerbed == null) {
            return true;
        }
        if (flowerbed.length == 1 && n <= 1 && flowerbed[0] == 0) {
            return true;
        }
        int length = flowerbed.length;
        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                // Start
                if (i == 0 && i + 1 < length - 1 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
                // End
                else if (i == length - 1 && i - 1 >= 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
                // Between
                else if (i + 1 < length - 1 &&
                        flowerbed[i + 1] == 0 &&
                        flowerbed[i - 1] == 0
                ) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
            if (n == 0) {
                return true;
            }
        }
        return false;
    }

}
