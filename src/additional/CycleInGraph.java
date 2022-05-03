package additional;

public class CycleInGraph {

  private static final int WHITE = 0; // Didn't process
  private static final int BLACK = 1; // Mark as not have any loop
  private static final int GRAY = 2; // currently progressing

  public boolean cycleInGraph(int[][] edges) {
    int n = edges.length;
    // Initial with black color
    int[] color = new int[n];
    for (int i = 0; i < n; i++) {
      if (cycleDetection(edges, i, color)) {
        return true;
      }
    }
    return false;
  }

  private boolean cycleDetection(int[][] edges, int index, int[] color) {
    if (color[index] == GRAY) {
      return true;
    }
    color[index] = GRAY;
    for (int next : edges[index]) {
      if (cycleDetection(edges, next, color)) {
        return true;
      }
    }
    color[index] = BLACK;
    return false;
  }
}
