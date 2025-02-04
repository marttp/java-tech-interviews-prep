package lc.general.easy;

import common.TreeNode;

public class DiameterOfBinaryTree_543 {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] result = {0};
        findDiameter(root, result);
        return result[0];
    }

    public int findDiameter(TreeNode node, int[] result) {
        if (node == null) {
            return 0;
        }
        int left = findDiameter(node.left, result);
        int right = findDiameter(node.right, result);
        int currentDiameter = left + right;
        result[0] = Integer.max(result[0], currentDiameter);
        return 1 + Integer.max(left, right);
    }
}
