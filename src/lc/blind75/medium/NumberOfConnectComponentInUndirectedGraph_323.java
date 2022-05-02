package lc.blind75.medium;

import java.util.HashSet;
import java.util.Set;
import lc.common.unionfind.UnionFindNumArr;

public class NumberOfConnectComponentInUndirectedGraph_323 {

  public int countComponent(int n, int[][] edges) {
    UnionFindNumArr uf = new UnionFindNumArr(n);
    for (int[] edge : edges) {
      uf.union(edge[0], edge[1]);
    }
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(uf.find(i));
    }
    return set.size();
  }
}
