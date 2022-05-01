package lc.common.unionfind;

public interface UnionFind<T> {

  boolean union(T x, T y);

  T find(T x);
}
