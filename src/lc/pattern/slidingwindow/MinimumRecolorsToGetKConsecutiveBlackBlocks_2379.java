package lc.pattern.slidingwindow;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks_2379 {
    public int minimumRecolors(String blocks, int k) {
        char[] chars = blocks.toCharArray();
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int whiteCount = 0;
        while (right < blocks.length()) {
            char cr = chars[right++];
            if (right - left > k) {
                result = Integer.min(result, whiteCount);
                char cl = chars[left++];
                whiteCount -= cl == 'W' ? 1 : 0;
            }
            whiteCount += cr == 'W' ? 1 : 0;
        }
        return Integer.min(result, whiteCount);
    }
}
