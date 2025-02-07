package lc.general.easy;

public class CountingElements_1426 {
    public int countElements(int[] arr) {
        int[] count = new int[1001];
        for (int a : arr) {
            count[a]++;
        }
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            if (count[i] != 0 && count[i + 1] != 0) {
                result += count[i];
            }
        }
        return result;
    }
}
