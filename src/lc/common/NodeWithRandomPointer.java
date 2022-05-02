package lc.common;

public class NodeWithRandomPointer<T> {

  public T val;
  public NodeWithRandomPointer<T> next;
  public NodeWithRandomPointer<T> random;

  public NodeWithRandomPointer(T val) {
    this.val = val;
  }
}
