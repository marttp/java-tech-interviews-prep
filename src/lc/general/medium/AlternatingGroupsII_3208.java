package lc.general.medium;

public class AlternatingGroupsII_3208 {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;
        int[] temp = new int[n + k - 1];

        System.arraycopy(colors, 0, temp, 0, n);
        System.arraycopy(colors, 0, temp, n, k - 1);

        int count = 0;
        int left = 0;
        int right = 0;

        while (right < temp.length) {
            if (right > 0 && temp[right] == temp[right - 1]) {
                left = right;
            }

            if (right - left + 1 >= k) {
                count++;
            }

            right++;
        }

        return count;
    }
}
