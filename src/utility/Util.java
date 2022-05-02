package utility;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Util {

  public static int[] listToIntArray(List<Integer> list) {
    return list.stream().mapToInt(Integer::intValue).toArray();
  }

  public static int sum(int[] nums) {
    return IntStream.of(nums).sum();
  }

  public static long sum(long[] nums) {
    return LongStream.of(nums).sum();
  }

  public static int sum(List<Integer> list) {
    return list.stream().mapToInt(Integer::intValue).sum();
  }

  public static int min3Elem(int a, int b, int c) {
    return Math.min(a, Math.min(b, c));
  }

  public static int max3Elem(int a, int b, int c) {
    return Math.max(a, Math.max(b, c));
  }

  public static boolean isInbound(char[][] grid, int r, int c) {
    return r >= 0 && r < grid.length && c >= 0 && c < grid.length;
  }

  public static boolean isInbound(int[][] grid, int r, int c) {
    return r >= 0 && r < grid.length && c >= 0 && c < grid.length;
  }
}
