package datastructurealgorithms.tree.normal;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    public T value;
    public final List<TreeNode<T>> children;

    public TreeNode(T value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode<T> child) {
        this.children.add(child);
    }

    public void addChildren(List<TreeNode<T>> children) {
        this.children.addAll(children);
    }

    public void removeChild(TreeNode<T> child) {
        this.children.remove(child);
    }

    public void removeChildren(List<TreeNode<T>> children) {
        this.children.removeAll(children);
    }

    public boolean isLeaf() {
        return this.children.isEmpty();
    }
}

