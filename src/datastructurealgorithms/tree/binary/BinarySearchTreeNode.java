package datastructurealgorithms.tree.binary;

public class BinarySearchTreeNode<T extends Comparable<T>> {
    public T value;
    public BinarySearchTreeNode<T> left;
    public BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode(T value) {
        this.value = value;
    }

    public BinarySearchTreeNode(T value, BinarySearchTreeNode<T> left, BinarySearchTreeNode<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public void insert(T value) {
        if (value.compareTo(this.value) < 0) {
            if (this.left == null) {
                this.left = new BinarySearchTreeNode<>(value);
            } else {
                this.left.insert(value);
            }
        } else if (value.compareTo(this.value) > 0) {
            if (this.right == null) {
                this.right = new BinarySearchTreeNode<>(value);
            } else {
                this.right.insert(value);
            }
        }
    }

    public static <T extends Comparable<T>> BinarySearchTreeNode<T> searchBST(BinarySearchTreeNode<T> root, T val) {
        if (root == null) {
            return null;
        }
        if (val.compareTo(root.value) == 0) {
            return root;
        } else if (root.value.compareTo(val) > 0) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    public static <T extends Comparable<T>> BinarySearchTreeNode<T> deleteNode(BinarySearchTreeNode<T> root, T key) {
        if (root == null) {
            return null;
        }

        if (root.value.compareTo(key) > 0) {
            root.left = deleteNode(root.left, key);
        } else if (root.value.compareTo(key) < 0) {
            root.right = deleteNode(root.right, key);
        } else {
            // Found the node
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Seem have both child
            // Select Right
            BinarySearchTreeNode<T> leftMostRightChild = findMostLeft(root.right);
            leftMostRightChild.left = root.left;
            return root.right;
        }
        return root;
    }

    private static <T extends Comparable<T>> BinarySearchTreeNode<T> findMostLeft(BinarySearchTreeNode<T> node) {
        BinarySearchTreeNode<T> ptr = node;
        while (ptr.left != null) {
            ptr = ptr.left;
        }
        return ptr;
    }
}

