package utility;

public class MathUtil {

  public static long manhattanDistance(int x1, int x2, int y1, int y2) {
    return Math.abs(x1 - x2) + Math.abs(y1 - y2);
  }
}
