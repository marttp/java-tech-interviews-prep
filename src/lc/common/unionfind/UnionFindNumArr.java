package lc.common.unionfind;

public class UnionFindNumArr implements UnionFind<Integer> {

  public int[] parent;
  public int[] rank;
  public int size;

  public UnionFindNumArr(int size) {
    this.size = size;
    this.parent = new int[size];
    this.rank = new int[size];
    for (int i = 0; i < size; i++) {
      this.parent[i] = i;
      this.rank[i] = 0;
    }
  }

  @Override
  public boolean union(Integer x, Integer y) {
    int rootX = this.find(x);
    int rootY = this.find(y);
    if (rootX != rootY) {
      int rankX = this.rank[rootX];
      int rankY = this.rank[rootY];
      if (rankX > rankY) {
        this.rank[rootY] = rootX;
      } else if (rankX < rankY) {
        this.rank[rootX] = rootY;
      } else {
        this.rank[rootX] = rootY;
        this.rank[rootY]++;
      }
      return true;
    }
    return false;
  }

  @Override
  public Integer find(Integer x) {
    if (this.parent[x] == x) {
      return x;
    }
    // Path compression
    return this.parent[x] = this.find(this.parent[x]);
  }
}
