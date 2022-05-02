package constant;

public class GraphConstant {

  // UP, RIGHT, DOWN, LEFT
  // บน ขวา ล่าง ซ้าย
  public static final int[][] FOUR_DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
  public static final int[] DIR_R = {-1, 0, 1, 0};
  public static final int[] DIR_C = {0, 1, 0, -1};

  // 8 DIRECTIONS
  public static final int[][] EIGHT_DIRECTIONS = {
      {-1, -1}, {-1, 0}, {-1, 1},
      {0, -1}, /*SKIP CENTER*/ {0, 1},
      {1, -1}, {1, 0}, {1, 1}
  };
}
