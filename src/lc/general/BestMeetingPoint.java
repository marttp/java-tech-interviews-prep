package lc.general;

import java.util.ArrayList;
import java.util.List;

public class BestMeetingPoint {

  public int minTotalDistance(int[][] grid) {
    if (grid.length == 1 && grid[0].length == 1) {
      return 1;
    }
    var rows = collectOneFromRows(grid);
    var cols = collectOneFromCols(grid);
    return getDistance(rows) + getDistance(cols);
  }

  private int getDistance(List<Integer> list) {
    int distance = 0;
    int left = 0;
    int right = list.size() - 1;
    while (left <= right) {
      // don't forget! => we push number of index, not the value of that index
      distance += list.get(right) - list.get(left);
      left++;
      right--;
    }
    return distance;
  }

  private List<Integer> collectOneFromRows(int[][] grid) {
    List<Integer> rows = new ArrayList<>();
    /*
     * Traverse direction (RIGHT, DOWN)
     * */
    for (int row = 0; row < grid.length; row++) {
      for (int col = 0; col < grid[0].length; col++) {
        if (grid[row][col] == 1) {
          rows.add(row);
        }
      }
    }
    return rows;
  }

  private List<Integer> collectOneFromCols(int[][] grid) {
    List<Integer> cols = new ArrayList<>();
    /*
     * Traverse direction (DOWN, RIGHT)
     * */
    for (int col = 0; col < grid[0].length; col++) {
      for (int row = 0; row < grid.length; row++) {
        if (grid[row][col] == 1) {
          cols.add(col);
        }
      }
    }
    return cols;
  }
}
