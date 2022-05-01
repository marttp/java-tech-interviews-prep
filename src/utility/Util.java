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
}
