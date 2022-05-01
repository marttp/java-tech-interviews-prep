package lc.blind75;

import lc.common.unionfind.UnionFind;
import lc.common.unionfind.UnionFindMap;
import utility.GenerateExample;

public class GraphValidTree_261 implements GenerateExample {

  public boolean validTree(int n, int[][] edges) {
    // check edges case => edge ของ Tree ไม่ครบ
    if (n - 1 != edges.length) {
      return false;
    }
    UnionFind<Integer> uf = new UnionFindMap<>();
    for (int[] edge : edges) {
      if (!uf.union(edge[0], edge[1])) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void example() {
    boolean case1 = validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}});
    System.out.println("Test Case 1 Result: " + case1);
    boolean case2 = validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}});
    System.out.println("Test Case 2 Result: " + case2);
  }
}
