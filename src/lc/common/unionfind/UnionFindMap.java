package lc.common.unionfind;

import java.util.HashMap;
import java.util.Map;

public class UnionFindMap<T> implements UnionFind<T> {

  public Map<T, T> parent;
  public Map<T, Integer> rank;

  public UnionFindMap() {
    this.parent = new HashMap<>();
    this.rank = new HashMap<>();
  }

  private void preRequisiteCheck(T e) {
    this.parent.putIfAbsent(e, e);
    this.rank.putIfAbsent(e, 0);
  }

  @Override
  public boolean union(T x, T y) {
    this.preRequisiteCheck(x);
    this.preRequisiteCheck(y);

    T rootX = this.find(x);
    T rootY = this.find(y);

    if (rootX != rootY) {
      int rankX = this.rank.get(x);
      int rankY = this.rank.get(y);
      if (rankX > rankY) {
        this.parent.put(y, x);
      } else if (rankX < rankY) {
        this.parent.put(x, y);
      } else {
        this.parent.put(x, y);
        this.rank.put(rootY, rankY + 1);
      }
      return true;
    }
    return false;
  }

  @Override
  public T find(T x) {
    // Path compression
    if (this.parent.get(x) != x) {
      this.parent.put(x, find(this.parent.get(x)));
    }
    return this.parent.get(x);
  }
}
