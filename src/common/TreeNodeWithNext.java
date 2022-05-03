package common;

public class TreeNodeWithNext {

  public int val;
  public TreeNodeWithNext left;
  public TreeNodeWithNext right;
  public TreeNodeWithNext next;

  public TreeNodeWithNext() {
  }

  public TreeNodeWithNext(int val) {
    this.val = val;
  }

  public TreeNodeWithNext(int val,
      TreeNodeWithNext left,
      TreeNodeWithNext right,
      TreeNodeWithNext next) {
    this.val = val;
    this.left = left;
    this.right = right;
    this.next = next;
  }
}
