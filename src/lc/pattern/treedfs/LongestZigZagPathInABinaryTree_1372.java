package lc.pattern.treedfs;

import common.TreeNode;

public class LongestZigZagPathInABinaryTree_1372 {

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] longestValue = {0};
        longestZigZag(root, 0, 0, longestValue);
        longestZigZag(root, 1, 0, longestValue);
        return longestValue[0];
    }

    public void longestZigZag(
            TreeNode node,
            int direction,
            int count,
            int[] longestValue
    ) {
        if (node == null) {
            return;
        }
        longestValue[0] = Math.max(longestValue[0], count);
        if (direction == 0) {
            longestZigZag(node.right, 1, count + 1, longestValue);
            longestZigZag(node.left, 0, 1, longestValue);
        } else {
            longestZigZag(node.left, 0, count + 1, longestValue);
            longestZigZag(node.right, 1, 1, longestValue);
        }
    }
}
