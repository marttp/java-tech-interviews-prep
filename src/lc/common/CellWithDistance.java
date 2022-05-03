package lc.common;

public class CellWithDistance extends Cell {

  public int distance;

  public CellWithDistance(int x, int y) {
    super(x, y);
  }

  public CellWithDistance(int x, int y, int distance) {
    super(x, y);
    this.distance = distance;
  }
}
