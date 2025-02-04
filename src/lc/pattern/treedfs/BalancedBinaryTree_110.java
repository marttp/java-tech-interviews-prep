package lc.pattern.treedfs;

import common.TreeNode;

public class BalancedBinaryTree_110 {

    public boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        int diff = Math.abs(leftHeight - rightHeight);
        return diff < 2 && isBalanced(node.left) && isBalanced(node.right);
    }

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Integer.max(
                getHeight(node.left),
                getHeight(node.right)
        );
    }
}
