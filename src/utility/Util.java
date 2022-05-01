package utility;

import java.util.List;

public class Util {

  public static int[] listToIntArray(List<Integer> list) {
    return list.stream().mapToInt(Integer::intValue).toArray();
  }
}
